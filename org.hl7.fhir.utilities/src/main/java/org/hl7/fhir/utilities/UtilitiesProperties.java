package org.hl7.fhir.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilitiesProperties {


  static Properties properties = null;
  private static final String I_PACKAGE_PROVIDER_CLASSNAME = "hl7.core.utilities.iPackageProvider.classname";

  public static final String PROPERTY_FILE_NAME = "hl7.core.utilities.properties";

  private Properties getProperties() {
    if (properties != null) {
      return properties;
    }
    InputStream stream = UtilitiesProperties.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
    if (stream != null) {
      try {
        properties.load(stream);
        stream.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return properties;
  }

  public String getIPackageProviderClassName() {
    return getProperties().getProperty(I_PACKAGE_PROVIDER_CLASSNAME);
  }
}
