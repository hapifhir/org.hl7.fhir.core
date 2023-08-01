package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CodeSystem;

public class BigCodeSystemGenerator {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    new BigCodeSystemGenerator().execute(new File("/Users/grahamegrieve/work/test-cases/tx/big/codesystem-big.json"));
  }

  private void execute(File file) throws FHIRFormatError, FileNotFoundException, IOException {
    CodeSystem cs = (CodeSystem) new JsonParser().parse(new FileInputStream(file));
    cs.getConcept().clear();
    for (int i = 1; i <= 2000; i++) {
      cs.addConcept().setCode("code"+i).setDisplay("Display "+i).setDefinition("This is code "+i);
    }
    new JsonParser().compose(new FileOutputStream(file), cs);
    
  }
  
}
