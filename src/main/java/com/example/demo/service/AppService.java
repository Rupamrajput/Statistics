package com.example.demo.service;

import com.example.demo.domain.Stats;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

@Service
public class AppService {
  public Stats get(BigDecimal[] arr){
    return new Stats(minimum(arr),maximum(arr),mean(arr),median(arr),standardDeviation(arr));
  }

  private BigDecimal mean(BigDecimal[] arr){
    BigDecimal sum = BigDecimal.ZERO;
    for(BigDecimal x:arr){
      sum= sum.add(x);
    }
    return sum.divide(BigDecimal.valueOf(arr.length));
  }
  private BigDecimal median(BigDecimal[] arr){
    Arrays.sort(arr);
    if(arr.length%2!=0) return arr[arr.length/2];
    else return (arr[arr.length/2].add(arr[arr.length/2-1])).divide(BigDecimal.valueOf(2));
  }

  private BigDecimal minimum(BigDecimal[] arr){
    BigDecimal minimum = BigDecimal.valueOf(Integer.MAX_VALUE);
    for(BigDecimal x : arr){
      minimum = minimum.min(x);
    }
    return minimum;
  }

  private BigDecimal maximum(BigDecimal[] arr){
    BigDecimal maximum = BigDecimal.valueOf(Integer.MIN_VALUE);
    for(BigDecimal x : arr){
      maximum = maximum.max(x);
    }
    return maximum;
  }

  private BigDecimal standardDeviation(BigDecimal[] arr){
    BigDecimal sum = BigDecimal.ZERO;
    BigDecimal standardDeviation = BigDecimal.ZERO;
    BigDecimal res;
    BigDecimal sq;
    for(BigDecimal x:arr){
      sum= sum.add(x);
    }
    for (int i = 0; i < arr.length; i++) {
      standardDeviation
          = standardDeviation.add(arr[i].subtract(mean(arr)).pow(2));
    }
    MathContext mc = new MathContext(7);
    sq = standardDeviation.divide(BigDecimal.valueOf(arr.length));
    res = sq.sqrt(mc);
    return res;
  }


}
