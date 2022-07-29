package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.repo.AccountRepo;

@Service
public class AccountService {
	private AccountRepo repo;
	public AccountService(AccountRepo repo) {
		super();
		this.repo=repo;
	}
	public Account createAcc(Account acc) {
		return this.repo.save(acc);
	}
	public List<Account> readAcc(){
		return this.repo.findAll();
	}
	public Account updateAcc(int id, Account acc) {
		Optional<Account> myTempAccount=this.repo.findById(id);
		Account existing= myTempAccount.get();
		existing.setAccountNumber(acc.getAccountNumber());
		existing.setName(acc.getName());
		return this.repo.save(existing);
	}
	public boolean deleteAcc(int id) {
		this.repo.deleteById(id);
		boolean exists=this.repo.existsById(id);
		return !exists;
	}

}
