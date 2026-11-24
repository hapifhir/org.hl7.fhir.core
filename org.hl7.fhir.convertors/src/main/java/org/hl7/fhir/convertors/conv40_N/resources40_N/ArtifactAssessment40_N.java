package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.exceptions.FHIRException;

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

/**
 * ArtifactAssessment is new in R5, so R4 has nothing for it: like the other new resources, it's a Basic with the code
 * http://hl7.org/fhir/fhir-types#ArtifactAssessment. identifier maps to Basic's; everything else is a cross-version
 * extension (5.0, except relatesTo, which R6 changed)
 */
public class ArtifactAssessment40_N {

  public static final String TYPE_SYSTEM = "http://hl7.org/fhir/fhir-types";
  public static final String TYPE_CODE = "ArtifactAssessment";

  private static final String[] V5 = {"title", "citeAs", "artifact", "date", "copyright", "approvalDate", "lastReviewDate", "content",
    "workflowStatus", "disposition"};
  private static final String[] V6 = {"relatesTo"};

  public static boolean isArtifactAssessment(org.hl7.fhir.r4.model.Basic src) {
    return src.getCode().hasCoding(TYPE_SYSTEM, TYPE_CODE);
  }

  public static org.hl7.fhir.model.core.ArtifactAssessment convertArtifactAssessment(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!isArtifactAssessment(src)) {
      throw new FHIRException("Error in logic: this basic resource is not an ArtifactAssessment");
    }
    org.hl7.fhir.model.core.ArtifactAssessment tgt = new org.hl7.fhir.model.core.ArtifactAssessment();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("ArtifactAssessment", "5.0", V5, CrossVersionElements40_N.urls("ArtifactAssessment", "6.0", V6)));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "title", "citeAs");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "artifact", "date", "copyright", "approvalDate", "lastReviewDate", "content",
      "workflowStatus", "disposition");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Basic convertArtifactAssessment(org.hl7.fhir.model.core.ArtifactAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    tgt.getCode().addCoding().setSystem(TYPE_SYSTEM).setCode(TYPE_CODE);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    return tgt;
  }
}
