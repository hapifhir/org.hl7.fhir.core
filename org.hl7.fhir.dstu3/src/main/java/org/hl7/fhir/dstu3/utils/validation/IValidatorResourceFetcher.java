package org.hl7.fhir.dstu3.utils.validation;

import org.hl7.fhir.dstu3.elementmodel.Element;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;

import java.io.IOException;

public interface IValidatorResourceFetcher {
  Element fetch(Object appContext, String url) throws IOException, FHIRException;
  boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException;
}
