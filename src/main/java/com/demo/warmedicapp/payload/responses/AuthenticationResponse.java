package com.demo.warmedicapp.payload.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private String doctorName;
    private String doctorSurname;
    private String username;
    private String roleName;
    private Integer id;
    private String token;

    @JsonCreator
    public AuthenticationResponse(@JsonProperty("doctor_name") String doctorName,
                                  @JsonProperty("doctor_surname") String doctorSurname,
                                  @JsonProperty("username") String username,
                                  @JsonProperty("role_name") String roleName,
                                  @JsonProperty("doctor_id") Integer id) {
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.username = username;
        this.roleName = roleName;
        this.id = id;
    }
}
