package services;

import model.Book;

import java.io.*;

public class FilesProcessing {

    public static void writeBooksToFile(Book[] books, String filename){
        try (ObjectOutputStream ostream = new ObjectOutputStream(
                new FileOutputStream(new File("src/main/resources/" + filename + ".txt")))){
            ostream.writeObject(books);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Book[] readBooksFromFile(String filename){
        Book[] books = null;
        try (ObjectInputStream istream = new ObjectInputStream(
                new FileInputStream(new File("src/main/resources/" + filename + ".txt")))){
            books = (Book[]) istream.readObject();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return books;
    }
}
