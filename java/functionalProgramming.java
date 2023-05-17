/**
函数式编程称为Lambda计算
单方法接口被称为FunctionalInterface。
接收FunctionalInterface作为参数的时候，可以把实例化的匿名类改写为Lambda表达式，能大大简化代码
*/

// 虽然Comparator接口有很多方法，但只有一个抽象方法int compare(T o1, T o2)，其他的方法都是default方法或static方法。
// 另外注意到boolean equals(Object obj)是Object定义的方法，不算在接口方法内。因此，Comparator也是一个FunctionalInterface
@FunctionalInterface
public interface Comparator<T> {

    int compare(T o1, T o2);

    boolean equals(Object obj);

    default Comparator<T> reversed() {
        return Collections.reverseOrder(this);
    }

    default Comparator<T> thenComparing(Comparator<? super T> other) {
        ...
    }
    ...
}




