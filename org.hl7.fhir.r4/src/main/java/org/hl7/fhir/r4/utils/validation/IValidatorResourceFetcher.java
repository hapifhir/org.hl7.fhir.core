package org.hl7.fhir.r4.utils.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.elementmodel.Element;

import java.io.IOException;

public interface IValidatorResourceFetcher {
  Element fetch(Object appContext, String url) throws FHIRException, IOException;
  boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException;
}
