package com.example.demo.Controller;

import com.example.demo.domain.Stats;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/stats")
public class AppController {

  @Autowired
  private AppService service;
  @PostMapping
  public Stats getStats(@RequestBody BigDecimal[] param){
    return service.get(param);
  }

}
