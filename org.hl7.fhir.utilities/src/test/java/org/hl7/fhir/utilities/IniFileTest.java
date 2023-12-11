package org.hl7.fhir.utilities;



import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IniFileTest {

  public static final String EXPECTED_TIMESTAMP_STRING = "1979-12-31 19:16:40";
  public static final String DUMMY_SECTION = "dummy-section";
  public static final String DUMMY_TIMESTAMP_KEY = "dummyTimestamp";
  public static final String DUMMY_TIMESTAMP_COMMENT = "dummy comment";
  public static final String INTEGER_ONLY_DATETIME_STRING = "19791231191640";
  public static final String INTEGER_ONLY_DATE_TIME_FORMAT = "yyyyMMddHHmmss";

  public ZonedDateTime getDummyInstant() throws ParseException {

    DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

   return ZonedDateTime.parse(EXPECTED_TIMESTAMP_STRING,dtFmt);
  }



  @Test
  public void testZonedDateTime() {
    DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern(INTEGER_ONLY_DATE_TIME_FORMAT);
    LocalDateTime dateTime = LocalDateTime.parse(INTEGER_ONLY_DATETIME_STRING,dtFmt);

  }
  @Test
  public void testSetTimestampPropertyDefaultFormat() throws IOException, ParseException {
    Path testIni = Files.createTempFile("testIni", ".ini");
    IniFile iniFile = new IniFile(testIni.toAbsolutePath().toString());
    ZonedDateTime timestamp = getDummyInstant();
    iniFile.setTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY, timestamp, DUMMY_TIMESTAMP_COMMENT);
    Date date = iniFile.getTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY);

    assertEquals(EXPECTED_TIMESTAMP_STRING, iniFile.getStringProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY));
    assertEquals(Date.from(timestamp.toInstant()).getTime(), date.getTime());

  }


  @Test
  public void voidTestSetTimeStampPropertyExplicitFormat() throws IOException, ParseException {
    Path testIni = Files.createTempFile("testIni", ".ini");
    IniFile iniFile = new IniFile(testIni.toAbsolutePath().toString());
    ZonedDateTime timestamp = getDummyInstant();
    iniFile.setTimeStampFormat(INTEGER_ONLY_DATE_TIME_FORMAT);
    iniFile.setTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY, timestamp, DUMMY_TIMESTAMP_COMMENT);

    Date date = iniFile.getTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY);

    assertEquals(INTEGER_ONLY_DATETIME_STRING, iniFile.getStringProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY));
    assertEquals(Date.from(timestamp.toInstant()).getTime(), date.getTime());
  }


}
