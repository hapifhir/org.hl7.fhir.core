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

public class ExDiagnosistypeEnumFactory implements EnumFactory<ExDiagnosistype> {

  public ExDiagnosistype fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("admitting".equals(codeString))
      return ExDiagnosistype.ADMITTING;
    if ("clinical".equals(codeString))
      return ExDiagnosistype.CLINICAL;
    if ("differential".equals(codeString))
      return ExDiagnosistype.DIFFERENTIAL;
    if ("discharge".equals(codeString))
      return ExDiagnosistype.DISCHARGE;
    if ("laboratory".equals(codeString))
      return ExDiagnosistype.LABORATORY;
    if ("nursing".equals(codeString))
      return ExDiagnosistype.NURSING;
    if ("prenatal".equals(codeString))
      return ExDiagnosistype.PRENATAL;
    if ("principal".equals(codeString))
      return ExDiagnosistype.PRINCIPAL;
    if ("radiology".equals(codeString))
      return ExDiagnosistype.RADIOLOGY;
    if ("remote".equals(codeString))
      return ExDiagnosistype.REMOTE;
    if ("retrospective".equals(codeString))
      return ExDiagnosistype.RETROSPECTIVE;
    if ("self".equals(codeString))
      return ExDiagnosistype.SELF;
    throw new IllegalArgumentException("Unknown ExDiagnosistype code '" + codeString + "'");
  }

  public String toCode(ExDiagnosistype code) {
       if (code == ExDiagnosistype.NULL)
           return null;
       if (code == ExDiagnosistype.ADMITTING)
      return "admitting";
    if (code == ExDiagnosistype.CLINICAL)
      return "clinical";
    if (code == ExDiagnosistype.DIFFERENTIAL)
      return "differential";
    if (code == ExDiagnosistype.DISCHARGE)
      return "discharge";
    if (code == ExDiagnosistype.LABORATORY)
      return "laboratory";
    if (code == ExDiagnosistype.NURSING)
      return "nursing";
    if (code == ExDiagnosistype.PRENATAL)
      return "prenatal";
    if (code == ExDiagnosistype.PRINCIPAL)
      return "principal";
    if (code == ExDiagnosistype.RADIOLOGY)
      return "radiology";
    if (code == ExDiagnosistype.REMOTE)
      return "remote";
    if (code == ExDiagnosistype.RETROSPECTIVE)
      return "retrospective";
    if (code == ExDiagnosistype.SELF)
      return "self";
    return "?";
   }

  public String toSystem(ExDiagnosistype code) {
    return code.getSystem();
  }

}