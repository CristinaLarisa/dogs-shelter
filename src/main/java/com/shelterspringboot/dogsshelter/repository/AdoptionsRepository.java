package com.shelterspringboot.dogsshelter.repository;

import com.shelterspringboot.dogsshelter.model.Adoptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionsRepository extends JpaRepository<Adoptions, Integer> {

    List<Adoptions> findAdoptionsByCity(String city);



}
