package org.hl7.fhir.r5.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.xml.stream.ReferenceResolver;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.ExpressionNode;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.GraphDefinition;
import org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.graphql.Argument;
import org.hl7.fhir.utilities.graphql.EGraphEngine;
import org.hl7.fhir.utilities.graphql.EGraphQLException;
import org.hl7.fhir.utilities.graphql.GraphQLResponse;
import org.hl7.fhir.utilities.graphql.IGraphQLStorageServices;
import org.hl7.fhir.utilities.graphql.IGraphQLStorageServices.ReferenceResolution;
import org.hl7.fhir.utilities.graphql.StringValue;
import org.hl7.fhir.instance.model.api.IBaseResource;

public class GraphDefinitionEngine {


  private static final String TAG_NAME = "Compiled.expression";
  
  private IGraphQLStorageServices services;
  private IWorkerContext context;
  /**
   *  for the host to pass context into and get back on the reference resolution interface
   */
  private Object appInfo;

  /**
   *  the focus resource - if (there instanceof one. if (there isn"t,) there instanceof no focus
   */
  private Resource start;

  /**
   * The package that describes the graphQL to be executed, operation name, and variables
   */
  private GraphDefinition graphDefinition;

  /**
   * If the graph definition is being run to validate a grph
   */
  private boolean validating;
  
  /**
   * where the output from executing the query instanceof going to go
   */
  private Bundle bundle;

  private String baseURL;
  private FHIRPathEngine engine;

  public GraphDefinitionEngine(IGraphQLStorageServices services, IWorkerContext context) {
    super();
    this.services = services;
    this.context = context;
  }

  public Object getAppInfo() {
    return appInfo;
  }

  public void setAppInfo(Object appInfo) {
    this.appInfo = appInfo;
  }

  public Resource getFocus() {
    return start;
  }

  public void setFocus(Resource focus) {
    this.start = focus;
  }

  public GraphDefinition getGraphDefinition() {
    return graphDefinition;
  }

  public void setGraphDefinition(GraphDefinition graphDefinition) {
    this.graphDefinition = graphDefinition;
  }

  public Bundle getOutput() {
    return bundle;
  }

  public void setOutput(Bundle bundle) {
    this.bundle = bundle;
  }

  public IGraphQLStorageServices getServices() {
    return services;
  }

  public IWorkerContext getContext() {
    return context;
  }

  public String getBaseURL() {
    return baseURL;
  }

  public void setBaseURL(String baseURL) {
    this.baseURL = baseURL;
  }

  public boolean isValidating() {
    return validating;
  }

  public void setValidating(boolean validating) {
    this.validating = validating;
  }

  public void execute() throws EGraphEngine, EGraphQLException, FHIRException {
    assert services != null;
    assert start != null;
    assert bundle != null;
    assert baseURL != null;
    assert graphDefinition != null;
    graphDefinition.checkNoModifiers("definition", "Building graph from GraphDefinition");

    check(!start.fhirType().equals(graphDefinition.getStart()), "The Graph definition requires that the start (focus reosource) is "+graphDefinition.getStart()+", but instead found "+start.fhirType());
    
    if (!isInBundle(start)) {
      addToBundle(start);
    }
    for (GraphDefinitionLinkComponent l : graphDefinition.getLink()) {
      processLink(start.fhirType(), start, l, 1);
    }
  }

  private void check(boolean b, String msg) {
    if (!b) {
      throw new FHIRException(msg);
    }
  }

  private boolean isInBundle(Resource resource) {
    for (BundleEntryComponent be : bundle.getEntry()) {
      if (be.hasResource() && be.getResource().fhirType().equals(resource.fhirType()) && be.getResource().getId().equals(resource.getId())) {
        return true;
      }
    }
    return false;
  }

  private void addToBundle(Resource resource) {
    BundleEntryComponent be = bundle.addEntry();
    be.setFullUrl(Utilities.pathURL(baseURL, resource.fhirType(), resource.getId()));
    be.setResource(resource);
  }  

  private void processLink(String focusPath, Resource focus, GraphDefinitionLinkComponent link, int depth) {
    if (link.hasPath()) {
      processLinkPath(focusPath, focus, link, depth);
    } else {
      processLinkTarget(focusPath, focus, link, depth);
    }
  }

