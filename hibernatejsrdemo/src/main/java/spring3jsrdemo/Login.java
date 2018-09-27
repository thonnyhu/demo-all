package spring3jsrdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.Valid;

/**
 * Created by Mirana on 2017/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring3jsrdemo/validator.xml"})
public class Login {

    public void login(@Valid User user){

    }

    @Test
    public void test(){
        User user = new User();
        login(user);
    }
}
