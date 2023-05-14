package com.demo.warmedicapp.payload.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackResponse {
    private Integer id;

    private String text;
    private String name;
    private String surname;
    private String patronymic;

    @JsonCreator
    public FeedbackResponse(@JsonProperty("id") Integer id,
                            @JsonProperty("text") String text,
                            @JsonProperty("name") String name,
                            @JsonProperty("surname") String surname,
                            @JsonProperty("patronymic") String patronymic) {
        this.id = id;
        this.text = text;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }
}
