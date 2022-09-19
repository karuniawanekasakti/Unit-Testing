package com.example.tugastesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JunitWalletTest {

    static JunitWallet wallet;

    @BeforeEach
    public void startUp(){
        wallet = new JunitWallet();
        System.out.println("Start Up");
    }

    @BeforeAll
    public static void setUp() {
        wallet = new JunitWallet();
        System.out.println("Set Up");
    }

    @AfterAll
    public static void tearDown() {
        JunitWallet wallet = new JunitWallet();
        System.out.println("Teardown");
    }


    @Test
    void testSetOwner() {
        wallet.setOwner("Ekow");
        Assertions.assertEquals("Ekow",wallet.getOwner());
        System.out.println("Test Set Owner");
    }

    @Test
    void testTakeCard(){
        wallet.addCard("KTM");
        wallet.addCard("SIM");
        wallet.takeCard("KTM");
        Assertions.assertEquals(1,wallet.cards.size());
        System.out.println("Test Take Card");
    }

    @Test
    void testAddCards(){
        wallet.addCard("KTM");
        wallet.addCard("SIM");
        Assertions.assertEquals(2,wallet.cards.size());
        System.out.println("Test Add Card");
    }

    @Test
    void testInsertCoins(){
        wallet.insertCoins(500);
        wallet.insertCoins(500);
        Assertions.assertEquals(2,wallet.coins.get(500));
        System.out.println("Test Insert Coin");
    }

    @Test
    void testTakeCoins(){
        wallet.insertCoins(1000);
        wallet.insertCoins(1000);
        wallet.insertCoins(1000);
        wallet.insertCoins(1000);
        wallet.takeCoin(1000);
        Assertions.assertEquals(3,wallet.coins.get(1000));
        System.out.println("Test Take Coin");
    }

    @Test
    void testCalculatedCoins(){
        wallet.insertCoins(1000);
        wallet.insertCoins(1000);
        wallet.insertCoins(500);
        wallet.insertCoins(100);
        Assertions.assertEquals(2600,wallet.calculatedCoins());
        System.out.println("Test Calculated Coin");

    }


}