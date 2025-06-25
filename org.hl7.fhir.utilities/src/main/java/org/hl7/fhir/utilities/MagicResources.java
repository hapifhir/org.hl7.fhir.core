package org.hl7.fhir.utilities;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.exceptions.FHIRException;

public class MagicResources {

  public static byte[] spdxCodesAsData() throws IOException {
    ClassLoader classLoader = MagicResources.class.getClassLoader();
    InputStream help = classLoader.getResourceAsStream("spdx.json");
    return FileUtilities.streamToBytes(help);
  }

  public static CSVReader loadLanguagesCSV() throws FHIRException, IOException {
    ClassLoader classLoader = MagicResources.class.getClassLoader();
    InputStream source = classLoader.getResourceAsStream("languages.csv");
    return new CSVReader(source);
  }
  
  
}
