package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.exception.MusicianNotFoundException;
import com.example.persistence.domain.Musician;
import com.example.persistence.repo.MusicianRepo;
import com.example.rest.dto.MusicianDTO;

@Service
public class MusicianService {
	
	private MusicianRepo repo;
	private ModelMapper mapper;
	
	public MusicianService(MusicianRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	 public MusicianDTO readById(Long id) {
	        Musician found = this.repo.findById(id).orElseThrow(MusicianNotFoundException::new);
	        return this.mapToDTO(found);
    }
	 private MusicianDTO mapToDTO(Musician musician) {
			return this.mapper.map(musician, MusicianDTO.class);
	}
	 public MusicianDTO addMusician(Musician musician) {
		 Musician saved = this.repo.save(musician);
		 return this.mapToDTO(saved);
	}
	 public List<MusicianDTO>getAllMusicians() {
		 return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	 public MusicianDTO updateMusician(Long id, Musician newMusician) {
		 Optional<Musician> existingOptional = this.repo.findById(id);
		 Musician existing = existingOptional.get();
		 
		 existing.setName(newMusician.getName());
		 existing.setStrings(newMusician.getStrings());
		 existing.setType(newMusician.getType());
		 existing.setBand(newMusician.getBand());
		 
		 Musician updated = this.repo.save(existing);
		 return this.mapToDTO(updated);
	}
	 public boolean removeMusician(Long id) {
		 this.repo.deleteById(id);
		 boolean exists = this.repo.existsById(id);
		 return !exists;
	}
	
	
	
}
	
