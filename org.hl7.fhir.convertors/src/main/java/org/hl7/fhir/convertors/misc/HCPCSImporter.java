package org.hl7.fhir.convertors.misc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.utilities.Utilities;

public class HCPCSImporter {

  // https://www.cms.gov/medicare/coding-billing/healthcare-common-procedure-system/quarterly-update

  public static void main(String[] args) throws FHIRFormatError, IOException {
    new HCPCSImporter().execute(args[0], args[1], args[2], args[3]);

  }

  private void execute(String source, String version, String date, String dest) throws FileNotFoundException, IOException {
    CodeSystem cs = new CodeSystem();
    cs.setId("hcpcs");
    cs.setUrl("http://www.cms.gov/Medicare/Coding/HCPCSReleaseCodeSets");
    cs.setVersion(version);

    cs.setName("HCPCSLevelII");
    cs.setTitle("Healthcare Common Procedure Coding System (HCPCS) level II alphanumeric codes");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setExperimental(false);
    cs.setDateElement(new DateTimeType(date));
    cs.setPublisher("U.S. Centers for Medicare & Medicaid Services (CMS)");
    ContactDetail cd = cs.addContact();
    cd.setName("U.S. Centers for Medicare & Medicaid Services (CMS)");
    cd.addTelecom().setSystem(ContactPointSystem.URL).setValue("https://www.cms.gov/");
    cd.addTelecom().setSystem(ContactPointSystem.EMAIL).setValue("hcpcs@cms.hhs.gov");
    cs.setDescription("The Level II HCPCS codes, which are established by CMS's Alpha-Numeric Editorial Panel, primarily represent items and supplies and non-physician services not covered by the American Medical Association's Current Procedural Terminology-4 (CPT-4) codes; Medicare, Medicaid, and private health insurers use HCPCS procedure and modifier codes for claims processing.  Level II alphanumeric procedure and modifier codes comprise the A to V range.");
    cs.setCaseSensitive(true);

    cs.addProperty().setCode("seqnum").setType(PropertyType.STRING).setDescription("Code to identify record type");

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(source))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (!Utilities.noString(line.trim())) {
          String code = field(line, 1, 5);
          String shortD = field(line, 92, 119);
          String longD = field(line, 12, 91); 
          String seqNum = field(line, 6, 10); 
          ConceptDefinitionComponent cc = cs.addConcept();
          cc.setCode(code);
          cc.setDisplay(shortD);
          cc.addDesignation().setValue(longD);
          if (!Utilities.noString(seqNum)) {
            cc.addProperty().setCode("seqNum").setValue(new StringType(seqNum));
          }
 
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), cs);
  }

  private String field(String line, int i, int j) {
    return line.substring(i-1, j).trim();
  }
}
