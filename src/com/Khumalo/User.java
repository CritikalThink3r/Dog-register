package com.Khumalo;

import java.util.ArrayList;

public class User {

    private String name;


   private ArrayList<Dog> arrayListOfUserWhoOwndogs = new ArrayList<>();

    public String dogName() {
        
        String a = "";
        for (Dog d: arrayListOfUserWhoOwndogs) {

            if (d.getName() != null){

                a = a+d.getName();
                 // alltid bygga på en sträng !!!!

                // ????
               // System.out.print(d.getName() + ", " );
            }
        }
        return a;
    }



public ArrayList<Dog> getDogs(){

        return arrayListOfUserWhoOwndogs;
}




    public void addDog(Dog dog){
        arrayListOfUserWhoOwndogs.add(dog);

    }

    public String getName() {
        return name;
    }


    public User(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return  name + "[" + dogName() + "]" ;
    }


}
