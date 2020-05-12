package org.hl7.fhir.convertors;

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



import java.net.URISyntaxException;

import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.terminologies.TerminologyClientR5;
import org.hl7.fhir.utilities.Utilities;

public class TerminologyClientFactory {

  public static TerminologyClient makeClient(String url, FhirPublication v) throws URISyntaxException {
    if (v == null)
      return new TerminologyClientR5(checkEndsWith("/r4", url));
    switch (v) {
    case DSTU2016May: return new TerminologyClientR3(checkEndsWith("/r3", url)); // r3 is the least worst match 
    case DSTU1: throw new Error("The version "+v.toString()+" is not currently supported");
    case DSTU2: return new TerminologyClientR2(checkEndsWith("/r2", url));
    case R4: return new TerminologyClientR5(checkEndsWith("/r4", url));
    case R5: return new TerminologyClientR5(checkEndsWith("/r4", url)); // r4 for now, since the terminology is currently the same
    case STU3: return new TerminologyClientR3(checkEndsWith("/r3", url));
    default: throw new Error("The version "+v.toString()+" is not currently supported");
    }
  }
  
  private static String checkEndsWith(String term, String url) {
    if (url.endsWith(term))
      return url;
    if (url.startsWith("http://tx.fhir.org"))
      return Utilities.pathURL(url, term);
    if (url.equals("http://local.fhir.org:960"))
      return Utilities.pathURL(url, term);
    return url;
  }

}