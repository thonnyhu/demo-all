package org.ngnm.demo.collectiondemo;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mirana on 2017/8/19.
 */

public class HashMapDemo {

    @Test
    public void toCurrentSafeHashMap(){
        HashMap map = new HashMap();
        Map map1 = Collections.synchronizedMap(map);
    }
}
