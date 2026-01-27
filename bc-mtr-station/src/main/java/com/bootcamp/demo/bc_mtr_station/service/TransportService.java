package com.bootcamp.demo.bc_mtr_station.service;

import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO;

public interface TransportService {
  
  NextTrainDTO getNextTrainSchedule(String line, String sta);



}
