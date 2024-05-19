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
public class EmployeeDTO
{
    @NotBlank
    @JsonProperty("uuid")
    private String Uuid;
    @NotBlank
    @JsonProperty("firstName")
    private String FirstName;
    @NotBlank
    @JsonProperty("lastName")
    private String LastName;

    @JsonProperty("middleName")
    private String MiddleName;
    @NotBlank
    @JsonProperty("birthdate")
    private String Birthdate;

    @JsonProperty("jobInformation")
    private JobInformationDTO JobInformation;
    @JsonProperty("personalInformation")
    private PersonalInformationDTO PersonalInformation;

}