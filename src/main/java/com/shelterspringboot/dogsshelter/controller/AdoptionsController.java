package com.shelterspringboot.dogsshelter.controller;

import com.shelterspringboot.dogsshelter.exception.ResourceNotFoundException;
import com.shelterspringboot.dogsshelter.model.Adoptions;
import com.shelterspringboot.dogsshelter.service.AdoptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/adoptions")
public class AdoptionsController {

    private final AdoptionsService adoptionsService;

    @GetMapping("/{city}")   // http://localhost:8080/api/adoptions/{city}
    public ResponseEntity<List<Adoptions>> getAdoptionById(@PathVariable String city){
        List<Adoptions> adoptionsList = adoptionsService.findAdoptionByCity(city);
        if(adoptionsList.size() == 0){
            throw new ResourceNotFoundException("No adoption with the city name: " + city + " was found in DB");
        }
        return new ResponseEntity<>(adoptionsList, HttpStatus.OK);
    }

    @PostMapping("/addAdoption")  // http://localhost:8080/api/adoptions/addAdoption
    public Adoptions addAdoption(@RequestBody Adoptions adoptions){
        return adoptionsService.addAdoption(adoptions);
    }

    @PutMapping("/updateAdoption")  // http://localhost:8080/api/adoptions/updateAdoption
    public ResponseEntity<Adoptions> updateAdoption (@RequestBody Adoptions adoptions){
        Adoptions updateAdoption = adoptionsService.updateAdoption(adoptions);
        return ResponseEntity.ok(updateAdoption);
    }

    @DeleteMapping("/deleteAdoption/{id}") // http://localhost:8080/api/adoptions/deleteAdoption/{id}
    public ResponseEntity<?> deleteAdoption(@PathVariable("id") int id){
        adoptionsService.readAdoptionsById(id).orElseThrow(() -> new ResourceNotFoundException("Adoption with id: " + id + " doesn't exist in DB"));
        adoptionsService.deleteAdoptionById(id);
        return new ResponseEntity<>("Adoption with id: " + id + " deleted succesfully!", HttpStatus.OK);
    }

}
