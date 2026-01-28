package com.bootcamp.demo.bc_mtr_station.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.bc_mtr_station.dto.EarliestTrainsDto;
import com.bootcamp.demo.bc_mtr_station.dto.LineWithStationsDto;
import com.bootcamp.demo.bc_mtr_station.dto.StationDetailDto;
import com.bootcamp.demo.bc_mtr_station.dto.StationDto;
import com.bootcamp.demo.bc_mtr_station.dto.TrainDto;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.mapper.DtoMapper;
import com.bootcamp.demo.bc_mtr_station.model.dto.NextTrainDTO;
import com.bootcamp.demo.bc_mtr_station.projection.LineStationProjection;
import com.bootcamp.demo.bc_mtr_station.repository.LineRepository;
import com.bootcamp.demo.bc_mtr_station.repository.LineRouteRepository;
import com.bootcamp.demo.bc_mtr_station.repository.StationRepository;
import com.bootcamp.demo.bc_mtr_station.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService {

  @Value(value = "${external-api.hk-mtr.domain}")
  private String domain;

  @Value(value = "${external-api.hk-mtr.schedule.path-segment}")
  private String pathSegment;

  @Value(value = "${external-api.hk-mtr.schedule.path}")
  private String path;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private StationRepository stationRepository;

  @Autowired
  private LineRepository lineRepository;

  @Autowired
  private LineRouteRepository lineRouteRepository;

  @Autowired
  private DtoMapper dtoMapper;



  private NextTrainDTO callMtrApi(String lineCode, String stationCode) {
    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.put("line", List.of(lineCode));
    paramMap.put("sta", List.of(stationCode));

    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(this.domain)
      .pathSegment(this.pathSegment)
      .path(this.path)
      .queryParams(paramMap)
      .build()
      .toUriString();

    return restTemplate.getForObject(url, NextTrainDTO.class);
  }
  
  @Override
  public NextTrainDTO getNextTrainSchedule(String line, String sta) {
    return callMtrApi(line, sta);
  }

  @Override
  public StationDto getStation(String sta) {
    Optional<StationEntity> optionalStation =
        stationRepository.findByStationCode(sta);

    if (optionalStation.isEmpty())
      throw new IllegalArgumentException("Invalid station PathVariable.");
    return dtoMapper.toStationDto(optionalStation.get());
  }

  @Override
  public Map<String, LineWithStationsDto> getAllStationsGroupedByLine() {
    List<LineStationProjection> projections = lineRepository.findAllLineStationProjections();
    Map<String, LineWithStationsDto> result = new LinkedHashMap<>();

    for (LineStationProjection proj : projections) {
      String lineCode = proj.getLineCode();

      LineWithStationsDto lineDto = result.computeIfAbsent(
        lineCode,
        k -> new LineWithStationsDto(proj.getLineCode(), proj.getLineDescription(), new ArrayList<>())
      );

      StationDetailDto station = new StationDetailDto(
        proj.getStationCode(),
        proj.getStationDescription(),
        proj.getSequenceOrder()
      );

      lineDto.addStation(station);
    }

    return result;
  }

  @Override
  public LineWithStationsDto getStationsByLine(String line) {
    if (!lineRepository.existsByLineCode(line)) {
      throw new IllegalArgumentException("Line '" + line + "' not found");
    }
    
    List<LineStationProjection> projections = lineRepository.findLineStationProjectionsByLineCode(line);
    
    if (projections.isEmpty()) {
      return new LineWithStationsDto(line, "", new ArrayList<>());
    }
    
    LineStationProjection first = projections.get(0);
    LineWithStationsDto lineDTO = new LineWithStationsDto(
      first.getLineCode(),
      first.getLineDescription(),
      new ArrayList<>()
    );
    
    for (LineStationProjection proj : projections) {
      StationDetailDto station = new StationDetailDto(
        proj.getStationCode(),
        proj.getStationDescription(),
        proj.getSequenceOrder()
      );
      lineDTO.addStation(station);
    }
    
    return lineDTO;
  }

  @Override
  public EarliestTrainsDto getEarliestTrains(String stationCode) {
    List<String> lineCodes = lineRouteRepository.findLineCodesByStationCode(stationCode);

    if (lineCodes.isEmpty()) {
      throw new IllegalArgumentException("Station '" + stationCode + "' does not belong to any line or does not exist");
    }

    List<TrainDto> allEarliestTrains = new ArrayList<>();
    LocalDateTime apiCurrTime = null;
    LocalDateTime apiSysTime = null;

    for (String lineCode : lineCodes) {
      NextTrainDTO apiResponse = callMtrApi(lineCode, stationCode);

      if (apiCurrTime == null || apiSysTime == null) {
        apiCurrTime = apiResponse.getCurrentTime();
        apiSysTime = apiResponse.getSystemTime();
      }

      System.out.println("\nTEST - 1: " + apiResponse.getData().get(lineCode + "-" + stationCode).getUpTrains() + "\n");
      System.out.println("\nTEST - 2: " + apiResponse.getData().get(lineCode + "-" + stationCode).getDownTrains() + "\n");
      System.out.println("\nTEST - 3: " + allEarliestTrains + "\n");
    }

    throw new UnsupportedOperationException("This API is still under development!");
  }




}
