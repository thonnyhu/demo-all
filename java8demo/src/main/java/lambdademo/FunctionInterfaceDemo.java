package lambdademo;

/**
 * Created by Mirana on 2017/8/8.
 */
public class FunctionInterfaceDemo {

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    public static boolean doPredicate(int age , Predicate<Integer> predicate){
        return predicate.test(age);
    }

    public static void main(String[] args) {
        boolean isAdult = doPredicate(30, x -> x>=18);
        System.out.println(isAdult);
    }
}
