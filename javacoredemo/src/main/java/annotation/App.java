package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String clazz = "com.nmng.demo.ReflectNeed";
        try {
            Method[] methods = App.class.getClassLoader().loadClass(clazz).getMethods();
            Method method = methods[0];
            Children children = method.getAnnotation(Children.class);
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            Annotation[] annotations = method.getAnnotations();
            System.out.println("finish");
//            Father father = method.getAnnotation(Father.class);
//            System.out.println(father.name());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
