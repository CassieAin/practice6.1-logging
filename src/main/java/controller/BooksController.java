package controller;

import model.Book;
import services.BookPublisherComparator;

import java.util.Arrays;
import java.util.Date;

public class BooksController {
    private Book[] books;

    public BooksController(){}

    public BooksController(Book[] books){
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooksByAuthor(String author){
        int count = 0;
        Book[] result = new Book[books.length];
        for(int i = 0; i < books.length; i++){
            if(books[i].getAuthor().equals(author)){
                result[count++] = books[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Book[] getBooksByPublisher(String publisher){
        int count = 0;
        Book[] result = new Book[books.length];
        for(int i = 0; i < books.length; i++){
            if(books[i].getPublisher().equals(publisher)){
                result[count++] = books[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Book[] getBooksByDate(Date date){
        int count = 0;
        Book[] result = new Book[books.length];
        for(int i = 0; i < books.length; i++){
            if(books[i].getEditionDate().compareTo(date) == 1){
                result[count++] = books[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public void sortBooksByPublisher(){
        Arrays.sort(books, new BookPublisherComparator());
    }

}
