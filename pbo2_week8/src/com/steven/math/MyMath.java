package com.steven.math;

public class MyMath {
    public int sum(int val1,int val2) throws Exception {
        int result=val1+val2;
        if (val1>0 && val2 >0 && result<0){
            throw  new Exception("Number overflow");
        }
        return val1+val2;
    }
}
