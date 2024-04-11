package com.example.day01_jms_receiver;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private String genre;
}
