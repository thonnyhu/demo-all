package dubbospring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Mirana on 2017/8/29.
 */
@Setter
@Getter
@ToString
public class Person implements Serializable{

    private Long id;
    private String name;
}
