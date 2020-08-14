package org.hl7.fhir.utilities;

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



public class OIDUtils {

	/*
  2.16.840.1.113883.3.72.5.2 - NIST owns this
  2.16.840.1.113883.4.6 - National Provider Identifier
  2.16.840.1.113883.6.21 - UB92
  2.16.840.1.113883.6.69 - NDC
	 */

	public static String getUriForOid(String r) {
	  if (r == null) {
	    return null;
	  }
		if (r.equals("2.16.840.1.113883.6.96"))
			return "http://snomed.info/sct";
		if (r.equals("2.16.840.1.113883.6.1"))
			return "http://loinc.org";
		if (r.equals("2.16.840.1.113883.6.8"))
			return "http://unitsofmeasure.org";
		if (r.equals("2.16.840.1.113883.6.3"))
			return "http://hl7.org/fhir/sid/icd-10";
		if (r.equals("2.16.840.1.113883.6.42"))
			return "http://hl7.org/fhir/sid/icd-9";
		if (r.equals("2.16.840.1.113883.6.104"))
			return "http://hl7.org/fhir/sid/icd-9";
		if (r.equals("2.16.840.1.113883.6.103"))
			return "http://hl7.org/fhir/sid/icd-9"; //todo: confirm this		
		if (r.equals("2.16.840.1.113883.6.73"))
			return "http://www.whocc.no/atc";
		if (r.equals("2.16.840.1.113883.3.26.1.1"))
			return "http://ncimeta.nci.nih.gov";
		if (r.equals("2.16.840.1.113883.3.26.1.1.1"))
			return "http://ncimeta.nci.nih.gov";
		if (r.equals("2.16.840.1.113883.6.88"))
			return "http://www.nlm.nih.gov/research/umls/rxnorm"; // todo: confirm this

		if (r.equals("2.16.840.1.113883.5.1008"))
			return "http://terminology.hl7.org/v3/NullFlavor";
		if (r.equals("2.16.840.1.113883.5.111"))
			return "http://terminology.hl7.org/v3/RoleCode";
		if (r.equals("2.16.840.1.113883.5.4"))
			return "http://terminology.hl7.org/v3/ActCode";
		if (r.equals("2.16.840.1.113883.5.8"))
			return "http://terminology.hl7.org/v3/ActReason";
		if (r.equals("2.16.840.1.113883.5.83"))
			return "http://terminology.hl7.org/v3/ObservationInterpretation";
		if (r.equals("2.16.840.1.113883.6.238"))
			return "http://terminology.hl7.org/v3/Race";

		if (r.equals("2.16.840.1.113883.6.59"))
			return "http://hl7.org/fhir/sid/cvx";
		if (r.equals("2.16.840.1.113883.12.292"))
			return "http://hl7.org/fhir/sid/cvx";

		if (r.equals("2.16.840.1.113883.6.12"))
			return "http://www.ama-assn.org/go/cpt";

		if (r.startsWith("2.16.840.1.113883.12."))
			return "http://hl7.org/fhir/sid/v2-"+r.substring(21);
		return null;
	}

}