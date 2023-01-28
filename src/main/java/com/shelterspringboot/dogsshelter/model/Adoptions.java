package com.shelterspringboot.dogsshelter.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "adoptions")
public class Adoptions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "adopter_name")
    private String name;
    @Column(name = "adopter_phone")
    private String phone;
    @Column(name = "adopter_email")
    private String email;
    @Column(name = "adopter_city")
    private String city;


}
