// java 8 interview: https://www.youtube.com/watch?v=k7fNLXoVCYg&list=PLVz2XdJiJQxwS8FyWnWyKyfILxHPLsiro&index=16
// java 8 programming: https://www.youtube.com/watch?v=1Ps5F1PU72M


1. What are all features of java 8 did you use?
(1) Functional interface (default & static method)
(2) Lambda function
(3) Stream
(4) CompletableFuture
(5) Java DateTime API

2. What is functional interface?

3. Can you tell few functional interface before Java 8?
Runnalbe, Callable
Comparator (equals method override from java.lang.Object which does not account for abtract method)

4. Can you write one functional interface?

5 can we extends functional interface from another functional interface?

6. What are all functional interface introduced in Java 8?
Function, Predicate, Consumer, Supplier

7. What is lambda expression?

8. what's the advantages and disadvantages of Lambda expression?

9. What is stream API?
process collections of objects with functional style of coding using lambda expression to be pipelined

10. What is stream in java 8?

11. What is method reference 8?
shorthand notation of lambda expression to call a method

list.stream().filter(t -> t > 4).sorted().forEach(System.out::println); // static
Test test = new Test();
list.stream().filter(t -> t > 4).sorted().forEach(test::printlnElement); // non-static

12. few stream method you used in project?
filter, forEach, sorted, map, flatMap, reduce, 
groupingBy (2. interview programming question), count, collect

https://www.jianshu.com/p/afe6f60d492a

按子组收集数据
传递给groupingBy的第二个收集器可以是==任何类型==
Map<Integer, Optional<T>> maps4 = trans.stream().collect(groupingBy(T::getYear,
    maxBy(Comparator.comparingInt(T::getValue))));

把收集器结果转换为另一种类型
Collectors.collectingAndThen(W,M) 返回一个收集器
W：要转换的收集器 M：W的结果maxBy(comparing(Transaction::getValue)) -> Optional<Transaction> 转换函数 e -> e.get()
Map<Integer, Transaction> maps5 = trans.stream().collect(groupingBy(Transaction::getYear,
    collectingAndThen(maxBy(comparing(Transaction::getValue)), Optional::get)));

于groupingBy联合使用的其他收集器
Collectors.mapping(W,M) 返回一个收集器
W：转换函数 M：收集函数

Map<Integer, Set<Level>> maps7 = trans.stream()
    .collect(groupingBy(Transaction::getYear, Collectors.mapping(t -> {
        if (t.getValue() <= 500)
            return Level.LOW;
        else if (t.getValue() <= 1000)
            return Level.NORMAL;
        else
            return Level.HIGH;
    }, toSet())));


13. when to use map & flatMap?
List<String> lists = users.stream().flatMap(e -> e.getEmail().stream()).collect(Collectors.toList());

14. WAP using stream to find frequency of each character in a given string?
String test = "abcdabc";
Map<String, Long> collect = Arrays.stream(test.split(""))
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

15. Assume you have list of employee in various dept, WAP to find highest paid employee from each dept?

16. Stream vs parallel stream?

17. Waht is CompletableFuture? 
CompletableFuture is used async programming in Java. Async programming is a means of writing non-blocding code by running a task on a seprate thread than the main thread, notifying the main thread about its progress, completion or failure. 

18. Why CompletableFuture why not Future? 
(1) It cannot be manually completed
(2) Multiple futures cannot chained together
(3) cannot combine multiple futures together
(4) no exception handling

19. How to deciede Thread pool size?

20. WAP to print even and oldd using 2 threads.

CompletableFuture.runAsync(() -> EvenOdd.Printer.printNumber(oddCond)); // thread 1
CompletableFuture.runAsync(() -> EvenOdd.Printer.printNumber(evenCond)); // thread 2








