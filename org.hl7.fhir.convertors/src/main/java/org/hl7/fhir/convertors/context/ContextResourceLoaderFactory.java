package org.hl7.fhir.convertors.context;

import org.hl7.fhir.convertors.loaders.loaderR5.ILoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R2016MayToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R2ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R3ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R4BToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R5ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R6ToR5Loader;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class ContextResourceLoaderFactory {

  public static IContextResourceLoader makeLoader(String version, ILoaderKnowledgeProviderR5 loader) {
    if (VersionUtilities.isR2Ver(version)) { 
      return new R2ToR5Loader(Utilities.stringSet("Conformance", "StructureDefinition", "ValueSet", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"), loader);
    } 
    if (VersionUtilities.isR2BVer(version)) {
      return new R2016MayToR5Loader(Utilities.stringSet("Conformance", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"), loader); // special case
    }
    if (VersionUtilities.isR3Ver(version)) {
      return new R3ToR5Loader(Utilities.stringSet("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"), loader);
    }
    if (VersionUtilities.isR4Ver(version)) {
      return new R4ToR5Loader(Utilities.stringSet("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"), loader, version);
    }
    if (VersionUtilities.isR4BVer(version)) {
      return new R4BToR5Loader(Utilities.stringSet("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"), loader, version);
    }
    if (VersionUtilities.isR6Ver(version)) {
      return new R6ToR5Loader(Utilities.stringSet("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"), loader);
    }
    return new R5ToR5Loader(Utilities.stringSet("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"), loader);
  }

}
