package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction;
import org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class CapabilityStatementRenderer extends ResourceRenderer {
  
  private static final String EXPECTATION = "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation";
  private static final String COMBINED = "http://hl7.org/fhir/StructureDefinition/capabilitystatement-search-parameter-combination";
  private static final String SP_BASE = "http://hl7.org/fhir/searchparameter/";
  private static final String FHIR_BASE = "http://hl7.org/fhir/";
  private static final String VERS_DEF_PREFIX = "FHIR Release ";

  private String currentFhirBase = "";
  private String collapseClass = "panel-collapse in";
  
  //Private classes for driving the rendering

  private class CombinedSearchParamSet {
    private Map<Boolean, List<SingleParam>> params;
    String expectation = "";

    CombinedSearchParamSet(String expectation) {
      params = new HashMap<Boolean, List<SingleParam>>();
      params.put(true, new ArrayList<SingleParam>());
      params.put(false, new ArrayList<SingleParam>());
      if (!Utilities.noString(expectation)) this.expectation = expectation;
    }
 
    public Map<Boolean, List<SingleParam>> getParams() {
        return params;
    }

    public String getExpectation() {
        return expectation;
    }

    public void addParam(boolean required, SingleParam param) {
      params.get(required).add(param);
    }
  }
  private class SingleParam {
    private String name = "";
    private String definition = "";
    private String type = "";
    private String documentation = "";
    private String expectation = "";
    private String hostResource = "";

    public SingleParam(String name) {
      if (!Utilities.noString(name)) this.name=name;
    }
 
    public SingleParam(String name, String definition) {
      if (!Utilities.noString(name)) this.name=name;
      if (!Utilities.noString(definition)) this.definition=definition;
    }

    public SingleParam(String name, String definition, String type) {
      if (!Utilities.noString(name)) this.name=name;
      if (!Utilities.noString(definition)) this.definition=definition;
      if (!Utilities.noString(type)) this.type=type;
    }

    public SingleParam(String name, String definition, String type, String documentation) {
      if (!Utilities.noString(name)) this.name=name;
      if (!Utilities.noString(definition)) this.definition=definition;
      if (!Utilities.noString(type)) this.type=type;
      if (!Utilities.noString(documentation)) this.documentation=documentation;
    }
 
    public SingleParam(String name, String definition, String type, String documentation, String expectation, String hostResource) {
      if (!Utilities.noString(name)) this.name=name;
      if (!Utilities.noString(definition)) this.definition=definition;
      if (!Utilities.noString(type)) this.type=type;
      if (!Utilities.noString(documentation)) this.documentation=documentation;
      if (!Utilities.noString(expectation)) this.expectation=expectation;
      if (!Utilities.noString(hostResource)) this.hostResource = hostResource;
    }
 
    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

    public String getDocumentation() {
        return documentation;
    }
 
    public String getType() {
        return type;
    }

    public String getExpectation() {
        return expectation;
    }

    public String getHostResource() {
      return hostResource;
    }
  }
  private class ResourceSearchParams {
    private Map<String, List<CombinedSearchParamSet>> combinedParams;
    private Map<String, SingleParam> individualParamsByName;
    private Map<String, List<SingleParam>> individualParamsByExp;

    public ResourceSearchParams() {
      combinedParams = new HashMap<String, List<CombinedSearchParamSet>>();
      combinedParams.put("SHALL", new ArrayList<CombinedSearchParamSet>());
      combinedParams.put("SHOULD", new ArrayList<CombinedSearchParamSet>());
      combinedParams.put("SHOULD-NOT", new ArrayList<CombinedSearchParamSet>());
      combinedParams.put("MAY", new ArrayList<CombinedSearchParamSet>());
      combinedParams.put("supported", new ArrayList<CombinedSearchParamSet>());
      individualParamsByName  = new HashMap<String, SingleParam>();
      individualParamsByExp = new HashMap<String, List<SingleParam>>();
      individualParamsByExp.put("SHALL", new ArrayList<SingleParam>());
      individualParamsByExp.put("SHOULD", new ArrayList<SingleParam>());
      individualParamsByExp.put("MAY", new ArrayList<SingleParam>());
      individualParamsByExp.put("SHOULD-NOT", new ArrayList<SingleParam>());
      individualParamsByExp.put("supported", new ArrayList<SingleParam>());
    }

    public Map<String, List<CombinedSearchParamSet>> getCombined() {
      return combinedParams;
    }

    public Map<String, SingleParam> getInd() {
        return individualParamsByName;
    }

    public Map<String, SingleParam> getIndbyName() {
      return individualParamsByName;
    }
    
    public Map<String, List<SingleParam>> getIndbyExp() {
      return individualParamsByExp;
    }

    public void addCombinedParamSet(String exp, CombinedSearchParamSet params) {
      combinedParams.get(exp).add(params);
    }
 
    public void addIndividualbyName(String name, SingleParam param) {
      individualParamsByName.put(name, param);
    }
 
    public void addIndividualbyExp(String exp, SingleParam param) {
      individualParamsByExp.get(exp).add(param);
    }
 
  }
 
  private class SingleOperation {
    private String name = "";
    private String definition = "";
    private String documentation = "";
    private String expectation = "";

    public SingleOperation(String name) {
      if (!Utilities.noString(name)) this.name=name;
    }

    public SingleOperation(String name, String definition) {
      if (!Utilities.noString(name)) this.name=name;
      if (!Utilities.noString(definition)) this.definition=definition;
    }

    public SingleOperation(String name, String definition, String documentation) {
      if (!Utilities.noString(name)) this.name=name;
      if (!Utilities.noString(definition)) this.definition=definition;

      if (!Utilities.noString(documentation)) this.documentation=documentation;
    }

    public SingleOperation(String name, String definition, String documentation, String expectation) {
      if (!Utilities.noString(name)) this.name=name;
      if (!Utilities.noString(definition)) this.definition=definition;
      if (!Utilities.noString(documentation)) this.documentation=documentation;
      if (!Utilities.noString(expectation)) this.expectation=expectation;
    }
 
    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

    public String getDocumentation() {
        return documentation;
     }

    public String getExpectation() {
      return expectation;
    }
  }
 
  private class ResourceOperations {
    private Map<String, List<SingleOperation>> operationsByExp;

    public ResourceOperations() {

      operationsByExp = new HashMap<String, List<SingleOperation>>();
      operationsByExp.put("SHALL", new ArrayList<SingleOperation>());
      operationsByExp.put("SHOULD", new ArrayList<SingleOperation>());
      operationsByExp.put("MAY", new ArrayList<SingleOperation>());
      operationsByExp.put("SHOULD-NOT", new ArrayList<SingleOperation>());
      operationsByExp.put("supported", new ArrayList<SingleOperation>());
    }
 
    public Map<String, List<SingleOperation>> getOperations() {
      return operationsByExp;
    }
    public void addOperation(String exp, SingleOperation op) {
      operationsByExp.get(exp).add(op);
    }

  }

  //Constructors
  public CapabilityStatementRenderer(RenderingContext context) {
    super(context);
  }

  public CapabilityStatementRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (CapabilityStatement) dr);
  }

  public boolean render(XhtmlNode x, CapabilityStatement conf) throws FHIRFormatError, DefinitionException, IOException {
    boolean igRenderingMode = (context.getRules() == GenerationRules.IG_PUBLISHER);
    FHIRVersion currentVersion = conf.getFhirVersion();
    String versionPathComponent = getVersionPathComponent(currentVersion.getDefinition());
    if (!Utilities.noString(versionPathComponent)) {
      currentFhirBase = FHIR_BASE + versionPathComponent + "/";
    }
    else {
      currentFhirBase = FHIR_BASE;
    }
    
    String igVersion = conf.getVersion();

    x.h(2,"title").addText(conf.getTitle());
    XhtmlNode uList = x.ul();
    uList.li().addText("Implementation Guide Version: " + igVersion);
    uList.li().addText("FHIR Version: " + currentVersion.toCode());
 
    addSupportedFormats(uList, conf);
    
    uList.li().addText("Published on: " + conf.getDate());
    uList.li().addText("Published by: " + conf.getPublisherElement().asStringValue());


    XhtmlNode block = x.addTag("blockquote").attribute("class","impl-note");
    block.addTag("p").addTag("strong").addText("Note to Implementers: FHIR Capabilities");
    block.addTag("p").addText("Any FHIR capability may be 'allowed' by the system unless explicitly marked as \"SHALL NOT\". A few items are marked as MAY in the Implementation Guide to highlight their potential relevance to the use case.");


    addSupportedIGs(x, conf);

    int restNum = conf.getRest().size();
    int nextLevel = 3;
    if (restNum > 0) {
      x.h(2,"rest").addText("FHIR RESTful Capabilities");
      int count=1;
      for (CapabilityStatementRestComponent rest : conf.getRest()) {
        if (restNum > 1) {
          x.h(3,"rest"+Integer.toString(count)).addText("REST Configuration " + Integer.toString(count));
          nextLevel = 4;
        }
        addRestConfigPanel(x, rest, nextLevel, count);
        
        boolean hasVRead = false;
        boolean hasPatch = false;
        boolean hasDelete = false;
        boolean hasHistory = false;
        boolean hasUpdates = false;
        for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
          hasVRead = hasVRead || hasOp(r, TypeRestfulInteraction.VREAD);
          hasPatch = hasPatch || hasOp(r, TypeRestfulInteraction.PATCH);
          hasDelete = hasDelete || hasOp(r, TypeRestfulInteraction.DELETE);
          hasHistory = hasHistory || hasOp(r, TypeRestfulInteraction.HISTORYTYPE);
          hasUpdates = hasUpdates || hasOp(r, TypeRestfulInteraction.HISTORYINSTANCE);
        }
        if (rest.getResource().size() >0) {
          x.h(nextLevel,"resourcesCap" + Integer.toString(count)).addText("Capabilities by Resource/Profile");
          x.h(nextLevel+1,"resourcesSummary" + Integer.toString(count)).addText("Summary");
          addSummaryIntro(x);
          addSummaryTable(x, rest, hasVRead, hasPatch, hasDelete, hasHistory, hasUpdates, count);
          x.addTag("hr");
          //Third time for individual resources
          int resCount = 1;
          for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
            addResourceConfigPanel(x, r, nextLevel+1, count, resCount, igRenderingMode);
            resCount++;
          }
        }
        count++;
      }
    }

    return true;
  }

  private String getVersionPathComponent(String definition) {
    if (Utilities.noString(definition)) return "";
    if (!definition.startsWith(VERS_DEF_PREFIX)) return "";
    String restOfDef[] = definition.substring(VERS_DEF_PREFIX.length()).split(" ");
    if (restOfDef[1].startsWith("(")) return "R"+restOfDef[0];
    return "";
  }

  public void describe(XhtmlNode x, CapabilityStatement cs) {
    x.tx(display(cs));
  }

  public String display(CapabilityStatement cs) {
    return cs.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((CapabilityStatement) r).present();
  }


  private boolean hasOp(CapabilityStatementRestResourceComponent r, TypeRestfulInteraction on) {
    for (ResourceInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return true;
    }
    return false;
  }

  private String showOp(CapabilityStatementRestResourceComponent r, TypeRestfulInteraction on) {
    for (ResourceInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return "y";
    }
    return "";
  }

  private String showOp(CapabilityStatementRestComponent r, SystemRestfulInteraction on) {
    for (SystemInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return "y";
    }
    return "";
  }

  private XhtmlNode addTableRow(XhtmlNode t, String name) {
    XhtmlNode tr = t.tr();
    tr.td().addText(name);
    return tr.td();
  }
  
  private void addTableRow(XhtmlNode t, String name, String value) {
    XhtmlNode tr = t.tr();
    tr.td().addText(name);
    tr.td().addText(value);
  }

  @Nullable
  private String getExtValueCode(Extension ext) {
    if (ext != null) {
      return ext.getValueCodeType().getCode();
    }
    return null;
  }

  private void addSupportedIGs(XhtmlNode x, CapabilityStatement cap) {
    String capExpectation=null;
    if (cap.hasImplementationGuide()) {
      ArrayList<String> igShoulds = new ArrayList<String>();
      ArrayList<String> igShalls = new ArrayList<String>();
      ArrayList<String> igMays = new ArrayList<String>();
      int i=0;
      for (CanonicalType c : cap.getImplementationGuide())
      {
        capExpectation=getExtValueCode(c.getExtensionByUrl(EXPECTATION));
        if (!Utilities.noString(capExpectation)) {
          if (capExpectation.equals("SHALL")) {
            igShalls.add(c.asStringValue());
          }
          else if (capExpectation.equals("SHOULD")) {
            igShoulds.add(c.asStringValue());
          }
          else if (capExpectation.equals("MAY")) {
            igMays.add(c.asStringValue());
          }
        }
        else {
          igShalls.add(c.asStringValue());   //default to SHALL
        }
      }
      XhtmlNode ul = null;
      if (igShalls.size() > 0) {
        x.h(3,"shallIGs").addText("SHALL Support the Following Implementation Guides");
        ul = x.ul();
        for (String url : igShalls) {
          addResourceLink(ul.li(), url, url);
          //ul.li().ah(url).addText(url);
        }
      }
      if (igShoulds.size() > 0) {
        x.h(3,"shouldIGs").addText("SHOULD Support the Following Implementation Guides");
        ul = x.ul();
        for (String url : igShoulds) {
          addResourceLink(ul.li(), url, url);
          //ul.li().ah(url).addText(url);
        }
      }
      if (igMays.size() > 0) {
        x.h(3,"shouldIGs").addText("SHOULD Support the Following Implementation Guides");
        ul = x.ul();
        for (String url : igMays) {
          addResourceLink(ul.li(), url, url);
          //ul.li().ah(url).addText(url);
        }
      }

    }
  }

  private void addSupportedFormats(XhtmlNode uList, CapabilityStatement conf) {
    XhtmlNode lItem = uList.li();
    lItem.addText("Supported Formats: ");
    Boolean first = true;
    String capExpectation = null;
    for (CodeType c : conf.getFormat()) {
      if (!first) {
        lItem.addText(", ");
      }
      capExpectation = getExtValueCode(c.getExtensionByUrl(EXPECTATION));
      if (!Utilities.noString(capExpectation)) {
        lItem.addTag("strong").addText(capExpectation);
        lItem.addText(" support ");
      }
      lItem.code().addText(c.getCode());
      first = false;
    }
    lItem = uList.li();
    lItem.addText("Supported Patch Formats: ");
    first=true;
    for (CodeType c : conf.getPatchFormat()) {
      if (!first) {
        lItem.addText(", ");
      }
      capExpectation = getExtValueCode(c.getExtensionByUrl(EXPECTATION));
      if (!Utilities.noString(capExpectation)) {
        lItem.addTag("strong").addText(capExpectation);
        lItem.addText(" support ");
      }
      lItem.code().addText(c.getCode());
      first = false;
    }
  }

  private void addRestConfigPanel(XhtmlNode x, CapabilityStatementRestComponent rest, int nextLevel, int count) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode panel= null;
    XhtmlNode body = null;
    XhtmlNode row = null;
    XhtmlNode cell = null;
    XhtmlNode heading = null;
    panel = x.div().attribute("class", "panel panel-default");
    heading = panel.div().attribute("class", "panel-heading").h(nextLevel,"mode" + Integer.toString(count)).attribute("class", "panel-title");
    heading.addText("Mode: ");
    heading.code().addText(rest.getMode().toCode());
    body = panel.div().attribute("class", "panel-body");
    addMarkdown(body, rest.getDocumentation());
    //Security info
    if (rest.hasSecurity()) {
      body.div().attribute("class","lead").addTag("em").addText("Security");
      String mdText = rest.getSecurity().getDescription();
      boolean cors = rest.getSecurity().getCors();
      List<CodeableConcept> services = rest.getSecurity().getService();
      if (cors || services.size() >0) {
        row = body.div().attribute("class","row");
        row.div().attribute("class","col-lg-6").addText(getCorsText(cors));
        cell = row.div().attribute("class","col-lg-6");
        cell.addText("Security services supported: ");
        addSeparatedListOfCodes(cell, getSecServices(services), ",");
      } 
    
      if (!Utilities.noString(mdText)) {
        addMarkdown(body.blockquote(),mdText);
      }
    }  
    body.div().attribute("class","lead").addTag("em").addText("Summary of System-wide Interactions");
    addSystemInteractions(body, rest.getInteraction());
        
  }

  private String getCorsText(boolean on) {
    if (on) {
      return "Enable CORS: yes";
    }
    return "Enable CORS: no";
  }

  private List<String> getSecServices(List<CodeableConcept> services)
  {
    List<String> serviceStrings = new ArrayList<String>();
    for (CodeableConcept c: services) {
      if (c.hasCoding()){
        serviceStrings.add(c.getCodingFirstRep().getCode());
      }
      else {
        serviceStrings.add(c.getText());
      }
    }
    return serviceStrings;
  }


  private void addSystemInteractions(XhtmlNode body, List<SystemInteractionComponent> interactions) {
    if (interactions.size()==0) return;
    XhtmlNode uList = body.ul();
    String capExpectation = null;
    String expName = null;
    String documentation = null;
    Map<String,String> expression = null;
    ArrayList<Map<String,String>> shalls = new ArrayList<Map<String,String>>();
    ArrayList<Map<String,String>> shoulds = new ArrayList<Map<String,String>>();
    ArrayList<Map<String,String>> mays = new ArrayList<Map<String,String>>();
    ArrayList<Map<String,String>> shouldnots = new ArrayList<Map<String,String>>();
    ArrayList<Map<String,String>> supports = new ArrayList<Map<String,String>>();
    for (SystemInteractionComponent comp : interactions) {
      capExpectation=getExtValueCode(comp.getExtensionByUrl(EXPECTATION));
      expName = comp.getCode().toCode();
      documentation = comp.getDocumentation();
      if (Utilities.noString(documentation)) {
        documentation="";
      }
      expression = new HashMap<String,String>();
      expression.put(expName,documentation);
      if (!Utilities.noString(capExpectation)) {
        if (capExpectation.equals("SHALL")) {
          shalls.add(expression);
        }
        else if (capExpectation.equals("SHOULD")) {
          shoulds.add(expression);
        }
        else if (capExpectation.equals("MAY")) {
          mays.add(expression);
        }
        else if (capExpectation.equals("SHOULD-NOT")) {
          shouldnots.add(expression);
        }
      }
      else {
        supports.add(expression);
      }
    }
    addInteractionListItems(uList, "SHALL", shalls);
    addInteractionListItems(uList, "SHOULD", shoulds);
    addInteractionListItems(uList, "MAY", mays);
    addInteractionListItems(uList, "SHOULD NOT", shouldnots);
    addInteractionListItems(uList, null, supports);
  }

  private void addInteractionListItems(XhtmlNode uList, String verb, List<Map<String,String>> interactions) {
    XhtmlNode item = null;
    String interaction = null;
    String documentation = null;
    for (Map<String,String> interactionMap : interactions) {
      item = uList.li();
      if (Utilities.noString(verb)) {
        item.addText("Supports the ");
      }
      else {
        item.addTag("strong").addText(verb);
        item.addText(" support the ");
      }
      interaction = interactionMap.keySet().toArray()[0].toString();
      item.code(interaction);
      documentation = interactionMap.get(interaction);
      if (Utilities.noString(documentation)) {
        item.addText(" interaction.");
      }
      else {
        item.addText(" interaction described as follows:");
        try {
          addMarkdown(item, documentation);
        } catch (FHIRFormatError e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (DefinitionException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }

  private void addInteractionSummaryList(XhtmlNode uList, String verb, List<String> interactions) {
    if (interactions.size() == 0) return;
    XhtmlNode item = uList.li();
    if (Utilities.noString(verb)) {
      item.addText("Supports ");
    }
    else {
      item.addTag("strong").addText(verb);
      item.addText(" support ");
    }
    addSeparatedListOfCodes(item, interactions, ",");
    item.addText(".");
  }

  private void addSummaryIntro(XhtmlNode x) {
    XhtmlNode uList = null;
    XhtmlNode lItem = null;
    x.para().addText("The summary table lists the resources that are part of this configuration, and for each resource it lists:");
    uList=x.ul();
    uList.li().addText("The relevant profiles (if any)");
    lItem = uList.li();
    lItem.addText("The interactions supported by each resource (");
    lItem.b().addTag("span").attribute("class","bg-info").addText("R");
    lItem.addText("ead, ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("S");
    lItem.addText("earch, ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("U");
    lItem.addText("pdate, and ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("C");
    lItem.addText("reate, are always shown, while ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("VR");
    lItem.addText("ead, ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("P");
    lItem.addText("atch, ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("D");
    lItem.addText("elete, ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("H");
    lItem.addText("istory on ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("I");
    lItem.addText("nstance, or ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("H");
    lItem.addText("istory on ");
    lItem.b().addTag("span").attribute("class","bg-info").addText("T");
    lItem.addText("ype are only present if at least one of the resources has support for them.");
    uList.li().addTag("span").addText("The required, recommended, and some optional search parameters (if any). ");
    lItem = uList.li();
    lItem.addText("The linked resources enabled for ");
    lItem.code().addText("_include");
    lItem = uList.li();
    lItem.addText("The other resources enabled for ");
    lItem.code().addText("_revinclude");
    uList.li().addText("The operations on the resource (if any)");
  }

  private void addSummaryTable(XhtmlNode x, CapabilityStatement.CapabilityStatementRestComponent rest, boolean hasVRead, boolean hasPatch, boolean hasDelete, boolean hasHistory, boolean hasUpdates, int count) throws IOException {
    XhtmlNode t = x.div().attribute("class","table-responsive").table("table table-condensed table-hover");
    XhtmlNode tr = t.addTag("thead").tr();
    tr.th().b().tx("Resource Type");
    tr.th().b().tx("Profile");
    tr.th().attribute("class", "text-center").b().attribute("title", "GET a resource (read interaction)").tx("R");
    if (hasVRead)
      tr.th().attribute("class", "text-center").b().attribute("title", "GET past versions of resources (vread interaction)").tx("V-R");
    tr.th().attribute("class", "text-center").b().attribute("title", "GET all set of resources of the type (search interaction)").tx("S");
    tr.th().attribute("class", "text-center").b().attribute("title", "PUT a new resource version (update interaction)").tx("U");
    if (hasPatch)
      tr.th().attribute("class", "text-center").b().attribute("title", "PATCH a new resource version (patch interaction)").tx("P");
    tr.th().attribute("class", "text-center").b().attribute("title", "POST a new resource (create interaction)").tx("C");
    if (hasDelete)
      tr.th().attribute("class", "text-center").b().attribute("title", "DELETE a resource (delete interaction)").tx("D");
    if (hasUpdates)
      tr.th().attribute("class", "text-center").b().attribute("title", "GET changes to a resource (history interaction on instance)").tx("H-I");
    if (hasHistory)
      tr.th().attribute("class", "text-center").b().attribute("title", "GET changes for all resources of the type (history interaction on type)").tx("H-T");
    tr.th().b().attribute("title", "Required and recommended search parameters").tx("Searches");
    tr.th().code().b().tx("_include");
    tr.th().code().b().tx("_revinclude");
    tr.th().b().tx("Operations");

    XhtmlNode tbody = t.addTag("tbody");
    XhtmlNode profCell = null;
    boolean hasProf = false;
    boolean hasSupProf = false;
    int resCount = 1;
    String countString = "";
    for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
      tr = tbody.tr();
      countString = Integer.toString(count) + "-" + Integer.toString(resCount);
      tr.td().ah("#" + r.getType() + countString).addText(r.getType());
      resCount++;
      //Show profiles
      profCell = tr.td();
      hasProf = r.hasProfile();
      hasSupProf = r.hasSupportedProfile();
      if ((!hasProf) && (!hasSupProf)) {
        profCell.nbsp();
      }
      else if (hasProf) {
        addResourceLink(profCell, r.getProfile(), r.getProfile());
        //profCell.ah(r.getProfile()).addText(r.getProfile());
        if (hasSupProf) {
          profCell.br();
          profCell.addTag("em").addText("Additional supported profiles:");
          renderSupportedProfiles(profCell, r);
        }
      }
      else {    //Case of only supported profiles
        profCell.addText("Supported profiles:");
        renderSupportedProfiles(profCell, r);
      }
      //Show capabilities
      tr.td().addText(showOp(r, TypeRestfulInteraction.READ));
      if (hasVRead)
        tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.VREAD));
      tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.SEARCHTYPE));
      tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.UPDATE));
      if (hasPatch)
        tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.PATCH));
      tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.CREATE));
      if (hasDelete)
        tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.DELETE));
      if (hasUpdates)
        tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.HISTORYINSTANCE));
      if (hasHistory)
        tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.HISTORYTYPE));
      //Show search parameters
      List<String> stringList = new ArrayList<String>();
      getParams(stringList,r.getSearchParam());
      getCombinedParams(stringList,r.getExtensionsByUrl(COMBINED));
      tr.td().addText(getSeparatedList(stringList,","));
      //Show supported includes
      stringList = getStringListFromStringTypeList(r.getSearchInclude());
      addSeparatedListOfCodes(tr.td(), stringList, ",");
      //Show supported revIncludes
      stringList = getStringListFromStringTypeList(r.getSearchRevInclude());
      addSeparatedListOfCodes(tr.td(), stringList, ",");
      //Show supported operations
      stringList = getStringListFromOperations(r.getOperation());
      addSeparatedListOfCodes(tr.td(), stringList, ",");
    }
  }

  private List<String> getCombinedParams(List<String> paramNames, List<Extension> paramExtensions) {
    for (Extension e : paramExtensions) {
      String capExpectation = e.getExtensionString(EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        if (capExpectation.equals("SHALL") || capExpectation.equals("SHOULD") || capExpectation.equals("MAY")) {
          paramNames.add(printCombinedParams(e));
        }
      }
    }
    return paramNames;
  }

  private void renderSupportedProfiles(XhtmlNode profCell, CapabilityStatementRestResourceComponent r) throws IOException {
    for (CanonicalType sp: r.getSupportedProfile()) { 
      profCell.br();
      profCell.nbsp().nbsp();
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, sp.getValue());
      if (sd != null) {
        profCell.ah(sd.getWebPath()).addText(sd.present());
      } else {
        profCell.ah(sp.getValue()).addText(sp.getValue());        
      }
    }
    if (r.hasExtension(ToolingExtensions.EXT_PROFILE_MAPPING)) {
      profCell.br();
      profCell.b().tx("Profile Mapping");
      XhtmlNode tbl = profCell.table("grid");
      boolean doco = false;
      for (Extension ext : r.getExtensionsByUrl(ToolingExtensions.EXT_PROFILE_MAPPING)) {
        doco = doco || ext.hasExtension("documentation");
      }
      XhtmlNode tr = tbl.tr();
      tr.th().tx("Criteria");
      tr.th().tx("Profile");
      if (doco) {
        tr.th().tx("Criteria");
      }
      for (Extension ext : r.getExtensionsByUrl(ToolingExtensions.EXT_PROFILE_MAPPING)) {
        tr = tbl.tr();
        tr.td().code().tx(ToolingExtensions.readStringExtension(ext, "search"));
        String url = ToolingExtensions.readStringExtension(ext, "profile");
        StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, url);
        if (sd != null) {
          tr.td().code().ah(sd.getWebPath()).tx(sd.present());
        } else {
          tr.td().code().tx(url);
        }
        if (doco) {
          tr.td().code().markdown(ToolingExtensions.readStringExtension(ext, "documentation"), "documentation"); 
        }
      }      
    }
  }

  private String printCombinedParams(Extension e) {
    StringBuilder params = new StringBuilder();
    List<Extension> requiredParams = e.getExtensionsByUrl("required");
    List<Extension> optionalParams = e.getExtensionsByUrl("optional");
    boolean first = true;
    for (Extension param : requiredParams) {
      if (!first) {
        params.append("+");
      }
      first = false;
      params.append(param.getValueStringType());
    }
    for (Extension param : optionalParams) {
      params.append("+");
      params.append(param.getValueStringType());
    }
    return params.toString();
  }

  private List<String> getParams(List<String> paramNames, List<CapabilityStatementRestResourceSearchParamComponent> params) {
    for (CapabilityStatementRestResourceSearchParamComponent p : params) {
      String capExpectation = p.getExtensionString(EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        if (capExpectation.equals("SHALL") || capExpectation.equals("SHOULD") || capExpectation.equals("MAY")) {
          paramNames.add(p.getName());
        }
      }
      else {  //When there is not extension, assume parameters are required
        paramNames.add(p.getName()); 
      }
    }
    return paramNames;
  }

  private String getSeparatedList(List<String> list, String separator) {
    StringBuilder result = new StringBuilder();
    boolean first = true;
    for (String s : list) {
      if (!first) {
        result.append(separator + " ");
      }
      first = false;
      result.append(s);
    }
    return result.toString();
  }

  private List<String> getStringListFromStringTypeList(List<StringType> list) {
    List<String> stringList = new ArrayList<String>();
    for (StringType st : list) {
      stringList.add(st.asStringValue());
    }
    return stringList;
  }

  private void addSeparatedListOfCodes(XhtmlNode parent, List<String> list, String separator) {
    boolean first = true;
    for (String s : list) {
      if (!first) {
        parent.addText(separator + " ");
      }
      first = false;
      parent.code().addText(s);
    }
  }

  private List<String> getStringListFromOperations(List<CapabilityStatementRestResourceOperationComponent> list) {
    List<String> result = new ArrayList<String>();
    for (CapabilityStatementRestResourceOperationComponent op : list) {
      String capExpectation = op.getExtensionString(EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        if (capExpectation.equals("SHALL") || capExpectation.equals("SHOULD") || capExpectation.equals("MAY")) {
          result.add("$"+op.getName());
        }
      }
    }
    return result;
  }

  private void addResourceConfigPanel(XhtmlNode x, CapabilityStatementRestResourceComponent r, int nextLevel, int count, int resCount, boolean igRenderingMode) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode panel= null;
    XhtmlNode body = null;
    XhtmlNode panelHead = null;
    XhtmlNode panelRef = null;
    
    String countString = Integer.toString(count) + "-" + Integer.toString(resCount);
    panel = x.div().attribute("class", "panel panel-default");
    if (igRenderingMode) {
      panelHead = panel.div().attribute("class", "panel-heading").attribute("role", "tab").attribute("id","heading" + countString).h(nextLevel,r.getType() + countString).attribute("class", "panel-title");
      panelRef = panelHead.ah("#collapse" + countString).attribute("role","button").attribute("data-toggle", "collapse").attribute("aria-expanded","true").attribute("aria-controls","collapse" + countString);
      //panelRef = panelHead.addTag("button").attribute("href","#collapse" + countString).attribute("role","button").attribute("data-toggle", "collapse").attribute("aria-expanded","false").attribute("aria-controls","collapse" + countString);
      //panelRef.span("float: right;","").attribute("class", "lead").addText("Resource Conformance: " + getResourceExpectation(r));
      panelRef.span("float: right;","").addText("Resource Conformance: " + getResourceExpectation(r));
      panelRef.addText(r.getType());
      body = panel.div().attribute("class", collapseClass).attribute("id","collapse" + countString).attribute("role","tabpanel").attribute("aria-labelledby","heading" + countString).div().attribute("class", "panel-body").div().attribute("class", "container");
    }
    else {
      panelHead = panel.div().attribute("class", "panel-heading").h(nextLevel,r.getType() + countString).attribute("class", "panel-title");
      panelHead.span("float: right;","").addText("Resource Conformance: " + getResourceExpectation(r));
      panelHead.addText(r.getType());
      body = panel.div().attribute("class", "panel-body").div().attribute("class", "container");
    }
    
    
    //Top part of panel
    XhtmlNode cell = null;
    XhtmlNode row = body.div().attribute("class", "row");   
    String text = r.getProfile();
    boolean pullInteraction = false;
    String refPolicyWidth = "col-lg-3";
    if (!Utilities.noString(text)) {
      cell = row.div().attribute("class", "col-lg-6");
      addLead(cell,"Base System Profile");
      cell.br();
      addResourceLink(cell, text, text);
      cell=row.div().attribute("class", "col-lg-3");
      addLead(cell, "Profile Conformance");
      cell.br();
      cell.b().addText(getProfileExpectation(r.getProfileElement()));
    }
    else {   //No profile, use FHIR Core Resource
      cell = row.div().attribute("class", "col-lg-4");
      addLead(cell,"Core FHIR Resource");
      cell.br();
      cell.ah(currentFhirBase + r.getType().toLowerCase() + ".html").addText(r.getType());
      pullInteraction = true;
      refPolicyWidth = "col-lg-4";
    }
    
    cell = row.div().attribute("class", refPolicyWidth);
    addLead(cell,"Reference Policy");
    cell.br();
    addSeparatedListOfCodes(cell, getReferencePolicyStrings(r.getReferencePolicy()) , ",");
    if (pullInteraction) {
      addInteractions(row, r, 4);
    }
    body.para();
    List<CanonicalType> supportedProfiles = r.getSupportedProfile();
    if (supportedProfiles.size() > 0) {
      row = body.div().attribute("class", "row");
      cell = row.div().attribute("class", "col-6");
      addLead(cell,"Supported Profiles");
      XhtmlNode para = cell.para();
      boolean first = true;
      for (CanonicalType c : supportedProfiles) {
        if (!first) {
          para.br();
        }
        first=false;
        addResourceLink(para, c.asStringValue(), c.asStringValue());
        //para.ah(c.asStringValue()).addText(c.asStringValue());
      }  
    }
    if (!pullInteraction) {
      if (supportedProfiles.size() < 1) {
        row = body.div().attribute("class", "row");
      }
      addInteractions(row, r, 6);
    }

    //Resource Documentation
    body.para();
    String mdText = r.getDocumentation();
    if (!Utilities.noString(mdText)) {
      row = body.div().attribute("class", "row");
      cell = row.div().attribute("class", "col-12");
      addLead(cell,"Documentation");
      addMarkdown(cell.blockquote(), mdText);
    }

    //Resource search parameters
    ResourceSearchParams sParams = collectParams(r);
    addSearchParams(body, sParams);
    //addSearchParamsDocumentation(body, sParams);
    //Resource operations
    ResourceOperations ops = collectOperations(r);
    addExtendedOperations(body, ops);
  }

  private void addExtendedOperations(XhtmlNode body, ResourceOperations ops) {
    if (ops == null) return;
    Map<String, List<SingleOperation>> map = ops.getOperations();
    if (!hasOperations(map)) return;
    XhtmlNode row;
    XhtmlNode cell;
    XhtmlNode table;
    XhtmlNode tbody;
    XhtmlNode tr;
    row = body.div().attribute("class", "row");
    cell = row.div().attribute("class", "col-12");
    addLead(cell,"Extended Operations");
    table = cell.table("table table-condensed table-hover");
    tr = table.addTag("thead").tr();
    tr.th().addText("Conformance");
    tr.th().addText("Operation");
    tr.th().addText("Documentation");
    tbody = table.addTag("tbody");
    addOps(tbody, map, "supported");
    addOps(tbody, map, "SHALL");
    addOps(tbody, map, "SHOULD");
    addOps(tbody, map, "MAY");
    addOps(tbody, map, "SHOULD-NOT");
    return;
  }

  private ResourceOperations collectOperations(CapabilityStatementRestResourceComponent r) {
    List <CapabilityStatementRestResourceOperationComponent> opList = r.getOperation();
    if (opList.size()==0) return null;
    String capExpectation;
    SingleOperation operation;
    ResourceOperations ops = new ResourceOperations();
    
    for ( CapabilityStatementRestResourceOperationComponent op : opList) {
      capExpectation = op.getExtensionString(EXPECTATION);
      if (Utilities.noString(capExpectation)) {
        capExpectation = "supported";
      }
      operation = new SingleOperation(op.getName(),op.getDefinition(),op.getDocumentation(),capExpectation);
      ops.addOperation(capExpectation, operation);
    }
    return ops;
  }

  private void addInteractions(XhtmlNode row, CapabilityStatementRestResourceComponent r, int width) {
    String capExpectation;
    String widthString = "col-lg-" + Integer.toString(width);
    List<String> shalls = new ArrayList<String>();
    List<String> shoulds = new ArrayList<String>();
    List<String> mays = new ArrayList<String>();
    List<String> shouldnots = new ArrayList<String>();
    List<String> supporteds = new ArrayList<String>();

    for (ResourceInteractionComponent op : r.getInteraction()) {
      capExpectation = op.getExtensionString(EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        switch(capExpectation) {
          case "SHALL"      : shalls.add(op.getCode().toCode());
                              break;
          case "SHOULD"     : shoulds.add(op.getCode().toCode());
                              break;
          case "MAY"        : mays.add(op.getCode().toCode());
                              break;
          case "SHOULD-NOT" : shouldnots.add(op.getCode().toCode());
                              break;
        }
      }
      else {
        supporteds.add(op.getCode().toCode());
      }
    }
    XhtmlNode cell = row.div().attribute("class", widthString);
    addLead(cell, "Interaction summary");
    cell.br();
    XhtmlNode ul = cell.ul();
    addInteractionSummaryList(ul, "SHALL", shalls);
    addInteractionSummaryList(ul, "SHOULD", shoulds);
    addInteractionSummaryList(ul, "MAY", mays);
    addInteractionSummaryList(ul, "SHOULD-NOT", shouldnots);
    addInteractionSummaryList(ul, "", supporteds);
  }

  private ResourceSearchParams collectParams(CapabilityStatementRestResourceComponent r) {
    ResourceSearchParams sParams = new ResourceSearchParams();
    String capExpectation;
    SingleParam param;
    for ( CapabilityStatementRestResourceSearchParamComponent sp : r.getSearchParam()) {
      capExpectation = sp.getExtensionString(EXPECTATION);
      if (Utilities.noString(capExpectation)) {
        capExpectation = "supported";
      }
      param = new SingleParam(sp.getName(),sp.getDefinition(),sp.getType().toCode(),sp.getDocumentation(),capExpectation, r.getType().toLowerCase());
      sParams.addIndividualbyName(param.getName(), param);
      sParams.addIndividualbyExp(capExpectation,param);
    }
    //CombinedSearchParam component;
    CombinedSearchParamSet combinedParams;
    String paramName;
    for (Extension e : r.getExtensionsByUrl(COMBINED)) {
      capExpectation = e.getExtensionString(EXPECTATION);
      if (Utilities.noString(capExpectation)) {
        capExpectation = "supported";
      }
      combinedParams = new CombinedSearchParamSet(capExpectation);
      for (Extension cmpnt : e.getExtensionsByUrl("required")) {
        paramName = cmpnt.getValueStringType().asStringValue();
        param = sParams.getIndbyName().get(paramName);
        if (param == null) {
          param = new SingleParam(paramName,"","<unknown>");
        }
        //component = new CombinedSearchParam(param, true);
        combinedParams.addParam(true, param);
      }
      for (Extension cmpnt : e.getExtensionsByUrl("optional")) {
        paramName = cmpnt.getValueStringType().asStringValue();
        param = sParams.getIndbyName().get(paramName);
        if (param == null) {
          param = new SingleParam(paramName);
        }
        //component = new CombinedSearchParam(param);
        combinedParams.addParam(false, param);
      }
      sParams.addCombinedParamSet(capExpectation, combinedParams);
    }
    return sParams;
  }

  private void addSearchParams(XhtmlNode body, ResourceSearchParams sParams) {
    Map<String, List<CombinedSearchParamSet>> comboMap = sParams.getCombined();
    if (isCombinedEmpty(comboMap) && sParams.getIndbyName().size()==0) return;
    XhtmlNode row;
    XhtmlNode cell;
    XhtmlNode table;
    XhtmlNode tbody;
    XhtmlNode tr;
    row = body.div().attribute("class", "row");
    cell = row.div().attribute("class", "col-lg-7");
    addLead(cell,"Search Parameters");
    table = cell.table("table table-condensed table-hover");
    tr = table.addTag("thead").tr();
    tr.th().addText("Conformance");
    tr.th().addText("Parameter");
    tr.th().addText("Type");
    tr.th().addText("Documentation");
    tbody = table.addTag("tbody");
    Map<String,List<SingleParam>> map = sParams.getIndbyExp();
    addIndRows(tbody, map, "supported");
    addIndRows(tbody, map, "SHALL");
    addIndRows(tbody, map, "SHOULD");
    addIndRows(tbody, map, "MAY");
    addIndRows(tbody, map, "SHOULD-NOT");
    cell = row.div().attribute("class", "col-lg-5");
    if (!isCombinedEmpty(comboMap)) {
      addLead(cell,"Combined Search Parameters");
      table = cell.table("table table-condensed table-hover");
      tr = table.addTag("thead").tr();
      tr.th().addText("Conformance");
      tr.th().addText("Parameters");
      tr.th().addText("Types");
      tbody = table.addTag("tbody");
      addComboRows(tbody, comboMap, "supported");
      addComboRows(tbody, comboMap, "SHALL");
      addComboRows(tbody, comboMap, "SHOULD");
      addComboRows(tbody, comboMap, "MAY");
      addComboRows(tbody, comboMap, "SHOULD-NOT");
    }
    else {
      cell.nbsp();
    }
  }

  private void addIndRows(XhtmlNode tbody, Map<String, List<SingleParam>> map, String exp) {
    XhtmlNode tr;
    for (SingleParam param: map.get(exp)) {
      tr=tbody.tr();
      if (!exp.equals("supported")) {
        tr.td().b().addText(exp);
      }
      else {
        tr.td().b().addText("SHALL");
      }
      addResourceLink(tr.td(), param.getName(), param.getDefinition(),true, param.getHostResource());
      /*if (Utilities.noString(param.getDefinition())) {
        tr.td().addText(param.getName());
      }
      else {
        tr.td().ah(param.getDefinition()).addText(param.getName());
      }*/
      tr.td().code().addText(param.getType());
      try {
        addMarkdown(tr.td(), param.getDocumentation());
      } catch (FHIRFormatError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (DefinitionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  private void addOps(XhtmlNode tbody, Map<String, List<SingleOperation>> map, String exp) {
    XhtmlNode tr;
    String name;
    String canonicalUri;
    for (SingleOperation operation: map.get(exp)) {
      tr = tbody.tr();
      name = "$" + operation.getName();
      if (!exp.equals("supported")) {
        tr.td().b().addText(exp);
      }
      else {
        tr.td().b().addText("SHALL");
      }
      canonicalUri = operation.getDefinition();
      addResourceLink(tr.td(), name, canonicalUri);
      /*
      if (Utilities.noString(operation.getDefinition())) {
        tr.td().addText(name);
      }
      else {
        tr.td().ah(operation.getDefinition()).addText(name);
        Resource cr = context.getContext().fetchResource(Resource.class, operation.getDefinition());
      } */
      try {
        addMarkdown(tr.td(), operation.getDocumentation());
      } catch (FHIRFormatError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (DefinitionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  private void addComboRows(XhtmlNode tbody, Map<String, List<CombinedSearchParamSet>> map, String exp) {
    XhtmlNode tr,td;
    boolean first;
    for (CombinedSearchParamSet paramSet: map.get(exp)) {
      tr=tbody.tr();
      if (!exp.equals("supported")) {
        tr.td().b().addText(exp);
      }
      else {
        tr.td().nbsp();
      }
      //Parameter combination
      td = tr.td();
      first = true;
      for (SingleParam p : paramSet.getParams().get(true)) {
        if (!first) {
          td.addText("+");
        }
        first=false;
        if (Utilities.noString(p.getDefinition())) {
          td.addText(p.getName());
        }
        else {
          addResourceLink(td, p.getName(), p.getDefinition(), true, p.getHostResource());
          //td.ah(p.param.getDefinition()).addText(p.param.getName());
        }
      }
      if (paramSet.getParams().get(false).size() > 0) {
        td.addText("(");
        for (SingleParam p : paramSet.getParams().get(false)) {
          td.addText("+");
          if (Utilities.noString(p.getDefinition())) {
            td.addText(p.getName());
          }
          else {
            addResourceLink(td, p.getName(), p.getDefinition(), true, p.getHostResource());
            //td.ah(p.param.getDefinition()).addText(p.param.getName());
          }
        }
        td.addText(")");
      }
      //types combination
      td = tr.td();
      first = true;
      for (SingleParam p : paramSet.getParams().get(true)) {
        if (!first) {
          td.addText("+");
        }
        first=false;
        td.code().addText(p.getType());
      }
      if (paramSet.getParams().get(false).size() > 0) {
        td.addText("(");
        for (SingleParam p : paramSet.getParams().get(false)) {
          td.addText("+");
          if (!p.getType().equals("<unknown>")) {
            td.code().addText(p.getType());
          }
          else {
            td.addText(p.getType());
          }
        }
        td.addText(")");
      }
    }
  }

  boolean isCombinedEmpty(Map<String, List<CombinedSearchParamSet>> combinedMap) {
    boolean result = true;
    for (String s : combinedMap.keySet()) {
      if (combinedMap.get(s).size() > 0) {
        result=false;
        break;
      }
    }
    return result;
  }

  boolean hasOperations(Map<String, List<SingleOperation>> operationsMap) {
    boolean result = false;
    for (String s : operationsMap.keySet()) {
      if (operationsMap.get(s).size() > 0) {
        result=true;
        break;
      }
    }
    return result;
  }

  private List<String> getReferencePolicyStrings(List<Enumeration<ReferenceHandlingPolicy>> list) {
    List<String> stringList = new ArrayList<String>();
    for (Enumeration<ReferenceHandlingPolicy> p : list) {
      stringList.add(p.getCode());
    }
    return stringList;
  }
  private String getResourceExpectation(CapabilityStatementRestResourceComponent r) {
    String capExpectation = r.getExtensionString(EXPECTATION);
    if (!Utilities.noString(capExpectation)) return capExpectation;
    boolean shalls = false;
    boolean shoulds = false;
    boolean mays = false;
    boolean shouldnots = false;
    for (ResourceInteractionComponent ric : r.getInteraction()) {
      capExpectation = ric.getExtensionString(EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        switch(capExpectation) {
          case "SHALL" :  shalls = true;
                          break;
          case "SHOULD" : shoulds = true;
                          break;
          case "MAY" :    mays = true;
                          break;
          case "SHOULD-NOT" : shouldnots = true;
                              break;
        }
      }
    }
    if (shalls) return "SHALL";
    //Check search parameters requirements
    for ( CapabilityStatementRestResourceSearchParamComponent sp : r.getSearchParam()) {
      capExpectation = sp.getExtensionString(EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        switch(capExpectation) {
          case "SHALL" :  shalls = true;
                          break;
          case "SHOULD" : shoulds = true;
                          break;
          case "MAY" :    mays = true;
                          break;
          case "SHOULD-NOT" : shouldnots = true;
                              break;
        }
      }
    }
    if (shalls) return "SHALL";
    if (shoulds) return "SHOULD";
    if (mays) return "MAY";
    if (shouldnots) return "SHOULD NOT";
    return "supported";
  }

  private String getProfileExpectation(CanonicalType r) {
    String capExpectation = r.getExtensionString(EXPECTATION);
    if (!Utilities.noString(capExpectation)) return capExpectation;
    return "SHALL";
  }

  private void addLead(XhtmlNode node, String text) {
    node.addTag("span").attribute("class", "lead").addText(text);
  }

  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    if (r.has("name")) {
      return r.children("name").get(0).getBase().primitiveValue();
    }
    return "??";
  }

  private void addResourceLink(XhtmlNode node, String name, String canonicalUri) {
    addResourceLink(node, name, canonicalUri, false, "");
  }

  private void addResourceLink(XhtmlNode node, String name, String canonicalUri, boolean isParam, String hostResource) {
    if (Utilities.noString(canonicalUri)) {
      node.addText(name);
      return;
    }

    Resource cr = context.getContext().fetchResource(Resource.class, canonicalUri);
    if (cr == null) {
      node.addText(name);
    }
    else {
      //String path = cr.getUserString("path");
      String path = cr.getWebPath();
      if (Utilities.noString(path)) {
        if (isParam && (canonicalUri.toLowerCase().startsWith(SP_BASE)) && (!Utilities.noString(currentFhirBase)) && (!Utilities.noString(hostResource))) {
          String resourceName = "";
          if (canonicalUri.substring(SP_BASE.length()).split("-")[0].toLowerCase().equals("resource")) {
            resourceName = "resource";
          }
          else if (canonicalUri.substring(SP_BASE.length()).split("-")[0].toLowerCase().equals("domainresource")) {
            resourceName = "domainresource";
          }
          else {
            resourceName = hostResource;
          }

          node.ah(currentFhirBase + resourceName + ".html#search").addText(name);
        }
        else {
          node.addText(name);
        }
      }
      else {
        node.ah(path).addText(name);
      }
    }
  }

}
