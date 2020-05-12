package org.hl7.fhir.convertors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.convertors.conv30_50.ActivityDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.AllergyIntolerance30_50;
import org.hl7.fhir.convertors.conv30_50.Appointment30_50;
import org.hl7.fhir.convertors.conv30_50.AppointmentResponse30_50;
import org.hl7.fhir.convertors.conv30_50.AuditEvent30_50;
import org.hl7.fhir.convertors.conv30_50.Basic30_50;
import org.hl7.fhir.convertors.conv30_50.Binary30_50;
import org.hl7.fhir.convertors.conv30_50.BodySite30_50;
import org.hl7.fhir.convertors.conv30_50.Bundle30_50;
import org.hl7.fhir.convertors.conv30_50.CapabilityStatement30_50;
import org.hl7.fhir.convertors.conv30_50.CarePlan30_50;
import org.hl7.fhir.convertors.conv30_50.CareTeam30_50;
import org.hl7.fhir.convertors.conv30_50.ClinicalImpression30_50;
import org.hl7.fhir.convertors.conv30_50.CodeSystem30_50;
import org.hl7.fhir.convertors.conv30_50.Communication30_50;
import org.hl7.fhir.convertors.conv30_50.CompartmentDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.Composition30_50;
import org.hl7.fhir.convertors.conv30_50.ConceptMap30_50;
import org.hl7.fhir.convertors.conv30_50.Condition30_50;
import org.hl7.fhir.convertors.conv30_50.Consent30_50;
import org.hl7.fhir.convertors.conv30_50.DataElement30_50;
import org.hl7.fhir.convertors.conv30_50.DetectedIssue30_50;
import org.hl7.fhir.convertors.conv30_50.DeviceUseStatement30_50;
import org.hl7.fhir.convertors.conv30_50.DiagnosticReport30_50;
import org.hl7.fhir.convertors.conv30_50.DocumentReference30_50;
import org.hl7.fhir.convertors.conv30_50.Encounter30_50;
import org.hl7.fhir.convertors.conv30_50.Endpoint30_50;
import org.hl7.fhir.convertors.conv30_50.EpisodeOfCare30_50;
import org.hl7.fhir.convertors.conv30_50.ExpansionProfile30_50;
import org.hl7.fhir.convertors.conv30_50.FamilyMemberHistory30_50;
import org.hl7.fhir.convertors.conv30_50.Flag30_50;
import org.hl7.fhir.convertors.conv30_50.Goal30_50;
import org.hl7.fhir.convertors.conv30_50.GraphDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.Group30_50;
import org.hl7.fhir.convertors.conv30_50.HealthcareService30_50;
import org.hl7.fhir.convertors.conv30_50.ImagingStudy30_50;
import org.hl7.fhir.convertors.conv30_50.Immunization30_50;
import org.hl7.fhir.convertors.conv30_50.ImplementationGuide30_50;
import org.hl7.fhir.convertors.conv30_50.Library30_50;
import org.hl7.fhir.convertors.conv30_50.Linkage30_50;
import org.hl7.fhir.convertors.conv30_50.List30_50;
import org.hl7.fhir.convertors.conv30_50.Location30_50;
import org.hl7.fhir.convertors.conv30_50.Measure30_50;
import org.hl7.fhir.convertors.conv30_50.Media30_50;
import org.hl7.fhir.convertors.conv30_50.Medication30_50;
import org.hl7.fhir.convertors.conv30_50.MedicationAdministration30_50;
import org.hl7.fhir.convertors.conv30_50.MedicationDispense30_50;
import org.hl7.fhir.convertors.conv30_50.MedicationRequest30_50;
import org.hl7.fhir.convertors.conv30_50.MedicationStatement30_50;
import org.hl7.fhir.convertors.conv30_50.MessageDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.MessageHeader30_50;
import org.hl7.fhir.convertors.conv30_50.NamingSystem30_50;
import org.hl7.fhir.convertors.conv30_50.Observation30_50;
import org.hl7.fhir.convertors.conv30_50.OperationDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.OperationOutcome30_50;
import org.hl7.fhir.convertors.conv30_50.Organization30_50;
import org.hl7.fhir.convertors.conv30_50.Parameters30_50;
import org.hl7.fhir.convertors.conv30_50.Patient30_50;
import org.hl7.fhir.convertors.conv30_50.PaymentNotice30_50;
import org.hl7.fhir.convertors.conv30_50.Person30_50;
import org.hl7.fhir.convertors.conv30_50.PlanDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.Practitioner30_50;
import org.hl7.fhir.convertors.conv30_50.PractitionerRole30_50;
import org.hl7.fhir.convertors.conv30_50.Provenance30_50;
import org.hl7.fhir.convertors.conv30_50.Questionnaire30_50;
import org.hl7.fhir.convertors.conv30_50.QuestionnaireResponse30_50;
import org.hl7.fhir.convertors.conv30_50.RelatedPerson30_50;
import org.hl7.fhir.convertors.conv30_50.RiskAssessment30_50;
import org.hl7.fhir.convertors.conv30_50.Schedule30_50;
import org.hl7.fhir.convertors.conv30_50.SearchParameter30_50;
import org.hl7.fhir.convertors.conv30_50.Sequence30_50;
import org.hl7.fhir.convertors.conv30_50.Slot30_50;
import org.hl7.fhir.convertors.conv30_50.Specimen30_50;
import org.hl7.fhir.convertors.conv30_50.StructureDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.StructureMap30_50;
import org.hl7.fhir.convertors.conv30_50.Substance30_50;
import org.hl7.fhir.convertors.conv30_50.SupplyDelivery30_50;
import org.hl7.fhir.convertors.conv30_50.TestReport30_50;
import org.hl7.fhir.convertors.conv30_50.TestScript30_50;
import org.hl7.fhir.convertors.conv30_50.ValueSet30_50;
import org.hl7.fhir.dstu3.model.Parameters;
import org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.utilities.Utilities;

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
public class VersionConvertor_30_50 {

    static final public String EXT_SRC_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type";

    static public List<String> CANONICAL_URLS = new ArrayList<>();

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

    static public void copyElement(org.hl7.fhir.dstu3.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        for (org.hl7.fhir.dstu3.model.Extension e : src.getExtension()) {
            if (!isExemptExtension(e.getUrl(), extensionsToIgnore)) {
                tgt.addExtension(convertExtension(e));
            }
        }
    }

