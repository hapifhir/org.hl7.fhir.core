package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DiagnosticReport;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.utils.EOperationOutcome;
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
  
  public boolean render(XhtmlNode x, Resource dr) throws IOException, FHIRException, EOperationOutcome {
    return render(x, (DiagnosticReport) dr);
  }

  public boolean render(XhtmlNode x, ResourceWrapper dr) throws IOException, FHIRException, EOperationOutcome {
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
    XhtmlNode tbl = x.table("grid");
    XhtmlNode tr;
    if (dr.has("subject")) {
       tr = tbl.tr();
       tr.td().tx("Subject");
       populateSubjectSummary(tr.td(), getProperty(dr, "subject").value());
    }
    
    DataType eff = null;
    DataType iss = null;
    
    if (dr.has("effective[x]")) {
      tr = tbl.tr();
      tr.td().tx("When For");
      eff = (DataType) getProperty(dr, "effective[x]").value().getBase();
      render(tr.td(), eff);
    }
    if (dr.has("issued")) {
      tr = tbl.tr();
      tr.td().tx("Reported");
      eff = (DataType) getProperty(dr, "issued").value().getBase();
      render(tr.td(), getProperty(dr, "issued").value());
    }

    pw = getProperty(dr, "perfomer");
    if (valued(pw)) {
      tr = tbl.tr();
      tr.td().tx(Utilities.pluralize("Performer", pw.getValues().size()));
      XhtmlNode tdr = tr.td();
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        render(tdr, v);
      }
    }
    pw = getProperty(dr, "identifier");
    if (valued(pw)) {
      tr = tbl.tr();
      tr.td().tx(Utilities.pluralize("Identifier", pw.getValues().size())+":");
      XhtmlNode tdr = tr.td();
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        render(tdr, v);
      }
    }
    pw = getProperty(dr, "request");
    if (valued(pw)) {
      tr = tbl.tr();
      tr.td().tx(Utilities.pluralize("Request", pw.getValues().size())+":");
      XhtmlNode tdr = tr.td();
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        render(tdr, v);
      }
      tdr.br();
    }

    
    x.para().b().tx("Report Details");

    pw = getProperty(dr, "result");
    if (valued(pw)) {
      List<ObservationNode> observations = fetchObservations(pw.getValues(), dr);
      buildObservationsTable(x, observations, eff, iss);
    }

    pw = getProperty(dr, "conclusion");
    if (valued(pw)) {
      if (pw.fhirType().equals("markdown")) {        
        render(x, pw.value());        
      } else {
        render(x.para(), pw.value());
      }
    }

    pw = getProperty(dr, "conclusionCode");
    if (!valued(pw)) {
      pw = getProperty(dr, "codedDiagnosis");    
    }
    if (valued(pw)) {
      XhtmlNode p = x.para();
      p.b().tx("Coded Conclusions :");
      XhtmlNode ul = x.ul();
      for (BaseWrapper v : pw.getValues()) {
        render(ul.li(), v);
      }
    }
    return false;
  }

  public boolean render(XhtmlNode x, DiagnosticReport dr) throws IOException, FHIRException, EOperationOutcome {
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

  @Override
  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return "Not done yet";
  }

  private void populateSubjectSummary(XhtmlNode container, BaseWrapper subject) throws UnsupportedEncodingException, FHIRException, IOException, EOperationOutcome {
    ResourceWrapper r = fetchResource(subject);
    if (r == null)
      container.tx("Unable to get Patient Details");
    else if (r.getName().equals("Patient"))
      generatePatientSummary(container, r);
    else
      container.tx("Not done yet");
  }

  private void generatePatientSummary(XhtmlNode c, ResourceWrapper r) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    new PatientRenderer(context).describe(c, r);
  }
  
  private List<ObservationNode> fetchObservations(List<BaseWrapper> list, ResourceWrapper rw) throws UnsupportedEncodingException, FHIRException, IOException {
    List<ObservationNode> res = new ArrayList<ObservationNode>();
    for (BaseWrapper b : list) {
      if (b.has("reference")) {
        ObservationNode obs = new ObservationNode();
        obs.ref = b.get("reference").primitiveValue();
        obs.obs = resolveReference(rw, obs.ref);
        if (obs.obs != null && obs.obs.getResource() != null) {
          PropertyWrapper t = getProperty(obs.obs.getResource(), "contained");
          if (t != null && t.hasValues()) {
            obs.contained = fetchObservations(t.getValues(), rw);
          }
        }
        res.add(obs);
      }
    }
    return res;
  }

  private void buildObservationsTable(XhtmlNode root, List<ObservationNode> observations, DataType eff, DataType iss) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tbl = root.table("grid");
    boolean refRange = scanObsForRefRange(observations);
    boolean flags = scanObsForFlags(observations); 
    boolean note = scanObsForNote(observations);
    boolean effectiveTime = scanObsForEffective(observations, eff);
    boolean issued = scanObsForIssued(observations, iss);
    int cs = 2;
    if (refRange) cs++;
    if (flags) cs++;
    if (note) cs++;
    if (issued) cs++;
    if (effectiveTime) cs++;
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx("Code");
    tr.td().b().tx("Value");
    if (refRange) {
      tr.td().b().tx("Reference Range");
    }
    if (flags) {
      tr.td().b().tx("Flags");
    }
    if (note) {
      tr.td().b().tx("Note");
    }
    if (effectiveTime) {
      tr.td().b().tx("When For");
    }
    if (issued) {
      tr.td().b().tx("Reported");
    }
    for (ObservationNode o : observations) {
      addObservationToTable(tbl, o, 0, Integer.toString(cs), refRange, flags, note, effectiveTime, issued, eff, iss);
    }
  }

  private boolean scanObsForRefRange(List<ObservationNode> observations) {
    for (ObservationNode o : observations) {
      if (o.obs != null && o.obs.getResource() != null) {
        PropertyWrapper pw = getProperty(o.obs.getResource(), "referenceRange");
        if (valued(pw)) {
          return true;
        }        
      }
      if (o.contained != null) {
        if (scanObsForRefRange(o.contained)) {
          return true;
        }
      }
    }      
    return false;
  }

  private boolean scanObsForNote(List<ObservationNode> observations) {
    for (ObservationNode o : observations) {
      if (o.obs != null && o.obs.getResource() != null) {
        PropertyWrapper pw = getProperty(o.obs.getResource(), "note");
        if (valued(pw)) {
          return true;
        }        
      }
      if (o.contained != null) {
        if (scanObsForNote(o.contained)) {
          return true;
        }
      }
    }      
    return false;
  }

  private boolean scanObsForIssued(List<ObservationNode> observations, DataType iss) throws UnsupportedEncodingException, FHIRException, IOException {
    for (ObservationNode o : observations) {
      if (o.obs != null && o.obs.getResource() != null) {
        PropertyWrapper pw = getProperty(o.obs.getResource(), "issued");
        if (valued(pw)) {
          if (!Base.compareDeep(pw.value().getBase(), iss, true)) {
            return true;
          }
        }        
      }
      if (o.contained != null) {
        if (scanObsForIssued(o.contained, iss)) {
          return true;
        }
      }
    }      
    return false;
  }

  private boolean scanObsForEffective(List<ObservationNode> observations, DataType eff) throws UnsupportedEncodingException, FHIRException, IOException {
    for (ObservationNode o : observations) {
      if (o.obs != null && o.obs.getResource() != null) {
        PropertyWrapper pw = getProperty(o.obs.getResource(), "effective[x]");
        if (valued(pw)) {
          if (!Base.compareDeep(pw.value().getBase(), eff, true)) {
            return true;
          }
        }        
      }
      if (o.contained != null) {
        if (scanObsForEffective(o.contained, eff)) {
          return true;
        }
      }
    }      
    return false;
  }

  private boolean scanObsForFlags(List<ObservationNode> observations) throws UnsupportedEncodingException, FHIRException, IOException {
    for (ObservationNode o : observations) {
      if (o.obs != null && o.obs.getResource() != null) {
        PropertyWrapper pw = getProperty(o.obs.getResource(), "interpretation");
        if (valued(pw)) {
          return true;
        }
        pw = getProperty(o.obs.getResource(), "status");
        if (valued(pw)) {
          if (!pw.value().getBase().primitiveValue().equals("final")) {
            return true;
          }
        }
        
      }
      if (o.contained != null) {
        if (scanObsForFlags(o.contained)) {
          return true;
        }
      }
    }      
    return false;
  }

  private void addObservationToTable(XhtmlNode tbl, ObservationNode o, int i, String cs, boolean refRange, boolean flags, boolean note, boolean effectiveTime, boolean issued, DataType eff, DataType iss) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tr = tbl.tr();
    if (o.obs != null && o.obs.getReference()  == null) {
      XhtmlNode td = tr.td().colspan(cs);
      td.i().tx("This Observation could not be resolved");
    } else {
      if (o.obs != null && o.obs.getResource() != null) {
        addObservationToTable(tr, o.obs.getResource(), i, o.obs.getReference(), refRange, flags, note, effectiveTime, issued, eff, iss);
      } else {
        XhtmlNode td = tr.td().colspan(cs);
        td.i().tx("Observation");
      }
      if (o.contained != null) {
        for (ObservationNode c : o.contained) {
          addObservationToTable(tbl, c, i+1, cs, refRange, flags, note, effectiveTime, issued, eff, iss);
        }
      }
    } 
  }

  private void addObservationToTable(XhtmlNode tr, ResourceWrapper obs, int i, String ref, boolean refRange, boolean flags, boolean note, boolean effectiveTime, boolean issued, DataType eff, DataType iss) throws UnsupportedEncodingException, FHIRException, IOException {

    // code (+bodysite)
    XhtmlNode td = tr.td();
    PropertyWrapper pw = getProperty(obs, "code");
    if (valued(pw)) {
      render(td.ah(ref), pw.value());
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
    } else {
      pw = getProperty(obs, "dataAbsentReason");
      if (valued(pw)) {
        XhtmlNode span = td.span("color: maroon", "Error");
        span.tx("Error: ");
        render(span.b(), pw.value());
      }
    }
    if (refRange) {
      // reference range
      td = tr.td();
      pw = getProperty(obs, "referenceRange");
      if (valued(pw)) {
        boolean first = true;
        for (BaseWrapper v : pw.getValues()) {
          if (first) first = false; else td.br();
          PropertyWrapper pwr = getProperty(v, "type"); 
          if (valued(pwr)) {
            render(td, pwr.value());
            td.tx(": ");
          }
          PropertyWrapper pwt = getProperty(v, "text"); 
          if (valued(pwt)) {
            render(td, pwt.value());
          } else {
            PropertyWrapper pwl = getProperty(v, "low"); 
            PropertyWrapper pwh = getProperty(v, "high"); 
            if (valued(pwl) && valued(pwh)) {
              render(td, pwl.value());
              td.tx(" - ");
              render(td, pwh.value());
            } else if (valued(pwl)) {
              td.tx(">");
              render(td, pwl.value());
            } else if (valued(pwh)) {
              td.tx("<");
              render(td, pwh.value());
            } else {
              td.tx("??");
            }
          }
          pwr = getProperty(v, "appliesTo"); 
          PropertyWrapper pwrA = getProperty(v, "age"); 
          if (valued(pwr) || valued(pwrA)) {
            boolean firstA = true;
            td.tx(" for ");
            if (valued(pwr)) {
              for (BaseWrapper va : pwr.getValues()) {
                if (firstA) firstA = false; else td.tx(", ");
                render(td, va);
              }
            }
            if (valued(pwrA)) {
              if (firstA) firstA = false; else td.tx(", ");
              td.tx("Age ");
              render(td, pwrA.value());
            }
          }
        }        
      }      
    }
    if (flags) {
      // flags (status other than F, interpretation, )
      td = tr.td();
      boolean first = true;
      pw = getProperty(obs, "status");
      if (valued(pw)) {
        if (!pw.value().getBase().primitiveValue().equals("final")) {
          if (first) first = false; else td.br();
          render(td, pw.value());
        }
      }
      pw = getProperty(obs, "interpretation");
      if (valued(pw)) {
        for (BaseWrapper v : pw.getValues()) {
          if (first) first = false; else td.br();
          render(td, v);
        }
      }
    }

    if (note) {
      td = tr.td();
      pw = getProperty(obs, "note");
      if (valued(pw)) {
        render(td, pw.value());
      }
    }
    if (effectiveTime) {
      // effective if different to DR
      td = tr.td();
      pw = getProperty(obs, "effective[x]");
      if (valued(pw)) {
        if (!Base.compareDeep(pw.value().getBase(), eff, true)) {
          render(td, pw.value());
        }
      }
    }
    if (issued) {
      // issued if different to DR
      td = tr.td();
      pw = getProperty(obs, "issued");
      if (valued(pw)) {
        if (!Base.compareDeep(pw.value().getBase(), eff, true)) {
          render(td, pw.value());
        }
      }
    }
  }
}
