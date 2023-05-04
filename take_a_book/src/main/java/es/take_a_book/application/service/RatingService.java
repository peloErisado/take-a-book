package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.take_a_book.application.model.Rating;
import es.take_a_book.application.repository.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository repo;
	
	public List<Rating> findAll(){
		return repo.findAll();
	}
	
	public Optional<Rating> findById(long id){
		return repo.findById(id);
	}
	
	public void save (Rating rating) {
		repo.save(rating);
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
}
