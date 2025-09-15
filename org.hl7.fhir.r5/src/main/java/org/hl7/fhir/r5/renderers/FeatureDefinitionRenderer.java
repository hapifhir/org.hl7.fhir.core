package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;

@MarkedToMoveToAdjunctPackage
public class FeatureDefinitionRenderer extends ResourceRenderer {
  
  public FeatureDefinitionRenderer(RenderingContext context) { 
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
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper fd) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(fd, x);
    genSummaryTable(status, x, fd);
    
    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    
    XhtmlNode td = tbl.tr().td();
    td.tx("Feature ");
    td.code().tx(fd.primitiveValue("url"));
    
    addMarkdown(tbl.tr().td(), fd.primitiveValue("description"));

    td = tbl.tr().td();
    td.b().tx("Type: ");    
    td.tx(fd.primitiveValue("valueType"));
    
    td = tbl.tr().td();
    td.b().tx("Contexts");
    XhtmlNode ul = td.ul();
    for (ResourceWrapper c : fd.children("context")) {
      String url = c.primitiveValue();
      var li = ul.li();
      if (url.contains("#")) {
        String type = url.substring(0, url.indexOf("#"));
        String id = url.substring(url.indexOf("#")+1);
        StructureDefinition sd = context.getContext().fetchTypeDefinition(type);
        if (sd != null && sd.hasWebPath()) {
          li.ah(sd.getWebPath()).tx(sd.present());
        } else {
          li.tx(url);
        }
        if (id != null) {
          li.tx(" element ");
          li.code().tx(id);
        }
      } else {
        li.tx(url);
      }
    }
    td = tbl.tr().td();
    if (fd.has("qualifier")) {
      td.b().tx("Qualifiers");

      XhtmlNode tbl2 = td.table("lines", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = tbl2.tr();
      tr.td().b().tx("Name");
      tr.td().b().tx("Type");
      tr.td().b().tx("Optional");
      tr.td().b().tx("Description");
      for (ResourceWrapper q : fd.children("qualifier")) {
        tr = tbl2.tr();
        tr.td().tx(q.primitiveValue("name"));
        tr.td().tx(q.primitiveValue("valueType"));
        tr.td().tx(q.primitiveValue("optional"));
        tr.td().tx(q.primitiveValue("description"));
        
      }
    } else {
      td.tx("This feature doesn't have any qualifiers");
    }

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
