package com.bootcamp.demo.bc_mtr_station.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "mtr_stations",
        uniqueConstraints = @UniqueConstraint(name = "station_code_unique",
                columnNames = {"station_code"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_code", length = 3, nullable = false)
    private String stationCode;

    @Column(name = "description", length = 100, nullable = false)
    private String description;



}
