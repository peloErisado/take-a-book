package es.take_a_book.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.take_a_book.application.model.Author;
import es.take_a_book.application.model.Book;

@Repository
@CacheConfig(cacheNames="authors")
public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Cacheable
	List<Author> findAll();

	@Cacheable
	Optional <Author> findById(int id);

	@CacheEvict(allEntries = true)
	Author save(Author author);
	
	@CacheEvict(allEntries = true)
	void delete(Author author);
	
	

}
