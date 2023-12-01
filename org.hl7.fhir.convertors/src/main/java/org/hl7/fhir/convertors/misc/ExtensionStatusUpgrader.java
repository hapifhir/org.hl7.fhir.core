package org.hl7.fhir.convertors.misc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.formats.ResourceFolderVisitor;
import org.hl7.fhir.r5.utils.formats.ResourceFolderVisitor.IResourceObserver;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class ExtensionStatusUpgrader implements IResourceObserver {

  public static void main(String[] args) throws IOException {
    new ExtensionStatusUpgrader().execute(args[0]);

  }
  Map<String, CanonicalResource> r4b = new HashMap<>();
  Map<String, CanonicalResource> r5 = new HashMap<>();

  private void execute(String folder) throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.FilesystemPackageCacheManagerBuilder().build();
    
    // load R4
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r4.core");
    for (String n : npm.listResources("StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter")) {
      CanonicalResource cr = (CanonicalResource) VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(npm.load(n)));
      r4b.put(cr.getUrl(), cr);
    }
    // load R5-ballot3 
    npm = pcm.loadPackage("hl7.fhir.r5.core#5.0.0-ballot");
    for (String n : npm.listResources("StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter")) {
      CanonicalResource cr = (CanonicalResource) new org.hl7.fhir.r5.formats.JsonParser().parse(npm.load(n));
      r5.put(cr.getUrl(), cr);
    }
    
    new ResourceFolderVisitor(this, "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter").visit(folder);
  }

  @Override
  public boolean visitResource(String filename, Resource resource) {
    boolean changed = false;
    CanonicalResource cr = (CanonicalResource) resource;
    if (r4b.containsKey(cr.getUrl())) {
      CanonicalResource ocr = r4b.get(cr.getUrl());
      if (cr.getStatus() != PublicationStatus.ACTIVE) {
        cr.setStatus(PublicationStatus.ACTIVE);
        changed = true;
      }
      if (ocr.getStandardsStatus() == StandardsStatus.NORMATIVE) {
        if (cr.getStandardsStatus() != StandardsStatus.NORMATIVE) {
          cr.setStandardsStatus(StandardsStatus.NORMATIVE);
          changed = true;
        }
      } else {
        if (cr.getStandardsStatus() != StandardsStatus.TRIAL_USE) {
          cr.setStandardsStatus(StandardsStatus.TRIAL_USE);
          changed = true;
        }
      }
      if (cr.getExperimental()) {
        cr.setExperimental(false);
        changed = true;        
      }
      if (!"3".equals(ToolingExtensions.readStringExtension(cr, ToolingExtensions.EXT_FMM_LEVEL))) {
        ToolingExtensions.setIntegerExtension(cr, ToolingExtensions.EXT_FMM_LEVEL, 3);
        changed = true;        
      }
    } else if (r5.containsKey(cr.getUrl())) {
      CanonicalResource ocr = r5.get(cr.getUrl());
      if (cr.getStatus() != PublicationStatus.DRAFT) {
        cr.setStatus(PublicationStatus.DRAFT);
        changed = true;
      }
      if (ocr.getStandardsStatus() == StandardsStatus.NORMATIVE) {
        if (cr.getStandardsStatus() != StandardsStatus.NORMATIVE) {
          cr.setStandardsStatus(StandardsStatus.NORMATIVE);
          changed = true;
        }
      } else {
        if (cr.getStandardsStatus() != StandardsStatus.TRIAL_USE) {
          cr.setStandardsStatus(StandardsStatus.TRIAL_USE);
          changed = true;
        }
      }
      if (cr.getExperimental()) {
        cr.setExperimental(false);
        changed = true;        
      }
      if (!"2".equals(ToolingExtensions.readStringExtension(cr, ToolingExtensions.EXT_FMM_LEVEL))) {
        ToolingExtensions.setIntegerExtension(cr, ToolingExtensions.EXT_FMM_LEVEL, 2);
        changed = true;        
      }
    } else {
      if (cr.getStatus() != PublicationStatus.DRAFT) {
        cr.setStatus(PublicationStatus.DRAFT);
        changed = true;
      }
      if (cr.getStandardsStatus() != StandardsStatus.DRAFT) {
        cr.setStandardsStatus(StandardsStatus.DRAFT);
        changed = true;
      }
      if (!cr.getExperimental()) {
        cr.setExperimental(true);
        changed = true;        
      }
    }
    return changed;
  }

}
