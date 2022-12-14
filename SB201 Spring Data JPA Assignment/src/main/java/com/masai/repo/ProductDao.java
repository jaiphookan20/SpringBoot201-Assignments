package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;

@Repository
public interface  ProductDao extends JpaRepository<Product, Integer> {
	
	

	public List<Product> findByCategory(String category) throws ProductException;
	

	@Query("select new com.masai.model.ProductDTO(s.productName, s.quantity,s.price) from Product s")
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException;


}
