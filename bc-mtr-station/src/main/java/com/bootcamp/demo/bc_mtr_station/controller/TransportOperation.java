package com.bootcamp.demo.bc_mtr_station.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO;

public interface TransportOperation {

  @GetMapping("/mtr/schedule")
  NextTrainDTO getNextTrainSchedule(@RequestParam String line, @RequestParam String sta);



}
