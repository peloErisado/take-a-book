package es.take_a_book.application.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.take_a_book.application.model.Loan;
import es.take_a_book.application.model.Purchase;

//@CacheConfig(cacheNames="bookStore")
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
/*
	@Cacheable
	List<Purchase> findAll();

	@Cacheable
	Optional <Purchase> findById(long id);

	@CacheEvict(allEntries = true)
	Purchase save(Purchase purchase);
	
	@CacheEvict
	void deleteById(long id);
*/	
}
