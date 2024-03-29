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

public enum EventStatus {

  /**
   * The core event has not started yet, but some staging activities have begun
   * (e.g. surgical suite preparation). Preparation stages may be tracked for
   * billing purposes.
   */
  PREPARATION,
  /**
   * The event is currently occurring.
   */
  INPROGRESS,
  /**
   * The event was terminated prior to any activity beyond preparation. I.e. The
   * 'main' activity has not yet begun. The boundary between preparatory and the
   * 'main' activity is context-specific.
   */
  NOTDONE,
  /**
   * The event has been temporarily stopped but is expected to resume in the
   * future.
   */
  ONHOLD,
  /**
   * The event was terminated prior to the full completion of the intended
   * activity but after at least some of the 'main' activity (beyond preparation)
   * has occurred.
   */
  STOPPED,
  /**
   * The event has now concluded.
   */
  COMPLETED,
  /**
   * This electronic record should never have existed, though it is possible that
   * real-world decisions were based on it. (If real-world activity has occurred,
   * the status should be "cancelled" rather than "entered-in-error".).
   */
  ENTEREDINERROR,
  /**
   * The authoring/source system does not know which of the status values
   * currently applies for this event. Note: This concept is not to be used for
   * "other" - one of the listed statuses is presumed to apply, but the
   * authoring/source system does not know which.
   */
  UNKNOWN,
  /**
   * added to help the parsers
   */
  NULL;

  public static EventStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("preparation".equals(codeString))
      return PREPARATION;
    if ("in-progress".equals(codeString))
      return INPROGRESS;
    if ("not-done".equals(codeString))
      return NOTDONE;
    if ("on-hold".equals(codeString))
      return ONHOLD;
    if ("stopped".equals(codeString))
      return STOPPED;
    if ("completed".equals(codeString))
      return COMPLETED;
    if ("entered-in-error".equals(codeString))
      return ENTEREDINERROR;
    if ("unknown".equals(codeString))
      return UNKNOWN;
    throw new FHIRException("Unknown EventStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case PREPARATION:
      return "preparation";
    case INPROGRESS:
      return "in-progress";
    case NOTDONE:
      return "not-done";
    case ONHOLD:
      return "on-hold";
    case STOPPED:
      return "stopped";
    case COMPLETED:
      return "completed";
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
    return "http://hl7.org/fhir/event-status";
  }

  public String getDefinition() {
    switch (this) {
    case PREPARATION:
      return "The core event has not started yet, but some staging activities have begun (e.g. surgical suite preparation).  Preparation stages may be tracked for billing purposes.";
    case INPROGRESS:
      return "The event is currently occurring.";
    case NOTDONE:
      return "The event was terminated prior to any activity beyond preparation.  I.e. The 'main' activity has not yet begun.  The boundary between preparatory and the 'main' activity is context-specific.";
    case ONHOLD:
      return "The event has been temporarily stopped but is expected to resume in the future.";
    case STOPPED:
      return "The event was terminated prior to the full completion of the intended activity but after at least some of the 'main' activity (beyond preparation) has occurred.";
    case COMPLETED:
      return "The event has now concluded.";
    case ENTEREDINERROR:
      return "This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
    case UNKNOWN:
      return "The authoring/source system does not know which of the status values currently applies for this event.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case PREPARATION:
      return "Preparation";
    case INPROGRESS:
      return "In Progress";
    case NOTDONE:
      return "Not Done";
    case ONHOLD:
      return "On Hold";
    case STOPPED:
      return "Stopped";
    case COMPLETED:
      return "Completed";
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