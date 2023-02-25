package es.take_a_book.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.take_a_book.application.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
