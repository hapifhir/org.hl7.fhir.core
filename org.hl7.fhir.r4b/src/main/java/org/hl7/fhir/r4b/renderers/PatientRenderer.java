package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.poi.hssf.record.chart.DatRecord;
import org.hl7.fhir.r4b.model.DateTimeType;
import org.hl7.fhir.r4b.model.DateType;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.HumanName;
import org.hl7.fhir.r4b.model.HumanName.NameUse;
import org.hl7.fhir.r4b.model.Identifier;
import org.hl7.fhir.r4b.model.Identifier.IdentifierUse;
import org.hl7.fhir.r4b.model.Patient;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class PatientRenderer extends ResourceRenderer {

  public PatientRenderer(RenderingContext context) {
    super(context);
  }

  public boolean render(XhtmlNode x, Resource dr) throws UnsupportedEncodingException, IOException {
    describe(x, dr);
    return false;
  }

  // name gender DoB (MRN)
  public String display(Resource dr) {
    Patient pat = (Patient) dr;
    Identifier id = null;
    for (Identifier t : pat.getIdentifier()) {
      id = chooseId(id, t);
    }
    HumanName n = null;
    for (HumanName t : pat.getName()) {
      n = chooseName(n, t);
    }
    return display(n, pat.getGender().getDisplay(), pat.getBirthDateElement(), id);
  }

  private Identifier chooseId(Identifier oldId, Identifier newId) {
    if (oldId == null) {
      return newId;
    }
    if (newId == null) {
      return oldId;
    }
    return isPreferred(newId.getUse(), oldId.getUse()) ? newId : oldId;
  }

  private boolean isPreferred(IdentifierUse newUse, IdentifierUse oldUse) {
    if (newUse == null && oldUse == null || newUse == oldUse) {
      return false;
    }
    if (newUse == null) {
      return true;
    }
    switch (newUse) {
    case NULL: return !existsInList(oldUse, IdentifierUse.OFFICIAL, IdentifierUse.USUAL);
    case OFFICIAL: return !existsInList(oldUse, IdentifierUse.USUAL);
    case OLD: return !existsInList(oldUse, IdentifierUse.OFFICIAL, IdentifierUse.SECONDARY, IdentifierUse.USUAL);
    case SECONDARY: return !existsInList(oldUse, IdentifierUse.OFFICIAL, IdentifierUse.USUAL);
    case TEMP: return !existsInList(oldUse, IdentifierUse.OFFICIAL, IdentifierUse.SECONDARY, IdentifierUse.USUAL);
    case USUAL: return true;
    default: return false;
    }
  }

  private boolean existsInList(IdentifierUse oldUse, IdentifierUse... values) {
    for (IdentifierUse value : values) {
      if (value == oldUse) {
        return true;
      }
    }
    return false;
  }

  private HumanName chooseName(HumanName oldName, HumanName newName) {
    if (oldName == null) {
      return newName;
    }
    if (newName == null) {
      return oldName;
    }
    return isPreferred(newName.getUse(), oldName.getUse()) ? newName : oldName;
  }


  private boolean isPreferred(NameUse newUse, NameUse oldUse) {
    if (newUse == null && oldUse == null || newUse == oldUse) {
      return false;
    }
    if (newUse == null) {
      return true;
    }
    switch (oldUse) {
      case ANONYMOUS: return existsInList(newUse, NameUse.OFFICIAL, NameUse.USUAL);
      case MAIDEN: return existsInList(newUse, NameUse.OFFICIAL, NameUse.USUAL);
      case NICKNAME: return existsInList(newUse, NameUse.OFFICIAL, NameUse.USUAL);
      case NULL: return existsInList(newUse, NameUse.OFFICIAL, NameUse.USUAL);
      case OFFICIAL: return existsInList(newUse, NameUse.USUAL);
      case OLD: return existsInList(newUse, NameUse.OFFICIAL, NameUse.USUAL);
      case TEMP: return existsInList(newUse, NameUse.OFFICIAL, NameUse.USUAL);
      case USUAL: return false; 
    }
    return false;
  }

  private boolean existsInList(NameUse oldUse, NameUse... values) {
    for (NameUse value : values) {
      if (value == oldUse) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String display(ResourceWrapper pat) throws UnsupportedEncodingException, IOException {
    Identifier id = null;
    PropertyWrapper pw = getProperty(pat, "identifier");
    for (BaseWrapper t : pw.getValues()) {
      id = chooseId(id, (Identifier) t.getBase());
    }
    pw = getProperty(pat, "name");
    HumanName n = null;
    for (BaseWrapper t : pw.getValues()) {
      n = chooseName(n, (HumanName) t);
    }
    String gender = null;
    pw = getProperty(pat, "gender");
    if (valued(pw)) {
      pw.value().getBase().primitiveValue();
    }
    DateType dt = null; 
    pw = getProperty(pat, "birthDate");
    if (valued(pw)) {
      dt = (DateType) pw.value().getBase();
    }
    return display(n, gender, dt, id);  
  }

  public void describe(XhtmlNode x, ResourceWrapper pat) throws UnsupportedEncodingException, IOException {
    Identifier id = null;
    PropertyWrapper pw = getProperty(pat, "identifier");
    for (BaseWrapper t : pw.getValues()) {
      id = chooseId(id, (Identifier) t.getBase());
    }
    pw = getProperty(pat, "name");
    HumanName n = null;
    for (BaseWrapper t : pw.getValues()) {
      n = chooseName(n, (HumanName) t.getBase());
    }
    String gender = null;
    pw = getProperty(pat, "gender");
    if (valued(pw)) {
      pw.value().getBase().primitiveValue();
    }
    DateType dt = null; 
    pw = getProperty(pat, "birthDate");
    if (valued(pw)) {
      dt = (DateType) pw.value().getBase();
    }
    describe(x, n, gender, dt, id);
  }


  private String display(HumanName name, String gender, DateType dob, Identifier id) {
    StringBuilder b = new StringBuilder();
    b.append(display(name));
    b.append(" ");
    if (dob == null) {
      b.append("??");
    } else {
      b.append(gender);
    }
    b.append(" ");
    if (dob == null) {
      b.append("DoB Unknown");
    } else {
      b.append(display(dob));      
    }
    if (id != null) {
      b.append(" ( ");      
      b.append(display(id));
      b.append(")");      
    }
    return b.toString();
  }
  
  public void describe(XhtmlNode x, HumanName name, String gender, DateType dob, Identifier id) throws UnsupportedEncodingException, IOException {
    if (name == null) {
      x.b().tx("Unnamed Patient"); // todo: is this appropriate?  
    } else {
      render(x.b(), name);
    }
    x.tx(" ");
    if (gender == null) {
      x.tx("??");
    } else {
      x.tx(gender);
    }
    x.tx(" ");
    if (dob == null) {
      x.tx("DoB Unknown");
    } else {
      render(x, dob);
    }
    if (id != null) {
      x.tx(" ( ");      
      render(x, id);
      x.tx(")");      
    }
  }


}