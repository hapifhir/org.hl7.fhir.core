package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.OperationOutcome;

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

public class OperationOutcome40_N {

  // R6 removed issue.location; R4 locations go in this
  // R6 issue codes R4 doesn't have
  public static final String SEVERITY_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-OperationOutcome.issue.severity";
  public static final String TYPE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-OperationOutcome.issue.code";
  public static final String ISSUE_LOCATION_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-OperationOutcome.issue.location";

  public static org.hl7.fhir.model.core.OperationOutcome convertOperationOutcome(org.hl7.fhir.r4.model.OperationOutcome src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationOutcome tgt = new org.hl7.fhir.model.core.OperationOutcome();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.model.core.OperationOutcome src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationOutcome tgt = new org.hl7.fhir.r4.model.OperationOutcome();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssueList())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.StringType t : src.getLocation())
      tgt.addExtension(ISSUE_LOCATION_EXTENSION_URL, String40_N.convertString(t));
    if (src.hasSeverity())
      tgt.setSeverityElement(CrossVersionElements40_N.toR6Code(src.getSeverityElement(), convertIssueSeverity(src.getSeverityElement()), src.fhirType(), "severity"));
    if (src.hasCode())
      tgt.setCodeElement(CrossVersionElements40_N.toR6Code(src.getCodeElement(), convertIssueType(src.getCodeElement()), src.fhirType(), "code"));
    if (src.hasDetails())
      tgt.setDetails(CodeableConcept40_N.convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(String40_N.convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getExpression())
      tgt.getExpressionList().add(String40_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, ISSUE_LOCATION_EXTENSION_URL);
    for (org.hl7.fhir.model.core.Extension ext : src.getExtensionsByUrl(ISSUE_LOCATION_EXTENSION_URL))
      tgt.getLocation().add(String40_N.convertString((org.hl7.fhir.model.core.StringType) ext.getValue()));
    if (src.hasSeverity())
      tgt.setSeverityElement(CrossVersionElements40_N.toR4Code(src.getSeverityElement(), convertIssueSeverity(src.getSeverityElement()), src.fhirType(), "severity"));
    if (src.hasCode())
      tgt.setCodeElement(CrossVersionElements40_N.toR4Code(src.getCodeElement(), convertIssueType(src.getCodeElement()), src.fhirType(), "code"));
    if (src.hasDetails())
      tgt.setDetails(CodeableConcept40_N.convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(String40_N.convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getExpressionList())
      tgt.getExpression().add(String40_N.convertString(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationOutcome.IssueSeverity> convertIssueSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<OperationOutcome.IssueSeverity> tgt = new Enumeration<>(new OperationOutcome.IssueSeverityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, SEVERITY_EXTENSION_URL);
      if (src.hasExtension(SEVERITY_EXTENSION_URL)) {
          tgt.setValueAsString(src.getExtensionString(SEVERITY_EXTENSION_URL));
      } else if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case FATAL:
                  tgt.setValue(OperationOutcome.IssueSeverity.FATAL);
                  break;
              case ERROR:
                  tgt.setValue(OperationOutcome.IssueSeverity.ERROR);
                  break;
              case WARNING:
                  tgt.setValue(OperationOutcome.IssueSeverity.WARNING);
                  break;
              case INFORMATION:
                  tgt.setValue(OperationOutcome.IssueSeverity.INFORMATION);
                  break;
              default:
                  tgt.setValue(OperationOutcome.IssueSeverity.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity> convertIssueSeverity(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationOutcome.IssueSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.OperationOutcome.IssueSeverityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case FATAL:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.FATAL);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.ERROR);
                  break;
              case WARNING:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.WARNING);
                  break;
              case INFORMATION:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.INFORMATION);
                  break;
              case SUCCESS:
                  // R4 doesn't have success: information, with the R6 code kept
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.INFORMATION);
                  tgt.addExtension(SEVERITY_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getCode()));
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationOutcome.IssueType> convertIssueType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationOutcome.IssueType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<OperationOutcome.IssueType> tgt = new Enumeration<>(new OperationOutcome.IssueTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, TYPE_EXTENSION_URL);
      if (src.hasExtension(TYPE_EXTENSION_URL)) {
          tgt.setValueAsString(src.getExtensionString(TYPE_EXTENSION_URL));
      } else if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INVALID:
                  tgt.setValue(OperationOutcome.IssueType.INVALID);
                  break;
              case STRUCTURE:
                  tgt.setValue(OperationOutcome.IssueType.STRUCTURE);
                  break;
              case REQUIRED:
                  tgt.setValue(OperationOutcome.IssueType.REQUIRED);
                  break;
              case VALUE:
                  tgt.setValue(OperationOutcome.IssueType.VALUE);
                  break;
              case INVARIANT:
                  tgt.setValue(OperationOutcome.IssueType.INVARIANT);
                  break;
              case SECURITY:
                  tgt.setValue(OperationOutcome.IssueType.SECURITY);
                  break;
              case LOGIN:
                  tgt.setValue(OperationOutcome.IssueType.LOGIN);
                  break;
              case UNKNOWN:
                  tgt.setValue(OperationOutcome.IssueType.UNKNOWN);
                  break;
              case EXPIRED:
                  tgt.setValue(OperationOutcome.IssueType.EXPIRED);
                  break;
              case FORBIDDEN:
                  tgt.setValue(OperationOutcome.IssueType.FORBIDDEN);
                  break;
              case SUPPRESSED:
                  tgt.setValue(OperationOutcome.IssueType.SUPPRESSED);
                  break;
              case PROCESSING:
                  tgt.setValue(OperationOutcome.IssueType.PROCESSING);
                  break;
              case NOTSUPPORTED:
                  tgt.setValue(OperationOutcome.IssueType.NOTSUPPORTED);
                  break;
              case DUPLICATE:
                  tgt.setValue(OperationOutcome.IssueType.DUPLICATE);
                  break;
              case MULTIPLEMATCHES:
                  tgt.setValue(OperationOutcome.IssueType.MULTIPLEMATCHES);
                  break;
              case NOTFOUND:
                  tgt.setValue(OperationOutcome.IssueType.NOTFOUND);
                  break;
              case DELETED:
                  tgt.setValue(OperationOutcome.IssueType.DELETED);
                  break;
              case TOOLONG:
                  tgt.setValue(OperationOutcome.IssueType.TOOLONG);
                  break;
              case CODEINVALID:
                  tgt.setValue(OperationOutcome.IssueType.CODEINVALID);
                  break;
              case EXTENSION:
                  tgt.setValue(OperationOutcome.IssueType.EXTENSION);
                  break;
              case TOOCOSTLY:
                  tgt.setValue(OperationOutcome.IssueType.TOOCOSTLY);
                  break;
              case BUSINESSRULE:
                  tgt.setValue(OperationOutcome.IssueType.BUSINESSRULE);
                  break;
              case CONFLICT:
                  tgt.setValue(OperationOutcome.IssueType.CONFLICT);
                  break;
              case TRANSIENT:
                  tgt.setValue(OperationOutcome.IssueType.TRANSIENT);
                  break;
              case LOCKERROR:
                  tgt.setValue(OperationOutcome.IssueType.LOCKERROR);
                  break;
              case NOSTORE:
                  tgt.setValue(OperationOutcome.IssueType.NOSTORE);
                  break;
              case EXCEPTION:
                  tgt.setValue(OperationOutcome.IssueType.EXCEPTION);
                  break;
              case TIMEOUT:
                  tgt.setValue(OperationOutcome.IssueType.TIMEOUT);
                  break;
              case INCOMPLETE:
                  tgt.setValue(OperationOutcome.IssueType.INCOMPLETE);
                  break;
              case THROTTLED:
                  tgt.setValue(OperationOutcome.IssueType.THROTTLED);
                  break;
              case INFORMATIONAL:
                  tgt.setValue(OperationOutcome.IssueType.INFORMATIONAL);
                  break;
              default:
                  tgt.setValue(OperationOutcome.IssueType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationOutcome.IssueType> convertIssueType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationOutcome.IssueType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationOutcome.IssueType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.OperationOutcome.IssueTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INVALID:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.INVALID);
                  break;
              case STRUCTURE:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.STRUCTURE);
                  break;
              case REQUIRED:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.REQUIRED);
                  break;
              case VALUE:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.VALUE);
                  break;
              case INVARIANT:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.INVARIANT);
                  break;
              case SECURITY:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.SECURITY);
                  break;
              case LOGIN:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.LOGIN);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.UNKNOWN);
                  break;
              case EXPIRED:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXPIRED);
                  break;
              case FORBIDDEN:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.FORBIDDEN);
                  break;
              case SUPPRESSED:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.SUPPRESSED);
                  break;
              case PROCESSING:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.PROCESSING);
                  break;
              case NOTSUPPORTED:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOTSUPPORTED);
                  break;
              case DUPLICATE:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.DUPLICATE);
                  break;
              case MULTIPLEMATCHES:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.MULTIPLEMATCHES);
                  break;
              case NOTFOUND:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOTFOUND);
                  break;
              case DELETED:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.DELETED);
                  break;
              case TOOLONG:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.TOOLONG);
                  break;
              case CODEINVALID:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.CODEINVALID);
                  break;
              case EXTENSION:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXTENSION);
                  break;
              case TOOCOSTLY:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.TOOCOSTLY);
                  break;
              case BUSINESSRULE:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.BUSINESSRULE);
                  break;
              case CONFLICT:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.CONFLICT);
                  break;
              case TRANSIENT:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.TRANSIENT);
                  break;
              case LOCKERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.LOCKERROR);
                  break;
              case NOSTORE:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOSTORE);
                  break;
              case EXCEPTION:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXCEPTION);
                  break;
              case TIMEOUT:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.TIMEOUT);
                  break;
              case INCOMPLETE:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.INCOMPLETE);
                  break;
              case THROTTLED:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.THROTTLED);
                  break;
              case INFORMATIONAL:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.INFORMATIONAL);
                  break;
              case SUCCESS:
              case LIMITEDFILTER:
                  // R4 doesn't have these: informational, with the R6 code kept
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.INFORMATIONAL);
                  tgt.addExtension(TYPE_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getCode()));
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.OperationOutcome.IssueType.NULL);
                  break;
          }
      }
      return tgt;
  }
}