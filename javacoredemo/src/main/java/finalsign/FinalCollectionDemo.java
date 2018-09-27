package finalsign;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mirana on 2017/8/16.
 */
public class FinalCollectionDemo {

    private final List<String> fList;

    public FinalCollectionDemo(){
        fList = new ArrayList<String>();
        fList.add("a");
        fList.add("b");
    }

    public static void main(String[] args) {
        FinalCollectionDemo demo = new FinalCollectionDemo();
        demo.fList.add("c");
        System.out.println(demo.fList.toString());
    }
}
