package cgliborjdk;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class B implements C {


    @Override
    public void sayHello() {

    }


    @Transactional
    public void sayGoodBye(){

    }
}
