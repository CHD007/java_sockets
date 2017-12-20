package ru.spb.etu.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "supplies")
public class Supply {
    @Id
    @Column(name = "idsupplies")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "serverFk")
    private MountServer serverFk;
    @OneToOne
    @JoinColumn(name = "univerFk")
    private Univer univerFk;
}
