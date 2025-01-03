package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.Book;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Base64;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookRequestDTO {
    private String title;
    private String author;
    private Integer originalPrice;
    private Integer currentPrice;
    private Integer stock;
    private String description;
    private String imageData;
    private String category;

    public Book toEntity() {
        Book book = new Book();
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setOriginalPrice(this.originalPrice);
        book.setCurrentPrice(this.currentPrice);
        book.setStock(this.stock);
        book.setDescription(this.description);
        book.setImageData(Base64.getDecoder().decode(this.imageData));
        book.setCategory(this.category);
        return book;
    }
}
