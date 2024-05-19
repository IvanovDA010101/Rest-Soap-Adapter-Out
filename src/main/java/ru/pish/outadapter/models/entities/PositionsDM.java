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
@Table(name = "positions")
public class PositionsDM {


    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "description")
    private String description;


}