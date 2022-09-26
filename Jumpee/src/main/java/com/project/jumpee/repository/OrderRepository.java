package com.project.jumpee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.Order;

@Transactional(readOnly = true)
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(long id);
    Order findByUserId(long id);
    Boolean existsByUserId(long id);
    
    List<Order> findAllByUserId(long id);
    
    
}
