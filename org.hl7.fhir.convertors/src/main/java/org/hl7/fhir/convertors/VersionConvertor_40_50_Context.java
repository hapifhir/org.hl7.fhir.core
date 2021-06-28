package org.hl7.fhir.convertors;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Extension40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Meta40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Narrative40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class VersionConvertor_40_50_Context {

  private static Logger logger = LoggerFactory.getLogger(VersionConvertor_40_50_Context.class);

  private static final ThreadLocal<VersionConvertor_40_50_A> threadLocal = new ThreadLocal<>();

  public static void init(VersionConvertor_40_50_A versionConvertor_40_50_a) {
    if (versionConvertor_40_50_a == null) {
      throw new FHIRException("Null is not allowed!");
    }
    if (threadLocal.get() != null) {
      throw new FHIRException("Already set!");
    }
    threadLocal.set(versionConvertor_40_50_a);
  }

  public static void close() {
    if (threadLocal.get() == null) {
      throw new FHIRException("Already null!");
    }
    threadLocal.remove();
  }

  public static VersionConvertor_40_50_A getVersionConvertor_40_50_a() {
    VersionConvertor_40_50_A result = threadLocal.get();
    logger.debug(result.toString());
    if (result == null) {
      throw new FHIRException("Reached unstable state, null conversion instance.");
    }
    return result;
  }
}