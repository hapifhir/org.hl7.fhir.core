package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_50;
import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public final class VersionConvertorFactory_14_50 {

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_14_50());
  }

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src, BaseAdvisor_14_50 advisor) throws FHIRException {
    return new VersionConvertor_14_50(advisor).convertResource(src);
  }

  public static org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_14_50());
  }

  public static org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src, BaseAdvisor_14_50 advisor) throws FHIRException {
    return new VersionConvertor_14_50(advisor).convertResource(src);
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu2016may.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_14_50());
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu2016may.model.Type src, BaseAdvisor_14_50 advisor) throws FHIRException {
    return new VersionConvertor_14_50(advisor).convertType(src);
  }

  public static org.hl7.fhir.dstu2016may.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_14_50());
  }

  public static org.hl7.fhir.dstu2016may.model.Type convertType(org.hl7.fhir.r5.model.DataType src, BaseAdvisor_14_50 advisor) throws FHIRException {
    return new VersionConvertor_14_50(advisor).convertType(src);
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "Bundle", "CodeSystem", "CompartmentDefinition", "ConceptMap", "CapabilityStatement", "ImplementationGuide", "NamingSystem", "OperationDefinition", "OperationOutcome", "Questionnaire", "QuestionnaireResponse", "SearchParameter", "StructureDefinition", "StructureMap", "ValueSet");
  }
}