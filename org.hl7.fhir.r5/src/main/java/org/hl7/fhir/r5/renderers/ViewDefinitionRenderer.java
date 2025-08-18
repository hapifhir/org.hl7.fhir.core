package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.sql.Column;
import org.hl7.fhir.r5.utils.sql.ColumnKind;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Title;

@MarkedToMoveToAdjunctPackage
public class ViewDefinitionRenderer extends ResourceRenderer {
  
  public ViewDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 

  @Override
  public boolean renderingUsesValidation() {
    return true;
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper vd) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(vd, x);
    genSummaryTable(status, x, vd);
    
    XhtmlNode p = x.para();
    p.tx("This view acts on the "+vd.primitiveValue("resource")+" resource");
    var vers = vd.children("fhirVersion");
    for (int i = 0; i <  vers.size(); i++) {
      if (i == 0) {
        p.tx(" for version"+(vers.size() == 1 ? "" : "s")+" ");
      } else if (i == vers.size() - 1) {
        p.tx(" and ");
      } else {
        p.tx(", ");
      }
      String ver = vers.get(i).primitiveValue();
      p.ah(VersionUtilities.getSpecUrl(ver)).tx(VersionUtilities.getNameForVersion(ver));
    }
    if (vd.has("resourceProfile")) {
      p.tx(" using profile ?");
    }    
    if (vd.has("name")) {
      p.tx(" to produce a table named \"");
      p.code().tx(vd.primitiveValue("name"));
      p.tx("\"");      
    } else {
      p.tx(" to produce a unnamed table");
    }
    if (vd.has("where")) {
      List<ResourceWrapper> wheres = vd.children("where");
      if (wheres.size() == 1) {
        p.tx(" where ");
        p.code().tx(wheres.get(0).primitiveValue("path"));
        if (wheres.get(0).has("description")) {
          p.tx(" ("+wheres.get(0).primitiveValue("description")+")");
        }
        p.tx(".");
      } else {
        p.tx(" where:");
        XhtmlNode ul = x.ul();
        for (ResourceWrapper w : wheres) {
          XhtmlNode li = ul.li();
          li.code().tx(wheres.get(0).primitiveValue("path"));
          if (wheres.get(0).has("description")) {
            li.tx(" ("+wheres.get(0).primitiveValue("description")+")");
          }
        }
      }
    } else {
      p.tx(".");
    }
    
