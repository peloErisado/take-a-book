package es.take_a_book.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.take_a_book.application.model.Loan;
import es.take_a_book.application.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
/*
	@Cacheable
	List<Rating> findAll();

	@Cacheable
	Optional <Rating> findById(long id);

	@CacheEvict(allEntries = true)
	Rating save(Rating rating);
	
	@CacheEvict
	void deleteById(long id);
*/
}
