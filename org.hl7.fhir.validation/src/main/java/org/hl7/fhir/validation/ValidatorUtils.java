package org.hl7.fhir.validation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R2016MayToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R2ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R3ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R4BToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R5ToR5Loader;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.cli.utils.AsteriskFilter;
import org.hl7.fhir.validation.cli.utils.Common;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

//TODO find a home for these and clean it up
public class ValidatorUtils {

  protected static void grabNatives(Map<String, byte[]> source, Map<String, byte[]> binaries, String prefix) {
    for (Map.Entry<String, byte[]> e : source.entrySet()) {
      if (e.getKey().endsWith(".zip"))
        binaries.put(prefix + "#" + e.getKey(), e.getValue());
    }
  }

  public static IWorkerContext.IContextResourceLoader loaderForVersion(String version) {
    if (Utilities.noString(version)) {
      return null;
    }
    if (VersionUtilities.isR2Ver(version)) {
      return new R2ToR5Loader(new String[]{"Conformance", "StructureDefinition", "ValueSet", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProviderR5());
    } 
    if (VersionUtilities.isR2BVer(version)) {
      return new R2016MayToR5Loader(new String[]{"Conformance", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProviderR5()); // special case
    }
    if (VersionUtilities.isR3Ver(version)) {
      return new R3ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProviderR5());
    }
    if (VersionUtilities.isR4Ver(version)) {
      return new R4ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProviderR5(), version);
    }
    if (VersionUtilities.isR4BVer(version)) {
      return new R4BToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProviderR5(), version);
    }
    if (VersionUtilities.isR5Ver(version)) {
      return new R5ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProviderR5());
    }
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

  protected static List<ValidationMessage> filterMessages(List<ValidationMessage> messages) {
    List<ValidationMessage> filteredValidation = new ArrayList<ValidationMessage>();
    for (ValidationMessage e : messages) {
      if (!filteredValidation.contains(e))
        filteredValidation.add(e);
    }
    filteredValidation.sort(null);
    return filteredValidation;
  }

  protected static OperationOutcome messagesToOutcome(List<ValidationMessage> messages, SimpleWorkerContext context, FHIRPathEngine fpe) throws IOException, FHIRException, EOperationOutcome {
    OperationOutcome op = new OperationOutcome();
    for (ValidationMessage vm : filterMessages(messages)) {
      try {
        fpe.parse(vm.getLocation());
      } catch (Exception e) {
        System.out.println("Internal error in location for message: '" + e.getMessage() + "', loc = '" + vm.getLocation() + "', err = '" + vm.getMessage() + "'");
      }
      op.getIssue().add(OperationOutcomeUtilities.convertToIssue(vm, op));
    }
    if (!op.hasIssue()) {
      op.addIssue().setSeverity(OperationOutcome.IssueSeverity.INFORMATION).setCode(OperationOutcome.IssueType.INFORMATIONAL).getDetails().setText(context.formatMessage(I18nConstants.ALL_OK));
    }
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, RenderingContext.ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    RendererFactory.factory(op, rc).render(op);
    return op;
  }

  /**
   * Parses passed in resource path, adding any found references to the passed in list.
   *
   * @return {@link Boolean#TRUE} if more than one reference is found.
   */
  static boolean extractReferences(String name, List<String> refs, SimpleWorkerContext context) throws IOException {
    if (Common.isNetworkPath(name)) {
      refs.add(name);
    } else if (Common.isWildcardPath(name)) {
      AsteriskFilter filter = new AsteriskFilter(name);
      File[] files = new File(filter.getDir()).listFiles(filter);
      for (File file : files) {
        refs.add(file.getPath());
      }
    } else {
      File file = new File(name);
      if (!file.exists()) {
        if (System.console() != null) {
          System.console().printf(context.formatMessage(I18nConstants.BAD_FILE_PATH_ERROR, name));
        } else {
          System.out.println(context.formatMessage(I18nConstants.BAD_FILE_PATH_ERROR, name));
        }
        throw new IOException("File " + name + " does not exist");
      }

      if (file.isFile()) {
        refs.add(name);
      } else {
        for (int i = 0; i < file.listFiles().length; i++) {
          File[] fileList = file.listFiles();
          if (fileList[i].isFile())
            refs.add(fileList[i].getPath());
        }
      }
    }
    return refs.size() > 1;
  }

  /**
   * Iterates through the list of passed in sources, extracting all references and populated them in the passed in list.
   *
   * @return {@link Boolean#TRUE} if more than one reference is found.
   */
  public static boolean parseSources(List<String> sources, List<String> refs, SimpleWorkerContext context) throws IOException {
    boolean multipleRefsFound = sources.size() > 1;
    for (String source : sources) {
      multipleRefsFound |= extractReferences(source, refs, context);
    }
    return multipleRefsFound;
  }
}
