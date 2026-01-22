package com.bootcamp.demo.demo_external_api.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_external_api.controller.CatOperation;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@RestController
public class CatController implements CatOperation {
  @Autowired
  JsonPlaceHolderService jsonPlaceHolderService;

  @Override
  public Cat getSuperCat() {
    return jsonPlaceHolderService.getSuperCat();
  }



}
