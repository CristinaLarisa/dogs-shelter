package com.shelterspringboot.dogsshelter.controller;

import com.shelterspringboot.dogsshelter.exception.ResourceNotFoundException;
import com.shelterspringboot.dogsshelter.model.Dogs;
import com.shelterspringboot.dogsshelter.service.DogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dogs")
public class DogsController {

    private final DogsService dogsService;

    @GetMapping("/{id}")
    public ResponseEntity<Dogs> getDogById(@PathVariable int id){
        Dogs dogsDB = dogsService.getDogById(id).orElseThrow(()-> new ResourceNotFoundException("Dog with id " + id + " does not exist in DB"));
    return ResponseEntity.ok(dogsDB);
    }

    @PostMapping("/add")  // http://localhost:8080/api/dogs/add
    public ResponseEntity<Dogs> addDog(@RequestBody Dogs dogs){
        Dogs newDog = dogsService.addDog(dogs);
        return ResponseEntity.ok(newDog);
    }

    @PutMapping("/updateDogs")     //  http://localhost:8080/api/dogs/updateDogs
    public ResponseEntity<Dogs> updateDogs (@RequestBody Dogs dogs){
       Dogs updateDogs = dogsService.updateDog(dogs);
        return ResponseEntity.ok(updateDogs);
    }

    @DeleteMapping("/deleteDog/{id}") //http://localhost:8080/api/dogs/deleteDog/{id}
    public ResponseEntity<?> deleteDog(@PathVariable("id") int id){
        dogsService.getDogById(id).orElseThrow(() -> new ResourceNotFoundException("Dog with id: " + id + " doesn't exist in DB"));
        dogsService.deleteDogById(id);
        return new ResponseEntity<>("Dog with id: " + id + " deleted successfully!", HttpStatus.OK);
    }




}

