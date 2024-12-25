package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    private String title;
    private String author;
    private Integer originalPrice;
    private Integer currentPrice;
    private Integer stock;
    private String description;
    private Byte[] imageData;
    private String category;
    private String createdAt;
    private String updatedAt;

    public Book toEntity() {
        Book book = new Book();
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setOriginalPrice(this.originalPrice);
        book.setCurrentPrice(this.currentPrice);
        book.setStock(this.stock);
        book.setDescription(this.description);
        book.setImageData(this.imageData);
        book.setCategory(this.category);
        book.setCreatedAt(this.createdAt);
        book.setUpdatedAt(this.updatedAt);
        return book;
    }
}
