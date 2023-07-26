package org.hl7.fhir.utilities;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IniFileTest {

  public static final String EXPECTED_TIMESTAMP_STRING = "1979-12-31 19:16:40";
  public static final String DUMMY_SECTION = "dummy-section";
  public static final String DUMMY_TIMESTAMP_KEY = "dummyTimestamp";
  public static final String DUMMY_TIMESTAMP_COMMENT = "dummy comment";

  @Test
  public void testSetTimestampPropertyDefaultFormat() throws IOException {
    Path testIni = Files.createTempFile("testIni", ".ini");
    IniFile iniFile = new IniFile(testIni.toAbsolutePath().toString());
    java.sql.Timestamp timestamp = Timestamp.valueOf(EXPECTED_TIMESTAMP_STRING);
    iniFile.setTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY, timestamp, DUMMY_TIMESTAMP_COMMENT);
    Date date = iniFile.getTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY);

    assertEquals(EXPECTED_TIMESTAMP_STRING, iniFile.getStringProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY));
    assertEquals(timestamp.getTime(), date.getTime());

  }

  @Test
  public void voidTestSetTimeStampPropertyExplicitFormat() throws IOException {
    Path testIni = Files.createTempFile("testIni", ".ini");
    IniFile iniFile = new IniFile(testIni.toAbsolutePath().toString());
    java.sql.Timestamp timestamp = Timestamp.valueOf(EXPECTED_TIMESTAMP_STRING);
    iniFile.setTimeStampFormat("yyyyMMddhhmmss");
    iniFile.setTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY, timestamp, DUMMY_TIMESTAMP_COMMENT);

    Date date = iniFile.getTimestampProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY);

    assertEquals("19791231071640", iniFile.getStringProperty(DUMMY_SECTION, DUMMY_TIMESTAMP_KEY));
    assertEquals(timestamp.getTime(), date.getTime());
  }
}
