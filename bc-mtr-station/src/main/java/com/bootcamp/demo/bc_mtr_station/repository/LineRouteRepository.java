package com.bootcamp.demo.bc_mtr_station.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.bc_mtr_station.entity.LineRouteEntity;

@Repository
public interface LineRouteRepository extends JpaRepository<LineRouteEntity, Long> {

  @Query("""
      SELECT l.lineCode 
      FROM LineEntity l
      JOIN LineRouteEntity r ON l.id = r.line.id
      JOIN StationEntity s ON r.station.id = s.id
      WHERE s.stationCode = :stationCode
      """)
  List<String> findLineCodesByStationCode(@Param("stationCode") String stationCode);
  
}
