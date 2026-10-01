package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * Shared machinery for the renderers of the resources that describe people and their roles
 * (Patient, Practitioner, PractitionerRole, RelatedPerson): a banner holding the summary,
 * followed by a 4 column table of label / value cells, with an optional photo alongside.
 *
 * These renderers work through ResourceWrapper, so they are used for R4, R5 and R6 content.
 * Elements that only exist in some versions are simply absent in the others - check with has()
 * rather than assuming a structure.
 */
public abstract class ParticipantRendererBase extends ResourceRenderer {

  protected static final int MAX_IMAGE_LENGTH = 2*1024*1024;

  /**
   * a label / value pair, for rows that hold two items side by side
   */
  protected static class LabelledValue {
    private String label;
    private String hint;
    private ResourceWrapper value;

    public LabelledValue(String label, String hint, ResourceWrapper value) {
      this.label = label;
      this.hint = hint;
      this.value = value;
    }
  }

  public ParticipantRendererBase(RenderingContext context) {
    super(context);
  }

  // ---- choosing the identifier and name to show in the banner ------------------------------

  protected ResourceWrapper chooseId(ResourceWrapper oldId, ResourceWrapper newId) {
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

  protected ResourceWrapper chooseName(ResourceWrapper oldName, ResourceWrapper newName) {
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

  protected ResourceWrapper chooseId(ResourceWrapper r) {
    ResourceWrapper id = null;
    for (ResourceWrapper t : r.children("identifier")) {
      id = chooseId(id, t);
    }
    return id;
  }

  protected ResourceWrapper chooseName(ResourceWrapper r) {
    ResourceWrapper n = null;
    for (ResourceWrapper t : r.children("name")) {
      n = chooseName(n, t);
    }
    return n;
  }

  /**
   * A reference as plain text for the summary - without the "->" that displayReference puts in front of it 
   */
  protected String referenceText(ResourceWrapper ref) {
    if (ref.has("display")) {
      return context.getTranslated(ref.child("display"));
    }
    String s = displayReference(ref);
    return s != null && s.startsWith("->") ? s.substring(2) : s;
  }

  /**
   * A CodeableConcept as plain text - the text if there is one, else what displayCodeableConcept() makes of the codings
   */
  protected String conceptText(ResourceWrapper cc) {
    if (cc.has("text")) {
      return context.getTranslated(cc.child("text"));
    }
    return displayCodeableConcept(cc);
  }

  /**
   * for summaries: append " (a, b)" for a list of CodeableConcepts, if there are any
   */
  protected void appendConcepts(StringBuilder b, List<ResourceWrapper> list) {
    if (!list.isEmpty()) {
      b.append(" (");
      boolean first = true;
      for (ResourceWrapper cc : list) {
        if (first) first = false; else b.append(", ");
        b.append(conceptText(cc));
      }
      b.append(")");
    }
  }

  /**
   * for summaries: append " (id)" with the preferred identifier, if there is one
   */
  protected void appendId(StringBuilder b, ResourceWrapper r) {
    ResourceWrapper id = chooseId(r);
    if (id != null) {
      b.append(" (");      
      b.append(displayIdentifier(id));
      b.append(")");      
    }
  }

  // ---- the table rows ------------------------------------------------------------------------

  /**
   * Add a row with a label and the value(s) - one value inline, more than one as a list
   */
  protected void addValuesRow(RenderingStatus status, XhtmlNode tbl, String label, String hint, List<ResourceWrapper> values) throws FHIRFormatError, DefinitionException, IOException {
    if (values.isEmpty()) {
      return;
    }
    XhtmlNode tr = tbl.tr();
    nameCell(tr, label, hint);
    XhtmlNode td = tr.td();
    td.colspan("3");
    if (values.size() == 1) {
      renderValue(status, td, values.get(0));
    } else {
      XhtmlNode ul = td.ul();
      for (ResourceWrapper v : values) {
        renderValue(status, ul.li(), v);
      }
    }
  }

  protected void renderValue(RenderingStatus status, XhtmlNode x, ResourceWrapper v) throws FHIRFormatError, DefinitionException, IOException {
    if ("Reference".equals(v.fhirType())) {
      renderReference(status, x, v);
    } else {
      renderDataType(status, xlinkNarrative(x, v), v);
    }
  }

  /**
   * Add rows that hold two label / value pairs each. If there's an odd number, the last value spans the rest of the row
   */
  protected void addPairedRows(RenderingStatus status, XhtmlNode tbl, List<LabelledValue> values) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tr = null;
    for (int i = 0; i < values.size(); i++) {
      LabelledValue lv = values.get(i);
      if (i % 2 == 0) {
        tr = tbl.tr();
      }
      nameCell(tr, lv.label, lv.hint);
      XhtmlNode td = tr.td();
      if (i % 2 == 0 && i == values.size() - 1) {
        td.colspan("3");
      }
      renderValue(status, td, lv.value);
    }
  }

  protected void addLabelledValue(List<LabelledValue> list, String label, String hint, ResourceWrapper value) {
    if (value != null) {
      list.add(new LabelledValue(label, hint, value));
    }
  }

  protected void addExtensions(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
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

  /**
   * The identifiers other than the one shown in the banner
   */
  protected void addIdentifiers(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
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

  /**
   * Languages from communication. Patient, RelatedPerson, and Practitioner (from R5) have a backbone element
   * with language and preferred; Practitioner in R4 (and PractitionerRole) just have a CodeableConcept
   */
  protected void addLangs(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> langs = new ArrayList<ResourceWrapper>();
    List<ResourceWrapper> comms = r.children("communication");
    ResourceWrapper prefLang = null;
    for (ResourceWrapper t : comms) {
      if ("CodeableConcept".equals(t.fhirType())) {
        langs.add(t);
      } else {
        ResourceWrapper lang = t.child("language");
        if (lang != null) {
          langs.add(lang);
          ResourceWrapper l = t.child("preferred");
          if (l != null && "true".equals(l.primitiveValue())) {
            prefLang = lang;
          }
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
          td.tx(" "+context.formatPhrase(RenderingI18nContext.PAT_LANG_PREFERRED));
        }
      } else if (langs.size() > 1) {
        XhtmlNode ul = td.ul();
        for (ResourceWrapper i : langs) {
          XhtmlNode li = ul.li();
          renderDataType(status, xlinkNarrative(li, i), i);
          if (i == prefLang) {
            li.tx(" "+context.formatPhrase(RenderingI18nContext.PAT_LANG_PREFERRED));;
          }
        }
      }
    }
  }

  /**
   * The names other than the one shown in the banner
   */
  protected void addNames(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
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
      nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_ALT_NAME), context.formatPhrase(RenderingI18nContext.PAT_ALT_NAME_HINT));
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

  /**
   * telecom and address
   */
  protected void addComms(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r, String hint) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> tels = r.children("telecom");
    List<ResourceWrapper> adds = r.children("address");
    if (tels.size() + adds.size() > 0) {
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_CONTACT), hint);
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

  protected void nameCell(XhtmlNode tr, String text, String title) {
    XhtmlNode td = tr.td();
    td.setAttribute("title", title);
    td.tx(text);
    td.style("background-color: #f3f5da");
    markBoilerplate(td);
  }

  protected void nameCell(XhtmlNode tr, String text, String title, String link) {
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

  /**
   * A contact (ExtendedContactDetail from R5; in R4, Organization.contact has the same shape apart from period and organization)
   */
  protected void addContactDetail(RenderingStatus status, XhtmlNode tbl, ResourceWrapper c, String hint) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> items = new ArrayList<>();
    items.addAll(c.children("name"));
    items.addAll(c.children("telecom"));
    items.addAll(c.children("address"));
    items.addAll(c.children("organization"));
    if (items.isEmpty()) {
      return;
    }
    XhtmlNode tr = tbl.tr();
    if (c.has("purpose")) {
      nameCell(tr, conceptText(c.child("purpose"))+":", hint);
    } else {
      nameCell(tr, context.formatPhrase(RenderingI18nContext.PAT_CONTACT), hint);
    }
    XhtmlNode td = tr.td();
    td.colspan("3");
    XhtmlNode ul = td.ul();
    for (ResourceWrapper item : items) {
      if ("Reference".equals(item.fhirType())) {
        renderReference(status, ul.li(), item);
      } else {
        renderDataType(status, xlinkNarrative(ul.li(), item), item);
      }
    }
    if (c.has("period")) {
      XhtmlNode li = ul.li();
      li.tx(context.formatPhrase(RenderingI18nContext.PAT_PERIOD)+" ");
      renderDataType(status, xlinkNarrative(li, c.child("period")), c.child("period"));
    }
  }

  /**
   * When something is available. In R4, the times are directly on the resource (availableTime, notAvailable, 
   * availabilityExceptions - or for Location, hoursOfOperation with openingTime/closingTime); from R5 they're 
   * in an Availability datatype (availableTime, notAvailableTime) in the named element
   */
  protected void addAvailability(RenderingStatus status, XhtmlNode tbl, ResourceWrapper r, String elementName, String label, String hint) throws FHIRFormatError, DefinitionException, IOException {
    List<ResourceWrapper> available = new ArrayList<>();
    List<ResourceWrapper> notAvailable = new ArrayList<>();
    // R4
    available.addAll(r.children("availableTime"));
    notAvailable.addAll(r.children("notAvailable"));
    // R5+ (and R4 Location.hoursOfOperation, which is a list of times)
    for (ResourceWrapper a : r.children(elementName)) {
      if ("Availability".equals(a.fhirType()) || a.has("availableTime") || a.has("notAvailableTime")) {
        available.addAll(a.children("availableTime"));
        notAvailable.addAll(a.children("notAvailableTime"));
      } else {
        available.add(a);
      }
    }
    ResourceWrapper exceptions = r.child("availabilityExceptions"); // R4
    if (available.isEmpty() && notAvailable.isEmpty() && exceptions == null) {
      return;
    }
    XhtmlNode tr = tbl.tr();
    nameCell(tr, label, hint);
    XhtmlNode td = tr.td();
    td.colspan("3");
    XhtmlNode ul = td.ul();
    for (ResourceWrapper at : available) {
      XhtmlNode li = ul.li();
      boolean first = true;
      for (ResourceWrapper d : at.children("daysOfWeek")) {
        if (first) first = false; else li.tx(", ");
        renderDataType(status, xlinkNarrative(li, d), d);
      }
      if (!first) {
        li.tx(": ");
      }
      if ("true".equals(at.primitiveValue("allDay"))) {
        spanIfTracking(li, at.child("allDay")).tx(context.formatPhrase(RenderingI18nContext.PRR_ALL_DAY));
      } else {
        ResourceWrapper start = at.childMN("availableStartTime", "openingTime"); // R4 Location uses opening/closing 
        ResourceWrapper end = at.childMN("availableEndTime", "closingTime");
        if (start != null || end != null) {
          if (start != null) {
            renderDataType(status, xlinkNarrative(li, start), start);
          }
          li.tx(" - ");
          if (end != null) {
            renderDataType(status, xlinkNarrative(li, end), end);
          }
        }
      }
    }
    for (ResourceWrapper na : notAvailable) {
      XhtmlNode li = ul.li();
      li.tx(context.formatPhrase(RenderingI18nContext.PRR_NOT_AVAIL)+" ");
      if (na.has("description")) {
        renderDataType(status, xlinkNarrative(li, na.child("description")), na.child("description"));
      }
      if (na.has("during")) {
        li.tx(" (");
        renderDataType(status, xlinkNarrative(li, na.child("during")), na.child("during"));
        li.tx(")");
      }
    }
    if (exceptions != null) {
      XhtmlNode li = ul.li();
      li.tx(context.formatPhrase(RenderingI18nContext.PRR_AVAIL_EXC)+" ");
      renderDataType(status, xlinkNarrative(li, exceptions), exceptions);
    }
  }

  /**
   * Practitioner.qualification and Organization.qualification (R5+)
   */
  protected void addQualification(RenderingStatus status, XhtmlNode tbl, ResourceWrapper q) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tr = tbl.tr();
    nameCell(tr, context.formatPhrase(RenderingI18nContext.PRAC_QUAL), context.formatPhrase(RenderingI18nContext.PRAC_QUAL_HINT));
    XhtmlNode td = tr.td();
    td.colspan("3");
    if (q.has("code")) {
      renderDataType(status, xlinkNarrative(td, q.child("code")), q.child("code"));
    }
    if (q.has("identifier") || q.has("status") || q.has("period") || q.has("issuer")) {
      XhtmlNode ul = td.ul();
      for (ResourceWrapper id : q.children("identifier")) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.PRAC_QUAL_ID)+" ");
        renderDataType(status, xlinkNarrative(li, id), id);
      }
      if (q.has("status")) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.PRAC_QUAL_STATUS)+" ");
        renderDataType(status, xlinkNarrative(li, q.child("status")), q.child("status"));
      }
      if (q.has("period")) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.PAT_PERIOD)+" ");
        renderDataType(status, xlinkNarrative(li, q.child("period")), q.child("period"));
      }
      if (q.has("issuer")) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.PRAC_QUAL_ISSUER)+" ");
        renderReference(status, li, q.child("issuer"));
      }
    }
  }

  // ---- layout --------------------------------------------------------------------------------

  /**
   * Start the table - next to the photo if there is one
   */
  protected XhtmlNode startTable(XhtmlNode x, ResourceWrapper r, String inlinePhotoAlt, String filePhotoAlt) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tbl;
    if (hasRenderablePhoto(r)) {
      tbl = x.table(null, true).markGenerated(!context.forValidResource());
      XhtmlNode tr = tbl.tr();
      tbl = tr.td().table("grid", false).markGenerated(!context.forValidResource());
      renderPhoto(tr.td(), r, inlinePhotoAlt, filePhotoAlt);
    } else {
      tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    }
    return tbl;
  }

  /**
   * finish off: drop the table if nothing went in it, and list contained resources in technical mode
   */
  protected void finishNarrative(RenderingStatus status, XhtmlNode x, XhtmlNode tbl, ResourceWrapper r) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    if (tbl.isEmpty()) {
      x.remove(tbl);
    }
    addContainedResources(status, x, r);
  }

  /**
   * in technical mode, list any contained resources
   */
  protected void addContainedResources(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    if (r.has("contained") && context.isTechnicalMode()) {
      x.hr();
      x.para().b().tx(context.formatMessagePlural(r.children("contained").size(), RenderingContext.PAT_CONTAINED));
      addContained(status, x, r.children("contained"));
    }
  }

  protected void renderPhoto(XhtmlNode td, ResourceWrapper r, String inlineAlt, String fileAlt) throws UnsupportedEncodingException, FHIRException, IOException {
    if (r.has("photo")) {
      List<ResourceWrapper> a = r.children("photo");
      for (ResourceWrapper att : a) {
        String ct = att.primitiveValue("contentType");
        byte[] cnt = att.has("data") ? Utilities.decodeBase64(att.primitiveValue("data"), true) : null;
        if (ct != null && ct.startsWith("image/") &&
            cnt != null && (!context.isInlineGraphics() || (cnt.length > 0 && cnt.length < MAX_IMAGE_LENGTH))) {
          String ext = extensionForType(ct);
          if (context.isInlineGraphics() || Utilities.noString(context.getDestDir()) || ext == null) {
            td.img("data:"+ct+";base64,"+att.primitiveValue("data"), inlineAlt);
          } else {
            String n = context.getRandomName(r.getId())+ext;
            FileUtilities.bytesToFile(cnt, ManagedFileAccess.file(Utilities.path(context.getDestDir(), n)));
            context.registerFile(n);
            td.img(n, fileAlt);
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

  protected boolean hasRenderablePhoto(ResourceWrapper r) throws UnsupportedEncodingException, FHIRException, IOException {
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

  protected XhtmlNode makeBanner(XhtmlNode para, ResourceWrapper res) {
    para.style("border: 1px #661aff solid; background-color: #e6e6ff; padding: 10px;");
    xlinkNarrative(para, res);
    return para;
  }

}
