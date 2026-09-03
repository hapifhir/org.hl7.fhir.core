package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Ratio43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Identifier;
import org.hl7.fhir.model.core.Substance;

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

public class Substance43_N {

  public static org.hl7.fhir.model.core.Substance convertSubstance(org.hl7.fhir.r4b.model.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Substance tgt = new org.hl7.fhir.model.core.Substance();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.getCode().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      convertSubstanceInstanceComponent(t, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Substance convertSubstance(org.hl7.fhir.model.core.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Substance tgt = new org.hl7.fhir.r4b.model.Substance();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.getCode().hasConcept())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode().getConcept()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Substance.FHIRSubstanceStatus> tgt = new Enumeration<>(new Substance.FHIRSubstanceStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Substance.FHIRSubstanceStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(Substance.FHIRSubstanceStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Substance.FHIRSubstanceStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Substance.FHIRSubstanceStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Substance.FHIRSubstanceStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static void convertSubstanceInstanceComponent(org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent src, org.hl7.fhir.model.core.Substance tgt) throws FHIRException {
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime43_N.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
  }

  public static org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.model.core.Substance src) throws FHIRException {
    org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent();
    for (Identifier t : src.getIdentifierList()) {
      tgt.setIdentifier(Identifier43_N.convertIdentifier(t));
    }
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime43_N.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }
}