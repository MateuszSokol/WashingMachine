package com.company;

import java.util.Stack;

public class WashingMachineOnOffState extends States
{
    public WashingMachineOnOffState(Stack<States> states)
    {
        super(states);

    }

    @Override
    public void printInfo()
    {
        System.out.println("1: Wylacz pralke");
        System.out.println("2: Zaladuj beben");
        System.out.println("3: Rozladuj beben");
        System.out.println("4: Wypisz informacje o pralce");
    }

}
