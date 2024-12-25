package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.entities.Book;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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
