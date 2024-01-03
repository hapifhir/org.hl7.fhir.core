package org.hl7.fhir.r5.ips;

import java.util.Date;
import java.util.List;

import org.hl7.fhir.r5.ips.IPSBuilder.TypeAndId;
import org.hl7.fhir.r5.model.Age;
import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Period;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Range;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Composition.SectionComponent;
import org.hl7.fhir.r5.model.Condition;
import org.hl7.fhir.r5.model.Condition.ConditionParticipantComponent;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Device;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Dosage;
import org.hl7.fhir.r5.model.Enumerations.CompositionStatus;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Medication;
import org.hl7.fhir.r5.model.MedicationStatement;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.utils.client.FHIRToolingClient;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class IPSBuilder {

  public static class TypeAndId {
    private String type;
    private String id;
    protected TypeAndId(String type, String id) {
      super();
      this.type = type;
      this.id = id;
    }
    public String getType() {
      return type;
    }
    public String getId() {
      return id;
    }
  }

  public static Bundle generateIPS(FHIRToolingClient server, String patientId) {
    Patient pat = server.fetchResource(Patient.class, patientId);
    Bundle bnd = initBundle();
    Composition cmp = initComposition(bnd, server.getAddress(), pat);
    pat = processPatient(bnd, server.getAddress(), pat);
//    addMedications(bnd, cmp, server, patientId);
    addConditions(bnd, cmp, server, patientId);
    return bnd;
  }

  private static Bundle initBundle() {
    Bundle bnd = new Bundle();
    bnd.getIdentifier().setSystem("urn:ietf:rfc:3986");
    bnd.getIdentifier().setValue(Utilities.makeUuidUrn());
    bnd.setType(BundleType.DOCUMENT);
    bnd.setTimestamp(new Date());
    return bnd;
  }
  
  private static Composition initComposition(Bundle bnd, String url, Patient pat) {
    Composition cmp = new Composition();
    cmp.setIdBase(Utilities.makeUuidLC());
    cmp.setStatus(CompositionStatus.FINAL);
    cmp.getType().addCoding().setSystem("http://loinc.org").setCode("60591-5");
    cmp.setDate(new Date());
    cmp.setTitle("International Patient Summary");
    cmp.addSubject().setReference("Patient/"+pat.getIdBase());
    cmp.addAuthor().setReference("Device/java");
    bnd.addEntry().setResource(cmp).setFullUrl(Utilities.pathURL(url, "Composition", cmp.getIdBase()));
    Device dev = new Device();
    dev.setId("java");
    dev.addName().setValue("Java Core Library");
    dev.addVersion().setValue(VersionUtil.getVersion());
    bnd.addEntry().setResource(dev).setFullUrl(Utilities.pathURL(url, "Device", dev.getIdBase()));
    return cmp;
  }

  private static Patient processPatient(Bundle bnd,  String url, Patient pat) {
    bnd.addEntry().setResource(pat).setFullUrl(Utilities.pathURL(url, "Patient", pat.getIdBase()));
    return pat;
  }
  
  private static void addMedications(Bundle bnd, Composition cmp, FHIRToolingClient server, String patientId) {
    Bundle sb = server.search("MedicationStatement", "?patient="+patientId+"&_include=MedicationStatement:medication&_include=MedicationStatement:source");
    SectionComponent sct = cmp.addSection();
    sct.setTitle("Medications");
    sct.getCode().addCoding().setSystem("http://loinc.org").setCode("10160-0");
    sct.getText().setStatus(NarrativeStatus.GENERATED);
    var x = sct.getText().getDiv();
    var tbl = x.table("grid");
    var tr = tbl.tr();
    tr.th().tx("Medication");
    tr.th().tx("Category");
    tr.th().tx("Status");
    tr.th().tx("When");
    tr.th().tx("Dosage");
    tr.th().tx("Reason");
    tr.th().tx("Source");
    tr.th().tx("Notes");

    boolean ok = false;
    for (BundleEntryComponent be : sb.getEntry()) {
      if (be.hasResource() && be.getResource() instanceof MedicationStatement) {
        MedicationStatement mdstmt = (MedicationStatement) be.getResource();
        ok = true;
        bnd.addEntry().setResource(mdstmt).setFullUrl(Utilities.pathURL(server.getAddress(), "MedicationStatement", mdstmt.getIdBase()));
        sct.addEntry().setReference("MedicationStatement/"+mdstmt.getIdBase());
        tr = tbl.tr();
        if (mdstmt.hasMedication() && mdstmt.getMedication().hasReference()) {
          Medication med = findMedication(sb, server, mdstmt, mdstmt.getMedication().getReference());
          if (med == null) {
            tr.td().b().tx("Unknown?");
          } else {
            tr.td().tx(summarise(med));
            bnd.addEntry().setResource(med).setFullUrl(Utilities.pathURL(server.getAddress(), "Medication", med.getIdBase()));
          }
        } else {
          tr.td().tx(genCC(mdstmt.getMedication().getConcept()));
        }
        tr.td().tx(genCC(mdstmt.getCategory()));
        var td = tr.td();
        td.tx(mdstmt.getStatus().getDisplay());
        if (mdstmt.hasReason()) {
          td.tx(" (");
          for (CodeableReference cc : mdstmt.getReason()) {
            if (cc.hasConcept()) {
              td.tx(genCC(cc.getConcept()));
            } else {
              td.tx(genReference(mdstmt, cc.getReference(), bnd, sb, server));              
            }
          }
          td.tx(")");
        }
        tr.td().tx(genDT(mdstmt.getEffective()));
        genDosages(tr.td(), mdstmt.getDosage());
        for (Reference is : mdstmt.getInformationSource()) {
          tr.td().tx(genReference(mdstmt, is, bnd, sb, server));
        }
        genNotes(tr.td(), mdstmt.getNote());
      }
    }
    if (!ok) {
      Condition cnd = new Condition();
      cnd.setId(Utilities.makeUuidLC());

      cnd.getText().setStatus(NarrativeStatus.GENERATED);
      var rx = cnd.getText().getDiv();
      rx.tx("No information is provided about the patient's medical problems");
      tr = tbl.tr();
      tr.td().colspan(7).tx("No information is provided about the patient's medical problems");
      cnd.getClinicalStatus().addCoding().setSystem("http://terminology.hl7.org/CodeSystem/condition-clinical").setCode("active").setDisplay("Active");
      cnd.getCode().addCoding().setSystem("http://hl7.org/fhir/uv/ips/CodeSystem/absent-unknown-uv-ips").setCode("no-problem-info").setDisplay("No information about current problems");
      cnd.getSubject().setReference("Patient/"+patientId);
    }
  }


  private static void genDosages(XhtmlNode x, List<Dosage> dosages) {
    if (dosages == null || dosages.size() == 0) {
      
    } else if (dosages.size() == 1) {
      genDosage(x, dosages.get(0));
    } else {
      var ul = x.ul();
      for (Dosage d : dosages) {
        genDosage(ul.li(), d);
      }
    } 
  }

  private static void genDosage(XhtmlNode x, Dosage dosage) {
    x.tx(dosage.getText());
    if (dosage.hasAsNeeded() || dosage.hasAsNeededFor()) {
      x.nbsp();
      if (dosage.hasAsNeeded()) {
        if (dosage.getAsNeeded()) {
          x.tx(" (as needed)");
        }
      } else {
        for (CodeableConcept cc : dosage.getAsNeededFor()) {
          x.tx(genDT(cc));
        }
      }
    } else if (dosage.hasTiming()) {
      x.nbsp();
      x.tx(genDT(dosage.getTiming()));
    }
    if (dosage.hasSite()) {
      x.tx(". ");
      x.tx(genDT(dosage.getSite()));
    }
    if (dosage.hasRoute()) {
      x.tx(". ");
      x.tx(genDT(dosage.getRoute()));
    }
  }

  private static Medication findMedication(Bundle sb, FHIRToolingClient server, MedicationStatement mdstmt, Reference ref) {
    if (ref == null || !ref.hasReference()) {
      return null;
    }
    if (ref.getReference().startsWith("#")) {
      
    } else {
      
    }
    return null;
  }

  private static void addConditions(Bundle bnd, Composition cmp, FHIRToolingClient server, String patientId) {
    Bundle sb = server.search("Condition", "?patient="+patientId+"&_include=Condition:asserter");
    SectionComponent sct = cmp.addSection();
    sct.setTitle("Problems");
    sct.getCode().addCoding().setSystem("http://loinc.org").setCode("11450-4");
    sct.getText().setStatus(NarrativeStatus.GENERATED);
    var x = sct.getText().getDiv();
    var tbl = x.table("grid");
    var tr = tbl.tr();
    tr.th().tx("Code");
    tr.th().tx("Category");
    tr.th().tx("Severity");
    tr.th().tx("Status");
    tr.th().tx("Onset");
    tr.th().tx("Abatement");
    tr.th().tx("Source");
    tr.th().tx("Notes");

    boolean ok = false;
    for (BundleEntryComponent be : sb.getEntry()) {
      if (be.hasResource() && be.getResource() instanceof Condition) {
        Condition cnd = (Condition) be.getResource();
        ok = true;
        bnd.addEntry().setResource(cnd).setFullUrl(Utilities.pathURL(server.getAddress(), "Condition", cnd.getIdBase()));
        sct.addEntry().setReference("Condition/"+cnd.getIdBase());
        tr = tbl.tr();
        tr.td().tx(genCC(cnd.getCode()));
        tr.td().tx(genCC(cnd.getCategory()));
        tr.td().tx(genCC(cnd.getSeverity()));
        tr.td().tx(genStatus(cnd));
        tr.td().tx(genDT(cnd.getOnset()));
        tr.td().tx(genDT(cnd.getAbatement()));
        tr.td().tx(genSource(cnd, bnd, sb, server));
        genNotes(tr.td(), cnd.getNote());

      }
    }
    if (!ok) {
      Condition cnd = new Condition();
      cnd.setId(Utilities.makeUuidLC());

      cnd.getText().setStatus(NarrativeStatus.GENERATED);
      var rx = cnd.getText().getDiv();
      rx.tx("No information is provided about the patient's medical problems");
      tr = tbl.tr();
      tr.td().colspan(7).tx("No information is provided about the patient's medical problems");
      cnd.getClinicalStatus().addCoding().setSystem("http://terminology.hl7.org/CodeSystem/condition-clinical").setCode("active").setDisplay("Active");
      cnd.getCode().addCoding().setSystem("http://hl7.org/fhir/uv/ips/CodeSystem/absent-unknown-uv-ips").setCode("no-problem-info").setDisplay("No information about current problems");
      cnd.getSubject().setReference("Patient/"+patientId);
    }
  }


  private static String genReference(DomainResource src, Reference ref, Bundle bnd, Bundle search, FHIRToolingClient server) {
    if (ref == null || ref.isEmpty()) {
      return null;
    }
    boolean contained = false;
    DomainResource tgt = null;
    if (ref.hasReference()) {
      if (ref.getReference().startsWith("#")) {
        tgt = (DomainResource) src.getContained(ref.getReference());
        contained = true;
      } else {
        TypeAndId tid = getTypeAndId(server.getAddress(), ref.getReference());
        if (tid != null) {
          tgt = findInBundle(bnd, Utilities.pathURL(server.getAddress(), tid.getType(), tid.getId()));
          if (tgt == null) {
            tgt = findInBundle(search, Utilities.pathURL(server.getAddress(), tid.getType(), tid.getId()));
            if (tgt == null) {
              tgt = (DomainResource) server.read(tid.getType(), tid.getId());
            }
          } else {
            contained = true;
          }
        }
      }
    }
    if (tgt != null) {
      if (!contained) {
        bnd.addEntry().setResource(tgt).setFullUrl(Utilities.pathURL(server.getAddress(), tgt.fhirType(), tgt.getIdBase()));
      }
      return summarise(tgt);
    } else if (ref.hasDisplay()) {
      return ref.getDisplay();
    } else if (ref.hasReference()) {
      return ref.getReference();
    } else if (ref.hasIdentifier()) {
      return genIdentifier(ref.getIdentifier());
    } else {
      return "unknown";
    }
  }

  
  private static TypeAndId getTypeAndId(String baseUrl, String url) {
    if (Utilities.noString(url)) {
      return null;
    }
    if (url.startsWith(baseUrl+"/")) {
      url = url.substring(baseUrl.length()+1);
    }
    String[] p = url.split("\\/");
    if (p.length > 1) {
      if ("_history".equals(p[p.length-2]) && p.length > 3) {
        return new TypeAndId(p[p.length-4], p[p.length-3]);
      } else {
        return new TypeAndId(p[p.length-2], p[p.length-1]);
      }
    }
    return null;
  }

  private static DomainResource findInBundle(Bundle bnd, String url) {
    for (BundleEntryComponent be : bnd.getEntry()) {
      if (url.equals(be.getFullUrl()) && be.hasResource() && be.getResource() instanceof DomainResource) {
        return (DomainResource) be.getResource();
      }
    }
    return null;
  }

  private static String summarise(DomainResource tgt) {
    // TODO Auto-generated method stub
    return null;
  }

  private static String genIdentifier(Identifier id) {
    return id.getValue();
  }

  private static void genNotes(XhtmlNode td, List<Annotation> notes) {
    if (notes.size() > 0) {
      if (notes.size() == 1) {
        genNote(td, notes.get(0));
      } else {
        var ul = td.ul();
        for (Annotation a : notes) {
          genNote(ul.li(), a);
        }
      }
    }
  }

  private static void genNote(XhtmlNode td, Annotation annotation) {
    td.tx(annotation.getText());    
  }

  private static String genSource(Condition cnd, Bundle bnd, Bundle sb, FHIRToolingClient server) {
    for (ConditionParticipantComponent t: cnd.getParticipant()) {
      return genCC(t.getFunction()) + " : "+genReference(cnd, t.getActor(), bnd, sb, server);
    }
    return "";
  }

  private static String genDT(DataType v) {
    if (v == null) {
      return null;
    }
    if (v.isPrimitive()) {
      return v.primitiveValue();
    }
    if (v instanceof Age) {
      return genQty((Age) v);
    }
    if (v instanceof Period) {
      Period p = (Period) v;
      return genDT(p.getStartElement())+" - "+genDT(p.getStartElement());
    }
    if (v instanceof Range) {
      Range p = (Range) v;
      return genDT(p.getLow())+" - "+genDT(p.getHigh());
    }
    return "not done: "+v.fhirType();
  }

  private static String genQty(Quantity v) {
    return v.getValue().toPlainString()+v.getUnit();
  }

  private static String genStatus(Condition cnd) {
    if (cnd.hasClinicalStatus() && cnd.hasVerificationStatus()) {
      return genCC(cnd.getClinicalStatus()) +"/"+genCC(cnd.getVerificationStatus());
    } else if (cnd.hasClinicalStatus()) {
      return genCC(cnd.getClinicalStatus());
    } else if (cnd.hasVerificationStatus()) {
      return genCC(cnd.getVerificationStatus());      
    } else {
      return null;
    }
  }

  private static String genCC(List<CodeableConcept> list) {
    if (list != null && list.size() == 1) {
      return genCC(list.get(0));
    } else {
      return null;
    }
  }

  private static String genCC(CodeableConcept code) {
    if (code.hasText()) {
      return code.getText();
    } else if (code.hasCoding()) {
      Coding c = code.getCodingFirstRep();
      if (c.hasDisplay()) {
        return c.getDisplay();
      } else {
        return c.getCode();
      }
    } else {
      return null;
    }
  }

}
