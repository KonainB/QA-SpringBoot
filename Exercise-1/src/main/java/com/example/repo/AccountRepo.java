package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer>{

	boolean existsById(Long id);

	Optional<Account> findById(Long id);

	void deleteById(Long id);

	

}
