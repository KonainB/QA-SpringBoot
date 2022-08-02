package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.exception.ProductNotFoundException;
import com.example.model.Product;
import com.example.repo.ProductRepo;

@Service
public class ProductService {
	private ProductRepo repo;
	//public List<Product> list=new ArrayList();
	public ProductService(ProductRepo repo) {
		super();
		this.repo = repo;
	}	
	public Product addProd(Product prod) {
		return this.repo.save(prod);
	}
	public List<Product> getAllProd() {
		return this.repo.findAll();
	}
	public Product updateProd(int id, Product prod1) {
		Product temp= this.repo.findById(id).orElseThrow(ProductNotFoundException::new);
		Optional<Product> myTempProduct=Optional.of(temp);
		Product existing= myTempProduct.get();
		//existing.setId(prod.getId());
		existing.setName(prod1.getName());
		existing.setBrand(prod1.getBrand());
		return this.repo.save(existing);
	}
	public boolean removeProd(int id) {
		this.repo.deleteById(id);
		boolean exists=this.repo.existsById(id);
		return !exists;
	}
//	public List<Product> getProductByBrand(String brand){
//		return this.repo.findProductbyBrand(brand);
//	}
//	public List<Product> getProductByName(String name){
//		return this.repo.findProductByName(name);
//	}

}
