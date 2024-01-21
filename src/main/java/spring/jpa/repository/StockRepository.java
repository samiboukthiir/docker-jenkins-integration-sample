package spring.jpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.Stock;
public interface StockRepository extends
JpaRepository<Stock, Long> { }
