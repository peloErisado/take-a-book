package es.take_a_book.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.take_a_book.application.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
}
