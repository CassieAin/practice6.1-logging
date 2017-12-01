package view;

import model.Book;
import services.ControllerWrapper;
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
                    display.displayBooksByAuthor(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Input the publisher name:" + scanner.nextLine());
                    display.displayBooksByPublisher(scanner.nextLine());
                    break;
                case 3:
                    int year = scanner.nextInt();
                    System.out.print("Input the year:" + year);
                    scanner.nextLine();
                    display.displayBooksByDate(new Date(year,1,1));
                    break;
                case 4:
                    display.sortArray();
                    break;
                case 5:
                    System.out.println("Printed array:");
                    display.printArray(display.getBooks());
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(1);
            }
        }
    }
}
