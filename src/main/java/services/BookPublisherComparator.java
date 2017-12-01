package services;

import model.Book;

import java.util.Comparator;

public class BookPublisherComparator implements Comparator<Book> {
    public int compare(Book book1, Book book2){
        return book1.getPublisher().compareToIgnoreCase(book2.getPublisher());
    }
}
