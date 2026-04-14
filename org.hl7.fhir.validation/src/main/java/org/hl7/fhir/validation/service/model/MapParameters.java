package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Deprecated(since="2025-11-07")
public class MapParameters {
  @JsonProperty("map")
  @SerializedName("map")
  private String map = null;

  @SerializedName("map")
  @JsonProperty("map")
  public String getMap() {
    return map;
  }

  @SerializedName("map")
  @JsonProperty("map")
  public MapParameters setMap(String map) {
    this.map = map;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MapParameters that = (MapParameters) o;
    return Objects.equals(map, that.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(map);
  }

  @Override
  public String toString() {
    return "MapParameters{" +
      "map='" + map + '\'' +
      '}';
  }
}