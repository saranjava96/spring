package springCRUD.first.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import springCRUD.first.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
	@Query("SELECT p.price FROM Product p")
    List<Double> findProductPrices();
	
    @Query("SELECT p FROM Product p WHERE p.price <= :maxPrice")
    List<Product> findProductsByPrice(@Param("maxPrice") double maxPrice);
	
	
}
    
	
	
 
	
	

