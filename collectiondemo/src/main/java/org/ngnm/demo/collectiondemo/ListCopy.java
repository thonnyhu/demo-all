package org.ngnm.demo.collectiondemo;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mirana on 2017/7/19.
 */
public class ListCopy {

    @Test
    public void test1() {
        List<Integer> orgiL = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            orgiL.add(i);
        }
       sout(orgiL);
    }

    public void sout(List<Integer> list){
        ArrayList<Integer> integers = Lists.newArrayList();
        if(list.size()>100){
            List<Integer> subL = list.subList(0,100);
            integers = Lists.newArrayList(subL);
            list.removeAll(subL);
            sout(list);
        }else{
            System.out.println(list.toString());
            return ;
        }
        System.out.println(integers.toString());
    }

    @Test
    public void test2(){
        int a = 1;
        Integer b = 1;
        System.out.println(b.equals(a));
    }
}
