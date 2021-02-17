package org.hl7.fhir.r4.test;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.IParser;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.EOperationOutcome;
import org.hl7.fhir.r4.utils.NarrativeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ResourceCopyTests {


  @Test
  public void testCopyExtensionForEnumerationField() throws FHIRException {
    // Create new Observation and set the Extension with field value without status field set .
    Observation obs = new Observation();
    obs.getStatusElement().getExtension().add(new Extension().setUrl("Sampleurl"));
    obs.getStatusElement().getExtension().add(new Extension().setUrl("Sampleurl2"));

    Observation copyObs = obs.copy();
    Assertions.assertEquals(obs.hasStatusElement(),copyObs.hasStatusElement(),"Status Element not copied ");
    Assertions.assertEquals(obs.getStatusElement().hasExtension(),copyObs.getStatusElement().hasExtension(),"Status Element Extension not copied ");
    Assertions.assertEquals(obs.getStatusElement().getExtension().get(0).getUrl(),copyObs.getStatusElement().getExtension().get(0).getUrl(),"Status Element Extension url not copied ");
    Assertions.assertEquals(obs.getStatusElement().getExtension().get(1).getUrl(),copyObs.getStatusElement().getExtension().get(1).getUrl(),"Status Element Extension url not copied ");
    //Verify the object at toplevel using equals Deep
    Assertions.assertEquals(obs.equalsDeep(copyObs),true,"DeepEquals fails");
  }

  @Test
  public void testCopyEnumerationField() throws FHIRException, IOException {
    // Create new Observation and set the Extension with field value as well as status field set .
    Observation obs = new Observation();
    obs.setStatus(Observation.ObservationStatus.AMENDED);
    obs.getStatusElement().getExtension().add(new Extension().setUrl("Sampleurl"));


    Observation copyObs = obs.copy();
    Assertions.assertEquals(obs.getStatus(),copyObs.getStatus(),"Status  not copied ");
    Assertions.assertEquals(obs.hasStatusElement(),copyObs.hasStatusElement(),"Status Element not copied ");
    Assertions.assertEquals(obs.getStatusElement().hasExtension(),copyObs.getStatusElement().hasExtension(),"Status Element Extension not copied ");
    Assertions.assertEquals(obs.getStatusElement().getExtension().get(0).getUrl(),copyObs.getStatusElement().getExtension().get(0).getUrl(),"Status Element Extension url not copied ");
    //Verify the object at toplevel using equals Deep
    Assertions.assertEquals(obs.equalsDeep(copyObs),true,"DeepEquals fails");

  }
}