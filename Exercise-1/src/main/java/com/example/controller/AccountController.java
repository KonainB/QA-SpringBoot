package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public Account create(@RequestBody Account acc)
	{
		return this.service.createAcc(acc);
	}
	@GetMapping("/readAccount")
	public List<Account>getList()
	{
		return this.service.readAcc();
	}
	@PutMapping("/updateAccount/{id}")
	public Account update(@PathVariable int id,@RequestBody Account acc)
	{
		return this.service.updateAcc(id, acc);
	}
	@DeleteMapping("/deleteAccount/{id}")
	public void delete (@PathVariable int id)
	{
		this.service.deleteAcc(id);
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "My home is in UK";
	}

}
