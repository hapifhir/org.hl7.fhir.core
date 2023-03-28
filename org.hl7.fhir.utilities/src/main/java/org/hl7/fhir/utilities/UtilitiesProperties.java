package org.hl7.fhir.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class UtilitiesProperties {

  Properties properties = null;

  public static final String PROPERTY_FILE_NAME = "hl7.core.utilities.properties";

  private Properties getProperties() {
    if (properties == null)
      properties = new Properties();
    InputStream stream = getClass().getClassLoader().getSystemResourceAsStream(PROPERTY_FILE_NAME);
    if (stream != null) {
      try {
        properties.load(stream);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return properties;
  }

  private static final String I_PACKAGE_PROVIDER_CLASSNAME = "hl7.core.utilities.iPackageProvider.classname";


  public String getIPackageProviderClassName() {
    return getProperties().getProperty(I_PACKAGE_PROVIDER_CLASSNAME);
  }
}