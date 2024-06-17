package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Attachment;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.DataRequirement;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.ParameterDefinition;
import org.hl7.fhir.r5.model.RelatedArtifact;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class LibraryRenderer extends ResourceRenderer {

  private static final int DATA_IMG_SIZE_CUTOFF = 4000; 
  
  public LibraryRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement lib) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
   
    List<ResourceElement> authors = lib.children("author");
    List<ResourceElement> editors = lib.children("editor");
    List<ResourceElement> reviewers = lib.children("reviewer");
    List<ResourceElement> endorsers = lib.children("endorser");
    if (!authors.isEmpty() || !editors.isEmpty() || !reviewers.isEmpty() || !endorsers.isEmpty()) {
      boolean email = hasCT(authors, "email") || hasCT(editors, "email") || hasCT(reviewers, "email") || hasCT(endorsers, "email"); 
      boolean phone = hasCT(authors, "phone") || hasCT(editors, "phone") || hasCT(reviewers, "phone") || hasCT(endorsers, "phone"); 
      boolean url = hasCT(authors, "url") || hasCT(editors, "url") || hasCT(reviewers, "url") || hasCT(endorsers, "url"); 
      x.h2().tx(context.formatPhrase(RenderingContext.LIB_REND_PAR));
      XhtmlNode t = x.table("grid");
      for (ResourceElement cd : authors) {
        participantRow(status, t, (context.formatPhrase(RenderingContext.LIB_REND_AUT)), cd, email, phone, url);
      }

      for (ResourceElement cd : editors) {
        participantRow(status, t, (context.formatPhrase(RenderingContext.LIB_REND_ED)), cd, email, phone, url);
      }
      for (ResourceElement cd : reviewers) {
        participantRow(status, t, (context.formatPhrase(RenderingContext.LIB_REND_REV)), cd, email, phone, url);
      }
      for (ResourceElement cd : endorsers) {
        participantRow(status, t, (context.formatPhrase(RenderingContext.LIB_REND_END)), cd, email, phone, url);
      }
    }
    List<ResourceElement> artifacts = lib.children("relatedArtifact");
    if (!artifacts.isEmpty()) {
      x.h2().tx(context.formatPhrase(RenderingContext.LIB_REND_ART));
      XhtmlNode t = x.table("grid");
      boolean label = false;
      boolean display = false;
      boolean citation = false;
      for (ResourceElement ra : artifacts) {
        label = label || ra.has("label");
        display = display || ra.has("display");
        citation = citation || ra.has("citation");
      }
      for (ResourceElement ra : artifacts) {
        renderArtifact(status, t, ra, lib, label, display, citation);
      }      
    }
    List<ResourceElement> parameters = lib.children("parameter");
    if (!parameters.isEmpty()) {
      x.h2().tx(context.formatPhrase(RenderingContext.GENERAL_PARS));
      XhtmlNode t = x.table("grid");
      boolean doco = false;
      for (ResourceElement p : parameters) {
        doco = doco || p.has("documentation");
      }
      for (ResourceElement p : parameters) {
        renderParameter(t, p, doco);
      }      
    }
    List<ResourceElement> dataRequirements = lib.children("dataRequirement");
    if (!dataRequirements.isEmpty()) {
      x.h2().tx(context.formatPhrase(RenderingContext.LIB_REND_REQ));
      for (ResourceElement p : dataRequirements) {
        renderDataRequirement(status, x, p);
      }      
    }
    List<ResourceElement> contents = lib.children("content");
    if (!contents.isEmpty()) {
      x.h2().tx(context.formatPhrase(RenderingContext.LIB_REND_CONT));          
      boolean isCql = false;
      int counter = 0;
      for (ResourceElement p : contents) {
        renderAttachment(x, p, isCql, counter, lib.getId());
        isCql = isCql || (p.has("contentType") && p.primitiveValue("contentType").startsWith("text/cql"));
        counter++;
      }
    }
  }
    
  private boolean hasCT(List<ResourceElement> list, String type) throws UnsupportedEncodingException, FHIRException, IOException {
    for (ResourceElement cd : list) {
      List<ResourceElement> telecoms = cd.children("telecom");
      if (hasContactPoint(telecoms, type)) {
        return true;
      }
    }
    return false;
  }

  private boolean hasContactPoint(List<ResourceElement> list, String type) {
    for (ResourceElement cd : list) {
      for (ResourceElement t : cd.children("telecom")) {
        if (type.equals(t.primitiveValue("system"))) {
          return true;
        }
      }
    }
    return false;
  }

  private ResourceElement getContactPoint(List<ResourceElement> list, String type) {
    for (ResourceElement cd : list) {
      for (ResourceElement t : cd.children("telecom")) {
        if (type.equals(t.primitiveValue("system"))) {
          return t;
        }
      }
    }
    return null;
  }

  private void renderParameter(XhtmlNode t, ResourceElement p, boolean doco) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tr = t.tr();
    tr.td().tx(p.has("name") ? p.primitiveValue("name") : null);
    tr.td().tx(p.has("use") ? p.primitiveValue("use") : null);
    tr.td().tx(p.has("min") ? p.primitiveValue("min") : null);
    tr.td().tx(p.has("max") ? p.primitiveValue("max") : null);
    tr.td().tx(p.has("type") ? p.primitiveValue("type") : null);
    if (doco) {
      tr.td().tx(p.has("documentation") ? p.primitiveValue("documentation") : null);
    }
  }


  private void renderArtifact(RenderingStatus status, XhtmlNode t, ResourceElement ra, ResourceElement lib, boolean label, boolean display, boolean citation) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tr = t.tr();
    tr.td().tx(ra.has("type") ? ra.primitiveValue("type") : null);
    if (label) {
      tr.td().tx(ra.has("label") ? ra.primitiveValue("label") : null);
    }
    if (display) {
      tr.td().tx(ra.has("display") ? ra.primitiveValue("display") : null);
    }
    if (citation) {
      tr.td().markdown(ra.has("citation") ? ra.primitiveValue("citation") : null, "Citation");
    }
    if (ra.has("resource")) {
      renderCanonical(status, tr.td(), Resource.class, ra.child("resource"));
    } else {
      tr.td().tx(ra.has("url") ? ra.primitiveValue("url") : null);
    }
  }

  private void participantRow(RenderingStatus status, XhtmlNode t, String label, ResourceElement cd, boolean email, boolean phone, boolean url) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode tr = t.tr();
    tr.td().tx(label);
    tr.td().tx(cd.has("name") ? cd.primitiveValue("name") : null);
    List<ResourceElement> telecoms = cd.children("telecom");
    if (email) {
      renderContactPoint(status, tr.td(), getContactPoint(telecoms, "email"));
    }
    if (phone) {
      renderContactPoint(status, tr.td(), getContactPoint(telecoms, "phone"));
    }
    if (url) {
      renderContactPoint(status, tr.td(), getContactPoint(telecoms, "url"));
    }
  }


  private void renderAttachment(XhtmlNode x, ResourceElement att, boolean noShowData, int counter, String baseId) {
    String url = att.primitiveValue("url");
    String title = att.primitiveValue("title");
    String ct =  att.primitiveValue("contentType");
    
    boolean ref = !att.has("data") && att.has("url");
    if (ref) {
      XhtmlNode p = x.para();
      if (att.has("title")) {
        p.tx(title);
        p.tx(": ");
      }
      Resource res = context.getContext().fetchResource(Resource.class, url);
      if (res == null || !res.hasWebPath()) {
        p.code().ah(url).tx(url);        
      } else if (res instanceof CanonicalResource) {
        p.code().ah(res.getWebPath()).tx(((CanonicalResource) res).present());        
      } else {
        p.code().ah(res.getWebPath()).tx(url);        
      }
      p.tx(" (");
      p.code().tx(ct);
      p.tx(lang(att));
      p.tx(")");
    } else if (!att.has("data")) {
      XhtmlNode p = x.para();
      if (att.has("title")) {
        p.tx(title);
        p.tx(": ");
      }
      p.code().tx(context.formatPhrase(RenderingContext.LIB_REND_NOCONT));
      p.tx(" (");
      p.code().tx(ct);
      p.tx(lang(att));
      p.tx(")");
    } else {
      byte[] cnt = Base64.decodeBase64(att.primitiveValue("data"));
      String txt = getText(cnt);
      if (isImage(ct)) {
        XhtmlNode p = x.para();
        if (att.has("title")) {
          p.tx(title);
          p.tx(": (");
          p.code().tx(ct);
          p.tx(lang(att));
          p.tx(")");
        }
        else {
          p.code().tx(ct+lang(att));
        }
        if (cnt.length < LibraryRenderer.DATA_IMG_SIZE_CUTOFF) {
          x.img("data: "+ct+">;base64,"+b64(cnt), "data");
        } else {
          String filename = "Library-"+baseId+(counter == 0 ? "" : "-"+Integer.toString(counter))+"."+imgExtension(ct); 
          x.img(filename, "data");
        }        
      } else if (txt != null && !noShowData) {
        XhtmlNode p = x.para();
        if (att.has("title")) {
          p.tx(title);
          p.tx(": (");
          p.code().tx(ct);
          p.tx(lang(att));
          p.tx(")");
        }
        else {
          p.code().tx(ct+lang(att));
        }
        String prismCode = determinePrismCode(ct);
        if (prismCode != null && !tooBig(txt)) {
          x.pre().code().setAttribute("class", "language-"+prismCode).tx(txt);
        } else {
          x.pre().code().tx(txt);
        }
      } else {
        XhtmlNode p = x.para();
        if (att.has("title")) {
          p.tx(title);
          p.tx(": ");
        }
        p.code().tx(context.formatPhrase(RenderingContext.LIB_REND_SHOW));
        p.code().tx(ct);
        p.tx(lang(att));
        p.tx((context.formatPhrase(RenderingContext.LIB_REND_SIZE, Utilities.describeSize(cnt.length))+" ")+")");
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

  private String lang(ResourceElement att) {
    if (att.has("language")) {
      return ", language = "+describeLang(att.primitiveValue("language"));
    }
    return "";
  }

  private String getText( byte[] cnt) {
    try {
      try {
        String src = new String(cnt, "UTF-8");
        if (checkString(src)) {
          return src;
        }
      } catch (Exception e) {
        // ignore
      }
      try {
        String src = new String(cnt, "UTF-16");
        if (checkString(src)) {
          return src;
        }
      } catch (Exception e) {
        // ignore
      }
      try {
        String src = new String(cnt, "ASCII");
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

  private String determinePrismCode(String ct) {
    if (!Utilities.noString(ct)) {
      if (ct.contains(";")) {
        ct = ct.substring(0, ct.indexOf(";"));
      }
      switch (ct) {
      case "text/html" : return "html";
      case "text/xml" : return "xml";
      case "application/xml" : return "xml";
      case "text/markdown" : return "markdown";
      case "application/js" : return "JavaScript";
      case "application/css" : return "css";
      case "text/x-csrc" : return "c";
      case "text/x-csharp" : return "csharp";
      case "text/x-c++src" : return "cpp";
      case "application/graphql" : return "graphql";
      case "application/x-java" : return "java";
      case "application/json" : return "json";
      case "text/json" : return "json";
      case "application/liquid" : return "liquid";
      case "text/x-pascal" : return "pascal";
      case "text/x-python" : return "python";
      case "text/x-rsrc" : return "r";
      case "text/x-ruby" : return "ruby";
      case "text/x-sas" : return "sas";
      case "text/x-sql" : return "sql";
      case "application/typescript" : return "typescript";
      case "text/cql" : return "sql"; // not that bad...
      }
      if (ct.contains("json+") || ct.contains("+json")) {
        return "json";
      }
      if (ct.contains("xml+") || ct.contains("+xml")) {
        return "xml";
      }
    }
    return null;
  }
  
  
}
