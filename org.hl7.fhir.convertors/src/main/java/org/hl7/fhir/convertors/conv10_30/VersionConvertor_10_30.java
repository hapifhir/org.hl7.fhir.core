package org.hl7.fhir.convertors.conv10_30;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_30;
import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.BackboneElement10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.resources10_30.Resource10_30;
import org.hl7.fhir.dstu2.model.CodeableConcept;
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

public class VersionConvertor_10_30 {

  private final BaseAdvisor_10_30 advisor;
  private final Element10_30 elementConvertor;

  private final BackboneElement10_30 backboneElementConvertor;
  private final Resource10_30 resourceConvertor;
  private final Type10_30 typeConvertor;

  public VersionConvertor_10_30(@Nonnull BaseAdvisor_10_30 advisor) {
    this.advisor = advisor;
    this.elementConvertor = new Element10_30(advisor);
    this.backboneElementConvertor = new BackboneElement10_30();
    this.resourceConvertor = new Resource10_30(advisor);
    this.typeConvertor = new Type10_30(advisor);
  }

  static public boolean isJurisdiction(@Nonnull CodeableConcept t) {
    return t.hasCoding()
      && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem())
      || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem())
      || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public BaseAdvisor_10_30 advisor() {
    return advisor;
  }

  public void copyResource(@Nonnull org.hl7.fhir.dstu2.model.Resource src,
                           @Nonnull org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public void copyResource(@Nonnull org.hl7.fhir.dstu3.model.Resource src,
                           @Nonnull org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(@Nonnull org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    ConversionContext10_30.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext10_30.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu2.model.Resource convertResource(@Nonnull org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    ConversionContext10_30.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext10_30.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu3.model.Type convertType(@Nonnull org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    ConversionContext10_30.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext10_30.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu2.model.Type convertType(@Nonnull org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    ConversionContext10_30.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext10_30.INSTANCE.close(src.fhirType());
    }
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.dstu2.model.DomainResource src,
    @Nonnull org.hl7.fhir.dstu3.model.DomainResource tgt,
    String ... extensionUrlsToIgnore
    ) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt,extensionUrlsToIgnore);
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.dstu3.model.DomainResource src,
    @Nonnull org.hl7.fhir.dstu2.model.DomainResource tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.dstu2.model.Element src,
    @Nonnull org.hl7.fhir.dstu3.model.Element tgt, String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext10_30.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.dstu3.model.Element src,
    @Nonnull org.hl7.fhir.dstu2.model.Element tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext10_30.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyElement(@Nonnull org.hl7.fhir.dstu3.model.DomainResource src,
                          @Nonnull org.hl7.fhir.dstu2.model.Element tgt,
                          String... var) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext10_30.INSTANCE.path(), var);
  }

  public void copyBackboneElement(@Nonnull org.hl7.fhir.dstu3.model.BackboneElement src,
                                  @Nonnull org.hl7.fhir.dstu2.model.BackboneElement tgt,
                                  String... var) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, var);
  }

  public void copyBackboneElement(@Nonnull org.hl7.fhir.dstu2.model.BackboneElement src,
                                  @Nonnull org.hl7.fhir.dstu3.model.BackboneElement tgt,
                                  String... var) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, var);
  }
}