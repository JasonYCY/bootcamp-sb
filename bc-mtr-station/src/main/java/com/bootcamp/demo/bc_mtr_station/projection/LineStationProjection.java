package com.bootcamp.demo.bc_mtr_station.projection;

public interface LineStationProjection {
  String getLineCode();
  String getLineDescription();
  String getStationCode();
  String getStationDescription();  
  Integer getSequenceOrder();

}
