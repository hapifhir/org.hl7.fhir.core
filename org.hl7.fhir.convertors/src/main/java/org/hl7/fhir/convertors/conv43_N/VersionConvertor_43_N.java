package org.hl7.fhir.convertors.conv43_N;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_N;
import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.BackboneElement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.Element43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.Type43_N;
import org.hl7.fhir.convertors.conv43_N.resources43_N.Resource43_N;
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
 * Our conversion class needs to be able to handle all the base data-types in FHIR; Resources, DomainResource, Element
 */
public class VersionConvertor_43_N {
  private final BaseAdvisor_43_N advisor;
  private final Element43_N elementConvertor;

  private final BackboneElement43_N backboneElementConvertor;
  private final Resource43_N resourceConvertor;
  private final Type43_N typeConvertor;

  public VersionConvertor_43_N(@Nonnull BaseAdvisor_43_N advisor) {
    this.advisor = advisor;
    this.elementConvertor = new Element43_N(advisor);
    this.backboneElementConvertor = new BackboneElement43_N();
    this.resourceConvertor = new Resource43_N(advisor);
    this.typeConvertor = new Type43_N(advisor);
  }

  public BaseAdvisor_43_N advisor() {
    return advisor;
  }

  public void copyResource(@Nonnull org.hl7.fhir.r4b.model.Resource src,
                           @Nonnull org.hl7.fhir.model.core.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public void copyResource(@Nonnull org.hl7.fhir.model.core.Resource src,
                           @Nonnull org.hl7.fhir.r4b.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public org.hl7.fhir.model.core.Resource convertResource(@Nonnull org.hl7.fhir.r4b.model.Resource src) throws FHIRException {
    ConversionContext43_N.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext43_N.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r4b.model.Resource convertResource(@Nonnull org.hl7.fhir.model.core.Resource src) throws FHIRException {
    ConversionContext43_N.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext43_N.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.model.core.DataType convertType(@Nonnull org.hl7.fhir.r4b.model.DataType src) throws FHIRException {
    ConversionContext43_N.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext43_N.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r4b.model.DataType convertType(@Nonnull org.hl7.fhir.model.core.DataType src) throws FHIRException {
    ConversionContext43_N.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext43_N.INSTANCE.close(src.fhirType());
    }
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.r4b.model.DomainResource src,
    @Nonnull org.hl7.fhir.model.core.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.model.core.DomainResource src,
    @Nonnull org.hl7.fhir.r4b.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.r4b.model.Element src,
    @Nonnull org.hl7.fhir.model.core.Element tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext43_N.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.model.core.Element src,
    @Nonnull org.hl7.fhir.r4b.model.Element tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext43_N.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyBackboneElement(
    @Nonnull org.hl7.fhir.model.core.BackboneElement src,
    @Nonnull org.hl7.fhir.r4b.model.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, extensionUrlsToIgnore);
  }

  public void copyBackboneElement(
    @Nonnull org.hl7.fhir.r4b.model.BackboneElement src,
    @Nonnull org.hl7.fhir.model.core.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, extensionUrlsToIgnore);
  }
}