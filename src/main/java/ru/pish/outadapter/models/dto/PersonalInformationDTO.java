package ru.pish.outadapter.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalInformationDTO {
    @NotBlank
    @JsonProperty("jobNumber")
    private String JobNumber;

    @JsonProperty("contacts")
    private List<ContactsDTO> Contacts;

    @JsonProperty("skills")
    private List<SkillsDTO> Skills;

}