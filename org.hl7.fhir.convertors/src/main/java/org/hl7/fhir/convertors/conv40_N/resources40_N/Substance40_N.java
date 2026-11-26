package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Ratio40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
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

public class Substance40_N {

  private static boolean isSimpleInstance(org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent t) {
    return !t.hasIdentifier() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension();
  }

  public static org.hl7.fhir.model.core.Substance convertSubstance(org.hl7.fhir.r4.model.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Substance tgt = new org.hl7.fhir.model.core.Substance();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    // R6 dropped ingredient
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Substance", tgt.getExtension(), "ingredient");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertFHIRSubstanceStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    // R6 Substance is the instance: a single instance with no identifier maps to expiry and quantity. Otherwise the
    // instances go in cross-version extensions
    if (src.getInstance().size() == 1 && isSimpleInstance(src.getInstanceFirstRep())) {
      org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent t = src.getInstanceFirstRep();
      if (t.hasExpiry())
        tgt.setExpiryElement(DateTime40_N.convertDateTime(t.getExpiryElement()));
      if (t.hasQuantity())
        tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(t.getQuantity()));
    } else {
      CrossVersionElements40_N.r4ElementsToExtensions(src, "Substance", tgt.getExtension(), "instance");
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Substance convertSubstance(org.hl7.fhir.model.core.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Substance tgt = new org.hl7.fhir.r4.model.Substance();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Substance", "4.0", new String[] {"ingredient", "instance"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Substance", "ingredient");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertFHIRSubstanceStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasExpiry() || src.hasQuantity()) {
      org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent t = tgt.addInstance();
      if (src.hasExpiry())
        t.setExpiryElement(DateTime40_N.convertDateTime(src.getExpiryElement()));
      if (src.hasQuantity())
        t.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    }
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Substance", "instance");
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Substance.FHIRSubstanceStatus> tgt = new Enumeration<>(new Substance.FHIRSubstanceStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Substance.FHIRSubstanceStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static void convertSubstanceInstanceComponent(org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent src, org.hl7.fhir.model.core.Substance tgt) throws FHIRException {
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime40_N.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
  }

  public static org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.model.core.Substance src) throws FHIRException {
    org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent();
    for (Identifier t : src.getIdentifierList()) {
      tgt.setIdentifier(Identifier40_N.convertIdentifier(t));
    }
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime40_N.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }
}