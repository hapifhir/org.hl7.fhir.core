package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class BodyStructure40_N {

  public static org.hl7.fhir.model.core.BodyStructure convertBodyStructure(org.hl7.fhir.r4.model.BodyStructure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.BodyStructure tgt = new org.hl7.fhir.model.core.BodyStructure();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("BodyStructure", "5.0", new String[] {"includedStructure", "excludedStructure"}));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    // R4 location, locationQualifier and morphology are the first included structure. Others are in extensions
    if (src.hasLocation() || src.hasLocationQualifier() || src.hasMorphology()) {
      org.hl7.fhir.model.core.BodyStructure.BodyStructureIncludedStructureComponent is = tgt.addIncludedStructure();
      if (src.hasLocation())
        is.setStructure(CodeableConcept40_N.convertCodeableConcept(src.getLocation()));
      for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLocationQualifier())
        is.addQualifier(CodeableConcept40_N.convertCodeableConcept(t));
      if (src.hasMorphology())
        is.addMorphology(CodeableConcept40_N.convertCodeableConcept(src.getMorphology()));
    }
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "includedStructure", "excludedStructure");
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getImage()) tgt.addImage(Attachment40_N.convertAttachment(t));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BodyStructure convertBodyStructure(org.hl7.fhir.model.core.BodyStructure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BodyStructure tgt = new org.hl7.fhir.r4.model.BodyStructure();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    // the first included structure maps to location, locationQualifier and morphology if that's all it has. Otherwise, extensions
    boolean first = true;
    for (org.hl7.fhir.model.core.BodyStructure.BodyStructureIncludedStructureComponent t : src.getIncludedStructureList()) {
      if (first && isSimpleIncludedStructure(t)) {
        if (t.hasStructure())
          tgt.setLocation(CodeableConcept40_N.convertCodeableConcept(t.getStructure()));
        for (org.hl7.fhir.model.core.CodeableConcept q : t.getQualifierList())
          tgt.addLocationQualifier(CodeableConcept40_N.convertCodeableConcept(q));
        if (t.hasMorphology())
          tgt.setMorphology(CodeableConcept40_N.convertCodeableConcept(t.getMorphologyFirstRep()));
      } else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("BodyStructure", "5.0", "includedStructure"), t));
      first = false;
    }
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "excludedStructure");
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.Attachment t : src.getImageList()) tgt.addImage(Attachment40_N.convertAttachment(t));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    return tgt;
  }

  private static boolean isSimpleIncludedStructure(org.hl7.fhir.model.core.BodyStructure.BodyStructureIncludedStructureComponent t) {
    return t.hasStructure() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension() && !t.hasLaterality() && !t.hasBodyLandmarkOrientation()
      && !t.hasSpatialReference() && !t.hasImage() && !t.hasOrigin() && t.getMorphologyList().size() <= 1;
  }
}
