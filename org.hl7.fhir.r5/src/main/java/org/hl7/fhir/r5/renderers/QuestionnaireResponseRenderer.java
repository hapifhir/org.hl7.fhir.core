package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.QuestionnaireResponse;
import org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent;
import org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class QuestionnaireResponseRenderer extends ResourceRenderer {

  public QuestionnaireResponseRenderer(RenderingContext context) {
    super(context);
  }
  
  public boolean render(XhtmlNode x, Resource q) throws UnsupportedEncodingException, IOException {
    return render(x, (QuestionnaireResponse) q);
  }
  
  public boolean render(XhtmlNode x, QuestionnaireResponse q) throws UnsupportedEncodingException, IOException {
    switch (context.getQuestionnaireMode()) {
    case FORM:  return renderForm(x, q);
    case LINKS: return renderLinks(x, q);
//    case LOGIC: return renderLogic(x, q);
//    case DEFNS: return renderDefns(x, q);
    case TREE:  return renderTree(x, q);
    default:
      throw new Error("Unknown QuestionnaireResponse Renderer Mode");
    }
  }
  
  public boolean render(XhtmlNode x, ResourceWrapper qr) throws UnsupportedEncodingException, IOException {
    switch (context.getQuestionnaireMode()) {
    case FORM:  return renderTree(x, qr);
    case LINKS: return renderLinks(x, qr);
//    case LOGIC: return renderLogic(x, q);
//    case DEFNS: return renderDefns(x, q);
    case TREE:  return renderTree(x, qr);
    default:
      throw new Error("Unknown QuestionnaireResponse Renderer Mode");
    }
  }
  
  public boolean renderTree(XhtmlNode x, ResourceWrapper qr) throws UnsupportedEncodingException, IOException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context.getDestDir(), context.isInlineGraphics(), true);
    TableModel model = gen.new TableModel("qtree="+qr.getId(), false);    
    model.setAlternating(true);
    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) {
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());   
    } else {
      model.setDocoImg(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "help16.png"));
    }
    model.setDocoRef(context.getLink(KnownLinkType.SPEC)+"formats.html#table");
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "LinkId"), translate("sd.hint", "The linkId for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Text"), translate("sd.hint", "Text for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Definition"), translate("sd.hint", "Minimum and Maximum # of times the the itemcan appear in the instance"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Answer"), translate("sd.hint", "The type of the item"), null, 0));

    boolean hasExt = false;
    // first we add a root for the questionaire itself
    Row row = addTreeRoot(gen, model.getRows(), qr);
    List<BaseWrapper> items = qr.children("item");
    for (BaseWrapper i : items) {
      hasExt = renderTreeItem(gen, row.getSubRows(), qr, i) || hasExt;
    }
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null);
    x.getChildNodes().add(xn);
    return hasExt;
  }

  public boolean renderTree(XhtmlNode x, QuestionnaireResponse q) throws UnsupportedEncodingException, IOException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context.getDestDir(), context.isInlineGraphics(), true);
    TableModel model = gen.new TableModel("qtree="+q.getId(), true);    
    model.setAlternating(true);
    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) {
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());      
    } else {
      model.setDocoImg(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "help16.png"));
    }
    model.setDocoRef(context.getLink(KnownLinkType.SPEC)+"formats.html#table");
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "LinkId"), translate("sd.hint", "The linkId for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Text"), translate("sd.hint", "Text for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Definition"), translate("sd.hint", "Minimum and Maximum # of times the the itemcan appear in the instance"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Answer"), translate("sd.hint", "The type of the item"), null, 0));

    boolean hasExt = false;
    // first we add a root for the questionaire itself
    Row row = addTreeRoot(gen, model.getRows(), q);
    for (QuestionnaireResponseItemComponent i : q.getItem()) {
      hasExt = renderTreeItem(gen, row.getSubRows(), q, i) || hasExt;
    }
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null);
    x.getChildNodes().add(xn);
    return hasExt;
  }



  private Row addTreeRoot(HierarchicalTableGenerator gen, List<Row> rows, QuestionnaireResponse q) throws IOException {
    Row r = gen.new Row();
    rows.add(r);

    r.setIcon("icon_q_root.gif", "QuestionnaireResponseRoot");
    r.getCells().add(gen.new Cell(null, null, q.getId(), null, null));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    r.getCells().add(gen.new Cell(null, null, "QuestionnaireResponse", null, null));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    return r;    
  }

  private Row addTreeRoot(HierarchicalTableGenerator gen, List<Row> rows, ResourceWrapper q) throws IOException {
    Row r = gen.new Row();
    rows.add(r);

    r.setIcon("icon_q_root.gif", "QuestionnaireResponseRoot");
    r.getCells().add(gen.new Cell(null, null, q.getId(), null, null));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    r.getCells().add(gen.new Cell(null, null, "QuestionnaireResponse", null, null));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    return r;    
  }



  private boolean renderTreeItem(HierarchicalTableGenerator gen, List<Row> rows, ResourceWrapper q, BaseWrapper i) throws IOException {
    Row r = gen.new Row();
    rows.add(r);
    boolean hasExt = false;

    List<BaseWrapper> items = i.children("item");
    List<BaseWrapper> answers = i.children("answer");
    boolean hasItem = items != null && !items.isEmpty();
    if (answers != null) {
      for (BaseWrapper a : answers) {
        hasItem = a.has("item");
      }
    }
    if (hasItem) {
      r.setIcon("icon-q-group.png", "Group");
    } else {
      r.setIcon("icon-q-string.png", "Item");
    }
    String linkId = i.has("linkId") ? i.get("linkId").primitiveValue() : "??";
    String text = i.has("text") ? i.get("text").primitiveValue() : "";
    r.getCells().add(gen.new Cell(null, context.getDefinitionsTarget() == null ? "" : context.getDefinitionsTarget()+"#item."+linkId, linkId, null, null));
    r.getCells().add(gen.new Cell(null, null, text, null, null));
    r.getCells().add(gen.new Cell(null, null, null, null, null));
    if (answers == null ||  answers.size() == 0) {
      r.getCells().add(gen.new Cell(null, null, null, null, null));
      if (items != null) {
        for (BaseWrapper si : items) {
          renderTreeItem(gen, r.getSubRows(), q, si);
        }
      }
    } else if (answers.size() == 1) {
      BaseWrapper ans = answers.get(0);
      renderAnswer(gen, q, r, ans);
    } else {
      r.getCells().add(gen.new Cell(null, null, null, null, null));          
      for (BaseWrapper ans : answers) {
        Row ar = gen.new Row();
        ar.setIcon("icon-q-string.png", "Item");
        ar.getSubRows().add(ar);
        ar.getCells().add(gen.new Cell(null, null, null, null, null));
        ar.getCells().add(gen.new Cell(null, null, text, null, null));
        ar.getCells().add(gen.new Cell(null, null, null, null, null));
        renderAnswer(gen, q, ar, ans);
      }
    }

    return hasExt;    
  }

  public void renderAnswer(HierarchicalTableGenerator gen, ResourceWrapper q, Row r, BaseWrapper ans) throws UnsupportedEncodingException, IOException {
    List<BaseWrapper> items;
    Base b = ans.get("value[x]");
    if (b == null) {
      r.getCells().add(gen.new Cell(null, null, "null!", null, null));
    } else if (b.isPrimitive()) {
      r.getCells().add(gen.new Cell(null, null, b.primitiveValue(), null, null));
    } else {
      XhtmlNode x = new XhtmlNode(NodeType.Element, "span");
      Cell cell = gen.new Cell(null, null, null, null, null);
      Piece p = gen.new Piece("span");
      p.getChildren().add(x);
      cell.addPiece(p);
      render(x, (DataType) b);
      r.getCells().add(cell);
    }
    items = ans.children("item");
    for (BaseWrapper si : items) {
      renderTreeItem(gen, r.getSubRows(), q, si);
    }
  }
  
  private boolean renderTreeItem(HierarchicalTableGenerator gen, List<Row> rows, QuestionnaireResponse q, QuestionnaireResponseItemComponent i) throws IOException {
    Row r = gen.new Row();
    rows.add(r);
    boolean hasExt = false;

    boolean hasItem = i.hasItem();
    for (QuestionnaireResponseItemAnswerComponent a : i.getAnswer()) {
      hasItem = a.hasItem();
    }
    if (hasItem) {
      r.setIcon("icon-q-group.png", "Group");
    } else {
      r.setIcon("icon-q-string.png", "Item");
    }
    r.getCells().add(gen.new Cell(null, context.getDefinitionsTarget() == null ? "" : context.getDefinitionsTarget()+"#item."+i.getLinkId(), i.getLinkId(), null, null));
    r.getCells().add(gen.new Cell(null, null, i.getText(), null, null));
    r.getCells().add(gen.new Cell(null, null, null, null, null));
    r.getCells().add(gen.new Cell(null, null, null, null, null));

    return hasExt;    
  }

  public void genDefinitionLink(HierarchicalTableGenerator gen, QuestionnaireResponseItemComponent i, Cell defn, Resource src) {
    // can we resolve the definition? 
    String path = null;
    String d = i.getDefinition();
    if (d.contains("#")) {
      path = d.substring(d.indexOf("#")+1);
      d = d.substring(0, d.indexOf("#"));
    }
    StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, d, src);
    if (sd != null) {
      String url = sd.getWebPath();
      if (url != null) {
        defn.getPieces().add(gen.new Piece(url+"#"+path, path, null));          
      } else {
        defn.getPieces().add(gen.new Piece(null, i.getDefinition(), null));
      }
    } else {
      defn.getPieces().add(gen.new Piece(null, i.getDefinition(), null));
    }
  }

  public void genDefinitionLink(XhtmlNode x, QuestionnaireResponseItemComponent i, Resource src) {
    // can we resolve the definition? 
    String path = null;
    String d = i.getDefinition();
    if (d.contains("#")) {
      path = d.substring(d.indexOf("#")+1);
      d = d.substring(0, d.indexOf("#"));
    }
    StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, d, src);
    if (sd != null) {
      String url = sd.getWebPath();
      if (url != null) {
        x.ah(url+"#"+path).tx(path);          
      } else {
        x.tx(i.getDefinition());
      }
    } else {
      x.tx(i.getDefinition());
    }
  }

  private void addExpression(Piece p, Expression exp, String label, String url) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "li").style("font-size: 11px");
    p.addHtml(x);
    x.ah(url).tx(label);
    x.tx(": ");
    x.code(exp.getExpression());
  }

  public boolean renderForm(XhtmlNode x, QuestionnaireResponse q) throws UnsupportedEncodingException, IOException {
    boolean hasExt = false;
//    XhtmlNode d = x.div();
//    boolean hasPrefix = false;
//    for (QuestionnaireItemComponent c : q.getItem()) {
//      hasPrefix = hasPrefix || doesItemHavePrefix(c);
//    }
//    int i = 1;
//    for (QuestionnaireItemComponent c : q.getItem()) {
//      hasExt = renderFormItem(d, q, c, hasPrefix ? null : Integer.toString(i), 0) || hasExt;
//      i++;
//    }
//    return hasExt; 
//  }
//
//  private boolean doesItemHavePrefix(QuestionnaireItemComponent i) {
//    if (i.hasPrefix()) {
//      return true;
//    }
//    for (QuestionnaireItemComponent c : i.getItem()) {
//      if (doesItemHavePrefix(c)) {
//        return true;
//      }
//    }
    return false;
  }

  public boolean renderForm(XhtmlNode x, ResourceWrapper q) throws UnsupportedEncodingException, IOException {
    boolean hasExt = false;
    XhtmlNode d = x.div();
    d.tx("todo");
//    boolean hasPrefix = false;
//    for (QuestionnaireItemComponent c : q.getItem()) {
//      hasPrefix = hasPrefix || doesItemHavePrefix(c);
//    }
//    int i = 1;
//    for (QuestionnaireItemComponent c : q.getItem()) {
//      hasExt = renderFormItem(d, q, c, hasPrefix ? null : Integer.toString(i), 0) || hasExt;
//      i++;
//    }
//    return hasExt; 
//  }
//
//  private boolean doesItemHavePrefix(QuestionnaireItemComponent i) {
//    if (i.hasPrefix()) {
//      return true;
//    }
//    for (QuestionnaireItemComponent c : i.getItem()) {
//      if (doesItemHavePrefix(c)) {
//        return true;
//      }
//    }
    return hasExt;
  }

