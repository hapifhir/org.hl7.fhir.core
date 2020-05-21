package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class QuestionnaireRenderer extends TerminologyRenderer {
  
  private boolean tree = false;
  
  public QuestionnaireRenderer(RenderingContext context) {
    super(context);
  }

  public boolean isTree() {
    return tree;
  }

  public void setTree(boolean tree) {
    this.tree = tree;
  }

  public boolean render(XhtmlNode x, DomainResource q) throws UnsupportedEncodingException, IOException {
    return render(x, (Questionnaire) q);
  }
  
  public boolean render(XhtmlNode x, Questionnaire q) throws UnsupportedEncodingException, IOException {
    if (tree) {
      return renderTree(x, q);
    } else {
      return renderForm(x, q);      
    }
  }
  
  public boolean renderTree(XhtmlNode x, Questionnaire q) throws UnsupportedEncodingException, IOException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context.getDestDir(), context.isInlineGraphics(), true);
    TableModel model = gen.new TableModel("qtree="+q.getId(), true);    
    model.setAlternating(true);
    model.setDocoImg(context.getPrefix() +"help16.png");
    model.setDocoRef(context.getPrefix()+"formats.html#table");
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "LinkId"), translate("sd.hint", "The linkId for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Text"), translate("sd.hint", "Text for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Cardinality"), translate("sd.hint", "Minimum and Maximum # of times the the itemcan appear in the instance"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Type"), translate("sd.hint", "The type of the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Flags"), translate("sd.hint", "Other attributes of the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Description & Constraints"), translate("sd.hint", "Additional information about the item"), null, 0));

    boolean hasExt = false;
    for (QuestionnaireItemComponent i : q.getItem()) {
      hasExt = renderTreeItem(gen, model.getRows(), q, i) || hasExt;
    }
    XhtmlNode xn = gen.generate(model, context.getDestDir(), 1, null);
    x.getChildNodes().add(xn);
    return hasExt;
  }

  private boolean renderTreeItem(HierarchicalTableGenerator gen, List<Row> rows, Questionnaire q, QuestionnaireItemComponent i) throws IOException {
    Row r = gen.new Row();
    rows.add(r);
    boolean hasExt = false;

    r.setIcon("icon-q-"+i.getType().toCode()+".png", i.getType().getDisplay());
    r.getCells().add(gen.new Cell(null, context.getDefinitionsTarget() == null ? "" : context.getDefinitionsTarget()+"-definitions.html#extension."+i.getLinkId(), i.getLinkId(), null, null));
    String txt = (i.hasPrefix() ? i.getPrefix() + ". " : "") + i.getText();
    r.getCells().add(gen.new Cell(null, null, txt, null, null));
    r.getCells().add(gen.new Cell(null, null, (i.getRequired() ? "1" : "0")+".."+(i.getRepeats() ? "*" : "1"), null, null));
    r.getCells().add(gen.new Cell(null, context.getPrefix()+"codesystem-item-type.html#"+i.getType().toCode(), i.getType().toCode(), null, null));
    
    // flags:
    Cell flags = gen.new Cell();
    r.getCells().add(flags);
    if (i.getReadOnly()) {
      flags.addPiece(gen.new Piece(Utilities.pathURL(context.getPrefix(), "questionnaire-definitions.html#Questionnaire.item.readOnly"), null, "Is Readonly").addHtml(new XhtmlNode(NodeType.Element, "img").attribute("src", Utilities.path(context.getDestDir(), "icon-qi-readonly.png"))));
    }
    if (ToolingExtensions.readBoolExtension(i, "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-isSubject")) {
      flags.addPiece(gen.new Piece("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-isSubject", null, "Can change the subject of the questionnaire").addHtml(new XhtmlNode(NodeType.Element, "img").attribute("src", Utilities.path(context.getDestDir(), "icon-qi-subject.png"))));
    }
    if (ToolingExtensions.readBoolExtension(i, "http://hl7.org/fhir/StructureDefinition/questionnaire-hidden")) {
      flags.addPiece(gen.new Piece(Utilities.pathURL(context.getPrefix(), "extension-questionnaire-hidden.html"), null, "Is a hidden item").addHtml(new XhtmlNode(NodeType.Element, "img").attribute("src", Utilities.path(context.getDestDir(), "icon-qi-hidden.png"))));
    }
    if (ToolingExtensions.readBoolExtension(i, "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-optionalDisplay")) {
      flags.addPiece(gen.new Piece("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-optionalDisplay", null, "Is optional to display").addHtml(new XhtmlNode(NodeType.Element, "img").attribute("src", Utilities.path(context.getDestDir(), "icon-qi-optional.png"))));
    }
    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-observationLinkPeriod")) {
      flags.addPiece(gen.new Piece("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-observationLinkPeriod", null, "Is linked to an observation").addHtml(new XhtmlNode(NodeType.Element, "img").attribute("src", Utilities.path(context.getDestDir(), "icon-qi-observation.png"))));
    }
    if (i.hasExtension("http://hl7.org/fhir/StructureDefinition/questionnaire-choiceOrientation")) {
      String code = ToolingExtensions.readStringExtension(i,  "http://hl7.org/fhir/StructureDefinition/questionnaire-choiceOrientation");
      flags.addPiece(gen.new Piece("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-observationLinkPeriod", null, "Orientation: "+code).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("src", Utilities.path(context.getDestDir(), "icon-qi-"+code+".png"))));
    }
    if (i.hasExtension("http://hl7.org/fhir/StructureDefinition/questionnaire-displayCategory")) {
      CodeableConcept cc = i.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/questionnaire-displayCategory").getValueCodeableConcept();
      String code = cc.getCode("http://hl7.org/fhir/questionnaire-display-category");
      flags.addPiece(gen.new Piece("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-observationLinkPeriod", null, "Category: "+code).addHtml(new XhtmlNode(NodeType.Element, "img").attribute("src", Utilities.path(context.getDestDir(), "icon-qi-"+code+".png"))));
    }
    
    Cell defn = gen.new Cell();
    r.getCells().add(defn);

    if (i.hasMaxLength()) {
      defn.getPieces().add(gen.new Piece(null, "Max Length: ", null));
      defn.getPieces().add(gen.new Piece(null, Integer.toString(i.getMaxLength()), null));
    }
    if (i.hasDefinition()) {
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
      defn.getPieces().add(gen.new Piece(null, "Definition: ", null));
      defn.getPieces().add(gen.new Piece(null, i.getDefinition(), null));
      
    }
    if (i.hasEnableWhen()) {
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
      defn.getPieces().add(gen.new Piece(null, "Enable When: ", null));
      defn.getPieces().add(gen.new Piece(null, "todo", null));      
    }
    if (i.hasAnswerValueSet()) {
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
      defn.getPieces().add(gen.new Piece(null, "Value Set: ", null));
      if (i.getAnswerValueSet().startsWith("#")) {
        ValueSet vs = (ValueSet) q.getContained(i.getAnswerValueSet().substring(1));
        if (vs == null) {
          defn.getPieces().add(gen.new Piece(null, i.getAnswerValueSet(), null));                    
        } else {
          defn.getPieces().add(gen.new Piece("todo", vs.present(), null));                              
        }
      } else {
        ValueSet vs = context.getWorker().fetchResource(ValueSet.class, i.getAnswerValueSet());
        if (vs == null  || !vs.hasUserData("path")) {
          defn.getPieces().add(gen.new Piece(null, i.getAnswerValueSet(), null));                    
        } else {
          defn.getPieces().add(gen.new Piece(vs.getUserString("path"), vs.present(), null));                    
        }             
      }
    }
    if (i.hasAnswerOption()) {
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
      defn.getPieces().add(gen.new Piece(null, "Options: ", null));
      defn.getPieces().add(gen.new Piece(context.getDefinitionsTarget()+"#"+i.getLinkId(), Integer.toString(i.getAnswerOption().size())+" "+Utilities.pluralize("option", i.getAnswerOption().size()), null));            
    }
    if (i.hasInitial()) {
      for (QuestionnaireItemInitialComponent v : i.getInitial()) {
        if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
        defn.getPieces().add(gen.new Piece(null, "Initial Value: ", null));
        defn.getPieces().add(gen.new Piece(null, v.getValue().fhirType(), null));
        defn.getPieces().add(gen.new Piece(null, " = ", null));
        if (v.getValue().isPrimitive()) {
          defn.getPieces().add(gen.new Piece(null, v.getValue().primitiveValue(), null));
        } else {
          defn.getPieces().add(gen.new Piece(null, "{todo}", null));          
        }
      }
    }
    // still todo

