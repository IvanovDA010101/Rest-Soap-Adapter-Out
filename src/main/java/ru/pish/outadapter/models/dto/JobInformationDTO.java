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
public class JobInformationDTO {
    @NotBlank
    @JsonProperty("workType")
    private String WorkType;
    @JsonProperty("chiefId")
    private String ChiefId;
    @NotBlank
    @JsonProperty("department")
    private DescriptionDTO Department;
    @NotBlank
    @JsonProperty("position")
    private DescriptionDTO Position;
    @NotBlank
    @JsonProperty("salary")
    private SalaryDTO Salary;
    @NotBlank
    @JsonProperty("entryDate")
    private String EntryDate;
    @JsonProperty("endDate")
    private String EndDate;
}