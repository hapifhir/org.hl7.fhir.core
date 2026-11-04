package org.hl7.fhir.r5.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ContextUtilitiesTypeNamesTest {

  private static class CountingProxy extends CanonicalResourceProxy {
    private final StructureDefinition sd;
    private final AtomicInteger loads = new AtomicInteger();

    CountingProxy(StructureDefinition sd, String indexedDerivation) {
      super("StructureDefinition", sd.getId(), sd.getUrl(), sd.getVersion(), null, indexedDerivation, null);
      this.sd = sd;
    }

    @Override
    public CanonicalResource loadResource() throws FHIRException {
      loads.incrementAndGet();
      return sd;
    }
  }

  private SimpleWorkerContext context;
  private CountingProxy constraint;

  private static StructureDefinition sd(String id, StructureDefinitionKind kind, TypeDerivationRule derivation, FHIRVersion version) {
    StructureDefinition sd = new StructureDefinition();
    sd.setId(id);
    sd.setUrl("http://example.org/fhir/StructureDefinition/type-names-" + id);
    sd.setVersion("1.0.0");
    sd.setName("TypeNames" + id);
    sd.setKind(kind);
    sd.setType(kind == StructureDefinitionKind.LOGICAL ? sd.getUrl() : "TypeNames" + id);
    sd.setDerivation(derivation);
    sd.setFhirVersion(version);
    return sd;
  }

  @BeforeEach
  void setUp() throws IOException {
    context = new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext());
    PackageInformation pi = new PackageInformation("example.type.names", "1.0.0", "5.0.0", new Date());

    constraint = new CountingProxy(sd("Constraint", StructureDefinitionKind.RESOURCE, TypeDerivationRule.CONSTRAINT, FHIRVersion._5_0_0), "constraint");
    context.registerResourceFromPackage(constraint, pi);
    // a package index that doesn't give the derivation: these have to be loaded to find out
    context.registerResourceFromPackage(new CountingProxy(sd("UnknownConstraint", StructureDefinitionKind.RESOURCE, TypeDerivationRule.CONSTRAINT, FHIRVersion._5_0_0), null), pi);
    context.registerResourceFromPackage(new CountingProxy(sd("Resource", StructureDefinitionKind.RESOURCE, TypeDerivationRule.SPECIALIZATION, FHIRVersion._5_0_0), null), pi);
    context.registerResourceFromPackage(new CountingProxy(sd("Logical", StructureDefinitionKind.LOGICAL, TypeDerivationRule.SPECIALIZATION, FHIRVersion._5_0_0), "specialization"), pi);
    context.registerResourceFromPackage(new CountingProxy(sd("OtherVersion", StructureDefinitionKind.COMPLEXTYPE, TypeDerivationRule.SPECIALIZATION, FHIRVersion._4_0_1), "specialization"), pi);
  }

  static Stream<Arguments> lookups() {
    // whether the names are limited to the context's FHIR version
    return Stream.of(
      Arguments.of("getTypeNames", (Function<ContextUtilities, Collection<String>>) ContextUtilities::getTypeNames, false),
      Arguments.of("getTypeNameSet", (Function<ContextUtilities, Collection<String>>) ContextUtilities::getTypeNameSet, true));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("lookups")
  void typeNamesAreTheSameAsFilteringAllStructures(String name, Function<ContextUtilities, Collection<String>> lookup, boolean sameVersion) {
    int loads = constraint.loads.get();
    Collection<String> actual = lookup.apply(new ContextUtilities(context));
    assertEquals(loads, constraint.loads.get(), "a known constraint shouldn't be loaded");

    Set<String> expected = new HashSet<>();
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getKind() != StructureDefinitionKind.LOGICAL && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION &&
        (!sameVersion || VersionUtilities.versionMatches(context.getVersion(), sd.getFhirVersion().toCode()))) {
        expected.add(sd.getName());
      }
    }
    if (actual instanceof List) {
      assertEquals(Utilities.sorted(expected), actual);
    } else {
      assertEquals(expected, actual);
    }
    assertTrue(actual.contains("TypeNamesResource"));
    assertTrue(actual.contains("Patient"));
    assertEquals(!sameVersion, actual.contains("TypeNamesOtherVersion"));
    assertFalse(actual.contains("TypeNamesLogical"));
    assertFalse(actual.contains("TypeNamesConstraint"));
    assertFalse(actual.contains("TypeNamesUnknownConstraint"));
  }
}
