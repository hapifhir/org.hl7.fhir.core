package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
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
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class RequirementsRenderer extends ResourceRenderer {

  public RequirementsRenderer(RenderingContext context) {
    super(context);
  }

  public RequirementsRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (Requirements) dr);
  }

  public boolean render(XhtmlNode x, Requirements req) throws FHIRFormatError, DefinitionException, IOException {
    if (req.hasActor()) {
      if (req.getActor().size() == 1) {
        ActorDefinition acd = context.getWorker().fetchResource(ActorDefinition.class, req.getActor().get(0).getValue(), req);
        XhtmlNode p = x.para();
        p.tx("These requirements apply to the actor ");
        if (acd == null) {
          p.code(req.getActor().get(0).getValue());
        } else {
          p.ah(acd.getWebPath()).tx(acd.present());
        }
      } else {
        x.para().tx("These requirements apply to the following actors:");
        XhtmlNode ul = x.ul();
        for (CanonicalType a : req.getActor()) {
          ActorDefinition acd = context.getWorker().fetchResource(ActorDefinition.class, a.getValue(), req);
          if (acd == null) {
            ul.li().code(a.getValue());
          } else {
            ul.li().ah(acd.getWebPath()).tx(acd.present());
          }
        }
      }
    }
    if (req.hasDerivedFrom()) {
      if (req.getDerivedFrom().size() == 1) {
        Requirements reqd = context.getWorker().fetchResource(Requirements.class, req.getDerivedFrom().get(0).getValue(), req);
        XhtmlNode p = x.para();
        p.tx("These requirements derive from ");
        if (reqd == null) {
          p.code(req.getDerivedFrom().get(0).getValue());
        } else {
          p.ah(reqd.getWebPath()).tx(reqd.present());
        }
      } else {
        x.para().tx("These requirements are derived from the following requirements:");
        XhtmlNode ul = x.ul();
        for (CanonicalType a : req.getDerivedFrom()) {
          Requirements reqd = context.getWorker().fetchResource(Requirements.class, a.getValue(), req);
          if (reqd == null) {
            ul.li().code(a.getValue());
          } else {
            ul.li().ah(reqd.getWebPath()).tx(reqd.present());
          }
        }
      }
    }
    
    XhtmlNode tbl = x.table("grid");
    
    for (RequirementsStatementComponent stmt : req.getStatement()) {
      XhtmlNode tr = tbl.tr();
      String lbl = stmt.hasLabel() ? stmt.getLabel() : stmt.getKey();
      XhtmlNode td = tr.td();
      td.b().an(stmt.getKey());
      td.tx(lbl);
      td = tr.td();
      boolean first = true;
      CodeSystem cs = context.getWorker().fetchCodeSystem("http://hl7.org/fhir/conformance-expectation");
      for (Enumeration<ConformanceExpectation> t : stmt.getConformance()) {
        if (first) first = false; else td.tx(", ");
        if (cs != null) {
          td.ah(cs.getWebPath()+"#conformance-expectation-"+t.asStringValue()).tx(t.asStringValue().toUpperCase());          
        } else {
          td.tx(t.asStringValue().toUpperCase());
        }
      }
      td = tr.td();
      addMarkdown(td, stmt.getRequirement());
      if (stmt.hasDerivedFrom() || stmt.hasSatisfiedBy() || stmt.hasReference() || stmt.hasSource()) {
        td.para().tx("Links:");
        XhtmlNode ul = td.ul();
        if (stmt.hasDerivedFrom()) {
          XhtmlNode li = ul.li();
          li.tx("Derived From: ");
          String url = stmt.getDerivedFrom();
          String key = url.contains("#") ? url.substring(url.indexOf("#")+1) : "";
          if (url.contains("#")) { url = url.substring(0, url.indexOf("#")); };
          Requirements reqr = context.getWorker().fetchResource(Requirements.class, url, req);
          if (reqr != null) {
            RequirementsStatementComponent stmtr = reqr.findStatement(key);
            if (stmtr != null) {
              li.ah(reqr.getWebPath()+"#"+key).tx(reqr.present() + " # " +(stmt.hasLabel() ? stmt.getLabel() : stmt.getKey()));
            } else {
              li.ah(reqr.getWebPath()+"#"+key).tx(reqr.present()+" # "+key);              
            }
          } else {
            li.code(stmt.getDerivedFrom());
          }
        }
        if (stmt.hasSatisfiedBy()) {
          XhtmlNode li = ul.li();
          li.tx("Satisfied By: ");
          first = true;
          for (UrlType c : stmt.getSatisfiedBy()) {
            if (first) first = false; else li.tx(", ");
            String url = c.getValue();
            if (url.contains("#")) {
              url = url.substring(0, url.indexOf("#"));
            }
            Resource r = context.getWorker().fetchResource(Resource.class, url, req);
            if (r != null) {
              String desc = getResourceDescription(r, null);
              li.ah(c.getValue()).tx(desc);
            } else {
              li.ah(c.getValue()).tx(url);
            }
          }
        }
        if (stmt.hasReference()) {
          XhtmlNode li = ul.li();
          li.tx("References: ");
          int i = 0;
          for (UrlType c : stmt.getSatisfiedBy()) {
            i++;
            if (i>1) li.tx(", ");
            String url = c.getValue();
            if (url.contains("#")) {
              url = url.substring(0, url.indexOf("#"));
            }
            li.ah(c.getValue()).tx(url);
          }
        }
        if (stmt.hasSource()) {
          XhtmlNode li = ul.li();
          li.tx("Source: ");
          first = true;
          for (Reference c : stmt.getSource()) {
            if (first) first = false; else li.tx(", ");
            if (c.hasReference()) {
              String url = c.getReference();
              if (url.contains("#")) {
                url = url.substring(0, url.indexOf("#"));
              }
              Resource r = context.getWorker().fetchResource(Resource.class, url, req);
              ResourceWithReference t = null;
              if (r == null && context.getResolver() != null) {
                t = context.getResolver().resolve(context, url);                
              }
              if (r != null) {
                String desc = getResourceDescription(r, c.getDisplay());
                li.ah(c.getReference()).tx(desc);
              } else if (t != null) {
                String desc = getResourceDescription(t, c.getDisplay());
                li.ah(t.getReference()).tx(desc);
              } else {
                li.ah(c.getReference()).tx(url);
              }
            } else if (c.hasDisplay()) {
              li.tx(c.getDisplay());
            } else {
              li.tx("??");
            }
          }
        }
      }
    }
    return false;
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
  
}
