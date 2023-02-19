package es.take_a_book.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.take_a_book.application.model.Book;

public interface AuthorRepository extends JpaRepository<Book, Short> {
	
}
