package com.project.jumpee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.jumpee.model.Wallet;

@Transactional(readOnly = true)
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findById(long id);
    Wallet findByUserId(long id);
    Boolean existsByUserId(long id);
    
    @Query (value = "select * from wallet where user_id=:user_id", nativeQuery = true)
    Wallet getWalletBalance (@Param ("user_id")long userId);
}
