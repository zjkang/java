import org.junit.jupiter.api.Test;
import java.util.Optional;

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



    //ifPresent(Consumer<? super T>)方法

    public static void main(String[] args) {
        PictureCondition pictureCondition = new PictureCondition();

        String s1 = Optional.ofNullable(pictureCondition)
                .map(s -> s.getUrl())
                .map(s -> s.trim())
                .orElse("");
        System.out.println(s1);
    }

}

class PictureCondition {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
