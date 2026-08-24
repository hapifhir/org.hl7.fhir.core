package org.hl7.fhir.r5.conformance;

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
import org.hl7.fhir.r5.elementmodel.TurtleParserR6;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class ShExGeneratorR6 extends ShExGeneratorBase {

  public static class ShExComparator extends BaseShExComparator {
  }

  /**
   * @deprecated Use {@link #ShExGeneratorR6(IWorkerContext, ShExGeneratorConfig)} to supply generator settings during construction.
   */
  @Deprecated
  public ShExGeneratorR6(IWorkerContext context) {
    this(context, ShExGeneratorConfig.defaultConfig());
  }

  public ShExGeneratorR6(IWorkerContext context, ShExGeneratorConfig config) {
    super(context, config);
  }

  @Override
  protected String getClassName(String name) {
    return TurtleParserR6.getClassName(name);
  }

  @Override
  protected String getLinkPredicate() {
    return "fhir:l";
  }
}
