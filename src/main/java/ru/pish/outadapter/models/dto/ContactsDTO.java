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
public class ContactsDTO {

    @NotBlank
    @JsonProperty("type")
    private String Type;
    @JsonProperty("email")
    private String Email;
    @JsonProperty("phone")
    private String Phone;
    @JsonProperty("address")
    private AddressDTO Address;


}