//
//http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-choiceColumn
//
//http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-width
//http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-observationLinkPeriod
//http://hl7.org/fhir/StructureDefinition/questionnaire-itemControl
//http://hl7.org/fhir/StructureDefinition/questionnaire-sliderStepValue
    
    if (i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-enableWhenExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-itemContext") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-calculatedExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-contextExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-candidateExpression") || i.hasExtension("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-initialExpression")) {
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
      defn.getPieces().add(gen.new Piece(null, "Expressions: ", null));
      Piece p = gen.new Piece("ul");
      defn.getPieces().add(p);
      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-initialExpression")) {
        addExpression(p, e.getValueExpression(), "Initial Value", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-initialExpression");
      }
      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-contextExpression")) {
        addExpression(p, e.getValueExpression(), "Context", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-contextExpression");
      }
      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-itemContext")) {
        addExpression(p, e.getValueExpression(), "Item Context", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-itemContext");
      }
      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-enableWhenExpression")) {
        addExpression(p, e.getValueExpression(), "Enable When", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-enableWhenExpression");
      }
      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-calculatedExpression")) {
        addExpression(p, e.getValueExpression(), "Calculated Value", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-calculatedExpression");
      }
      for (Extension e : i.getExtensionsByUrl("http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-candidateExpression")) {
        addExpression(p, e.getValueExpression(), "Candidates", "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-candidateExpression");
      } 
    }

    for (QuestionnaireItemComponent c : i.getItem()) {
      hasExt = renderTreeItem(gen, r.getSubRows(), q, c) || hasExt;
    }
    return hasExt;
    
  }


  private void addExpression(Piece p, Expression exp, String label, String url) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "li").style("font-size: 11px");
    p.addHtml(x);
    x.ah(url).tx(label);
    x.tx(": ");
    x.code(exp.getExpression());
  }

  public boolean renderForm(XhtmlNode x, Questionnaire q) throws UnsupportedEncodingException, IOException {
    boolean hasExt = false;
    XhtmlNode d = x.div();
    boolean hasPrefix = false;
    for (QuestionnaireItemComponent c : q.getItem()) {
      hasPrefix = hasPrefix || doesItemHavePrefix(c);
    }
    int i = 1;
    for (QuestionnaireItemComponent c : q.getItem()) {
      hasExt = renderFormItem(d, q, c, hasPrefix ? null : Integer.toString(i), true) || hasExt;
      i++;
    }
    return hasExt; 
  }

  private boolean doesItemHavePrefix(QuestionnaireItemComponent i) {
    if (i.hasPrefix()) {
      return true;
    }
    for (QuestionnaireItemComponent c : i.getItem()) {
      if (doesItemHavePrefix(c)) {
        return true;
      }
    }
    return false;
  }

  private boolean renderFormItem(XhtmlNode x, Questionnaire q, QuestionnaireItemComponent i, String pfx, boolean root) {
    boolean hasExt = false;
    XhtmlNode d = x.div();
    if (!root) {
      d.style("margin-left: 10px");
    }
    XhtmlNode p = d.para();
    if (i.hasPrefix()) {
      p.tx(i.getPrefix());
      p.tx(": ");
    }
    p.span(null, "linkId: "+i.getLinkId()).tx(i.getText());
    if (i.getRequired()) {
      p.span("color: red", "Mandatory").tx(" *");
    }

    XhtmlNode input = null;
    switch (i.getType()) {
    case STRING:
      p.tx(" ");
      input = p.input(i.getLinkId(), "text", i.getType().getDisplay(), 60);
      break;
    case ATTACHMENT:
      break;
    case BOOLEAN:
      p.tx(" ");
      input = p.input(i.getLinkId(), "checkbox", i.getType().getDisplay(), 1);
      break;
    case CHOICE:
      input = p.select(i.getLinkId());
      listOptions(q, i, input);
      break;
    case DATE:
      p.tx(" ");
      input = p.input(i.getLinkId(), "date", i.getType().getDisplay(), 10);
      break;
    case DATETIME:
      p.tx(" ");
      input = p.input(i.getLinkId(), "datetime-local", i.getType().getDisplay(), 25);
      break;
    case DECIMAL:
      p.tx(" ");
      input = p.input(i.getLinkId(), "number", i.getType().getDisplay(), 15);
      break;
    case DISPLAY:
      break;
    case GROUP:
      break;
    case INTEGER:
      p.tx(" ");
      input = p.input(i.getLinkId(), "number", i.getType().getDisplay(), 10);
      break;
    case OPENCHOICE:
      break;
    case QUANTITY:
      p.tx(" ");
      input = p.input(i.getLinkId(), "number", "value", 15);
      p.tx(" ");
      input = p.input(i.getLinkId(), "unit", "unit", 10);
      break;
    case QUESTION:
      break;
    case REFERENCE:
      break;
    case TEXT:
      break;
    case TIME:
      break;
    case URL:
      break;
    default:
      break;
    }
    if (input != null) {
      if (i.getReadOnly()) {
        input.attribute("readonly", "1");
      }
      
    }
    int t = 1;
    for (QuestionnaireItemComponent c : i.getItem()) {
      hasExt = renderFormItem(d, q, c, pfx == null ? null : pfx+"."+Integer.toString(t), false) || hasExt;
      t++;
    }
    return hasExt; 
  }

  private void listOptions(Questionnaire q, QuestionnaireItemComponent i, XhtmlNode select) {
    if (i.hasAnswerValueSet()) {
      ValueSet vs = null;
      if (i.getAnswerValueSet().startsWith("#")) {
        vs = (ValueSet) q.getContained(i.getAnswerValueSet().substring(1)).copy();
        if (vs != null && !vs.hasUrl()) {
          vs.setUrl("urn:uuid:"+UUID.randomUUID().toString().toLowerCase());
        }
      } else {
        vs = context.getContext().fetchResource(ValueSet.class, i.getAnswerValueSet());
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
    } else if (i.hasAnswerOption()) {
      
    } 
    select.option("a", "??", false);    
  }

  public String display(DomainResource dr) throws UnsupportedEncodingException, IOException {
    return display((Questionnaire) dr);
  }

  public String display(Questionnaire q) throws UnsupportedEncodingException, IOException {
    return "Questionnaire "+q.present();
  }
  
}