package org.hl7.fhir.dstu3.utils.validation;

import java.io.IOException;

import org.hl7.fhir.dstu3.elementmodel.Element;
import org.hl7.fhir.exceptions.FHIRException;

public interface IValidatorResourceFetcher {
  Element fetch(Object appContext, String url) throws IOException, FHIRException;
  boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException;
}
