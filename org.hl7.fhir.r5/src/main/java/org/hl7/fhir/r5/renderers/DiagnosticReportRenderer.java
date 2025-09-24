package org.hl7.fhir.r5.renderers; 

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class DiagnosticReportRenderer extends ResourceRenderer { 

  public class ObservationNode { 
    private String ref; 
    private ResourceWithReference resolution;
    private List<ObservationNode> contained; 
  } 

  public DiagnosticReportRenderer(RenderingContext context) { 
    super(context); 
  } 

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper dr) throws IOException, FHIRException, EOperationOutcome {
    renderDiagnosticReport(status, x, dr);
  }

  public void renderDiagnosticReport(RenderingStatus status, XhtmlNode x, ResourceWrapper dr) throws IOException, FHIRException, EOperationOutcome {
   renderResourceTechDetails(dr, x);
    
    XhtmlNode h2 = x.h2(); 
    renderDataType(status, h2, dr.child("code")); 
    h2.tx(" "); 
    List<ResourceWrapper> cats = dr.children("category"); 
    if (!cats.isEmpty()) { 
      h2.tx("("); 
      boolean first = true; 
      for (ResourceWrapper b : cats) { 
        if (first) first = false; else h2.tx(", "); 
        renderDataType(status, h2, b); 
      } 
      h2.tx(") "); 
    } 
    XhtmlNode tbl = x.table("grid", false); 
    XhtmlNode tr;
    if (dr.has("subject")) { 
      tr = tbl.tr(); 
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_SUBJ)); 
      populateSubjectSummary(status, tr.td(), dr.child("subject")); 
    } 

    ResourceWrapper eff = null;
    ResourceWrapper iss = null;
    if (dr.has("effective[x]")) { 
      tr = tbl.tr(); 
      tr.td().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_WHEN));
      eff = dr.child("effective[x]");
      renderDataType(status, tr.td(), eff); 
    } 
    if (dr.has("issued")) { 
      tr = tbl.tr(); 
      tr.td().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_REP)); 
      iss = dr.child("issued");
      renderDataType(status, tr.td(), iss); 
    } 

    addTableRow(status, tbl, dr, RenderingContext.DIAG_REP_REND_PER, "performer");
    addTableRow(status, tbl, dr, RenderingContext.DIAG_REP_REND_IDENTIFIER, "identifier");
    addTableRow(status, tbl, dr, RenderingContext.GENERAL_REQUEST, "request"); 

    x.para().b().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_REPDET)); 

    List<ResourceWrapper> items = dr.children("result"); 
    if (!items.isEmpty()) { 
      List<ObservationNode> observations = fetchObservations(items); 
      buildObservationsTable(status, x, observations, eff, iss); 
    } 

    if (dr.has("conclusion")) { 
      ResourceWrapper conc = dr.child("conclusion");
      if (conc.fhirType().equals("markdown")) {         
        renderDataType(status, x, conc);         
      } else { 
        renderDataType(status, x.para(), conc); 
      } 
    } 

    if (dr.hasMN("conclusionCode", "codedDiagnosis")) {
      x.para().b().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_CODECON));
      addListRows(status, x.ul(), dr, RenderingContext.DIAG_REP_REND_CODECON, "conclusionCode", "codedDiagnosis"); 
    }
    
    for (ResourceWrapper cont : dr.children("contained")) {
      x.hr();
      RendererFactory.factory(cont, context.forContained()).setInner(true).buildNarrative(status, x, cont);
    }
  } 

  private void addTableRow(RenderingStatus status, XhtmlNode tbl, ResourceWrapper dr, String constName, String... names) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> items = dr.childrenMN(names); 
    if (!items.isEmpty()) { 
      XhtmlNode tr = tbl.tr(); 
      tr.td().tx(Utilities.pluralize(context.formatPhrase(constName), items.size())); 
      XhtmlNode tdr = tr.td(); 
      for (ResourceWrapper v : items) { 
        tdr.tx(" "); 
        renderDataType(status, tdr, v); 
      } 
    } 
  }

  private void addListRows(RenderingStatus status, XhtmlNode ul, ResourceWrapper dr, String constName, String... names) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> items = dr.childrenMN(names); 
    if (!items.isEmpty()) { 
      for (ResourceWrapper v : items) { 
        XhtmlNode li = ul.li(); 
        renderDataType(status, li, v); 
      } 
    } 
  }

  public void describeDiagnosticReport(XhtmlNode x, ResourceWrapper dr) { 
    x.tx(displayDiagnosticReport(dr)); 
  } 

  public String displayDiagnosticReport(ResourceWrapper dr) {
    ResourceWrapper c = dr.child("code");
    String cd = c == null ? context.formatPhrase(RenderingContext.DIAG_REP_UNSPECIFIED_CODE) : displayCodeableConcept(c);
    ResourceWrapper s = dr.child("subject");
    String sd = s == null ? context.formatPhrase(RenderingContext.DIAG_REP_UNSPECIFIED_SUBJECT) : displayReference(s);
    return context.formatPhrase(RenderingContext.DIAG_REP_SUMMARY, cd, sd);
  } 

  @Override 
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException { 
    return displayDiagnosticReport(r); 
  } 


  private void populateSubjectSummary(RenderingStatus status, XhtmlNode container, ResourceWrapper subject) throws UnsupportedEncodingException, FHIRException, IOException, EOperationOutcome { 
    ResourceWithReference r = resolveReference(subject); 
    if (r == null) 
      container.tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_UNABLE)); 
    else if (r.getResource().fhirType().equals("Patient")) 
      generatePatientSummary(status, container, r.getResource()); 
    else 
      container.tx(context.formatPhrase(RenderingContext.GENERAL_TODO)); 
  } 

  private void generatePatientSummary(RenderingStatus status, XhtmlNode c, ResourceWrapper r) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome { 
    new PatientRenderer(context).buildSummary(status, c, r); 
  } 

  private List<ObservationNode> fetchObservations(List<ResourceWrapper> list) throws UnsupportedEncodingException, FHIRException, IOException { 
    List<ObservationNode> res = new ArrayList<ObservationNode>(); 
    for (ResourceWrapper b : list) { 
      if (b.has("reference")) { 
        ObservationNode obs = new ObservationNode(); 
        obs.ref = b.primitiveValue("reference"); 
        obs.resolution = resolveReference(b.child("reference")); 
        if (obs.resolution != null && obs.resolution.getResource() != null) { 
          List<ResourceWrapper> t = obs.resolution.getResource().children("contained"); 
          if (!t.isEmpty()) { 
            obs.contained = fetchObservations(t); 
          } 
        } 
        res.add(obs); 
      } 
    } 
    return res; 
  } 

  private void buildObservationsTable(RenderingStatus status, XhtmlNode root, List<ObservationNode> observations, ResourceWrapper eff, ResourceWrapper iss) throws UnsupportedEncodingException, FHIRException, IOException { 
    XhtmlNode tbl = root.table("grid", false); 
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
    tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE)); 
    tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_VALUE)); 
    if (refRange) { 
      tr.td().b().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_REFRAN)); 
    } 
    if (flags) { 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_FLAGS)); 
    } 
    if (note) { 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_NOTE)); 
    } 
    if (effectiveTime) { 
      tr.td().b().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_WHEN)); 
    } 
    if (issued) { 
      tr.td().b().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_REP)); 
    } 
    for (ObservationNode o : observations) { 
      addObservationToTable(status, tbl, o, 0, Integer.toString(cs), refRange, flags, note, effectiveTime, issued, eff, iss); 
    } 
  } 

  private boolean scanObsForRefRange(List<ObservationNode> observations) { 
    for (ObservationNode o : observations) {  
      if (o.resolution != null) {
        ResourceWrapper obs = o.resolution.getResource();
        if (obs != null && obs.has("referenceRange")) { 
          return true; 
        } 
        if (o.contained != null) { 
          if (scanObsForRefRange(o.contained)) { 
            return true; 
          } 
        } 
      }
    }       
    return false; 
  } 

  private boolean scanObsForNote(List<ObservationNode> observations) { 
    for (ObservationNode o : observations) { 
      if (o.resolution != null) {
        ResourceWrapper obs = o.resolution.getResource();
        if (obs != null && obs.has("note")) { 
          return true; 
        } 
        if (o.contained != null) { 
          if (scanObsForNote(o.contained)) { 
            return true; 
          } 
        } 
      }
    }       
    return false; 
  } 

  private boolean scanObsForIssued(List<ObservationNode> observations, ResourceWrapper iss) throws UnsupportedEncodingException, FHIRException, IOException { 
    for (ObservationNode o : observations) { 
      if (o.resolution != null) {
        ResourceWrapper obs = o.resolution.getResource();
        if (obs != null && obs.has("issued") && (iss == null || !iss.matches(obs.child("issued")))) { 
          return true; 
        } 
        if (o.contained != null) { 
          if (scanObsForIssued(o.contained, iss)) { 
            return true; 
          } 
        } 
      }
    }       
    return false; 
  } 

  private boolean scanObsForEffective(List<ObservationNode> observations, ResourceWrapper eff) throws UnsupportedEncodingException, FHIRException, IOException { 
    for (ObservationNode o : observations) { 
      if (o.resolution != null) {
        ResourceWrapper obs = o.resolution.getResource();
        if (obs != null && obs.has("effective[x]") && (eff == null || !eff.matches(obs.child("effective[x]")))) { 
          return true; 
        } 
        if (o.contained != null) { 
          if (scanObsForEffective(o.contained, eff)) { 
            return true; 
          } 
        } 
      }
    }       
    return false; 
  } 

  private boolean scanObsForFlags(List<ObservationNode> observations) throws UnsupportedEncodingException, FHIRException, IOException { 
    for (ObservationNode o : observations) { 
      if (o.resolution != null) {
        ResourceWrapper obs = o.resolution.getResource();
        if (obs != null && (obs.has("interpretation") || obs.has("status"))) { 
          return true; 
        } 
        if (o.contained != null) { 
          if (scanObsForFlags(o.contained)) { 
            return true; 
          } 
        } 
      }
    }       
    return false; 
  } 

  private void addObservationToTable(RenderingStatus status, XhtmlNode tbl, ObservationNode o, int i, String cs, boolean refRange, boolean flags, boolean note, boolean effectiveTime, boolean issued, ResourceWrapper eff, ResourceWrapper iss) throws UnsupportedEncodingException, FHIRException, IOException { 
    XhtmlNode tr = tbl.tr(); 
    if (o.resolution == null) { 
      XhtmlNode td = tr.td().colspan(cs); 
      td.i().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_NOTRES, o.ref)); 
    } else { 
      if (o.resolution.getResource() != null) { 
        addObservationToTable(status, tr, o.resolution.getResource(), i, o.resolution.getWebPath(), refRange, flags, note, effectiveTime, issued, eff, iss); 
      } else { 
        XhtmlNode td = tr.td().colspan(cs); 
        td.i().tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_OBS)); 
      } 
      if (o.contained != null) { 
        for (ObservationNode c : o.contained) { 
          addObservationToTable(status, tbl, c, i+1, cs, refRange, flags, note, effectiveTime, issued, eff, iss); 
        } 
      } 
    }  
  } 

  private void addObservationToTable(RenderingStatus status, XhtmlNode tr, ResourceWrapper obs, int i, String ref, boolean refRange, boolean flags, boolean note, boolean effectiveTime, boolean issued, ResourceWrapper eff, ResourceWrapper iss) throws UnsupportedEncodingException, FHIRException, IOException { 

    // code (+bodysite) 
    XhtmlNode td = tr.td(); 
    if (obs.has("code")) { 
      renderDataType(status, td.ah(context.prefixLocalHref(ref)), obs.child("code")); 
    } 
    if (obs.has("bodySite")) { 
      td.tx(" ("); 
      renderDataType(status, td, obs.child("bodySite")); 
      td.tx(")"); 
    } 

    // value / dataAbsentReason (in red) 
    td = tr.td(); 
    if (obs.has("value[x]")) { 
      renderDataType(status, td, obs.child("value[x]")); 
    } else if (obs.has("dataAbsentReason")) { 
      XhtmlNode span = td.span("color: maroon", "Error"); 
      span.tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_ERR) + " "); 
      renderDataType(status, span.b(), obs.child("dataAbsentReason")); 
    } 

    if (refRange) { 
      // reference range 
      td = tr.td(); 
      List<ResourceWrapper> items = obs.children("referenceRange"); 
      if (!items.isEmpty()) { 
        boolean first = true; 
        for (ResourceWrapper v : items) { 
          if (first) first = false; else td.br(); 
          ResourceWrapper pwr = v.child("type");  
          if (pwr != null) { 
            renderDataType(status, td, pwr); 
            td.tx(": "); 
          } 
          ResourceWrapper pwt = v.child("text");  
          if (pwt != null) { 
            renderDataType(status, td, pwt); 
          } else { 
            ResourceWrapper pwl = v.child("low");  
            ResourceWrapper pwh = v.child("high");  
            if (pwl != null && pwh != null) { 
              renderDataType(status, td, pwl); 
              td.tx(" - "); 
              renderDataType(status, td, pwh); 
            } else if (pwl != null) { 
              td.tx(">"); 
              renderDataType(status, td, pwl); 
            } else if (pwh != null) { 
              td.tx("<"); 
              renderDataType(status, td, pwh); 
            } else { 
              td.tx("??"); 
            } 
          } 
          List<ResourceWrapper> pwrF = v.children("appliesTo");  
          ResourceWrapper pwrA = v.child("age");  
          if (!pwrF.isEmpty() || pwrA != null) { 
            boolean firstA = true; 
            td.tx(" "+ (context.formatPhrase(RenderingContext.DIAG_REP_REND_FOR)) + " "); 
            if (!pwrF.isEmpty()) { 
              for (ResourceWrapper va : pwrF) { 
                if (firstA) firstA = false; else td.tx(", "); 
                renderDataType(status, td, va); 
              } 
            } 
            if (pwrA != null) { 
              if (firstA) firstA = false; else td.tx(", "); 
              td.tx(context.formatPhrase(RenderingContext.DIAG_REP_REND_AGE) + " "); 
              renderDataType(status, td, pwrA); 
            } 
          } 
        }         
      }       
    } 

    addCellToTable(flags, status, tr, obs, null, "status", "interpretation");
    addCellToTable(note, status, tr, obs, null, "note");
    addCellToTable(effectiveTime, status, tr, obs, eff, "effective[x]");
    addCellToTable(issued, status, tr, obs, iss, "issued");

  }

  private void addCellToTable(boolean included, RenderingStatus status, XhtmlNode tr, ResourceWrapper obs, ResourceWrapper diff, String... names) throws FHIRFormatError, DefinitionException, IOException {
    if (included) { 
      XhtmlNode td = tr.td(); 
      List<ResourceWrapper> list = obs.childrenMN(names);
      if (!list.isEmpty()) { 
        boolean first = true;
        for (ResourceWrapper b : list) {
          if (diff == null || !diff.matches(b)) {
            if (first) first = false; else td.tx(", ");
            renderDataType(status, td, b);
          }
        }
      } 
    }
  } 

} 
