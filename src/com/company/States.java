package com.company;

import java.util.Stack;

public abstract class States {

    private Stack<States> states;

    public States(Stack<States> states) {
        this.states = states;
    }
    public abstract void printInfo();


}
