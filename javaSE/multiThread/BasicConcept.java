// 多线程基础
// https://www.liaoxuefeng.com/wiki/1252599548343744/1255943750561472

/*
  Java多线程编程的特点又在于：
  多线程模型是Java程序最基本的并发模型；
  后续读写网络、数据库、Web开发等都依赖Java多线程模型
*/


/*
  创建新线程
  
  Java用Thread对象表示一个线程，通过调用start()启动一个新线程；
  一个线程对象只能调用一次start()方法；
  线程的执行代码写在run()方法中；
  线程调度由操作系统决定，程序本身无法决定调度顺序；
  
  必须调用Thread实例的start()方法才能启动新线程，如果我们查看Thread类的源代码，会看到start()方法内部调用了一个private native void start0()方法，
  native修饰符表示这个方法是由JVM虚拟机内部的C代码实现的，不是由Java代码实现的
*/
// Method 1: inherit Thread
public class Main {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start(); // 启动新线程
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}

// Method 2: implment Runnable
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start(); // 启动新线程
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}

// ---------------------------------------

/*
  线程的状态

  New：新创建的线程，尚未执行；
  Runnable：运行中的线程，正在执行run()方法的Java代码；
  Blocked：运行中的线程，因为某些操作被阻塞而挂起；
  Waiting：运行中的线程，因为某些操作在等待中；
  Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
  Terminated：线程已终止，因为run()方法执行完毕。

  Java线程对象Thread的状态包括：New、Runnable、Blocked、Waiting、Timed Waiting和Terminated；
  通过对另一个线程对象调用join()方法可以等待其执行结束；
  可以指定等待时间，超过等待时间线程仍然没有结束就不再等待；
  对已经运行结束的线程调用join()方法会立刻返回
*/


/*
中断线程

对目标线程调用interrupt()方法可以请求中断一个线程，目标线程通过检测isInterrupted()标志获取自身是否已中断。
如果目标线程处于等待状态，该线程会捕获到InterruptedException；

目标线程检测到isInterrupted()为true或者捕获了InterruptedException都应该立刻结束自身线程；
通过标志位判断需要正确使用volatile关键字；
volatile关键字解决了共享变量在线程间的可见性问题。
*/


/*
  守护线程

  守护线程是指为其他线程服务的线程。在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
  在守护线程中，编写代码要注意：守护线程不能持有任何需要关闭的资源，例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
*/

Thread t = new MyThread();
t.setDaemon(true);
t.start();




https://www.baeldung.com/java-wait-notify
object.wait() or object.notify()


https://www.baeldung.com/java-thread-join
thread.join()

