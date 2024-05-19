package ru.pish.outadapter.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentsDTO {
    @NotBlank
    @JsonProperty("type")
    private String Type;
    @NotBlank
    @JsonProperty("description")
    private String Description;
    @NotBlank
    @JsonProperty("number")
    private String Number;
    @JsonProperty("registrationDate")
    private String RegistrationDate;


}