package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.model.User;



public interface BookRepository extends JpaRepository<Book, Short> {
	
}
