package org.hl7.fhir.r5.conformance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.R5ExtensionsLoader.Loadable;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.utils.ResourceSorters;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

public class R5ExtensionsLoader {
  
  public static class CanonicalResourceSortByUrl<T extends CanonicalResource> implements Comparator<Loadable<T>> {

    @Override
    public int compare(Loadable<T> arg0, Loadable<T> arg1) {
      return arg0.info.getUrl().compareTo(arg1.info.getUrl());
    }
  }

  public class Loadable<T extends CanonicalResource> {
    public Loadable(PackageResourceInformation info, NpmPackage source) {
      this.info = info;
      this.source = source;
    }
    private T resource;
    private NpmPackage source;
    private PackageResourceInformation info;
    public T getResource() throws FHIRFormatError, FileNotFoundException, IOException {
      if (resource == null) {
        CanonicalResource r = (CanonicalResource) json.parse(source.load(info));
        r.setWebPath(Utilities.pathURL(source.getWebLocation(), r.fhirType().toLowerCase()+ "-"+r.getId().toLowerCase()+".html"));
        resource = (T) r;
      }
      return resource;
    }
  }

  private BasePackageCacheManager pcm;
  private int count;
  private NpmPackage pckCore;
  private Map<String, Loadable<ValueSet>> valueSets;
  private Map<String, Loadable<CodeSystem>> codeSystems;
  private List<Loadable<StructureDefinition>> structures;
  private IWorkerContext context;
  private JsonParser json;
  
  public R5ExtensionsLoader(BasePackageCacheManager pcm, IWorkerContext context) {
    super();
    this.pcm = pcm;
    this.context = context;

    valueSets = new HashMap<>();
    codeSystems = new HashMap<>();
    structures = new ArrayList<>();
  }

  public void load() throws FHIRException, IOException {
    pckCore = pcm.loadPackage("hl7.fhir.r5.core", "5.0.0");
    loadDetails(pckCore); 
  }

  private void loadDetails(NpmPackage pck) throws IOException {
    json = new JsonParser();

    String[] types = new String[] { "StructureDefinition", "ValueSet", "CodeSystem" };
    for (PackageResourceInformation pri : pck.listIndexedResources(types)) {
      if (pri.getResourceType().equals("CodeSystem")) {
        codeSystems.put(pri.getUrl(), new Loadable<CodeSystem>(pri, pck));
        codeSystems.put(pri.getUrl()+"|"+pri.getVersion(), new Loadable<CodeSystem>(pri, pck));
      } else if (pri.getResourceType().equals("ValueSet")) {
        valueSets.put(pri.getUrl(), new Loadable<ValueSet>(pri, pck));
        valueSets.put(pri.getUrl()+"|"+pri.getVersion(), new Loadable<ValueSet>(pri, pck));
      } else if (pri.getResourceType().equals("StructureDefinition"))  {
        structures.add(new Loadable<StructureDefinition>(pri, pck));
      }
    }
  }
  
//  public void loadR5Extensions() throws FHIRException, IOException {
//    count = 0;
//    List<String> typeNames = new ContextUtilities(context).getTypeNames();
//    for (Loadable<StructureDefinition> lsd : structures) {
//      if (lsd.info.getStatedType().equals("Extension") && !context.hasResource(StructureDefinition.class, lsd.info.getUrl())) {
//        StructureDefinition sd = lsd.getResource();
//        if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
//          if (survivesStrippingTypes(sd, context, typeNames)) {
//            count++;
//            sd.setWebPath(Utilities.pathURL(pckExt.getWebLocation(), "extension-"+sd.getId().toLowerCase()+".html"));
//            registerTerminologies(sd);
//            context.cacheResourceFromPackage(sd, new PackageInformation(lsd.source));
//          }
//        }
//      }
//    }
//  }

