package org.hl7.fhir.services.renderers;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.utilities.EOperationOutcome;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class PatientRenderer extends ParticipantRendererBase {


  public PatientRenderer(RenderingContext context) { 
    super(context); 
  } 


  @Override
  public String buildSummary(ResourceWrapper pat) throws UnsupportedEncodingException, IOException {
    ResourceWrapper id = null;
    List<ResourceWrapper> list = pat.children("identifier");
    for (ResourceWrapper t : list) {
      id = chooseId(id, t);
    }
    list = pat.children("name");
    ResourceWrapper n = null;
    for (ResourceWrapper t : list) {
      n = chooseName(n, t);
    }
    String gender = null;
    ResourceWrapper item = pat.child("gender");
    if (item != null) {
      gender = context.getTranslatedCode(item.primitiveValue(), "http://hl7.org/fhir/administrative-gender");
    }
    ResourceWrapper dt = pat.child("birthDate"); 

    StringBuilder b = new StringBuilder();
    if (n != null) {
      b.append(displayHumanName(n));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.PAT_NO_NAME));      
    }
    b.append(" ");
    if (item == null) {
      b.append(context.formatPhrase(RenderingI18nContext.PAT_NO_GENDER));
    } else {
      b.append(gender);
    }
    b.append(", ");
    if (dt == null) {
      b.append(context.formatPhrase(RenderingI18nContext.PAT_NO_DOB));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.PAT_DOB, displayDateTime(dt)));      
    }
    if (id != null) {
      b.append(" ( ");      
      b.append(displayIdentifier(id));
      b.append(")");      
    }
    return b.toString();
  }


  //  // name gender DoB (MRN)
  //  public String display(Resource dr) {
  //    Patient pat = (Patient) dr;
  //    Identifier id = null;
  //    for (Identifier t : pat.getIdentifier()) {
  //      id = chooseId(id, t);
  //    }
  //    HumanName n = null;
  //    for (HumanName t : pat.getName()) {
  //      n = chooseName(n, t);
  //    }
  //    return display(n, pat.hasGender() ? context.getTranslatedCode(pat.getGenderElement(), "http://hl7.org/fhir/administrative-gender") : null, pat.getBirthDateElement(), id);
  //  }


  private static final boolean SHORT = false;


  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper pat) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(pat, x);
    if (context.isShortPatientForm()) {
      ResourceWrapper id = null;
      List<ResourceWrapper> list = pat.children("identifier");
      for (ResourceWrapper t : list) {
        id = chooseId(id, t);
      }
      list = pat.children("name");
      ResourceWrapper n = null;
      for (ResourceWrapper t : list) {
        n = chooseName(n, t);
      }
      String gender = null;
      ResourceWrapper item = pat.child("gender");
      if (item != null) {
        gender = getTranslatedCode(item);
      }
      ResourceWrapper dt = pat.child("birthDate");

      if (n == null) {
        x.b().tx(context.formatPhrase(RenderingI18nContext.PAT_NO_NAME)); // todo: is this appropriate?  
      } else {
        renderDataType(status, xlinkNarrative(x.b(), n), n);
      }
      x.tx(" ");
      if (gender == null) {
        x.tx(context.formatPhrase(RenderingI18nContext.PAT_NO_GENDER));
      } else {
        spanIfTracking(x, pat.child("gender")).tx(gender);
      }
      x.tx(", ");
      if (dt == null) {
        x.tx(context.formatPhrase(RenderingI18nContext.PAT_NO_DOB));
      } else {
        spanIfTracking(x, dt).tx(context.formatPhrase(RenderingI18nContext.PAT_DOB, displayDateTime(dt)));
      }
      if (id != null) {
        x.tx(" ( ");      
        renderDataType(status, spanIfTracking(x, id), id);
        x.tx(")");      
      }
    } else {
      // banner
      makeBanner(x.para(), pat).tx(buildSummary(pat));
      x.hr();
      XhtmlNode tbl = startTable(x, pat, "patient photo", context.formatPhrase(RenderingI18nContext.PAT_PHOTO));

      // the table has 4 columns
      addStatus(status, tbl, pat);
      addIdentifiers(status, tbl, pat);
      addNames(status, tbl, pat);
      addComms(status, tbl, pat, context.formatPhrase(RenderingI18nContext.PAT_CONTACT_HINT));
      addLangs(status, tbl, pat);
      addNOKs(status, tbl, pat);
      addLinks(status, tbl, pat);
      addExtensions(status, tbl, pat);
      finishNarrative(status, x, tbl, pat);
    }
  }

  public class NamedReferance {

    private String name;
    private ResourceWrapper type;
    private ResourceWrapper reference;

    public NamedReferance(String name, ResourceWrapper type, ResourceWrapper ref) {
      this.name = name;
      this.type = type;
      this.reference = ref;
    }

    public String getName() {
      return name;
    }

    public ResourceWrapper getReference() {
      return reference;
    }

    public ResourceWrapper getType() {
      return type;
    }

  }


  private void addLinks(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
    List<NamedReferance> refs = new ArrayList<>();
    List<ResourceWrapper> pw = r.children("generalPractitioner");
    for (ResourceWrapper t : pw) {
      refs.add(new NamedReferance(context.formatPhrase(RenderingI18nContext.PAT_GP), null, t));
    }
    pw = r.children("managingOrganization");
    for (ResourceWrapper t : pw) {
      refs.add(new NamedReferance(context.formatPhrase(RenderingI18nContext.PAT_MO), null, t));
    }
    pw = r.children("link");
    for (ResourceWrapper t : pw) {
      ResourceWrapper o = t.firstChild("other");
      ResourceWrapper l = t.firstChild("type");
      if (l != null && o != null) {
        refs.add(new NamedReferance(describeLinkedRecord(l.primitiveValue()), l,   o));        
      }
    }

    if (refs.size() > 0) {      
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_LINKS), context.formatPhrase(RenderingI18nContext.PAT_LINKS_HINT));
      XhtmlNode td = tr.td();
      td.colspan("3");
      XhtmlNode ul = td.ul();
      for (NamedReferance ref : refs) {
        XhtmlNode li = ul.li();
        if (ref.getType() != null) {
          spanIfTracking(li, ref.getType()).tx(ref.getName());
        } else {
          li.tx(ref.getName());
        }
        li.tx(": ");
        renderReference(status, li, ref.getReference());        
      }
    }
  }

  private String describeLinkedRecord(String type) {
    switch (type) {
    case "replaced-by" : return context.formatPhrase(RenderingI18nContext.PAT_LINK_REPLBY);
    case "replaces": return context.formatPhrase(RenderingI18nContext.PAT_LINK_REPL);
    case "refer": return context.formatPhrase(RenderingI18nContext.PAT_LINK_REFER);
    case "seealso": return context.formatPhrase(RenderingI18nContext.PAT_LINK_SEE);
    }
    return "Unknown";
  }

  private void addNOKs(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    for (ResourceWrapper t : r.children("contact")) {
      addNOK(status, tbl, r,  t);
    }
  }

  private void addNOK(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r, ResourceWrapper bw) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> rels = bw.children("relationship");
    ResourceWrapper name = bw.firstChild("name");
    ResourceWrapper add = bw.firstChild("address");
    String gender = context.getTranslatedCode(bw.primitiveValue("gender"), "http://hl7.org/fhir/administrative-gender");
    ResourceWrapper period = bw.firstChild("period");
    ResourceWrapper organization = bw.firstChild("organization");
    List<ResourceWrapper> tels = bw.children("telecom");

    if (rels.size() < 2 && name == null && add == null && gender == null && period == null && organization == null && tels.size() == 0) {
      return; // nothing to render 
    }
    XhtmlNode tr = tbl.tr();
    if (rels.size() == 1) {
      nameCell(tr, displayDataType(rels.get(0))+":",  context.formatPhrase(RenderingI18nContext.PAT_NOM_CONTACT)+" "+displayDataType(rels.get(0)));
    } else {
      nameCell(tr, context.formatPhrase(RenderingI18nContext.GENERAL_CONTACT), context.formatPhrase(RenderingI18nContext.PAT_NOK_CONTACT_HINT));
    }
    XhtmlNode td = tr.td();
    td.colspan("3");
    XhtmlNode ul = td.ul();
    XhtmlNode li;
    if (name != null) {
      li = ul.li();
      renderDataType(status, xlinkNarrative(li, name), name);
      if (gender != null) {
        li.tx(" "+"("+gender+")");
      }
    } else if (gender != null) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingI18nContext.PAT_GENDER, gender));      
    }
    if (rels.size() > 1) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingI18nContext.PAT_RELN));
      boolean first = true;
      for (ResourceWrapper rel : rels) {
        if (first) first = false; else li.tx(", ");
        renderDataType(status, xlinkNarrative(li, rel), rel);
      }      
    }
    if (add != null) {
      renderDataType(status, xlinkNarrative(ul.li(), add), add);
    }
    for (ResourceWrapper cp : tels) {
      renderDataType(status, xlinkNarrative(ul.li(), cp), cp);
    }
    if (organization != null) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingI18nContext.PAT_ORG));
      renderDataType(status, xlinkNarrative(li, organization), organization);
    }
    if (period != null) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingI18nContext.PAT_PERIOD));
      renderDataType(status, xlinkNarrative(li, period), period);
    }
  }

  private void addStatus(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, UnsupportedEncodingException, FHIRException, IOException {
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
        List<ResourceWrapper> a = r.children("active");
        if (!a.isEmpty()) {
          pos++;
          nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT));
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          renderDataType(status, xlinkNarrative(td, a.get(0)), a.get(0));
        }
      }      
      if (r.has("deceased[x]")) {
        List<ResourceWrapper> a = r.children("deceased[x]");
        if (!a.isEmpty()) {
          pos++;
          nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_DECEASED), context.formatPhrase(RenderingI18nContext.PAT_DECEASED_HINT));
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          renderDataType(status, xlinkNarrative(td, a.get(0)), a.get(0));
        }
      }      
      if (r.has("maritalStatus")) {
        List<ResourceWrapper> a = r.children("maritalStatus");
        if (!a.isEmpty()) {
          pos++;
          if (pos == 3) {
            tr = tbl.tr();          
          }
          nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_MARITAL), context.formatPhrase(RenderingI18nContext.PAT_MARITAL_HINT));
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          renderDataType(status, xlinkNarrative(td, a.get(0)), a.get(0));
        }
      }      
      if (r.has("multipleBirth[x]")) {
        List<ResourceWrapper> a = r.children("multipleBirth[x]");
        if (!a.isEmpty()) {
          pos++;
          if (pos == 3) {
            tr = tbl.tr();          
          }
          nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_MUL_BIRTH), context.formatPhrase(RenderingI18nContext.PAT_MUL_BIRTH_HINT));
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          renderDataType(status, xlinkNarrative(td, a.get(0)), a.get(0));
        }
      }      
    }  
  }


}