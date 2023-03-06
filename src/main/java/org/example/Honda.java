package org.example;

public class Honda extends Overrifing{

    void bike(){
        System.out.println("Bike is Honda");
    }


    public static void main(String[] args) {
        Overrifing o = new Honda();
        o.bike();
    }



}
