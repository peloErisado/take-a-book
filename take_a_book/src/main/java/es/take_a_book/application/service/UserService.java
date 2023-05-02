package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import es.take_a_book.application.repository.UserRepository;
import es.take_a_book.application.model.Users;

@Controller
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Transactional(readOnly=true)
	public List<Users> findAll(){
		return repo.findAll();
	}
	
	@Transactional(readOnly=true)
	public Optional<Users> findById(String username){
		return repo.findById(username);
	}
	
	@Transactional(readOnly=false)
	public void save (Users user) {
		repo.save(user);
	}
	
	@Transactional(readOnly=false)
	public void delete (String username) {
		repo.deleteById(username);
	}
	
}
