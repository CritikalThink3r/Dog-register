package com.Khumalo;

import java.util.*;

public class RegisterForDogs {

    private Scanner input = new Scanner(System.in);

    //ArrayList for Dogs
    private ArrayList<Dog> arrayListObjDog = new ArrayList<>();

    //ArrayList for User
    private ArrayList<User> arrayListOfOwners = new ArrayList<>();

    // Auction ArrayList
    private ArrayList<Auction> arrayListAuctioningOfDog = new ArrayList<>();


    public void welcomeMessage() {
        System.out.println("hej och velkommen!");
        System.out.println();
    }


    public void differentCommandsToChoose() {
        System.out.println("Register new dog");
        System.out.println("Increase dog age");
        System.out.println("Remove dog ");
        System.out.println("List dogs");
        System.out.println("Register new user");
        System.out.println("List user");
        System.out.println("Remove user");
        System.out.println("Start auctions");
        System.out.println("List auction");
        System.out.println("Close auction");
        System.out.println("make bid");
        System.out.println("Exit");
        System.out.println();
    }

    // if name  and breed is empty loop
    private String readName(String message) {
        System.out.print(message);
        String name = input.nextLine().trim();
        name = name.trim();


        while (name.isEmpty()) {
            System.out.println("Error. Cant be empty.");
            System.out.println(message);
            name = input.nextLine().trim();
        }

        return name.toLowerCase();
    }

    private void commandRegisteringDog() {

        System.out.print("you chose register new dog");
        System.out.println();

        String name = readName("enter dogs name: ");

        String breed = readName("enter dogs breed: ");

        System.out.print("enter dogs age: ");
        int age = input.nextInt();

        System.out.print("enter dogs weight: ");
        int weight = input.nextInt();
        input.nextLine();

        System.out.println(name + " has been registered into the system ");
        System.out.println();

        Dog dog = new Dog(name, breed, age, weight);
        arrayListObjDog.add(dog);

    }

   private void whileMthode(String name){

        while(name.isEmpty()){
            System.out.println("Error. Cannot be empty");
            name =input.nextLine().trim().toLowerCase();
        }
    }

    private void removeDogM() {

        boolean removed = false;

        System.out.println("you chose to remove dog");
        System.out.print("enter dogs name ");
        String removeDogsName = input.nextLine().trim().toLowerCase();


         while(removeDogsName.isEmpty()){
           System.out.println("Error. Cannot be empty");
           removeDogsName = input.nextLine().trim().toLowerCase();

          removed = false;

       }

        Dog b = findDog(removeDogsName.trim().toLowerCase());

        Auction f = findAuction(removeDogsName.trim().toLowerCase());

        //have no idea why it is not working??

        //whileMthode(removeDogsName);

        if (b == null) {
            System.out.println("Error. no such dog");
            removed = false;
            return;
        }

        arrayListObjDog.remove(b);
        removed = true;

        arrayListAuctioningOfDog.remove(f);
        removed = true;

        if (f == null) {
        }

        System.out.println(removeDogsName + " is removed from register");
    }

    private void increaseAge() {

        String findDogsName = readName("enter dogs name: ");
        //String findDogsName = input.nextLine();
        for (Dog a : arrayListObjDog) {
            if (a.getName().equalsIgnoreCase(findDogsName)) {
                a.increaseAge();
                System.out.println(a.getName() + " is now one year older");
                return;
            }
        }
        System.out.println("Error. no such dog");
    }

    // sort dogs tailLength
    private Comparator<Dog> sortTailLength = new Comparator<Dog>() {
        @Override
        public int compare(Dog firstDog, Dog secondDog) {
            if (firstDog.getTailLength() == secondDog.getTailLength())
                return firstDog.getName().compareTo(secondDog.getName());

            if (firstDog.getTailLength() > secondDog.getTailLength())
                return 1;
            else ;
            return -1;
        }
    };

    private void listTailLength() {

        System.out.println("enter dogs tail length: ");
        int length = input.nextInt();
        Collections.sort(arrayListObjDog, sortTailLength);

        for (int i = 0; i < arrayListObjDog.size(); i++) {
            if (length <= arrayListObjDog.get(i).getTailLength()) {
                System.out.println(arrayListObjDog.get(i));
            }
        }
            if (arrayListObjDog.isEmpty()) {
            System.out.println("no dogs in register");
            }
            input.nextLine();

    }


