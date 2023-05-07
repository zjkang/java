/*
 * 线程同步
 *
 * 不需要synchronized的操作
 * JVM规范定义了几种原子操作：
 * 基本类型（long和double除外）赋值，例如：int n = m；
 * 引用类型赋值，例如：List<String> list = anotherList。
 * long和double是64位数据，JVM没有明确规定64位赋值操作是不是一个原子操作，
 * 不过在x64平台的JVM是把long和double的赋值作为原子操作实现的。
 *
 *
 * 不可变对象无需同步
 * 如果多线程读写的是一个不可变对象，那么无需同步，因为不会修改对象的状态
 *
 * 多线程还需理解变量在栈上的存储方式，基本类型和引用类型的存储方式也不同
 */

// e.g., synchronized
public class Counter {
    public void add(int m) {
        synchronized (obj) {
            if (m < 0) {
                throw new RuntimeException();
            }
            this.value += m;
        } // 无论有无异常，都会在此释放锁
    }
}

// 多线程连续读写多个变量时，同步的目的是为了保证程序逻辑正确！

// synchronized 内存可见性
// 对java内存模型不熟悉的同学，可以参考这边文章java内存模型。
// 线程释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存中。
// 线程获取锁时，JMM会把该线程对应的本地内存置为无效，从而使得被监视器保护的临界区代码必须从主内存中读取共享变量。
// synchronized除了加锁外，还具有内存屏障功能，并且强制读取所有共享变量的主内存最新值，
// 退出synchronized时再强制回写主内存（如果有修改）

// volatile只保证：
// 读主内存到本地副本；
// 操作本地副本；
// 回写主内存。
// 这3步多个线程可以同时进行。

// volatile关键字的目的是告诉虚拟机：
// * 每次访问变量时，总是获取主内存的最新值；
// * 每次修改变量后，立刻回写到主内存。
// volatile 修饰的变量，获取值和回写值时都不会阻塞线程，它只是保证了其他线程能更快的看到修改后的值。

/*
 * 同步方法
 *
 * 如果一个类被设计为允许多线程正确访问，我们就说这个类就是“线程安全”的（thread-safe），
 * 上面的Counter类就是线程安全的。Java标准库的java.lang.StringBuffer也是线程安全的
 *
 * 用synchronized修饰方法可以把整个方法变为同步代码块，synchronized方法加锁对象是this；
 * 通过合理的设计和数据封装可以让一个类变为“线程安全”；
 * 一个类没有特殊说明，默认不是thread-safe；
 * 多线程能否安全访问某个非线程安全的实例，需要具体问题具体分析
 *
 *
 */

// instance method sync
public class Counter {
    public void add(int n) {
        synchronized (this) { // 锁住this
            count += n;
        } // 解锁
    }
}

// static method sync
public class Counter {
    public static void test(int n) {
        synchronized (Counter.class) {
            ;// ...
        }
    }
}

/*
 * 死锁
 *
 */

// JVM允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁，就叫做可重入锁
// Java的线程锁是可重入锁，所以，获取锁的时候，不但要判断是否是第一次获取，
// 还要记录这是第几次获取。每获取一次锁，记录+1，每退出synchronized块，记录-1，
// 减到0的时候，才会真正释放锁
public class Counter {
    private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}

// 死锁
// 死锁发生后，没有任何机制能解除死锁，只能强制结束JVM进程
// 那么我们应该如何避免死锁呢？答案是：线程获取锁的顺序要一致。即严格按照先获取lockA，再获取lockB的顺序