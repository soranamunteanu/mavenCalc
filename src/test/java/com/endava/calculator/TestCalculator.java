package com.endava.calculator;

import cam.endava.calculator.basic.Basic;
import cam.endava.calculator.basic.BasicOperation;
import cam.endava.calculator.expert.Expert;
import cam.endava.calculator.expert.ExpertOperation;

public class TestCalculator {
    public static void main(String[] args) {

        BasicOperation b = new Basic(3);
        System.out.println(b.add(2,3,4,8));
        System.out.println(b.substract(2));
        System.out.println(b.multiply(2,3));
        System.out.println(b.divide(10,3));
        System.out.println(b.multiply(3.5, 2.3));
        System.out.println(b.multiply(3,5,7,4));
        System.out.println(b.divide(64,8,4,2,1));


        System.out.println("-----------");
        ExpertOperation e = new Expert();
        System.out.println(e.pow(2,-5));
        System.out.println(e.root(10));
        System.out.println(e.fact(3));
        System.out.println("-----------");
        System.out.println(e.rootmax(27,3));
        System.out.println(e.calculate("3*2+3*4"));
        System.out.println(e.calculate("3+2*4"));
        System.out.println(e.calculate("2*3%2"));
        System.out.println(e.calculate("-3-5*3"));
        System.out.println(e.calculate("2*(-3+2)"));
        System.out.println(e.calculate("(-3-5)/6"));
        System.out.println(e.calculate("2+(-3-5)"));
        System.out.println(e.calculate("2*(-3-5) + 5"));
        System.out.println(e.calculate("2^3"));
        System.out.println(e.calculate("2^3^3"));
        System.out.println(e.calculate("2+2!"));



    }
}
