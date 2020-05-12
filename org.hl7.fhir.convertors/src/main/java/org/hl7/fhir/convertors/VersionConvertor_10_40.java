package org.hl7.fhir.convertors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.convertors.conv10_40.Appointment10_40;
import org.hl7.fhir.convertors.conv10_40.AppointmentResponse10_40;
import org.hl7.fhir.convertors.conv10_40.AuditEvent10_40;
import org.hl7.fhir.convertors.conv10_40.Basic10_40;
import org.hl7.fhir.convertors.conv10_40.Binary10_40;
import org.hl7.fhir.convertors.conv10_40.Bundle10_40;
import org.hl7.fhir.convertors.conv10_40.CarePlan10_40;
import org.hl7.fhir.convertors.conv10_40.Communication10_40;
import org.hl7.fhir.convertors.conv10_40.CommunicationRequest10_40;
import org.hl7.fhir.convertors.conv10_40.Composition10_40;
import org.hl7.fhir.convertors.conv10_40.ConceptMap10_40;
import org.hl7.fhir.convertors.conv10_40.Condition10_40;
import org.hl7.fhir.convertors.conv10_40.Conformance10_40;
import org.hl7.fhir.convertors.conv10_40.DataElement10_40;
import org.hl7.fhir.convertors.conv10_40.DetectedIssue10_40;
import org.hl7.fhir.convertors.conv10_40.DeviceMetric10_40;
import org.hl7.fhir.convertors.conv10_40.DeviceUseStatement10_40;
import org.hl7.fhir.convertors.conv10_40.DiagnosticReport10_40;
import org.hl7.fhir.convertors.conv10_40.DocumentReference10_40;
import org.hl7.fhir.convertors.conv10_40.Encounter10_40;
import org.hl7.fhir.convertors.conv10_40.EnrollmentRequest10_40;
import org.hl7.fhir.convertors.conv10_40.EnrollmentResponse10_40;
import org.hl7.fhir.convertors.conv10_40.EpisodeOfCare10_40;
import org.hl7.fhir.convertors.conv10_40.FamilyMemberHistory10_40;
import org.hl7.fhir.convertors.conv10_40.Flag10_40;
import org.hl7.fhir.convertors.conv10_40.Group10_40;
import org.hl7.fhir.convertors.conv10_40.HealthcareService10_40;
import org.hl7.fhir.convertors.conv10_40.ImplementationGuide10_40;
import org.hl7.fhir.convertors.conv10_40.List10_40;
import org.hl7.fhir.convertors.conv10_40.Location10_40;
import org.hl7.fhir.convertors.conv10_40.MedicationDispense10_40;
import org.hl7.fhir.convertors.conv10_40.MedicationStatement10_40;
import org.hl7.fhir.convertors.conv10_40.MessageHeader10_40;
import org.hl7.fhir.convertors.conv10_40.NamingSystem10_40;
import org.hl7.fhir.convertors.conv10_40.Observation10_40;
import org.hl7.fhir.convertors.conv10_40.OperationDefinition10_40;
import org.hl7.fhir.convertors.conv10_40.OperationOutcome10_40;
import org.hl7.fhir.convertors.conv10_40.Organization10_40;
import org.hl7.fhir.convertors.conv10_40.Parameters10_40;
import org.hl7.fhir.convertors.conv10_40.Patient10_40;
import org.hl7.fhir.convertors.conv10_40.Person10_40;
import org.hl7.fhir.convertors.conv10_40.Practitioner10_40;
import org.hl7.fhir.convertors.conv10_40.Questionnaire10_40;
import org.hl7.fhir.convertors.conv10_40.QuestionnaireResponse10_40;
import org.hl7.fhir.convertors.conv10_40.RiskAssessment10_40;
import org.hl7.fhir.convertors.conv10_40.Schedule10_40;
import org.hl7.fhir.convertors.conv10_40.SearchParameter10_40;
import org.hl7.fhir.convertors.conv10_40.Slot10_40;
import org.hl7.fhir.convertors.conv10_40.StructureDefinition10_40;
import org.hl7.fhir.convertors.conv10_40.Subscription10_40;
import org.hl7.fhir.convertors.conv10_40.Substance10_40;
import org.hl7.fhir.convertors.conv10_40.SupplyDelivery10_40;
import org.hl7.fhir.convertors.conv10_40.SupplyRequest10_40;
import org.hl7.fhir.convertors.conv10_40.TestScript10_40;
import org.hl7.fhir.convertors.conv10_40.ValueSet10_40;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.dstu2.model.Parameters;
import org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent;
import org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent;
import org.hl7.fhir.r4.model.Timing.EventTiming;
import org.hl7.fhir.r4.terminologies.CodeSystemUtilities;
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
public class VersionConvertor_10_40 {

    static public List<String> CANONICAL_URLS = new ArrayList<String>();

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

