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

import org.hl7.fhir.r4.model.EnumFactory;

public class AuditSourceTypeEnumFactory implements EnumFactory<AuditSourceType> {

  public AuditSourceType fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("1".equals(codeString))
      return AuditSourceType._1;
    if ("2".equals(codeString))
      return AuditSourceType._2;
    if ("3".equals(codeString))
      return AuditSourceType._3;
    if ("4".equals(codeString))
      return AuditSourceType._4;
    if ("5".equals(codeString))
      return AuditSourceType._5;
    if ("6".equals(codeString))
      return AuditSourceType._6;
    if ("7".equals(codeString))
      return AuditSourceType._7;
    if ("8".equals(codeString))
      return AuditSourceType._8;
    if ("9".equals(codeString))
      return AuditSourceType._9;
    throw new IllegalArgumentException("Unknown AuditSourceType code '" + codeString + "'");
  }

  public String toCode(AuditSourceType code) {
       if (code == AuditSourceType.NULL)
           return null;
       if (code == AuditSourceType._1)
      return "1";
    if (code == AuditSourceType._2)
      return "2";
    if (code == AuditSourceType._3)
      return "3";
    if (code == AuditSourceType._4)
      return "4";
    if (code == AuditSourceType._5)
      return "5";
    if (code == AuditSourceType._6)
      return "6";
    if (code == AuditSourceType._7)
      return "7";
    if (code == AuditSourceType._8)
      return "8";
    if (code == AuditSourceType._9)
      return "9";
    return "?";
   }

  public String toSystem(AuditSourceType code) {
    return code.getSystem();
  }

}