package org.hl7.fhir.r5.comparison;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlDocument;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;

public class ResourceComparer {

  public class ResourceCmparison {
    protected List<ValidationMessage> messages = new ArrayList<>();

    public List<ValidationMessage> getMessages() {
      return messages;
    }
  }
  
  public final static String COLOR_NO_ROW_LEFT = "#ffffb3";
  public final static String COLOR_NO_CELL_LEFT = "#ffff4d";
  public final static String COLOR_NO_ROW_RIGHT = "#ffecb3";
  public final static String COLOR_NO_CELL_RIGHT = "#ffcc33";  
  public final static String COLOR_DIFFERENT = "#f0b3ff";
  public final static String COLOR_ISSUE = "#ffad99";

  protected IWorkerContext context;
  
  public ResourceComparer(IWorkerContext context) {
    super();
    this.context = context;
  }

  public Cell missingCell(HierarchicalTableGenerator gen) {
    Cell c = gen.new Cell(null, null, "", null, null);
    return c;
  }

  public Cell missingCell(HierarchicalTableGenerator gen, String color) {
    Cell c = gen.new Cell(null, null, "", null, null);
    if (color != null) {
      c.setStyle("background-color: "+color);
    }
    return c;
  }

  public XhtmlNode renderErrors(ResourceCmparison csc) {
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode tbl = div.table("grid");
    for (ValidationMessage vm : csc.messages) {
      XhtmlNode tr = tbl.tr();
      tr.td().tx(vm.getLocation());
      tr.td().tx(vm.getMessage());
      tr.td().tx(vm.getLevel().getDisplay());
    }
    return div;
  }


  protected ValidationMessage vm(IssueSeverity level, String message, String path) {
    return new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, message, level == IssueSeverity.NULL ? IssueSeverity.INFORMATION : level);
  }

  private String colorForLevel(IssueSeverity level) {
    switch (level) {
    case ERROR:
      return "#ffcccc";
    case FATAL:
      return "#ff9999";
    case WARNING:
      return "#ffebcc";
    default: // INFORMATION:
      return "#ffffe6";
    }
  }

  private String halfColorForLevel(IssueSeverity level) {
    switch (level) {
    case ERROR:
      return "#ffeeee";
    case FATAL:
      return "#ffcccc";
    case WARNING:
      return "#fff4ee";
    default: // INFORMATION:
      return "#fffff2";
    }
  }

  protected Cell cellForMessages(HierarchicalTableGenerator gen, List<ValidationMessage> messages) {
    Cell cell = gen.new Cell();
    Piece piece = gen.new Piece("ul");
    cell.addPiece(piece);
    for (ValidationMessage msg : messages) {
      XhtmlNode li = new XhtmlNode(NodeType.Element, "li");
      piece.getChildren().add(li);
      li.style("background-color: "+halfColorForLevel(msg.getLevel()));
      li.tx(msg.getMessage());
    }
    return cell;
  }
  
}
