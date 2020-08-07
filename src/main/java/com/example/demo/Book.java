

package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    @Size(min=3)
    private String title;


    @Column(name="author")
    @NotEmpty
    private String author;


    @Column(name="quantity")
    private int quantity;

    @Column(name="instock")
    private boolean instock;

    @Column (name="enabled")
    private boolean enabled;
    @Column (name="image")
    private String image;



    @ManyToOne
    private Category category;


    public Book() {
    }

    public Book(@Size(min = 3) String title,
                @NotEmpty String author,
                int quantity,
                boolean instock,
                String image)
    {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.instock = true;
        this.image = image;

    }

    public Book(String s, String s1) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInstock() {
        return instock;
    }

    public void setInstock(boolean instock) {
        this.instock = instock;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
