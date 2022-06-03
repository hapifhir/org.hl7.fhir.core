package org.hl7.fhir.utilities.tests;

import java.io.InputStream;

public interface ResourceLoaderTests {

  static final String PATH_DELIMITER = "/";

  public default InputStream getResourceAsInputStream(String ... resourcePath) {
    return this.getClass().getClassLoader().getResourceAsStream(String.join(PATH_DELIMITER, resourcePath));
  }
}
