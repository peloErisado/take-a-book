package es.take_a_book.application.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.take_a_book.application.model.Loan;
import es.take_a_book.application.model.Users;

import java.util.List;
import java.util.Optional;

//@CacheConfig(cacheNames="bookStore")
public interface UserRepository extends JpaRepository<Users, String> {
/*
	@Cacheable
	List<Users> findAll();

	@Cacheable
	Optional <Users> findById(String username);

	@CacheEvict(allEntries = true)
	Users save(Users users);
	
	@CacheEvict
	void deleteById(String username);
*/
}
