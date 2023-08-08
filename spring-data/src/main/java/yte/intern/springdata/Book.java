package yte.intern.springdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity                  //  =>  bunlar lombok kütüphanesinden
@Getter //class tüm fieldlar için getter oluşturmuş oluyor.
@Setter
@AllArgsConstructor // bütün fieldları alan const oluşturur
@NoArgsConstructor // bunu da yazmak gerekir üsttekini yazınca
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Long age;
    private LocalDateTime publishDate;
}
