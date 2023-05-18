/**
函数式编程称为Lambda计算

Lambda基础
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


/**
方法引用
所谓方法引用，是指如果某个方法签名和接口恰好一致，就可以直接传入方法引用
方法签名只看参数类型和返回类型，不看方法名称，也不看类的继承关系

符合方法签名的静态方法；
符合方法签名的实例方法（实例类型被看做第一个参数类型）；
符合方法签名的构造方法（实例类型被看做返回类型）
*/

// 引用构造方法
public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "Tim");
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person:" + this.name;
    }
}

// 构造方法虽然没有return语句，但它会隐式地返回this实例，类型就是Person，因此，此处可以引用构造方法。
// 构造方法的引用写法是类名::new，因此，此处传入Person::new


/**
 使用Stream
*/

//       java.io	           java.util.stream
// 存储	顺序读写的byte或char	  顺序输出的任意Java对象实例
// 用途	序列化至文件或网络	    内存计算／业务逻辑

// List的用途是操作一组已存在的Java对象，而Stream实现的是惰性计算
//       java.util.List	         java.util.stream
// 元素	已分配并存储在内存	      可能未分配，实时计算
// 用途	操作一组已存在的Java对象	 惰性计算

// 创建Stream
// 1.Stream.of()，传入可变参数即创建了一个能输出确定元素的Stream

// 2.创建Stream的方法是基于一个数组或者Collection，这样该Stream输出的元素就是数组或者Collection持有的元素
// 把数组变成Stream使用Arrays.stream()方法。对于Collection（List、Set、Queue等），直接调用stream()方法就可以获得Stream
Stream<String> stream1 = Arrays.stream(new String[] { "A", "B", "C" });
Stream<String> stream2 = List.of("X", "Y", "Z").stream();

// 3.基于Supplier Stream.generate()方法，它需要传入一个Supplier对象
public class Main {
    public static void main(String[] args) {
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;
    public Integer get() {
        n++;
        return n;
    }
}

// 基本类型
// 因为Java的范型不支持基本类型，所以我们无法用Stream<int>这样的类型，会发生编译错误。为了保存int，只能使用Stream<Integer>，
// 但这样会产生频繁的装箱、拆箱操作。为了提高效率，Java标准库提供了IntStream、LongStream和DoubleStream这三种使用基本类型的Stream，
// 它们的使用方法和范型Stream没有大的区别，设计这三个Stream的目的是提高运行效率
// 将int[]数组变为IntStream:
IntStream is = Arrays.stream(new int[] { 1, 2, 3 });
// 将Stream<String>转换为LongStream:
LongStream ls = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);


// 使用map
// 使用filter




















