package org.hl7.fhir.r5.renderers;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Address;
import org.hl7.fhir.r5.model.Attachment;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.HumanName;
import org.hl7.fhir.r5.model.HumanName.NameUse;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Identifier.IdentifierUse;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Period;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class PatientRenderer extends ResourceRenderer {

  public class NamedReferance {

    private String name;
    private Reference reference;
    private BaseWrapper wrapper;

    public NamedReferance(String name, Reference ref, BaseWrapper refw) {
      this.name = name;
      this.reference = ref;
      this.wrapper = refw;
    }

    public String getName() {
      return name;
    }

    public Reference getReference() {
      return reference;
    }

    public BaseWrapper getWrapper() {
      return wrapper;
    }

  }

  private static final int MAX_IMAGE_LENGTH = 2*1024*1024;

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
    return display(n, pat.hasGender() ? pat.getGender().getDisplay() : null, pat.getBirthDateElement(), id);
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
    if (oldUse == null) {
      return existsInList(newUse, NameUse.OFFICIAL, NameUse.USUAL);
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
      gender = pw.value().getBase().primitiveValue();
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
      b.append("(no stated gender)");
    } else {
      b.append(gender);
    }
    b.append(", ");
    if (dob == null) {
      b.append("DoB Unknown");
    } else {
      b.append("DoB: "+display(dob));      
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
      x.b().tx("Anonymous Patient"); // todo: is this appropriate?  
    } else {
      render(x.b(), name);
    }
    x.tx(" ");
    if (gender == null) {
      x.tx("(no stated gender)");
    } else {
      x.tx(gender);
    }
    x.tx(", ");
    if (dob == null) {
      x.tx("DoB Unknown");
    } else {
      x.tx("DoB: ");
      render(x, dob);
    }
    if (id != null) {
      x.tx(" ( ");      
      render(x, id);
      x.tx(")");      
    }
  }

  @Override
  public boolean render(XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    // banner
    describe(makeBanner(x.para()), r);
    x.hr();
    XhtmlNode tbl;
    if (hasRenderablePhoto(r)) {
      tbl = x.table("none");
      XhtmlNode tr = tbl.tr();
      tbl = tr.td().table("grid");
      renderPhoto(tr.td(), r);
    } else {
      tbl = x.table("grid");
    }
    
    // the table has 4 columns
    addStatus(tbl, r);
    addIdentifiers(tbl, r);
    addNames(tbl, r);
    addComms(tbl, r);
    addLangs(tbl, r);
    addNOKs(tbl, r);
    addLinks(tbl, r);
    addExtensions(tbl, r);
    if (tbl.isEmpty()) {
      x.remove(tbl);
    }
    return false;
  }

  private void addExtensions(XhtmlNode tbl, ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
    Map<String, List<Extension>> extensions = new HashMap<>();
    PropertyWrapper pw = getProperty(r, "extension");
    for (BaseWrapper t : pw.getValues()) {      
      Extension ext = (Extension) t.getBase();
      if (!extensions.containsKey(ext.getUrl())) {
        extensions.put(ext.getUrl(), new ArrayList<>());
      }
      extensions.get(ext.getUrl()).add(ext);
    }
    for (String url : extensions.keySet()) {
      StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, url);
      if (sd != null) {
        List<Extension> list = extensions.get(url);
        boolean anyComplex = false;
        for (Extension ext : list) {
          anyComplex = anyComplex || ext.hasExtension();
        }
        if (!anyComplex) {
          XhtmlNode tr = tbl.tr();
          nameCell(tr, sd.getTitle()+":", sd.getDescription(), sd.getWebPath());
          XhtmlNode td = tr.td();
          td.colspan("3");
          if (list.size() == 1) {
            XhtmlNode ul = td.ul();
            for (Extension s : list) {
              XhtmlNode li = ul.li();
              render(r, li, s.getValue());
            }
          } else {
            render(r, td, list.get(0).getValue());
          }
        } else {
          for (Extension ext : list) {
            XhtmlNode tr = tbl.tr();
            nameCell(tr, sd.getTitle()+":", sd.getDescription());
            XhtmlNode td = tr.td();
            td.colspan("3");
            if (ext.hasExtension()) {
              XhtmlNode ul = td.ul();
              for (Extension s : ext.getExtension()) {
                XhtmlNode li = ul.li();
                li.tx(s.getUrl()+": ");
                if (s.hasExtension()) {
                  boolean first = true;
                  for (Extension t : s.getExtension()) {
                    if (first) first = false; else li.tx("; ");
                    li.tx(t.getUrl()+"=");
                    render(r, li, t.getValue());
                  }
                } else {
                  render(r, li, s.getValue());
                }
              }
            } else {
              render(r, td, ext.getValue());
            }
          }
        }
      }
    }
    
    
  }

  private void addIdentifiers(XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<Identifier> ids = new ArrayList<>();
    PropertyWrapper pw = getProperty(r, "identifier");
    for (BaseWrapper t : pw.getValues()) {
      ids.add((Identifier) t.getBase());
    }
    Identifier id = null;
    for (Identifier i : ids) {
      id = chooseId(id, i);
    }
    if (id != null) {
      ids.remove(id);
    };
    if (ids.size() == 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Other Id:", "Other Ids (see the one above)");
      XhtmlNode td = tr.td();
      td.colspan("3");
      render(r, td, ids.get(0));
    } else if (ids.size() > 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Other Ids:", "Other Ids (see the one above)");
      XhtmlNode td = tr.td();
      td.colspan("3");
      XhtmlNode ul = td.ul();
      for (Identifier i : ids) {
        render(r, ul.li(), i);
      }
    }
  }

  private void addLangs(XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<CodeableConcept> langs = new ArrayList<>();
    PropertyWrapper pw = getProperty(r, "communication");
    CodeableConcept prefLang = null;
    for (BaseWrapper t : pw.getValues()) {
      PropertyWrapper l = getProperty(t, "language");
      if (l != null && l.hasValues()) {
        CodeableConcept lang = (CodeableConcept) l.getValues().get(0).getBase();
        langs.add(lang);
        l = getProperty(t, "preferred");
        if (l != null && l.hasValues() && "true".equals(l.getValues().get(0).getBase().primitiveValue())) {
          prefLang = lang;
        }
      }
    }
    if (langs.size() == 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Language:", "Languages spoken");
      XhtmlNode td = tr.td();
      td.colspan("3");
      render(r, td, langs.get(0));
      if (prefLang != null) {
        td.tx(" (preferred)");
      }
    } else if (langs.size() > 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Languages:", "Languages spoken");
      XhtmlNode td = tr.td();
      td.colspan("3");
      XhtmlNode ul = td.ul();
      for (CodeableConcept i : langs) {
        XhtmlNode li = ul.li();
        render(r, li, i);
        if (i == prefLang) {
          li.tx(" (preferred)");
        }
      }
    }
  }


  private void addLinks(XhtmlNode tbl, ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
    List<NamedReferance> refs = new ArrayList<>();
    PropertyWrapper pw = getProperty(r, "generalPractitioner");
    if (pw != null) {
      for (BaseWrapper t : pw.getValues()) {
        refs.add(new NamedReferance("General Practitioner", (Reference) t.getBase(), t));
      }
    }
    pw = getProperty(r, "managingOrganization");
    if (pw != null) {
      for (BaseWrapper t : pw.getValues()) {
        refs.add(new NamedReferance("Managing Organization", (Reference) t.getBase(), t));
      }
    }
    pw = getProperty(r, "link");
    for (BaseWrapper t : pw.getValues()) {
      PropertyWrapper l = getProperty(t, "other");
      Reference ref = null;
      BaseWrapper refw = null;
      for (BaseWrapper v : l.getValues()) {
        ref = (Reference) v.getBase();
        refw = v;
      }
      String type = null;
      l = getProperty(t, "type");
      for (BaseWrapper v : l.getValues()) {
        type = v.getBase().primitiveValue();
      }
      if (type != null && ref != null) {
        refs.add(new NamedReferance(describeLinkedRecord(type), ref, refw));        
      }
    }
    
    if (refs.size() > 0) {      
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Links:", "Patient Links");
      XhtmlNode td = tr.td();
      td.colspan("3");
      XhtmlNode ul = td.ul();
      for (NamedReferance ref : refs) {
        XhtmlNode li = ul.li();
        li.tx(ref.getName());
        li.tx(": ");
        renderReference(r, li, ref.getReference());        
      }
    }
  }

  private String describeLinkedRecord(String type) {
    switch (type) {
    case "replaced-by" : return "This record replaced by";
    case "replaces": return "This record replaces";
    case "refer": return "Please refer to";
    case "seealso": return "Also see";
    }
    return "Unknown";
  }

  private void addNOKs(XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    PropertyWrapper pw = getProperty(r, "contact");
    for (BaseWrapper t : pw.getValues()) {
      addNOK(tbl,r,  t);
    }
  }
  
  private void addNOK(XhtmlNode tbl, ResourceWrapper r, BaseWrapper bw) throws FHIRFormatError, DefinitionException, IOException {
    List<CodeableConcept> rels = new ArrayList<>();
    HumanName name = null;
    Address add = null;
    String gender = null;
    Period period = null;
    Reference organization = null;
    List<ContactPoint> tels = new ArrayList<>();

    PropertyWrapper pw = getProperty(bw, "relationship");
    for (BaseWrapper t : pw.getValues()) {
      CodeableConcept v = (CodeableConcept) t.getBase();
      rels.add(v);
    }
        
    pw = getProperty(bw, "name");
    if (pw.hasValues()) {
      name = (HumanName) pw.getValues().get(0).getBase();
    }
    pw = getProperty(bw, "telecom");
    for (BaseWrapper t : pw.getValues()) {
      ContactPoint v = (ContactPoint) t.getBase();
      tels.add(v);
    }
        
    pw = getProperty(bw, "address");
    if (pw.hasValues()) {
      add = (Address) pw.getValues().get(0).getBase();
    }
    
    pw = getProperty(bw, "gender");
    if (pw.hasValues()) {
      gender = pw.getValues().get(0).getBase().primitiveValue();
    }

    pw = getProperty(bw, "organization");
    if (pw.hasValues()) {
      organization = (Reference) pw.getValues().get(0).getBase();
    }
    
    pw = getProperty(bw, "period");
    if (pw.hasValues()) {
      period = (Period) pw.getValues().get(0).getBase();
    }
    
    if (rels.size() < 2 && name == null && add == null && gender == null && period == null && organization == null && tels.size() == 0) {
      return; // nothing to render 
    }
    XhtmlNode tr = tbl.tr();
    if (rels.size() == 1) {
      nameCell(tr, (rels.get(0).getCodingFirstRep().hasDisplay() ? rels.get(0).getCodingFirstRep().getDisplay() : display(rels.get(0)))+":", "Nominated Contact: "+display(rels.get(0)));
    } else {
      nameCell(tr, "Contact", "Patient contact");
    }
    XhtmlNode td = tr.td();
    td.colspan("3");
    XhtmlNode ul = td.ul();
    XhtmlNode li;
    if (name != null) {
      li = ul.li();
      render(r, li, name);
      if (gender != null) {
        li.tx(" ("+gender+")");
      }
    } else if (gender != null) {
      li = ul.li();
      li.tx("Gender: "+gender);      
    }
    if (rels.size() > 1) {
      li = ul.li();
      li.tx("Relationships: ");
      boolean first = true;
      for (CodeableConcept rel : rels) {
        if (first) first = false; else li.tx(", ");
        render(r, li, rel);
      }      
    }
    if (add != null) {
      render(r, ul.li(), add);
    }
    for (ContactPoint cp : tels) {
      render(r, ul.li(), cp);
    }
    if (organization != null) {
      li = ul.li();
      li.tx("Organization: ");
      render(r, li, organization);
    }
    if (period != null) {
      li = ul.li();
      li.tx("Valid Period: ");
      render(r, li, period);
    }
  }

  private void addNames(XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<HumanName> names = new ArrayList<>();
    PropertyWrapper pw = getProperty(r, "name");
    for (BaseWrapper t : pw.getValues()) {
      names.add((HumanName) t.getBase());
    }
    HumanName name = null;
    for (HumanName n : names) {
      name = chooseName(name, n);
    }
    if (name != null) {
      names.remove(name);
    };
    if (names.size() == 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Alt. Name:", "Alternate names (see the one above)");
      XhtmlNode td = tr.td();
      td.colspan("3");
      render(r, td, names.get(0));
    } else if (names.size() > 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Alt Names:", "Alternate names (see the one above)");
      XhtmlNode td = tr.td();
      td.colspan("3");
      XhtmlNode ul = td.ul();
      for (HumanName n : names) {
        render(r, ul.li(), n);
      }
    }
  }
  
  private void addComms(XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<ContactPoint> tels = new ArrayList<>();
    PropertyWrapper pw = getProperty(r, "telecom");
    for (BaseWrapper t : pw.getValues()) {
      tels.add((ContactPoint) t.getBase());
    }
    List<Address> adds = new ArrayList<>();
    pw = getProperty(r, "address");
    for (BaseWrapper t : pw.getValues()) {
      adds.add((Address) t.getBase());
    }
    if (tels.size() + adds.size() == 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Contact Detail:", "Ways to contact the Patient");
      XhtmlNode td = tr.td();
      td.colspan("3");
      if (adds.isEmpty()) {
        render(r, td, tels.get(0));
      } else {
        render(r, td, adds.get(0));
      }
    } else if (tels.size() + adds.size() > 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, "Contact Details:", "Ways to contact the Patient");
      XhtmlNode td = tr.td();
      td.colspan("3");
      XhtmlNode ul = td.ul();
      for (ContactPoint n : tels) {
        render(r, ul.li(), n);
      }
      for (Address n : adds) {
        render(r, ul.li(), n);
      }
    }
  }
  
  private void addStatus(XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, UnsupportedEncodingException, FHIRException, IOException {
    // TODO Auto-generated method stub
    int count = 0;
    if (r.has("active")) {
      count++;
    }
    if (r.has("deceased")) {
      count++;
    }
    if (r.has("maritalStatus")) {
      count++;
    }
    if (r.has("multipleBirth")) {
      count++;
    }
    if (count > 0) {
      XhtmlNode tr = tbl.tr();
      int pos = 0;
      if (r.has("active")) {
        PropertyWrapper a = r.getChildByName("active");
        if (a.hasValues()) {
          pos++;
          nameCell(tr, "Active:", "Record is active");
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          render(r, td, (DataType) a.value().getBase());
        }
      }      
      if (r.has("deceased[x]")) {
        PropertyWrapper a = r.getChildByName("deceased[x]");
        if (a.hasValues()) {
          pos++;
          nameCell(tr, "Deceased:", "Known status of Patient");
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          render(r, td, (DataType) a.value().getBase());
        }
      }      
      if (r.has("maritalStatus")) {
        PropertyWrapper a = r.getChildByName("maritalStatus");
        if (a.hasValues()) {
          pos++;
          if (pos == 3) {
            tr = tbl.tr();          
          }
          nameCell(tr, "Marital Status:", "Known Marital status of Patient");
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          render(r, td, (DataType) a.value().getBase());
        }
      }      
      if (r.has("multipleBirth[x]")) {
        PropertyWrapper a = r.getChildByName("multipleBirth[x]");
        if (a.hasValues()) {
          pos++;
          if (pos == 3) {
            tr = tbl.tr();          
          }
          nameCell(tr, "Multiple Birth:", "Known multipleBirth status of Patient");
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          render(r, td, (DataType) a.value().getBase());
        }
      }      
    }  
  }

  private void nameCell(XhtmlNode tr, String text, String title) {
    XhtmlNode td = tr.td();
    td.setAttribute("title", title);
    td.tx(text);
    td.style("background-color: #f3f5da");
  }

  private void nameCell(XhtmlNode tr, String text, String title, String link) {
    XhtmlNode td = tr.td();
    td.setAttribute("title", title);
    if (link != null) {
      td.ah(link).tx(text); 
    } else {
      td.tx(text);
    }
    td.style("background-color: #f3f5da");
  }

  private void renderPhoto(XhtmlNode td, ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
    if (r.has("photo")) {
      PropertyWrapper a = r.getChildByName("photo");
      for (BaseWrapper v : a.getValues()) {
        Attachment att = (Attachment) v.getBase();
        if (att.getContentType().startsWith("image/") &&
            att.getData() != null && (!context.isInlineGraphics() || (att.getData().length > 0 && att.getData().length < MAX_IMAGE_LENGTH))) {
          String ext = extensionForType(att.getContentType());
          if (context.isInlineGraphics() || Utilities.noString(context.getDestDir()) || ext == null) {
            td.img("data:"+att.getContentType()+";base64,"+att.getDataElement().asStringValue(), "patient photo");
          } else {
            String n = UUID.randomUUID().toString().toLowerCase()+ext;
            TextFile.bytesToFile(att.getData(), new File(Utilities.path(context.getDestDir(), n)));
            context.registerFile(n);
            td.img(n, "patient photo");            
          }
          return;
        } 
      }
    }      
    return;
  }

  private String extensionForType(String contentType) {
    if (contentType.equals("image/gif")) {
      return ".gif";
    }
    if (contentType.equals("image/png")) {
      return ".png";
    }
    if (contentType.equals("image/jpeg")) {
      return ".jpg";
    }
    return null;
  }

  private boolean hasRenderablePhoto(ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
    if (r.has("photo")) {
      PropertyWrapper a = r.getChildByName("photo");
      for (BaseWrapper v : a.getValues()) {
        Attachment att = (Attachment) v.getBase();
        if (att.hasContentType() && att.getContentType().startsWith("image/") &&
            att.getData() != null && (!context.isInlineGraphics() || (att.getData().length > 0 && att.getData().length < MAX_IMAGE_LENGTH))) {
          return true;
        } 
      }
    }      
    return false;
  }

  private XhtmlNode makeBanner(XhtmlNode para) {
    para.style("border: 1px #661aff solid; background-color: #e6e6ff; padding: 10px;");
    return para;
  }
}