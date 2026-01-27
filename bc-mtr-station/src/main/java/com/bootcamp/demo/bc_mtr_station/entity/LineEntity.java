package com.bootcamp.demo.bc_mtr_station.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "mtr_lines",
        uniqueConstraints = @UniqueConstraint(name = "line_code_unique",
                columnNames = {"line_code"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line_code", length = 3, nullable = false)
    private String lineCode;

    @Column(name = "description", length = 100, nullable = false)
    private String description;



}
