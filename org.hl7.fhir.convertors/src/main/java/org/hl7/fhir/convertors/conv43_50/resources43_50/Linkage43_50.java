package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class Linkage43_50 {

  public static org.hl7.fhir.r5.model.Linkage convertLinkage(org.hl7.fhir.r4b.model.Linkage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Linkage tgt = new org.hl7.fhir.r5.model.Linkage();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_50.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4b.model.Linkage.LinkageItemComponent t : src.getItem())
      tgt.addItem(convertLinkageItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Linkage convertLinkage(org.hl7.fhir.r5.model.Linkage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Linkage tgt = new org.hl7.fhir.r4b.model.Linkage();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_50.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r5.model.Linkage.LinkageItemComponent t : src.getItem())
      tgt.addItem(convertLinkageItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Linkage.LinkageItemComponent convertLinkageItemComponent(org.hl7.fhir.r4b.model.Linkage.LinkageItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Linkage.LinkageItemComponent tgt = new org.hl7.fhir.r5.model.Linkage.LinkageItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertLinkageType(src.getTypeElement()));
    if (src.hasResource())
      tgt.setResource(Reference43_50.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Linkage.LinkageItemComponent convertLinkageItemComponent(org.hl7.fhir.r5.model.Linkage.LinkageItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Linkage.LinkageItemComponent tgt = new org.hl7.fhir.r4b.model.Linkage.LinkageItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertLinkageType(src.getTypeElement()));
    if (src.hasResource())
      tgt.setResource(Reference43_50.convertReference(src.getResource()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Linkage.LinkageType> convertLinkageType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Linkage.LinkageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Linkage.LinkageType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Linkage.LinkageTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case SOURCE:
        tgt.setValue(org.hl7.fhir.r5.model.Linkage.LinkageType.SOURCE);
        break;
      case ALTERNATE:
        tgt.setValue(org.hl7.fhir.r5.model.Linkage.LinkageType.ALTERNATE);
        break;
      case HISTORICAL:
        tgt.setValue(org.hl7.fhir.r5.model.Linkage.LinkageType.HISTORICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Linkage.LinkageType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Linkage.LinkageType> convertLinkageType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Linkage.LinkageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Linkage.LinkageType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Linkage.LinkageTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case SOURCE:
        tgt.setValue(org.hl7.fhir.r4b.model.Linkage.LinkageType.SOURCE);
        break;
      case ALTERNATE:
        tgt.setValue(org.hl7.fhir.r4b.model.Linkage.LinkageType.ALTERNATE);
        break;
      case HISTORICAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Linkage.LinkageType.HISTORICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Linkage.LinkageType.NULL);
        break;
    }
    return tgt;
  }
}