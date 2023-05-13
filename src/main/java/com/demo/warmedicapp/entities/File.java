package com.demo.warmedicapp.entities;

import com.demo.warmedicapp.entities.enums.FileType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "url", unique = false, nullable = false)
    @JsonProperty("url")
    private String name;

    @Column(name = "soldier_id", unique = false, nullable = false)
    @JsonProperty("soldier_id")
    private int soldierId;

    @Column(name = "type", unique = false, nullable = false)
    @JsonProperty("type")
    private FileType type;
}
