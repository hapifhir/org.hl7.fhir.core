package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction;
import org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;


@MarkedToMoveToAdjunctPackage
public class CapabilityStatementRenderer extends ResourceRenderer {

  public CapabilityStatementRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {
      renderResourceTechDetails(r, x);
      render(status, x, (CapabilityStatement) r.getBase(), r);      
    } else {
      // the intention is to change this in the future
      x.para().tx("CapabilityStatementRenderer only renders native resources directly");
    }
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  private static final String EXPECTATION = "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation";
  private static final String COMBINED = "http://hl7.org/fhir/StructureDefinition/capabilitystatement-search-parameter-combination";
  private static final String SP_BASE = "http://hl7.org/fhir/searchparameter/";
  private static final String FHIR_BASE = "http://hl7.org/fhir/";
  private static final String VERS_DEF_PREFIX = "FHIR Release ";

  private String currentFhirBase = "";
  private String collapseClass = "panel-collapse in";

  private boolean multExpectationsPresent = false;
  
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

  private class ResourceInteraction {
    private String codeString;
    private String documentation;
    public ResourceInteraction(String code, String markdown) {
      codeString = code;
      if (!Utilities.noString(markdown)) {
        documentation = markdown;
      }
      else {
        documentation = null;
      }
    }

    public String getDocumentation() {
      return documentation;
    }

    public String getInteraction() {
      return codeString;
    }
  }



  public void render(RenderingStatus status, XhtmlNode x, CapabilityStatement conf, ResourceWrapper res) throws FHIRFormatError, DefinitionException, IOException {
    status.setExtensions(true);
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

    x.h(2,context.prefixAnchor("title")).addText(conf.getTitle());
    XhtmlNode uList = x.ul();
    uList.li().addText(context.formatPhrase(RenderingContext.CAPABILITY_IMP_VER, igVersion) + " ");
    uList.li().addText(context.formatPhrase(RenderingContext.CAPABILITY_FHIR_VER, currentVersion.toCode()) + " ");
    addSupportedFormats(uList, conf);
    
    uList.li().addText(context.formatPhrase(RenderingContext.CAPABILITY_PUB_ON, displayDateTime(wrapWC(res, conf.getDateElement())) + " "));
    uList.li().addText(context.formatPhrase(RenderingContext.CAPABILITY_PUB_BY, conf.getPublisherElement().asStringValue()) + " ");


    XhtmlNode block = x.addTag("blockquote").attribute("class","impl-note");
    block.addTag("p").addTag("strong").addText(context.formatPhrase(RenderingContext.CAPABILITY_NOTE_CAP));
    block.addTag("p").addText(context.formatPhrase(RenderingContext.CAPABILTY_ALLOW_CAP));


    addSupportedCSs(status, x, conf, res);
    addSupportedIGs(x, conf);

    int restNum = conf.getRest().size();
    int nextLevel = 3;
    if (restNum > 0) {
      x.h(2,context.prefixAnchor("rest")).addText((context.formatPhrase(RenderingContext.CAPABILITY_REST_CAPS)));
      int count=1;
      for (CapabilityStatementRestComponent rest : conf.getRest()) {
        if (restNum > 1) {
          x.h(3,context.prefixAnchor("rest"+Integer.toString(count))).addText(context.formatPhrase(RenderingContext.CAPABILITY_REST_CONFIG, Integer.toString(count)) + " ");
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
          x.h(nextLevel,context.prefixAnchor("resourcesCap" + Integer.toString(count))).addText(context.formatPhrase(RenderingContext.CAPABILITY_RES_PRO));
          x.h(nextLevel+1,context.prefixAnchor("resourcesSummary" + Integer.toString(count))).addText(context.formatPhrase(RenderingContext.GENERAL_SUMM));
          addSummaryIntro(x);
          addSummaryTable(status, res, x, rest, hasVRead, hasPatch, hasDelete, hasHistory, hasUpdates, count);
          x.addTag("hr");
          //Third time for individual resources
          int resCount = 1;
          for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
            addResourceConfigPanel(status, res, x, r, nextLevel+1, count, resCount, igRenderingMode);
            resCount++;
          }
        }
        if (rest.getOperation().size() > 0) {
          //TODO Figure out what should come out of this
          x.h(nextLevel,context.prefixAnchor("operationsCap" + Integer.toString(count))).addText(context.formatPhrase(RenderingContext.CAPABILITY_OP));
          x.h(nextLevel+1,context.prefixAnchor("operationsSummary" + Integer.toString(count))).addText(context.formatPhrase(RenderingContext.OP_DEF_USE));
        }
        count++;
      }
    }

