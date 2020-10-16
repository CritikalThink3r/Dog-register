package com.Khumalo;

public class Dog {

    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength;

        // constructor
    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;

    }

     // if the race of the dogName is tax(eng, dachshund) then the tail length will be 3.7
     // calculation tail length is weight * age / 10                           
    public double calculateTailLength() {
        double tax = 3.7;
        if (breed.equals("tax")) {
            System.out.println("Tail length for this dogName is: " + tax);

        }else if (breed.equals("dachshund")){
            System.out.println("Tail length for this dogName is: " + tax);
        }else {
            double tailLength = (double) (age * weight) / 10.0;
            System.out.println("Tail length for this dogName is: " + tailLength);
        }
        return tailLength;
    }

        // method for age increase
        // a dogs age increases each year
        public int ageIncrease() {
            return age++;
        }

           // get methods
        public void getName (){
            this.name = name;
        }

        public void getBreed (){
            this.breed = breed;
        }

        public void getAge(){
            this.age = age;
        }

        public void getWeight (){
            this.weight = weight;
        }


        public void getTailLength(){
            this.tailLength = tailLength;
        }

        public String toString(){
            return name + breed + age +
                    weight;
        }

    }



       /*

        */
    //private static String name;
    // ??????????
    //public Dog(String name){
       // this.name = name;
    //}

    //public String toString(){
     //   return name;
   // }

//}
