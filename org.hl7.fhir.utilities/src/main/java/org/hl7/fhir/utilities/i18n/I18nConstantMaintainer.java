package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class I18nConstantMaintainer {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    rename("/Users/grahamegrieve/work/core", "SD_GRID_HEAD_CARD", "GENERAL_CARD");
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_CARD", "GENERAL_CARD");      
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_CARD", "GENERAL_CARD");      

    rename("/Users/grahamegrieve/work/core", "OP_DEF_CARD", "GENERAL_CARDINALITY");
    replace("/Users/grahamegrieve/work/core", "QUEST_CARD", "GENERAL_CARDINALITY");  
    
    rename("/Users/grahamegrieve/work/core", "CODEPROP_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "CODE_SYS_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "CONC_MAP_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "DATA_REND_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "DIAG_REP_REND_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "OP_OUT_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "QUEST_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "TX_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "VALUE_SET_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "DATA_REND_GETCODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "LIST_REND_CODE", "GENERAL_CODE");
  
    // Comment
    rename("/Users/grahamegrieve/work/core", "CONC_MAP_CMNT", "GENERAL_COMMENT");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_COM", "GENERAL_COMMENT");

    // Comments
    rename("/Users/grahamegrieve/work/core", "SD_COMP_HEAD_COMP", "GENERAL_COMMENTS");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_COMMENTS", "GENERAL_COMMENTS");
    replace("/Users/grahamegrieve/work/core", "TX_COMMENTS", "GENERAL_COMMENTS");

    // Comparators
    rename("/Users/grahamegrieve/work/core", "SEARCH_PAR_COMP", "GENERAL_COMPARATORS");
    replace("/Users/grahamegrieve/work/core", "SUB_TOPIC_COMP", "GENERAL_COMPARATORS");

    // Component
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_COMPONENT", "GENERAL_COMPONENT");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_COMP", "GENERAL_COMPONENT");

    // Conformance
    rename("/Users/grahamegrieve/work/core", "CAPABILITY_CONF", "GENERAL_CONFORMANCE");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_CONFORMANCE", "GENERAL_CONFORMANCE");

    // Contact:
    rename("/Users/grahamegrieve/work/core", "PAT_NOK_CONTACT", "GENERAL_CONTACT");
    replace("/Users/grahamegrieve/work/core", "TEST_PLAN_CONT", "GENERAL_CONTACT");

    // Content
    rename("/Users/grahamegrieve/work/core", "CODE_SYS_CONTENT", "GENERAL_CONTENT");
    replace("/Users/grahamegrieve/work/core", "EX_SCEN_CONT", "GENERAL_CONTENT");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_CONTENT", "GENERAL_CONTENT");
    replace("/Users/grahamegrieve/work/core", "TEST_PLAN_CONTENT", "GENERAL_CONTENT");

    // Copyright
    rename("/Users/grahamegrieve/work/core", "CANON_REND_COPYRIGHT", "GENERAL_COPYRIGHT");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_COPY", "GENERAL_COPYRIGHT");
    replace("/Users/grahamegrieve/work/core", "QUEST_COPYRIGHT", "GENERAL_COPYRIGHT");

    // Criteria
    rename("/Users/grahamegrieve/work/core", "CAPABILITY_CRIT", "GENERAL_CRIT");
    replace("/Users/grahamegrieve/work/core", "SUB_TOPIC_CRITERIA", "GENERAL_CRIT");

    // Defining URL
    rename("/Users/grahamegrieve/work/core", "CANON_REND_URL", "GENERAL_DEFINING_URL");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_URL", "GENERAL_DEFINING_URL");

    // Definition
    rename("/Users/grahamegrieve/work/core", "CANON_REND_DEFINITION", "GENERAL_DEFINITION");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_DEF", "GENERAL_DEFINITION");
    replace("/Users/grahamegrieve/work/core", "QUEST_DEFINITION", "GENERAL_DEFINITION");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_DEFINITION", "GENERAL_DEFINITION");
    replace("/Users/grahamegrieve/work/core", "TX_DEFINITION", "GENERAL_DEFINITION");
    replace("/Users/grahamegrieve/work/core", "VALUE_SET_DEF", "GENERAL_DEFINITION");

    // Definition:
    rename("/Users/grahamegrieve/work/core", "QUEST_DEF", "GENERAL_DEFINITION_COLON");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_DEF", "GENERAL_DEFINITION_COLON");

    // Deprecated
    rename("/Users/grahamegrieve/work/core", "CODESYSTEM_DEPRECATED", "CODESYSTEM_DEPRECATED");
    replace("/Users/grahamegrieve/work/core", "TX_DEPRECATED", "CODESYSTEM_DEPRECATED");

    // Description
    rename("/Users/grahamegrieve/work/core", "CODESYSTEM_DESC", "GENERAL_DESC");
    replace("/Users/grahamegrieve/work/core", "CODESYSTEM_PROP_DESC", "GENERAL_DESC");
    replace("/Users/grahamegrieve/work/core", "EX_SCEN_DESC", "GENERAL_DESC");
    replace("/Users/grahamegrieve/work/core", "QUEST_DESCRIPTION", "GENERAL_DESC");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_DESC", "GENERAL_DESC");
    replace("/Users/grahamegrieve/work/core", "SUB_TOPIC_DESC", "GENERAL_DESC");

    // Description & Constraints
    rename("/Users/grahamegrieve/work/core", "QUEST_DESC", "GENERAL_DESC_CONST");
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_DESC", "GENERAL_DESC_CONST");

    // Details
    rename("/Users/grahamegrieve/work/core", "OP_OUT_DET", "GENERAL_DETAILS");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_DETAILS", "GENERAL_DETAILS");

    // Display
    rename("/Users/grahamegrieve/work/core", "TX_DISPLAY", "TX_DISPLAY");
    replace("/Users/grahamegrieve/work/core", "VALUE_SET_DISPLAY", "TX_DISPLAY");

    // Documentation
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_DOC", "GENERAL_DOCUMENTATION");
    replace("/Users/grahamegrieve/work/core", "CAPABILITY_DOC", "GENERAL_DOCUMENTATION");
    replace("/Users/grahamegrieve/work/core", "OBLIG_DOC", "GENERAL_DOCUMENTATION");
    replace("/Users/grahamegrieve/work/core", "OP_DEF_DOC", "GENERAL_DOCUMENTATION");

    // Example
    rename("/Users/grahamegrieve/work/core", "STRUC_DEF_EX", "GENERAL_EXAMPLE");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_EXAMPLE", "GENERAL_EXAMPLE");

    // Experimental
    rename("/Users/grahamegrieve/work/core", "QUEST_EXPER", "GENERAL_EXPER");
    replace("/Users/grahamegrieve/work/core", "RES_REND_EXP", "GENERAL_EXPER");

    // Filter
    rename("/Users/grahamegrieve/work/core", "DATA_REND_FILT", "GENERAL_FILTER");
    replace("/Users/grahamegrieve/work/core", "OBLIG_FILT", "GENERAL_FILTER");

    // Flags
    rename("/Users/grahamegrieve/work/core", "DIAG_REP_REND_FLAG", "GENERAL_FLAGS");
    replace("/Users/grahamegrieve/work/core", "QUEST_FLAG", "GENERAL_FLAGS");
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_FLAGS", "GENERAL_FLAGS");

    // Id is required to be present (this is the default for resources but not elements)
    rename("/Users/grahamegrieve/work/core", "STRUC_DEF_ID_MAY", "STRUC_DEF_ID_MAY");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_ID_REQ", "STRUC_DEF_ID_MAY");

    // Instances of this logical model are not marked to be the target of a Reference
    rename("/Users/grahamegrieve/work/core", "STRUC_DEF_NOT_MARK", "STRUC_DEF_NOT_MARK");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_NOT_MARKED", "STRUC_DEF_NOT_MARK");

    // Instances of this logical model can be the target of a Reference
    rename("/Users/grahamegrieve/work/core", "STRUC_DEF_CAN_TARGET", "STRUC_DEF_CAN_TARGET");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_REF", "STRUC_DEF_CAN_TARGET");

    // Instances of this type are validated using an unknown approach: {0}
    rename("/Users/grahamegrieve/work/core", "STRUC_DEF_UNKNOWN_APPROACH", "STRUC_DEF_UNKNOWN_APPROACH");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_VALID_UNKNOWN", "STRUC_DEF_UNKNOWN_APPROACH");

    // Location
    rename("/Users/grahamegrieve/work/core", "OP_OUT_LOC", "GENERAL_LOCATION");
    replace("/Users/grahamegrieve/work/core", "PROV_LOC", "GENERAL_LOCATION");

    // Logical Container
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_LOGIC", "STRUC_DEF_LOGICAL_CONT");

    // Maturity
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_MATURITY", "CANON_REND_MATURITY");

    // Max Length:
    rename("/Users/grahamegrieve/work/core", "QUEST_MAX", "GENERAL_MAX_LENGTH");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_MAX_LENGTH", "GENERAL_MAX_LENGTH");

    // Modifiers
    rename("/Users/grahamegrieve/work/core", "SEARCH_PAR_MOD", "GENERAL_MODIFIERS");
    replace("/Users/grahamegrieve/work/core", "SUB_TOPIC_MOD", "GENERAL_MODIFIERS");

    // Name
    rename("/Users/grahamegrieve/work/core", "CANON_REND_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "CODESYSTEM_PROP_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "DATA_REND_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "EX_SCEN_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "OP_DEF_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "QUEST_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "SD_COMP_HEAD_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "SD_GRID_HEAD_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_NAME", "GENERAL_NAME");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_NAME", "GENERAL_NAME");

    // Not done yet
    rename("/Users/grahamegrieve/work/core", "DIAG_REP_REND_NOTDONE", "GENERAL_TODO");
    replace("/Users/grahamegrieve/work/core", "OP_OUT_NOT", "GENERAL_TODO");
    replace("/Users/grahamegrieve/work/core", "PROV_NOT", "GENERAL_TODO");
    replace("/Users/grahamegrieve/work/core", "QUEST_NOT_DONE", "GENERAL_TODO");

    // Note
    rename("/Users/grahamegrieve/work/core", "DIAG_REP_REND_NOTE", "GENERAL_NOTE");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_NOTE_C", "GENERAL_NOTE");

    // OID
    rename("/Users/grahamegrieve/work/core", "CODE_SYS_OID", "GENERAL_OID");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_OID", "GENERAL_OID");
    replace("/Users/grahamegrieve/work/core", "VALUE_SET_OID", "GENERAL_OID");

    // Obligations
    rename("/Users/grahamegrieve/work/core", "OBLIG_OBLIG", "GENERAL_OBLIG");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_OBLIGATIONS", "GENERAL_OBLIG");

    // Parameter
    rename("/Users/grahamegrieve/work/core", "CAPABILITY_PAR", "GENERAL_PAR");
    replace("/Users/grahamegrieve/work/core", "SEARCH_PAR_PAR", "GENERAL_PAR");

    // Parameters
    rename("/Users/grahamegrieve/work/core", "CAPABILITY_PARS", "GENERAL_PARS");
    replace("/Users/grahamegrieve/work/core", "LIB_REND_PARA", "GENERAL_PARS");
    replace("/Users/grahamegrieve/work/core", "OP_DEF_PAR", "GENERAL_PARS");
    replace("/Users/grahamegrieve/work/core", "PAR_REND_PAR", "GENERAL_PARS");

    // Preferred
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_PREFERRED", "GENERAL_PREFERRED");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_PREF", "GENERAL_PREFERRED");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_PREF", "GENERAL_PREFERRED");

    // Profile
    rename("/Users/grahamegrieve/work/core", "CAPABILITY_PROF", "GENERAL_PROF");
    replace("/Users/grahamegrieve/work/core", "RES_REND_PROF", "GENERAL_PROF");
    replace("/Users/grahamegrieve/work/core", "RES_REND_PROFILE", "GENERAL_PROF");
    replace("/Users/grahamegrieve/work/core", "TEXT_ICON_PROFILE", "GENERAL_PROF");

    // Properties
    rename("/Users/grahamegrieve/work/core", "CODESYSTEM_PROPS", "GENERAL_PROPS");
    replace("/Users/grahamegrieve/work/core", "CONC_MAP_PROP", "GENERAL_PROPS");

    // Publisher
    rename("/Users/grahamegrieve/work/core", "CANON_REND_PUBLISHER", "CANON_REND_PUBLISHER");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_PUB", "CANON_REND_PUBLISHER");

    // Purpose
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_PUR", "GENERAL_PURPOSE");
    replace("/Users/grahamegrieve/work/core", "QUEST_PURPOSE", "GENERAL_PURPOSE");

    // Reference to the type of the element
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_TYPE_DESC", "SD_GRID_HEAD_TYPE_DESC");

    // References:
    rename("/Users/grahamegrieve/work/core", "ACTOR_DEF_REF", "GENERAL_REFS");
    replace("/Users/grahamegrieve/work/core", "REQ_REFERENCES", "GENERAL_REFS");

    // Request
    rename("/Users/grahamegrieve/work/core", "DIAG_REP_REND_REQUEST", "GENERAL_REQUEST");
    replace("/Users/grahamegrieve/work/core", "EX_SCEN_REQ", "GENERAL_REQUEST");

    // Required
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_REQUIRED", "GENERAL_REQUIRED");
    replace("/Users/grahamegrieve/work/core", "QUEST_REQ", "GENERAL_REQUIRED");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_REQ", "GENERAL_REQUIRED");

    // Resource
    rename("/Users/grahamegrieve/work/core", "RES_REND_RESOURCE", "GENERAL_RESOURCE");
    replace("/Users/grahamegrieve/work/core", "SEARCH_PAR_REND_RES", "GENERAL_RESOURCE");
    replace("/Users/grahamegrieve/work/core", "SUB_TOPIC_RES", "GENERAL_RESOURCE");
    replace("/Users/grahamegrieve/work/core", "TEXT_ICON_RESOURCE", "GENERAL_RESOURCE");

    // SNOMED-CT
    rename("/Users/grahamegrieve/work/core", "STRUC_DEF_SNOMED_CT", "GENERAL_SNOMED_CT");
    replace("/Users/grahamegrieve/work/core", "TERMINOLOGY_SNOMED", "GENERAL_SNOMED_CT");

    // Security Label
    rename("/Users/grahamegrieve/work/core", "RES_REND_SECURITY", "GENERAL_SECURITY_LABEL");
    replace("/Users/grahamegrieve/work/core", "RES_REND_SECURITY_LABEL", "GENERAL_SECURITY_LABEL");

    // Source:
    rename("/Users/grahamegrieve/work/core", "LIST_REND_SRC", "GENERAL_SRC");
    replace("/Users/grahamegrieve/work/core", "REQ_SOURCES", "GENERAL_SRC");

    // Starter
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_STARTER", "GENERAL_STARTER");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_START", "GENERAL_STARTER");

    // Status
    rename("/Users/grahamegrieve/work/core", "CANON_REND_STATUS", "GENERAL_STATUS");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_STAT", "GENERAL_STATUS");
    replace("/Users/grahamegrieve/work/core", "QUEST_STATUS", "GENERAL_STATUS");

    // Subject
    rename("/Users/grahamegrieve/work/core", "DATA_REND_SUB", "GENERAL_SUBJ");
    replace("/Users/grahamegrieve/work/core", "DIAG_REP_REND_SUB", "GENERAL_SUBJ");
    replace("/Users/grahamegrieve/work/core", "QUEST_SUB", "GENERAL_SUBJ");

    // Summary
    rename("/Users/grahamegrieve/work/core", "CAPABILITY_SUMM", "GENERAL_SUMM");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_SUM", "GENERAL_SUMM");
    replace("/Users/grahamegrieve/work/core", "PROV_SUM", "GENERAL_SUMM");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_SUMMARY", "GENERAL_SUMM");

    // The logical name of the element
    rename("/Users/grahamegrieve/work/core", "SD_COMP_HEAD_NAME_DESC", "GENERAL_LOGICAL_NAME");
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_NAME_DESC", "GENERAL_LOGICAL_NAME");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_LOGIC_NAME", "GENERAL_LOGICAL_NAME");

    // The minimum allowable value set - any conformant system SHALL support all these codes
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_MIN_ALLOW", "GENERAL_BIND_MIN_ALLOW");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_MIN_ALLOW", "GENERAL_BIND_MIN_ALLOW");

    // This content has been removed since {0}
    rename("/Users/grahamegrieve/work/core", "REND_ROW_REMOVED_SINCE", "GENERAL_REMOVED_SINCE");
    replace("/Users/grahamegrieve/work/core", "REND_SINCE_DELETED", "GENERAL_REMOVED_SINCE");

    // This element can be extended by named JSON elements
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_JSON_ELE", "STRUC_DEF_EXT_JSON");

    // This element is a modifier element
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_MOD_ELEMENT", "STRUC_DEF_MOD");

    // This element is included in summaries
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_SUMM", "STRUC_DEF_ELE_INCLUDED");

    // This element must be supported
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_SUPP", "STRUC_DEF_ELE_MUST_SUPP");

    // This is a repeating choice group that does not appear directly in the instance
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_REP_CHOICE", "STRUC_DEF_REPEAT");

    // This value set is a good set of codes to start with when designing your system
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_START_DEF", "ADD_BIND_DESIG_SYS");

    // Title
    rename("/Users/grahamegrieve/work/core", "CANON_REND_TITLE", "GENERAL_TITLE");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_TITLE", "GENERAL_TITLE");
    replace("/Users/grahamegrieve/work/core", "QUEST_TITLE", "GENERAL_TITLE");

    // Type
    rename("/Users/grahamegrieve/work/core", "CAPABILITY_TYP", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "CODESYSTEM_PROP_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "DATA_REND_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "EX_SCEN_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "OP_DEF_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "PROV_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "QUEST_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "SD_GRID_HEAD_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_TYPE", "GENERAL_TYPE");
    replace("/Users/grahamegrieve/work/core", "TEST_PLAN_TYPE", "GENERAL_TYPE");

    // UCUM
    rename("/Users/grahamegrieve/work/core", "DATA_REND_UCUM", "GENERAL_UCUM");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_UCUM", "GENERAL_UCUM");

    // URI
    rename("/Users/grahamegrieve/work/core", "CODESYSTEM_PROP_URI", "GENERAL_URI");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_URI", "GENERAL_URI");

    // URL
    rename("/Users/grahamegrieve/work/core", "QUEST_URL", "GENERAL_URL");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_URL", "GENERAL_URL");

    // Usage
    rename("/Users/grahamegrieve/work/core", "ADD_BIND_USE", "GENERAL_USAGE");
    replace("/Users/grahamegrieve/work/core", "OBLIG_USE", "GENERAL_USAGE");

    // Value
    rename("/Users/grahamegrieve/work/core", "CODESYSTEM_FILTER_VALUE", "GENERAL_VALUE");
    replace("/Users/grahamegrieve/work/core", "DATA_REND_VALUE", "GENERAL_VALUE");
    replace("/Users/grahamegrieve/work/core", "DIAG_REP_REND_VALUE", "GENERAL_VALUE");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_VALUE", "GENERAL_VALUE");

    // Value Set
    rename("/Users/grahamegrieve/work/core", "CODE_SYS_VALUE_SET", "GENERAL_VALUESET");
    replace("/Users/grahamegrieve/work/core", "QUEST_VALUE_SET", "GENERAL_VALUESET");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_VALUE", "GENERAL_VALUESET");

    // Version
    rename("/Users/grahamegrieve/work/core", "CANON_REND_VER", "GENERAL_VER");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_VER", "GENERAL_VER");
    replace("/Users/grahamegrieve/work/core", "QUEST_VERSION", "GENERAL_VER");
    replace("/Users/grahamegrieve/work/core", "RES_REND_VERSION", "GENERAL_VER");
    replace("/Users/grahamegrieve/work/core", "TX_VERSION", "GENERAL_VER");

    // XML
    rename("/Users/grahamegrieve/work/core", "CANON_REND_XML", "GENERAL_XML");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_XML", "GENERAL_XML");

    // for OID based terminology systems
    rename("/Users/grahamegrieve/work/core", "CODE_SYS_FOR_OID", "CODE_SYS_FOR_OID");
    replace("/Users/grahamegrieve/work/core", "NAME_SYS_FOROID", "CODE_SYS_FOR_OID");
    replace("/Users/grahamegrieve/work/core", "VALUE_SET_OID_TERM_SYS", "CODE_SYS_FOR_OID");

    // is prefixed to the value before validation
    rename("/Users/grahamegrieve/work/core", "STRUC_DEF_PREFIXED", "STRUC_DEF_PREFIXED");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_PREFIX_VALID", "STRUC_DEF_PREFIXED");

    // todo
    replace("/Users/grahamegrieve/work/core", "OP_OUT_TODO", "GENERAL_TODO");
    replace("/Users/grahamegrieve/work/core", "QUEST_TODO", "GENERAL_TODO");
    replace("/Users/grahamegrieve/work/core", "RES_REND_TODO", "GENERAL_TODO");
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_TODO", "GENERAL_TODO");

    // version
    rename("/Users/grahamegrieve/work/core", "EX_SCEN_VER", "GENERAL_VER_LOW");
    replace("/Users/grahamegrieve/work/core", "VALUE_SET_VERSION", "GENERAL_VER_LOW");

    // {0}, {1} by {2}
    rename("/Users/grahamegrieve/work/core", "SD_SLICING_INFO", "SD_SLICING_INFO");
    replace("/Users/grahamegrieve/work/core", "SD_SUMMARY_INFO", "SD_SLICING_INFO");
  }

  private static void replace(String dir, String src, String tgt) throws FileNotFoundException, IOException {
    if (!src.equals(tgt)) {
      System.out.println("Replace "+src+" with "+tgt+" in "+dir);
      int count = replace(new File(dir), src, tgt);
      System.out.println("Done. "+count+" files changed");
    }
  }

  private static int replace(File file, String src, String tgt) throws FileNotFoundException, IOException {
    int count = 0;
    if (file.isDirectory()) {
      for (File f : file.listFiles()) {
        count = count + replace(f, src, tgt);
      }
    } else {
      String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
      if ("java".equals(ext)) {
        String source = TextFile.fileToString(file);
        boolean mod = false;
        if (source.contains("I18nConstants."+src+",")) {
          source = source.replace("I18nConstants."+src+",", "I18nConstants."+tgt+",");
          mod = true;
        } 
        if (source.contains("I18nConstants."+src+")")) {
          source = source.replace("I18nConstants."+src+")", "I18nConstants."+tgt+")");
          mod = true;
        } 
        
        if (source.contains("RenderingI18nContext."+src+",")) {
          source = source.replace("RenderingI18nContext."+src+",", "RenderingI18nContext."+tgt+",");
          mod = true;
        } 
        if (source.contains("RenderingI18nContext."+src+")")) {
          source = source.replace("RenderingI18nContext."+src+")", "RenderingI18nContext."+tgt+")");
          mod = true;
        } 

        if (source.contains("RenderingContext."+src+",")) {
          source = source.replace("RenderingContext."+src+",", "RenderingContext."+tgt+",");
          mod = true;
        }
        
        if (source.contains("RenderingContext."+src+")")) {
          source = source.replace("RenderingContext."+src+")", "RenderingContext."+tgt+")");
          mod = true;
        }
         
        if (file.getName().equals("I18nConstants.java") && source.contains(src)) {
          source = removeLines(source, src);
          mod = true;
        } 
        if (file.getName().equals("RenderingI18nContext.java") && source.contains(src)) {
          source = removeLines(source, src);
          mod = true;
        } 
        if (mod) {
          TextFile.stringToFile(source, file);
          count++;
        }

      } else if (Utilities.existsInList(ext, "properties")) {
        String source = TextFile.fileToString(file);
        if (source.contains(src)) {
          source = removeLines(source, src);
          TextFile.stringToFile(source, file);
          count++;
        }
      }
    }
    return count;
  }

  private static String removeLines(String source, String src) {
    String[] lines = Utilities.splitLines(source);
    StringBuilder b = new StringBuilder();
    for (String s : lines) {
      if (!(s.contains(src+"\"") || s.contains(src+"=") || s.contains(src+" "))) {
        b.append(s);
        b.append("\r\n");
      }
    }
    return b.toString();
  }

  private static void rename(String dir, String src, String tgt) throws FileNotFoundException, IOException {
    if (!src.equals(tgt)) {
      System.out.println("Rename "+src+" to "+tgt+" in "+dir);
      int count = rename(new File(dir), src, tgt);
      System.out.println("Done. "+count+" files changed");
    }
  }

  private static int rename(File file, String src, String tgt) throws FileNotFoundException, IOException {
    int count = 0;
    if (file.isDirectory()) {
      for (File f : file.listFiles()) {
        count = count + rename(f, src, tgt);
      }
    } else {
      String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
      if ("java".equals(ext)) {
        String source = TextFile.fileToString(file);
        boolean mod = false;
        
        if (source.contains("I18nConstants."+src+",")) {
          source = source.replace("I18nConstants."+src+",", "I18nConstants."+tgt+",");
          mod = true;
        } 
        if (source.contains("I18nConstants."+src+")")) {
          source = source.replace("I18nConstants."+src+")", "I18nConstants."+tgt+")");
          mod = true;
        } 
        
        if (source.contains("RenderingI18nContext."+src+",")) {
          source = source.replace("RenderingI18nContext."+src+",", "RenderingI18nContext."+tgt+",");
          mod = true;
        } 
        if (source.contains("RenderingI18nContext."+src+")")) {
          source = source.replace("RenderingI18nContext."+src+")", "RenderingI18nContext."+tgt+")");
          mod = true;
        } 

        if (source.contains("RenderingContext."+src+",")) {
          source = source.replace("RenderingContext."+src+",", "RenderingContext."+tgt+",");
          mod = true;
        }
        
        if (source.contains("RenderingContext."+src+")")) {
          source = source.replace("RenderingContext."+src+")", "RenderingContext."+tgt+")");
          mod = true;
        }
        
        
        
        if (file.getName().equals("I18nConstants.java") && source.contains(src+" =")) {
          source = source.replace(src+" =", tgt+" =");
          mod = true;
        }  
        if (file.getName().equals("I18nConstants.java") && source.contains(src+"=")) {
          source = source.replace(src+"=", tgt+" =");
          mod = true;
        } 
        if (file.getName().equals("I18nConstants.java") && source.contains(src+" =")) {
          source = source.replace(src+" =", tgt+" =");
          mod = true;
        } 
        if (file.getName().equals("I18nConstants.java") && source.contains(src+"=")) {
          source = source.replace(src+"=", tgt+" =");
          mod = true;
        } 
        if (file.getName().equals("RenderingI18nContext.java") && source.contains(src+" =")) {
          source = source.replace(src+" =", tgt+" =");
          mod = true;
        } 
        if (file.getName().equals("RenderingI18nContext.java") && source.contains(src+"=")) {
          source = source.replace(src+"=", tgt+" =");
          mod = true;
        } 

        if (mod) {
          TextFile.stringToFile(source, file);
          count++;
        }

      } else if (Utilities.existsInList(ext, "po", "properties")) {
        String source = TextFile.fileToString(file);
        if (source.contains(src)) {
          source = source.replace(src, tgt);
          TextFile.stringToFile(source, file);
          count++;
        }
      }
    }
    return count;
  }
}
