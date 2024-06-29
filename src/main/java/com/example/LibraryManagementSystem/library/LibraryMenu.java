package com.example.LibraryManagementSystem.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private Scanner scanner;

    public LibraryMenu() {
        library = new Library();
        scanner = new Scanner(System.in);
        library.setDepartments(new ArrayList<>()); // Initialize the departments list
    }

    public void displayMenu() {
        String choice = "";
        while (!choice.equals("6")) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    removeBook();
                    break;
                case "3":
                    findBookByTitle();
                    break;
                case "4":
                    findBookByAuthor();
                    break;
                case "5":
                    listAllBooks();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter department name: ");
        String departmentName = scanner.nextLine();

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();

        System.out.print("Enter book genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter book publication year: ");
        int publicationYear = Integer.parseInt(scanner.nextLine());

        System.out.print("Is the book available (true/false): ");
        boolean availability = Boolean.parseBoolean(scanner.nextLine());

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        book.setGenre(genre);
        book.setPublicationYear(publicationYear);
        book.setAvailability(availability);

        library.addBook(departmentName, book);
    }

    private void removeBook() {
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
    }

    private void findBookByTitle() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with the title: " + title);
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void findBookByAuthor() {
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found by the author: " + author);
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void listAllBooks() {
        List<Book> books = library.listAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryMenu menu = new LibraryMenu();
        menu.displayMenu();
    }
}
