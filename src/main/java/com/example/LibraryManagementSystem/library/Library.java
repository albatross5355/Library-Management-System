package com.example.LibraryManagementSystem.library;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Library {
    private List<Department> departments;

    public Library() {
        departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addBook(String departmentName, Book book) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                department.addBook(book);
                return;
            }
        }
        System.out.println("Department not found!");
    }

    public void removeBook(String ISBN) {
        for (Department department : departments) {
            department.removeBook(ISBN);
        }
    }

    public List<Book> findBookByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Department department : departments) {
            foundBooks.addAll(department.findBookByTitle(title));
        }
        return foundBooks;
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Department department : departments) {
            foundBooks.addAll(department.findBookByAuthor(author));
        }
        return foundBooks;
    }

    public List<Book> listAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        for (Department department : departments) {
            allBooks.addAll(department.getBooks());
        }
        return allBooks;
    }

    public List<Book> listAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Department department : departments) {
            availableBooks.addAll(department.listAvailableBooks());
        }
        return availableBooks;
    }
}
