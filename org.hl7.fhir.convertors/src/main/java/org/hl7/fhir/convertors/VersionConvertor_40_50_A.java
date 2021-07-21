package org.hl7.fhir.convertors;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Type40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Meta40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Parameters;

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
 * Our conversion class needs to be able to handle all the base datatypes in FHIR; Resources, DomainResource, Element
 */
public class VersionConvertor_40_50_A {
  private final BaseAdvisor_40_50 advisor;
  private final Element40_50 elementConvertor;
  private final Resource40_50 resourceConvertor;
  private final Type40_50 typeConvertor;

  public VersionConvertor_40_50_A(BaseAdvisor_40_50 advisor) {
    this.advisor = advisor;
    this.elementConvertor = new Element40_50(advisor);
    this.resourceConvertor = new Resource40_50(advisor);
    this.typeConvertor = new Type40_50(advisor);
  }

  public BaseAdvisor_40_50 advisor() {
    return advisor;
  }

  public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src,tgt);
  }

  public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    resourceConvertor.copyResource(src,tgt);
  }

  public org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    VersionConvertor_40_50_Context.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      VersionConvertor_40_50_Context.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    VersionConvertor_40_50_Context.INSTANCE.init(this, src.fhirType());
    try {
      return resourceConvertor.convertResource(src);
    } finally {
      VersionConvertor_40_50_Context.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    VersionConvertor_40_50_Context.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      VersionConvertor_40_50_Context.INSTANCE.close(src.fhirType());
    }
  }

  public org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    VersionConvertor_40_50_Context.INSTANCE.init(this, src.fhirType());
    try {
      return typeConvertor.convertType(src);
    } finally {
      VersionConvertor_40_50_Context.INSTANCE.close(src.fhirType());
    }
  }

  public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt);
  }

  public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt) throws FHIRException {
    resourceConvertor.copyDomainResource(src, tgt);
  }

  public void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... var) throws FHIRException {
    elementConvertor.copyElement(src, tgt, VersionConvertor_40_50_Context.INSTANCE.path(), var);
  }

  public void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.r4.model.Element tgt, String... var) throws FHIRException {
    elementConvertor.copyElement(src, tgt, VersionConvertor_40_50_Context.INSTANCE.path(), var);
  }


}