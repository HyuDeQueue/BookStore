package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private String id;

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

    public static BookResponseDTO toDto(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getOriginalPrice(),
                book.getCurrentPrice(),
                book.getStock(),
                book.getDescription(),
                book.getImageData(),
                book.getCategory(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }
}