    public void loopCommand() {

        boolean done = false;
        while (!done) {

            System.out.print("choose one of the above: ");
            String oneOfTheAbove = input.nextLine();
            oneOfTheAbove = oneOfTheAbove.trim();


            switch (oneOfTheAbove.toLowerCase()) {

                case ("register new dog"):
                    commandRegisteringDog();
                    break;

                case "increase age":
                    increaseAge();
                    break;

                case "remove dog":
                    removeDogM();
                    break;

                case "list dogs":
                    listTailLength();
                    break;

                case "register new user":
                    registerUser();
                    break;

                case "list users":
                    listUsers();
                    break;

                case "remove user":
                    removeUser();
                    break;
                case "start auction":
                    startAuction();
                    break;

                case "list auctions":
                    listAuction();
                    break;
                case "make bid":
                    makeBid();
                    break;

                case "list bids":
                    listBids();
                    break;

                case "close auction":
                    closeAuction();
                    break;


                case "exit":
                    System.out.println();
                    closeDownMethod();
                    done = true;
                    break;

                default:
                    System.out.println("Error");

            }
        }
    }

    private void closeDownMethod() {
        System.out.println("hej då");
    }

    // user methods

    private void registerUser() {
        System.out.print("name: ");
        String name = input.nextLine().trim();

        while (name.isEmpty()) {
            System.out.println("Error. cannot be empty");
            System.out.print("name: ");
            name = input.nextLine().trim();

        }
        
        User userName = new User(name.toLowerCase().trim());
        arrayListOfOwners.add(userName);
        System.out.println(userName.getName() + " added to the register");
        System.out.println();
    }

    private void listUsers() {
        for (User n : arrayListOfOwners) {
            System.out.println(n);
        }
        if (arrayListOfOwners.size() == 0) {
            System.out.println("no users in register");
        }
    }

    //    public void findUser(String name) {
//        for (User u : arrayListOfOwners) {
//            if (u.getName().equalsIgnoreCase(name)) {
//                arrayListOfOwners.remove(u);
//
//            }
//
//        }
//        System.out.println("Error: no such user");
//    }
//
    private void removeUser() {

        System.out.println("Enter the name of the user: ");
        String removeUser = input.nextLine();

            while(removeUser.isEmpty()){
                System.out.println("Error cannot be empty");
                removeUser = input.nextLine().trim().toLowerCase();
            }

        for (User r : arrayListOfOwners) {
            if (r.getName().equalsIgnoreCase(removeUser)) {

                for (Auction a : arrayListAuctioningOfDog) {
                    a.removeAUsersBid(removeUser);
                }
                arrayListObjDog.removeAll(r.getDogs());

                arrayListOfOwners.remove(r);
                System.out.println(removeUser + " removed from the register");
                return;
            }
        }
        System.out.println("Error: no such user");
    }

    // Auction methods
    // if the dogName does not exist it should say no such dogName, and if the dogName
    //is already up for auction it should say this
    // dogName is aready up for
    // auction, if the dogName has an owner it has too
    // say this dogName aready has an owner


    // DOG LOOP FIND DOG IN ARRAYLIST OF DOGS

