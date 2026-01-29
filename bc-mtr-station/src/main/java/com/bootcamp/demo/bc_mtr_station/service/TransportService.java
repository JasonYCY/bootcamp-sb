package com.bootcamp.demo.bc_mtr_station.service;

import java.util.List;
import java.util.Map;
import com.bootcamp.demo.bc_mtr_station.dto.EarliestTrainsDto;
import com.bootcamp.demo.bc_mtr_station.dto.LineSignalDto;
import com.bootcamp.demo.bc_mtr_station.dto.LineWithStationsDto;
import com.bootcamp.demo.bc_mtr_station.dto.StationDto;
import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO;

public interface TransportService {
  
  NextTrainDTO getNextTrainSchedule(String line, String sta);

  StationDto getStation(String sta);

  boolean postStation(String sta, String line, String prev, String next);

  boolean deleteStation(String sta);

  Map<String, LineWithStationsDto> getAllStationsGroupedByLine();

  LineWithStationsDto getStationsByLine(String line);

  EarliestTrainsDto getEarliestTrains(String stationCode);

  LineSignalDto getLineSignalByLineCode(String line);

  List<LineSignalDto> getAllLineSignals();



}
