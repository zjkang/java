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


