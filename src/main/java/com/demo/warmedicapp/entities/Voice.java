package com.demo.warmedicapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voice")
@AllArgsConstructor
@NoArgsConstructor
public class Voice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "url", nullable = false)
    @JsonProperty("url")
    byte[] url;

    @Column(name = "soldier_id", nullable = false)
    @JsonProperty("soldier_id")
    private int soldierId;
}
