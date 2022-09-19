package com.example.tugastesting;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class LibraryHelper {
    LibraryServiceImplementation service;

    public LibraryHelper(LibraryServiceImplementation service) {
        this.service = service;
    }

    public List<Book> searchBook(String keyword){
        List<Book> allBooks = service.getAllBooks();
        List<Book> result = new ArrayList<Book>();

        for (int i = 0; i < allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.getTitle().contains(keyword)){
                result.add(book);
            }
        }
        return result;
    }

    public void returnToShelf(Book book,String shelfId){
        if (book.getShelfId() == shelfId) {
            service.returnBookToShelf(book.barcode);
        }
    }

    public int totalBookAvailable(int BookId){
        List<Book> allBooks = service.getAllBooks();
        int count = 0;

        for (int i = 0; i < allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.getBookId() == BookId){
                count++;
            }
        }
        return count;
    }

    public boolean isOverdue(String barcode, Date tglKembali) {
        Book book = this.service.findBook(barcode);
        Date tglPinjam = book.tanggalPeminjaman;
        int loanPeriod = book.loanPeriod;

        Calendar cal = Calendar.getInstance();
        cal.setTime(tglPinjam);
        cal.add(Calendar.DATE, loanPeriod);

        Date tglHarusKembali = cal.getTime();

        if (tglHarusKembali.before(tglKembali)) {
            return true;
        } else {
            return false;
        }
    }
    
    public int totalLateCharge(String barcode, int daysLate){
        Book book = this.service.findBook(barcode);
        int fine = book.fine;

        return fine * daysLate;
    }

    public boolean isNeedBookAddition(int BookId){
        List<Book> allBooks = service.getAllBooks();
        int count = 0;

        for (int i = 0; i < allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.getBookId() == BookId && !book.isBorrowed){
                count++;
            }
        }
        return count == 0;
    }

    public Book borrowBook(int bookID) {
        List<Book> allBooks = service.getAllBooks();
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            if (book.getBookId() == bookID && !book.isBorrowed) {
                service.borrowBook(book.getBarcode());
                return book;
            }
        }
        return null;
    }

    public void reminderMessage(Date tglKembali) {
        List<Book> allBooks = service.getAllBooks();
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date firstDate = book.getTanggalPeminjaman();
            Date secondDate = tglKembali;

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (diff >= 0) {
                service.sendMessageToStudent(book.getStudentId());
            }
        }
    }



}
