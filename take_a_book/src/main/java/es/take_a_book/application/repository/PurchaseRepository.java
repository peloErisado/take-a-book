package es.take_a_book.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import es.take_a_book.application.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
