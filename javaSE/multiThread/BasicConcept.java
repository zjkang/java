// 多线程基础
// https://www.liaoxuefeng.com/wiki/1252599548343744/1255943750561472

/*
  Java多线程编程的特点又在于：
  多线程模型是Java程序最基本的并发模型；
  后续读写网络、数据库、Web开发等都依赖Java多线程模型
*/


/*
Create Thread
  Java用Thread对象表示一个线程，通过调用start()启动一个新线程；
  一个线程对象只能调用一次start()方法；
  线程的执行代码写在run()方法中；
  线程调度由操作系统决定，程序本身无法决定调度顺序；
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



https://www.baeldung.com/java-wait-notify
object.wait() or object.notify()


https://www.baeldung.com/java-thread-join
thread.join()

