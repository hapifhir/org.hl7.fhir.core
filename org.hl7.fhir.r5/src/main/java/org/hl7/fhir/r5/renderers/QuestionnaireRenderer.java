package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class QuestionnaireRenderer extends ResourceRenderer {
  
  private String directory;
  private String defnFile;
  private boolean inlineGraphics;
  
  private boolean tree;
  
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
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context.getDirectory(), context.isInlineGraphics(), true);
    TableModel model = gen.new TableModel("qtree="+q.getId(), true);    
    model.setAlternating(true);
    model.setDocoImg(context.getPrefix() +"help16.png");
    model.setDocoRef(context.getPrefix()+"formats.html#table");
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "LinkId"), translate("sd.hint", "The linkId for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Text"), translate("sd.hint", "Text for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Cardinality"), translate("sd.hint", "Minimum and Maximum # of times the the itemcan appear in the instance"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Type"), translate("sd.hint", "The type of the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Description & Constraints"), translate("sd.hint", "Additional information about the item"), null, 0));

    boolean hasExt = false;
    for (QuestionnaireItemComponent i : q.getItem()) {
      hasExt = renderTreeItem(gen, model.getRows(), q, i) || hasExt;
    }
    return hasExt;
  }

  private boolean renderTreeItem(HierarchicalTableGenerator gen, List<Row> rows, Questionnaire q, QuestionnaireItemComponent i) {
    Row r = gen.new Row();
    rows.add(r);
    boolean hasExt = false;

    r.getCells().add(gen.new Cell(null, context.getDefnFile() == null ? "" : context.getDefnFile()+"-definitions.html#extension."+i.getLinkId(), i.getLinkId(), null, null));
    String txt = (i.hasPrefix() ? i.getPrefix() + ". " : "") + i.getText();
    r.getCells().add(gen.new Cell(null, null, txt, null, null));
    r.getCells().add(gen.new Cell(null, null, (i.getRequired() ? "1" : "0")+".."+(i.getRepeats() ? "*" : "1"), null, null));
    r.getCells().add(gen.new Cell(null, context.getPrefix()+"codesystem-item-type.html#"+i.getType().toCode(), i.getType().toCode(), null, null));
    Cell defn = gen.new Cell(null, null, null, null, null);
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
      defn.getPieces().add(gen.new Piece(null, "todo", null));            
    }
    if (i.hasAnswerOption()) {
      if (!defn.getPieces().isEmpty()) defn.addPiece(gen.new Piece("br"));
      defn.getPieces().add(gen.new Piece(null, "Options: ", null));
      defn.getPieces().add(gen.new Piece(null, "todo", null));            
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
    
    for (QuestionnaireItemComponent c : i.getItem()) {
      hasExt = renderTreeItem(gen, rows, q, c) || hasExt;
    }
    return hasExt;
    
  }


  public boolean renderForm(XhtmlNode x, Questionnaire q) throws UnsupportedEncodingException, IOException {
    boolean hasExt = false;
    XhtmlNode d = x.div();
    for (QuestionnaireItemComponent c : q.getItem()) {
      hasExt = renderFormItem(d, q, c) || hasExt;
    }
    return hasExt; 
  }

  private boolean renderFormItem(XhtmlNode x, Questionnaire q, QuestionnaireItemComponent i) {
    boolean hasExt = false;
    XhtmlNode d = x.div();
    d.para().tx(i.getText());

    for (QuestionnaireItemComponent c : i.getItem()) {
      hasExt = renderFormItem(d, q, c) || hasExt;
    }
    return hasExt; 
  }

  public String display(DomainResource dr) throws UnsupportedEncodingException, IOException {
    return display((Questionnaire) dr);
  }

  public String display(Questionnaire q) throws UnsupportedEncodingException, IOException {
    return "Questionnaire "+q.present();
  }
  
}