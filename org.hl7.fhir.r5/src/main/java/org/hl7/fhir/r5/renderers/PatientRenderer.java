package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class PatientRenderer extends ResourceRenderer {


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
      b.append(context.formatPhrase(RenderingContext.PAT_NO_NAME));      
    }
    b.append(" ");
    if (item == null) {
      b.append(context.formatPhrase(RenderingContext.PAT_NO_GENDER));
    } else {
      b.append(gender);
    }
    b.append(", ");
    if (dt == null) {
      b.append(context.formatPhrase(RenderingContext.PAT_NO_DOB));
    } else {
      b.append(context.formatPhrase(RenderingContext.PAT_DOB, displayDateTime(dt)));      
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


  private static final int MAX_IMAGE_LENGTH = 2*1024*1024;
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
        x.b().tx(context.formatPhrase(RenderingContext.PAT_NO_NAME)); // todo: is this appropriate?  
      } else {
        renderDataType(status, xlinkNarrative(x.b(), n), n);
      }
      x.tx(" ");
      if (gender == null) {
        x.tx(context.formatPhrase(RenderingContext.PAT_NO_GENDER));
      } else {
        spanIfTracking(x, pat.child("gender")).tx(gender);
      }
      x.tx(", ");
      if (dt == null) {
        x.tx(context.formatPhrase(RenderingContext.PAT_NO_DOB));
      } else {
        spanIfTracking(x, dt).tx(context.formatPhrase(RenderingContext.PAT_DOB, displayDateTime(dt)));
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
      XhtmlNode tbl;
      if (hasRenderablePhoto(pat)) {
        tbl = x.table(null, true);
        XhtmlNode tr = tbl.tr();
        tbl = tr.td().table("grid", false);
        renderPhoto(tr.td(), pat);
      } else {
        tbl = x.table("grid", false);
      }

      // the table has 4 columns
      addStatus(status, tbl, pat);
      addIdentifiers(status, tbl, pat);
      addNames(status, tbl, pat);
      addComms(status, tbl, pat);
      addLangs(status, tbl, pat);
      addNOKs(status, tbl, pat);
      addLinks(status, tbl, pat);
      addExtensions(status, tbl, pat);
      if (tbl.isEmpty()) {
        x.remove(tbl);
      }
      if (pat.has("contained") && context.isTechnicalMode()) {
        x.hr();
        x.para().b().tx(context.formatMessagePlural(pat.children("contained").size(), RenderingContext.PAT_CONTAINED));
        addContained(status, x, pat.children("contained"));
      }
    }
  }

  private ResourceWrapper chooseId(ResourceWrapper oldId, ResourceWrapper newId) {
    if (oldId == null) {
      return newId;
    }
    if (newId == null) {
      return oldId;
    }
    return isPreferredId(newId.primitiveValue("use"), oldId.primitiveValue("use")) ? newId : oldId;
  }

  private boolean isPreferredId(String newUse, String oldUse) {
    if (newUse == null && oldUse == null || newUse == oldUse) {
      return false;
    }
    if (newUse == null) {
      return true;
    }
    switch (newUse) {
    case "official": return !Utilities.existsInList(oldUse, "usual");
    case "old": return !Utilities.existsInList(oldUse, "official", "secondary", "usual");
    case "secondary": return !Utilities.existsInList(oldUse, "official", "usual");
    case "temp": return !Utilities.existsInList(oldUse, "official", "secondary", "usual");
    case "usual": return true;
    default: return false;
    }
  }

  private ResourceWrapper chooseName(ResourceWrapper oldName, ResourceWrapper newName) {
    if (oldName == null) {
      return newName;
    }
    if (newName == null) {
      return oldName;
    }
    return isPreferredName(newName.primitiveValue("use"), oldName.primitiveValue("use")) ? newName : oldName;
  }


  private boolean isPreferredName(String newUse, String oldUse) {
    if (newUse == null && oldUse == null || newUse == oldUse) {
      return false;
    }
    if (newUse == null) {
      return true;
    }
    if (oldUse == null) {
      return Utilities.existsInList(newUse, "official", "usual");
    }
    switch (oldUse) {
    case "anonymous": return Utilities.existsInList(newUse, "official", "usual");
    case "maiden": return Utilities.existsInList(newUse, "official", "usual");
    case "nickname": return Utilities.existsInList(newUse, "official", "usual");
    case "official": return Utilities.existsInList(newUse, "usual");
    case "old": return Utilities.existsInList(newUse, "official", "usual");
    case "temp": return Utilities.existsInList(newUse, "official", "usual");
    case "usual": return false; 
    }
    return false;
  }

  private void addExtensions(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
    Map<String, List<ResourceWrapper>> extensions = new HashMap<>();
    List<ResourceWrapper> pw = r.children("extension");
    for (ResourceWrapper t : pw) {  
      String url = t.primitiveValue("url");
      if (!extensions.containsKey(url)) {
        extensions.put(url, new ArrayList<>());
      }
      extensions.get(url).add(t);
    }

    for (String url : extensions.keySet()) {
      StructureDefinition sd = findCanonical(StructureDefinition.class, url, r);
      if (sd != null) {
        List<ResourceWrapper> list = extensions.get(url);
        boolean anyComplex = false;
        for (ResourceWrapper ext : list) {
          anyComplex = anyComplex || ext.has("extension");
        }
        if (!anyComplex) {
          XhtmlNode tr = tbl.tr();
          nameCell(tr, getContext().getTranslated(sd.getTitleElement()), sd.getDescription(), sd.getWebPath());
          XhtmlNode td = tr.td();
          td.colspan("3");
          if (list.size() != 1) {
            XhtmlNode ul = td.ul();
            for (ResourceWrapper s : list) {
              XhtmlNode li = ul.li();
              renderDataType(status, xlinkNarrative(li, s.child("value")), s.child("value"));
            }
          } else {
            renderDataType(status, xlinkNarrative(td, list.get(0).child("value")), list.get(0).child("value"));
          }
        } else {
          for (ResourceWrapper ext : list) {
            XhtmlNode tr = tbl.tr();
            nameCell(tr, sd.getTitle()+":", sd.getDescription());
            XhtmlNode td = tr.td();
            td.colspan("3");
            if (ext.has("extension")) {
              XhtmlNode ul = td.ul();
              for (ResourceWrapper s : ext.extensions()) {
                XhtmlNode li = ul.li();
                li.tx(s.primitiveValue("url")+": ");
                if (s.has("extension")) {
                  boolean first = true;
                  for (ResourceWrapper t : s.extensions()) {
                    if (first) first = false; else li.tx("; ");
                    li.tx(t.primitiveValue("url")+"=");
                    renderDataType(status, xlinkNarrative(li, t.child("value")), t.child("value"));
                  }
                } else {
                  renderDataType(status, xlinkNarrative(li, s.child("value")), s.child("value"));
                }
              }
            } else {
              renderDataType(status, xlinkNarrative(td, ext.child("value")), ext.child("value"));
            }
          }
        }
      }
    }


  }

  private void addIdentifiers(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> ids = r.children("identifier");
    ResourceWrapper id = null;
    for (ResourceWrapper i : ids) {
      id = chooseId(id, i);
    }
    if (id != null) {
      ids.remove(id);
    };
    if (ids.size() > 0) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatMessagePlural(ids.size(), RenderingContext.PAT_OTHER_ID),context.formatMessagePlural(ids.size(), RenderingContext.PAT_OTHER_ID_HINT));
      XhtmlNode td = tr.td();
      td.colspan("3");
      if (ids.size() == 1) {
        renderDataType(status, xlinkNarrative(td, ids.get(0)), ids.get(0));
      } else { 
        XhtmlNode ul = td.ul();
        for (ResourceWrapper i : ids) {
          renderDataType(status, xlinkNarrative(ul.li(), i), i);
        }
      }
    }
  }

  private void addLangs(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> langs = new ArrayList<ResourceWrapper>();
    List<ResourceWrapper> comms = r.children("communication");
    ResourceWrapper prefLang = null;
    for (ResourceWrapper t : comms) {
      ResourceWrapper lang = t.child("language");
      if (lang != null) {
        langs.add(lang);
        ResourceWrapper l = t.child("preferred");
        if (l != null && "true".equals(l.primitiveValue())) {
          prefLang = lang;
        }
      }
    }
    if (langs.size() > 0) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatMessagePlural(langs.size(), RenderingContext.PAT_LANG), context.formatMessagePlural(langs.size(), RenderingContext.PAT_LANG_HINT));
      XhtmlNode td = tr.td();
      td.colspan("3");
      if (langs.size() == 1) {
        renderDataType(status, xlinkNarrative(td, langs.get(0)), langs.get(0));
        if (prefLang != null) {
          td.tx(" "+context.formatPhrase(RenderingContext.PAT_LANG_PREFERRED));
        }
      } else if (langs.size() > 1) {
        XhtmlNode ul = td.ul();
        for (ResourceWrapper i : langs) {
          XhtmlNode li = ul.li();
          renderDataType(status, xlinkNarrative(li, i), i);
          if (i == prefLang) {
            li.tx(" "+context.formatPhrase(RenderingContext.PAT_LANG_PREFERRED));;
          }
        }
      }
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
      refs.add(new NamedReferance(context.formatPhrase(RenderingContext.PAT_GP), null, t));
    }
    pw = r.children("managingOrganization");
    for (ResourceWrapper t : pw) {
      refs.add(new NamedReferance(context.formatPhrase(RenderingContext.PAT_MO), null, t));
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
      nameCell(tr, context.formatPhrase(RenderingContext.PAT_LINKS), context.formatPhrase(RenderingContext.PAT_LINKS_HINT));
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
    case "replaced-by" : return context.formatPhrase(RenderingContext.PAT_LINK_REPLBY);
    case "replaces": return context.formatPhrase(RenderingContext.PAT_LINK_REPL);
    case "refer": return context.formatPhrase(RenderingContext.PAT_LINK_REFER);
    case "seealso": return context.formatPhrase(RenderingContext.PAT_LINK_SEE);
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
      nameCell(tr, displayDataType(rels.get(0))+":",  context.formatPhrase(RenderingContext.PAT_NOM_CONTACT)+" "+displayDataType(rels.get(0)));
    } else {
      nameCell(tr, context.formatPhrase(RenderingContext.GENERAL_CONTACT), context.formatPhrase(RenderingContext.PAT_NOK_CONTACT_HINT));
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
      li.tx(context.formatPhrase(RenderingContext.PAT_GENDER, gender));      
    }
    if (rels.size() > 1) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingContext.PAT_RELN));
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
      li.tx(context.formatPhrase(RenderingContext.PAT_ORG));
      renderDataType(status, xlinkNarrative(li, organization), organization);
    }
    if (period != null) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingContext.PAT_PERIOD));
      renderDataType(status, xlinkNarrative(li, period), period);
    }
  }

  private void addNames(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> names = r.children("name");
    ResourceWrapper name = null;
    for (ResourceWrapper n : names) {
      name = chooseName(name, n);
    }
    if (name != null) {
      names.remove(name);
    };
    if (names.size() == 1) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatPhrase(RenderingContext.PAT_ALT_NAME), context.formatPhrase(RenderingContext.PAT_ALT_NAME_HINT));
      XhtmlNode td = tr.td();
      td.colspan("3");
      if (names.size() == 1) {
        renderDataType(status, xlinkNarrative(td, names.get(0)), names.get(0));
      } else {
        XhtmlNode ul = td.ul();
        for (ResourceWrapper n : names) {
          renderDataType(status,xlinkNarrative(ul.li(), n), n);
        }
      }
    }
  }

  private void addComms(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> tels = r.children("telecom");
    List<ResourceWrapper> adds = r.children("address");
    if (tels.size() + adds.size() > 0) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatPhrase(RenderingContext.PAT_CONTACT), context.formatPhrase(RenderingContext.PAT_CONTACT_HINT));
      XhtmlNode td = tr.td();
      td.colspan("3");
      if (tels.size() + adds.size() == 1) {
        if (adds.isEmpty()) {
          renderDataType(status, xlinkNarrative(td, tels.get(0)), tels.get(0));
        } else {
          renderDataType(status, xlinkNarrative(td, adds.get(0)), adds.get(0));
        }
      } else {
        XhtmlNode ul = td.ul();
        for (ResourceWrapper n : tels) {
          renderDataType(status, xlinkNarrative(ul.li(), n), n);
        }
        for (ResourceWrapper n : adds) {
          renderDataType(status, xlinkNarrative(ul.li(), n), n);
        }
      }
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
          nameCell(tr, context.formatPhrase(RenderingContext.PAT_ACTIVE), context.formatPhrase(RenderingContext.PAT_ACTIVE_HINT));
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
          nameCell(tr, context.formatPhrase(RenderingContext.PAT_DECEASED), context.formatPhrase(RenderingContext.PAT_DECEASED_HINT));
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
          nameCell(tr, context.formatPhrase(RenderingContext.PAT_MARITAL), context.formatPhrase(RenderingContext.PAT_MARITAL_HINT));
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
          nameCell(tr, context.formatPhrase(RenderingContext.PAT_MUL_BIRTH), context.formatPhrase(RenderingContext.PAT_MUL_BIRTH_HINT));
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          renderDataType(status, xlinkNarrative(td, a.get(0)), a.get(0));
        }
      }      
    }  
  }

  private void nameCell(XhtmlNode tr, String text, String title) {
    XhtmlNode td = tr.td();
    td.setAttribute("title", title);
    td.tx(text);
    td.style("background-color: #f3f5da");
    markBoilerplate(td);
  }

  private void nameCell(XhtmlNode tr, String text, String title, String link) {
    XhtmlNode td = tr.td();
    td.setAttribute("title", title);
    if (link != null) {
      td.ah(context.prefixLocalHref(link)).tx(text); 
    } else {
      td.tx(text);
    }
    td.style("background-color: #f3f5da");
    markBoilerplate(td);
  }

  private void renderPhoto(XhtmlNode td, ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
    if (r.has("photo")) {
      List<ResourceWrapper> a = r.children("photo");
      for (ResourceWrapper att : a) {
        String ct = att.primitiveValue("contentType");
        byte[] cnt = att.has("data") ? Base64.getDecoder().decode(att.primitiveValue("data")) : null;
        if (ct.startsWith("image/") &&
            cnt != null && (!context.isInlineGraphics() || (cnt.length > 0 && cnt.length < MAX_IMAGE_LENGTH))) {
          String ext = extensionForType(ct);
          if (context.isInlineGraphics() || Utilities.noString(context.getDestDir()) || ext == null) {
            td.img("data:"+ct+";base64,"+att.primitiveValue("data"), "patient photo");
          } else {
            String n = context.getRandomName(r.getId())+ext;
            FileUtilities.bytesToFile(cnt, ManagedFileAccess.file(Utilities.path(context.getDestDir(), n)));
            context.registerFile(n);
            td.img(n, context.formatPhrase(RenderingContext.PAT_PHOTO));            
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
      List<ResourceWrapper> a = r.children("photo");
      for (ResourceWrapper att : a) {
        if (att.has("contentType") && att.primitiveValue("contentType").startsWith("image/") &&
            att.has("data") && (!context.isInlineGraphics() || (att.primitiveValue("data").length() > 0 && 
                att.primitiveValue("data").length() < MAX_IMAGE_LENGTH))) {
          return true;
        } 
      }
    }      
    return false;
  }

  private XhtmlNode makeBanner(XhtmlNode para, ResourceWrapper res) {
    para.style("border: 1px #661aff solid; background-color: #e6e6ff; padding: 10px;");
    xlinkNarrative(para, res);
    return para;
  }
}