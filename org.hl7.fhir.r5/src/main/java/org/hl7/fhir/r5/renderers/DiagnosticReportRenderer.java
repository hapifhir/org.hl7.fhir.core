package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.DiagnosticReport;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class DiagnosticReportRenderer extends ResourceRenderer {

  public class ObservationNode {
    private String ref;
    private ResourceWithReference obs;
    private List<ObservationNode> contained;
  }


  public DiagnosticReportRenderer(RenderingContext context) {
    super(context);
  }

  public DiagnosticReportRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, DomainResource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (DiagnosticReport) dr);
  }

  public boolean render(XhtmlNode x, ResourceWrapper dr) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode h2 = x.h2();
    render(h2, getProperty(dr, "code").value());
    h2.tx(" ");
    PropertyWrapper pw = getProperty(dr, "category");
    if (valued(pw)) {
      h2.tx("(");
      boolean first = true;
      for (BaseWrapper b : pw.getValues()) {
        if (first) first = false; else h2.tx(", ");
        render(h2, b);
      }
      h2.tx(") ");
    }
    if (dr.has("issued")) {
      render(h2, getProperty(dr, "issued").value());
    }

    XhtmlNode tbl = x.table("grid");
    XhtmlNode tr = tbl.tr();
    XhtmlNode tdl = tr.td();
    XhtmlNode tdr = tr.td();
    populateSubjectSummary(tdl, getProperty(dr, "subject").value());
    tdr.b().tx("Report Details");
    tdr.br();
    pw = getProperty(dr, "perfomer");
    if (valued(pw)) {
      tdr.addText(Utilities.pluralize("Performer", pw.getValues().size())+":");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        render(tdr, v);
      }
      tdr.br();
    }
    pw = getProperty(dr, "identifier");
    if (valued(pw)) {
      tdr.addText(Utilities.pluralize("Identifier", pw.getValues().size())+":");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        render(tdr, v);
      }
      tdr.br();
    }
    pw = getProperty(dr, "request");
    if (valued(pw)) {
      tdr.addText(Utilities.pluralize("Request", pw.getValues().size())+":");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        render(tdr, v);
      }
      tdr.br();
    }

    pw = getProperty(dr, "result");
    if (valued(pw)) {
      List<ObservationNode> observations = fetchObservations(pw.getValues(), dr);
      buildObservationsTable(x, observations);
    }

    pw = getProperty(dr, "conclusion");
    if (valued(pw))
      render(x.para(), pw.value());

    pw = getProperty(dr, "result");
    if (valued(pw)) {
      XhtmlNode p = x.para();
      p.b().tx("Coded Diagnoses :");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        render(tdr, v);
      }
    }
    return false;
  }

  public boolean render(XhtmlNode x, DiagnosticReport dr) throws FHIRFormatError, DefinitionException, IOException {
    render(x, new DirectWrappers.ResourceWrapperDirect(this.context, dr));

    return true;
  }

  public void describe(XhtmlNode x, DiagnosticReport dr) {
    x.tx(display(dr));
  }

  public String display(DiagnosticReport dr) {
    return display(dr.getCode());
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return display((DiagnosticReport) r);
  }

  private void populateSubjectSummary(XhtmlNode container, BaseWrapper subject) throws UnsupportedEncodingException, FHIRException, IOException {
    ResourceWrapper r = fetchResource(subject);
    if (r == null)
      container.tx("Unable to get Patient Details");
    else if (r.getName().equals("Patient"))
      generatePatientSummary(container, r);
    else
      container.tx("Not done yet");
  }

  private void generatePatientSummary(XhtmlNode c, ResourceWrapper r) {
    c.tx("to do");
  }
  
  private List<ObservationNode> fetchObservations(List<BaseWrapper> list, ResourceWrapper rw) throws UnsupportedEncodingException, FHIRException, IOException {
    List<ObservationNode> res = new ArrayList<ObservationNode>();
    for (BaseWrapper b : list) {
      if (b.has("reference")) {
        ObservationNode obs = new ObservationNode();
        obs.ref = b.get("reference").primitiveValue();
        obs.obs = resolveReference(rw, obs.ref);
        if (obs.obs.getResource() != null) {
          PropertyWrapper t = getProperty(obs.obs.getResource(), "contained");
          if (t.hasValues()) {
            obs.contained = fetchObservations(t.getValues(), rw);
          }
        }
        res.add(obs);
      }
    }
    return res;
  }

  private void buildObservationsTable(XhtmlNode root, List<ObservationNode> observations) {
    XhtmlNode tbl = root.table( "none");
    for (ObservationNode o : observations) {
      addObservationToTable(tbl, o, 0);
    }
  }

  private void addObservationToTable(XhtmlNode tbl, ObservationNode o, int i) {
    XhtmlNode tr = tbl.tr();
    if (o.obs.getReference()  == null) {
      XhtmlNode td = tr.td().colspan("6");
      td.i().tx("This Observation could not be resolved");
    } else {
      if (o.obs.getResource() != null) {
        addObservationToTable(tr, o.obs.getResource(), i);
      } else {
        tr.td().tx("Unable to resolve Observation: "+o.obs.getReference());
      }
      if (o.contained != null) {
        for (ObservationNode c : o.contained) {
          addObservationToTable(tbl, c, i+1);
        }
      }
    } 
  }

  private void addObservationToTable(XhtmlNode tr, ResourceWrapper obs, int i) {
    // TODO Auto-generated method stub

    // code (+bodysite)
    XhtmlNode td = tr.td();
    PropertyWrapper pw = getProperty(obs, "code");
    if (valued(pw)) {
      render(td, pw.value());
    }
    pw = getProperty(obs, "bodySite");
    if (valued(pw)) {
      td.tx(" (");
      render(td, pw.value());
      td.tx(")");
    }

    // value / dataAbsentReason (in red)
    td = tr.td();
    pw = getProperty(obs, "value[x]");
    if (valued(pw)) {
      render(td, pw.value());
    }

    // units
    td = tr.td();
    td.tx("to do");

    // reference range
    td = tr.td();
    td.tx("to do");

    // flags (status other than F, interpretation, )
    td = tr.td();
    td.tx("to do");

    // issued if different to DR
    td = tr.td();
    td.tx("to do");
  }

}
