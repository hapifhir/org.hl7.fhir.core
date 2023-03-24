package org.hl7.fhir.r5.utils;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer;

public class ResourceLanguageFileBuilder {

  
  private LanguageFileProducer file;
  private String source;
  private String target;
  private IWorkerContext context;
  StructureDefinition profile = null;

  public void prepare(LanguageFileProducer file, IWorkerContext context, String source, String target) {
    this.file = file;
    this.source = source;
    this.target = target;
    this.context = context;
  }
  
  
  public StructureDefinition getProfile() {
    return profile;
  }

  public void setProfile(StructureDefinition profile) {
    this.profile = profile;
  }
  
  public void build(Resource res) throws IOException {
    String id = res.fhirType();
    String path = res.fhirType() +"-"+res.getIdBase();
    
    if (!source.equals(res.getLanguage())) {
      throw new FHIRException("Language mismatch: '"+source+"' => '"+target+"' but resource language is '"+res.getLanguage()+"'");
    }

    if (profile == null) {
      profile = context.fetchTypeDefinition(res.fhirType());
      if (profile == null) {
        throw new FHIRException("profile");
      }
    }
    
    file.start(path, path, res.getWebPath(), source, target);
  
    for (Property p : res.children()) {
      process(p, id, path);      
    }
    
    file.finish();
  }
  
  private void process(Property p, String id, String path) throws IOException {
    if (p.hasValues()) {
      int i = 0;
      for (Base b : p.getValues()) {
        String pid = id+"."+p.getName();
        String ppath = path+"."+p.getName()+(p.isList() ? "["+i+"]" : "");
        i++;
        if (isTranslatable(p, b, pid)) {
          file.makeEntry(ppath, null, null, b.primitiveValue(), getTranslation(b, target));
        }
        for (Property pp : b.children()) {
          process(pp, pid, ppath);      
        }
      }
    }  
  }

  private boolean isTranslatable(Property p, Base b, String id) {
    if (new ContextUtilities(context).isPrimitiveDatatype(b.fhirType())) { // never any translations for non-primitives
      ElementDefinition ed = null;
      for (ElementDefinition t : profile.getSnapshot().getElement()) {
        if (t.getId().equals(id)) {
          ed = t;
        }
      }
      if (ed != null && ed.hasExtension(ToolingExtensions.EXT_TRANSLATABLE)) {
        return true;
      }
    }
    return false;
  }

  private String getTranslation(Base b, String target2) {
    if (b instanceof  org.hl7.fhir.r5.model.Element) {
      org.hl7.fhir.r5.model.Element e = (org.hl7.fhir.r5.model.Element) b;
      for (Extension ext : e.getExtensionsByUrl(ToolingExtensions.EXT_TRANSLATION)) {
        String lang = ext.hasExtension("lang") ? ext.getExtensionString("lang") : null;
        if (target.equals(lang)) {
          return ext.getExtensionString("content");
        }
      }      
    }
    return null;
  }

  public void build(Element res) {
    
  }

}
