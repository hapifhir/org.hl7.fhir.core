package org.hl7.fhir.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilitiesPropertiesImpl extends UtilitiesProperties {



  private static final String I_PACKAGE_PROVIDER_CLASSNAME = "hl7.core.utilities.iPackageProvider.classname";

  public static final String PROPERTY_FILE_NAME = "hl7.core.utilities.properties";



  public String getIPackageProviderClassName() {
    return getEnvironmentProperties().getProperty(I_PACKAGE_PROVIDER_CLASSNAME);
  }
}
