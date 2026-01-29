package com.bootcamp.demo.bc_mtr_station.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.projection.LineStationProjection;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long> {

    Optional<LineEntity> findByLineCode(String lineCode);

    @Query("SELECT l.lineCode FROM LineEntity l")
    List<String> findAllLineCode();

    boolean existsByLineCode(String lineCode);

    /**
     * 核心查询：获取所有线路及其车站（使用投影接口） 注意：SELECT中的别名必须和投影接口的方法名匹配（去掉get，首字母小写）
     */
    @Query("""
            SELECT
                l.lineCode as lineCode,
                l.description as lineDescription,
                s.stationCode as stationCode,
                s.description as stationDescription,
                lr.sequenceOrder as sequenceOrder
            FROM LineEntity l
            JOIN LineRouteEntity lr ON l.id = lr.line.id
            JOIN StationEntity s ON lr.station.id = s.id
            ORDER BY l.lineCode, lr.sequenceOrder
            """)
    List<LineStationProjection> findAllLineStationProjections();

    /**
     * 查询特定线路的车站
     */
    @Query("""
            SELECT
                l.lineCode as lineCode,
                l.description as lineDescription,
                s.stationCode as stationCode,
                s.description as stationDescription,
                lr.sequenceOrder as sequenceOrder
            FROM LineEntity l
            JOIN LineRouteEntity lr ON l.id = lr.line.id
            JOIN StationEntity s ON lr.station.id = s.id
            WHERE l.lineCode = :lineCode
            ORDER BY lr.sequenceOrder
            """)
    List<LineStationProjection> findLineStationProjectionsByLineCode(@Param("lineCode") String lineCode);

}
