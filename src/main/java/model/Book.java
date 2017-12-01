package model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
    private String name;
    private String author;
    private String publisher;
    private Date editionDate;
    private int pagesNumber;
    private double price;

    public Book(){}

    public Book(String name, String author, String publisher, Date editionDate, int pagesNumber, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.editionDate = editionDate;
        this.pagesNumber = pagesNumber;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", editionDate=" + editionDate +
                ", pagesNumber=" + pagesNumber +
                ", price=" + price +
                '}';
    }
}
