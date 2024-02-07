package springCRUD.first.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springCRUD.first.model.Product;
import springCRUD.first.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{   
	@Autowired
	private ProductService productService;
	
	@GetMapping
	List<Product>getAllProducts() 
	{
		return productService.getAllProducts();
		
	}
	@GetMapping("/id/{id}") 
	public ResponseEntity<Product> getProductById(@PathVariable Long id)
	{    
		Product product=productService.getProductById(id);
		return product !=null ?ResponseEntity.ok(product):ResponseEntity.notFound().build();
	}
	
    @GetMapping("/price")
    public ResponseEntity<List<Double>> getProductPrices() {
        List<Double> prices = productService.findProductPrices();
        return ResponseEntity.ok(prices);
    }
    @GetMapping("/findByPrice")
    
    public List<Product> findProductsByPrice(@RequestParam("maxPrice") double maxPrice) {
        return productService.findProductsByPrice(maxPrice);
    }
	

    @PostMapping("/post")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

	        	
}
