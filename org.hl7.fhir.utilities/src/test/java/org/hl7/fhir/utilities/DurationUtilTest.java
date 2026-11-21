package org.hl7.fhir.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DurationUtilTest {


  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    List<Arguments> objects = new ArrayList<>();
    objects.add(Arguments.of("PT0.001S", "00:00.001"));
    objects.add(Arguments.of("PT0.012S", "00:00.012"));
    objects.add(Arguments.of("PT0.123S", "00:00.123"));
    objects.add(Arguments.of("PT0.999S", "00:00.999"));
    objects.add(Arguments.of("PT1.001S", "00:01.001"));
    objects.add(Arguments.of("PT1M1.001S", "01:01.001"));
    objects.add(Arguments.of("PT59M1.001S", "59:01.001"));
    objects.add(Arguments.of("PT1H1M1.001S", "01:01:01.001"));
    objects.add(Arguments.of("PT23H1M1.001S", "23:01:01.001"));
    objects.add(Arguments.of("P1DT23H1M1.001S", "1d 23:01:01.001"));
    objects.add(Arguments.of("P12DT23H1M1.001S", "12d 23:01:01.001"));
    return objects.stream();
  }

  @ParameterizedTest
  @MethodSource("data")
  public void testPresentDuration(String iso8601String, String expectedPresentation) {
    assertEquals(expectedPresentation, DurationUtil.presentDuration(Duration.parse(iso8601String).toNanos()));
  }


}
