package com.example.tugastesting;

import java.util.List;

public interface LibraryService {
    public List<Book> getAllBooks();
    public void returnBookToShelf(Book book);
    public void borrowBook(String barcode);
    public void findBook(String barcode);
    public void sendMessageToStudent(String studentId);
}
