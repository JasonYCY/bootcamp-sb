package com.bootcamp.demo.demo_thymeleaf.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinData;
import com.bootcamp.demo.demo_thymeleaf.service.ApiService;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Service
public class ApiServiceImpl implements ApiService {
  private static String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";

  @Autowired
  private ObjectMapper objectMapper; // Spring's pre-configured mapper

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinData> fetchCoinData() {
    CoinData[] response = restTemplate.getForObject(apiUrl, CoinData[].class);
    return Arrays.asList(response);
  }

  @Override
  public List<CoinData> fetchCoinDataMock() {
    String json = """
      [
        {
          "id": "bitcoin",
          "symbol": "btc",
          "name": "Bitcoin",
          "image": "https://coin-images.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
          "current_price": 78751,
          "market_cap": 1573669157766,
          "market_cap_rank": 1,
          "fully_diluted_valuation": 1573669157766,
          "total_volume": 63211002000,
          "high_24h": 79131,
          "low_24h": 76579,
          "price_change_24h": 2063.44,
          "price_change_percentage_24h": 2.69072,
          "market_cap_change_24h": 44580944114,
          "market_cap_change_percentage_24h": 2.91552,
          "circulating_supply": 19982656,
          "total_supply": 19982656,
          "max_supply": 21000000,
          "ath": 126080,
          "ath_change_percentage": -37.53902,
          "ath_date": "2025-10-06T18:57:42.558Z",
          "atl": 67.81,
          "atl_change_percentage": 116036.10503,
          "atl_date": "2013-07-06T00:00:00.000Z",
          "roi": null,
          "last_updated": "2026-02-03T07:51:04.352Z"
        },
        {
          "id": "ethereum",
          "symbol": "eth",
          "name": "Ethereum",
          "image": "https://coin-images.coingecko.com/coins/images/279/large/ethereum.png?1696501628",
          "current_price": 2324.82,
          "market_cap": 280664709030,
          "market_cap_rank": 2,
          "fully_diluted_valuation": 280664709030,
          "total_volume": 37530215712,
          "high_24h": 2387.64,
          "low_24h": 2229.15,
          "price_change_24h": 83.67,
          "price_change_percentage_24h": 3.73315,
          "market_cap_change_24h": 10946349348,
          "market_cap_change_percentage_24h": 4.05844,
          "circulating_supply": 120693657.395343,
          "total_supply": 120693657.395343,
          "max_supply": null,
          "ath": 4946.05,
          "ath_change_percentage": -52.99632,
          "ath_date": "2025-08-24T19:21:03.333Z",
          "atl": 0.432979,
          "atl_change_percentage": 536837.27571,
          "atl_date": "2015-10-20T00:00:00.000Z",
          "roi": {
            "times": 38.46588577618936,
            "currency": "btc",
            "percentage": 3846.588577618936
          },
          "last_updated": "2026-02-03T07:51:05.254Z"
        },
        {
          "id": "tether",
          "symbol": "usdt",
          "name": "Tether",
          "image": "https://coin-images.coingecko.com/coins/images/325/large/Tether.png?1696501661",
          "current_price": 0.999108,
          "market_cap": 185191255365,
          "market_cap_rank": 3,
          "fully_diluted_valuation": 190653402063,
          "total_volume": 109110312915,
          "high_24h": 0.999478,
          "low_24h": 0.998804,
          "price_change_24h": 0.00022661,
          "price_change_percentage_24h": 0.02269,
          "market_cap_change_24h": 25565187,
          "market_cap_change_percentage_24h": 0.01381,
          "circulating_supply": 185353670778.6412,
          "total_supply": 190820607858.3862,
          "max_supply": null,
          "ath": 1.32,
          "ath_change_percentage": -24.48615,
          "ath_date": "2018-07-24T00:00:00.000Z",
          "atl": 0.572521,
          "atl_change_percentage": 74.51241,
          "atl_date": "2015-03-02T00:00:00.000Z",
          "roi": null,
          "last_updated": "2026-02-03T07:51:02.916Z"
        }
      ]
      """;

    return objectMapper.readValue(json, new TypeReference<List<CoinData>>() {});
  }
  
}
