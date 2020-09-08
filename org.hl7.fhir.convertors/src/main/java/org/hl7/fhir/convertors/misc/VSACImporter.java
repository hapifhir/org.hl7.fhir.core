package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Element;

import java.io.*;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VSACImporter extends OIDBasedValueSetImporter {

  public static void main(String[] args) throws FileNotFoundException, FHIRException, IOException, ParseException, URISyntaxException {
//    new PhinVadsImporter().importValueSet(TextFile.fileToBytes("C:\\work\\org.hl7.fhir\\packages\\us.cdc.phinvads-source\\source\\PHVS_BirthDefectsLateralityatDiagnosis_HL7_V1.txt"));
    VSACImporter self = new VSACImporter();
    self.process(args[0], args[1], args[2], args[3]);
  }

  public VSACImporter() throws FileNotFoundException, FHIRException, IOException {
    super();
    init();
  }

  private void process(String source, String dest, String username, String password) throws FHIRException, FileNotFoundException, IOException, URISyntaxException {
    CSVReader csv = new CSVReader(new FileInputStream(source));
    csv.readHeaders();
    FHIRToolingClient client = new FHIRToolingClient("https://cts.nlm.nih.gov/fhir", username, password);
    int i = 0;
    while (csv.line()) {
      String oid = csv.cell("OID");
      try {
        ValueSet vs = client.read(ValueSet.class, oid);
        new JsonParser().compose(new FileOutputStream(Utilities.path(dest, "ValueSet-"+oid+".json")), vs);
        i++;
        if (i % 100 == 0) {
          System.out.println(i);  
        }
      } catch (Exception e) {
        System.out.println("Unable to fetch OID "+oid+": "+e.getMessage());        
      }
    }
    System.out.println("Done. "+i+" ValueSets");
//    for (File f : new File(source).listFiles()) {
//      try {
//        System.out.println("Process " + f.getName());
//        List<ValueSet> vsl = importValueSet(TextFile.fileToBytes(f));
//        for (ValueSet vs : vsl) {
//          if (vs.getId() != null) {
//            new JsonParser().compose(new FileOutputStream(Utilities.path(dest, "ValueSet-" + vs.getId() + ".json")), vs);
//          }
//        }
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    }
  }

//  private List<ValueSet> importValueSet(byte[] source) throws Exception {
//    List<ValueSet> res = new ArrayList<ValueSet>();
//    Element x = loadXml(new ByteArrayInputStream(source)).getDocumentElement();
//    List<Element> vl = XMLUtil.getNamedChildren(x, "DescribedValueSet");
//    for (Element v : vl) {
//      ValueSet vs = new ValueSet();
//      vs.setId(v.getAttribute("ID"));
//      vs.setUrl("http://cts.nlm.nih.gov/fhir/ValueSet/" + vs.getId());
//      vs.getMeta().setSource("https://vsac.nlm.nih.gov/valueset/" + vs.getId() + "/expansion");
//      vs.setVersion(v.getAttribute("version"));
//      vs.setTitle(v.getAttribute("displayName"));
//      vs.setName(Utilities.titleize(vs.getTitle()).replace(" ", ""));
//      Element d = XMLUtil.getNamedChild(v, "Purpose");
//      if (d != null) {
//        vs.setDescription(d.getTextContent());
//      }
//      Element s = XMLUtil.getNamedChild(v, "Status");
//      if (s != null && "Active".equals(s.getTextContent())) {
//        vs.setStatus(PublicationStatus.ACTIVE);
//      } else {
//        vs.setStatus(PublicationStatus.DRAFT);
//      }
//      Element dt = XMLUtil.getNamedChild(v, "RevisionDate");
//      if (dt != null) {
//        vs.getDateElement().setValueAsString(dt.getTextContent());
//      }
//
//      Element cl = XMLUtil.getNamedChild(v, "ConceptList");
//      Element cc = XMLUtil.getFirstChild(cl);
//
//      while (cc != null) {
//        String code = cc.getAttribute("code");
//        String display = cc.getAttribute("displayName");
//        String csoid = cc.getAttribute("codeSystem");
//        String csver = cc.getAttribute("codeSystemVersion");
//        String url = context.oid2Uri(csoid);
//        if (url == null) {
//          url = "urn:oid:" + csoid;
//        }
//        csver = fixVersionforSystem(url, csver);
//        ConceptSetComponent inc = getInclude(vs, url, csver);
//        inc.addConcept().setCode(code).setDisplay(display);
//        cc = XMLUtil.getNextSibling(cc);
//      }
//
//      res.add(vs);
//    }
//    return res;
//  }
}
