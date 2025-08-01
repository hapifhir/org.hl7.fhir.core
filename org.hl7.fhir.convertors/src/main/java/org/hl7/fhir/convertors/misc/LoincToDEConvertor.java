package org.hl7.fhir.convertors.misc;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.InstantType;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

/**
 * This class converts the LOINC XML representation that the FHIR build tool uses internally to a set of DataElements in an atom feed
 * 
 * @author Grahame
 *
 */
@Slf4j
public class LoincToDEConvertor {

  @SuppressWarnings("checkstyle:systemout")
	public static void main(String[] args) throws FHIRFormatError, IOException, XmlPullParserException, SAXException, ParserConfigurationException {
		if (args.length == 0) {
			System.out.println("FHIR LOINC to CDE convertor. ");
			System.out.println("");
			System.out.println("This tool converts from LOINC to A set of DataElement definitions.");
			System.out.println("");
			System.out.println("Usage: [jar(path?)] [dest] (-defn [definitions]) where: ");
			System.out.println("* [dest] is a file name of the bundle to produce");
			System.out.println("* [definitions] is the file name of a file produced by exporting the main LOINC table from the mdb to XML");
			System.out.println("");
		} else {
			LoincToDEConvertor exe = new LoincToDEConvertor();
			exe.setDest(args[0]);
			for (int i = 1; i < args.length; i++) {
				if (args[i].equals("-defn"))
					exe.setDefinitions(args[i+1]);
			}
			exe.process();
		}

	}

	private String dest;
	private String definitions;
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getDefinitions() {
		return definitions;
	}
	public void setDefinitions(String definitions) {
		this.definitions = definitions;
	}

	private Document xml;
	private Bundle bundle;
	private DateTimeType now;

  public Bundle process(String sourceFile) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
    this.definitions = sourceFile;
    log.info("Begin. Produce Loinc CDEs in "+dest+" from "+definitions);

    loadLoinc();
    log.info("LOINC loaded");

    now = DateTimeType.now();

    bundle = new Bundle();
    bundle.setType(BundleType.COLLECTION);
    bundle.setId("http://hl7.org/fhir/commondataelement/loinc");
    bundle.setMeta(new Meta().setLastUpdatedElement(InstantType.now()));

