package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.dto.AccountDTO;
import com.example.model.Account;
import com.example.repo.AccountRepo;

@Service
public class AccountService {
	private AccountRepo repo;
	private ModelMapper mapper;
	
	public AccountService(AccountRepo repo,ModelMapper mapper) {
		super();
		this.repo=repo;
		this.mapper = mapper;
	}
	private AccountDTO mapToDTO(Account account) {
		return this.mapper.map(account, AccountDTO.class);
	}

	public AccountDTO addAccount(Account account) {
		Account saved = this.repo.save(account);
		return this.mapToDTO(saved);
	}

	public List<AccountDTO> getAllAccount() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public AccountDTO updateAccount(int id, Account newAccount) {
		Optional<Account> existingOptional = this.repo.findById(id);
		Account existing = existingOptional.get();

		existing.setAccountNumber(newAccount.getAccountNumber());
		existing.setName(newAccount.getName());

		Account updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}

	public boolean removeAccount(int id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
