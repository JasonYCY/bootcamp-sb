package com.bootcamp.demo.demo_thymeleaf.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinData;
import com.bootcamp.demo.demo_thymeleaf.service.impl.ApiServiceImpl;



@Controller
public class HelloWorldController {
  @Autowired
  private ApiServiceImpl apiService;

  @GetMapping("/helloworld")
  public String hello(Model model) {
    model.addAttribute("message", "test");
    return "hello"; // // Thymeleaf template name (hello.html)
  }
  

  @GetMapping("/coin-data")
  public String displayCoinData(Model model) {
    List<CoinData> coinDataList = apiService.fetchCoinDataMock();
    model.addAttribute("coinList", coinDataList);
    return "coindata"; // Thymeleaf template name (coindata.html)
  }


  @GetMapping("/external-data")
  public String displayExternalData(Model model) {
    List<CoinData> coinDataList = apiService.fetchCoinDataMock();
    // coinDataList.sort((e1, e2) -> (int) (e2.getMarketCap() - e1.getMarketCap()));
    model.addAttribute("coinDataList", coinDataList);
    return "externaldata"; // Thymeleaf template name (coindata.html)
  }


  @GetMapping("/exercise")
  public String displayExercise(Model model) {
    List<CoinData> coinDataList = apiService.fetchCoinDataMock();
    model.addAttribute("coinDataList", coinDataList);
    return "exercise"; // Thymeleaf template name (exercise.html)
  }
  
  
  
}
