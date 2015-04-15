package com.jss0027.comp3710.graphicmotiontest;

/**
 * Created by JDSS on 14/4/15.
 */
public class NumObj {
    int value;
    public NumObj(int val) {
        value = val;
    }

    public void addValue(int add) {
        value += add;
    }

    public int getValue() {
        return value;
    }
}
