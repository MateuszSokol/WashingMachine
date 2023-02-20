package com.company;

import java.util.LinkedList;
import java.util.Stack;

public class WashingMachine{
    Stack<States> states;
    private boolean isOn;
    final private double height;
    final private double width;
    final private double finalCapacity;
    private boolean hasDoor;
    private LinkedList<Mode> modes;
    private double capacity;
    final private String brand;
    final private String model;

    public void initializeState(){
        this.states = new Stack<>();
    }

    public boolean IsOn(){
        return isOn;
    }

    public WashingMachine(double height, double width, double finalCapacity, boolean hasDoor, String brand, String model)
    {
        this.height = height;
        this.width = width;
        this.finalCapacity = finalCapacity;
        this.capacity = finalCapacity;
        this.hasDoor = hasDoor;
        this.brand = brand;
        this.model = model;
        this.modes = new LinkedList<>();
        this.isOn = false;
        initializeState();
    }

    public void printInfo()
    {
        String status = "Nie";
        if (this.hasDoor) {
            status = "Tak";
        }
        System.out.println("Marka: " + this.brand + " Model: " + this.model + " Wysokosc: " + this.height + "m" + " Szerokosc: " + this.width
                + "m" + " Pojemonosc fabryczna : " + this.finalCapacity + " kg" +" Pozostala pojemnosc "+this.capacity+ " kg "+" Czy posiada drzwi :" + status);

        for (int i = 0; i < modes.size(); i++) {
            System.out.println(modes.get(i));
        }

        if (isOn)
            status = "Wlaczona";
        else
            status = "Wylaczona";

        System.out.println("Status: " + status);

    }

    public void setOn()
    {
        this.isOn = true;
        states.push(new WashingMachineOnOffState(this.states));
    }

    public void setOff()
    {
        this.isOn = false;
    }


    public boolean loadTheDrum(double weight)
    {

        this.states.push(new LoadState(this.states));

        if(isOn && hasDoor)
        {
            if (weight > this.capacity){
                System.out.println("Waga przekroczona...");
                return  false;
            }

            else
            {
                this.capacity = Math.floor(this.capacity - weight);
                System.out.println("Pomyslnie zaladowano beben, pozostala waga: " + this.capacity);
                return true;
            }
        }

        return false;
    }

    public boolean unloadTheDrum()
    {
        if(capacity == finalCapacity)
        {
            System.out.println("Beben pralki jest pusty");
            return false;
        }
        this.capacity = finalCapacity;
        System.out.println("Pomyslnie rozladowano beben, waga: "+ this.capacity);

        return true;

    }


}