//  private boolean renderFormItem(XhtmlNode x, QuestionnaireResponse q, QuestionnaireItemComponent i, String pfx, int indent) throws IOException {
//    boolean hasExt = false;
//    XhtmlNode d = x.div().style("width: "+Integer.toString(900-indent*10)+"px; border-top: 1px #eeeeee solid");
//    if (indent > 0) {
//      d.style("margin-left: "+Integer.toString(10*indent)+"px");
//    }
//    XhtmlNode display = d.div().style("display: inline-block; width: "+Integer.toString(500-indent*10)+"px");
//    XhtmlNode details = d.div().style("border: 1px #ccccff solid; padding: 2px; display: inline-block; background-color: #fefce7; width: 380px");
//    XhtmlNode p = display.para();
//    if (i.getType() == QuestionnaireItemType.GROUP) {
//      p = p.b();
//    }
//    if (i.hasPrefix()) {
//      p.tx(i.getPrefix());
//      p.tx(": ");
//    }
//    p.span(null, "linkId: "+i.getLinkId()).tx(i.getText());
//    if (i.getRequired()) {
//      p.span("color: red", "Mandatory").tx("*");
//    }
//
//    XhtmlNode input = null;
//    switch (i.getType()) {
//    case STRING:
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "text", i.getType().getDisplay(), 60);
//      break;
//    case ATTACHMENT:
//      break;
//    case BOOLEAN:
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "checkbox", i.getType().getDisplay(), 1);
//      break;
//    case CHOICE:
//      input = p.select(i.getLinkId());
//      listOptions(q, i, input);
//      break;
//    case DATE:
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "date", i.getType().getDisplay(), 10);
//      break;
//    case DATETIME:
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "datetime-local", i.getType().getDisplay(), 25);
//      break;
//    case DECIMAL:
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "number", i.getType().getDisplay(), 15);
//      break;
//    case DISPLAY:
//      break;
//    case GROUP:
//      
//      break;
//    case INTEGER:
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "number", i.getType().getDisplay(), 10);
//      break;
//    case OPENCHOICE:
//      break;
//    case QUANTITY:
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "number", "value", 15);
//      p.tx(" ");
//      input = p.input(i.getLinkId(), "unit", "unit", 10);
//      break;
//    case QUESTION:
//      break;
//    case REFERENCE:
//      break;
//    case TEXT:
//      break;
//    case TIME:
//      break;
//    case URL:
//      break;
//    default:
//      break;
//    }
//    if (input != null) {
//      if (i.getReadOnly()) {
//        input.attribute("readonly", "1");
//        input.style("background-color: #eeeeee");
//      }
//    }
//    
////  if (i.hasExtension(" http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-choiceOrientation")) {
////  String code = ToolingExtensions.readStringExtension(i,  "http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-choiceOrientation");
////  flags.addPiece(gen.new Piece("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-observationLinkPeriod", null, "Orientation: "+code).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("alt", "icon").attribute("src", Utilities.path(context.getLocalPrefix(), "icon-qi-"+code+".png"))));
////}
//
//    
//    XhtmlNode ul = details.ul();
//    boolean hasFlag = false; 
//    XhtmlNode flags = item(ul, "Flags");
//    item(ul, "linkId", i.getLinkId());
//    
//    if (ToolingExtensions.readBoolExtension(i, "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-isSubject")) {
//      hasFlag = true;
//      flags.ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-isSubject", "Can change the subject of the QuestionnaireResponse").img(Utilities.path(context.getLocalPrefix(), "icon-qi-subject.png"));
//    }
//    if (ToolingExtensions.readBoolExtension(i, "http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-hidden")) {
//      hasFlag = true;
//      flags.ah(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "extension-QuestionnaireResponse-hidden.html"), "Is a hidden item").img(Utilities.path(context.getLocalPrefix(), "icon-qi-hidden.png"));
//      d.style("background-color: #eeeeee");
//    }
//    if (ToolingExtensions.readBoolExtension(i, "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-optionalDisplay")) {
//      hasFlag = true;
//      flags.ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-optionalDisplay", "Is optional to display").img(Utilities.path(context.getLocalPrefix(), "icon-qi-optional.png"));
//    }
//    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-observationLinkPeriod")) {
//      hasFlag = true;
//      flags.ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-observationLinkPeriod", "Is linked to an observation").img(Utilities.path(context.getLocalPrefix(), "icon-qi-observation.png"));
//    }
//    if (i.hasExtension(" http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-displayCategory")) {
//      CodeableConcept cc = i.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-displayCategory").getValueCodeableConcept();
//      String code = cc.getCode("http://hl7.org/fhir/QuestionnaireResponse-display-category");
//      hasFlag = true;
//      flags.ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-displayCategory", "Category: "+code).img(Utilities.path(context.getLocalPrefix(), "icon-qi-"+code+".png"));
//    }
//
//    if (i.hasMaxLength()) {
//      item(ul, "Max Length", Integer.toString(i.getMaxLength()));
//    }
//    if (i.hasDefinition()) {
//      genDefinitionLink(item(ul, "Definition"), i);      
//    }
//    if (i.hasEnableWhen()) {
//      item(ul, "Enable When", "todo");
//    }
//    if (i.hasAnswerValueSet()) {
//      XhtmlNode ans = item(ul, "Answers");
//      if (i.getAnswerValueSet().startsWith("#")) {
//        ValueSet vs = (ValueSet) q.getContained(i.getAnswerValueSet().substring(1));
//        if (vs == null) {
//          ans.tx(i.getAnswerValueSet());                    
//        } else {
//          ans.ah(vs.getWebPath()).tx(vs.present());                              
//        }
//      } else {
//        ValueSet vs = context.getWorker().fetchResource(ValueSet.class, i.getAnswerValueSet());
//        if (vs == null  || !vs.hasWebPath()) {
//          ans.tx(i.getAnswerValueSet());                    
//        } else {
//          ans.ah(vs.getWebPath()).tx(vs.present());                              
//        }             
//      }
//    }
//    if (i.hasAnswerOption()) {
//      item(ul, "Answers", Integer.toString(i.getAnswerOption().size())+" "+Utilities.pluralize("option", i.getAnswerOption().size()), context.getDefinitionsTarget()+"#item."+i.getLinkId());
//    }
//    if (i.hasInitial()) {
//      XhtmlNode vi = item(ul, "Initial Values");
//      boolean first = true;
//      for (QuestionnaireItemInitialComponent v : i.getInitial()) {
//        if (first) first = false; else vi.tx(", ");
//        if (v.getValue().isPrimitive()) {
//          vi.tx(v.getValue().primitiveValue());
//        } else {
//          vi.tx("{todo}");          
//        }
//      }
//    }
//    if (!hasFlag) {
//      ul.remove(flags);
//    }
////    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-enableWhenExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-itemContext") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-calculatedExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-contextExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-candidateExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-initialExpression")) {
////      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
////      defn.getPieces().add(gen.new Piece(null, "Expressions: ", null));
////      Piece p = gen.new Piece("ul");
////      defn.getPieces().add(p);
////      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-initialExpression")) {
////        addExpression(p, e.getValueExpression(), "Initial Value", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-initialExpression");
////      }
////      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-contextExpression")) {
////        addExpression(p, e.getValueExpression(), "Context", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-contextExpression");
////      }
////      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-itemContext")) {
////        addExpression(p, e.getValueExpression(), "Item Context", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-itemContext");
////      }
////      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-enableWhenExpression")) {
////        addExpression(p, e.getValueExpression(), "Enable When", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-enableWhenExpression");
////      }
////      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-calculatedExpression")) {
////        addExpression(p, e.getValueExpression(), "Calculated Value", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-calculatedExpression");
////      }
////      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-candidateExpression")) {
////        addExpression(p, e.getValueExpression(), "Candidates", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-candidateExpression");
////      } 
////    }
////
//
//    int t = 1;
//    for (QuestionnaireItemComponent c : i.getItem()) {
//      hasExt = renderFormItem(x, q, c, pfx == null ? null : pfx+"."+Integer.toString(t), indent+1) || hasExt;
//      t++;
//    }
//    return hasExt; 
//  }
//
//  private void item(XhtmlNode ul, String name, String value, String valueLink) {
//    if (!Utilities.noString(value)) {
//      ul.li().style("font-size: 10px").ah(valueLink).tx(name+": "+value);
//    }
//  }
//
//  private void item(XhtmlNode ul, String name, String value) {
//    if (!Utilities.noString(value)) {
//      ul.li().style("font-size: 10px").tx(name+": "+value);
//    }
//  }
//  private XhtmlNode item(XhtmlNode ul, String name) {
//    XhtmlNode li = ul.li();
//    li.style("font-size: 10px").tx(name+": ");
//    return li;
//  }
//
//
//  private void listOptions(QuestionnaireResponse q, QuestionnaireItemComponent i, XhtmlNode select) {
//    if (i.hasAnswerValueSet()) {
//      ValueSet vs = null;
//      if (i.getAnswerValueSet().startsWith("#")) {
//        vs = (ValueSet) q.getContained(i.getAnswerValueSet().substring(1)).copy();
//        if (vs != null && !vs.hasUrl()) {
//          vs.setUrl("urn:uuid:"+UUID.randomUUID().toString().toLowerCase());
//        }
//      } else {
//        vs = context.getContext().fetchResource(ValueSet.class, i.getAnswerValueSet());
//      }
//      if (vs != null) {
//        ValueSetExpansionOutcome exp = context.getContext().expandVS(vs, true, false);
//        if (exp.getValueset() != null) {
//          for (ValueSetExpansionContainsComponent cc : exp.getValueset().getExpansion().getContains()) {
//            select.option(cc.getCode(), cc.hasDisplay() ? cc.getDisplay() : cc.getCode(), false);    
//          }
//          return;
//        }
//      }
//    } else if (i.hasAnswerOption()) {
//      
//    } 
//    select.option("a", "??", false);    
//  }
//
//  public String display(Resource dr) throws UnsupportedEncodingException, IOException {
//    return display((QuestionnaireResponse) dr);
//  }
//
//  public String display(QuestionnaireResponse q) throws UnsupportedEncodingException, IOException {
//    return "QuestionnaireResponse "+q.present();
//  }
// 
  private boolean renderLinks(XhtmlNode x, QuestionnaireResponse q) {
    x.para().tx("Try this QuestionnaireResponse out:");
    XhtmlNode ul = x.ul();
    ul.li().ah("http://todo.nlm.gov/path?mode=ig&src="+Utilities.pathURL(context.getLink(KnownLinkType.SELF), "package.tgz")+"&q="+q.getId()+".json").tx("NLM Forms Library");
    return false;
  }

  private boolean renderLinks(XhtmlNode x, ResourceWrapper q) {
    x.para().tx("Try this QuestionnaireResponse out:");
    XhtmlNode ul = x.ul();
    ul.li().ah("http://todo.nlm.gov/path?mode=ig&src="+Utilities.pathURL(context.getLink(KnownLinkType.SELF), "package.tgz")+"&q="+q.getId()+".json").tx("NLM Forms Library");
    return false;
  }

