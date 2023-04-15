// Refer https://www.youtube.com/watch?v=GJ5Tx43q6KM

// CompletableFuture tutorials
// Compare with Futures, ExecutorService, Callback interface, Thread Pools

ExecutorService service = Executors.newFixedThreadPool(10);
Future<List<Integer>> feature = service.submit(() -> {
  // doing api call, waiting...
  Thread.sleep(10000);
  return Arrays.asList(1,2,3,4);
});

// block some time
List<Integer> list = feature.get();

// 原有的async programming的问题:
// 1. it cannot be manually completed
// 2. multiple Futures cannot be chained together
// 3. Cannot combine multiple Futures together
// 4. No proper exception handling

// 如果执行时间太长,可以通过complete manualy结束执行
CompletableFuture<String> completableFuture = new CompletableFuture<>();
completableFuture.get();
completableFuture.complete("return some dummy data");


runAsync() vs supplyAsync()
默认是forkJoinPool.commonPool executor
1. CompletableFuture.runAysn(Runnable)
2. CompletableFuture.runAysn(Runnable, Executor)

1. CompletableFuture.runAysn(Supplier<T>)
2. CompletableFuture.runAysn(Supplier<T>, Executor)


chain multple futures

thenApply(Function)
thenAccept(Cconsumer)
thenRun(Runnable)







