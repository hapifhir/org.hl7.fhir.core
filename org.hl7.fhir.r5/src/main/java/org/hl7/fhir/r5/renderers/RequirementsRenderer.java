package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Requirements;
import org.hl7.fhir.r5.model.Requirements.ConformanceExpectation;
import org.hl7.fhir.r5.model.Requirements.RequirementsStatementComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class RequirementsRenderer extends ResourceRenderer {

  public RequirementsRenderer(RenderingContext context) { 
    super(context); 
  } 

  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement req) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (req.has("actor")) {
      List<ResourceElement> actors = req.children("actor");
      if (actors.size() == 1) {
        ActorDefinition acd = context.getWorker().fetchResource(ActorDefinition.class, actors.get(0).primitiveValue(), req);
        XhtmlNode p = x.para();
        p.tx(context.formatPhrase(RenderingContext.REQ_ACTOR)+" ");
        if (acd == null) {
          p.code(actors.get(0).primitiveValue());
        } else {
          p.ah(acd.getWebPath()).tx(acd.present());
        }
      } else {
        x.para().tx(context.formatPhrase(RenderingContext.REQ_FOLLOWING_ACTOR)+" ");
        XhtmlNode ul = x.ul();
        for (ResourceElement a : actors) {
          ActorDefinition acd = context.getWorker().fetchResource(ActorDefinition.class, a.primitiveValue(), req);
          if (acd == null) {
            ul.li().code(a.primitiveValue());
          } else {
            ul.li().ah(acd.getWebPath()).tx(acd.present());
          }
        }
      }
    }
    if (req.has("derivedFrom")) {
      List<ResourceElement> list = req.children("derivedFrom");
      if (list.size() == 1) {
        Requirements reqd = context.getWorker().fetchResource(Requirements.class, list.get(0).primitiveValue(), req);
        XhtmlNode p = x.para();
        p.tx(context.formatPhrase(RenderingContext.REQ_DERIVE)+" ");
        if (reqd == null) {
          p.code(list.get(0).primitiveValue());
        } else {
          p.ah(reqd.getWebPath()).tx(reqd.present());
        }
      } else {
        x.para().tx(context.formatPhrase(RenderingContext.REQ_FOLLOWING_REQ)+" ");
        XhtmlNode ul = x.ul();
        for (ResourceElement a : list) {
          Requirements reqd = context.getWorker().fetchResource(Requirements.class, a.primitiveValue(), req);
          if (reqd == null) {
            ul.li().code(a.primitiveValue());
          } else {
            ul.li().ah(reqd.getWebPath()).tx(reqd.present());
          }
        }
      }
    }
    if (req.has("reference")) {
      XhtmlNode p = x.para();
      p.tx(context.formatPhrase(RenderingContext.GENERAL_REFS)+" ");
      int i = 0;
      for (ResourceElement c : req.children("reference")) {
        i++;
        if (i>1) p.tx(", ");
        String url = c.primitiveValue();
        if (url.contains("#")) {
          url = url.substring(0, url.indexOf("#"));
        }
        p.ah(c.primitiveValue()).tx(url);
      }
    }
    XhtmlNode tbl = x.table("grid");

    for (ResourceElement stmt : req.children("statement")) {
      XhtmlNode tr = tbl.tr();
      String lbl = stmt.has("label") ? stmt.primitiveValue("label") : stmt..primitiveValue("key");
      XhtmlNode td = tr.td();
      td.b().an(stmt.primitiveValue("key"));
      td.tx(lbl);
      td = tr.td();
      boolean first = true;
      CodeSystem cs = context.getWorker().fetchCodeSystem("http://hl7.org/fhir/conformance-expectation");
      for (ResourceElement t : stmt.children("conformance")) {
        if (first) first = false; else td.tx(", ");
        if (cs != null) {
          td.ah(cs.getWebPath()+"#conformance-expectation-"+t.primitiveValue()).tx(t.primitiveValue().toUpperCase());          
        } else {
          td.tx(t.primitiveValue().toUpperCase());
        }
      }
      td = tr.td();
      addMarkdown(td, stmt.primitiveValue("requirement"));
      if (stmt.has("derivedFrom") || stmt.has("satisfiedBy") || stmt.has("reference") || stmt.has("source")) {
        td.para().tx(context.formatPhrase(RenderingContext.REQ_LINKS)+" ");
        XhtmlNode ul = td.ul();
        if (stmt.has("derivedFrom")) {
          XhtmlNode li = ul.li();
          li.tx(context.formatPhrase(RenderingContext.REQ_DERIVED)+" ");
          String url = stmt.primitiveValue("derivedFrom");
          String key = url.contains("#") ? url.substring(url.indexOf("#")+1) : "";
          if (url.contains("#")) { url = url.substring(0, url.indexOf("#")); };
          Requirements reqr = context.getWorker().fetchResource(Requirements.class, url, req);
          if (reqr != null) {
            RequirementsStatementComponent stmtr = reqr.findStatement(key);
            if (stmtr != null) {
              li.ah(reqr.getWebPath()+"#"+key).tx(reqr.present() + " # " +(stmt.has("label") ? stmt.primitiveValue("label") : stmt.primitiveValue("key")));
            } else {
              li.ah(reqr.getWebPath()+"#"+key).tx(reqr.present()+" # "+key);              
            }
          } else {
            li.code(stmt.primitiveValue("derivedFrom"));
          }
        }
        if (stmt.has("satisfiedBy")) {
          XhtmlNode li = ul.li();
          li.tx(context.formatPhrase(RenderingContext.REQ_SATISFIED)+" ");
          first = true;
          for (ResourceElement c : stmt.children("satisfiedBy")) {
            if (first) first = false; else li.tx(", ");
            String url = c.primitiveValue();
            if (url.contains("#")) {
              url = url.substring(0, url.indexOf("#"));
            }
            Resource r = context.getWorker().fetchResource(Resource.class, url, req);
            if (r != null) {
              String desc = getResourceDescription(r, null);
              li.ah(c.primitiveValue()).tx(desc);
            } else {
              li.ah(c.primitiveValue()).tx(url);
            }
          }
        }
        if (stmt.has("reference")) {
          XhtmlNode li = ul.li();
          li.tx(context.formatPhrase(RenderingContext.GENERAL_REFS)+" ");
          int i = 0;
          for (ResourceElement c : stmt.children("reference")) {
            i++;
            if (i>1) li.tx(", ");
            String url = c.primitiveValue();
            if (url.contains("#")) {
              url = url.substring(0, url.indexOf("#"));
            }
            li.ah(c.primitiveValue()).tx(url);
          }
        }
        if (stmt.has("source")) {
          XhtmlNode li = ul.li();
          li.tx(context.formatPhrase(RenderingContext.GENERAL_SRC)+" ");
          first = true;
          for (ResourceElement c : stmt.children("source")) {
            if (first) first = false; else li.tx(", ");
            if (c.has("reference")) {
              String url = c.primitiveValue("reference");
              if (url.contains("#")) {
                url = url.substring(0, url.indexOf("#"));
              }
              Resource r = context.getWorker().fetchResource(Resource.class, url, req);
              ResourceWithReference t = null;
              if (r == null && context.getResolver() != null) {
                t = context.getResolver().resolve(context, url);                
              }
              if (r != null) {
                String desc = getResourceDescription(r, c.primitiveValue("display"));
                li.ah(c.primitiveValue("reference")).tx(desc);
              } else if (t != null) {
                String desc = getResourceDescription(t, c.primitiveValue("display"));
                li.ah(t.getReference()).tx(desc);
              } else {
                li.ah(c.primitiveValue("reference")).tx(url);
              }
            } else if (c.has("display")) {
              li.tx(c.primitiveValue("display"));
            } else {
              li.tx("??");
            }
          }
        }
      }
    }
  }

  private String getResourceDescription(ResourceWithReference res, String display) throws UnsupportedEncodingException, IOException {
    if (!Utilities.noString(display)) {
      return display;
    }
    return RendererFactory.factory(res.getResource(), context).display(res.getResource());
  }

  private String getResourceDescription(Resource res, String display) throws UnsupportedEncodingException, IOException {
    if (!Utilities.noString(display)) {
      return display;
    }
    if (res instanceof CanonicalResource) {
      return ((CanonicalResource) res).present();
    }
    return RendererFactory.factory(res, context).display(res);
  }

  public void describe(XhtmlNode x, Library lib) {
    x.tx(display(lib));
  }

  public String display(Library lib) {
    return lib.present();
  }

}
