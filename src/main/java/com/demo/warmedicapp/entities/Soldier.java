package com.demo.warmedicapp.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "soldiers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "surname", unique = false, nullable = false)
    @JsonProperty("surname")
    private String surname;

    @Column(name = "blood_type", unique = false, nullable = false)
    @JsonProperty("blood_type")
    private String bloodType;

    @Column(name = "infections", unique = false, nullable = false)
    @JsonProperty("infections")
    private String infections;

    @Column(name = "needs_blood_transfusion", unique = false, nullable = false)
    @JsonProperty("needs_blood_transfusion")
    private Boolean needsBloodTransfusion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "soldier_id", referencedColumnName = "id")
    private Set<Image> images;
}