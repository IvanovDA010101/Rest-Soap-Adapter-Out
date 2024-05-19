package ru.pish.outadapter.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeDM {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "departmentuuid")
    private String departmentUuid;

    @Column(name = "positionuuid")
    private String positionUuid;

    @Column(name = "jobnumber")
    private String jobNumber;

}