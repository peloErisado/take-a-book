package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import es.take_a_book.application.model.Book;
import es.take_a_book.application.model.Loan;
import es.take_a_book.application.model.User;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
