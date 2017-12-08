package services;

import controller.BooksController;
import model.Book;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

public class ControllerWrapper {
    private BooksController controller;
    private Book[] books;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public ControllerWrapper(Book[] inputBooks){
        books = inputBooks;
        controller = new BooksController(inputBooks);
    }

    public String displayBooks(Book[] printBooks){
        FilesProcessing.writeBooksToFile(printBooks, "printed_books");
        return Arrays.toString(printBooks);
    }

    public String displaySortedArray(){
        Book[] sortedBooks = controller.sortBooksByPublisher();
        FilesProcessing.writeBooksToFile(sortedBooks, "books_sorted_by_publisher");
        return Arrays.toString(sortedBooks);
    }

    public String displayBooksByDate(Date date){
        if(!Arrays.asList().contains(date)) {
            Book[] booksByDate = controller.getBooksByDate(date);
            FilesProcessing.writeBooksToFile(booksByDate, "books_by_date");
            return Arrays.toString(booksByDate);
        }
        return "There are no books published after" + date;
    }

    public String displayBooksByAuthor(String author){
        Book[] booksByAuthor = controller.getBooksByAuthor(author);
        FilesProcessing.writeBooksToFile(booksByAuthor, "books_by_author");
        return Arrays.toString(booksByAuthor);
    }

    public String displayBooksByPublisher(String publisher){
        if(Arrays.asList().contains(publisher)){
            return "here are no books published by " + publisher;

        }else{
            Book[] booksByPublisher = controller.getBooksByPublisher(publisher);
            FilesProcessing.writeBooksToFile(booksByPublisher, "books_by_publisher");
            return Arrays.toString(booksByPublisher);
        }

    }
}
