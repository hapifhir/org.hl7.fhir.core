package org.hl7.fhir.r4.fhirpath;

import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FHIRPathEngineTest {

  @Test
  public void testResolveFunctionSupportsHapiParser() {

    Patient p = new Patient();

    Organization org = new Organization();
    org.setId("#123");
    org.setName("An Organization");
    p.getContained().add(org);

    p.setManagingOrganization(new Reference("#123"));

    IWorkerContext ctx = TestingUtilities.context();
    FHIRPathEngine engine = new FHIRPathEngine(ctx);

    List<Base> outcome = engine.evaluate(p, "Patient.managingOrganization.reference.resolve()");
    assertEquals(org, outcome.get(0));
  }

}
