package com.graphqljava.tutorial.bookDetails;

import java.util.Arrays;
import java.util.List;

public class Book {

    private String id;
    private String name;
    private int pageCount;
    private Author author;

    public Book(String id, String name, int pageCount, Author author) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
    }

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, new Author("author-1", "Joanne", "Rowling")),
            new Book("book-2", "Moby Dick", 635, new Author("author-2", "Herman", "Melville")),
            new Book("book-3", "Interview with the vampire", 371, new Author("author-3", "Anne", "Rice"))
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

}