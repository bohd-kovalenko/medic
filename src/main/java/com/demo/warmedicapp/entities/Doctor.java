package com.demo.warmedicapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "medic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @JoinColumn(name = "credentials_id", nullable = false, unique = true)
    @OneToOne(fetch = FetchType.EAGER)
    private Credentials credentials;

}
