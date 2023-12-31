package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
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
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ConceptMapRenderer extends TerminologyRenderer {

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

}
