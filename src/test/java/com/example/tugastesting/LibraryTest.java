package com.example.tugastesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;



public class LibraryTest {
    @Test
    public void testSearchBooks() {
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBook = new ArrayList<>();
        Book book1 = new Book(1,"Testing Java","B1");
        Book book2 = new Book(2,"Testing Java 2","B2");
        Book book3 = new Book(3,"Seni","B3");

        dummyBook.add(book1);
        dummyBook.add(book2);
        dummyBook.add(book3);

        when(service.getAllBooks()).thenReturn(dummyBook);
        Assertions.assertEquals(2,helper.searchBook("Testing Java").size());
    }

    @Test
    public void testReturnToShelf(){
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);

        Book book = new Book(1,"Belajar Testing","B1");
//        book.shelfId = "1";
        book.setShelfId("RAK1");

        helper.returnToShelf(book,"RAK1");
        verify(service).returnBookToShelf("B1");
    }

    @Test
    public void testTotalAvailableBooks(){
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBook = new ArrayList<>();
        Book book1 = new Book(1,"Testing Java","B1");
        Book book2 = new Book(2,"Testing Java 2","B2");
        Book book3 = new Book(3,"Seni","B3");

        dummyBook.add(book1);
        dummyBook.add(book2);
        dummyBook.add(book3);

        when(service.getAllBooks()).thenReturn(dummyBook);
        Assertions.assertEquals(1,helper.totalBookAvailable(2));
    }

    @Test
    public void testIsOverdue() throws ParseException {
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Book book = new Book(1,"Belajar Testing","B1");
        String setTanggalPeminjaman = "10-10-2022";
        String setTanggalHarusKembali = "11-10-2022";
        book.setTanggalPeminjaman(sdf.parse(setTanggalPeminjaman));
        book.setLoanPeriod(7);

        when(service.findBook("B1")).thenReturn(book);
        Assertions.assertEquals(true,helper.isOverdue("B1",sdf.parse(setTanggalHarusKembali)));
    }

    @Test
    public void testTotalLateCharge(){
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);

        Book book = new Book(1,"Belajar Testing","B1");
        book.setFine(1000);
        when(service.findBook("B1")).thenReturn(book);

        Assertions.assertEquals(7000,helper.totalLateCharge("B1",7));
    }

    @Test
    public void testIsNeedBookAddition(){
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBook = new ArrayList<>();
        Book book1 = new Book(1,"Testing Java","B1",true);
        Book book2 = new Book(1,"Testing Java 2","B2",true);
        Book book3 = new Book(1,"Seni","B3",true);

        dummyBook.add(book1);
        dummyBook.add(book2);
        dummyBook.add(book3);

        when(service.getAllBooks()).thenReturn(dummyBook);
        Assertions.assertEquals(true,helper.isNeedBookAddition(1));
    }


    @Test
    public void testBorrowBook() {
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBook = new ArrayList<>();
        Book book1 = new Book(1,"Testing Java","B1",true);
        Book book2 = new Book(1,"Testing Java 2","B2",true);
        Book book3 = new Book(1,"Seni","B3",false);

        dummyBook.add(book1);
        dummyBook.add(book2);
        dummyBook.add(book3);

        when(service.getAllBooks()).thenReturn(dummyBook);
        Book bookBorrow = helper.borrowBook(1);
        verify(service).borrowBook(bookBorrow.getBarcode());
    }


    @Test
    public void testReminderMessage() {
        LibraryServiceImplementation service = mock(LibraryServiceImplementation.class);
        LibraryHelper helper = new LibraryHelper(service);
        Calendar cal = new GregorianCalendar();


        Book book1 = new Book(1, "Testing Java", "B1", true, "S1");
        book1.setLoanPeriod(7);
        cal.add(Calendar.DAY_OF_MONTH, -9);
        Date daysAgo1 = cal.getTime();
        book1.setTanggalPeminjaman(daysAgo1);
        book1.setFine(300);

        Book book2 = new Book(1, "Testing Java 2", "B2", true, "S2");
        book2.setLoanPeriod(7);
        cal.add(Calendar.DAY_OF_MONTH, -8);
        Date daysAgo2 = cal.getTime();
        book2.setTanggalPeminjaman(daysAgo2);
        book2.setFine(300);

        when(service.getAllBooks()).thenReturn(
                new ArrayList<>(List.of(
                        book1,
                        book2
                ))
        );

        helper.reminderMessage(Calendar.getInstance().getTime());
        verify(service).sendMessageToStudent("S2");
    }

}
