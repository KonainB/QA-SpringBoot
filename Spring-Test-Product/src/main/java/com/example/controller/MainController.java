package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class MainController {
	private ProductService service;

	public MainController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createProduct")
	public Product create(@RequestBody Product prod) {
		return this.service.addProd(prod);
	}

	@GetMapping("/readProduct")
	public List<Product> getList() {
		return this.service.getAllProd();
	}

	@PutMapping("/updateProduct/{id}")
	public Product update(@PathVariable int id, @RequestBody Product prod1) {
		return this.service.updateProd(id, prod1);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public void delete(@PathVariable int id) {
		this.service.removeProd(id);
	}

	@GetMapping("/home")
	public String home() {
		return "My home is in UK";
	}

//	@GetMapping("/prod/{brand}")
//	public List<Product> prodBrand(@PathVariable String brand) {
//		return this.service.getProductByBrand(brand);
//	}
//
//	@GetMapping("/prod/{name}")
//	public List<Product> prodName(@PathVariable String name) {
//		return this.service.getProductByName(name);
//	}

	@GetMapping("/test")
	public String test() {
		return "Hello, World!";
	}

}
