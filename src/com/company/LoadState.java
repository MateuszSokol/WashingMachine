package com.company;

import java.util.Stack;

public class LoadState extends States{
    public LoadState(Stack<States> states) {
        super(states);
    }
    public void printInfo()
    {
        System.out.println("Ladowanie bebna....");
    }
}
