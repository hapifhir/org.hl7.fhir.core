package org.hl7.fhir.convertors;

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


import org.hl7.fhir.r5.extensions.ExtensionDefinitions;

public class VersionConvertorConstants {

  public final static String EXT_PAYLOAD_CONTENT = "http://hl7.org/fhir/4.0/StructureDefinition/extension-CommunicationRequest.payload.content";
  public final static String EXT_IG_CONFORMANCE_MESSAGE_EVENT = "http://hl7.org/fhir/1.0/StructureDefinition/extension-Conformance.messaging.event";
  public final static String EXT_IG_DEPENDSON_VERSION_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ImplementationGuide.dependsOn.version";
  public final static String EXT_MODIFIER_REASON_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ElementDefinition.isModifierReason";
  public final static String EXT_MODIFIER_REASON_LEGACY = "No Modifier Reason provideed in previous versions of FHIR";
  public final static String EXT_PROFILE_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ElementDefinition.type.profile";
  public static final String EXT_ACCEPT_UNKNOWN_EXTENSION_URL = "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown";
  public static final String EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION = "http://hl7.org/fhir/3.0/StructureDefinition/extension-CarePlan.activity.detail.category";
  public static final String EXT_EXP_VS_CONT_PROP = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.contains.property";
  public static final String EXT_TESTSCRIPT_SCOPE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestScript.scope";
  public static final String EXT_ACTUAL_RESOURCE_NAME = "http://hl7.org/fhir/tools/StructureDefinition/original-resource-name";
  public static final String EXT_ADDITIONAL_BINDING = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ElementDefinition.binding.additional";
  public static final String EXT_CS_PROFILE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile";
  public static final String EXT_IG_DEFINITION_PAGE_NAME = "http://hl7.org/fhir/tools/StructureDefinition/ig-page-name";
  public static final String EXT_IG_DEFINITION_PARAMETER = "http://hl7.org/fhir/tools/StructureDefinition/ig-parameter";
  public static final String EXT_IG_DEFINITION_PARAM_URL_BASE = "http://hl7.org/fhir/guide-parameter-code";
  public static final String EXT_IG_DEFINITION_PARAM_URL_EXT = "http://hl7.org/fhir/tools/CodeSystem/ig-parameters";
  public static final String EXT_IG_DEFINITION_RESOURCE_PROFILE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ImplementationGuide.definition.resource.profile";
  public static final String EXT_IG_DEPENDSON_REASON = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ImplementationGuide.dependsOn.reason";
  public static final String EXT_MED_ISBRAND = "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.isBrand";
  public static final String EXT_MED_OTC = "http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationOTC";
  public static final String EXT_MED_IMAGE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationImage";
  public static final String EXT_MED_PACK_CONTAINER = "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.package.container";
  public static final String EXT_MED_PACK_AMOUNT = "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.package.content.amount";
  public static final String EXT_MED_PACK_CONTENT = "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.package.content";
  public static final String EXT_MUST_VALUE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ElementDefinition.mustHaveValue";
  public static final String EXT_NAMINGSYSTEM_TITLE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-NamingSystem.title";
  public static final String EXT_NAMINGSYSTEM_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-NamingSystem.url";
  public static final String EXT_NAMINGSYSTEM_VERSION = "http://hl7.org/fhir/5.0/StructureDefinition/extension-NamingSystem.version";
  public static final String EXT_OLD_CONCEPTMAP_EQUIVALENCE = "http://hl7.org/fhir/1.0/StructureDefinition/extension-ConceptMap.element.target.equivalence";
  public static final String EXT_OPDEF_ORIGINAL_TYPE = "http://hl7.org/fhir/4.0/StructureDefinition/extension-OperationDefinition.parameter.type";
  public static final String EXT_PAT_ANIMAL = "http://hl7.org/fhir/StructureDefinition/patient-animal";
  public static final String EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL = ExtensionDefinitions.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL;
  public static final String EXT_VALUE_ALT = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ElementDefinition.valueAlternatives";
  public static final String EXT_VS_EXP_PROP = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.property";
  public static final String EXT_VS_EXTENSIBLE = "http://hl7.org/fhir/1.0/StructureDefinition/extension-ValueSet.extensible";
  public static final String EXT_NOT_GIVEN_EXTENSION_URL = "http://hl7.org/fhir/3.0/StructureDefinition/extension-Immunization.notGiven";
  public static final String EXT_IG_DEPENDSON_PACKAGE_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ImplementationGuide.dependsOn.packageId";
  public static final String EXT_MED_REQ_ONBEHALF = "http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationRequest.requester.onBehalfOf";
  public static final String EXT_MED_STAT_STATUS = "http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationStatement.status";
  public static final String EXT_MED_STAT_STATUS_4 = "http://hl7.org/fhir/4.0/StructureDefinition/extension-MedicationStatement.status";
  public static final String EXT_MED_STAT_STATUS_5 = "http://hl7.org/fhir/5.0/StructureDefinition/extension-MedicationStatement.status";
  public static final String EXT_MED_STAT_TAKEN = "http://hl7.org/fhir/3.0/StructureDefinition/extension-MedicationStatement.taken";
  public static final String EXT_COM_REQ_ONBEHALF = "http://hl7.org/fhir/3.0/StructureDefinition/extension-CommunicationRequest.requester.onBehalfOf";
  public static final String EXT_DOC_REF_CREATED = "http://hl7.org/fhir/3.0/StructureDefinition/extension-DocumentReference.created";
  public static final String EXT_DIA_REP_PERFORMER = "http://hl7.org/fhir/3.0/StructureDefinition/extension-DiagnosticReport.performer.role";
  public static final String EXT_VERSION_ALGORITHM = "http://hl7.org/fhir/5.0/StructureDefinition/extension-CanonicalResource.versionAlgorithm";

