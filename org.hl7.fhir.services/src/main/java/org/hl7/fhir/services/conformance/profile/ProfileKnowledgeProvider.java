package org.hl7.fhir.services.conformance.profile;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Element;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.model.core.Resource;

import org.hl7.fhir.model.core.StructureDefinition;


public interface ProfileKnowledgeProvider {
  boolean isDatatype(String typeSimple);
  boolean isPrimitiveType(String typeSimple);
  boolean isResource(String typeSimple);
  boolean hasLinkFor(String typeSimple);
  String getLinkFor(String corePath, String typeSimple);
  BindingResolution resolveBinding(StructureDefinition def,
    ElementDefinitionBindingComponent binding, String path) throws FHIRException;
  BindingResolution resolveBinding(StructureDefinition def, String url, String path, Element ctxt) throws FHIRException;
  String getLinkForProfile(StructureDefinition profile, String url);
  boolean prependLinks();
  String getLinkForUrl(String corePath, String s);
  String getCanonicalForDefaultContext();
  public String getDefinitionsName(Resource r);
}