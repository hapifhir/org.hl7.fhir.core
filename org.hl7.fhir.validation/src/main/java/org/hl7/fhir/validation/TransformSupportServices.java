package org.hl7.fhir.validation;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.terminologies.ConceptMapEngine;
import org.hl7.fhir.r5.utils.structuremap.ITransformerServices;

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
    this.referenceCache = new HashMap<String, Base>();
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
  
  public void addToReferenceCache(Base res) {
    // PoC: Just adding Resource/id for demonstration purposes.
    // TODO: add other options (see BaseValidator.resolveInBundle() how to correctly resolve within a Bundle)
    this.referenceCache.put(res.fhirType() + "/" + res.getIdBase(), res);
  }

  @Override
  public Base resolveReference(Object appContext, String url) throws FHIRException {
    Base r = referenceCache.get(url);
    if(r != null)
      return r;
    throw new FHIRException("resolveReference is only supported for Bundles");
  }

  @Override
  public List<Base> performSearch(Object appContext, String url) throws FHIRException {
    throw new FHIRException("performSearch is not supported yet");
  }
}
