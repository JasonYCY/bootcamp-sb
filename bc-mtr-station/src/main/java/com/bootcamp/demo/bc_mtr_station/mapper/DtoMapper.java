package com.bootcamp.demo.bc_mtr_station.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_mtr_station.dto.StationDto;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;

@Component
public class DtoMapper {
  public StationDto toStationDto(StationEntity stationEntity) {
    return StationDto.builder()
      .id(stationEntity.getId())
      .station_code(stationEntity.getStationCode())
      .description(stationEntity.getDescription())
      .build();
  }

}
