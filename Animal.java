package com.test.myPackage;

public abstract class Animal{
    private String name;
    private String address;
    private int number;
    public Animal(String name, String address, int number){
        System.out.println("Constructing an Animal");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public Animal(String myName, int myid) {

    }

    public double computePay(){
        System.out.println("Inside Animal computePay");
        return 0.0;
    }
    public void mailCheck(){
        System.out.println("Mailing a check to "+ this.name + " "+this.address);
    }
    public String toString(){
        return name+" "+address+" "+number;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String newAdderss){
        address = newAdderss;
    }
    public int getNumber(){
        return number;
    }
}