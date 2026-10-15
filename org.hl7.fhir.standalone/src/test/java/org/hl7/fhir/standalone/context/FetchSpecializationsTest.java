package org.hl7.fhir.standalone.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.PackageInformation;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.services.context.CanonicalResourceProxy;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.Test;

class FetchSpecializationsTest {

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

  private static StructureDefinition sd(String id, TypeDerivationRule derivation) {
    StructureDefinition sd = new StructureDefinition();
    sd.setId(id);
    sd.setUrl("http://example.org/fhir/StructureDefinition/fetch-specializations-" + id);
    sd.setVersion("1.0.0");
    sd.setName("FetchSpecializations" + id);
    sd.setKind(StructureDefinitionKind.LOGICAL);
    sd.setType(sd.getUrl());
    sd.setDerivation(derivation);
    return sd;
  }

  private static List<StructureDefinition> specializationsByType(SimpleWorkerContext context) {
    List<StructureDefinition> res = new ArrayList<>();
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        res.add(sd);
      }
    }
    return res;
  }

  @Test
  void sameAsFilteringAllStructuresWithoutLoadingKnownConstraints() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext((SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());

    CountingProxy constraint = new CountingProxy(sd("constraint", TypeDerivationRule.CONSTRAINT), "constraint");
    CountingProxy specialization = new CountingProxy(sd("specialization", TypeDerivationRule.SPECIALIZATION), "specialization");
    // a package index that doesn't say: the definition has to be loaded to find out
    CountingProxy unknownConstraint = new CountingProxy(sd("unknown-constraint", TypeDerivationRule.CONSTRAINT), null);
    CountingProxy unknownSpecialization = new CountingProxy(sd("unknown-specialization", TypeDerivationRule.SPECIALIZATION), null);
    PackageInformation pi = new PackageInformation("example.fetch.specializations", "1.0.0", "5.0.0", new Date());
    context.registerResourceFromPackage(constraint, pi);
    context.registerResourceFromPackage(specialization, pi);
    context.registerResourceFromPackage(unknownConstraint, pi);
    context.registerResourceFromPackage(unknownSpecialization, pi);
    int constraintLoadsWhenRegistered = constraint.loads.get();

    List<StructureDefinition> actual = context.fetchSpecializations();

    assertEquals(constraintLoadsWhenRegistered, constraint.loads.get(), "a known constraint shouldn't be loaded");
    assertTrue(actual.contains(specialization.sd));
    assertTrue(actual.contains(unknownSpecialization.sd));
    assertFalse(actual.contains(constraint.sd));
    assertFalse(actual.contains(unknownConstraint.sd));
    assertTrue(actual.size() > 100, "the core types should be there too");

    assertEquals(specializationsByType(context), actual);
  }
}
