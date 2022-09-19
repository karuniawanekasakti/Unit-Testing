package com.example.tugastesting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String Owner;
    private ArrayList<String> Kartu;
    private ArrayList<Integer> Uang;

    public Wallet(String owner, ArrayList<String> kartu, ArrayList<Integer> uang) {
        Owner = owner;
        Kartu = kartu;
        Uang = uang;
    }

    public String getOwner() {

        return Owner;
    }

    public void setOwner(String owner) {

        Owner = owner;
    }

    public ArrayList<String> getKartu() {

        return Kartu;
    }


    public void addKartu(String kartu){

        this.Kartu.add(kartu);
    }

    public String getKartu(String getKartu) {
        for (String listKartu: this.Kartu) {
            if (listKartu.equals(getKartu)) {
                Kartu.remove(listKartu);
                return listKartu;
            }
        }
        return null;
    }

    public Integer getUang(Integer nominal) {
        for (Integer listUang: this.Uang) {
            if (listUang.equals(nominal)) {
                this.Uang.remove(nominal);
                return listUang;
            }
        }

        return null;
    }

    public ArrayList<Integer> getUang() {
        return Uang;
    }

//    public void addUang(ArrayList<Integer> uang) {
//
//        this.Uang.addAll(uang);
//    }

    public void addUang(Integer uang) {

        this.Uang.add(uang);
    }

    public Integer getJumlahUang() {
        Integer jumlah = 0;
        for (Integer listUang:this.Uang) {
            jumlah += listUang;
        }
        return jumlah;
    }
}
