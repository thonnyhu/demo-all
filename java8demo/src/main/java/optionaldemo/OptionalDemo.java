package optionaldemo;


import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Mirana on 2017/8/8.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        // Guava Optional instantiation
        Optional<String> name = Optional.of("Sanaulla");
        // Null Instantiation
        Optional empty = Optional.ofNullable(null);
        // if name is null
        if(name.isPresent())
            System.out.println(name.get());

        try{
            System.out.println(empty.get());
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        // lambda
        name.ifPresent((value)->{
            System.out.println("The length of the value is: " + value.length());
        });

        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));

        try{
            empty.orElseThrow(ValueAbsentException::new);
        }catch (Throwable e){
            System.out.println(e.getMessage());
        }

        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));

        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));

        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }


}
class ValueAbsentException extends Throwable {

    public ValueAbsentException() {
        super();
    }

    public ValueAbsentException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}