    static public void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.dstu3.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
            if (!isExemptExtension(e.getUrl(), extensionsToIgnore)) {
                tgt.addExtension(convertExtension(e));
            }
        }
    }

    static public void copyBackboneElement(org.hl7.fhir.dstu3.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    static public void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.dstu3.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    public static org.hl7.fhir.r5.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu3.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.r5.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r5.model.Base64BinaryType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r5.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu3.model.Base64BinaryType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.dstu3.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.r5.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.BooleanType(src.getValue()) : new org.hl7.fhir.r5.model.BooleanType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu3.model.BooleanType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValue()) : new org.hl7.fhir.r5.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu3.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeType convertStringToCode(org.hl7.fhir.dstu3.model.StringType src) throws FHIRException {
        org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValue()) : new org.hl7.fhir.r5.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StringType convertCodeToString(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.StringType(src.getValue()) : new org.hl7.fhir.dstu3.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeType convertStringToCode(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu3.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StringType convertCodeToString(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValue()) : new org.hl7.fhir.r5.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
        org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DateTimeType convertDateToDateTime(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
        org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateType convertDateTimeToDate(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DateTimeType convertDateTime(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateTimeType convertDateTime(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DecimalType convertDecimal(org.hl7.fhir.dstu3.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.r5.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DecimalType(src.getValue()) : new org.hl7.fhir.r5.model.DecimalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DecimalType convertDecimal(org.hl7.fhir.r5.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DecimalType(src.getValue()) : new org.hl7.fhir.dstu3.model.DecimalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.dstu3.model.IdType src) throws FHIRException {
        org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValue()) : new org.hl7.fhir.r5.model.IdType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.IdType(src.getValue()) : new org.hl7.fhir.dstu3.model.IdType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r5.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r5.model.InstantType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.InstantType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.dstu3.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.r5.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IntegerType(src.getValue()) : new org.hl7.fhir.r5.model.IntegerType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu3.model.IntegerType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DecimalType convertInteger64(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DecimalType tgt = new org.hl7.fhir.dstu3.model.DecimalType(src.getValue().toString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu3.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r5.model.MarkdownType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MarkdownType convertMarkdown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu3.model.MarkdownType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.dstu3.model.OidType src) throws FHIRException {
        org.hl7.fhir.r5.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.OidType(src.getValue()) : new org.hl7.fhir.r5.model.OidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.OidType(src.getValue()) : new org.hl7.fhir.dstu3.model.OidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu3.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.r5.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r5.model.PositiveIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.dstu3.model.PositiveIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StringType convertString(org.hl7.fhir.dstu3.model.StringType src) throws FHIRException {
        org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValue()) : new org.hl7.fhir.r5.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StringType convertString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.StringType(src.getValue()) : new org.hl7.fhir.dstu3.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MarkdownType convertStringToMarkdown(org.hl7.fhir.dstu3.model.StringType src) throws FHIRException {
        org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r5.model.MarkdownType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StringType convertMarkdownToString(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.StringType(src.getValue()) : new org.hl7.fhir.dstu3.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TimeType convertTime(org.hl7.fhir.dstu3.model.TimeType src) throws FHIRException {
        org.hl7.fhir.r5.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.TimeType(src.getValue()) : new org.hl7.fhir.r5.model.TimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TimeType convertTime(org.hl7.fhir.r5.model.TimeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.TimeType(src.getValue()) : new org.hl7.fhir.dstu3.model.TimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu3.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.r5.model.UnsignedIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.dstu3.model.UnsignedIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
        org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValue()) : new org.hl7.fhir.r5.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UriType(src.getValue()) : new org.hl7.fhir.dstu3.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UriType convertCodeToUri(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValue()) : new org.hl7.fhir.r5.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeType convertUriToCode(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu3.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.dstu3.model.UuidType src) throws FHIRException {
        org.hl7.fhir.r5.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UuidType(src.getValue()) : new org.hl7.fhir.r5.model.UuidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UuidType(src.getValue()) : new org.hl7.fhir.dstu3.model.UuidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.dstu3.model.Extension src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
        copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu3.model.Reference)
                tgt.setValue(convertReferenceToCanonical((org.hl7.fhir.dstu3.model.Reference) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Extension tgt = new org.hl7.fhir.dstu3.model.Extension();
        copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r5.model.CanonicalType)
                tgt.setValue(convertCanonicalToReference((org.hl7.fhir.r5.model.CanonicalType) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Narrative convertNarrative(org.hl7.fhir.dstu3.model.Narrative src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Narrative tgt = new org.hl7.fhir.r5.model.Narrative();
        copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
        if (src.hasDiv())
            tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Narrative convertNarrative(org.hl7.fhir.r5.model.Narrative src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Narrative tgt = new org.hl7.fhir.dstu3.model.Narrative();
        copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
        if (src.hasDiv())
            tgt.setDiv(src.getDiv());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case GENERATED:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.GENERATED);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EXTENSIONS);
                break;
            case ADDITIONAL:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.ADDITIONAL);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EMPTY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case GENERATED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.GENERATED);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EXTENSIONS);
                break;
            case ADDITIONAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.ADDITIONAL);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EMPTY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Age convertAge(org.hl7.fhir.dstu3.model.Age src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Age tgt = new org.hl7.fhir.r5.model.Age();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Age convertAge(org.hl7.fhir.r5.model.Age src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Age tgt = new org.hl7.fhir.dstu3.model.Age();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.dstu3.model.Annotation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
        copyElement(src, tgt);
        if (src.hasAuthor())
            tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTime())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        if (src.hasText())
            tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Annotation tgt = new org.hl7.fhir.dstu3.model.Annotation();
        copyElement(src, tgt);
        if (src.hasAuthor())
            tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTime())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        if (src.hasText())
            tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.dstu3.model.Attachment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Attachment tgt = new org.hl7.fhir.r5.model.Attachment();
        copyElement(src, tgt);
        if (src.hasContentType())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasData())
            tgt.setDataElement(convertBase64Binary(src.getDataElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasSize())
            tgt.setSize(Long.valueOf(src.getSize()));
        if (src.hasHash())
            tgt.setHashElement(convertBase64Binary(src.getHashElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCreation())
            tgt.setCreationElement(convertDateTime(src.getCreationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Attachment tgt = new org.hl7.fhir.dstu3.model.Attachment();
        copyElement(src, tgt);
        if (src.hasContentType())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasData())
            tgt.setDataElement(convertBase64Binary(src.getDataElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasSize())
            tgt.setSize(Math.toIntExact(src.getSize()));
        if (src.hasHash())
            tgt.setHashElement(convertBase64Binary(src.getHashElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCreation())
            tgt.setCreationElement(convertDateTime(src.getCreationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeableConcept tgt = new org.hl7.fhir.dstu3.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasUserSelected())
            tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
        copyElement(src, tgt);
        tgt.setCode(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeableConcept convertCodingToCodeableConcept(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.getCodingFirstRep().setSystem(src.getSystem());
        if (src.hasVersion())
            tgt.getCodingFirstRep().setVersion(src.getVersion());
        if (src.hasCode())
            tgt.getCodingFirstRep().setCode(src.getCode());
        if (src.hasDisplay())
            tgt.getCodingFirstRep().setDisplay(src.getDisplay());
        if (src.hasUserSelected())
            tgt.getCodingFirstRep().setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
        copyElement(src, tgt);
        if (src.hasCoding()) {
            if (src.getCodingFirstRep().hasSystem())
                tgt.setSystem(src.getCodingFirstRep().getSystem());
            if (src.getCodingFirstRep().hasVersion())
                tgt.setVersion(src.getCodingFirstRep().getVersion());
            if (src.getCodingFirstRep().hasCode())
                tgt.setCode(src.getCodingFirstRep().getCode());
            if (src.getCodingFirstRep().hasDisplay())
                tgt.setDisplay(src.getCodingFirstRep().getDisplay());
            if (src.getCodingFirstRep().hasUserSelected())
                tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
        copyElement(src, tgt);
        if (src.hasCoding()) {
            if (src.getCodingFirstRep().hasSystem())
                tgt.setSystem(src.getCodingFirstRep().getSystem());
            if (src.getCodingFirstRep().hasVersion())
                tgt.setVersion(src.getCodingFirstRep().getVersion());
            if (src.getCodingFirstRep().hasCode())
                tgt.setCode(src.getCodingFirstRep().getCode());
            if (src.getCodingFirstRep().hasDisplay())
                tgt.setDisplay(src.getCodingFirstRep().getDisplay());
            if (src.getCodingFirstRep().hasUserSelected())
                tgt.setUserSelected(src.getCodingFirstRep().getUserSelected());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasUserSelected())
            tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Count convertCount(org.hl7.fhir.dstu3.model.Count src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Count tgt = new org.hl7.fhir.r5.model.Count();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Count convertCount(org.hl7.fhir.r5.model.Count src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Count tgt = new org.hl7.fhir.dstu3.model.Count();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Distance convertDistance(org.hl7.fhir.dstu3.model.Distance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Distance tgt = new org.hl7.fhir.r5.model.Distance();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Distance convertDistance(org.hl7.fhir.r5.model.Distance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Distance tgt = new org.hl7.fhir.dstu3.model.Distance();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Duration convertDuration(org.hl7.fhir.dstu3.model.Duration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Duration tgt = new org.hl7.fhir.r5.model.Duration();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Duration convertDuration(org.hl7.fhir.r5.model.Duration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Duration tgt = new org.hl7.fhir.dstu3.model.Duration();
        copyQuantity(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.dstu3.model.Identifier src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Identifier tgt = new org.hl7.fhir.r5.model.Identifier();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasAssigner())
            tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Identifier tgt = new org.hl7.fhir.dstu3.model.Identifier();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasAssigner())
            tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.TEMP);
                break;
            case SECONDARY:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.SECONDARY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.TEMP);
                break;
            case SECONDARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.SECONDARY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.dstu3.model.Money src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasCode())
            tgt.setCurrencyElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Money tgt = new org.hl7.fhir.dstu3.model.Money();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasCurrency())
            tgt.setCodeElement(convertCode(src.getCurrencyElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.dstu3.model.Period src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
        copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(convertDateTime(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertDateTime(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Period tgt = new org.hl7.fhir.dstu3.model.Period();
        copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(convertDateTime(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertDateTime(src.getEndElement()));
        return tgt;
    }

    public static void copyQuantity(org.hl7.fhir.dstu3.model.Quantity src, org.hl7.fhir.r5.model.Quantity tgt) throws FHIRException {
        if (src == null || tgt == null)
            return;
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
    }

    public static void copyQuantity(org.hl7.fhir.r5.model.Quantity src, org.hl7.fhir.dstu3.model.Quantity tgt) throws FHIRException {
        if (src == null || tgt == null)
            return;
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
    }

    public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.dstu3.model.Quantity src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Quantity tgt = new org.hl7.fhir.dstu3.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case LESS_THAN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_THAN);
                break;
            case LESS_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_OR_EQUAL);
                break;
            case GREATER_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_OR_EQUAL);
                break;
            case GREATER_THAN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_THAN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Quantity.QuantityComparatorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case LESS_THAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_THAN);
                break;
            case LESS_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
                break;
            case GREATER_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
                break;
            case GREATER_THAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_THAN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.dstu3.model.Range src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Range tgt = new org.hl7.fhir.dstu3.model.Range();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Ratio convertRatio(org.hl7.fhir.dstu3.model.Ratio src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Ratio tgt = new org.hl7.fhir.r5.model.Ratio();
        copyElement(src, tgt);
        if (src.hasNumerator())
            tgt.setNumerator(convertQuantity(src.getNumerator()));
        if (src.hasDenominator())
            tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Ratio convertRatio(org.hl7.fhir.r5.model.Ratio src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Ratio tgt = new org.hl7.fhir.dstu3.model.Ratio();
        copyElement(src, tgt);
        if (src.hasNumerator())
            tgt.setNumerator(convertQuantity(src.getNumerator()));
        if (src.hasDenominator())
            tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(src.getReference());
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Reference tgt = new org.hl7.fhir.dstu3.model.Reference();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(src.getReference());
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.dstu3.model.SampledData src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
        copyElement(src, tgt);
        if (src.hasOrigin())
            tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasLowerLimit())
            tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
        if (src.hasUpperLimit())
            tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
        if (src.hasDimensions())
            tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
        if (src.hasData())
            tgt.setDataElement(convertString(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SampledData tgt = new org.hl7.fhir.dstu3.model.SampledData();
        copyElement(src, tgt);
        if (src.hasOrigin())
            tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasLowerLimit())
            tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
        if (src.hasUpperLimit())
            tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
        if (src.hasDimensions())
            tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
        if (src.hasData())
            tgt.setDataElement(convertString(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.dstu3.model.Signature src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        if (src.hasWhen())
            tgt.setWhenElement(convertInstant(src.getWhenElement()));
        if (src.hasWho()) {
            if (src.hasWhoUriType())
                tgt.setWho(new org.hl7.fhir.r5.model.Reference(src.getWhoUriType().getValue()));
            else
                tgt.setWho(convertReference(src.getWhoReference()));
        }
        if (src.hasOnBehalfOf()) {
            if (src.hasOnBehalfOfUriType())
                tgt.setOnBehalfOf(new Reference(src.getOnBehalfOfUriType().primitiveValue()));
            else
                tgt.setOnBehalfOf(convertReference(src.getOnBehalfOfReference()));
        }
        if (src.hasContentType())
            tgt.setSigFormatElement(convertCode(src.getContentTypeElement()));
        if (src.hasBlob())
            tgt.setDataElement(convertBase64Binary(src.getBlobElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Signature tgt = new org.hl7.fhir.dstu3.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        if (src.hasWhen())
            tgt.setWhenElement(convertInstant(src.getWhenElement()));
        if (src.hasWho())
            tgt.setWho(convertType(src.getWho()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(convertType(src.getOnBehalfOf()));
        if (src.hasSigFormat())
            tgt.setContentTypeElement(convertCode(src.getSigFormatElement()));
        if (src.hasData())
            tgt.setBlobElement(convertBase64Binary(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Address convertAddress(org.hl7.fhir.dstu3.model.Address src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Address tgt = new org.hl7.fhir.r5.model.Address();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        if (src.hasCity())
            tgt.setCityElement(convertString(src.getCityElement()));
        if (src.hasDistrict())
            tgt.setDistrictElement(convertString(src.getDistrictElement()));
        if (src.hasState())
            tgt.setStateElement(convertString(src.getStateElement()));
        if (src.hasPostalCode())
            tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
        if (src.hasCountry())
            tgt.setCountryElement(convertString(src.getCountryElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Address convertAddress(org.hl7.fhir.r5.model.Address src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Address tgt = new org.hl7.fhir.dstu3.model.Address();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        if (src.hasCity())
            tgt.setCityElement(convertString(src.getCityElement()));
        if (src.hasDistrict())
            tgt.setDistrictElement(convertString(src.getDistrictElement()));
        if (src.hasState())
            tgt.setStateElement(convertString(src.getStateElement()));
        if (src.hasPostalCode())
            tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
        if (src.hasCountry())
            tgt.setCountryElement(convertString(src.getCountryElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Address.AddressUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> convertAddressType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case POSTAL:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.POSTAL);
                break;
            case PHYSICAL:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.PHYSICAL);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressType> convertAddressType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Address.AddressTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case POSTAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.POSTAL);
                break;
            case PHYSICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.PHYSICAL);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertContactDetail(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertContactDetail(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu3.model.ContactPoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ContactPoint tgt = new org.hl7.fhir.r5.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasUse())
            tgt.setUseElement(convertContactPointUse(src.getUseElement()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ContactPoint tgt = new org.hl7.fhir.dstu3.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasUse())
            tgt.setUseElement(convertContactPointUse(src.getUseElement()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PHONE:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PHONE);
                break;
            case FAX:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.FAX);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.EMAIL);
                break;
            case PAGER:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PAGER);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.URL);
                break;
            case SMS:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.SMS);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PHONE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PHONE);
                break;
            case FAX:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.FAX);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.EMAIL);
                break;
            case PAGER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PAGER);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.URL);
                break;
            case SMS:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.SMS);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.OLD);
                break;
            case MOBILE:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.MOBILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.OLD);
                break;
            case MOBILE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.MOBILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contributor convertContributor(org.hl7.fhir.dstu3.model.Contributor src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contributor tgt = new org.hl7.fhir.r5.model.Contributor();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertContributorType(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contributor convertContributor(org.hl7.fhir.r5.model.Contributor src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Contributor tgt = new org.hl7.fhir.dstu3.model.Contributor();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertContributorType(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Contributor.ContributorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contributor.ContributorTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AUTHOR:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.AUTHOR);
                break;
            case EDITOR:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.EDITOR);
                break;
            case REVIEWER:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.REVIEWER);
                break;
            case ENDORSER:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.ENDORSER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Contributor.ContributorType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Contributor.ContributorTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AUTHOR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Contributor.ContributorType.AUTHOR);
                break;
            case EDITOR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Contributor.ContributorType.EDITOR);
                break;
            case REVIEWER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Contributor.ContributorType.REVIEWER);
                break;
            case ENDORSER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Contributor.ContributorType.ENDORSER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Contributor.ContributorType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Dosage convertDosage(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertInteger(src.getSequenceElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAdditionalInstruction()) tgt.addAdditionalInstruction(convertCodeableConcept(t));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        if (src.hasTiming())
            tgt.setTiming(convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasSite())
            tgt.setSite(convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasDose() || src.hasRate()) {
            org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
            if (src.hasDose())
                dr.setDose(convertType(src.getDose()));
            if (src.hasRate())
                dr.setRate(convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        if (src.hasMaxDosePerAdministration())
            tgt.setMaxDosePerAdministration(convertSimpleQuantity(src.getMaxDosePerAdministration()));
        if (src.hasMaxDosePerLifetime())
            tgt.setMaxDosePerLifetime(convertSimpleQuantity(src.getMaxDosePerLifetime()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Dosage convertDosage(org.hl7.fhir.r5.model.Dosage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertInteger(src.getSequenceElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAdditionalInstruction()) tgt.addAdditionalInstruction(convertCodeableConcept(t));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        if (src.hasTiming())
            tgt.setTiming(convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasSite())
            tgt.setSite(convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
            tgt.setDose(convertType(src.getDoseAndRate().get(0).getDose()));
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        if (src.hasMaxDosePerAdministration())
            tgt.setMaxDosePerAdministration(convertSimpleQuantity(src.getMaxDosePerAdministration()));
        if (src.hasMaxDosePerLifetime())
            tgt.setMaxDosePerLifetime(convertSimpleQuantity(src.getMaxDosePerLifetime()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
            tgt.setRate(convertType(src.getDoseAndRate().get(0).getRate()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu3.model.ElementDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition tgt = new org.hl7.fhir.r5.model.ElementDefinition();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_30_50::convertPropertyRepresentation)
                .collect(Collectors.toList()));
        if (src.hasSliceName())
            tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        if (src.hasShort())
            tgt.setShortElement(convertString(src.getShortElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
        for (org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent t : src.getType()) convertTypeRefComponent(t, tgt.getType());
        if (src.hasDefaultValue())
            tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
        if (src.hasOrderMeaning())
            tgt.setOrderMeaningElement(convertString(src.getOrderMeaningElement()));
        if (src.hasFixed())
            tgt.setFixed(convertType(src.getFixed()));
        if (src.hasPattern())
            tgt.setPattern(convertType(src.getPattern()));
        for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample()) tgt.addExample(convertElementDefinitionExampleComponent(t));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
        for (org.hl7.fhir.dstu3.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
        if (src.hasIsModifier())
            tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
        if (tgt.getIsModifier()) {
            String reason = org.hl7.fhir.dstu3.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
            if (Utilities.noString(reason))
                reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
            tgt.setIsModifierReason(reason);
        }
        if (src.hasIsSummary())
            tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r5.model.ElementDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition tgt = new org.hl7.fhir.dstu3.model.ElementDefinition();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_30_50::convertPropertyRepresentation)
                .collect(Collectors.toList()));        if (src.hasSliceName())
            tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        if (src.hasShort())
            tgt.setShortElement(convertString(src.getShortElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
        for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : src.getType()) convertTypeRefComponent(t, tgt.getType());
        if (src.hasDefaultValue())
            tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
        if (src.hasOrderMeaning())
            tgt.setOrderMeaningElement(convertString(src.getOrderMeaningElement()));
        if (src.hasFixed())
            tgt.setFixed(convertType(src.getFixed()));
        if (src.hasPattern())
            tgt.setPattern(convertType(src.getPattern()));
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample()) tgt.addExample(convertElementDefinitionExampleComponent(t));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
        for (org.hl7.fhir.r5.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
        if (src.hasIsModifier())
            tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
        if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
            org.hl7.fhir.dstu3.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
        if (src.hasIsSummary())
            tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case XMLATTR:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                break;
            case XMLTEXT:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                break;
            case TYPEATTR:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                break;
            case CDATEXT:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                break;
            case XHTML:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XHTML);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case XMLATTR:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                break;
            case XMLTEXT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                break;
            case TYPEATTR:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                break;
            case CDATEXT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                break;
            case XHTML:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XHTML);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrdered())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrdered())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLOSED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.CLOSED);
                break;
            case OPEN:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPEN);
                break;
            case OPENATEND:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPENATEND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLOSED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.CLOSED);
                break;
            case OPEN:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPEN);
                break;
            case OPENATEND:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPENATEND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VALUE:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.VALUE);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.EXISTS);
                break;
            case PATTERN:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.PATTERN);
                break;
            case TYPE:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.TYPE);
                break;
            case PROFILE:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.PROFILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VALUE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.VALUE);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.EXISTS);
                break;
            case PATTERN:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.PATTERN);
                break;
            case TYPE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.TYPE);
                break;
            case PROFILE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.PROFILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasMin())
            tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasMin())
            tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        return tgt;
    }

    public static void convertTypeRefComponent(org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent tgt = null;
        for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : list) if (t.getCode().equals(src.getCode()))
            tgt = t;
        if (tgt == null) {
            tgt = new org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent();
            list.add(tgt);
            copyElement(src, tgt);
            tgt.setCodeElement(convertUri(src.getCodeElement()));
        }
        if (src.hasProfile()) {
            boolean found = false;
            for (CanonicalType p : tgt.getProfile()) {
                if (p.equals(src.getProfile()))
                    found = true;
            }
            if (!found)
                tgt.addProfile(src.getProfile());
        }
        if (src.hasTargetProfile())
            tgt.addTargetProfile(src.getTargetProfile());
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
            org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> a = convertAggregationMode(t);
            if (!tgt.hasAggregation(a.getValue()))
                copyElement(t, tgt.addAggregation(a.getValue()));
        }
        if (src.hasVersioning())
            tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    }

    public static void convertTypeRefComponent(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        tgt.setCodeElement(convertUri(src.getCodeElement()));
        list.add(tgt);
        if (src.hasTarget()) {
            if (src.hasProfile())
                tgt.setProfile(src.getProfile().get(0).getValue());
            for (org.hl7.fhir.r5.model.UriType u : src.getTargetProfile()) {
                if (tgt.hasTargetProfile()) {
                    tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
                    list.add(tgt);
                    copyElement(src, tgt);
                    tgt.setCode(src.getCode());
                    if (src.hasProfile())
                        tgt.setProfile(src.getProfile().get(0).getValue());
                }
                tgt.setTargetProfile(u.getValue());
            }
        } else {
            for (org.hl7.fhir.r5.model.UriType u : src.getProfile()) {
                if (tgt.hasProfile()) {
                    tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
                    list.add(tgt);
                    copyElement(src, tgt);
                    tgt.setCode(src.getCode());
                }
                tgt.setProfile(u.getValue());
            }
        }
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONTAINED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.CONTAINED);
                break;
            case REFERENCED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.REFERENCED);
                break;
            case BUNDLED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.BUNDLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONTAINED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.CONTAINED);
                break;
            case REFERENCED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.REFERENCED);
                break;
            case BUNDLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.BUNDLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EITHER:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.EITHER);
                break;
            case INDEPENDENT:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                break;
            case SPECIFIC:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EITHER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.EITHER);
                break;
            case INDEPENDENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                break;
            case SPECIFIC:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent();
        copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent();
        copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        if (src.hasKey())
            tgt.setKeyElement(convertId(src.getKeyElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
        if (src.hasHuman())
            tgt.setHumanElement(convertString(src.getHumanElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasXpath())
            tgt.setXpathElement(convertString(src.getXpathElement()));
        if (src.hasSource())
            tgt.setSource(src.getSource());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        if (src.hasKey())
            tgt.setKeyElement(convertId(src.getKeyElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
        if (src.hasHuman())
            tgt.setHumanElement(convertString(src.getHumanElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasXpath())
            tgt.setXpathElement(convertString(src.getXpathElement()));
        if (src.hasSource())
            tgt.setSource(src.getSource());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ERROR:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.ERROR);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.WARNING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.ERROR);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.WARNING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt, EXT_SRC_TYPE);
        if (src.hasStrength())
            tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasValueSet()) {
            DataType t = convertType(src.getValueSet());
            if (t instanceof org.hl7.fhir.r5.model.Reference) {
                tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
                tgt.getValueSetElement().addExtension(EXT_SRC_TYPE, new UriType("Reference"));
            } else {
                tgt.setValueSet(t.primitiveValue());
                tgt.getValueSetElement().addExtension(EXT_SRC_TYPE, new UriType("uri"));
            }
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt, EXT_SRC_TYPE);
        if (src.hasStrength())
            tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasValueSet()) {
            org.hl7.fhir.r5.model.Extension ex = src.getValueSetElement().getExtensionByUrl(EXT_SRC_TYPE);
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (ex != null) {
                if ("uri".equals(ex.getValue().primitiveValue())) {
                    tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr == null ? src.getValueSet() : vsr));
                } else {
                    tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
                }
            } else {
                if (vsr != null)
                    tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr));
                else
                    tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
            }
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.REQUIRED);
                break;
            case EXTENSIBLE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXTENSIBLE);
                break;
            case PREFERRED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.PREFERRED);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXAMPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.REQUIRED);
                break;
            case EXTENSIBLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXTENSIBLE);
                break;
            case PREFERRED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.PREFERRED);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXAMPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentity())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasMap())
            tgt.setMapElement(convertString(src.getMapElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentity())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasMap())
            tgt.setMapElement(convertString(src.getMapElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HumanName convertHumanName(org.hl7.fhir.dstu3.model.HumanName src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HumanName tgt = new org.hl7.fhir.r5.model.HumanName();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasFamily())
            tgt.setFamilyElement(convertString(src.getFamilyElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HumanName convertHumanName(org.hl7.fhir.r5.model.HumanName src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HumanName tgt = new org.hl7.fhir.dstu3.model.HumanName();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasFamily())
            tgt.setFamilyElement(convertString(src.getFamilyElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.r5.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.r5.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.HumanName.NameUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.TEMP);
                break;
            case NICKNAME:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.NICKNAME);
                break;
            case ANONYMOUS:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.ANONYMOUS);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.OLD);
                break;
            case MAIDEN:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.MAIDEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.HumanName.NameUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.TEMP);
                break;
            case NICKNAME:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.NICKNAME);
                break;
            case ANONYMOUS:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.ANONYMOUS);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.OLD);
                break;
            case MAIDEN:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.MAIDEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.dstu3.model.Meta src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
        if (src.hasLastUpdated())
            tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Meta tgt = new org.hl7.fhir.dstu3.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
        if (src.hasLastUpdated())
            tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
        for (org.hl7.fhir.r5.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.dstu3.model.ParameterDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ParameterDefinition tgt = new org.hl7.fhir.r5.model.ParameterDefinition();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertCode(src.getNameElement()));
        if (src.hasUse())
            tgt.setUseElement(convertParameterUse(src.getUseElement()));
        if (src.hasMin())
            tgt.setMinElement(convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
        if (src.hasType())
            tgt.setType(org.hl7.fhir.r5.model.Enumerations.FHIRAllTypes.fromCode(src.getType()));
        if (src.hasProfile()) {
            tgt.setProfile(convertReference(src.getProfile()).getReference());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r5.model.ParameterDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ParameterDefinition tgt = new org.hl7.fhir.dstu3.model.ParameterDefinition();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertCode(src.getNameElement()));
        if (src.hasUse())
            tgt.setUseElement(convertParameterUse(src.getUseElement()));
        if (src.hasMin())
            tgt.setMinElement(convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
        if (src.hasType())
            tgt.setType(src.getType().toCode());
        if (src.hasProfile())
            tgt.setProfile(new org.hl7.fhir.dstu3.model.Reference(src.getProfile()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
                break;
            case OUT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> convertParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUseEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case IN:
                tgt.setValue(org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse.IN);
                break;
            case OUT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse.OUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.dstu3.model.RelatedArtifact src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RelatedArtifact tgt = new org.hl7.fhir.r5.model.RelatedArtifact();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasCitation())
            tgt.setCitation(src.getCitation());
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasDocument())
            tgt.setDocument(convertAttachment(src.getDocument()));
        if (src.hasResource())
            tgt.setResourceElement(convertReferenceToCanonical(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r5.model.RelatedArtifact src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RelatedArtifact tgt = new org.hl7.fhir.dstu3.model.RelatedArtifact();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasCitation())
            tgt.setCitation(src.getCitation());
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasDocument())
            tgt.setDocument(convertAttachment(src.getDocument()));
        if (src.hasResource())
            tgt.setResource(convertCanonicalToReference(src.getResourceElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DOCUMENTATION:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
                break;
            case JUSTIFICATION:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
                break;
            case CITATION:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.CITATION);
                break;
            case PREDECESSOR:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
                break;
            case SUCCESSOR:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
                break;
            case DERIVEDFROM:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
                break;
            case DEPENDSON:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
                break;
            case COMPOSEDOF:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DOCUMENTATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
                break;
            case JUSTIFICATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
                break;
            case CITATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.CITATION);
                break;
            case PREDECESSOR:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
                break;
            case SUCCESSOR:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
                break;
            case DERIVEDFROM:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
                break;
            case DEPENDSON:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
                break;
            case COMPOSEDOF:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Timing convertTiming(org.hl7.fhir.dstu3.model.Timing src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Timing tgt = new org.hl7.fhir.r5.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        if (src.hasRepeat())
            tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Timing convertTiming(org.hl7.fhir.r5.model.Timing src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Timing tgt = new org.hl7.fhir.dstu3.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        if (src.hasRepeat())
            tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r5.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        if (src.hasBounds())
            tgt.setBounds(convertType(src.getBounds()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasCountMax())
            tgt.setCountMax(src.getCountMax());
        if (src.hasDuration())
            tgt.setDurationElement(convertDecimal(src.getDurationElement()));
        if (src.hasDurationMax())
            tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
        if (src.hasDurationUnit())
            tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
        if (src.hasFrequency())
            tgt.setFrequency(src.getFrequency());
        if (src.hasFrequencyMax())
            tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMax())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnit())
            tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
        tgt.setDayOfWeek(src.getDayOfWeek().stream()
                .map(VersionConvertor_30_50::convertDayOfWeek)
                .collect(Collectors.toList()));
        tgt.setWhen(src.getWhen().stream()
                .map(VersionConvertor_30_50::convertEventTiming)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.dstu3.model.TimeType t : src.getTimeOfDay()) tgt.addTimeOfDay(t.getValue());
        if (src.hasOffset())
            tgt.setOffsetElement(convertUnsignedInt(src.getOffsetElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        if (src.hasBounds())
            tgt.setBounds(convertType(src.getBounds()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasCountMax())
            tgt.setCountMax(src.getCountMax());
        if (src.hasDuration())
            tgt.setDurationElement(convertDecimal(src.getDurationElement()));
        if (src.hasDurationMax())
            tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
        if (src.hasDurationUnit())
            tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
        if (src.hasFrequency())
            tgt.setFrequency(src.getFrequency());
        if (src.hasFrequencyMax())
            tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMax())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnit())
            tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
        tgt.setDayOfWeek(src.getDayOfWeek().stream()
                .map(VersionConvertor_30_50::convertDayOfWeek)
                .collect(Collectors.toList()));
        tgt.setWhen(src.getWhen().stream()
                .map(VersionConvertor_30_50::convertEventTiming)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.r5.model.TimeType t : src.getTimeOfDay()) tgt.addTimeOfDay(t.getValue());
        if (src.hasOffset())
            tgt.setOffsetElement(convertUnsignedInt(src.getOffsetElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case S:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.S);
                break;
            case MIN:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.MIN);
                break;
            case H:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.H);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.D);
                break;
            case WK:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.WK);
                break;
            case MO:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.MO);
                break;
            case A:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.A);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case S:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.S);
                break;
            case MIN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MIN);
                break;
            case H:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.H);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.D);
                break;
            case WK:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.WK);
                break;
            case MO:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MO);
                break;
            case A:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.A);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDayOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.DayOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MON:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON);
                break;
            case TUE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE);
                break;
            case WED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED);
                break;
            case THU:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU);
                break;
            case FRI:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI);
                break;
            case SAT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT);
                break;
            case SUN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.DayOfWeek> convertDayOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.DayOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.DayOfWeekEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MON:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.MON);
                break;
            case TUE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.TUE);
                break;
            case WED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.WED);
                break;
            case THU:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.THU);
                break;
            case FRI:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.FRI);
                break;
            case SAT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.SAT);
                break;
            case SUN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.SUN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.EventTimingEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MORN:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.MORN);
                break;
            case AFT:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AFT);
                break;
            case EVE:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.EVE);
                break;
            case NIGHT:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NIGHT);
                break;
            case PHS:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PHS);
                break;
            case HS:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.HS);
                break;
            case WAKE:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.WAKE);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.C);
                break;
            case CM:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CM);
                break;
            case CD:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CD);
                break;
            case CV:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CV);
                break;
            case AC:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AC);
                break;
            case ACM:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACM);
                break;
            case ACD:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACD);
                break;
            case ACV:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACV);
                break;
            case PC:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PC);
                break;
            case PCM:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCM);
                break;
            case PCD:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCD);
                break;
            case PCV:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCV);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.EventTimingEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MORN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.MORN);
                break;
            case AFT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.AFT);
                break;
            case EVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.EVE);
                break;
            case NIGHT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.NIGHT);
                break;
            case PHS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PHS);
                break;
            case HS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.HS);
                break;
            case WAKE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.WAKE);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.C);
                break;
            case CM:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CM);
                break;
            case CD:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CD);
                break;
            case CV:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CV);
                break;
            case AC:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.AC);
                break;
            case ACM:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACM);
                break;
            case ACD:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACD);
                break;
            case ACV:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACV);
                break;
            case PC:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PC);
                break;
            case PCM:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCM);
                break;
            case PCD:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCD);
                break;
            case PCV:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCV);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UsageContext convertUsageContext(org.hl7.fhir.dstu3.model.UsageContext src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.UsageContext tgt = new org.hl7.fhir.r5.model.UsageContext();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCoding(src.getCode()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UsageContext convertUsageContext(org.hl7.fhir.r5.model.UsageContext src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.UsageContext tgt = new org.hl7.fhir.dstu3.model.UsageContext();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCoding(src.getCode()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu3.model.SimpleQuantity src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SimpleQuantity tgt = new org.hl7.fhir.r5.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SimpleQuantity tgt = new org.hl7.fhir.dstu3.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.dstu3.model.TriggerDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TriggerDefinition tgt = new org.hl7.fhir.r5.model.TriggerDefinition();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
        if (src.hasEventName())
            tgt.setNameElement(convertString(src.getEventNameElement()));
        if (src.hasEventTiming())
            tgt.setTiming(convertType(src.getEventTiming()));
        if (src.hasEventData())
            tgt.addData(convertDataRequirement(src.getEventData()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r5.model.TriggerDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TriggerDefinition tgt = new org.hl7.fhir.dstu3.model.TriggerDefinition();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
        if (src.hasName())
            tgt.setEventNameElement(convertString(src.getNameElement()));
        if (src.hasTiming())
            tgt.setEventTiming(convertType(src.getTiming()));
        if (src.hasData())
            tgt.setEventData(convertDataRequirement(src.getDataFirstRep()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DataRequirement convertDataRequirement(org.hl7.fhir.dstu3.model.DataRequirement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DataRequirement tgt = new org.hl7.fhir.r5.model.DataRequirement();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(Enumerations.FHIRAllTypes.fromCode(src.getType()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getMustSupport()) tgt.addMustSupport(t.getValue());
        for (org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter()) tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
        for (org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter()) tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataRequirement convertDataRequirement(org.hl7.fhir.r5.model.DataRequirement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DataRequirement tgt = new org.hl7.fhir.dstu3.model.DataRequirement();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType().toCode());
        for (org.hl7.fhir.r5.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.r5.model.StringType t : src.getMustSupport()) tgt.addMustSupport(t.getValue());
        for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter()) tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
        for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter()) tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasValueSet()) {
            DataType t = convertType(src.getValueSet());
            if (t instanceof org.hl7.fhir.r5.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getValueCode()) tgt.addCode(convertCoding(t));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getValueCoding()) tgt.addCode(convertCoding(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getValueCodeableConcept()) tgt.addCode(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
        }
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) {
            tgt.addValueCoding(convertCoding(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TriggerDefinition.TriggerTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NAMEDEVENT:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NAMEDEVENT);
                break;
            case PERIODIC:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.PERIODIC);
                break;
            case DATAADDED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAADDED);
                break;
            case DATAMODIFIED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAMODIFIED);
                break;
            case DATAREMOVED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAREMOVED);
                break;
            case DATAACCESSED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSED);
                break;
            case DATAACCESSENDED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NAMEDEVENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.NAMEDEVENT);
                break;
            case PERIODIC:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.PERIODIC);
                break;
            case DATAADDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAADDED);
                break;
            case DATAMODIFIED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAMODIFIED);
                break;
            case DATAREMOVED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAREMOVED);
                break;
            case DATAACCESSED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAACCESSED);
                break;
            case DATAACCESSENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
        if (src == null)
            return null;
        if (src instanceof org.hl7.fhir.dstu3.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.dstu3.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.BooleanType)
            return convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.CodeType)
            return convertCode((org.hl7.fhir.dstu3.model.CodeType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DateType)
            return convertDate((org.hl7.fhir.dstu3.model.DateType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DateTimeType)
            return convertDateTime((org.hl7.fhir.dstu3.model.DateTimeType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DecimalType)
            return convertDecimal((org.hl7.fhir.dstu3.model.DecimalType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.IdType)
            return convertId((org.hl7.fhir.dstu3.model.IdType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.InstantType)
            return convertInstant((org.hl7.fhir.dstu3.model.InstantType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.IntegerType)
            return convertInteger((org.hl7.fhir.dstu3.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.OidType)
            return convertOid((org.hl7.fhir.dstu3.model.OidType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.dstu3.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.StringType)
            return convertString((org.hl7.fhir.dstu3.model.StringType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.TimeType)
            return convertTime((org.hl7.fhir.dstu3.model.TimeType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.dstu3.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.UriType)
            return convertUri((org.hl7.fhir.dstu3.model.UriType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.UuidType)
            return convertUuid((org.hl7.fhir.dstu3.model.UuidType) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Extension)
            return convertExtension((org.hl7.fhir.dstu3.model.Extension) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Narrative)
            return convertNarrative((org.hl7.fhir.dstu3.model.Narrative) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Age)
            return convertAge((org.hl7.fhir.dstu3.model.Age) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Annotation)
            return convertAnnotation((org.hl7.fhir.dstu3.model.Annotation) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Attachment)
            return convertAttachment((org.hl7.fhir.dstu3.model.Attachment) src);
        if (src instanceof org.hl7.fhir.dstu3.model.CodeableConcept)
            return convertCodeableConcept((org.hl7.fhir.dstu3.model.CodeableConcept) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Coding)
            return convertCoding((org.hl7.fhir.dstu3.model.Coding) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Count)
            return convertCount((org.hl7.fhir.dstu3.model.Count) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Distance)
            return convertDistance((org.hl7.fhir.dstu3.model.Distance) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Duration)
            return convertDuration((org.hl7.fhir.dstu3.model.Duration) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Identifier)
            return convertIdentifier((org.hl7.fhir.dstu3.model.Identifier) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Money)
            return convertMoney((org.hl7.fhir.dstu3.model.Money) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Period)
            return convertPeriod((org.hl7.fhir.dstu3.model.Period) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Quantity)
            return convertQuantity((org.hl7.fhir.dstu3.model.Quantity) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Range)
            return convertRange((org.hl7.fhir.dstu3.model.Range) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Ratio)
            return convertRatio((org.hl7.fhir.dstu3.model.Ratio) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Reference)
            return convertReference((org.hl7.fhir.dstu3.model.Reference) src);
        if (src instanceof org.hl7.fhir.dstu3.model.SampledData)
            return convertSampledData((org.hl7.fhir.dstu3.model.SampledData) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Signature)
            return convertSignature((org.hl7.fhir.dstu3.model.Signature) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Address)
            return convertAddress((org.hl7.fhir.dstu3.model.Address) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ContactDetail)
            return convertContactDetail((org.hl7.fhir.dstu3.model.ContactDetail) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.dstu3.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Contributor)
            return convertContributor((org.hl7.fhir.dstu3.model.Contributor) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Dosage)
            return convertDosage((org.hl7.fhir.dstu3.model.Dosage) src);
        if (src instanceof org.hl7.fhir.dstu3.model.HumanName)
            return convertHumanName((org.hl7.fhir.dstu3.model.HumanName) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Meta)
            return convertMeta((org.hl7.fhir.dstu3.model.Meta) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ParameterDefinition)
            return convertParameterDefinition((org.hl7.fhir.dstu3.model.ParameterDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.RelatedArtifact)
            return convertRelatedArtifact((org.hl7.fhir.dstu3.model.RelatedArtifact) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Timing)
            return convertTiming((org.hl7.fhir.dstu3.model.Timing) src);
        if (src instanceof org.hl7.fhir.dstu3.model.UsageContext)
            return convertUsageContext((org.hl7.fhir.dstu3.model.UsageContext) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ElementDefinition)
            return convertElementDefinition((org.hl7.fhir.dstu3.model.ElementDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DataRequirement)
            return convertDataRequirement((org.hl7.fhir.dstu3.model.DataRequirement) src);
        if (src instanceof org.hl7.fhir.dstu3.model.TriggerDefinition)
            return convertTriggerDefinition((org.hl7.fhir.dstu3.model.TriggerDefinition) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
        if (src == null)
            return null;
        if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.r5.model.BooleanType)
            return convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
        if (src instanceof org.hl7.fhir.r5.model.CodeType)
            return convertCode((org.hl7.fhir.r5.model.CodeType) src);
        if (src instanceof org.hl7.fhir.r5.model.DateType)
            return convertDate((org.hl7.fhir.r5.model.DateType) src);
        if (src instanceof org.hl7.fhir.r5.model.DateTimeType)
            return convertDateTime((org.hl7.fhir.r5.model.DateTimeType) src);
        if (src instanceof org.hl7.fhir.r5.model.DecimalType)
            return convertDecimal((org.hl7.fhir.r5.model.DecimalType) src);
        if (src instanceof org.hl7.fhir.r5.model.IdType)
            return convertId((org.hl7.fhir.r5.model.IdType) src);
        if (src instanceof org.hl7.fhir.r5.model.InstantType)
            return convertInstant((org.hl7.fhir.r5.model.InstantType) src);
        if (src instanceof org.hl7.fhir.r5.model.IntegerType)
            return convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.r5.model.Integer64Type)
            return convertInteger64((org.hl7.fhir.r5.model.Integer64Type) src);
        if (src instanceof org.hl7.fhir.r5.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.r5.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.r5.model.OidType)
            return convertOid((org.hl7.fhir.r5.model.OidType) src);
        if (src instanceof org.hl7.fhir.r5.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.r5.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.r5.model.StringType)
            return convertString((org.hl7.fhir.r5.model.StringType) src);
        if (src instanceof org.hl7.fhir.r5.model.TimeType)
            return convertTime((org.hl7.fhir.r5.model.TimeType) src);
        if (src instanceof org.hl7.fhir.r5.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.r5.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.r5.model.UriType)
            return convertUri((org.hl7.fhir.r5.model.UriType) src);
        if (src instanceof org.hl7.fhir.r5.model.UuidType)
            return convertUuid((org.hl7.fhir.r5.model.UuidType) src);
        if (src instanceof org.hl7.fhir.r5.model.Extension)
            return convertExtension((org.hl7.fhir.r5.model.Extension) src);
        if (src instanceof org.hl7.fhir.r5.model.Narrative)
            return convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
        if (src instanceof org.hl7.fhir.r5.model.Age)
            return convertAge((org.hl7.fhir.r5.model.Age) src);
        if (src instanceof org.hl7.fhir.r5.model.Annotation)
            return convertAnnotation((org.hl7.fhir.r5.model.Annotation) src);
        if (src instanceof org.hl7.fhir.r5.model.Attachment)
            return convertAttachment((org.hl7.fhir.r5.model.Attachment) src);
        if (src instanceof org.hl7.fhir.r5.model.CodeableConcept)
            return convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src);
        if (src instanceof org.hl7.fhir.r5.model.Coding)
            return convertCoding((org.hl7.fhir.r5.model.Coding) src);
        if (src instanceof org.hl7.fhir.r5.model.Count)
            return convertCount((org.hl7.fhir.r5.model.Count) src);
        if (src instanceof org.hl7.fhir.r5.model.Distance)
            return convertDistance((org.hl7.fhir.r5.model.Distance) src);
        if (src instanceof org.hl7.fhir.r5.model.Duration)
            return convertDuration((org.hl7.fhir.r5.model.Duration) src);
        if (src instanceof org.hl7.fhir.r5.model.Identifier)
            return convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
        if (src instanceof org.hl7.fhir.r5.model.Money)
            return convertMoney((org.hl7.fhir.r5.model.Money) src);
        if (src instanceof org.hl7.fhir.r5.model.Period)
            return convertPeriod((org.hl7.fhir.r5.model.Period) src);
        if (src instanceof org.hl7.fhir.r5.model.Quantity)
            return convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
        if (src instanceof org.hl7.fhir.r5.model.Range)
            return convertRange((org.hl7.fhir.r5.model.Range) src);
        if (src instanceof org.hl7.fhir.r5.model.Ratio)
            return convertRatio((org.hl7.fhir.r5.model.Ratio) src);
        if (src instanceof org.hl7.fhir.r5.model.Reference)
            return convertReference((org.hl7.fhir.r5.model.Reference) src);
        if (src instanceof org.hl7.fhir.r5.model.SampledData)
            return convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
        if (src instanceof org.hl7.fhir.r5.model.Signature)
            return convertSignature((org.hl7.fhir.r5.model.Signature) src);
        if (src instanceof org.hl7.fhir.r5.model.Address)
            return convertAddress((org.hl7.fhir.r5.model.Address) src);
        if (src instanceof org.hl7.fhir.r5.model.ContactDetail)
            return convertContactDetail((org.hl7.fhir.r5.model.ContactDetail) src);
        if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.r5.model.Contributor)
            return convertContributor((org.hl7.fhir.r5.model.Contributor) src);
        if (src instanceof org.hl7.fhir.r5.model.Dosage)
            return convertDosage((org.hl7.fhir.r5.model.Dosage) src);
        if (src instanceof org.hl7.fhir.r5.model.HumanName)
            return convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
        if (src instanceof org.hl7.fhir.r5.model.Meta)
            return convertMeta((org.hl7.fhir.r5.model.Meta) src);
        if (src instanceof org.hl7.fhir.r5.model.ParameterDefinition)
            return convertParameterDefinition((org.hl7.fhir.r5.model.ParameterDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.RelatedArtifact)
            return convertRelatedArtifact((org.hl7.fhir.r5.model.RelatedArtifact) src);
        if (src instanceof org.hl7.fhir.r5.model.Timing)
            return convertTiming((org.hl7.fhir.r5.model.Timing) src);
        if (src instanceof org.hl7.fhir.r5.model.UsageContext)
            return convertUsageContext((org.hl7.fhir.r5.model.UsageContext) src);
        if (src instanceof org.hl7.fhir.r5.model.ElementDefinition)
            return convertElementDefinition((org.hl7.fhir.r5.model.ElementDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.DataRequirement)
            return convertDataRequirement((org.hl7.fhir.r5.model.DataRequirement) src);
        if (src instanceof org.hl7.fhir.r5.model.TriggerDefinition)
            return convertTriggerDefinition((org.hl7.fhir.r5.model.TriggerDefinition) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    static public void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.dstu3.model.Resource t1 : src.getContained()) tgt.addContained(convertResource(t1, false));
        for (org.hl7.fhir.dstu3.model.Extension t2 : src.getExtension()) {
            if (!isExemptExtension(t2.getUrl(), extensionsToIgnore))
                tgt.addExtension(convertExtension(t2));
        }
        for (org.hl7.fhir.dstu3.model.Extension t3 : src.getModifierExtension()) {
            if (!isExemptExtension(t3.getUrl(), extensionsToIgnore))
                tgt.addModifierExtension(convertExtension(t3));
        }
    }

    static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
        boolean ok = false;
        for (String s : extensionsToIgnore) if (s.equals(url))
            ok = true;
        return ok;
    }

    static public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.dstu3.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.r5.model.Resource t1 : src.getContained()) tgt.addContained(convertResource(t1, false));
        for (org.hl7.fhir.r5.model.Extension t2 : src.getExtension()) {
            if (!isExemptExtension(t2.getUrl(), extensionsToIgnore))
                tgt.addExtension(convertExtension(t2));
        }
        for (org.hl7.fhir.r5.model.Extension t3 : src.getModifierExtension()) {
            if (!isExemptExtension(t3.getUrl(), extensionsToIgnore))
                tgt.addModifierExtension(convertExtension(t3));
        }
    }

    static public void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
        if (src.hasId())
            tgt.setIdElement(convertId(src.getIdElement()));
        if (src.hasMeta())
            tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    }

    static public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
        if (src.hasId())
            tgt.setIdElement(convertId(src.getIdElement()));
        if (src.hasMeta())
            tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.RETIRED);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.PublicationStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.RETIRED);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public CodeableReference convertReferenceToCodableReference(org.hl7.fhir.dstu3.model.Reference src) {
        CodeableReference tgt = new CodeableReference();
        tgt.setReference(convertReference(src));
        return tgt;
    }

    static public CodeableReference convertCodeableConceptToCodableReference(org.hl7.fhir.dstu3.model.CodeableConcept src) {
        CodeableReference tgt = new CodeableReference();
        tgt.setConcept(convertCodeableConcept(src));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.CanonicalType convertReferenceToCanonical(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
        org.hl7.fhir.r5.model.CanonicalType dst = new org.hl7.fhir.r5.model.CanonicalType(src.getReference());
        copyElement(src, dst);
        return dst;
    }

    static public org.hl7.fhir.dstu3.model.Reference convertCanonicalToReference(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.Reference dst = new org.hl7.fhir.dstu3.model.Reference(src.getValue());
        copyElement(src, dst);
        return dst;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NUMBER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NUMBER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.DATE);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.STRING);
                break;
            case TOKEN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.TOKEN);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.REFERENCE);
                break;
            case COMPOSITE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.COMPOSITE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.QUANTITY);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.URI);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NUMBER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.NUMBER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.DATE);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.STRING);
                break;
            case TOKEN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.TOKEN);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.REFERENCE);
                break;
            case COMPOSITE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.COMPOSITE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.QUANTITY);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.URI);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator> convertFilterOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CodeSystem.FilterOperatorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.ISA);
                break;
            case DESCENDENTOF:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.DESCENDENTOF);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.NOTIN);
                break;
            case GENERALIZES:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.GENERALIZES);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.EXISTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent();
        copyElement(src, tgt);
        if (src.hasAuthority())
            tgt.setAuthorityElement(convertUri(src.getAuthorityElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent();
        copyElement(src, tgt);
        if (src.hasAuthority())
            tgt.setAuthorityElement(convertUri(src.getAuthorityElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Consent.ConsentDataMeaningEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.INSTANCE);
                break;
            case RELATED:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.RELATED);
                break;
            case DEPENDENTS:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.DEPENDENTS);
                break;
            case AUTHOREDBY:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.AUTHOREDBY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaningEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.INSTANCE);
                break;
            case RELATED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.RELATED);
                break;
            case DEPENDENTS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.DEPENDENTS);
                break;
            case AUTHOREDBY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.AUTHOREDBY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent();
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasRef())
            tgt.setRef(convertReference(src.getRef()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent();
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasRef())
            tgt.setRef(convertReference(src.getRef()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REPLACES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.REPLACES);
                break;
            case TRANSFORMS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.TRANSFORMS);
                break;
            case SIGNS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.SIGNS);
                break;
            case APPENDS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.APPENDS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.Encounter.DiagnosisComponent();
        copyElement(src, tgt);
        if (src.hasCondition())
            tgt.setCondition(convertReference(src.getCondition()));
        if (src.hasRole())
            tgt.setUse(convertCodeableConcept(src.getRole()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.Encounter.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent();
        copyElement(src, tgt);
        if (src.hasCondition())
            tgt.setCondition(convertReference(src.getCondition()));
        if (src.hasUse())
            tgt.setRole(convertCodeableConcept(src.getUse()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.dstu3.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent();
        copyElement(src, tgt);
        if (src.hasCondition())
            tgt.setCondition(convertReference(src.getCondition()));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.dstu3.model.EpisodeOfCare.DiagnosisComponent();
        copyElement(src, tgt);
        if (src.hasCondition())
            tgt.setCondition(convertReference(src.getCondition()));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.AdministrativeGenderEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MALE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.MALE);
                break;
            case FEMALE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.FEMALE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.OTHER);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGenderEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MALE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.MALE);
                break;
            case FEMALE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.OTHER);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.NULL);
                break;
        }
        return tgt;
    }

    private static final String CODE_SYSTEM_MEDIA_TYPE = "http://terminology.hl7.org/CodeSystem/media-type";

    public static String convertCoding2Uri(org.hl7.fhir.dstu3.model.Coding code) {
        return code.getSystem() + "/" + code.getCode();
    }

    public static org.hl7.fhir.dstu3.model.Coding convertUri2Coding(String uri) {
        int i = uri.lastIndexOf("/");
        return new org.hl7.fhir.dstu3.model.Coding().setSystem(uri.substring(0, i)).setCode(uri.substring(i + 1));
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MON:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON);
                break;
            case TUE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE);
                break;
            case WED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED);
                break;
            case THU:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU);
                break;
            case FRI:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI);
                break;
            case SAT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT);
                break;
            case SUN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Provenance convertProvenance(org.hl7.fhir.dstu3.model.Provenance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Provenance tgt = new org.hl7.fhir.r5.model.Provenance();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Reference t : src.getTarget()) tgt.addTarget(convertReference(t));
        if (src.hasPeriod())
            tgt.setOccurred(convertPeriod(src.getPeriod()));
        if (src.hasRecorded())
            tgt.setRecordedElement(convertInstant(src.getRecordedElement()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getReason()) tgt.addReason(convertCodingToCodeableConcept(t));
        if (src.hasActivity())
            tgt.setActivity(convertCodingToCodeableConcept(src.getActivity()));
        for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent t : src.getEntity()) tgt.addEntity(convertProvenanceEntityComponent(t));
        for (org.hl7.fhir.dstu3.model.Signature t : src.getSignature()) tgt.addSignature(convertSignature(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance convertProvenance(org.hl7.fhir.r5.model.Provenance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Provenance tgt = new org.hl7.fhir.dstu3.model.Provenance();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Reference t : src.getTarget()) tgt.addTarget(convertReference(t));
        if (src.hasOccurredPeriod())
            tgt.setPeriod(convertPeriod(src.getOccurredPeriod()));
        if (src.hasRecorded())
            tgt.setRecordedElement(convertInstant(src.getRecordedElement()));
        for (org.hl7.fhir.r5.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason()) for (org.hl7.fhir.r5.model.Coding tc : t.getCoding()) tgt.addReason(convertCoding(tc));
        if (src.hasActivity())
            tgt.setActivity(convertCoding(src.getActivity()));
        for (org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        for (org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent t : src.getEntity()) tgt.addEntity(convertProvenanceEntityComponent(t));
        for (org.hl7.fhir.r5.model.Signature t : src.getSignature()) tgt.addSignature(convertSignature(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(convertCodeableConcept(t));
        if (src.hasWho()) {
            DataType t = convertType(src.getWho());
            if (t instanceof Reference)
                tgt.setWho((Reference) t);
            if (t instanceof UriType)
                tgt.getWho().setReference(t.primitiveValue());
        }
        if (src.hasOnBehalfOf()) {
            DataType t = convertType(src.getOnBehalfOf());
            if (t instanceof Reference)
                tgt.setOnBehalfOf((Reference) t);
            if (t instanceof UriType)
                tgt.getOnBehalfOf().setReference(t.primitiveValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRole()) tgt.addRole(convertCodeableConcept(t));
        if (src.hasWho())
            tgt.setWho(convertType(src.getWho()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(convertType(src.getOnBehalfOf()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent();
        copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRoleElement(convertProvenanceEntityRole(src.getRoleElement()));
        if (src.hasWhat()) {
            DataType t = convertType(src.getWhat());
            if (t instanceof Reference)
                tgt.setWhat((Reference) t);
            else if (t instanceof Identifier)
                tgt.getWhat().setIdentifier((Identifier) t);
            else if (t instanceof UriType)
                tgt.getWhat().setReference(t.primitiveValue());
        }
        for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent();
        copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRoleElement(convertProvenanceEntityRole(src.getRoleElement()));
        if (src.hasWhat())
            tgt.setWhat(convertType(src.getWhat()));
        for (org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole> convertProvenanceEntityRole(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRoleEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DERIVATION:
                tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.DERIVATION);
                break;
            case REVISION:
                tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.REVISION);
                break;
            case QUOTATION:
                tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.QUOTATION);
                break;
            case SOURCE:
                tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.SOURCE);
                break;
            case REMOVAL:
                tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.REMOVAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole> convertProvenanceEntityRole(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRoleEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DERIVATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.DERIVATION);
                break;
            case REVISION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.REVISION);
                break;
            case QUOTATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.QUOTATION);
                break;
            case SOURCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.SOURCE);
                break;
            case REMOVAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.REMOVAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestReport.SetupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertUri(src.getDetailElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertUri(src.getDetailElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportActionResultEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PASS:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.PASS);
                break;
            case SKIP:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.SKIP);
                break;
            case FAIL:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.FAIL);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.WARNING);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.ERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportActionResultEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PASS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.PASS);
                break;
            case SKIP:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.SKIP);
                break;
            case FAIL:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.FAIL);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.WARNING);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.ERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertString(src.getDetailElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertString(src.getDetailElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestReport.TestActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestReport.TestActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestReport.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestScript.SetupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasResource())
            tgt.setResource(org.hl7.fhir.r5.model.TestScript.FHIRDefinedType.fromCode(src.getResource()));
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasAccept())
            tgt.setAccept(convertContentType(src.getAccept()));
        if (src.hasContentType())
            tgt.setContentType(convertContentType(src.getContentType()));
        if (src.hasDestination())
            tgt.setDestinationElement(convertInteger(src.getDestinationElement()));
        if (src.hasEncodeRequestUrl())
            tgt.setEncodeRequestUrlElement(convertBoolean(src.getEncodeRequestUrlElement()));
        if (src.hasOrigin())
            tgt.setOriginElement(convertInteger(src.getOriginElement()));
        if (src.hasParams())
            tgt.setParamsElement(convertString(src.getParamsElement()));
        for (org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        if (src.hasRequestId())
            tgt.setRequestIdElement(convertId(src.getRequestIdElement()));
        if (src.hasResponseId())
            tgt.setResponseIdElement(convertId(src.getResponseIdElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasTargetId())
            tgt.setTargetId(src.getTargetId());
        if (src.hasUrl())
            tgt.setUrlElement(convertString(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasResource())
            tgt.setResource(src.getResource().toCode());
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasAccept())
            tgt.setAccept(convertContentType(src.getAccept()));
        if (src.hasContentType())
            tgt.setContentType(convertContentType(src.getContentType()));
        if (src.hasDestination())
            tgt.setDestinationElement(convertInteger(src.getDestinationElement()));
        if (src.hasEncodeRequestUrl())
            tgt.setEncodeRequestUrlElement(convertBoolean(src.getEncodeRequestUrlElement()));
        if (src.hasOrigin())
            tgt.setOriginElement(convertInteger(src.getOriginElement()));
        if (src.hasParams())
            tgt.setParamsElement(convertString(src.getParamsElement()));
        for (org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        if (src.hasRequestId())
            tgt.setRequestIdElement(convertId(src.getRequestIdElement()));
        if (src.hasResponseId())
            tgt.setResponseIdElement(convertId(src.getResponseIdElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasTargetId())
            tgt.setTargetId(src.getTargetId());
        if (src.hasUrl())
            tgt.setUrlElement(convertString(src.getUrlElement()));
        return tgt;
    }

    static public String convertContentType(org.hl7.fhir.dstu3.model.TestScript.ContentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XML:
                return "application/fhir+xml";
            case JSON:
                return "application/fhir+json";
            case TTL:
                return "text/turtle";
            case NONE:
                return null;
            default:
                return null;
        }
    }

    static public org.hl7.fhir.dstu3.model.TestScript.ContentType convertContentType(String src) throws FHIRException {
        if (src == null)
            return null;
        if (src.contains("xml"))
            return org.hl7.fhir.dstu3.model.TestScript.ContentType.XML;
        if (src.contains("json"))
            return org.hl7.fhir.dstu3.model.TestScript.ContentType.JSON;
        if (src.contains("tu"))
            return org.hl7.fhir.dstu3.model.TestScript.ContentType.TTL;
        return org.hl7.fhir.dstu3.model.TestScript.ContentType.NONE;
    }

    public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent();
        copyElement(src, tgt);
        if (src.hasField())
            tgt.setFieldElement(convertString(src.getFieldElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent();
        copyElement(src, tgt);
        if (src.hasField())
            tgt.setFieldElement(convertString(src.getFieldElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasDirection())
            tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
        if (src.hasCompareToSourceId())
            tgt.setCompareToSourceIdElement(convertString(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourceExpression())
            tgt.setCompareToSourceExpressionElement(convertString(src.getCompareToSourceExpressionElement()));
        if (src.hasCompareToSourcePath())
            tgt.setCompareToSourcePathElement(convertString(src.getCompareToSourcePathElement()));
        if (src.hasContentType())
            tgt.setContentType(convertContentType(src.getContentType()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(convertString(src.getHeaderFieldElement()));
        if (src.hasMinimumId())
            tgt.setMinimumIdElement(convertString(src.getMinimumIdElement()));
        if (src.hasNavigationLinks())
            tgt.setNavigationLinksElement(convertBoolean(src.getNavigationLinksElement()));
        if (src.hasOperator())
            tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasRequestMethod())
            tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
        if (src.hasRequestURL())
            tgt.setRequestURLElement(convertString(src.getRequestURLElement()));
        if (src.hasResource())
            tgt.setResource(org.hl7.fhir.r5.model.TestScript.FHIRDefinedType.fromCode(src.getResource()));
        if (src.hasResponse())
            tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
        if (src.hasResponseCode())
            tgt.setResponseCodeElement(convertString(src.getResponseCodeElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasValidateProfileId())
            tgt.setValidateProfileIdElement(convertId(src.getValidateProfileIdElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasWarningOnly())
            tgt.setWarningOnlyElement(convertBoolean(src.getWarningOnlyElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasDirection())
            tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
        if (src.hasCompareToSourceId())
            tgt.setCompareToSourceIdElement(convertString(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourceExpression())
            tgt.setCompareToSourceExpressionElement(convertString(src.getCompareToSourceExpressionElement()));
        if (src.hasCompareToSourcePath())
            tgt.setCompareToSourcePathElement(convertString(src.getCompareToSourcePathElement()));
        if (src.hasContentType())
            tgt.setContentType(convertContentType(src.getContentType()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(convertString(src.getHeaderFieldElement()));
        if (src.hasMinimumId())
            tgt.setMinimumIdElement(convertString(src.getMinimumIdElement()));
        if (src.hasNavigationLinks())
            tgt.setNavigationLinksElement(convertBoolean(src.getNavigationLinksElement()));
        if (src.hasOperator())
            tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasRequestMethod())
            tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
        if (src.hasRequestURL())
            tgt.setRequestURLElement(convertString(src.getRequestURLElement()));
        if (src.hasResource())
            tgt.setResource(src.getResource().toCode());
        if (src.hasResponse())
            tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
        if (src.hasResponseCode())
            tgt.setResponseCodeElement(convertString(src.getResponseCodeElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasValidateProfileId())
            tgt.setValidateProfileIdElement(convertId(src.getValidateProfileIdElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasWarningOnly())
            tgt.setWarningOnlyElement(convertBoolean(src.getWarningOnlyElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionDirectionTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case RESPONSE:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.RESPONSE);
                break;
            case REQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.REQUEST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case RESPONSE:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.RESPONSE);
                break;
            case REQUEST:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.REQUEST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionOperatorTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUALS:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EQUALS);
                break;
            case NOTEQUALS:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEQUALS);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTIN);
                break;
            case GREATERTHAN:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.GREATERTHAN);
                break;
            case LESSTHAN:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.LESSTHAN);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EMPTY);
                break;
            case NOTEMPTY:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEMPTY);
                break;
            case CONTAINS:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.CONTAINS);
                break;
            case NOTCONTAINS:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTCONTAINS);
                break;
            case EVAL:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EVAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUALS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EQUALS);
                break;
            case NOTEQUALS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEQUALS);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTIN);
                break;
            case GREATERTHAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.GREATERTHAN);
                break;
            case LESSTHAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.LESSTHAN);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EMPTY);
                break;
            case NOTEMPTY:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEMPTY);
                break;
            case CONTAINS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.CONTAINS);
                break;
            case NOTCONTAINS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTCONTAINS);
                break;
            case EVAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EVAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DELETE:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.DELETE);
                break;
            case GET:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.GET);
                break;
            case OPTIONS:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
                break;
            case PATCH:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.PATCH);
                break;
            case POST:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.POST);
                break;
            case PUT:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.PUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DELETE:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.DELETE);
                break;
            case GET:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.GET);
                break;
            case OPTIONS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
                break;
            case PATCH:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.PATCH);
                break;
            case POST:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.POST);
                break;
            case PUT:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.PUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionResponseTypesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case OKAY:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.OKAY);
                break;
            case CREATED:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CREATED);
                break;
            case NOCONTENT:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOCONTENT);
                break;
            case NOTMODIFIED:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
                break;
            case BAD:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.BAD);
                break;
            case FORBIDDEN:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.FORBIDDEN);
                break;
            case NOTFOUND:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTFOUND);
                break;
            case METHODNOTALLOWED:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
                break;
            case CONFLICT:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CONFLICT);
                break;
            case GONE:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.GONE);
                break;
            case PRECONDITIONFAILED:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
                break;
            case UNPROCESSABLE:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case OKAY:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.OKAY);
                break;
            case CREATED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CREATED);
                break;
            case NOCONTENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOCONTENT);
                break;
            case NOTMODIFIED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
                break;
            case BAD:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.BAD);
                break;
            case FORBIDDEN:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.FORBIDDEN);
                break;
            case NOTFOUND:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTFOUND);
                break;
            case METHODNOTALLOWED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
                break;
            case CONFLICT:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CONFLICT);
                break;
            case GONE:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.GONE);
                break;
            case PRECONDITIONFAILED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
                break;
            case UNPROCESSABLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestScript.TestActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestScript.TestActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA);
                break;
            case DESCENDENTOF:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.DESCENDENTOF);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN);
                break;
            case GENERALIZES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.GENERALIZES);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EXISTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src, boolean nullOk) throws FHIRException {
        if (src == null)
            return null;
        if (src instanceof org.hl7.fhir.dstu3.model.Parameters)
            return Parameters30_50.convertParameters((org.hl7.fhir.dstu3.model.Parameters) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ActivityDefinition)
            return ActivityDefinition30_50.convertActivityDefinition((org.hl7.fhir.dstu3.model.ActivityDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.AllergyIntolerance)
            return AllergyIntolerance30_50.convertAllergyIntolerance((org.hl7.fhir.dstu3.model.AllergyIntolerance) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Appointment)
            return Appointment30_50.convertAppointment((org.hl7.fhir.dstu3.model.Appointment) src);
        if (src instanceof org.hl7.fhir.dstu3.model.AppointmentResponse)
            return AppointmentResponse30_50.convertAppointmentResponse((org.hl7.fhir.dstu3.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.dstu3.model.AuditEvent)
            return AuditEvent30_50.convertAuditEvent((org.hl7.fhir.dstu3.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Basic)
            return Basic30_50.convertBasic((org.hl7.fhir.dstu3.model.Basic) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Binary)
            return Binary30_50.convertBinary((org.hl7.fhir.dstu3.model.Binary) src);
        if (src instanceof org.hl7.fhir.dstu3.model.BodySite)
            return BodySite30_50.convertBodySite((org.hl7.fhir.dstu3.model.BodySite) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Bundle)
            return Bundle30_50.convertBundle((org.hl7.fhir.dstu3.model.Bundle) src);
        if (src instanceof org.hl7.fhir.dstu3.model.CapabilityStatement)
            return CapabilityStatement30_50.convertCapabilityStatement((org.hl7.fhir.dstu3.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.dstu3.model.CarePlan)
            return CarePlan30_50.convertCarePlan((org.hl7.fhir.dstu3.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.dstu3.model.CareTeam)
            return CareTeam30_50.convertCareTeam((org.hl7.fhir.dstu3.model.CareTeam) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ClinicalImpression)
            return ClinicalImpression30_50.convertClinicalImpression((org.hl7.fhir.dstu3.model.ClinicalImpression) src);
        if (src instanceof org.hl7.fhir.dstu3.model.CodeSystem)
            return CodeSystem30_50.convertCodeSystem((org.hl7.fhir.dstu3.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Communication)
            return Communication30_50.convertCommunication((org.hl7.fhir.dstu3.model.Communication) src);
        if (src instanceof org.hl7.fhir.dstu3.model.CompartmentDefinition)
            return CompartmentDefinition30_50.convertCompartmentDefinition((org.hl7.fhir.dstu3.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Composition)
            return Composition30_50.convertComposition((org.hl7.fhir.dstu3.model.Composition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ConceptMap)
            return ConceptMap30_50.convertConceptMap((org.hl7.fhir.dstu3.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Condition)
            return Condition30_50.convertCondition((org.hl7.fhir.dstu3.model.Condition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Consent)
            return Consent30_50.convertConsent((org.hl7.fhir.dstu3.model.Consent) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DataElement)
            return DataElement30_50.convertDataElement((org.hl7.fhir.dstu3.model.DataElement) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DetectedIssue)
            return DetectedIssue30_50.convertDetectedIssue((org.hl7.fhir.dstu3.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DeviceUseStatement)
            return DeviceUseStatement30_50.convertDeviceUseStatement((org.hl7.fhir.dstu3.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DiagnosticReport)
            return DiagnosticReport30_50.convertDiagnosticReport((org.hl7.fhir.dstu3.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.dstu3.model.DocumentReference)
            return DocumentReference30_50.convertDocumentReference((org.hl7.fhir.dstu3.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Encounter)
            return Encounter30_50.convertEncounter((org.hl7.fhir.dstu3.model.Encounter) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Endpoint)
            return Endpoint30_50.convertEndpoint((org.hl7.fhir.dstu3.model.Endpoint) src);
        if (src instanceof org.hl7.fhir.dstu3.model.EpisodeOfCare)
            return EpisodeOfCare30_50.convertEpisodeOfCare((org.hl7.fhir.dstu3.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ExpansionProfile)
            return ExpansionProfile30_50.convertExpansionProfile((org.hl7.fhir.dstu3.model.ExpansionProfile) src);
        if (src instanceof org.hl7.fhir.dstu3.model.FamilyMemberHistory)
            return FamilyMemberHistory30_50.convertFamilyMemberHistory((org.hl7.fhir.dstu3.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Flag)
            return Flag30_50.convertFlag((org.hl7.fhir.dstu3.model.Flag) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Goal)
            return Goal30_50.convertGoal((org.hl7.fhir.dstu3.model.Goal) src);
        if (src instanceof org.hl7.fhir.dstu3.model.GraphDefinition)
            return GraphDefinition30_50.convertGraphDefinition((org.hl7.fhir.dstu3.model.GraphDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Group)
            return Group30_50.convertGroup((org.hl7.fhir.dstu3.model.Group) src);
        if (src instanceof org.hl7.fhir.dstu3.model.HealthcareService)
            return HealthcareService30_50.convertHealthcareService((org.hl7.fhir.dstu3.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ImagingStudy)
            return ImagingStudy30_50.convertImagingStudy((org.hl7.fhir.dstu3.model.ImagingStudy) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Immunization)
            return Immunization30_50.convertImmunization((org.hl7.fhir.dstu3.model.Immunization) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ImplementationGuide)
            return ImplementationGuide30_50.convertImplementationGuide((org.hl7.fhir.dstu3.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Library)
            return Library30_50.convertLibrary((org.hl7.fhir.dstu3.model.Library) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Linkage)
            return Linkage30_50.convertLinkage((org.hl7.fhir.dstu3.model.Linkage) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ListResource)
            return List30_50.convertList((org.hl7.fhir.dstu3.model.ListResource) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Location)
            return Location30_50.convertLocation((org.hl7.fhir.dstu3.model.Location) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Measure)
            return Measure30_50.convertMeasure((org.hl7.fhir.dstu3.model.Measure) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Media)
            return Media30_50.convertMedia((org.hl7.fhir.dstu3.model.Media) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Medication)
            return Medication30_50.convertMedication((org.hl7.fhir.dstu3.model.Medication) src);
        if (src instanceof org.hl7.fhir.dstu3.model.MedicationAdministration)
            return MedicationAdministration30_50.convertMedicationAdministration((org.hl7.fhir.dstu3.model.MedicationAdministration) src);
        if (src instanceof org.hl7.fhir.dstu3.model.MedicationDispense)
            return MedicationDispense30_50.convertMedicationDispense((org.hl7.fhir.dstu3.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.dstu3.model.MedicationRequest)
            return MedicationRequest30_50.convertMedicationRequest((org.hl7.fhir.dstu3.model.MedicationRequest) src);
        if (src instanceof org.hl7.fhir.dstu3.model.MedicationStatement)
            return MedicationStatement30_50.convertMedicationStatement((org.hl7.fhir.dstu3.model.MedicationStatement) src);
        if (src instanceof org.hl7.fhir.dstu3.model.MessageDefinition)
            return MessageDefinition30_50.convertMessageDefinition((org.hl7.fhir.dstu3.model.MessageDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.MessageHeader)
            return MessageHeader30_50.convertMessageHeader((org.hl7.fhir.dstu3.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.dstu3.model.NamingSystem)
            return NamingSystem30_50.convertNamingSystem((org.hl7.fhir.dstu3.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Observation)
            return Observation30_50.convertObservation((org.hl7.fhir.dstu3.model.Observation) src);
        if (src instanceof org.hl7.fhir.dstu3.model.OperationDefinition)
            return OperationDefinition30_50.convertOperationDefinition((org.hl7.fhir.dstu3.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.OperationOutcome)
            return OperationOutcome30_50.convertOperationOutcome((org.hl7.fhir.dstu3.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Organization)
            return Organization30_50.convertOrganization((org.hl7.fhir.dstu3.model.Organization) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Patient)
            return Patient30_50.convertPatient((org.hl7.fhir.dstu3.model.Patient) src);
        if (src instanceof org.hl7.fhir.dstu3.model.PaymentNotice)
            return PaymentNotice30_50.convertPaymentNotice((org.hl7.fhir.dstu3.model.PaymentNotice) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Person)
            return Person30_50.convertPerson((org.hl7.fhir.dstu3.model.Person) src);
        if (src instanceof org.hl7.fhir.dstu3.model.PlanDefinition)
            return PlanDefinition30_50.convertPlanDefinition((org.hl7.fhir.dstu3.model.PlanDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Practitioner)
            return Practitioner30_50.convertPractitioner((org.hl7.fhir.dstu3.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.dstu3.model.PractitionerRole)
            return PractitionerRole30_50.convertPractitionerRole((org.hl7.fhir.dstu3.model.PractitionerRole) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Provenance)
          return Provenance30_50.convertProvenance((org.hl7.fhir.dstu3.model.Provenance) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Questionnaire)
            return Questionnaire30_50.convertQuestionnaire((org.hl7.fhir.dstu3.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.dstu3.model.QuestionnaireResponse)
            return QuestionnaireResponse30_50.convertQuestionnaireResponse((org.hl7.fhir.dstu3.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.dstu3.model.RelatedPerson)
            return RelatedPerson30_50.convertRelatedPerson((org.hl7.fhir.dstu3.model.RelatedPerson) src);
        if (src instanceof org.hl7.fhir.dstu3.model.RiskAssessment)
            return RiskAssessment30_50.convertRiskAssessment((org.hl7.fhir.dstu3.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Schedule)
            return Schedule30_50.convertSchedule((org.hl7.fhir.dstu3.model.Schedule) src);
        if (src instanceof org.hl7.fhir.dstu3.model.SearchParameter)
            return SearchParameter30_50.convertSearchParameter((org.hl7.fhir.dstu3.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Sequence)
            return Sequence30_50.convertSequence((org.hl7.fhir.dstu3.model.Sequence) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Slot)
            return Slot30_50.convertSlot((org.hl7.fhir.dstu3.model.Slot) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Specimen)
            return Specimen30_50.convertSpecimen((org.hl7.fhir.dstu3.model.Specimen) src);
        if (src instanceof org.hl7.fhir.dstu3.model.StructureDefinition)
            return StructureDefinition30_50.convertStructureDefinition((org.hl7.fhir.dstu3.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.dstu3.model.StructureMap)
            return StructureMap30_50.convertStructureMap((org.hl7.fhir.dstu3.model.StructureMap) src);
        if (src instanceof org.hl7.fhir.dstu3.model.Substance)
            return Substance30_50.convertSubstance((org.hl7.fhir.dstu3.model.Substance) src);
        if (src instanceof org.hl7.fhir.dstu3.model.SupplyDelivery)
            return SupplyDelivery30_50.convertSupplyDelivery((org.hl7.fhir.dstu3.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.dstu3.model.TestReport)
            return TestReport30_50.convertTestReport((org.hl7.fhir.dstu3.model.TestReport) src);
        if (src instanceof org.hl7.fhir.dstu3.model.TestScript)
            return TestScript30_50.convertTestScript((org.hl7.fhir.dstu3.model.TestScript) src);
        if (src instanceof org.hl7.fhir.dstu3.model.ValueSet)
            return ValueSet30_50.convertValueSet((org.hl7.fhir.dstu3.model.ValueSet) src);
        if (!nullOk)
            throw new FHIRException("Unknown resource " + src.fhirType());
        else
            return null;
    }

    public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src, boolean nullOk) throws FHIRException {
        if (src == null)
            return null;
        if (src instanceof org.hl7.fhir.r5.model.Parameters) {
            if (((org.hl7.fhir.r5.model.Parameters) src).hasParameter("profile-url"))
                return ExpansionProfile30_50.convertExpansionProfile((org.hl7.fhir.r5.model.Parameters) src);
            else
                return Parameters30_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
        }
        if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
            return ActivityDefinition30_50.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
            return AllergyIntolerance30_50.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
        if (src instanceof org.hl7.fhir.r5.model.Appointment)
            return Appointment30_50.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
        if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
            return AppointmentResponse30_50.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
            return AuditEvent30_50.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.r5.model.Basic)
            return Basic30_50.convertBasic((org.hl7.fhir.r5.model.Basic) src);
        if (src instanceof org.hl7.fhir.r5.model.Binary)
            return Binary30_50.convertBinary((org.hl7.fhir.r5.model.Binary) src);
        if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
            return BodySite30_50.convertBodySite((org.hl7.fhir.r5.model.BodyStructure) src);
        if (src instanceof org.hl7.fhir.r5.model.Bundle)
            return Bundle30_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
        if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
            return CapabilityStatement30_50.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.r5.model.CarePlan)
            return CarePlan30_50.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.r5.model.CareTeam)
            return CareTeam30_50.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
        if (src instanceof org.hl7.fhir.r5.model.ClinicalImpression)
            return ClinicalImpression30_50.convertClinicalImpression((org.hl7.fhir.r5.model.ClinicalImpression) src);
        if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
            return CodeSystem30_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.r5.model.Communication)
            return Communication30_50.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
        if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
            return CompartmentDefinition30_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.Composition)
            return Composition30_50.convertComposition((org.hl7.fhir.r5.model.Composition) src);
        if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
            return ConceptMap30_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.r5.model.Condition)
            return Condition30_50.convertCondition((org.hl7.fhir.r5.model.Condition) src);
        if (src instanceof org.hl7.fhir.r5.model.Consent)
            return Consent30_50.convertConsent((org.hl7.fhir.r5.model.Consent) src);
        if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
            return DetectedIssue30_50.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.r5.model.DeviceUseStatement)
            return DeviceUseStatement30_50.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
            return DiagnosticReport30_50.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
            return DocumentReference30_50.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.r5.model.Encounter)
            return Encounter30_50.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
        if (src instanceof org.hl7.fhir.r5.model.Endpoint)
            return Endpoint30_50.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
        if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
            return EpisodeOfCare30_50.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
            return FamilyMemberHistory30_50.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.r5.model.Flag)
            return Flag30_50.convertFlag((org.hl7.fhir.r5.model.Flag) src);
        if (src instanceof org.hl7.fhir.r5.model.Goal)
            return Goal30_50.convertGoal((org.hl7.fhir.r5.model.Goal) src);
        if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
            return GraphDefinition30_50.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.Group)
            return Group30_50.convertGroup((org.hl7.fhir.r5.model.Group) src);
        if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
            return HealthcareService30_50.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
            return ImagingStudy30_50.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
        if (src instanceof org.hl7.fhir.r5.model.Immunization)
            return Immunization30_50.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
        if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
            return ImplementationGuide30_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.r5.model.Library)
            return Library30_50.convertLibrary((org.hl7.fhir.r5.model.Library) src);
        if (src instanceof org.hl7.fhir.r5.model.Linkage)
            return Linkage30_50.convertLinkage((org.hl7.fhir.r5.model.Linkage) src);
        if (src instanceof org.hl7.fhir.r5.model.ListResource)
            return List30_50.convertList((org.hl7.fhir.r5.model.ListResource) src);
        if (src instanceof org.hl7.fhir.r5.model.Location)
            return Location30_50.convertLocation((org.hl7.fhir.r5.model.Location) src);
        if (src instanceof org.hl7.fhir.r5.model.Measure)
            return Measure30_50.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
        if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
            return Media30_50.convertMedia((org.hl7.fhir.r5.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.r5.model.Medication)
            return Medication30_50.convertMedication((org.hl7.fhir.r5.model.Medication) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
            return MedicationAdministration30_50.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
            return MedicationDispense30_50.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
            return MedicationRequest30_50.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationUsage)
            return MedicationStatement30_50.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationUsage) src);
        if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
            return MessageDefinition30_50.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
            return MessageHeader30_50.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
            return NamingSystem30_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.r5.model.Observation)
            return Observation30_50.convertObservation((org.hl7.fhir.r5.model.Observation) src);
        if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
            return OperationDefinition30_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
            return OperationOutcome30_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.r5.model.Organization)
            return Organization30_50.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
        if (src instanceof org.hl7.fhir.r5.model.Patient)
            return Patient30_50.convertPatient((org.hl7.fhir.r5.model.Patient) src);
        if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
            return PaymentNotice30_50.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
        if (src instanceof org.hl7.fhir.r5.model.Person)
            return Person30_50.convertPerson((org.hl7.fhir.r5.model.Person) src);
        if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
            return PlanDefinition30_50.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.Practitioner)
            return Practitioner30_50.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
            return PractitionerRole30_50.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
        if (src instanceof org.hl7.fhir.r5.model.Provenance)
          return Provenance30_50.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
        if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
            return Questionnaire30_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
            return QuestionnaireResponse30_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
            return RelatedPerson30_50.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
        if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
            return RiskAssessment30_50.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.r5.model.Schedule)
            return Schedule30_50.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
        if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
            return SearchParameter30_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.r5.model.MolecularSequence)
            return Sequence30_50.convertSequence((org.hl7.fhir.r5.model.MolecularSequence) src);
        if (src instanceof org.hl7.fhir.r5.model.Slot)
            return Slot30_50.convertSlot((org.hl7.fhir.r5.model.Slot) src);
        if (src instanceof org.hl7.fhir.r5.model.Specimen)
            return Specimen30_50.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
        if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
            return StructureDefinition30_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.StructureMap)
            return StructureMap30_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
        if (src instanceof org.hl7.fhir.r5.model.Substance)
            return Substance30_50.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
        if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
            return SupplyDelivery30_50.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.r5.model.TestReport)
            return TestReport30_50.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
        if (src instanceof org.hl7.fhir.r5.model.TestScript)
            return TestScript30_50.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
        if (src instanceof org.hl7.fhir.r5.model.ValueSet)
            return ValueSet30_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
        if (!nullOk)
            throw new FHIRException("Unknown resource " + src.fhirType());
        else
            return null;
    }

    public static TerminologyCapabilities convertTerminologyCapabilities(Parameters src, boolean b) {
        TerminologyCapabilities res = new TerminologyCapabilities();
        for (ParametersParameterComponent p : src.getParameter()) {
            if (p.getName().equals("system"))
                res.addCodeSystem().setUri(p.getValue().primitiveValue());
        }
        return res;
    }

    public static boolean convertsResource(String rt) {
        return Utilities.existsInList(rt, "Parameters", "ActivityDefinition", "AllergyIntolerance", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodyStructure", "Bundle", "CapabilityStatement", "CarePlan", "CareTeam", "ClinicalImpression", "CodeSystem", "Communication", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Consent", "DetectedIssue", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "Endpoint", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Goal", "GraphDefinition", "Group", "HealthcareService", "ImagingStudy", "Immunization", "ImplementationGuide", "Library", "Linkage", "ListResource", "Location", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationRequest", "MedicationStatement", "MessageDefinition", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "PaymentNotice", "Person", "PlanDefinition", "Practitioner", "PractitionerRole", "ProcessRequest", "Questionnaire", "QuestionnaireResponse", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "Slot", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "TestReport", "TestScript", "ValueSet");
    }
}