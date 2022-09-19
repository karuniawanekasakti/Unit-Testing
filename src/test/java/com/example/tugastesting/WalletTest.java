package com.example.tugastesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    @Test
    void testOwner(){
        ArrayList<String> kartu = new ArrayList<>();
        ArrayList<Integer> uang = new ArrayList<>();
        Wallet wallet = new Wallet("Sam", kartu, uang);
        Assertions.assertEquals("Ekow",wallet.getOwner(),"Nama tidak seusai");
    }

    @Test
    void testAddUang(){
        ArrayList<String> kartu = new ArrayList<>();
        ArrayList<Integer> uang = new ArrayList<>();
        Wallet wallet = new Wallet("Ekow", kartu, uang);
//        wallet.addUang(5000,10000);
        wallet.addUang(50000);
//        wallet.addUang(10000);
        Assertions.assertNotNull(wallet.getUang());
//        Assertions.assertNull(wallet.getUang());
    }

    @Test
    void testJumlahUang() {
        ArrayList<String> kartu = new ArrayList<>();
        ArrayList<Integer> uang = new ArrayList<>();
        Wallet wallet = new Wallet("Ekow", kartu, uang);
        wallet.addUang(50000);
        wallet.addUang(100000);
        wallet.addUang(500);
        Assertions.assertEquals(150500,wallet.getJumlahUang());
    }

    @Test
    void testAddKartu(){
        ArrayList<String> kartu = new ArrayList<>();
        ArrayList<Integer> uang = new ArrayList<>();
        Wallet wallet = new Wallet("Ekow", kartu, uang);
        wallet.addKartu("KTM");
        Assertions.assertNotNull(wallet.getKartu("KTM"));
//        Assertions.assertSame(wallet.getKartu("KTM").toString());
//        Assertions.assertNotNull(wallet.getKartu("KTM"),wallet.getKartu());
    }

    @Test
    void testGetKartu(){
        ArrayList<String> kartu = new ArrayList<>();
        ArrayList<Integer> uang = new ArrayList<>();
        Wallet wallet = new Wallet("Ekow", kartu, uang);
        wallet.getKartu("KTM");
        Assertions.assertNotNull(wallet.getKartu());
    }

    @Test
    void testGetUang(){
        ArrayList<String> kartu = new ArrayList<>();
        ArrayList<Integer> uang = new ArrayList<>();
        Wallet wallet = new Wallet("Ekow", kartu, uang);
        wallet.addUang(50000);
        wallet.addUang(50000);
        wallet.getUang(50000);
        Assertions.assertEquals(50000,wallet.getJumlahUang());

    }

}