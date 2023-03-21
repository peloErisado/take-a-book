package es.take_a_book.application.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.take_a_book.application.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	 
}
