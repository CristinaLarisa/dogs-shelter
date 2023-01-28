package com.shelterspringboot.dogsshelter.service;

import com.shelterspringboot.dogsshelter.model.Dogs;
import com.shelterspringboot.dogsshelter.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogsService {
    @Autowired
    DogsRepository dogsRepository;
    //get
    public List<Dogs> reedAllDogs(){
        return dogsRepository.findAll();
    }
    //get
    public Optional<Dogs> getDogById(int id){
        return dogsRepository.findById(id);
    }
    //post
    public Dogs addDog(Dogs dogs){
        return dogsRepository.save(dogs);
    }
    //put
    public Dogs updateDog(Dogs dogs){
        return dogsRepository.save(dogs);
    }
    //delete
    public void deleteDogById(int id){
        dogsRepository.deleteById(id);
    }



}
