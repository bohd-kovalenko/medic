package com.demo.warmedicapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "battalion")
@NoArgsConstructor
@AllArgsConstructor
public class Battalion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "soldier_id", nullable = false)
    @JsonProperty("soldier_id")
    private int soldierId;
}
