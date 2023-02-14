package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.model.Users;


public interface AuthorRepository extends JpaRepository<Book, Short> {
	
}
