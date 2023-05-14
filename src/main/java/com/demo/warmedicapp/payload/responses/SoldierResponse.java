package com.demo.warmedicapp.payload.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SoldierResponse {
    private String brigade;
    private String name;
    private String surname;
    private String patronymic;
    private Integer age;
    private String infections;
    private String allergies;
    private String bloodType;
    private Boolean needsBloodTransfusion;

    @JsonCreator
    public SoldierResponse(@JsonProperty("brigade") String brigade,
                           @JsonProperty("name") String name,
                           @JsonProperty("surname") String surname,
                           @JsonProperty("patronymic") String patronymic,
                           @JsonProperty("age") Integer age,
                           @JsonProperty("infections") String infections,
                           @JsonProperty("allergies") String allergies,
                           @JsonProperty("blood_type") String bloodType,
                           @JsonProperty("needs_blood_transfusion") Boolean needsBloodTransfusion) {
        this.brigade = brigade;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.infections = infections;
        this.allergies = allergies;
        this.bloodType = bloodType;
        this.needsBloodTransfusion = needsBloodTransfusion;
    }
}
