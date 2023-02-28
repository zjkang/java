// Create thread using futureTask
// FutureTask implements Runnable & Future interface, and allows to pass Callable interface to get result

FutureTask<String> task = new FutureTask<>(() -> {
    Thread.sleep(1000);
    return "Complete";
});
Thread th = new Thread(task);
th.start();
System.out.println(task.get());


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





