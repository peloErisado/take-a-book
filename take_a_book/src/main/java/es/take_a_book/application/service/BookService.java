package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.take_a_book.application.model.Author;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<Book> findAll(){
		return repo.findAll();
	}

	public Optional<Book> findById(int id){
		return repo.findById(id);
	}
	
	public void save (Book book) {
		repo.save(book);
	}
	
	public void delete (Book book) {
		book.clearAuthors();
		repo.delete(book);
	}

	public void addAuthor (Book book, Author author) {
		book.addAuthor(author);
		author.addBook(book);
	}

}
