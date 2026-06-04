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
import java.util.List;

import org.hl7.fhir.r5.elementmodel.TurtleParser;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.VersionUtilities;

@MarkedToMoveToAdjunctPackage
public class ShExGenerator extends ShExGeneratorBase {

  public static class ShExComparator extends BaseShExComparator {
  }

  // `volatile` so the one-shot lazy publish of the R6 delegate, and the snapshot of the
  // configuration last synced into it, are visible across threads without stale cached reads.
  private volatile ShExGeneratorR6 r6Generator;
  private volatile ShExGeneratorConfig syncedR6Configuration;

  /**
   * @deprecated Use {@link #ShExGenerator(IWorkerContext, ShExGeneratorConfig)} to supply generator settings during construction.
   */
  @Deprecated
  public ShExGenerator(IWorkerContext context) {
    this(context, ShExGeneratorConfig.defaultConfig());
  }

  public ShExGenerator(IWorkerContext context, ShExGeneratorConfig config) {
    super(context, config);
  }

  @Override
  protected String getClassName(String name) {
    return TurtleParser.getClassName(name);
  }

  @Override
  protected String getLinkPredicate() {
    return "fhir:link";
  }

  @Override
  public String generate(HTMLLinkPolicy links, StructureDefinition structure) {
    if (VersionUtilities.isR6Ver(context.getVersion())) {
      return getR6Generator().generate(links, structure);
    }
    return super.generate(links, structure);
  }

  @Override
  public List<String> getExcludedStructureDefinitionUrls() {
    if (VersionUtilities.isR6Ver(context.getVersion())) {
      return getR6Generator().getExcludedStructureDefinitionUrls();
    }
    return super.getExcludedStructureDefinitionUrls();
  }

  @Override
  public void setExcludedStructureDefinitionUrls(List<String> excludedSDs) {
    if (VersionUtilities.isR6Ver(context.getVersion())) {
      getR6Generator().setExcludedStructureDefinitionUrls(excludedSDs);
      return;
    }
    super.setExcludedStructureDefinitionUrls(excludedSDs);
  }

  @Override
  public List<StructureDefinition> getSelectedExtensions() {
    if (VersionUtilities.isR6Ver(context.getVersion())) {
      return getR6Generator().getSelectedExtensions();
    }
    return super.getSelectedExtensions();
  }

  @Override
  public void setSelectedExtension(List<StructureDefinition> selectedExtensions) {
    if (VersionUtilities.isR6Ver(context.getVersion())) {
      getR6Generator().setSelectedExtension(selectedExtensions);
      return;
    }
    super.setSelectedExtension(selectedExtensions);
  }

  @Override
  public String generate(HTMLLinkPolicy links, List<StructureDefinition> structures, List<String> excludedSDUrls) {
    if (VersionUtilities.isR6Ver(context.getVersion())) {
      return getR6Generator().generate(links, structures, excludedSDUrls);
    }
    return super.generate(links, structures, excludedSDUrls);
  }

  @Override
  public String generate(HTMLLinkPolicy links, List<StructureDefinition> structures) {
    if (VersionUtilities.isR6Ver(context.getVersion())) {
      return getR6Generator().generate(links, structures);
    }
    return super.generate(links, structures);
  }

  /** Redirect to R6 ShExGenerator and ensure it uses the same configuration */
  private ShExGeneratorR6 getR6Generator() {
    ShExGeneratorConfig currentConfig = currentConfiguration();
    ShExGeneratorR6 generator = r6Generator;
    if (generator == null) {
      // First level of thread-safety: ensure only one thread constructs the delegate and
      // publishes it. Without this, a racing first-time R6 caller could create a second
      // delegate that gets silently dropped along with its initial config snapshot.
      synchronized (this) {
        generator = r6Generator;
        if (generator == null) {
          generator = new ShExGeneratorR6(context, currentConfig);
          r6Generator = generator;
          syncedR6Configuration = currentConfig;
          return generator;
        }
      }
    }

    // If the deprecated config/settings changed, we need to get their current values
    if (!currentConfig.equals(syncedR6Configuration)) {
      // Second level of thread-safety: ensure config resync is applied atomically with the
      // "last-synced" marker, so two threads can't both observe drift and double-copy (or copy
      // out of order). Safe to do here because ShExGeneratorConfig is an immutable value and
      // copyConfigurationTo is the only writer the delegate sees on the R6 path.
      synchronized (this) {
        if (!currentConfig.equals(syncedR6Configuration)) {
          copyConfigurationTo(r6Generator);
          syncedR6Configuration = currentConfig;
        }
        generator = r6Generator;
      }
    }
    return generator;
  }
}