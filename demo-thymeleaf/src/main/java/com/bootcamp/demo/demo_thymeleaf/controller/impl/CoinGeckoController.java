package com.bootcamp.demo.demo_thymeleaf.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_thymeleaf.controller.CoinGeckoOperation;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinData;
import com.bootcamp.demo.demo_thymeleaf.service.ApiService;


@RestController
public class CoinGeckoController implements CoinGeckoOperation {
  @Autowired
  private ApiService apiService;

  @Override
  public List<CoinData> getMarket() {
      return apiService.fetchCoinData();
  }

  @Override
  public List<CoinData> getMarketMock() {
    return apiService.fetchCoinDataMock();
  }
  



}
