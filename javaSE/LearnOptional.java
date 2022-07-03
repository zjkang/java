import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;
import java.util.Optional;

// refer to the links
// https://juejin.cn/post/6844904020721549326
// https://blog.csdn.net/qq_35634181/article/details/101109300
// https://www.baeldung.com/java-optional-or-else-vs-or-else-get

public class OptionalLearn {

    // of(T)与ofNullable(T)方法
    // 两者区别，ofNullable可以传null，of方法不能传null
    @Test
    public void testOptionalOf() {
        // throw NPE (NullPointerException)
        Optional<Object> objectOptional = Optional.of(null);
    }

    //get()方法
    //使用Optional包装非空对象，调用get方法,得到T
    //使用Optional包装空对象，调用get方法,会抛出NoSuchElementException
    @Test
    public void testOptionalGet() {
        Optional<PictureCondition> emptyObj = Optional.empty();
        PictureCondition user = emptyObj.get();
    }

    //isPresent()方法
    //判断Optional包装的对象是否是空
    @Test
    public void testOptionalIsPresent() {
        Optional<PictureCondition> pictureCondition = Optional.of(new PictureCondition());
        Assertions.assertEquals(true, pictureCondition.isPresent());
        Optional<PictureCondition> emptyObj = Optional.empty();
        Assertions.assertEquals(false, emptyObj.isPresent());
    }

    //ifPresent(Consumer<? super T>)方法
    //如果Optional内的对象存在，执行Consumer接口的accept方法
    @Test
    public void testOptionalIfPresent() {
        Optional<PictureCondition> userOptional = Optional.ofNullable(new PictureCondition());
        userOptional.ifPresent(user -> System.out.println("Optional value exists：" + user));
        System.out.println("=============");
        Optional<Object> emptyOptional = Optional.ofNullable(null);
        emptyOptional.ifPresent(obj -> System.out.println("Optional value存在：" + obj));
    }

    //map vs flatMap
    //map(Function<? super T, ? extends U>)方法, Function interface: accepts T, return U
    //输入T，结果返回一个Optional<U>的对象
    //flatMap(Function<? super T, ? extends Optional<? extends U>>), Function interface: accepts T, return Optional<U>
    // source code
//    public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
//        Objects.requireNonNull(mapper);
//        if (!isPresent()) {
//            return empty();
//        } else {
//            return Optional.ofNullable(mapper.apply(value));
//        }
//    }
    //
//    public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper) {
//        Objects.requireNonNull(mapper);
//        if (!isPresent()) {
//            return empty();
//        } else {
//            @SuppressWarnings("unchecked")
//            Optional<U> r = (Optional<U>) mapper.apply(value);
//            return Objects.requireNonNull(r);
//        }
//    }
    @Test
    public void testOptionalMap() {
        String url = Optional.of(new PictureCondition("abc"))
                .map(PictureCondition::getUrl)
                .get();
        Assertions.assertEquals("abc", url);
    }

    @Test
    public void testOptionalFlatMap() {
        String url = Optional.of(new PictureCondition("abc"))
                .flatMap(e -> Optional.of(e.getUrl()))
                .get();
        Assertions.assertEquals("abc", url);
    }

    //orElse vs orElseGet
    //https://www.baeldung.com/java-optional-or-else-vs-or-else-get
    //T orElse(T other)
    // similar to orElseGet, but even if Optional的对象存在 也会调用T other
//    String name = Optional.of("baeldung")
//            .orElse(getRandomName());
//    Notice that getRandomName() is a method which returns a random name from a List<String>of names:
//
//    public String getRandomName() {
//        LOG.info("getRandomName() method - start");
//
//        Random random = new Random();
//        int index = random.nextInt(5);
//
//        LOG.info("getRandomName() method - end");
//        return names.get(index);
//    }
//    On executing our code, we'll find the below messages printed in the console:
//
//    getRandomName() method - start
//    getRandomName() method - end
    //
    //T orElseGet(Supplier<? extends T> other)
    //String name = Optional.of("baeldung")
    //        .orElseGet(() -> getRandomName());
    // Optional的T对象存在的话 不会调用Supplier的接口函数
    //Remember (from the Javadoc) that the Supplier method passed as an argument is only executed when an Optional value isn't present.

    //orElseThrow(Supplier<? extends X>)
    @Test
    public void testOptionalOrElseThrow() {
        PictureCondition pc = null;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Optional.ofNullable(pc).orElseThrow(IllegalArgumentException::new)
        );
    }

    //filter(Predicate<? super T>)方法
    @Test
    public void testOptionalFilter() {
        PictureCondition obj = new PictureCondition("12");
        Optional<PictureCondition> userOptional = Optional.of(obj);
        Optional<PictureCondition> filterOptional = userOptional.filter(user -> user.getUrl() != null && user.getUrl().contains("1"));
        Assertions.assertEquals(obj, filterOptional.get());

        Optional<PictureCondition> emptyOptional = Optional.empty();
        Optional<PictureCondition> filterEmptyOptional = emptyOptional.filter(emptyUser -> emptyUser.getUrl() != null && emptyUser.getUrl().contains("1"));
        Assertions.assertThrows(NoSuchElementException.class, () -> filterEmptyOptional.get());
    }
}

class PictureCondition {
    private String url;

    public PictureCondition() {}
    public PictureCondition(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
