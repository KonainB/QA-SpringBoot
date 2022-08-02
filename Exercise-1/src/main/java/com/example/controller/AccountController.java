package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AccountDTO;
import com.example.model.Account;
import com.example.service.AccountService;

@RestController
public class AccountController {
	private AccountService service;
	
	public AccountController(AccountService service) {
		super();
		this.service=service;
	}
	
	@PostMapping("/createAccount")
	public AccountDTO create(@RequestBody Account acc)
	{
		return this.service.addAccount(acc);
	}
	@GetMapping("/readAccount")
	public List<AccountDTO> getList()
	{
		return this.service.getAllAccount();
	}
	@PutMapping("/updateAccount/{id}")
	public AccountDTO update(@PathVariable int id,@RequestBody Account acc)
	{
		return this.service.updateAccount( id, acc);
	}
	@DeleteMapping("/deleteAccount/{id}")
	public void delete (@PathVariable int id)
	{
		this.service.removeAccount(id);
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "My home is in UK";
	}

}
