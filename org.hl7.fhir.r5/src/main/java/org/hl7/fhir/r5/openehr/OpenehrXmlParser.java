package org.hl7.fhir.r5.openehr;

// generated

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0



import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.formats.*;
import org.xmlpull.v1.*;
import org.hl7.fhir.utilities.xml.IXMLWriter;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.FHIRException;
import java.io.IOException;
import java.util.Enumeration;

public class OpenehrXmlParser extends org.hl7.fhir.r5.formats.XmlParser {

  public OpenehrXmlParser(boolean allowUnknownContent) {
    super();
    setAllowUnknownContent(allowUnknownContent);
  }

  public OpenehrXmlParser(IXMLWriter xml) {
    super();
    this.xml = xml;
  }

  protected ACCESS_CONTROL_SETTINGS parseACCESS_CONTROL_SETTINGS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseACCESS_CONTROL_SETTINGSContent(int eventType, XmlPullParser xpp, ACCESS_CONTROL_SETTINGS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected ACTOR parseACTOR(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "AGENT": return parseAGENT(xpp);
    case "GROUP": return parseGROUP(xpp);
    case "PERSON": return parsePERSON(xpp);
    case "ORGANISATION": return parseORGANISATION(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseACTORContent(int eventType, XmlPullParser xpp, ACTOR res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("languages")) {
      res.getLanguagesList().add(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("roles")) {
      res.getRolesList().add(parsePARTY_REF(xpp));
    } else if (!parsePARTYContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected AUTHORED_RESOURCE parseAUTHORED_RESOURCE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseAUTHORED_RESOURCEContent(int eventType, XmlPullParser xpp, AUTHORED_RESOURCE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("original_language")) {
      res.setOriginal_language(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("is_controlled")) {
      res.setIs_controlledElement(parseBoolean(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("translations")) {
      res.getTranslationsList().add(parseTRANSLATION_DETAILS(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescription(parseRESOURCE_DESCRIPTION(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("revision_history")) {
      res.setRevision_history(parseREVISION_HISTORY(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected Any parseAny(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "EHR": return parseEHR(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseAnyContent(int eventType, XmlPullParser xpp, Any res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected CARE_ENTRY parseCARE_ENTRY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "INSTRUCTION": return parseINSTRUCTION(xpp);
    case "OBSERVATION": return parseOBSERVATION(xpp);
    case "ACTION": return parseACTION(xpp);
    case "EVALUATION": return parseEVALUATION(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseCARE_ENTRYContent(int eventType, XmlPullParser xpp, CARE_ENTRY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("protocol")) {
      res.setProtocol(parseITEM_STRUCTURE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("guideline_id")) {
      res.setGuideline_id(parseOBJECT_REF(xpp));
    } else if (!parseENTRYContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected CONTENT_ITEM parseCONTENT_ITEM(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "SECTION": return parseSECTION(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseCONTENT_ITEMContent(int eventType, XmlPullParser xpp, CONTENT_ITEM res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseLOCATABLEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DATA_STRUCTURE parseDATA_STRUCTURE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "HISTORY": return parseHISTORY(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDATA_STRUCTUREContent(int eventType, XmlPullParser xpp, DATA_STRUCTURE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseLOCATABLEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DATA_VALUE parseDATA_VALUE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "DV-TEXT": return parseDV_TEXT(xpp);
    case "DV-IDENTIFIER": return parseDV_IDENTIFIER(xpp);
    case "DV-BOOLEAN": return parseDV_BOOLEAN(xpp);
    case "DV-PARAGRAPH": return parseDV_PARAGRAPH(xpp);
    case "DV-URI": return parseDV_URI(xpp);
    case "DV-STATE": return parseDV_STATE(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDATA_VALUEContent(int eventType, XmlPullParser xpp, DATA_VALUE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DV_ABSOLUTE_QUANTITY parseDV_ABSOLUTE_QUANTITY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDV_ABSOLUTE_QUANTITYContent(int eventType, XmlPullParser xpp, DV_ABSOLUTE_QUANTITY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseDV_QUANTIFIEDContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DV_AMOUNT parseDV_AMOUNT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "DV-DURATION": return parseDV_DURATION(xpp);
    case "DV-COUNT": return parseDV_COUNT(xpp);
    case "DV-PROPORTION": return parseDV_PROPORTION(xpp);
    case "DV-QUANTITY": return parseDV_QUANTITY(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDV_AMOUNTContent(int eventType, XmlPullParser xpp, DV_AMOUNT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("accuracy_is_percent")) {
      res.setAccuracy_is_percentElement(parseBoolean(xpp));
    } else if (!parseDV_QUANTIFIEDContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DV_ENCAPSULATED parseDV_ENCAPSULATED(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "DV-MULTIMEDIA": return parseDV_MULTIMEDIA(xpp);
    case "DV-PARSABLE": return parseDV_PARSABLE(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDV_ENCAPSULATEDContent(int eventType, XmlPullParser xpp, DV_ENCAPSULATED res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("charset")) {
      res.setCharset(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
      res.setLanguage(parseCODE_PHRASE(xpp));
    } else if (!parseDV_AMOUNTContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DV_ORDERED parseDV_ORDERED(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "DV-DATE-TIME": return parseDV_DATE_TIME(xpp);
    case "DV-TIME": return parseDV_TIME(xpp);
    case "DV-INTERVAL": return parseDV_INTERVAL(xpp);
    case "DV-ORDINAL": return parseDV_ORDINAL(xpp);
    case "DV-SCALE": return parseDV_SCALE(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDV_ORDEREDContent(int eventType, XmlPullParser xpp, DV_ORDERED res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("normal_status")) {
      res.setNormal_status(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("normal_range")) {
      res.setNormal_range(parseDV_INTERVAL(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_reference_ranges")) {
      res.getOther_reference_rangesList().add(parseREFERENCE_RANGE(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DV_QUANTIFIED parseDV_QUANTIFIED(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDV_QUANTIFIEDContent(int eventType, XmlPullParser xpp, DV_QUANTIFIED res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("magnitude_status")) {
      res.setMagnitude_statusElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("accuracy")) {
      res.setAccuracy(parseBase(xpp));
    } else if (!parseDV_ORDEREDContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }
  
  protected DV_TEMPORAL parseDV_TEMPORAL(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "DV-DATE": return parseDV_DATE(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDV_TEMPORALContent(int eventType, XmlPullParser xpp, DV_TEMPORAL res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseDV_ABSOLUTE_QUANTITYContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected DV_TIME_SPECIFICATION parseDV_TIME_SPECIFICATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "DV-GENERAL-TIME-SPECIFICATION": return parseDV_GENERAL_TIME_SPECIFICATION(xpp);
    case "DV-PERIODIC-TIME-SPECIFICATION": return parseDV_PERIODIC_TIME_SPECIFICATION(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseDV_TIME_SPECIFICATIONContent(int eventType, XmlPullParser xpp, DV_TIME_SPECIFICATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("DV_PARSABLE")) {
      res.setDV_PARSABLEElement(parseString(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected ENTRY parseENTRY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "ADMIN-ENTRY": return parseADMIN_ENTRY(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseENTRYContent(int eventType, XmlPullParser xpp, ENTRY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
      res.setLanguage(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encoding")) {
      res.setEncoding(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_participations")) {
      res.getOther_participationsList().add(parsePARTICIPATION(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("workflow_id")) {
      res.setWorkflow_id(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
      res.setSubject(parsePARTY_PROXY(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("provider")) {
      res.setProvider(parsePARTY_PROXY(xpp));
    } else if (!parseCONTENT_ITEMContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected EVENT parseEVENT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "INTERVAL-EVENT": return parseINTERVAL_EVENT(xpp);
    case "POINT-EVENT": return parsePOINT_EVENT(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseEVENTContent(int eventType, XmlPullParser xpp, EVENT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
      res.setTime(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("state")) {
      res.setState(parseITEM_STRUCTURE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
      res.setData(parseAny(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected ITEM_STRUCTURE parseITEM_STRUCTURE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "ITEM-SINGLE": return parseITEM_SINGLE(xpp);
    case "ITEM-TREE": return parseITEM_TREE(xpp);
    case "ITEM-TABLE": return parseITEM_TABLE(xpp);
    case "ITEM-LIST": return parseITEM_LIST(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseITEM_STRUCTUREContent(int eventType, XmlPullParser xpp, ITEM_STRUCTURE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseDATA_STRUCTUREContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected ITEM parseITEM(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "ELEMENT": return parseELEMENT(xpp);
    case "CLUSTER": return parseCLUSTER(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseITEMContent(int eventType, XmlPullParser xpp, ITEM res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseLOCATABLEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected LOCATABLE parseLOCATABLE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "CONTACT": return parseCONTACT(xpp);
    case "EVENT-CONTEXT": return parseEVENT_CONTEXT(xpp);
    case "EHR-STATUS": return parseEHR_STATUS(xpp);
    case "PARTY-IDENTITY": return parsePARTY_IDENTITY(xpp);
    case "ADDRESS": return parseADDRESS(xpp);
    case "COMPOSITION": return parseCOMPOSITION(xpp);
    case "PARTY-RELATIONSHIP": return parsePARTY_RELATIONSHIP(xpp);
    case "CAPABILITY": return parseCAPABILITY(xpp);
    case "EHR-ACCESS": return parseEHR_ACCESS(xpp);
    case "ACTIVITY": return parseACTIVITY(xpp);
    case "FOLDER": return parseFOLDER(xpp);
    case "PARTICIPATION": return parsePARTICIPATION(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseLOCATABLEContent(int eventType, XmlPullParser xpp, LOCATABLE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parsePATHABLEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected OBJECT_ID parseOBJECT_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "TEMPLATE-ID": return parseTEMPLATE_ID(xpp);
    case "ARCHETYPE-ID": return parseARCHETYPE_ID(xpp);
    case "GENERIC-ID": return parseGENERIC_ID(xpp);
    case "TERMINOLOGY-ID": return parseTERMINOLOGY_ID(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseOBJECT_IDContent(int eventType, XmlPullParser xpp, OBJECT_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseUIDContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected PARTY_PROXY parsePARTY_PROXY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "PARTY-SELF": return parsePARTY_SELF(xpp);
    case "PARTY-IDENTIFIED": return parsePARTY_IDENTIFIED(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parsePARTY_PROXYContent(int eventType, XmlPullParser xpp, PARTY_PROXY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("external_ref")) {
      res.setExternal_ref(parsePARTY_REF(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected PARTY parsePARTY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "ROLE": return parseROLE(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parsePARTYContent(int eventType, XmlPullParser xpp, PARTY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identities")) {
      res.getIdentitiesList().add(parsePARTY_IDENTITY(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contacts")) {
      res.setContacts(parseCONTACT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
      res.setDetails(parseITEM_STRUCTURE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reverse_relationships")) {
      res.getReverse_relationshipsList().add(parseLOCATABLE_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relationships")) {
      res.getRelationshipsList().add(parsePARTY_RELATIONSHIP(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected PATHABLE parsePATHABLE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "INSTRUCTION-DETAILS": return parseINSTRUCTION_DETAILS(xpp);
    case "ISM-TRANSITION": return parseISM_TRANSITION(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parsePATHABLEContent(int eventType, XmlPullParser xpp, PATHABLE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setName(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("archetype_node_id")) {
      res.setArchetype_node_idElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uid")) {
      res.setUid(parseUID_BASED_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("links")) {
      res.getLinksList().add(parseLINK(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("archetype_details")) {
      res.setArchetype_details(parseARCHETYPED(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("feeder_audit")) {
      res.setFeeder_audit(parseFEEDER_AUDIT(xpp));
    } else if (!parseAnyContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected UID_BASED_ID parseUID_BASED_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "OBJECT-VERSION-ID": return parseOBJECT_VERSION_ID(xpp);
    case "HIER-OBJECT-ID": return parseHIER_OBJECT_ID(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseUID_BASED_IDContent(int eventType, XmlPullParser xpp, UID_BASED_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseOBJECT_IDContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected UID parseUID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "ISO-OID": return parseISO_OID(xpp);
    case "UUID": return parseUUID(xpp);
    case "INTERNET-ID": return parseINTERNET_ID(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseUIDContent(int eventType, XmlPullParser xpp, UID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected VERSION parseVERSION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String type = xpp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
    switch (type) {
    case "IMPORTED-VERSION": return parseIMPORTED_VERSION(xpp);
    case "ORIGINAL-VERSION": return parseORIGINAL_VERSION(xpp);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected boolean parseVERSIONContent(int eventType, XmlPullParser xpp, VERSION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contribution")) {
      res.setContribution(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("signature")) {
      res.setSignatureElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("commit_audit")) {
      res.setCommit_audit(parseAUDIT_DETAILS(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected ACTION parseACTION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ACTION res = new ACTION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseACTIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseACTIONContent(int eventType, XmlPullParser xpp, ACTION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
      res.setTime(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ism_transition")) {
      res.setIsm_transition(parseISM_TRANSITION(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instruction_details")) {
      res.setInstruction_details(parseINSTRUCTION_DETAILS(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescription(parseITEM_STRUCTURE(xpp));
    } else if (!parseCARE_ENTRYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ACTIVITY parseACTIVITY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ACTIVITY res = new ACTIVITY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseACTIVITYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseACTIVITYContent(int eventType, XmlPullParser xpp, ACTIVITY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("timing")) {
      res.setTiming(parseDV_PARSABLE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("action_archetype_id")) {
      res.setAction_archetype_idElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescription(parseITEM_STRUCTURE(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ADDRESS parseADDRESS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ADDRESS res = new ADDRESS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseADDRESSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseADDRESSContent(int eventType, XmlPullParser xpp, ADDRESS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
      res.setDetails(parseITEM_STRUCTURE(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ADMIN_ENTRY parseADMIN_ENTRY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ADMIN_ENTRY res = new ADMIN_ENTRY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseADMIN_ENTRYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseADMIN_ENTRYContent(int eventType, XmlPullParser xpp, ADMIN_ENTRY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
      res.setData(parseITEM_STRUCTURE(xpp));
    } else if (!parseENTRYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected AGENT parseAGENT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    AGENT res = new AGENT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseAGENTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseAGENTContent(int eventType, XmlPullParser xpp, AGENT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseACTORContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ARCHETYPE_ID parseARCHETYPE_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ARCHETYPE_ID res = new ARCHETYPE_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseARCHETYPE_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseARCHETYPE_IDContent(int eventType, XmlPullParser xpp, ARCHETYPE_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseOBJECT_IDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ARCHETYPED parseARCHETYPED(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ARCHETYPED res = new ARCHETYPED();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseARCHETYPEDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseARCHETYPEDContent(int eventType, XmlPullParser xpp, ARCHETYPED res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("archetype_id")) {
      res.setArchetype_id(parseARCHETYPE_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("template_id")) {
      res.setTemplate_id(parseTEMPLATE_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("rm_version")) {
      res.setRm_versionElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ATTESTATION parseATTESTATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ATTESTATION res = new ATTESTATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseATTESTATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseATTESTATIONContent(int eventType, XmlPullParser xpp, ATTESTATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("attested_view")) {
      res.setAttested_view(parseDV_MULTIMEDIA(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("proof")) {
      res.setProofElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("items")) {
      res.getItemsList().add(parseDV_EHR_URI(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
      res.setReason(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("is_pending")) {
      res.setIs_pendingElement(parseBoolean(xpp));
    } else if (!parseAUDIT_DETAILSContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected AUDIT_DETAILS parseAUDIT_DETAILS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    AUDIT_DETAILS res = new AUDIT_DETAILS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseAUDIT_DETAILSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseAUDIT_DETAILSContent(int eventType, XmlPullParser xpp, AUDIT_DETAILS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system_id")) {
      res.setSystem_idElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time_committed")) {
      res.setTime_committed(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("change_type")) {
      res.setChange_type(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescription(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("committer")) {
      res.setCommitter(parsePARTY_PROXY(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected Annotations parseAnnotations(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    Annotations res = new Annotations();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseAnnotationsContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseAnnotationsContent(int eventType, XmlPullParser xpp, Annotations res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comment")) {
      res.setCommentElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("fhir_mapping")) {
      res.setFhir_mappingElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("vset_description")) {
      res.setVset_descriptionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hl7v2_mapping")) {
      res.setHl7v2_mappingElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("visibleInView")) {
      res.setVisibleInViewElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CAPABILITY parseCAPABILITY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CAPABILITY res = new CAPABILITY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCAPABILITYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCAPABILITYContent(int eventType, XmlPullParser xpp, CAPABILITY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("credentials")) {
      res.setCredentials(parseITEM_STRUCTURE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time_validity")) {
      res.setTime_validity(parseDV_INTERVAL(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CLUSTER parseCLUSTER(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CLUSTER res = new CLUSTER();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCLUSTERContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCLUSTERContent(int eventType, XmlPullParser xpp, CLUSTER res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("items")) {
      res.getItemsList().add(parseITEM(xpp));
    } else if (!parseITEMContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CODE_PHRASE parseCODE_PHRASE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CODE_PHRASE res = new CODE_PHRASE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCODE_PHRASEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCODE_PHRASEContent(int eventType, XmlPullParser xpp, CODE_PHRASE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("terminology_id")) {
      res.setTerminology_id(parseTERMINOLOGY_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code_string")) {
      res.setCode_stringElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("preferred_term")) {
      res.setPreferred_termElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected COMPOSITION parseCOMPOSITION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    COMPOSITION res = new COMPOSITION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCOMPOSITIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCOMPOSITIONContent(int eventType, XmlPullParser xpp, COMPOSITION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
      res.setLanguage(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("territory")) {
      res.setTerritory(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("category")) {
      res.setCategory(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("context")) {
      res.setContext(parseEVENT_CONTEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("composer")) {
      res.setComposer(parsePARTY_PROXY(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
      res.getContentList().add(parseCONTENT_ITEM(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CONTACT parseCONTACT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CONTACT res = new CONTACT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCONTACTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCONTACTContent(int eventType, XmlPullParser xpp, CONTACT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("addresses")) {
      res.getAddressesList().add(parseADDRESS(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time_validity")) {
      res.setTime_validity(parseDV_INTERVAL(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CONTRIBUTION parseCONTRIBUTION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CONTRIBUTION res = new CONTRIBUTION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCONTRIBUTIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCONTRIBUTIONContent(int eventType, XmlPullParser xpp, CONTRIBUTION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uid")) {
      res.setUid(parseHIER_OBJECT_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("versions")) {
      res.getVersionsList().add(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("audit")) {
      res.setAudit(parseAUDIT_DETAILS(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_BOOLEAN parseDV_BOOLEAN(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_BOOLEAN res = new DV_BOOLEAN();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_BOOLEANContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_BOOLEANContent(int eventType, XmlPullParser xpp, DV_BOOLEAN res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseBoolean(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_CODED_TEXT parseDV_CODED_TEXT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_CODED_TEXT res = new DV_CODED_TEXT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_CODED_TEXTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_CODED_TEXTContent(int eventType, XmlPullParser xpp, DV_CODED_TEXT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("defining_code")) {
      res.setDefining_code(parseCODE_PHRASE(xpp));
    } else if (!parseDV_TEXTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_COUNT parseDV_COUNT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_COUNT res = new DV_COUNT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_COUNTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_COUNTContent(int eventType, XmlPullParser xpp, DV_COUNT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("magnitude")) {
      res.setMagnitudeElement(parseDecimal(xpp));
    } else if (!parseDV_AMOUNTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_DATE_TIME parseDV_DATE_TIME(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_DATE_TIME res = new DV_DATE_TIME();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_DATE_TIMEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_DATE_TIMEContent(int eventType, XmlPullParser xpp, DV_DATE_TIME res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseDateTime(xpp));
    } else if (!parseDV_ORDEREDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_DATE parseDV_DATE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_DATE res = new DV_DATE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_DATEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_DATEContent(int eventType, XmlPullParser xpp, DV_DATE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseDateTime(xpp));
    } else if (!parseDV_TEMPORALContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_DURATION parseDV_DURATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_DURATION res = new DV_DURATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_DURATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_DURATIONContent(int eventType, XmlPullParser xpp, DV_DURATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (!parseDV_AMOUNTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_EHR_URI parseDV_EHR_URI(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_EHR_URI res = new DV_EHR_URI();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_EHR_URIContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_EHR_URIContent(int eventType, XmlPullParser xpp, DV_EHR_URI res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseDV_URIContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_GENERAL_TIME_SPECIFICATION parseDV_GENERAL_TIME_SPECIFICATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_GENERAL_TIME_SPECIFICATION res = new DV_GENERAL_TIME_SPECIFICATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_GENERAL_TIME_SPECIFICATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_GENERAL_TIME_SPECIFICATIONContent(int eventType, XmlPullParser xpp, DV_GENERAL_TIME_SPECIFICATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseDV_TIME_SPECIFICATIONContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_IDENTIFIER parseDV_IDENTIFIER(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_IDENTIFIER res = new DV_IDENTIFIER();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_IDENTIFIERContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_IDENTIFIERContent(int eventType, XmlPullParser xpp, DV_IDENTIFIER res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("issuer")) {
      res.setIssuerElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("assigner")) {
      res.setAssignerElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
      res.setIdElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
      res.setTypeElement(parseString(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_INTERVAL parseDV_INTERVAL(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_INTERVAL res = new DV_INTERVAL();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_INTERVALContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_INTERVALContent(int eventType, XmlPullParser xpp, DV_INTERVAL res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseDV_ORDEREDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_MULTIMEDIA parseDV_MULTIMEDIA(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_MULTIMEDIA res = new DV_MULTIMEDIA();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_MULTIMEDIAContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_MULTIMEDIAContent(int eventType, XmlPullParser xpp, DV_MULTIMEDIA res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("alternate_text")) {
      res.setAlternate_textElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uri")) {
      res.setUri(parseDV_URI(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
      res.setDataElement(parseBase64Binary(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("media_type")) {
      res.setMedia_type(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("compression_algorithm")) {
      res.setCompression_algorithm(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("integrity_check")) {
      res.setIntegrity_checkElement(parseBase64Binary(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("integrity_check_algorithm")) {
      res.setIntegrity_check_algorithm(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("thumbnail")) {
      res.setThumbnail(parseDV_MULTIMEDIA(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("size")) {
      res.setSizeElement(parseInteger(xpp));
    } else if (!parseDV_ENCAPSULATEDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_ORDINAL parseDV_ORDINAL(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_ORDINAL res = new DV_ORDINAL();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_ORDINALContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_ORDINALContent(int eventType, XmlPullParser xpp, DV_ORDINAL res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("symbol")) {
      res.setSymbol(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseInteger(xpp));
    } else if (!parseDV_ORDEREDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_PARAGRAPH parseDV_PARAGRAPH(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_PARAGRAPH res = new DV_PARAGRAPH();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_PARAGRAPHContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_PARAGRAPHContent(int eventType, XmlPullParser xpp, DV_PARAGRAPH res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("items")) {
      res.getItemsList().add(parseDV_TEXT(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_PARSABLE parseDV_PARSABLE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_PARSABLE res = new DV_PARSABLE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_PARSABLEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_PARSABLEContent(int eventType, XmlPullParser xpp, DV_PARSABLE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("formalism")) {
      res.setFormalismElement(parseString(xpp));
    } else if (!parseDV_ENCAPSULATEDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_PERIODIC_TIME_SPECIFICATION parseDV_PERIODIC_TIME_SPECIFICATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_PERIODIC_TIME_SPECIFICATION res = new DV_PERIODIC_TIME_SPECIFICATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_PERIODIC_TIME_SPECIFICATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_PERIODIC_TIME_SPECIFICATIONContent(int eventType, XmlPullParser xpp, DV_PERIODIC_TIME_SPECIFICATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseDV_TIME_SPECIFICATIONContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_PROPORTION parseDV_PROPORTION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_PROPORTION res = new DV_PROPORTION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_PROPORTIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_PROPORTIONContent(int eventType, XmlPullParser xpp, DV_PROPORTION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("numerator")) {
      res.setNumeratorElement(parseDecimal(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("denominator")) {
      res.setDenominatorElement(parseDecimal(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
      res.setTypeElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("precision")) {
      res.setPrecisionElement(parseInteger(xpp));
    } else if (!parseDV_AMOUNTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_QUANTITY parseDV_QUANTITY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_QUANTITY res = new DV_QUANTITY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_QUANTITYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_QUANTITYContent(int eventType, XmlPullParser xpp, DV_QUANTITY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("magnitude")) {
      res.setMagnitudeElement(parseDecimal(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("precision")) {
      res.setPrecisionElement(parseInteger(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
      res.setUnitsElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units_system")) {
      res.setUnits_systemElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units_display_name")) {
      res.setUnits_display_nameElement(parseString(xpp));
    } else if (!parseDV_AMOUNTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_SCALE parseDV_SCALE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_SCALE res = new DV_SCALE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_SCALEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_SCALEContent(int eventType, XmlPullParser xpp, DV_SCALE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("symbol")) {
      res.setSymbol(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseDecimal(xpp));
    } else if (!parseDV_ORDEREDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_STATE parseDV_STATE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_STATE res = new DV_STATE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_STATEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_STATEContent(int eventType, XmlPullParser xpp, DV_STATE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValue(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("is_terminal")) {
      res.setIs_terminalElement(parseBoolean(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_TEXT parseDV_TEXT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_TEXT res = new DV_TEXT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_TEXTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_TEXTContent(int eventType, XmlPullParser xpp, DV_TEXT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hyperlink")) {
      res.setHyperlink(parseDV_URI(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("formatting")) {
      res.setFormattingElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mappings")) {
      res.getMappingsList().add(parseTERM_MAPPING(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
      res.setLanguage(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encoding")) {
      res.setEncoding(parseCODE_PHRASE(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_TIME parseDV_TIME(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_TIME res = new DV_TIME();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_TIMEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_TIMEContent(int eventType, XmlPullParser xpp, DV_TIME res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (!parseDV_ORDEREDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected DV_URI parseDV_URI(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DV_URI res = new DV_URI();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseDV_URIContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseDV_URIContent(int eventType, XmlPullParser xpp, DV_URI res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseUri(xpp));
    } else if (!parseDATA_VALUEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected EHR_ACCESS parseEHR_ACCESS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    EHR_ACCESS res = new EHR_ACCESS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseEHR_ACCESSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseEHR_ACCESSContent(int eventType, XmlPullParser xpp, EHR_ACCESS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("settings")) {
      res.setSettings(parseACCESS_CONTROL_SETTINGS(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected EHR_STATUS parseEHR_STATUS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    EHR_STATUS res = new EHR_STATUS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseEHR_STATUSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseEHR_STATUSContent(int eventType, XmlPullParser xpp, EHR_STATUS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
      res.setSubject(parsePARTY_SELF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("is_queryable")) {
      res.setIs_queryableElement(parseBoolean(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("is_modifiable")) {
      res.setIs_modifiableElement(parseBoolean(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_details")) {
      res.setOther_details(parseITEM_STRUCTURE(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected EHR parseEHR(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    EHR res = new EHR();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseEHRContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseEHRContent(int eventType, XmlPullParser xpp, EHR res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system_id")) {
      res.getSystem_idList().add(parseHIER_OBJECT_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ehr_id")) {
      res.setEhr_id(parseHIER_OBJECT_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contributions")) {
      res.getContributionsList().add(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ehr_status")) {
      res.setEhr_status(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ehr_access")) {
      res.setEhr_access(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("compositions")) {
      res.getCompositionsList().add(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("directory")) {
      res.setDirectory(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time_created")) {
      res.setTime_created(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("folders")) {
      res.getFoldersList().add(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("tags")) {
      res.getTagsList().add(parseOBJECT_REF(xpp));
    } else if (!parseAnyContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ELEMENT parseELEMENT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ELEMENT res = new ELEMENT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseELEMENTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseELEMENTContent(int eventType, XmlPullParser xpp, ELEMENT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("null_flavour")) {
      res.setNull_flavour(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValue(parseDATA_VALUE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("null_reason")) {
      res.setNull_reason(parseDV_TEXT(xpp));
    } else if (!parseITEMContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected EVALUATION parseEVALUATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    EVALUATION res = new EVALUATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseEVALUATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseEVALUATIONContent(int eventType, XmlPullParser xpp, EVALUATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
      res.setData(parseITEM_STRUCTURE(xpp));
    } else if (!parseCARE_ENTRYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected EVENT_CONTEXT parseEVENT_CONTEXT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    EVENT_CONTEXT res = new EVENT_CONTEXT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseEVENT_CONTEXTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseEVENT_CONTEXTContent(int eventType, XmlPullParser xpp, EVENT_CONTEXT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("start_time")) {
      res.setStart_time(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("end_time")) {
      res.setEnd_time(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
      res.setLocationElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("setting")) {
      res.setSetting(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_context")) {
      res.setOther_context(parseITEM_STRUCTURE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("health_care_facility")) {
      res.setHealth_care_facility(parsePARTY_IDENTIFIED(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("participations")) {
      res.getParticipationsList().add(parsePARTICIPATION(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected FEEDER_AUDIT_DETAILS parseFEEDER_AUDIT_DETAILS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    FEEDER_AUDIT_DETAILS res = new FEEDER_AUDIT_DETAILS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseFEEDER_AUDIT_DETAILSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseFEEDER_AUDIT_DETAILSContent(int eventType, XmlPullParser xpp, FEEDER_AUDIT_DETAILS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system_id")) {
      res.setSystem_idElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
      res.setLocation(parsePARTY_IDENTIFIED(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
      res.setSubject(parsePARTY_PROXY(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("provider")) {
      res.setProvider(parsePARTY_IDENTIFIED(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
      res.setTime(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version_id")) {
      res.setVersion_idElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_details")) {
      res.setOther_details(parseITEM_STRUCTURE(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected FEEDER_AUDIT parseFEEDER_AUDIT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    FEEDER_AUDIT res = new FEEDER_AUDIT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseFEEDER_AUDITContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseFEEDER_AUDITContent(int eventType, XmlPullParser xpp, FEEDER_AUDIT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("originating_system_item_ids")) {
      res.getOriginating_system_item_idsList().add(parseDV_IDENTIFIER(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("feeder_system_item_ids")) {
      res.getFeeder_system_item_idsList().add(parseDV_IDENTIFIER(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("original_content")) {
      res.setOriginal_content(parseDV_ENCAPSULATED(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("originating_system_audit")) {
      res.setOriginating_system_audit(parseFEEDER_AUDIT_DETAILS(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("feeder_system_audit")) {
      res.setFeeder_system_audit(parseFEEDER_AUDIT_DETAILS(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected FOLDER parseFOLDER(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    FOLDER res = new FOLDER();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseFOLDERContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseFOLDERContent(int eventType, XmlPullParser xpp, FOLDER res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("items")) {
      res.getItemsList().add(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("folders")) {
      res.getFoldersList().add(parseFOLDER(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
      res.setDetails(parseITEM_STRUCTURE(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected GENERIC_ID parseGENERIC_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    GENERIC_ID res = new GENERIC_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseGENERIC_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseGENERIC_IDContent(int eventType, XmlPullParser xpp, GENERIC_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseOBJECT_IDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected GROUP parseGROUP(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    GROUP res = new GROUP();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseGROUPContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseGROUPContent(int eventType, XmlPullParser xpp, GROUP res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseACTORContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected HIER_OBJECT_ID parseHIER_OBJECT_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    HIER_OBJECT_ID res = new HIER_OBJECT_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseHIER_OBJECT_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseHIER_OBJECT_IDContent(int eventType, XmlPullParser xpp, HIER_OBJECT_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseUID_BASED_IDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected HISTORY parseHISTORY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    HISTORY res = new HISTORY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseHISTORYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseHISTORYContent(int eventType, XmlPullParser xpp, HISTORY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("origin")) {
      res.setOrigin(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
      res.setPeriod(parseDV_DURATION(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("duration")) {
      res.setDuration(parseDV_DURATION(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("summary")) {
      res.setSummary(parseITEM_STRUCTURE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("events")) {
      res.getEventsList().add(parseEVENT(xpp));
    } else if (!parseDATA_STRUCTUREContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected IMPORTED_VERSION parseIMPORTED_VERSION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    IMPORTED_VERSION res = new IMPORTED_VERSION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseIMPORTED_VERSIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseIMPORTED_VERSIONContent(int eventType, XmlPullParser xpp, IMPORTED_VERSION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("item")) {
      res.setItem(parseORIGINAL_VERSION(xpp));
    } else if (!parseVERSIONContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected INSTRUCTION_DETAILS parseINSTRUCTION_DETAILS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    INSTRUCTION_DETAILS res = new INSTRUCTION_DETAILS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseINSTRUCTION_DETAILSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseINSTRUCTION_DETAILSContent(int eventType, XmlPullParser xpp, INSTRUCTION_DETAILS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instruction_id")) {
      res.setInstruction_id(parseLOCATABLE_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("activity_id")) {
      res.setActivity_idElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("wf_details")) {
      res.setWf_details(parseITEM_STRUCTURE(xpp));
    } else if (!parsePATHABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected INSTRUCTION parseINSTRUCTION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    INSTRUCTION res = new INSTRUCTION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseINSTRUCTIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseINSTRUCTIONContent(int eventType, XmlPullParser xpp, INSTRUCTION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("narrative")) {
      res.setNarrative(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("expiry_time")) {
      res.setExpiry_time(parseDV_DATE_TIME(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("wf_definition")) {
      res.setWf_definition(parseDV_PARSABLE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("activities")) {
      res.getActivitiesList().add(parseACTIVITY(xpp));
    } else if (!parseCARE_ENTRYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected INTERNET_ID parseINTERNET_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    INTERNET_ID res = new INTERNET_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseINTERNET_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseINTERNET_IDContent(int eventType, XmlPullParser xpp, INTERNET_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseUIDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected INTERVAL_EVENT parseINTERVAL_EVENT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    INTERVAL_EVENT res = new INTERVAL_EVENT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseINTERVAL_EVENTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseINTERVAL_EVENTContent(int eventType, XmlPullParser xpp, INTERVAL_EVENT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("width")) {
      res.setWidth(parseDV_DURATION(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("sample_count")) {
      res.setSample_countElement(parseInteger(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("math_function")) {
      res.setMath_function(parseDV_CODED_TEXT(xpp));
    } else if (!parseEVENTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ISM_TRANSITION parseISM_TRANSITION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ISM_TRANSITION res = new ISM_TRANSITION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseISM_TRANSITIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseISM_TRANSITIONContent(int eventType, XmlPullParser xpp, ISM_TRANSITION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("current_state")) {
      res.setCurrent_state(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("transition")) {
      res.setTransition(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("careflow_step")) {
      res.setCareflow_step(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
      res.getReasonList().add(parseDV_TEXT(xpp));
    } else if (!parsePATHABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ISO_OID parseISO_OID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ISO_OID res = new ISO_OID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseISO_OIDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseISO_OIDContent(int eventType, XmlPullParser xpp, ISO_OID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseUIDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ITEM_LIST parseITEM_LIST(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ITEM_LIST res = new ITEM_LIST();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseITEM_LISTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseITEM_LISTContent(int eventType, XmlPullParser xpp, ITEM_LIST res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("items")) {
      res.getItemsList().add(parseELEMENT(xpp));
    } else if (!parseITEM_STRUCTUREContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ITEM_SINGLE parseITEM_SINGLE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ITEM_SINGLE res = new ITEM_SINGLE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseITEM_SINGLEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseITEM_SINGLEContent(int eventType, XmlPullParser xpp, ITEM_SINGLE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("item")) {
      res.setItem(parseELEMENT(xpp));
    } else if (!parseITEM_STRUCTUREContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ITEM_TABLE parseITEM_TABLE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ITEM_TABLE res = new ITEM_TABLE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseITEM_TABLEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseITEM_TABLEContent(int eventType, XmlPullParser xpp, ITEM_TABLE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("rows")) {
      res.getRowsList().add(parseCLUSTER(xpp));
    } else if (!parseITEM_STRUCTUREContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ITEM_TAG parseITEM_TAG(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ITEM_TAG res = new ITEM_TAG();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseITEM_TAGContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseITEM_TAGContent(int eventType, XmlPullParser xpp, ITEM_TAG res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("key")) {
      res.setKeyElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
      res.setTarget(parseUID_BASED_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target_path")) {
      res.setTarget_pathElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("owner_id")) {
      res.setOwner_id(parseOBJECT_REF(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ITEM_TREE parseITEM_TREE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ITEM_TREE res = new ITEM_TREE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseITEM_TREEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseITEM_TREEContent(int eventType, XmlPullParser xpp, ITEM_TREE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("items")) {
      res.getItemsList().add(parseITEM(xpp));
    } else if (!parseITEM_STRUCTUREContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected LINK parseLINK(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    LINK res = new LINK();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseLINKContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseLINKContent(int eventType, XmlPullParser xpp, LINK res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("meaning")) {
      res.setMeaning(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
      res.setType(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
      res.setTarget(parseDV_EHR_URI(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected LOCATABLE_REF parseLOCATABLE_REF(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    LOCATABLE_REF res = new LOCATABLE_REF();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseLOCATABLE_REFContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseLOCATABLE_REFContent(int eventType, XmlPullParser xpp, LOCATABLE_REF res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("path")) {
      res.setPathElement(parseString(xpp));
    } else if (!parseOBJECT_REFContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected OBJECT_REF parseOBJECT_REF(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    OBJECT_REF res = new OBJECT_REF();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseOBJECT_REFContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseOBJECT_REFContent(int eventType, XmlPullParser xpp, OBJECT_REF res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("namespace")) {
      res.setNamespaceElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
      res.setTypeElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
      res.setId(parseOBJECT_ID(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected OBJECT_VERSION_ID parseOBJECT_VERSION_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    OBJECT_VERSION_ID res = new OBJECT_VERSION_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseOBJECT_VERSION_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseOBJECT_VERSION_IDContent(int eventType, XmlPullParser xpp, OBJECT_VERSION_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseUID_BASED_IDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected OBSERVATION parseOBSERVATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    OBSERVATION res = new OBSERVATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseOBSERVATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseOBSERVATIONContent(int eventType, XmlPullParser xpp, OBSERVATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
      res.setData(parseHISTORY(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("state")) {
      res.setState(parseHISTORY(xpp));
    } else if (!parseCARE_ENTRYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ORGANISATION parseORGANISATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ORGANISATION res = new ORGANISATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseORGANISATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseORGANISATIONContent(int eventType, XmlPullParser xpp, ORGANISATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseACTORContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ORIGINAL_VERSION parseORIGINAL_VERSION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ORIGINAL_VERSION res = new ORIGINAL_VERSION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseORIGINAL_VERSIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseORIGINAL_VERSIONContent(int eventType, XmlPullParser xpp, ORIGINAL_VERSION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uid")) {
      res.setUid(parseOBJECT_VERSION_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("preceding_version_uid")) {
      res.setPreceding_version_uid(parseOBJECT_VERSION_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_input_version_uids")) {
      res.getOther_input_version_uidsList().add(parseOBJECT_VERSION_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lifecycle_state")) {
      res.setLifecycle_state(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("attestations")) {
      res.getAttestationsList().add(parseATTESTATION(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
      res.setData(parseAny(xpp));
    } else if (!parseVERSIONContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PARTICIPATION parsePARTICIPATION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PARTICIPATION res = new PARTICIPATION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePARTICIPATIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePARTICIPATIONContent(int eventType, XmlPullParser xpp, PARTICIPATION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("function")) {
      res.setFunction(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
      res.setMode(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("performer")) {
      res.setPerformer(parsePARTY_PROXY(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
      res.setTime(parseDV_INTERVAL(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PARTY_IDENTIFIED parsePARTY_IDENTIFIED(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PARTY_IDENTIFIED res = new PARTY_IDENTIFIED();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePARTY_IDENTIFIEDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePARTY_IDENTIFIEDContent(int eventType, XmlPullParser xpp, PARTY_IDENTIFIED res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifiers")) {
      res.getIdentifiersList().add(parseDV_IDENTIFIER(xpp));
    } else if (!parsePARTY_PROXYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PARTY_IDENTITY parsePARTY_IDENTITY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PARTY_IDENTITY res = new PARTY_IDENTITY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePARTY_IDENTITYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePARTY_IDENTITYContent(int eventType, XmlPullParser xpp, PARTY_IDENTITY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
      res.setDetails(parseITEM_STRUCTURE(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PARTY_REF parsePARTY_REF(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PARTY_REF res = new PARTY_REF();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePARTY_REFContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePARTY_REFContent(int eventType, XmlPullParser xpp, PARTY_REF res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseOBJECT_REFContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PARTY_RELATED parsePARTY_RELATED(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PARTY_RELATED res = new PARTY_RELATED();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePARTY_RELATEDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePARTY_RELATEDContent(int eventType, XmlPullParser xpp, PARTY_RELATED res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relationship")) {
      res.setRelationship(parseDV_CODED_TEXT(xpp));
    } else if (!parsePARTY_IDENTIFIEDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PARTY_RELATIONSHIP parsePARTY_RELATIONSHIP(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PARTY_RELATIONSHIP res = new PARTY_RELATIONSHIP();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePARTY_RELATIONSHIPContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePARTY_RELATIONSHIPContent(int eventType, XmlPullParser xpp, PARTY_RELATIONSHIP res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
      res.setDetails(parseITEM_STRUCTURE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
      res.setTarget(parsePARTY_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time_validity")) {
      res.setTime_validity(parseDV_INTERVAL(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
      res.setSource(parsePARTY_REF(xpp));
    } else if (!parseLOCATABLEContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PARTY_SELF parsePARTY_SELF(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PARTY_SELF res = new PARTY_SELF();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePARTY_SELFContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePARTY_SELFContent(int eventType, XmlPullParser xpp, PARTY_SELF res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parsePARTY_PROXYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected PERSON parsePERSON(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PERSON res = new PERSON();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePERSONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePERSONContent(int eventType, XmlPullParser xpp, PERSON res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseACTORContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected POINT_EVENT parsePOINT_EVENT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    POINT_EVENT res = new POINT_EVENT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parsePOINT_EVENTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parsePOINT_EVENTContent(int eventType, XmlPullParser xpp, POINT_EVENT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseEVENTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected REFERENCE_RANGE parseREFERENCE_RANGE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    REFERENCE_RANGE res = new REFERENCE_RANGE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseREFERENCE_RANGEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseREFERENCE_RANGEContent(int eventType, XmlPullParser xpp, REFERENCE_RANGE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("meaning")) {
      res.setMeaning(parseDV_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
      res.setRange(parseDV_INTERVAL(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected RESOURCE_DESCRIPTION_ITEM parseRESOURCE_DESCRIPTION_ITEM(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    RESOURCE_DESCRIPTION_ITEM res = new RESOURCE_DESCRIPTION_ITEM();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseRESOURCE_DESCRIPTION_ITEMContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseRESOURCE_DESCRIPTION_ITEMContent(int eventType, XmlPullParser xpp, RESOURCE_DESCRIPTION_ITEM res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
      res.setLanguage(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("purpose")) {
      res.setPurposeElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("keywords")) {
      res.getKeywordsList().add(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
      res.setUseElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("misuse")) {
      res.setMisuseElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("copyright")) {
      res.setCopyrightElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("original_resource_uri")) {
      res.getOriginal_resource_uriList().add(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_details")) {
      res.getOther_detailsList().add(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected RESOURCE_DESCRIPTION parseRESOURCE_DESCRIPTION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    RESOURCE_DESCRIPTION res = new RESOURCE_DESCRIPTION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseRESOURCE_DESCRIPTIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseRESOURCE_DESCRIPTIONContent(int eventType, XmlPullParser xpp, RESOURCE_DESCRIPTION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("original_author")) {
      res.getOriginal_authorList().add(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_contributors")) {
      res.getOther_contributorsList().add(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lifecycle_state")) {
      res.setLifecycle_stateElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource_package_uri")) {
      res.setResource_package_uriElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_details")) {
      res.getOther_detailsList().add(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("parent_resource")) {
      res.setParent_resource(parseAUTHORED_RESOURCE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
      res.getDetailsList().add(parseRESOURCE_DESCRIPTION_ITEM(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected REVISION_HISTORY_ITEM parseREVISION_HISTORY_ITEM(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    REVISION_HISTORY_ITEM res = new REVISION_HISTORY_ITEM();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseREVISION_HISTORY_ITEMContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseREVISION_HISTORY_ITEMContent(int eventType, XmlPullParser xpp, REVISION_HISTORY_ITEM res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version_id")) {
      res.setVersion_id(parseOBJECT_VERSION_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("audits")) {
      res.getAuditsList().add(parseAUDIT_DETAILS(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected REVISION_HISTORY parseREVISION_HISTORY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    REVISION_HISTORY res = new REVISION_HISTORY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseREVISION_HISTORYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseREVISION_HISTORYContent(int eventType, XmlPullParser xpp, REVISION_HISTORY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("most_recent_version")) {
      res.setMost_recent_versionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("most_recent_version_time_committed")) {
      res.setMost_recent_version_time_committedElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected ROLE parseROLE(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    ROLE res = new ROLE();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseROLEContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseROLEContent(int eventType, XmlPullParser xpp, ROLE res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time_validity")) {
      res.setTime_validity(parseDV_INTERVAL(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("performer")) {
      res.setPerformer(parsePARTY_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("capabilities")) {
      res.getCapabilitiesList().add(parseCAPABILITY(xpp));
    } else if (!parsePARTYContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected SECTION parseSECTION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    SECTION res = new SECTION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseSECTIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseSECTIONContent(int eventType, XmlPullParser xpp, SECTION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("items")) {
      res.getItemsList().add(parseCONTENT_ITEM(xpp));
    } else if (!parseCONTENT_ITEMContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TEMPLATE_ID parseTEMPLATE_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TEMPLATE_ID res = new TEMPLATE_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTEMPLATE_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTEMPLATE_IDContent(int eventType, XmlPullParser xpp, TEMPLATE_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseOBJECT_IDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TERM_MAPPING parseTERM_MAPPING(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TERM_MAPPING res = new TERM_MAPPING();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTERM_MAPPINGContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTERM_MAPPINGContent(int eventType, XmlPullParser xpp, TERM_MAPPING res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("match")) {
      res.setMatchElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("purpose")) {
      res.setPurpose(parseDV_CODED_TEXT(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
      res.setTarget(parseCODE_PHRASE(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TERMINOLOGY_ID parseTERMINOLOGY_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TERMINOLOGY_ID res = new TERMINOLOGY_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTERMINOLOGY_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTERMINOLOGY_IDContent(int eventType, XmlPullParser xpp, TERMINOLOGY_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseOBJECT_IDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TRANSLATION_DETAILS parseTRANSLATION_DETAILS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TRANSLATION_DETAILS res = new TRANSLATION_DETAILS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTRANSLATION_DETAILSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTRANSLATION_DETAILSContent(int eventType, XmlPullParser xpp, TRANSLATION_DETAILS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
      res.setLanguage(parseCODE_PHRASE(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
      res.getAuthorList().add(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("accreditation")) {
      res.setAccreditationElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("other_details")) {
      res.getOther_detailsList().add(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TranslatedString parseTranslatedString(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TranslatedString res = new TranslatedString();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTranslatedStringContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTranslatedStringContent(int eventType, XmlPullParser xpp, TranslatedString res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
      res.setLanguageElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected UUID parseUUID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    UUID res = new UUID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseUUIDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseUUIDContent(int eventType, XmlPullParser xpp, UUID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseUIDContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected VERSION_TREE_ID parseVERSION_TREE_ID(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    VERSION_TREE_ID res = new VERSION_TREE_ID();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseVERSION_TREE_IDContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseVERSION_TREE_IDContent(int eventType, XmlPullParser xpp, VERSION_TREE_ID res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected VERSIONED_COMPOSITION parseVERSIONED_COMPOSITION(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    VERSIONED_COMPOSITION res = new VERSIONED_COMPOSITION();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseVERSIONED_COMPOSITIONContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseVERSIONED_COMPOSITIONContent(int eventType, XmlPullParser xpp, VERSIONED_COMPOSITION res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseVERSIONED_OBJECTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected VERSIONED_EHR_ACCESS parseVERSIONED_EHR_ACCESS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    VERSIONED_EHR_ACCESS res = new VERSIONED_EHR_ACCESS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseVERSIONED_EHR_ACCESSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseVERSIONED_EHR_ACCESSContent(int eventType, XmlPullParser xpp, VERSIONED_EHR_ACCESS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseVERSIONED_OBJECTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected VERSIONED_EHR_STATUS parseVERSIONED_EHR_STATUS(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    VERSIONED_EHR_STATUS res = new VERSIONED_EHR_STATUS();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseVERSIONED_EHR_STATUSContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseVERSIONED_EHR_STATUSContent(int eventType, XmlPullParser xpp, VERSIONED_EHR_STATUS res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseVERSIONED_OBJECTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected VERSIONED_FOLDER parseVERSIONED_FOLDER(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    VERSIONED_FOLDER res = new VERSIONED_FOLDER();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseVERSIONED_FOLDERContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseVERSIONED_FOLDERContent(int eventType, XmlPullParser xpp, VERSIONED_FOLDER res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseVERSIONED_OBJECTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected VERSIONED_OBJECT parseVERSIONED_OBJECT(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    VERSIONED_OBJECT res = new VERSIONED_OBJECT();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseVERSIONED_OBJECTContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseVERSIONED_OBJECTContent(int eventType, XmlPullParser xpp, VERSIONED_OBJECT res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uid")) {
      res.setUid(parseHIER_OBJECT_ID(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("owner_id")) {
      res.setOwner_id(parseOBJECT_REF(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time_created")) {
      res.setTime_created(parseDV_DATE_TIME(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected VERSIONED_PARTY parseVERSIONED_PARTY(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    VERSIONED_PARTY res = new VERSIONED_PARTY();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseVERSIONED_PARTYContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseVERSIONED_PARTYContent(int eventType, XmlPullParser xpp, VERSIONED_PARTY res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseVERSIONED_OBJECTContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplate parseWebTemplate(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplate res = new WebTemplate();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateContent(int eventType, XmlPullParser xpp, WebTemplate res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("templateId")) {
      res.setTemplateIdElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
      res.setVersionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("semver")) {
      res.setSemverElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("defaultLanguage")) {
      res.setDefaultLanguageElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("languages")) {
      res.getLanguagesList().add(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("tree")) {
      res.setTree(parseWebTemplateItem(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplateInput parseWebTemplateInput(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplateInput res = new WebTemplateInput();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateInputContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateInputContent(int eventType, XmlPullParser xpp, WebTemplateInput res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("suffix")) {
      res.setSuffixElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
      res.setTypeElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("defaultValue")) {
      res.setDefaultValue(parseNativePrimitive(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("terminology")) {
      res.setTerminologyElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("validation")) {
      res.setValidation(parseWebTemplateInputValidation(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("list")) {
      res.getListList().add(parseWebTemplateInputListItem(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("listOpen")) {
      res.setListOpenElement(parseBoolean(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplateInputListItem parseWebTemplateInputListItem(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplateInputListItem res = new WebTemplateInputListItem();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateInputListItemContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateInputListItemContent(int eventType, XmlPullParser xpp, WebTemplateInputListItem res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("label")) {
      res.setLabelElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ordinal")) {
      res.setOrdinalElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("localizedLabels")) {
      res.getLocalizedLabelsList().add(parseTranslatedString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("localizedDescriptions")) {
      res.getLocalizedDescriptionsList().add(parseTranslatedString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("currentStates")) {
      res.setCurrentStatesElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
      res.setRangeElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("precision")) {
      res.setPrecisionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("termBindings")) {
      res.getTermBindingsList().add(parseWebTemplateTermBinding(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplateInputValidation parseWebTemplateInputValidation(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplateInputValidation res = new WebTemplateInputValidation();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateInputValidationContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateInputValidationContent(int eventType, XmlPullParser xpp, WebTemplateInputValidation res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
      res.setRange(parseWebTemplateInputValidationRange(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("precision")) {
      res.setPrecision(parseWebTemplateInputValidationRange(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplateInputValidationRange parseWebTemplateInputValidationRange(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplateInputValidationRange res = new WebTemplateInputValidationRange();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateInputValidationRangeContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateInputValidationRangeContent(int eventType, XmlPullParser xpp, WebTemplateInputValidationRange res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("minOp")) {
      res.setMinOpElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("min")) {
      res.setMinElement(parseDecimal(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("maxOp")) {
      res.setMaxOpElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("max")) {
      res.setMaxElement(parseDecimal(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplateItem parseWebTemplateItem(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplateItem res = new WebTemplateItem();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateItemContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateItemContent(int eventType, XmlPullParser xpp, WebTemplateItem res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
      res.setIdElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("depth")) {
      res.setDepthElement(parseInteger(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("localizedName")) {
      res.setLocalizedNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("rmType")) {
      res.setRmTypeElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("nodeId")) {
      res.setNodeIdElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("min")) {
      res.setMinElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("max")) {
      res.setMaxElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dependsOn")) {
      res.setDependsOnElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("localizedNames")) {
      res.getLocalizedNamesList().add(parseTranslatedString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("localizedDescriptions")) {
      res.getLocalizedDescriptionsList().add(parseTranslatedString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("annotations")) {
      res.setAnnotations(parseAnnotations(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("archetype_id")) {
      res.setArchetype_idElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("aqlPath")) {
      res.setAqlPathElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("custodian_namespace")) {
      res.setCustodian_namespaceElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("custodian_organisation")) {
      res.setCustodian_organisationElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lifecycleState")) {
      res.setLifecycleStateElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("original_namespace")) {
      res.setOriginal_namespaceElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("original_publisher")) {
      res.setOriginal_publisherElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("proportionTypes")) {
      res.setProportionTypesElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("revision")) {
      res.setRevisionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("inContext")) {
      res.setInContextElement(parseBoolean(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("inputs")) {
      res.getInputsList().add(parseWebTemplateInput(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("termBindings")) {
      res.getTermBindingsList().add(parseWebTemplateTermBinding(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("children")) {
      res.getChildrenList().add(parseWebTemplateItem(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplateTermBinding parseWebTemplateTermBinding(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplateTermBinding res = new WebTemplateTermBinding();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateTermBindingContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateTermBindingContent(int eventType, XmlPullParser xpp, WebTemplateTermBinding res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
      res.setCodeElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValue(parseWebTemplateTermBindingValue(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected WebTemplateTermBindingValue parseWebTemplateTermBindingValue(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    WebTemplateTermBindingValue res = new WebTemplateTermBindingValue();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseWebTemplateTermBindingValueContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseWebTemplateTermBindingValueContent(int eventType, XmlPullParser xpp, WebTemplateTermBindingValue res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("terminologyId")) {
      res.setTerminologyIdElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }


  
  @Override
  protected Resource parseResource(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    if (xpp == null) {
      throw new IOException("xpp == null!");

    } else {
      throw new FHIRFormatError("Unknown resource type "+xpp.getName()+"");
    }
  }

  protected DataType parseType(String prefix, XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    if (prefix == null) {
      throw new IOException("prefix == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (xpp.getName().equals(prefix+"Date")) {
      return parseDate(xpp);
    } else if (xpp.getName().equals(prefix+"DateTime")) {
      return parseDateTime(xpp);
    } else if (xpp.getName().equals(prefix+"Code")) {
      return parseCode(xpp);
    } else if (xpp.getName().equals(prefix+"String")) {
      return parseString(xpp);
    } else if (xpp.getName().equals(prefix+"Integer")) {
      return parseInteger(xpp);
    } else if (xpp.getName().equals(prefix+"Integer64")) {
      return parseInteger64(xpp);
    } else if (xpp.getName().equals(prefix+"Oid")) {
      return parseOid(xpp);
    } else if (xpp.getName().equals(prefix+"Canonical")) {
      return parseCanonical(xpp);
    } else if (xpp.getName().equals(prefix+"Uri")) {
      return parseUri(xpp);
    } else if (xpp.getName().equals(prefix+"Uuid")) {
      return parseUuid(xpp);
    } else if (xpp.getName().equals(prefix+"Url")) {
      return parseUrl(xpp);
    } else if (xpp.getName().equals(prefix+"Instant")) {
      return parseInstant(xpp);
    } else if (xpp.getName().equals(prefix+"Boolean")) {
      return parseBoolean(xpp);
    } else if (xpp.getName().equals(prefix+"Base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (xpp.getName().equals(prefix+"UnsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (xpp.getName().equals(prefix+"Markdown")) {
      return parseMarkdown(xpp);
    } else if (xpp.getName().equals(prefix+"Time")) {
      return parseTime(xpp);
    } else if (xpp.getName().equals(prefix+"Id")) {
      return parseId(xpp);
    } else if (xpp.getName().equals(prefix+"PositiveInt")) {
      return parsePositiveInt(xpp);
    } else if (xpp.getName().equals(prefix+"Decimal")) {
      return parseDecimal(xpp);

    } else {
      throw new FHIRFormatError("Unknown type "+xpp.getName());
    }
  }

  protected DataType parseType(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    if (type == null) {
      throw new IOException("type == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (type.equals("date")) {
      return parseDate(xpp);
    } else if (type.equals("dateTime")) {
      return parseDateTime(xpp);
    } else if (type.equals("code")) {
      return parseCode(xpp);
    } else if (type.equals("string")) {
      return parseString(xpp);
    } else if (type.equals("integer")) {
      return parseInteger(xpp);
    } else if (type.equals("integer64")) {
      return parseInteger64(xpp);
    } else if (type.equals("oid")) {
      return parseOid(xpp);
    } else if (type.equals("canonical")) {
      return parseCanonical(xpp);
    } else if (type.equals("uri")) {
      return parseUri(xpp);
    } else if (type.equals("uuid")) {
      return parseUuid(xpp);
    } else if (type.equals("url")) {
      return parseUrl(xpp);
    } else if (type.equals("instant")) {
      return parseInstant(xpp);
    } else if (type.equals("boolean")) {
      return parseBoolean(xpp);
    } else if (type.equals("base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (type.equals("unsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (type.equals("markdown")) {
      return parseMarkdown(xpp);
    } else if (type.equals("time")) {
      return parseTime(xpp);
    } else if (type.equals("id")) {
      return parseId(xpp);
    } else if (type.equals("positiveInt")) {
      return parsePositiveInt(xpp);
    } else if (type.equals("decimal")) {
      return parseDecimal(xpp);

    } else {
      throw new FHIRFormatError("Unknown type "+type);
    }
  }

  public Base parseFragment(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    if (type == null) {
      throw new IOException("type == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (type.equals("ACTION")) {
      return parseACTION(xpp);
    } else if (type.equals("ACTIVITY")) {
      return parseACTIVITY(xpp);
    } else if (type.equals("ADDRESS")) {
      return parseADDRESS(xpp);
    } else if (type.equals("ADMIN_ENTRY")) {
      return parseADMIN_ENTRY(xpp);
    } else if (type.equals("AGENT")) {
      return parseAGENT(xpp);
    } else if (type.equals("ARCHETYPE_ID")) {
      return parseARCHETYPE_ID(xpp);
    } else if (type.equals("ARCHETYPED")) {
      return parseARCHETYPED(xpp);
    } else if (type.equals("ATTESTATION")) {
      return parseATTESTATION(xpp);
    } else if (type.equals("AUDIT_DETAILS")) {
      return parseAUDIT_DETAILS(xpp);
    } else if (type.equals("Annotations")) {
      return parseAnnotations(xpp);
    } else if (type.equals("CAPABILITY")) {
      return parseCAPABILITY(xpp);
    } else if (type.equals("CLUSTER")) {
      return parseCLUSTER(xpp);
    } else if (type.equals("CODE_PHRASE")) {
      return parseCODE_PHRASE(xpp);
    } else if (type.equals("COMPOSITION")) {
      return parseCOMPOSITION(xpp);
    } else if (type.equals("CONTACT")) {
      return parseCONTACT(xpp);
    } else if (type.equals("CONTRIBUTION")) {
      return parseCONTRIBUTION(xpp);
    } else if (type.equals("DV_BOOLEAN")) {
      return parseDV_BOOLEAN(xpp);
    } else if (type.equals("DV_CODED_TEXT")) {
      return parseDV_CODED_TEXT(xpp);
    } else if (type.equals("DV_COUNT")) {
      return parseDV_COUNT(xpp);
    } else if (type.equals("DV_DATE_TIME")) {
      return parseDV_DATE_TIME(xpp);
    } else if (type.equals("DV_DATE")) {
      return parseDV_DATE(xpp);
    } else if (type.equals("DV_DURATION")) {
      return parseDV_DURATION(xpp);
    } else if (type.equals("DV_EHR_URI")) {
      return parseDV_EHR_URI(xpp);
    } else if (type.equals("DV_GENERAL_TIME_SPECIFICATION")) {
      return parseDV_GENERAL_TIME_SPECIFICATION(xpp);
    } else if (type.equals("DV_IDENTIFIER")) {
      return parseDV_IDENTIFIER(xpp);
    } else if (type.equals("DV_INTERVAL")) {
      return parseDV_INTERVAL(xpp);
    } else if (type.equals("DV_MULTIMEDIA")) {
      return parseDV_MULTIMEDIA(xpp);
    } else if (type.equals("DV_ORDINAL")) {
      return parseDV_ORDINAL(xpp);
    } else if (type.equals("DV_PARAGRAPH")) {
      return parseDV_PARAGRAPH(xpp);
    } else if (type.equals("DV_PARSABLE")) {
      return parseDV_PARSABLE(xpp);
    } else if (type.equals("DV_PERIODIC_TIME_SPECIFICATION")) {
      return parseDV_PERIODIC_TIME_SPECIFICATION(xpp);
    } else if (type.equals("DV_PROPORTION")) {
      return parseDV_PROPORTION(xpp);
    } else if (type.equals("DV_QUANTITY")) {
      return parseDV_QUANTITY(xpp);
    } else if (type.equals("DV_SCALE")) {
      return parseDV_SCALE(xpp);
    } else if (type.equals("DV_STATE")) {
      return parseDV_STATE(xpp);
    } else if (type.equals("DV_TEXT")) {
      return parseDV_TEXT(xpp);
    } else if (type.equals("DV_TIME")) {
      return parseDV_TIME(xpp);
    } else if (type.equals("DV_URI")) {
      return parseDV_URI(xpp);
    } else if (type.equals("EHR_ACCESS")) {
      return parseEHR_ACCESS(xpp);
    } else if (type.equals("EHR_STATUS")) {
      return parseEHR_STATUS(xpp);
    } else if (type.equals("EHR")) {
      return parseEHR(xpp);
    } else if (type.equals("ELEMENT")) {
      return parseELEMENT(xpp);
    } else if (type.equals("EVALUATION")) {
      return parseEVALUATION(xpp);
    } else if (type.equals("EVENT_CONTEXT")) {
      return parseEVENT_CONTEXT(xpp);
    } else if (type.equals("FEEDER_AUDIT_DETAILS")) {
      return parseFEEDER_AUDIT_DETAILS(xpp);
    } else if (type.equals("FEEDER_AUDIT")) {
      return parseFEEDER_AUDIT(xpp);
    } else if (type.equals("FOLDER")) {
      return parseFOLDER(xpp);
    } else if (type.equals("GENERIC_ID")) {
      return parseGENERIC_ID(xpp);
    } else if (type.equals("GROUP")) {
      return parseGROUP(xpp);
    } else if (type.equals("HIER_OBJECT_ID")) {
      return parseHIER_OBJECT_ID(xpp);
    } else if (type.equals("HISTORY")) {
      return parseHISTORY(xpp);
    } else if (type.equals("IMPORTED_VERSION")) {
      return parseIMPORTED_VERSION(xpp);
    } else if (type.equals("INSTRUCTION_DETAILS")) {
      return parseINSTRUCTION_DETAILS(xpp);
    } else if (type.equals("INSTRUCTION")) {
      return parseINSTRUCTION(xpp);
    } else if (type.equals("INTERNET_ID")) {
      return parseINTERNET_ID(xpp);
    } else if (type.equals("INTERVAL_EVENT")) {
      return parseINTERVAL_EVENT(xpp);
    } else if (type.equals("ISM_TRANSITION")) {
      return parseISM_TRANSITION(xpp);
    } else if (type.equals("ISO_OID")) {
      return parseISO_OID(xpp);
    } else if (type.equals("ITEM_LIST")) {
      return parseITEM_LIST(xpp);
    } else if (type.equals("ITEM_SINGLE")) {
      return parseITEM_SINGLE(xpp);
    } else if (type.equals("ITEM_TABLE")) {
      return parseITEM_TABLE(xpp);
    } else if (type.equals("ITEM_TAG")) {
      return parseITEM_TAG(xpp);
    } else if (type.equals("ITEM_TREE")) {
      return parseITEM_TREE(xpp);
    } else if (type.equals("LINK")) {
      return parseLINK(xpp);
    } else if (type.equals("LOCATABLE_REF")) {
      return parseLOCATABLE_REF(xpp);
    } else if (type.equals("OBJECT_REF")) {
      return parseOBJECT_REF(xpp);
    } else if (type.equals("OBJECT_VERSION_ID")) {
      return parseOBJECT_VERSION_ID(xpp);
    } else if (type.equals("OBSERVATION")) {
      return parseOBSERVATION(xpp);
    } else if (type.equals("ORGANISATION")) {
      return parseORGANISATION(xpp);
    } else if (type.equals("ORIGINAL_VERSION")) {
      return parseORIGINAL_VERSION(xpp);
    } else if (type.equals("PARTICIPATION")) {
      return parsePARTICIPATION(xpp);
    } else if (type.equals("PARTY_IDENTIFIED")) {
      return parsePARTY_IDENTIFIED(xpp);
    } else if (type.equals("PARTY_IDENTITY")) {
      return parsePARTY_IDENTITY(xpp);
    } else if (type.equals("PARTY_REF")) {
      return parsePARTY_REF(xpp);
    } else if (type.equals("PARTY_RELATED")) {
      return parsePARTY_RELATED(xpp);
    } else if (type.equals("PARTY_RELATIONSHIP")) {
      return parsePARTY_RELATIONSHIP(xpp);
    } else if (type.equals("PARTY_SELF")) {
      return parsePARTY_SELF(xpp);
    } else if (type.equals("PERSON")) {
      return parsePERSON(xpp);
    } else if (type.equals("POINT_EVENT")) {
      return parsePOINT_EVENT(xpp);
    } else if (type.equals("REFERENCE_RANGE")) {
      return parseREFERENCE_RANGE(xpp);
    } else if (type.equals("RESOURCE_DESCRIPTION_ITEM")) {
      return parseRESOURCE_DESCRIPTION_ITEM(xpp);
    } else if (type.equals("RESOURCE_DESCRIPTION")) {
      return parseRESOURCE_DESCRIPTION(xpp);
    } else if (type.equals("REVISION_HISTORY_ITEM")) {
      return parseREVISION_HISTORY_ITEM(xpp);
    } else if (type.equals("REVISION_HISTORY")) {
      return parseREVISION_HISTORY(xpp);
    } else if (type.equals("ROLE")) {
      return parseROLE(xpp);
    } else if (type.equals("SECTION")) {
      return parseSECTION(xpp);
    } else if (type.equals("TEMPLATE_ID")) {
      return parseTEMPLATE_ID(xpp);
    } else if (type.equals("TERM_MAPPING")) {
      return parseTERM_MAPPING(xpp);
    } else if (type.equals("TERMINOLOGY_ID")) {
      return parseTERMINOLOGY_ID(xpp);
    } else if (type.equals("TRANSLATION_DETAILS")) {
      return parseTRANSLATION_DETAILS(xpp);
    } else if (type.equals("TranslatedString")) {
      return parseTranslatedString(xpp);
    } else if (type.equals("UUID")) {
      return parseUUID(xpp);
    } else if (type.equals("VERSION_TREE_ID")) {
      return parseVERSION_TREE_ID(xpp);
    } else if (type.equals("VERSIONED_COMPOSITION")) {
      return parseVERSIONED_COMPOSITION(xpp);
    } else if (type.equals("VERSIONED_EHR_ACCESS")) {
      return parseVERSIONED_EHR_ACCESS(xpp);
    } else if (type.equals("VERSIONED_EHR_STATUS")) {
      return parseVERSIONED_EHR_STATUS(xpp);
    } else if (type.equals("VERSIONED_FOLDER")) {
      return parseVERSIONED_FOLDER(xpp);
    } else if (type.equals("VERSIONED_OBJECT")) {
      return parseVERSIONED_OBJECT(xpp);
    } else if (type.equals("VERSIONED_PARTY")) {
      return parseVERSIONED_PARTY(xpp);
    } else if (type.equals("WebTemplate")) {
      return parseWebTemplate(xpp);
    } else if (type.equals("WebTemplateInput")) {
      return parseWebTemplateInput(xpp);
    } else if (type.equals("WebTemplateInputListItem")) {
      return parseWebTemplateInputListItem(xpp);
    } else if (type.equals("WebTemplateInputValidation")) {
      return parseWebTemplateInputValidation(xpp);
    } else if (type.equals("WebTemplateInputValidationRange")) {
      return parseWebTemplateInputValidationRange(xpp);
    } else if (type.equals("WebTemplateItem")) {
      return parseWebTemplateItem(xpp);
    } else if (type.equals("WebTemplateTermBinding")) {
      return parseWebTemplateTermBinding(xpp);
    } else if (type.equals("WebTemplateTermBindingValue")) {
      return parseWebTemplateTermBindingValue(xpp);
      
    } else if (type.equals("date")) {
      return parseDate(xpp);
    } else if (type.equals("dateTime")) {
      return parseDateTime(xpp);
    } else if (type.equals("code")) {
      return parseCode(xpp);
    } else if (type.equals("string")) {
      return parseString(xpp);
    } else if (type.equals("integer")) {
      return parseInteger(xpp);
    } else if (type.equals("integer64")) {
      return parseInteger64(xpp);
    } else if (type.equals("oid")) {
      return parseOid(xpp);
    } else if (type.equals("canonical")) {
      return parseCanonical(xpp);
    } else if (type.equals("uri")) {
      return parseUri(xpp);
    } else if (type.equals("uuid")) {
      return parseUuid(xpp);
    } else if (type.equals("url")) {
      return parseUrl(xpp);
    } else if (type.equals("instant")) {
      return parseInstant(xpp);
    } else if (type.equals("boolean")) {
      return parseBoolean(xpp);
    } else if (type.equals("base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (type.equals("unsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (type.equals("markdown")) {
      return parseMarkdown(xpp);
    } else if (type.equals("time")) {
      return parseTime(xpp);
    } else if (type.equals("id")) {
      return parseId(xpp);
    } else if (type.equals("positiveInt")) {
      return parsePositiveInt(xpp);
    } else if (type.equals("decimal")) {
      return parseDecimal(xpp);
    } else {
      throw new FHIRFormatError("Unknown type "+type);
    }
  }

  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) throws IOException {  
    if (prefix == null) {
      throw new IOException("prefix == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (xpp.getName().equals(prefix+"ACTION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ACTIVITY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ADDRESS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ADMIN_ENTRY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"AGENT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ARCHETYPE_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ARCHETYPED")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ATTESTATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"AUDIT_DETAILS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Annotations")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CAPABILITY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CLUSTER")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CODE_PHRASE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"COMPOSITION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CONTACT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CONTRIBUTION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_BOOLEAN")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_CODED_TEXT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_COUNT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_DATE_TIME")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_DATE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_DURATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_EHR_URI")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_GENERAL_TIME_SPECIFICATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_IDENTIFIER")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_INTERVAL")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_MULTIMEDIA")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_ORDINAL")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_PARAGRAPH")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_PARSABLE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_PERIODIC_TIME_SPECIFICATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_PROPORTION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_QUANTITY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_SCALE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_STATE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_TEXT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_TIME")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DV_URI")) {
      return true;
    } else if (xpp.getName().equals(prefix+"EHR_ACCESS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"EHR_STATUS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"EHR")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ELEMENT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"EVALUATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"EVENT_CONTEXT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"FEEDER_AUDIT_DETAILS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"FEEDER_AUDIT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"FOLDER")) {
      return true;
    } else if (xpp.getName().equals(prefix+"GENERIC_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"GROUP")) {
      return true;
    } else if (xpp.getName().equals(prefix+"HIER_OBJECT_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"HISTORY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"IMPORTED_VERSION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"INSTRUCTION_DETAILS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"INSTRUCTION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"INTERNET_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"INTERVAL_EVENT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ISM_TRANSITION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ISO_OID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ITEM_LIST")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ITEM_SINGLE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ITEM_TABLE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ITEM_TAG")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ITEM_TREE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"LINK")) {
      return true;
    } else if (xpp.getName().equals(prefix+"LOCATABLE_REF")) {
      return true;
    } else if (xpp.getName().equals(prefix+"OBJECT_REF")) {
      return true;
    } else if (xpp.getName().equals(prefix+"OBJECT_VERSION_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"OBSERVATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ORGANISATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ORIGINAL_VERSION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PARTICIPATION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PARTY_IDENTIFIED")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PARTY_IDENTITY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PARTY_REF")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PARTY_RELATED")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PARTY_RELATIONSHIP")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PARTY_SELF")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PERSON")) {
      return true;
    } else if (xpp.getName().equals(prefix+"POINT_EVENT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"REFERENCE_RANGE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"RESOURCE_DESCRIPTION_ITEM")) {
      return true;
    } else if (xpp.getName().equals(prefix+"RESOURCE_DESCRIPTION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"REVISION_HISTORY_ITEM")) {
      return true;
    } else if (xpp.getName().equals(prefix+"REVISION_HISTORY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"ROLE")) {
      return true;
    } else if (xpp.getName().equals(prefix+"SECTION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"TEMPLATE_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"TERM_MAPPING")) {
      return true;
    } else if (xpp.getName().equals(prefix+"TERMINOLOGY_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"TRANSLATION_DETAILS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"TranslatedString")) {
      return true;
    } else if (xpp.getName().equals(prefix+"UUID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"VERSION_TREE_ID")) {
      return true;
    } else if (xpp.getName().equals(prefix+"VERSIONED_COMPOSITION")) {
      return true;
    } else if (xpp.getName().equals(prefix+"VERSIONED_EHR_ACCESS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"VERSIONED_EHR_STATUS")) {
      return true;
    } else if (xpp.getName().equals(prefix+"VERSIONED_FOLDER")) {
      return true;
    } else if (xpp.getName().equals(prefix+"VERSIONED_OBJECT")) {
      return true;
    } else if (xpp.getName().equals(prefix+"VERSIONED_PARTY")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplate")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplateInput")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplateInputListItem")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplateInputValidation")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplateInputValidationRange")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplateItem")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplateTermBinding")) {
      return true;
    } else if (xpp.getName().equals(prefix+"WebTemplateTermBindingValue")) {
      return true;

    } else if (xpp.getName().equals(prefix+"Date")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DateTime")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Code")) {
      return true;
    } else if (xpp.getName().equals(prefix+"String")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Integer")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Integer64")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Oid")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Canonical")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Uri")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Uuid")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Url")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Instant")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Boolean")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Base64Binary")) {
      return true;
    } else if (xpp.getName().equals(prefix+"UnsignedInt")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Markdown")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Time")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Id")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PositiveInt")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Decimal")) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected DataType parseAnyType(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    return parseType(xpp, type);
  }


//----------------- Composer -------------------------------------------------------------------------------------------

  protected void composeACCESS_CONTROL_SETTINGS(String name, ACCESS_CONTROL_SETTINGS element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeACCESS_CONTROL_SETTINGSElements(ACCESS_CONTROL_SETTINGS element) throws IOException {
    composeBaseElements(element);
  }

  protected void composeACTOR(String name, ACTOR element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "AGENT":
        composeAGENT(name, (AGENT) element);
        break;
      case "GROUP":
        composeGROUP(name, (GROUP) element);
        break;
      case "PERSON":
        composePERSON(name, (PERSON) element);
        break;
      case "ORGANISATION":
        composeORGANISATION(name, (ORGANISATION) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeACTORElements(ACTOR element) throws IOException {
    composePARTYElements(element);
    if (element.hasLanguages()) { 
      for (DV_TEXT e : element.getLanguagesList()) 
          composeDV_TEXT("languages", e); // a
    }
    if (element.hasRoles()) { 
      for (PARTY_REF e : element.getRolesList()) 
          composePARTY_REF("roles", e); // a
    }
  }

  protected void composeAUTHORED_RESOURCE(String name, AUTHORED_RESOURCE element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeAUTHORED_RESOURCEElements(AUTHORED_RESOURCE element) throws IOException {
    composeBaseElements(element);
    if (element.hasOriginal_language()) {
      composeCODE_PHRASE("original_language", element.getOriginal_language());
    }
    if (element.hasIs_controlledElement()) {
      composeBoolean("is_controlled", element.getIs_controlledElement());
    }
    if (element.hasTranslations()) { 
      for (TRANSLATION_DETAILS e : element.getTranslationsList()) 
          composeTRANSLATION_DETAILS("translations", e); // a
    }
    if (element.hasDescription()) {
      composeRESOURCE_DESCRIPTION("description", element.getDescription());
    }
    if (element.hasRevision_history()) {
      composeREVISION_HISTORY("revision_history", element.getRevision_history());
    }
  }

  protected void composeAny(String name, Any element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "EHR":
        composeEHR(name, (EHR) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeAnyElements(Any element) throws IOException {
    composeBaseElements(element);
  }

  protected void composeCARE_ENTRY(String name, CARE_ENTRY element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "INSTRUCTION":
        composeINSTRUCTION(name, (INSTRUCTION) element);
        break;
      case "OBSERVATION":
        composeOBSERVATION(name, (OBSERVATION) element);
        break;
      case "ACTION":
        composeACTION(name, (ACTION) element);
        break;
      case "EVALUATION":
        composeEVALUATION(name, (EVALUATION) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeCARE_ENTRYElements(CARE_ENTRY element) throws IOException {
    composeENTRYElements(element);
    if (element.hasProtocol()) {
      composeITEM_STRUCTURE("protocol", element.getProtocol());
    }
    if (element.hasGuideline_id()) {
      composeOBJECT_REF("guideline_id", element.getGuideline_id());
    }
  }

  protected void composeCONTENT_ITEM(String name, CONTENT_ITEM element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "SECTION":
        composeSECTION(name, (SECTION) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeCONTENT_ITEMElements(CONTENT_ITEM element) throws IOException {
    composeLOCATABLEElements(element);
  }

  protected void composeDATA_STRUCTURE(String name, DATA_STRUCTURE element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "HISTORY":
        composeHISTORY(name, (HISTORY) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDATA_STRUCTUREElements(DATA_STRUCTURE element) throws IOException {
    composeLOCATABLEElements(element);
  }

  protected void composeDATA_VALUE(String name, DATA_VALUE element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-TEXT":
        composeDV_TEXT(name, (DV_TEXT) element);
        break;
      case "DV-IDENTIFIER":
        composeDV_IDENTIFIER(name, (DV_IDENTIFIER) element);
        break;
      case "DV-BOOLEAN":
        composeDV_BOOLEAN(name, (DV_BOOLEAN) element);
        break;
      case "DV-PARAGRAPH":
        composeDV_PARAGRAPH(name, (DV_PARAGRAPH) element);
        break;
      case "DV-URI":
        composeDV_URI(name, (DV_URI) element);
        break;
      case "DV-STATE":
        composeDV_STATE(name, (DV_STATE) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDATA_VALUEElements(DATA_VALUE element) throws IOException {
    composeBaseElements(element);
  }

  protected void composeDV_ABSOLUTE_QUANTITY(String name, DV_ABSOLUTE_QUANTITY element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_ABSOLUTE_QUANTITYElements(DV_ABSOLUTE_QUANTITY element) throws IOException {
    composeDV_QUANTIFIEDElements(element);
  }

  protected void composeDV_AMOUNT(String name, DV_AMOUNT element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-DURATION":
        composeDV_DURATION(name, (DV_DURATION) element);
        break;
      case "DV-COUNT":
        composeDV_COUNT(name, (DV_COUNT) element);
        break;
      case "DV-PROPORTION":
        composeDV_PROPORTION(name, (DV_PROPORTION) element);
        break;
      case "DV-QUANTITY":
        composeDV_QUANTITY(name, (DV_QUANTITY) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_AMOUNTElements(DV_AMOUNT element) throws IOException {
    composeDV_QUANTIFIEDElements(element);
    if (element.hasAccuracy_is_percentElement()) {
      composeBoolean("accuracy_is_percent", element.getAccuracy_is_percentElement());
    }
  }

  protected void composeDV_ENCAPSULATED(String name, DV_ENCAPSULATED element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-MULTIMEDIA":
        composeDV_MULTIMEDIA(name, (DV_MULTIMEDIA) element);
        break;
      case "DV-PARSABLE":
        composeDV_PARSABLE(name, (DV_PARSABLE) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_ENCAPSULATEDElements(DV_ENCAPSULATED element) throws IOException {
    composeDV_AMOUNTElements(element);
    if (element.hasCharset()) {
      composeCODE_PHRASE("charset", element.getCharset());
    }
    if (element.hasLanguage()) {
      composeCODE_PHRASE("language", element.getLanguage());
    }
  }

  protected void composeDV_ORDERED(String name, DV_ORDERED element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-DATE-TIME":
        composeDV_DATE_TIME(name, (DV_DATE_TIME) element);
        break;
      case "DV-TIME":
        composeDV_TIME(name, (DV_TIME) element);
        break;
      case "DV-INTERVAL":
        composeDV_INTERVAL(name, (DV_INTERVAL) element);
        break;
      case "DV-ORDINAL":
        composeDV_ORDINAL(name, (DV_ORDINAL) element);
        break;
      case "DV-SCALE":
        composeDV_SCALE(name, (DV_SCALE) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_ORDEREDElements(DV_ORDERED element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasNormal_status()) {
      composeCODE_PHRASE("normal_status", element.getNormal_status());
    }
    if (element.hasNormal_range()) {
      composeDV_INTERVAL("normal_range", element.getNormal_range());
    }
    if (element.hasOther_reference_ranges()) { 
      for (REFERENCE_RANGE e : element.getOther_reference_rangesList()) 
          composeREFERENCE_RANGE("other_reference_ranges", e); // a
    }
  }

  protected void composeDV_QUANTIFIED(String name, DV_QUANTIFIED element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_QUANTIFIEDElements(DV_QUANTIFIED element) throws IOException {
    composeDV_ORDEREDElements(element);
    if (element.hasMagnitude_statusElement()) {
      composeString("magnitude_status", element.getMagnitude_statusElement());
    }
    if (element.hasAccuracy()) {
      composeBase("accuracy", element.getAccuracy());
    }
  }

  protected void composeDV_TEMPORAL(String name, DV_TEMPORAL element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-DATE":
        composeDV_DATE(name, (DV_DATE) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_TEMPORALElements(DV_TEMPORAL element) throws IOException {
    composeDV_ABSOLUTE_QUANTITYElements(element);
  }

  protected void composeDV_TIME_SPECIFICATION(String name, DV_TIME_SPECIFICATION element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-GENERAL-TIME-SPECIFICATION":
        composeDV_GENERAL_TIME_SPECIFICATION(name, (DV_GENERAL_TIME_SPECIFICATION) element);
        break;
      case "DV-PERIODIC-TIME-SPECIFICATION":
        composeDV_PERIODIC_TIME_SPECIFICATION(name, (DV_PERIODIC_TIME_SPECIFICATION) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_TIME_SPECIFICATIONElements(DV_TIME_SPECIFICATION element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasDV_PARSABLEElement()) {
      composeString("DV_PARSABLE", element.getDV_PARSABLEElement());
    }
  }

  protected void composeENTRY(String name, ENTRY element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "ADMIN-ENTRY":
        composeADMIN_ENTRY(name, (ADMIN_ENTRY) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeENTRYElements(ENTRY element) throws IOException {
    composeCONTENT_ITEMElements(element);
    if (element.hasLanguage()) {
      composeCODE_PHRASE("language", element.getLanguage());
    }
    if (element.hasEncoding()) {
      composeCODE_PHRASE("encoding", element.getEncoding());
    }
    if (element.hasOther_participations()) { 
      for (PARTICIPATION e : element.getOther_participationsList()) 
          composePARTICIPATION("other_participations", e); // a
    }
    if (element.hasWorkflow_id()) {
      composeOBJECT_REF("workflow_id", element.getWorkflow_id());
    }
    if (element.hasSubject()) {
      composePARTY_PROXY("subject", element.getSubject());
    }
    if (element.hasProvider()) {
      composePARTY_PROXY("provider", element.getProvider());
    }
  }

  protected void composeEVENT(String name, EVENT element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "INTERVAL-EVENT":
        composeINTERVAL_EVENT(name, (INTERVAL_EVENT) element);
        break;
      case "POINT-EVENT":
        composePOINT_EVENT(name, (POINT_EVENT) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeEVENTElements(EVENT element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasTime()) {
      composeDV_DATE_TIME("time", element.getTime());
    }
    if (element.hasState()) {
      composeITEM_STRUCTURE("state", element.getState());
    }
    if (element.hasData()) {
      composeAny("data", element.getData());
    }
  }

  protected void composeITEM_STRUCTURE(String name, ITEM_STRUCTURE element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "ITEM-SINGLE":
        composeITEM_SINGLE(name, (ITEM_SINGLE) element);
        break;
      case "ITEM-TREE":
        composeITEM_TREE(name, (ITEM_TREE) element);
        break;
      case "ITEM-TABLE":
        composeITEM_TABLE(name, (ITEM_TABLE) element);
        break;
      case "ITEM-LIST":
        composeITEM_LIST(name, (ITEM_LIST) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeITEM_STRUCTUREElements(ITEM_STRUCTURE element) throws IOException {
    composeDATA_STRUCTUREElements(element);
  }

  protected void composeITEM(String name, ITEM element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "ELEMENT":
        composeELEMENT(name, (ELEMENT) element);
        break;
      case "CLUSTER":
        composeCLUSTER(name, (CLUSTER) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeITEMElements(ITEM element) throws IOException {
    composeLOCATABLEElements(element);
  }

  protected void composeLOCATABLE(String name, LOCATABLE element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "CONTACT":
        composeCONTACT(name, (CONTACT) element);
        break;
      case "EVENT-CONTEXT":
        composeEVENT_CONTEXT(name, (EVENT_CONTEXT) element);
        break;
      case "EHR-STATUS":
        composeEHR_STATUS(name, (EHR_STATUS) element);
        break;
      case "PARTY-IDENTITY":
        composePARTY_IDENTITY(name, (PARTY_IDENTITY) element);
        break;
      case "ADDRESS":
        composeADDRESS(name, (ADDRESS) element);
        break;
      case "COMPOSITION":
        composeCOMPOSITION(name, (COMPOSITION) element);
        break;
      case "PARTY-RELATIONSHIP":
        composePARTY_RELATIONSHIP(name, (PARTY_RELATIONSHIP) element);
        break;
      case "CAPABILITY":
        composeCAPABILITY(name, (CAPABILITY) element);
        break;
      case "EHR-ACCESS":
        composeEHR_ACCESS(name, (EHR_ACCESS) element);
        break;
      case "ACTIVITY":
        composeACTIVITY(name, (ACTIVITY) element);
        break;
      case "FOLDER":
        composeFOLDER(name, (FOLDER) element);
        break;
      case "PARTICIPATION":
        composePARTICIPATION(name, (PARTICIPATION) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeLOCATABLEElements(LOCATABLE element) throws IOException {
    composePATHABLEElements(element);
  }

  protected void composeOBJECT_ID(String name, OBJECT_ID element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "TEMPLATE-ID":
        composeTEMPLATE_ID(name, (TEMPLATE_ID) element);
        break;
      case "ARCHETYPE-ID":
        composeARCHETYPE_ID(name, (ARCHETYPE_ID) element);
        break;
      case "GENERIC-ID":
        composeGENERIC_ID(name, (GENERIC_ID) element);
        break;
      case "TERMINOLOGY-ID":
        composeTERMINOLOGY_ID(name, (TERMINOLOGY_ID) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeOBJECT_IDElements(OBJECT_ID element) throws IOException {
    composeUIDElements(element);
  }

  protected void composePARTY_PROXY(String name, PARTY_PROXY element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "PARTY-SELF":
        composePARTY_SELF(name, (PARTY_SELF) element);
        break;
      case "PARTY-IDENTIFIED":
        composePARTY_IDENTIFIED(name, (PARTY_IDENTIFIED) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composePARTY_PROXYElements(PARTY_PROXY element) throws IOException {
    composeBaseElements(element);
    if (element.hasExternal_ref()) {
      composePARTY_REF("external_ref", element.getExternal_ref());
    }
  }

  protected void composePARTY(String name, PARTY element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "ROLE":
        composeROLE(name, (ROLE) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composePARTYElements(PARTY element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasIdentities()) { 
      for (PARTY_IDENTITY e : element.getIdentitiesList()) 
          composePARTY_IDENTITY("identities", e); // a
    }
    if (element.hasContacts()) {
      composeCONTACT("contacts", element.getContacts());
    }
    if (element.hasDetails()) {
      composeITEM_STRUCTURE("details", element.getDetails());
    }
    if (element.hasReverse_relationships()) { 
      for (LOCATABLE_REF e : element.getReverse_relationshipsList()) 
          composeLOCATABLE_REF("reverse_relationships", e); // a
    }
    if (element.hasRelationships()) { 
      for (PARTY_RELATIONSHIP e : element.getRelationshipsList()) 
          composePARTY_RELATIONSHIP("relationships", e); // a
    }
  }

  protected void composePATHABLE(String name, PATHABLE element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "INSTRUCTION-DETAILS":
        composeINSTRUCTION_DETAILS(name, (INSTRUCTION_DETAILS) element);
        break;
      case "ISM-TRANSITION":
        composeISM_TRANSITION(name, (ISM_TRANSITION) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composePATHABLEElements(PATHABLE element) throws IOException {
    composeAnyElements(element);
    if (element.hasName()) {
      composeDV_TEXT("name", element.getName());
    }
    if (element.hasArchetype_node_idElement()) {
      composeString("archetype_node_id", element.getArchetype_node_idElement());
    }
    if (element.hasUid()) {
      composeUID_BASED_ID("uid", element.getUid());
    }
    if (element.hasLinks()) { 
      for (LINK e : element.getLinksList()) 
          composeLINK("links", e); // a
    }
    if (element.hasArchetype_details()) {
      composeARCHETYPED("archetype_details", element.getArchetype_details());
    }
    if (element.hasFeeder_audit()) {
      composeFEEDER_AUDIT("feeder_audit", element.getFeeder_audit());
    }
  }

  protected void composeUID_BASED_ID(String name, UID_BASED_ID element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "OBJECT-VERSION-ID":
        composeOBJECT_VERSION_ID(name, (OBJECT_VERSION_ID) element);
        break;
      case "HIER-OBJECT-ID":
        composeHIER_OBJECT_ID(name, (HIER_OBJECT_ID) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeUID_BASED_IDElements(UID_BASED_ID element) throws IOException {
    composeOBJECT_IDElements(element);
  }

  protected void composeUID(String name, UID element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "ISO-OID":
        composeISO_OID(name, (ISO_OID) element);
        break;
      case "UUID":
        composeUUID(name, (UUID) element);
        break;
      case "INTERNET-ID":
        composeINTERNET_ID(name, (INTERNET_ID) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeUIDElements(UID element) throws IOException {
    composeBaseElements(element);
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
  }

  protected void composeVERSION(String name, VERSION element) throws IOException {
    if (element != null) {
      xml.attribute("xsi:type", element.fhirType());
      switch (element.fhirType()) {
      case "IMPORTED-VERSION":
        composeIMPORTED_VERSION(name, (IMPORTED_VERSION) element);
        break;
      case "ORIGINAL-VERSION":
        composeORIGINAL_VERSION(name, (ORIGINAL_VERSION) element);
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeVERSIONElements(VERSION element) throws IOException {
    composeBaseElements(element);
    if (element.hasContribution()) {
      composeOBJECT_REF("contribution", element.getContribution());
    }
    if (element.hasSignatureElement()) {
      composeString("signature", element.getSignatureElement());
    }
    if (element.hasCommit_audit()) {
      composeAUDIT_DETAILS("commit_audit", element.getCommit_audit());
    }
  }

  protected void composeACTION(String name, ACTION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeACTIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeACTIONElements(ACTION element) throws IOException {
    composeCARE_ENTRYElements(element);
    if (element.hasTime()) {
      composeDV_DATE_TIME("time", element.getTime());
    }
    if (element.hasIsm_transition()) {
      composeISM_TRANSITION("ism_transition", element.getIsm_transition());
    }
    if (element.hasInstruction_details()) {
      composeINSTRUCTION_DETAILS("instruction_details", element.getInstruction_details());
    }
    if (element.hasDescription()) {
      composeITEM_STRUCTURE("description", element.getDescription());
    }
  }

  protected void composeACTIVITY(String name, ACTIVITY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeACTIVITYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeACTIVITYElements(ACTIVITY element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasTiming()) {
      composeDV_PARSABLE("timing", element.getTiming());
    }
    if (element.hasAction_archetype_idElement()) {
      composeString("action_archetype_id", element.getAction_archetype_idElement());
    }
    if (element.hasDescription()) {
      composeITEM_STRUCTURE("description", element.getDescription());
    }
  }

  protected void composeADDRESS(String name, ADDRESS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeADDRESSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeADDRESSElements(ADDRESS element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasDetails()) {
      composeITEM_STRUCTURE("details", element.getDetails());
    }
  }

  protected void composeADMIN_ENTRY(String name, ADMIN_ENTRY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeADMIN_ENTRYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeADMIN_ENTRYElements(ADMIN_ENTRY element) throws IOException {
    composeENTRYElements(element);
    if (element.hasData()) {
      composeITEM_STRUCTURE("data", element.getData());
    }
  }

  protected void composeAGENT(String name, AGENT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeAGENTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeAGENTElements(AGENT element) throws IOException {
    composeACTORElements(element);
  }

  protected void composeARCHETYPE_ID(String name, ARCHETYPE_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeARCHETYPE_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeARCHETYPE_IDElements(ARCHETYPE_ID element) throws IOException {
    composeOBJECT_IDElements(element);
  }

  protected void composeARCHETYPED(String name, ARCHETYPED element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeARCHETYPEDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeARCHETYPEDElements(ARCHETYPED element) throws IOException {
    composeBaseElements(element);
    if (element.hasArchetype_id()) {
      composeARCHETYPE_ID("archetype_id", element.getArchetype_id());
    }
    if (element.hasTemplate_id()) {
      composeTEMPLATE_ID("template_id", element.getTemplate_id());
    }
    if (element.hasRm_versionElement()) {
      composeString("rm_version", element.getRm_versionElement());
    }
  }

  protected void composeATTESTATION(String name, ATTESTATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeATTESTATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeATTESTATIONElements(ATTESTATION element) throws IOException {
    composeAUDIT_DETAILSElements(element);
    if (element.hasAttested_view()) {
      composeDV_MULTIMEDIA("attested_view", element.getAttested_view());
    }
    if (element.hasProofElement()) {
      composeString("proof", element.getProofElement());
    }
    if (element.hasItems()) { 
      for (DV_EHR_URI e : element.getItemsList()) 
          composeDV_EHR_URI("items", e); // a
    }
    if (element.hasReason()) {
      composeDV_TEXT("reason", element.getReason());
    }
    if (element.hasIs_pendingElement()) {
      composeBoolean("is_pending", element.getIs_pendingElement());
    }
  }

  protected void composeAUDIT_DETAILS(String name, AUDIT_DETAILS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeAUDIT_DETAILSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeAUDIT_DETAILSElements(AUDIT_DETAILS element) throws IOException {
    composeBaseElements(element);
    if (element.hasSystem_idElement()) {
      composeString("system_id", element.getSystem_idElement());
    }
    if (element.hasTime_committed()) {
      composeDV_DATE_TIME("time_committed", element.getTime_committed());
    }
    if (element.hasChange_type()) {
      composeDV_CODED_TEXT("change_type", element.getChange_type());
    }
    if (element.hasDescription()) {
      composeDV_TEXT("description", element.getDescription());
    }
    if (element.hasCommitter()) {
      composePARTY_PROXY("committer", element.getCommitter());
    }
  }

  protected void composeAnnotations(String name, Annotations element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeAnnotationsElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeAnnotationsElements(Annotations element) throws IOException {
    composeBaseElements(element);
    if (element.hasCommentElement()) {
      composeString("comment", element.getCommentElement());
    }
    if (element.hasFhir_mappingElement()) {
      composeString("fhir_mapping", element.getFhir_mappingElement());
    }
    if (element.hasVset_descriptionElement()) {
      composeString("vset_description", element.getVset_descriptionElement());
    }
    if (element.hasHl7v2_mappingElement()) {
      composeString("hl7v2_mapping", element.getHl7v2_mappingElement());
    }
    if (element.hasVisibleInViewElement()) {
      composeString("visibleInView", element.getVisibleInViewElement());
    }
  }

  protected void composeCAPABILITY(String name, CAPABILITY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCAPABILITYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCAPABILITYElements(CAPABILITY element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasCredentials()) {
      composeITEM_STRUCTURE("credentials", element.getCredentials());
    }
    if (element.hasTime_validity()) {
      composeDV_INTERVAL("time_validity", element.getTime_validity());
    }
  }

  protected void composeCLUSTER(String name, CLUSTER element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCLUSTERElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCLUSTERElements(CLUSTER element) throws IOException {
    composeITEMElements(element);
    if (element.hasItems()) { 
      for (ITEM e : element.getItemsList()) 
          composeITEM("items", e); // a
    }
  }

  protected void composeCODE_PHRASE(String name, CODE_PHRASE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCODE_PHRASEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCODE_PHRASEElements(CODE_PHRASE element) throws IOException {
    composeBaseElements(element);
    if (element.hasTerminology_id()) {
      composeTERMINOLOGY_ID("terminology_id", element.getTerminology_id());
    }
    if (element.hasCode_stringElement()) {
      composeString("code_string", element.getCode_stringElement());
    }
    if (element.hasPreferred_termElement()) {
      composeString("preferred_term", element.getPreferred_termElement());
    }
  }

  protected void composeCOMPOSITION(String name, COMPOSITION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCOMPOSITIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCOMPOSITIONElements(COMPOSITION element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasLanguage()) {
      composeCODE_PHRASE("language", element.getLanguage());
    }
    if (element.hasTerritory()) {
      composeCODE_PHRASE("territory", element.getTerritory());
    }
    if (element.hasCategory()) {
      composeDV_CODED_TEXT("category", element.getCategory());
    }
    if (element.hasContext()) {
      composeEVENT_CONTEXT("context", element.getContext());
    }
    if (element.hasComposer()) {
      composePARTY_PROXY("composer", element.getComposer());
    }
    if (element.hasContent()) { 
      for (CONTENT_ITEM e : element.getContentList()) 
          composeCONTENT_ITEM("content", e); // a
    }
  }

  protected void composeCONTACT(String name, CONTACT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCONTACTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCONTACTElements(CONTACT element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasAddresses()) { 
      for (ADDRESS e : element.getAddressesList()) 
          composeADDRESS("addresses", e); // a
    }
    if (element.hasTime_validity()) {
      composeDV_INTERVAL("time_validity", element.getTime_validity());
    }
  }

  protected void composeCONTRIBUTION(String name, CONTRIBUTION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCONTRIBUTIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCONTRIBUTIONElements(CONTRIBUTION element) throws IOException {
    composeBaseElements(element);
    if (element.hasUid()) {
      composeHIER_OBJECT_ID("uid", element.getUid());
    }
    if (element.hasVersions()) { 
      for (OBJECT_REF e : element.getVersionsList()) 
          composeOBJECT_REF("versions", e); // a
    }
    if (element.hasAudit()) {
      composeAUDIT_DETAILS("audit", element.getAudit());
    }
  }

  protected void composeDV_BOOLEAN(String name, DV_BOOLEAN element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_BOOLEANElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_BOOLEANElements(DV_BOOLEAN element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasValueElement()) {
      composeBoolean("value", element.getValueElement());
    }
  }

  protected void composeDV_CODED_TEXT(String name, DV_CODED_TEXT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_CODED_TEXTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_CODED_TEXTElements(DV_CODED_TEXT element) throws IOException {
    composeDV_TEXTElements(element);
    if (element.hasDefining_code()) {
      composeCODE_PHRASE("defining_code", element.getDefining_code());
    }
  }

  protected void composeDV_COUNT(String name, DV_COUNT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_COUNTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_COUNTElements(DV_COUNT element) throws IOException {
    composeDV_AMOUNTElements(element);
    if (element.hasMagnitudeElement()) {
      composeDecimal("magnitude", element.getMagnitudeElement());
    }
  }

  protected void composeDV_DATE_TIME(String name, DV_DATE_TIME element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_DATE_TIMEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_DATE_TIMEElements(DV_DATE_TIME element) throws IOException {
    composeDV_ORDEREDElements(element);
    if (element.hasValueElement()) {
      composeDateTime("value", element.getValueElement());
    }
  }

  protected void composeDV_DATE(String name, DV_DATE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_DATEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_DATEElements(DV_DATE element) throws IOException {
    composeDV_TEMPORALElements(element);
    if (element.hasValueElement()) {
      composeDateTime("value", element.getValueElement());
    }
  }

  protected void composeDV_DURATION(String name, DV_DURATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_DURATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_DURATIONElements(DV_DURATION element) throws IOException {
    composeDV_AMOUNTElements(element);
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
  }

  protected void composeDV_EHR_URI(String name, DV_EHR_URI element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_EHR_URIElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_EHR_URIElements(DV_EHR_URI element) throws IOException {
    composeDV_URIElements(element);
  }

  protected void composeDV_GENERAL_TIME_SPECIFICATION(String name, DV_GENERAL_TIME_SPECIFICATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_GENERAL_TIME_SPECIFICATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_GENERAL_TIME_SPECIFICATIONElements(DV_GENERAL_TIME_SPECIFICATION element) throws IOException {
    composeDV_TIME_SPECIFICATIONElements(element);
  }

  protected void composeDV_IDENTIFIER(String name, DV_IDENTIFIER element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_IDENTIFIERElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_IDENTIFIERElements(DV_IDENTIFIER element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasIssuerElement()) {
      composeString("issuer", element.getIssuerElement());
    }
    if (element.hasAssignerElement()) {
      composeString("assigner", element.getAssignerElement());
    }
    if (element.hasIdElement()) {
      composeString("id", element.getIdElement());
    }
    if (element.hasTypeElement()) {
      composeString("type", element.getTypeElement());
    }
  }

  protected void composeDV_INTERVAL(String name, DV_INTERVAL element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_INTERVALElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_INTERVALElements(DV_INTERVAL element) throws IOException {
    composeDV_ORDEREDElements(element);
  }

  protected void composeDV_MULTIMEDIA(String name, DV_MULTIMEDIA element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_MULTIMEDIAElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_MULTIMEDIAElements(DV_MULTIMEDIA element) throws IOException {
    composeDV_ENCAPSULATEDElements(element);
    if (element.hasAlternate_textElement()) {
      composeString("alternate_text", element.getAlternate_textElement());
    }
    if (element.hasUri()) {
      composeDV_URI("uri", element.getUri());
    }
    if (element.hasDataElement()) {
      composeBase64Binary("data", element.getDataElement());
    }
    if (element.hasMedia_type()) {
      composeCODE_PHRASE("media_type", element.getMedia_type());
    }
    if (element.hasCompression_algorithm()) {
      composeCODE_PHRASE("compression_algorithm", element.getCompression_algorithm());
    }
    if (element.hasIntegrity_checkElement()) {
      composeBase64Binary("integrity_check", element.getIntegrity_checkElement());
    }
    if (element.hasIntegrity_check_algorithm()) {
      composeCODE_PHRASE("integrity_check_algorithm", element.getIntegrity_check_algorithm());
    }
    if (element.hasThumbnail()) {
      composeDV_MULTIMEDIA("thumbnail", element.getThumbnail());
    }
    if (element.hasSizeElement()) {
      composeInteger("size", element.getSizeElement());
    }
  }

  protected void composeDV_ORDINAL(String name, DV_ORDINAL element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_ORDINALElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_ORDINALElements(DV_ORDINAL element) throws IOException {
    composeDV_ORDEREDElements(element);
    if (element.hasSymbol()) {
      composeDV_CODED_TEXT("symbol", element.getSymbol());
    }
    if (element.hasValueElement()) {
      composeInteger("value", element.getValueElement());
    }
  }

  protected void composeDV_PARAGRAPH(String name, DV_PARAGRAPH element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_PARAGRAPHElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_PARAGRAPHElements(DV_PARAGRAPH element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasItems()) { 
      for (DV_TEXT e : element.getItemsList()) 
          composeDV_TEXT("items", e); // a
    }
  }

  protected void composeDV_PARSABLE(String name, DV_PARSABLE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_PARSABLEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_PARSABLEElements(DV_PARSABLE element) throws IOException {
    composeDV_ENCAPSULATEDElements(element);
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
    if (element.hasFormalismElement()) {
      composeString("formalism", element.getFormalismElement());
    }
  }

  protected void composeDV_PERIODIC_TIME_SPECIFICATION(String name, DV_PERIODIC_TIME_SPECIFICATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_PERIODIC_TIME_SPECIFICATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_PERIODIC_TIME_SPECIFICATIONElements(DV_PERIODIC_TIME_SPECIFICATION element) throws IOException {
    composeDV_TIME_SPECIFICATIONElements(element);
  }

  protected void composeDV_PROPORTION(String name, DV_PROPORTION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_PROPORTIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_PROPORTIONElements(DV_PROPORTION element) throws IOException {
    composeDV_AMOUNTElements(element);
    if (element.hasNumeratorElement()) {
      composeDecimal("numerator", element.getNumeratorElement());
    }
    if (element.hasDenominatorElement()) {
      composeDecimal("denominator", element.getDenominatorElement());
    }
    if (element.hasTypeElement()) {
      composeCode("type", element.getTypeElement());
    }
    if (element.hasPrecisionElement()) {
      composeInteger("precision", element.getPrecisionElement());
    }
  }

  protected void composeDV_QUANTITY(String name, DV_QUANTITY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_QUANTITYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_QUANTITYElements(DV_QUANTITY element) throws IOException {
    composeDV_AMOUNTElements(element);
    if (element.hasMagnitudeElement()) {
      composeDecimal("magnitude", element.getMagnitudeElement());
    }
    if (element.hasPrecisionElement()) {
      composeInteger("precision", element.getPrecisionElement());
    }
    if (element.hasUnitsElement()) {
      composeString("units", element.getUnitsElement());
    }
    if (element.hasUnits_systemElement()) {
      composeString("units_system", element.getUnits_systemElement());
    }
    if (element.hasUnits_display_nameElement()) {
      composeString("units_display_name", element.getUnits_display_nameElement());
    }
  }

  protected void composeDV_SCALE(String name, DV_SCALE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_SCALEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_SCALEElements(DV_SCALE element) throws IOException {
    composeDV_ORDEREDElements(element);
    if (element.hasSymbol()) {
      composeDV_CODED_TEXT("symbol", element.getSymbol());
    }
    if (element.hasValueElement()) {
      composeDecimal("value", element.getValueElement());
    }
  }

  protected void composeDV_STATE(String name, DV_STATE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_STATEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_STATEElements(DV_STATE element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasValue()) {
      composeDV_CODED_TEXT("value", element.getValue());
    }
    if (element.hasIs_terminalElement()) {
      composeBoolean("is_terminal", element.getIs_terminalElement());
    }
  }

  protected void composeDV_TEXT(String name, DV_TEXT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_TEXTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_TEXTElements(DV_TEXT element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
    if (element.hasHyperlink()) {
      composeDV_URI("hyperlink", element.getHyperlink());
    }
    if (element.hasFormattingElement()) {
      composeString("formatting", element.getFormattingElement());
    }
    if (element.hasMappings()) { 
      for (TERM_MAPPING e : element.getMappingsList()) 
          composeTERM_MAPPING("mappings", e); // a
    }
    if (element.hasLanguage()) {
      composeCODE_PHRASE("language", element.getLanguage());
    }
    if (element.hasEncoding()) {
      composeCODE_PHRASE("encoding", element.getEncoding());
    }
  }

  protected void composeDV_TIME(String name, DV_TIME element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_TIMEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_TIMEElements(DV_TIME element) throws IOException {
    composeDV_ORDEREDElements(element);
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
  }

  protected void composeDV_URI(String name, DV_URI element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeDV_URIElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeDV_URIElements(DV_URI element) throws IOException {
    composeDATA_VALUEElements(element);
    if (element.hasValueElement()) {
      composeUri("value", element.getValueElement());
    }
  }

  protected void composeEHR_ACCESS(String name, EHR_ACCESS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeEHR_ACCESSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeEHR_ACCESSElements(EHR_ACCESS element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasSettings()) {
      composeACCESS_CONTROL_SETTINGS("settings", element.getSettings());
    }
  }

  protected void composeEHR_STATUS(String name, EHR_STATUS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeEHR_STATUSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeEHR_STATUSElements(EHR_STATUS element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasSubject()) {
      composePARTY_SELF("subject", element.getSubject());
    }
    if (element.hasIs_queryableElement()) {
      composeBoolean("is_queryable", element.getIs_queryableElement());
    }
    if (element.hasIs_modifiableElement()) {
      composeBoolean("is_modifiable", element.getIs_modifiableElement());
    }
    if (element.hasOther_details()) {
      composeITEM_STRUCTURE("other_details", element.getOther_details());
    }
  }

  protected void composeEHR(String name, EHR element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeEHRElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeEHRElements(EHR element) throws IOException {
    composeAnyElements(element);
    if (element.hasSystem_id()) { 
      for (HIER_OBJECT_ID e : element.getSystem_idList()) 
          composeHIER_OBJECT_ID("system_id", e); // a
    }
    if (element.hasEhr_id()) {
      composeHIER_OBJECT_ID("ehr_id", element.getEhr_id());
    }
    if (element.hasContributions()) { 
      for (OBJECT_REF e : element.getContributionsList()) 
          composeOBJECT_REF("contributions", e); // a
    }
    if (element.hasEhr_status()) {
      composeOBJECT_REF("ehr_status", element.getEhr_status());
    }
    if (element.hasEhr_access()) {
      composeOBJECT_REF("ehr_access", element.getEhr_access());
    }
    if (element.hasCompositions()) { 
      for (OBJECT_REF e : element.getCompositionsList()) 
          composeOBJECT_REF("compositions", e); // a
    }
    if (element.hasDirectory()) {
      composeOBJECT_REF("directory", element.getDirectory());
    }
    if (element.hasTime_created()) {
      composeDV_DATE_TIME("time_created", element.getTime_created());
    }
    if (element.hasFolders()) { 
      for (OBJECT_REF e : element.getFoldersList()) 
          composeOBJECT_REF("folders", e); // a
    }
    if (element.hasTags()) { 
      for (OBJECT_REF e : element.getTagsList()) 
          composeOBJECT_REF("tags", e); // a
    }
  }

  protected void composeELEMENT(String name, ELEMENT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeELEMENTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeELEMENTElements(ELEMENT element) throws IOException {
    composeITEMElements(element);
    if (element.hasNull_flavour()) {
      composeDV_CODED_TEXT("null_flavour", element.getNull_flavour());
    }
    if (element.hasValue()) {
      composeDATA_VALUE("value", element.getValue());
    }
    if (element.hasNull_reason()) {
      composeDV_TEXT("null_reason", element.getNull_reason());
    }
  }

  protected void composeEVALUATION(String name, EVALUATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeEVALUATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeEVALUATIONElements(EVALUATION element) throws IOException {
    composeCARE_ENTRYElements(element);
    if (element.hasData()) {
      composeITEM_STRUCTURE("data", element.getData());
    }
  }

  protected void composeEVENT_CONTEXT(String name, EVENT_CONTEXT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeEVENT_CONTEXTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeEVENT_CONTEXTElements(EVENT_CONTEXT element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasStart_time()) {
      composeDV_DATE_TIME("start_time", element.getStart_time());
    }
    if (element.hasEnd_time()) {
      composeDV_DATE_TIME("end_time", element.getEnd_time());
    }
    if (element.hasLocationElement()) {
      composeString("location", element.getLocationElement());
    }
    if (element.hasSetting()) {
      composeDV_CODED_TEXT("setting", element.getSetting());
    }
    if (element.hasOther_context()) {
      composeITEM_STRUCTURE("other_context", element.getOther_context());
    }
    if (element.hasHealth_care_facility()) {
      composePARTY_IDENTIFIED("health_care_facility", element.getHealth_care_facility());
    }
    if (element.hasParticipations()) { 
      for (PARTICIPATION e : element.getParticipationsList()) 
          composePARTICIPATION("participations", e); // a
    }
  }

  protected void composeFEEDER_AUDIT_DETAILS(String name, FEEDER_AUDIT_DETAILS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeFEEDER_AUDIT_DETAILSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeFEEDER_AUDIT_DETAILSElements(FEEDER_AUDIT_DETAILS element) throws IOException {
    composeBaseElements(element);
    if (element.hasSystem_idElement()) {
      composeString("system_id", element.getSystem_idElement());
    }
    if (element.hasLocation()) {
      composePARTY_IDENTIFIED("location", element.getLocation());
    }
    if (element.hasSubject()) {
      composePARTY_PROXY("subject", element.getSubject());
    }
    if (element.hasProvider()) {
      composePARTY_IDENTIFIED("provider", element.getProvider());
    }
    if (element.hasTime()) {
      composeDV_DATE_TIME("time", element.getTime());
    }
    if (element.hasVersion_idElement()) {
      composeString("version_id", element.getVersion_idElement());
    }
    if (element.hasOther_details()) {
      composeITEM_STRUCTURE("other_details", element.getOther_details());
    }
  }

  protected void composeFEEDER_AUDIT(String name, FEEDER_AUDIT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeFEEDER_AUDITElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeFEEDER_AUDITElements(FEEDER_AUDIT element) throws IOException {
    composeBaseElements(element);
    if (element.hasOriginating_system_item_ids()) { 
      for (DV_IDENTIFIER e : element.getOriginating_system_item_idsList()) 
          composeDV_IDENTIFIER("originating_system_item_ids", e); // a
    }
    if (element.hasFeeder_system_item_ids()) { 
      for (DV_IDENTIFIER e : element.getFeeder_system_item_idsList()) 
          composeDV_IDENTIFIER("feeder_system_item_ids", e); // a
    }
    if (element.hasOriginal_content()) {
      composeDV_ENCAPSULATED("original_content", element.getOriginal_content());
    }
    if (element.hasOriginating_system_audit()) {
      composeFEEDER_AUDIT_DETAILS("originating_system_audit", element.getOriginating_system_audit());
    }
    if (element.hasFeeder_system_audit()) {
      composeFEEDER_AUDIT_DETAILS("feeder_system_audit", element.getFeeder_system_audit());
    }
  }

  protected void composeFOLDER(String name, FOLDER element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeFOLDERElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeFOLDERElements(FOLDER element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasItems()) { 
      for (OBJECT_REF e : element.getItemsList()) 
          composeOBJECT_REF("items", e); // a
    }
    if (element.hasFolders()) { 
      for (FOLDER e : element.getFoldersList()) 
          composeFOLDER("folders", e); // a
    }
    if (element.hasDetails()) {
      composeITEM_STRUCTURE("details", element.getDetails());
    }
  }

  protected void composeGENERIC_ID(String name, GENERIC_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeGENERIC_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeGENERIC_IDElements(GENERIC_ID element) throws IOException {
    composeOBJECT_IDElements(element);
  }

  protected void composeGROUP(String name, GROUP element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeGROUPElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeGROUPElements(GROUP element) throws IOException {
    composeACTORElements(element);
  }

  protected void composeHIER_OBJECT_ID(String name, HIER_OBJECT_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeHIER_OBJECT_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeHIER_OBJECT_IDElements(HIER_OBJECT_ID element) throws IOException {
    composeUID_BASED_IDElements(element);
  }

  protected void composeHISTORY(String name, HISTORY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeHISTORYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeHISTORYElements(HISTORY element) throws IOException {
    composeDATA_STRUCTUREElements(element);
    if (element.hasOrigin()) {
      composeDV_DATE_TIME("origin", element.getOrigin());
    }
    if (element.hasPeriod()) {
      composeDV_DURATION("period", element.getPeriod());
    }
    if (element.hasDuration()) {
      composeDV_DURATION("duration", element.getDuration());
    }
    if (element.hasSummary()) {
      composeITEM_STRUCTURE("summary", element.getSummary());
    }
    if (element.hasEvents()) { 
      for (EVENT e : element.getEventsList()) 
          composeEVENT("events", e); // a
    }
  }

  protected void composeIMPORTED_VERSION(String name, IMPORTED_VERSION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeIMPORTED_VERSIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeIMPORTED_VERSIONElements(IMPORTED_VERSION element) throws IOException {
    composeVERSIONElements(element);
    if (element.hasItem()) {
      composeORIGINAL_VERSION("item", element.getItem());
    }
  }

  protected void composeINSTRUCTION_DETAILS(String name, INSTRUCTION_DETAILS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeINSTRUCTION_DETAILSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeINSTRUCTION_DETAILSElements(INSTRUCTION_DETAILS element) throws IOException {
    composePATHABLEElements(element);
    if (element.hasInstruction_id()) {
      composeLOCATABLE_REF("instruction_id", element.getInstruction_id());
    }
    if (element.hasActivity_idElement()) {
      composeString("activity_id", element.getActivity_idElement());
    }
    if (element.hasWf_details()) {
      composeITEM_STRUCTURE("wf_details", element.getWf_details());
    }
  }

  protected void composeINSTRUCTION(String name, INSTRUCTION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeINSTRUCTIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeINSTRUCTIONElements(INSTRUCTION element) throws IOException {
    composeCARE_ENTRYElements(element);
    if (element.hasNarrative()) {
      composeDV_TEXT("narrative", element.getNarrative());
    }
    if (element.hasExpiry_time()) {
      composeDV_DATE_TIME("expiry_time", element.getExpiry_time());
    }
    if (element.hasWf_definition()) {
      composeDV_PARSABLE("wf_definition", element.getWf_definition());
    }
    if (element.hasActivities()) { 
      for (ACTIVITY e : element.getActivitiesList()) 
          composeACTIVITY("activities", e); // a
    }
  }

  protected void composeINTERNET_ID(String name, INTERNET_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeINTERNET_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeINTERNET_IDElements(INTERNET_ID element) throws IOException {
    composeUIDElements(element);
  }

  protected void composeINTERVAL_EVENT(String name, INTERVAL_EVENT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeINTERVAL_EVENTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeINTERVAL_EVENTElements(INTERVAL_EVENT element) throws IOException {
    composeEVENTElements(element);
    if (element.hasWidth()) {
      composeDV_DURATION("width", element.getWidth());
    }
    if (element.hasSample_countElement()) {
      composeInteger("sample_count", element.getSample_countElement());
    }
    if (element.hasMath_function()) {
      composeDV_CODED_TEXT("math_function", element.getMath_function());
    }
  }

  protected void composeISM_TRANSITION(String name, ISM_TRANSITION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeISM_TRANSITIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeISM_TRANSITIONElements(ISM_TRANSITION element) throws IOException {
    composePATHABLEElements(element);
    if (element.hasCurrent_state()) {
      composeDV_CODED_TEXT("current_state", element.getCurrent_state());
    }
    if (element.hasTransition()) {
      composeDV_CODED_TEXT("transition", element.getTransition());
    }
    if (element.hasCareflow_step()) {
      composeDV_CODED_TEXT("careflow_step", element.getCareflow_step());
    }
    if (element.hasReason()) { 
      for (DV_TEXT e : element.getReasonList()) 
          composeDV_TEXT("reason", e); // a
    }
  }

  protected void composeISO_OID(String name, ISO_OID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeISO_OIDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeISO_OIDElements(ISO_OID element) throws IOException {
    composeUIDElements(element);
  }

  protected void composeITEM_LIST(String name, ITEM_LIST element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeITEM_LISTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeITEM_LISTElements(ITEM_LIST element) throws IOException {
    composeITEM_STRUCTUREElements(element);
    if (element.hasItems()) { 
      for (ELEMENT e : element.getItemsList()) 
          composeELEMENT("items", e); // a
    }
  }

  protected void composeITEM_SINGLE(String name, ITEM_SINGLE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeITEM_SINGLEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeITEM_SINGLEElements(ITEM_SINGLE element) throws IOException {
    composeITEM_STRUCTUREElements(element);
    if (element.hasItem()) {
      composeELEMENT("item", element.getItem());
    }
  }

  protected void composeITEM_TABLE(String name, ITEM_TABLE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeITEM_TABLEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeITEM_TABLEElements(ITEM_TABLE element) throws IOException {
    composeITEM_STRUCTUREElements(element);
    if (element.hasRows()) { 
      for (CLUSTER e : element.getRowsList()) 
          composeCLUSTER("rows", e); // a
    }
  }

  protected void composeITEM_TAG(String name, ITEM_TAG element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeITEM_TAGElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeITEM_TAGElements(ITEM_TAG element) throws IOException {
    composeBaseElements(element);
    if (element.hasKeyElement()) {
      composeString("key", element.getKeyElement());
    }
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
    if (element.hasTarget()) {
      composeUID_BASED_ID("target", element.getTarget());
    }
    if (element.hasTarget_pathElement()) {
      composeString("target_path", element.getTarget_pathElement());
    }
    if (element.hasOwner_id()) {
      composeOBJECT_REF("owner_id", element.getOwner_id());
    }
  }

  protected void composeITEM_TREE(String name, ITEM_TREE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeITEM_TREEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeITEM_TREEElements(ITEM_TREE element) throws IOException {
    composeITEM_STRUCTUREElements(element);
    if (element.hasItems()) { 
      for (ITEM e : element.getItemsList()) 
          composeITEM("items", e); // a
    }
  }

  protected void composeLINK(String name, LINK element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeLINKElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeLINKElements(LINK element) throws IOException {
    composeBaseElements(element);
    if (element.hasMeaning()) {
      composeDV_TEXT("meaning", element.getMeaning());
    }
    if (element.hasType()) {
      composeDV_TEXT("type", element.getType());
    }
    if (element.hasTarget()) {
      composeDV_EHR_URI("target", element.getTarget());
    }
  }

  protected void composeLOCATABLE_REF(String name, LOCATABLE_REF element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeLOCATABLE_REFElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeLOCATABLE_REFElements(LOCATABLE_REF element) throws IOException {
    composeOBJECT_REFElements(element);
    if (element.hasPathElement()) {
      composeString("path", element.getPathElement());
    }
  }

  protected void composeOBJECT_REF(String name, OBJECT_REF element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeOBJECT_REFElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeOBJECT_REFElements(OBJECT_REF element) throws IOException {
    composeBaseElements(element);
    if (element.hasNamespaceElement()) {
      composeString("namespace", element.getNamespaceElement());
    }
    if (element.hasTypeElement()) {
      composeString("type", element.getTypeElement());
    }
    if (element.hasId()) {
      composeOBJECT_ID("id", element.getId());
    }
  }

  protected void composeOBJECT_VERSION_ID(String name, OBJECT_VERSION_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeOBJECT_VERSION_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeOBJECT_VERSION_IDElements(OBJECT_VERSION_ID element) throws IOException {
    composeUID_BASED_IDElements(element);
  }

  protected void composeOBSERVATION(String name, OBSERVATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeOBSERVATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeOBSERVATIONElements(OBSERVATION element) throws IOException {
    composeCARE_ENTRYElements(element);
    if (element.hasData()) {
      composeHISTORY("data", element.getData());
    }
    if (element.hasState()) {
      composeHISTORY("state", element.getState());
    }
  }

  protected void composeORGANISATION(String name, ORGANISATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeORGANISATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeORGANISATIONElements(ORGANISATION element) throws IOException {
    composeACTORElements(element);
  }

  protected void composeORIGINAL_VERSION(String name, ORIGINAL_VERSION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeORIGINAL_VERSIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeORIGINAL_VERSIONElements(ORIGINAL_VERSION element) throws IOException {
    composeVERSIONElements(element);
    if (element.hasUid()) {
      composeOBJECT_VERSION_ID("uid", element.getUid());
    }
    if (element.hasPreceding_version_uid()) {
      composeOBJECT_VERSION_ID("preceding_version_uid", element.getPreceding_version_uid());
    }
    if (element.hasOther_input_version_uids()) { 
      for (OBJECT_VERSION_ID e : element.getOther_input_version_uidsList()) 
          composeOBJECT_VERSION_ID("other_input_version_uids", e); // a
    }
    if (element.hasLifecycle_state()) {
      composeDV_CODED_TEXT("lifecycle_state", element.getLifecycle_state());
    }
    if (element.hasAttestations()) { 
      for (ATTESTATION e : element.getAttestationsList()) 
          composeATTESTATION("attestations", e); // a
    }
    if (element.hasData()) {
      composeAny("data", element.getData());
    }
  }

  protected void composePARTICIPATION(String name, PARTICIPATION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePARTICIPATIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePARTICIPATIONElements(PARTICIPATION element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasFunction()) {
      composeDV_TEXT("function", element.getFunction());
    }
    if (element.hasMode()) {
      composeDV_CODED_TEXT("mode", element.getMode());
    }
    if (element.hasPerformer()) {
      composePARTY_PROXY("performer", element.getPerformer());
    }
    if (element.hasTime()) {
      composeDV_INTERVAL("time", element.getTime());
    }
  }

  protected void composePARTY_IDENTIFIED(String name, PARTY_IDENTIFIED element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePARTY_IDENTIFIEDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePARTY_IDENTIFIEDElements(PARTY_IDENTIFIED element) throws IOException {
    composePARTY_PROXYElements(element);
    if (element.hasNameElement()) {
      composeString("name", element.getNameElement());
    }
    if (element.hasIdentifiers()) { 
      for (DV_IDENTIFIER e : element.getIdentifiersList()) 
          composeDV_IDENTIFIER("identifiers", e); // a
    }
  }

  protected void composePARTY_IDENTITY(String name, PARTY_IDENTITY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePARTY_IDENTITYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePARTY_IDENTITYElements(PARTY_IDENTITY element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasDetails()) {
      composeITEM_STRUCTURE("details", element.getDetails());
    }
  }

  protected void composePARTY_REF(String name, PARTY_REF element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePARTY_REFElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePARTY_REFElements(PARTY_REF element) throws IOException {
    composeOBJECT_REFElements(element);
  }

  protected void composePARTY_RELATED(String name, PARTY_RELATED element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePARTY_RELATEDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePARTY_RELATEDElements(PARTY_RELATED element) throws IOException {
    composePARTY_IDENTIFIEDElements(element);
    if (element.hasRelationship()) {
      composeDV_CODED_TEXT("relationship", element.getRelationship());
    }
  }

  protected void composePARTY_RELATIONSHIP(String name, PARTY_RELATIONSHIP element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePARTY_RELATIONSHIPElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePARTY_RELATIONSHIPElements(PARTY_RELATIONSHIP element) throws IOException {
    composeLOCATABLEElements(element);
    if (element.hasDetails()) {
      composeITEM_STRUCTURE("details", element.getDetails());
    }
    if (element.hasTarget()) {
      composePARTY_REF("target", element.getTarget());
    }
    if (element.hasTime_validity()) {
      composeDV_INTERVAL("time_validity", element.getTime_validity());
    }
    if (element.hasSource()) {
      composePARTY_REF("source", element.getSource());
    }
  }

  protected void composePARTY_SELF(String name, PARTY_SELF element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePARTY_SELFElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePARTY_SELFElements(PARTY_SELF element) throws IOException {
    composePARTY_PROXYElements(element);
  }

  protected void composePERSON(String name, PERSON element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePERSONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePERSONElements(PERSON element) throws IOException {
    composeACTORElements(element);
  }

  protected void composePOINT_EVENT(String name, POINT_EVENT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composePOINT_EVENTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composePOINT_EVENTElements(POINT_EVENT element) throws IOException {
    composeEVENTElements(element);
  }

  protected void composeREFERENCE_RANGE(String name, REFERENCE_RANGE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeREFERENCE_RANGEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeREFERENCE_RANGEElements(REFERENCE_RANGE element) throws IOException {
    composeBaseElements(element);
    if (element.hasMeaning()) {
      composeDV_TEXT("meaning", element.getMeaning());
    }
    if (element.hasRange()) {
      composeDV_INTERVAL("range", element.getRange());
    }
  }

  protected void composeRESOURCE_DESCRIPTION_ITEM(String name, RESOURCE_DESCRIPTION_ITEM element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeRESOURCE_DESCRIPTION_ITEMElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeRESOURCE_DESCRIPTION_ITEMElements(RESOURCE_DESCRIPTION_ITEM element) throws IOException {
    composeBaseElements(element);
    if (element.hasLanguage()) {
      composeCODE_PHRASE("language", element.getLanguage());
    }
    if (element.hasPurposeElement()) {
      composeString("purpose", element.getPurposeElement());
    }
    if (element.hasKeywords()) { 
      for (StringType e : element.getKeywordsList()) 
          composeString("keywords", e); // a
    }
    if (element.hasUseElement()) {
      composeString("use", element.getUseElement());
    }
    if (element.hasMisuseElement()) {
      composeString("misuse", element.getMisuseElement());
    }
    if (element.hasCopyrightElement()) {
      composeString("copyright", element.getCopyrightElement());
    }
    if (element.hasOriginal_resource_uri()) { 
      for (StringType e : element.getOriginal_resource_uriList()) 
          composeString("original_resource_uri", e); // a
    }
    if (element.hasOther_details()) { 
      for (StringType e : element.getOther_detailsList()) 
          composeString("other_details", e); // a
    }
  }

  protected void composeRESOURCE_DESCRIPTION(String name, RESOURCE_DESCRIPTION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeRESOURCE_DESCRIPTIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeRESOURCE_DESCRIPTIONElements(RESOURCE_DESCRIPTION element) throws IOException {
    composeBaseElements(element);
    if (element.hasOriginal_author()) { 
      for (StringType e : element.getOriginal_authorList()) 
          composeString("original_author", e); // a
    }
    if (element.hasOther_contributors()) { 
      for (StringType e : element.getOther_contributorsList()) 
          composeString("other_contributors", e); // a
    }
    if (element.hasLifecycle_stateElement()) {
      composeString("lifecycle_state", element.getLifecycle_stateElement());
    }
    if (element.hasResource_package_uriElement()) {
      composeString("resource_package_uri", element.getResource_package_uriElement());
    }
    if (element.hasOther_details()) { 
      for (OBJECT_REF e : element.getOther_detailsList()) 
          composeOBJECT_REF("other_details", e); // a
    }
    if (element.hasParent_resource()) {
      composeAUTHORED_RESOURCE("parent_resource", element.getParent_resource());
    }
    if (element.hasDetails()) { 
      for (RESOURCE_DESCRIPTION_ITEM e : element.getDetailsList()) 
          composeRESOURCE_DESCRIPTION_ITEM("details", e); // a
    }
  }

  protected void composeREVISION_HISTORY_ITEM(String name, REVISION_HISTORY_ITEM element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeREVISION_HISTORY_ITEMElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeREVISION_HISTORY_ITEMElements(REVISION_HISTORY_ITEM element) throws IOException {
    composeBaseElements(element);
    if (element.hasVersion_id()) {
      composeOBJECT_VERSION_ID("version_id", element.getVersion_id());
    }
    if (element.hasAudits()) { 
      for (AUDIT_DETAILS e : element.getAuditsList()) 
          composeAUDIT_DETAILS("audits", e); // a
    }
  }

  protected void composeREVISION_HISTORY(String name, REVISION_HISTORY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeREVISION_HISTORYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeREVISION_HISTORYElements(REVISION_HISTORY element) throws IOException {
    composeBaseElements(element);
    if (element.hasMost_recent_versionElement()) {
      composeString("most_recent_version", element.getMost_recent_versionElement());
    }
    if (element.hasMost_recent_version_time_committedElement()) {
      composeString("most_recent_version_time_committed", element.getMost_recent_version_time_committedElement());
    }
  }

  protected void composeROLE(String name, ROLE element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeROLEElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeROLEElements(ROLE element) throws IOException {
    composePARTYElements(element);
    if (element.hasTime_validity()) {
      composeDV_INTERVAL("time_validity", element.getTime_validity());
    }
    if (element.hasPerformer()) {
      composePARTY_REF("performer", element.getPerformer());
    }
    if (element.hasCapabilities()) { 
      for (CAPABILITY e : element.getCapabilitiesList()) 
          composeCAPABILITY("capabilities", e); // a
    }
  }

  protected void composeSECTION(String name, SECTION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeSECTIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeSECTIONElements(SECTION element) throws IOException {
    composeCONTENT_ITEMElements(element);
    if (element.hasItems()) { 
      for (CONTENT_ITEM e : element.getItemsList()) 
          composeCONTENT_ITEM("items", e); // a
    }
  }

  protected void composeTEMPLATE_ID(String name, TEMPLATE_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTEMPLATE_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTEMPLATE_IDElements(TEMPLATE_ID element) throws IOException {
    composeOBJECT_IDElements(element);
  }

  protected void composeTERM_MAPPING(String name, TERM_MAPPING element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTERM_MAPPINGElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTERM_MAPPINGElements(TERM_MAPPING element) throws IOException {
    composeBaseElements(element);
    if (element.hasMatchElement()) {
      composeString("match", element.getMatchElement());
    }
    if (element.hasPurpose()) {
      composeDV_CODED_TEXT("purpose", element.getPurpose());
    }
    if (element.hasTarget()) {
      composeCODE_PHRASE("target", element.getTarget());
    }
  }

  protected void composeTERMINOLOGY_ID(String name, TERMINOLOGY_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTERMINOLOGY_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTERMINOLOGY_IDElements(TERMINOLOGY_ID element) throws IOException {
    composeOBJECT_IDElements(element);
  }

  protected void composeTRANSLATION_DETAILS(String name, TRANSLATION_DETAILS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTRANSLATION_DETAILSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTRANSLATION_DETAILSElements(TRANSLATION_DETAILS element) throws IOException {
    composeBaseElements(element);
    if (element.hasLanguage()) {
      composeCODE_PHRASE("language", element.getLanguage());
    }
    if (element.hasAuthor()) { 
      for (StringType e : element.getAuthorList()) 
          composeString("author", e); // a
    }
    if (element.hasAccreditationElement()) {
      composeString("accreditation", element.getAccreditationElement());
    }
    if (element.hasOther_details()) { 
      for (StringType e : element.getOther_detailsList()) 
          composeString("other_details", e); // a
    }
  }

  protected void composeTranslatedString(String name, TranslatedString element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTranslatedStringElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTranslatedStringElements(TranslatedString element) throws IOException {
    composeBaseElements(element);
    if (element.hasLanguageElement()) {
      composeCode("language", element.getLanguageElement());
    }
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
  }

  protected void composeUUID(String name, UUID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeUUIDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeUUIDElements(UUID element) throws IOException {
    composeUIDElements(element);
  }

  protected void composeVERSION_TREE_ID(String name, VERSION_TREE_ID element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeVERSION_TREE_IDElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeVERSION_TREE_IDElements(VERSION_TREE_ID element) throws IOException {
    composeBaseElements(element);
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
  }

  protected void composeVERSIONED_COMPOSITION(String name, VERSIONED_COMPOSITION element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeVERSIONED_COMPOSITIONElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeVERSIONED_COMPOSITIONElements(VERSIONED_COMPOSITION element) throws IOException {
    composeVERSIONED_OBJECTElements(element);
  }

  protected void composeVERSIONED_EHR_ACCESS(String name, VERSIONED_EHR_ACCESS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeVERSIONED_EHR_ACCESSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeVERSIONED_EHR_ACCESSElements(VERSIONED_EHR_ACCESS element) throws IOException {
    composeVERSIONED_OBJECTElements(element);
  }

  protected void composeVERSIONED_EHR_STATUS(String name, VERSIONED_EHR_STATUS element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeVERSIONED_EHR_STATUSElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeVERSIONED_EHR_STATUSElements(VERSIONED_EHR_STATUS element) throws IOException {
    composeVERSIONED_OBJECTElements(element);
  }

  protected void composeVERSIONED_FOLDER(String name, VERSIONED_FOLDER element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeVERSIONED_FOLDERElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeVERSIONED_FOLDERElements(VERSIONED_FOLDER element) throws IOException {
    composeVERSIONED_OBJECTElements(element);
  }

  protected void composeVERSIONED_OBJECT(String name, VERSIONED_OBJECT element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeVERSIONED_OBJECTElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeVERSIONED_OBJECTElements(VERSIONED_OBJECT element) throws IOException {
    composeBaseElements(element);
    if (element.hasUid()) {
      composeHIER_OBJECT_ID("uid", element.getUid());
    }
    if (element.hasOwner_id()) {
      composeOBJECT_REF("owner_id", element.getOwner_id());
    }
    if (element.hasTime_created()) {
      composeDV_DATE_TIME("time_created", element.getTime_created());
    }
  }

  protected void composeVERSIONED_PARTY(String name, VERSIONED_PARTY element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeVERSIONED_PARTYElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeVERSIONED_PARTYElements(VERSIONED_PARTY element) throws IOException {
    composeVERSIONED_OBJECTElements(element);
  }

  protected void composeWebTemplate(String name, WebTemplate element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateElements(WebTemplate element) throws IOException {
    composeBaseElements(element);
    if (element.hasTemplateIdElement()) {
      composeString("templateId", element.getTemplateIdElement());
    }
    if (element.hasVersionElement()) {
      composeString("version", element.getVersionElement());
    }
    if (element.hasSemverElement()) {
      composeString("semver", element.getSemverElement());
    }
    if (element.hasDefaultLanguageElement()) {
      composeString("defaultLanguage", element.getDefaultLanguageElement());
    }
    if (element.hasLanguages()) { 
      for (StringType e : element.getLanguagesList()) 
          composeString("languages", e); // a
    }
    if (element.hasTree()) {
      composeWebTemplateItem("tree", element.getTree());
    }
  }

  protected void composeWebTemplateInput(String name, WebTemplateInput element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateInputElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateInputElements(WebTemplateInput element) throws IOException {
    composeBaseElements(element);
    if (element.hasSuffixElement()) {
      composeString("suffix", element.getSuffixElement());
    }
    if (element.hasTypeElement()) {
      composeCode("type", element.getTypeElement());
    }
    if (element.hasDefaultValue()) {
      composeNativePrimitive("defaultValue", element.getDefaultValue());
    }
    if (element.hasTerminologyElement()) {
      composeCode("terminology", element.getTerminologyElement());
    }
    if (element.hasValidation()) {
      composeWebTemplateInputValidation("validation", element.getValidation());
    }
    if (element.hasList()) { 
      for (WebTemplateInputListItem e : element.getListList()) 
          composeWebTemplateInputListItem("list", e); // a
    }
    if (element.hasListOpenElement()) {
      composeBoolean("listOpen", element.getListOpenElement());
    }
  }

  protected void composeWebTemplateInputListItem(String name, WebTemplateInputListItem element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateInputListItemElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateInputListItemElements(WebTemplateInputListItem element) throws IOException {
    composeBaseElements(element);
    if (element.hasValueElement()) {
      composeCode("value", element.getValueElement());
    }
    if (element.hasLabelElement()) {
      composeString("label", element.getLabelElement());
    }
    if (element.hasOrdinalElement()) {
      composeString("ordinal", element.getOrdinalElement());
    }
    if (element.hasLocalizedLabels()) { 
      for (TranslatedString e : element.getLocalizedLabelsList()) 
          composeTranslatedString("localizedLabels", e); // a
    }
    if (element.hasLocalizedDescriptions()) { 
      for (TranslatedString e : element.getLocalizedDescriptionsList()) 
          composeTranslatedString("localizedDescriptions", e); // a
    }
    if (element.hasCurrentStatesElement()) {
      composeString("currentStates", element.getCurrentStatesElement());
    }
    if (element.hasRangeElement()) {
      composeString("range", element.getRangeElement());
    }
    if (element.hasPrecisionElement()) {
      composeString("precision", element.getPrecisionElement());
    }
    if (element.hasTermBindings()) { 
      for (WebTemplateTermBinding e : element.getTermBindingsList()) 
          composeWebTemplateTermBinding("termBindings", e); // a
    }
  }

  protected void composeWebTemplateInputValidation(String name, WebTemplateInputValidation element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateInputValidationElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateInputValidationElements(WebTemplateInputValidation element) throws IOException {
    composeBaseElements(element);
    if (element.hasRange()) {
      composeWebTemplateInputValidationRange("range", element.getRange());
    }
    if (element.hasPrecision()) {
      composeWebTemplateInputValidationRange("precision", element.getPrecision());
    }
  }

  protected void composeWebTemplateInputValidationRange(String name, WebTemplateInputValidationRange element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateInputValidationRangeElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateInputValidationRangeElements(WebTemplateInputValidationRange element) throws IOException {
    composeBaseElements(element);
    if (element.hasMinOpElement()) {
      composeCode("minOp", element.getMinOpElement());
    }
    if (element.hasMinElement()) {
      composeDecimal("min", element.getMinElement());
    }
    if (element.hasMaxOpElement()) {
      composeCode("maxOp", element.getMaxOpElement());
    }
    if (element.hasMaxElement()) {
      composeDecimal("max", element.getMaxElement());
    }
  }

  protected void composeWebTemplateItem(String name, WebTemplateItem element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateItemElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateItemElements(WebTemplateItem element) throws IOException {
    composeBaseElements(element);
    if (element.hasIdElement()) {
      composeString("id", element.getIdElement());
    }
    if (element.hasDepthElement()) {
      composeInteger("depth", element.getDepthElement());
    }
    if (element.hasNameElement()) {
      composeString("name", element.getNameElement());
    }
    if (element.hasLocalizedNameElement()) {
      composeString("localizedName", element.getLocalizedNameElement());
    }
    if (element.hasRmTypeElement()) {
      composeCode("rmType", element.getRmTypeElement());
    }
    if (element.hasNodeIdElement()) {
      composeString("nodeId", element.getNodeIdElement());
    }
    if (element.hasMinElement()) {
      composeString("min", element.getMinElement());
    }
    if (element.hasMaxElement()) {
      composeString("max", element.getMaxElement());
    }
    if (element.hasDependsOnElement()) {
      composeString("dependsOn", element.getDependsOnElement());
    }
    if (element.hasLocalizedNames()) { 
      for (TranslatedString e : element.getLocalizedNamesList()) 
          composeTranslatedString("localizedNames", e); // a
    }
    if (element.hasLocalizedDescriptions()) { 
      for (TranslatedString e : element.getLocalizedDescriptionsList()) 
          composeTranslatedString("localizedDescriptions", e); // a
    }
    if (element.hasAnnotations()) {
      composeAnnotations("annotations", element.getAnnotations());
    }
    if (element.hasArchetype_idElement()) {
      composeString("archetype_id", element.getArchetype_idElement());
    }
    if (element.hasAqlPathElement()) {
      composeString("aqlPath", element.getAqlPathElement());
    }
    if (element.hasCustodian_namespaceElement()) {
      composeString("custodian_namespace", element.getCustodian_namespaceElement());
    }
    if (element.hasCustodian_organisationElement()) {
      composeString("custodian_organisation", element.getCustodian_organisationElement());
    }
    if (element.hasLifecycleStateElement()) {
      composeCode("lifecycleState", element.getLifecycleStateElement());
    }
    if (element.hasOriginal_namespaceElement()) {
      composeString("original_namespace", element.getOriginal_namespaceElement());
    }
    if (element.hasOriginal_publisherElement()) {
      composeString("original_publisher", element.getOriginal_publisherElement());
    }
    if (element.hasProportionTypesElement()) {
      composeCode("proportionTypes", element.getProportionTypesElement());
    }
    if (element.hasRevisionElement()) {
      composeString("revision", element.getRevisionElement());
    }
    if (element.hasInContextElement()) {
      composeBoolean("inContext", element.getInContextElement());
    }
    if (element.hasInputs()) { 
      for (WebTemplateInput e : element.getInputsList()) 
          composeWebTemplateInput("inputs", e); // a
    }
    if (element.hasTermBindings()) { 
      for (WebTemplateTermBinding e : element.getTermBindingsList()) 
          composeWebTemplateTermBinding("termBindings", e); // a
    }
    if (element.hasChildren()) { 
      for (WebTemplateItem e : element.getChildrenList()) 
          composeWebTemplateItem("children", e); // a
    }
  }

  protected void composeWebTemplateTermBinding(String name, WebTemplateTermBinding element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateTermBindingElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateTermBindingElements(WebTemplateTermBinding element) throws IOException {
    composeBaseElements(element);
    if (element.hasCodeElement()) {
      composeCode("code", element.getCodeElement());
    }
    if (element.hasValue()) {
      composeWebTemplateTermBindingValue("value", element.getValue());
    }
  }

  protected void composeWebTemplateTermBindingValue(String name, WebTemplateTermBindingValue element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeWebTemplateTermBindingValueElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeWebTemplateTermBindingValueElements(WebTemplateTermBindingValue element) throws IOException {
    composeBaseElements(element);
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
    if (element.hasTerminologyIdElement()) {
      composeString("terminologyId", element.getTerminologyIdElement());
    }
  }



  @Override
  protected void composeResource(Resource resource) throws IOException {
    if (resource == null) {
      throw new IOException("resource == null");
      
    } else {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    }
  }

  protected void composeResource(String name, Resource resource) throws IOException {
    if (name == null) {
      throw new IOException("name == null");
    } else if (resource == null) {
      throw new IOException("resource == null");
      
    } else {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    }
  }

  protected void composeType(String prefix, DataType type) throws IOException {
    if (prefix == null) {
      throw new IOException("prefix == null");
    } else if (type == null) {
      throw new IOException("type == null");

    } else if (type instanceof CodeType) {
       composeCode(prefix+"Code", (CodeType) type);
    } else if (type instanceof OidType) {
       composeOid(prefix+"Oid", (OidType) type);
    } else if (type instanceof CanonicalType) {
       composeCanonical(prefix+"Canonical", (CanonicalType) type);
    } else if (type instanceof UuidType) {
       composeUuid(prefix+"Uuid", (UuidType) type);
    } else if (type instanceof UrlType) {
       composeUrl(prefix+"Url", (UrlType) type);
    } else if (type instanceof UnsignedIntType) {
       composeUnsignedInt(prefix+"UnsignedInt", (UnsignedIntType) type);
    } else if (type instanceof MarkdownType) {
       composeMarkdown(prefix+"Markdown", (MarkdownType) type);
    } else if (type instanceof IdType) {
       composeId(prefix+"Id", (IdType) type);
    } else if (type instanceof PositiveIntType) {
       composePositiveInt(prefix+"PositiveInt", (PositiveIntType) type);
    } else if (type instanceof DateType) {
       composeDate(prefix+"Date", (DateType) type);
    } else if (type instanceof DateTimeType) {
       composeDateTime(prefix+"DateTime", (DateTimeType) type);
    } else if (type instanceof StringType) {
       composeString(prefix+"String", (StringType) type);
    } else if (type instanceof IntegerType) {
      composeInteger(prefix+"Integer", (IntegerType) type);
    } else if (type instanceof Integer64Type) {
      composeInteger64(prefix+"Integer64", (Integer64Type) type);
    } else if (type instanceof UriType) {
       composeUri(prefix+"Uri", (UriType) type);
    } else if (type instanceof InstantType) {
       composeInstant(prefix+"Instant", (InstantType) type);
    } else if (type instanceof BooleanType) {
       composeBoolean(prefix+"Boolean", (BooleanType) type);
    } else if (type instanceof Base64BinaryType) {
       composeBase64Binary(prefix+"Base64Binary", (Base64BinaryType) type);
    } else if (type instanceof TimeType) {
       composeTime(prefix+"Time", (TimeType) type);
    } else if (type instanceof DecimalType) {
       composeDecimal(prefix+"Decimal", (DecimalType) type);
    } else {
      throw new Error("Unhandled type "+type.fhirType());
    }
  }

}