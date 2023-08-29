package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.Annotation;
import org.hl7.fhir.r4b.model.Attachment;
import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.ContactDetail;
import org.hl7.fhir.r4b.model.ContactPoint;
import org.hl7.fhir.r4b.model.DataRequirement;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Library;
import org.hl7.fhir.r4b.model.ListResource;
import org.hl7.fhir.r4b.model.ListResource.ListResourceEntryComponent;
import org.hl7.fhir.r4b.model.ParameterDefinition;
import org.hl7.fhir.r4b.model.Reference;
import org.hl7.fhir.r4b.model.RelatedArtifact;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class LibraryRenderer extends ResourceRenderer {

  private static final int DATA_IMG_SIZE_CUTOFF = 4000;

  public LibraryRenderer(RenderingContext context) {
    super(context);
  }

  public LibraryRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (Library) dr);
  }

  public boolean render(XhtmlNode x, ResourceWrapper lib) throws FHIRFormatError, DefinitionException, IOException {
    PropertyWrapper authors = lib.getChildByName("author");
    PropertyWrapper editors = lib.getChildByName("editor");
    PropertyWrapper reviewers = lib.getChildByName("reviewer");
    PropertyWrapper endorsers = lib.getChildByName("endorser");
    if ((authors != null && authors.hasValues()) || (editors != null && editors.hasValues())
        || (reviewers != null && reviewers.hasValues()) || (endorsers != null && endorsers.hasValues())) {
      boolean email = hasCT(authors, "email") || hasCT(editors, "email") || hasCT(reviewers, "email")
          || hasCT(endorsers, "email");
      boolean phone = hasCT(authors, "phone") || hasCT(editors, "phone") || hasCT(reviewers, "phone")
          || hasCT(endorsers, "phone");
      boolean url = hasCT(authors, "url") || hasCT(editors, "url") || hasCT(reviewers, "url")
          || hasCT(endorsers, "url");
      x.h2().tx("Participants");
      XhtmlNode t = x.table("grid");
      if (authors != null) {
        for (BaseWrapper cd : authors.getValues()) {
          participantRow(t, "Author", cd, email, phone, url);
        }
      }
      if (authors != null) {
        for (BaseWrapper cd : editors.getValues()) {
          participantRow(t, "Editor", cd, email, phone, url);
        }
      }
      if (authors != null) {
        for (BaseWrapper cd : reviewers.getValues()) {
          participantRow(t, "Reviewer", cd, email, phone, url);
        }
      }
      if (authors != null) {
        for (BaseWrapper cd : endorsers.getValues()) {
          participantRow(t, "Endorser", cd, email, phone, url);
        }
      }
    }
    PropertyWrapper artifacts = lib.getChildByName("relatedArtifact");
    if (artifacts != null && artifacts.hasValues()) {
      x.h2().tx("Related Artifacts");
      XhtmlNode t = x.table("grid");
      boolean label = false;
      boolean display = false;
      boolean citation = false;
      for (BaseWrapper ra : artifacts.getValues()) {
        label = label || ra.has("label");
        display = display || ra.has("display");
        citation = citation || ra.has("citation");
      }
      for (BaseWrapper ra : artifacts.getValues()) {
        renderArtifact(t, ra, lib, label, display, citation);
      }
    }
    PropertyWrapper parameters = lib.getChildByName("parameter");
    if (parameters != null && parameters.hasValues()) {
      x.h2().tx("Parameters");
      XhtmlNode t = x.table("grid");
      boolean doco = false;
      for (BaseWrapper p : parameters.getValues()) {
        doco = doco || p.has("documentation");
      }
      for (BaseWrapper p : parameters.getValues()) {
        renderParameter(t, p, doco);
      }
    }
    PropertyWrapper dataRequirements = lib.getChildByName("dataRequirement");
    if (dataRequirements != null && dataRequirements.hasValues()) {
      x.h2().tx("Data Requirements");
      for (BaseWrapper p : dataRequirements.getValues()) {
        renderDataRequirement(x, (DataRequirement) p.getBase());
      }
    }
    PropertyWrapper contents = lib.getChildByName("content");
    if (contents != null) {
      x.h2().tx("Contents");
      boolean isCql = false;
      int counter = 0;
      for (BaseWrapper p : contents.getValues()) {
        Attachment att = (Attachment) p.getBase();
        renderAttachment(x, att, isCql, counter, lib.getId());
        isCql = isCql || (att.hasContentType() && att.getContentType().startsWith("text/cql"));
        counter++;
      }
    }
    return false;
  }

  private boolean hasCT(PropertyWrapper prop, String type)
      throws UnsupportedEncodingException, FHIRException, IOException {
    if (prop != null) {
      for (BaseWrapper cd : prop.getValues()) {
        PropertyWrapper telecoms = cd.getChildByName("telecom");
        if (getContactPoint(telecoms, type) != null) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean hasCT(List<ContactDetail> list, String type) {
    for (ContactDetail cd : list) {
      for (ContactPoint t : cd.getTelecom()) {
        if (type.equals(t.getSystem().toCode())) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean render(XhtmlNode x, Library lib) throws FHIRFormatError, DefinitionException, IOException {
    if (lib.hasAuthor() || lib.hasEditor() || lib.hasReviewer() || lib.hasEndorser()) {
      boolean email = hasCT(lib.getAuthor(), "email") || hasCT(lib.getEditor(), "email")
          || hasCT(lib.getReviewer(), "email") || hasCT(lib.getEndorser(), "email");
      boolean phone = hasCT(lib.getAuthor(), "phone") || hasCT(lib.getEditor(), "phone")
          || hasCT(lib.getReviewer(), "phone") || hasCT(lib.getEndorser(), "phone");
      boolean url = hasCT(lib.getAuthor(), "url") || hasCT(lib.getEditor(), "url") || hasCT(lib.getReviewer(), "url")
          || hasCT(lib.getEndorser(), "url");
      x.h2().tx("Participants");
      XhtmlNode t = x.table("grid");
      for (ContactDetail cd : lib.getAuthor()) {
        participantRow(t, "Author", cd, email, phone, url);
      }
      for (ContactDetail cd : lib.getEditor()) {
        participantRow(t, "Editor", cd, email, phone, url);
      }
      for (ContactDetail cd : lib.getReviewer()) {
        participantRow(t, "Reviewer", cd, email, phone, url);
      }
      for (ContactDetail cd : lib.getEndorser()) {
        participantRow(t, "Endorser", cd, email, phone, url);
      }
    }
    if (lib.hasRelatedArtifact()) {
      x.h2().tx("Related Artifacts");
      XhtmlNode t = x.table("grid");
      boolean label = false;
      boolean display = false;
      boolean citation = false;
      for (RelatedArtifact ra : lib.getRelatedArtifact()) {
        label = label || ra.hasLabel();
        display = display || ra.hasDisplay();
        citation = citation || ra.hasCitation();
      }
      for (RelatedArtifact ra : lib.getRelatedArtifact()) {
        renderArtifact(t, ra, lib, label, display, citation);
      }
    }
    if (lib.hasParameter()) {
      x.h2().tx("Parameters");
      XhtmlNode t = x.table("grid");
      boolean doco = false;
      for (ParameterDefinition p : lib.getParameter()) {
        doco = doco || p.hasDocumentation();
      }
      for (ParameterDefinition p : lib.getParameter()) {
        renderParameter(t, p, doco);
      }
    }
    if (lib.hasDataRequirement()) {
      x.h2().tx("Data Requirements");
      for (DataRequirement p : lib.getDataRequirement()) {
        renderDataRequirement(x, p);
      }
    }
    if (lib.hasContent()) {
      x.h2().tx("Contents");
      boolean isCql = false;
      int counter = 0;
      for (Attachment att : lib.getContent()) {
        renderAttachment(x, att, isCql, counter, lib.getId());
        isCql = isCql || (att.hasContentType() && att.getContentType().startsWith("text/cql"));
        counter++;
      }
    }
    return false;
  }

  private void renderParameter(XhtmlNode t, BaseWrapper p, boolean doco)
      throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tr = t.tr();
    tr.td().tx(p.has("name") ? p.get("name").primitiveValue() : null);
    tr.td().tx(p.has("use") ? p.get("use").primitiveValue() : null);
    tr.td().tx(p.has("min") ? p.get("min").primitiveValue() : null);
    tr.td().tx(p.has("max") ? p.get("max").primitiveValue() : null);
    tr.td().tx(p.has("type") ? p.get("type").primitiveValue() : null);
    if (doco) {
      tr.td().tx(p.has("documentation") ? p.get("documentation").primitiveValue() : null);
    }
  }

  private void renderParameter(XhtmlNode t, ParameterDefinition p, boolean doco) {
    XhtmlNode tr = t.tr();
    tr.td().tx(p.getName());
    tr.td().tx(p.getUse().getDisplay());
    tr.td().tx(p.getMin());
    tr.td().tx(p.getMax());
    tr.td().tx(p.getType().getDisplay());
    if (doco) {
      tr.td().tx(p.getDocumentation());
    }
  }

  private void renderArtifact(XhtmlNode t, BaseWrapper ra, ResourceWrapper lib, boolean label, boolean display,
      boolean citation) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tr = t.tr();
    tr.td().tx(ra.has("type") ? ra.get("type").primitiveValue() : null);
    if (label) {
      tr.td().tx(ra.has("label") ? ra.get("label").primitiveValue() : null);
    }
    if (display) {
      tr.td().tx(ra.has("display") ? ra.get("display").primitiveValue() : null);
    }
    if (citation) {
      tr.td().markdown(ra.has("citation") ? ra.get("citation").primitiveValue() : null, "Citation");
    }
    if (ra.has("resource")) {
      renderCanonical(lib, tr.td(), ra.get("resource").primitiveValue());
    } else {
      tr.td().tx(ra.has("url") ? ra.get("url").primitiveValue() : null);
    }
  }

  private void renderArtifact(XhtmlNode t, RelatedArtifact ra, Resource lib, boolean label, boolean display,
      boolean citation) throws IOException {
    XhtmlNode tr = t.tr();
    tr.td().tx(ra.getType().getDisplay());
    if (label) {
      tr.td().tx(ra.getLabel());
    }
    if (display) {
      tr.td().tx(ra.getDisplay());
    }
    if (citation) {
      tr.td().markdown(ra.getCitation(), "Citation");
    }
    if (ra.hasResource()) {
      renderCanonical(lib, tr.td(), ra.getResource());
    } else {
      renderAttachment(tr.td(), ra.getDocument(), false, 0, lib.getId());
    }
  }

  private void participantRow(XhtmlNode t, String label, BaseWrapper cd, boolean email, boolean phone, boolean url)
      throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tr = t.tr();
    tr.td().tx(label);
    tr.td().tx(cd.get("name") != null ? cd.get("name").primitiveValue() : null);
    PropertyWrapper telecoms = cd.getChildByName("telecom");
    if (email) {
      renderContactPoint(tr.td(), getContactPoint(telecoms, "email"));
    }
    if (phone) {
      renderContactPoint(tr.td(), getContactPoint(telecoms, "phone"));
    }
    if (url) {
      renderContactPoint(tr.td(), getContactPoint(telecoms, "url"));
    }
  }

  private ContactPoint getContactPoint(PropertyWrapper telecoms, String value)
      throws UnsupportedEncodingException, FHIRException, IOException {
    for (BaseWrapper t : telecoms.getValues()) {
      if (t.has("system")) {
        String system = t.get("system").primitiveValue();
        if (value.equals(system)) {
          return (ContactPoint) t.getBase();
        }
      }
    }
    return null;
  }

  private void participantRow(XhtmlNode t, String label, ContactDetail cd, boolean email, boolean phone, boolean url) {
    XhtmlNode tr = t.tr();
    tr.td().tx(label);
    tr.td().tx(cd.getName());
    if (email) {
      renderContactPoint(tr.td(), cd.getEmail());
    }
    if (phone) {
      renderContactPoint(tr.td(), cd.getPhone());
    }
    if (url) {
      renderContactPoint(tr.td(), cd.getUrl());
    }
  }

  public void describe(XhtmlNode x, Library lib) {
    x.tx(display(lib));
  }

  public String display(Library lib) {
    return lib.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((Library) r).present();
  }

  @Override
  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    return "??";
  }

  private void renderAttachment(XhtmlNode x, Attachment att, boolean noShowData, int counter, String baseId) {
    boolean ref = !att.hasData() && att.hasUrl();
    if (ref) {
      XhtmlNode p = x.para();
      if (att.hasTitle()) {
        p.tx(att.getTitle());
        p.tx(": ");
      }
      p.code().ah(att.getUrl()).tx(att.getUrl());
      p.tx(" (");
      p.code().tx(att.getContentType());
      p.tx(lang(att));
      p.tx(")");
    } else if (!att.hasData()) {
      XhtmlNode p = x.para();
      if (att.hasTitle()) {
        p.tx(att.getTitle());
        p.tx(": ");
      }
      p.code().tx("No Content");
      p.tx(" (");
      p.code().tx(att.getContentType());
      p.tx(lang(att));
      p.tx(")");
    } else {
      String txt = getText(att);
      if (isImage(att.getContentType())) {
        XhtmlNode p = x.para();
        if (att.hasTitle()) {
          p.tx(att.getTitle());
          p.tx(": (");
          p.code().tx(att.getContentType());
          p.tx(lang(att));
          p.tx(")");
        } else {
          p.code().tx(att.getContentType() + lang(att));
        }
        if (att.getData().length < LibraryRenderer.DATA_IMG_SIZE_CUTOFF) {
          x.img("data: " + att.getContentType() + ">;base64," + b64(att.getData()), "data");
        } else {
          String filename = "Library-" + baseId + (counter == 0 ? "" : "-" + Integer.toString(counter)) + "."
              + imgExtension(att.getContentType());
          x.img(filename, "data");
        }
      } else if (txt != null && !noShowData) {
        XhtmlNode p = x.para();
        if (att.hasTitle()) {
          p.tx(att.getTitle());
          p.tx(": (");
          p.code().tx(att.getContentType());
          p.tx(lang(att));
          p.tx(")");
        } else {
          p.code().tx(att.getContentType() + lang(att));
        }
        String prismCode = determinePrismCode(att);
        if (prismCode != null && !tooBig(txt)) {
          x.pre().code().setAttribute("class", "language-" + prismCode).tx(txt);
        } else {
          x.pre().code().tx(txt);
        }
      } else {
        XhtmlNode p = x.para();
        if (att.hasTitle()) {
          p.tx(att.getTitle());
          p.tx(": ");
        }
        p.code().tx("Content not shown - (");
        p.code().tx(att.getContentType());
        p.tx(lang(att));
        p.tx(", size = " + Utilities.describeSize(att.getData().length) + ")");
      }
    }
  }

  private boolean tooBig(String txt) {
    return txt.length() > 16384;
  }

  private String imgExtension(String contentType) {
    if (contentType != null && contentType.startsWith("image/")) {
      if (contentType.startsWith("image/png")) {
        return "png";
      }
      if (contentType.startsWith("image/jpeg")) {
        return "jpg";
      }
    }
    return null;
  }

  private String b64(byte[] data) {
    byte[] encodeBase64 = Base64.encodeBase64(data);
    return new String(encodeBase64);
  }

  private boolean isImage(String contentType) {
    return imgExtension(contentType) != null;
  }

  private String lang(Attachment att) {
    if (att.hasLanguage()) {
      return ", language = " + describeLang(att.getLanguage());
    }
    return "";
  }

  private String getText(Attachment att) {
    try {
      try {
        String src = new String(att.getData(), "UTF-8");
        if (checkString(src)) {
          return src;
        }
      } catch (Exception e) {
        // ignore
      }
      try {
        String src = new String(att.getData(), "UTF-16");
        if (checkString(src)) {
          return src;
        }
      } catch (Exception e) {
        // ignore
      }
      try {
        String src = new String(att.getData(), "ASCII");
        if (checkString(src)) {
          return src;
        }
      } catch (Exception e) {
        // ignore
      }
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  public boolean checkString(String src) {
    for (char ch : src.toCharArray()) {
      if (ch < ' ' && ch != '\r' && ch != '\n' && ch != '\t') {
        return false;
      }
    }
    return true;
  }

  private String determinePrismCode(Attachment att) {
    if (att.hasContentType()) {
      String ct = att.getContentType();
      if (ct.contains(";")) {
        ct = ct.substring(0, ct.indexOf(";"));
      }
      switch (ct) {
      case "text/html":
        return "html";
      case "text/xml":
        return "xml";
      case "application/xml":
        return "xml";
      case "text/markdown":
        return "markdown";
      case "application/js":
        return "JavaScript";
      case "application/css":
        return "css";
      case "text/x-csrc":
        return "c";
      case "text/x-csharp":
        return "csharp";
      case "text/x-c++src":
        return "cpp";
      case "application/graphql":
        return "graphql";
      case "application/x-java":
        return "java";
      case "application/json":
        return "json";
      case "text/json":
        return "json";
      case "application/liquid":
        return "liquid";
      case "text/x-pascal":
        return "pascal";
      case "text/x-python":
        return "python";
      case "text/x-rsrc":
        return "r";
      case "text/x-ruby":
        return "ruby";
      case "text/x-sas":
        return "sas";
      case "text/x-sql":
        return "sql";
      case "application/typescript":
        return "typescript";
      case "text/cql":
        return "sql"; // not that bad...
      }
      if (att.getContentType().contains("json+") || att.getContentType().contains("+json")) {
        return "json";
      }
      if (att.getContentType().contains("xml+") || att.getContentType().contains("+xml")) {
        return "xml";
      }
    }
    return null;
  }

}
