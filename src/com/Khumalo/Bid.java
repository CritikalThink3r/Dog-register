package com.Khumalo;

import java.lang.reflect.Array;

public class Bid {

    private User user;
    private Dog dog;
    private int amount;

    public Bid(User user,Dog dog, int amount){
        this.user = user;
        this.dog = dog;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public int getAmount() {
        this.amount = amount;
        return amount;
    }

    public Dog getDOg(){
        this.dog = dog;
        return dog;
    }

    @Override
    public String toString() {
        return user.getName() + " " + amount +" kr ";
    }
}
