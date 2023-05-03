package es.take_a_book.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.take_a_book.application.model.Loan;
import es.take_a_book.application.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository repo;
	
	@Transactional(readOnly=true)
	public List<Loan> findAll(){
		return repo.findAll();
	}
	
	@Transactional(readOnly=true)
	public Optional<Loan> findById(long id){
		return repo.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void save (Loan loan) {
		repo.save(loan);
	}
	
	@Transactional(readOnly=false)
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	
}