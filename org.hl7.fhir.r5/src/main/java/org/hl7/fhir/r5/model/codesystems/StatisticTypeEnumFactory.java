package org.hl7.fhir.r5.model.codesystems;

/*
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

// Generated on Thu, Oct 17, 2019 09:42+1100 for FHIR v4.1.0


import org.hl7.fhir.r5.model.EnumFactory;

public class StatisticTypeEnumFactory implements EnumFactory<StatisticType> {

  public StatisticType fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("absolute-MedianDiff".equals(codeString))
      return StatisticType.ABSOLUTEMEDIANDIFF;
    if ("C25463".equals(codeString))
      return StatisticType.C25463;
    if ("0000301".equals(codeString))
      return StatisticType._0000301;
    if ("predictedRisk".equals(codeString))
      return StatisticType.PREDICTEDRISK;
    if ("descriptive".equals(codeString))
      return StatisticType.DESCRIPTIVE;
    if ("C93150".equals(codeString))
      return StatisticType.C93150;
    if ("C16726".equals(codeString))
      return StatisticType.C16726;
    if ("rate-ratio".equals(codeString))
      return StatisticType.RATERATIO;
    if ("C25564".equals(codeString))
      return StatisticType.C25564;
    if ("C53319".equals(codeString))
      return StatisticType.C53319;
    if ("0000457".equals(codeString))
      return StatisticType._0000457;
    if ("C28007".equals(codeString))
      return StatisticType.C28007;
    if ("C25570".equals(codeString))
      return StatisticType.C25570;
    if ("C16932".equals(codeString))
      return StatisticType.C16932;
    if ("C65172".equals(codeString))
      return StatisticType.C65172;
    if ("C17010".equals(codeString))
      return StatisticType.C17010;
    if ("C44256".equals(codeString))
      return StatisticType.C44256;
    if ("0000565".equals(codeString))
      return StatisticType._0000565;
    if ("C93152".equals(codeString))
      return StatisticType.C93152;
    if ("0000424".equals(codeString))
      return StatisticType._0000424;
    if ("C65171".equals(codeString))
      return StatisticType.C65171;
    if ("0000100".equals(codeString))
      return StatisticType._0000100;
    throw new IllegalArgumentException("Unknown StatisticType code '"+codeString+"'");
  }

  public String toCode(StatisticType code) {
    if (code == StatisticType.ABSOLUTEMEDIANDIFF)
      return "absolute-MedianDiff";
    if (code == StatisticType.C25463)
      return "C25463";
    if (code == StatisticType._0000301)
      return "0000301";
    if (code == StatisticType.PREDICTEDRISK)
      return "predictedRisk";
    if (code == StatisticType.DESCRIPTIVE)
      return "descriptive";
    if (code == StatisticType.C93150)
      return "C93150";
    if (code == StatisticType.C16726)
      return "C16726";
    if (code == StatisticType.RATERATIO)
      return "rate-ratio";
    if (code == StatisticType.C25564)
      return "C25564";
    if (code == StatisticType.C53319)
      return "C53319";
    if (code == StatisticType._0000457)
      return "0000457";
    if (code == StatisticType.C28007)
      return "C28007";
    if (code == StatisticType.C25570)
      return "C25570";
    if (code == StatisticType.C16932)
      return "C16932";
    if (code == StatisticType.C65172)
      return "C65172";
    if (code == StatisticType.C17010)
      return "C17010";
    if (code == StatisticType.C44256)
      return "C44256";
    if (code == StatisticType._0000565)
      return "0000565";
    if (code == StatisticType.C93152)
      return "C93152";
    if (code == StatisticType._0000424)
      return "0000424";
    if (code == StatisticType.C65171)
      return "C65171";
    if (code == StatisticType._0000100)
      return "0000100";
    return "?";
  }

    public String toSystem(StatisticType code) {
      return code.getSystem();
      }

}

