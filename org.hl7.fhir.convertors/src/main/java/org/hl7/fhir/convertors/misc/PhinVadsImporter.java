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
import org.hl7.fhir.utilities.cache.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.ToolsVersion;

public class PhinVadsImporter {

  public static void main(String[] args) throws FileNotFoundException, FHIRException, IOException, ParseException {
    PhinVadsImporter self = new PhinVadsImporter();
    self.init();
    self.process(args[0], args[1]);
  }

  private IWorkerContext context;
  
  public PhinVadsImporter() {
    super();
  }

  private void init() throws FileNotFoundException, FHIRException, IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r5.core", "current");
    SimpleWorkerContext ctxt = SimpleWorkerContext.fromPackage(npm);
    ctxt.setAllowLoadingDuplicates(true);
    ctxt.loadFromPackage(pcm.loadPackage("hl7.terminology"), null);
    context = ctxt;
  }

  private void process(String source, String dest) {
    for (File f : new File(source).listFiles()) {
      try {
        System.out.println("Process "+f.getName());
        ValueSet vs = importValueSet(TextFile.fileToBytes(f));
        new JsonParser().compose(new FileOutputStream(Utilities.path(dest, "ValueSet-"+vs.getId()+".json")), vs);
      } catch (Exception e) {
        e.printStackTrace();       
      }
    }    
  }
  
  private ValueSet importValueSet(byte[] source) throws FHIRException, IOException, ParseException {
    // first thing do is split into 2 
    List<byte[]> parts = Utilities.splitBytes(source, "\r\n\r\n".getBytes());
    if (parts.size() != 2) {
      throw new FHIRException("Unable to parse phinvads value set: "+parts.size()+" parts found");
    }
    CSVReader rdr = new CSVReader(new ByteArrayInputStream(parts.get(0)));
    rdr.setDelimiter('\t');
    rdr.readHeaders();
    rdr.line();
    
    ValueSet vs = new ValueSet();
    vs.setId(rdr.cell("Value Set OID"));
    vs.setUrl("https://phinvads.cdc.gov/fhir/ValueSet/"+vs.getId());
    vs.setVersion(rdr.cell("Value Set Version"));
    vs.setTitle(rdr.cell("Value Set Name"));
    vs.setName(rdr.cell("Value Set Code"));
    vs.setDescription(rdr.cell("Value Set Definition"));
    if ("Published".equals(rdr.cell("Value Set Status"))) {
      vs.setStatus(PublicationStatus.ACTIVE);
    }
    if (rdr.has("VS Last Updated Date")) {
      vs.setDate(new SimpleDateFormat("mm/dd/yyyy").parse(rdr.cell("VS Last Updated Date")));
    }
    
    rdr = new CSVReader(new ByteArrayInputStream(parts.get(1)));
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
      ConceptSetComponent inc = getInclude(vs, url, csver);
      inc.addConcept().setCode(code).setDisplay(display);
    }
    return vs;
  }

  private ConceptSetComponent getInclude(ValueSet vs, String url, String csver) {
    for (ConceptSetComponent t : vs.getCompose().getInclude()) {
      if (t.getSystem().equals(url) && t.getVersion().equals(csver)) {
        return t;
      }
    }
    ConceptSetComponent c = vs.getCompose().addInclude();
    c.setSystem(url);
    c.setVersion(csver);
    return c;
  }

}
