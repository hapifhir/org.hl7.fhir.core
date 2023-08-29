package org.hl7.fhir.r4.utils.validation;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.elementmodel.Element;

public interface IValidatorResourceFetcher {
  Element fetch(Object appContext, String url) throws FHIRException, IOException;

  boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException;
}
