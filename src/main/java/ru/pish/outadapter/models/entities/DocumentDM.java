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
@Table(name = "skills")
public class DocumentDM {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "employeeuuid")
    private String employeeUuid;

}