//  private boolean renderDefns(XhtmlNode x, QuestionnaireResponse q) throws IOException {
//    XhtmlNode tbl = x.table("dict");
//    boolean ext = false;
//    ext = renderRootDefinition(tbl, q, new ArrayList<>()) || ext;
//    for (QuestionnaireItemComponent qi : q.getItem()) {
//      ext = renderDefinition(tbl, q, qi, new ArrayList<>()) || ext;
//    }
//    return ext;
//  }
//
//  private boolean renderRootDefinition(XhtmlNode tbl, QuestionnaireResponse q, List<QuestionnaireItemComponent> parents) throws IOException {
//    boolean ext = false;
//    XhtmlNode td = tbl.tr().td("structure").colspan("2").span(null, null).attribute("class", "self-link-parent");
//    td.an(q.getId());
//    td.img(Utilities.path(context.getLocalPrefix(), "icon_q_root.gif"));
//    td.tx(" QuestionnaireResponse ");
//    td.b().tx(q.getId());
//    
//    // general information
//    defn(tbl, "URL", q.getUrl());
//    defn(tbl, "Version", q.getVersion());
//    defn(tbl, "Name", q.getName());
//    defn(tbl, "Title", q.getTitle());
//    if (q.hasDerivedFrom()) {
//      td = defn(tbl, "Derived From");
//      boolean first = true;
//      for (CanonicalType c : q.getDerivedFrom()) {
//        if (first) first = false; else td.tx(", ");
//        td.tx(c.asStringValue()); // todo: make these a reference
//      }
//    }
//    defn(tbl, "Status", q.getStatus().getDisplay());
//    defn(tbl, "Experimental", q.getExperimental());
//    defn(tbl, "Publication Date", q.getDateElement().primitiveValue());
//    defn(tbl, "Approval Date", q.getApprovalDateElement().primitiveValue());
//    defn(tbl, "Last Review Date", q.getLastReviewDateElement().primitiveValue());
//    if (q.hasEffectivePeriod()) {
//      renderPeriod(defn(tbl, "Effective Period"), q.getEffectivePeriod());
//    }
//    
//    if (q.hasSubjectType()) {
//      td = defn(tbl, "Subject Type");
//      boolean first = true;
//      for (CodeType c : q.getSubjectType()) {
//        if (first) first = false; else td.tx(", ");
//        td.tx(c.asStringValue());
//      }
//    }
//    defn(tbl, "Description", q.getDescription());
//    defn(tbl, "Purpose", q.getPurpose());
//    defn(tbl, "Copyright", q.getCopyright());
//    if (q.hasCode()) {
//      td = defn(tbl, Utilities.pluralize("Code", q.getCode().size()));
//      boolean first = true;
//      for (Coding c : q.getCode()) {
//        if (first) first = false; else td.tx(", ");
//        renderCodingWithDetails(td,  c);
//      }
//    }
//    return false;
//  }
  
