package org.hl7.fhir.r5.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.hl7.fhir.r5.context.IWorkerContext.VersionResolutionRules;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * A supplement may have the url of the code system it supplements. When resolving the url finds the supplement -
 * it's the latest version, or it has the version asked for too - the code system is still the one with that url that
 * isn't a supplement, whatever order they were loaded in. Only when there's no such code system (for the version
 * asked for) is the code system (version) unknown
 */
class SameUrlSupplementTests {

  private static final String URL = "http://example.org/fhir/CodeSystem/colours";
  private static final PackageInformation CS_PACKAGE = new PackageInformation("example.colours", "1.0.0", "5.0.0", new Date());
  private static final PackageInformation SUPPLEMENT_PACKAGE = new PackageInformation("example.colours.de", "1.0.0", "5.0.0", new Date());

  private static CodeSystem codeSystem(String version) {
    CodeSystem cs = new CodeSystem();
    cs.setUrl(URL);
    cs.setVersion(version);
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("red").setDisplay("Red");
    return cs;
  }

  private static CodeSystem supplement(String version, String supplements) {
    CodeSystem cs = new CodeSystem();
    cs.setUrl(URL);
    cs.setVersion(version);
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.SUPPLEMENT);
    cs.setSupplements(supplements);
    cs.addConcept().setCode("red").addDesignation().setLanguage("de").setValue("Rot");
    return cs;
  }

  private static SimpleWorkerContext context(String csVersion, String suppVersion, boolean supplementFirst) throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext());
    // from two packages, as they would be: two resources with the same url|version from the same source replace
    // each other
    if (supplementFirst) {
      ctxt.cacheResourceFromPackage(supplement(suppVersion, URL + "|" + csVersion), SUPPLEMENT_PACKAGE);
      ctxt.cacheResourceFromPackage(codeSystem(csVersion), CS_PACKAGE);
    } else {
      ctxt.cacheResourceFromPackage(codeSystem(csVersion), CS_PACKAGE);
      ctxt.cacheResourceFromPackage(supplement(suppVersion, URL + "|" + csVersion), SUPPLEMENT_PACKAGE);
    }
    return ctxt;
  }

  @ParameterizedTest(name = "code system {0}, supplement {1}, asked for {2}, supplement loaded first {3}")
  @CsvSource({
    // the supplement is the latest version
    "1.0, 2.0, ,    true",
    "1.0, 2.0, ,    false",
    // the supplement has the code system's version
    "1.0, 1.0, 1.0, true",
    "1.0, 1.0, 1.0, false",
    "1.0, 1.0, ,    true",
    "1.0, 1.0, ,    false",
  })
  void theCodeSystemIsTheOneThatIsntASupplement(String csVersion, String suppVersion, String version, boolean supplementFirst) throws Exception {
    SimpleWorkerContext ctxt = context(csVersion, suppVersion, supplementFirst);

    CodeSystem cs = ctxt.fetchSupplementedCodeSystem(URL, VersionResolutionRules.defaultRule(), version, null, null);
    assertNotNull(cs);
    assertFalse(cs.hasSupplements());
    assertEquals(csVersion, cs.getVersion());

    // and so validating and expanding find it
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/colours");
    vs.getCompose().addInclude().setSystem(URL).setVersion(version);
    ValidationResult vr = ctxt.validateCode(ValidationOptions.defaults().withNoServer(), new Coding(URL, "red", null), vs);
    assertTrue(vr.isOk(), vr.getMessage());
    ValueSetExpansionOutcome vso = ctxt.expandVS(vs, false, false);
    assertNotNull(vso.getValueset(), vso.getError());
    assertEquals(1, vso.getValueset().getExpansion().getContains().size());
  }

  @ParameterizedTest(name = "supplement loaded first {0}")
  @CsvSource({"true", "false"})
  void onlyTheSupplementHasTheVersion(boolean supplementFirst) throws Exception {
    SimpleWorkerContext ctxt = context("1.0", "2.0", supplementFirst);
    // there's no code system version 2.0: what's found is the supplement, and the callers say the version is unknown
    CodeSystem cs = ctxt.fetchSupplementedCodeSystem(URL, VersionResolutionRules.defaultRule(), "2.0", null, null);
    assertTrue(cs == null || cs.hasSupplements());
  }
}
