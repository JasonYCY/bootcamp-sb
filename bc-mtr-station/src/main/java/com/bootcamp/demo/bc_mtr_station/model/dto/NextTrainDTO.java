package com.bootcamp.demo.bc_mtr_station.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NextTrainDTO {

  @JsonProperty("sys_time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime systemTime;

  @JsonProperty("curr_time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currentTime;

  private Map<String, LineStationSchedule> data;

  @JsonProperty("isdelay")
  private String isDelay;

  private Integer status;
  private String message;

  @Data
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class LineStationSchedule {

    @JsonProperty("curr_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime scheduleCurrentTime;

    @JsonProperty("sys_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime scheduleSystemTime;

    @JsonProperty("UP")
    private List<TrainArrival> upTrains;

    @JsonProperty("DOWN")
    private List<TrainArrival> downTrains;
  }

  @Data
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class TrainArrival {

    @JsonProperty("seq")
    private String sequence;

    @JsonProperty("dest")
    private String destination;

    @JsonProperty("plat")
    private String platform;

    @JsonProperty("time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalTime;

    @JsonProperty("ttnt")
    private String timeToNextTrain;

    @JsonProperty("valid")
    private String isValid;

    @JsonProperty("source")
    private String source;
  }



}
