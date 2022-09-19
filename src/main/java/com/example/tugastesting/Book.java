package com.example.tugastesting;

import java.util.Date;

public class Book {
    int BookId;
    String title;
    String barcode;
    boolean isBorrowed;
    int loanPeriod;
    String studentId;
    String shelfId;
    int fine;
    Date tanggalPeminjaman;
    Date tanggalKembali;

    public Book(int bookId, String title, String barcode) {
        this.setBookId(bookId);
        this.setTitle(title);
        this.setBarcode(barcode);
    }

    public Book(int bookId, String title, String barcode,boolean isBorrowed) {
        this.setBookId(bookId);
        this.setTitle(title);
        this.setBarcode(barcode);
        this.isBorrowed = isBorrowed;
    }

    public Book(int bookId, String title, String barcode,boolean isBorrowed,String studentId) {
        this.setBookId(bookId);
        this.setTitle(title);
        this.setBarcode(barcode);
        this.isBorrowed = isBorrowed;
        this.studentId = studentId;
    }


    public Date getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(Date tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
