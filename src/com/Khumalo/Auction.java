package com.Khumalo;


import java.util.ArrayList;

public class Auction {

    private static int counter = 1;
    private int serialNumber;
    private Dog dog;
    private Bid amount;


    private ArrayList<Bid> bidsInAuction = new ArrayList<>();

                        // Array
    private Bid[] topThreeBids = new Bid[3];

    public void bidFromAUser(Bid bid) {
        bidsInAuction.add(bid);
    }

                //what...
    private String listTopOfTheBids() {
        String a = "";

        for (int i = 0; i < topThreeBids.length; i++) {
            if (topThreeBids[i] != null) {
                a += topThreeBids[i] + " ";
            }
        }
        return a;
    }

                //top bids
    private String bidsInTheOrderOfThree() {
        String a = " ";
        sortBids();
        for (int i = 0; i < Math.min(bidsInAuction.size(), 3); i++) {
            topThreeBids[i] = bidsInAuction.get(i);
            a += topThreeBids[i] + " ";
        }
        return a;
    }


    public boolean isDogUpForBid(String name) {
        boolean done = false;

        for(Bid b: bidsInAuction) {
            if (b.getDOg().getName().equals(name)) {
                done = true;
            }
        }
        return done;
    }


    private void sortBids() {

        for (int i = 1; i < bidsInAuction.size(); i++) {
            for (int j = i; j > 0 && bidsInAuction.get(j).getAmount() > bidsInAuction.get(j - 1).getAmount(); j--) {
                Bid temp = bidsInAuction.get(j);
                bidsInAuction.set(j, bidsInAuction.get(j - 1));
                bidsInAuction.set(j - 1, temp);
            }
        }
    }


    public Bid getHighestBid() {

        if (bidsInAuction.isEmpty()) {
            return null;
        }
        sortBids();
        return bidsInAuction.get(0);
    }


    public void replaceBidWithNewBid(String name) {

        for (Bid d : bidsInAuction) {
            if (d.getUser().getName().equalsIgnoreCase(name)) {
                bidsInAuction.remove(d);
                break;
            }
        }
    }


    public void removeAUsersBid(String name) {

        for (Bid b : bidsInAuction) {
            if (b.getUser().getName().equalsIgnoreCase(name)) {
                bidsInAuction.remove(b);
            }
        }
    }

    public Bid getAmount() {
        return amount;
    }

    public int getserialNumber() {
        return serialNumber;
    }


    public Auction(Dog dog) {
        this.dog = dog;
        serialNumber = counter;
        counter++;

    }

    // make method for bid
    public void listOfBidedDogs() {

        if (bidsInAuction.isEmpty()) {
            System.out.println("no bids yet mad for this dog");

        } else {

            sortBids();
            System.out.println("here are the bids for this auction");
            for (Bid a : bidsInAuction) {
                System.out.println(a);

            }
        }
    }


    public Dog getDog() {
        return dog;
    }



    @Override
    public String toString() {
        return "auction" + " #" + getserialNumber() + ": " + this.dog.getName() + ". " + "Top bids: " + bidsInTheOrderOfThree();// names of people who made bids
    }
}
