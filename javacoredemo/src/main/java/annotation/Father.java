package annotation;

import java.lang.annotation.*;

/**
 * Created by Mirana on 2017/7/1.
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Father {
    String name() default "huzijian";
}
