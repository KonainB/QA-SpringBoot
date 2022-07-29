package com.example.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Band;
import com.example.rest.dto.BandDTO;
import com.example.service.BandService;

@RestController
public class BandController {
	private BandService service;

    public BandController(BandService service) {
        super();
        this.service = service;
    }

    @PostMapping("/createBand")
    public BandDTO addBand(@RequestBody Band band) {
        return this.service.addBand(band);
    }

    @GetMapping("/getAllBand")
    public List<BandDTO> getAllBand() {
        return this.service.getAllBand();
    }

    @PutMapping("/updateBand/{id}")
    public BandDTO updateBand(@PathVariable Long id, @RequestBody Band band) {
        return this.service.updateBand(id, band);
    }

    @DeleteMapping("/deleteBand/{id}")
    public boolean removeBand(@PathVariable Long id) {
        return this.service.removeBand(id);
    }
    


}
