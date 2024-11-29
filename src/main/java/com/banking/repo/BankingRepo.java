package com.banking.repo;
import com.banking.model.Banking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingRepo extends JpaRepository<Banking,Long> {
}
