package com.shelterspringboot.dogsshelter.repository;

import com.shelterspringboot.dogsshelter.model.Dogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogsRepository extends JpaRepository<Dogs, Integer> {


}
