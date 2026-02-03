package com.bootcamp.demo.demo_thymeleaf.service;

import java.util.List;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinData;

public interface ApiService {
  List<CoinData> fetchCoinData();

  List<CoinData> fetchCoinDataMock();
  
}