  public static String refToVS(String url) {
    if (url == null)
      return null;
    if (url.equals("http://www.genenames.org"))
      return "http://hl7.org/fhir/ValueSet/genenames";
    else if (url.equals("http://varnomen.hgvs.org/"))
      return "http://hl7.org/fhir/ValueSet/variants";
    else if (url.equals("http://www.ncbi.nlm.nih.gov/nuccore?db=nuccore"))
      return "http://hl7.org/fhir/ValueSet/ref-sequences";
    else if (url.equals("http://www.ensembl.org/"))
      return "http://hl7.org/fhir/ValueSet/ensembl";
    else if (url.equals("http://www.ncbi.nlm.nih.gov/clinvar/variation"))
      return "http://hl7.org/fhir/ValueSet/clinvar";
    else if (url.equals("http://cancer.sanger.ac.uk/cancergenome/projects/cosmic/"))
      return "http://hl7.org/fhir/ValueSet/cosmic";
    else if (url.equals("http://www.ncbi.nlm.nih.gov/projects/SNP/"))
      return "http://hl7.org/fhir/ValueSet/bbsnp";
    else if (url.equals("http://www.sequenceontology.org/"))
      return "http://hl7.org/fhir/ValueSet/sequenceontology";
    else if (url.equals("http://www.ebi.ac.uk/"))
      return "http://hl7.org/fhir/ValueSet/allelename";
    else if (url.equals("https://www.iso.org/iso-4217-currency-codes.html"))
      return "http://hl7.org/fhir/ValueSet/currencies";
    else if (url.equals("http://www.rfc-editor.org/bcp/bcp13.txt"))
      return "http://hl7.org/fhir/ValueSet/mimetypes";
    else
      return url;
  }

  public static String vsToRef(String url) {
    if (url == null)
      return null;
    if (url.equals("http://hl7.org/fhir/ValueSet/genenames"))
      return "http://www.genenames.org";
    else if (url.equals("http://hl7.org/fhir/ValueSet/variants"))
      return "http://varnomen.hgvs.org/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/ref-sequences"))
      return "http://www.ncbi.nlm.nih.gov/nuccore?db=nuccore";
    else if (url.equals("http://hl7.org/fhir/ValueSet/ensembl"))
      return "http://www.ensembl.org/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/clinvar"))
      return "http://www.ncbi.nlm.nih.gov/clinvar/variation";
    else if (url.equals("http://hl7.org/fhir/ValueSet/cosmic"))
      return "http://cancer.sanger.ac.uk/cancergenome/projects/cosmic/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/bbsnp"))
      return "http://www.ncbi.nlm.nih.gov/projects/SNP/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/sequenceontology"))
      return "http://www.sequenceontology.org/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/allelename"))
      return "http://www.ebi.ac.uk/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/currencies"))
      return "https://www.iso.org/iso-4217-currency-codes.html";
    else if (url.equals("http://hl7.org/fhir/ValueSet/mimetypes"))
      return "http://www.rfc-editor.org/bcp/bcp13.txt";
    else
      return null;
  }


}