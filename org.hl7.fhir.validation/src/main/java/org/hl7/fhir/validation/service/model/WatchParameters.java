package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.validation.service.ValidatorWatchMode;

import java.util.Objects;

@Deprecated(since="2025-11-07")
public class WatchParameters {
  @JsonProperty("watchMode")
  @SerializedName("watchMode")
  private ValidatorWatchMode watchMode = ValidatorWatchMode.NONE;

  @JsonProperty("watchScanDelay")
  @SerializedName("watchScanDelay")
  private int watchScanDelay = 1000;

  @JsonProperty("watchSettleTime")
  @SerializedName("watchSettleTime")
  private int watchSettleTime = 100;

  @SerializedName("watchMode")
  @JsonProperty("watchMode")
  public ValidatorWatchMode getWatchMode() {
    return watchMode;
  }

  @SerializedName("watchMode")
  @JsonProperty("watchMode")
  public WatchParameters setWatchMode(ValidatorWatchMode watchMode) {
    this.watchMode = watchMode;
    return this;
  }

  @SerializedName("watchScanDelay")
  @JsonProperty("watchScanDelay")
  public int getWatchScanDelay() {
    return watchScanDelay;
  }

  @SerializedName("watchScanDelay")
  @JsonProperty("watchScanDelay")
  public WatchParameters setWatchScanDelay(int watchScanDelay) {
    this.watchScanDelay = watchScanDelay;
    return this;
  }

  @SerializedName("watchSettleTime")
  @JsonProperty("watchSettleTime")
  public int getWatchSettleTime() {
    return watchSettleTime;
  }

  @SerializedName("watchSettleTime")
  @JsonProperty("watchSettleTime")
  public WatchParameters setWatchSettleTime(int watchSettleTime) {
    this.watchSettleTime = watchSettleTime;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WatchParameters that = (WatchParameters) o;
    return watchScanDelay == that.watchScanDelay
      && watchSettleTime == that.watchSettleTime
      && watchMode == that.watchMode;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      watchMode,
      watchScanDelay,
      watchSettleTime);
  }

  @Override
  public String toString() {
    return "WatchParameters{" +
      "watchMode=" + watchMode +
      ", watchScanDelay=" + watchScanDelay +
      ", watchSettleTime=" + watchSettleTime +
      "}";
  }
}
