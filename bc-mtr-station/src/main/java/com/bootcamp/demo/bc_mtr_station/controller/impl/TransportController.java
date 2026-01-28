package com.bootcamp.demo.bc_mtr_station.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_mtr_station.controller.TransportOperation;
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



}
