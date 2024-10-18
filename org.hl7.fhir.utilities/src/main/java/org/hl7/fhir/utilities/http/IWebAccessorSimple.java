package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.util.Map;

public interface IWebAccessorSimple {
  HTTPResult get(String url, String accept, Map<String, String> headers) throws IOException;
  HTTPResult post(String url, byte[] bytes, String contentType, String accept, Map<String, String> headers) throws IOException;
  HTTPResult put(String url, byte[] bytes, String contentType, String accept, Map<String, String> headers) throws IOException;
}
