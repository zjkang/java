Q21. What are the different types of garbage collectors in Java?

Garbage collection in Java a program which helps in implicit memory management. 
Since in Java, using the new keyword you can create objects dynamically, 
which once created will consume some memory. Once the job is done and there are 
no more references left to the object, Java using garbage collection destroys the object 
and relieves the memory occupied by it.

Java provides four types of garbage collectors:

Serial Garbage Collector
Parallel Garbage Collector
CMS Garbage Collector
G1 Garbage Collector


https://blog.csdn.net/zhangphil/article/details/78260863

垃圾收集（Garbage Collection，下文简称GC）是Java有别于其他编程语言的一大特点，GC主要考虑的有三个问题
哪些内存需要回收？  https://blog.csdn.net/qq_32099833/article/details/109253339
什么时候回收？      
如何回收？

memory leak
内存泄漏指的是JVM中某些不再需要使用的对象，仍然存活于JVM中而不能及时释放而导致内存空间的浪费。
Java中内存泄漏的原因有多种，这些众多的因素会导致Java程序产生不同类型的内存泄漏，随着时间的推移，内存泄漏会使程序增加额外的内存资源占用，从而导致程序性能下降。
垃圾回收器会回收长时间没有引用的对象，但是它不会回收那些还存在引用的对象，这就是产生内存泄漏的原因。

堆和栈的内存泄漏
其中堆内存泄漏是由于创建后的对象一直存在于堆中，不再需要的对象其引用一直没有被移除。这些无用的对象会慢慢占用内存，最后导致内存溢出。
栈内存泄漏由于方法不断被调用，但是一直没有退出方法。这种情况可能发生在无限循环或递归掉用时，最终导致栈内存溢出。

避免Java内存泄漏的一些最佳实践
使用最新稳定版本的Java
尽量减少使用静态变量，使用完之后及时赋值 null，移除引用
明确对象的有效作用域，尽量缩小对象的作用域。局部变量回收会很快。
减少长生命周期对象持有短生命周期的引用
各种连接应该及时关闭（数据库连接，网络，IO等）
使用内存泄漏检测工具如MAT,Visual VM，jprofile 等
避免在代码中使用System.gc()
避免使用内部类


garbage collection原理
https://cloud.tencent.com/developer/article/1862924





