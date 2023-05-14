package com.demo.warmedicapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Doctor {
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
    @Column(name = "brigade", unique = false, nullable = true)
    private String brigade;

    @OneToOne
    @JoinColumn(name = "credentials_id", referencedColumnName = "id")
    @JsonIgnore
    private Credentials credentials;
}
