package ru.spb.etu.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "mount_servers")
public class MountServer {
    @Id
    @Column(name = "idmount_servers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String processor;
}
