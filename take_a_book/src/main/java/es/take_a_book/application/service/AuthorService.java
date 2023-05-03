package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.take_a_book.application.model.Author;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.repository.AuthorRepository;
import es.take_a_book.application.repository.BookRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repo;
	
	@Transactional(readOnly=true)
	public List<Author> findAll(){
		return repo.findAll();
	}

	@Transactional(readOnly=true)
	public Optional<Author> findById(Long id){
		return repo.findById(id);
	}

  @Transactional(readOnly=false)
	public void save (Author author) {
		repo.save(author);
	}
	
	@Transactional(readOnly=false)
	public void delete (Author author) {
		author.clearBooks();
		repo.delete(author);
	}
	
	@Transactional(readOnly=false)
	public void addBook (Long id, Book book) {
		repo.findById(id).get().addBook(book);
	}
}
