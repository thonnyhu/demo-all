package dubbospring;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Mirana on 2017/8/29.
 */
public class PersonService implements IPersonService{

    private final static AtomicLong ID = new AtomicLong();

    public Person getPersonName(long id) {
        Person person = new Person();
        person.setId(id);
        person.setName("某某");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return person;
    }

    public Person getPersonName(String name) {
        if(name==null)
            throw new RuntimeException("Nickname is not allowed null");
        name = name.trim();
        Person person = new Person();
        person.setId(ID.getAndIncrement());
        person.setName(name);

        return person;
    }
}
