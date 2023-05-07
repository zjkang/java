// volatile vs sychronized

1. sychronized: read varialbe always from main memory? (not thread copy)  read number vs write number 
   (add syncrhonized to both or write only and volatile)
2. singleton: volatile to prevent instruction reordering  in new singleton object.  V69 blibli shangguigu


// Thread basic concept
https://www.javatpoint.com/java-multithreading-interview-questions
  9) What is the difference between preemptive scheduling and time slicing?
      Under preemptive scheduling, the highest priority task executes until it enters the waiting or dead states or a higher priority task comes into existence. 
      Under time slicing, a task executes for a predefined slice of time and then reenters the pool of ready tasks. 
      The scheduler then determines which task should execute next, based on priority and other factors.
  10) What is context switching?
  18)Can we make the user thread as daemon thread if the thread is started?
  19)What is shutdown hook? vs finalizer()
  21) What is the synchronization?
    Synchronization is the capability to control the access of multiple threads to any shared resource
  30) How is the safety of a thread achieved?
      If a method or class object can be used by multiple threads at a time without any race condition, then the class is thread-safe. Thread safety is used to make a program safe to use in multithreaded programming. It can be achieved by the following ways:
        Synchronization
        Using Volatile keyword
        Using a lock based mechanism
        Use of atomic wrapper classes
  35) What is the Executor interface in Concurrency API in Java?
  41) Explain the ExecutorService Interface.
          
      


// Create thread using futureTask
// FutureTask implements Runnable & Future interface, and allows to pass Callable interface to get result
// https://cloud.tencent.com/developer/article/1497507

FutureTask<String> task = new FutureTask<>(() -> {
    Thread.sleep(1000);
    return "Complete";
});
Thread th = new Thread(task);
th.start();
System.out.println(task.get());  // Future interface, waiting for result; or task.isDone()


// 
ExecutorService executorService = Executors.newSingleThreadExecutor();
Future<String> task = executorService.submit(() -> {
    Thread.sleep(1000);
    return "Complete";
});

System.out.println(task.get());



// wait or notify
// https://www.baeldung.com/java-wait-notify
// example: print 0,1,2,...9 using multi-threading to keep in order

package thread.sync;

public class PrintSync {
    public static void main(String[] args) {
        var ref = new Object() {
            int flag = 0;
        };
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i += 2) {
                synchronized (lock) {
                    while (ref.flag != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    ref.flag = 1;
                    lock.notify();
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                synchronized (lock) {
                    while (ref.flag != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    ref.flag = 0;
                    lock.notify();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}

// ------------------------------------------------
// Notes








