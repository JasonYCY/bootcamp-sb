package com.bootcamp.demo.bc_mtr_station.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO;
import com.bootcamp.demo.bc_mtr_station.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService {
  
  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${external-api.hk-mtr.domain}")
  private String domain;

  @Value(value = "${external-api.hk-mtr.schedule.path-segment}")
  private String pathSegment;

  @Value(value = "${external-api.hk-mtr.schedule.path}")
  private String path;



  @Override
  public NextTrainDTO getNextTrainSchedule(String line, String sta) {
    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.put("line", List.of(line));
    paramMap.put("sta", List.of(sta));
    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(this.domain)
      .pathSegment(this.pathSegment)
      .path(this.path)
      .queryParams(paramMap)
      .build()
      .toUriString();

    NextTrainDTO nextTrainDTO = restTemplate.getForObject(url, NextTrainDTO.class);
    return nextTrainDTO;
  }



}
