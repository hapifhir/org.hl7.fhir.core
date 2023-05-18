package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.TestPlan;
import org.hl7.fhir.r5.model.TestPlan.TestCaseDependencyComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanDependencyComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseAssertionComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseTestDataComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseTestRunComponent;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class TestPlanRenderer extends ResourceRenderer {

	public TestPlanRenderer(RenderingContext context) {
		super(context);
	}

	public TestPlanRenderer(RenderingContext context, ResourceContext rcontext) {
		super(context, rcontext);
	}

	@Override
	public boolean render(XhtmlNode x, Resource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
		return render(x, (TestPlan) r);
	}

	public boolean render(XhtmlNode x, TestPlan tp) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
		XhtmlNode p = null;
		if (!tp.getContact().isEmpty()) {
			p = x.para();
      p.b().tx("Contact:");
			p.tx(" (");
			boolean firsti = true;
			for (ContactDetail ci : tp.getContact()) {
				if (firsti)
					firsti = false;
				else
					p.tx(", ");
				if (ci.hasName())
					p.addText(ci.getName() + ": ");
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

		if (tp.hasCategory()) {
			p = x.para();
			p.b().tx("Category: ");
      boolean first = true;
			for (CodeableConcept cc : tp.getCategory()) {
        if (first)
          first = false;
        else
          p.tx(", ");
				renderCodeableConcept(p, cc, false);
			}
		}

		if (tp.hasScope()) {
			if (tp.getScope().size() == 1) {
				p = x.para();
				p.b().tx("Test Plan Scope: ");
				renderReference(tp, p, tp.getScopeFirstRep());
			} else {
				x.para().b().tx("Test Plan Scopes:");
				XhtmlNode ul = x.ul();
				for (Reference ref : tp.getScope()) {
					renderReference(tp, ul.li(), ref);
				}
			}
		}

		if (tp.hasDependency()) {
			if (tp.getDependency().size() == 1) {
				p = x.para();
				p.b().tx("Test Plan Dependency: ");
				XhtmlNode t = x.table("grid");
				XhtmlNode tr = t.tr();
			    if (!Utilities.noString(tp.getDependencyFirstRep().getDescription())) {
			        addMarkdown(tr.td(), tp.getDependencyFirstRep().getDescription());
			    }
			    tr = t.tr();
				renderReference(tp, tr.td(), tp.getDependencyFirstRep().getPredecessor());
			} else {
				x.para().b().tx("Test Plan Dependencies:");
				XhtmlNode ul = x.ul();
				XhtmlNode li = null;
				for (TestPlanDependencyComponent d : tp.getDependency()) {
					li = ul.li();
				    if (!Utilities.noString(d.getDescription())) {
				        addMarkdown(li, d.getDescription());
				    }
				    else {
				    	li.addText("Dependency -  no description");
				    }
				    if (d.hasPredecessor()) {
						XhtmlNode liul = li.ul();
						XhtmlNode liulli = liul.li();
						renderReference(tp, liulli, d.getPredecessor());
				    }
				}
			}
		}

		if (tp.hasExitCriteria()) {
			addMarkdown(x, tp.getExitCriteria());
		}

		if (tp.hasTestCase()) {
		  for (TestPlanTestCaseComponent tc : tp.getTestCase()) {
		    x.h2().addText("Test Case" + (tc.hasSequence() ? " - Sequence" + tc.getSequence() : ""));

		    if (tc.hasScope()) {
		      if (tc.getScope().size() == 1) {
		        p = x.para();
		        p.b().tx("Test Case Scope: ");
		        renderReference(tp, p, tc.getScopeFirstRep());
		      } else {
		        x.para().b().tx("Test Case Scopes:");
		        XhtmlNode ul = x.ul();
		        for (Reference ref : tc.getScope()) {
		          renderReference(tp, ul.li(), ref);
		        }
		      }
		    }

		    if (tc.hasDependency()) {
		      if (tc.getDependency().size() == 1) {
		        x.h3().addText("Test Case Dependency");
		        XhtmlNode t = x.table("grid");
		        XhtmlNode tr = t.tr();
	          if (!Utilities.noString(tc.getDependencyFirstRep().getDescription())) {
	            addMarkdown(tr.td(), tc.getDependencyFirstRep().getDescription());
	          }
	          tr = t.tr();
	          renderReference(tp, tr.td(), tc.getDependencyFirstRep().getPredecessor());
		      } else {
            x.h3().addText("Test Case Dependencies");
		        XhtmlNode ul = x.ul();
		        XhtmlNode li = null;
		        for (TestCaseDependencyComponent d : tc.getDependency()) {
		          li = ul.li();
		            if (!Utilities.noString(d.getDescription())) {
		                addMarkdown(li, d.getDescription());
		            }
		            else {
		              li.addText("Dependency -  no description");
		            }
		            if (d.hasPredecessor()) {
		            XhtmlNode liul = li.ul();
		            XhtmlNode liulli = liul.li();
		            renderReference(tp, liulli, d.getPredecessor());
		            }
		        }
		      }
		    }

		    if (tc.hasTestRun()) {
		      if (tc.getTestRun().size() == 1) {
		        x.h3().addText("Test Run");
		        renderTestRun(x, tp, tc.getTestRunFirstRep());
		      }
		      else {
		        int count = 0;
		        for (TestPlanTestCaseTestRunComponent trun : tc.getTestRun()) {
		          count++;
		          x.h3().addText("Test Run " + count);
	            renderTestRun(x, tp, trun);
		        }
		      }
		    }

        if (tc.hasTestData()) {
          if (tc.getTestData().size() == 1) {
            x.h3().addText("Test Data");
            renderTestData(x, tp, tc.getTestDataFirstRep());
          }
          else {
            int count = 0;
            for (TestPlanTestCaseTestDataComponent tdata : tc.getTestData()) {
              count++;
              x.h3().addText("Test Data " + count);
              renderTestData(x, tp, tdata);
            }
          }
        }

	      if (tc.hasAssertion()) {
	        if (tc.getAssertion().size() == 1) {
	          x.h3().addText("Assertion");
	          renderAssertion(x, tp, tc.getAssertionFirstRep());
	        }
	        else {
	          int count = 0;
	          for (TestPlanTestCaseAssertionComponent as : tc.getAssertion()) {
	            count++;
	            x.h3().addText("Assertion " + count);
	            renderAssertion(x, tp, as);
	          }
	        }
	      }
		  }
    }

		return false;
	}

  private void renderTestRun(XhtmlNode x, TestPlan tp, TestPlanTestCaseTestRunComponent trun) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (trun.hasNarrative()) {
      addMarkdown(x, trun.getNarrative());
    }

    if (trun.hasScript()) {
      XhtmlNode t = x.table("grid");
      XhtmlNode tr = t.tr();
      tr.td().b().addText("Language");
      tr.td().b().addText("Source[x]");
      tr = t.tr();
      if (trun.getScript().hasLanguage()) {
        renderCodeableConcept(tr.td(), trun.getScript().getLanguage(), false);
      }
      else {
        tr.td().addText("??");
      }
      if (trun.getScript().hasSourceReference()) {
        renderReference(tp, tr.td(), trun.getScript().getSourceReference());
      }
      else if(trun.getScript().hasSourceStringType()) {
        tr.td().addText(trun.getScript().getSourceStringType().asStringValue());
      }
      else {
        tr.td().addText("??");
      }
    }
	}

  private void renderTestData(XhtmlNode x, TestPlan tp, TestPlanTestCaseTestDataComponent tdata) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    XhtmlNode t = x.table("grid");
    XhtmlNode tr = t.tr();
    tr.td().b().addText("Type");
    tr.td().b().addText("Content");
    tr.td().b().addText("Source[x]");
    tr = t.tr();
    if (tdata.hasType()) {
      renderCoding(tr.td(), tdata.getType());
    }
    else {
      tr.td().addText("??");
    }
    if (tdata.hasContent()) {
      renderReference(tp, tr.td(), tdata.getContent());
    }
    else {
      tr.td().addText("??");
    }
    if (tdata.hasSourceReference()) {
      renderReference(tp, tr.td(), tdata.getSourceReference());
    }
    else if(tdata.hasSourceStringType()) {
      tr.td().addText(tdata.getSourceStringType().asStringValue());
    }
    else {
      tr.td().addText("??");
    }
  }

  private void renderAssertion(XhtmlNode x, TestPlan tp, TestPlanTestCaseAssertionComponent as) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    XhtmlNode t = x.table("grid");
    XhtmlNode tr = t.tr();
    tr.td().b().addText("Type");
    tr.td().b().addText("Content");
    tr.td().b().addText("Result");
    tr = t.tr();
    if (as.hasType()) {
      XhtmlNode td = tr.td();
      XhtmlNode ul = td.ul();
      for (CodeableConcept cc : as.getType()) {
        renderCodeableConcept(ul.li(), cc, false);
      }
    }
    else {
      tr.td().addText("??");
    }
    if (as.hasObject()) {
      XhtmlNode td = tr.td();
      XhtmlNode ul = td.ul();
      for (CodeableReference cr : as.getObject()) {
        renderCodeableReference(ul.li(), cr, false);
      }
    }
    else {
      tr.td().addText("??");
    }
    if (as.hasResult()) {
      XhtmlNode td = tr.td();
      XhtmlNode ul = td.ul();
      for (CodeableReference cr : as.getResult()) {
        renderCodeableReference(ul.li(), cr, false);
      }
    }
    else {
      tr.td().addText("??");
    }
  }

	@Override
	public String display(Resource r) throws UnsupportedEncodingException, IOException {
		return null;
	}

	@Override
	public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
		if (r.has("title")) {
			return r.children("title").get(0).getBase().primitiveValue();
		}
		return "??";
	}

}
