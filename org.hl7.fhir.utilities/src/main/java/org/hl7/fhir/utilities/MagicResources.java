package org.hl7.fhir.utilities;

import java.io.IOException;
import java.io.InputStream;

public class MagicResources {

  public static byte[] spdxCodesAsData() throws IOException {
    ClassLoader classLoader = MagicResources.class.getClassLoader();
    InputStream help = classLoader.getResourceAsStream("spdx.json");
    return TextFile.streamToBytes(help);
  }
  
  
}
