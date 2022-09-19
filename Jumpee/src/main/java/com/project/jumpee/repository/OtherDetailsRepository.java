package com.project.jumpee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.OtherDetails;

@Transactional(readOnly = true)
public interface OtherDetailsRepository extends JpaRepository<OtherDetails, Long> {

	Optional<OtherDetails> findByContactPersonNumber(String contactPersonNumber);
	Boolean existsByContactPersonNumber(String contactPersonNumber);
	OtherDetails findByUserId(long id);
	Boolean existsByUserId(long userId);
	
	@Query(value = "SELECT * from other_details where user_id=:userId", nativeQuery = true)
	List<OtherDetails> getByUserId(long userId);
}