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
public class DescriptionDTO {

    @NotBlank
    @JsonProperty("uuid")
    private String Uuid;
    @NotBlank
    @JsonProperty("description")
    private String Description;

}