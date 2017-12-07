package services;

import controller.BooksController;
import model.Book;

import java.util.Arrays;
import java.util.Date;

public class ControllerWrapper {
    private BooksController controller;
    private Book[] books;
            /*= {
            new Book("Carrie", "Stephen King", "Pocket Books", new Date(2005, 11, 1), 253, 6.57),
            new Book("Thinking in Java", "Bruce Eckel","Pearson", new Date(2008, 3, 12), 1512, 18.84),
            new Book("Needful things", "Stephen King", "Hodder & Stoughton Ltd", new Date(1992, 6, 1), 790, 7.15),
            new Book("The Plague", "Albert Camus", "Vintage International", new Date(1999, 3, 7), 308, 6.99),
            new Book("Java in a Nutshell", "David Flanagan", "O'Reilly Media ", new Date(2005, 3, 25), 1224, 37.03),
            new Book("Frankenstein", "Mary Shelley","Penguin", new Date(2003, 3, 12), 273, 18.84),
            new Book("1984", "George Orwell", "New American Library", new Date(1950, 7, 1), 328, 7.50),
            new Book("Flowers for Algernon", "Daniel Keyes", "Mariner Books", new Date(2005, 5, 1), 311, 2.99),
    };*/
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

    public void displayBooks(Book[] printBooks){
        FilesProcessing.writeBooksToFile(printBooks, "printed_books");
        for(Book book : printBooks){
            System.out.println(book);
        }
    }

    public void displaySortedArray(){
        System.out.println("\nSorted array: ");
        Book[] sortedBooks = controller.sortBooksByPublisher();
        FilesProcessing.writeBooksToFile(sortedBooks, "books_sorted_by_publisher");
        displayBooks(sortedBooks);
    }

    public void displayBooksByDate(Date date){
        if(!Arrays.asList().contains(date)) {
            System.out.println("\nBooks that are later than " + date + ": ");
            Book[] booksByDate = controller.getBooksByDate(date);
            FilesProcessing.writeBooksToFile(booksByDate, "books_by_date");
            displayBooks(booksByDate);
        }else{
            System.out.println("\nThere are no books published after " + date);
        }
    }

    public void displayBooksByAuthor(String author){
        System.out.println("\nBooks that were written by " + author + ": ");
        Book[] booksByAuthor = controller.getBooksByAuthor(author);
        FilesProcessing.writeBooksToFile(booksByAuthor, "books_by_author");
        displayBooks(booksByAuthor);
    }

    public void displayBooksByPublisher(String publisher){
        if(Arrays.asList().contains(publisher)){
            System.out.println("\nThere are no books published by " + publisher);

        }else{
            System.out.println("\nBooks that were published by " + publisher + ": ");
            Book[] booksByPublisher = controller.getBooksByPublisher(publisher);
            FilesProcessing.writeBooksToFile(booksByPublisher, "books_by_publisher");
            displayBooks(booksByPublisher);
        }

    }
}
