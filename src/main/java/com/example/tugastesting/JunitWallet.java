package com.example.tugastesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JunitWallet {
    String owner;

    public String getOwner(){
        return owner;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public HashMap<Integer,Integer> getCoins(){

        return coins;
    }

    public void setCoins(HashMap<Integer,Integer> coins){
        this.coins = coins;
    }

    public List<String> getCards(){
        return cards;
    }

    public void setCards(List<String> cards){
        this.cards = cards;
    }

    HashMap<Integer,Integer> coins;
    List<String> cards;
int[] coinTypes = {100,500,1000};

    public JunitWallet(){
        this.coins = new HashMap<Integer,Integer>();
        this.coins.put(100,0);
        this.coins.put(500,0);
        this.coins.put(1000,0);

        this.cards = new ArrayList<String>();
    }

    void insertCoins(Integer type){
        boolean isCoinValid = false;
        for (int i=0;i < coinTypes.length;i++){
            if (type == coinTypes[i]){
                isCoinValid = true;
            }
        }
        if (isCoinValid) {
            int initialValue = this.coins.get(type);
//            System.out.println(initialValue);
            this.coins.put(type, initialValue + 1);
        }
    }

    void takeCoin(Integer type) {
        int initialValue = this.coins.get(type);
        this.coins.put(type, initialValue-1);
    }

    void addCard(String card) {
        this.cards.add(card);
    }

    void takeCard(String card){
        for (int i=0;i < this.cards.size(); i++){
            this.cards.remove(card);
        }
    }

    public int calculatedCoins(){
        int total = 0;
        for (Integer key : this.coins.keySet()){
            total += key * this.coins.get(key);
        }
        return total;
    }
}
