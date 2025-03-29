package org.hl7.fhir.validation;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.terminologies.ConceptMapEngine;
import org.hl7.fhir.r5.utils.structuremap.ITransformerServices;
import org.hl7.fhir.r5.utils.structuremap.VariableMode;
import org.hl7.fhir.r5.utils.structuremap.Variables;

public class TransformSupportServices implements ITransformerServices {

  private final PrintWriter mapLog;
  private final SimpleWorkerContext context;
  private List<Base> outputs;
  private Map<String, Base> referenceCache;

  public TransformSupportServices(List<Base> outputs,
                                  PrintWriter mapLog,
                                  SimpleWorkerContext context) {
    this.outputs = outputs;
    this.mapLog = mapLog;
    this.context = context;
  }

  @Override
  public void log(String message) {
    if (mapLog != null)
      mapLog.println(message);
    System.out.println(message);
  }

  @Override
  public Base createType(Object appInfo, String name, ProfileUtilities profileUtilities) throws FHIRException {
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, name);
    return Manager.build(context, sd, profileUtilities);
  }

  @Override
  public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
    if (atRootofTransform)
      outputs.add(res);
    return res;
  }

  @Override
  public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
    ConceptMapEngine cme = new ConceptMapEngine(context);
    return cme.translate(source, conceptMapUrl);
  }
  
  @Override
  public Base resolveReference(Object appContext, String url) throws FHIRException {
    if(this.referenceCache == null) {
      // look in Bundle for reference. Lazy cache references for subsequent lookups
      cacheBundleReferences((Variables) appContext);
    }
    
    Base r = referenceCache.get(url);
    if(r != null)
      return r;
    throw new FHIRException("resolveReference is only supported for Bundles");
  }

  @Override
  public List<Base> performSearch(Object appContext, String url) throws FHIRException {
    throw new FHIRException("performSearch is not supported yet");
  }
  
  private void cacheBundleReferences(Variables vars) {
    this.referenceCache = new HashMap<String, Base>();
    Element bundle = (Element) vars.get(VariableMode.INPUT, "bundle");
    if(bundle != null && bundle.hasChildren("entry")) {
      for(Element entry : bundle.getChildrenByName("entry")) {
        Element r = entry.getNamedChild("resource", false);
        if(r != null) {
          if(r.getIdBase() != null) {
            // Resource/id
            this.referenceCache.put(r.fhirType() + "/" + r.getIdBase(), r);
          }
          if(entry.getChildValue("fullUrl") != null) {
            // fullUrl
            this.referenceCache.put(entry.getChildValue("fullUrl"), r);
          }
        }
      }
    }
  }
}
