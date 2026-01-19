package com.bootcamp.demo.demo_restful_api.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_restful_api.model.Database;
import com.bootcamp.demo.demo_restful_api.model.NameBox;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


// Restful API
// 1) C -> Create -> POST
// 2) R -> Read -> GET
// 3) U -> Update -> PUT (Replace the entire resource) / PATCH (Update only some fields)
// 4) D -> Delete -> DELETE



@Controller
@ResponseBody
public class NameController {
  // 1) given a name, add the name into the list
  // http://localhost:8080/name/Peter
  @PostMapping("/name")
  public String addToNameList(@RequestBody NameBox nameBox) {
    Database.names.add(nameBox.getName());
    return "Successfully added " + nameBox.getName() + " to the name list!";
  }

  @GetMapping("/name")
  public String getNameByIndex(@RequestParam Integer index) {
    String name = Database.names.get(index);

    if (name == null) {
      return "Name not found for index " + index;
    }
    return name + "Name found at index " + index;
  }
  
  // 2) get all names
  // http://localhost:8080/names
  @GetMapping("/names")
  public List<String> getNameList() {
    return Database.names;
  }
  

}
