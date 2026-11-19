package org.hl7.fhir.r5.terminologies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpander;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Two versions of a global language pack, S|1.0 and S|2.0, for a code system loaded from package P. A value set
 * asks for S|2.0 by version, so its expansion should use S|2.0 (CodeSystemUtilities.oneVersionEach: "the one
 * asked for by version is used").
 * <p>
 * S|2.0 always comes from another package, Q; S|1.0 comes from P or Q. CanonicalResourceManager.getSupplements
 * prefers supplements from the code system's own package, so when S|1.0 is in P, S|2.0 was never a candidate:
 * S|1.0 was merged because it is global, and then counted as satisfying the request for S|2.0, and the expansion
 * failed with "Required supplement not found". A supplement asked for by version is now a candidate wherever it
 * comes from (BaseWorkerContext.fetchSupplementedCodeSystem).
 */
class SupplementVersionSelectionTest {

  private static final String CS_URL = "http://example.org/fhir/CodeSystem/base";
  private static final String SUPPLEMENT_URL = "http://example.org/fhir/CodeSystem/lang-pack";
  private static final String LANG = "fr";

  private static final PackageInformation PACKAGE_P = new PackageInformation("example.base", "1.0.0", "5.0.0", new Date());
  private static final PackageInformation PACKAGE_Q = new PackageInformation("example.other", "1.0.0", "5.0.0", new Date());

  private static CodeSystem baseCodeSystem() {
    CodeSystem cs = new CodeSystem();
    cs.setId("base");
    cs.setUrl(CS_URL);
    cs.setVersion("1.0");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.setCaseSensitive(true);
    cs.addConcept().setCode("A").setDisplay("Alpha");
    return cs;
  }

  private static CodeSystem globalLangPack(String version) {
    CodeSystem sup = new CodeSystem();
    sup.setId("lang-pack-" + version.replace('.', '-'));
    sup.setUrl(SUPPLEMENT_URL);
    sup.setVersion(version);
    sup.setStatus(PublicationStatus.ACTIVE);
    sup.setContent(CodeSystemContentMode.SUPPLEMENT);
    sup.setSupplements(CS_URL);
    sup.setLanguage(LANG);
    sup.addExtension(ExtensionDefinitions.EXT_SUPPL_TYPE, new StringType("lang-pack"));
    sup.addExtension(ExtensionDefinitions.EXT_SUPPL_GLOBAL, new BooleanType(true));
    sup.addConcept().setCode("A").addDesignation().setLanguage(LANG).setValue("Alpha v" + version);
    return sup;
  }

  private static ValueSet valueSetAskingForVersion2() {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/uses-lang-pack-2");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.addExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED, new CanonicalType(SUPPLEMENT_URL + "|2.0"));
    vs.getCompose().addInclude().setSystem(CS_URL);
    return vs;
  }

  /** The French designations of A in the expansion: which version(s) of the language pack were used. */
  private static List<String> frenchDesignationsOfA(SimpleWorkerContext ctxt) {
    ValidationOptions options = new ValidationOptions();
    Parameters params = new Parameters();
    params.addParameter("includeDesignations", true);
    ValueSetExpansionOutcome outcome = new ValueSetExpander(ctxt, new TerminologyOperationContext(ctxt, options, "expansion"))
      .expand(valueSetAskingForVersion2(), params);
    assertNotNull(outcome.getValueset(), () -> "expansion failed: " + outcome.getError());
    ValueSetExpansionContainsComponent a = outcome.getValueset().getExpansion().getContains().stream()
      .filter(c -> "A".equals(c.getCode())).findFirst().orElseThrow();
    return a.getDesignation().stream()
      .filter(d -> LANG.equals(d.getLanguage()))
      .map(d -> d.getValue())
      .collect(Collectors.toList());
  }

  /**
   * @param version1Package the package S|1.0 is loaded from: P (the base code system's package) or Q (where
   *   S|2.0 is). Nothing else differs.
   */
  @ParameterizedTest(name = "S|1.0 from package {0}")
  @ValueSource(strings = {"P", "Q"})
  void versionAskedForIsUsedWhateverPackageTheOtherVersionIsIn(String version1Package) throws Exception {
    // two versions of one url, as when they come from two packages (cacheResource rejects that otherwise)
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    ctxt.setAllowLoadingDuplicates(true);
    ctxt.cacheResourceFromPackage(baseCodeSystem(), PACKAGE_P);
    ctxt.cacheResourceFromPackage(globalLangPack("1.0"), "P".equals(version1Package) ? PACKAGE_P : PACKAGE_Q);
    ctxt.cacheResourceFromPackage(globalLangPack("2.0"), PACKAGE_Q);

    assertEquals(List.of("Alpha v2.0"), frenchDesignationsOfA(ctxt));
  }
}
