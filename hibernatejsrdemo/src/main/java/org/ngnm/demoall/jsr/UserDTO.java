package org.ngnm.demoall.jsr;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Mirana on 2017/4/25.
 */
@Setter
@Getter
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
public class UserDTO {

    @NotNull
    @NonNull
    private String username;
    @NotNull
    @NonNull
    private String email;
    @Min(2)
    private int age;




    @Override
    public String toString() {
        return "age:"+age+",username:"+username+",email:"+email;
    }
}
