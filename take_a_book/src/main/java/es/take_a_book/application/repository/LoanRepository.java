package es.take_a_book.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.take_a_book.application.model.Loan;

//@CacheConfig(cacheNames="bookStore")
public interface LoanRepository extends JpaRepository<Loan, Long> {
/*
	@Cacheable
	List<Loan> findAll();

	@Cacheable
	Optional <Loan> findById(long id);

	@CacheEvict(allEntries = true)
	Loan save(Loan loan);
	
	@CacheEvict
	void deleteById(long id);
	*/
}
