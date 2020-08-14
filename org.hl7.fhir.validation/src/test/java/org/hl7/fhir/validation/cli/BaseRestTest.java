package org.hl7.fhir.validation.cli;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public abstract class BaseRestTest {

  protected final String JSON_MIME_TYPE = "application/json";

  @BeforeAll
  public static void startServer() {
    ValidatorGui.start(new CliContext(), null, false);
  }

  @AfterAll
  public static void stopServer() {
    ValidatorGui.stop();
  }

  public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz)
    throws IOException {

    String jsonFromResponse = EntityUtils.toString(response.getEntity());
    ObjectMapper mapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return mapper.readValue(jsonFromResponse, clazz);
  }

}