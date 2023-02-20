package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCommand;
        WashingMachine myWashingMachine = new WashingMachine(0.7,0.6,9.0,true,"Bosh","156p");

        greet();

        int startTheGame;


        startTheGame = scanner.nextInt();

        if(startTheGame ==1){
            myWashingMachine.setOn();

            do
            {

                myWashingMachine.states.peek().printInfo();
                numberCommand = scanner.nextInt();

                switch (numberCommand) {
                    case 1 -> myWashingMachine.setOff();
                    case 2 ->
                            {
                                System.out.println("Wybrales opcje nr 2" + "\n" + "Wpisz wage ubran");

                        if (myWashingMachine.loadTheDrum(scanner.nextDouble()))
                        {
                            myWashingMachine.states.peek().printInfo();

                        }
                        myWashingMachine.states.pop();
                    }
                    case 3 -> myWashingMachine.unloadTheDrum();
                    case 4 ->myWashingMachine.printInfo();
                    default -> System.out.println("Wybrano zla opcje sprobuj ponownie :)");




                }

            }
            while(myWashingMachine.IsOn());

        }
        else
            System.out.println("Wybrano niepoprawna opcje wychodze z menu");
            myWashingMachine.setOff();


    }

    public static void greet()
    {
        System.out.println("Witaj uzytkowniku, przed toba symulator pralki. Baw sie dobrze!!");
        System.out.println("Nacisnij 1 aby wlaczyc pralke");
    }
}
