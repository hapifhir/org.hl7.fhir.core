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

public enum NehtaImagingExaminationResultStat {

  /**
   * No result yet available.
   */
  _1,
  /**
   * This is an initial or interim result: data may be missing or verification has
   * not been performed.
   */
  _2,
  /**
   * The result is complete and verified by the responsible radiologist.
   */
  _3,
  /**
   * The result has been modified subsequent to being Final, and is complete and
   * verified by the radiologist.
   */
  _4,
  /**
   * The result is not available because the examination was not started or
   * completed.
   */
  _5,
  /**
   * added to help the parsers
   */
  NULL;

  public static NehtaImagingExaminationResultStat fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("1".equals(codeString))
      return _1;
    if ("2".equals(codeString))
      return _2;
    if ("3".equals(codeString))
      return _3;
    if ("4".equals(codeString))
      return _4;
    if ("5".equals(codeString))
      return _5;
    throw new FHIRException("Unknown NehtaImagingExaminationResultStat code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case _1:
      return "1";
    case _2:
      return "2";
    case _3:
      return "3";
    case _4:
      return "4";
    case _5:
      return "5";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/imaging-examination-result-stat";
  }

  public String getDefinition() {
    switch (this) {
    case _1:
      return "No result yet available.";
    case _2:
      return "This is an initial or interim result: data may be missing or verification has not been performed.";
    case _3:
      return "The result is complete and verified by the responsible radiologist.";
    case _4:
      return "The result has been modified subsequent to being Final, and is complete and verified by the radiologist.";
    case _5:
      return "The result is not available because the examination was not started or completed.";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case _1:
      return "Registered";
    case _2:
      return "Interim";
    case _3:
      return "Final";
    case _4:
      return "Amended";
    case _5:
      return "Cancelled/Aborted";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}