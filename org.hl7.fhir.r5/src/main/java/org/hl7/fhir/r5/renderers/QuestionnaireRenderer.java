package org.hl7.fhir.r5.renderers; 

import java.io.IOException; 
import java.io.UnsupportedEncodingException; 
import java.util.ArrayList; 
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.ContextUtilities; 
import org.hl7.fhir.r5.model.CanonicalResource; 
import org.hl7.fhir.r5.model.CanonicalType; 
import org.hl7.fhir.r5.model.CodeType; 
import org.hl7.fhir.r5.model.CodeableConcept; 
import org.hl7.fhir.r5.model.Coding; 
import org.hl7.fhir.r5.model.Expression; 
import org.hl7.fhir.r5.model.Extension; 
import org.hl7.fhir.r5.model.Resource; 
import org.hl7.fhir.r5.model.StructureDefinition; 
import org.hl7.fhir.r5.model.ValueSet; 
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules; 
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType; 
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions; 
import org.hl7.fhir.utilities.Utilities; 
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator; 
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell; 
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece; 
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row; 
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel; 
import org.hl7.fhir.utilities.xhtml.NodeType; 
import org.hl7.fhir.utilities.xhtml.XhtmlNode; 

import javax.annotation.Nonnull; 

public class QuestionnaireRenderer extends TerminologyRenderer { 
  public static final String EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ResourceElement.item.type"; 

