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
https://www.baeldung.com/java-wait-notify

