package org.hl7.fhir.convertors.misc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;

public class PhinVadsImporter extends OIDBasedValueSetImporter {

  public static void main(String[] args) throws FileNotFoundException, FHIRException, IOException, ParseException {
//    new PhinVadsImporter().importValueSet(TextFile.fileToBytes("C:\\work\\org.hl7.fhir\\packages\\us.cdc.phinvads-source\\source\\PHVS_BirthDefectsLateralityatDiagnosis_HL7_V1.txt"));
    PhinVadsImporter self = new PhinVadsImporter();
    self.process(args[0], args[1]);
  }

  
  public PhinVadsImporter() throws FileNotFoundException, FHIRException, IOException {
    super();
    init();
  }

  private void process(String source, String dest) {
    for (File f : new File(source).listFiles()) {
      try {
        System.out.println("Process "+f.getName());
        ValueSet vs = importValueSet(TextFile.fileToBytes(f));
        if (vs.getId() != null) {
          new JsonParser().compose(new FileOutputStream(Utilities.path(dest, "ValueSet-"+vs.getId()+".json")), vs);
        }
      } catch (Exception e) {
        e.printStackTrace();       
      }
    }    
  }
  
  private ValueSet importValueSet(byte[] source) throws FHIRException, IOException, ParseException {
    // first thing do is split into 2 
    List<byte[]> parts = Utilities.splitBytes(source, "\r\n\r\n".getBytes());
    if (parts.size() < 2) {
      TextFile.bytesToFile(source, "c:\\temp\\phinvads.txt");
      throw new FHIRException("Unable to parse phinvads value set: "+parts.size()+" parts found");
    }
    CSVReader rdr = new CSVReader(new ByteArrayInputStream(parts.get(0)));
    rdr.setDelimiter('\t');
    rdr.setMultiline(true);
    rdr.readHeaders();
    rdr.line();
    
    ValueSet vs = new ValueSet();
    vs.setId(rdr.cell("Value Set OID"));
    vs.setUrl("http://phinvads.cdc.gov/fhir/ValueSet/"+vs.getId());
    vs.getMeta().setSource("https://phinvads.cdc.gov/vads/ViewValueSet.action?oid="+vs.getId());
    vs.setVersion(rdr.cell("Value Set Version"));
    vs.setTitle(rdr.cell("Value Set Name"));
    vs.setName(rdr.cell("Value Set Code"));
    vs.setDescription(rdr.cell("Value Set Definition"));
    if ("Published".equals(rdr.cell("Value Set Status"))) {
      vs.setStatus(PublicationStatus.ACTIVE);
    } else { 
      vs.setStatus(PublicationStatus.DRAFT);
    }
    if (rdr.has("VS Last Updated Date")) {
      vs.setDate(new SimpleDateFormat("mm/dd/yyyy").parse(rdr.cell("VS Last Updated Date")));
    }
    
    rdr = new CSVReader(new ByteArrayInputStream(parts.get(parts.size()-1)));
    rdr.setMultiline(true);
    rdr.setDelimiter('\t');
    rdr.readHeaders();
    while (rdr.line()) {
      String code = rdr.cell("Concept Code");
      String display = rdr.cell("Preferred Concept Name");
      String csoid = rdr.cell("Code System OID");
      String csver = rdr.cell("Code System Version");
      String url = context.oid2Uri(csoid);
      if (url == null) {
        url = "urn:oid:"+csoid;
      }
      csver = fixVersionforSystem(url, csver);
      ConceptSetComponent inc = getInclude(vs, url, csver);
      inc.addConcept().setCode(code).setDisplay(display);
    }
    return vs;
  }

 
}
