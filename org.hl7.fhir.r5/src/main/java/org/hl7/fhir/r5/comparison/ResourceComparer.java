package org.hl7.fhir.r5.comparison;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ResourceComparer {
 
  public static class MessageCounts {
    private int errors;
    private int warnings;
    private int hints;
    public int getErrors() {
      return errors;
    }
    public int getWarnings() {
      return warnings;
    }
    public int getHints() {
      return hints;
    }
    public void error() {
      errors++;
    }
    public void warning() {
      warnings++;
    }
    public void hint() {
      hints++;
    }
  }


  public static abstract class ResourceComparison {
    private String id;
    private String leftId;
    private String rightId;
    private MessageCounts cnts;
    
    public ResourceComparison(String leftId, String rightId) {
      super();
      this.leftId = leftId;
      this.rightId = rightId;
      id = abbreviation()+"-"+leftId + "-" + rightId;
    }

    protected String refCell(CanonicalResource cr) {
      if (cr == null) {
        return "<td></td>";
      }
      String t = cr.present();
      if (Utilities.noString(t)) {
        t = cr.getId();
      }
      if (cr.hasWebPath()) {
        String p = cr.getWebPath();
        return "<td><a href=\""+(Utilities.isAbsoluteUrl(p) ? "" : "../")+p+"\">"+Utilities.escapeXml(t)+"</td>";
      } else 
        return "<td>"+Utilities.escapeXml(t)+"</td>";
    }
    
    protected abstract String abbreviation(); 

    public String getLeftId() {
      return leftId;
    }

    public String getRightId() {
      return rightId;
    }

    protected List<ValidationMessage> messages = new ArrayList<>();
    
    public List<ValidationMessage> getMessages() {
      return messages;
    }

    public String getId() {
      return id;
    }

    protected abstract String summary();

    protected abstract String fhirType();

    protected abstract String toTable();
    
    protected String color() {
      if (hasErrors()) {
        return COLOR_DIFFERENT;
      } else if (noChange()) {
        return COLOR_NO_CHANGE;
      } else { 
        return COLOR_DIFFERENT_LESS;
      }
    }

    protected boolean hasErrors() {
      MessageCounts cnts = getCounts();
      return cnts.getErrors() > 0;
    }

    protected boolean noChange() {
      MessageCounts cnts = getCounts();
      return cnts.getErrors() + cnts.getWarnings() + cnts.getHints() == 0;
    }

    protected String outcomeSummary() {
      MessageCounts cnts = getCounts();
      return 
          Integer.toString(cnts.getErrors())+" "+Utilities.pluralize("Breaking Change", cnts.getErrors())+", "+
          Integer.toString(cnts.getWarnings())+" "+Utilities.pluralize("Change", cnts.getWarnings())+", "+
          Integer.toString(cnts.getHints())+" "+Utilities.pluralize("Note", cnts.getHints());
    }

    public MessageCounts getCounts() {
      if (cnts == null) { 
        cnts = new MessageCounts();
        countMessages(cnts);
      }
      return cnts;
    }

    protected abstract void countMessages(MessageCounts cnts);
  }
  
  
  public static class PlaceHolderComparison extends ResourceComparison {
    private CanonicalResource left;
    private CanonicalResource right;
    private Throwable e;

    public PlaceHolderComparison(CanonicalResource left, CanonicalResource right) {
      super(left == null ? right.getId() : left.getId(), right == null ? left.getId() : right.getId());
      this.left = left;
      this.right = right;
    }

    public PlaceHolderComparison(CanonicalResource left, CanonicalResource right, Throwable e) {
      super(left == null ? right.getId() : left.getId(), right == null ? left.getId() : right.getId());
      this.e = e;
      this.left = left;
      this.right = right;
    }

    @Override
    protected String abbreviation() {
      CanonicalResource cr = left == null ? right : left;
      if (cr instanceof CodeSystem) {
        return "cs";
      } else if (cr instanceof ValueSet) {
        return "vs";
      } else if (cr instanceof StructureDefinition) {
        return "sd";
      } else {
        return "xx";
      }
    }

    @Override
    protected String summary() {
      if (e != null) {
        return e.getMessage();
      }
      CanonicalResource cr = left == null ? right : left;
      return cr.fhirType()+(left == null ? " Added" : " Removed");
    }

    @Override
    protected String fhirType() {
      CanonicalResource cr = left == null ? right : left;
      return cr.fhirType();
    }

    @Override
    protected String toTable() {
      String s = "";
      String color = null;
      s = s + refCell(left);
      s = s + refCell(right);
      if (left == null) {
        s = s + "<td>Added</td>";
        color = COLOR_NO_ROW_LEFT;
      } else if (right == null) {
        s = s + "<td>Removed</td>";        
        color = COLOR_NO_ROW_RIGHT;
      } else {
        s = s + "<td><a href=\""+getId()+".html\">Failed<a></td>";
        color = COLOR_ISSUE;
      }
      s = s + "<td>"+(e != null ? Utilities.escapeXml(e.getMessage()) : "")+"</td>";
      return "<tr style=\"background-color: "+color+"\">"+s+"</tr>\r\n";
    }

   

    public Throwable getE() {
      return e;
    }

    @Override
    protected void countMessages(MessageCounts cnts) {
      if (e != null) {
        cnts.error();
      }
    }    
    
  }

  public final static String COLOR_NO_ROW_LEFT = "#ffffb3";
  public final static String COLOR_NO_CELL_LEFT = "#ffff4d";
  public final static String COLOR_NO_ROW_RIGHT = "#ffecb3";
  public final static String COLOR_NO_CELL_RIGHT = "#ffcc33";  
  public final static String COLOR_DIFFERENT = "#f0b3ff";
  public final static String COLOR_DIFFERENT_LESS = "#f8e6ff";
  public final static String COLOR_ISSUE = "#ffad99";
  public final static String COLOR_NO_CHANGE = "#ffffff";

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
      tr.style("background-color: "+colorForLevel(vm.getLevel()));
      tr.td().tx(vm.getLevel().getDisplay());
      tr.td().tx(vm.getLocation());
      tr.td().tx(vm.getMessage().replace("\"", "'"));
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

  protected ValidationMessage vm(IssueSeverity level, String message, String path, List<ValidationMessage> genMessages) {
    ValidationMessage vm = new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, message, level == IssueSeverity.NULL ? IssueSeverity.INFORMATION : level);
    genMessages.add(vm);
    return vm;
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
      return "#ffdddd";
    case FATAL:
      return "#ffcccc";
    case WARNING:
      return "#fff6ee";
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
      if (msg.getLevel() == IssueSeverity.ERROR) {
        li.style("font-weight: bold");
      }
      li.tx(msg.getMessage());
    }
    return cell;
  }
 


}