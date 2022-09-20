package org.hl7.fhir.convertors.misc.utg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.hl7.fhir.r4.formats.IParser;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Provenance;
import org.hl7.fhir.r4.model.Provenance.ProvenanceAgentComponent;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.utilities.Utilities;

public class UTGCaseSensitivePopulator {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    new UTGCaseSensitivePopulator().process(new File(args[0]));

  }

  private void process(File root) throws FileNotFoundException, IOException {
    Bundle bundle = new Bundle();
    bundle.setType(BundleType.COLLECTION);
    bundle.setId("hxutg1-1-0-12");
    
    scanFolders(root, bundle);
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(root.getAbsolutePath(), "input", "sourceOfTruth", "history", "utgrel1hx-1-0-12.json")), bundle);
    System.out.println("Done");
  }

  private void scanFolders(File folder, Bundle bundle) throws FileNotFoundException, IOException {
    Calendar today = Calendar.getInstance();
    Date dt = today.getTime();
    today.set(Calendar.HOUR_OF_DAY, 0);
    Date d = today.getTime();
    System.out.println("Scan "+folder.getAbsolutePath());
        
    for (File f : folder.listFiles()) {
      if (f.isDirectory() && !f.getName().equals("retired")) {
        scanFolders(f, bundle);
      } else if (f.getName().endsWith(".xml")) {
        processFile(f, bundle, new XmlParser(), d, dt);
      } else if (f.getName().endsWith(".json")) {
        processFile(f, bundle, new JsonParser(), d, dt);
      }
    }
    
  }

  private void processFile(File f, Bundle bundle, IParser parser, Date d, Date dt) {
    try {
      Resource r = parser.parse(new FileInputStream(f));
      if (r instanceof CodeSystem) {
        if (processCodeSystem((CodeSystem) r, bundle, d, dt)) {
          parser.setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), r);
        }
      }
    } catch (Exception e) {
    }
    
  }

  private boolean processCodeSystem(CodeSystem cs, Bundle bundle, Date d, Date dt) {
    if (cs.hasCaseSensitive()) {
      return false;
    }
    if (!cs.getUrl().startsWith("http://terminology.hl7.org") || cs.getContent() == CodeSystemContentMode.NOTPRESENT) {
      return false;
    }
    cs.setCaseSensitive(true);
    Provenance p = new Provenance();
    p.setId("cs-286-"+cs.getId());
    p.addTarget().setReference("CodeSystem/"+cs.getId());
    p.setOccurred(new Period());
    p.getOccurredPeriod().setEnd(d);
    p.setRecorded(dt);
    p.addReason().setText("Populate Missing caseSensitive property;UP-286").addCoding().setSystem("http://terminology.hl7.org/CodeSystem/v3-ActReason").setCode("METAMGT");
    p.getActivity().addCoding().setSystem("http://terminology.hl7.org/CodeSystem/v3-DataOperation").setCode("UPDATE");
    ProvenanceAgentComponent agent = p.addAgent();
    agent.getType().addCoding().setSystem("http://terminology.hl7.org/CodeSystem/provenance-participant-type").setCode("author");
    agent.getWho().setDisplay("Grahame Grieve");
    agent = p.addAgent();
    agent.getType().addCoding().setSystem("http://terminology.hl7.org/CodeSystem/provenance-participant-type").setCode("custodian");
    agent.getWho().setDisplay("Vocabulary WG");
    
    bundle.addEntry().setFullUrl("http://terminology.hl7.org/fhir/Provenance/cs-286-"+cs.getId()).setResource(p);
    
    return true;
  }

}
