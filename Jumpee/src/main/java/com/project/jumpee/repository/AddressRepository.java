package com.project.jumpee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.Address;

@Transactional(readOnly = true)
public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findByUserId(long id);
	Boolean existsByUserId(long userId);
	Address findById(long addressId);
	
	@Query(value = "select * from address where user_id=:userId and id =:addressId", nativeQuery = true)
	Address findByAddressId(long userId, long addressId);
	
	@Query(value = "SELECT * from address where user_id=:userId", nativeQuery = true)
	List<Address> getByUserId(long userId);
	
	@Modifying
	@Transactional
	@Query(value = "update address set is_default=1 where user_id=:userId and id=:addressId", nativeQuery = true)
	void setDefaultAddress(long userId, long addressId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from address where user_id = :userId and id = :addressId", nativeQuery = true)
	void deleteAddress(long userId, long addressId);
	
	
	@Query(value = "select * from address where is_default=1 and user_id=:userId", nativeQuery = true)
	Address getAddressId(long userId);
	
}