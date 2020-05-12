package org.hl7.fhir.r5.comparison;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

  public class ResourceComparison {
    private String id;
    
    protected List<ValidationMessage> messages = new ArrayList<>();
    
    public ResourceComparison() {
      super();
    }

    public List<ValidationMessage> getMessages() {
      return messages;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }
    
    
  }
  
  public final static String COLOR_NO_ROW_LEFT = "#ffffb3";
  public final static String COLOR_NO_CELL_LEFT = "#ffff4d";
  public final static String COLOR_NO_ROW_RIGHT = "#ffecb3";
  public final static String COLOR_NO_CELL_RIGHT = "#ffcc33";  
  public final static String COLOR_DIFFERENT = "#f0b3ff";
  public final static String COLOR_ISSUE = "#ffad99";

  protected ComparisonSession session;
  
  public ResourceComparer(ComparisonSession session) {
    super();
    this.session = session;
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

  public XhtmlNode renderErrors(ResourceComparison csc) {
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


  protected ValidationMessage vmI(IssueSeverity level, String message, String path) {
    ValidationMessage vm = new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, message, level == IssueSeverity.NULL ? IssueSeverity.INFORMATION : level);
    return vm;    
  }
  
  protected void vm(IssueSeverity level, String message, String path, List<ValidationMessage> genMessages, List<ValidationMessage> specMessages) {
    ValidationMessage vm = new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, message, level == IssueSeverity.NULL ? IssueSeverity.INFORMATION : level);
    genMessages.add(vm);
    if (specMessages != null) {
      specMessages.add(vm);
    }
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