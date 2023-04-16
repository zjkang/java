// Refer 
// https://www.youtube.com/watch?v=GJ5Tx43q6KM
// https://www.youtube.com/watch?v=oFRtBuRviHM
// https://juejin.cn/post/6844904195162636295
// https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650

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


// runAsync() vs supplyAsync()
// 默认是forkJoinPool.commonPool executor
// 1. CompletableFuture.runAysn(Runnable)
// 2. CompletableFuture.runAysn(Runnable, Executor)

// 1. CompletableFuture.supplyAysn(Supplier<T>)
// 2. CompletableFuture.supplyAysn(Supplier<T>, Executor)


// chain multple futures

thenApply(Function)
thenAccept(Consumer)
thenRun(Runnable)

// e.g., can pass the same executor with different threads in the pool; 
// or even different executor (not recommend)
CompletableFuture.supplyAsync(() -> {}, executor)
  .thenApply((T) -> R, executor)
  .thenApply()
  .thenAccept();



// e.g., 
// 从Java 8开始引入了CompletableFuture，它针对Future做了改进，可以传入回调对象，
// 当异步任务完成或者发生异常时，自动调用回调对象的回调方法。

public class Main {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}


// 总结:
// CompletableFuture可以指定异步处理流程：

// thenAccept()处理正常结果；
// exceptional()处理异常结果；
// thenApplyAsync()用于串行化另一个CompletableFuture；
// anyOf()和allOf()用于并行化多个CompletableFuture









