package dubbospring;

/**
 * Created by Mirana on 2017/8/29.
 */
public interface IPersonService {
    Person getPersonName(long id);

    Person getPersonName(String nickName);
}
