package org.hl7.fhir.r5.openehr;

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


  
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.Base;

public class TypeFactory extends Factory {

    public static Base createType(String name) throws FHIRException {
      switch (name.hashCode()) {
        case 1925345846: return new ACTION();
        case -873340145: return new ACTIVITY();
        case -429709356: return new ADDRESS();
        case -1382932670: return new ADMIN_ENTRY();
        case 62212837: return new AGENT();
        case 1064832689: return new ARCHETYPE_ID();
        case 264794875: return new ARCHETYPED();
        case 1443336880: return new ATTESTATION();
        case 228187550: return new AUDIT_DETAILS();
        case 706159364: return new Annotations();
        case -298577640: return new CAPABILITY();
        case 1590074842: return new CLUSTER();
        case -361507509: return new CODE_PHRASE();
        case 1314037130: return new COMPOSITION();
        case 1669509120: return new CONTACT();
        case -601715696: return new CONTRIBUTION();
        case 1840641371: return new DV_BOOLEAN();
        case 888790594: return new DV_CODED_TEXT();
        case 52006658: return new DV_COUNT();
        case -1522326725: return new DV_DATE();
        case 1347071313: return new DV_DATE_TIME();
        case 1522199201: return new DV_DURATION();
        case 11133551: return new DV_EHR_URI();
        case -622650475: return new DV_GENERAL_TIME_SPECIFICATION();
        case -305383818: return new DV_IDENTIFIER();
        case -210337326: return new DV_INTERVAL();
        case -1719828456: return new DV_MULTIMEDIA();
        case 568935332: return new DV_ORDINAL();
        case -779301407: return new DV_PARAGRAPH();
        case 406932825: return new DV_PARSABLE();
        case -1654100760: return new DV_PERIODIC_TIME_SPECIFICATION();
        case 673287783: return new DV_PROPORTION();
        case -2065759848: return new DV_QUANTITY();
        case 66406205: return new DV_SCALE();
        case 66912900: return new DV_STATE();
        case -1521846086: return new DV_TEXT();
        case -1521842598: return new DV_TIME();
        case 2029119519: return new DV_URI();
        case 68623: return new EHR();
        case -447366252: return new EHR_ACCESS();
        case 83613218: return new EHR_STATUS();
        case -944854308: return new ELEMENT();
        case 1343615804: return new EVALUATION();
        case 92915914: return new EVENT_CONTEXT();
        case 225999175: return new FEEDER_AUDIT();
        case -1591843030: return new FEEDER_AUDIT_DETAILS();
        case 2079330414: return new FOLDER();
        case 797698211: return new GENERIC_ID();
        case 68091487: return new GROUP();
        case 1114667146: return new HIER_OBJECT_ID();
        case 1644916852: return new HISTORY();
        case -510646659: return new IMPORTED_VERSION();
        case -1840480146: return new INSTRUCTION();
        case -2023205039: return new INSTRUCTION_DETAILS();
        case 76145369: return new INTERNET_ID();
        case -2060236160: return new INTERVAL_EVENT();
        case 69994161: return new ISM_TRANSITION();
        case -1479621936: return new ISO_OID();
        case 674751050: return new ITEM_LIST();
        case 95942388: return new ITEM_SINGLE();
        case -550420606: return new ITEM_TABLE();
        case 1961436238: return new ITEM_TAG();
        case 674997578: return new ITEM_TREE();
        case 2336762: return new LINK();
        case 1558028385: return new LOCATABLE_REF();
        case 1553222515: return new OBJECT_REF();
        case 245463810: return new OBJECT_VERSION_ID();
        case -2019660788: return new OBSERVATION();
        case -999167782: return new ORGANISATION();
        case 1501456458: return new ORIGINAL_VERSION();
        case 1874830625: return new PARTICIPATION();
        case -1805159500: return new PARTY_IDENTIFIED();
        case -1878970857: return new PARTY_IDENTITY();
        case 1001896826: return new PARTY_REF();
        case -628307054: return new PARTY_RELATED();
        case 682481425: return new PARTY_RELATIONSHIP();
        case 994060581: return new PARTY_SELF();
        case -1938387115: return new PERSON();
        case -639801621: return new POINT_EVENT();
        case -1033459959: return new REFERENCE_RANGE();
        case 1224967467: return new RESOURCE_DESCRIPTION();
        case 606415271: return new RESOURCE_DESCRIPTION_ITEM();
        case -827739120: return new REVISION_HISTORY();
        case 1005683170: return new REVISION_HISTORY_ITEM();
        case 2521206: return new ROLE();
        case -1606743355: return new SECTION();
        case -372332800: return new TEMPLATE_ID();
        case 1766939611: return new TERM_MAPPING();
        case -917870009: return new TERMINOLOGY_ID();
        case 112102004: return new TRANSLATION_DETAILS();
        case 1460097191: return new TranslatedString();
        case 2616251: return new UUID();
        case 1908280533: return new VERSION_TREE_ID();
        case -1476193118: return new VERSIONED_COMPOSITION();
        case -1230110340: return new VERSIONED_EHR_ACCESS();
        case -699130870: return new VERSIONED_EHR_STATUS();
        case -353924522: return new VERSIONED_FOLDER();
        case -108326617: return new VERSIONED_OBJECT();
        case -1388065826: return new VERSIONED_PARTY();
        case 1912213454: return new WebTemplate();
        case -1229584228: return new WebTemplateInput();
        case 1911304589: return new WebTemplateInputListItem();
        case -1604183499: return new WebTemplateInputValidation();
        case 167790600: return new WebTemplateInputValidationRange();
        case -1009489919: return new WebTemplateItem();
        case -510870581: return new WebTemplateTermBinding();
        case -1350464410: return new WebTemplateTermBindingValue();

      default:
        throw new FHIRException("Unknown Resource or Type Name '"+name+"'");
    }
  }


}