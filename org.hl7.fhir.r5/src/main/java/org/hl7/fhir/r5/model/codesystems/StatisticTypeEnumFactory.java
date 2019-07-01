package org.hl7.fhir.r5.model.codesystems;

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

// Generated on Sun, Jun 30, 2019 16:52-0400 for FHIR v4.1.0


import org.hl7.fhir.r5.model.EnumFactory;

public class StatisticTypeEnumFactory implements EnumFactory<StatisticType> {

  public StatisticType fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("relative-RR".equals(codeString))
      return StatisticType.RELATIVERR;
    if ("relative-OR".equals(codeString))
      return StatisticType.RELATIVEOR;
    if ("relative-HR".equals(codeString))
      return StatisticType.RELATIVEHR;
    if ("absolute-ARD".equals(codeString))
      return StatisticType.ABSOLUTEARD;
    if ("absolute-MeanDiff".equals(codeString))
      return StatisticType.ABSOLUTEMEANDIFF;
    if ("absolute-SMD".equals(codeString))
      return StatisticType.ABSOLUTESMD;
    if ("absolute-MedianDiff".equals(codeString))
      return StatisticType.ABSOLUTEMEDIANDIFF;
    if ("proportion".equals(codeString))
      return StatisticType.PROPORTION;
    if ("derivedProportion".equals(codeString))
      return StatisticType.DERIVEDPROPORTION;
    if ("mean".equals(codeString))
      return StatisticType.MEAN;
    if ("median".equals(codeString))
      return StatisticType.MEDIAN;
    if ("count".equals(codeString))
      return StatisticType.COUNT;
    if ("descriptive".equals(codeString))
      return StatisticType.DESCRIPTIVE;
    throw new IllegalArgumentException("Unknown StatisticType code '"+codeString+"'");
  }

  public String toCode(StatisticType code) {
    if (code == StatisticType.RELATIVERR)
      return "relative-RR";
    if (code == StatisticType.RELATIVEOR)
      return "relative-OR";
    if (code == StatisticType.RELATIVEHR)
      return "relative-HR";
    if (code == StatisticType.ABSOLUTEARD)
      return "absolute-ARD";
    if (code == StatisticType.ABSOLUTEMEANDIFF)
      return "absolute-MeanDiff";
    if (code == StatisticType.ABSOLUTESMD)
      return "absolute-SMD";
    if (code == StatisticType.ABSOLUTEMEDIANDIFF)
      return "absolute-MedianDiff";
    if (code == StatisticType.PROPORTION)
      return "proportion";
    if (code == StatisticType.DERIVEDPROPORTION)
      return "derivedProportion";
    if (code == StatisticType.MEAN)
      return "mean";
    if (code == StatisticType.MEDIAN)
      return "median";
    if (code == StatisticType.COUNT)
      return "count";
    if (code == StatisticType.DESCRIPTIVE)
      return "descriptive";
    return "?";
  }

    public String toSystem(StatisticType code) {
      return code.getSystem();
      }

}

