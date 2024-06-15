package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Attachment;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class PatientRenderer extends ResourceRenderer {


  public PatientRenderer(RenderingContext context) { 
    super(context); 
  } 


  @Override
  public String displayResource(ResourceElement pat) throws UnsupportedEncodingException, IOException {
    ResourceElement id = null;
    List<ResourceElement> list = pat.children("identifier");
    for (ResourceElement t : list) {
      id = chooseId(id, t);
    }
    list = pat.children("name");
    ResourceElement n = null;
    for (ResourceElement t : list) {
      n = chooseName(n, t);
    }
    String gender = null;
    ResourceElement item = pat.child("gender");
    if (item != null) {
      gender = context.getTranslatedCode(item.primitiveValue(), "http://hl7.org/fhir/administrative-gender");
    }
    ResourceElement dt = pat.child("birthDate"); 

    StringBuilder b = new StringBuilder();
    if (b == null) {
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
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement pat) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (SHORT) {
      ResourceElement id = null;
      List<ResourceElement> list = pat.children("identifier");
      for (ResourceElement t : list) {
        id = chooseId(id, t);
      }
      list = pat.children("name");
      ResourceElement n = null;
      for (ResourceElement t : list) {
        n = chooseName(n, t);
      }
      String gender = null;
      ResourceElement item = pat.child("gender");
      if (item != null) {
        gender = context.getTranslatedCode(item.primitiveValue(), "http://hl7.org/fhir/administrative-gender");
      }
      ResourceElement dt = pat.child("birthDate");

      if (n == null) {
        x.b().tx(context.formatPhrase(RenderingContext.PAT_NO_NAME)); // todo: is this appropriate?  
      } else {
        renderDataType(status, x.b(), n);
      }
      x.tx(" ");
      if (gender == null) {
        x.tx(context.formatPhrase(RenderingContext.PAT_NO_GENDER));
      } else {
        x.tx(gender);
      }
      x.tx(", ");
      if (dt == null) {
        x.tx(context.formatPhrase(RenderingContext.PAT_NO_DOB));
      } else {
        x.tx(context.formatPhrase(RenderingContext.PAT_DOB, displayDateTime(dt)));
      }
      if (id != null) {
        x.tx(" ( ");      
        renderDataType(status, x, id);
        x.tx(")");      
      }
    } else {
      // banner
      describe(makeBanner(x.para()), pat);
      x.hr();
      XhtmlNode tbl;
      if (hasRenderablePhoto(pat)) {
        tbl = x.table("none");
        XhtmlNode tr = tbl.tr();
        tbl = tr.td().table("grid");
        renderPhoto(tr.td(), pat);
      } else {
        tbl = x.table("grid");
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

  private ResourceElement chooseId(ResourceElement oldId, ResourceElement newId) {
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

  private ResourceElement chooseName(ResourceElement oldName, ResourceElement newName) {
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


  private void addContained(RenderingStatus status, XhtmlNode x, List<ResourceElement> list) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    for (ResourceElement c : list) {
      x.hr();
      x.an(c.getId());
      RendererFactory.factory(c, context).renderResource(status, x, c);
    }
  }

  private void addExtensions(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws UnsupportedEncodingException, FHIRException, IOException {
    Map<String, List<ResourceElement>> extensions = new HashMap<>();
    List<ResourceElement> pw = r.children("extension");
    for (ResourceElement t : pw) {  
      String url = t.primitiveValue("url");
      if (!extensions.containsKey(url)) {
        extensions.put(url, new ArrayList<>());
      }
      extensions.get(url).add(t);
    }

    for (String url : extensions.keySet()) {
      StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, url);
      if (sd != null) {
        List<ResourceElement> list = extensions.get(url);
        boolean anyComplex = false;
        for (ResourceElement ext : list) {
          anyComplex = anyComplex || ext.has("extension");
        }
        if (!anyComplex) {
          XhtmlNode tr = tbl.tr();
          nameCell(tr, getContext().getTranslated(sd.getTitleElement()), sd.getDescription(), sd.getWebPath());
          XhtmlNode td = tr.td();
          td.colspan("3");
          if (list.size() != 1) {
            XhtmlNode ul = td.ul();
            for (ResourceElement s : list) {
              XhtmlNode li = ul.li();
              renderDataType(status, li, s.child("value"));
            }
          } else {
            renderDataType(status, td, list.get(0));
          }
        } else {
          for (ResourceElement ext : list) {
            XhtmlNode tr = tbl.tr();
            nameCell(tr, sd.getTitle()+":", sd.getDescription());
            XhtmlNode td = tr.td();
            td.colspan("3");
            if (ext.has("extension")) {
              XhtmlNode ul = td.ul();
              for (ResourceElement s : ext.extensions()) {
                XhtmlNode li = ul.li();
                li.tx(s.primitiveValue("url")+": ");
                if (s.has("extension")) {
                  boolean first = true;
                  for (ResourceElement t : s.extensions()) {
                    if (first) first = false; else li.tx("; ");
                    li.tx(t.primitiveValue("url")+"=");
                    renderDataType(status, li, t.child("value"));
                  }
                } else {
                  renderDataType(status, li, s.child("value"));
                }
              }
            } else {
              renderDataType(status, td, ext.child("value"));
            }
          }
        }
      }
    }


  }

  private void addIdentifiers(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceElement> ids = r.children("identifier");
    ResourceElement id = null;
    for (ResourceElement i : ids) {
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
        renderDataType(status, td, ids.get(0));
      } else { 
        XhtmlNode ul = td.ul();
        for (ResourceElement i : ids) {
          renderDataType(status, ul.li(), i);
        }
      }
    }
  }

  private void addLangs(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceElement> langs = new ArrayList<ResourceElement>();
    List<ResourceElement> comms = r.children("communication");
    ResourceElement prefLang = null;
    for (ResourceElement t : comms) {
      ResourceElement lang = t.child("language");
      if (lang != null) {
        langs.add(lang);
        ResourceElement l = t.child("preferred");
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
        renderDataType(status, td, langs.get(0));
        if (prefLang != null) {
          td.tx(" "+context.formatPhrase(RenderingContext.PAT_LANG_PREFERRED));
        }
      } else if (langs.size() > 1) {
        XhtmlNode ul = td.ul();
        for (ResourceElement i : langs) {
          XhtmlNode li = ul.li();
          renderDataType(status, li, i);
          if (i == prefLang) {
            li.tx(" "+context.formatPhrase(RenderingContext.PAT_LANG_PREFERRED));;
          }
        }
      }
    }
  }



  public class NamedReferance {

    private String name;
    private ResourceElement reference;

    public NamedReferance(String name, ResourceElement ref) {
      this.name = name;
      this.reference = ref;
    }

    public String getName() {
      return name;
    }

    public ResourceElement getReference() {
      return reference;
    }

  }


  private void addLinks(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws UnsupportedEncodingException, FHIRException, IOException {
    List<NamedReferance> refs = new ArrayList<>();
    List<ResourceElement> pw = r.children("generalPractitioner");
    for (ResourceElement t : pw) {
      refs.add(new NamedReferance(context.formatPhrase(RenderingContext.PAT_GP), t));
    }
    pw = r.children("managingOrganization");
    for (ResourceElement t : pw) {
      refs.add(new NamedReferance(context.formatPhrase(RenderingContext.PAT_MO), t));
    }
    pw = r.children("link");
    for (ResourceElement t : pw) {
      ResourceElement o = t.firstChild("other");
      ResourceElement l = t.firstChild("type");
      if (l != null && o != null) {
        refs.add(new NamedReferance(describeLinkedRecord(l.primitiveValue()), o));        
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
        li.tx(ref.getName());
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

  private void addNOKs(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException {
    for (ResourceElement t : r.children("contact")) {
      addNOK(status, tbl, r,  t);
    }
  }

  private void addNOK(RenderingStatus status, XhtmlNode tbl, ResourceElement r, ResourceElement bw) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceElement> rels = bw.children("relationship");
    ResourceElement name = bw.firstChild("name");
    ResourceElement add = bw.firstChild("address");
    String gender = context.getTranslatedCode(bw.primitiveValue("gender"), "http://hl7.org/fhir/administrative-gender");
    ResourceElement period = bw.firstChild("period");
    ResourceElement organization = bw.firstChild("organization");
    List<ResourceElement> tels = bw.children("telecom");

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
      renderDataType(status, li, name);
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
      for (ResourceElement rel : rels) {
        if (first) first = false; else li.tx(", ");
        renderDataType(status, li, rel);
      }      
    }
    if (add != null) {
      renderDataType(status, ul.li(), add);
    }
    for (ResourceElement cp : tels) {
      renderDataType(status, ul.li(), cp);
    }
    if (organization != null) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingContext.PAT_ORG));
      renderDataType(status, li, organization);
    }
    if (period != null) {
      li = ul.li();
      li.tx(context.formatPhrase(RenderingContext.PAT_PERIOD));
      renderDataType(status, li, period);
    }
  }

  private void addNames(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceElement> names = r.children("name");
    ResourceElement name = null;
    for (ResourceElement n : names) {
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
        renderDataType(status, td, names.get(0));
      } else {
        XhtmlNode ul = td.ul();
        for (ResourceElement n : names) {
          renderDataType(status, ul.li(), n);
        }
      }
    }
  }

  private void addComms(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceElement> tels = r.children("telecom");
    List<ResourceElement> adds = r.children("address");
    if (tels.size() + adds.size() > 0) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatPhrase(RenderingContext.PAT_CONTACT), context.formatPhrase(RenderingContext.PAT_CONTACT_HINT));
      XhtmlNode td = tr.td();
      td.colspan("3");
      if (tels.size() + adds.size() == 1) {
        if (adds.isEmpty()) {
          renderDataType(status, td, tels.get(0));
        } else {
          renderDataType(status, td, adds.get(0));
        }
      } else {
        XhtmlNode ul = td.ul();
        for (ResourceElement n : tels) {
          renderDataType(status, ul.li(), n);
        }
        for (ResourceElement n : adds) {
          renderDataType(status, ul.li(), n);
        }
      }
    }
  }

  private void addStatus(RenderingStatus status, XhtmlNode tbl, ResourceElement r) throws FHIRFormatError, DefinitionException, UnsupportedEncodingException, FHIRException, IOException {
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
        List<ResourceElement> a = r.children("active");
        if (!a.isEmpty()) {
          pos++;
          nameCell(tr, context.formatPhrase(RenderingContext.PAT_ACTIVE), context.formatPhrase(RenderingContext.PAT_ACTIVE_HINT));
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          renderDataType(status, td, a.get(0));
        }
      }      
      if (r.has("deceased[x]")) {
        List<ResourceElement> a = r.children("deceased[x]");
        if (!a.isEmpty()) {
          pos++;
          nameCell(tr, context.formatPhrase(RenderingContext.PAT_DECEASED), context.formatPhrase(RenderingContext.PAT_DECEASED_HINT));
          XhtmlNode td = tr.td();
          if (pos == count) {
            td.colspan("3");
          }
          renderDataType(status, td, a.get(0));
        }
      }      
      if (r.has("maritalStatus")) {
        List<ResourceElement> a = r.children("maritalStatus");
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
          renderDataType(status, td, a.get(0));
        }
      }      
      if (r.has("multipleBirth[x]")) {
        List<ResourceElement> a = r.children("multipleBirth[x]");
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
          renderDataType(status, td, a.get(0));
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

  private void renderPhoto(XhtmlNode td, ResourceElement r) throws UnsupportedEncodingException, FHIRException, IOException {
    if (r.has("photo")) {
      List<ResourceElement> a = r.children("photo");
      for (ResourceElement att : a) {
        String ct = att.primitiveValue("contentType");
        byte[] cnt = att.has("data") ? Base64.getDecoder().decode(att.primitiveValue("data")) : null;
        if (ct.startsWith("image/") &&
            cnt != null && (!context.isInlineGraphics() || (cnt.length > 0 && cnt.length < MAX_IMAGE_LENGTH))) {
          String ext = extensionForType(ct);
          if (context.isInlineGraphics() || Utilities.noString(context.getDestDir()) || ext == null) {
            td.img("data:"+ct+";base64,"+att.primitiveValue("data"), "patient photo");
          } else {
            String n = UUID.randomUUID().toString().toLowerCase()+ext;
            TextFile.bytesToFile(cnt, ManagedFileAccess.file(Utilities.path(context.getDestDir(), n)));
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

  private boolean hasRenderablePhoto(ResourceElement r) throws UnsupportedEncodingException, FHIRException, IOException {
    if (r.has("photo")) {
      List<ResourceElement> a = r.children("photo");
      for (ResourceElement v : a) {
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