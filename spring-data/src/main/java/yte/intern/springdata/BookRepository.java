package yte.intern.springdata;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {  // kullanılan entitynin adı ve türü

  //  List<Book> findByTitle(String title);

  //  List<Book> findByAgeGreaterThanEqualOrderByAgeAsc(Long age);

 /*   Book findByTitle(String title);
    List<Book> findByAgeGreaterThan(Long age, Sort sort);
    List<Book> findByPublishDateAfter(LocalDateTime publishDate, PageRequest pageRequest);
    List<Book> findByTitleContainsIgnoreCase(String title);
    List<Book> findByAuthorAndAgeGreaterThan(String author, Long age);
    long countByAuthor(String author);
    boolean existsByAuthor(String author);   */


    @Query("select b from Book b where b.title = :title ")     //burada isimlendirme önemli değil
    Book findByTitleQuery(String title);

    @Query("select b from Book b where b.age >= :age")
    List<Book> findyByAgeQuery(@Param("age") Long age);

    @Query("select b from Book b where b.publishDate >= :publishDate")
    List<Book> findByPublishDateQuery(LocalDateTime publishDate, PageRequest pageRequest);

    @Query("select b from Book b where b.title like %:title%")  //  ilike dersek sensitive case olmaz
    List<Book> findByTitleLike(String title);

    @Query("select b from Book b where b.author = :author and b.age >= :age")
    List<Book> findByAuthorAndAge(String author, Long age);

    @Query("select count(b) from Book b where b.author = :author")
    long countByAuthorQuery(String author);




}
