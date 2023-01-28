package com.shelterspringboot.dogsshelter.service;

import com.shelterspringboot.dogsshelter.model.Adoptions;
import com.shelterspringboot.dogsshelter.repository.AdoptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionsService {

    @Autowired
    AdoptionsRepository adoptionsRepository;
    //Get
    public List<Adoptions> findAdoptionByCity(String city){
        return adoptionsRepository.findAdoptionsByCity(city);
    }
    //Get
    public Optional<Adoptions> readAdoptionsById(int id){
        return adoptionsRepository.findById(id);
    }
    //post
    public Adoptions addAdoption(Adoptions adoptions){
        return adoptionsRepository.save(adoptions);
    }
    //put
    public Adoptions updateAdoption(Adoptions adoptions){
        return adoptionsRepository.save(adoptions);
    }
    //delete
    public void deleteAdoptionById(int id){
        adoptionsRepository.deleteById(id);
    }


}
