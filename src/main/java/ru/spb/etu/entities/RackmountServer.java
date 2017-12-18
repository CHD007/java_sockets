package ru.spb.etu.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "servers")
public class RackmountServer {
    @Id
    @Column(name = "idservers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String serverName;
    @Column
    private String processor;
}
