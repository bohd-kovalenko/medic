package com.demo.warmedicapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "brigade", unique = false, nullable = false)
    @JsonProperty("brigade")
    private String brigade;

    @Column(name = "name", unique = false, nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "surname", unique = false, nullable = false)
    @JsonProperty("surname")
    private String surname;

    @Column(name = "patronymic", unique = false, nullable = false)
    @JsonProperty("patronymic")
    private String patronymic;

    @Column(name = "needs_blood_transfusion", unique = false, nullable = false)
    @JsonProperty("needs_blood_transfusion")
    private Boolean needsBloodTransfusion;

    @Column(name = "created_at", unique = false, nullable = false)
    @JsonProperty("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "deleted_at", unique = false, nullable = true)
    @JsonProperty("deleted_at")
    private LocalDateTime deletedAt;
    @OneToOne(mappedBy = "soldier")
    private SoldierInjuriesConcrete soldierInjuriesConcreteList;
    @OneToOne(mappedBy = "soldier")
    private SoldierInjuriesTypes soldierInjuriesTypesList;
    @OneToMany(mappedBy = "soldier")
    private List<SpecificSituationInfo> specificSituationInfoList;
    @OneToOne(mappedBy = "soldier")
    private GeneralSoldierMedicalInfo generalSoldierMedicalInfo;
}
