package org.hl7.fhir.r4.model.codesystems;

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

// Generated on Wed, Jan 30, 2019 16:19-0500 for FHIR v4.0.0

import org.hl7.fhir.exceptions.FHIRException;

public enum DiagnosticReportStatus {

  /**
   * The existence of the report is registered, but there is nothing yet
   * available.
   */
  REGISTERED,
  /**
   * This is a partial (e.g. initial, interim or preliminary) report: data in the
   * report may be incomplete or unverified.
   */
  PARTIAL,
  /**
   * Verified early results are available, but not all results are final.
   */
  PRELIMINARY,
  /**
   * The report is complete and verified by an authorized person.
   */
  FINAL,
  /**
   * Subsequent to being final, the report has been modified. This includes any
   * change in the results, diagnosis, narrative text, or other content of a
   * report that has been issued.
   */
  AMENDED,
  /**
   * Subsequent to being final, the report has been modified to correct an error
   * in the report or referenced results.
   */
  CORRECTED,
  /**
   * Subsequent to being final, the report has been modified by adding new
   * content. The existing content is unchanged.
   */
  APPENDED,
  /**
   * The report is unavailable because the measurement was not started or not
   * completed (also sometimes called "aborted").
   */
  CANCELLED,
  /**
   * The report has been withdrawn following a previous final release. This
   * electronic record should never have existed, though it is possible that
   * real-world decisions were based on it. (If real-world activity has occurred,
   * the status should be "cancelled" rather than "entered-in-error".).
   */
  ENTEREDINERROR,
  /**
   * The authoring/source system does not know which of the status values
   * currently applies for this observation. Note: This concept is not to be used
   * for "other" - one of the listed statuses is presumed to apply, but the
   * authoring/source system does not know which.
   */
  UNKNOWN,
  /**
   * added to help the parsers
   */
  NULL;

  public static DiagnosticReportStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("registered".equals(codeString))
      return REGISTERED;
    if ("partial".equals(codeString))
      return PARTIAL;
    if ("preliminary".equals(codeString))
      return PRELIMINARY;
    if ("final".equals(codeString))
      return FINAL;
    if ("amended".equals(codeString))
      return AMENDED;
    if ("corrected".equals(codeString))
      return CORRECTED;
    if ("appended".equals(codeString))
      return APPENDED;
    if ("cancelled".equals(codeString))
      return CANCELLED;
    if ("entered-in-error".equals(codeString))
      return ENTEREDINERROR;
    if ("unknown".equals(codeString))
      return UNKNOWN;
    throw new FHIRException("Unknown DiagnosticReportStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case REGISTERED:
      return "registered";
    case PARTIAL:
      return "partial";
    case PRELIMINARY:
      return "preliminary";
    case FINAL:
      return "final";
    case AMENDED:
      return "amended";
    case CORRECTED:
      return "corrected";
    case APPENDED:
      return "appended";
    case CANCELLED:
      return "cancelled";
    case ENTEREDINERROR:
      return "entered-in-error";
    case UNKNOWN:
      return "unknown";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/diagnostic-report-status";
  }

  public String getDefinition() {
    switch (this) {
    case REGISTERED:
      return "The existence of the report is registered, but there is nothing yet available.";
    case PARTIAL:
      return "This is a partial (e.g. initial, interim or preliminary) report: data in the report may be incomplete or unverified.";
    case PRELIMINARY:
      return "Verified early results are available, but not all  results are final.";
    case FINAL:
      return "The report is complete and verified by an authorized person.";
    case AMENDED:
      return "Subsequent to being final, the report has been modified.  This includes any change in the results, diagnosis, narrative text, or other content of a report that has been issued.";
    case CORRECTED:
      return "Subsequent to being final, the report has been modified  to correct an error in the report or referenced results.";
    case APPENDED:
      return "Subsequent to being final, the report has been modified by adding new content. The existing content is unchanged.";
    case CANCELLED:
      return "The report is unavailable because the measurement was not started or not completed (also sometimes called \"aborted\").";
    case ENTEREDINERROR:
      return "The report has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
    case UNKNOWN:
      return "The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case REGISTERED:
      return "Registered";
    case PARTIAL:
      return "Partial";
    case PRELIMINARY:
      return "Preliminary";
    case FINAL:
      return "Final";
    case AMENDED:
      return "Amended";
    case CORRECTED:
      return "Corrected";
    case APPENDED:
      return "Appended";
    case CANCELLED:
      return "Cancelled";
    case ENTEREDINERROR:
      return "Entered in Error";
    case UNKNOWN:
      return "Unknown";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}