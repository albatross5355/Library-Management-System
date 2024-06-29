package com.example.LibraryManagementSystem;


import com.example.LibraryManagementSystem.library.Book;
import com.example.LibraryManagementSystem.library.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartmentTest {
    private Department department;

    @BeforeEach
    public void setUp() {
        department = new Department("Department1");
        Book book1 = new Book("Title1", "Author1", "ISBN1", "Genre1", 2000, true);
        Book book2 = new Book("Title2", "Author2", "ISBN2", "Genre2", 2001, false);
        Book book3 = new Book("Title3", "Author1", "ISBN3", "Genre3", 2002, true);

        department.addBook(book1);
        department.addBook(book2);
        department.addBook(book3);
    }

    @Test
    public void testAddBook() {
        Book book4 = new Book("Title4", "Author3", "ISBN4", "Genre4", 2003, true);
        department.addBook(book4);
        assertEquals(4, department.getBooks().size());
    }

    @Test
    public void testRemoveBook() {
        department.removeBook("ISBN1");
        assertEquals(2, department.getBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = department.findBookByTitle("Title1");
        assertEquals(1, books.size());
        assertEquals("Title1", books.get(0).getTitle());
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = department.findBookByAuthor("Author1");
        assertEquals(2, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> books = department.listAvailableBooks();
        assertEquals(2, books.size());
    }
}