//  private boolean renderDefinition(XhtmlNode tbl, QuestionnaireResponse q, QuestionnaireItemComponent qi, List<QuestionnaireItemComponent> parents) throws IOException {
//    boolean ext = false;
//    XhtmlNode td = tbl.tr().td("structure").colspan("2").span(null, null).attribute("class", "self-link-parent");
//    td.an("item."+qi.getLinkId());
//    for (QuestionnaireItemComponent p : parents) {
//      td.ah("#item."+p.getLinkId()).img(Utilities.path(context.getLocalPrefix(), "icon_q_item.png"));
//      td.tx(" > ");
//    }
//    td.img(Utilities.path(context.getLocalPrefix(), "icon_q_item.png"));
//    td.tx(" Item ");
//    td.b().tx(qi.getLinkId());
//    
//    // general information
//    defn(tbl, "Link Id", qi.getLinkId());
//    defn(tbl, "Prefix", qi.getPrefix());
//    defn(tbl, "Text", qi.getText());
//    defn(tbl, "Type", qi.getType().getDisplay());
//    defn(tbl, "Required", qi.getRequired(), true);
//    defn(tbl, "Repeats", qi.getRepeats(), true);
//    defn(tbl, "Read Only", qi.getReadOnly(), false);
//    if (ToolingExtensions.readBoolExtension(qi, "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-isSubject")) {
//      defn(tbl, "Subject", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-isSubject", "This element changes who the subject of the question is", null);
//    }
//    
//    // content control
//    defn(tbl, "Max Length", qi.getMaxLength());
//    if (qi.hasAnswerValueSet()) {
//      defn(tbl, "Value Set", qi.getDefinition(), context.getWorker().fetchResource(ValueSet.class,  qi.getAnswerValueSet()));
//    }
//    if (qi.hasAnswerOption()) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx("Allowed Answers");
//      XhtmlNode ul = tr.td().ul();
//      for (QuestionnaireItemAnswerOptionComponent ans : qi.getAnswerOption()) {
//        XhtmlNode li = ul.li();
//        render(li, ans.getValue());
//        if (ans.getInitialSelected()) {
//          li.tx(" (initially selected)");
//        }
//      }      
//    }
//    if (qi.hasInitial()) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx(Utilities.pluralize("Initial Answer", qi.getInitial().size()));
//      if (qi.getInitial().size() == 1) {
//        render(tr.td(), qi.getInitialFirstRep().getValue());
//      } else {
//        XhtmlNode ul = tr.td().ul();
//        for (QuestionnaireItemInitialComponent ans : qi.getInitial()) {
//          XhtmlNode li = ul.li();
//          render(li, ans.getValue());
//        }
//      }      
//    }
//
//    // appearance 
//    if (qi.hasExtension(" http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-displayCategory")) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().ah("http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-displayCategory").tx("Display Category");
//      render(tr.td(), qi.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-displayCategory").getValue());
//    }
//    if (ToolingExtensions.readBoolExtension(qi, "http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-hidden")) {
//      defn(tbl, "Hidden Item", "http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse-displayCategory", "This item is a hidden question", null);
//    }
//    if (ToolingExtensions.readBoolExtension(qi, "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-optionalDisplay")) {
//      defn(tbl, "Hidden Item", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-optionalDisplay", "This item is optional to display", null);
//    }
//    
//    // formal definitions
//    if (qi.hasDefinition()) {
//      genDefinitionLink(defn(tbl, "Definition"), qi);
//    }
//      
//    if (qi.hasCode()) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx(Utilities.pluralize("Code", qi.getCode().size()));
//      XhtmlNode ul = tr.td().ul();
//      for (Coding c : qi.getCode()) {
//        renderCodingWithDetails(ul.li(), c);
//      }
//    }
//    if (qi.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-observationLinkPeriod")) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().ah(getSDCLink("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-observationLinkPeriod").tx("Observation Link Period");
//      render(tr.td(), qi.getExtensionByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-QuestionnaireResponse-observationLinkPeriod").getValue());
//    }
//    
//    // dynamic management
//    if (qi.hasEnableWhen()) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx("Enable When");
//      td = tr.td();
//      if (qi.getEnableWhen().size() == 1) {
//        renderEnableWhen(td, qi.getEnableWhen().get(0));
//      } else {
//        td.tx(qi.getEnableBehavior().getDisplay()+" are true:");
//        XhtmlNode ul = td.ul();
//        for (QuestionnaireItemEnableWhenComponent ew : qi.getEnableWhen()) {
//          renderEnableWhen(ul.li(), ew);
//        }
//      }      
//    }
//    
//    
//    // other stuff
//    
//
//    
//    List<QuestionnaireItemComponent> curr = new ArrayList<>();
//    curr.addAll(parents);
//    curr.add(qi);
//    for (QuestionnaireItemComponent qic : qi.getItem()) {
//      ext = renderDefinition(tbl, q, qic, curr) || ext;
//    }
//    return ext;
//  }
//
//  private void defn(XhtmlNode tbl, String name, String url, Resource res) throws UnsupportedEncodingException, IOException {
//    if (res != null && res.hasWebPath()) {
//      defn(tbl, "Definition", RendererFactory.factory(res, context).display(res), res.getWebPath());
//    } else if (Utilities.isAbsoluteUrl(url)) {
//      defn(tbl, "Definition", url, url);
//    } {
//      defn(tbl, "Definition", url);
//    }
// 
//  }
//
//  private void renderEnableWhen(XhtmlNode x, QuestionnaireItemEnableWhenComponent ew) {
//    x.ah("#item."+ew.getQuestion()).tx(ew.getQuestion());
//    x.tx(" ");
//    x.tx(ew.getOperator().toCode());
//    x.tx(" ");
//    x.tx(display(ew.getAnswer()));
//  }
//
//  private XhtmlNode defn(XhtmlNode tbl, String name) {
//    XhtmlNode tr = tbl.tr();
//    tr.td().tx(name);
//    return tr.td();
//  }
//  
//  private void defn(XhtmlNode tbl, String name, int value) {
//    if (value > 0) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx(name);
//      tr.td().tx(value);
//    }    
//  }
// 
//  
//  private void defn(XhtmlNode tbl, String name, boolean value) {
//    XhtmlNode tr = tbl.tr();
//    tr.td().tx(name);
//    tr.td().tx(Boolean.toString(value));
//  }
// 
//  private void defn(XhtmlNode tbl, String name, String value) {
//    if (!Utilities.noString(value)) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx(name);
//      tr.td().tx(value);
//    }    
//  }
//  
//  private void defn(XhtmlNode tbl, String name, String value, String url) {
//    if (!Utilities.noString(value)) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx(name);
//      tr.td().ah(url).tx(value);
//    }    
//  }
//
//  private void defn(XhtmlNode tbl, String name, String nurl, String value, String url) {
//    if (!Utilities.noString(value)) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().ah(nurl).tx(name);
//      if (url != null) {
//        tr.td().ah(url).tx(value);
//      } else {
//        tr.td().tx(value);
//      }
//    }    
//  }
//
//  private void defn(XhtmlNode tbl, String name, boolean value, boolean ifFalse) {
//    if (ifFalse || value) {
//      XhtmlNode tr = tbl.tr();
//      tr.td().tx(name);
//      tr.td().tx(Boolean.toString(value));
//    }    
//  }


  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return "todo";
  }

  @Override
  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return "Not done yet";
  }

}