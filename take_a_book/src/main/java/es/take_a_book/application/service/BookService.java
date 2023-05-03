package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.take_a_book.application.model.Author;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	@Transactional(readOnly=true)
	public List<Book> findAll(){
		return repo.findAll();
	}

	@Transactional(readOnly=true)
	public Optional<Book> findById(int id){
		return repo.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void save (Book book) {
		repo.save(book);
	}
	
	@Transactional(readOnly=false)
	public void delete (Book book) {
		book.clearAuthors();
		repo.delete(book);
	}

	@Transactional(readOnly=false)
	public void addAuthor (Book book, Author author) {
		book.addAuthor(author);
		author.addBook(book);
	}

}
