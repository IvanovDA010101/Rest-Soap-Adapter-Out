package ru.pish.outadapter.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contacts")
public class ContactDM {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "type")
    private String type;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "employeeuuid")
    private String employeeUuid;
}