    if (vd.hasUserData(UserDataNames.db_columns)) {
      x.para().tx("The table contains the following columns:");
      List<Column> cols = (List<Column>) vd.getUserData(UserDataNames.db_columns);
      boolean hasNotes = false;
      for (Column col : cols) {
        hasNotes = hasNotes || !Utilities.noString(col.getNotes());
      }
      
      XhtmlNode t2 = x.table("grid", false);
      XhtmlNode tr = t2.tr();
      tr.th().tx("Name");
      tr.th().tx("Fhir Type");
      tr.th().tx("SQL Type");
      tr.th().tx("Collection");
      if (hasNotes) {
        tr.th().tx("Notes");
      }
      
      for (Column col : cols) {
        tr = t2.tr();
        tr.td().tx(col.getName());
        tr.td().tx(col.getType());
        tr.td().tx(col.getKind().name());
        tr.td().tx(col.isColl() == null ? "" : col.isColl() ? "Y" : "N");
        if (hasNotes) {
          tr.td().tx(col.getNotes());
        }
      }
    }
    if (vd.has("constant")) {
      x.para().tx("Constants:");

      XhtmlNode t2 = x.table("grid", false);
      XhtmlNode tr = t2.tr();
      tr.th().tx("Name");
      tr.th().tx("Value");
      
      for (ResourceWrapper cnst : vd.children("constant")) {
        tr = t2.tr();
        tr.td().tx(cnst.primitiveValue("name"));
        tr.td().tx(cnst.primitiveValue("value"));
      }
    }
    // row 4: select tree
    x.para().tx("Selection Rules:");
    
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, context.getDestDir(), context.isInlineGraphics(), true, ""); 
    TableModel model = gen.new TableModel("vd="+vd.getId(), context.getRules() == GenerationRules.IG_PUBLISHER);     
    model.setAlternating(true); 
    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) { 
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());     
    } else { 
      model.setDocoImg(Utilities.pathURL(context.getLink(KnownLinkType.SPEC, true), "help16.png")); 
    }  
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Item"), (context.formatPhrase(RenderingContext.QUEST_LINK)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Coll"), (context.formatPhrase(RenderingContext.QUEST_TEXTFOR)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Type"), (context.formatPhrase(RenderingContext.QUEST_TIMES)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Description"), (context.formatPhrase(RenderingContext.QUEST_TYPE_ITEM)), null, 0)); 
 
    // first we add a root for the questionaire itself 
    Row row = addViewRoot(gen, model.getRows(), vd); 
    for (ResourceWrapper select : vd.children("select")) { 
      renderSelect(status, gen, row.getSubRows(), vd, select); 
    } 
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null); 
    x.addChildNode(xn); 
  }

  private void renderSelect(RenderingStatus status, HierarchicalTableGenerator gen, List<Row> rows, ResourceWrapper vd, ResourceWrapper select) {
    Row r = gen.new Row(); 
    rows.add(r); 
    
    r.setIcon("icon_vd_select.png", "Select"); 
    Cell c1 = gen.new Cell(null, null, "Select", null, null); 
    r.getCells().add(c1); 
    r.getCells().add(gen.new Cell(null, null, null, null, null)); 
    r.getCells().add(gen.new Cell(null, null, null, null, null));
    Cell cell = gen.new Cell(null, null, null, null, null);
    if (select.has("forEach")) {
      addFHIRPath(cell.getPieces().get(0), "for each ", select.primitiveValue("forEach"), null);     
    } else if (select.has("forEachOrNull")) {
      addFHIRPath(cell.getPieces().get(0), "for each ", select.primitiveValue("forEachOrNull"), ", or null");        
    } else {
    }
    r.getCells().add(cell);

    for (ResourceWrapper column : select.children("column")) { 
      renderColumn(status, gen, r.getSubRows(), vd, select, column); 
    }      

    for (ResourceWrapper child : select.children("select")) { 
      renderSelect(status, gen, r.getSubRows(), vd, child); 
    }      

  }

  private void renderColumn(RenderingStatus status, HierarchicalTableGenerator gen, List<Row> rows, ResourceWrapper vd, ResourceWrapper select, ResourceWrapper column) {
    Row r = gen.new Row(); 
    rows.add(r); 
    
    r.setIcon("icon_vd_col.png", "Column"); 
    Cell c1 = gen.new Cell(null, null, column.primitiveValue("name"), null, null); 
    r.getCells().add(c1); 
    String coll = column.has("collection") ? "true".equals(column.primitiveValue("collection")) ? "Y" : "N" : "";
    r.getCells().add(gen.new Cell(null, null, coll, null, null)); 
    r.getCells().add(gen.new Cell(null, null, column.primitiveValue("type"), null, null));
    Cell cell = gen.new Cell(null, null, null, null, null);
    addFHIRPath(cell.getPieces().get(0), null, column.primitiveValue("path"), null); 
    if (column.has("description")) {
      cell.addPiece(gen.new Piece("br")); 
      cell.addPiece(gen.new Piece(null, column.primitiveValue("description"), null)); 
    }
    for (ResourceWrapper tag : column.children("tag")) {
      cell.addPiece(gen.new Piece("br")); 
      cell.addPiece(gen.new Piece(null, tag.primitiveValue("name")+"="+tag.primitiveValue("value"), null)); 
    }
    r.getCells().add(cell);  
  }

  private void addFHIRPath(Piece p, String pfx, String expr, String sfx) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "span").style("font-size: 11px"); 
    p.addHtml(x); 
    if (pfx != null) {
      x.tx(pfx);
    }
    x.code(expr); 
    if (sfx != null) {
      x.tx(sfx);
    }
  }

  private Row addViewRoot(HierarchicalTableGenerator gen, List<Row> rows, ResourceWrapper vd) throws IOException { 
    Row r = gen.new Row(); 
    rows.add(r); 

    r.setIcon("icon_vd_view.png", context.formatPhrase(RenderingContext.QUEST_ROOT)); 
    r.getCells().add(gen.new Cell(null, null, vd.primitiveValue("name"), null, null)); 
    r.getCells().add(gen.new Cell(null, null, "", null, null)); 
    r.getCells().add(gen.new Cell(null, null, vd.primitiveValue("resource"), null, null)); 
    r.getCells().add(gen.new Cell(null, null, vd.primitiveValue("description"), null, null)); 
    return r;     
  } 

}
