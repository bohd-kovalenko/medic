package com.demo.warmedicapp.entities;

import com.demo.warmedicapp.entities.Soldier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "soldiers_injuries_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldierInjuriesTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name ="artillery", nullable = false, unique = false)
    private boolean artillery;
    @Column(name ="blunt", nullable = false, unique = false)
    private boolean blunt;
    @Column(name ="burn", nullable = false, unique = false)
    private boolean burn;
    @Column(name ="fall", nullable = false, unique = false)
    private boolean fall;
    @Column(name ="grenade", nullable = false, unique = false)
    private boolean grenade;
    @Column(name ="gsw", nullable = false, unique = false)
    private boolean gsw;
    @Column(name ="ied", nullable = false, unique = false)
    private boolean ied;
    @Column(name ="landmine", nullable = false, unique = false)
    private boolean landmine;
    @Column(name ="mvc", nullable = false, unique = false)
    private boolean mvc;
    @Column(name ="rpg", nullable = false, unique = false)
    private boolean rpg;
    @Column(name ="other", nullable = true, unique = false)
    private String other;
    @ManyToOne
    @JoinColumn(name = "soldier_id", nullable = false, unique = false)
    private Soldier soldier;
}
