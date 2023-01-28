package com.shelterspringboot.dogsshelter.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dogs")
public class Dogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "dog_breed")
    private String breed;
    @Column(name = "dog_height")
    private String height;
    @Column(name = "dog_color")
    private String color;
    @Column(name = "dog_gender")
    private String gender;
    @Column(name = "dog_years")
    private int years;




}