  private void processLinkPath(String focusPath, Resource focus, GraphDefinitionLinkComponent link, int depth) {
    String path = focusPath+" -> "+link.getPath();
    check(link.hasPath(), "Path is needed at "+path);
    check(!link.hasSliceName(), "SliceName is not yet supported at "+path);
    
    ExpressionNode node;
    if (link.getPathElement().hasUserData(TAG_NAME)) {
        node = (ExpressionNode) link.getPathElement().getUserData(TAG_NAME);
    } else {
        node = engine.parse(link.getPath());
        link.getPathElement().setUserData(TAG_NAME, node);
    }
    List<Base> matches = engine.evaluate(null, focus, focus, focus, node);
    check(!validating || matches.size() >= (link.hasMin() ? link.getMin() : 0), "Link at path "+path+" requires at least "+link.getMin()+" matches, but only found "+matches.size());
    check(!validating || matches.size() <= (link.hasMax() ?  Integer.parseInt(link.getMax()) : Integer.MAX_VALUE), "Link at path "+path+" requires at most "+link.getMax()+" matches, but found "+matches.size());
//    for (Base sel : matches) {
//      check(sel.fhirType().equals("Reference"), "Selected node from an expression must be a Reference"); // todo: should a URL be ok?
//      ReferenceResolution res = services.lookup(appInfo, focus, (Reference) sel);
//      if (res != null) {
//        check(res.getTargetContext() != focus, "how to handle contained resources is not yet resolved"); // todo
//        for (GraphDefinitionLinkTargetComponent tl : link.getTarget()) {
//          if (tl.getType().equals(res.getTarget().fhirType())) {
//            Resource r = (Resource) res.getTarget();
//            if (!isInBundle(r)) {
//              addToBundle(r);
//              for (GraphDefinitionLinkComponent l : graphDefinition.getLink()) {
//                processLink(focus.fhirType(), r, l, depth+1);
//              }
//            }
//          }
//        }
//      }
//    }
  }
  
  private void processLinkTarget(String focusPath, Resource focus, GraphDefinitionLinkComponent link, int depth) {
//    check(link.getTarget().size() == 1, "If there is no path, there must be one and only one target at "+focusPath);
//    check(link.getTarget().get(0).hasType(), "If there is no path, there must be type on the target at "+focusPath);
//    check(link.getTarget().get(0).getParams().contains("{ref}"), "If there is no path, the target must have parameters that include a parameter using {ref} at "+focusPath);
//    String path = focusPath+" -> "+link.getTarget().get(0).getType()+"?"+link.getTarget().get(0).getParams();
//    
//    List<IBaseResource> list = new ArrayList<>();
//    List<Argument> params = new ArrayList<>();
//    parseParams(params, link.getTarget().get(0).getParams(), focus);
//    services.listResources(appInfo, link.getTarget().get(0).getType().toCode(), params, list);
//    check(!validating || (list.size() >= (link.hasMin() ? link.getMin() : 0)), "Link at path "+path+" requires at least "+link.getMin()+" matches, but only found "+list.size());
//    check(!validating || (list.size() <= (link.hasMax() && !link.getMax().equals("*") ? Integer.parseInt(link.getMax()) : Integer.MAX_VALUE)), "Link at path "+path+" requires at most "+link.getMax()+" matches, but found "+list.size());
//    for (IBaseResource res : list) {
//      Resource r = (Resource) res;
//      if (!isInBundle(r)) {
//        addToBundle(r);
//        // Grahame Grieve 17-06-2020: this seems wrong to me - why restart? 
//        for (GraphDefinitionLinkComponent l : graphDefinition.getLink()) {
//          processLink(start.fhirType(), start, l, depth+1);
//        }
//      }
//    }
  }

    private void parseParams(List<Argument> params, String value, Resource res) {
      boolean refed = false;
      Map<String, List<String>> p = splitQuery(value);
      for (String n : p.keySet()) {
        for (String v : p.get(n)) {
          if (v.equals("{ref}")) {
            refed = true;
            v = res.fhirType()+'/'+res.getId();
          }
          params.add(new Argument(n, new StringValue(v)));
        }
      }
      check(refed, "no use of {ref} found");
    }

  public Map<String, List<String>> splitQuery(String string) {
    final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
    final String[] pairs = string.split("&");
    for (String pair : pairs) {
      final int idx = pair.indexOf("=");
      final String key = idx > 0 ? decode(pair.substring(0, idx), "UTF-8") : pair;
      if (!query_pairs.containsKey(key)) {
        query_pairs.put(key, new LinkedList<String>());
      }
      final String value = idx > 0 && pair.length() > idx + 1 ? decode(pair.substring(idx + 1), "UTF-8") : null;
      query_pairs.get(key).add(value);
    }
    return query_pairs;
  }

  private String decode(String s, String enc) {
    try {
      return URLDecoder.decode(s, enc);
    } catch (UnsupportedEncodingException e) {
      return s;
    }
  }
  
}
