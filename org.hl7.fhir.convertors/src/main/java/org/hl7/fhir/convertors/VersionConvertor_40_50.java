package org.hl7.fhir.convertors;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Extension40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Meta40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Narrative40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

import java.util.Arrays;

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

public class VersionConvertor_40_50 {

  public static void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    new VersionConvertor_40_50_A(new BaseAdvisor_40_50()).copyResource(src, tgt);
  }

  public static void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    new VersionConvertor_40_50_A(new BaseAdvisor_40_50()).copyResource(src, tgt);
  }

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_40_50());
  }

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_40_50 advisor) throws FHIRException {
    return new VersionConvertor_40_50_A(advisor).convertResource(src);
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_40_50());
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src, BaseAdvisor_40_50 advisor) throws FHIRException {
    return new VersionConvertor_40_50_A(advisor).convertResource(src);
  }

  public static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_40_50());
  }

  public static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt, BaseAdvisor_40_50 advisor) throws FHIRException {
    new VersionConvertor_40_50_A(advisor).copyDomainResource(src, tgt);
  }

  public static void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_40_50());
  }

  public static void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt, BaseAdvisor_40_50 advisor) throws FHIRException {
    new VersionConvertor_40_50_A(advisor).copyDomainResource(src, tgt);
  }
}