    private Dog findDog(String name) {

        for (Dog d : arrayListObjDog) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    // FIND DOGS IN ARRAYLIST OF AUCTION

    private Auction findAuction(String name) {

        for (Auction a : arrayListAuctioningOfDog) {
            if (a.getDog().getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }


    private void startAuction() {

        System.out.println("Enter the name of the dog ");
        String nameOfDog = input.nextLine().trim().toLowerCase();


        while (nameOfDog.isEmpty()) {
            System.out.println("Error. name cannot be empty");
            nameOfDog = input.nextLine().trim().toLowerCase();
        }


        for (Auction a : arrayListAuctioningOfDog) {

            if (a.getDog().getName().equalsIgnoreCase(nameOfDog)) {
                System.out.println("Error. This dog is already up for auction");
                return;
            }
        }

        Dog d = findDog(nameOfDog);

        if (d == null) {
            System.out.println("Error. No such dog");
            return;
        }

        boolean hasOwner = false;
        for (Dog a : arrayListObjDog) {
            if (a.getName().equalsIgnoreCase(nameOfDog.toLowerCase())) {

                hasOwner = a.hasOwner();
            }
        }
        if (hasOwner) {
            System.out.println("Error. Dog already has an owner");
            return;
        }

        //loopa över alla auctions och kolla om nån redan har hunden d i sig -- måste skapa getDog i auction

        Auction dogsInAuction = new Auction(d);

        arrayListAuctioningOfDog.add(dogsInAuction);

        System.out.println(nameOfDog + " has been put up for auction in auction " + "#" + dogsInAuction.getserialNumber());
    }


    private void listAuction() {

        for (int i = 0; i < arrayListAuctioningOfDog.size(); i++) {
            System.out.println(arrayListAuctioningOfDog.get(i));
        }
        if (arrayListAuctioningOfDog.isEmpty()) {
            System.out.println("Error. No auctions in progress");
        }
    }


    private void closeAuction() {

        System.out.println("Enter the name of the dog ");
        String closeAuctionForDog = input.nextLine().toLowerCase();

        while(closeAuctionForDog.isEmpty()){
            System.out.println("Error. Cannot be empty");
            closeAuctionForDog = input.nextLine().trim().toLowerCase();
        }
        
        Dog d = findDog(closeAuctionForDog.toLowerCase());

        Auction a = findAuction(closeAuctionForDog.toLowerCase());
        if (a == null) {
            System.out.println("Error. This dog is not up for auction");//no auction for dogName etc
                return;
            }
             boolean upForBid =  a.isDogUpForBid(closeAuctionForDog);
            if(!upForBid){
                System.out.println("The auction is closed. No bids where made for " + closeAuctionForDog);
                return;
            }


        Bid b = a.getHighestBid();
        User u = b.getUser();

        //method for the dogName class that i can call when a dogName has an owner

        u.addDog(a.getDog());

        d.setUser(u);

        System.out.println("The auction is closed. The winning bid was " + b.getAmount() + "kr and was made by " + u.getName());

        arrayListAuctioningOfDog.remove(a);

        return;
    }

    // methods for bid

    private void listBids() {
        System.out.println("Enter the name of the dog");
        String dogUpForBid = input.nextLine().trim();

        while (dogUpForBid.isEmpty()){
              System.out.println("Error. Cannot be empty");
              dogUpForBid = input.nextLine().trim().toLowerCase();
        }

        for (Auction a : arrayListAuctioningOfDog) {
            if (a.getDog().getName().equalsIgnoreCase(dogUpForBid)) {
                a.listOfBidedDogs();
                return;
            }
        }
        System.out.println("Error: this dog is not up for auction");
    }

    private void makeBid() {
        // You make an object for
        User auctionUser = null;
        Dog auctionDog = null;

        System.out.println("Enter the name of the user");
        String name = input.nextLine().trim();

        while (name.isEmpty()) {
            System.out.println("Error. cannot be empty");
            name = input.nextLine().trim();

        }

        boolean foundUser = false;

        for (User u : arrayListOfOwners) {

            for (Auction a : arrayListAuctioningOfDog) {

                if (u.getName().equalsIgnoreCase(name)) {
                    auctionUser = u;
                    foundUser = true;

                    a.replaceBidWithNewBid(name);

                    break;
                }
            }
        }
        if (foundUser == false) {

            System.out.println("Error no such user");
            return;
        }


             System.out.println("Enter the name of the dog");
             String dog = input.nextLine().trim();
             

                 for(Auction b : arrayListAuctioningOfDog) {

                     while(dog.isEmpty()){
                         System.out.println("Error. cannot be empty");
                         dog = input.nextLine().trim().toLowerCase();
                     }

                     if (b == null) {
                         System.out.println("Error this dog is not up for auction");
                         return;
                     }
                 }

            Auction b = findAuction(dog);

            int minAmount = 1;
            if (b.getHighestBid() != null) {
                minAmount = b.getHighestBid().getAmount();
            }

            System.out.println("the amount to bid > " + minAmount + " kr");
            int amount = input.nextInt();

            while (amount <= minAmount) {
                System.out.println("Error: too low bid!");
                System.out.println("the amount to bid > " + minAmount + " kr");
                amount = input.nextInt();

            }

            System.out.println("bid made");

            Bid bid = new Bid(auctionUser, b.getDog(), amount);
            b.bidFromAUser(bid);
            System.out.println();

            input.nextLine();
            return;
        }


}