  public QuestionnaireRenderer(RenderingContext context) { 
    super(context); 
  } 

  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement q) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    switch (context.getQuestionnaireMode()) { 
    case FORM:
      renderForm(status, x, q);
      break;
    case LINKS: 
      renderLinks(status, x, q);
      break;
    case LOGIC: 
      renderLogic(status, x, q);
      break;
    case DEFNS: 
      renderDefns(status, x, q);
      break;
    case TREE:  
      renderTree(status, x, q);
      break;
    default: 
      throw new Error("Unknown ResourceElement Renderer Mode"); 
    } 
  } 

  public void renderTree(RenderingStatus status, XhtmlNode x, ResourceElement q) throws UnsupportedEncodingException, IOException { 
    boolean hasFlags = checkForFlags(q.children("item")); 
    boolean doOpts = context.getDefinitionsTarget() == null && hasAnyOptions(q.children("item"));  

    if (doOpts) { 
      x.b().tx(context.formatPhrase(RenderingContext.QUEST_STRUCT)); 
    } 
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, context.getDestDir(), context.isInlineGraphics(), true); 
    TableModel model = gen.new TableModel("qtree="+q.getId(), context.getRules() == GenerationRules.IG_PUBLISHER);     
    model.setAlternating(true); 
    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) { 
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());     
    } else { 
      model.setDocoImg(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "help16.png")); 
    } 
    model.setDocoRef(context.getLink(KnownLinkType.SPEC)+"formats.html#table"); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.QUEST_LINKID)), (context.formatPhrase(RenderingContext.QUEST_LINK)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.QUEST_TEXT)), (context.formatPhrase(RenderingContext.QUEST_TEXTFOR)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.GENERAL_CARDINALITY)), (context.formatPhrase(RenderingContext.QUEST_TIMES)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.GENERAL_TYPE)), (context.formatPhrase(RenderingContext.QUEST_TYPE_ITEM)), null, 0)); 
    if (hasFlags) { 
      model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.GENERAL_FLAGS)), (context.formatPhrase(RenderingContext.QUEST_ATTRIBUTES)), null, 0)); 
    } 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.GENERAL_DESC_CONST)), (context.formatPhrase(RenderingContext.QUEST_ADD_INFO)), null, 0)); 
 
    // first we add a root for the questionaire itself 
    Row row = addTreeRoot(gen, model.getRows(), q, hasFlags); 
    for (ResourceElement i : q.children("item")) { 
      renderTreeItem(status, gen, row.getSubRows(), q, i, hasFlags); 
    } 
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null); 
    x.getChildNodes().add(xn); 
    if (doOpts) { 
      renderOptions(q, x); 
    } 
  } 

  private void renderOptions(ResourceElement q, XhtmlNode x) { 
    if (hasAnyOptions(q.children("item"))) { 
      x.hr(); 
      x.para().b().tx(context.formatPhrase(RenderingContext.QUEST_OPT)); 
      renderOptions(q.children("item"), x); 
    }     
  } 

  private void renderOptions(List<ResourceElement> items, XhtmlNode x) {     
    for (ResourceElement i : items) { 
      renderItemOptions(x, i); 
      renderOptions(i.children("item"), x); 
    }     
  } 

  public void renderItemOptions(XhtmlNode x, ResourceElement i) { 
    if (i.has("answerOption")) { 
      boolean useSelect = false; 
      for (ResourceElement opt : i.children("answerOption")) { 
        useSelect = useSelect || "true".equals(opt.primitiveValue("initialSelected"));  
      } 
      x.an("opt-item."+i.primitiveValue("linkId")); 
      x.para().b().tx(context.formatPhrase(RenderingContext.QUEST_ANSW, i.primitiveValue("linkId"))+" "); 
      XhtmlNode ul = x.ul(); 
      for (ResourceElement opt : i.children("answerOption")) { 
        XhtmlNode li = ul.li(); 
        li.style("font-size: 11px"); 
        if (useSelect) { 
          if ("true".equals(opt.primitiveValue("initialSelected"))) { 
            li.img("icon-selected.png", "icon"); 
          } else { 
            li.img("icon-not-selected.png", "icon");             
          } 
        } 
        ResourceElement v = opt.child("value");
        if (v.isPrimitive()) { 
          li.tx(v.primitiveValue()); 
        } else if (v.fhirType().equals("Coding")) { 
          String link = v.has("system") ? new ContextUtilities(context.getWorker()).getLinkForUrl(context.getLink(KnownLinkType.SPEC), v.primitiveValue("system")) : null; 
          if (link == null) { 
            li.tx(v.primitiveValue("system")+"#"+v.primitiveValue("code")); 
          } else { 
            li.ah(link).tx(displaySystem(v.primitiveValue("system"))); 
            li.tx(": "+v.primitiveValue("code"));               
          } 
          if (v.has("display")) { 
            li.tx(" (\""+v.primitiveValue("display")+"\")");               
          } 
        } else { 
          li.tx("??");             
        } 
      } 
    } 
  } 

  private boolean hasAnyOptions(List<ResourceElement> items) { 
    for (ResourceElement i : items) { 
      if (i.has("answerOption")) { 
        return true; 
      } 
      if (hasAnyOptions(i.children("item"))) { 
        return true; 
      } 
    } 
    return false; 
  } 

  private boolean checkForFlags(List<ResourceElement> items) { 
    for (ResourceElement i : items) { 
      if (checkForFlags(i)) { 
        return true; 
      } 
    } 
    return false; 
  } 

  private boolean checkForFlags(ResourceElement i) { 
    if (i.has("readOnly")) { 
      return true; 
    } 
    if ("true".equals(i.extensionString(ToolingExtensions.EXT_Q_IS_SUBJ))) { 
      return true; 
    } 
    if ("true".equals(i.extensionString(ToolingExtensions.EXT_Q_HIDDEN))) { 
      return true; 
    } 
    if ("true".equals(i.extensionString(ToolingExtensions.EXT_Q_OTP_DISP))) { 
      return true; 
    } 
    if (i.hasExtension(ToolingExtensions.EXT_O_LINK_PERIOD)) { 
      return true; 
    } 
    if (i.hasExtension(ToolingExtensions.EXT_Q_CHOICE_ORIENT)) { 
      return true; 
    } 
    if (i.hasExtension(ToolingExtensions.EXT_Q_DISPLAY_CAT)) { 
      return true; 
    } 
    return checkForFlags(i.children("item")); 
  } 



  private Row addTreeRoot(HierarchicalTableGenerator gen, List<Row> rows, ResourceElement q, boolean hasFlags) throws IOException { 
    Row r = gen.new Row(); 
    rows.add(r); 

    r.setIcon("icon_q_root.gif", context.formatPhrase(RenderingContext.QUEST_ROOT)); 
    r.getCells().add(gen.new Cell(null, null, q.primitiveValue("name"), null, null)); 
    r.getCells().add(gen.new Cell(null, null, q.primitiveValue("description"), null, null)); 
    r.getCells().add(gen.new Cell(null, null, "", null, null)); 
    r.getCells().add(gen.new Cell(null, null, context.formatPhrase(RenderingContext.QUEST_QUEST), null, null)); 
    if (hasFlags) { 
      r.getCells().add(gen.new Cell(null, null, "", null, null)); 
    } 
    r.getCells().add(gen.new Cell(null, null, q.has("url") ? q.has("version") ? q.primitiveValue("url")+"#"+q.primitiveValue("version") : q.primitiveValue("url") : "", null, null)); 
    return r;     
  } 

  private String getSpecLink(String path) { 
    return Utilities.pathURL(context.getLink(KnownLinkType.SPEC), path); 
  } 

  private String getSDCLink(String url, String path) { 
    StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, url); 
    if (sd == null) { 
      sd = context.getContext().fetchResource(StructureDefinition.class, path); 
    } 
    if (sd != null && sd.hasWebPath()) { 
      return sd.getWebPath(); 
    } else if (Utilities.isAbsoluteUrl(path)) { 
      return path.replace("StructureDefinition/", "StructureDefinition-")+".html"; 
    } else { 
      return Utilities.pathURL("http://hl7.org/fhir/uv/sdc", path); // for now? 
    } 
  } 

  private void renderTreeItem(RenderingStatus status, HierarchicalTableGenerator gen, List<Row> rows, ResourceElement q, ResourceElement i, boolean hasFlags) throws IOException { 
    Row r = gen.new Row(); 
    rows.add(r); 
    String type = i.primitiveValue("type");

    r.setIcon("icon-q-"+type.toLowerCase()+".png", type); 
    Cell c1 = gen.new Cell(null, context.getDefinitionsTarget() == null ? "" : context.getDefinitionsTarget()+"#item."+i.primitiveValue("linkId"), i.primitiveValue("linkId"), null, null); 
    c1.setId("item."+i.primitiveValue("linkId")); 
    r.getCells().add(c1); 
    String txt = (i.has("prefix") ? i.primitiveValue("prefix") + ". " : "") + i.primitiveValue("text"); 
    r.getCells().add(gen.new Cell(null, null, txt, null, null)); 
    r.getCells().add(gen.new Cell(null, null, ("true".equals(i.primitiveValue("required")) ? "1" : "0")+".."+("true".equals(i.primitiveValue("repeats")) ? "*" : "1"), null, null)); 
    if (i.child("type").hasExtension(EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL)) { 
      status.setExtensions(true);
      String t = i.child("type").extensionString(EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL); 
      r.getCells().add(gen.new Cell(null, context.getLink(KnownLinkType.SPEC)+"codesystem-item-type.html#item-type-"+t, t, null, null)); 
    } else { 
      r.getCells().add(gen.new Cell(null, context.getLink(KnownLinkType.SPEC)+"codesystem-item-type.html#item-type-"+type, type, null, null)); 
    } 

    if (hasFlags) { 
      // flags: 
      Cell flags = gen.new Cell(); 
      r.getCells().add(flags); 
      if ("true".equals(i.primitiveValue("readOnly"))) { 
        flags.addPiece(gen.new Piece(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "ResourceElement-definitions.html#ResourceElement.item.readOnly"), null, context.formatPhrase(RenderingContext.QUEST_READONLY)).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", getImgPath("icon-qi-readonly.png")))); 
      } 
      if ("true".equals(i.extensionString("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-isSubject"))) { 
        status.setExtensions(true);
        flags.addPiece(gen.new Piece(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-isSubject", "StructureDefinition-sdc-ResourceElement-isSubject.html"), null, context.formatPhrase(RenderingContext.QUEST_SUBJECT)).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", getImgPath("icon-qi-subject.png")))); 
      } 
      if ("true".equals(i.extensionString(ToolingExtensions.EXT_Q_HIDDEN))) { 
        status.setExtensions(true);
        flags.addPiece(gen.new Piece(getSpecLink("extension-ResourceElement-hidden.html"), null, context.formatPhrase(RenderingContext.QUEST_HIDDEN)).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", getImgPath("icon-qi-hidden.png")))); 
      } 
      if ("true".equals(i.extensionString(ToolingExtensions.EXT_Q_OTP_DISP))) { 
        status.setExtensions(true);
        flags.addPiece(gen.new Piece(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-optionalDisplay", "StructureDefinition-sdc-ResourceElement-optionalDisplay.html"), null, context.formatPhrase(RenderingContext.QUEST_DISPLAY)).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", getImgPath("icon-qi-optional.png")))); 
      } 
      if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod")) { 
        status.setExtensions(true);
        flags.addPiece(gen.new Piece(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod", "StructureDefinition-sdc-ResourceElement-observationLinkPeriod.html"), null, context.formatPhrase(RenderingContext.QUEST_LINKED)).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", getImgPath("icon-qi-observation.png")))); 
      } 
      if (i.hasExtension(ToolingExtensions.EXT_Q_CHOICE_ORIENT)) { 
        status.setExtensions(true);
        String code = i.extensionString(ToolingExtensions.EXT_Q_CHOICE_ORIENT); 
        flags.addPiece(gen.new Piece(getSpecLink("extension-ResourceElement-choiceorientation.html"), null, context.formatPhrase(RenderingContext.QUEST_ORIENTATION, code)+" ").addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", getImgPath("icon-qi-" + code + ".png")))); 
      } 
      if (i.hasExtension(ToolingExtensions.EXT_Q_DISPLAY_CAT)) { 
        status.setExtensions(true);
        ResourceElement cc = i.extensionValue(ToolingExtensions.EXT_Q_DISPLAY_CAT); 
        String code = getCodeFromCC(cc, "http://hl7.org/fhir/ResourceElement-display-category"); 
        flags.addPiece(gen.new Piece("https://hl7.org/fhir/R4/extension-ResourceElement-displayCategory.html", null, context.formatPhrase(RenderingContext.QUEST_CAT, code)+" ").addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", getImgPath("icon-qi-" + code + ".png")))); 
      } 
    }     
    Cell defn = gen.new Cell(); 
    r.getCells().add(defn); 

    if (i.has("maxLength")) { 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_MAX_LENGTH)+" "), null)); 
      defn.getPieces().add(gen.new Piece(null, i.primitiveValue("maxLength"), null)); 
    } 
    if (i.has("definition")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_DEFINITION_COLON)+" "), null)); 
      genDefinitionLink(gen, i, defn, q);       
    } 
    if (i.has("enableWhen")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      Piece p = gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_ENABLE)+" "), null); 
      defn.getPieces().add(p); 
      if (i.children("enableWhen").size() == 1) { 
        XhtmlNode x = new XhtmlNode(NodeType.Element, "span"); 
        p.getChildren().add(x); 
        renderEnableWhen(x, i.firstChild("enableWhen"));         
      } else { 
        XhtmlNode x = new XhtmlNode(NodeType.Element, "ul"); 
        p.getChildren().add(x); 
        for (ResourceElement qi : i.children("enableWhen")) { 
          renderEnableWhen(x.li(), qi); 
        } 
      } 
    } 
    if (i.has("answerValueSet")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_VALUE)+" "), null)); 
      if (i.hasPrimitiveValue("answerValueSet") && i.primitiveValue("answerValueSet").startsWith("#")) { 
        ResourceElement vs = q.getContained(i.primitiveValue("answerValueSet").substring(1)); 
        if (vs == null) { 
          defn.getPieces().add(gen.new Piece(null, i.primitiveValue("answerValueSet"), null));                     
        } else { 
          defn.getPieces().add(gen.new Piece(vs.getWebPath(), RendererFactory.factory(vs, context).displayResource(vs), null));                               
        } 
      } else { 
        ValueSet vs = context.getWorker().findTxResource(ValueSet.class, i.primitiveValue("answerValueSet")); 
        if (vs == null  || !vs.hasWebPath()) { 
          defn.getPieces().add(gen.new Piece(null, i.primitiveValue("answerValueSet"), null));                     
        } else { 
          defn.getPieces().add(gen.new Piece(vs.getWebPath(), vs.present(), null));                     
        }              
      } 
    } 
    if (i.has("answerOption")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_OPTIONS)+" "), null)); 
      if (context.getDefinitionsTarget() == null) { 
        // if we don't have a definitions target, we'll add them below.  
        defn.getPieces().add(gen.new Piece("#opt-item."+i.primitiveValue("linkId"), Integer.toString(i.children("answerOption").size())+" "+Utilities.pluralize("option", i.children("answerOption").size()), null)); 
      } else { 
        defn.getPieces().add(gen.new Piece(context.getDefinitionsTarget()+"#item."+i.primitiveValue("linkId"), Integer.toString(i.children("answerOption").size())+" "+Utilities.pluralize("option", i.children("answerOption").size()), null)); 
      } 
    } 
    if (i.has("initial")) { 
      for (ResourceElement v : i.children("initial")) { 
        ResourceElement vv = v.child("value");
        if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
        defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_INITIAL)+" "), null)); 
        defn.getPieces().add(gen.new Piece(null, vv.fhirType(), null)); 
        defn.getPieces().add(gen.new Piece(null, " = ", null));
        if (vv.isPrimitive()) { 
          defn.getPieces().add(gen.new Piece(null, vv.primitiveValue(), null)); 
        } else if (vv.fhirType().equals("Coding")) { 
          renderCoding(gen, defn.getPieces(), vv);           
        } else if (vv.fhirType().equals("Quantity")) { 
          renderQuantity(gen, defn.getPieces(), vv, false);         
        } else if (vv.fhirType().equals("Reference")) { 
          renderReference(q, gen, defn.getPieces(), vv, true);        
        } else if (vv.fhirType().equals("Attachment")) { 
          // renderAttachment(gen, defn.getPieces(), vv);           
        } 
      } 
    } 
    // still todo 

    // 
    //http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-choiceColumn 
    // 
    //http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-width 
    //http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod 
    //http://hl7.org/fhir/StructureDefinition/ResourceElement-itemControl 
    //http://hl7.org/fhir/StructureDefinition/ResourceElement-sliderStepValue 

    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_EXP)+" "), null)); 
      Piece p = gen.new Piece("ul"); 
      defn.getPieces().add(p); 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_INT), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_CONT), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_ITEM_CONT), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_EN), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_CALC), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_CAND), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression"); 
      }  
    } 

    for (ResourceElement c : i.children("item")) { 
      renderTreeItem(status, gen, r.getSubRows(), q, c, hasFlags); 
    }      
  } 

  private String getCodeFromCC(ResourceElement cc, String system) {
    for (ResourceElement coding : cc.children("coding")) {
      if (system.equals(coding.primitiveValue("system"))) {
        return coding.primitiveValue("code");
      }      
    }
    return null;
    
  }

  public void genDefinitionLink(HierarchicalTableGenerator gen, ResourceElement i, Cell defn, ResourceElement q) { 
    // can we resolve the definition?  
    String path = null; 
    String d = i.primitiveValue("definition"); 
    if (d.contains("#")) { 
      path = d.substring(d.indexOf("#")+1); 
      d = d.substring(0, d.indexOf("#")); 
    } 
    StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, d, q.getResourceNative()); 
    if (sd != null) { 
      String url = sd.getWebPath(); 
      if (url != null) { 
        defn.getPieces().add(gen.new Piece(url+"#"+path, path, null));           
      } else { 
        defn.getPieces().add(gen.new Piece(null, i.primitiveValue("definition"), null)); 
      } 
    } else { 
      defn.getPieces().add(gen.new Piece(null, i.primitiveValue("definition"), null)); 
    } 
  } 

  public void genDefinitionLink(XhtmlNode x, ResourceElement i, ResourceElement q) { 
    // can we resolve the definition?  
    String path = null; 
    String d = i.primitiveValue("definition"); 
    if (d.contains("#")) { 
      path = d.substring(d.indexOf("#")+1); 
      d = d.substring(0, d.indexOf("#")); 
    } 
    StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, d, q.getResourceNative()); 
    if (sd != null) { 
      String url = sd.getWebPath(); 
      if (url != null) { 
        x.ah(url+"#"+path).tx(path);           
      } else { 
        x.tx(i.primitiveValue("definition")); 
      } 
    } else { 
      x.tx(i.primitiveValue("definition")); 
    } 
  } 

  private void addExpression(Piece p, ResourceElement exp, String label, String url) { 
    XhtmlNode x = new XhtmlNode(NodeType.Element, "li").style("font-size: 11px"); 
    p.addHtml(x); 
    CanonicalResource cr = (CanonicalResource) context.getContext().fetchResource(Resource.class, url); 
    if (cr != null && cr.hasWebPath()) { 
      x.ah(cr.getWebPath()).tx(label); 
    } else { 
      x.ah(url).tx(label); 
    } 
    x.tx(": "); 
    x.code(exp.primitiveValue("expression")); 
  } 

  private void renderLogic(RenderingStatus status, XhtmlNode x, ResourceElement q) throws FHIRException, IOException { 
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, context.getDestDir(), context.isInlineGraphics(), true); 
    TableModel model = gen.new TableModel("qtree="+q.getId(), true);     
    model.setAlternating(true); 
    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) { 
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());     
    } else { 
      model.setDocoImg(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "help16.png")); 
    } 
    model.setDocoRef(context.getLink(KnownLinkType.SPEC)+"formats.html#table"); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.QUEST_LINKID), context.formatPhrase(RenderingContext.QUEST_LINK), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.GENERAL_DESC_CONST), context.formatPhrase(RenderingContext.QUEST_ADD_INFO), null, 0)); 

    if (!q.has("item")) { 
      gen.emptyRow(model, 2); 
    } else { 
      for (ResourceElement i : q.children("item")) { 
        renderLogicItem(status, gen, model.getRows(), q, i); 
      } 
    } 
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null); 
    x.getChildNodes().add(xn); 
  } 

  private void renderLogicItem(RenderingStatus status, HierarchicalTableGenerator gen, List<Row> rows, ResourceElement q, ResourceElement i) throws IOException { 
    Row r = gen.new Row(); 
    rows.add(r); 
    String type = i.primitiveValue("type");

    r.setIcon("icon-q-"+type.toLowerCase()+".png", type); 
    r.getCells().add(gen.new Cell(null, context.getDefinitionsTarget() == null ? "" : context.getDefinitionsTarget()+"#item."+i.primitiveValue("linkId"), i.primitiveValue("linkId"), null, null)); 
    Cell defn = gen.new Cell(); 
    r.getCells().add(defn); 

    if (i.has("maxLength")) { 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_MAX_LENGTH)+" "), null)); 
      defn.getPieces().add(gen.new Piece(null, i.primitiveValue("maxLength"), null)); 
    } 
    if (i.has("definition")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_DEFINITION_COLON)+" "), null)); 
      genDefinitionLink(gen, i, defn, q);             
    } 
    if (i.has("enableWhen")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_ENABLE)+" "), null)); 
      defn.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.GENERAL_TODO), null));       
    } 
    if (i.has("answerValueSet")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_VALUE)+" "), null)); 
      if (Utilities.noString(i.primitiveValue("answerValueSet")) && i.primitiveValue("answerValueSet").startsWith("#")) { 
        ResourceElement vs = q.getContained(i.primitiveValue("answerValueSet").substring(1)); 
        if (vs == null) { 
          defn.getPieces().add(gen.new Piece(null, i.primitiveValue("answerValueSet"), null));                     
        } else { 
          defn.getPieces().add(gen.new Piece(vs.getWebPath(), RendererFactory.factory(vs, context).displayResource(vs), null));                               
        } 
      } else { 
        ValueSet vs = context.getWorker().findTxResource(ValueSet.class, i.primitiveValue("answerValueSet"), q.getResourceNative()); 
        if (vs == null  || !vs.hasWebPath()) { 
          defn.getPieces().add(gen.new Piece(null, i.primitiveValue("answerValueSet"), null));                     
        } else { 
          defn.getPieces().add(gen.new Piece(vs.getWebPath(), vs.present(), null));                     
        }              
      } 
    } 
    if (i.has("answerOption")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_OPTIONS)+" "), null)); 
      defn.getPieces().add(gen.new Piece(context.getDefinitionsTarget()+"#item."+i.primitiveValue("linkId"), Integer.toString(i.children("answerOption").size())+" "+Utilities.pluralize("option", i.children("answerOption").size()), null));             
    } 
    if (i.has("initial")) { 
      for (ResourceElement v : i.children("initial")) { 
        if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
        ResourceElement vv = v.child("value"); 
        defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_INITIAL)+" "), null)); 
        defn.getPieces().add(gen.new Piece(null, vv.fhirType(), null)); 
        defn.getPieces().add(gen.new Piece(null, " = ", null)); 
        if (vv.isPrimitive()) { 
          defn.getPieces().add(gen.new Piece(null, vv.primitiveValue(), null)); 
        } else if (vv.fhirType().equals("Coding")) { 
          renderCoding(gen, defn.getPieces(), vv);        
        } else if (vv.fhirType().equals("Coding")) { 
          renderQuantity(gen, defn.getPieces(), vv, false); 
        } else if (vv.fhirType().equals("Coding")) { 
          renderReference(q, gen, defn.getPieces(), vv, false);           
          //        } else if (v.hasValueAttachment()) { 
          //          renderAttachment(gen, defn.getPieces(), v.getValueAttachment());           
        } 
      } 
    } 
    // still todo 

    // 
    //http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-choiceColumn 
    // 
    //http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-width 
    //http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod 
    //http://hl7.org/fhir/StructureDefinition/ResourceElement-itemControl 
    //http://hl7.org/fhir/StructureDefinition/ResourceElement-sliderStepValue 

    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression")) { 
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
      defn.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.QUEST_EXP)+" "), null)); 
      Piece p = gen.new Piece("ul"); 
      defn.getPieces().add(p); 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_INT), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_CONT), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_ITEM_CONT), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_EN), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_CALC), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression"); 
      } 
      for (ResourceElement e : i.extensions("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression")) { 
        addExpression(p, e.child("value"), context.formatPhrase(RenderingContext.QUEST_CAND), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression"); 
      }  
    } 

    for (ResourceElement c : i.children("item")) { 
      renderLogicItem(status, gen, r.getSubRows(), q, c); 
    }  

  } 


  public void renderForm(RenderingStatus status, XhtmlNode x, ResourceElement q) throws UnsupportedEncodingException, IOException {
    XhtmlNode d = x.div(); 
    boolean hasPrefix = false; 
    for (ResourceElement c : q.children("item")) { 
      hasPrefix = hasPrefix || doesItemHavePrefix(c); 
    } 
    int i = 1; 
    for (ResourceElement c : q.children("item")) { 
      renderFormItem(status, d, q, c, hasPrefix ? null : Integer.toString(i), 0); 
      i++; 
    }   
  } 

  private boolean doesItemHavePrefix(ResourceElement i) { 
    if (i.has("prefix")) { 
      return true; 
    } 
    for (ResourceElement c : i.children("item")) { 
      if (doesItemHavePrefix(c)) { 
        return true; 
      } 
    } 
    return false; 
  } 

  private void renderFormItem(RenderingStatus status, XhtmlNode x, ResourceElement q, ResourceElement i, String pfx, int indent) throws IOException { 
    boolean hasExt = false; 
    XhtmlNode d = x.div().style("width: "+Integer.toString(900-indent*10)+"px; border-top: 1px #eeeeee solid"); 
    if (indent > 0) { 
      d.style("margin-left: "+Integer.toString(10*indent)+"px"); 
    } 
    XhtmlNode display = d.div().style("display: inline-block; width: "+Integer.toString(500-indent*10)+"px"); 
    XhtmlNode details = d.div().style("border: 1px #ccccff solid; padding: 2px; display: inline-block; background-color: #fefce7; width: 380px"); 
    XhtmlNode p = display.para(); 

    String type = i.primitiveValue("type");
    if ("group".equals(type)) { 
      p = p.b(); 
    } 
    if (i.has("prefix")) { 
      p.tx(i.primitiveValue("prefix")); 
      p.tx(": "); 
    } 
    p.span(null, "linkId: "+i.primitiveValue("linkId")).tx(i.primitiveValue("text")); 
    if ("true".equals(i.primitiveValue("required"))) { 
      p.span("color: red", context.formatPhrase(RenderingContext.QUEST_MAND)).tx("*"); 
    } 

    XhtmlNode input = null; 
    switch (type) { 
    case "string": 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "text", type, 60); 
      break; 
    case "attachment": 
      break; 
    case "boolean": 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "checkbox", type, 1); 
      break; 
    case "coding": 
      input = p.select(i.primitiveValue("linkId")); 
      listOptions(q, i, input); 
      break; 
    case "date": 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "date", type, 10); 
      break; 
    case "dateTime": 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "datetime-local", type, 25); 
      break; 
    case "decimal": 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "number", type, 15); 
      break; 
    case "display": 
      break; 
    case "group": 
      break; 
    case "integer": 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "number", type, 10); 
      break; 
    case "qantity": 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "number", "value", 15); 
      p.tx(" "); 
      input = p.input(i.primitiveValue("linkId"), "unit", "unit", 10); 
      break; 
    case "question": 
      break; 
    case "reference": 
      break; 
    case "text": 
      break; 
    case "time": 
      break; 
    case "url": 
      break; 
    default: 
      break; 
    } 
    if (input != null) { 
      if ("true".equals(i.primitiveValue("readOnly"))) { 
        input.attribute("readonly", "1"); 
        input.style("background-color: #eeeeee"); 
      } 
    } 

    //  if (i.hasExtension(ToolingExtensions.EXT_Q_CHOICE_ORIENT)) { 
    //  String code = ToolingExtensions.readStringExtension(i,  ToolingExtensions.EXT_Q_CHOICE_ORIENT); 
    //  flags.addPiece(gen.new Piece("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod", null, "Orientation: "+code).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", Utilities.path(context.getLocalPrefix(), "icon-qi-"+code+".png")))); 
    //} 


    XhtmlNode ul = details.ul(); 
    boolean hasFlag = false;  
    XhtmlNode flags = item(ul, "Flags"); 
    item(ul, "linkId", i.primitiveValue("linkId")); 

    if ("true".equals(i.extensionString("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-isSubject"))) { 
      hasFlag = true; 
      flags.ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-isSubject", "StructureDefinition-sdc-ResourceElement-isSubject.html"), context.formatPhrase(RenderingContext.QUEST_SUBJECT)).img(getImgPath("icon-qi-subject.png"), "icon"); 
    } 
    if ("true".equals(i.extensionString(ToolingExtensions.EXT_Q_HIDDEN))) { 
      hasFlag = true; 
      flags.ah(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "extension-ResourceElement-hidden.html"), context.formatPhrase(RenderingContext.QUEST_HIDDEN)).img(getImgPath("icon-qi-hidden.png"), "icon"); 
      d.style("background-color: #eeeeee"); 
    } 
    if ("true".equals(i.extensionString(ToolingExtensions.EXT_Q_OTP_DISP))) { 
      hasFlag = true; 
      flags.ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-optionalDisplay", "StructureDefinition-sdc-ResourceElement-optionalDisplay.html"), context.formatPhrase(RenderingContext.QUEST_DISPLAY)).img(getImgPath("icon-qi-optional.png"), "icon"); 
    } 
    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod")) { 
      hasFlag = true; 
      flags.ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod", "StructureDefinition-sdc-ResourceElement-observationLinkPeriod.html"), context.formatPhrase(RenderingContext.QUEST_LINKED)).img(getImgPath("icon-qi-observation.png"), "icon"); 
    } 
    if (i.hasExtension(ToolingExtensions.EXT_Q_DISPLAY_CAT)) { 
      ResourceElement cc = i.extension(ToolingExtensions.EXT_Q_DISPLAY_CAT).child("value"); 
      String code = getCodeFromCC(cc, "http://hl7.org/fhir/ResourceElement-display-category"); 
      hasFlag = true; 
      flags.ah("https://hl7.org/fhir/R4/extension-ResourceElement-displayCategory.html", (context.formatPhrase(RenderingContext.QUEST_CAT, code)+" ")).img(getImgPath("icon-qi-" + code + ".png"), "icon"); 
    } 

    if (i.has("maxLength")) { 
      item(ul, context.formatPhrase(RenderingContext.GENERAL_MAX_LENGTH), i.primitiveValue("maxLength")); 
    } 
    if (i.has("definition")) { 
      genDefinitionLink(item(ul, context.formatPhrase(RenderingContext.GENERAL_DEFINITION_COLON)), i, q);       
    } 
    if (i.has("enableWhen")) { 
      item(ul, context.formatPhrase(RenderingContext.QUEST_EN), "todo"); 
    } 
    if (i.has("answerValueSet")) { 
      XhtmlNode ans = item(ul, context.formatPhrase(RenderingContext.QUEST_ANSWERS)); 
      if (!Utilities.noString(i.primitiveValue("answerValueSet")) && i.primitiveValue("answerValueSet").startsWith("#")) { 
        ResourceElement vs = q.getContained(i.primitiveValue("answerValueSet").substring(1)); 
        if (vs == null || vs.getWebPath() == null) { 
          ans.tx(i.primitiveValue("answerValueSet"));                     
        } else { 
          ans.ah(vs.getWebPath()).tx(RendererFactory.factory(vs, context).displayResource(vs));                               
        } 
      } else { 
        ValueSet vs = context.getWorker().findTxResource(ValueSet.class, i.primitiveValue("answerValueSet"), q.getResourceNative()); 
        if (vs == null  || !vs.hasWebPath()) { 
          ans.tx(i.primitiveValue("answerValueSet"));                     
        } else { 
          ans.ah(vs.getWebPath()).tx(vs.present());                               
        }              
      } 
    } 
    if (i.has("answerOption")) { 
      item(ul, context.formatPhrase(RenderingContext.QUEST_ANSWERS), Integer.toString(i.children("answerOption").size())+" "+Utilities.pluralize("option", i.children("answerOption").size()), context.getDefinitionsTarget()+"#item."+i.primitiveValue("linkId")); 
    } 
    if (i.has("initial")) { 
      XhtmlNode vi = item(ul, context.formatPhrase(RenderingContext.QUEST_INT)); 
      boolean first = true; 
      for (ResourceElement v : i.children("initial")) { 
        if (first) first = false; else vi.tx(", "); 
        ResourceElement vv = v.child("value");
        if (vv.isPrimitive()) { 
          vi.tx(vv.primitiveValue()); 
        } else if (vv.fhirType().equals("Coding")) { 
          renderCoding(status, vi, vv);            
        } else if (vv.fhirType().equals("Reference")) { 
          renderReference(status, vi, vv);            
        } else if (vv.fhirType().equals("Quantity")) { 
          renderQuantity(status, vi, vv);            
          //        } else if (v.hasValueAttachment()) { 
          //          renderAttachment(vi, v.getValueAttachment());            
        } 
      } 
    } 
    if (!hasFlag) { 
      ul.remove(flags); 
    } 
    //    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression")) { 
    //      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br")); 
    //      defn.getPieces().add(gen.new Piece(null, "Expressions: ", null)); 
    //      Piece p = gen.new Piece("ul"); 
    //      defn.getPieces().add(p); 
    //      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression")) { 
    //        addExpression(p, e.getValueExpression(), "Initial Value", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-initialExpression"); 
    //      } 
    //      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression")) { 
    //        addExpression(p, e.getValueExpression(), "Context", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-contextExpression"); 
    //      } 
    //      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext")) { 
    //        addExpression(p, e.getValueExpression(), "Item Context", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-itemContext"); 
    //      } 
    //      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression")) { 
    //        addExpression(p, e.getValueExpression(), "Enable When", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-enableWhenExpression"); 
    //      } 
    //      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression")) { 
    //        addExpression(p, e.getValueExpression(), "Calculated Value", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-calculatedExpression"); 
    //      } 
    //      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression")) { 
    //        addExpression(p, e.getValueExpression(), "Candidates", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-candidateExpression"); 
    //      }  
    //    } 
    // 

    int t = 1; 
    for (ResourceElement c : i.children("item")) { 
      renderFormItem(status, x, q, c, pfx == null ? null : pfx+"."+Integer.toString(t), indent+1); 
      t++; 
    }   
  } 

  @Nonnull 
  private String getImgPath(String code) throws IOException { 
    return context.getLocalPrefix().length() > 0 
        ? Utilities.path(context.getLocalPrefix(), code) 
            : Utilities.path(code); 
  } 

  private void item(XhtmlNode ul, String name, String value, String valueLink) { 
    if (!Utilities.noString(value)) { 
      ul.li().style("font-size: 10px").ah(valueLink).tx(name+": "+value); 
    } 
  } 

  private void item(XhtmlNode ul, String name, String value) { 
    if (!Utilities.noString(value)) { 
      ul.li().style("font-size: 10px").tx(name+": "+value); 
    } 
  } 
  private XhtmlNode item(XhtmlNode ul, String name) { 
    XhtmlNode li = ul.li(); 
    li.style("font-size: 10px").tx(name+": "); 
    return li; 
  } 


  private void listOptions(ResourceElement q, ResourceElement i, XhtmlNode select) { 
    if (i.has("answerValueSet")) { 
      ValueSet vs = null; 
      if (!Utilities.noString(i.primitiveValue("answerValueSet")) && i.primitiveValue("answerValueSet").startsWith("#")) { 
        vs = (ValueSet) q.getContained(i.primitiveValue("answerValueSet").substring(1)).getResourceNative(); 
        if (vs != null && !vs.hasUrl()) { 
          vs = vs.copy(); 
          vs.setUrl(q.primitiveValue("url")+"--"+q.getContained(i.primitiveValue("answerValueSet").substring(1))); 
        } 
      } else { 
        vs = context.getContext().findTxResource(ValueSet.class, i.primitiveValue("answerValueSet"), q.getResourceNative()); 
      } 
      if (vs != null) { 
        ValueSetExpansionOutcome exp = context.getContext().expandVS(vs, true, false); 
        if (exp.getValueset() != null) { 
          for (ValueSetExpansionContainsComponent cc : exp.getValueset().getExpansion().getContains()) { 
            select.option(cc.getCode(), cc.hasDisplay() ? cc.getDisplay() : cc.getCode(), false);     
          } 
          return; 
        } 
      } 
    } else if (i.has("answerOption")) { 
      renderItemOptions(select, i);  
    }  
    select.option("a", "??", false);     
  } 

  private void renderLinks(RenderingStatus status, XhtmlNode x, ResourceElement q) { 
    x.para().tx(context.formatPhrase(RenderingContext.QUEST_TRY)); 
    XhtmlNode ul = x.ul(); 
    ul.li().ah("http://todo.nlm.gov/path?mode=ig&src="+Utilities.pathURL(context.getLink(KnownLinkType.SELF), "package.tgz")+"&q="+q.getId()+".json").tx(context.formatPhrase(RenderingContext.QUEST_NLM)); 
  } 

  private void renderDefns(RenderingStatus status, XhtmlNode x, ResourceElement q) throws IOException { 
    XhtmlNode tbl = x.table("dict"); 
    renderRootDefinition(status, tbl, q, new ArrayList<>()); 
    for (ResourceElement qi : q.children("item")) { 
      renderDefinition(status, tbl, q, qi, new ArrayList<>()); 
    } 
  } 

  private void renderRootDefinition(RenderingStatus status, XhtmlNode tbl, ResourceElement q, List<ResourceElement> parents) throws IOException { 
    boolean ext = false; 
    XhtmlNode td = tbl.tr().td("structure").colspan("2").span(null, null).attribute("class", "self-link-parent"); 
    td.an(q.getId()); 
    td.img(getImgPath("icon_q_root.gif"), "icon"); 
    td.tx(" "+(context.formatPhrase(RenderingContext.QUEST_QUEST)+" ")); 
    td.b().tx(q.getId()); 

    // general information 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_URL), q.primitiveValue("url")); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_VER), q.primitiveValue("version")); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_NAME), q.primitiveValue("name")); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_TITLE), q.primitiveValue("title")); 
    if (q.has("derivedFrom")) { 
      td = defn(tbl, context.formatPhrase(RenderingContext.QUEST_DERIVED)); 
      boolean first = true; 
      for (ResourceElement c : q.children("derivedFrom")) { 
        if (first) first = false; else td.tx(", "); 
        td.tx(c.primitiveValue()); // todo: make these a reference 
      } 
    } 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_STATUS), q.primitiveValue("status")); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_EXPER), q.primitiveValue("experimental")); 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_PUB), q.primitiveValue("date")); 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_APP), q.primitiveValue("approvalDate")); 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_REV_DATE), q.primitiveValue("lastReviewDate")); 
    if (q.has("effectivePeriod")) { 
      renderPeriod(status, defn(tbl, context.formatPhrase(RenderingContext.QUEST_EFF_PERIOD)), q.child("effectivePeriod")); 
    } 

    if (q.has("subjectType")) { 
      td = defn(tbl, context.formatPhrase(RenderingContext.QUEST_SUB_TYPE)); 
      boolean first = true; 
      for (ResourceElement c : q.children("subjectType")) { 
        if (first) first = false; else td.tx(", "); 
        td.tx(c.primitiveValue()); 
      } 
    } 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_DESC), q.primitiveValue("description")); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_PURPOSE), q.primitiveValue("purpose")); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_COPYRIGHT), q.primitiveValue("copyright")); 
    if (q.has("code")) { 
      td = defn(tbl, Utilities.pluralize("Code", q.children("code").size())); 
      boolean first = true; 
      for (ResourceElement c : q.children("code")) { 
        if (first) first = false; else td.tx(", "); 
        renderCodingWithDetails(status, td,  c); 
      } 
    } 
  } 

  private void renderDefinition(RenderingStatus status, XhtmlNode tbl, ResourceElement q, ResourceElement qi, List<ResourceElement> parents) throws IOException { 
    XhtmlNode td = tbl.tr().td("structure").colspan("2").span(null, null).attribute("class", "self-link-parent"); 
    td.an("item."+qi.primitiveValue("linkId")); 
    for (ResourceElement p : parents) { 
      td.ah("#item."+p.primitiveValue("linkId")).img(getImgPath("icon_q_item.png"), "icon"); 
      td.tx(" > "); 
    } 
    td.img(getImgPath("icon_q_item.png"), "icon"); 
    td.tx(" Item "); 
    td.b().tx(qi.primitiveValue("linkId")); 
    String type = qi.primitiveValue("type");

    // general information 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_ID), qi.primitiveValue("linkId")); 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_PREFIX), qi.primitiveValue("prefix")); 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_TEXT), qi.primitiveValue("text")); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_TYPE), type); 
    defn(tbl, context.formatPhrase(RenderingContext.GENERAL_REQUIRED), qi.primitiveValue("required")); 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_REP), qi.primitiveValue("repeats")); 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_READ_ONLY), qi.primitiveValue("readOnly")); 
    if ("true".equals(qi.extensionString("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-isSubject"))) { 
      defn(tbl, context.formatPhrase(RenderingContext.GENERAL_SUBJ), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-isSubject", "This element changes who the subject of the question is", null); 
    } 

    // content control 
    defn(tbl, context.formatPhrase(RenderingContext.QUEST_MAX_LENGTH), qi.primitiveValue("maxLength")); 
    if (qi.has("answerValueSet")) { 
      defn(tbl, context.formatPhrase(RenderingContext.GENERAL_VALUESET), qi.primitiveValue("definition"), context.getWorker().findTxResource(ValueSet.class,  qi.primitiveValue("answerValueSet"), q.getResourceNative())); 
    } 
    if (qi.has("answerOption")) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(context.formatPhrase(RenderingContext.QUEST_ALLOWED)); 
      XhtmlNode ul = tr.td().ul(); 
      for (ResourceElement ans : qi.children("answerOption")) { 
        XhtmlNode li = ul.li(); 
        renderDataType(status, li, ans.child("value")); 
        if ("true".equals(ans.primitiveValue("initialSelected"))) { 
          li.tx(" "+(context.formatPhrase(RenderingContext.QUEST_INITIALLY))); 
        } 
      }       
    } 
    if (qi.has("initial")) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(Utilities.pluralize((context.formatPhrase(RenderingContext.QUEST_INITIAL_ANSWER)), qi.children("initial").size())); 
      if (qi.children("initial").size() == 1) { 
        renderDataType(status, tr.td(), qi.firstChild("initial").child("value")); 
      } else { 
        XhtmlNode ul = tr.td().ul(); 
        for (ResourceElement ans : qi.children("initial")) { 
          XhtmlNode li = ul.li(); 
          renderDataType(status, li, ans.child("value")); 
        } 
      }       
    } 

    // appearance  
    if (qi.hasExtension(ToolingExtensions.EXT_Q_DISPLAY_CAT)) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().ah(ToolingExtensions.EXT_Q_DISPLAY_CAT).tx("Display Category"); 
      renderDataType(status, tr.td(), qi.extension(ToolingExtensions.EXT_Q_DISPLAY_CAT).child("value")); 
    } 
    if ("true".equals(qi.extensionString(ToolingExtensions.EXT_Q_HIDDEN))) { 
      defn(tbl, context.formatPhrase(RenderingContext.QUEST_HIDDEN_ITEM), ToolingExtensions.EXT_Q_DISPLAY_CAT, "This item is a hidden question", null); 
    } 
    if ("true".equals(qi.extensionString(ToolingExtensions.EXT_Q_OTP_DISP))) { 
      defn(tbl, context.formatPhrase(RenderingContext.QUEST_HIDDEN_ITEM), ToolingExtensions.EXT_Q_OTP_DISP, "This item is optional to display", null); 
    } 

    // formal definitions 
    if (qi.has("definition")) { 
      genDefinitionLink(defn(tbl, context.formatPhrase(RenderingContext.GENERAL_DEFINITION)), qi, q); 
    } 

    if (qi.has("code")) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(Utilities.pluralize(context.formatPhrase(RenderingContext.GENERAL_CODE), qi.children("code").size())); 
      XhtmlNode ul = tr.td().ul(); 
      for (ResourceElement c : qi.children("code")) { 
        renderCodingWithDetails(status, ul.li(), c); 
      } 
    } 
    if (qi.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod")) { 
      XhtmlNode tr = tbl.tr(); 
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, ToolingExtensions.EXT_O_LINK_PERIOD); 
      if (sd != null && sd.hasWebPath()) { 
        tr.td().ah(sd.getWebPath()).tx(context.formatPhrase(RenderingContext.QUEST_OBSERVATION)); 
      } else { 
        tr.td().ah("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod").tx(context.formatPhrase(RenderingContext.QUEST_OBSERVATION)); 
      } 
      renderDataType(status, tr.td(), qi.extension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-ResourceElement-observationLinkPeriod").child("value")); 
    } 

    // dynamic management 
    if (qi.has("enableWhen")) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(context.formatPhrase(RenderingContext.QUEST_EN)); 
      td = tr.td(); 
      if (qi.children("enableWhen").size() == 1) { 
        renderEnableWhen(td, qi.children("enableWhen").get(0)); 
      } else { 
        if (qi.has("enableBehavior")) { 
          td.tx(qi.primitiveValue("enableBehavior")+" "+(context.formatPhrase(RenderingContext.QUEST_TRUE))); 
        } else { 
          td.tx(context.formatPhrase(RenderingContext.QUEST_ARE_TRUE)); 
        } 
        XhtmlNode ul = td.ul(); 
        for (ResourceElement ew : qi.children("enableWhen")) { 
          renderEnableWhen(ul.li(), ew); 
        } 
      }       
    } 


    // other stuff 



    List<ResourceElement> curr = new ArrayList<>(); 
    curr.addAll(parents); 
    curr.add(qi); 
    for (ResourceElement qic : qi.children("item")) { 
      renderDefinition(status, tbl, q, qic, curr); 
    }  
  } 

  private void defn(XhtmlNode tbl, String name, String url, Resource res) throws UnsupportedEncodingException, IOException { 
    if (res != null && res.hasWebPath()) { 
      defn(tbl, context.formatPhrase(RenderingContext.GENERAL_DEFINITION), RendererFactory.factory(res, context).displayResource(wrap(res)), res.getWebPath()); 
    } else if (Utilities.isAbsoluteUrlLinkable(url)) { 
      defn(tbl, context.formatPhrase(RenderingContext.GENERAL_DEFINITION), url, url); 
    } { 
      defn(tbl, context.formatPhrase(RenderingContext.GENERAL_DEFINITION), url); 
    } 

  } 

  private void renderEnableWhen(XhtmlNode x, ResourceElement ew) { 
    x.ah("#item."+ew.primitiveValue("question")).tx(ew.primitiveValue("question")); 
    x.tx(" "); 
    x.tx(ew.primitiveValue("operator")); 
    x.tx(" "); 
    x.tx(displayDataType(ew.child("Answer"))); 
  } 

  private XhtmlNode defn(XhtmlNode tbl, String name) { 
    XhtmlNode tr = tbl.tr(); 
    tr.td().tx(name); 
    return tr.td(); 
  } 

  private void defn(XhtmlNode tbl, String name, int value) { 
    if (value > 0) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(name); 
      tr.td().tx(value); 
    }     
  } 


  private void defn(XhtmlNode tbl, String name, boolean value) { 
    XhtmlNode tr = tbl.tr(); 
    tr.td().tx(name); 
    tr.td().tx(Boolean.toString(value)); 
  } 

  private void defn(XhtmlNode tbl, String name, String value) { 
    if (!Utilities.noString(value)) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(name); 
      tr.td().tx(value); 
    }     
  } 

  private void defn(XhtmlNode tbl, String name, String value, String url) { 
    if (!Utilities.noString(value)) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(name); 
      tr.td().ah(url).tx(value); 
    }     
  } 

  private void defn(XhtmlNode tbl, String name, String nurl, String value, String url) { 
    if (!Utilities.noString(value)) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().ah(nurl).tx(name); 
      if (url != null) { 
        tr.td().ah(url).tx(value); 
      } else { 
        tr.td().tx(value); 
      } 
    }     
  } 

  private void defn(XhtmlNode tbl, String name, boolean value, boolean ifFalse) { 
    if (ifFalse || value) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(name); 
      tr.td().tx(Boolean.toString(value)); 
    }     
  } 

} 
