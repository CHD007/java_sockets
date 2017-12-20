package ru.spb.etu.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "univers")
public class Univer {
    @Id
    @Column(name = "idunivers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String address;
}
