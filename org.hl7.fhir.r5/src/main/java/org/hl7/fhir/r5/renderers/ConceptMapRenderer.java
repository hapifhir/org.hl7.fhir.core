package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode;
import org.hl7.fhir.r5.model.ConceptMap.MappingPropertyComponent;
import org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ConceptMapRenderer extends TerminologyRenderer {

  public enum RenderMultiRowSortPolicy {
    UNSORTED, FIRST_COL, LAST_COL

  }

  public interface IConceptMapInformationProvider {
    public List<Coding> getMembers(String uri);
    public String getLink(String system, String code);
  }
  
  public static class MultipleMappingRowSorter implements Comparator<MultipleMappingRow> {

    private boolean first;
    
    protected MultipleMappingRowSorter(boolean first) {
      super();
      this.first = first;
    }

    @Override
    public int compare(MultipleMappingRow o1, MultipleMappingRow o2) {
      String s1 = first ? o1.firstCode() : o1.lastCode();
      String s2 = first ? o2.firstCode() : o2.lastCode();
      return s1.compareTo(s2);
    }
  }

  public static class Cell {

    private String system;
    private String code;
    private String display;
    private String relationship;
    private String relComment;
    public boolean renderedRel;
    public boolean renderedCode;
    private Cell clone;
    
    protected Cell() {
      super();
    }

    public Cell(String system, String code, String display) {
      this.system = system;
      this.code = code;
      this.display = display;
    }

    public Cell(String system, String code, String relationship, String comment) {
      this.system = system;
      this.code = code;
      this.relationship = relationship;
      this.relComment = comment;
    }

    public boolean matches(String system, String code) {
      return (system != null && system.equals(this.system)) && (code != null && code.equals(this.code));
    }

    public String present() {
      if (system == null) {
        return code;
      } else {
        return code; //+(clone == null ? "" : " (@"+clone.code+")");
      }
    }

    public Cell copy(boolean clone) {
      Cell res = new Cell();
      res.system = system;
      res.code = code;
      res.display = display;
      res.relationship = relationship;
      res.relComment = relComment;
      res.renderedRel = renderedRel;
      res.renderedCode = renderedCode;
      if (clone) {
        res.clone = this;
      }
      return res;
    }

    @Override
    public String toString() {
      return relationship+" "+system + "#" + code + " \"" + display + "\"";
    }
    
  }
  

  public static class MultipleMappingRowItem {
    List<Cell> cells = new ArrayList<>();

    @Override
    public String toString() {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (Cell cell : cells) {
        if (cell.relationship != null) {
          b.append(cell.relationship+cell.code);
        } else {
          b.append(cell.code);
        }
      }
      return b.toString();
    }
  }
  
  public static class MultipleMappingRow {
    private List<MultipleMappingRowItem> rowSets = new ArrayList<>();
    private MultipleMappingRow stickySource;

    public MultipleMappingRow(int i, String system, String code, String display) {
      MultipleMappingRowItem row = new MultipleMappingRowItem();
      rowSets.add(row);
      for (int c = 0; c < i; c++) {
        row.cells.add(new Cell()); // blank cell spaces
      }
      row.cells.add(new Cell(system, code, display));
    }


    public MultipleMappingRow(MultipleMappingRow stickySource) {
      this.stickySource = stickySource;
    }

    @Override
    public String toString() {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (MultipleMappingRowItem rowSet : rowSets) {
        b.append(""+rowSet.cells.size());
      }
      CommaSeparatedStringBuilder b2 = new CommaSeparatedStringBuilder(";");
      for (MultipleMappingRowItem rowSet : rowSets) {
        b2.append(rowSet.toString());
      }
      return ""+rowSets.size()+" ["+b.toString()+"] ("+b2.toString()+")";
    }


    public String lastCode() {
      MultipleMappingRowItem first = rowSets.get(0);
      for (int i = first.cells.size()-1; i >= 0; i--) {
        if (first.cells.get(i).code != null) {
          return first.cells.get(i).code;
        }
      }
      return "";
    }

    public String firstCode() {
      MultipleMappingRowItem first = rowSets.get(0);
      for (int i = 0; i < first.cells.size(); i++) {
        if (first.cells.get(i).code != null) {
          return first.cells.get(i).code;
        }
      }
      return "";
    }

    public void addSource(MultipleMappingRow sourceRow, List<MultipleMappingRow> rowList, ConceptMapRelationship relationship, String comment) {
      // we already have a row, and we're going to collapse the rows on sourceRow into here, and add a matching terminus 
      assert sourceRow.rowSets.get(0).cells.size() == rowSets.get(0).cells.size()-1;
      rowList.remove(sourceRow);
      Cell template = rowSets.get(0).cells.get(rowSets.get(0).cells.size()-1);
      for (MultipleMappingRowItem row : sourceRow.rowSets) {
        row.cells.add(new Cell(template.system, template.code, relationship.getSymbol(), comment));
      }
      rowSets.addAll(sourceRow.rowSets);
    }

    public void addTerminus() {
      for (MultipleMappingRowItem row : rowSets) {
        row.cells.add(new Cell(null, null, "X", null));
      }
    }

    public void addTarget(String system, String code, ConceptMapRelationship relationship, String comment, List<MultipleMappingRow> sets, int colCount) {
      if (rowSets.get(0).cells.size() == colCount+1) { // if it's already has a target for this col then we have to clone (and split) the rows
        for (MultipleMappingRowItem row : rowSets) {
          row.cells.add(new Cell(system, code, relationship.getSymbol(), comment));
        }
      } else {
        MultipleMappingRow nrow = new MultipleMappingRow(this);
        for (MultipleMappingRowItem row : rowSets) {
          MultipleMappingRowItem n = new MultipleMappingRowItem();
          for (int i = 0; i < row.cells.size()-1; i++) { // note to skip the last
            n.cells.add(row.cells.get(i).copy(true));
          }
          n.cells.add(new Cell(system, code, relationship.getSymbol(), comment));
          nrow.rowSets.add(n);
        }
        sets.add(sets.indexOf(this), nrow);
      }
    }

    public String lastSystem() {
      MultipleMappingRowItem first = rowSets.get(0);
      for (int i = first.cells.size()-1; i >= 0; i--) {
        if (first.cells.get(i).system != null) {
          return first.cells.get(i).system;
        }
      }
      return "";
    }

    public void addCopy(String system) {
      for (MultipleMappingRowItem row : rowSets) {
        row.cells.add(new Cell(system, lastCode(), "=", null));
      }
    }


    public boolean alreadyHasMappings(int i) {
      for (MultipleMappingRowItem row : rowSets) {
        if (row.cells.size() > i+1) {
          return true;
        }
      }
      return false;
    }


    public Cell getLastSource(int i) {
      for (MultipleMappingRowItem row : rowSets) {
        return row.cells.get(i+1);
      }
      throw new Error("Should not get here");   // return null
    }


    public void cloneSource(int i, Cell cell) {
      MultipleMappingRowItem row = new MultipleMappingRowItem();
      rowSets.add(row);
      for (int c = 0; c < i-1; c++) {
        row.cells.add(new Cell()); // blank cell spaces
      }
      row.cells.add(cell.copy(true));
      row.cells.add(rowSets.get(0).cells.get(rowSets.get(0).cells.size()-1).copy(false));      
    }
  }

  public ConceptMapRenderer(RenderingContext context) {
    super(context);
  }

  public ConceptMapRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (ConceptMap) dr, false);
  }

  public boolean render(XhtmlNode x, ConceptMap cm, boolean header) throws FHIRFormatError, DefinitionException, IOException {
    if (header) {
      x.h2().addText(cm.getName()+" ("+cm.getUrl()+")");
    }

    XhtmlNode p = x.para();
    p.tx("Mapping from ");
    if (cm.hasSourceScope())
      AddVsRef(cm.getSourceScope().primitiveValue(), p, cm);
    else
      p.tx("(not specified)");
    p.tx(" to ");
    if (cm.hasTargetScope())
      AddVsRef(cm.getTargetScope().primitiveValue(), p, cm);
    else 
      p.tx("(not specified)");

    p = x.para();
    if (cm.getExperimental())
      p.addText(Utilities.capitalize(cm.getStatus().toString())+" (not intended for production usage). ");
    else
      p.addText(Utilities.capitalize(cm.getStatus().toString())+". ");
    p.tx("Published on "+(cm.hasDate() ? display(cm.getDateElement()) : "?ngen-10?")+" by "+cm.getPublisher());
    if (!cm.getContact().isEmpty()) {
      p.tx(" (");
      boolean firsti = true;
      for (ContactDetail ci : cm.getContact()) {
        if (firsti)
          firsti = false;
        else
          p.tx(", ");
        if (ci.hasName())
          p.addText(ci.getName()+": ");
        boolean first = true;
        for (ContactPoint c : ci.getTelecom()) {
          if (first)
            first = false;
          else
            p.tx(", ");
          addTelecom(p, c);
        }
      }
      p.tx(")");
    }
    p.tx(". ");
    p.addText(cm.getCopyright());
    if (!Utilities.noString(cm.getDescription()))
      addMarkdown(x, cm.getDescription());

    x.br();
    int gc = 0;
    
    CodeSystem cs = getContext().getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-relationship");
    if (cs == null)
      cs = getContext().getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-equivalence");
    String eqpath = cs == null ? null : cs.getWebPath();

    for (ConceptMapGroupComponent grp : cm.getGroup()) {
      String src = grp.getSource();
      boolean comment = false;
      boolean ok = true;
      Map<String, HashSet<String>> props = new HashMap<String, HashSet<String>>();
      Map<String, HashSet<String>> sources = new HashMap<String, HashSet<String>>();
      Map<String, HashSet<String>> targets = new HashMap<String, HashSet<String>>();
      sources.put("code", new HashSet<String>());
      targets.put("code", new HashSet<String>());
      sources.get("code").add(grp.getSource());
      targets.get("code").add(grp.getTarget());
      for (SourceElementComponent ccl : grp.getElement()) {
        ok = ok && (ccl.getNoMap() || (ccl.getTarget().size() == 1 && ccl.getTarget().get(0).getDependsOn().isEmpty() && ccl.getTarget().get(0).getProduct().isEmpty()));
        for (TargetElementComponent ccm : ccl.getTarget()) {
          comment = comment || !Utilities.noString(ccm.getComment());
          for (MappingPropertyComponent pp : ccm.getProperty()) {
            if (!props.containsKey(pp.getCode()))
              props.put(pp.getCode(), new HashSet<String>());            
          }
          for (OtherElementComponent d : ccm.getDependsOn()) {
            if (!sources.containsKey(d.getAttribute()))
              sources.put(d.getAttribute(), new HashSet<String>());
          }
          for (OtherElementComponent d : ccm.getProduct()) {
            if (!targets.containsKey(d.getAttribute()))
              targets.put(d.getAttribute(), new HashSet<String>());
          }
        }
      }

      gc++;
      if (gc > 1) {
        x.hr();
      }
      XhtmlNode pp = x.para();
      pp.b().tx("Group "+gc);
      pp.tx("Mapping from ");
      if (grp.hasSource()) {
        renderCanonical(cm, pp, grp.getSource());
      } else {
        pp.code("unspecified code system");
      }
      pp.tx(" to ");
      if (grp.hasTarget()) {
        renderCanonical(cm, pp, grp.getTarget());
      } else {
        pp.code("unspecified code system");
      }
      
      String display;
      if (ok) {
        // simple
        XhtmlNode tbl = x.table( "grid");
        XhtmlNode tr = tbl.tr();
        tr.td().b().tx("Source Code");
        tr.td().b().tx("Relationship");
        tr.td().b().tx("Target Code");
        if (comment)
          tr.td().b().tx("Comment");
        for (SourceElementComponent ccl : grp.getElement()) {
          tr = tbl.tr();
          XhtmlNode td = tr.td();
          td.addText(ccl.getCode());
          display = ccl.hasDisplay() ? ccl.getDisplay() : getDisplayForConcept(systemFromCanonical(grp.getSource()), versionFromCanonical(grp.getSource()), ccl.getCode());
          if (display != null && !isSameCodeAndDisplay(ccl.getCode(), display))
            td.tx(" ("+display+")");
          if (ccl.getNoMap()) {
            tr.td().colspan(comment ? "3" : "2").style("background-color: #efefef").tx("(not mapped)");
          } else {
            TargetElementComponent ccm = ccl.getTarget().get(0);
            if (!ccm.hasRelationship())
              tr.td().tx(":"+"("+ConceptMapRelationship.EQUIVALENT.toCode()+")");
            else {
              if (ccm.hasExtension(ToolingExtensions.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
                String code = ToolingExtensions.readStringExtension(ccm, ToolingExtensions.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
                tr.td().ah(eqpath+"#"+code, code).tx(presentEquivalenceCode(code));                
              } else {
                tr.td().ah(eqpath+"#"+ccm.getRelationship().toCode(), ccm.getRelationship().toCode()).tx(presentRelationshipCode(ccm.getRelationship().toCode()));
              }
            }
            td = tr.td();
            td.addText(ccm.getCode());
            display = ccm.hasDisplay() ? ccm.getDisplay() : getDisplayForConcept(systemFromCanonical(grp.getTarget()), versionFromCanonical(grp.getTarget()), ccm.getCode());
            if (display != null && !isSameCodeAndDisplay(ccm.getCode(), display))
              td.tx(" ("+display+")");
            if (comment)
              tr.td().addText(ccm.getComment());
          }
          addUnmapped(tbl, grp);
        }
      } else {
        boolean hasRelationships = false;
        for (int si = 0; si < grp.getElement().size(); si++) {
          SourceElementComponent ccl = grp.getElement().get(si);
          for (int ti = 0; ti < ccl.getTarget().size(); ti++) {
            TargetElementComponent ccm = ccl.getTarget().get(ti);
            if (ccm.hasRelationship()) {
              hasRelationships = true;
            }  
          }
        }
        
        XhtmlNode tbl = x.table( "grid");
        XhtmlNode tr = tbl.tr();
        XhtmlNode td;
        tr.td().colspan(Integer.toString(1+sources.size())).b().tx("Source Concept Details");
        if (hasRelationships) {
          tr.td().b().tx("Relationship");
        }
        tr.td().colspan(Integer.toString(1+targets.size())).b().tx("Target Concept Details");
        if (comment) {
          tr.td().b().tx("Comment");
        }
        tr.td().colspan(Integer.toString(1+targets.size())).b().tx("Properties");
        tr = tbl.tr();
        if (sources.get("code").size() == 1) {
          String url = sources.get("code").iterator().next();
          renderCSDetailsLink(tr, url, true);           
        } else
          tr.td().b().tx("Code");
        for (String s : sources.keySet()) {
          if (s != null && !s.equals("code")) {
            if (sources.get(s).size() == 1) {
              String url = sources.get(s).iterator().next();
              renderCSDetailsLink(tr, url, false);           
            } else
              tr.td().b().addText(getDescForConcept(s));
          }
        }
        if (hasRelationships) {
          tr.td();
        }
        if (targets.get("code").size() == 1) {
          String url = targets.get("code").iterator().next();
          renderCSDetailsLink(tr, url, true);           
        } else
          tr.td().b().tx("Code");
        for (String s : targets.keySet()) {
          if (s != null && !s.equals("code")) {
            if (targets.get(s).size() == 1) {
              String url = targets.get(s).iterator().next();
              renderCSDetailsLink(tr, url, false);           
            } else
              tr.td().b().addText(getDescForConcept(s));
          }
        }
        if (comment) {
          tr.td();
        }
        for (String s : props.keySet()) {
          if (s != null) {
            if (props.get(s).size() == 1) {
              String url = props.get(s).iterator().next();
              renderCSDetailsLink(tr, url, false);           
            } else
              tr.td().b().addText(getDescForConcept(s));
          }
        }

        for (int si = 0; si < grp.getElement().size(); si++) {
          SourceElementComponent ccl = grp.getElement().get(si);
          boolean slast = si == grp.getElement().size()-1;
          boolean first = true;
          if (ccl.hasNoMap() && ccl.getNoMap()) {
            tr = tbl.tr();
            td = tr.td().style("border-right-width: 0px");
            if (!first)
              td.style("border-top-style: none");
            else 
              td.style("border-bottom-style: none");
            if (sources.get("code").size() == 1)
              td.addText(ccl.getCode());
            else
              td.addText(grp.getSource()+" / "+ccl.getCode());
            display = ccl.hasDisplay() ? ccl.getDisplay() : getDisplayForConcept(systemFromCanonical(grp.getSource()), versionFromCanonical(grp.getSource()), ccl.getCode());
            tr.td().style("border-left-width: 0px").tx(display == null ? "" : display);
            tr.td().colspan("4").style("background-color: #efefef").tx("(not mapped)");

          } else {
            for (int ti = 0; ti < ccl.getTarget().size(); ti++) {
              TargetElementComponent ccm = ccl.getTarget().get(ti);
              boolean last = ti == ccl.getTarget().size()-1;
              tr = tbl.tr();
              td = tr.td().style("border-right-width: 0px");
              if (!first && !last)
                td.style("border-top-style: none; border-bottom-style: none");
              else if (!first)
                td.style("border-top-style: none");
              else if (!last)
                td.style("border-bottom-style: none");
              if (first) {
                if (sources.get("code").size() == 1)
                  td.addText(ccl.getCode());
                else
                  td.addText(grp.getSource()+" / "+ccl.getCode());
                display = ccl.hasDisplay() ? ccl.getDisplay() : getDisplayForConcept(systemFromCanonical(grp.getSource()), versionFromCanonical(grp.getSource()), ccl.getCode());
                td = tr.td();
                if (!last)
                  td.style("border-left-width: 0px; border-bottom-style: none");
                else
                  td.style("border-left-width: 0px");
                td.tx(display == null ? "" : display);
              } else {
                td = tr.td(); // for display
                if (!last)
                  td.style("border-left-width: 0px; border-top-style: none; border-bottom-style: none");
                else
                  td.style("border-top-style: none; border-left-width: 0px");
              }
              for (String s : sources.keySet()) {
                if (s != null && !s.equals("code")) {
                  td = tr.td();
                  if (first) {
                    td.addText(getValue(ccm.getDependsOn(), s, sources.get(s).size() != 1));
                    display = getDisplay(ccm.getDependsOn(), s);
                    if (display != null)
                      td.tx(" ("+display+")");
                  }
                }
              }
              first = false;
              if (hasRelationships) {
                if (!ccm.hasRelationship())
                  tr.td();
                else {
                  if (ccm.getRelationshipElement().hasExtension(ToolingExtensions.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
                    String code = ToolingExtensions.readStringExtension(ccm.getRelationshipElement(), ToolingExtensions.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
                    tr.td().ah(eqpath+"#"+code, code).tx(presentEquivalenceCode(code));                
                  } else {
                    tr.td().ah(eqpath+"#"+ccm.getRelationship().toCode(), ccm.getRelationship().toCode()).tx(presentRelationshipCode(ccm.getRelationship().toCode()));
                  }
                }
              }
              td = tr.td().style("border-right-width: 0px");
              if (targets.get("code").size() == 1)
                td.addText(ccm.getCode());
              else
                td.addText(grp.getTarget()+" / "+ccm.getCode());
              display = ccm.hasDisplay() ? ccm.getDisplay() : getDisplayForConcept(systemFromCanonical(grp.getTarget()), versionFromCanonical(grp.getTarget()), ccm.getCode());
              tr.td().style("border-left-width: 0px").tx(display == null ? "" : display);

              for (String s : targets.keySet()) {
                if (s != null && !s.equals("code")) {
                  td = tr.td();
                  td.addText(getValue(ccm.getProduct(), s, targets.get(s).size() != 1));
                  display = getDisplay(ccm.getProduct(), s);
                  if (display != null)
                    td.tx(" ("+display+")");
                }
              }
              if (comment)
                tr.td().addText(ccm.getComment());

              for (String s : props.keySet()) {
                if (s != null) {
                  td = tr.td();
                  td.addText(getValue(ccm.getProperty(), s));
                }
              }
            }
          }
          addUnmapped(tbl, grp);
        }
      }
    }
    return true;
  }

  public void describe(XhtmlNode x, ConceptMap cm) {
    x.tx(display(cm));
  }

  public String display(ConceptMap cm) {
    return cm.present();
  }

  private boolean isSameCodeAndDisplay(String code, String display) {
    String c = code.replace(" ", "").replace("-", "").toLowerCase();
    String d = display.replace(" ", "").replace("-", "").toLowerCase();
    return c.equals(d);
  }


  private String presentRelationshipCode(String code) {
    if ("related-to".equals(code)) {
      return "is related to";
    } else if ("equivalent".equals(code)) {
      return "is equivalent to";
    } else if ("source-is-narrower-than-target".equals(code)) {
      return "is narrower than";
    } else if ("source-is-broader-than-target".equals(code)) {
      return "is broader than";
    } else if ("not-related-to".equals(code)) {
      return "is not related to";
    } else {
      return code;
    }
  }

  private String presentEquivalenceCode(String code) {
    if ("relatedto".equals(code)) {
      return "is related to";
    } else if ("equivalent".equals(code)) {
      return "is equivalent to";
    } else if ("equal".equals(code)) {
      return "is equal to";
    } else if ("wider".equals(code)) {
      return "maps to wider concept";
    } else if ("subsumes".equals(code)) {
      return "is subsumed by";
    } else if ("source-is-broader-than-target".equals(code)) {
      return "maps to narrower concept";
    } else if ("specializes".equals(code)) {
      return "has specialization";
    } else if ("inexact".equals(code)) {
      return "maps loosely to";
    } else if ("unmatched".equals(code)) {
      return "has no match";
    } else if ("disjoint".equals(code)) {
      return "is not related to";
    } else {
      return code;
    }
  }

  public void renderCSDetailsLink(XhtmlNode tr, String url, boolean span2) {
    CodeSystem cs;
    XhtmlNode td;
    cs = getContext().getWorker().fetchCodeSystem(url);
    td = tr.td();
    if (span2) {
      td.colspan("2");
    }
    td.b().tx("Codes");
    td.tx(" from ");
    if (cs == null)
      td.tx(url);
    else
      td.ah(context.fixReference(cs.getWebPath())).attribute("title", url).tx(cs.present());
  }

  private void addUnmapped(XhtmlNode tbl, ConceptMapGroupComponent grp) {
    if (grp.hasUnmapped()) {
//      throw new Error("not done yet");
    }
    
  }

  private String getDescForConcept(String s) {
    if (s.startsWith("http://hl7.org/fhir/v2/element/"))
        return "v2 "+s.substring("http://hl7.org/fhir/v2/element/".length());
    return s;
  }


  private String getValue(List<MappingPropertyComponent> list, String s) {
    return "todo";
  }

  private String getValue(List<OtherElementComponent> list, String s, boolean withSystem) {
    for (OtherElementComponent c : list) {
      if (s.equals(c.getAttribute()))
        if (withSystem)
          return /*c.getSystem()+" / "+*/c.getValue().primitiveValue();
        else
          return c.getValue().primitiveValue();
    }
    return null;
  }

  private String getDisplay(List<OtherElementComponent> list, String s) {
    for (OtherElementComponent c : list) {
      if (s.equals(c.getAttribute())) {
        // return getDisplayForConcept(systemFromCanonical(c.getSystem()), versionFromCanonical(c.getSystem()), c.getValue());
      }
    }
    return null;
  }

  public static XhtmlNode renderMultipleMaps(String start, List<ConceptMap> maps, IConceptMapInformationProvider linker, RenderMultiRowSortPolicy sort) {
    // 1+1 column for each provided map
    List<MultipleMappingRow> rowSets = new ArrayList<>();
    for (int i = 0; i < maps.size(); i++) {
      populateRows(rowSets, maps.get(i), i, linker);
    }
    collateRows(rowSets);
    if (sort != RenderMultiRowSortPolicy.UNSORTED) {
      Collections.sort(rowSets, new MultipleMappingRowSorter(sort == RenderMultiRowSortPolicy.FIRST_COL));
    }
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode tbl = div.table("none").style("text-align: left; border-spacing: 0; padding: 5px");
    XhtmlNode tr = tbl.tr();
    styleCell(tr.td(), false, true, 5).b().tx(start);
    for (ConceptMap map : maps) {
      if (map.hasWebPath()) {
        styleCell(tr.td(), false, true, 5).colspan(2).b().ah(map.getWebPath(), map.getVersionedUrl()).tx(map.present());
      } else {
        styleCell(tr.td(), false, true, 5).colspan(2).b().tx(map.present());
      }
    }
    for (MultipleMappingRow row : rowSets) {
      renderMultiRow(tbl, row, maps, linker);
    }
    return div;
  }

  private static void collateRows(List<MultipleMappingRow> rowSets) {
    List<MultipleMappingRow> toDelete = new ArrayList<ConceptMapRenderer.MultipleMappingRow>();
    for (MultipleMappingRow rowSet : rowSets) {
      MultipleMappingRow tgt = rowSet.stickySource;
      while (toDelete.contains(tgt)) {
        tgt = tgt.stickySource;
      }
      if (tgt != null && rowSets.contains(tgt)) {
        tgt.rowSets.addAll(rowSet.rowSets);
        toDelete.add(rowSet);
      }
    }
    rowSets.removeAll(toDelete);    
  }

  private static void renderMultiRow(XhtmlNode tbl, MultipleMappingRow rows, List<ConceptMap> maps, IConceptMapInformationProvider linker) {
    int rowCounter = 0;
    for (MultipleMappingRowItem row : rows.rowSets) {
      XhtmlNode tr = tbl.tr();
      boolean first = true;
      int cellCounter = 0;
      Cell last = null;
      for (Cell cell : row.cells) {
        if (first) {     
          if (!cell.renderedCode) { 
            int c = 1;
            for (int i = rowCounter + 1; i < rows.rowSets.size(); i++) {
              if (cell.code != null && rows.rowSets.get(i).cells.size() > cellCounter && cell.code.equals(rows.rowSets.get(i).cells.get(cellCounter).code)) {
                rows.rowSets.get(i).cells.get(cellCounter).renderedCode = true;
                c++;
              } else {
                break;
              }
            }  
            if (cell.code == null) {
              styleCell(tr.td(), rowCounter == 0, true, 5).rowspan(c).style("background-color: #eeeeee");
            } else {
              String link = linker.getLink(cell.system, cell.code);
              XhtmlNode x = null;
              if (link != null) {
                x = styleCell(tr.td(), rowCounter == 0, true, 5).attributeNN("title", cell.display).rowspan(c).ah(link);
              } else {
                x = styleCell(tr.td(), rowCounter == 0, true, 5).attributeNN("title", cell.display).rowspan(c);
              }
//              if (cell.clone != null) {
//                x.style("color: grey");
//              }
              x.tx(cell.present());
            }
          }
          first = false;
        } else {
          if (!cell.renderedRel) { 
            int c = 1;
            for (int i = rowCounter + 1; i < rows.rowSets.size(); i++) {
              if ((cell.relationship != null && rows.rowSets.get(i).cells.size() > cellCounter && cell.relationship.equals(rows.rowSets.get(i).cells.get(cellCounter).relationship)) && 
                  (cell.code != null && cell.code.equals(rows.rowSets.get(i).cells.get(cellCounter).code)) && 
                  (last.code != null && cell.code.equals(rows.rowSets.get(i).cells.get(cellCounter-1).code))) {
                rows.rowSets.get(i).cells.get(cellCounter).renderedRel = true;
                c++;
              } else {
                break;
              }
            }
            if (last.code == null || cell.code == null) {
              styleCell(tr.td(), rowCounter == 0, true, 5).style("background-color: #eeeeee");
            } else if (cell.relationship != null) {
              styleCell(tr.tdW(16), rowCounter == 0, true, 0).attributeNN("title", cell.relComment).rowspan(c).style("background-color: LightGrey; text-align: center; vertical-align: middle; color: white").tx(cell.relationship);
            } else {
              styleCell(tr.tdW(16), rowCounter == 0, false, 0).rowspan(c);
            }
          }
          if (!cell.renderedCode) { 
            int c = 1;
            for (int i = rowCounter + 1; i < rows.rowSets.size(); i++) {
              if (cell.code != null && rows.rowSets.get(i).cells.size() > cellCounter && cell.code.equals(rows.rowSets.get(i).cells.get(cellCounter).code)) {
                rows.rowSets.get(i).cells.get(cellCounter).renderedCode = true;
                c++;
              } else {
                break;
              }
            }
            if (cell.code == null) {
              styleCell(tr.td(), rowCounter == 0, true, 5).rowspan(c).style("background-color: #eeeeee");
            } else {
              String link = linker.getLink(cell.system, cell.code);
              XhtmlNode x = null;
              if (link != null) {
                x = styleCell(tr.td(), rowCounter == 0, true, 5).attributeNN("title", cell.display).rowspan(c).ah(link);
              } else {
                x = styleCell(tr.td(), rowCounter == 0, true, 5).attributeNN("title", cell.display).rowspan(c);                
              }
//              if (cell.clone != null) {
//                x.style("color: grey");
//              }
              x.tx(cell.present());
            }
          }
        }
        last = cell;
        cellCounter++;
      }
      rowCounter++;
    }    
  }

  private static XhtmlNode styleCell(XhtmlNode td, boolean firstrow, boolean sides, int padding) {
    if (firstrow) {
      td.style("vertical-align: middle; border-top: 1px solid black; padding: "+padding+"px");
    } else {
      td.style("vertical-align: middle; border-top: 1px solid LightGrey; padding: "+padding+"px");
    }
    if (sides) {
      td.style("border-left: 1px solid LightGrey; border-right: 2px solid LightGrey");
    }
    return td;
  }

  private static void populateRows(List<MultipleMappingRow> rowSets, ConceptMap map, int i, IConceptMapInformationProvider linker) {
    // if we can resolve the value set, we create entries for it
    if (map.hasSourceScope()) {
      List<Coding> codings = linker.getMembers(map.getSourceScope().primitiveValue());
      if (codings != null) {
        for (Coding c : codings) {
          MultipleMappingRow row = i == 0 ? null : findExistingRowBySource(rowSets, c.getSystem(), c.getCode(), i);
          if (row == null) {
            row = new MultipleMappingRow(i, c.getSystem(), c.getCode(), c.getDisplay());
            rowSets.add(row);
          } 
          
        }
      }
    }  
    
    for (ConceptMapGroupComponent grp : map.getGroup()) {
      for (SourceElementComponent src : grp.getElement()) {
        MultipleMappingRow row = findExistingRowBySource(rowSets, grp.getSource(), src.getCode(), i);
        if (row == null) {
          row = new MultipleMappingRow(i, grp.getSource(), src.getCode(), src.getDisplay());
          rowSets.add(row);
        } 
        if (src.getNoMap()) {
          row.addTerminus();
        } else {
          List<TargetElementComponent> todo = new ArrayList<>();
          for (TargetElementComponent tgt : src.getTarget()) {
            MultipleMappingRow trow = findExistingRowByTarget(rowSets, grp.getTarget(), tgt.getCode(), i);
            if (trow == null) {
              row.addTarget(grp.getTarget(), tgt.getCode(), tgt.getRelationship(), tgt.getComment(), rowSets, i);
            } else {
              todo.add(tgt);
            }
          }
          // we've already got a mapping to these targets. So we gather them under the one mapping - but do this after the others are done
          for (TargetElementComponent t : todo) {
            MultipleMappingRow trow = findExistingRowByTarget(rowSets, grp.getTarget(), t.getCode(), i);     
            if (row.alreadyHasMappings(i)) {
              // src is already mapped, and so is target, and now we need to map src to target too
              // we have to clone src, but we only clone the last
              trow.cloneSource(i, row.getLastSource(i));
            } else {
              trow.addSource(row, rowSets, t.getRelationship(), t.getComment());
            }
          }
        }
      }
      boolean copy = grp.hasUnmapped() && grp.getUnmapped().getMode() == ConceptMapGroupUnmappedMode.USESOURCECODE;
      if (copy) {
        for (MultipleMappingRow row : rowSets) {
          if (row.rowSets.get(0).cells.size() == i && row.lastSystem().equals(grp.getSource())) {
            row.addCopy(grp.getTarget());
          }
        }
      }
    } 
    for (MultipleMappingRow row : rowSets) {
      if (row.rowSets.get(0).cells.size() == i) {
        row.addTerminus();
      }
    }
    if (map.hasTargetScope()) {
      List<Coding> codings = linker.getMembers(map.getTargetScope().primitiveValue());
      if (codings != null) {
        for (Coding c : codings) {
          MultipleMappingRow row = findExistingRowByTarget(rowSets, c.getSystem(), c.getCode(), i);
          if (row == null) {
            row = new MultipleMappingRow(i+1, c.getSystem(), c.getCode(), c.getDisplay());
            rowSets.add(row);
          } else {
            for (MultipleMappingRowItem cells : row.rowSets) {
              Cell last = cells.cells.get(cells.cells.size() -1);
              if (last.system != null && last.system.equals(c.getSystem()) && last.code.equals(c.getCode()) && last.display == null) {
                last.display = c.getDisplay();
              }
            }
          }
        }
      }
    }

  }

  private static MultipleMappingRow findExistingRowByTarget(List<MultipleMappingRow> rows, String system, String code, int i) {
    for (MultipleMappingRow row : rows) {
      for (MultipleMappingRowItem cells : row.rowSets) {
        if (cells.cells.size() > i + 1 && cells.cells.get(i+1).matches(system, code)) {
          return row;
        }
      }
    }
    return null;
  }

  private static MultipleMappingRow findExistingRowBySource(List<MultipleMappingRow> rows, String system, String code, int i) {
    for (MultipleMappingRow row : rows) {
      for (MultipleMappingRowItem cells : row.rowSets) {
        if (cells.cells.size() > i && cells.cells.get(i).matches(system, code)) {
          return row;
        }
      }
    }
    return null;
  }
}
