package view;

import model.Book;
import services.ControllerWrapper;
import services.DataLogging;
import services.FilesProcessing;

import java.util.Date;
import java.util.Scanner;

public class UserInterface {

    public static void run(){
        System.out.println("Hello, user! In this system you can make several actions");
        System.out.println("Input the filename to get all the books:");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        Book[] data = FilesProcessing.readBooksFromFile(filename);
        ControllerWrapper display = new ControllerWrapper(data);

        while(true){
            System.out.println("\nPress 1 - to get the list of books by specific author");
            System.out.println("Press 2 - to get the list of books by specific publisher");
            System.out.println("Press 3 - to get the list of books published after specific year");
            System.out.println("Press 4 - to get sorted list of books by publishers");
            System.out.println("Press 5 - to get the list of books by default");
            System.out.println("Press 6 - to exit");
            System.out.println("Choose the action, please:");

           int number = scanner.nextInt();

            switch(number){
                case 1:
                    System.out.print("Input the author name:" + scanner.nextLine());
                    String displayedBooksByAuthor = display.displayBooksByAuthor(scanner.nextLine());
                    DataLogging.logData(displayedBooksByAuthor);
                    break;
                case 2:
                    System.out.print("Input the publisher name:" + scanner.nextLine());
                    String displayedBooksByPublisher = display.displayBooksByPublisher(scanner.nextLine());
                    DataLogging.logData(displayedBooksByPublisher);
                    break;
                case 3:
                    int year = scanner.nextInt();
                    System.out.print("Input the year:" + year);
                    //scanner.nextLine();
                    String displayedBooksByDate = display.displayBooksByDate(new Date(year,1,1));
                    DataLogging.logData(displayedBooksByDate);
                    break;
                case 4:
                    String displayedSortedArray = display.displaySortedArray();
                    DataLogging.logData(displayedSortedArray);
                    break;
                case 5:
                    String displayedBooks = display.displayBooks(display.getBooks());
                    DataLogging.logData(displayedBooks);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(1);
            }
        }
    }
}
