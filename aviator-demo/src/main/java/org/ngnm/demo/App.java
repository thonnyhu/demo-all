package org.ngnm.demo;

import com.googlecode.aviator.AviatorEvaluator;

public class App {

    public static void main(String[] args) {
        Long result = (Long) AviatorEvaluator.execute("13*5+23*4+22+12*2+2*23");
        System.out.println(result);
    }
}
