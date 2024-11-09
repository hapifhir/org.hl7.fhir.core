package org.hl7.fhir.dstu3.utils.client.network;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.http.HTTPHeader;

/**
 * Generic Implementation of Client Headers.
 *
 * Stores a list of headers for HTTP calls to the TX server. Users can implement their own instance if they desire
 * specific, custom behavior.
 */
public class ClientHeaders {
  
  private final ArrayList<HTTPHeader> headers;

  public ClientHeaders() {
    this.headers = new ArrayList<>();
  }

  public ClientHeaders(ArrayList<HTTPHeader> headers) {
    this.headers = headers;
  }

  public ArrayList<HTTPHeader> headers() {
    return headers;
  }

  /**
   * Add a header to the list of stored headers for network operations.
   *
   * @param header {@link HTTPHeader} to add to the list.
   * @throws FHIRException if the header being added is a duplicate.
   */
  public ClientHeaders addHeader(HTTPHeader header) throws FHIRException {
    if (headers.contains(header)) {
      throw new FHIRException("Attempting to add duplicate header, <" + header.getName() + ", "
        + header.getValue() + ">.");
    }
    headers.add(header);
    return this;
  }

  /**
   * Add a header to the list of stored headers for network operations.
   *
   * @param headerList {@link List} of {@link HTTPHeader} to add.
   * @throws FHIRException if any of the headers being added is a duplicate.
   */
  public ClientHeaders addHeaders(List<HTTPHeader> headerList) throws FHIRException {
    headerList.forEach(this::addHeader);
    return this;
  }

  /**
   * Removes the passed in header from the list of stored headers.
   * @param header {@link HTTPHeader} to remove from the list.
   * @throws FHIRException if the header passed in does not exist within the stored list.
   */
  public ClientHeaders removeHeader(HTTPHeader header) throws FHIRException {
    if (!headers.remove(header)) {
      throw new FHIRException("Attempting to remove header, <" + header.getName() + ", "
        + header.getValue() + ">, from GenericClientHeaders that is not currently stored.");
    }
    return this;
  }

  /**
   * Removes the passed in headers from the list of stored headers.
   * @param headerList {@link List} of {@link HTTPHeader} to remove.
   * @throws FHIRException if any of the headers passed in does not exist within the stored list.
   */
  public ClientHeaders removeHeaders(List<HTTPHeader> headerList) throws FHIRException {
    headerList.forEach(this::removeHeader);
    return this;
  }

  /**
   * Clears all stored {@link HTTPHeader}.
   */
  public ClientHeaders clearHeaders() {
    headers.clear();
    return this;
  }

  @Override
  public String toString() {
    return this.headers.stream()
      .map(header -> "\t" + header.getName() + ":" + header.getValue())
      .collect(Collectors.joining(",\n", "{\n", "\n}"));
  }
}
