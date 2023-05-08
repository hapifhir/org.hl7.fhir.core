package org.hl7.fhir.convertors.conv30_50;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_50;
import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.BackboneElement30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Type30_50;
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

public class VersionConvertor_30_50 {
  static final public String EXT_SRC_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type";
  private static final String CODE_SYSTEM_MEDIA_TYPE = "http://terminology.hl7.org/CodeSystem/media-type";
  static public List<String> CANONICAL_URLS = new ArrayList<>();

  static {
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-conceptmap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-valueset");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/codesystem-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/cqif-library");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-inheritedExtensibleValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/event-instantiatesCanonical");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-allowedProfile");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-deMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-sourceStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-targetStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-unit-valueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-supplement");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-system");
  }

  private final BaseAdvisor_30_50 advisor;
  private final Element30_50 elementConvertor;

  private final BackboneElement30_50 backboneElementConvertor;
  private final Resource30_50 resourceConvertor;
  private final Type30_50 typeConvertor;

  public VersionConvertor_30_50(@Nonnull BaseAdvisor_30_50 advisor) {
    this.advisor = advisor;
    this.elementConvertor = new Element30_50(advisor);
    this.backboneElementConvertor = new BackboneElement30_50();
    this.resourceConvertor = new Resource30_50(advisor);
    this.typeConvertor = new Type30_50(advisor);
  }

  public BaseAdvisor_30_50 advisor() {
    return advisor;
  }

  public void copyResource(@Nonnull org.hl7.fhir.dstu3.model.Resource src,
                           @Nonnull org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public void copyResource(@Nonnull org.hl7.fhir.r5.model.Resource src,
                           @Nonnull org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public org.hl7.fhir.r5.model.Resource convertResource(@Nonnull org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    ConversionContext30_50.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext30_50.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(@Nonnull org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    ConversionContext30_50.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext30_50.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r5.model.DataType convertType(@Nonnull org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    ConversionContext30_50.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext30_50.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu3.model.Type convertType(@Nonnull org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    ConversionContext30_50.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext30_50.INSTANCE.close(src.fhirType());
    }
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.dstu3.model.DomainResource src,
    @Nonnull org.hl7.fhir.r5.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.r5.model.DomainResource src,
    @Nonnull org.hl7.fhir.dstu3.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.dstu3.model.Element src,
    @Nonnull org.hl7.fhir.r5.model.Element tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext30_50.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyElement(
    @Nonnull org.hl7.fhir.r5.model.Element src,
    @Nonnull org.hl7.fhir.dstu3.model.Element tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext30_50.INSTANCE.path(), extensionUrlsToIgnore);
  }

  public void copyBackboneElement(
    @Nonnull org.hl7.fhir.r5.model.BackboneElement src,
    @Nonnull org.hl7.fhir.dstu3.model.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, extensionUrlsToIgnore);
  }

  public void copyBackboneElement(
    @Nonnull org.hl7.fhir.dstu3.model.BackboneElement src,
    @Nonnull org.hl7.fhir.r5.model.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, extensionUrlsToIgnore);
  }
}