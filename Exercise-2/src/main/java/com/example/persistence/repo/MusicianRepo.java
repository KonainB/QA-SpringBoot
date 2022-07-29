package com.example.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Musician;

@Repository
public interface MusicianRepo extends JpaRepository<Musician, Long>{

}
