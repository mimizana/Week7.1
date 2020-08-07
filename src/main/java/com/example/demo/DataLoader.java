package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public void run(String... strings) throws Exception {

        //  public void run(String... args) {
        Category category = new Category();
        category.setTitle("Fantasy");
        categoryRepository.save(category);

        Category category2 = new Category();
        category2.setTitle("Mystery");
        categoryRepository.save(category2);


        Book book = new Book("The Hobbit and The Lord of the Rings", "J.R.R. Tolkien's", 3, true);

        book.setCategory(category);
        bookRepository.save(book);

        Book book2 = new Book("The Hobbit and The Lord of the Rings", "J.R.R. Tolkien's", 3, true);

        book2.setCategory(category);
        bookRepository.save(book);


    }
}