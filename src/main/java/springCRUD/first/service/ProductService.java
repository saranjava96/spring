package springCRUD.first.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springCRUD.first.model.Product;
import springCRUD.first.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product>getAllProducts()
	{
		return productRepository.findAll(); // all products
		
	}
	public Product getProductById(Long id)
	
	{
		return productRepository.findById(id).orElse(null); // find by id
		   
	}
	   public List<Product> findProductsByPrice(double maxPrice) {
	        return productRepository.findProductsByPrice(maxPrice);
	   }
    public List<Double> findProductPrices() {
        return productRepository.findProductPrices();
    }

	public Product createProduct (Product product) {
		return productRepository.save(product);
	}
	
}
