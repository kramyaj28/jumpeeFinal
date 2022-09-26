package com.project.jumpee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.Cart;

@Transactional(readOnly = true)
public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByUserId(long userId);
	Cart findById(long id);
	Cart findByCheckOutStatus(long id);
	Boolean existsByPaymentStatus(byte status);
	Boolean existsByUserId(long UserId);
	
	@Query(value = "select * from cart where user_id=:userId and id=:cartId", nativeQuery = true)
	Cart getByCartId(Long userId, long cartId);
	
	@Query(value = "SELECT * from cart where user_id=:userId and payment_status=0", nativeQuery = true)
	List<Cart> getByUserId(long userId);
	
//	@Query(value = "SELECT * from cart where check_out_status=0", nativeQuery = true)
//	Cart getByCheckOutStatus(long userId);

	
}
