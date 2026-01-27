package com.bootcamp.demo.bc_mtr_station.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "mtr_line_routes",
    uniqueConstraints = {
        @UniqueConstraint(name = "unique_line_station",
            columnNames = {"line_id", "station_id"}),
        @UniqueConstraint(name = "unique_line_sequence",
            columnNames = {"line_id", "sequence_order"})},
    indexes = {
        @Index(name = "idx_line_sequence",
            columnList = "line_id, sequence_order"),
        @Index(name = "idx_station_line", columnList = "station_id, line_id")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineRouteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "line_id", nullable = false, foreignKey = @ForeignKey(name = "FK_mtr_line_routes_line"))
  @OnDelete(action = OnDeleteAction.CASCADE)
  private LineEntity line;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "station_id", nullable = false, foreignKey = @ForeignKey(name = "FK_mtr_line_routes_station"))
  @OnDelete(action = OnDeleteAction.CASCADE)
  private StationEntity station;

  @Column(name = "sequence_order", nullable = false)
  private Integer sequenceOrder;



}
