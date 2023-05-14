package com.demo.warmedicapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "situation_specific_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecificSituationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "filling_time", unique = false, nullable = true)
    private LocalDateTime fillingTime;
    @Column(name = "pulse", unique = false, nullable = true)
    private String pulse;
    @Column(name = "blood_pressure", unique = false, nullable = true)
    private String bloodPressure;
    @Column(name = "respiratory_rate", unique = false, nullable = true)
    private String respiratoryDate;
    @Column(name = "pulse_ox%o2_sat", unique = false, nullable = true)
    private String pulseOxO2Sat;
    @Column(name = "avpu", unique = false, nullable = true)
    private String avpu;
    @Column(name = "pain_scale", unique = false, nullable = true)
    private String painScale;
    @ManyToOne
    @JoinColumn(name = "soldier_id", nullable = false, unique = false)
    private Soldier soldier;
}
