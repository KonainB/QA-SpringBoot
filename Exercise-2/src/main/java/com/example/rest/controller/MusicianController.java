package com.example.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Musician;
import com.example.rest.dto.MusicianDTO;
import com.example.service.MusicianService;

@RestController
public class MusicianController {
	private MusicianService service;

	public MusicianController(MusicianService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createMusician")
	public MusicianDTO addMusician(@RequestBody Musician musician) {
		return this.service.addMusician(musician);
	}

	@GetMapping("/getAllMusician")
	public List<MusicianDTO> getAllMusician() {
		return this.service.getAllMusicians();
	}

	@PutMapping("/updateMusician")
	public MusicianDTO updateMusician(@PathParam("id") Long id, @RequestBody Musician musician) {
		return this.service.updateMusician(id, musician);
	}

	@DeleteMapping("/deleteMusician/{id}")
	public boolean removeMusician(@PathVariable Long id) {
		return this.service.removeMusician(id);
	}
	

}
