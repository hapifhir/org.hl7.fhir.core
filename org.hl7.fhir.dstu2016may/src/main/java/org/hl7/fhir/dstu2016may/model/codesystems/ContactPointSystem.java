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

public enum ContactPointSystem {

  /**
   * The value is a telephone number used for voice calls. Use of full
   * international numbers starting with + is recommended to enable automatic
   * dialing support but not required.
   */
  PHONE,
  /**
   * The value is a fax machine. Use of full international numbers starting with +
   * is recommended to enable automatic dialing support but not required.
   */
  FAX,
  /**
   * The value is an email address.
   */
  EMAIL,
  /**
   * The value is a pager number. These may be local pager numbers that are only
   * usable on a particular pager system.
   */
  PAGER,
  /**
   * A contact that is not a phone, fax, or email address. The format of the value
   * SHOULD be a URL. This is intended for various personal contacts including
   * blogs, Twitter, Facebook, etc. Do not use for email addresses. If this is not
   * a URL, then it will require human interpretation.
   */
  OTHER,
  /**
   * added to help the parsers
   */
  NULL;

  public static ContactPointSystem fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("phone".equals(codeString))
      return PHONE;
    if ("fax".equals(codeString))
      return FAX;
    if ("email".equals(codeString))
      return EMAIL;
    if ("pager".equals(codeString))
      return PAGER;
    if ("other".equals(codeString))
      return OTHER;
    throw new FHIRException("Unknown ContactPointSystem code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case PHONE:
      return "phone";
    case FAX:
      return "fax";
    case EMAIL:
      return "email";
    case PAGER:
      return "pager";
    case OTHER:
      return "other";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/contact-point-system";
  }

  public String getDefinition() {
    switch (this) {
    case PHONE:
      return "The value is a telephone number used for voice calls. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.";
    case FAX:
      return "The value is a fax machine. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.";
    case EMAIL:
      return "The value is an email address.";
    case PAGER:
      return "The value is a pager number. These may be local pager numbers that are only usable on a particular pager system.";
    case OTHER:
      return "A contact that is not a phone, fax, or email address. The format of the value SHOULD be a URL. This is intended for various personal contacts including blogs, Twitter, Facebook, etc. Do not use for email addresses. If this is not a URL, then it will require human interpretation.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case PHONE:
      return "Phone";
    case FAX:
      return "Fax";
    case EMAIL:
      return "Email";
    case PAGER:
      return "Pager";
    case OTHER:
      return "URL";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}