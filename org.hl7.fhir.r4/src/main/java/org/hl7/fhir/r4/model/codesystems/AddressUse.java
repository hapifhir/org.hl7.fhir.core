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

public enum AddressUse {

  /**
   * A communication address at a home.
   */
  HOME,
  /**
   * An office address. First choice for business related contacts during business
   * hours.
   */
  WORK,
  /**
   * A temporary address. The period can provide more detailed information.
   */
  TEMP,
  /**
   * This address is no longer in use (or was never correct but retained for
   * records).
   */
  OLD,
  /**
   * An address to be used to send bills, invoices, receipts etc.
   */
  BILLING,
  /**
   * added to help the parsers
   */
  NULL;

  public static AddressUse fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("home".equals(codeString))
      return HOME;
    if ("work".equals(codeString))
      return WORK;
    if ("temp".equals(codeString))
      return TEMP;
    if ("old".equals(codeString))
      return OLD;
    if ("billing".equals(codeString))
      return BILLING;
    throw new FHIRException("Unknown AddressUse code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case HOME:
      return "home";
    case WORK:
      return "work";
    case TEMP:
      return "temp";
    case OLD:
      return "old";
    case BILLING:
      return "billing";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/address-use";
  }

  public String getDefinition() {
    switch (this) {
    case HOME:
      return "A communication address at a home.";
    case WORK:
      return "An office address. First choice for business related contacts during business hours.";
    case TEMP:
      return "A temporary address. The period can provide more detailed information.";
    case OLD:
      return "This address is no longer in use (or was never correct but retained for records).";
    case BILLING:
      return "An address to be used to send bills, invoices, receipts etc.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case HOME:
      return "Home";
    case WORK:
      return "Work";
    case TEMP:
      return "Temporary";
    case OLD:
      return "Old / Incorrect";
    case BILLING:
      return "Billing";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}