package org.hl7.fhir.r4b.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.CodeSystem;
import org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4b.model.Resource;

public class ResourceFixer {


  public static void main(String[] args) {
    new ResourceFixer().vistAllResources(args[0]);

  }

  private Set<String> refs = new HashSet<>();
  
  private void vistAllResources(String folder) {
    
    for (File f : new File(folder).listFiles()) {
      if (f.isDirectory()) {
        vistAllResources(f.getAbsolutePath());
      } else if (f.getName().endsWith(".json")) {
        Resource r = null;
        try {
          r = new JsonParser().parse(new FileInputStream(f));
        } catch (Throwable e) {
          // nothing at all
        }
        if (r != null) {
          try {
            if (visitResource(r)) {
              new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), r);
            }
          } catch (Exception e) {
            System.out.println("Error processing "+f.getAbsolutePath()+": "+e.getMessage());
//            e.printStackTrace();
          }
        }
      } else if (f.getName().endsWith(".xml")) {
        Resource r = null;
        try {
          r = new XmlParser().parse(new FileInputStream(f));
        } catch (Throwable e) {
          // nothing at all
        }
        if (r != null) {
          try {
            if (visitResource(r)) {
              new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), r);
            }
          } catch (Exception e) {
            System.out.println("Error processing "+f.getAbsolutePath()+": "+e.getMessage());
//            e.printStackTrace();
          }
        }
      }
    } 
  }

  private boolean visitResource(Resource r) {
    if (r.hasId()) {
      String ref = r.fhirType()+"/"+r.getId();
      if (refs.contains(ref)) {
        throw new FHIRException("Duplicate resource "+ref);
      }
      refs.add(ref);
    }
    if (r instanceof CodeSystem) {
      return visitCodeSystem((CodeSystem) r);
    }
    return false;
  }

  private boolean visitCodeSystem(CodeSystem cs) {
    if (!cs.hasContent()) {
      System.out.println("Setting content = complete for CodeSystem/"+cs.getId());      
      cs.setContent(CodeSystemContentMode.COMPLETE);
      return true;
    } else if (!cs.hasHierarchyMeaning() && hasHierarchy(cs)) {      
      System.out.println("Setting hierarchyMeaning = is-a for CodeSystem/"+cs.getId());      
      cs.setHierarchyMeaning(CodeSystemHierarchyMeaning.ISA);
      return true;
    } else {      
      return false;
    }
  }

  private boolean hasHierarchy(CodeSystem cs) {
    for (ConceptDefinitionComponent c : cs.getConcept()) {
      if (c.hasConcept()) {
        return true;
      }
    }
    return false;
  }

}
