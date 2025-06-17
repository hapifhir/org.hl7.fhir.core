package org.hl7.fhir.r5.renderers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.extensions.ExtensionConstants;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.ExampleScenario;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent;
import org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.Resolver;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlDocument;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

@MarkedToMoveToAdjunctPackage
public class ExampleScenarioRenderer extends TerminologyRenderer {

  private Set<String> stepPrefixes = new HashSet<>();

  public ExampleScenarioRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {
      renderResourceTechDetails(r, x);
      genSummaryTable(status, x, (ExampleScenario) r.getBase());
      render(status, x, (ExampleScenario) r.getBase(), r);
    } else {
      // the intention is to change this in the future
      x.para().tx("ExampleScenarioRenderer only renders native resources directly");
    }
  }

  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, ExampleScenario scen, ResourceWrapper res) throws FHIRException {

    Map<Element, String> prefixes = new HashMap<>();
    assignProcessPrefixes(prefixes, scen.getProcess(), 1);
    
    try {
      if (context.getScenarioMode() == null) {
        renderActors(status, res, x, scen);
      } else {
        switch (context.getScenarioMode()) {
          case ACTORS:
            renderActors(status, res, x, scen);
            break;
          case INSTANCES:
            renderInstances(status, res, x, scen);
            break;
          case PROCESSES:
            renderProcesses(prefixes, status, x, scen);
            break;
          default:
            throw new FHIRException(context.formatPhrase(RenderingContext.EX_SCEN_UN, context.getScenarioMode()) + " ");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new FHIRException(context.formatPhrase(RenderingContext.EX_SCEN_ERR_REN, scen.getUrl(), e) + " ");
    }
  }

  public String renderDiagram(RenderingStatus status, ResourceWrapper res, ExampleScenario scen) throws IOException {

    Map<Element, String> prefixes = new HashMap<>();
    assignProcessPrefixes(prefixes, scen.getProcess(), 1);
    
    try {
      String plantUml = toPlantUml(prefixes, status, res, scen);
      SourceStringReader reader = new SourceStringReader(plantUml);
      final ByteArrayOutputStream os = new ByteArrayOutputStream();
      reader.outputImage(os, new FileFormatOption(FileFormat.SVG));
      os.close();

      final String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
      return svg;
    } catch (Exception e) {
      return "<p style=\"color: maroon\"><b>"+Utilities.escapeXml(e.getMessage())+"</b></p>";
    }
  }

  protected String toPlantUml(Map<Element, String> prefixes, RenderingStatus status, ResourceWrapper res, ExampleScenario scen) throws IOException {
    String plantUml = "@startuml\r\n";
    plantUml += "Title " + (scen.hasTitle() ? scen.getTitle() : scen.getName()) + "\r\n\r\n";
    Map<String, String> actorKeys = new HashMap<String, String>();

    for (ExampleScenarioActorComponent actor: scen.getActor()) {
      String actorType = actor.getType().equals(Enumerations.ExampleScenarioActorType.PERSON) ? "actor" : "participant";
      actorKeys.put(actor.getKey(), escapeKey(actor.getKey()));
      plantUml += actorType + " \"" + creolLink(actor.getTitle(), "#a_" + actor.getKey(), actor.getDescription()) + "\" as " + actorKeys.get(actor.getKey()) + "\r\n";
    }
    plantUml += "\r\n";

    for (ExampleScenarioProcessComponent process: scen.getProcess()) {
      plantUml += toPlantUml(prefixes, status, res, process, scen, actorKeys);
    }
    plantUml += "@enduml";

    return plantUml;
  }

  private String escapeKey(String origKey) {
    char[] chars = origKey.toCharArray();
    for (int i=0; i<chars.length; i++) {
      char c = chars[i];
      if (!((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9') || c=='@' || c=='.'))
        chars[i] = '_';
    }
    return new String(chars);
  }

  protected String toPlantUml(Map<Element, String> prefixes, RenderingStatus status, ResourceWrapper res, ExampleScenarioProcessComponent process, ExampleScenario scen, Map<String, String> actorKeys) throws IOException {
    String plantUml = "group " + process.getTitle() + " " + creolLink("details", prefixes.get(process), process.getDescription()) + "\r\n";

    Map<String,Boolean> actorsActive = new HashMap<String, Boolean>();
    for (ExampleScenarioActorComponent actor : scen.getActor()) {
      actorsActive.put(actor.getKey(), Boolean.FALSE);
    }

    for (ExampleScenarioProcessStepComponent step: process.getStep()) {
      plantUml += toPlantUml(prefixes, status, res, step, scen, actorsActive, actorKeys);
      if (step.getPause())
        plantUml += context.formatPhrase(RenderingContext.EX_SCEN_TIME)+"\n";
    }

    plantUml += "end\r\n\r\n";
    return plantUml;
  }

  protected String toPlantUml(Map<Element, String> prefixes, RenderingStatus status, ResourceWrapper res, ExampleScenarioProcessStepComponent step, ExampleScenario scen, Map<String,Boolean> actorsActive, Map<String, String> actorKeys) throws IOException {
    String plantUml = "";
    if (step.hasWorkflow()) {
      XhtmlNode n = new XhtmlDocument();
      renderCanonical(status, res, n, Resource.class, step.getWorkflowElement());
      XhtmlNode ref = n.getChildNodes().get(0);
      plantUml += noteOver(scen.getActor(), context.formatPhrase(RenderingContext.EXAMPLE_SCEN_STEP_SCEN, creolLink((ref.getContent()), ref.getAttribute("href"))));
    } else if (step.hasProcess())
      plantUml += toPlantUml(prefixes, status, res, step.getProcess(), scen, actorKeys);
    else {
      // Operation
      plantUml += toPlantUml(prefixes, step.getOperation(), scen, actorsActive, actorKeys);
    }

    return plantUml;
  }

  protected String toPlantUml(Map<Element, String> prefixes, ExampleScenarioProcessStepOperationComponent op, ExampleScenario scen, Map<String,Boolean> actorsActive, Map<String, String> actorKeys) {
    StringBuilder plantUml = new StringBuilder();
    plantUml.append(handleActivation(op.getInitiator(), op.getInitiatorActive(), actorsActive, actorKeys));
    plantUml.append(handleActivation(op.getReceiver(), op.getReceiverActive(), actorsActive, actorKeys));
    plantUml.append(actorKeys.get(op.getInitiator()) + " -> " + actorKeys.get(op.getReceiver()) + ": ");
    plantUml.append(creolLink(op.getTitle(), prefixes.get(op), op.getDescription()));
    if (op.hasRequest()) {
      plantUml.append(" (" + creolLink("payload", linkForInstance(op.getRequest())) + ")\r\n");
    }
    if (op.hasResponse()) {
      plantUml.append("activate " + actorKeys.get(op.getReceiver()) + "\r\n");
      plantUml.append(actorKeys.get(op.getReceiver()) + " --> " + actorKeys.get(op.getInitiator()) + ": ");
      plantUml.append(creolLink("response", prefixes.get(op), op.getDescription()));
      plantUml.append(" (" + creolLink("payload", linkForInstance(op.getResponse())) + ")\r\n");
      plantUml.append("deactivate " + actorKeys.get(op.getReceiver()) + "\r\n");
    }
    plantUml.append(handleDeactivation(op.getInitiator(), op.getInitiatorActive(), actorsActive, actorKeys));
    plantUml.append(handleDeactivation(op.getReceiver(), op.getReceiverActive(), actorsActive, actorKeys));

    return plantUml.toString();
  }

  private String handleActivation(String actorId, boolean active, Map<String,Boolean> actorsActive, Map<String, String> actorKeys) {
    String plantUml = "";
    Boolean actorWasActive = actorsActive.get(actorId);
    if (active && !actorWasActive) {
      plantUml += "activate " + actorKeys.get(actorId) + "\r\n";
    }
    return plantUml;
  }

  private String handleDeactivation(String actorId, boolean active, Map<String,Boolean> actorsActive, Map<String, String> actorKeys) {
    String plantUml = "";
    Boolean actorWasActive = actorsActive.get(actorId);
    if (actorWasActive != null) {
      if (!active && actorWasActive) {
        plantUml += "deactivate " + actorKeys.get(actorId) + "\r\n";
      }
      if (active != actorWasActive) {
        actorsActive.remove(actorId);
        actorsActive.put(actorId, Boolean.valueOf(active));
      }
    }
    return plantUml;
  }

  private String linkForInstance(ExampleScenarioInstanceContainedInstanceComponent ref) {
    String plantUml = "#i_" + ref.getInstanceReference();
    if (ref.hasVersionReference())
      plantUml += "v_" + ref.getVersionReference();
    return plantUml;
  }

  private String noteOver(List<ExampleScenarioActorComponent> actors, String text) {
    String plantUml = "Note over ";
    List actorKeys = new ArrayList<String>();
    for (ExampleScenarioActorComponent actor: actors) {
      actorKeys.add(actor.getKey());
    }
    plantUml += String.join(", ", actorKeys);
    plantUml += " " + text;
    return plantUml;
  }

  private String creolLink(String text, String url) {
    return creolLink(text, url, null);
  }

  private String creolLink(String text, String url, String flyover) {
    String s = "[[" + url;
    if (flyover!=null)
      s += "{" + flyover + "}";
    s += " " + text + "]]";
    return s;
  }

  public boolean renderActors(RenderingStatus status, ResourceWrapper res, XhtmlNode x, ExampleScenario scen) throws IOException {
    XhtmlNode tbl = x.table("table-striped table-bordered", false);
    XhtmlNode thead = tbl.tr();
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_NAME));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_TYPE));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_DESC));
    for (ExampleScenarioActorComponent actor : scen.getActor()) {
      XhtmlNode tr = tbl.tr();
      XhtmlNode nameCell = tr.td();
      nameCell.an(context.prefixAnchor("a_" + actor.getKey()));
      nameCell.tx(actor.getTitle());
      tr.td().tx(actor.getType().getDisplay());
      addMarkdown(tr.td().style("overflow-wrap:break-word"), actor.getDescription());
    }
    return true;
  }

  public boolean renderInstances(RenderingStatus status, ResourceWrapper res, XhtmlNode x, ExampleScenario scen) throws IOException {
    XhtmlNode tbl = x.table("table-striped table-bordered", false);
    XhtmlNode thead = tbl.tr();
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_NAME));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_TYPE));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_CONTENT));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_DESC));

    Map<String, String> instanceNames = new HashMap<String, String>();
    for (ExampleScenarioInstanceComponent instance : scen.getInstance()) {
      instanceNames.put("i_" + instance.getKey(), instance.getTitle());
      if (instance.hasVersion()) {
        for (ExampleScenarioInstanceVersionComponent version: instance.getVersion()) {
          instanceNames.put("i_" + instance.getKey() + "v_" + version.getKey(), version.getTitle());
        }
      }
    }

    for (ExampleScenarioInstanceComponent instance : scen.getInstance()) {
      XhtmlNode row = tbl.tr();
      XhtmlNode nameCell = row.td();
      nameCell.an(context.prefixAnchor("i_" + instance.getKey()));
      nameCell.tx(instance.getTitle());
      XhtmlNode typeCell = row.td();
      if (instance.hasVersion())
        typeCell.attribute("rowSpan", Integer.toString(instance.getVersion().size()+1));

      if (!instance.hasStructureVersion() || instance.getStructureType().getSystem().equals("")) {
        if (instance.hasStructureVersion())
          typeCell.tx((context.formatPhrase(RenderingContext.EX_SCEN_FVER, instance.getStructureVersion()) + " ") + " ");
        if (instance.hasStructureProfileCanonicalType()) {
          renderCanonical(status, res, typeCell, StructureDefinition.class, instance.getStructureProfileCanonicalType());
        } else if (instance.hasStructureProfileUriType()) {
          renderBase(status, typeCell, instance.getStructureProfileUriType());
        } else {
          CanonicalType ct = new CanonicalType("http://hl7.org/fhir/StructureDefinition/" + instance.getStructureType().getCode());
          renderCanonical(status, res, typeCell, StructureDefinition.class, ct);
        }
      } else {
        renderDataType(status, typeCell, wrapWC(res, instance.getStructureVersionElement()));
        typeCell.tx(" "+(context.formatPhrase(RenderingContext.GENERAL_VER_LOW, instance.getStructureVersion())+" "));
        if (instance.hasStructureProfile()) {
          typeCell.tx(" ");
          if (instance.hasStructureProfileCanonicalType()) {
            renderCanonical(status, res, typeCell, StructureDefinition.class, instance.getStructureProfileCanonicalType());
          }
        }
      }
      if (instance.hasContent() && instance.getContent().hasReference()) {
        // Force end-user mode to avoid ugly references
        RenderingContext.ResourceRendererMode mode = context.getMode();
        context.setMode(RenderingContext.ResourceRendererMode.END_USER);
        renderReference(status, row.td(), wrapWC(res, instance.getContent().copy().setDisplay("here")));
        context.setMode(mode);
      } else
        row.td();

      XhtmlNode descCell = row.td();
      addMarkdown(descCell, instance.getDescription());
      if (instance.hasContainedInstance()) {
        descCell.b().tx(context.formatPhrase(RenderingContext.EX_SCEN_CONTA) + " ");
        boolean first = true;
        for (ExampleScenarioInstanceContainedInstanceComponent contained: instance.getContainedInstance()) {
          if (first) first = false; else descCell.tx(", ");
          String key = "i_" + contained.getInstanceReference();
          if (contained.hasVersionReference())
            key += "v_" + contained.getVersionReference();
          String description = instanceNames.get(key);
          if (description==null)
            throw new FHIRException("Unable to find contained instance " + key + " under " + instance.getKey());
          descCell.ah(context.prefixLocalHref("#" + key)).tx(description);
        }
      }

      for (ExampleScenarioInstanceVersionComponent version: instance.getVersion()) {
        row = tbl.tr();
        nameCell = row.td().style("padding-left: 10px;");
        nameCell.an("i_" + instance.getKey() + "v_" + version.getKey());
        XhtmlNode nameItem = nameCell.ul().li();
        nameItem.tx(version.getTitle());

        if (version.hasContent() && version.getContent().hasReference()) {
          // Force end-user mode to avoid ugly references
          RenderingContext.ResourceRendererMode mode = context.getMode();
          context.setMode(RenderingContext.ResourceRendererMode.END_USER);
          renderReference(status, row.td(), wrapWC(res, version.getContent().copy().setDisplay("here")));
          context.setMode(mode);
        } else
          row.td();

        descCell = row.td();
        addMarkdown(descCell, instance.getDescription());
      }
    }
    return true;
  }

  public boolean renderProcesses(Map<Element, String> prefixes, RenderingStatus status, XhtmlNode x, ExampleScenario scen) throws IOException {
    Map<String, ExampleScenarioActorComponent> actors = new HashMap<>();
    for (ExampleScenarioActorComponent actor: scen.getActor()) {
      actors.put(actor.getKey(), actor);
    }

    Map<String, ExampleScenarioInstanceComponent> instances = new HashMap<>();
    for (ExampleScenarioInstanceComponent instance: scen.getInstance()) {
      instances.put(instance.getKey(), instance);
    }

    for (ExampleScenarioProcessComponent process : scen.getProcess()) {
      renderProcess(prefixes, status, x, process, actors, instances);
    }
    return true;
  }

  private int assignProcessPrefixes(Map<Element, String> prefixes, List<ExampleScenarioProcessComponent> processes, int i) {
    for (ExampleScenarioProcessComponent process : processes) {
      prefixes.put(process, "node"+i);
      i++;
    }
    
    for (ExampleScenarioProcessComponent process : processes) {
      i = assignStepPrefixes(prefixes, process.getStep(), i);
    }
    return i;
  }

  private int assignStepPrefixes(Map<Element, String> prefixes, List<ExampleScenarioProcessStepComponent> steps, int i) {
    for (ExampleScenarioProcessStepComponent step : steps) {
      prefixes.put(step, "node"+i);
      i++;
    }
    
    for (ExampleScenarioProcessStepComponent step : steps) {
      if (step.hasProcess()) {
        prefixes.put(step.getProcess(), "node"+i);
        i++;
        i = assignStepPrefixes(prefixes, step.getProcess().getStep(), i);
      }
      i = assignAlternativePrefixes(prefixes, step.getAlternative(), i);
      if (step.hasOperation()) {
        prefixes.put(step.getOperation(), "node"+i);
        i++;
      }
    }
    return i;
  }

  private int assignAlternativePrefixes(Map<Element, String> prefixes, List<ExampleScenarioProcessStepAlternativeComponent> list, int i) {
    for (ExampleScenarioProcessStepAlternativeComponent alt : list) {
      prefixes.put(alt, "node"+i);
      i++;
    }
    
    for (ExampleScenarioProcessStepAlternativeComponent alt : list) {
      i = assignStepPrefixes(prefixes, alt.getStep(), i);
    }
    return i;
  }

  public void renderProcess(Map<Element, String> prefixes, RenderingStatus status, XhtmlNode x, ExampleScenarioProcessComponent process, Map<String, ExampleScenarioActorComponent> actors, Map<String, ExampleScenarioInstanceComponent> instances) throws IOException {
    XhtmlNode div = x.div();
    div.an(context.prefixAnchor(prefixes.get(process)));
    div.b().tx(context.formatPhrase(RenderingContext.EX_SCEN_PROC, process.getTitle())+" ");
    if (process.hasDescription())
      addMarkdown(div, process.getDescription());
    if (process.hasPreConditions()) {
      div.para().b().i().tx(context.formatPhrase(RenderingContext.EX_SCEN_PRECON));
      addMarkdown(div, process.getPreConditions());
    }
    if (process.hasPostConditions()) {
      div.para().b().i().tx(context.formatPhrase(RenderingContext.EX_SCEN_POSTCON));
      addMarkdown(div, process.getPostConditions());
    }
    XhtmlNode tbl = div.table("table-striped table-bordered", false).style("width:100%");
    XhtmlNode thead = tbl.tr();
    thead.th().addText(context.formatPhrase(RenderingContext.EX_SCEN_STEP));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_NAME));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_DESC));
    thead.th().addText(context.formatPhrase(RenderingContext.EX_SCEN_IN));
    thead.th().addText(context.formatPhrase(RenderingContext.EX_SCEN_REC));
    thead.th().addText(context.formatPhrase(RenderingContext.GENERAL_REQUEST));
    thead.th().addText(context.formatPhrase(RenderingContext.EX_SCEN_RES));
    int stepCount = 1;
    for (ExampleScenarioProcessStepComponent step: process.getStep()) {
      renderStep(prefixes, status, tbl, step, actors, instances);
      stepCount++;
    }

    // Now go through the steps again and spit out any child processes
    stepCount = 1;
    for (ExampleScenarioProcessStepComponent step: process.getStep()) {
      stepSubProcesses(prefixes, status, tbl, step, actors, instances);
      stepCount++;
    }
  }

  private void stepSubProcesses(Map<Element, String> prefixes, RenderingStatus status, XhtmlNode x, ExampleScenarioProcessStepComponent step, Map<String, ExampleScenarioActorComponent> actors, Map<String, ExampleScenarioInstanceComponent> instances) throws IOException {
    if (step.hasProcess())
      renderProcess(prefixes, status, x, step.getProcess(), actors, instances);
    if (step.hasAlternative()) {
      int altNum = 1;
      for (ExampleScenarioProcessStepAlternativeComponent alt: step.getAlternative()) {
        int stepCount = 1;
        for (ExampleScenarioProcessStepComponent altStep: alt.getStep()) {
          stepSubProcesses(prefixes, status, x, altStep, actors, instances);
          stepCount++;
        }
        altNum++;
      }
    }
  }

  private boolean renderStep(Map<Element, String> prefixes, RenderingStatus status, XhtmlNode tbl, ExampleScenarioProcessStepComponent step, Map<String, ExampleScenarioActorComponent> actors, Map<String, ExampleScenarioInstanceComponent> instances) throws IOException {
    XhtmlNode row = tbl.tr();
    if (step.getPause()) {
      var td = row.td().colspan(7);
      td.style("opacity: 0.7");
      td.an(context.prefixAnchor(prefixes.get(step)));
      td.tx("Pause");
    } else {
      XhtmlNode prefixCell = row.td();
      prefixCell.an(context.prefixAnchor(prefixes.get(step)));
      prefixCell.tx(step.getNumber());
      if (step.hasProcess()) {
        XhtmlNode n = row.td().colspan(6);
        n.tx(context.formatPhrase(RenderingContext.EX_SCEN_SEE));
        n.ah(context.prefixLocalHref("#" + context.prefixAnchor(prefixes.get(step)))).tx(step.getProcess().getTitle());
        n.tx(" "+ context.formatPhrase(RenderingContext.EX_SCEN_BEL));

      } else if (step.hasWorkflow()) {
        XhtmlNode n = row.td().colspan(6);
        n.an(context.prefixAnchor(prefixes.get(step)));
        n.tx(context.formatPhrase(RenderingContext.EX_SCEN_OTH));
        String link = new ContextUtilities(context.getWorker()).getLinkForUrl(context.getLink(KnownLinkType.SPEC, true), step.getWorkflow());
        String title = "Unknown title";
        if (step.getWorkflowElement().hasExtension(ExtensionConstants.EXT_DISPLAY_NAME)) {
          title = step.getWorkflowElement().getExtensionString(ExtensionConstants.EXT_DISPLAY_NAME);
        } else {
          Resolver.ResourceWithReference rres = context.getResolver().resolve(context, step.getWorkflow(), null);
          if (rres != null && rres.getResource() != null && rres.getResource().has("title"))
            title = rres.getResource().primitiveValue("title");
        }
        if (link!= null)
          n.ah(context.prefixLocalHref(link)).tx(title);
        else
          n.addText(title);

      } else {
        // Must be an operation
        ExampleScenarioProcessStepOperationComponent op = step.getOperation();
        XhtmlNode name = row.td();
        name.tx(op.getTitle());
        if (op.hasType()) {
          name.tx(" - ");
          renderCoding(status, name, wrapNC(op.getType()));
        }
        XhtmlNode descCell = row.td();
        addMarkdown(descCell, op.getDescription());

        addActor(row, op.getInitiator(), actors);
        addActor(row, op.getReceiver(), actors);
        addInstance(row, op.getRequest(), instances);
        addInstance(row, op.getResponse(), instances);
      }

      int altNum = 1;
      for (ExampleScenarioProcessStepAlternativeComponent alt : step.getAlternative()) {
        XhtmlNode altHeading = tbl.tr().colspan(7).td();
        altHeading.para().i().tx(context.formatPhrase(RenderingContext.EX_SCEN_ALT, alt.getTitle())+" ");
        if (alt.hasDescription())
          addMarkdown(altHeading, alt.getDescription());
        int stepCount = 1;
        for (ExampleScenarioProcessStepComponent subStep : alt.getStep()) {
          renderStep(prefixes, status, tbl, subStep, actors, instances);
          stepCount++;
        }
        altNum++;
      }
    }

    return true;
  }

  private void addActor(XhtmlNode row, String actorId, Map<String, ExampleScenarioActorComponent> actors) throws FHIRException {
    XhtmlNode actorCell = row.td();
    if (actorId==null)
      return;
    ExampleScenarioActorComponent actor = actors.get(actorId);
    if (actor==null)
      throw new FHIRException(context.formatPhrase(RenderingContext.EX_SCEN_UN_ACT, actorId)+" ");
    actorCell.ah("#a_" + actor.getKey(), actor.getDescription()).tx(actor.getTitle());
  }

  private void addInstance(XhtmlNode row, ExampleScenarioInstanceContainedInstanceComponent instanceRef, Map<String, ExampleScenarioInstanceComponent> instances) {
    XhtmlNode instanceCell =  row.td();
    if (instanceRef==null || instanceRef.getInstanceReference()==null)
      return;
    ExampleScenarioInstanceComponent instance = instances.get(instanceRef.getInstanceReference());
    if (instance==null) {
      instanceCell.b().tx("Bad reference: "+instanceRef.getInstanceReference());
    } else if (instanceRef.hasVersionReference()) {
      ExampleScenarioInstanceVersionComponent theVersion = null;
      for (ExampleScenarioInstanceVersionComponent version: instance.getVersion()) {
        if (version.getKey().equals(instanceRef.getVersionReference())) {
          theVersion = version;
          break;
        }
      }
      if (theVersion==null)
        throw new FHIRException("Unable to find referenced version " + instanceRef.getVersionReference() + " within instance " + instanceRef.getInstanceReference());
      instanceCell.ah(context.prefixLocalHref("#i_" + instance.getKey() + "v_"+ theVersion.getKey()) , theVersion.getDescription()).tx(theVersion.getTitle());

    } else
      instanceCell.ah(context.prefixLocalHref("#i_" + instance.getKey()), instance.getDescription()).tx(instance.getTitle());
  }
}
