package org.hl7.fhir.validation.cli.logging;

public enum Level {
  TRACE("TRACE"),
  DEBUG("DEBUG"),
  INFO("INFO"),
  WARN("WARN"),
  ERROR("ERROR");

  private final String level;

  Level(String level) {
    this.level = level;
  }

  public String getLevel() {
    return level;
  }

  @Override
  public String toString() {
    return level;
  }
}
