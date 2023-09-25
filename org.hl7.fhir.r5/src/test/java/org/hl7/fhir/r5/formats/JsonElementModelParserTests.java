package org.hl7.fhir.r5.formats;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonElementModelParserTests {

  @Test
  public void composeString_forResource_worksForCurrentEncoding() throws IOException {
    
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    ProfileUtilities utils = new ProfileUtilities(context, null, null);
    JsonParser jp = new JsonParser(context, utils);
    InputStream cnt = TestingUtilities.loadTestResourceStream("r5", "json-extension-example.json");
    List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
    Element e = jp.parseSingle(cnt, errors);
    
    Assertions.assertEquals(2, e.getChildren("extension").get(0).getChildren().size());
  }

}