  public void loadR5SpecialTypes(List<String> types) throws FHIRException, IOException {
    for (Loadable<StructureDefinition> lsd : structures) {
      if (Utilities.existsInList(lsd.info.getId(), types)) {
        StructureDefinition sd = lsd.getResource();
        count++;
        List<ElementDefinition> rl = new ArrayList<>();
        for (ElementDefinition ed : sd.getDifferential().getElement()) {
          if (!stripTypes(ed, sd, types)) {
            rl.add(ed);
          }
        }
        sd.getDifferential().getElement().removeAll(rl);
        rl.clear();
        for (ElementDefinition ed : sd.getSnapshot().getElement()) {
          if (!stripTypes(ed, sd, types)) {
            rl.add(ed);
          }
        } 
        sd.getSnapshot().getElement().removeAll(rl);
        sd.setWebPath(Utilities.pathURL(lsd.source.getWebLocation(), sd.getId().toLowerCase()+".html"));
        registerTerminologies(sd);
        context.cacheResourceFromPackage(sd, new PackageInformation(lsd.source));
      }
    }    
  }
  
  private boolean stripTypes(ElementDefinition ed, StructureDefinition sd, List<String> types) {
    if (!ed.getPath().contains(".") || !ed.hasType()) {
      return true;
    }
    ed.getType().removeIf(tr -> context.fetchTypeDefinition(tr.getWorkingCode()) == null);
    if (!ed.hasType()) {
      return false;
    }
    for (TypeRefComponent tr : ed.getType()) {
      if (tr.hasTargetProfile()) {
        tr.getTargetProfile().removeIf(n -> !context.hasResource(StructureDefinition.class, n.asStringValue()) && !n.asStringValue().equals(sd.getUrl()) && !types.contains(tail(n.asStringValue())));
        if (!tr.hasTargetProfile()) {
          return false;
        }
      }
    }
    return true;
  }

  private Object tail(String s) {
    if (s == null || !s.contains("/")) {
      return s;
    }
    return s.substring(s.lastIndexOf("/")+1);
  }

  private void registerTerminologies(StructureDefinition sd) throws FHIRFormatError, FileNotFoundException, IOException {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
        String vsu = ed.getBinding().getValueSet();
        ValueSet vs = context.fetchResource(ValueSet.class, vsu);
        if (vs == null) {
          loadValueSet(vsu, context, valueSets, codeSystems);
        } else if (vs.hasVersion()) {
          ed.getBinding().setValueSet(vs.getUrl()+"|"+vs.getVersion());
        }
      }
    }
  }

  private void loadValueSet(String url, IWorkerContext context, Map<String, Loadable<ValueSet>> valueSets, Map<String, Loadable<CodeSystem>> codeSystems) throws FHIRFormatError, FileNotFoundException, IOException {
    if (valueSets.containsKey(url)) {
      ValueSet vs = valueSets.get(url).getResource();      
      context.cacheResourceFromPackage(vs, vs.getSourcePackage());
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        for (CanonicalType t : inc.getValueSet()) {
          loadValueSet(t.asStringValue(), context, valueSets, codeSystems);
        }
        if (inc.hasSystem()) {
          if (!inc.hasVersion()) {
            if (codeSystems.containsKey(inc.getSystem())) {
              CodeSystem cs = codeSystems.get(inc.getSystem()).getResource();
              CodeSystem csAlready = context.fetchCodeSystem(inc.getSystem());
              if (csAlready == null) {
                context.cacheResourceFromPackage(cs, cs.getSourcePackage());
              }
            }
          } else if (context.fetchResource(CodeSystem.class, inc.getSystem(), inc.getVersion()) == null && codeSystems.containsKey(inc.getSystem()+"|"+inc.getVersion())) {
            CodeSystem cs1 = codeSystems.get(inc.getSystem()+"|"+inc.getVersion()).getResource();
            context.cacheResourceFromPackage(cs1, cs1.getSourcePackage());
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

  public byte[] getMap() throws IOException {
   return pckCore.hasFile("other", "spec.internals") ?  TextFile.streamToBytes(pckCore.load("other", "spec.internals")) : null;
  }

  public NpmPackage getPckCore() {
    return pckCore;
  }



  
}
