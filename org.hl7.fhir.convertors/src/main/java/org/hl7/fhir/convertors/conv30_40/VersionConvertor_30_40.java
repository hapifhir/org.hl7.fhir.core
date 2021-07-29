package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.Resource30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

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

public class VersionConvertor_30_40 {
  static final public String EXT_SRC_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type";
  static public List<String> CANONICAL_URLS = new ArrayList<>();
  static final public String URN_IETF_RFC_3986 = "urn:ietf:rfc:3986";

  static {
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-conceptmap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-valueset");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/codesystem-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/cqif-library");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-inheritedExtensibleValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/event-instantiatesCanonical");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-allowedProfile");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-deMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-sourceStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-targetStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-unit-valueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-supplement");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-system");
  }

  private final BaseAdvisor_30_40 advisor;
  private final Element30_40 elementConvertor;
  private final Resource30_40 resourceConvertor;
  private final Type30_40 typeConvertor;

  public VersionConvertor_30_40(BaseAdvisor_30_40 advisor) {
    this.advisor = advisor;
    this.elementConvertor = new Element30_40(advisor);
    this.resourceConvertor = new Resource30_40(advisor);
    this.typeConvertor = new Type30_40(advisor);
  }

  public BaseAdvisor_30_40 advisor() {
    return advisor;
  }

  public void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    ConversionContext30_40.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext30_40.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    ConversionContext30_40.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext30_40.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    ConversionContext30_40.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext30_40.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    ConversionContext30_40.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext30_40.INSTANCE.close(src.fhirType());
    }
  }

  public void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt);
  }

  public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu3.model.DomainResource tgt) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt);
  }

  public void copyElement(org.hl7.fhir.dstu3.model.Element src, org.hl7.fhir.r4.model.Element tgt, String... var) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext30_40.INSTANCE.path(), var);
  }

  public void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.dstu3.model.Element tgt, String... var) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext30_40.INSTANCE.path(), var);
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "ActivityDefinition", "AllergyIntolerance", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodyStructure", "Bundle", "CapabilityStatement", "CarePlan", "CareTeam", "ClinicalImpression", "CodeSystem", "Communication", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Consent", "DetectedIssue", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "Endpoint", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Goal", "GraphDefinition", "Group", "HealthcareService", "ImagingStudy", "Immunization", "ImplementationGuide", "Library", "Linkage", "ListResource", "Location", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationRequest", "MedicationStatement", "MessageDefinition", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "PaymentNotice", "Person", "PlanDefinition", "Practitioner", "PractitionerRole", "Procedure", "ProcedureRequest", "ProcessRequest", "Provenance", "Questionnaire", "QuestionnaireResponse", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "Slot", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "TestReport", "TestScript", "ValueSet");
  }
}