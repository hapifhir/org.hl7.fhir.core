package org.hl7.fhir.convertors.misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.fhir.ucum.Utilities;
import org.hl7.fhir.convertors.misc.CVXImporter.CVXSorter;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.terminologies.CodeSystemUtilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * To use this class, download the CVX definitions from 
 * https://www2a.cdc.gov/vaccines/iis/iisstandards/vaccines.asp?rpt=cvx
 * using the XML-new format, and then execute this class with two parameters:
 * - the name of the downloaded file
 * - a local name for the file https://github.com/FHIR/packages/blob/master/packages/fhir.tx.support.r4/package/CodeSystem-cvx.json
 * 
 * //.Users/grahamegrieve/work/packages/packages/fhir.tx.support.r4/package/CodeSystem-cvx.json
 */

public class CVXImporter {

  public class CVXSorter implements Comparator<ConceptDefinitionComponent> {

    @Override
    public int compare(ConceptDefinitionComponent o1, ConceptDefinitionComponent o2) {
      int i1 = Integer.parseInt(o1.getCode());
      int i2 = Integer.parseInt(o2.getCode());
      return i1-i2;
    }

  }

  public static void main(String[] args) throws FHIRException, FileNotFoundException, IOException, ClassNotFoundException, SQLException, ParserConfigurationException, SAXException {
    new CVXImporter().doUpdate(args[0], args[1]);

  }

  private void doUpdate(String source, String dest) throws FHIRFormatError, FileNotFoundException, IOException, ParserConfigurationException, SAXException {
    CodeSystem cvx = (CodeSystem) new JsonParser().parse(new FileInputStream(dest));
    
    String ldate = null;
    
    Document xml = XMLUtil.parseFileToDom(source);
    Element cvxCodes = xml.getDocumentElement();
    for (Element cvsInfo : XMLUtil.getNamedChildren(cvxCodes, "CVXInfo")) {
      String desc = XMLUtil.getNamedChildText(cvsInfo, "ShortDescription").trim();
      String fullName = XMLUtil.getNamedChildText(cvsInfo, "FullVaccinename").trim();
      String code = XMLUtil.getNamedChildText(cvsInfo, "CVXCode").trim();
      String notes = XMLUtil.getNamedChildText(cvsInfo, "Notes");
      String status = XMLUtil.getNamedChildText(cvsInfo, "Status").trim();
      String date = XMLUtil.getNamedChildText(cvsInfo, "LastUpdated").trim();
      ConceptDefinitionComponent def = findCVXCode(cvx, code);
      if (def == null) {
        def = cvx.addConcept();
        def.setCode(code);
      } else {
        def.getDesignation().clear();
      }
      def.setDisplay(desc);
      def.addDesignation().setValue(fullName).setLanguage("en").setUse(new Coding().setSystem("http://snomed.info/sct").setCode("900000000000013009").setDisplay("Synonym"));
      if (!Utilities.noString(notes)) {
        def.forceProperty("notes").setValue(new StringType(notes.trim()));
      }
      def.forceProperty("vaccine-status").setValue(new CodeType(status.trim()));
      String[] d = date.split("\\/");
      String vdate = d[2]+"-"+Utilities.padLeft(d[0], '0', 2)+"-"+Utilities.padLeft(d[1], '0', 2);
      def.forceProperty("last-updated").setValue(new DateTimeType(vdate));
      if (ldate == null || ldate.compareTo(vdate) < 0) {
        ldate = vdate;
      }
    }
    Collections.sort(cvx.getConcept(), new CVXSorter());
    cvx.setDateElement(new DateTimeType(ldate));
    cvx.setVersion(ldate.replace("-", ""));
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), cvx);
  }

  private ConceptDefinitionComponent findCVXCode(CodeSystem cvx, String code) {
    for (ConceptDefinitionComponent t : cvx.getConcept()) {
      if (code.equals(t.getCode())) {
        return t;
      }
    }
    return null;
  }
}
