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
public class SalaryDTO {

    @NotBlank
    @JsonProperty("amount")
    private int amount;
    @NotBlank
    @JsonProperty("currency")
    private String currency;


}