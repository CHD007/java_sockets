package ru.spb.etu.entities;

import lombok.Data;
import ru.spb.etu.server.Server;

import javax.persistence.*;

@Data
@Entity(name = "supplies")
public class Supply {
    @Id
    @Column(name = "idsupplies")
    private int id;

    @OneToOne
    @JoinColumn(name = "serverFk")
    private RackmountServer serverFk;
    @OneToOne
    @JoinColumn(name = "univerFk")
    private Univer univerFk;
}
