package es.take_a_book.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.take_a_book.application.model.Author;
import es.take_a_book.application.model.Book;


@Repository
@CacheConfig(cacheNames="books")
public interface BookRepository extends JpaRepository<Book, Integer> {
	@Cacheable
	List<Book> findAll();

	@Cacheable
	Optional <Book> findById(int ISBN);

	@CacheEvict(allEntries = true)
	Book save(Book book);
	
	@CacheEvict(allEntries = true)
	void delete(Book book);

}
