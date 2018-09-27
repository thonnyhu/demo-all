package spring3jsrdemo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Mirana on 2017/5/13.
 */
@Setter
@Getter
public class User {
    @NotEmpty
    private String userName;
    @NotNull
    private String password;
}