    int messagingNum = conf.getMessaging().size();
    nextLevel = 3;
    if (messagingNum > 0) {
      x.h(2,context.prefixAnchor("messaging")).addText((context.formatPhrase(RenderingContext.CAPABILITY_MESSAGING_CAPS)));
      int count=1;
      for (CapabilityStatementMessagingComponent msg : conf.getMessaging()) 
      {
        addMessagingPanel(status, res, x, msg, nextLevel, count, messagingNum);
        count++;
      }

    }

    int documentNum = conf.getDocument().size();
    nextLevel = 3;
    if (documentNum > 0) {
      x.h(2,context.prefixAnchor("document")).addText((context.formatPhrase(RenderingContext.CAPABILITY_DOCUMENT_CAPS)));
      addDocumentTable(status, res, x, conf, nextLevel);
    }

    
    if (multExpectationsPresent) {
      addWarningPanel(x,"⹋⹋ - " + context.formatPhrase(RenderingContext.CAPABILITY_MULT_EXT));
    }

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

  private void addSupportedCSs(RenderingStatus status, XhtmlNode x, CapabilityStatement cap, ResourceWrapper res) throws UnsupportedEncodingException, IOException {
    if (cap.hasInstantiates()) {
      XhtmlNode p = x.para();
      p.tx(cap.getInstantiates().size() > 1 ? "This CapabilityStatement instantiates these CapabilityStatements " : "This CapabilityStatement instantiates the CapabilityStatement ");
      boolean first = true;
      for (CanonicalType ct : cap.getInstantiates()) {
        if (first) {first = false;} else {p.tx(", ");};
        renderCanonical(status, res, p, CapabilityStatement.class, ct);
      }
    }
    if (cap.hasImports()) {
      XhtmlNode p = x.para();
      p.tx(cap.getImports().size() > 1 ? "This CapabilityStatement imports these CapabilityStatements " : "This CapabilityStatement imports the CapabilityStatement ");
      boolean first = true;
      for (CanonicalType ct : cap.getImports()) {
        if (first) {first = false;} else {p.tx(", ");};
        renderCanonical(status, res, p, CapabilityStatement.class, ct);
      }      
    }
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
        x.h(3,context.prefixAnchor("shallIGs")).addText(context.formatPhrase(RenderingContext.CAPABILTY_SHALL_SUPP));
        ul = x.ul();
        for (String url : igShalls) {
          addResourceLink(ul.li(), url, url);
          //ul.li().ah(url).addText(url);
        }
      }
      if (igShoulds.size() > 0) {
        x.h(3,context.prefixAnchor("shouldIGs")).addText(context.formatPhrase(RenderingContext.CAPABILITY_SHOULD_SUPP));
        ul = x.ul();
        for (String url : igShoulds) {
          addResourceLink(ul.li(), url, url);
          //ul.li().ah(url).addText(url);
        }
      }
      if (igMays.size() > 0) {
        x.h(3,context.prefixAnchor("mayIGs")).addText(context.formatPhrase(RenderingContext.CAPABILITY_MAY_SUPP));
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
    lItem.addText(context.formatPhrase(RenderingContext.CAPABILITY_SUPP_FORM) + " ");
    Boolean first = true;
    String capExpectation = null;
    for (CodeType c : conf.getFormat()) {
      if (!first) {
        lItem.addText(", ");
      }
      capExpectation = getExtValueCode(c.getExtensionByUrl(EXPECTATION));
      if (!Utilities.noString(capExpectation)) {
        lItem.addTag("strong").addText(capExpectation);
        lItem.addText(" "+ (context.formatPhrase(RenderingContext.CAPABILITY_SUPP) + " "));
      }
      lItem.code().addText(c.getCode());
      first = false;
    }
    lItem = uList.li();
    lItem.addText(context.formatPhrase(RenderingContext.CAPABILITY_SUPP_PATCH_FORM) + " ");
    first=true;
    for (CodeType c : conf.getPatchFormat()) {
      if (!first) {
        lItem.addText(", ");
      }
      capExpectation = getExtValueCode(c.getExtensionByUrl(EXPECTATION));
      if (!Utilities.noString(capExpectation)) {
        lItem.addTag("strong").addText(capExpectation);
        lItem.addText(" " + context.formatPhrase(RenderingContext.CAPABILITY_SUPP) + " ");
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
    heading = panel.div().attribute("class", "panel-heading").h(nextLevel,context.prefixAnchor("mode" + Integer.toString(count))).attribute("class", "panel-title");
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
    body.div().attribute("class","lead").addTag("em").addText(context.formatPhrase(RenderingContext.CAPABILITY_SUMM_SYS_INT));
    addSystemInteractions(body, rest.getInteraction());
        
  }

  private void addMessagingPanel(RenderingStatus status, ResourceWrapper res, XhtmlNode x, CapabilityStatementMessagingComponent msg, int nextLevel, int index, int total) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode panel= null;
    XhtmlNode body = null;
    XhtmlNode row = null;
    XhtmlNode heading = null;

    XhtmlNode table;
    XhtmlNode tbody;
    XhtmlNode tr;

    panel = x.div().attribute("class", "panel panel-default");
    heading = panel.div().attribute("class", "panel-heading").h(nextLevel,context.prefixAnchor("messaging_" + Integer.toString(index))).attribute("class", "panel-title");
    if(total == 1)
    {
      heading.addText(context.formatPhrase(RenderingContext.CAPABILITY_MESSAGING_CAP));
    }
    else
    {
      heading.addText(context.formatPhrase(RenderingContext.CAPABILITY_MESSAGING_CAP) + " " + String.valueOf(index));
    }

    body = panel.div().attribute("class", "panel-body");

    if(msg.hasReliableCache())
    {
      addLead(body, "Reliable Cache Length");
      body.br();
      body.addText(String.valueOf(msg.getReliableCache()) + " Minute(s)");
      body.br();
    }

    if(msg.hasEndpoint())
    {
      body.h(nextLevel+1,context.prefixAnchor("msg_end_"+Integer.toString(index))).addText(context.formatPhrase(RenderingContext.CAPABILITY_ENDPOINTS));
      table = body.table("table table-condensed table-hover", false);
      tr = table.addTag("thead").tr();
      tr.th().addText("Protocol");
      tr.th().addText("Address");

      tbody = table.addTag("tbody");
      for (CapabilityStatementMessagingEndpointComponent end : msg.getEndpoint())
      {
        tr = tbody.tr();
        renderDataType(status, tr.td(), wrapNC(end.getProtocol()));
        renderUri(status,  tr.td(), wrapNC(end.getAddressElement()));
      }
      body.br();
    }

    if(msg.hasSupportedMessage())
    {
      body.h(nextLevel+1,context.prefixAnchor("msg_sm_"+Integer.toString(index))).addText(context.formatPhrase(RenderingContext.CAPABILITY_SUPP_MSGS));
      table = body.table("table table-condensed table-hover", false);
      tr = table.addTag("thead").tr();
      tr.th().addText("Mode");
      tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_DEFINITION));

      tbody = table.addTag("tbody");
      for (CapabilityStatementMessagingSupportedMessageComponent sup : msg.getSupportedMessage())
      {
        tr = tbody.tr();
        tr.td().addText(sup.getMode().toCode());
        renderCanonical(status, res, tr.td(), StructureDefinition.class, sup.getDefinitionElement());
      }
      if(msg.hasDocumentation())
      {
        addLead(body, context.formatPhrase(RenderingContext.GENERAL_DOCUMENTATION));
        addMarkdown(body.blockquote(), msg.getDocumentation());
      }
      body.br();
    }
  }


  private void addDocumentTable(RenderingStatus status, ResourceWrapper res, XhtmlNode x, CapabilityStatement conf, int nextLevel) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode table;
    XhtmlNode tbody;
    XhtmlNode tr;

    table = x.table("table table-condensed table-hover", false);
    tr = table.addTag("thead").tr();
    tr.th().addText("Mode");
    tr.th().addText(context.formatPhrase(RenderingContext.CAPABILITY_PROF_RES_DOC));
    tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_DOCUMENTATION));

    tbody = table.addTag("tbody");
    for (CapabilityStatementDocumentComponent document : conf.getDocument()) {
      tr = tbody.tr();
      tr.td().addText(document.getMode().toCode());
      renderCanonical(status, res, tr.td(), StructureDefinition.class, document.getProfileElement());
      if(document.hasDocumentation())
      {
        addMarkdown(tr.td(), document.getDocumentation());
      }
      else
      {
        tr.td().nbsp();
      }
    }
  }

  private String getCorsText(boolean on) {
    if (on) {
      return context.formatPhrase(RenderingContext.CAPABILITY_CORS_YES);
    }
    return context.formatPhrase(RenderingContext.CAPABILITY_CORS_NO);
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
        item.addText(context.formatPhrase(RenderingContext.CAPABILITY_SUPPS_THE) + " ");
      }
      else {
        item.addTag("strong").addText(verb + " ");
        item.addText(context.formatPhrase(RenderingContext.CAPABILITY_SUPP_THE) + " ");
      }
      interaction = interactionMap.keySet().toArray()[0].toString();
      item.code(interaction);
      documentation = interactionMap.get(interaction);
      if (Utilities.noString(documentation)) {
        item.addText(context.formatPhrase(RenderingContext.CAPABILITY_INT));
      }
      else {
        item.addText(context.formatPhrase(RenderingContext.CAPABILITY_INT_DESC));
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

  private void addInteractionSummaryList(XhtmlNode uList, String verb, List<ResourceInteraction> interactions) {
    if (interactions.size() == 0) return;
    XhtmlNode item = uList.li();
    if (Utilities.noString(verb)) {
      item.addText(context.formatPhrase(RenderingContext.CAPABILITY_SUPPS) + " ");
    }
    else {
      item.addTag("strong").addText(verb);
      item.addText(" " + context.formatPhrase(RenderingContext.CAPABILITY_SUPP) + " ");
    }

    applyInteractionsList(item, interactions);  
  }

  private void addSummaryIntro(XhtmlNode x) {
    XhtmlNode uList = null;
    XhtmlNode lItem = null;
    x.para().addText(context.formatPhrase(RenderingContext.CAPABILITY_SUMM_RES));
    uList=x.ul();
    uList.li().addText(context.formatPhrase(RenderingContext.CAPABILITY_REV_PROF));
    lItem = uList.li();
    lItem.addText(context.formatPhrase(RenderingContext.CAPABILITY_INTER_SUPP));
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
    lItem.addText(context.formatPhrase(RenderingContext.CAPABILITY_TYP_PRES));
    uList.li().addTag("span").addText(context.formatPhrase(RenderingContext.CAPABILITY_SEARCH_PAR) + " ");
    lItem = uList.li();
    lItem.addText(context.formatPhrase(RenderingContext.CAPABILITY_RES_ENB) + " ");
    lItem.code().addText("_include");
    lItem = uList.li();
    lItem.addText(context.formatPhrase(RenderingContext.CAPABILITY_OTH_RES_ENB) + " ");
    lItem.code().addText("_revinclude");
    uList.li().addText(context.formatPhrase(RenderingContext.CAPABILITY_RES_OPER));
  }

  private void addSummaryTable(RenderingStatus status, ResourceWrapper res, XhtmlNode x, CapabilityStatement.CapabilityStatementRestComponent rest, boolean hasVRead, boolean hasPatch, boolean hasDelete, boolean hasHistory, boolean hasUpdates, int count) throws IOException {
    XhtmlNode t = x.div().attribute("class","table-responsive").table("table table-condensed table-hover", false);
    XhtmlNode tr = t.addTag("thead").tr();
    tr.th().b().tx(context.formatPhrase(RenderingContext.CAPABILITY_RES_TYP));
    tr.th().b().tx(context.formatPhrase(RenderingContext.GENERAL_PROF));
    tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_READ_INT)).tx("R");
    if (hasVRead)
      tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_VREAD_INT)).tx("V-R");
    tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_SEARCH_INT)).tx("S");
    tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_UPDATE_INT)).tx("U");
    if (hasPatch)
      tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_PATCH_INT)).tx("P");
    tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_CREATE_INT)).tx("C");
    if (hasDelete)
      tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_DELETE_INT)).tx("D");
    if (hasUpdates)
      tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_HISTORY_INT)).tx("H-I");
    if (hasHistory)
      tr.th().attribute("class", "text-center").b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_HISTORY_TYPE)).tx("H-T");
    tr.th().b().attribute("title", context.formatPhrase(RenderingContext.CAPABILITY_REQ_RECOM)).tx(context.formatPhrase(RenderingContext.CAPABILITY_SEARCHES));
    tr.th().code().b().tx("_include");
    tr.th().code().b().tx("_revinclude");
    tr.th().b().tx(context.formatPhrase(RenderingContext.CAPABILITY_OP));

    XhtmlNode tbody = t.addTag("tbody");
    XhtmlNode profCell = null;
    boolean hasProf = false;
    boolean hasSupProf = false;
    int resCount = 1;
    String countString = "";
    for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
      tr = tbody.tr();
      countString = Integer.toString(count) + "-" + Integer.toString(resCount);
      tr.td().ah("#" + context.prefixAnchor(r.getType() + countString)).addText(r.getType());
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
          profCell.addTag("em").addText(context.formatPhrase(RenderingContext.CAPABILITY_ADD_SUPP_PROF));
          renderSupportedProfiles(status, res, profCell, r);
        }
      }
      else {    //Case of only supported profiles
        profCell.addText(context.formatPhrase(RenderingContext.CAPABILITY_SUPP_PROFS));
        renderSupportedProfiles(status, res, profCell, r);
      }
      //Show capabilities
      tr.td().attribute("class", "text-center").addText(showOp(r, TypeRestfulInteraction.READ));
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
      String capExpectation = expectationForDisplay(e,EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        if (capExpectation.equals("SHALL") || capExpectation.equals("SHOULD") || capExpectation.equals("MAY")) {
          paramNames.add(printCombinedParams(e));
        }
      }
    }
    return paramNames;
  }

  private void renderSupportedProfiles(RenderingStatus status, ResourceWrapper res, XhtmlNode profCell, CapabilityStatementRestResourceComponent r) throws IOException {
    for (CanonicalType sp: r.getSupportedProfile()) { 
      profCell.br();
      profCell.nbsp().nbsp();
      renderCanonical(status, res, profCell, StructureDefinition.class, sp);
    }
    if (r.hasExtension(ExtensionDefinitions.EXT_PROFILE_MAPPING_NEW, ExtensionDefinitions.EXT_PROFILE_MAPPING_OLD)) {
      profCell.br();
      profCell.b().tx(context.formatPhrase(RenderingContext.CAPABILITY_PROF_MAP));
      XhtmlNode tbl = profCell.table("grid", false);
      boolean doco = false;
      for (Extension ext : r.getExtensionsByUrl(ExtensionDefinitions.EXT_PROFILE_MAPPING_NEW, ExtensionDefinitions.EXT_PROFILE_MAPPING_OLD)) {
        doco = doco || ext.hasExtension("documentation");
      }
      XhtmlNode tr = tbl.tr();
      tr.th().tx(context.formatPhrase(RenderingContext.GENERAL_CRIT));
      tr.th().tx(context.formatPhrase(RenderingContext.GENERAL_PROF));
      if (doco) {
        tr.th().tx(context.formatPhrase(RenderingContext.GENERAL_CRIT));
      }
      for (Extension ext : r.getExtensionsByUrl(ExtensionDefinitions.EXT_PROFILE_MAPPING_NEW, ExtensionDefinitions.EXT_PROFILE_MAPPING_OLD)) {
        tr = tbl.tr();
        tr.td().code().tx(ExtensionUtilities.readStringExtension(ext, "search"));
        String url = ExtensionUtilities.readStringExtension(ext, "profile");
        StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, url);
        if (sd != null) {
          tr.td().code().ah(sd.getWebPath()).tx(sd.present());
        } else {
          tr.td().code().tx(url);
        }
        if (doco) {
          tr.td().code().markdown(ExtensionUtilities.readStringExtension(ext, "documentation"), "documentation"); 
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
      String capExpectation = expectationForDisplay(p,EXPECTATION);
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
      String capExpectation = expectationForDisplay(op,EXPECTATION);
      if (!Utilities.noString(capExpectation)) {
        if (capExpectation.equals("SHALL") || capExpectation.equals("SHOULD") || capExpectation.equals("MAY")) {
          result.add("$"+op.getName());
        }
      }
      else {
        result.add("$"+op.getName());
      }
    }
    return result;
  }

  private void applyInteractionsList(XhtmlNode item, List<ResourceInteraction> list) {
    List<String> noDocList = new ArrayList<String>();
    List<ResourceInteraction> docList = new ArrayList<ResourceInteraction>();
    for (ResourceInteraction inter : list) {
      if (Utilities.noString(inter.getDocumentation())) {
        noDocList.add(inter.getInteraction());
      }
      else {
        docList.add(inter);
      }
    }
    if (noDocList.size() > 0) {
      addSeparatedListOfCodes(item,noDocList, ",");
    }
    if (docList.size() > 0) {
      item.br();
      for (ResourceInteraction inter : docList) {
        item.code().addText(inter.getInteraction());
        try {
          addMarkdown(item, inter.getDocumentation());
        }
        catch(IOException e) {
          e.printStackTrace();
        }
      }
    }
    else {
      item.addText(".");
    }
  }

  private void addResourceConfigPanel(RenderingStatus status, ResourceWrapper res, XhtmlNode x, CapabilityStatementRestResourceComponent r, int nextLevel, int count, int resCount, boolean igRenderingMode) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode panel= null;
    XhtmlNode body = null;
    XhtmlNode panelHead = null;
    XhtmlNode panelRef = null;
    
    String countString = Integer.toString(count) + "-" + Integer.toString(resCount);
    panel = x.div().attribute("class", "panel panel-default");
    if (igRenderingMode) {
      panelHead = panel.div().attribute("class", "panel-heading").attribute("role", "tab").attribute("id","heading" + countString).h(nextLevel,context.prefixAnchor(r.getType() + countString)).attribute("class", "panel-title");
      panelRef = panelHead.ah("#collapse" + countString).attribute("role","button").attribute("data-toggle", "collapse").attribute("aria-expanded","true").attribute("aria-controls","collapse" + countString);
      //panelRef = panelHead.addTag("button").attribute("href","#collapse" + countString).attribute("role","button").attribute("data-toggle", "collapse").attribute("aria-expanded","false").attribute("aria-controls","collapse" + countString);
      //panelRef.span("float: right;","").attribute("class", "lead").addText("Resource Conformance: " + getResourceExpectation(r));
      panelRef.span("float: right;","").addText("Resource Conformance: " + getResourceExpectation(r));
      panelRef.addText(r.getType());
      body = panel.div().attribute("class", collapseClass).attribute("id","collapse" + countString).attribute("role","tabpanel").attribute("aria-labelledby","heading" + countString).div().attribute("class", "panel-body").div().attribute("class", "container");
    }
    else {
      panelHead = panel.div().attribute("class", "panel-heading").h(nextLevel,context.prefixAnchor(r.getType() + countString)).attribute("class", "panel-title");
      panelHead.span("float: right;","").addText(context.formatPhrase(RenderingContext.CAPABILITY_RES_CONF, getResourceExpectation(r)) + " ");
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
      addLead(cell,context.formatPhrase(RenderingContext.CAPABILITY_BASE_SYS));
      cell.br();
      renderCanonical(status, res, cell, StructureDefinition.class, r.getProfileElement());
      cell=row.div().attribute("class", "col-lg-3");
      addLead(cell, context.formatPhrase(RenderingContext.CAPABILITY_PROF_CONF));
      cell.br();
      cell.b().addText(getProfileExpectation(r.getProfileElement()));
    }
    else {   //No profile, use FHIR Core Resource
      cell = row.div().attribute("class", "col-lg-4");
      addLead(cell, context.formatPhrase(RenderingContext.CAPABILITY_FHIR));
      cell.br();
      cell.ah(currentFhirBase + r.getType().toLowerCase() + ".html").addText(r.getType());
      pullInteraction = true;
      refPolicyWidth = "col-lg-4";
    }
    
    cell = row.div().attribute("class", refPolicyWidth);
    addLead(cell,context.formatPhrase(RenderingContext.CAPABILITY_REF_PROF));
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
      addLead(cell, context.formatPhrase(RenderingContext.CAPABILITY_SUPP_PROFS));
      XhtmlNode para = cell.para();
      boolean first = true;
      for (CanonicalType c : supportedProfiles) {
        if (!first) {
          para.br();
        }
        first=false;
        renderCanonical(status, res, para, StructureDefinition.class, c);
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
      addLead(cell, context.formatPhrase(RenderingContext.GENERAL_DOCUMENTATION));
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
    addLead(cell, context.formatPhrase(RenderingContext.CAPABILITY_EXT_OP));
    table = cell.table("table table-condensed table-hover", false);
    tr = table.addTag("thead").tr();
    tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_CONFORMANCE));
    tr.th().addText(context.formatPhrase(RenderingContext.CAPABILITY_OPER));
    tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_DOCUMENTATION));
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
      capExpectation = expectationForDisplay(op,EXPECTATION);
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
    //Need to build a different structure
    List<ResourceInteraction> shalls = new ArrayList<ResourceInteraction>();
    List<ResourceInteraction> shoulds = new ArrayList<ResourceInteraction>();
    List<ResourceInteraction> mays = new ArrayList<ResourceInteraction>();
    List<ResourceInteraction> shouldnots = new ArrayList<ResourceInteraction>();
    List<ResourceInteraction> supporteds = new ArrayList<ResourceInteraction>();

    ResourceInteraction tempInteraction = null;

    for (ResourceInteractionComponent op : r.getInteraction()) {
      capExpectation = expectationForDisplay(op,EXPECTATION);
      tempInteraction = new ResourceInteraction(op.getCode().toCode(), op.getDocumentation());
      if (!Utilities.noString(capExpectation)) {
        switch(capExpectation) {
          case "SHALL"      : shalls.add(tempInteraction);
                              break;
          case "SHOULD"     : shoulds.add(tempInteraction);
                              break;
          case "MAY"        : mays.add(tempInteraction);
                              break;
          case "SHOULD-NOT" : shouldnots.add(tempInteraction);
                              break;
        }
      }
      else {
        supporteds.add(tempInteraction);
      }
    }
    XhtmlNode cell = row.div().attribute("class", widthString);
    addLead(cell, context.formatPhrase(RenderingContext.CAPABILITY_INT_SUMM));
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
      capExpectation = expectationForDisplay(sp,EXPECTATION);
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
      capExpectation = expectationForDisplay(e,EXPECTATION);
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
    addLead(cell, context.formatPhrase(RenderingContext.CAPABILITY_SEARCH_PARS));
    table = cell.table("table table-condensed table-hover", false);
    tr = table.addTag("thead").tr();
    tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_CONFORMANCE));
    tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_PAR));
    tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_TYPE));
    tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_DOCUMENTATION));
    tbody = table.addTag("tbody");
    Map<String,List<SingleParam>> map = sParams.getIndbyExp();
    addIndRows(tbody, map, "supported");
    addIndRows(tbody, map, "SHALL");
    addIndRows(tbody, map, "SHOULD");
    addIndRows(tbody, map, "MAY");
    addIndRows(tbody, map, "SHOULD-NOT");
    cell = row.div().attribute("class", "col-lg-5");
    if (!isCombinedEmpty(comboMap)) {
      addLead(cell, context.formatPhrase(RenderingContext.CAPABILITY_COMB_SEARCH_PAR));
      table = cell.table("table table-condensed table-hover", false);
      tr = table.addTag("thead").tr();
      tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_CONFORMANCE));
      tr.th().addText(context.formatPhrase(RenderingContext.GENERAL_PARS));
      tr.th().addText(context.formatPhrase(RenderingContext.CAPABILITY_TYPS));
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
    String capExpectation = expectationForDisplay(r,EXPECTATION);
    if (!Utilities.noString(capExpectation)) return capExpectation;
    boolean shalls = false;
    boolean shoulds = false;
    boolean mays = false;
    boolean shouldnots = false;
    for (ResourceInteractionComponent ric : r.getInteraction()) {
      capExpectation = expectationForDisplay(ric,EXPECTATION);
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
      capExpectation = expectationForDisplay(sp,EXPECTATION);
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
    String capExpectation = expectationForDisplay(r,EXPECTATION);
    if (!Utilities.noString(capExpectation)) return capExpectation;
    return "SHALL";
  }

  private void addLead(XhtmlNode node, String text) {
    node.addTag("span").attribute("class", "lead").addText(text);
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

  private String expectationForDisplay(Element e, String url) {
    String result;
    try {
      result = e.getExtensionString(url);
      return result;
    }
    catch (FHIRException fex) {
      List<Extension> ext = e.getExtensionsByUrl(url); 
      if (ext.isEmpty()) 
        return null; 
      if (!ext.get(0).hasValue())
        return null;
      multExpectationsPresent = true;
      return ext.get(0).getValue().primitiveValue() + "-⹋⹋";
    }

  }

  private void addWarningPanel(XhtmlNode node, String text) {
    XhtmlNode panel = node.addTag("div").attribute("class","panel panel-danger").addTag("div").attribute("class","panel-body");
    panel.addTag("span").attribute("class","label label-danger").addText(context.formatPhrase(RenderingContext.CAPABILITY_ERR_DET));
    panel.addText(" " + text);
  }
}