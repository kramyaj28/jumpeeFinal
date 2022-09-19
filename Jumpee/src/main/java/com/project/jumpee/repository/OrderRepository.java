package com.project.jumpee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.Orders;

@Transactional(readOnly = true)
public interface OrderRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findById(long id);
    Orders findByUserId(long id);
    Boolean existsByUserId(long id);
    
    List<Orders> findAllByUserId(long id);
    
    
}
