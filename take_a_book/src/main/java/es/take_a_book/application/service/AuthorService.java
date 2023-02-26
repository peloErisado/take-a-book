package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.take_a_book.application.model.Author;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repo;
	
	public List<Author> findAll(){
		return repo.findAll();
	}
	
	public Optional<Author> findById(Long id){
		return repo.findById(id);
	}
	
	public void save (Author author) {
		repo.save(author);
	}
	
	public void delete (Author author) {
		repo.delete(author);
	}
	
	public void addBook (Long id, Book book) {
		repo.findById(id).get().addBook(book);
	}
}
