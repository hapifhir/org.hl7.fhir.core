package org.hl7.fhir.dstu3.utils.client.network;

import okhttp3.*;
import org.hl7.fhir.dstu3.formats.IParser;

import org.hl7.fhir.utilities.ToolingClientLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;

import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class FhirRequestBuilderTests {

  private static final String DUMMY_URL = "https://some-url.com/";

  Request mockRequest = new Request.Builder()
    .url(DUMMY_URL)
    .build();

  final String RESPONSE_BODY_STRING = "{}";

  Response response = new Response.Builder()
    .request(mockRequest)
    .protocol(Protocol.HTTP_2)
    .code(200) // status code
    .message("")
    .body(ResponseBody.create(RESPONSE_BODY_STRING,
      MediaType.get("application/json; charset=utf-8")
    ))
    .addHeader("Content-Type", "")
    .build();

  final Request.Builder requestBuilder = new Request.Builder()
    .url(DUMMY_URL);

  final FhirRequestBuilder fhirRequestBuilder = Mockito.spy(new FhirRequestBuilder(requestBuilder));

  @Mock
  OkHttpClient client;

  @Mock
  Call mockCall;

  @Mock
  ToolingClientLogger logger;

  @BeforeEach
  public void beforeEach() {
    Mockito.doReturn(client).when(fhirRequestBuilder).getHttpClient();
  }

  @Test
  public void testExecuteLogging() throws IOException {

    Mockito.doReturn(response).when(mockCall).execute();
    Mockito.doReturn(mockCall).when(client).newCall(ArgumentMatchers.any());

    Mockito.doReturn(null).when(fhirRequestBuilder).unmarshalReference(ArgumentMatchers.any(), ArgumentMatchers.isNull());

    fhirRequestBuilder.withLogger(logger);
    fhirRequestBuilder.execute();

    Mockito.verify(logger).logRequest(ArgumentMatchers.eq("GET"), ArgumentMatchers.eq(DUMMY_URL), ArgumentMatchers.anyList(), ArgumentMatchers.isNull());
  }

  @Test
  public void testExecuteBatchLogging() throws IOException {

    Mockito.doReturn(response).when(mockCall).execute();
    Mockito.doReturn(mockCall).when(client).newCall(ArgumentMatchers.any());

    Mockito.doReturn(null).when(fhirRequestBuilder).unmarshalFeed(ArgumentMatchers.any(), ArgumentMatchers.isNull());

    fhirRequestBuilder.withLogger(logger);
    fhirRequestBuilder.executeAsBatch();

    Mockito.verify(logger).logRequest(ArgumentMatchers.eq("GET"), ArgumentMatchers.eq(DUMMY_URL), ArgumentMatchers.anyList(), ArgumentMatchers.isNull());
  }

  @Test
  public void testUnmarshallReferenceLogging() {

    IParser parser = Mockito.mock(IParser.class);

    Mockito.doReturn(parser).when(fhirRequestBuilder).getParser(ArgumentMatchers.eq("json"));

    fhirRequestBuilder.withLogger(logger);
    fhirRequestBuilder.unmarshalReference(response, "json");

    Mockito.verify(logger).logResponse(ArgumentMatchers.eq("200"), ArgumentMatchers.anyList(), AdditionalMatchers.aryEq(RESPONSE_BODY_STRING.getBytes()));
  }

  @Test
  public void testUnmarshallFeedLogging() {

    fhirRequestBuilder.withLogger(logger);
    fhirRequestBuilder.unmarshalFeed(response, "application/json");

    Mockito.verify(logger).logResponse(ArgumentMatchers.eq("200"), ArgumentMatchers.anyList(), AdditionalMatchers.aryEq(RESPONSE_BODY_STRING.getBytes()));
  }

}
