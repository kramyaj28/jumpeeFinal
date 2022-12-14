package com.project.jumpee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.User;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByMobileNumber(String mobileNumber);
    Optional<User> findById(long id);
    Boolean existsByStatus(int status);
    Boolean existsByMobileNumber(String username);
    Boolean existsByContactPersonNumber(String username);
    Boolean existsByEmail(String email);
    Boolean existsByPassword(String password);
    Boolean existsById(long id);
    
    @Query (value = "select * from users where email=:email", nativeQuery = true)
    User getUserByEmail (String email);
    
    @Query (value = "select * from users where status=:status", nativeQuery = true)
    User getUserByStatus (int status);
    
//    @Query (value = "select * from users where id=:id", nativeQuery = true)
//    User findByEmailId (@Param ("email")long id);
    
}