    public static void copyElement(org.hl7.fhir.dstu2.model.Element src, org.hl7.fhir.r4.model.Element tgt) throws FHIRException {
        tgt.setId(src.getId());
        for (org.hl7.fhir.dstu2.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    public static void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
        tgt.setId(src.getId());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    public static void copyElement(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
        tgt.setId(src.getId());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.r4.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r4.model.Base64BinaryType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu2.model.Base64BinaryType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.dstu2.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.r4.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.BooleanType(src.getValue()) : new org.hl7.fhir.r4.model.BooleanType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu2.model.BooleanType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValue()) : new org.hl7.fhir.r4.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UriType convertCodeToUri(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValue()) : new org.hl7.fhir.r4.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertUriToCode(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertDateToDateTime(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDateTimeToDate(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DecimalType convertDecimal(org.hl7.fhir.dstu2.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.r4.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DecimalType(src.getValue()) : new org.hl7.fhir.r4.model.DecimalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DecimalType convertDecimal(org.hl7.fhir.r4.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DecimalType(src.getValue()) : new org.hl7.fhir.dstu2.model.DecimalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.dstu2.model.IdType src) throws FHIRException {
        org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValue()) : new org.hl7.fhir.r4.model.IdType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.IdType convertId(org.hl7.fhir.r4.model.IdType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.IdType(src.getValue()) : new org.hl7.fhir.dstu2.model.IdType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InstantType convertInstant(org.hl7.fhir.dstu2.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r4.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.InstantType(src.getValue()) : new org.hl7.fhir.r4.model.InstantType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.InstantType convertInstant(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.InstantType(src.getValue()) : new org.hl7.fhir.dstu2.model.InstantType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.dstu2.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValue()) : new org.hl7.fhir.r4.model.IntegerType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu2.model.IntegerType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.r4.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r4.model.MarkdownType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu2.model.MarkdownType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.dstu2.model.OidType src) throws FHIRException {
        org.hl7.fhir.r4.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.OidType(src.getValue()) : new org.hl7.fhir.r4.model.OidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.OidType(src.getValue()) : new org.hl7.fhir.dstu2.model.OidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r4.model.PositiveIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.dstu2.model.PositiveIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.dstu2.model.StringType src) throws FHIRException {
        org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValue()) : new org.hl7.fhir.r4.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.StringType(src.getValue()) : new org.hl7.fhir.dstu2.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.dstu2.model.TimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.TimeType(src.getValue()) : new org.hl7.fhir.r4.model.TimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.TimeType(src.getValue()) : new org.hl7.fhir.dstu2.model.TimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.r4.model.UnsignedIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.dstu2.model.UnsignedIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
        org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValue()) : new org.hl7.fhir.r4.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UriType(src.getValue()) : new org.hl7.fhir.dstu2.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.dstu2.model.UuidType src) throws FHIRException {
        org.hl7.fhir.r4.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UuidType(src.getValue()) : new org.hl7.fhir.r4.model.UuidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UuidType(src.getValue()) : new org.hl7.fhir.dstu2.model.UuidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.dstu2.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
        copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2.model.Reference)
                tgt.setValue(convertReferenceToCanonical((Reference) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Extension tgt = new org.hl7.fhir.dstu2.model.Extension();
        copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r4.model.CanonicalType)
                tgt.setValue(convertCanonicalToReference((CanonicalType) src.getValue()));
            else if (src.hasValue())
                tgt.setValue(convertType(src.getValue()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Narrative convertNarrative(org.hl7.fhir.dstu2.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Narrative tgt = new org.hl7.fhir.r4.model.Narrative();
        copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Narrative convertNarrative(org.hl7.fhir.r4.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Narrative tgt = new org.hl7.fhir.dstu2.model.Narrative();
        copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case GENERATED:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.GENERATED);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EXTENSIONS);
                break;
            case ADDITIONAL:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.ADDITIONAL);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EMPTY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case GENERATED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.GENERATED);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EXTENSIONS);
                break;
            case ADDITIONAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.ADDITIONAL);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EMPTY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.dstu2.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
        copyElement(src, tgt);
        if (src.hasAuthor())
            tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTimeElement())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Annotation tgt = new org.hl7.fhir.dstu2.model.Annotation();
        copyElement(src, tgt);
        if (src.hasAuthor())
            tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTimeElement())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.dstu2.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
        copyElement(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasLanguageElement())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasDataElement())
            tgt.setDataElement(convertBase64Binary(src.getDataElement()));
        tgt.setUrl(src.getUrl());
        if (src.hasSizeElement())
            tgt.setSizeElement(convertUnsignedInt(src.getSizeElement()));
        if (src.hasHashElement())
            tgt.setHashElement(convertBase64Binary(src.getHashElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCreationElement())
            tgt.setCreationElement(convertDateTime(src.getCreationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Attachment tgt = new org.hl7.fhir.dstu2.model.Attachment();
        copyElement(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasLanguageElement())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasDataElement())
            tgt.setDataElement(convertBase64Binary(src.getDataElement()));
        tgt.setUrl(src.getUrl());
        if (src.hasSizeElement())
            tgt.setSizeElement(convertUnsignedInt(src.getSizeElement()));
        if (src.hasHashElement())
            tgt.setHashElement(convertBase64Binary(src.getHashElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCreationElement())
            tgt.setCreationElement(convertDateTime(src.getCreationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CodeableConcept tgt = new org.hl7.fhir.dstu2.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu2.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
        copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasUserSelectedElement())
            tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Coding tgt = new org.hl7.fhir.dstu2.model.Coding();
        copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasUserSelectedElement())
            tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.dstu2.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasValueElement())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasAssigner())
            tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Identifier tgt = new org.hl7.fhir.dstu2.model.Identifier();
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.TEMP);
                break;
            case SECONDARY:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.SECONDARY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.TEMP);
                break;
            case SECONDARY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.SECONDARY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.dstu2.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
        copyElement(src, tgt);
        if (src.hasStartElement())
            tgt.setStartElement(convertDateTime(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(convertDateTime(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Period tgt = new org.hl7.fhir.dstu2.model.Period();
        copyElement(src, tgt);
        if (src.hasStartElement())
            tgt.setStartElement(convertDateTime(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(convertDateTime(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Quantity convertQuantity(org.hl7.fhir.dstu2.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Quantity convertQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Quantity tgt = new org.hl7.fhir.dstu2.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Quantity.QuantityComparatorEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case LESS_THAN:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_THAN);
                break;
            case LESS_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
                break;
            case GREATER_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
                break;
            case GREATER_THAN:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_THAN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Quantity.QuantityComparatorEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case LESS_THAN:
                tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_THAN);
                break;
            case LESS_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
                break;
            case GREATER_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
                break;
            case GREATER_THAN:
                tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_THAN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.dstu2.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Range tgt = new org.hl7.fhir.dstu2.model.Range();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.dstu2.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
        copyElement(src, tgt);
        if (src.hasNumerator())
            tgt.setNumerator(convertQuantity(src.getNumerator()));
        if (src.hasDenominator())
            tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Ratio tgt = new org.hl7.fhir.dstu2.model.Ratio();
        copyElement(src, tgt);
        if (src.hasNumerator())
            tgt.setNumerator(convertQuantity(src.getNumerator()));
        if (src.hasDenominator())
            tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.dstu2.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
        copyElement(src, tgt);
        tgt.setReference(src.getReference());
        if (src.hasDisplayElement())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Reference tgt = new org.hl7.fhir.dstu2.model.Reference();
        copyElement(src, tgt);
        tgt.setReference(src.getReference());
        if (src.hasDisplayElement())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.dstu2.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
        copyElement(src, tgt);
        if (src.hasOrigin())
            tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        if (src.hasPeriodElement())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasFactorElement())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasLowerLimitElement())
            tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
        if (src.hasUpperLimitElement())
            tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
        if (src.hasDimensionsElement())
            tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
        if (src.hasDataElement())
            tgt.setDataElement(convertString(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SampledData tgt = new org.hl7.fhir.dstu2.model.SampledData();
        copyElement(src, tgt);
        if (src.hasOrigin())
            tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        if (src.hasPeriodElement())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasFactorElement())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasLowerLimitElement())
            tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
        if (src.hasUpperLimitElement())
            tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
        if (src.hasDimensionsElement())
            tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
        if (src.hasDataElement())
            tgt.setDataElement(convertString(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.dstu2.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        if (src.hasWhenElement())
            tgt.setWhenElement(convertInstant(src.getWhenElement()));
        if (src.hasWhoUriType())
            tgt.setWho(new org.hl7.fhir.r4.model.Reference(src.getWhoUriType().getValue()));
        else
            tgt.setWho(convertReference(src.getWhoReference()));
        if (src.hasContentTypeElement())
            tgt.setSigFormatElement(convertCode(src.getContentTypeElement()));
        if (src.hasBlobElement())
            tgt.setDataElement(convertBase64Binary(src.getBlobElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Signature tgt = new org.hl7.fhir.dstu2.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        if (src.hasWhenElement())
            tgt.setWhenElement(convertInstant(src.getWhenElement()));
        if (src.hasWho())
            tgt.setWho(convertType(src.getWho()));
        if (src.hasSigFormatElement())
            tgt.setContentTypeElement(convertCode(src.getSigFormatElement()));
        if (src.hasDataElement())
            tgt.setBlobElement(convertBase64Binary(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Address convertAddress(org.hl7.fhir.dstu2.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Address tgt = new org.hl7.fhir.r4.model.Address();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        if (src.hasCityElement())
            tgt.setCityElement(convertString(src.getCityElement()));
        if (src.hasDistrictElement())
            tgt.setDistrictElement(convertString(src.getDistrictElement()));
        if (src.hasStateElement())
            tgt.setStateElement(convertString(src.getStateElement()));
        if (src.hasPostalCodeElement())
            tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
        if (src.hasCountryElement())
            tgt.setCountryElement(convertString(src.getCountryElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Address convertAddress(org.hl7.fhir.r4.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Address tgt = new org.hl7.fhir.dstu2.model.Address();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        if (src.hasCityElement())
            tgt.setCityElement(convertString(src.getCityElement()));
        if (src.hasDistrictElement())
            tgt.setDistrictElement(convertString(src.getDistrictElement()));
        if (src.hasStateElement())
            tgt.setStateElement(convertString(src.getStateElement()));
        if (src.hasPostalCodeElement())
            tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
        if (src.hasCountryElement())
            tgt.setCountryElement(convertString(src.getCountryElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Address.AddressUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> convertAddressType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case POSTAL:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.POSTAL);
                break;
            case PHYSICAL:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.PHYSICAL);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressType> convertAddressType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Address.AddressTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case POSTAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.POSTAL);
                break;
            case PHYSICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.PHYSICAL);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactPoint tgt = new org.hl7.fhir.r4.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
        if (src.hasValueElement())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasUse())
            tgt.setUseElement(convertContactPointUse(src.getUseElement()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ContactPoint convertContactPoint(org.hl7.fhir.r4.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ContactPoint tgt = new org.hl7.fhir.dstu2.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
        if (src.hasValueElement())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasUse())
            tgt.setUseElement(convertContactPointUse(src.getUseElement()));
        if (src.hasRankElement())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PHONE:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PHONE);
                break;
            case FAX:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.FAX);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.EMAIL);
                break;
            case PAGER:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PAGER);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PHONE:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PHONE);
                break;
            case FAX:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.FAX);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.EMAIL);
                break;
            case PAGER:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PAGER);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.OLD);
                break;
            case MOBILE:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.MOBILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.OLD);
                break;
            case MOBILE:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.MOBILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2.model.ElementDefinition src, List<String> slicePaths, List<org.hl7.fhir.dstu2.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_10_40::convertPropertyRepresentation)
                .collect(Collectors.toList()));
        if (src.hasName()) {
            if (slicePaths.contains(src.getPath()))
                tgt.setSliceNameElement(convertString(src.getNameElement()));
            if (src.hasNameElement())
                tgt.setIdElement(convertString(src.getNameElement()));
        }
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing(), context, pos));
        if (src.hasShort())
            tgt.setShortElement(convertString(src.getShortElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
        if (src.hasComments())
            tgt.setCommentElement(convertMarkdown(src.getCommentsElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasNameReference())
            tgt.setContentReference("#" + src.getNameReference());
        for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : src.getType()) convertElementDefinitionTypeComponent(t, tgt.getType());
        if (src.hasDefaultValue())
            tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
        if (src.hasFixed())
            tgt.setFixed(convertType(src.getFixed()));
        if (src.hasPattern())
            tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.addExample().setLabel("General").setValue(convertType(src.getExample()));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
        for (org.hl7.fhir.dstu2.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
        if (src.hasIsModifier())
            tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
        if (tgt.getIsModifier()) {
            String reason = org.hl7.fhir.dstu2.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
            if (Utilities.noString(reason))
                reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
            tgt.setIsModifierReason(reason);
        }
        if (src.hasIsSummary())
            tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        if (!tgt.hasId())
            tgt.setId(tgt.getPath());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition tgt = new org.hl7.fhir.dstu2.model.ElementDefinition();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_10_40::convertPropertyRepresentation)
                .collect(Collectors.toList()));
        if (src.hasSliceName())
            tgt.setNameElement(convertString(src.getSliceNameElement()));
        else
            tgt.setNameElement(convertString(src.getIdElement()));
        if (src.hasLabelElement())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        if (src.hasShortElement())
            tgt.setShortElement(convertString(src.getShortElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
        if (src.hasCommentElement())
            tgt.setCommentsElement(convertMarkdown(src.getCommentElement()));
        if (src.hasRequirementsElement())
            tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        tgt.setMin(src.getMin());
        if (src.hasMaxElement())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setNameReference(src.getContentReference().substring(1));
        for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType()) convertElementDefinitionTypeComponent(t, tgt.getType());
        if (src.hasDefaultValue())
            tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissingElement())
            tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
        if (src.hasFixed())
            tgt.setFixed(convertType(src.getFixed()));
        if (src.hasPattern())
            tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.setExample(convertType(src.getExampleFirstRep().getValue()));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLengthElement())
            tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
        for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupportElement())
            tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
        if (src.hasIsModifierElement())
            tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
        if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
            org.hl7.fhir.dstu2.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
        if (src.hasIsSummaryElement())
            tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case XMLATTR:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case XMLATTR:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent src, List<org.hl7.fhir.dstu2.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        org.hl7.fhir.dstu2.model.ElementDefinition slicingElement = context.get(pos);
        for (org.hl7.fhir.dstu2.model.StringType t : src.getDiscriminator()) {
            boolean isExists = false;
            if (!t.asStringValue().contains("@")) {
                int slices = 0;
                boolean existsSlicePresent = false;
                boolean notExistsSlicePresent = false;
                String existsPath = slicingElement.getPath() + "." + t.asStringValue();
                for (int i = pos + 1; i < context.size(); i++) {
                    org.hl7.fhir.dstu2.model.ElementDefinition e = context.get(i);
                    if (e.getPath().equals(slicingElement.getPath()))
                        slices++;
                    else if (!e.getPath().startsWith(slicingElement.getPath() + "."))
                        break;
                    else if (e.getPath().equals(existsPath)) {
                        if (e.hasMin() && e.getMin() > 0)
                            existsSlicePresent = true;
                        else if (e.hasMax() && e.getMax().equals("0"))
                            notExistsSlicePresent = true;
                    }
                }
                isExists = (slices == 2 && existsSlicePresent && notExistsSlicePresent) || (slices == 1 && existsSlicePresent != notExistsSlicePresent);
            }
            tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue(), isExists));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrderedElement())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrderedElement())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLOSED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.CLOSED);
                break;
            case OPEN:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPEN);
                break;
            case OPENATEND:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPENATEND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLOSED:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.CLOSED);
                break;
            case OPEN:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPEN);
                break;
            case OPENATEND:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPENATEND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setMin(src.getMin());
        if (src.hasMaxElement())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setMin(src.getMin());
        if (src.hasMaxElement())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        return tgt;
    }

    public static void convertElementDefinitionTypeComponent(org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = null;
        for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : list) if (t.getCode().equals(src.getCode()))
            tgt = t;
        if (tgt == null) {
            tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
            list.add(tgt);
            copyElement(src, tgt);
            tgt.setCode(src.getCode());
        }
        if (tgt.hasTarget()) {
            for (org.hl7.fhir.dstu2.model.UriType u : src.getProfile()) tgt.addTargetProfile(u.getValue());
        } else {
            for (org.hl7.fhir.dstu2.model.UriType u : src.getProfile()) tgt.addProfile(u.getValue());
        }
        for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
            org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> a = convertAggregationMode(t);
            if (!tgt.hasAggregation(a.getValue()))
                copyElement(t, tgt.addAggregationElement().setValue(a.getValue()));
        }
    }

    public static void convertElementDefinitionTypeComponent(org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        tgt.setCode(src.getCode());
        list.add(tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.UriType u : src.getTargetProfile()) {
                tgt.addProfile(u.getValue());
            }
        } else {
            for (org.hl7.fhir.r4.model.UriType u : src.getProfile()) {
                tgt.addProfile(u.getValue());
            }
        }
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONTAINED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.CONTAINED);
                break;
            case REFERENCED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.REFERENCED);
                break;
            case BUNDLED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.BUNDLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONTAINED:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.CONTAINED);
                break;
            case REFERENCED:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.REFERENCED);
                break;
            case BUNDLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.BUNDLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        if (src.hasKeyElement())
            tgt.setKeyElement(convertId(src.getKeyElement()));
        if (src.hasRequirementsElement())
            tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
        if (src.hasHumanElement())
            tgt.setHumanElement(convertString(src.getHumanElement()));
        tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
        if (src.hasXpathElement())
            tgt.setXpathElement(convertString(src.getXpathElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        if (src.hasKeyElement())
            tgt.setKeyElement(convertId(src.getKeyElement()));
        if (src.hasRequirementsElement())
            tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
        if (src.hasHumanElement())
            tgt.setHumanElement(convertString(src.getHumanElement()));
        if (src.hasExpression())
            ToolingExtensions.addStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
        if (src.hasXpathElement())
            tgt.setXpathElement(convertString(src.getXpathElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.ERROR);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.WARNING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.ERROR);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.WARNING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        org.hl7.fhir.r4.model.Type vs = convertType(src.getValueSet());
        if (vs != null) {
            tgt.setValueSet(vs instanceof org.hl7.fhir.r4.model.Reference ? ((org.hl7.fhir.r4.model.Reference) vs).getReference() : vs.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED);
                break;
            case EXTENSIBLE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXTENSIBLE);
                break;
            case PREFERRED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.PREFERRED);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXAMPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.REQUIRED);
                break;
            case EXTENSIBLE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXTENSIBLE);
                break;
            case PREFERRED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.PREFERRED);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXAMPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasLanguageElement())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasMapElement())
            tgt.setMapElement(convertString(src.getMapElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasLanguageElement())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasMapElement())
            tgt.setMapElement(convertString(src.getMapElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HumanName convertHumanName(org.hl7.fhir.dstu2.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.HumanName tgt = new org.hl7.fhir.r4.model.HumanName();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getFamily()) tgt.setFamily(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HumanName tgt = new org.hl7.fhir.dstu2.model.HumanName();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasFamily())
            tgt.addFamily(src.getFamily());
        for (org.hl7.fhir.r4.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HumanName.NameUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.TEMP);
                break;
            case NICKNAME:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.NICKNAME);
                break;
            case ANONYMOUS:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.ANONYMOUS);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.OLD);
                break;
            case MAIDEN:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.MAIDEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HumanName.NameUseEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.TEMP);
                break;
            case NICKNAME:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.NICKNAME);
                break;
            case ANONYMOUS:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.ANONYMOUS);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.OLD);
                break;
            case MAIDEN:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.MAIDEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.dstu2.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionIdElement())
            tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
        if (src.hasLastUpdatedElement())
            tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
        for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Meta tgt = new org.hl7.fhir.dstu2.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionIdElement())
            tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
        if (src.hasLastUpdatedElement())
            tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
        for (org.hl7.fhir.r4.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing convertTiming(org.hl7.fhir.dstu2.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Timing tgt = new org.hl7.fhir.r4.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        if (src.hasRepeat())
            tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Timing convertTiming(org.hl7.fhir.r4.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Timing tgt = new org.hl7.fhir.dstu2.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        if (src.hasRepeat())
            tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r4.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        if (src.hasBounds())
            tgt.setBounds(convertType(src.getBounds()));
        tgt.setCount(src.getCount());
        if (src.hasDurationElement())
            tgt.setDurationElement(convertDecimal(src.getDurationElement()));
        if (src.hasDurationMaxElement())
            tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
        if (src.hasDurationUnits())
            tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitsElement()));
        tgt.setFrequency(src.getFrequency());
        tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriodElement())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMaxElement())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnits())
            tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitsElement()));
        if (src.hasWhen()) {
            tgt.setWhen(Collections.singletonList(convertEventTiming(src.getWhenElement())));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r4.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        if (src.hasBounds())
            tgt.setBounds(convertType(src.getBounds()));
        tgt.setCount(src.getCount());
        if (src.hasDurationElement())
            tgt.setDurationElement(convertDecimal(src.getDurationElement()));
        if (src.hasDurationMaxElement())
            tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
        if (src.hasDurationUnit())
            tgt.setDurationUnitsElement(convertUnitsOfTime(src.getDurationUnitElement()));
        tgt.setFrequency(src.getFrequency());
        tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriodElement())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMaxElement())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnit())
            tgt.setPeriodUnitsElement(convertUnitsOfTime(src.getPeriodUnitElement()));
        if (src.hasWhen()) {
            tgt.setWhenElement(convertEventTiming(src.getWhen().get(0)));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case S:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.S);
                break;
            case MIN:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.MIN);
                break;
            case H:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.H);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.D);
                break;
            case WK:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.WK);
                break;
            case MO:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.MO);
                break;
            case A:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.A);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case S:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.S);
                break;
            case MIN:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MIN);
                break;
            case H:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.H);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.D);
                break;
            case WK:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.WK);
                break;
            case MO:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MO);
                break;
            case A:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.A);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.EventTimingEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case HS:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.HS);
                break;
            case WAKE:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.WAKE);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.C);
                break;
            case CM:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CM);
                break;
            case CD:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CD);
                break;
            case CV:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CV);
                break;
            case AC:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AC);
                break;
            case ACM:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACM);
                break;
            case ACD:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACD);
                break;
            case ACV:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACV);
                break;
            case PC:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PC);
                break;
            case PCM:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCM);
                break;
            case PCD:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCD);
                break;
            case PCV:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCV);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.EventTiming> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Timing.EventTimingEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case HS:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.HS);
                break;
            case WAKE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.WAKE);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.C);
                break;
            case CM:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.CM);
                break;
            case CD:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.CD);
                break;
            case CV:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.CV);
                break;
            case AC:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.AC);
                break;
            case ACM:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.ACM);
                break;
            case ACD:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.ACD);
                break;
            case ACV:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.ACV);
                break;
            case PC:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PC);
                break;
            case PCM:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PCM);
                break;
            case PCD:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PCD);
                break;
            case PCV:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PCV);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Age convertAge(org.hl7.fhir.dstu2.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Age tgt = new org.hl7.fhir.r4.model.Age();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Age convertAge(org.hl7.fhir.r4.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Age tgt = new org.hl7.fhir.dstu2.model.Age();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Count convertCount(org.hl7.fhir.dstu2.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Count tgt = new org.hl7.fhir.r4.model.Count();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Count convertCount(org.hl7.fhir.r4.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Count tgt = new org.hl7.fhir.dstu2.model.Count();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.dstu2.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Distance tgt = new org.hl7.fhir.dstu2.model.Distance();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Duration convertDuration(org.hl7.fhir.dstu2.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Duration tgt = new org.hl7.fhir.r4.model.Duration();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Duration convertDuration(org.hl7.fhir.r4.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Duration tgt = new org.hl7.fhir.dstu2.model.Duration();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.dstu2.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasCodeElement())
            tgt.setCurrencyElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Money tgt = new org.hl7.fhir.dstu2.model.Money();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasCurrencyElement())
            tgt.setCodeElement(convertCode(src.getCurrencyElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu2.model.SimpleQuantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SimpleQuantity tgt = new org.hl7.fhir.r4.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValueElement())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnitElement())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.dstu2.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.dstu2.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.BooleanType)
            return convertBoolean((org.hl7.fhir.dstu2.model.BooleanType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CodeType)
            return convertCode((org.hl7.fhir.dstu2.model.CodeType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DateType)
            return convertDate((org.hl7.fhir.dstu2.model.DateType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DateTimeType)
            return convertDateTime((org.hl7.fhir.dstu2.model.DateTimeType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DecimalType)
            return convertDecimal((org.hl7.fhir.dstu2.model.DecimalType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.IdType)
            return convertId((org.hl7.fhir.dstu2.model.IdType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.InstantType)
            return convertInstant((org.hl7.fhir.dstu2.model.InstantType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.IntegerType)
            return convertInteger((org.hl7.fhir.dstu2.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.dstu2.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.OidType)
            return convertOid((org.hl7.fhir.dstu2.model.OidType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.dstu2.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.StringType)
            return convertString((org.hl7.fhir.dstu2.model.StringType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.TimeType)
            return convertTime((org.hl7.fhir.dstu2.model.TimeType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.dstu2.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.UriType)
            return convertUri((org.hl7.fhir.dstu2.model.UriType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.UuidType)
            return convertUuid((org.hl7.fhir.dstu2.model.UuidType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Extension)
            return convertExtension((org.hl7.fhir.dstu2.model.Extension) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Narrative)
            return convertNarrative((org.hl7.fhir.dstu2.model.Narrative) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Annotation)
            return convertAnnotation((org.hl7.fhir.dstu2.model.Annotation) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Attachment)
            return convertAttachment((org.hl7.fhir.dstu2.model.Attachment) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CodeableConcept)
            return convertCodeableConcept((org.hl7.fhir.dstu2.model.CodeableConcept) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Coding)
            return convertCoding((org.hl7.fhir.dstu2.model.Coding) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Identifier)
            return convertIdentifier((org.hl7.fhir.dstu2.model.Identifier) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Period)
            return convertPeriod((org.hl7.fhir.dstu2.model.Period) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Quantity)
            return convertQuantity((org.hl7.fhir.dstu2.model.Quantity) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Range)
            return convertRange((org.hl7.fhir.dstu2.model.Range) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Ratio)
            return convertRatio((org.hl7.fhir.dstu2.model.Ratio) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Reference)
            return convertReference((org.hl7.fhir.dstu2.model.Reference) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SampledData)
            return convertSampledData((org.hl7.fhir.dstu2.model.SampledData) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Signature)
            return convertSignature((org.hl7.fhir.dstu2.model.Signature) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Address)
            return convertAddress((org.hl7.fhir.dstu2.model.Address) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.dstu2.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.dstu2.model.HumanName)
            return convertHumanName((org.hl7.fhir.dstu2.model.HumanName) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Meta)
            return convertMeta((org.hl7.fhir.dstu2.model.Meta) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Timing)
            return convertTiming((org.hl7.fhir.dstu2.model.Timing) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Age)
            return convertAge((org.hl7.fhir.dstu2.model.Age) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Count)
            return convertCount((org.hl7.fhir.dstu2.model.Count) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Distance)
            return convertDistance((org.hl7.fhir.dstu2.model.Distance) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Duration)
            return convertDuration((org.hl7.fhir.dstu2.model.Duration) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Money)
            return convertMoney((org.hl7.fhir.dstu2.model.Money) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SimpleQuantity)
            return convertSimpleQuantity((org.hl7.fhir.dstu2.model.SimpleQuantity) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.r4.model.BooleanType)
            return convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
        if (src instanceof org.hl7.fhir.r4.model.CodeType)
            return convertCode((org.hl7.fhir.r4.model.CodeType) src);
        if (src instanceof org.hl7.fhir.r4.model.DateType)
            return convertDate((org.hl7.fhir.r4.model.DateType) src);
        if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
            return convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
        if (src instanceof org.hl7.fhir.r4.model.DecimalType)
            return convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
        if (src instanceof org.hl7.fhir.r4.model.IdType)
            return convertId((org.hl7.fhir.r4.model.IdType) src);
        if (src instanceof org.hl7.fhir.r4.model.InstantType)
            return convertInstant((org.hl7.fhir.r4.model.InstantType) src);
        if (src instanceof org.hl7.fhir.r4.model.IntegerType)
            return convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.r4.model.OidType)
            return convertOid((org.hl7.fhir.r4.model.OidType) src);
        if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.r4.model.StringType)
            return convertString((org.hl7.fhir.r4.model.StringType) src);
        if (src instanceof org.hl7.fhir.r4.model.TimeType)
            return convertTime((org.hl7.fhir.r4.model.TimeType) src);
        if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.r4.model.UriType)
            return convertUri((org.hl7.fhir.r4.model.UriType) src);
        if (src instanceof org.hl7.fhir.r4.model.UuidType)
            return convertUuid((org.hl7.fhir.r4.model.UuidType) src);
        if (src instanceof org.hl7.fhir.r4.model.Extension)
            return convertExtension((org.hl7.fhir.r4.model.Extension) src);
        if (src instanceof org.hl7.fhir.r4.model.Narrative)
            return convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
        if (src instanceof org.hl7.fhir.r4.model.Annotation)
            return convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
        if (src instanceof org.hl7.fhir.r4.model.Attachment)
            return convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
        if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
            return convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
        if (src instanceof org.hl7.fhir.r4.model.Coding)
            return convertCoding((org.hl7.fhir.r4.model.Coding) src);
        if (src instanceof org.hl7.fhir.r4.model.Identifier)
            return convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
        if (src instanceof org.hl7.fhir.r4.model.Period)
            return convertPeriod((org.hl7.fhir.r4.model.Period) src);
        if (src instanceof org.hl7.fhir.r4.model.Quantity)
            return convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
        if (src instanceof org.hl7.fhir.r4.model.Range)
            return convertRange((org.hl7.fhir.r4.model.Range) src);
        if (src instanceof org.hl7.fhir.r4.model.Ratio)
            return convertRatio((org.hl7.fhir.r4.model.Ratio) src);
        if (src instanceof org.hl7.fhir.r4.model.Reference)
            return convertReference((org.hl7.fhir.r4.model.Reference) src);
        if (src instanceof org.hl7.fhir.r4.model.SampledData)
            return convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
        if (src instanceof org.hl7.fhir.r4.model.Signature)
            return convertSignature((org.hl7.fhir.r4.model.Signature) src);
        if (src instanceof org.hl7.fhir.r4.model.Address)
            return convertAddress((org.hl7.fhir.r4.model.Address) src);
        if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.r4.model.HumanName)
            return convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
        if (src instanceof org.hl7.fhir.r4.model.Meta)
            return convertMeta((org.hl7.fhir.r4.model.Meta) src);
        if (src instanceof org.hl7.fhir.r4.model.Timing)
            return convertTiming((org.hl7.fhir.r4.model.Timing) src);
        if (src instanceof org.hl7.fhir.r4.model.Age)
            return convertAge((org.hl7.fhir.r4.model.Age) src);
        if (src instanceof org.hl7.fhir.r4.model.Count)
            return convertCount((org.hl7.fhir.r4.model.Count) src);
        if (src instanceof org.hl7.fhir.r4.model.Distance)
            return convertDistance((org.hl7.fhir.r4.model.Distance) src);
        if (src instanceof org.hl7.fhir.r4.model.Duration)
            return convertDuration((org.hl7.fhir.r4.model.Duration) src);
        if (src instanceof org.hl7.fhir.r4.model.Money)
            return convertMoney((org.hl7.fhir.r4.model.Money) src);
        if (src instanceof org.hl7.fhir.r4.model.SimpleQuantity)
            return convertSimpleQuantity((org.hl7.fhir.r4.model.SimpleQuantity) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
        boolean ok = false;
        for (String s : extensionsToIgnore) if (s.equals(url))
            ok = true;
        return ok;
    }

    public static void copyDomainResource(org.hl7.fhir.dstu2.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.dstu2.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.dstu2.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.dstu2.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    public static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.r4.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    public static void copyResource(org.hl7.fhir.dstu2.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
        tgt.setId(src.getId());
        tgt.setMeta(convertMeta(src.getMeta()));
        tgt.setImplicitRules(src.getImplicitRules());
        tgt.setLanguage(src.getLanguage());
    }

    public static void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
        tgt.setId(src.getId());
        if (src.hasMeta())
            tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.AdministrativeGenderEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case MALE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE);
                break;
            case FEMALE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.OTHER);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGenderEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case MALE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.MALE);
                break;
            case FEMALE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.FEMALE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.OTHER);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case NUMBER:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.NUMBER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.DATE);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.STRING);
                break;
            case TOKEN:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.TOKEN);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.REFERENCE);
                break;
            case COMPOSITE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.COMPOSITE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.QUANTITY);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.URI);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case NUMBER:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NUMBER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.DATE);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.STRING);
                break;
            case TOKEN:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.TOKEN);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.REFERENCE);
                break;
            case COMPOSITE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.COMPOSITE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.QUANTITY);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.URI);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public class SourceElementComponentWrapper {

        public SourceElementComponentWrapper(SourceElementComponent comp, String source, String target) {
            super();
            this.source = source;
            this.target = target;
            this.comp = comp;
        }

        public String source;

        public String target;

        public org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent comp;
    }

    public static org.hl7.fhir.r4.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2.model.CodeableConcept t) throws FHIRException {
        org.hl7.fhir.r4.model.UsageContext result = new org.hl7.fhir.r4.model.UsageContext();
        result.setValue(convertCodeableConcept(t));
        return result;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.RETIRED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.NULL);
                break;
        }
        return tgt;
    }

    static public CanonicalType convertReferenceToCanonical(Reference src) throws FHIRException {
        CanonicalType dst = new CanonicalType(src.getReference());
        copyElement(src, dst);
        return dst;
    }

    static public Reference convertCanonicalToReference(CanonicalType src) throws FHIRException {
        Reference dst = new Reference(src.getValue());
        copyElement(src, dst);
        return dst;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> convertConformanceEventMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityModeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENDER:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.SENDER);
                break;
            case RECEIVER:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode> convertConformanceEventMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Conformance.ConformanceEventModeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENDER:
                tgt.setValue(org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.SENDER);
                break;
            case RECEIVER:
                tgt.setValue(org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.RECEIVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent();
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasRef())
            tgt.setRef(convertReference(src.getRef()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent();
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasRef())
            tgt.setRef(convertReference(src.getRef()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Reference getPerformer(List<ImmunizationPerformerComponent> practitioner) {
        for (ImmunizationPerformerComponent p : practitioner) {
            if (hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "AP"))
                return p.getActor();
        }
        return null;
    }

    static public org.hl7.fhir.r4.model.Reference getRequester(List<ImmunizationPerformerComponent> practitioner) {
        for (ImmunizationPerformerComponent p : practitioner) {
            if (hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "OP"))
                return p.getActor();
        }
        return null;
    }

    static public boolean hasConcept(org.hl7.fhir.r4.model.CodeableConcept cc, String system, String code) {
        for (org.hl7.fhir.r4.model.Coding c : cc.getCoding()) {
            if (system.equals(c.getSystem()) && code.equals(c.getCode()))
                return true;
        }
        return false;
    }

    static public boolean hasConcept(org.hl7.fhir.dstu2.model.CodeableConcept cc, String system, String code) {
        for (org.hl7.fhir.dstu2.model.Coding c : cc.getCoding()) {
            if (system.equals(c.getSystem()) && code.equals(c.getCode()))
                return true;
        }
        return false;
    }

    public static org.hl7.fhir.r4.model.Dosage convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
        copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(convertCodeableConcept(src.getSiteCodeableConcept()));
        if (src.hasRoute())
            tgt.setRoute(convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasDose() || src.hasRate()) {
            DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
            if (src.hasDose())
                dr.setDose(convertType(src.getDose()));
            if (src.hasRate())
                dr.setRate(convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent();
        copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasSite())
            tgt.setSite(convertType(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
            tgt.setDose(convertType(src.getDoseAndRate().get(0).getDose()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
            tgt.setRate(convertType(src.getDoseAndRate().get(0).getRate()));
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Slot.SlotStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Slot.SlotStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case BUSY:
                tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.BUSY);
                break;
            case FREE:
                tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.FREE);
                break;
            case BUSYUNAVAILABLE:
                tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYUNAVAILABLE);
                break;
            case BUSYTENTATIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYTENTATIVE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Slot.SlotStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Slot.SlotStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case BUSY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSY);
                break;
            case FREE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.FREE);
                break;
            case BUSYUNAVAILABLE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYUNAVAILABLE);
                break;
            case BUSYTENTATIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYTENTATIVE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUESTED:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
                break;
            case FAILED:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.REQUESTED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent convertCodeSystem(org.hl7.fhir.r4.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent();
        copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setSystemElement(convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasCaseSensitiveElement())
            tgt.setCaseSensitiveElement(convertBoolean(src.getCaseSensitiveElement()));
        for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(src, cc));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent convertCodeSystemConcept(CodeSystem cs, ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent();
        copyElement(src, tgt);
        tgt.setAbstract(CodeSystemUtilities.isNotSelectable(cs, src));
        tgt.setCode(src.getCode());
        tgt.setDefinition(src.getDefinition());
        tgt.setDisplay(src.getDisplay());
        for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(cs, cc));
        for (ConceptDefinitionDesignationComponent cc : src.getDesignation()) tgt.addDesignation(convertCodeSystemDesignation(cc));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent convertCodeSystemDesignation(ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
        copyElement(src, tgt);
        tgt.setUse(convertCoding(src.getUse()));
        tgt.setLanguage(src.getLanguage());
        tgt.setValue(src.getValue());
        return tgt;
    }

    static public boolean isJurisdiction(CodeableConcept t) {
        return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
    }

    public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, VersionConvertorAdvisor40 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.dstu2.model.Parameters)
            return Parameters10_40.convertParameters((org.hl7.fhir.dstu2.model.Parameters) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Appointment)
            return Appointment10_40.convertAppointment((org.hl7.fhir.dstu2.model.Appointment) src);
        if (src instanceof org.hl7.fhir.dstu2.model.AppointmentResponse)
            return AppointmentResponse10_40.convertAppointmentResponse((org.hl7.fhir.dstu2.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.dstu2.model.AuditEvent)
            return AuditEvent10_40.convertAuditEvent((org.hl7.fhir.dstu2.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Basic)
            return Basic10_40.convertBasic((org.hl7.fhir.dstu2.model.Basic) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Binary)
            return Binary10_40.convertBinary((org.hl7.fhir.dstu2.model.Binary) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Bundle)
            return Bundle10_40.convertBundle((org.hl7.fhir.dstu2.model.Bundle) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CarePlan)
            return CarePlan10_40.convertCarePlan((org.hl7.fhir.dstu2.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Communication)
            return Communication10_40.convertCommunication((org.hl7.fhir.dstu2.model.Communication) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CommunicationRequest)
            return CommunicationRequest10_40.convertCommunicationRequest((org.hl7.fhir.dstu2.model.CommunicationRequest) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Composition)
            return Composition10_40.convertComposition((org.hl7.fhir.dstu2.model.Composition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ConceptMap)
            return ConceptMap10_40.convertConceptMap((org.hl7.fhir.dstu2.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Condition)
            return Condition10_40.convertCondition((org.hl7.fhir.dstu2.model.Condition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Conformance)
            return Conformance10_40.convertConformance((org.hl7.fhir.dstu2.model.Conformance) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DataElement)
            return DataElement10_40.convertDataElement((org.hl7.fhir.dstu2.model.DataElement) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DetectedIssue)
            return DetectedIssue10_40.convertDetectedIssue((org.hl7.fhir.dstu2.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DeviceMetric)
            return DeviceMetric10_40.convertDeviceMetric((org.hl7.fhir.dstu2.model.DeviceMetric) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DeviceUseStatement)
            return DeviceUseStatement10_40.convertDeviceUseStatement((org.hl7.fhir.dstu2.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DiagnosticReport)
            return DiagnosticReport10_40.convertDiagnosticReport((org.hl7.fhir.dstu2.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DocumentReference)
            return DocumentReference10_40.convertDocumentReference((org.hl7.fhir.dstu2.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Encounter)
            return Encounter10_40.convertEncounter((org.hl7.fhir.dstu2.model.Encounter) src);
        if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentRequest)
            return EnrollmentRequest10_40.convertEnrollmentRequest((org.hl7.fhir.dstu2.model.EnrollmentRequest) src);
        if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentResponse)
            return EnrollmentResponse10_40.convertEnrollmentResponse((org.hl7.fhir.dstu2.model.EnrollmentResponse) src);
        if (src instanceof org.hl7.fhir.dstu2.model.EpisodeOfCare)
            return EpisodeOfCare10_40.convertEpisodeOfCare((org.hl7.fhir.dstu2.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.dstu2.model.FamilyMemberHistory)
            return FamilyMemberHistory10_40.convertFamilyMemberHistory((org.hl7.fhir.dstu2.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Flag)
            return Flag10_40.convertFlag((org.hl7.fhir.dstu2.model.Flag) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Group)
            return Group10_40.convertGroup((org.hl7.fhir.dstu2.model.Group) src);
        if (src instanceof org.hl7.fhir.dstu2.model.HealthcareService)
            return HealthcareService10_40.convertHealthcareService((org.hl7.fhir.dstu2.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ImplementationGuide)
            return ImplementationGuide10_40.convertImplementationGuide((org.hl7.fhir.dstu2.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.dstu2.model.List_)
            return List10_40.convertList((org.hl7.fhir.dstu2.model.List_) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Location)
            return Location10_40.convertLocation((org.hl7.fhir.dstu2.model.Location) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MedicationDispense)
            return MedicationDispense10_40.convertMedicationDispense((org.hl7.fhir.dstu2.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MedicationStatement)
            return MedicationStatement10_40.convertMedicationStatement((org.hl7.fhir.dstu2.model.MedicationStatement) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MessageHeader)
            return MessageHeader10_40.convertMessageHeader((org.hl7.fhir.dstu2.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.dstu2.model.NamingSystem)
            return NamingSystem10_40.convertNamingSystem((org.hl7.fhir.dstu2.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Observation)
            return Observation10_40.convertObservation((org.hl7.fhir.dstu2.model.Observation) src);
        if (src instanceof org.hl7.fhir.dstu2.model.OperationDefinition)
            return OperationDefinition10_40.convertOperationDefinition((org.hl7.fhir.dstu2.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.OperationOutcome)
            return OperationOutcome10_40.convertOperationOutcome((org.hl7.fhir.dstu2.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Organization)
            return Organization10_40.convertOrganization((org.hl7.fhir.dstu2.model.Organization) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Patient)
            return Patient10_40.convertPatient((org.hl7.fhir.dstu2.model.Patient) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Person)
            return Person10_40.convertPerson((org.hl7.fhir.dstu2.model.Person) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Practitioner)
            return Practitioner10_40.convertPractitioner((org.hl7.fhir.dstu2.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Questionnaire)
            return Questionnaire10_40.convertQuestionnaire((org.hl7.fhir.dstu2.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.dstu2.model.QuestionnaireResponse)
            return QuestionnaireResponse10_40.convertQuestionnaireResponse((org.hl7.fhir.dstu2.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.dstu2.model.RiskAssessment)
            return RiskAssessment10_40.convertRiskAssessment((org.hl7.fhir.dstu2.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Schedule)
            return Schedule10_40.convertSchedule((org.hl7.fhir.dstu2.model.Schedule) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SearchParameter)
            return SearchParameter10_40.convertSearchParameter((org.hl7.fhir.dstu2.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Slot)
            return Slot10_40.convertSlot((org.hl7.fhir.dstu2.model.Slot) src);
        if (src instanceof org.hl7.fhir.dstu2.model.StructureDefinition)
            return StructureDefinition10_40.convertStructureDefinition((org.hl7.fhir.dstu2.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Subscription)
            return Subscription10_40.convertSubscription((org.hl7.fhir.dstu2.model.Subscription) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Substance)
            return Substance10_40.convertSubstance((org.hl7.fhir.dstu2.model.Substance) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SupplyDelivery)
            return SupplyDelivery10_40.convertSupplyDelivery((org.hl7.fhir.dstu2.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SupplyRequest)
            return SupplyRequest10_40.convertSupplyRequest((org.hl7.fhir.dstu2.model.SupplyRequest) src);
        if (src instanceof org.hl7.fhir.dstu2.model.TestScript)
            return TestScript10_40.convertTestScript((org.hl7.fhir.dstu2.model.TestScript) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ValueSet)
            return ValueSet10_40.convertValueSet((org.hl7.fhir.dstu2.model.ValueSet) src, advisor);
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, VersionConvertorAdvisor40 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r4.model.Parameters)
            return Parameters10_40.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
        if (src instanceof org.hl7.fhir.r4.model.Appointment)
            return Appointment10_40.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
        if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
            return AppointmentResponse10_40.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
            return AuditEvent10_40.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.r4.model.Basic)
            return Basic10_40.convertBasic((org.hl7.fhir.r4.model.Basic) src);
        if (src instanceof org.hl7.fhir.r4.model.Binary)
            return Binary10_40.convertBinary((org.hl7.fhir.r4.model.Binary) src);
        if (src instanceof org.hl7.fhir.r4.model.Bundle)
            return Bundle10_40.convertBundle((org.hl7.fhir.r4.model.Bundle) src, advisor);
        if (src instanceof org.hl7.fhir.r4.model.CarePlan)
            return CarePlan10_40.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.r4.model.Communication)
            return Communication10_40.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
        if (src instanceof org.hl7.fhir.r4.model.CommunicationRequest)
            return CommunicationRequest10_40.convertCommunicationRequest((org.hl7.fhir.r4.model.CommunicationRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.Composition)
            return Composition10_40.convertComposition((org.hl7.fhir.r4.model.Composition) src);
        if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
            return ConceptMap10_40.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.r4.model.Condition)
            return Condition10_40.convertCondition((org.hl7.fhir.r4.model.Condition) src);
        if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
            return Conformance10_40.convertConformance((org.hl7.fhir.r4.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
            return DetectedIssue10_40.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceMetric)
            return DeviceMetric10_40.convertDeviceMetric((org.hl7.fhir.r4.model.DeviceMetric) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceUseStatement)
            return DeviceUseStatement10_40.convertDeviceUseStatement((org.hl7.fhir.r4.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
            return DiagnosticReport10_40.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
            return DocumentReference10_40.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.r4.model.Encounter)
            return Encounter10_40.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
        if (src instanceof org.hl7.fhir.r4.model.EnrollmentRequest)
            return EnrollmentRequest10_40.convertEnrollmentRequest((org.hl7.fhir.r4.model.EnrollmentRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.EnrollmentResponse)
            return EnrollmentResponse10_40.convertEnrollmentResponse((org.hl7.fhir.r4.model.EnrollmentResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
            return EpisodeOfCare10_40.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
            return FamilyMemberHistory10_40.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.r4.model.Flag)
            return Flag10_40.convertFlag((org.hl7.fhir.r4.model.Flag) src);
        if (src instanceof org.hl7.fhir.r4.model.Group)
            return Group10_40.convertGroup((org.hl7.fhir.r4.model.Group) src);
        if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
            return HealthcareService10_40.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
            return ImplementationGuide10_40.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.r4.model.ListResource)
            return List10_40.convertList((org.hl7.fhir.r4.model.ListResource) src);
        if (src instanceof org.hl7.fhir.r4.model.Location)
            return Location10_40.convertLocation((org.hl7.fhir.r4.model.Location) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
            return MedicationDispense10_40.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
            return MedicationStatement10_40.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
            return MessageHeader10_40.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
            return NamingSystem10_40.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.r4.model.Observation)
            return Observation10_40.convertObservation((org.hl7.fhir.r4.model.Observation) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
            return OperationDefinition10_40.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
            return OperationOutcome10_40.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.r4.model.Organization)
            return Organization10_40.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
        if (src instanceof org.hl7.fhir.r4.model.Patient)
            return Patient10_40.convertPatient((org.hl7.fhir.r4.model.Patient) src);
        if (src instanceof org.hl7.fhir.r4.model.Person)
            return Person10_40.convertPerson((org.hl7.fhir.r4.model.Person) src);
        if (src instanceof org.hl7.fhir.r4.model.Practitioner)
            return Practitioner10_40.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
            return Questionnaire10_40.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
            return QuestionnaireResponse10_40.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
            return RiskAssessment10_40.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.r4.model.Schedule)
            return Schedule10_40.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
        if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
            return SearchParameter10_40.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.r4.model.Slot)
            return Slot10_40.convertSlot((org.hl7.fhir.r4.model.Slot) src);
        if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
            return StructureDefinition10_40.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.Subscription)
            return Subscription10_40.convertSubscription((org.hl7.fhir.r4.model.Subscription) src);
        if (src instanceof org.hl7.fhir.r4.model.Substance)
            return Substance10_40.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
        if (src instanceof org.hl7.fhir.r4.model.SupplyDelivery)
            return SupplyDelivery10_40.convertSupplyDelivery((org.hl7.fhir.r4.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.r4.model.SupplyRequest)
            return SupplyRequest10_40.convertSupplyRequest((org.hl7.fhir.r4.model.SupplyRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.TestScript)
            return TestScript10_40.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);
        if (src instanceof org.hl7.fhir.r4.model.ValueSet)
            return ValueSet10_40.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src, advisor);
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static TerminologyCapabilities convertTerminologyCapabilities(Parameters src) {
        TerminologyCapabilities res = new TerminologyCapabilities();
        for (ParametersParameterComponent p : src.getParameter()) {
            if (p.getName().equals("system"))
                res.addCodeSystem().setUri(p.getValue().primitiveValue());
        }
        return res;
    }

    public static boolean convertsResource(String rt) {
        return Utilities.existsInList(rt, "Parameters", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "Bundle", "CarePlan", "Communication", "CommunicationRequest", "Composition", "ConceptMap", "Condition", "CapabilityStatement", "DetectedIssue", "DeviceMetric", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Group", "HealthcareService", "ImplementationGuide", "ListResource", "Location", "MedicationDispense", "MedicationStatement", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "Person", "Practitioner", "Questionnaire", "QuestionnaireResponse", "RiskAssessment", "Schedule", "SearchParameter", "Slot", "StructureDefinition", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "TestScript", "ValueSet");
    }

    public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
        return convertResource(src, null);
    }

    public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
        return convertResource(src, null);
    }
}