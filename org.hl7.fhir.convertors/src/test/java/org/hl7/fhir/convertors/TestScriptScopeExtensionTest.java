package org.hl7.fhir.convertors;

import static org.hl7.fhir.convertors.VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.VersionConvertor_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.hl7.fhir.convertors.igs.r5.testing.TestingR4Convertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The TestScript scope extension (EXT_TESTSCRIPT_SCOPE) is turned into TestScript.scope, or comes from it, so the
 * extension itself must not be copied across, whether the TestScript is converted on its own or inside a Bundle.
 */
class TestScriptScopeExtensionTest {

  private static final String ARTIFACT = "http://example.org/fhir/StructureDefinition/scoped";

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testR4ToR5(boolean inBundle) {
    org.hl7.fhir.r5.model.TestScript tgt = r5TestScript(VersionConvertorFactory_40_50.convertResource(r4(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
    Assertions.assertEquals(ARTIFACT, tgt.getScopeFirstRep().getArtifact());
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testR5ToR4(boolean inBundle) {
    org.hl7.fhir.r4.model.TestScript tgt = r4TestScript(VersionConvertorFactory_40_50.convertResource(r5(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testR4BToR5(boolean inBundle) {
    org.hl7.fhir.r5.model.TestScript tgt = r5TestScript(VersionConvertorFactory_43_50.convertResource(r4b(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
    Assertions.assertEquals(ARTIFACT, tgt.getScopeFirstRep().getArtifact());
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testR5ToR4B(boolean inBundle) {
    org.hl7.fhir.r4b.model.TestScript tgt = r4bTestScript(VersionConvertorFactory_43_50.convertResource(r5(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testR4ToN(boolean inBundle) {
    org.hl7.fhir.model.testing.TestScript tgt = nTestScript(VersionConvertorFactory_40_N.convertResource(r4(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
    Assertions.assertEquals(ARTIFACT, tgt.getScopeList().get(0).getArtifact());
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testNToR4(boolean inBundle) {
    org.hl7.fhir.r4.model.TestScript tgt = r4TestScript(VersionConvertorFactory_40_N.convertResource(n(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testR4BToN(boolean inBundle) {
    org.hl7.fhir.model.testing.TestScript tgt = nTestScript(VersionConvertorFactory_43_N.convertResource(r4b(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
    Assertions.assertEquals(ARTIFACT, tgt.getScopeList().get(0).getArtifact());
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testNToR4B(boolean inBundle) {
    org.hl7.fhir.r4b.model.TestScript tgt = r4bTestScript(VersionConvertorFactory_43_N.convertResource(n(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testR5ToN(boolean inBundle) {
    org.hl7.fhir.model.testing.TestScript tgt = nTestScript(VersionConvertorFactory_50_N.convertResource(r5(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
  }

  @ParameterizedTest(name = "in a Bundle: {0}")
  @ValueSource(booleans = {false, true})
  void testNToR5(boolean inBundle) {
    org.hl7.fhir.r5.model.TestScript tgt = r5TestScript(VersionConvertorFactory_50_N.convertResource(n(inBundle)));
    Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
  }

  @Test
  void testTestingIgR4ToR5() {
    ConversionContext40_50.INSTANCE.init(new VersionConvertor_40_50(new BaseAdvisor_40_50()));
    try {
      org.hl7.fhir.r5.igs.testing.TestScript tgt = TestingR4Convertor.convertTestScript((org.hl7.fhir.r4.model.TestScript) r4(false));
      Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
      Assertions.assertEquals(ARTIFACT, tgt.getScopeFirstRep().getArtifact());
    } finally {
      ConversionContext40_50.INSTANCE.close();
    }
  }

  @Test
  void testTestingIgR5ToR4() {
    org.hl7.fhir.r5.igs.testing.TestScript src = new org.hl7.fhir.r5.igs.testing.TestScript();
    src.addExtension().setUrl(EXT_TESTSCRIPT_SCOPE).addExtension().setUrl("artifact").setValue(new org.hl7.fhir.r5.model.CanonicalType(ARTIFACT));
    ConversionContext40_50.INSTANCE.init(new VersionConvertor_40_50(new BaseAdvisor_40_50()));
    try {
      org.hl7.fhir.r4.model.TestScript tgt = TestingR4Convertor.convertTestScript(src);
      Assertions.assertFalse(tgt.hasExtension(EXT_TESTSCRIPT_SCOPE));
    } finally {
      ConversionContext40_50.INSTANCE.close();
    }
  }

  // Each of these makes a TestScript that carries the scope extension (and has no scope of its own), on its own or
  // as the only entry in a Bundle; the matching xxTestScript method takes the TestScript back out of the result.

  private static org.hl7.fhir.r4.model.Resource r4(boolean inBundle) {
    org.hl7.fhir.r4.model.TestScript ts = new org.hl7.fhir.r4.model.TestScript();
    ts.addExtension().setUrl(EXT_TESTSCRIPT_SCOPE).addExtension().setUrl("artifact").setValue(new org.hl7.fhir.r4.model.CanonicalType(ARTIFACT));
    if (!inBundle) {
      return ts;
    }
    org.hl7.fhir.r4.model.Bundle bundle = new org.hl7.fhir.r4.model.Bundle();
    bundle.addEntry().setResource(ts);
    return bundle;
  }

  private static org.hl7.fhir.r4b.model.Resource r4b(boolean inBundle) {
    org.hl7.fhir.r4b.model.TestScript ts = new org.hl7.fhir.r4b.model.TestScript();
    ts.addExtension().setUrl(EXT_TESTSCRIPT_SCOPE).addExtension().setUrl("artifact").setValue(new org.hl7.fhir.r4b.model.CanonicalType(ARTIFACT));
    if (!inBundle) {
      return ts;
    }
    org.hl7.fhir.r4b.model.Bundle bundle = new org.hl7.fhir.r4b.model.Bundle();
    bundle.addEntry().setResource(ts);
    return bundle;
  }

  private static org.hl7.fhir.r5.model.Resource r5(boolean inBundle) {
    org.hl7.fhir.r5.model.TestScript ts = new org.hl7.fhir.r5.model.TestScript();
    ts.addExtension().setUrl(EXT_TESTSCRIPT_SCOPE).addExtension().setUrl("artifact").setValue(new org.hl7.fhir.r5.model.CanonicalType(ARTIFACT));
    if (!inBundle) {
      return ts;
    }
    org.hl7.fhir.r5.model.Bundle bundle = new org.hl7.fhir.r5.model.Bundle();
    bundle.addEntry().setResource(ts);
    return bundle;
  }

  private static org.hl7.fhir.model.core.Resource n(boolean inBundle) {
    org.hl7.fhir.model.testing.TestScript ts = new org.hl7.fhir.model.testing.TestScript();
    ts.addExtension().setUrl(EXT_TESTSCRIPT_SCOPE).addExtension().setUrl("artifact").setValue(new org.hl7.fhir.model.core.CanonicalType(ARTIFACT));
    if (!inBundle) {
      return ts;
    }
    org.hl7.fhir.model.core.Bundle bundle = new org.hl7.fhir.model.core.Bundle();
    bundle.addEntry().setResource(ts);
    return bundle;
  }

  private static org.hl7.fhir.r4.model.TestScript r4TestScript(org.hl7.fhir.r4.model.Resource res) {
    if (res instanceof org.hl7.fhir.r4.model.Bundle) {
      res = ((org.hl7.fhir.r4.model.Bundle) res).getEntryFirstRep().getResource();
    }
    return (org.hl7.fhir.r4.model.TestScript) res;
  }

  private static org.hl7.fhir.r4b.model.TestScript r4bTestScript(org.hl7.fhir.r4b.model.Resource res) {
    if (res instanceof org.hl7.fhir.r4b.model.Bundle) {
      res = ((org.hl7.fhir.r4b.model.Bundle) res).getEntryFirstRep().getResource();
    }
    return (org.hl7.fhir.r4b.model.TestScript) res;
  }

  private static org.hl7.fhir.r5.model.TestScript r5TestScript(org.hl7.fhir.r5.model.Resource res) {
    if (res instanceof org.hl7.fhir.r5.model.Bundle) {
      res = ((org.hl7.fhir.r5.model.Bundle) res).getEntryFirstRep().getResource();
    }
    return (org.hl7.fhir.r5.model.TestScript) res;
  }

  private static org.hl7.fhir.model.testing.TestScript nTestScript(org.hl7.fhir.model.core.Resource res) {
    if (res instanceof org.hl7.fhir.model.core.Bundle) {
      res = ((org.hl7.fhir.model.core.Bundle) res).getEntryList().get(0).getResource();
    }
    return (org.hl7.fhir.model.testing.TestScript) res;
  }
}
