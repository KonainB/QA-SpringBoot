package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.exception.BandNotFoundException;
import com.example.persistence.domain.Band;
import com.example.persistence.repo.BandRepo;
import com.example.rest.dto.BandDTO;

@Service
public class BandService {
	private BandRepo repo;
	private ModelMapper mapper;
	
	public BandService(BandRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	public BandDTO readById(Long id) {
        Band found = this.repo.findById(id).orElseThrow(BandNotFoundException::new);
        return this.mapToDTO(found);
    }
	private BandDTO mapToDTO(Band band) {
		return this.mapper.map(band, BandDTO.class);
	}
	public BandDTO addBand(Band band) {
		 Band saved = this.repo.save(band);
		 return this.mapToDTO(saved);
	 }
	 public List<BandDTO>getAllBand() {
		 return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	 }
	 public BandDTO updateBand(Long id, Band newBand) {
		 Optional<Band> existingOptional = this.repo.findById(id);
		 Band existing = existingOptional.get();
		 
		 existing.setName(newBand.getName());
		 
		 Band updated = this.repo.save(existing);
		 return this.mapToDTO(updated);
	 }
	 public boolean removeBand(Long id) {
		 this.repo.deleteById(id);
		 boolean exists = this.repo.existsById(id);
		 return !exists;
	 }
	
	

}
