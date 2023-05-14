package com.demo.warmedicapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "general_soldier_medical_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralSoldierMedicalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "last4", nullable = true, unique = false)
    private String last4;
    @Column(name = "gender", nullable = true, unique = false)
    private String gender;
    @Column(name = "date_time_creation", nullable = true, unique = false)
    private LocalDateTime dateTimeCreation;
    @Column(name = "forces_type", nullable = true, unique = false)
    private String forcesType;
    @Column(name = "blood_type", nullable = true, unique = false)
    private String bloodType;
    @Column(name = "allergies", nullable = true, unique = false)
    private String allergies;
    @ManyToOne
    @JoinColumn(name = "soldier_id", unique = false, nullable = false)
    private Soldier soldier;
}
