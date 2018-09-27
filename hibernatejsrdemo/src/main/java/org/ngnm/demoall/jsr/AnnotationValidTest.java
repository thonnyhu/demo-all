package org.ngnm.demoall.jsr;

import org.hibernate.validator.HibernateValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Mirana on 2017/4/25.
 */
public class AnnotationValidTest {

    private static Validator validator ;
    @BeforeClass
    public static void setUp(){
//        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void test(){
       UserDTO userDTO = UserDTO.of("zs","aa");
       userDTO.setAge(3);
        Set<ConstraintViolation<UserDTO>> validate = validator.validate(userDTO);
        Iterator<ConstraintViolation<UserDTO>> iterator = validate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }
        System.out.println(userDTO.toString());
    }

}
