package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Stats {
  private final BigDecimal minimum;
  private final BigDecimal maximum;
  private final BigDecimal mean;
  private final BigDecimal median;
  private final BigDecimal standardDeviation;

  public BigDecimal getMinimum() {
    return minimum;
  }
  public BigDecimal getMaximum() {
    return maximum;
  }
  public BigDecimal getMean() {
    return mean;
  }
  public BigDecimal getMedian() {
    return median;
  }
  public BigDecimal getStandardDeviation() {
    return standardDeviation;
  }
  public Stats(BigDecimal minimum, BigDecimal maximum, BigDecimal mean, BigDecimal median, BigDecimal standardDeviation) {
    this.minimum = minimum;
    this.maximum = maximum;
    this.mean = mean;
    this.median = median;
    this.standardDeviation = standardDeviation;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Stats)) {
      return false;
    }
    Stats stats = (Stats) o;
    return getMinimum() == stats.getMinimum() && getMaximum() == stats.getMaximum() && getMean() == stats.getMean() && getMedian() == stats.getMedian()
        && getStandardDeviation() == stats.getStandardDeviation();
  }
  @Override
  public int hashCode() {
    return Objects.hash(getMinimum(), getMaximum(), getMean(), getMedian(), getStandardDeviation());
  }
  @Override
  public String toString() {
    return "Stats{" +
        "minimum=" + minimum +
        ", maximum=" + maximum +
        ", mean=" + mean +
        ", median=" + median +
        ", standardDeviation=" + standardDeviation +
        '}';
  }
}
