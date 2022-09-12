package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.CodeSystem;
import org.hl7.fhir.r4b.model.ConceptMap;
import org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence;
import org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r4b.model.ConceptMap.OtherElementComponent;
import org.hl7.fhir.r4b.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r4b.model.ContactDetail;
import org.hl7.fhir.r4b.model.ContactPoint;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.utils.ToolingExtensions;
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
    return render(x, (ConceptMap) dr);
  }

  public boolean render(XhtmlNode x, ConceptMap cm) throws FHIRFormatError, DefinitionException, IOException {
    x.h2().addText(cm.getName()+" ("+cm.getUrl()+")");

    XhtmlNode p = x.para();
    p.tx("Mapping from ");
    if (cm.hasSource())
      AddVsRef(cm.getSource().primitiveValue(), p);
    else
      p.tx("(not specified)");
    p.tx(" to ");
    if (cm.hasTarget())
      AddVsRef(cm.getTarget().primitiveValue(), p);
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
    
    CodeSystem cs = getContext().getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-relationship");
    if (cs == null)
      cs = getContext().getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-equivalence");
    String eqpath = cs == null ? null : cs.getUserString("path");

    for (ConceptMapGroupComponent grp : cm.getGroup()) {
      String src = grp.getSource();
      boolean comment = false;
      boolean ok = true;
      Map<String, HashSet<String>> sources = new HashMap<String, HashSet<String>>();
      Map<String, HashSet<String>> targets = new HashMap<String, HashSet<String>>();
      sources.put("code", new HashSet<String>());
      targets.put("code", new HashSet<String>());
      SourceElementComponent cc = grp.getElement().get(0);
      String dst = grp.getTarget();
      sources.get("code").add(grp.getSource());
      targets.get("code").add(grp.getTarget());
      for (SourceElementComponent ccl : grp.getElement()) {
        ok = ok && ccl.getTarget().size() == 1 && ccl.getTarget().get(0).getDependsOn().isEmpty() && ccl.getTarget().get(0).getProduct().isEmpty();
        for (TargetElementComponent ccm : ccl.getTarget()) {
          comment = comment || !Utilities.noString(ccm.getComment());
          for (OtherElementComponent d : ccm.getDependsOn()) {
            if (!sources.containsKey(d.getProperty()))
              sources.put(d.getProperty(), new HashSet<String>());
            sources.get(d.getProperty()).add(d.getSystem());
          }
          for (OtherElementComponent d : ccm.getProduct()) {
            if (!targets.containsKey(d.getProperty()))
              targets.put(d.getProperty(), new HashSet<String>());
            targets.get(d.getProperty()).add(d.getSystem());
          }
        }
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
        tr = tbl.tr();
        XhtmlNode td = tr.td().colspan(comment ? "4" : "3");
        td.tx("Mapping from ");
        if (grp.hasSource()) {
          renderCanonical(cm, td, grp.getSource());
        } else {
          td.code("unspecified code system");
        }
        td.tx(" to ");
        if (grp.hasTarget()) {
          renderCanonical(cm, td, grp.getTarget());
        } else {
          td.code("unspecified code system");
        }
        for (SourceElementComponent ccl : grp.getElement()) {
          tr = tbl.tr();
          td = tr.td();
          td.addText(ccl.getCode());
          display = ccl.hasDisplay() ? ccl.getDisplay() : getDisplayForConcept(systemFromCanonical(grp.getSource()), versionFromCanonical(grp.getSource()), ccl.getCode());
          if (display != null && !isSameCodeAndDisplay(ccl.getCode(), display))
            td.tx(" ("+display+")");
          TargetElementComponent ccm = ccl.getTarget().get(0);
          if (!ccm.hasEquivalence())
            tr.td().tx(":"+"("+ConceptMapEquivalence.NULL.toCode()+")");
          else {
            String code = ccm.getEquivalenceElement().primitiveValue();
            tr.td().ah(eqpath+"#"+code).tx(presentEquivalenceCode(code));                
          }
          td = tr.td();
          td.addText(ccm.getCode());
          display = ccm.hasDisplay() ? ccm.getDisplay() : getDisplayForConcept(systemFromCanonical(grp.getTarget()), versionFromCanonical(grp.getTarget()), ccm.getCode());
          if (display != null && !isSameCodeAndDisplay(ccm.getCode(), display))
            td.tx(" ("+display+")");
          if (comment)
            tr.td().addText(ccm.getComment());
          addUnmapped(tbl, grp);
        }
      } else {
        boolean hasRelationships = false;
        for (int si = 0; si < grp.getElement().size(); si++) {
          SourceElementComponent ccl = grp.getElement().get(si);
          for (int ti = 0; ti < ccl.getTarget().size(); ti++) {
            TargetElementComponent ccm = ccl.getTarget().get(ti);
            if (ccm.hasEquivalence()) {
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
        tr = tbl.tr();
        if (sources.get("code").size() == 1) {
          String url = sources.get("code").iterator().next();
          renderCSDetailsLink(tr, url, true);           
        } else
          tr.td().b().tx("Code");
        for (String s : sources.keySet()) {
          if (!s.equals("code")) {
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
          if (!s.equals("code")) {
            if (targets.get(s).size() == 1) {
              String url = targets.get(s).iterator().next();
              renderCSDetailsLink(tr, url, false);           
            } else
              tr.td().b().addText(getDescForConcept(s));
          }
        }
        if (comment)
          tr.td();

        for (int si = 0; si < grp.getElement().size(); si++) {
          SourceElementComponent ccl = grp.getElement().get(si);
          boolean slast = si == grp.getElement().size()-1;
          boolean first = true;
          if (false) {
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
            display = getDisplayForConcept(systemFromCanonical(grp.getSource()), versionFromCanonical(grp.getSource()), ccl.getCode());
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
                if (!s.equals("code")) {
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
                if (!ccm.hasEquivalence())
                  tr.td();
                else {
                  String code = ccm.getEquivalenceElement().toString();
                  tr.td().ah(eqpath+"#"+code).tx(presentEquivalenceCode(code));                
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
                if (!s.equals("code")) {
                  td = tr.td();
                  td.addText(getValue(ccm.getProduct(), s, targets.get(s).size() != 1));
                  display = getDisplay(ccm.getProduct(), s);
                  if (display != null)
                    td.tx(" ("+display+")");
                }
              }
              if (comment)
                tr.td().addText(ccm.getComment());
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
      return "is narrower then";
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
    td.b().tx("Code");
    td.tx(" from ");
    if (cs == null)
      td.tx(url);
    else
      td.ah(context.fixReference(cs.getUserString("path"))).attribute("title", url).tx(cs.present());
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



  private String getValue(List<OtherElementComponent> list, String s, boolean withSystem) {
    for (OtherElementComponent c : list) {
      if (s.equals(c.getProperty()))
        if (withSystem)
          return /*c.getSystem()+" / "+*/c.getValue();
        else
          return c.getValue();
    }
    return null;
  }

  private String getDisplay(List<OtherElementComponent> list, String s) {
    for (OtherElementComponent c : list) {
      if (s.equals(c.getProperty())) {
        // return getDisplayForConcept(systemFromCanonical(c.getSystem()), versionFromCanonical(c.getSystem()), c.getValue());
      }
    }
    return null;
  }

}