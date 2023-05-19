package com.springboot.fundamentos.bean;

public class MyOperationImpl implements IMyOperation {
    @Override
    public int sum(int num) {
        return num + 1;
    }
}
