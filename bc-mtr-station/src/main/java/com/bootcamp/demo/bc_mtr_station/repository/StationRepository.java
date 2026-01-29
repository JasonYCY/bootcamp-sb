package com.bootcamp.demo.bc_mtr_station.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, Long> {

  Optional<StationEntity> findByStationCode(String stationCode);

  @Query("""
      SELECT s.stationCode 
      FROM LineEntity l
      JOIN LineRouteEntity r ON l.id = r.line.id
      JOIN StationEntity s ON r.station.id = s.id
      WHERE l.lineCode = :lineCode
      """)
  List<String> findStationCodesByLineCode(@Param("lineCode") String lineCode);
  
}
