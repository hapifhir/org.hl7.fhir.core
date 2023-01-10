package org.hl7.fhir.r5.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarkdownTests {

  @Test
  void test() {
    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    ContextUtilities cu = new ContextUtilities(ctxt);
    ProfileUtilities pu = new ProfileUtilities(ctxt, null, cu);
    String s = pu.processRelativeUrls("UDI may identify an unique instance of a device, or it may only identify the type of the device.  See [UDI mappings](device-mappings.html#udi) for a complete mapping of UDI parts to Device.", 
        "http://hl7.org/fhir", "", cu.getTypeNames(), null, null, true);
    Assertions.assertNotNull(s);
  }
}