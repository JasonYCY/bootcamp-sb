package com.bootcamp.demo.demo_thymeleaf.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinData;

public interface CoinGeckoOperation {
  @GetMapping("/market")
  public List<CoinData> getMarket();

  @GetMapping("/market/mock")
  public List<CoinData> getMarketMock();
  
}
