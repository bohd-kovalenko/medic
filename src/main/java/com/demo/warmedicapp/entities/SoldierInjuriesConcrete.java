package com.demo.warmedicapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "soldier_injuries_concrete")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldierInjuriesConcrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "text", nullable = true, unique = false)
    private String text;
    @Column(name = "tq", nullable = true, unique = false)
    private String tq;
    @Column(name = "injury_time", nullable = true, unique = false)
    private LocalDateTime injuryTime;
    @ManyToOne
    @JoinColumn(name = "soldier_id", nullable = false, unique = false)
    private Soldier soldier;
}
