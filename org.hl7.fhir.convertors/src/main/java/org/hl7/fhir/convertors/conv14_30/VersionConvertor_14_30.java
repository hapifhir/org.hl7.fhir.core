package org.hl7.fhir.convertors.conv14_30;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_30;
import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.BackboneElement14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Type14_30;
import org.hl7.fhir.convertors.conv14_30.resources14_30.Resource14_30;
import org.hl7.fhir.dstu2016may.model.CodeableConcept;
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

public class VersionConvertor_14_30 {

  private final BaseAdvisor_14_30 advisor;
  private final Element14_30 elementConvertor;

  private final BackboneElement14_30 backboneElementConvertor;
  private final Resource14_30 resourceConvertor;
  private final Type14_30 typeConvertor;

  public VersionConvertor_14_30(@Nonnull BaseAdvisor_14_30 advisor) {
    this.advisor = advisor;
    this.elementConvertor = new Element14_30(advisor);
    this.backboneElementConvertor = new BackboneElement14_30();
    this.resourceConvertor = new Resource14_30(advisor);
    this.typeConvertor = new Type14_30(advisor);
  }

  static public boolean isJurisdiction(@Nonnull CodeableConcept t) {
    return t.hasCoding()
      && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem())
      || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem())
      || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public BaseAdvisor_14_30 advisor() {
    return advisor;
  }

  public void copyResource(@Nonnull org.hl7.fhir.dstu2016may.model.Resource src,
                           @Nonnull org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public void copyResource(@Nonnull org.hl7.fhir.dstu3.model.Resource src,
                           @Nonnull org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(@Nonnull org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
    ConversionContext14_30.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext14_30.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu2016may.model.Resource convertResource(@Nonnull org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    ConversionContext14_30.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext14_30.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu3.model.Type convertType(@Nonnull org.hl7.fhir.dstu2016may.model.Type src) throws FHIRException {
    ConversionContext14_30.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext14_30.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu2016may.model.Type convertType(@Nonnull org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    ConversionContext14_30.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext14_30.INSTANCE.close(src.fhirType());
    }
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.dstu2016may.model.DomainResource src,
    @Nonnull org.hl7.fhir.dstu3.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.dstu3.model.DomainResource src,
    @Nonnull org.hl7.fhir.dstu2016may.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.dstu2016may.model.Element src,
    @Nonnull org.hl7.fhir.dstu3.model.Element tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext14_30.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.dstu3.model.Element src,
    @Nonnull org.hl7.fhir.dstu2016may.model.Element tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext14_30.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyBackboneElement(
    @Nonnull org.hl7.fhir.dstu2016may.model.BackboneElement src,
    @Nonnull org.hl7.fhir.dstu3.model.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, extensionUrlsToIgnore);
  }

  public void copyBackboneElement(
    @Nonnull org.hl7.fhir.dstu3.model.BackboneElement src,
    @Nonnull org.hl7.fhir.dstu2016may.model.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, extensionUrlsToIgnore);
  }
}