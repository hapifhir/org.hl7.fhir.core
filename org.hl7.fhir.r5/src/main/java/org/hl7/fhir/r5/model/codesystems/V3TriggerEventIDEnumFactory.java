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

public class V3TriggerEventIDEnumFactory implements EnumFactory<V3TriggerEventID> {

  public V3TriggerEventID fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("POLB_TE004000UV".equals(codeString))
      return V3TriggerEventID.POLBTE004000UV;
    if ("POLB_TE004001UV".equals(codeString))
      return V3TriggerEventID.POLBTE004001UV;
    if ("POLB_TE004002UV".equals(codeString))
      return V3TriggerEventID.POLBTE004002UV;
    if ("POLB_TE004007UV".equals(codeString))
      return V3TriggerEventID.POLBTE004007UV;
    if ("POLB_TE004100UV".equals(codeString))
      return V3TriggerEventID.POLBTE004100UV;
    if ("POLB_TE004102UV".equals(codeString))
      return V3TriggerEventID.POLBTE004102UV;
    if ("POLB_TE004200UV".equals(codeString))
      return V3TriggerEventID.POLBTE004200UV;
    if ("POLB_TE004201UV".equals(codeString))
      return V3TriggerEventID.POLBTE004201UV;
    if ("POLB_TE004202UV".equals(codeString))
      return V3TriggerEventID.POLBTE004202UV;
    if ("POLB_TE004301UV".equals(codeString))
      return V3TriggerEventID.POLBTE004301UV;
    if ("POLB_TE004500UV".equals(codeString))
      return V3TriggerEventID.POLBTE004500UV;
    throw new IllegalArgumentException("Unknown V3TriggerEventID code '"+codeString+"'");
  }

  public String toCode(V3TriggerEventID code) {
    if (code == V3TriggerEventID.POLBTE004000UV)
      return "POLB_TE004000UV";
    if (code == V3TriggerEventID.POLBTE004001UV)
      return "POLB_TE004001UV";
    if (code == V3TriggerEventID.POLBTE004002UV)
      return "POLB_TE004002UV";
    if (code == V3TriggerEventID.POLBTE004007UV)
      return "POLB_TE004007UV";
    if (code == V3TriggerEventID.POLBTE004100UV)
      return "POLB_TE004100UV";
    if (code == V3TriggerEventID.POLBTE004102UV)
      return "POLB_TE004102UV";
    if (code == V3TriggerEventID.POLBTE004200UV)
      return "POLB_TE004200UV";
    if (code == V3TriggerEventID.POLBTE004201UV)
      return "POLB_TE004201UV";
    if (code == V3TriggerEventID.POLBTE004202UV)
      return "POLB_TE004202UV";
    if (code == V3TriggerEventID.POLBTE004301UV)
      return "POLB_TE004301UV";
    if (code == V3TriggerEventID.POLBTE004500UV)
      return "POLB_TE004500UV";
    return "?";
  }

    public String toSystem(V3TriggerEventID code) {
      return code.getSystem();
      }

}

