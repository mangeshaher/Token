package com.example.mangeshaher.bookmytokens;

/**
 * Created by mangeshaher on 20/4/18.
 */

public class Container {

    private String Item1,Item2;

    public Container(){
        this.setItem1("");
        this.setItem2("");
    }
    public Container(String Item1,String Item2) {
        this.setItem1(Item1);
        this.setItem2(Item2);
    }

    public String getItem1() {
        return Item1;
    }

    public void setItem1(String Item1) {
        this.Item1 = Item1;
    }

    public String getItem2() {
        return Item2;
    }

    public void setItem2(String Item2) {
        this.Item2 = Item2;
    }

}
