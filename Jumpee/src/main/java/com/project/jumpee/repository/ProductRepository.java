package com.project.jumpee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.Product;

@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query (value = "SELECT * from product WHERE MATCH (brand_name, product_name) AGAINST (?1)", nativeQuery = true)
    public List<Product> search(String keyword);

	Product findById(long id);
	
//	@Query(value = "SELECT * from product where id=:productId", nativeQuery = true)
//	Product findByQuantity(@Param ("productId")long userId);
//	Product findByQuantity(Cart cart);
}
