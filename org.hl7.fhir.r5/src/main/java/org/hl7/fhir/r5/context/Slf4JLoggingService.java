package org.hl7.fhir.r5.context;

import lombok.RequiredArgsConstructor;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.event.Level;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@MarkedToMoveToAdjunctPackage
public class Slf4JLoggingService implements ILoggingService {

  private final Logger logger;

  static final Map<LogCategory, Marker> markers = new HashMap<>();

  private static Marker getMarker(LogCategory category) {
    return markers.computeIfAbsent(category, c -> {
      String markerName = c.name().toLowerCase();
      return MarkerFactory.getMarker(markerName);
    });
  }

  @Override
  public void logMessage(String message) {
    logger.info(message);
  }

  @Override
  public void logDebugMessage(LogCategory category, String message) {
    logger.makeLoggingEventBuilder(Level.DEBUG)
      .addMarker(getMarker(category))
      .setMessage(message)
      .log();
  }

}
