package org.hl7.fhir.convertors.conv14_40;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_40;
import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.BackboneElement14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Type14_40;
import org.hl7.fhir.convertors.conv14_40.resources14_40.Resource14_40;
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

public class VersionConvertor_14_40 {
  static public List<String> CANONICAL_URLS = new ArrayList<String>();

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

  private final BaseAdvisor_14_40 advisor;
  private final Element14_40 elementConvertor;

  private final BackboneElement14_40 backboneElementConvertor;
  private final Resource14_40 resourceConvertor;
  private final Type14_40 typeConvertor;

  public VersionConvertor_14_40(@Nonnull BaseAdvisor_14_40 advisor) {
    this.advisor = advisor;
    this.elementConvertor = new Element14_40(advisor);
    backboneElementConvertor = new BackboneElement14_40();
    this.resourceConvertor = new Resource14_40(advisor);
    this.typeConvertor = new Type14_40(advisor);
  }

  static public boolean isJurisdiction(@Nonnull CodeableConcept t) {
    return t.hasCoding()
      && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem())
      || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem())
      || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public BaseAdvisor_14_40 advisor() {
    return advisor;
  }

  public void copyResource(@Nonnull org.hl7.fhir.dstu2016may.model.Resource src,
                           @Nonnull org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public void copyResource(@Nonnull org.hl7.fhir.r4.model.Resource src,
                           @Nonnull org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src, tgt);
  }

  public org.hl7.fhir.r4.model.Resource convertResource(@Nonnull org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
    ConversionContext14_40.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext14_40.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu2016may.model.Resource convertResource(@Nonnull org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    ConversionContext14_40.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      ConversionContext14_40.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r4.model.Type convertType(@Nonnull org.hl7.fhir.dstu2016may.model.Type src) throws FHIRException {
    ConversionContext14_40.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext14_40.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.dstu2016may.model.Type convertType(@Nonnull org.hl7.fhir.r4.model.Type src) throws FHIRException {
    ConversionContext14_40.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      ConversionContext14_40.INSTANCE.close(src.fhirType());
    }
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.dstu2016may.model.DomainResource src,
    @Nonnull org.hl7.fhir.r4.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyDomainResource(
    @Nonnull org.hl7.fhir.r4.model.DomainResource src,
    @Nonnull org.hl7.fhir.dstu2016may.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt, extensionUrlsToIgnore);
  }

  public void copyElement(@Nonnull org.hl7.fhir.dstu2016may.model.Element src,
                          @Nonnull org.hl7.fhir.r4.model.Element tgt,
                          String... var) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext14_40.INSTANCE.path(), var);
  }

  public void copyElement(@Nonnull org.hl7.fhir.r4.model.Element src,
                          @Nonnull org.hl7.fhir.dstu2016may.model.Element tgt,
                          String... var) throws FHIRException {
    elementConvertor.copyElement(src, tgt, ConversionContext14_40.INSTANCE.path(), var);
  }

  public void copyBackboneElement(@Nonnull org.hl7.fhir.r4.model.BackboneElement src,
                                  @Nonnull org.hl7.fhir.dstu2016may.model.BackboneElement tgt,
                                  String... var) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, var);
  }

  public void copyBackboneElement(@Nonnull org.hl7.fhir.dstu2016may.model.BackboneElement src,
                                  @Nonnull org.hl7.fhir.r4.model.BackboneElement tgt,
                                  String... var) throws FHIRException {
    backboneElementConvertor.copyBackboneElement(src, tgt, var);
  }
}