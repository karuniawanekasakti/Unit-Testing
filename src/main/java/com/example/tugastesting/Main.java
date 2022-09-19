package com.example.tugastesting;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        ArrayList<String> kartu = new ArrayList<>();
        kartu.add("test");
        kartu.add("test");
        ArrayList<Integer> uang = new ArrayList<>();
        uang.add(100);
        Wallet wallet = new Wallet("Test", kartu, uang);
        wallet.addKartu("Tes1t");
    }
}
