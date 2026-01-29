package com.bootcamp.demo.bc_mtr_station.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_mtr_station.dto.EarliestTrainsDto;
import com.bootcamp.demo.bc_mtr_station.dto.LineSignalDto;
import com.bootcamp.demo.bc_mtr_station.dto.LineWithStationsDto;
import com.bootcamp.demo.bc_mtr_station.dto.ResponseMessageDto;
import com.bootcamp.demo.bc_mtr_station.dto.StationDto;
import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO;

public interface TransportOperation {

  @GetMapping("/mtr/schedule")
  NextTrainDTO getNextTrainSchedule(@RequestParam String line, @RequestParam String sta);

  @GetMapping("/mtr/station/{sta}")
  StationDto getStation(@PathVariable String sta);

  @PostMapping("/mtr/station/{sta}")
  ResponseMessageDto postStation(@PathVariable String sta, @RequestParam String line, @RequestParam String prev, @RequestParam String next);

  @DeleteMapping("/mtr/station/{sta}")
  ResponseMessageDto deleteStation(@PathVariable String sta);

  @GetMapping("/mtr/stations")
  Map<String, LineWithStationsDto> getAllStationsGroupedByLine();

  @GetMapping("/mtr/stations/line/{line}")
  LineWithStationsDto getStationsByLine(@PathVariable String line);

  @GetMapping("/mtr/earliest-trains/{stationCode}")
  EarliestTrainsDto getEarliestTrainsByStation(@PathVariable String stationCode);

  @GetMapping("/line/signal")
  LineSignalDto getLineSignalByLineCode(@RequestParam String line);

  @GetMapping("/line/signals")
  List<LineSignalDto> getAllLineSignals();



}
