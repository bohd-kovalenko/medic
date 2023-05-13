package com.demo.warmedicapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", unique = false, nullable = false)
    private String password;
}
