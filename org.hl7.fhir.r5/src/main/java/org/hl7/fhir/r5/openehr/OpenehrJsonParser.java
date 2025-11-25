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



import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;

import org.hl7.fhir.r5.formats.JsonCreator;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.Utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class OpenehrJsonParser extends org.hl7.fhir.r5.formats.JsonParser {
 
  public OpenehrJsonParser(JsonCreator json) {
    super();
    this.json = json;
  }

  public OpenehrJsonParser(boolean allowUnknownContent, boolean allowComments) {
    super();
    setAllowUnknownContent(allowUnknownContent);
    setAllowComments(allowComments);
  }

  public Resource parseResource(JsonObject json) throws IOException, FHIRFormatError {
    if (!json.has("resourceType")) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
    }
    String t = json.get("resourceType").getAsString();
    if (Utilities.noString(t)) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");

    } else {
      throw new FHIRFormatError("Unknown/Unrecognised resource type '"+t+"' (in property 'resourceType')");
    }
  }

  protected ACCESS_CONTROL_SETTINGS parseACCESS_CONTROL_SETTINGS(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseACCESS_CONTROL_SETTINGSProperties(JsonObject json, ACCESS_CONTROL_SETTINGS res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
  }

  protected ACTOR parseACTOR(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "AGENT": return parseAGENT(json);
    case "GROUP": return parseGROUP(json);
    case "PERSON": return parsePERSON(json);
    case "ORGANISATION": return parseORGANISATION(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseACTORProperties(JsonObject json, ACTOR res) throws IOException, FHIRFormatError {
    parsePARTYProperties(json, res);
    if (json.has("languages")) {
      JsonArray array = getJArray(json, "languages");
      for (int i = 0; i < array.size(); i++) {
        res.getLanguagesList().add(parseDV_TEXT(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("roles")) {
      JsonArray array = getJArray(json, "roles");
      for (int i = 0; i < array.size(); i++) {
        res.getRolesList().add(parsePARTY_REF(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected AUTHORED_RESOURCE parseAUTHORED_RESOURCE(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseAUTHORED_RESOURCEProperties(JsonObject json, AUTHORED_RESOURCE res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("original_language"))
      res.setOriginal_language(parseCODE_PHRASE(getJObject(json, "original_language")));
    if (json.has("is_controlled"))
      res.setIs_controlledElement(parseBoolean(json.get("is_controlled").getAsBoolean()));
    if (json.has("_is_controlled"))
      parseElementProperties(getJObject(json, "_is_controlled"), res.getIs_controlledElement());
    if (json.has("translations")) {
      JsonArray array = getJArray(json, "translations");
      for (int i = 0; i < array.size(); i++) {
        res.getTranslationsList().add(parseTRANSLATION_DETAILS(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("description"))
      res.setDescription(parseRESOURCE_DESCRIPTION(getJObject(json, "description")));
    if (json.has("revision_history"))
      res.setRevision_history(parseREVISION_HISTORY(getJObject(json, "revision_history")));
  }

  protected Any parseAny(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "EHR": return parseEHR(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseAnyProperties(JsonObject json, Any res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
  }

  protected CARE_ENTRY parseCARE_ENTRY(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "INSTRUCTION": return parseINSTRUCTION(json);
    case "OBSERVATION": return parseOBSERVATION(json);
    case "ACTION": return parseACTION(json);
    case "EVALUATION": return parseEVALUATION(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseCARE_ENTRYProperties(JsonObject json, CARE_ENTRY res) throws IOException, FHIRFormatError {
    parseENTRYProperties(json, res);
    if (json.has("protocol"))
      res.setProtocol(parseITEM_STRUCTURE(getJObject(json, "protocol")));
    if (json.has("guideline_id"))
      res.setGuideline_id(parseOBJECT_REF(getJObject(json, "guideline_id")));
  }

  protected CONTENT_ITEM parseCONTENT_ITEM(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "SECTION": return parseSECTION(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseCONTENT_ITEMProperties(JsonObject json, CONTENT_ITEM res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
  }

  protected DATA_STRUCTURE parseDATA_STRUCTURE(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "HISTORY": return parseHISTORY(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDATA_STRUCTUREProperties(JsonObject json, DATA_STRUCTURE res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
  }

  protected DATA_VALUE parseDATA_VALUE(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "DV-TEXT": return parseDV_TEXT(json);
    case "DV-IDENTIFIER": return parseDV_IDENTIFIER(json);
    case "DV-BOOLEAN": return parseDV_BOOLEAN(json);
    case "DV-PARAGRAPH": return parseDV_PARAGRAPH(json);
    case "DV-URI": return parseDV_URI(json);
    case "DV-STATE": return parseDV_STATE(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDATA_VALUEProperties(JsonObject json, DATA_VALUE res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
  }

  protected DV_ABSOLUTE_QUANTITY parseDV_ABSOLUTE_QUANTITY(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDV_ABSOLUTE_QUANTITYProperties(JsonObject json, DV_ABSOLUTE_QUANTITY res) throws IOException, FHIRFormatError {
    parseDV_QUANTIFIEDProperties(json, res);
  }

  protected DV_AMOUNT parseDV_AMOUNT(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "DV-DURATION": return parseDV_DURATION(json);
    case "DV-COUNT": return parseDV_COUNT(json);
    case "DV-PROPORTION": return parseDV_PROPORTION(json);
    case "DV-QUANTITY": return parseDV_QUANTITY(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDV_AMOUNTProperties(JsonObject json, DV_AMOUNT res) throws IOException, FHIRFormatError {
    parseDV_QUANTIFIEDProperties(json, res);
    if (json.has("accuracy_is_percent"))
      res.setAccuracy_is_percentElement(parseBoolean(json.get("accuracy_is_percent").getAsBoolean()));
    if (json.has("_accuracy_is_percent"))
      parseElementProperties(getJObject(json, "_accuracy_is_percent"), res.getAccuracy_is_percentElement());
  }

  protected DV_ENCAPSULATED parseDV_ENCAPSULATED(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "DV-MULTIMEDIA": return parseDV_MULTIMEDIA(json);
    case "DV-PARSABLE": return parseDV_PARSABLE(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDV_ENCAPSULATEDProperties(JsonObject json, DV_ENCAPSULATED res) throws IOException, FHIRFormatError {
    parseDV_AMOUNTProperties(json, res);
    if (json.has("charset"))
      res.setCharset(parseCODE_PHRASE(getJObject(json, "charset")));
    if (json.has("language"))
      res.setLanguage(parseCODE_PHRASE(getJObject(json, "language")));
  }

  protected DV_ORDERED parseDV_ORDERED(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "DV-DATE-TIME": return parseDV_DATE_TIME(json);
    case "DV-TIME": return parseDV_TIME(json);
    case "DV-INTERVAL": return parseDV_INTERVAL(json);
    case "DV-ORDINAL": return parseDV_ORDINAL(json);
    case "DV-SCALE": return parseDV_SCALE(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDV_ORDEREDProperties(JsonObject json, DV_ORDERED res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("normal_status"))
      res.setNormal_status(parseCODE_PHRASE(getJObject(json, "normal_status")));
    if (json.has("normal_range"))
      res.setNormal_range(parseDV_INTERVAL(getJObject(json, "normal_range")));
    if (json.has("other_reference_ranges")) {
      JsonArray array = getJArray(json, "other_reference_ranges");
      for (int i = 0; i < array.size(); i++) {
        res.getOther_reference_rangesList().add(parseREFERENCE_RANGE(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected DV_QUANTIFIED parseDV_QUANTIFIED(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDV_QUANTIFIEDProperties(JsonObject json, DV_QUANTIFIED res) throws IOException, FHIRFormatError {
    parseDV_ORDEREDProperties(json, res);
    if (json.has("magnitude_status"))
      res.setMagnitude_statusElement(parseString(json.get("magnitude_status").getAsString()));
    if (json.has("_magnitude_status"))
      parseElementProperties(getJObject(json, "_magnitude_status"), res.getMagnitude_statusElement());
    if (json.has("accuracy"))
      res.setAccuracy(parseBase(getJObject(json, "accuracy")));
  }

  protected DV_TEMPORAL parseDV_TEMPORAL(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "DV-DATE": return parseDV_DATE(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDV_TEMPORALProperties(JsonObject json, DV_TEMPORAL res) throws IOException, FHIRFormatError {
    parseDV_ABSOLUTE_QUANTITYProperties(json, res);
  }

  protected DV_TIME_SPECIFICATION parseDV_TIME_SPECIFICATION(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "DV-GENERAL-TIME-SPECIFICATION": return parseDV_GENERAL_TIME_SPECIFICATION(json);
    case "DV-PERIODIC-TIME-SPECIFICATION": return parseDV_PERIODIC_TIME_SPECIFICATION(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseDV_TIME_SPECIFICATIONProperties(JsonObject json, DV_TIME_SPECIFICATION res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("DV_PARSABLE"))
      res.setDV_PARSABLEElement(parseString(json.get("DV_PARSABLE").getAsString()));
    if (json.has("_DV_PARSABLE"))
      parseElementProperties(getJObject(json, "_DV_PARSABLE"), res.getDV_PARSABLEElement());
  }

  protected ENTRY parseENTRY(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "ADMIN-ENTRY": return parseADMIN_ENTRY(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseENTRYProperties(JsonObject json, ENTRY res) throws IOException, FHIRFormatError {
    parseCONTENT_ITEMProperties(json, res);
    if (json.has("language"))
      res.setLanguage(parseCODE_PHRASE(getJObject(json, "language")));
    if (json.has("encoding"))
      res.setEncoding(parseCODE_PHRASE(getJObject(json, "encoding")));
    if (json.has("other_participations")) {
      JsonArray array = getJArray(json, "other_participations");
      for (int i = 0; i < array.size(); i++) {
        res.getOther_participationsList().add(parsePARTICIPATION(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("workflow_id"))
      res.setWorkflow_id(parseOBJECT_REF(getJObject(json, "workflow_id")));
    if (json.has("subject"))
      res.setSubject(parsePARTY_PROXY(getJObject(json, "subject")));
    if (json.has("provider"))
      res.setProvider(parsePARTY_PROXY(getJObject(json, "provider")));
  }

  protected EVENT parseEVENT(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "INTERVAL-EVENT": return parseINTERVAL_EVENT(json);
    case "POINT-EVENT": return parsePOINT_EVENT(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseEVENTProperties(JsonObject json, EVENT res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("time"))
      res.setTime(parseDV_DATE_TIME(getJObject(json, "time")));
    if (json.has("state"))
      res.setState(parseITEM_STRUCTURE(getJObject(json, "state")));
    if (json.has("data"))
      res.setData(parseAny(getJObject(json, "data")));
  }

  protected ITEM_STRUCTURE parseITEM_STRUCTURE(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "ITEM-SINGLE": return parseITEM_SINGLE(json);
    case "ITEM-TREE": return parseITEM_TREE(json);
    case "ITEM-TABLE": return parseITEM_TABLE(json);
    case "ITEM-LIST": return parseITEM_LIST(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseITEM_STRUCTUREProperties(JsonObject json, ITEM_STRUCTURE res) throws IOException, FHIRFormatError {
    parseDATA_STRUCTUREProperties(json, res);
  }

  protected ITEM parseITEM(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "ELEMENT": return parseELEMENT(json);
    case "CLUSTER": return parseCLUSTER(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseITEMProperties(JsonObject json, ITEM res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
  }

  protected LOCATABLE parseLOCATABLE(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "CONTACT": return parseCONTACT(json);
    case "EVENT-CONTEXT": return parseEVENT_CONTEXT(json);
    case "EHR-STATUS": return parseEHR_STATUS(json);
    case "PARTY-IDENTITY": return parsePARTY_IDENTITY(json);
    case "ADDRESS": return parseADDRESS(json);
    case "COMPOSITION": return parseCOMPOSITION(json);
    case "PARTY-RELATIONSHIP": return parsePARTY_RELATIONSHIP(json);
    case "CAPABILITY": return parseCAPABILITY(json);
    case "EHR-ACCESS": return parseEHR_ACCESS(json);
    case "ACTIVITY": return parseACTIVITY(json);
    case "FOLDER": return parseFOLDER(json);
    case "PARTICIPATION": return parsePARTICIPATION(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseLOCATABLEProperties(JsonObject json, LOCATABLE res) throws IOException, FHIRFormatError {
    parsePATHABLEProperties(json, res);
  }

  protected OBJECT_ID parseOBJECT_ID(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "TEMPLATE-ID": return parseTEMPLATE_ID(json);
    case "ARCHETYPE-ID": return parseARCHETYPE_ID(json);
    case "GENERIC-ID": return parseGENERIC_ID(json);
    case "TERMINOLOGY-ID": return parseTERMINOLOGY_ID(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseOBJECT_IDProperties(JsonObject json, OBJECT_ID res) throws IOException, FHIRFormatError {
    parseUIDProperties(json, res);
  }

  protected PARTY_PROXY parsePARTY_PROXY(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "PARTY-SELF": return parsePARTY_SELF(json);
    case "PARTY-IDENTIFIED": return parsePARTY_IDENTIFIED(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parsePARTY_PROXYProperties(JsonObject json, PARTY_PROXY res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("external_ref"))
      res.setExternal_ref(parsePARTY_REF(getJObject(json, "external_ref")));
  }

  protected PARTY parsePARTY(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "ROLE": return parseROLE(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parsePARTYProperties(JsonObject json, PARTY res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("identities")) {
      JsonArray array = getJArray(json, "identities");
      for (int i = 0; i < array.size(); i++) {
        res.getIdentitiesList().add(parsePARTY_IDENTITY(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("contacts"))
      res.setContacts(parseCONTACT(getJObject(json, "contacts")));
    if (json.has("details"))
      res.setDetails(parseITEM_STRUCTURE(getJObject(json, "details")));
    if (json.has("reverse_relationships")) {
      JsonArray array = getJArray(json, "reverse_relationships");
      for (int i = 0; i < array.size(); i++) {
        res.getReverse_relationshipsList().add(parseLOCATABLE_REF(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("relationships")) {
      JsonArray array = getJArray(json, "relationships");
      for (int i = 0; i < array.size(); i++) {
        res.getRelationshipsList().add(parsePARTY_RELATIONSHIP(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected PATHABLE parsePATHABLE(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "INSTRUCTION-DETAILS": return parseINSTRUCTION_DETAILS(json);
    case "ISM-TRANSITION": return parseISM_TRANSITION(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parsePATHABLEProperties(JsonObject json, PATHABLE res) throws IOException, FHIRFormatError {
    parseAnyProperties(json, res);
    if (json.has("name"))
      res.setName(parseDV_TEXT(getJObject(json, "name")));
    if (json.has("archetype_node_id"))
      res.setArchetype_node_idElement(parseString(json.get("archetype_node_id").getAsString()));
    if (json.has("_archetype_node_id"))
      parseElementProperties(getJObject(json, "_archetype_node_id"), res.getArchetype_node_idElement());
    if (json.has("uid"))
      res.setUid(parseUID_BASED_ID(getJObject(json, "uid")));
    if (json.has("links")) {
      JsonArray array = getJArray(json, "links");
      for (int i = 0; i < array.size(); i++) {
        res.getLinksList().add(parseLINK(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("archetype_details"))
      res.setArchetype_details(parseARCHETYPED(getJObject(json, "archetype_details")));
    if (json.has("feeder_audit"))
      res.setFeeder_audit(parseFEEDER_AUDIT(getJObject(json, "feeder_audit")));
  }

  protected UID_BASED_ID parseUID_BASED_ID(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "OBJECT-VERSION-ID": return parseOBJECT_VERSION_ID(json);
    case "HIER-OBJECT-ID": return parseHIER_OBJECT_ID(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseUID_BASED_IDProperties(JsonObject json, UID_BASED_ID res) throws IOException, FHIRFormatError {
    parseOBJECT_IDProperties(json, res);
  }

  protected UID parseUID(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "ISO-OID": return parseISO_OID(json);
    case "UUID": return parseUUID(json);
    case "INTERNET-ID": return parseINTERNET_ID(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseUIDProperties(JsonObject json, UID res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected VERSION parseVERSION(JsonObject json) throws IOException, FHIRFormatError {
    if (json.has("_type")) { throw new FHIRException("'_type' property not found"); }
    String type = json.get("_type").getAsString();
    switch (type) {
    case "IMPORTED-VERSION": return parseIMPORTED_VERSION(json);
    case "ORIGINAL-VERSION": return parseORIGINAL_VERSION(json);
    default: throw new FHIRException("Unsupported type '"+type+"'");
    }
  }

  protected void parseVERSIONProperties(JsonObject json, VERSION res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("contribution"))
      res.setContribution(parseOBJECT_REF(getJObject(json, "contribution")));
    if (json.has("signature"))
      res.setSignatureElement(parseString(json.get("signature").getAsString()));
    if (json.has("_signature"))
      parseElementProperties(getJObject(json, "_signature"), res.getSignatureElement());
    if (json.has("commit_audit"))
      res.setCommit_audit(parseAUDIT_DETAILS(getJObject(json, "commit_audit")));
  }

  protected ACTION parseACTION(JsonObject json) throws IOException, FHIRFormatError {
    ACTION res = new ACTION();
    parseACTIONProperties(json, res);
    return res;
  }

  protected void parseACTIONProperties(JsonObject json, ACTION res) throws IOException, FHIRFormatError {
    parseCARE_ENTRYProperties(json, res);
    if (json.has("time"))
      res.setTime(parseDV_DATE_TIME(getJObject(json, "time")));
    if (json.has("ism_transition"))
      res.setIsm_transition(parseISM_TRANSITION(getJObject(json, "ism_transition")));
    if (json.has("instruction_details"))
      res.setInstruction_details(parseINSTRUCTION_DETAILS(getJObject(json, "instruction_details")));
    if (json.has("description"))
      res.setDescription(parseITEM_STRUCTURE(getJObject(json, "description")));
  }

  protected ACTIVITY parseACTIVITY(JsonObject json) throws IOException, FHIRFormatError {
    ACTIVITY res = new ACTIVITY();
    parseACTIVITYProperties(json, res);
    return res;
  }

  protected void parseACTIVITYProperties(JsonObject json, ACTIVITY res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("timing"))
      res.setTiming(parseDV_PARSABLE(getJObject(json, "timing")));
    if (json.has("action_archetype_id"))
      res.setAction_archetype_idElement(parseString(json.get("action_archetype_id").getAsString()));
    if (json.has("_action_archetype_id"))
      parseElementProperties(getJObject(json, "_action_archetype_id"), res.getAction_archetype_idElement());
    if (json.has("description"))
      res.setDescription(parseITEM_STRUCTURE(getJObject(json, "description")));
  }

  protected ADDRESS parseADDRESS(JsonObject json) throws IOException, FHIRFormatError {
    ADDRESS res = new ADDRESS();
    parseADDRESSProperties(json, res);
    return res;
  }

  protected void parseADDRESSProperties(JsonObject json, ADDRESS res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("details"))
      res.setDetails(parseITEM_STRUCTURE(getJObject(json, "details")));
  }

  protected ADMIN_ENTRY parseADMIN_ENTRY(JsonObject json) throws IOException, FHIRFormatError {
    ADMIN_ENTRY res = new ADMIN_ENTRY();
    parseADMIN_ENTRYProperties(json, res);
    return res;
  }

  protected void parseADMIN_ENTRYProperties(JsonObject json, ADMIN_ENTRY res) throws IOException, FHIRFormatError {
    parseENTRYProperties(json, res);
    if (json.has("data"))
      res.setData(parseITEM_STRUCTURE(getJObject(json, "data")));
  }

  protected AGENT parseAGENT(JsonObject json) throws IOException, FHIRFormatError {
    AGENT res = new AGENT();
    parseAGENTProperties(json, res);
    return res;
  }

  protected void parseAGENTProperties(JsonObject json, AGENT res) throws IOException, FHIRFormatError {
    parseACTORProperties(json, res);
  }

  protected ARCHETYPE_ID parseARCHETYPE_ID(JsonObject json) throws IOException, FHIRFormatError {
    ARCHETYPE_ID res = new ARCHETYPE_ID();
    parseARCHETYPE_IDProperties(json, res);
    return res;
  }

  protected void parseARCHETYPE_IDProperties(JsonObject json, ARCHETYPE_ID res) throws IOException, FHIRFormatError {
    parseOBJECT_IDProperties(json, res);
  }

  protected ARCHETYPED parseARCHETYPED(JsonObject json) throws IOException, FHIRFormatError {
    ARCHETYPED res = new ARCHETYPED();
    parseARCHETYPEDProperties(json, res);
    return res;
  }

  protected void parseARCHETYPEDProperties(JsonObject json, ARCHETYPED res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("archetype_id"))
      res.setArchetype_id(parseARCHETYPE_ID(getJObject(json, "archetype_id")));
    if (json.has("template_id"))
      res.setTemplate_id(parseTEMPLATE_ID(getJObject(json, "template_id")));
    if (json.has("rm_version"))
      res.setRm_versionElement(parseString(json.get("rm_version").getAsString()));
    if (json.has("_rm_version"))
      parseElementProperties(getJObject(json, "_rm_version"), res.getRm_versionElement());
  }

  protected ATTESTATION parseATTESTATION(JsonObject json) throws IOException, FHIRFormatError {
    ATTESTATION res = new ATTESTATION();
    parseATTESTATIONProperties(json, res);
    return res;
  }

  protected void parseATTESTATIONProperties(JsonObject json, ATTESTATION res) throws IOException, FHIRFormatError {
    parseAUDIT_DETAILSProperties(json, res);
    if (json.has("attested_view"))
      res.setAttested_view(parseDV_MULTIMEDIA(getJObject(json, "attested_view")));
    if (json.has("proof"))
      res.setProofElement(parseString(json.get("proof").getAsString()));
    if (json.has("_proof"))
      parseElementProperties(getJObject(json, "_proof"), res.getProofElement());
    if (json.has("items")) {
      JsonArray array = getJArray(json, "items");
      for (int i = 0; i < array.size(); i++) {
        res.getItemsList().add(parseDV_EHR_URI(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("reason"))
      res.setReason(parseDV_TEXT(getJObject(json, "reason")));
    if (json.has("is_pending"))
      res.setIs_pendingElement(parseBoolean(json.get("is_pending").getAsBoolean()));
    if (json.has("_is_pending"))
      parseElementProperties(getJObject(json, "_is_pending"), res.getIs_pendingElement());
  }

  protected AUDIT_DETAILS parseAUDIT_DETAILS(JsonObject json) throws IOException, FHIRFormatError {
    AUDIT_DETAILS res = new AUDIT_DETAILS();
    parseAUDIT_DETAILSProperties(json, res);
    return res;
  }

  protected void parseAUDIT_DETAILSProperties(JsonObject json, AUDIT_DETAILS res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("system_id"))
      res.setSystem_idElement(parseString(json.get("system_id").getAsString()));
    if (json.has("_system_id"))
      parseElementProperties(getJObject(json, "_system_id"), res.getSystem_idElement());
    if (json.has("time_committed"))
      res.setTime_committed(parseDV_DATE_TIME(getJObject(json, "time_committed")));
    if (json.has("change_type"))
      res.setChange_type(parseDV_CODED_TEXT(getJObject(json, "change_type")));
    if (json.has("description"))
      res.setDescription(parseDV_TEXT(getJObject(json, "description")));
    if (json.has("committer"))
      res.setCommitter(parsePARTY_PROXY(getJObject(json, "committer")));
  }

  protected Annotations parseAnnotations(JsonObject json) throws IOException, FHIRFormatError {
    Annotations res = new Annotations();
    parseAnnotationsProperties(json, res);
    return res;
  }

  protected void parseAnnotationsProperties(JsonObject json, Annotations res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("comment"))
      res.setCommentElement(parseString(json.get("comment").getAsString()));
    if (json.has("_comment"))
      parseElementProperties(getJObject(json, "_comment"), res.getCommentElement());
    if (json.has("fhir_mapping"))
      res.setFhir_mappingElement(parseString(json.get("fhir_mapping").getAsString()));
    if (json.has("_fhir_mapping"))
      parseElementProperties(getJObject(json, "_fhir_mapping"), res.getFhir_mappingElement());
    if (json.has("vset_description"))
      res.setVset_descriptionElement(parseString(json.get("vset_description").getAsString()));
    if (json.has("_vset_description"))
      parseElementProperties(getJObject(json, "_vset_description"), res.getVset_descriptionElement());
    if (json.has("hl7v2_mapping"))
      res.setHl7v2_mappingElement(parseString(json.get("hl7v2_mapping").getAsString()));
    if (json.has("_hl7v2_mapping"))
      parseElementProperties(getJObject(json, "_hl7v2_mapping"), res.getHl7v2_mappingElement());
    if (json.has("visibleInView"))
      res.setVisibleInViewElement(parseString(json.get("visibleInView").getAsString()));
    if (json.has("_visibleInView"))
      parseElementProperties(getJObject(json, "_visibleInView"), res.getVisibleInViewElement());
  }

  protected CAPABILITY parseCAPABILITY(JsonObject json) throws IOException, FHIRFormatError {
    CAPABILITY res = new CAPABILITY();
    parseCAPABILITYProperties(json, res);
    return res;
  }

  protected void parseCAPABILITYProperties(JsonObject json, CAPABILITY res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("credentials"))
      res.setCredentials(parseITEM_STRUCTURE(getJObject(json, "credentials")));
    if (json.has("time_validity"))
      res.setTime_validity(parseDV_INTERVAL(getJObject(json, "time_validity")));
  }

  protected CLUSTER parseCLUSTER(JsonObject json) throws IOException, FHIRFormatError {
    CLUSTER res = new CLUSTER();
    parseCLUSTERProperties(json, res);
    return res;
  }

  protected void parseCLUSTERProperties(JsonObject json, CLUSTER res) throws IOException, FHIRFormatError {
    parseITEMProperties(json, res);
    if (json.has("items")) {
      JsonArray array = getJArray(json, "items");
      for (int i = 0; i < array.size(); i++) {
        res.getItemsList().add(parseITEM(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CODE_PHRASE parseCODE_PHRASE(JsonObject json) throws IOException, FHIRFormatError {
    CODE_PHRASE res = new CODE_PHRASE();
    parseCODE_PHRASEProperties(json, res);
    return res;
  }

  protected void parseCODE_PHRASEProperties(JsonObject json, CODE_PHRASE res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("terminology_id"))
      res.setTerminology_id(parseTERMINOLOGY_ID(getJObject(json, "terminology_id")));
    if (json.has("code_string"))
      res.setCode_stringElement(parseString(json.get("code_string").getAsString()));
    if (json.has("_code_string"))
      parseElementProperties(getJObject(json, "_code_string"), res.getCode_stringElement());
    if (json.has("preferred_term"))
      res.setPreferred_termElement(parseString(json.get("preferred_term").getAsString()));
    if (json.has("_preferred_term"))
      parseElementProperties(getJObject(json, "_preferred_term"), res.getPreferred_termElement());
  }

  protected COMPOSITION parseCOMPOSITION(JsonObject json) throws IOException, FHIRFormatError {
    COMPOSITION res = new COMPOSITION();
    parseCOMPOSITIONProperties(json, res);
    return res;
  }

  protected void parseCOMPOSITIONProperties(JsonObject json, COMPOSITION res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("language"))
      res.setLanguage(parseCODE_PHRASE(getJObject(json, "language")));
    if (json.has("territory"))
      res.setTerritory(parseCODE_PHRASE(getJObject(json, "territory")));
    if (json.has("category"))
      res.setCategory(parseDV_CODED_TEXT(getJObject(json, "category")));
    if (json.has("context"))
      res.setContext(parseEVENT_CONTEXT(getJObject(json, "context")));
    if (json.has("composer"))
      res.setComposer(parsePARTY_PROXY(getJObject(json, "composer")));
    if (json.has("content")) {
      JsonArray array = getJArray(json, "content");
      for (int i = 0; i < array.size(); i++) {
        res.getContentList().add(parseCONTENT_ITEM(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CONTACT parseCONTACT(JsonObject json) throws IOException, FHIRFormatError {
    CONTACT res = new CONTACT();
    parseCONTACTProperties(json, res);
    return res;
  }

  protected void parseCONTACTProperties(JsonObject json, CONTACT res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("addresses")) {
      JsonArray array = getJArray(json, "addresses");
      for (int i = 0; i < array.size(); i++) {
        res.getAddressesList().add(parseADDRESS(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("time_validity"))
      res.setTime_validity(parseDV_INTERVAL(getJObject(json, "time_validity")));
  }

  protected CONTRIBUTION parseCONTRIBUTION(JsonObject json) throws IOException, FHIRFormatError {
    CONTRIBUTION res = new CONTRIBUTION();
    parseCONTRIBUTIONProperties(json, res);
    return res;
  }

  protected void parseCONTRIBUTIONProperties(JsonObject json, CONTRIBUTION res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("uid"))
      res.setUid(parseHIER_OBJECT_ID(getJObject(json, "uid")));
    if (json.has("versions")) {
      JsonArray array = getJArray(json, "versions");
      for (int i = 0; i < array.size(); i++) {
        res.getVersionsList().add(parseOBJECT_REF(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("audit"))
      res.setAudit(parseAUDIT_DETAILS(getJObject(json, "audit")));
  }

  protected DV_BOOLEAN parseDV_BOOLEAN(JsonObject json) throws IOException, FHIRFormatError {
    DV_BOOLEAN res = new DV_BOOLEAN();
    parseDV_BOOLEANProperties(json, res);
    return res;
  }

  protected void parseDV_BOOLEANProperties(JsonObject json, DV_BOOLEAN res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseBoolean(json.get("value").getAsBoolean()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected DV_CODED_TEXT parseDV_CODED_TEXT(JsonObject json) throws IOException, FHIRFormatError {
    DV_CODED_TEXT res = new DV_CODED_TEXT();
    parseDV_CODED_TEXTProperties(json, res);
    return res;
  }

  protected void parseDV_CODED_TEXTProperties(JsonObject json, DV_CODED_TEXT res) throws IOException, FHIRFormatError {
    parseDV_TEXTProperties(json, res);
    if (json.has("defining_code"))
      res.setDefining_code(parseCODE_PHRASE(getJObject(json, "defining_code")));
  }

  protected DV_COUNT parseDV_COUNT(JsonObject json) throws IOException, FHIRFormatError {
    DV_COUNT res = new DV_COUNT();
    parseDV_COUNTProperties(json, res);
    return res;
  }

  protected void parseDV_COUNTProperties(JsonObject json, DV_COUNT res) throws IOException, FHIRFormatError {
    parseDV_AMOUNTProperties(json, res);
    if (json.has("magnitude"))
      res.setMagnitudeElement(parseDecimal(json.get("magnitude").getAsBigDecimal()));
    if (json.has("_magnitude"))
      parseElementProperties(getJObject(json, "_magnitude"), res.getMagnitudeElement());
  }

  protected DV_DATE_TIME parseDV_DATE_TIME(JsonObject json) throws IOException, FHIRFormatError {
    DV_DATE_TIME res = new DV_DATE_TIME();
    parseDV_DATE_TIMEProperties(json, res);
    return res;
  }

  protected void parseDV_DATE_TIMEProperties(JsonObject json, DV_DATE_TIME res) throws IOException, FHIRFormatError {
    parseDV_ORDEREDProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseDateTime(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected DV_DATE parseDV_DATE(JsonObject json) throws IOException, FHIRFormatError {
    DV_DATE res = new DV_DATE();
    parseDV_DATEProperties(json, res);
    return res;
  }

  protected void parseDV_DATEProperties(JsonObject json, DV_DATE res) throws IOException, FHIRFormatError {
    parseDV_TEMPORALProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseDateTime(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected DV_DURATION parseDV_DURATION(JsonObject json) throws IOException, FHIRFormatError {
    DV_DURATION res = new DV_DURATION();
    parseDV_DURATIONProperties(json, res);
    return res;
  }

  protected void parseDV_DURATIONProperties(JsonObject json, DV_DURATION res) throws IOException, FHIRFormatError {
    parseDV_AMOUNTProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected DV_EHR_URI parseDV_EHR_URI(JsonObject json) throws IOException, FHIRFormatError {
    DV_EHR_URI res = new DV_EHR_URI();
    parseDV_EHR_URIProperties(json, res);
    return res;
  }

  protected void parseDV_EHR_URIProperties(JsonObject json, DV_EHR_URI res) throws IOException, FHIRFormatError {
    parseDV_URIProperties(json, res);
  }

  protected DV_GENERAL_TIME_SPECIFICATION parseDV_GENERAL_TIME_SPECIFICATION(JsonObject json) throws IOException, FHIRFormatError {
    DV_GENERAL_TIME_SPECIFICATION res = new DV_GENERAL_TIME_SPECIFICATION();
    parseDV_GENERAL_TIME_SPECIFICATIONProperties(json, res);
    return res;
  }

  protected void parseDV_GENERAL_TIME_SPECIFICATIONProperties(JsonObject json, DV_GENERAL_TIME_SPECIFICATION res) throws IOException, FHIRFormatError {
    parseDV_TIME_SPECIFICATIONProperties(json, res);
  }

  protected DV_IDENTIFIER parseDV_IDENTIFIER(JsonObject json) throws IOException, FHIRFormatError {
    DV_IDENTIFIER res = new DV_IDENTIFIER();
    parseDV_IDENTIFIERProperties(json, res);
    return res;
  }

  protected void parseDV_IDENTIFIERProperties(JsonObject json, DV_IDENTIFIER res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("issuer"))
      res.setIssuerElement(parseString(json.get("issuer").getAsString()));
    if (json.has("_issuer"))
      parseElementProperties(getJObject(json, "_issuer"), res.getIssuerElement());
    if (json.has("assigner"))
      res.setAssignerElement(parseString(json.get("assigner").getAsString()));
    if (json.has("_assigner"))
      parseElementProperties(getJObject(json, "_assigner"), res.getAssignerElement());
    if (json.has("id"))
      res.setIdElement(parseString(json.get("id").getAsString()));
    if (json.has("_id"))
      parseElementProperties(getJObject(json, "_id"), res.getIdElement());
    if (json.has("type"))
      res.setTypeElement(parseString(json.get("type").getAsString()));
    if (json.has("_type"))
      parseElementProperties(getJObject(json, "_type"), res.getTypeElement());
  }

  protected DV_INTERVAL parseDV_INTERVAL(JsonObject json) throws IOException, FHIRFormatError {
    DV_INTERVAL res = new DV_INTERVAL();
    parseDV_INTERVALProperties(json, res);
    return res;
  }

  protected void parseDV_INTERVALProperties(JsonObject json, DV_INTERVAL res) throws IOException, FHIRFormatError {
    parseDV_ORDEREDProperties(json, res);
  }

  protected DV_MULTIMEDIA parseDV_MULTIMEDIA(JsonObject json) throws IOException, FHIRFormatError {
    DV_MULTIMEDIA res = new DV_MULTIMEDIA();
    parseDV_MULTIMEDIAProperties(json, res);
    return res;
  }

  protected void parseDV_MULTIMEDIAProperties(JsonObject json, DV_MULTIMEDIA res) throws IOException, FHIRFormatError {
    parseDV_ENCAPSULATEDProperties(json, res);
    if (json.has("alternate_text"))
      res.setAlternate_textElement(parseString(json.get("alternate_text").getAsString()));
    if (json.has("_alternate_text"))
      parseElementProperties(getJObject(json, "_alternate_text"), res.getAlternate_textElement());
    if (json.has("uri"))
      res.setUri(parseDV_URI(getJObject(json, "uri")));
    if (json.has("data"))
      res.setDataElement(parseBase64Binary(json.get("data").getAsString()));
    if (json.has("_data"))
      parseElementProperties(getJObject(json, "_data"), res.getDataElement());
    if (json.has("media_type"))
      res.setMedia_type(parseCODE_PHRASE(getJObject(json, "media_type")));
    if (json.has("compression_algorithm"))
      res.setCompression_algorithm(parseCODE_PHRASE(getJObject(json, "compression_algorithm")));
    if (json.has("integrity_check"))
      res.setIntegrity_checkElement(parseBase64Binary(json.get("integrity_check").getAsString()));
    if (json.has("_integrity_check"))
      parseElementProperties(getJObject(json, "_integrity_check"), res.getIntegrity_checkElement());
    if (json.has("integrity_check_algorithm"))
      res.setIntegrity_check_algorithm(parseCODE_PHRASE(getJObject(json, "integrity_check_algorithm")));
    if (json.has("thumbnail"))
      res.setThumbnail(parseDV_MULTIMEDIA(getJObject(json, "thumbnail")));
    if (json.has("size"))
      res.setSizeElement(parseInteger(json.get("size").getAsLong()));
    if (json.has("_size"))
      parseElementProperties(getJObject(json, "_size"), res.getSizeElement());
  }

  protected DV_ORDINAL parseDV_ORDINAL(JsonObject json) throws IOException, FHIRFormatError {
    DV_ORDINAL res = new DV_ORDINAL();
    parseDV_ORDINALProperties(json, res);
    return res;
  }

  protected void parseDV_ORDINALProperties(JsonObject json, DV_ORDINAL res) throws IOException, FHIRFormatError {
    parseDV_ORDEREDProperties(json, res);
    if (json.has("symbol"))
      res.setSymbol(parseDV_CODED_TEXT(getJObject(json, "symbol")));
    if (json.has("value"))
      res.setValueElement(parseInteger(json.get("value").getAsLong()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected DV_PARAGRAPH parseDV_PARAGRAPH(JsonObject json) throws IOException, FHIRFormatError {
    DV_PARAGRAPH res = new DV_PARAGRAPH();
    parseDV_PARAGRAPHProperties(json, res);
    return res;
  }

  protected void parseDV_PARAGRAPHProperties(JsonObject json, DV_PARAGRAPH res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("items")) {
      JsonArray array = getJArray(json, "items");
      for (int i = 0; i < array.size(); i++) {
        res.getItemsList().add(parseDV_TEXT(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected DV_PARSABLE parseDV_PARSABLE(JsonObject json) throws IOException, FHIRFormatError {
    DV_PARSABLE res = new DV_PARSABLE();
    parseDV_PARSABLEProperties(json, res);
    return res;
  }

  protected void parseDV_PARSABLEProperties(JsonObject json, DV_PARSABLE res) throws IOException, FHIRFormatError {
    parseDV_ENCAPSULATEDProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
    if (json.has("formalism"))
      res.setFormalismElement(parseString(json.get("formalism").getAsString()));
    if (json.has("_formalism"))
      parseElementProperties(getJObject(json, "_formalism"), res.getFormalismElement());
  }

  protected DV_PERIODIC_TIME_SPECIFICATION parseDV_PERIODIC_TIME_SPECIFICATION(JsonObject json) throws IOException, FHIRFormatError {
    DV_PERIODIC_TIME_SPECIFICATION res = new DV_PERIODIC_TIME_SPECIFICATION();
    parseDV_PERIODIC_TIME_SPECIFICATIONProperties(json, res);
    return res;
  }

  protected void parseDV_PERIODIC_TIME_SPECIFICATIONProperties(JsonObject json, DV_PERIODIC_TIME_SPECIFICATION res) throws IOException, FHIRFormatError {
    parseDV_TIME_SPECIFICATIONProperties(json, res);
  }

  protected DV_PROPORTION parseDV_PROPORTION(JsonObject json) throws IOException, FHIRFormatError {
    DV_PROPORTION res = new DV_PROPORTION();
    parseDV_PROPORTIONProperties(json, res);
    return res;
  }

  protected void parseDV_PROPORTIONProperties(JsonObject json, DV_PROPORTION res) throws IOException, FHIRFormatError {
    parseDV_AMOUNTProperties(json, res);
    if (json.has("numerator"))
      res.setNumeratorElement(parseDecimal(json.get("numerator").getAsBigDecimal()));
    if (json.has("_numerator"))
      parseElementProperties(getJObject(json, "_numerator"), res.getNumeratorElement());
    if (json.has("denominator"))
      res.setDenominatorElement(parseDecimal(json.get("denominator").getAsBigDecimal()));
    if (json.has("_denominator"))
      parseElementProperties(getJObject(json, "_denominator"), res.getDenominatorElement());
    if (json.has("type"))
      res.setTypeElement(parseCode(json.get("type").getAsString()));
    if (json.has("_type"))
      parseElementProperties(getJObject(json, "_type"), res.getTypeElement());
    if (json.has("precision"))
      res.setPrecisionElement(parseInteger(json.get("precision").getAsLong()));
    if (json.has("_precision"))
      parseElementProperties(getJObject(json, "_precision"), res.getPrecisionElement());
  }

  protected DV_QUANTITY parseDV_QUANTITY(JsonObject json) throws IOException, FHIRFormatError {
    DV_QUANTITY res = new DV_QUANTITY();
    parseDV_QUANTITYProperties(json, res);
    return res;
  }

  protected void parseDV_QUANTITYProperties(JsonObject json, DV_QUANTITY res) throws IOException, FHIRFormatError {
    parseDV_AMOUNTProperties(json, res);
    if (json.has("magnitude"))
      res.setMagnitudeElement(parseDecimal(json.get("magnitude").getAsBigDecimal()));
    if (json.has("_magnitude"))
      parseElementProperties(getJObject(json, "_magnitude"), res.getMagnitudeElement());
    if (json.has("precision"))
      res.setPrecisionElement(parseInteger(json.get("precision").getAsLong()));
    if (json.has("_precision"))
      parseElementProperties(getJObject(json, "_precision"), res.getPrecisionElement());
    if (json.has("units"))
      res.setUnitsElement(parseString(json.get("units").getAsString()));
    if (json.has("_units"))
      parseElementProperties(getJObject(json, "_units"), res.getUnitsElement());
    if (json.has("units_system"))
      res.setUnits_systemElement(parseString(json.get("units_system").getAsString()));
    if (json.has("_units_system"))
      parseElementProperties(getJObject(json, "_units_system"), res.getUnits_systemElement());
    if (json.has("units_display_name"))
      res.setUnits_display_nameElement(parseString(json.get("units_display_name").getAsString()));
    if (json.has("_units_display_name"))
      parseElementProperties(getJObject(json, "_units_display_name"), res.getUnits_display_nameElement());
  }

  protected DV_SCALE parseDV_SCALE(JsonObject json) throws IOException, FHIRFormatError {
    DV_SCALE res = new DV_SCALE();
    parseDV_SCALEProperties(json, res);
    return res;
  }

  protected void parseDV_SCALEProperties(JsonObject json, DV_SCALE res) throws IOException, FHIRFormatError {
    parseDV_ORDEREDProperties(json, res);
    if (json.has("symbol"))
      res.setSymbol(parseDV_CODED_TEXT(getJObject(json, "symbol")));
    if (json.has("value"))
      res.setValueElement(parseDecimal(json.get("value").getAsBigDecimal()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected DV_STATE parseDV_STATE(JsonObject json) throws IOException, FHIRFormatError {
    DV_STATE res = new DV_STATE();
    parseDV_STATEProperties(json, res);
    return res;
  }

  protected void parseDV_STATEProperties(JsonObject json, DV_STATE res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDV_CODED_TEXT(getJObject(json, "value")));
    if (json.has("is_terminal"))
      res.setIs_terminalElement(parseBoolean(json.get("is_terminal").getAsBoolean()));
    if (json.has("_is_terminal"))
      parseElementProperties(getJObject(json, "_is_terminal"), res.getIs_terminalElement());
  }

  protected DV_TEXT parseDV_TEXT(JsonObject json) throws IOException, FHIRFormatError {
    DV_TEXT res = new DV_TEXT();
    parseDV_TEXTProperties(json, res);
    return res;
  }

  protected void parseDV_TEXTProperties(JsonObject json, DV_TEXT res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
    if (json.has("hyperlink"))
      res.setHyperlink(parseDV_URI(getJObject(json, "hyperlink")));
    if (json.has("formatting"))
      res.setFormattingElement(parseString(json.get("formatting").getAsString()));
    if (json.has("_formatting"))
      parseElementProperties(getJObject(json, "_formatting"), res.getFormattingElement());
    if (json.has("mappings")) {
      JsonArray array = getJArray(json, "mappings");
      for (int i = 0; i < array.size(); i++) {
        res.getMappingsList().add(parseTERM_MAPPING(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("language"))
      res.setLanguage(parseCODE_PHRASE(getJObject(json, "language")));
    if (json.has("encoding"))
      res.setEncoding(parseCODE_PHRASE(getJObject(json, "encoding")));
  }

  protected DV_TIME parseDV_TIME(JsonObject json) throws IOException, FHIRFormatError {
    DV_TIME res = new DV_TIME();
    parseDV_TIMEProperties(json, res);
    return res;
  }

  protected void parseDV_TIMEProperties(JsonObject json, DV_TIME res) throws IOException, FHIRFormatError {
    parseDV_ORDEREDProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected DV_URI parseDV_URI(JsonObject json) throws IOException, FHIRFormatError {
    DV_URI res = new DV_URI();
    parseDV_URIProperties(json, res);
    return res;
  }

  protected void parseDV_URIProperties(JsonObject json, DV_URI res) throws IOException, FHIRFormatError {
    parseDATA_VALUEProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseUri(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected EHR_ACCESS parseEHR_ACCESS(JsonObject json) throws IOException, FHIRFormatError {
    EHR_ACCESS res = new EHR_ACCESS();
    parseEHR_ACCESSProperties(json, res);
    return res;
  }

  protected void parseEHR_ACCESSProperties(JsonObject json, EHR_ACCESS res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("settings"))
      res.setSettings(parseACCESS_CONTROL_SETTINGS(getJObject(json, "settings")));
  }

  protected EHR_STATUS parseEHR_STATUS(JsonObject json) throws IOException, FHIRFormatError {
    EHR_STATUS res = new EHR_STATUS();
    parseEHR_STATUSProperties(json, res);
    return res;
  }

  protected void parseEHR_STATUSProperties(JsonObject json, EHR_STATUS res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parsePARTY_SELF(getJObject(json, "subject")));
    if (json.has("is_queryable"))
      res.setIs_queryableElement(parseBoolean(json.get("is_queryable").getAsBoolean()));
    if (json.has("_is_queryable"))
      parseElementProperties(getJObject(json, "_is_queryable"), res.getIs_queryableElement());
    if (json.has("is_modifiable"))
      res.setIs_modifiableElement(parseBoolean(json.get("is_modifiable").getAsBoolean()));
    if (json.has("_is_modifiable"))
      parseElementProperties(getJObject(json, "_is_modifiable"), res.getIs_modifiableElement());
    if (json.has("other_details"))
      res.setOther_details(parseITEM_STRUCTURE(getJObject(json, "other_details")));
  }

  protected EHR parseEHR(JsonObject json) throws IOException, FHIRFormatError {
    EHR res = new EHR();
    parseEHRProperties(json, res);
    return res;
  }

  protected void parseEHRProperties(JsonObject json, EHR res) throws IOException, FHIRFormatError {
    parseAnyProperties(json, res);
    if (json.has("system_id")) {
      JsonArray array = getJArray(json, "system_id");
      for (int i = 0; i < array.size(); i++) {
        res.getSystem_idList().add(parseHIER_OBJECT_ID(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("ehr_id"))
      res.setEhr_id(parseHIER_OBJECT_ID(getJObject(json, "ehr_id")));
    if (json.has("contributions")) {
      JsonArray array = getJArray(json, "contributions");
      for (int i = 0; i < array.size(); i++) {
        res.getContributionsList().add(parseOBJECT_REF(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("ehr_status"))
      res.setEhr_status(parseOBJECT_REF(getJObject(json, "ehr_status")));
    if (json.has("ehr_access"))
      res.setEhr_access(parseOBJECT_REF(getJObject(json, "ehr_access")));
    if (json.has("compositions")) {
      JsonArray array = getJArray(json, "compositions");
      for (int i = 0; i < array.size(); i++) {
        res.getCompositionsList().add(parseOBJECT_REF(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("directory"))
      res.setDirectory(parseOBJECT_REF(getJObject(json, "directory")));
    if (json.has("time_created"))
      res.setTime_created(parseDV_DATE_TIME(getJObject(json, "time_created")));
    if (json.has("folders")) {
      JsonArray array = getJArray(json, "folders");
      for (int i = 0; i < array.size(); i++) {
        res.getFoldersList().add(parseOBJECT_REF(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("tags")) {
      JsonArray array = getJArray(json, "tags");
      for (int i = 0; i < array.size(); i++) {
        res.getTagsList().add(parseOBJECT_REF(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected ELEMENT parseELEMENT(JsonObject json) throws IOException, FHIRFormatError {
    ELEMENT res = new ELEMENT();
    parseELEMENTProperties(json, res);
    return res;
  }

  protected void parseELEMENTProperties(JsonObject json, ELEMENT res) throws IOException, FHIRFormatError {
    parseITEMProperties(json, res);
    if (json.has("null_flavour"))
      res.setNull_flavour(parseDV_CODED_TEXT(getJObject(json, "null_flavour")));
    if (json.has("value"))
      res.setValue(parseDATA_VALUE(getJObject(json, "value")));
    if (json.has("null_reason"))
      res.setNull_reason(parseDV_TEXT(getJObject(json, "null_reason")));
  }

  protected EVALUATION parseEVALUATION(JsonObject json) throws IOException, FHIRFormatError {
    EVALUATION res = new EVALUATION();
    parseEVALUATIONProperties(json, res);
    return res;
  }

  protected void parseEVALUATIONProperties(JsonObject json, EVALUATION res) throws IOException, FHIRFormatError {
    parseCARE_ENTRYProperties(json, res);
    if (json.has("data"))
      res.setData(parseITEM_STRUCTURE(getJObject(json, "data")));
  }

  protected EVENT_CONTEXT parseEVENT_CONTEXT(JsonObject json) throws IOException, FHIRFormatError {
    EVENT_CONTEXT res = new EVENT_CONTEXT();
    parseEVENT_CONTEXTProperties(json, res);
    return res;
  }

  protected void parseEVENT_CONTEXTProperties(JsonObject json, EVENT_CONTEXT res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("start_time"))
      res.setStart_time(parseDV_DATE_TIME(getJObject(json, "start_time")));
    if (json.has("end_time"))
      res.setEnd_time(parseDV_DATE_TIME(getJObject(json, "end_time")));
    if (json.has("location"))
      res.setLocationElement(parseString(json.get("location").getAsString()));
    if (json.has("_location"))
      parseElementProperties(getJObject(json, "_location"), res.getLocationElement());
    if (json.has("setting"))
      res.setSetting(parseDV_CODED_TEXT(getJObject(json, "setting")));
    if (json.has("other_context"))
      res.setOther_context(parseITEM_STRUCTURE(getJObject(json, "other_context")));
    if (json.has("health_care_facility"))
      res.setHealth_care_facility(parsePARTY_IDENTIFIED(getJObject(json, "health_care_facility")));
    if (json.has("participations")) {
      JsonArray array = getJArray(json, "participations");
      for (int i = 0; i < array.size(); i++) {
        res.getParticipationsList().add(parsePARTICIPATION(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected FEEDER_AUDIT_DETAILS parseFEEDER_AUDIT_DETAILS(JsonObject json) throws IOException, FHIRFormatError {
    FEEDER_AUDIT_DETAILS res = new FEEDER_AUDIT_DETAILS();
    parseFEEDER_AUDIT_DETAILSProperties(json, res);
    return res;
  }

  protected void parseFEEDER_AUDIT_DETAILSProperties(JsonObject json, FEEDER_AUDIT_DETAILS res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("system_id"))
      res.setSystem_idElement(parseString(json.get("system_id").getAsString()));
    if (json.has("_system_id"))
      parseElementProperties(getJObject(json, "_system_id"), res.getSystem_idElement());
    if (json.has("location"))
      res.setLocation(parsePARTY_IDENTIFIED(getJObject(json, "location")));
    if (json.has("subject"))
      res.setSubject(parsePARTY_PROXY(getJObject(json, "subject")));
    if (json.has("provider"))
      res.setProvider(parsePARTY_IDENTIFIED(getJObject(json, "provider")));
    if (json.has("time"))
      res.setTime(parseDV_DATE_TIME(getJObject(json, "time")));
    if (json.has("version_id"))
      res.setVersion_idElement(parseString(json.get("version_id").getAsString()));
    if (json.has("_version_id"))
      parseElementProperties(getJObject(json, "_version_id"), res.getVersion_idElement());
    if (json.has("other_details"))
      res.setOther_details(parseITEM_STRUCTURE(getJObject(json, "other_details")));
  }

  protected FEEDER_AUDIT parseFEEDER_AUDIT(JsonObject json) throws IOException, FHIRFormatError {
    FEEDER_AUDIT res = new FEEDER_AUDIT();
    parseFEEDER_AUDITProperties(json, res);
    return res;
  }

  protected void parseFEEDER_AUDITProperties(JsonObject json, FEEDER_AUDIT res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("originating_system_item_ids")) {
      JsonArray array = getJArray(json, "originating_system_item_ids");
      for (int i = 0; i < array.size(); i++) {
        res.getOriginating_system_item_idsList().add(parseDV_IDENTIFIER(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("feeder_system_item_ids")) {
      JsonArray array = getJArray(json, "feeder_system_item_ids");
      for (int i = 0; i < array.size(); i++) {
        res.getFeeder_system_item_idsList().add(parseDV_IDENTIFIER(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("original_content"))
      res.setOriginal_content(parseDV_ENCAPSULATED(getJObject(json, "original_content")));
    if (json.has("originating_system_audit"))
      res.setOriginating_system_audit(parseFEEDER_AUDIT_DETAILS(getJObject(json, "originating_system_audit")));
    if (json.has("feeder_system_audit"))
      res.setFeeder_system_audit(parseFEEDER_AUDIT_DETAILS(getJObject(json, "feeder_system_audit")));
  }

  protected FOLDER parseFOLDER(JsonObject json) throws IOException, FHIRFormatError {
    FOLDER res = new FOLDER();
    parseFOLDERProperties(json, res);
    return res;
  }

  protected void parseFOLDERProperties(JsonObject json, FOLDER res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("items")) {
      JsonArray array = getJArray(json, "items");
      for (int i = 0; i < array.size(); i++) {
        res.getItemsList().add(parseOBJECT_REF(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("folders")) {
      JsonArray array = getJArray(json, "folders");
      for (int i = 0; i < array.size(); i++) {
        res.getFoldersList().add(parseFOLDER(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("details"))
      res.setDetails(parseITEM_STRUCTURE(getJObject(json, "details")));
  }

  protected GENERIC_ID parseGENERIC_ID(JsonObject json) throws IOException, FHIRFormatError {
    GENERIC_ID res = new GENERIC_ID();
    parseGENERIC_IDProperties(json, res);
    return res;
  }

  protected void parseGENERIC_IDProperties(JsonObject json, GENERIC_ID res) throws IOException, FHIRFormatError {
    parseOBJECT_IDProperties(json, res);
  }

  protected GROUP parseGROUP(JsonObject json) throws IOException, FHIRFormatError {
    GROUP res = new GROUP();
    parseGROUPProperties(json, res);
    return res;
  }

  protected void parseGROUPProperties(JsonObject json, GROUP res) throws IOException, FHIRFormatError {
    parseACTORProperties(json, res);
  }

  protected HIER_OBJECT_ID parseHIER_OBJECT_ID(JsonObject json) throws IOException, FHIRFormatError {
    HIER_OBJECT_ID res = new HIER_OBJECT_ID();
    parseHIER_OBJECT_IDProperties(json, res);
    return res;
  }

  protected void parseHIER_OBJECT_IDProperties(JsonObject json, HIER_OBJECT_ID res) throws IOException, FHIRFormatError {
    parseUID_BASED_IDProperties(json, res);
  }

  protected HISTORY parseHISTORY(JsonObject json) throws IOException, FHIRFormatError {
    HISTORY res = new HISTORY();
    parseHISTORYProperties(json, res);
    return res;
  }

  protected void parseHISTORYProperties(JsonObject json, HISTORY res) throws IOException, FHIRFormatError {
    parseDATA_STRUCTUREProperties(json, res);
    if (json.has("origin"))
      res.setOrigin(parseDV_DATE_TIME(getJObject(json, "origin")));
    if (json.has("period"))
      res.setPeriod(parseDV_DURATION(getJObject(json, "period")));
    if (json.has("duration"))
      res.setDuration(parseDV_DURATION(getJObject(json, "duration")));
    if (json.has("summary"))
      res.setSummary(parseITEM_STRUCTURE(getJObject(json, "summary")));
    if (json.has("events")) {
      JsonArray array = getJArray(json, "events");
      for (int i = 0; i < array.size(); i++) {
        res.getEventsList().add(parseEVENT(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected IMPORTED_VERSION parseIMPORTED_VERSION(JsonObject json) throws IOException, FHIRFormatError {
    IMPORTED_VERSION res = new IMPORTED_VERSION();
    parseIMPORTED_VERSIONProperties(json, res);
    return res;
  }

  protected void parseIMPORTED_VERSIONProperties(JsonObject json, IMPORTED_VERSION res) throws IOException, FHIRFormatError {
    parseVERSIONProperties(json, res);
    if (json.has("item"))
      res.setItem(parseORIGINAL_VERSION(getJObject(json, "item")));
  }

  protected INSTRUCTION_DETAILS parseINSTRUCTION_DETAILS(JsonObject json) throws IOException, FHIRFormatError {
    INSTRUCTION_DETAILS res = new INSTRUCTION_DETAILS();
    parseINSTRUCTION_DETAILSProperties(json, res);
    return res;
  }

  protected void parseINSTRUCTION_DETAILSProperties(JsonObject json, INSTRUCTION_DETAILS res) throws IOException, FHIRFormatError {
    parsePATHABLEProperties(json, res);
    if (json.has("instruction_id"))
      res.setInstruction_id(parseLOCATABLE_REF(getJObject(json, "instruction_id")));
    if (json.has("activity_id"))
      res.setActivity_idElement(parseString(json.get("activity_id").getAsString()));
    if (json.has("_activity_id"))
      parseElementProperties(getJObject(json, "_activity_id"), res.getActivity_idElement());
    if (json.has("wf_details"))
      res.setWf_details(parseITEM_STRUCTURE(getJObject(json, "wf_details")));
  }

  protected INSTRUCTION parseINSTRUCTION(JsonObject json) throws IOException, FHIRFormatError {
    INSTRUCTION res = new INSTRUCTION();
    parseINSTRUCTIONProperties(json, res);
    return res;
  }

  protected void parseINSTRUCTIONProperties(JsonObject json, INSTRUCTION res) throws IOException, FHIRFormatError {
    parseCARE_ENTRYProperties(json, res);
    if (json.has("narrative"))
      res.setNarrative(parseDV_TEXT(getJObject(json, "narrative")));
    if (json.has("expiry_time"))
      res.setExpiry_time(parseDV_DATE_TIME(getJObject(json, "expiry_time")));
    if (json.has("wf_definition"))
      res.setWf_definition(parseDV_PARSABLE(getJObject(json, "wf_definition")));
    if (json.has("activities")) {
      JsonArray array = getJArray(json, "activities");
      for (int i = 0; i < array.size(); i++) {
        res.getActivitiesList().add(parseACTIVITY(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected INTERNET_ID parseINTERNET_ID(JsonObject json) throws IOException, FHIRFormatError {
    INTERNET_ID res = new INTERNET_ID();
    parseINTERNET_IDProperties(json, res);
    return res;
  }

  protected void parseINTERNET_IDProperties(JsonObject json, INTERNET_ID res) throws IOException, FHIRFormatError {
    parseUIDProperties(json, res);
  }

  protected INTERVAL_EVENT parseINTERVAL_EVENT(JsonObject json) throws IOException, FHIRFormatError {
    INTERVAL_EVENT res = new INTERVAL_EVENT();
    parseINTERVAL_EVENTProperties(json, res);
    return res;
  }

  protected void parseINTERVAL_EVENTProperties(JsonObject json, INTERVAL_EVENT res) throws IOException, FHIRFormatError {
    parseEVENTProperties(json, res);
    if (json.has("width"))
      res.setWidth(parseDV_DURATION(getJObject(json, "width")));
    if (json.has("sample_count"))
      res.setSample_countElement(parseInteger(json.get("sample_count").getAsLong()));
    if (json.has("_sample_count"))
      parseElementProperties(getJObject(json, "_sample_count"), res.getSample_countElement());
    if (json.has("math_function"))
      res.setMath_function(parseDV_CODED_TEXT(getJObject(json, "math_function")));
  }

  protected ISM_TRANSITION parseISM_TRANSITION(JsonObject json) throws IOException, FHIRFormatError {
    ISM_TRANSITION res = new ISM_TRANSITION();
    parseISM_TRANSITIONProperties(json, res);
    return res;
  }

  protected void parseISM_TRANSITIONProperties(JsonObject json, ISM_TRANSITION res) throws IOException, FHIRFormatError {
    parsePATHABLEProperties(json, res);
    if (json.has("current_state"))
      res.setCurrent_state(parseDV_CODED_TEXT(getJObject(json, "current_state")));
    if (json.has("transition"))
      res.setTransition(parseDV_CODED_TEXT(getJObject(json, "transition")));
    if (json.has("careflow_step"))
      res.setCareflow_step(parseDV_CODED_TEXT(getJObject(json, "careflow_step")));
    if (json.has("reason")) {
      JsonArray array = getJArray(json, "reason");
      for (int i = 0; i < array.size(); i++) {
        res.getReasonList().add(parseDV_TEXT(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected ISO_OID parseISO_OID(JsonObject json) throws IOException, FHIRFormatError {
    ISO_OID res = new ISO_OID();
    parseISO_OIDProperties(json, res);
    return res;
  }

  protected void parseISO_OIDProperties(JsonObject json, ISO_OID res) throws IOException, FHIRFormatError {
    parseUIDProperties(json, res);
  }

  protected ITEM_LIST parseITEM_LIST(JsonObject json) throws IOException, FHIRFormatError {
    ITEM_LIST res = new ITEM_LIST();
    parseITEM_LISTProperties(json, res);
    return res;
  }

  protected void parseITEM_LISTProperties(JsonObject json, ITEM_LIST res) throws IOException, FHIRFormatError {
    parseITEM_STRUCTUREProperties(json, res);
    if (json.has("items")) {
      JsonArray array = getJArray(json, "items");
      for (int i = 0; i < array.size(); i++) {
        res.getItemsList().add(parseELEMENT(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected ITEM_SINGLE parseITEM_SINGLE(JsonObject json) throws IOException, FHIRFormatError {
    ITEM_SINGLE res = new ITEM_SINGLE();
    parseITEM_SINGLEProperties(json, res);
    return res;
  }

  protected void parseITEM_SINGLEProperties(JsonObject json, ITEM_SINGLE res) throws IOException, FHIRFormatError {
    parseITEM_STRUCTUREProperties(json, res);
    if (json.has("item"))
      res.setItem(parseELEMENT(getJObject(json, "item")));
  }

  protected ITEM_TABLE parseITEM_TABLE(JsonObject json) throws IOException, FHIRFormatError {
    ITEM_TABLE res = new ITEM_TABLE();
    parseITEM_TABLEProperties(json, res);
    return res;
  }

  protected void parseITEM_TABLEProperties(JsonObject json, ITEM_TABLE res) throws IOException, FHIRFormatError {
    parseITEM_STRUCTUREProperties(json, res);
    if (json.has("rows")) {
      JsonArray array = getJArray(json, "rows");
      for (int i = 0; i < array.size(); i++) {
        res.getRowsList().add(parseCLUSTER(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected ITEM_TAG parseITEM_TAG(JsonObject json) throws IOException, FHIRFormatError {
    ITEM_TAG res = new ITEM_TAG();
    parseITEM_TAGProperties(json, res);
    return res;
  }

  protected void parseITEM_TAGProperties(JsonObject json, ITEM_TAG res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("key"))
      res.setKeyElement(parseString(json.get("key").getAsString()));
    if (json.has("_key"))
      parseElementProperties(getJObject(json, "_key"), res.getKeyElement());
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
    if (json.has("target"))
      res.setTarget(parseUID_BASED_ID(getJObject(json, "target")));
    if (json.has("target_path"))
      res.setTarget_pathElement(parseString(json.get("target_path").getAsString()));
    if (json.has("_target_path"))
      parseElementProperties(getJObject(json, "_target_path"), res.getTarget_pathElement());
    if (json.has("owner_id"))
      res.setOwner_id(parseOBJECT_REF(getJObject(json, "owner_id")));
  }

  protected ITEM_TREE parseITEM_TREE(JsonObject json) throws IOException, FHIRFormatError {
    ITEM_TREE res = new ITEM_TREE();
    parseITEM_TREEProperties(json, res);
    return res;
  }

  protected void parseITEM_TREEProperties(JsonObject json, ITEM_TREE res) throws IOException, FHIRFormatError {
    parseITEM_STRUCTUREProperties(json, res);
    if (json.has("items")) {
      JsonArray array = getJArray(json, "items");
      for (int i = 0; i < array.size(); i++) {
        res.getItemsList().add(parseITEM(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected LINK parseLINK(JsonObject json) throws IOException, FHIRFormatError {
    LINK res = new LINK();
    parseLINKProperties(json, res);
    return res;
  }

  protected void parseLINKProperties(JsonObject json, LINK res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("meaning"))
      res.setMeaning(parseDV_TEXT(getJObject(json, "meaning")));
    if (json.has("type"))
      res.setType(parseDV_TEXT(getJObject(json, "type")));
    if (json.has("target"))
      res.setTarget(parseDV_EHR_URI(getJObject(json, "target")));
  }

  protected LOCATABLE_REF parseLOCATABLE_REF(JsonObject json) throws IOException, FHIRFormatError {
    LOCATABLE_REF res = new LOCATABLE_REF();
    parseLOCATABLE_REFProperties(json, res);
    return res;
  }

  protected void parseLOCATABLE_REFProperties(JsonObject json, LOCATABLE_REF res) throws IOException, FHIRFormatError {
    parseOBJECT_REFProperties(json, res);
    if (json.has("path"))
      res.setPathElement(parseString(json.get("path").getAsString()));
    if (json.has("_path"))
      parseElementProperties(getJObject(json, "_path"), res.getPathElement());
  }

  protected OBJECT_REF parseOBJECT_REF(JsonObject json) throws IOException, FHIRFormatError {
    OBJECT_REF res = new OBJECT_REF();
    parseOBJECT_REFProperties(json, res);
    return res;
  }

  protected void parseOBJECT_REFProperties(JsonObject json, OBJECT_REF res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("namespace"))
      res.setNamespaceElement(parseString(json.get("namespace").getAsString()));
    if (json.has("_namespace"))
      parseElementProperties(getJObject(json, "_namespace"), res.getNamespaceElement());
    if (json.has("type"))
      res.setTypeElement(parseString(json.get("type").getAsString()));
    if (json.has("_type"))
      parseElementProperties(getJObject(json, "_type"), res.getTypeElement());
    if (json.has("id"))
      res.setId(parseOBJECT_ID(getJObject(json, "id")));
  }

  protected OBJECT_VERSION_ID parseOBJECT_VERSION_ID(JsonObject json) throws IOException, FHIRFormatError {
    OBJECT_VERSION_ID res = new OBJECT_VERSION_ID();
    parseOBJECT_VERSION_IDProperties(json, res);
    return res;
  }

  protected void parseOBJECT_VERSION_IDProperties(JsonObject json, OBJECT_VERSION_ID res) throws IOException, FHIRFormatError {
    parseUID_BASED_IDProperties(json, res);
  }

  protected OBSERVATION parseOBSERVATION(JsonObject json) throws IOException, FHIRFormatError {
    OBSERVATION res = new OBSERVATION();
    parseOBSERVATIONProperties(json, res);
    return res;
  }

  protected void parseOBSERVATIONProperties(JsonObject json, OBSERVATION res) throws IOException, FHIRFormatError {
    parseCARE_ENTRYProperties(json, res);
    if (json.has("data"))
      res.setData(parseHISTORY(getJObject(json, "data")));
    if (json.has("state"))
      res.setState(parseHISTORY(getJObject(json, "state")));
  }

  protected ORGANISATION parseORGANISATION(JsonObject json) throws IOException, FHIRFormatError {
    ORGANISATION res = new ORGANISATION();
    parseORGANISATIONProperties(json, res);
    return res;
  }

  protected void parseORGANISATIONProperties(JsonObject json, ORGANISATION res) throws IOException, FHIRFormatError {
    parseACTORProperties(json, res);
  }

  protected ORIGINAL_VERSION parseORIGINAL_VERSION(JsonObject json) throws IOException, FHIRFormatError {
    ORIGINAL_VERSION res = new ORIGINAL_VERSION();
    parseORIGINAL_VERSIONProperties(json, res);
    return res;
  }

  protected void parseORIGINAL_VERSIONProperties(JsonObject json, ORIGINAL_VERSION res) throws IOException, FHIRFormatError {
    parseVERSIONProperties(json, res);
    if (json.has("uid"))
      res.setUid(parseOBJECT_VERSION_ID(getJObject(json, "uid")));
    if (json.has("preceding_version_uid"))
      res.setPreceding_version_uid(parseOBJECT_VERSION_ID(getJObject(json, "preceding_version_uid")));
    if (json.has("other_input_version_uids")) {
      JsonArray array = getJArray(json, "other_input_version_uids");
      for (int i = 0; i < array.size(); i++) {
        res.getOther_input_version_uidsList().add(parseOBJECT_VERSION_ID(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("lifecycle_state"))
      res.setLifecycle_state(parseDV_CODED_TEXT(getJObject(json, "lifecycle_state")));
    if (json.has("attestations")) {
      JsonArray array = getJArray(json, "attestations");
      for (int i = 0; i < array.size(); i++) {
        res.getAttestationsList().add(parseATTESTATION(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("data"))
      res.setData(parseAny(getJObject(json, "data")));
  }

  protected PARTICIPATION parsePARTICIPATION(JsonObject json) throws IOException, FHIRFormatError {
    PARTICIPATION res = new PARTICIPATION();
    parsePARTICIPATIONProperties(json, res);
    return res;
  }

  protected void parsePARTICIPATIONProperties(JsonObject json, PARTICIPATION res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("function"))
      res.setFunction(parseDV_TEXT(getJObject(json, "function")));
    if (json.has("mode"))
      res.setMode(parseDV_CODED_TEXT(getJObject(json, "mode")));
    if (json.has("performer"))
      res.setPerformer(parsePARTY_PROXY(getJObject(json, "performer")));
    if (json.has("time"))
      res.setTime(parseDV_INTERVAL(getJObject(json, "time")));
  }

  protected PARTY_IDENTIFIED parsePARTY_IDENTIFIED(JsonObject json) throws IOException, FHIRFormatError {
    PARTY_IDENTIFIED res = new PARTY_IDENTIFIED();
    parsePARTY_IDENTIFIEDProperties(json, res);
    return res;
  }

  protected void parsePARTY_IDENTIFIEDProperties(JsonObject json, PARTY_IDENTIFIED res) throws IOException, FHIRFormatError {
    parsePARTY_PROXYProperties(json, res);
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(getJObject(json, "_name"), res.getNameElement());
    if (json.has("identifiers")) {
      JsonArray array = getJArray(json, "identifiers");
      for (int i = 0; i < array.size(); i++) {
        res.getIdentifiersList().add(parseDV_IDENTIFIER(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected PARTY_IDENTITY parsePARTY_IDENTITY(JsonObject json) throws IOException, FHIRFormatError {
    PARTY_IDENTITY res = new PARTY_IDENTITY();
    parsePARTY_IDENTITYProperties(json, res);
    return res;
  }

  protected void parsePARTY_IDENTITYProperties(JsonObject json, PARTY_IDENTITY res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("details"))
      res.setDetails(parseITEM_STRUCTURE(getJObject(json, "details")));
  }

  protected PARTY_REF parsePARTY_REF(JsonObject json) throws IOException, FHIRFormatError {
    PARTY_REF res = new PARTY_REF();
    parsePARTY_REFProperties(json, res);
    return res;
  }

  protected void parsePARTY_REFProperties(JsonObject json, PARTY_REF res) throws IOException, FHIRFormatError {
    parseOBJECT_REFProperties(json, res);
  }

  protected PARTY_RELATED parsePARTY_RELATED(JsonObject json) throws IOException, FHIRFormatError {
    PARTY_RELATED res = new PARTY_RELATED();
    parsePARTY_RELATEDProperties(json, res);
    return res;
  }

  protected void parsePARTY_RELATEDProperties(JsonObject json, PARTY_RELATED res) throws IOException, FHIRFormatError {
    parsePARTY_IDENTIFIEDProperties(json, res);
    if (json.has("relationship"))
      res.setRelationship(parseDV_CODED_TEXT(getJObject(json, "relationship")));
  }

  protected PARTY_RELATIONSHIP parsePARTY_RELATIONSHIP(JsonObject json) throws IOException, FHIRFormatError {
    PARTY_RELATIONSHIP res = new PARTY_RELATIONSHIP();
    parsePARTY_RELATIONSHIPProperties(json, res);
    return res;
  }

  protected void parsePARTY_RELATIONSHIPProperties(JsonObject json, PARTY_RELATIONSHIP res) throws IOException, FHIRFormatError {
    parseLOCATABLEProperties(json, res);
    if (json.has("details"))
      res.setDetails(parseITEM_STRUCTURE(getJObject(json, "details")));
    if (json.has("target"))
      res.setTarget(parsePARTY_REF(getJObject(json, "target")));
    if (json.has("time_validity"))
      res.setTime_validity(parseDV_INTERVAL(getJObject(json, "time_validity")));
    if (json.has("source"))
      res.setSource(parsePARTY_REF(getJObject(json, "source")));
  }

  protected PARTY_SELF parsePARTY_SELF(JsonObject json) throws IOException, FHIRFormatError {
    PARTY_SELF res = new PARTY_SELF();
    parsePARTY_SELFProperties(json, res);
    return res;
  }

  protected void parsePARTY_SELFProperties(JsonObject json, PARTY_SELF res) throws IOException, FHIRFormatError {
    parsePARTY_PROXYProperties(json, res);
  }

  protected PERSON parsePERSON(JsonObject json) throws IOException, FHIRFormatError {
    PERSON res = new PERSON();
    parsePERSONProperties(json, res);
    return res;
  }

  protected void parsePERSONProperties(JsonObject json, PERSON res) throws IOException, FHIRFormatError {
    parseACTORProperties(json, res);
  }

  protected POINT_EVENT parsePOINT_EVENT(JsonObject json) throws IOException, FHIRFormatError {
    POINT_EVENT res = new POINT_EVENT();
    parsePOINT_EVENTProperties(json, res);
    return res;
  }

  protected void parsePOINT_EVENTProperties(JsonObject json, POINT_EVENT res) throws IOException, FHIRFormatError {
    parseEVENTProperties(json, res);
  }

  protected REFERENCE_RANGE parseREFERENCE_RANGE(JsonObject json) throws IOException, FHIRFormatError {
    REFERENCE_RANGE res = new REFERENCE_RANGE();
    parseREFERENCE_RANGEProperties(json, res);
    return res;
  }

  protected void parseREFERENCE_RANGEProperties(JsonObject json, REFERENCE_RANGE res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("meaning"))
      res.setMeaning(parseDV_TEXT(getJObject(json, "meaning")));
    if (json.has("range"))
      res.setRange(parseDV_INTERVAL(getJObject(json, "range")));
  }

  protected RESOURCE_DESCRIPTION_ITEM parseRESOURCE_DESCRIPTION_ITEM(JsonObject json) throws IOException, FHIRFormatError {
    RESOURCE_DESCRIPTION_ITEM res = new RESOURCE_DESCRIPTION_ITEM();
    parseRESOURCE_DESCRIPTION_ITEMProperties(json, res);
    return res;
  }

  protected void parseRESOURCE_DESCRIPTION_ITEMProperties(JsonObject json, RESOURCE_DESCRIPTION_ITEM res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("language"))
      res.setLanguage(parseCODE_PHRASE(getJObject(json, "language")));
    if (json.has("purpose"))
      res.setPurposeElement(parseString(json.get("purpose").getAsString()));
    if (json.has("_purpose"))
      parseElementProperties(getJObject(json, "_purpose"), res.getPurposeElement());
    if (json.has("keywords")) {
      JsonArray array = getJArray(json, "keywords");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getKeywordsList().add(new StringType());
        } else {;
          res.getKeywordsList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_keywords")) {
      JsonArray array = getJArray(json, "_keywords");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getKeywordsList().size())
          res.getKeywordsList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getKeywordsList().get(i));
      }
    };
    if (json.has("use"))
      res.setUseElement(parseString(json.get("use").getAsString()));
    if (json.has("_use"))
      parseElementProperties(getJObject(json, "_use"), res.getUseElement());
    if (json.has("misuse"))
      res.setMisuseElement(parseString(json.get("misuse").getAsString()));
    if (json.has("_misuse"))
      parseElementProperties(getJObject(json, "_misuse"), res.getMisuseElement());
    if (json.has("copyright"))
      res.setCopyrightElement(parseString(json.get("copyright").getAsString()));
    if (json.has("_copyright"))
      parseElementProperties(getJObject(json, "_copyright"), res.getCopyrightElement());
    if (json.has("original_resource_uri")) {
      JsonArray array = getJArray(json, "original_resource_uri");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getOriginal_resource_uriList().add(new StringType());
        } else {;
          res.getOriginal_resource_uriList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_original_resource_uri")) {
      JsonArray array = getJArray(json, "_original_resource_uri");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getOriginal_resource_uriList().size())
          res.getOriginal_resource_uriList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getOriginal_resource_uriList().get(i));
      }
    };
    if (json.has("other_details")) {
      JsonArray array = getJArray(json, "other_details");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getOther_detailsList().add(new StringType());
        } else {;
          res.getOther_detailsList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_other_details")) {
      JsonArray array = getJArray(json, "_other_details");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getOther_detailsList().size())
          res.getOther_detailsList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getOther_detailsList().get(i));
      }
    };
  }

  protected RESOURCE_DESCRIPTION parseRESOURCE_DESCRIPTION(JsonObject json) throws IOException, FHIRFormatError {
    RESOURCE_DESCRIPTION res = new RESOURCE_DESCRIPTION();
    parseRESOURCE_DESCRIPTIONProperties(json, res);
    return res;
  }

  protected void parseRESOURCE_DESCRIPTIONProperties(JsonObject json, RESOURCE_DESCRIPTION res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("original_author")) {
      JsonArray array = getJArray(json, "original_author");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getOriginal_authorList().add(new StringType());
        } else {;
          res.getOriginal_authorList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_original_author")) {
      JsonArray array = getJArray(json, "_original_author");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getOriginal_authorList().size())
          res.getOriginal_authorList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getOriginal_authorList().get(i));
      }
    };
    if (json.has("other_contributors")) {
      JsonArray array = getJArray(json, "other_contributors");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getOther_contributorsList().add(new StringType());
        } else {;
          res.getOther_contributorsList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_other_contributors")) {
      JsonArray array = getJArray(json, "_other_contributors");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getOther_contributorsList().size())
          res.getOther_contributorsList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getOther_contributorsList().get(i));
      }
    };
    if (json.has("lifecycle_state"))
      res.setLifecycle_stateElement(parseString(json.get("lifecycle_state").getAsString()));
    if (json.has("_lifecycle_state"))
      parseElementProperties(getJObject(json, "_lifecycle_state"), res.getLifecycle_stateElement());
    if (json.has("resource_package_uri"))
      res.setResource_package_uriElement(parseString(json.get("resource_package_uri").getAsString()));
    if (json.has("_resource_package_uri"))
      parseElementProperties(getJObject(json, "_resource_package_uri"), res.getResource_package_uriElement());
    if (json.has("other_details")) {
      JsonArray array = getJArray(json, "other_details");
      for (int i = 0; i < array.size(); i++) {
        res.getOther_detailsList().add(parseOBJECT_REF(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("parent_resource"))
      res.setParent_resource(parseAUTHORED_RESOURCE(getJObject(json, "parent_resource")));
    if (json.has("details")) {
      JsonArray array = getJArray(json, "details");
      for (int i = 0; i < array.size(); i++) {
        res.getDetailsList().add(parseRESOURCE_DESCRIPTION_ITEM(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected REVISION_HISTORY_ITEM parseREVISION_HISTORY_ITEM(JsonObject json) throws IOException, FHIRFormatError {
    REVISION_HISTORY_ITEM res = new REVISION_HISTORY_ITEM();
    parseREVISION_HISTORY_ITEMProperties(json, res);
    return res;
  }

  protected void parseREVISION_HISTORY_ITEMProperties(JsonObject json, REVISION_HISTORY_ITEM res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("version_id"))
      res.setVersion_id(parseOBJECT_VERSION_ID(getJObject(json, "version_id")));
    if (json.has("audits")) {
      JsonArray array = getJArray(json, "audits");
      for (int i = 0; i < array.size(); i++) {
        res.getAuditsList().add(parseAUDIT_DETAILS(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected REVISION_HISTORY parseREVISION_HISTORY(JsonObject json) throws IOException, FHIRFormatError {
    REVISION_HISTORY res = new REVISION_HISTORY();
    parseREVISION_HISTORYProperties(json, res);
    return res;
  }

  protected void parseREVISION_HISTORYProperties(JsonObject json, REVISION_HISTORY res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("most_recent_version"))
      res.setMost_recent_versionElement(parseString(json.get("most_recent_version").getAsString()));
    if (json.has("_most_recent_version"))
      parseElementProperties(getJObject(json, "_most_recent_version"), res.getMost_recent_versionElement());
    if (json.has("most_recent_version_time_committed"))
      res.setMost_recent_version_time_committedElement(parseString(json.get("most_recent_version_time_committed").getAsString()));
    if (json.has("_most_recent_version_time_committed"))
      parseElementProperties(getJObject(json, "_most_recent_version_time_committed"), res.getMost_recent_version_time_committedElement());
  }

  protected ROLE parseROLE(JsonObject json) throws IOException, FHIRFormatError {
    ROLE res = new ROLE();
    parseROLEProperties(json, res);
    return res;
  }

  protected void parseROLEProperties(JsonObject json, ROLE res) throws IOException, FHIRFormatError {
    parsePARTYProperties(json, res);
    if (json.has("time_validity"))
      res.setTime_validity(parseDV_INTERVAL(getJObject(json, "time_validity")));
    if (json.has("performer"))
      res.setPerformer(parsePARTY_REF(getJObject(json, "performer")));
    if (json.has("capabilities")) {
      JsonArray array = getJArray(json, "capabilities");
      for (int i = 0; i < array.size(); i++) {
        res.getCapabilitiesList().add(parseCAPABILITY(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected SECTION parseSECTION(JsonObject json) throws IOException, FHIRFormatError {
    SECTION res = new SECTION();
    parseSECTIONProperties(json, res);
    return res;
  }

  protected void parseSECTIONProperties(JsonObject json, SECTION res) throws IOException, FHIRFormatError {
    parseCONTENT_ITEMProperties(json, res);
    if (json.has("items")) {
      JsonArray array = getJArray(json, "items");
      for (int i = 0; i < array.size(); i++) {
        res.getItemsList().add(parseCONTENT_ITEM(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected TEMPLATE_ID parseTEMPLATE_ID(JsonObject json) throws IOException, FHIRFormatError {
    TEMPLATE_ID res = new TEMPLATE_ID();
    parseTEMPLATE_IDProperties(json, res);
    return res;
  }

  protected void parseTEMPLATE_IDProperties(JsonObject json, TEMPLATE_ID res) throws IOException, FHIRFormatError {
    parseOBJECT_IDProperties(json, res);
  }

  protected TERM_MAPPING parseTERM_MAPPING(JsonObject json) throws IOException, FHIRFormatError {
    TERM_MAPPING res = new TERM_MAPPING();
    parseTERM_MAPPINGProperties(json, res);
    return res;
  }

  protected void parseTERM_MAPPINGProperties(JsonObject json, TERM_MAPPING res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("match"))
      res.setMatchElement(parseString(json.get("match").getAsString()));
    if (json.has("_match"))
      parseElementProperties(getJObject(json, "_match"), res.getMatchElement());
    if (json.has("purpose"))
      res.setPurpose(parseDV_CODED_TEXT(getJObject(json, "purpose")));
    if (json.has("target"))
      res.setTarget(parseCODE_PHRASE(getJObject(json, "target")));
  }

  protected TERMINOLOGY_ID parseTERMINOLOGY_ID(JsonObject json) throws IOException, FHIRFormatError {
    TERMINOLOGY_ID res = new TERMINOLOGY_ID();
    parseTERMINOLOGY_IDProperties(json, res);
    return res;
  }

  protected void parseTERMINOLOGY_IDProperties(JsonObject json, TERMINOLOGY_ID res) throws IOException, FHIRFormatError {
    parseOBJECT_IDProperties(json, res);
  }

  protected TRANSLATION_DETAILS parseTRANSLATION_DETAILS(JsonObject json) throws IOException, FHIRFormatError {
    TRANSLATION_DETAILS res = new TRANSLATION_DETAILS();
    parseTRANSLATION_DETAILSProperties(json, res);
    return res;
  }

  protected void parseTRANSLATION_DETAILSProperties(JsonObject json, TRANSLATION_DETAILS res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("language"))
      res.setLanguage(parseCODE_PHRASE(getJObject(json, "language")));
    if (json.has("author")) {
      JsonArray array = getJArray(json, "author");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getAuthorList().add(new StringType());
        } else {;
          res.getAuthorList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_author")) {
      JsonArray array = getJArray(json, "_author");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getAuthorList().size())
          res.getAuthorList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getAuthorList().get(i));
      }
    };
    if (json.has("accreditation"))
      res.setAccreditationElement(parseString(json.get("accreditation").getAsString()));
    if (json.has("_accreditation"))
      parseElementProperties(getJObject(json, "_accreditation"), res.getAccreditationElement());
    if (json.has("other_details")) {
      JsonArray array = getJArray(json, "other_details");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getOther_detailsList().add(new StringType());
        } else {;
          res.getOther_detailsList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_other_details")) {
      JsonArray array = getJArray(json, "_other_details");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getOther_detailsList().size())
          res.getOther_detailsList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getOther_detailsList().get(i));
      }
    };
  }

  protected TranslatedString parseTranslatedString(JsonObject json) throws IOException, FHIRFormatError {
    TranslatedString res = new TranslatedString();
    parseTranslatedStringProperties(json, res);
    return res;
  }

  protected void parseTranslatedStringProperties(JsonObject json, TranslatedString res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("language"))
      res.setLanguageElement(parseCode(json.get("language").getAsString()));
    if (json.has("_language"))
      parseElementProperties(getJObject(json, "_language"), res.getLanguageElement());
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected UUID parseUUID(JsonObject json) throws IOException, FHIRFormatError {
    UUID res = new UUID();
    parseUUIDProperties(json, res);
    return res;
  }

  protected void parseUUIDProperties(JsonObject json, UUID res) throws IOException, FHIRFormatError {
    parseUIDProperties(json, res);
  }

  protected VERSION_TREE_ID parseVERSION_TREE_ID(JsonObject json) throws IOException, FHIRFormatError {
    VERSION_TREE_ID res = new VERSION_TREE_ID();
    parseVERSION_TREE_IDProperties(json, res);
    return res;
  }

  protected void parseVERSION_TREE_IDProperties(JsonObject json, VERSION_TREE_ID res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected VERSIONED_COMPOSITION parseVERSIONED_COMPOSITION(JsonObject json) throws IOException, FHIRFormatError {
    VERSIONED_COMPOSITION res = new VERSIONED_COMPOSITION();
    parseVERSIONED_COMPOSITIONProperties(json, res);
    return res;
  }

  protected void parseVERSIONED_COMPOSITIONProperties(JsonObject json, VERSIONED_COMPOSITION res) throws IOException, FHIRFormatError {
    parseVERSIONED_OBJECTProperties(json, res);
  }

  protected VERSIONED_EHR_ACCESS parseVERSIONED_EHR_ACCESS(JsonObject json) throws IOException, FHIRFormatError {
    VERSIONED_EHR_ACCESS res = new VERSIONED_EHR_ACCESS();
    parseVERSIONED_EHR_ACCESSProperties(json, res);
    return res;
  }

  protected void parseVERSIONED_EHR_ACCESSProperties(JsonObject json, VERSIONED_EHR_ACCESS res) throws IOException, FHIRFormatError {
    parseVERSIONED_OBJECTProperties(json, res);
  }

  protected VERSIONED_EHR_STATUS parseVERSIONED_EHR_STATUS(JsonObject json) throws IOException, FHIRFormatError {
    VERSIONED_EHR_STATUS res = new VERSIONED_EHR_STATUS();
    parseVERSIONED_EHR_STATUSProperties(json, res);
    return res;
  }

  protected void parseVERSIONED_EHR_STATUSProperties(JsonObject json, VERSIONED_EHR_STATUS res) throws IOException, FHIRFormatError {
    parseVERSIONED_OBJECTProperties(json, res);
  }

  protected VERSIONED_FOLDER parseVERSIONED_FOLDER(JsonObject json) throws IOException, FHIRFormatError {
    VERSIONED_FOLDER res = new VERSIONED_FOLDER();
    parseVERSIONED_FOLDERProperties(json, res);
    return res;
  }

  protected void parseVERSIONED_FOLDERProperties(JsonObject json, VERSIONED_FOLDER res) throws IOException, FHIRFormatError {
    parseVERSIONED_OBJECTProperties(json, res);
  }

  protected VERSIONED_OBJECT parseVERSIONED_OBJECT(JsonObject json) throws IOException, FHIRFormatError {
    VERSIONED_OBJECT res = new VERSIONED_OBJECT();
    parseVERSIONED_OBJECTProperties(json, res);
    return res;
  }

  protected void parseVERSIONED_OBJECTProperties(JsonObject json, VERSIONED_OBJECT res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("uid"))
      res.setUid(parseHIER_OBJECT_ID(getJObject(json, "uid")));
    if (json.has("owner_id"))
      res.setOwner_id(parseOBJECT_REF(getJObject(json, "owner_id")));
    if (json.has("time_created"))
      res.setTime_created(parseDV_DATE_TIME(getJObject(json, "time_created")));
  }

  protected VERSIONED_PARTY parseVERSIONED_PARTY(JsonObject json) throws IOException, FHIRFormatError {
    VERSIONED_PARTY res = new VERSIONED_PARTY();
    parseVERSIONED_PARTYProperties(json, res);
    return res;
  }

  protected void parseVERSIONED_PARTYProperties(JsonObject json, VERSIONED_PARTY res) throws IOException, FHIRFormatError {
    parseVERSIONED_OBJECTProperties(json, res);
  }

  protected WebTemplate parseWebTemplate(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplate res = new WebTemplate();
    parseWebTemplateProperties(json, res);
    return res;
  }

  protected void parseWebTemplateProperties(JsonObject json, WebTemplate res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("templateId"))
      res.setTemplateIdElement(parseString(json.get("templateId").getAsString()));
    if (json.has("_templateId"))
      parseElementProperties(getJObject(json, "_templateId"), res.getTemplateIdElement());
    if (json.has("version"))
      res.setVersionElement(parseString(json.get("version").getAsString()));
    if (json.has("_version"))
      parseElementProperties(getJObject(json, "_version"), res.getVersionElement());
    if (json.has("semver"))
      res.setSemverElement(parseString(json.get("semver").getAsString()));
    if (json.has("_semver"))
      parseElementProperties(getJObject(json, "_semver"), res.getSemverElement());
    if (json.has("defaultLanguage"))
      res.setDefaultLanguageElement(parseString(json.get("defaultLanguage").getAsString()));
    if (json.has("_defaultLanguage"))
      parseElementProperties(getJObject(json, "_defaultLanguage"), res.getDefaultLanguageElement());
    if (json.has("languages")) {
      JsonArray array = getJArray(json, "languages");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getLanguagesList().add(new StringType());
        } else {;
          res.getLanguagesList().add(parseString(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_languages")) {
      JsonArray array = getJArray(json, "_languages");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getLanguagesList().size())
          res.getLanguagesList().add(parseString(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getLanguagesList().get(i));
      }
    };
    if (json.has("tree"))
      res.setTree(parseWebTemplateItem(getJObject(json, "tree")));
  }

  protected WebTemplateInput parseWebTemplateInput(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplateInput res = new WebTemplateInput();
    parseWebTemplateInputProperties(json, res);
    return res;
  }

  protected void parseWebTemplateInputProperties(JsonObject json, WebTemplateInput res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("suffix"))
      res.setSuffixElement(parseString(json.get("suffix").getAsString()));
    if (json.has("_suffix"))
      parseElementProperties(getJObject(json, "_suffix"), res.getSuffixElement());
    if (json.has("type"))
      res.setTypeElement(parseCode(json.get("type").getAsString()));
    if (json.has("_type"))
      parseElementProperties(getJObject(json, "_type"), res.getTypeElement());
    if (json.has("defaultValue"))
      res.setDefaultValue(parseNativePrimitive(json, "defaultValue"));
    if (json.has("terminology"))
      res.setTerminologyElement(parseCode(json.get("terminology").getAsString()));
    if (json.has("_terminology"))
      parseElementProperties(getJObject(json, "_terminology"), res.getTerminologyElement());
    if (json.has("validation"))
      res.setValidation(parseWebTemplateInputValidation(getJObject(json, "validation")));
    if (json.has("list")) {
      JsonArray array = getJArray(json, "list");
      for (int i = 0; i < array.size(); i++) {
        res.getListList().add(parseWebTemplateInputListItem(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("listOpen"))
      res.setListOpenElement(parseBoolean(json.get("listOpen").getAsBoolean()));
    if (json.has("_listOpen"))
      parseElementProperties(getJObject(json, "_listOpen"), res.getListOpenElement());
  }


  protected WebTemplateInputListItem parseWebTemplateInputListItem(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplateInputListItem res = new WebTemplateInputListItem();
    parseWebTemplateInputListItemProperties(json, res);
    return res;
  }

  protected void parseWebTemplateInputListItemProperties(JsonObject json, WebTemplateInputListItem res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseCode(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
    if (json.has("label"))
      res.setLabelElement(parseString(json.get("label").getAsString()));
    if (json.has("_label"))
      parseElementProperties(getJObject(json, "_label"), res.getLabelElement());
    if (json.has("ordinal"))
      res.setOrdinalElement(parseString(json.get("ordinal").getAsString()));
    if (json.has("_ordinal"))
      parseElementProperties(getJObject(json, "_ordinal"), res.getOrdinalElement());
    if (json.has("localizedLabels")) {
      JsonArray array = getJArray(json, "localizedLabels");
      for (int i = 0; i < array.size(); i++) {
        res.getLocalizedLabelsList().add(parseTranslatedString(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("localizedDescriptions")) {
      JsonArray array = getJArray(json, "localizedDescriptions");
      for (int i = 0; i < array.size(); i++) {
        res.getLocalizedDescriptionsList().add(parseTranslatedString(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("currentStates"))
      res.setCurrentStatesElement(parseString(json.get("currentStates").getAsString()));
    if (json.has("_currentStates"))
      parseElementProperties(getJObject(json, "_currentStates"), res.getCurrentStatesElement());
    if (json.has("range"))
      res.setRangeElement(parseString(json.get("range").getAsString()));
    if (json.has("_range"))
      parseElementProperties(getJObject(json, "_range"), res.getRangeElement());
    if (json.has("precision"))
      res.setPrecisionElement(parseString(json.get("precision").getAsString()));
    if (json.has("_precision"))
      parseElementProperties(getJObject(json, "_precision"), res.getPrecisionElement());
    if (json.has("termBindings")) {
      JsonArray array = getJArray(json, "termBindings");
      for (int i = 0; i < array.size(); i++) {
        res.getTermBindingsList().add(parseWebTemplateTermBinding(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected WebTemplateInputValidation parseWebTemplateInputValidation(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplateInputValidation res = new WebTemplateInputValidation();
    parseWebTemplateInputValidationProperties(json, res);
    return res;
  }

  protected void parseWebTemplateInputValidationProperties(JsonObject json, WebTemplateInputValidation res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("range"))
      res.setRange(parseWebTemplateInputValidationRange(getJObject(json, "range")));
    if (json.has("precision"))
      res.setPrecision(parseWebTemplateInputValidationRange(getJObject(json, "precision")));
  }

  protected WebTemplateInputValidationRange parseWebTemplateInputValidationRange(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplateInputValidationRange res = new WebTemplateInputValidationRange();
    parseWebTemplateInputValidationRangeProperties(json, res);
    return res;
  }

  protected void parseWebTemplateInputValidationRangeProperties(JsonObject json, WebTemplateInputValidationRange res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("minOp"))
      res.setMinOpElement(parseCode(json.get("minOp").getAsString()));
    if (json.has("_minOp"))
      parseElementProperties(getJObject(json, "_minOp"), res.getMinOpElement());
    if (json.has("min"))
      res.setMinElement(parseDecimal(json.get("min").getAsBigDecimal()));
    if (json.has("_min"))
      parseElementProperties(getJObject(json, "_min"), res.getMinElement());
    if (json.has("maxOp"))
      res.setMaxOpElement(parseCode(json.get("maxOp").getAsString()));
    if (json.has("_maxOp"))
      parseElementProperties(getJObject(json, "_maxOp"), res.getMaxOpElement());
    if (json.has("max"))
      res.setMaxElement(parseDecimal(json.get("max").getAsBigDecimal()));
    if (json.has("_max"))
      parseElementProperties(getJObject(json, "_max"), res.getMaxElement());
  }

  protected WebTemplateItem parseWebTemplateItem(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplateItem res = new WebTemplateItem();
    parseWebTemplateItemProperties(json, res);
    return res;
  }

  protected void parseWebTemplateItemProperties(JsonObject json, WebTemplateItem res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("id"))
      res.setIdElement(parseString(json.get("id").getAsString()));
    if (json.has("_id"))
      parseElementProperties(getJObject(json, "_id"), res.getIdElement());
    if (json.has("depth"))
      res.setDepthElement(parseInteger(json.get("depth").getAsLong()));
    if (json.has("_depth"))
      parseElementProperties(getJObject(json, "_depth"), res.getDepthElement());
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(getJObject(json, "_name"), res.getNameElement());
    if (json.has("localizedName"))
      res.setLocalizedNameElement(parseString(json.get("localizedName").getAsString()));
    if (json.has("_localizedName"))
      parseElementProperties(getJObject(json, "_localizedName"), res.getLocalizedNameElement());
    if (json.has("rmType"))
      res.setRmTypeElement(parseCode(json.get("rmType").getAsString()));
    if (json.has("_rmType"))
      parseElementProperties(getJObject(json, "_rmType"), res.getRmTypeElement());
    if (json.has("nodeId"))
      res.setNodeIdElement(parseString(json.get("nodeId").getAsString()));
    if (json.has("_nodeId"))
      parseElementProperties(getJObject(json, "_nodeId"), res.getNodeIdElement());
    if (json.has("min"))
      res.setMinElement(parseString(json.get("min").getAsString()));
    if (json.has("_min"))
      parseElementProperties(getJObject(json, "_min"), res.getMinElement());
    if (json.has("max"))
      res.setMaxElement(parseString(json.get("max").getAsString()));
    if (json.has("_max"))
      parseElementProperties(getJObject(json, "_max"), res.getMaxElement());
    if (json.has("dependsOn"))
      res.setDependsOnElement(parseString(json.get("dependsOn").getAsString()));
    if (json.has("_dependsOn"))
      parseElementProperties(getJObject(json, "_dependsOn"), res.getDependsOnElement());
    if (json.has("localizedNames")) {
      JsonArray array = getJArray(json, "localizedNames");
      for (int i = 0; i < array.size(); i++) {
        res.getLocalizedNamesList().add(parseTranslatedString(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("localizedDescriptions")) {
      JsonArray array = getJArray(json, "localizedDescriptions");
      for (int i = 0; i < array.size(); i++) {
        res.getLocalizedDescriptionsList().add(parseTranslatedString(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("annotations"))
      res.setAnnotations(parseAnnotations(getJObject(json, "annotations")));
    if (json.has("archetype_id"))
      res.setArchetype_idElement(parseString(json.get("archetype_id").getAsString()));
    if (json.has("_archetype_id"))
      parseElementProperties(getJObject(json, "_archetype_id"), res.getArchetype_idElement());
    if (json.has("aqlPath"))
      res.setAqlPathElement(parseString(json.get("aqlPath").getAsString()));
    if (json.has("_aqlPath"))
      parseElementProperties(getJObject(json, "_aqlPath"), res.getAqlPathElement());
    if (json.has("custodian_namespace"))
      res.setCustodian_namespaceElement(parseString(json.get("custodian_namespace").getAsString()));
    if (json.has("_custodian_namespace"))
      parseElementProperties(getJObject(json, "_custodian_namespace"), res.getCustodian_namespaceElement());
    if (json.has("custodian_organisation"))
      res.setCustodian_organisationElement(parseString(json.get("custodian_organisation").getAsString()));
    if (json.has("_custodian_organisation"))
      parseElementProperties(getJObject(json, "_custodian_organisation"), res.getCustodian_organisationElement());
    if (json.has("lifecycleState"))
      res.setLifecycleStateElement(parseCode(json.get("lifecycleState").getAsString()));
    if (json.has("_lifecycleState"))
      parseElementProperties(getJObject(json, "_lifecycleState"), res.getLifecycleStateElement());
    if (json.has("original_namespace"))
      res.setOriginal_namespaceElement(parseString(json.get("original_namespace").getAsString()));
    if (json.has("_original_namespace"))
      parseElementProperties(getJObject(json, "_original_namespace"), res.getOriginal_namespaceElement());
    if (json.has("original_publisher"))
      res.setOriginal_publisherElement(parseString(json.get("original_publisher").getAsString()));
    if (json.has("_original_publisher"))
      parseElementProperties(getJObject(json, "_original_publisher"), res.getOriginal_publisherElement());
    if (json.has("proportionTypes"))
      res.setProportionTypesElement(parseCode(json.get("proportionTypes").getAsString()));
    if (json.has("_proportionTypes"))
      parseElementProperties(getJObject(json, "_proportionTypes"), res.getProportionTypesElement());
    if (json.has("revision"))
      res.setRevisionElement(parseString(json.get("revision").getAsString()));
    if (json.has("_revision"))
      parseElementProperties(getJObject(json, "_revision"), res.getRevisionElement());
    if (json.has("inContext"))
      res.setInContextElement(parseBoolean(json.get("inContext").getAsBoolean()));
    if (json.has("_inContext"))
      parseElementProperties(getJObject(json, "_inContext"), res.getInContextElement());
    if (json.has("inputs")) {
      JsonArray array = getJArray(json, "inputs");
      for (int i = 0; i < array.size(); i++) {
        res.getInputsList().add(parseWebTemplateInput(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("termBindings")) {
      JsonArray array = getJArray(json, "termBindings");
      for (int i = 0; i < array.size(); i++) {
        res.getTermBindingsList().add(parseWebTemplateTermBinding(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("children")) {
      JsonArray array = getJArray(json, "children");
      for (int i = 0; i < array.size(); i++) {
        res.getChildrenList().add(parseWebTemplateItem(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected WebTemplateTermBinding parseWebTemplateTermBinding(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplateTermBinding res = new WebTemplateTermBinding();
    parseWebTemplateTermBindingProperties(json, res);
    return res;
  }

  protected void parseWebTemplateTermBindingProperties(JsonObject json, WebTemplateTermBinding res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("code"))
      res.setCodeElement(parseCode(json.get("code").getAsString()));
    if (json.has("_code"))
      parseElementProperties(getJObject(json, "_code"), res.getCodeElement());
    if (json.has("value"))
      res.setValue(parseWebTemplateTermBindingValue(getJObject(json, "value")));
  }

  protected WebTemplateTermBindingValue parseWebTemplateTermBindingValue(JsonObject json) throws IOException, FHIRFormatError {
    WebTemplateTermBindingValue res = new WebTemplateTermBindingValue();
    parseWebTemplateTermBindingValueProperties(json, res);
    return res;
  }

  protected void parseWebTemplateTermBindingValueProperties(JsonObject json, WebTemplateTermBindingValue res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
    if (json.has("terminologyId"))
      res.setTerminologyIdElement(parseString(json.get("terminologyId").getAsString()));
    if (json.has("_terminologyId"))
      parseElementProperties(getJObject(json, "_terminologyId"), res.getTerminologyIdElement());
  }


  

// -- compose ---------------------------------------------------------------------------------------------------------------------


  protected void composeACCESS_CONTROL_SETTINGS(String name, ACCESS_CONTROL_SETTINGS element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeACCESS_CONTROL_SETTINGSProperties(ACCESS_CONTROL_SETTINGS element) throws IOException {
      composeBaseProperties(element);
  }

  protected void composeACTOR(String name, ACTOR element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "AGENT":
        composeAGENTProperties((AGENT) element);
        close();
        break;
      case "GROUP":
        composeGROUPProperties((GROUP) element);
        close();
        break;
      case "PERSON":
        composePERSONProperties((PERSON) element);
        close();
        break;
      case "ORGANISATION":
        composeORGANISATIONProperties((ORGANISATION) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeACTORProperties(ACTOR element) throws IOException {
      composePARTYProperties(element);
      if (element.hasLanguages()) {
        openArray("languages");
        for (DV_TEXT e : element.getLanguagesList()) 
          composeDV_TEXT(null, e);
        closeArray();
      };
      if (element.hasRoles()) {
        openArray("roles");
        for (PARTY_REF e : element.getRolesList()) 
          composePARTY_REF(null, e);
        closeArray();
      };
  }

  protected void composeAUTHORED_RESOURCE(String name, AUTHORED_RESOURCE element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeAUTHORED_RESOURCEProperties(AUTHORED_RESOURCE element) throws IOException {
      composeBaseProperties(element);
      if (element.hasOriginal_language()) {
        composeCODE_PHRASE("original_language", element.getOriginal_language());
      }
      if (element.hasIs_controlledElement()) {
        composeBooleanCore("is_controlled", element.getIs_controlledElement(), false);
        composeBooleanExtras("is_controlled", element.getIs_controlledElement(), false);
      }
      if (element.hasTranslations()) {
        openArray("translations");
        for (TRANSLATION_DETAILS e : element.getTranslationsList()) 
          composeTRANSLATION_DETAILS(null, e);
        closeArray();
      };
      if (element.hasDescription()) {
        composeRESOURCE_DESCRIPTION("description", element.getDescription());
      }
      if (element.hasRevision_history()) {
        composeREVISION_HISTORY("revision_history", element.getRevision_history());
      }
  }

  protected void composeAny(String name, Any element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "EHR":
        composeEHRProperties((EHR) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeAnyProperties(Any element) throws IOException {
      composeBaseProperties(element);
  }

  protected void composeCARE_ENTRY(String name, CARE_ENTRY element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "INSTRUCTION":
        composeINSTRUCTIONProperties((INSTRUCTION) element);
        close();
        break;
      case "OBSERVATION":
        composeOBSERVATIONProperties((OBSERVATION) element);
        close();
        break;
      case "ACTION":
        composeACTIONProperties((ACTION) element);
        close();
        break;
      case "EVALUATION":
        composeEVALUATIONProperties((EVALUATION) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeCARE_ENTRYProperties(CARE_ENTRY element) throws IOException {
      composeENTRYProperties(element);
      if (element.hasProtocol()) {
        composeITEM_STRUCTURE("protocol", element.getProtocol());
      }
      if (element.hasGuideline_id()) {
        composeOBJECT_REF("guideline_id", element.getGuideline_id());
      }
  }

  protected void composeCONTENT_ITEM(String name, CONTENT_ITEM element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "SECTION":
        composeSECTIONProperties((SECTION) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeCONTENT_ITEMProperties(CONTENT_ITEM element) throws IOException {
      composeLOCATABLEProperties(element);
  }

  protected void composeDATA_STRUCTURE(String name, DATA_STRUCTURE element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "HISTORY":
        composeHISTORYProperties((HISTORY) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDATA_STRUCTUREProperties(DATA_STRUCTURE element) throws IOException {
      composeLOCATABLEProperties(element);
  }

  protected void composeDATA_VALUE(String name, DATA_VALUE element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-TEXT":
        composeDV_TEXTProperties((DV_TEXT) element);
        close();
        break;
      case "DV-IDENTIFIER":
        composeDV_IDENTIFIERProperties((DV_IDENTIFIER) element);
        close();
        break;
      case "DV-BOOLEAN":
        composeDV_BOOLEANProperties((DV_BOOLEAN) element);
        close();
        break;
      case "DV-PARAGRAPH":
        composeDV_PARAGRAPHProperties((DV_PARAGRAPH) element);
        close();
        break;
      case "DV-URI":
        composeDV_URIProperties((DV_URI) element);
        close();
        break;
      case "DV-STATE":
        composeDV_STATEProperties((DV_STATE) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDATA_VALUEProperties(DATA_VALUE element) throws IOException {
      composeBaseProperties(element);
  }

  protected void composeDV_ABSOLUTE_QUANTITY(String name, DV_ABSOLUTE_QUANTITY element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_ABSOLUTE_QUANTITYProperties(DV_ABSOLUTE_QUANTITY element) throws IOException {
      composeDV_QUANTIFIEDProperties(element);
  }

  protected void composeDV_AMOUNT(String name, DV_AMOUNT element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-DURATION":
        composeDV_DURATIONProperties((DV_DURATION) element);
        close();
        break;
      case "DV-COUNT":
        composeDV_COUNTProperties((DV_COUNT) element);
        close();
        break;
      case "DV-PROPORTION":
        composeDV_PROPORTIONProperties((DV_PROPORTION) element);
        close();
        break;
      case "DV-QUANTITY":
        composeDV_QUANTITYProperties((DV_QUANTITY) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_AMOUNTProperties(DV_AMOUNT element) throws IOException {
      composeDV_QUANTIFIEDProperties(element);
      if (element.hasAccuracy_is_percentElement()) {
        composeBooleanCore("accuracy_is_percent", element.getAccuracy_is_percentElement(), false);
        composeBooleanExtras("accuracy_is_percent", element.getAccuracy_is_percentElement(), false);
      }
  }

  protected void composeDV_ENCAPSULATED(String name, DV_ENCAPSULATED element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-MULTIMEDIA":
        composeDV_MULTIMEDIAProperties((DV_MULTIMEDIA) element);
        close();
        break;
      case "DV-PARSABLE":
        composeDV_PARSABLEProperties((DV_PARSABLE) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_ENCAPSULATEDProperties(DV_ENCAPSULATED element) throws IOException {
      composeDV_AMOUNTProperties(element);
      if (element.hasCharset()) {
        composeCODE_PHRASE("charset", element.getCharset());
      }
      if (element.hasLanguage()) {
        composeCODE_PHRASE("language", element.getLanguage());
      }
  }

  protected void composeDV_ORDERED(String name, DV_ORDERED element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-DATE-TIME":
        composeDV_DATE_TIMEProperties((DV_DATE_TIME) element);
        close();
        break;
      case "DV-TIME":
        composeDV_TIMEProperties((DV_TIME) element);
        close();
        break;
      case "DV-INTERVAL":
        composeDV_INTERVALProperties((DV_INTERVAL) element);
        close();
        break;
      case "DV-ORDINAL":
        composeDV_ORDINALProperties((DV_ORDINAL) element);
        close();
        break;
      case "DV-SCALE":
        composeDV_SCALEProperties((DV_SCALE) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_ORDEREDProperties(DV_ORDERED element) throws IOException {
      composeDATA_VALUEProperties(element);
      if (element.hasNormal_status()) {
        composeCODE_PHRASE("normal_status", element.getNormal_status());
      }
      if (element.hasNormal_range()) {
        composeDV_INTERVAL("normal_range", element.getNormal_range());
      }
      if (element.hasOther_reference_ranges()) {
        openArray("other_reference_ranges");
        for (REFERENCE_RANGE e : element.getOther_reference_rangesList()) 
          composeREFERENCE_RANGE(null, e);
        closeArray();
      };
  }

  protected void composeDV_QUANTIFIED(String name, DV_QUANTIFIED element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_QUANTIFIEDProperties(DV_QUANTIFIED element) throws IOException {
      composeDV_ORDEREDProperties(element);
      if (element.hasMagnitude_statusElement()) {
        composeStringCore("magnitude_status", element.getMagnitude_statusElement(), false);
        composeStringExtras("magnitude_status", element.getMagnitude_statusElement(), false);
      }
      if (element.hasAccuracy()) {
        composeBase("accuracy", element.getAccuracy());
      }
  }

  protected void composeDV_TEMPORAL(String name, DV_TEMPORAL element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-DATE":
        composeDV_DATEProperties((DV_DATE) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_TEMPORALProperties(DV_TEMPORAL element) throws IOException {
      composeDV_ABSOLUTE_QUANTITYProperties(element);
  }

  protected void composeDV_TIME_SPECIFICATION(String name, DV_TIME_SPECIFICATION element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "DV-GENERAL-TIME-SPECIFICATION":
        composeDV_GENERAL_TIME_SPECIFICATIONProperties((DV_GENERAL_TIME_SPECIFICATION) element);
        close();
        break;
      case "DV-PERIODIC-TIME-SPECIFICATION":
        composeDV_PERIODIC_TIME_SPECIFICATIONProperties((DV_PERIODIC_TIME_SPECIFICATION) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeDV_TIME_SPECIFICATIONProperties(DV_TIME_SPECIFICATION element) throws IOException {
      composeDATA_VALUEProperties(element);
      if (element.hasDV_PARSABLEElement()) {
        composeStringCore("DV_PARSABLE", element.getDV_PARSABLEElement(), false);
        composeStringExtras("DV_PARSABLE", element.getDV_PARSABLEElement(), false);
      }
  }

  protected void composeENTRY(String name, ENTRY element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "ADMIN-ENTRY":
        composeADMIN_ENTRYProperties((ADMIN_ENTRY) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeENTRYProperties(ENTRY element) throws IOException {
      composeCONTENT_ITEMProperties(element);
      if (element.hasLanguage()) {
        composeCODE_PHRASE("language", element.getLanguage());
      }
      if (element.hasEncoding()) {
        composeCODE_PHRASE("encoding", element.getEncoding());
      }
      if (element.hasOther_participations()) {
        openArray("other_participations");
        for (PARTICIPATION e : element.getOther_participationsList()) 
          composePARTICIPATION(null, e);
        closeArray();
      };
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
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "INTERVAL-EVENT":
        composeINTERVAL_EVENTProperties((INTERVAL_EVENT) element);
        close();
        break;
      case "POINT-EVENT":
        composePOINT_EVENTProperties((POINT_EVENT) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeEVENTProperties(EVENT element) throws IOException {
      composeLOCATABLEProperties(element);
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
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "ITEM-SINGLE":
        composeITEM_SINGLEProperties((ITEM_SINGLE) element);
        close();
        break;
      case "ITEM-TREE":
        composeITEM_TREEProperties((ITEM_TREE) element);
        close();
        break;
      case "ITEM-TABLE":
        composeITEM_TABLEProperties((ITEM_TABLE) element);
        close();
        break;
      case "ITEM-LIST":
        composeITEM_LISTProperties((ITEM_LIST) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeITEM_STRUCTUREProperties(ITEM_STRUCTURE element) throws IOException {
      composeDATA_STRUCTUREProperties(element);
  }

  protected void composeITEM(String name, ITEM element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "ELEMENT":
        composeELEMENTProperties((ELEMENT) element);
        close();
        break;
      case "CLUSTER":
        composeCLUSTERProperties((CLUSTER) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeITEMProperties(ITEM element) throws IOException {
      composeLOCATABLEProperties(element);
  }

  protected void composeLOCATABLE(String name, LOCATABLE element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "CONTACT":
        composeCONTACTProperties((CONTACT) element);
        close();
        break;
      case "EVENT-CONTEXT":
        composeEVENT_CONTEXTProperties((EVENT_CONTEXT) element);
        close();
        break;
      case "EHR-STATUS":
        composeEHR_STATUSProperties((EHR_STATUS) element);
        close();
        break;
      case "PARTY-IDENTITY":
        composePARTY_IDENTITYProperties((PARTY_IDENTITY) element);
        close();
        break;
      case "ADDRESS":
        composeADDRESSProperties((ADDRESS) element);
        close();
        break;
      case "COMPOSITION":
        composeCOMPOSITIONProperties((COMPOSITION) element);
        close();
        break;
      case "PARTY-RELATIONSHIP":
        composePARTY_RELATIONSHIPProperties((PARTY_RELATIONSHIP) element);
        close();
        break;
      case "CAPABILITY":
        composeCAPABILITYProperties((CAPABILITY) element);
        close();
        break;
      case "EHR-ACCESS":
        composeEHR_ACCESSProperties((EHR_ACCESS) element);
        close();
        break;
      case "ACTIVITY":
        composeACTIVITYProperties((ACTIVITY) element);
        close();
        break;
      case "FOLDER":
        composeFOLDERProperties((FOLDER) element);
        close();
        break;
      case "PARTICIPATION":
        composePARTICIPATIONProperties((PARTICIPATION) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeLOCATABLEProperties(LOCATABLE element) throws IOException {
      composePATHABLEProperties(element);
  }

  protected void composeOBJECT_ID(String name, OBJECT_ID element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "TEMPLATE-ID":
        composeTEMPLATE_IDProperties((TEMPLATE_ID) element);
        close();
        break;
      case "ARCHETYPE-ID":
        composeARCHETYPE_IDProperties((ARCHETYPE_ID) element);
        close();
        break;
      case "GENERIC-ID":
        composeGENERIC_IDProperties((GENERIC_ID) element);
        close();
        break;
      case "TERMINOLOGY-ID":
        composeTERMINOLOGY_IDProperties((TERMINOLOGY_ID) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeOBJECT_IDProperties(OBJECT_ID element) throws IOException {
      composeUIDProperties(element);
  }

  protected void composePARTY_PROXY(String name, PARTY_PROXY element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "PARTY-SELF":
        composePARTY_SELFProperties((PARTY_SELF) element);
        close();
        break;
      case "PARTY-IDENTIFIED":
        composePARTY_IDENTIFIEDProperties((PARTY_IDENTIFIED) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composePARTY_PROXYProperties(PARTY_PROXY element) throws IOException {
      composeBaseProperties(element);
      if (element.hasExternal_ref()) {
        composePARTY_REF("external_ref", element.getExternal_ref());
      }
  }

  protected void composePARTY(String name, PARTY element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "ROLE":
        composeROLEProperties((ROLE) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composePARTYProperties(PARTY element) throws IOException {
      composeLOCATABLEProperties(element);
      if (element.hasIdentities()) {
        openArray("identities");
        for (PARTY_IDENTITY e : element.getIdentitiesList()) 
          composePARTY_IDENTITY(null, e);
        closeArray();
      };
      if (element.hasContacts()) {
        composeCONTACT("contacts", element.getContacts());
      }
      if (element.hasDetails()) {
        composeITEM_STRUCTURE("details", element.getDetails());
      }
      if (element.hasReverse_relationships()) {
        openArray("reverse_relationships");
        for (LOCATABLE_REF e : element.getReverse_relationshipsList()) 
          composeLOCATABLE_REF(null, e);
        closeArray();
      };
      if (element.hasRelationships()) {
        openArray("relationships");
        for (PARTY_RELATIONSHIP e : element.getRelationshipsList()) 
          composePARTY_RELATIONSHIP(null, e);
        closeArray();
      };
  }

  protected void composePATHABLE(String name, PATHABLE element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "INSTRUCTION-DETAILS":
        composeINSTRUCTION_DETAILSProperties((INSTRUCTION_DETAILS) element);
        close();
        break;
      case "ISM-TRANSITION":
        composeISM_TRANSITIONProperties((ISM_TRANSITION) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composePATHABLEProperties(PATHABLE element) throws IOException {
      composeAnyProperties(element);
      if (element.hasName()) {
        composeDV_TEXT("name", element.getName());
      }
      if (element.hasArchetype_node_idElement()) {
        composeStringCore("archetype_node_id", element.getArchetype_node_idElement(), false);
        composeStringExtras("archetype_node_id", element.getArchetype_node_idElement(), false);
      }
      if (element.hasUid()) {
        composeUID_BASED_ID("uid", element.getUid());
      }
      if (element.hasLinks()) {
        openArray("links");
        for (LINK e : element.getLinksList()) 
          composeLINK(null, e);
        closeArray();
      };
      if (element.hasArchetype_details()) {
        composeARCHETYPED("archetype_details", element.getArchetype_details());
      }
      if (element.hasFeeder_audit()) {
        composeFEEDER_AUDIT("feeder_audit", element.getFeeder_audit());
      }
  }

  protected void composeUID_BASED_ID(String name, UID_BASED_ID element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "OBJECT-VERSION-ID":
        composeOBJECT_VERSION_IDProperties((OBJECT_VERSION_ID) element);
        close();
        break;
      case "HIER-OBJECT-ID":
        composeHIER_OBJECT_IDProperties((HIER_OBJECT_ID) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeUID_BASED_IDProperties(UID_BASED_ID element) throws IOException {
      composeOBJECT_IDProperties(element);
  }

  protected void composeUID(String name, UID element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "ISO-OID":
        composeISO_OIDProperties((ISO_OID) element);
        close();
        break;
      case "UUID":
        composeUUIDProperties((UUID) element);
        close();
        break;
      case "INTERNET-ID":
        composeINTERNET_IDProperties((INTERNET_ID) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeUIDProperties(UID element) throws IOException {
      composeBaseProperties(element);
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeVERSION(String name, VERSION element) throws IOException {
    if (element != null) {
      open(name);
      prop("_type", element.fhirType());
      switch (element.fhirType()) {
      case "IMPORTED-VERSION":
        composeIMPORTED_VERSIONProperties((IMPORTED_VERSION) element);
        close();
        break;
      case "ORIGINAL-VERSION":
        composeORIGINAL_VERSIONProperties((ORIGINAL_VERSION) element);
        close();
        break;
      default: throw new FHIRException("Unsupported type '"+element.fhirType()+"'");
      }
    }
  }

  protected void composeVERSIONProperties(VERSION element) throws IOException {
      composeBaseProperties(element);
      if (element.hasContribution()) {
        composeOBJECT_REF("contribution", element.getContribution());
      }
      if (element.hasSignatureElement()) {
        composeStringCore("signature", element.getSignatureElement(), false);
        composeStringExtras("signature", element.getSignatureElement(), false);
      }
      if (element.hasCommit_audit()) {
        composeAUDIT_DETAILS("commit_audit", element.getCommit_audit());
      }
  }

  protected void composeACTION(String name, ACTION element) throws IOException {
    if (element != null) {
      open(name);
      composeACTIONProperties(element);
      close();
    }
  }

  protected void composeACTIONProperties(ACTION element) throws IOException {
    composeCARE_ENTRYProperties(element);
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
      open(name);
      composeACTIVITYProperties(element);
      close();
    }
  }

  protected void composeACTIVITYProperties(ACTIVITY element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasTiming()) {
        composeDV_PARSABLE("timing", element.getTiming());
      }
      if (element.hasAction_archetype_idElement()) {
        composeStringCore("action_archetype_id", element.getAction_archetype_idElement(), false);
        composeStringExtras("action_archetype_id", element.getAction_archetype_idElement(), false);
      }
      if (element.hasDescription()) {
        composeITEM_STRUCTURE("description", element.getDescription());
      }
  }

  protected void composeADDRESS(String name, ADDRESS element) throws IOException {
    if (element != null) {
      open(name);
      composeADDRESSProperties(element);
      close();
    }
  }

  protected void composeADDRESSProperties(ADDRESS element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasDetails()) {
        composeITEM_STRUCTURE("details", element.getDetails());
      }
  }

  protected void composeADMIN_ENTRY(String name, ADMIN_ENTRY element) throws IOException {
    if (element != null) {
      open(name);
      composeADMIN_ENTRYProperties(element);
      close();
    }
  }

  protected void composeADMIN_ENTRYProperties(ADMIN_ENTRY element) throws IOException {
    composeENTRYProperties(element);
      if (element.hasData()) {
        composeITEM_STRUCTURE("data", element.getData());
      }
  }

  protected void composeAGENT(String name, AGENT element) throws IOException {
    if (element != null) {
      open(name);
      composeAGENTProperties(element);
      close();
    }
  }

  protected void composeAGENTProperties(AGENT element) throws IOException {
    composeACTORProperties(element);
  }

  protected void composeARCHETYPE_ID(String name, ARCHETYPE_ID element) throws IOException {
    if (element != null) {
      open(name);
      composeARCHETYPE_IDProperties(element);
      close();
    }
  }

  protected void composeARCHETYPE_IDProperties(ARCHETYPE_ID element) throws IOException {
    composeOBJECT_IDProperties(element);
  }

  protected void composeARCHETYPED(String name, ARCHETYPED element) throws IOException {
    if (element != null) {
      open(name);
      composeARCHETYPEDProperties(element);
      close();
    }
  }

  protected void composeARCHETYPEDProperties(ARCHETYPED element) throws IOException {
    composeBaseProperties(element);
      if (element.hasArchetype_id()) {
        composeARCHETYPE_ID("archetype_id", element.getArchetype_id());
      }
      if (element.hasTemplate_id()) {
        composeTEMPLATE_ID("template_id", element.getTemplate_id());
      }
      if (element.hasRm_versionElement()) {
        composeStringCore("rm_version", element.getRm_versionElement(), false);
        composeStringExtras("rm_version", element.getRm_versionElement(), false);
      }
  }

  protected void composeATTESTATION(String name, ATTESTATION element) throws IOException {
    if (element != null) {
      open(name);
      composeATTESTATIONProperties(element);
      close();
    }
  }

  protected void composeATTESTATIONProperties(ATTESTATION element) throws IOException {
    composeAUDIT_DETAILSProperties(element);
      if (element.hasAttested_view()) {
        composeDV_MULTIMEDIA("attested_view", element.getAttested_view());
      }
      if (element.hasProofElement()) {
        composeStringCore("proof", element.getProofElement(), false);
        composeStringExtras("proof", element.getProofElement(), false);
      }
      if (element.hasItems()) {
        openArray("items");
        for (DV_EHR_URI e : element.getItemsList()) 
          composeDV_EHR_URI(null, e);
        closeArray();
      };
      if (element.hasReason()) {
        composeDV_TEXT("reason", element.getReason());
      }
      if (element.hasIs_pendingElement()) {
        composeBooleanCore("is_pending", element.getIs_pendingElement(), false);
        composeBooleanExtras("is_pending", element.getIs_pendingElement(), false);
      }
  }

  protected void composeAUDIT_DETAILS(String name, AUDIT_DETAILS element) throws IOException {
    if (element != null) {
      open(name);
      composeAUDIT_DETAILSProperties(element);
      close();
    }
  }

  protected void composeAUDIT_DETAILSProperties(AUDIT_DETAILS element) throws IOException {
    composeBaseProperties(element);
      if (element.hasSystem_idElement()) {
        composeStringCore("system_id", element.getSystem_idElement(), false);
        composeStringExtras("system_id", element.getSystem_idElement(), false);
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
      open(name);
      composeAnnotationsProperties(element);
      close();
    }
  }

  protected void composeAnnotationsProperties(Annotations element) throws IOException {
    composeBaseProperties(element);
      if (element.hasCommentElement()) {
        composeStringCore("comment", element.getCommentElement(), false);
        composeStringExtras("comment", element.getCommentElement(), false);
      }
      if (element.hasFhir_mappingElement()) {
        composeStringCore("fhir_mapping", element.getFhir_mappingElement(), false);
        composeStringExtras("fhir_mapping", element.getFhir_mappingElement(), false);
      }
      if (element.hasVset_descriptionElement()) {
        composeStringCore("vset_description", element.getVset_descriptionElement(), false);
        composeStringExtras("vset_description", element.getVset_descriptionElement(), false);
      }
      if (element.hasHl7v2_mappingElement()) {
        composeStringCore("hl7v2_mapping", element.getHl7v2_mappingElement(), false);
        composeStringExtras("hl7v2_mapping", element.getHl7v2_mappingElement(), false);
      }
      if (element.hasVisibleInViewElement()) {
        composeStringCore("visibleInView", element.getVisibleInViewElement(), false);
        composeStringExtras("visibleInView", element.getVisibleInViewElement(), false);
      }
  }

  protected void composeCAPABILITY(String name, CAPABILITY element) throws IOException {
    if (element != null) {
      open(name);
      composeCAPABILITYProperties(element);
      close();
    }
  }

  protected void composeCAPABILITYProperties(CAPABILITY element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasCredentials()) {
        composeITEM_STRUCTURE("credentials", element.getCredentials());
      }
      if (element.hasTime_validity()) {
        composeDV_INTERVAL("time_validity", element.getTime_validity());
      }
  }

  protected void composeCLUSTER(String name, CLUSTER element) throws IOException {
    if (element != null) {
      open(name);
      composeCLUSTERProperties(element);
      close();
    }
  }

  protected void composeCLUSTERProperties(CLUSTER element) throws IOException {
    composeITEMProperties(element);
      if (element.hasItems()) {
        openArray("items");
        for (ITEM e : element.getItemsList()) 
          composeITEM(null, e);
        closeArray();
      };
  }

  protected void composeCODE_PHRASE(String name, CODE_PHRASE element) throws IOException {
    if (element != null) {
      open(name);
      composeCODE_PHRASEProperties(element);
      close();
    }
  }

  protected void composeCODE_PHRASEProperties(CODE_PHRASE element) throws IOException {
    composeBaseProperties(element);
      if (element.hasTerminology_id()) {
        composeTERMINOLOGY_ID("terminology_id", element.getTerminology_id());
      }
      if (element.hasCode_stringElement()) {
        composeStringCore("code_string", element.getCode_stringElement(), false);
        composeStringExtras("code_string", element.getCode_stringElement(), false);
      }
      if (element.hasPreferred_termElement()) {
        composeStringCore("preferred_term", element.getPreferred_termElement(), false);
        composeStringExtras("preferred_term", element.getPreferred_termElement(), false);
      }
  }

  protected void composeCOMPOSITION(String name, COMPOSITION element) throws IOException {
    if (element != null) {
      open(name);
      composeCOMPOSITIONProperties(element);
      close();
    }
  }

  protected void composeCOMPOSITIONProperties(COMPOSITION element) throws IOException {
    composeLOCATABLEProperties(element);
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
        openArray("content");
        for (CONTENT_ITEM e : element.getContentList()) 
          composeCONTENT_ITEM(null, e);
        closeArray();
      };
  }

  protected void composeCONTACT(String name, CONTACT element) throws IOException {
    if (element != null) {
      open(name);
      composeCONTACTProperties(element);
      close();
    }
  }

  protected void composeCONTACTProperties(CONTACT element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasAddresses()) {
        openArray("addresses");
        for (ADDRESS e : element.getAddressesList()) 
          composeADDRESS(null, e);
        closeArray();
      };
      if (element.hasTime_validity()) {
        composeDV_INTERVAL("time_validity", element.getTime_validity());
      }
  }

  protected void composeCONTRIBUTION(String name, CONTRIBUTION element) throws IOException {
    if (element != null) {
      open(name);
      composeCONTRIBUTIONProperties(element);
      close();
    }
  }

  protected void composeCONTRIBUTIONProperties(CONTRIBUTION element) throws IOException {
    composeBaseProperties(element);
      if (element.hasUid()) {
        composeHIER_OBJECT_ID("uid", element.getUid());
      }
      if (element.hasVersions()) {
        openArray("versions");
        for (OBJECT_REF e : element.getVersionsList()) 
          composeOBJECT_REF(null, e);
        closeArray();
      };
      if (element.hasAudit()) {
        composeAUDIT_DETAILS("audit", element.getAudit());
      }
  }

  protected void composeDV_BOOLEAN(String name, DV_BOOLEAN element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_BOOLEANProperties(element);
      close();
    }
  }

  protected void composeDV_BOOLEANProperties(DV_BOOLEAN element) throws IOException {
    composeDATA_VALUEProperties(element);
      if (element.hasValueElement()) {
        composeBooleanCore("value", element.getValueElement(), false);
        composeBooleanExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeDV_CODED_TEXT(String name, DV_CODED_TEXT element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_CODED_TEXTProperties(element);
      close();
    }
  }

  protected void composeDV_CODED_TEXTProperties(DV_CODED_TEXT element) throws IOException {
    composeDV_TEXTProperties(element);
      if (element.hasDefining_code()) {
        composeCODE_PHRASE("defining_code", element.getDefining_code());
      }
  }

  protected void composeDV_COUNT(String name, DV_COUNT element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_COUNTProperties(element);
      close();
    }
  }

  protected void composeDV_COUNTProperties(DV_COUNT element) throws IOException {
    composeDV_AMOUNTProperties(element);
      if (element.hasMagnitudeElement()) {
        composeDecimalCore("magnitude", element.getMagnitudeElement(), false);
        composeDecimalExtras("magnitude", element.getMagnitudeElement(), false);
      }
  }

  protected void composeDV_DATE_TIME(String name, DV_DATE_TIME element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_DATE_TIMEProperties(element);
      close();
    }
  }

  protected void composeDV_DATE_TIMEProperties(DV_DATE_TIME element) throws IOException {
    composeDV_ORDEREDProperties(element);
      if (element.hasValueElement()) {
        composeDateTimeCore("value", element.getValueElement(), false);
        composeDateTimeExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeDV_DATE(String name, DV_DATE element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_DATEProperties(element);
      close();
    }
  }

  protected void composeDV_DATEProperties(DV_DATE element) throws IOException {
    composeDV_TEMPORALProperties(element);
      if (element.hasValueElement()) {
        composeDateTimeCore("value", element.getValueElement(), false);
        composeDateTimeExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeDV_DURATION(String name, DV_DURATION element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_DURATIONProperties(element);
      close();
    }
  }

  protected void composeDV_DURATIONProperties(DV_DURATION element) throws IOException {
    composeDV_AMOUNTProperties(element);
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeDV_EHR_URI(String name, DV_EHR_URI element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_EHR_URIProperties(element);
      close();
    }
  }

  protected void composeDV_EHR_URIProperties(DV_EHR_URI element) throws IOException {
    composeDV_URIProperties(element);
  }

  protected void composeDV_GENERAL_TIME_SPECIFICATION(String name, DV_GENERAL_TIME_SPECIFICATION element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_GENERAL_TIME_SPECIFICATIONProperties(element);
      close();
    }
  }

  protected void composeDV_GENERAL_TIME_SPECIFICATIONProperties(DV_GENERAL_TIME_SPECIFICATION element) throws IOException {
    composeDV_TIME_SPECIFICATIONProperties(element);
  }

  protected void composeDV_IDENTIFIER(String name, DV_IDENTIFIER element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_IDENTIFIERProperties(element);
      close();
    }
  }

  protected void composeDV_IDENTIFIERProperties(DV_IDENTIFIER element) throws IOException {
    composeDATA_VALUEProperties(element);
      if (element.hasIssuerElement()) {
        composeStringCore("issuer", element.getIssuerElement(), false);
        composeStringExtras("issuer", element.getIssuerElement(), false);
      }
      if (element.hasAssignerElement()) {
        composeStringCore("assigner", element.getAssignerElement(), false);
        composeStringExtras("assigner", element.getAssignerElement(), false);
      }
      if (element.hasIdElement()) {
        composeStringCore("id", element.getIdElement(), false);
        composeStringExtras("id", element.getIdElement(), false);
      }
      if (element.hasTypeElement()) {
        composeStringCore("type", element.getTypeElement(), false);
        composeStringExtras("type", element.getTypeElement(), false);
      }
  }

  protected void composeDV_INTERVAL(String name, DV_INTERVAL element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_INTERVALProperties(element);
      close();
    }
  }

  protected void composeDV_INTERVALProperties(DV_INTERVAL element) throws IOException {
    composeDV_ORDEREDProperties(element);
  }

  protected void composeDV_MULTIMEDIA(String name, DV_MULTIMEDIA element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_MULTIMEDIAProperties(element);
      close();
    }
  }

  protected void composeDV_MULTIMEDIAProperties(DV_MULTIMEDIA element) throws IOException {
    composeDV_ENCAPSULATEDProperties(element);
      if (element.hasAlternate_textElement()) {
        composeStringCore("alternate_text", element.getAlternate_textElement(), false);
        composeStringExtras("alternate_text", element.getAlternate_textElement(), false);
      }
      if (element.hasUri()) {
        composeDV_URI("uri", element.getUri());
      }
      if (element.hasDataElement()) {
        composeBase64BinaryCore("data", element.getDataElement(), false);
        composeBase64BinaryExtras("data", element.getDataElement(), false);
      }
      if (element.hasMedia_type()) {
        composeCODE_PHRASE("media_type", element.getMedia_type());
      }
      if (element.hasCompression_algorithm()) {
        composeCODE_PHRASE("compression_algorithm", element.getCompression_algorithm());
      }
      if (element.hasIntegrity_checkElement()) {
        composeBase64BinaryCore("integrity_check", element.getIntegrity_checkElement(), false);
        composeBase64BinaryExtras("integrity_check", element.getIntegrity_checkElement(), false);
      }
      if (element.hasIntegrity_check_algorithm()) {
        composeCODE_PHRASE("integrity_check_algorithm", element.getIntegrity_check_algorithm());
      }
      if (element.hasThumbnail()) {
        composeDV_MULTIMEDIA("thumbnail", element.getThumbnail());
      }
      if (element.hasSizeElement()) {
        composeIntegerCore("size", element.getSizeElement(), false);
        composeIntegerExtras("size", element.getSizeElement(), false);
      }
  }

  protected void composeDV_ORDINAL(String name, DV_ORDINAL element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_ORDINALProperties(element);
      close();
    }
  }

  protected void composeDV_ORDINALProperties(DV_ORDINAL element) throws IOException {
    composeDV_ORDEREDProperties(element);
      if (element.hasSymbol()) {
        composeDV_CODED_TEXT("symbol", element.getSymbol());
      }
      if (element.hasValueElement()) {
        composeIntegerCore("value", element.getValueElement(), false);
        composeIntegerExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeDV_PARAGRAPH(String name, DV_PARAGRAPH element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_PARAGRAPHProperties(element);
      close();
    }
  }

  protected void composeDV_PARAGRAPHProperties(DV_PARAGRAPH element) throws IOException {
    composeDATA_VALUEProperties(element);
      if (element.hasItems()) {
        openArray("items");
        for (DV_TEXT e : element.getItemsList()) 
          composeDV_TEXT(null, e);
        closeArray();
      };
  }

  protected void composeDV_PARSABLE(String name, DV_PARSABLE element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_PARSABLEProperties(element);
      close();
    }
  }

  protected void composeDV_PARSABLEProperties(DV_PARSABLE element) throws IOException {
    composeDV_ENCAPSULATEDProperties(element);
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
      if (element.hasFormalismElement()) {
        composeStringCore("formalism", element.getFormalismElement(), false);
        composeStringExtras("formalism", element.getFormalismElement(), false);
      }
  }

  protected void composeDV_PERIODIC_TIME_SPECIFICATION(String name, DV_PERIODIC_TIME_SPECIFICATION element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_PERIODIC_TIME_SPECIFICATIONProperties(element);
      close();
    }
  }

  protected void composeDV_PERIODIC_TIME_SPECIFICATIONProperties(DV_PERIODIC_TIME_SPECIFICATION element) throws IOException {
    composeDV_TIME_SPECIFICATIONProperties(element);
  }

  protected void composeDV_PROPORTION(String name, DV_PROPORTION element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_PROPORTIONProperties(element);
      close();
    }
  }

  protected void composeDV_PROPORTIONProperties(DV_PROPORTION element) throws IOException {
    composeDV_AMOUNTProperties(element);
      if (element.hasNumeratorElement()) {
        composeDecimalCore("numerator", element.getNumeratorElement(), false);
        composeDecimalExtras("numerator", element.getNumeratorElement(), false);
      }
      if (element.hasDenominatorElement()) {
        composeDecimalCore("denominator", element.getDenominatorElement(), false);
        composeDecimalExtras("denominator", element.getDenominatorElement(), false);
      }
      if (element.hasTypeElement()) {
        composeCodeCore("type", element.getTypeElement(), false);
        composeCodeExtras("type", element.getTypeElement(), false);
      }
      if (element.hasPrecisionElement()) {
        composeIntegerCore("precision", element.getPrecisionElement(), false);
        composeIntegerExtras("precision", element.getPrecisionElement(), false);
      }
  }

  protected void composeDV_QUANTITY(String name, DV_QUANTITY element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_QUANTITYProperties(element);
      close();
    }
  }

  protected void composeDV_QUANTITYProperties(DV_QUANTITY element) throws IOException {
    composeDV_AMOUNTProperties(element);
      if (element.hasMagnitudeElement()) {
        composeDecimalCore("magnitude", element.getMagnitudeElement(), false);
        composeDecimalExtras("magnitude", element.getMagnitudeElement(), false);
      }
      if (element.hasPrecisionElement()) {
        composeIntegerCore("precision", element.getPrecisionElement(), false);
        composeIntegerExtras("precision", element.getPrecisionElement(), false);
      }
      if (element.hasUnitsElement()) {
        composeStringCore("units", element.getUnitsElement(), false);
        composeStringExtras("units", element.getUnitsElement(), false);
      }
      if (element.hasUnits_systemElement()) {
        composeStringCore("units_system", element.getUnits_systemElement(), false);
        composeStringExtras("units_system", element.getUnits_systemElement(), false);
      }
      if (element.hasUnits_display_nameElement()) {
        composeStringCore("units_display_name", element.getUnits_display_nameElement(), false);
        composeStringExtras("units_display_name", element.getUnits_display_nameElement(), false);
      }
  }

  protected void composeDV_SCALE(String name, DV_SCALE element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_SCALEProperties(element);
      close();
    }
  }

  protected void composeDV_SCALEProperties(DV_SCALE element) throws IOException {
    composeDV_ORDEREDProperties(element);
      if (element.hasSymbol()) {
        composeDV_CODED_TEXT("symbol", element.getSymbol());
      }
      if (element.hasValueElement()) {
        composeDecimalCore("value", element.getValueElement(), false);
        composeDecimalExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeDV_STATE(String name, DV_STATE element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_STATEProperties(element);
      close();
    }
  }

  protected void composeDV_STATEProperties(DV_STATE element) throws IOException {
    composeDATA_VALUEProperties(element);
      if (element.hasValue()) {
        composeDV_CODED_TEXT("value", element.getValue());
      }
      if (element.hasIs_terminalElement()) {
        composeBooleanCore("is_terminal", element.getIs_terminalElement(), false);
        composeBooleanExtras("is_terminal", element.getIs_terminalElement(), false);
      }
  }

  protected void composeDV_TEXT(String name, DV_TEXT element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_TEXTProperties(element);
      close();
    }
  }

  protected void composeDV_TEXTProperties(DV_TEXT element) throws IOException {
    composeDATA_VALUEProperties(element);
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
      if (element.hasHyperlink()) {
        composeDV_URI("hyperlink", element.getHyperlink());
      }
      if (element.hasFormattingElement()) {
        composeStringCore("formatting", element.getFormattingElement(), false);
        composeStringExtras("formatting", element.getFormattingElement(), false);
      }
      if (element.hasMappings()) {
        openArray("mappings");
        for (TERM_MAPPING e : element.getMappingsList()) 
          composeTERM_MAPPING(null, e);
        closeArray();
      };
      if (element.hasLanguage()) {
        composeCODE_PHRASE("language", element.getLanguage());
      }
      if (element.hasEncoding()) {
        composeCODE_PHRASE("encoding", element.getEncoding());
      }
  }

  protected void composeDV_TIME(String name, DV_TIME element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_TIMEProperties(element);
      close();
    }
  }

  protected void composeDV_TIMEProperties(DV_TIME element) throws IOException {
    composeDV_ORDEREDProperties(element);
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeDV_URI(String name, DV_URI element) throws IOException {
    if (element != null) {
      open(name);
      composeDV_URIProperties(element);
      close();
    }
  }

  protected void composeDV_URIProperties(DV_URI element) throws IOException {
    composeDATA_VALUEProperties(element);
      if (element.hasValueElement()) {
        composeUriCore("value", element.getValueElement(), false);
        composeUriExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeEHR_ACCESS(String name, EHR_ACCESS element) throws IOException {
    if (element != null) {
      open(name);
      composeEHR_ACCESSProperties(element);
      close();
    }
  }

  protected void composeEHR_ACCESSProperties(EHR_ACCESS element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasSettings()) {
        composeACCESS_CONTROL_SETTINGS("settings", element.getSettings());
      }
  }

  protected void composeEHR_STATUS(String name, EHR_STATUS element) throws IOException {
    if (element != null) {
      open(name);
      composeEHR_STATUSProperties(element);
      close();
    }
  }

  protected void composeEHR_STATUSProperties(EHR_STATUS element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasSubject()) {
        composePARTY_SELF("subject", element.getSubject());
      }
      if (element.hasIs_queryableElement()) {
        composeBooleanCore("is_queryable", element.getIs_queryableElement(), false);
        composeBooleanExtras("is_queryable", element.getIs_queryableElement(), false);
      }
      if (element.hasIs_modifiableElement()) {
        composeBooleanCore("is_modifiable", element.getIs_modifiableElement(), false);
        composeBooleanExtras("is_modifiable", element.getIs_modifiableElement(), false);
      }
      if (element.hasOther_details()) {
        composeITEM_STRUCTURE("other_details", element.getOther_details());
      }
  }

  protected void composeEHR(String name, EHR element) throws IOException {
    if (element != null) {
      open(name);
      composeEHRProperties(element);
      close();
    }
  }

  protected void composeEHRProperties(EHR element) throws IOException {
    composeAnyProperties(element);
      if (element.hasSystem_id()) {
        openArray("system_id");
        for (HIER_OBJECT_ID e : element.getSystem_idList()) 
          composeHIER_OBJECT_ID(null, e);
        closeArray();
      };
      if (element.hasEhr_id()) {
        composeHIER_OBJECT_ID("ehr_id", element.getEhr_id());
      }
      if (element.hasContributions()) {
        openArray("contributions");
        for (OBJECT_REF e : element.getContributionsList()) 
          composeOBJECT_REF(null, e);
        closeArray();
      };
      if (element.hasEhr_status()) {
        composeOBJECT_REF("ehr_status", element.getEhr_status());
      }
      if (element.hasEhr_access()) {
        composeOBJECT_REF("ehr_access", element.getEhr_access());
      }
      if (element.hasCompositions()) {
        openArray("compositions");
        for (OBJECT_REF e : element.getCompositionsList()) 
          composeOBJECT_REF(null, e);
        closeArray();
      };
      if (element.hasDirectory()) {
        composeOBJECT_REF("directory", element.getDirectory());
      }
      if (element.hasTime_created()) {
        composeDV_DATE_TIME("time_created", element.getTime_created());
      }
      if (element.hasFolders()) {
        openArray("folders");
        for (OBJECT_REF e : element.getFoldersList()) 
          composeOBJECT_REF(null, e);
        closeArray();
      };
      if (element.hasTags()) {
        openArray("tags");
        for (OBJECT_REF e : element.getTagsList()) 
          composeOBJECT_REF(null, e);
        closeArray();
      };
  }

  protected void composeELEMENT(String name, ELEMENT element) throws IOException {
    if (element != null) {
      open(name);
      composeELEMENTProperties(element);
      close();
    }
  }

  protected void composeELEMENTProperties(ELEMENT element) throws IOException {
    composeITEMProperties(element);
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
      open(name);
      composeEVALUATIONProperties(element);
      close();
    }
  }

  protected void composeEVALUATIONProperties(EVALUATION element) throws IOException {
    composeCARE_ENTRYProperties(element);
      if (element.hasData()) {
        composeITEM_STRUCTURE("data", element.getData());
      }
  }

  protected void composeEVENT_CONTEXT(String name, EVENT_CONTEXT element) throws IOException {
    if (element != null) {
      open(name);
      composeEVENT_CONTEXTProperties(element);
      close();
    }
  }

  protected void composeEVENT_CONTEXTProperties(EVENT_CONTEXT element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasStart_time()) {
        composeDV_DATE_TIME("start_time", element.getStart_time());
      }
      if (element.hasEnd_time()) {
        composeDV_DATE_TIME("end_time", element.getEnd_time());
      }
      if (element.hasLocationElement()) {
        composeStringCore("location", element.getLocationElement(), false);
        composeStringExtras("location", element.getLocationElement(), false);
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
        openArray("participations");
        for (PARTICIPATION e : element.getParticipationsList()) 
          composePARTICIPATION(null, e);
        closeArray();
      };
  }

  protected void composeFEEDER_AUDIT_DETAILS(String name, FEEDER_AUDIT_DETAILS element) throws IOException {
    if (element != null) {
      open(name);
      composeFEEDER_AUDIT_DETAILSProperties(element);
      close();
    }
  }

  protected void composeFEEDER_AUDIT_DETAILSProperties(FEEDER_AUDIT_DETAILS element) throws IOException {
    composeBaseProperties(element);
      if (element.hasSystem_idElement()) {
        composeStringCore("system_id", element.getSystem_idElement(), false);
        composeStringExtras("system_id", element.getSystem_idElement(), false);
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
        composeStringCore("version_id", element.getVersion_idElement(), false);
        composeStringExtras("version_id", element.getVersion_idElement(), false);
      }
      if (element.hasOther_details()) {
        composeITEM_STRUCTURE("other_details", element.getOther_details());
      }
  }

  protected void composeFEEDER_AUDIT(String name, FEEDER_AUDIT element) throws IOException {
    if (element != null) {
      open(name);
      composeFEEDER_AUDITProperties(element);
      close();
    }
  }

  protected void composeFEEDER_AUDITProperties(FEEDER_AUDIT element) throws IOException {
    composeBaseProperties(element);
      if (element.hasOriginating_system_item_ids()) {
        openArray("originating_system_item_ids");
        for (DV_IDENTIFIER e : element.getOriginating_system_item_idsList()) 
          composeDV_IDENTIFIER(null, e);
        closeArray();
      };
      if (element.hasFeeder_system_item_ids()) {
        openArray("feeder_system_item_ids");
        for (DV_IDENTIFIER e : element.getFeeder_system_item_idsList()) 
          composeDV_IDENTIFIER(null, e);
        closeArray();
      };
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
      open(name);
      composeFOLDERProperties(element);
      close();
    }
  }

  protected void composeFOLDERProperties(FOLDER element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasItems()) {
        openArray("items");
        for (OBJECT_REF e : element.getItemsList()) 
          composeOBJECT_REF(null, e);
        closeArray();
      };
      if (element.hasFolders()) {
        openArray("folders");
        for (FOLDER e : element.getFoldersList()) 
          composeFOLDER(null, e);
        closeArray();
      };
      if (element.hasDetails()) {
        composeITEM_STRUCTURE("details", element.getDetails());
      }
  }

  protected void composeGENERIC_ID(String name, GENERIC_ID element) throws IOException {
    if (element != null) {
      open(name);
      composeGENERIC_IDProperties(element);
      close();
    }
  }

  protected void composeGENERIC_IDProperties(GENERIC_ID element) throws IOException {
    composeOBJECT_IDProperties(element);
  }

  protected void composeGROUP(String name, GROUP element) throws IOException {
    if (element != null) {
      open(name);
      composeGROUPProperties(element);
      close();
    }
  }

  protected void composeGROUPProperties(GROUP element) throws IOException {
    composeACTORProperties(element);
  }

  protected void composeHIER_OBJECT_ID(String name, HIER_OBJECT_ID element) throws IOException {
    if (element != null) {
      open(name);
      composeHIER_OBJECT_IDProperties(element);
      close();
    }
  }

  protected void composeHIER_OBJECT_IDProperties(HIER_OBJECT_ID element) throws IOException {
    composeUID_BASED_IDProperties(element);
  }

  protected void composeHISTORY(String name, HISTORY element) throws IOException {
    if (element != null) {
      open(name);
      composeHISTORYProperties(element);
      close();
    }
  }

  protected void composeHISTORYProperties(HISTORY element) throws IOException {
    composeDATA_STRUCTUREProperties(element);
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
        openArray("events");
        for (EVENT e : element.getEventsList()) 
          composeEVENT(null, e);
        closeArray();
      };
  }

  protected void composeIMPORTED_VERSION(String name, IMPORTED_VERSION element) throws IOException {
    if (element != null) {
      open(name);
      composeIMPORTED_VERSIONProperties(element);
      close();
    }
  }

  protected void composeIMPORTED_VERSIONProperties(IMPORTED_VERSION element) throws IOException {
    composeVERSIONProperties(element);
      if (element.hasItem()) {
        composeORIGINAL_VERSION("item", element.getItem());
      }
  }

  protected void composeINSTRUCTION_DETAILS(String name, INSTRUCTION_DETAILS element) throws IOException {
    if (element != null) {
      open(name);
      composeINSTRUCTION_DETAILSProperties(element);
      close();
    }
  }

  protected void composeINSTRUCTION_DETAILSProperties(INSTRUCTION_DETAILS element) throws IOException {
    composePATHABLEProperties(element);
      if (element.hasInstruction_id()) {
        composeLOCATABLE_REF("instruction_id", element.getInstruction_id());
      }
      if (element.hasActivity_idElement()) {
        composeStringCore("activity_id", element.getActivity_idElement(), false);
        composeStringExtras("activity_id", element.getActivity_idElement(), false);
      }
      if (element.hasWf_details()) {
        composeITEM_STRUCTURE("wf_details", element.getWf_details());
      }
  }

  protected void composeINSTRUCTION(String name, INSTRUCTION element) throws IOException {
    if (element != null) {
      open(name);
      composeINSTRUCTIONProperties(element);
      close();
    }
  }

  protected void composeINSTRUCTIONProperties(INSTRUCTION element) throws IOException {
    composeCARE_ENTRYProperties(element);
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
        openArray("activities");
        for (ACTIVITY e : element.getActivitiesList()) 
          composeACTIVITY(null, e);
        closeArray();
      };
  }

  protected void composeINTERNET_ID(String name, INTERNET_ID element) throws IOException {
    if (element != null) {
      open(name);
      composeINTERNET_IDProperties(element);
      close();
    }
  }

  protected void composeINTERNET_IDProperties(INTERNET_ID element) throws IOException {
    composeUIDProperties(element);
  }

  protected void composeINTERVAL_EVENT(String name, INTERVAL_EVENT element) throws IOException {
    if (element != null) {
      open(name);
      composeINTERVAL_EVENTProperties(element);
      close();
    }
  }

  protected void composeINTERVAL_EVENTProperties(INTERVAL_EVENT element) throws IOException {
    composeEVENTProperties(element);
      if (element.hasWidth()) {
        composeDV_DURATION("width", element.getWidth());
      }
      if (element.hasSample_countElement()) {
        composeIntegerCore("sample_count", element.getSample_countElement(), false);
        composeIntegerExtras("sample_count", element.getSample_countElement(), false);
      }
      if (element.hasMath_function()) {
        composeDV_CODED_TEXT("math_function", element.getMath_function());
      }
  }

  protected void composeISM_TRANSITION(String name, ISM_TRANSITION element) throws IOException {
    if (element != null) {
      open(name);
      composeISM_TRANSITIONProperties(element);
      close();
    }
  }

  protected void composeISM_TRANSITIONProperties(ISM_TRANSITION element) throws IOException {
    composePATHABLEProperties(element);
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
        openArray("reason");
        for (DV_TEXT e : element.getReasonList()) 
          composeDV_TEXT(null, e);
        closeArray();
      };
  }

  protected void composeISO_OID(String name, ISO_OID element) throws IOException {
    if (element != null) {
      open(name);
      composeISO_OIDProperties(element);
      close();
    }
  }

  protected void composeISO_OIDProperties(ISO_OID element) throws IOException {
    composeUIDProperties(element);
  }

  protected void composeITEM_LIST(String name, ITEM_LIST element) throws IOException {
    if (element != null) {
      open(name);
      composeITEM_LISTProperties(element);
      close();
    }
  }

  protected void composeITEM_LISTProperties(ITEM_LIST element) throws IOException {
    composeITEM_STRUCTUREProperties(element);
      if (element.hasItems()) {
        openArray("items");
        for (ELEMENT e : element.getItemsList()) 
          composeELEMENT(null, e);
        closeArray();
      };
  }

  protected void composeITEM_SINGLE(String name, ITEM_SINGLE element) throws IOException {
    if (element != null) {
      open(name);
      composeITEM_SINGLEProperties(element);
      close();
    }
  }

  protected void composeITEM_SINGLEProperties(ITEM_SINGLE element) throws IOException {
    composeITEM_STRUCTUREProperties(element);
      if (element.hasItem()) {
        composeELEMENT("item", element.getItem());
      }
  }

  protected void composeITEM_TABLE(String name, ITEM_TABLE element) throws IOException {
    if (element != null) {
      open(name);
      composeITEM_TABLEProperties(element);
      close();
    }
  }

  protected void composeITEM_TABLEProperties(ITEM_TABLE element) throws IOException {
    composeITEM_STRUCTUREProperties(element);
      if (element.hasRows()) {
        openArray("rows");
        for (CLUSTER e : element.getRowsList()) 
          composeCLUSTER(null, e);
        closeArray();
      };
  }

  protected void composeITEM_TAG(String name, ITEM_TAG element) throws IOException {
    if (element != null) {
      open(name);
      composeITEM_TAGProperties(element);
      close();
    }
  }

  protected void composeITEM_TAGProperties(ITEM_TAG element) throws IOException {
    composeBaseProperties(element);
      if (element.hasKeyElement()) {
        composeStringCore("key", element.getKeyElement(), false);
        composeStringExtras("key", element.getKeyElement(), false);
      }
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
      if (element.hasTarget()) {
        composeUID_BASED_ID("target", element.getTarget());
      }
      if (element.hasTarget_pathElement()) {
        composeStringCore("target_path", element.getTarget_pathElement(), false);
        composeStringExtras("target_path", element.getTarget_pathElement(), false);
      }
      if (element.hasOwner_id()) {
        composeOBJECT_REF("owner_id", element.getOwner_id());
      }
  }

  protected void composeITEM_TREE(String name, ITEM_TREE element) throws IOException {
    if (element != null) {
      open(name);
      composeITEM_TREEProperties(element);
      close();
    }
  }

  protected void composeITEM_TREEProperties(ITEM_TREE element) throws IOException {
    composeITEM_STRUCTUREProperties(element);
      if (element.hasItems()) {
        openArray("items");
        for (ITEM e : element.getItemsList()) 
          composeITEM(null, e);
        closeArray();
      };
  }

  protected void composeLINK(String name, LINK element) throws IOException {
    if (element != null) {
      open(name);
      composeLINKProperties(element);
      close();
    }
  }

  protected void composeLINKProperties(LINK element) throws IOException {
    composeBaseProperties(element);
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
      open(name);
      composeLOCATABLE_REFProperties(element);
      close();
    }
  }

  protected void composeLOCATABLE_REFProperties(LOCATABLE_REF element) throws IOException {
    composeOBJECT_REFProperties(element);
      if (element.hasPathElement()) {
        composeStringCore("path", element.getPathElement(), false);
        composeStringExtras("path", element.getPathElement(), false);
      }
  }

  protected void composeOBJECT_REF(String name, OBJECT_REF element) throws IOException {
    if (element != null) {
      open(name);
      composeOBJECT_REFProperties(element);
      close();
    }
  }

  protected void composeOBJECT_REFProperties(OBJECT_REF element) throws IOException {
    composeBaseProperties(element);
      if (element.hasNamespaceElement()) {
        composeStringCore("namespace", element.getNamespaceElement(), false);
        composeStringExtras("namespace", element.getNamespaceElement(), false);
      }
      if (element.hasTypeElement()) {
        composeStringCore("type", element.getTypeElement(), false);
        composeStringExtras("type", element.getTypeElement(), false);
      }
      if (element.hasId()) {
        composeOBJECT_ID("id", element.getId());
      }
  }

  protected void composeOBJECT_VERSION_ID(String name, OBJECT_VERSION_ID element) throws IOException {
    if (element != null) {
      open(name);
      composeOBJECT_VERSION_IDProperties(element);
      close();
    }
  }

  protected void composeOBJECT_VERSION_IDProperties(OBJECT_VERSION_ID element) throws IOException {
    composeUID_BASED_IDProperties(element);
  }

  protected void composeOBSERVATION(String name, OBSERVATION element) throws IOException {
    if (element != null) {
      open(name);
      composeOBSERVATIONProperties(element);
      close();
    }
  }

  protected void composeOBSERVATIONProperties(OBSERVATION element) throws IOException {
    composeCARE_ENTRYProperties(element);
      if (element.hasData()) {
        composeHISTORY("data", element.getData());
      }
      if (element.hasState()) {
        composeHISTORY("state", element.getState());
      }
  }

  protected void composeORGANISATION(String name, ORGANISATION element) throws IOException {
    if (element != null) {
      open(name);
      composeORGANISATIONProperties(element);
      close();
    }
  }

  protected void composeORGANISATIONProperties(ORGANISATION element) throws IOException {
    composeACTORProperties(element);
  }

  protected void composeORIGINAL_VERSION(String name, ORIGINAL_VERSION element) throws IOException {
    if (element != null) {
      open(name);
      composeORIGINAL_VERSIONProperties(element);
      close();
    }
  }

  protected void composeORIGINAL_VERSIONProperties(ORIGINAL_VERSION element) throws IOException {
    composeVERSIONProperties(element);
      if (element.hasUid()) {
        composeOBJECT_VERSION_ID("uid", element.getUid());
      }
      if (element.hasPreceding_version_uid()) {
        composeOBJECT_VERSION_ID("preceding_version_uid", element.getPreceding_version_uid());
      }
      if (element.hasOther_input_version_uids()) {
        openArray("other_input_version_uids");
        for (OBJECT_VERSION_ID e : element.getOther_input_version_uidsList()) 
          composeOBJECT_VERSION_ID(null, e);
        closeArray();
      };
      if (element.hasLifecycle_state()) {
        composeDV_CODED_TEXT("lifecycle_state", element.getLifecycle_state());
      }
      if (element.hasAttestations()) {
        openArray("attestations");
        for (ATTESTATION e : element.getAttestationsList()) 
          composeATTESTATION(null, e);
        closeArray();
      };
      if (element.hasData()) {
        composeAny("data", element.getData());
      }
  }

  protected void composePARTICIPATION(String name, PARTICIPATION element) throws IOException {
    if (element != null) {
      open(name);
      composePARTICIPATIONProperties(element);
      close();
    }
  }

  protected void composePARTICIPATIONProperties(PARTICIPATION element) throws IOException {
    composeLOCATABLEProperties(element);
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
      open(name);
      composePARTY_IDENTIFIEDProperties(element);
      close();
    }
  }

  protected void composePARTY_IDENTIFIEDProperties(PARTY_IDENTIFIED element) throws IOException {
    composePARTY_PROXYProperties(element);
      if (element.hasNameElement()) {
        composeStringCore("name", element.getNameElement(), false);
        composeStringExtras("name", element.getNameElement(), false);
      }
      if (element.hasIdentifiers()) {
        openArray("identifiers");
        for (DV_IDENTIFIER e : element.getIdentifiersList()) 
          composeDV_IDENTIFIER(null, e);
        closeArray();
      };
  }

  protected void composePARTY_IDENTITY(String name, PARTY_IDENTITY element) throws IOException {
    if (element != null) {
      open(name);
      composePARTY_IDENTITYProperties(element);
      close();
    }
  }

  protected void composePARTY_IDENTITYProperties(PARTY_IDENTITY element) throws IOException {
    composeLOCATABLEProperties(element);
      if (element.hasDetails()) {
        composeITEM_STRUCTURE("details", element.getDetails());
      }
  }

  protected void composePARTY_REF(String name, PARTY_REF element) throws IOException {
    if (element != null) {
      open(name);
      composePARTY_REFProperties(element);
      close();
    }
  }

  protected void composePARTY_REFProperties(PARTY_REF element) throws IOException {
    composeOBJECT_REFProperties(element);
  }

  protected void composePARTY_RELATED(String name, PARTY_RELATED element) throws IOException {
    if (element != null) {
      open(name);
      composePARTY_RELATEDProperties(element);
      close();
    }
  }

  protected void composePARTY_RELATEDProperties(PARTY_RELATED element) throws IOException {
    composePARTY_IDENTIFIEDProperties(element);
      if (element.hasRelationship()) {
        composeDV_CODED_TEXT("relationship", element.getRelationship());
      }
  }

  protected void composePARTY_RELATIONSHIP(String name, PARTY_RELATIONSHIP element) throws IOException {
    if (element != null) {
      open(name);
      composePARTY_RELATIONSHIPProperties(element);
      close();
    }
  }

  protected void composePARTY_RELATIONSHIPProperties(PARTY_RELATIONSHIP element) throws IOException {
    composeLOCATABLEProperties(element);
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
      open(name);
      composePARTY_SELFProperties(element);
      close();
    }
  }

  protected void composePARTY_SELFProperties(PARTY_SELF element) throws IOException {
    composePARTY_PROXYProperties(element);
  }

  protected void composePERSON(String name, PERSON element) throws IOException {
    if (element != null) {
      open(name);
      composePERSONProperties(element);
      close();
    }
  }

  protected void composePERSONProperties(PERSON element) throws IOException {
    composeACTORProperties(element);
  }

  protected void composePOINT_EVENT(String name, POINT_EVENT element) throws IOException {
    if (element != null) {
      open(name);
      composePOINT_EVENTProperties(element);
      close();
    }
  }

  protected void composePOINT_EVENTProperties(POINT_EVENT element) throws IOException {
    composeEVENTProperties(element);
  }

  protected void composeREFERENCE_RANGE(String name, REFERENCE_RANGE element) throws IOException {
    if (element != null) {
      open(name);
      composeREFERENCE_RANGEProperties(element);
      close();
    }
  }

  protected void composeREFERENCE_RANGEProperties(REFERENCE_RANGE element) throws IOException {
    composeBaseProperties(element);
      if (element.hasMeaning()) {
        composeDV_TEXT("meaning", element.getMeaning());
      }
      if (element.hasRange()) {
        composeDV_INTERVAL("range", element.getRange());
      }
  }

  protected void composeRESOURCE_DESCRIPTION_ITEM(String name, RESOURCE_DESCRIPTION_ITEM element) throws IOException {
    if (element != null) {
      open(name);
      composeRESOURCE_DESCRIPTION_ITEMProperties(element);
      close();
    }
  }

  protected void composeRESOURCE_DESCRIPTION_ITEMProperties(RESOURCE_DESCRIPTION_ITEM element) throws IOException {
    composeBaseProperties(element);
      if (element.hasLanguage()) {
        composeCODE_PHRASE("language", element.getLanguage());
      }
      if (element.hasPurposeElement()) {
        composeStringCore("purpose", element.getPurposeElement(), false);
        composeStringExtras("purpose", element.getPurposeElement(), false);
      }
      if (element.hasKeywords()) {
        if (anyHasValue(element.getKeywordsList())) {
          openArray("keywords");
          for (StringType e : element.getKeywordsList()) 
            composeStringCore(null, e, e != element.getKeywordsList().get(element.getKeywordsList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getKeywordsList())) {
          openArray("_keywords");
          for (StringType e : element.getKeywordsList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
      if (element.hasUseElement()) {
        composeStringCore("use", element.getUseElement(), false);
        composeStringExtras("use", element.getUseElement(), false);
      }
      if (element.hasMisuseElement()) {
        composeStringCore("misuse", element.getMisuseElement(), false);
        composeStringExtras("misuse", element.getMisuseElement(), false);
      }
      if (element.hasCopyrightElement()) {
        composeStringCore("copyright", element.getCopyrightElement(), false);
        composeStringExtras("copyright", element.getCopyrightElement(), false);
      }
      if (element.hasOriginal_resource_uri()) {
        if (anyHasValue(element.getOriginal_resource_uriList())) {
          openArray("original_resource_uri");
          for (StringType e : element.getOriginal_resource_uriList()) 
            composeStringCore(null, e, e != element.getOriginal_resource_uriList().get(element.getOriginal_resource_uriList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getOriginal_resource_uriList())) {
          openArray("_original_resource_uri");
          for (StringType e : element.getOriginal_resource_uriList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
      if (element.hasOther_details()) {
        if (anyHasValue(element.getOther_detailsList())) {
          openArray("other_details");
          for (StringType e : element.getOther_detailsList()) 
            composeStringCore(null, e, e != element.getOther_detailsList().get(element.getOther_detailsList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getOther_detailsList())) {
          openArray("_other_details");
          for (StringType e : element.getOther_detailsList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
  }

  protected void composeRESOURCE_DESCRIPTION(String name, RESOURCE_DESCRIPTION element) throws IOException {
    if (element != null) {
      open(name);
      composeRESOURCE_DESCRIPTIONProperties(element);
      close();
    }
  }

  protected void composeRESOURCE_DESCRIPTIONProperties(RESOURCE_DESCRIPTION element) throws IOException {
    composeBaseProperties(element);
      if (element.hasOriginal_author()) {
        if (anyHasValue(element.getOriginal_authorList())) {
          openArray("original_author");
          for (StringType e : element.getOriginal_authorList()) 
            composeStringCore(null, e, e != element.getOriginal_authorList().get(element.getOriginal_authorList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getOriginal_authorList())) {
          openArray("_original_author");
          for (StringType e : element.getOriginal_authorList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
      if (element.hasOther_contributors()) {
        if (anyHasValue(element.getOther_contributorsList())) {
          openArray("other_contributors");
          for (StringType e : element.getOther_contributorsList()) 
            composeStringCore(null, e, e != element.getOther_contributorsList().get(element.getOther_contributorsList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getOther_contributorsList())) {
          openArray("_other_contributors");
          for (StringType e : element.getOther_contributorsList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
      if (element.hasLifecycle_stateElement()) {
        composeStringCore("lifecycle_state", element.getLifecycle_stateElement(), false);
        composeStringExtras("lifecycle_state", element.getLifecycle_stateElement(), false);
      }
      if (element.hasResource_package_uriElement()) {
        composeStringCore("resource_package_uri", element.getResource_package_uriElement(), false);
        composeStringExtras("resource_package_uri", element.getResource_package_uriElement(), false);
      }
      if (element.hasOther_details()) {
        openArray("other_details");
        for (OBJECT_REF e : element.getOther_detailsList()) 
          composeOBJECT_REF(null, e);
        closeArray();
      };
      if (element.hasParent_resource()) {
        composeAUTHORED_RESOURCE("parent_resource", element.getParent_resource());
      }
      if (element.hasDetails()) {
        openArray("details");
        for (RESOURCE_DESCRIPTION_ITEM e : element.getDetailsList()) 
          composeRESOURCE_DESCRIPTION_ITEM(null, e);
        closeArray();
      };
  }

  protected void composeREVISION_HISTORY_ITEM(String name, REVISION_HISTORY_ITEM element) throws IOException {
    if (element != null) {
      open(name);
      composeREVISION_HISTORY_ITEMProperties(element);
      close();
    }
  }

  protected void composeREVISION_HISTORY_ITEMProperties(REVISION_HISTORY_ITEM element) throws IOException {
    composeBaseProperties(element);
      if (element.hasVersion_id()) {
        composeOBJECT_VERSION_ID("version_id", element.getVersion_id());
      }
      if (element.hasAudits()) {
        openArray("audits");
        for (AUDIT_DETAILS e : element.getAuditsList()) 
          composeAUDIT_DETAILS(null, e);
        closeArray();
      };
  }

  protected void composeREVISION_HISTORY(String name, REVISION_HISTORY element) throws IOException {
    if (element != null) {
      open(name);
      composeREVISION_HISTORYProperties(element);
      close();
    }
  }

  protected void composeREVISION_HISTORYProperties(REVISION_HISTORY element) throws IOException {
    composeBaseProperties(element);
      if (element.hasMost_recent_versionElement()) {
        composeStringCore("most_recent_version", element.getMost_recent_versionElement(), false);
        composeStringExtras("most_recent_version", element.getMost_recent_versionElement(), false);
      }
      if (element.hasMost_recent_version_time_committedElement()) {
        composeStringCore("most_recent_version_time_committed", element.getMost_recent_version_time_committedElement(), false);
        composeStringExtras("most_recent_version_time_committed", element.getMost_recent_version_time_committedElement(), false);
      }
  }

  protected void composeROLE(String name, ROLE element) throws IOException {
    if (element != null) {
      open(name);
      composeROLEProperties(element);
      close();
    }
  }

  protected void composeROLEProperties(ROLE element) throws IOException {
    composePARTYProperties(element);
      if (element.hasTime_validity()) {
        composeDV_INTERVAL("time_validity", element.getTime_validity());
      }
      if (element.hasPerformer()) {
        composePARTY_REF("performer", element.getPerformer());
      }
      if (element.hasCapabilities()) {
        openArray("capabilities");
        for (CAPABILITY e : element.getCapabilitiesList()) 
          composeCAPABILITY(null, e);
        closeArray();
      };
  }

  protected void composeSECTION(String name, SECTION element) throws IOException {
    if (element != null) {
      open(name);
      composeSECTIONProperties(element);
      close();
    }
  }

  protected void composeSECTIONProperties(SECTION element) throws IOException {
    composeCONTENT_ITEMProperties(element);
      if (element.hasItems()) {
        openArray("items");
        for (CONTENT_ITEM e : element.getItemsList()) 
          composeCONTENT_ITEM(null, e);
        closeArray();
      };
  }

  protected void composeTEMPLATE_ID(String name, TEMPLATE_ID element) throws IOException {
    if (element != null) {
      open(name);
      composeTEMPLATE_IDProperties(element);
      close();
    }
  }

  protected void composeTEMPLATE_IDProperties(TEMPLATE_ID element) throws IOException {
    composeOBJECT_IDProperties(element);
  }

  protected void composeTERM_MAPPING(String name, TERM_MAPPING element) throws IOException {
    if (element != null) {
      open(name);
      composeTERM_MAPPINGProperties(element);
      close();
    }
  }

  protected void composeTERM_MAPPINGProperties(TERM_MAPPING element) throws IOException {
    composeBaseProperties(element);
      if (element.hasMatchElement()) {
        composeStringCore("match", element.getMatchElement(), false);
        composeStringExtras("match", element.getMatchElement(), false);
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
      open(name);
      composeTERMINOLOGY_IDProperties(element);
      close();
    }
  }

  protected void composeTERMINOLOGY_IDProperties(TERMINOLOGY_ID element) throws IOException {
    composeOBJECT_IDProperties(element);
  }

  protected void composeTRANSLATION_DETAILS(String name, TRANSLATION_DETAILS element) throws IOException {
    if (element != null) {
      open(name);
      composeTRANSLATION_DETAILSProperties(element);
      close();
    }
  }

  protected void composeTRANSLATION_DETAILSProperties(TRANSLATION_DETAILS element) throws IOException {
    composeBaseProperties(element);
      if (element.hasLanguage()) {
        composeCODE_PHRASE("language", element.getLanguage());
      }
      if (element.hasAuthor()) {
        if (anyHasValue(element.getAuthorList())) {
          openArray("author");
          for (StringType e : element.getAuthorList()) 
            composeStringCore(null, e, e != element.getAuthorList().get(element.getAuthorList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getAuthorList())) {
          openArray("_author");
          for (StringType e : element.getAuthorList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
      if (element.hasAccreditationElement()) {
        composeStringCore("accreditation", element.getAccreditationElement(), false);
        composeStringExtras("accreditation", element.getAccreditationElement(), false);
      }
      if (element.hasOther_details()) {
        if (anyHasValue(element.getOther_detailsList())) {
          openArray("other_details");
          for (StringType e : element.getOther_detailsList()) 
            composeStringCore(null, e, e != element.getOther_detailsList().get(element.getOther_detailsList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getOther_detailsList())) {
          openArray("_other_details");
          for (StringType e : element.getOther_detailsList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
  }

  protected void composeTranslatedString(String name, TranslatedString element) throws IOException {
    if (element != null) {
      open(name);
      composeTranslatedStringProperties(element);
      close();
    }
  }

  protected void composeTranslatedStringProperties(TranslatedString element) throws IOException {
    composeBaseProperties(element);
      if (element.hasLanguageElement()) {
        composeCodeCore("language", element.getLanguageElement(), false);
        composeCodeExtras("language", element.getLanguageElement(), false);
      }
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeUUID(String name, UUID element) throws IOException {
    if (element != null) {
      open(name);
      composeUUIDProperties(element);
      close();
    }
  }

  protected void composeUUIDProperties(UUID element) throws IOException {
    composeUIDProperties(element);
  }

  protected void composeVERSION_TREE_ID(String name, VERSION_TREE_ID element) throws IOException {
    if (element != null) {
      open(name);
      composeVERSION_TREE_IDProperties(element);
      close();
    }
  }

  protected void composeVERSION_TREE_IDProperties(VERSION_TREE_ID element) throws IOException {
    composeBaseProperties(element);
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeVERSIONED_COMPOSITION(String name, VERSIONED_COMPOSITION element) throws IOException {
    if (element != null) {
      open(name);
      composeVERSIONED_COMPOSITIONProperties(element);
      close();
    }
  }

  protected void composeVERSIONED_COMPOSITIONProperties(VERSIONED_COMPOSITION element) throws IOException {
    composeVERSIONED_OBJECTProperties(element);
  }

  protected void composeVERSIONED_EHR_ACCESS(String name, VERSIONED_EHR_ACCESS element) throws IOException {
    if (element != null) {
      open(name);
      composeVERSIONED_EHR_ACCESSProperties(element);
      close();
    }
  }

  protected void composeVERSIONED_EHR_ACCESSProperties(VERSIONED_EHR_ACCESS element) throws IOException {
    composeVERSIONED_OBJECTProperties(element);
  }

  protected void composeVERSIONED_EHR_STATUS(String name, VERSIONED_EHR_STATUS element) throws IOException {
    if (element != null) {
      open(name);
      composeVERSIONED_EHR_STATUSProperties(element);
      close();
    }
  }

  protected void composeVERSIONED_EHR_STATUSProperties(VERSIONED_EHR_STATUS element) throws IOException {
    composeVERSIONED_OBJECTProperties(element);
  }

  protected void composeVERSIONED_FOLDER(String name, VERSIONED_FOLDER element) throws IOException {
    if (element != null) {
      open(name);
      composeVERSIONED_FOLDERProperties(element);
      close();
    }
  }

  protected void composeVERSIONED_FOLDERProperties(VERSIONED_FOLDER element) throws IOException {
    composeVERSIONED_OBJECTProperties(element);
  }

  protected void composeVERSIONED_OBJECT(String name, VERSIONED_OBJECT element) throws IOException {
    if (element != null) {
      open(name);
      composeVERSIONED_OBJECTProperties(element);
      close();
    }
  }

  protected void composeVERSIONED_OBJECTProperties(VERSIONED_OBJECT element) throws IOException {
    composeBaseProperties(element);
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
      open(name);
      composeVERSIONED_PARTYProperties(element);
      close();
    }
  }

  protected void composeVERSIONED_PARTYProperties(VERSIONED_PARTY element) throws IOException {
    composeVERSIONED_OBJECTProperties(element);
  }

  protected void composeWebTemplate(String name, WebTemplate element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateProperties(element);
      close();
    }
  }

  protected void composeWebTemplateProperties(WebTemplate element) throws IOException {
    composeBaseProperties(element);
      if (element.hasTemplateIdElement()) {
        composeStringCore("templateId", element.getTemplateIdElement(), false);
        composeStringExtras("templateId", element.getTemplateIdElement(), false);
      }
      if (element.hasVersionElement()) {
        composeStringCore("version", element.getVersionElement(), false);
        composeStringExtras("version", element.getVersionElement(), false);
      }
      if (element.hasSemverElement()) {
        composeStringCore("semver", element.getSemverElement(), false);
        composeStringExtras("semver", element.getSemverElement(), false);
      }
      if (element.hasDefaultLanguageElement()) {
        composeStringCore("defaultLanguage", element.getDefaultLanguageElement(), false);
        composeStringExtras("defaultLanguage", element.getDefaultLanguageElement(), false);
      }
      if (element.hasLanguages()) {
        if (anyHasValue(element.getLanguagesList())) {
          openArray("languages");
          for (StringType e : element.getLanguagesList()) 
            composeStringCore(null, e, e != element.getLanguagesList().get(element.getLanguagesList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getLanguagesList())) {
          openArray("_languages");
          for (StringType e : element.getLanguagesList()) 
            composeStringExtras(null, e, true);
          closeArray();
        }
      };
      if (element.hasTree()) {
        composeWebTemplateItem("tree", element.getTree());
      }
  }

  protected void composeWebTemplateInput(String name, WebTemplateInput element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateInputProperties(element);
      close();
    }
  }

  protected void composeWebTemplateInputProperties(WebTemplateInput element) throws IOException {
    composeBaseProperties(element);
      if (element.hasSuffixElement()) {
        composeStringCore("suffix", element.getSuffixElement(), false);
        composeStringExtras("suffix", element.getSuffixElement(), false);
      }
      if (element.hasTypeElement()) {
        composeCodeCore("type", element.getTypeElement(), false);
        composeCodeExtras("type", element.getTypeElement(), false);
      }
      if (element.hasDefaultValue()) {
        composeNativePrimitive("defaultValue", element.getDefaultValue());
      }
      if (element.hasTerminologyElement()) {
        composeCodeCore("terminology", element.getTerminologyElement(), false);
        composeCodeExtras("terminology", element.getTerminologyElement(), false);
      }
      if (element.hasValidation()) {
        composeWebTemplateInputValidation("validation", element.getValidation());
      }
      if (element.hasList()) {
        openArray("list");
        for (WebTemplateInputListItem e : element.getListList()) 
          composeWebTemplateInputListItem(null, e);
        closeArray();
      };
      if (element.hasListOpenElement()) {
        composeBooleanCore("listOpen", element.getListOpenElement(), false);
        composeBooleanExtras("listOpen", element.getListOpenElement(), false);
      }
  }

  protected void composeWebTemplateInputListItem(String name, WebTemplateInputListItem element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateInputListItemProperties(element);
      close();
    }
  }

  protected void composeWebTemplateInputListItemProperties(WebTemplateInputListItem element) throws IOException {
    composeBaseProperties(element);
      if (element.hasValueElement()) {
        composeCodeCore("value", element.getValueElement(), false);
        composeCodeExtras("value", element.getValueElement(), false);
      }
      if (element.hasLabelElement()) {
        composeStringCore("label", element.getLabelElement(), false);
        composeStringExtras("label", element.getLabelElement(), false);
      }
      if (element.hasOrdinalElement()) {
        composeStringCore("ordinal", element.getOrdinalElement(), false);
        composeStringExtras("ordinal", element.getOrdinalElement(), false);
      }
      if (element.hasLocalizedLabels()) {
        openArray("localizedLabels");
        for (TranslatedString e : element.getLocalizedLabelsList()) 
          composeTranslatedString(null, e);
        closeArray();
      };
      if (element.hasLocalizedDescriptions()) {
        openArray("localizedDescriptions");
        for (TranslatedString e : element.getLocalizedDescriptionsList()) 
          composeTranslatedString(null, e);
        closeArray();
      };
      if (element.hasCurrentStatesElement()) {
        composeStringCore("currentStates", element.getCurrentStatesElement(), false);
        composeStringExtras("currentStates", element.getCurrentStatesElement(), false);
      }
      if (element.hasRangeElement()) {
        composeStringCore("range", element.getRangeElement(), false);
        composeStringExtras("range", element.getRangeElement(), false);
      }
      if (element.hasPrecisionElement()) {
        composeStringCore("precision", element.getPrecisionElement(), false);
        composeStringExtras("precision", element.getPrecisionElement(), false);
      }
      if (element.hasTermBindings()) {
        openArray("termBindings");
        for (WebTemplateTermBinding e : element.getTermBindingsList()) 
          composeWebTemplateTermBinding(null, e);
        closeArray();
      };
  }

  protected void composeWebTemplateInputValidation(String name, WebTemplateInputValidation element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateInputValidationProperties(element);
      close();
    }
  }

  protected void composeWebTemplateInputValidationProperties(WebTemplateInputValidation element) throws IOException {
    composeBaseProperties(element);
      if (element.hasRange()) {
        composeWebTemplateInputValidationRange("range", element.getRange());
      }
      if (element.hasPrecision()) {
        composeWebTemplateInputValidationRange("precision", element.getPrecision());
      }
  }

  protected void composeWebTemplateInputValidationRange(String name, WebTemplateInputValidationRange element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateInputValidationRangeProperties(element);
      close();
    }
  }

  protected void composeWebTemplateInputValidationRangeProperties(WebTemplateInputValidationRange element) throws IOException {
    composeBaseProperties(element);
      if (element.hasMinOpElement()) {
        composeCodeCore("minOp", element.getMinOpElement(), false);
        composeCodeExtras("minOp", element.getMinOpElement(), false);
      }
      if (element.hasMinElement()) {
        composeDecimalCore("min", element.getMinElement(), false);
        composeDecimalExtras("min", element.getMinElement(), false);
      }
      if (element.hasMaxOpElement()) {
        composeCodeCore("maxOp", element.getMaxOpElement(), false);
        composeCodeExtras("maxOp", element.getMaxOpElement(), false);
      }
      if (element.hasMaxElement()) {
        composeDecimalCore("max", element.getMaxElement(), false);
        composeDecimalExtras("max", element.getMaxElement(), false);
      }
  }

  protected void composeWebTemplateItem(String name, WebTemplateItem element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateItemProperties(element);
      close();
    }
  }

  protected void composeWebTemplateItemProperties(WebTemplateItem element) throws IOException {
    composeBaseProperties(element);
      if (element.hasIdElement()) {
        composeStringCore("id", element.getIdElement(), false);
        composeStringExtras("id", element.getIdElement(), false);
      }
      if (element.hasDepthElement()) {
        composeIntegerCore("depth", element.getDepthElement(), false);
        composeIntegerExtras("depth", element.getDepthElement(), false);
      }
      if (element.hasNameElement()) {
        composeStringCore("name", element.getNameElement(), false);
        composeStringExtras("name", element.getNameElement(), false);
      }
      if (element.hasLocalizedNameElement()) {
        composeStringCore("localizedName", element.getLocalizedNameElement(), false);
        composeStringExtras("localizedName", element.getLocalizedNameElement(), false);
      }
      if (element.hasRmTypeElement()) {
        composeCodeCore("rmType", element.getRmTypeElement(), false);
        composeCodeExtras("rmType", element.getRmTypeElement(), false);
      }
      if (element.hasNodeIdElement()) {
        composeStringCore("nodeId", element.getNodeIdElement(), false);
        composeStringExtras("nodeId", element.getNodeIdElement(), false);
      }
      if (element.hasMinElement()) {
        composeStringCore("min", element.getMinElement(), false);
        composeStringExtras("min", element.getMinElement(), false);
      }
      if (element.hasMaxElement()) {
        composeStringCore("max", element.getMaxElement(), false);
        composeStringExtras("max", element.getMaxElement(), false);
      }
      if (element.hasDependsOnElement()) {
        composeStringCore("dependsOn", element.getDependsOnElement(), false);
        composeStringExtras("dependsOn", element.getDependsOnElement(), false);
      }
      if (element.hasLocalizedNames()) {
        openArray("localizedNames");
        for (TranslatedString e : element.getLocalizedNamesList()) 
          composeTranslatedString(null, e);
        closeArray();
      };
      if (element.hasLocalizedDescriptions()) {
        openArray("localizedDescriptions");
        for (TranslatedString e : element.getLocalizedDescriptionsList()) 
          composeTranslatedString(null, e);
        closeArray();
      };
      if (element.hasAnnotations()) {
        composeAnnotations("annotations", element.getAnnotations());
      }
      if (element.hasArchetype_idElement()) {
        composeStringCore("archetype_id", element.getArchetype_idElement(), false);
        composeStringExtras("archetype_id", element.getArchetype_idElement(), false);
      }
      if (element.hasAqlPathElement()) {
        composeStringCore("aqlPath", element.getAqlPathElement(), false);
        composeStringExtras("aqlPath", element.getAqlPathElement(), false);
      }
      if (element.hasCustodian_namespaceElement()) {
        composeStringCore("custodian_namespace", element.getCustodian_namespaceElement(), false);
        composeStringExtras("custodian_namespace", element.getCustodian_namespaceElement(), false);
      }
      if (element.hasCustodian_organisationElement()) {
        composeStringCore("custodian_organisation", element.getCustodian_organisationElement(), false);
        composeStringExtras("custodian_organisation", element.getCustodian_organisationElement(), false);
      }
      if (element.hasLifecycleStateElement()) {
        composeCodeCore("lifecycleState", element.getLifecycleStateElement(), false);
        composeCodeExtras("lifecycleState", element.getLifecycleStateElement(), false);
      }
      if (element.hasOriginal_namespaceElement()) {
        composeStringCore("original_namespace", element.getOriginal_namespaceElement(), false);
        composeStringExtras("original_namespace", element.getOriginal_namespaceElement(), false);
      }
      if (element.hasOriginal_publisherElement()) {
        composeStringCore("original_publisher", element.getOriginal_publisherElement(), false);
        composeStringExtras("original_publisher", element.getOriginal_publisherElement(), false);
      }
      if (element.hasProportionTypesElement()) {
        composeCodeCore("proportionTypes", element.getProportionTypesElement(), false);
        composeCodeExtras("proportionTypes", element.getProportionTypesElement(), false);
      }
      if (element.hasRevisionElement()) {
        composeStringCore("revision", element.getRevisionElement(), false);
        composeStringExtras("revision", element.getRevisionElement(), false);
      }
      if (element.hasInContextElement()) {
        composeBooleanCore("inContext", element.getInContextElement(), false);
        composeBooleanExtras("inContext", element.getInContextElement(), false);
      }
      if (element.hasInputs()) {
        openArray("inputs");
        for (WebTemplateInput e : element.getInputsList()) 
          composeWebTemplateInput(null, e);
        closeArray();
      };
      if (element.hasTermBindings()) {
        openArray("termBindings");
        for (WebTemplateTermBinding e : element.getTermBindingsList()) 
          composeWebTemplateTermBinding(null, e);
        closeArray();
      };
      if (element.hasChildren()) {
        openArray("children");
        for (WebTemplateItem e : element.getChildrenList()) 
          composeWebTemplateItem(null, e);
        closeArray();
      };
  }

  protected void composeWebTemplateTermBinding(String name, WebTemplateTermBinding element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateTermBindingProperties(element);
      close();
    }
  }

  protected void composeWebTemplateTermBindingProperties(WebTemplateTermBinding element) throws IOException {
    composeBaseProperties(element);
      if (element.hasCodeElement()) {
        composeCodeCore("code", element.getCodeElement(), false);
        composeCodeExtras("code", element.getCodeElement(), false);
      }
      if (element.hasValue()) {
        composeWebTemplateTermBindingValue("value", element.getValue());
      }
  }

  protected void composeWebTemplateTermBindingValue(String name, WebTemplateTermBindingValue element) throws IOException {
    if (element != null) {
      open(name);
      composeWebTemplateTermBindingValueProperties(element);
      close();
    }
  }

  protected void composeWebTemplateTermBindingValueProperties(WebTemplateTermBindingValue element) throws IOException {
    composeBaseProperties(element);
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
      if (element.hasTerminologyIdElement()) {
        composeStringCore("terminologyId", element.getTerminologyIdElement(), false);
        composeStringExtras("terminologyId", element.getTerminologyIdElement(), false);
      }
  }



  @Override
  protected void composeResource(Resource resource) throws IOException {
    if (resource == null) {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
 
    } else
      throw new Error("Unhandled resource type "+resource.getClass().getName());
  }

}