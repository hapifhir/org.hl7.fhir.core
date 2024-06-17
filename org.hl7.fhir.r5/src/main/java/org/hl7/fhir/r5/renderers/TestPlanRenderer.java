package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class TestPlanRenderer extends ResourceRenderer {


  public TestPlanRenderer(RenderingContext context) { 
    super(context); 
  } 

  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement tp) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    XhtmlNode p = null;
    if (tp.has("contact")) {
      p = x.para();
      p.b().tx(context.formatPhrase(RenderingContext.GENERAL_CONTACT));
      p.tx(" (");
      boolean firsti = true;
      for (ResourceElement ci : tp.children("contact")) {
        if (firsti)
          firsti = false;
        else
          p.tx(", ");
        if (ci.has("name"))
          p.addText(ci.primitiveValue("name") + ": ");
        boolean first = true;
        for (ResourceElement c : ci.children("telecom")) {
          if (first)
            first = false;
          else
            p.tx(", ");
          addTelecom(p, c);
        }
      }
      p.tx(")");
    }

    if (tp.has("category")) {
      p = x.para();
      p.b().tx(context.formatPhrase(RenderingContext.TEST_PLAN_CATEGORY)+" ");
      boolean first = true;
      for (ResourceElement cc : tp.children("category")) {
        if (first)
          first = false;
        else
          p.tx(", ");
        renderCodeableConcept(status, p, cc);
      }
    }

    if (tp.has("scope")) {
      List<ResourceElement> scopes = tp.children("scope");
      if (scopes.size() == 1) {
        p = x.para();
        p.b().tx(context.formatPhrase(RenderingContext.TEST_PLAN_SCOPE)+" ");
        renderReference(status, p, scopes.get(0));
      } else {
        x.para().b().tx(context.formatPhrase(RenderingContext.TEST_PLAN_SCOPES));
        XhtmlNode ul = x.ul();
        for (ResourceElement ref : scopes) {
          renderReference(status, ul.li(), ref);
        }
      }
    }

    if (tp.has("dependency")) {
      List<ResourceElement> deps = tp.children("dependency");
      if (deps.size() == 1) {
        ResourceElement dep = deps.get(0);
        p = x.para();
        p.b().tx(context.formatPhrase(RenderingContext.TEST_PLAN_DEP)+" ");
        XhtmlNode t = x.table("grid");
        XhtmlNode tr = t.tr();
        if (!Utilities.noString(dep.primitiveValue("description"))) {
          addMarkdown(tr.td(), dep.primitiveValue("description"));
        }
        tr = t.tr();
        renderReference(status, tr.td(), dep.child("predecessor"));
      } else {
        x.para().b().tx(context.formatPhrase(RenderingContext.TEST_PLAN_DEPEN));
        XhtmlNode ul = x.ul();
        XhtmlNode li = null;
        for (ResourceElement d : deps) {
          li = ul.li();
          if (!Utilities.noString(d.primitiveValue("description"))) {
            addMarkdown(li, d.primitiveValue("description"));
          }
          else {
            li.addText(context.formatPhrase(RenderingContext.TEST_PLAN_DESC));
          }
          if (d.has("predecessor")) {
            XhtmlNode liul = li.ul();
            XhtmlNode liulli = liul.li();
            renderReference(status, liulli, d.child("predecessor"));
          }
        }
      }
    }

    if (tp.has("exitCriteria")) {
      addMarkdown(x, tp.primitiveValue("exitCriteria"));
    }

    for (ResourceElement tc : tp.children("testCase")) {
      x.h2().addText(tc.has("sequence") ? formatPhrase(RenderingContext.TEST_PLAN_CASE) : formatPhrase(RenderingContext.TEST_PLAN_CASE_SEQ, tc.primitiveValue("sequence")));

      if (tc.has("scope")) {
        List<ResourceElement> scopes = tc.children("scope");
        if (scopes.size() == 1) {
          p = x.para();
          p.b().tx(context.formatPhrase(RenderingContext.TEST_PLAN_SCOPE)+" ");
          renderReference(status, p, scopes.get(0));
        } else {
          x.para().b().tx(context.formatPhrase(RenderingContext.TEST_PLAN_SCOPES));
          XhtmlNode ul = x.ul();
          for (ResourceElement ref : scopes) {
            renderReference(status, ul.li(), ref);
          }
        }
      }

      if (tc.has("dependency")) {
        List<ResourceElement> deps = tc.children("dependency");
        if (deps.size() == 1) {
          ResourceElement dep = deps.get(0);
          x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_DEP));
          XhtmlNode t = x.table("grid");
          XhtmlNode tr = t.tr();
          if (!Utilities.noString(dep.primitiveValue("description"))) {
            addMarkdown(tr.td(), dep.primitiveValue("description"));
          }
          tr = t.tr();
          renderReference(status, tr.td(), dep.child("predecessor"));
              
        } else {
          x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_DEPEN));
          XhtmlNode ul = x.ul();
          XhtmlNode li = null;
          for (ResourceElement d : deps) {
            li = ul.li();
            if (!Utilities.noString(d.primitiveValue("description"))) {
              addMarkdown(li, d.primitiveValue("description"));
            }
            else {
              li.addText(context.formatPhrase(RenderingContext.TEST_PLAN_DESC));
            }
            if (d.has("predecessor")) {
              XhtmlNode liul = li.ul();
              XhtmlNode liulli = liul.li();
              renderReference(status, liulli, d.child("predecessor"));
            }
          }
        }
      }

      if (tc.has("testRun")) {
        List<ResourceElement> runs = tc.children("testRun");
        if (runs.size() == 1) {
          x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_RUN));
          renderTestRun(status, x, tp, runs.get(0));
        }
        else {
          int count = 0;
          for (ResourceElement trun : runs) {
            count++;
            x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_TEST_RUN, count)+" ");
            renderTestRun(status, x, tp, trun);
          }
        }
      }

      if (tc.has("testData")) {
        List<ResourceElement> dl = tc.children("testData");
        if (dl.size() == 1) {
          x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_DATA));
          renderTestData(status, x, tp, dl.get(0));
        }
        else {
          int count = 0;
          for (ResourceElement tdata : dl) {
            count++;
            x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_TEST_DATA, count)+" ");
            renderTestData(status, x, tp, tdata);
          }
        }
      }

      if (tc.has("assertion")) {
        List<ResourceElement> al = tc.children("assertion");
        if (al.size() == 1) {
          x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_ASS));
          renderAssertion(status, x, tp, al.get(0));
        }
        else {
          int count = 0;
          for (ResourceElement as : al) {
            count++;
            x.h3().addText(context.formatPhrase(RenderingContext.TEST_PLAN_ASSERTION, count)+" ");
            renderAssertion(status, x, tp, as);
          }
        }
      }
    }
  }

  private void renderTestRun(RenderingStatus status, XhtmlNode x, ResourceElement tp, ResourceElement trun) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (trun.hasNarrative()) {
      addMarkdown(x, trun.primitiveValue("narrative"));
    }

    if (trun.has("script")) {
      ResourceElement script = trun.child("script");
      XhtmlNode t = x.table("grid");
      XhtmlNode tr = t.tr();
      tr.td().b().addText(context.formatPhrase(RenderingContext.TEST_PLAN_LANG));
      tr.td().b().addText(context.formatPhrase(RenderingContext.TEST_PLAN_SOURCE));
      tr = t.tr();
      if (script.has("language")) {
        renderCodeableConcept(status, tr.td(), script.child("language"));
      } else {
        tr.td().addText("??");
      }
      if (script.has("source")) {
        renderDataType(status, tr.td(), script.child("script"));
      } else {
        tr.td().addText("??");
      }
    }
  }

  private void renderTestData(RenderingStatus status, XhtmlNode x, ResourceElement tp, ResourceElement tdata) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    XhtmlNode t = x.table("grid");
    XhtmlNode tr = t.tr();
    tr.td().b().addText(context.formatPhrase(RenderingContext.GENERAL_TYPE));
    tr.td().b().addText(context.formatPhrase(RenderingContext.GENERAL_CONTENT));
    tr.td().b().addText(context.formatPhrase(RenderingContext.TEST_PLAN_SOURCE));
    tr = t.tr();
    if (tdata.has("type")) {
      renderCoding(status, tr.td(), tdata.child("type"));
    }
    else {
      tr.td().addText("??");
    }
    if (tdata.has("content")) {
      renderReference(status, tr.td(), tdata.child("content"));
    }
    else {
      tr.td().addText("??");
    }
    if (tdata.has("source")) {
      renderDataType(status, tr.td(), tdata.child("source"));
    } else {
      tr.td().addText("??");
    }
  }

  private void renderAssertion(RenderingStatus status, XhtmlNode x, ResourceElement tp, ResourceElement as) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    XhtmlNode t = x.table("grid");
    XhtmlNode tr = t.tr();
    tr.td().b().addText(context.formatPhrase(RenderingContext.GENERAL_TYPE));
    tr.td().b().addText(context.formatPhrase(RenderingContext.GENERAL_CONTENT));
    tr.td().b().addText(context.formatPhrase(RenderingContext.TEST_PLAN_RESULT));
    tr = t.tr();
    if (as.has("type")) {
      XhtmlNode td = tr.td();
      XhtmlNode ul = td.ul();
      for (ResourceElement cc : as.children("type")) {
        renderCodeableConcept(status, ul.li(), cc);
      }
    }
    else {
      tr.td().addText("??");
    }
    if (as.has("object")) {
      XhtmlNode td = tr.td();
      XhtmlNode ul = td.ul();
      for (ResourceElement cr : as.children("object")) {
        renderCodeableReference(status, ul.li(), cr);
      }
    }
    else {
      tr.td().addText("??");
    }
    if (as.has("result")) {
      XhtmlNode td = tr.td();
      XhtmlNode ul = td.ul();
      for (ResourceElement cr : as.children("result")) {
        renderCodeableReference(status, ul.li(), cr);
      }
    }
    else {
      tr.td().addText("??");
    }
  }

}
