package org.hl7.fhir.convertors.misc;


import java.util.Map;
import java.util.HashMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.fhir.ucum.Utilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.utilities.CSVReader;

public class ICFImporter {

  public static void main(String[] args) throws FHIRException, FileNotFoundException, IOException {
    new ICFImporter().doImport(args[0], args[1]);

  }

  private void doImport(String src, String dst) throws FHIRException, FileNotFoundException, IOException {
    CSVReader csv = new CSVReader(new FileInputStream(src));
    csv.setDelimiter('\t');
    csv.readHeaders();

    CodeSystem cs = new CodeSystem();
    cs.setId("icf");
    cs.setUrl("http://id.who.int/icd/release/11/beta/icf");
    cs.setVersion("2023-06");
    cs.setName("WHOICF");
    cs.setTitle("WHO ICF");
    cs.setHierarchyMeaning(CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
    cs.setCopyright("© World Health Organization 2022\r\nSome rights reserved. This work is available under the Creative Commons Attribution-NoDerivatives 3.0 IGO license (CC BY-ND 3.0 IGO further specified at [[https://icd.who.int/en/docs/ICD11-license.pdf]]). \r\nUnder the terms of this license, you may copy and redistribute the work, provided the work is appropriately cited, as indicated below. In any use of this work, there should be no suggestion that WHO endorses any specific organization, products or services. The use of the WHO logo is not permitted. This license does not allow you to produce adaptations of the work (including translations) without permission from WHO.\r\nAny mediation relating to disputes arising under the license shall be conducted in accordance with the mediation rules of the World Intellectual Property Organization.\r\nThis FHIR version of ICD-11 was generated to support the FHIR Community. The definitive version of ICD-11 is available from [[https://icd.who.int/browse11/l-m/en]].\r\n");
    
    cs.addProperty().setCode("icd11-uri").setDescription("Entity URI to map to ICD_11").setType(PropertyType.CODE);
    cs.addProperty().setCode("IsResidual").setDescription("True if the concept is not completely defined by ICD-11").setType(PropertyType.BOOLEAN);
    Map<Integer, ConceptDefinitionComponent> codes = new HashMap<>();
    
    while (csv.line()) {
      String code = csv.cell("Code");
      if (!Utilities.noString(code)) {
        ConceptDefinitionComponent c = new ConceptDefinitionComponent();  
        c.setCode(code);
        c.setDisplay(fixDisplay(csv.cell("Title")));
        c.addProperty().setCode("uri").setValue(new CodeType(csv.cell("Linearization (release) URI")));
        String b = csv.cell("IsResidual").toLowerCase();
        if (!"false".equals(b)) {
          c.addProperty().setCode("IsResidual").setValue(new BooleanType(b));
        }
        Integer level = Integer.parseInt(csv.cell("DepthInKind"));
        if (level == 1) {
          cs.getConcept().add(c);
        } else {
          ConceptDefinitionComponent p = codes.get(level -1);
          p.getConcept().add(c);
        }
        codes.put(level, c);
        for (int i = level + 1; i < 100; i++) {
          if (codes.containsKey(i)) {
            codes.remove(i);
          }
        }
      }
      
    }
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dst), cs); 
  }
//
//  private String processLink(String cell) {
//    String[] p = cell.split("\\\"\\\"");
//    return p[1];
//  }

  private String fixDisplay(String cell) {
    int i = 0;
    while (i < cell.length() && (cell.charAt(i) == ' ' || cell.charAt(i) == '-')) {
      i++;
    }
    return cell.substring(i);
  }

}
