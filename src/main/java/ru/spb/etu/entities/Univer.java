package ru.spb.etu.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "universities")
public class Univer {
    @Id
    @Column(name = "idUnivers")
    private int id;
    @Column
    private String name;
    @Column
    private String address;
}
