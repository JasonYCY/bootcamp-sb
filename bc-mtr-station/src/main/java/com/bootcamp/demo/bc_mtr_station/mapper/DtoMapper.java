package com.bootcamp.demo.bc_mtr_station.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_mtr_station.dto.StationDto;
import com.bootcamp.demo.bc_mtr_station.dto.TrainDto;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO.TrainArrival;

@Component
public class DtoMapper {
  @Autowired
  private DateMapper dateMapper;

  public StationDto toStationDto(StationEntity stationEntity) {
    return StationDto.builder()
      .id(stationEntity.getId())
      .station_code(stationEntity.getStationCode())
      .description(stationEntity.getDescription())
      .build();
  }

  public TrainDto toTrainDto(TrainArrival trainArrival, String direction) {
    return TrainDto.builder()
      .destination(trainArrival.getDestination())
      .arrivalTime(dateMapper.mapToString(trainArrival.getArrivalTime()))
      .direction(direction)
      .build();
  }

}
