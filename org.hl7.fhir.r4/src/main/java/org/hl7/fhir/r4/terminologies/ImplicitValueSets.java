package org.hl7.fhir.r4.terminologies;

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



import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.utilities.Utilities;

public class ImplicitValueSets {

  public static ValueSet build(String url) {
    if (Utilities.noString(url))
      return null;
    
    if (url.startsWith("http://snomed.info/sct"))
      return buildSnomedValueSet(url);
    if (url.startsWith("http://loinc.org/vs"))
      return buildLoincValueSet(url);
    if (url.equals("http://unitsofmeasure.org/vs"))
      return allUcumValueSet();
    return null;
  }

  private static ValueSet buildSnomedValueSet(String url) {
    return null;
  }

  private static ValueSet buildLoincValueSet(String url) {
    if (url.startsWith("http://loinc.org/vs/LL")) {
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setName("LoincVS"+url.substring(21).replace("-",  ""));
      vs.setTitle("Loinc Implicit ValueSet for "+url.substring(21));
      // todo: populate the compose fro the terminology server
      return vs;   
    } else if (url.equals("http://loinc.org/vs")) {
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setName("LoincVSAll");
      vs.setTitle("Loinc Implicit ValueSet : all codes");
      // todo: populate the compose for the terminology server
      return vs;   
    } else {
      return null;
    }
  }

  private static ValueSet allUcumValueSet() {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://unitsofmeasure.org/vs");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setName("AllUcumCodes");
    vs.setTitle("All Ucum Codes");
    vs.getCompose().addInclude().setSystem("http://unitsofmeasure.org");
    return vs;
  }

}