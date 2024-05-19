package ru.pish.outadapter.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillsDTO {

    @JsonProperty("category")
    private String Category;
    @JsonProperty("description")
    private String Description;


}