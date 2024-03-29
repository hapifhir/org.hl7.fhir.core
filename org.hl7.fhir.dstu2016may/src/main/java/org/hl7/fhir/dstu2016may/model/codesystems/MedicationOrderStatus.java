package org.hl7.fhir.dstu2016may.model.codesystems;

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

// Generated on Sun, May 8, 2016 03:05+1000 for FHIR v1.4.0

import org.hl7.fhir.exceptions.FHIRException;

public enum MedicationOrderStatus {

  /**
   * The prescription is 'actionable', but not all actions that are implied by it
   * have occurred yet.
   */
  ACTIVE,
  /**
   * Actions implied by the prescription are to be temporarily halted, but are
   * expected to continue later. May also be called "suspended".
   */
  ONHOLD,
  /**
   * All actions that are implied by the prescription have occurred.
   */
  COMPLETED,
  /**
   * The prescription was entered in error.
   */
  ENTEREDINERROR,
  /**
   * Actions implied by the prescription are to be permanently halted, before all
   * of them occurred.
   */
  STOPPED,
  /**
   * The prescription is not yet 'actionable', i.e. it is a work in progress,
   * requires sign-off or verification, and needs to be run through decision
   * support process.
   */
  DRAFT,
  /**
   * added to help the parsers
   */
  NULL;

  public static MedicationOrderStatus fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("active".equals(codeString))
      return ACTIVE;
    if ("on-hold".equals(codeString))
      return ONHOLD;
    if ("completed".equals(codeString))
      return COMPLETED;
    if ("entered-in-error".equals(codeString))
      return ENTEREDINERROR;
    if ("stopped".equals(codeString))
      return STOPPED;
    if ("draft".equals(codeString))
      return DRAFT;
    throw new FHIRException("Unknown MedicationOrderStatus code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case ACTIVE:
      return "active";
    case ONHOLD:
      return "on-hold";
    case COMPLETED:
      return "completed";
    case ENTEREDINERROR:
      return "entered-in-error";
    case STOPPED:
      return "stopped";
    case DRAFT:
      return "draft";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/medication-order-status";
  }

  public String getDefinition() {
    switch (this) {
    case ACTIVE:
      return "The prescription is 'actionable', but not all actions that are implied by it have occurred yet.";
    case ONHOLD:
      return "Actions implied by the prescription are to be temporarily halted, but are expected to continue later.  May also be called \"suspended\".";
    case COMPLETED:
      return "All actions that are implied by the prescription have occurred.";
    case ENTEREDINERROR:
      return "The prescription was entered in error.";
    case STOPPED:
      return "Actions implied by the prescription are to be permanently halted, before all of them occurred.";
    case DRAFT:
      return "The prescription is not yet 'actionable', i.e. it is a work in progress, requires sign-off or verification, and needs to be run through decision support process.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case ACTIVE:
      return "Active";
    case ONHOLD:
      return "On Hold";
    case COMPLETED:
      return "Completed";
    case ENTEREDINERROR:
      return "Entered In Error";
    case STOPPED:
      return "Stopped";
    case DRAFT:
      return "Draft";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}