package org.hl7.fhir.convertors.misc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.w3c.dom.Document;

public class OIDBasedValueSetImporter {

  protected IWorkerContext context;
  
  protected void init() throws FileNotFoundException, FHIRException, IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r5.core", "current");
    SimpleWorkerContext ctxt = SimpleWorkerContext.fromPackage(npm);
    ctxt.setAllowLoadingDuplicates(true);
    ctxt.loadFromPackage(pcm.loadPackage("hl7.terminology"), null);
    context = ctxt;
  }

  protected String fixVersionforSystem(String url, String csver) {
    if ("http://snomed.info/sct".equals(url)) {
      return "http://snomed.info/sct/731000124108/version/"+csver;
    }
    if ("http://loinc.org".equals(url)) {
      return csver;
    }
    if ("http://www.nlm.nih.gov/research/umls/rxnorm".equals(url)) {
      if (csver.length() == 8) {
        return csver.substring(4,6)+csver.substring(6,8)+csver.substring(0,4);
      } else {
        return csver;        
      }
      
    }
    return csver;
  }


  protected ConceptSetComponent getInclude(ValueSet vs, String url, String csver) {
    for (ConceptSetComponent t : vs.getCompose().getInclude()) {
      if (csver == null) {
        if (t.getSystem().equals(url) && !t.hasVersion()) {
          return t;
        }        
      } else {
        if (t.getSystem().equals(url) && t.hasVersion() && t.getVersion().equals(csver)) {
          return t;
        }
      }
    }
    ConceptSetComponent c = vs.getCompose().addInclude();
    c.setSystem(url);
    c.setVersion(csver);
    return c;
  }

  protected Document loadXml(InputStream fn) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
      factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
      factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
      factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
      factory.setXIncludeAware(false);
      factory.setExpandEntityReferences(false);
        
    factory.setNamespaceAware(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      return builder.parse(fn);
  }


}
