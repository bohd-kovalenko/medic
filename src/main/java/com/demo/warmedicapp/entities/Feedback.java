package com.demo.warmedicapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedbacks")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "text", unique = false, nullable = false)
    @JsonProperty("text")
    private String text;

    @Column(name = "soldier_id", unique = false, nullable = false)
    @JsonProperty("soldier_id")
    private int soldierId;

    @Column(name = "doctor_id", unique = false, nullable = false)
    @JsonProperty("doctor_id")
    private int doctorId;
}
