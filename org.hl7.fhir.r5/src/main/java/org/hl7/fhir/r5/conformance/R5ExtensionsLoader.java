package org.hl7.fhir.r5.conformance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.PackageVersion;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

public class R5ExtensionsLoader {
  private BasePackageCacheManager pcm;
  private int count;
  private byte[] map;
  private NpmPackage pck;
  
  public R5ExtensionsLoader(BasePackageCacheManager pcm) {
    super();
    this.pcm = pcm;
  }

  public void loadR5Extensions(IWorkerContext context) throws FHIRException, IOException {
    pck = pcm.loadPackage("hl7.fhir.r5.core", "current");
    String[] types = new String[] { "StructureDefinition", "ValueSet", "CodeSystem" };
    Map<String, ValueSet> valueSets = new HashMap<>();
    Map<String, CodeSystem> codeSystems = new HashMap<>();
    List<StructureDefinition> extensions = new ArrayList<>();
    JsonParser json = new JsonParser();
    for (PackageResourceInformation pri : pck.listIndexedResources(types)) {
      CanonicalResource r = (CanonicalResource) json.parse(pck.load(pri));
      r.setUserData("path", Utilities.pathURL(pck.getWebLocation(), r.fhirType().toLowerCase()+ "-"+r.getId().toLowerCase()+".html"));
      if (r instanceof CodeSystem) {
        codeSystems.put(r.getUrl(), (CodeSystem) r);
      } else if (r instanceof ValueSet) {
        valueSets.put(r.getUrl(), (ValueSet) r);
      } else if (r instanceof StructureDefinition)  {
        extensions.add((StructureDefinition) r);
      }
    } 
    PackageVersion pd = new PackageVersion(pck.name(), pck.version(), pck.dateAsDate());
    count = 0;
    List<String> typeNames = context.getTypeNames();
    for (StructureDefinition sd : extensions) {    
      if (sd.getType().equals("Extension") && sd.getDerivation() == TypeDerivationRule.CONSTRAINT &&
          !context.hasResource(StructureDefinition.class, sd.getUrl())) {
        if (survivesStrippingTypes(sd, context, typeNames)) {
          count++;
          sd.setUserData("path", Utilities.pathURL(pck.getWebLocation(), "extension-"+sd.getId().toLowerCase()+".html"));
          context.cacheResourceFromPackage(sd, pd);
          registerTerminologies(sd, context, valueSets, codeSystems, pd);
        }
      }
    }
    
    map = pck.hasFile("other", "spec.internals") ?  TextFile.streamToBytes(pck.load("other", "spec.internals")) : null;
  }

  private void registerTerminologies(StructureDefinition sd, IWorkerContext context, Map<String, ValueSet> valueSets, Map<String, CodeSystem> codeSystems, PackageVersion pd) {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
        String vs = ed.getBinding().getValueSet();
        if (!context.hasResource(ValueSet.class, vs)) {
          loadValueSet(vs, context, valueSets, codeSystems, pd);
        }
      }
    }
    
  }

  private void loadValueSet(String url, IWorkerContext context, Map<String, ValueSet> valueSets, Map<String, CodeSystem> codeSystems, PackageVersion pd) {
    if (valueSets.containsKey(url)) {
      ValueSet vs = valueSets.get(url);      
      context.cacheResourceFromPackage(vs, pd);
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        for (CanonicalType t : inc.getValueSet()) {
          loadValueSet(t.asStringValue(), context, valueSets, codeSystems, pd);
        }
        if (inc.hasSystem()) {
          if (!context.hasResource(CodeSystem.class, inc.getSystem()) && codeSystems.containsKey(inc.getSystem())) {
            context.cacheResourceFromPackage(codeSystems.get(inc.getSystem()), pd);
          }
        }
      }
    }
    
  }

  private boolean survivesStrippingTypes(StructureDefinition sd, IWorkerContext context, List<String> typeNames) {
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      stripTypes(ed, context, typeNames);
    }
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (!stripTypes(ed, context, typeNames)) {
        return false;
      }
    }  
    return true;
  }

  private boolean stripTypes(ElementDefinition ed, IWorkerContext context, List<String> typeNames) {
    if (!ed.getPath().contains(".") || !ed.hasType()) {
      return true;
    }
    ed.getType().removeIf(tr -> !typeNames.contains(tr.getWorkingCode()));
    if (!ed.hasType()) {
      return false;
    }
    for (TypeRefComponent tr : ed.getType()) {
      if (tr.hasTargetProfile()) {
        tr.getTargetProfile().removeIf(n -> !context.hasResource(StructureDefinition.class, n.asStringValue()));
        if (!tr.hasTargetProfile()) {
          return false;
        }
      }
    }
    return true;
  }

  public BasePackageCacheManager getPcm() {
    return pcm;
  }

  public int getCount() {
    return count;
  }

  public byte[] getMap() {
    return map;
  }

  public NpmPackage getPck() {
    return pck;
  }


  
}
