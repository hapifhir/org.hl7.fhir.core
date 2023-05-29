package org.hl7.fhir.convertors.misc;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;

public class OIDBasedValueSetImporter {

  protected IWorkerContext context;

  protected void init() throws FHIRException, IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r5.core", "5.0.0");
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(npm);
    context.loadFromPackage(pcm.loadPackage("hl7.terminology"), null);
    this.context = context;
  }

  protected String fixVersionforSystem(String url, String csver) {
    if ("http://snomed.info/sct".equals(url)) {
      return "http://snomed.info/sct/731000124108/version/" + csver;
    }
    if ("http://loinc.org".equals(url)) {
      return csver;
    }
    if ("http://www.nlm.nih.gov/research/umls/rxnorm".equals(url)) {
      if (csver.length() == 8) {
        return csver.substring(4, 6) + csver.substring(6, 8) + csver.substring(0, 4);
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
}
