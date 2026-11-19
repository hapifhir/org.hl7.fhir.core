package org.hl7.fhir.r5.elementmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.CanonicalResourceProxy;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The fallback loops in ParserBase.getDefinition find a specialization that isn't a base FHIR
 * resource by type name, by url, and (for xml) by namespace and name, without loading the
 * definitions that the package index says are constraints.
 */
class ParserBaseSpecializationLookupTest {

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
  private StructureDefinition resource;
  private JsonParser parser;

  private static StructureDefinition sd(String id, TypeDerivationRule derivation) {
    StructureDefinition sd = new StructureDefinition();
    sd.setId(id);
    sd.setUrl("http://example.org/fhir/StructureDefinition/lookup-" + id);
    sd.setVersion("1.0.0");
    sd.setName("Lookup" + id);
    sd.setKind(StructureDefinitionKind.RESOURCE);
    sd.setType("Lookup" + id);
    sd.setDerivation(derivation);
    sd.setFhirVersion(FHIRVersion._5_0_0);
    // a snapshot, so that getDefinition doesn't need to generate one
    sd.getSnapshot().addElement().setPath(sd.getType());
    return sd;
  }

  @BeforeEach
  void setUp() throws IOException {
    context = new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext());
    PackageInformation pi = new PackageInformation("example.lookup", "1.0.0", "5.0.0", new Date());
    constraint = new CountingProxy(sd("Constraint", TypeDerivationRule.CONSTRAINT), "constraint");
    context.registerResourceFromPackage(constraint, pi);
    resource = sd("Resource", TypeDerivationRule.SPECIALIZATION);
    context.registerResourceFromPackage(new CountingProxy(resource, null), pi);
    parser = new JsonParser(context);
  }

  @Test
  void findsSpecializationByTypeName() throws Exception {
    assertSame(resource, parser.getDefinition(new ArrayList<>(), 0, 0, "LookupResource"));
    assertEquals(0, constraint.loads.get(), "a known constraint shouldn't be loaded");
  }

  @Test
  void findsSpecializationByUrl() throws Exception {
    assertSame(resource, parser.getDefinition(new ArrayList<>(), 0, 0, resource.getUrl()));
    assertEquals(0, constraint.loads.get(), "a known constraint shouldn't be loaded");
  }

  @Test
  void findsSpecializationByXmlName() throws Exception {
    assertSame(resource, parser.getDefinition(new ArrayList<>(), 0, 0, FormatUtilities.FHIR_NS, "LookupResource"));
    assertEquals(0, constraint.loads.get(), "a known constraint shouldn't be loaded");
  }

  @Test
  void doesNotFindConstraint() {
    assertThrows(FHIRFormatError.class, () -> parser.getDefinition(new ArrayList<>(), 0, 0, "LookupConstraint"));
    assertThrows(FHIRFormatError.class, () -> parser.getDefinition(new ArrayList<>(), 0, 0, FormatUtilities.FHIR_NS, "LookupConstraint"));
    assertEquals(0, constraint.loads.get(), "a known constraint shouldn't be loaded");
  }
}
