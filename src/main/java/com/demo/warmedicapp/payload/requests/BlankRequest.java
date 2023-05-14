package com.demo.warmedicapp.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BlankRequest {
    private int soldierId;

    private String last4;
    boolean male;
    boolean female;
    private LocalDateTime dateTimeCreation;
    private String forcesType;
    private String bloodType;
    private String allergies;

    private LocalDateTime fillingTime;
    private String pulse;
    private String bloodPressure;
    private String respiratoryDate;
    private String pulseOxO2Sat;
    private String avpu;
    private String painScale;

    private boolean artillery;
    private boolean blunt;
    private boolean burn;
    private boolean fall;
    private boolean grenade;
    private boolean gsw;
    private boolean ied;
    private boolean landmine;
    private boolean mvc;
    private boolean rpg;
    private String other;

    private String text;

    @JsonCreator
    public BlankRequest(@JsonProperty("soldier_id") Integer soldierId,
                        @JsonProperty("last_4") String last4,
                        @JsonProperty("male") boolean male,
                        @JsonProperty("female") boolean female,
                        @JsonProperty("date_time_creation") LocalDateTime dateTimeCreation,
                        @JsonProperty("forces_type") String forcesType,
                        @JsonProperty("blood_type") String bloodType,
                        @JsonProperty("allergies") String allergies,
                        @JsonProperty("filling_time") LocalDateTime fillingTime,
                        @JsonProperty("pulse") String pulse,
                        @JsonProperty("blood_pressure") String bloodPressure,
                        @JsonProperty("respiratory_date") String respiratoryDate,
                        @JsonProperty("pulse_ox_o2_sat") String pulseOxO2Sat,
                        @JsonProperty("avpu") String avpu,
                        @JsonProperty("pain_scale") String painScale,
                        @JsonProperty("artillery") boolean artillery,
                        @JsonProperty("blunt") boolean blunt,
                        @JsonProperty("burn") boolean burn,
                        @JsonProperty("fall") boolean fall,
                        @JsonProperty("grenade") boolean grenade,
                        @JsonProperty("gsw") boolean gsw,
                        @JsonProperty("ied") boolean ied,
                        @JsonProperty("landmine") boolean landmine,
                        @JsonProperty("mvc") boolean mvc,
                        @JsonProperty("rpg") boolean rpg,
                        @JsonProperty("other") String other,
                        @JsonProperty("text") String text) {
        this.soldierId = soldierId;
        this.last4 = last4;
        this.male = male;
        this.female = female;
        this.dateTimeCreation = dateTimeCreation;
        this.forcesType = forcesType;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.fillingTime = fillingTime;
        this.pulse = pulse;
        this.bloodPressure = bloodPressure;
        this.respiratoryDate = respiratoryDate;
        this.pulseOxO2Sat = pulseOxO2Sat;
        this.avpu = avpu;
        this.painScale = painScale;
        this.artillery = artillery;
        this.blunt = blunt;
        this.burn = burn;
        this.fall = fall;
        this.grenade = grenade;
        this.gsw = gsw;
        this.ied = ied;
        this.landmine = landmine;
        this.mvc = mvc;
        this.rpg = rpg;
        this.other = other;
        this.text = text;
    }
}
