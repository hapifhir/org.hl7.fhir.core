package org.hl7.fhir.r5.model.codesystems;

/*-
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

// Generated on Sun, Jun 30, 2019 16:52-0400 for FHIR v4.1.0


import org.hl7.fhir.r5.model.EnumFactory;

public class SubscriberRelationshipEnumFactory implements EnumFactory<SubscriberRelationship> {

  public SubscriberRelationship fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("child".equals(codeString))
      return SubscriberRelationship.CHILD;
    if ("parent".equals(codeString))
      return SubscriberRelationship.PARENT;
    if ("spouse".equals(codeString))
      return SubscriberRelationship.SPOUSE;
    if ("common".equals(codeString))
      return SubscriberRelationship.COMMON;
    if ("other".equals(codeString))
      return SubscriberRelationship.OTHER;
    if ("self".equals(codeString))
      return SubscriberRelationship.SELF;
    if ("injured".equals(codeString))
      return SubscriberRelationship.INJURED;
    throw new IllegalArgumentException("Unknown SubscriberRelationship code '"+codeString+"'");
  }

  public String toCode(SubscriberRelationship code) {
    if (code == SubscriberRelationship.CHILD)
      return "child";
    if (code == SubscriberRelationship.PARENT)
      return "parent";
    if (code == SubscriberRelationship.SPOUSE)
      return "spouse";
    if (code == SubscriberRelationship.COMMON)
      return "common";
    if (code == SubscriberRelationship.OTHER)
      return "other";
    if (code == SubscriberRelationship.SELF)
      return "self";
    if (code == SubscriberRelationship.INJURED)
      return "injured";
    return "?";
  }

    public String toSystem(SubscriberRelationship code) {
      return code.getSystem();
      }

}

