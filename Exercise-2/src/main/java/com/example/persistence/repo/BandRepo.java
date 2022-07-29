package com.example.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Band;

@Repository
public interface BandRepo extends JpaRepository<Band, Long> {

}
