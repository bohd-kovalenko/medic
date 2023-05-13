package com.demo.warmedicapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "soldier_to_medic")
@AllArgsConstructor
@NoArgsConstructor
public class SoldierToMedic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "soldier_id", nullable = false)
    private Integer soldierId;

    @Column(name = "medic_id", nullable = false)
    private Integer medicId;

    @Column(name = "note", nullable = false, unique = false)
    private String note;
}