    processLoincCodes();
    return bundle;
  }
  
	public void process() throws FHIRFormatError, IOException, XmlPullParserException, SAXException, ParserConfigurationException {
    log.info("Begin. Produce Loinc CDEs in "+dest+" from "+definitions);

    loadLoinc();
    log.info("LOINC loaded");

    now = DateTimeType.now();

		bundle = new Bundle();
		bundle.setId("http://hl7.org/fhir/commondataelement/loinc");
    bundle.setMeta(new Meta().setLastUpdatedElement(InstantType.now()));

		processLoincCodes();
		if (dest != null) {
      log.info("Saving...");

      saveBundle();
		}
    log.info("Done");

  }

  private void loadLoinc() throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = XMLUtil.newXXEProtectedDocumentBuilderFactory();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		xml = builder.parse(ManagedFileAccess.inStream(definitions)); 
	}

	private void saveBundle() throws FHIRFormatError, IOException, XmlPullParserException {
		XmlParser xml = new XmlParser();
		FileOutputStream s = ManagedFileAccess.outStream(dest);
    xml.compose(s, bundle, true);
    s.close();
	}

	private String col(Element row, String name) {
		Element e = XMLUtil.getNamedChild(row, name);
		if (e == null)
			return null;
		String text = e.getTextContent();
		return text;
	}

	private boolean hasCol(Element row, String name) {
		return Utilities.noString(col(row, name));
	}


  /*
 The following prints to both log and System to track progress. Ideally, this should be done with a more generic
 progress tracking class.
 */
  @SuppressWarnings("checkstyle:systemout")
	private void processLoincCodes() {
		Element row = XMLUtil.getFirstChild(xml.getDocumentElement());
		int i = 0;
		while (row != null) {
			i++;
			if (i % 1000 == 0)
        log.debug("Processed {} LOINC codes", i);
				System.out.print(".");
				String code = col(row, "LOINC_NUM");
				String comp = col(row, "COMPONENT");
//				DataElement de = new DataElement();
//				de.setId("loinc-"+code);
//		    de.setMeta(new Meta().setLastUpdatedElement(InstantType.now()));
//				bundle.getEntry().add(new BundleEntryComponent().setResource(de));
//				Identifier id = new Identifier();
//				id.setSystem("http://hl7.org/fhir/commondataelement/loinc");
//				id.setValue(code);
//				de.addIdentifier(id);
//				de.setPublisher("Regenstrief + FHIR Project Team");
//				if (!col(row, "STATUS").equals("ACTIVE"))
//	 				de.setStatus(PublicationStatus.DRAFT); // till we get good at this
//				else
//					de.setStatus(PublicationStatus.RETIRED);
//				de.setDateElement(DateTimeType.now());
//				de.setName(comp);
//				ElementDefinition dee = de.addElement();
//
//				// PROPERTY	ignore
//				// TIME_ASPCT	
//				// SYSTEM	
//				// SCALE_TYP	
//				// METHOD_TYP	
//				// dee.getCategory().add(new CodeableConcept().setText(col(row, "CLASS")));
//				// SOURCE	
//				// DATE_LAST_CHANGED - should be in ?	
//				// CHNG_TYPE	
//				dee.setComment(col(row , "COMMENTS"));
//				if (hasCol(row, "CONSUMER_NAME"))
//					dee.addAlias(col(row, "CONSUMER_NAME"));	
//				// MOLAR_MASS	
//				// CLASSTYPE	
//				// FORMULA	
//				// SPECIES	
//				// EXMPL_ANSWERS	
//				// ACSSYM	
//				// BASE_NAME - ? this is a relationship	
//				// NAACCR_ID	
//				// ---------- CODE_TABLE todo	
//				// SURVEY_QUEST_TEXT	
//				// SURVEY_QUEST_SRC	
//				if (hasCol(row, "RELATEDNAMES2")) {
//	        String n = col(row, "RELATEDNAMES2");
//	        for (String s : n.split("\\;")) {
//						if (!Utilities.noString(s))
//							dee.addAlias(s);	
//	        }
//				}
//				dee.addAlias(col(row, "SHORTNAME"));	
//				// ORDER_OBS	
//				// CDISC Code	
//				// HL7_FIELD_SUBFIELD_ID	
//				//  ------------------ EXTERNAL_COPYRIGHT_NOTICE todo	
//				dee.setDefinition(col(row, "LONG_COMMON_NAME"));	
//				// HL7_V2_DATATYPE	
//				String cc = makeType(col(row, "HL7_V3_DATATYPE"), code);
//				if (cc != null)
//				  dee.addType().setCode(cc);	
//				// todo... CURATED_RANGE_AND_UNITS	
//				// todo: DOCUMENT_SECTION	
//				// STATUS_REASON	
//				// STATUS_TEXT	
//				// CHANGE_REASON_PUBLIC	
//				// COMMON_TEST_RANK	
//				// COMMON_ORDER_RANK	
//				// COMMON_SI_TEST_RANK	
//				// HL7_ATTACHMENT_STRUCTURE
//
//				// units:
//				// UNITSREQUIRED	
//				// SUBMITTED_UNITS
//				ExtensionUtilities.setAllowableUnits(dee, makeUnits(col(row, "EXAMPLE_UNITS"), col(row, "EXAMPLE_UCUM_UNITS")));
//				// EXAMPLE_SI_UCUM_UNITS	
			
			row = XMLUtil.getNextSibling(row);
		}
		System.out.println("done");
    log.info("Processing complete");
	}

	private String makeType(String type, String id) {
		if (Utilities.noString(type))
			return null;
		if (type.equals("PQ"))
			return "Quantity";
		else if (type.equals("ED"))
		  return "Attachment";
		else if (type.equals("TS"))
		  return "dateTime";
		else if (type.equals("ST"))
		  return "string";
		else if (type.equals("II"))
		  return "Identifier";
		else if (type.equals("CWE"))
		  return "CodeableConcept";
		else if (type.equals("CD") || type.equals("CO"))
		  return "CodeableConcept";
		else if (type.equals("PN"))
		  return "HumanName";
		else if (type.equals("EN"))
		  return "HumanName";
		else if (type.equals("AD"))
		  return "Address";
		else if (type.equals("BL"))
		  return "boolean";
		else if (type.equals("GTS"))
		  return "Schedule";
		else if (type.equals("INT"))
		  return "integer";
		else if (type.equals("CS"))
		  return "code";
		else if (type.equals("IVL_TS"))
		  return "Period";
		else if (type.equals("MMAT") || type.equals("PRF") || type.equals("TX") || type.equals("DT") || type.equals("FT"))
		  return null;
		else
			throw new Error("unmapped type "+type+" for LOINC code "+id);
	} // 18606-4: MMAT.  18665-0: PRF. 18671-8: TX. 55400-6: DT; 8251-1: FT 

	private CodeableConcept makeUnits(String text, String ucum) {
		if (Utilities.noString(text) && Utilities.noString(ucum))
			return null;
		CodeableConcept cc = new CodeableConcept();
		cc.setText(text);
		cc.getCoding().add(new Coding().setCode(ucum).setSystem("http://unitsofmeasure.org"));
		return cc;
	}
  public Bundle getBundle() {
    return bundle;
  }
}