package repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.model.Users;



public interface BookRepository extends JpaRepository<Book, Short> {
	
	List<Book> findAll();
	
}
