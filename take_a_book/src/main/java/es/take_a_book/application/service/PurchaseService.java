package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.take_a_book.application.model.Purchase;
import es.take_a_book.application.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepository repo;
	
	public List<Purchase> findAll(){
		return repo.findAll();
	}
	
	public Optional<Purchase> findById(long id){
		return repo.findById(id);
	}
	
	public void save (Purchase p) {
		repo.save(p);
	}
	
	/*
	public void delete(long id) {
		repo.deleteById(id);
	}
	*/
	
}
