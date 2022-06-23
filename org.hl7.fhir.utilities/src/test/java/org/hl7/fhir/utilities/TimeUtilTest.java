package org.hl7.fhir.utilities;

import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TimeUtilTest {


  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    List<Arguments> objects = new ArrayList<>();
    objects.add(Arguments.of("PT0.001S", "00:00.001"));
    return objects.stream();
  }

  @ParameterizedTest
  @MethodSource("data")
  public void testPresentDuration(String iso8601String, String expectedPresentation) {
    assertEquals(TimeUtil.presentDuration(Duration.parse(iso8601String).toNanos()), expectedPresentation);
  }


}
