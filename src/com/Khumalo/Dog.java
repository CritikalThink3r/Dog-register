
package com.Khumalo;

import java.util.Comparator;

public class Dog {

    private String name;
    private String breed;
    private int age;
    private int weight;
    private User user;
    private double tailLength;


    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    // if the race of the dogName is tax(eng, dachshund) then the tail length will be 3.7
    // calculation tail length is weight * age / 10
    public double getTailLength() {

        if (breed.equalsIgnoreCase("tax")) {
            tailLength = 3.7;

        } else if (breed.equalsIgnoreCase("dachshund")) {
            tailLength = 3.7;
        } else {
            tailLength = (double) (age * weight) / 10.0;

        }
        return tailLength;
    }

                // checking if dog has an owner

    public boolean hasOwner(){
        return user != null;
    }

                // print out the name of the owner

    public String ownerName() {
            String a = "";

            if (user == null) {
              return a;
            }
            return "owned by " + user.getName();
        }


    // method for age increase
    // a dogs age increases each year
    public void increaseAge() {
        age++;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(){
        this.user = user;
        return user;
    }


// get methods

    public String getName() {
        this.name = name;
        return name;
    }

    public String getBreed() {
        this.breed = breed;
        return breed;
    }

    public int getAge() {
        this.age = age;
        return age;
    }

    public int getWeight() {
        this.weight = weight;
        return weight;
    }


    @Override
    public String toString() {
        return  "{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", tailLength=" + getTailLength() +", " +  ownerName()+
                '}';
    }
}