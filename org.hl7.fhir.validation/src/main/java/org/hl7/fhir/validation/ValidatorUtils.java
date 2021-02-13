package org.hl7.fhir.validation;

import org.hl7.fhir.convertors.loaders.*;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.Utilities;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

public class ValidatorUtils {

  protected static void grabNatives(Map<String, byte[]> source, Map<String, byte[]> binaries, String prefix) {
    for (Map.Entry<String, byte[]> e : source.entrySet()) {
      if (e.getKey().endsWith(".zip"))
        binaries.put(prefix + "#" + e.getKey(), e.getValue());
    }
  }

  protected static IWorkerContext.IContextResourceLoader loaderForVersion(String version) {
    if (Utilities.noString(version))
      return null;
    if (version.startsWith("1.0"))
      return new R2ToR5Loader(new String[]{"Conformance", "StructureDefinition", "ValueSet", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new BaseLoaderR5.NullLoaderKnowledgeProvider());
    if (version.startsWith("1.4"))
      return new R2016MayToR5Loader(new String[]{"Conformance", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new BaseLoaderR5.NullLoaderKnowledgeProvider()); // special case
    if (version.startsWith("3.0"))
      return new R3ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new BaseLoaderR5.NullLoaderKnowledgeProvider());
    if (version.startsWith("4.0"))
      return new R4ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new BaseLoaderR5.NullLoaderKnowledgeProvider());
    if (version.startsWith("5.0"))
      return new R5ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new BaseLoaderR5.NullLoaderKnowledgeProvider());
    return null;
  }

  protected static Document parseXml(byte[] cnt) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // xxe protection
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    factory.setXIncludeAware(false);
    factory.setExpandEntityReferences(false);
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse(new ByteArrayInputStream(cnt));
  }
}
