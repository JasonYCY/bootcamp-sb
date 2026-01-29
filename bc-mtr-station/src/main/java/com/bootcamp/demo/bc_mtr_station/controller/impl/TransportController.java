package com.bootcamp.demo.bc_mtr_station.controller.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_mtr_station.controller.TransportOperation;
import com.bootcamp.demo.bc_mtr_station.dto.EarliestTrainsDto;
import com.bootcamp.demo.bc_mtr_station.dto.LineSignalDto;
import com.bootcamp.demo.bc_mtr_station.dto.LineWithStationsDto;
import com.bootcamp.demo.bc_mtr_station.dto.StationDto;
import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO;
import com.bootcamp.demo.bc_mtr_station.service.TransportService;

@RestController
public class TransportController implements TransportOperation {

  @Autowired
  private TransportService transportService;

  @Override
  public NextTrainDTO getNextTrainSchedule(String line, String sta) {
    return transportService.getNextTrainSchedule(line, sta);
  }

  @Override
  public StationDto getStation(String sta) {
    return transportService.getStation(sta);
  }

  @Override
  public Map<String, LineWithStationsDto> getAllStationsGroupedByLine() {
    return transportService.getAllStationsGroupedByLine();
  }
  
  @Override
  public LineWithStationsDto getStationsByLine(String line) {
    return transportService.getStationsByLine(line);
  }

  @Override
  public EarliestTrainsDto getEarliestTrainsByStation(String stationCode) {
    return transportService.getEarliestTrains(stationCode);
  }
  
  @Override
  public LineSignalDto getLineSignalByLineCode(String line) {
    return transportService.getLineSignalByLineCode(line);
  }



}
