package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.NamingSystem;
import org.hl7.fhir.r4b.model.NamingSystem.NamingSystemUniqueIdComponent;
import org.hl7.fhir.r4b.model.PrimitiveType;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.ValueSet;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r4b.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class NamingSystemRenderer extends ResourceRenderer {

  public NamingSystemRenderer(RenderingContext context) {
    super(context);
  }

  public NamingSystemRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (NamingSystem) dr);
  }

  public boolean render(XhtmlNode x, NamingSystem ns) throws FHIRFormatError, DefinitionException, IOException {
    x.h3().tx("Summary");
    XhtmlNode tbl = x.table("grid"); 
    row(tbl, "Defining URL", ns.getUrl());
    if (ns.hasVersion()) {
      row(tbl, "Version", ns.getVersion());
    }
    if (ns.hasName()) {
      row(tbl, "Name", gt(ns.getNameElement()));
    }
    if (ns.hasTitle()) {
      row(tbl, "Title", gt(ns.getTitleElement()));
    }
    row(tbl, "Status", ns.getStatus().toCode());
    if (ns.hasDescription()) {
      addMarkdown(row(tbl, "Definition"), ns.getDescription());
    }
    if (ns.hasPublisher()) {
      row(tbl, "Publisher", gt(ns.getPublisherElement()));
    }
    if (ns.hasExtension(ToolingExtensions.EXT_WORKGROUP)) {
      renderCommitteeLink(row(tbl, "Committee"), ns);
    }
    if (CodeSystemUtilities.hasOID(ns)) {
      row(tbl, "OID", CodeSystemUtilities.getOID(ns)).tx("("+translate("ns.summary", "for OID based terminology systems")+")");
    }
    if (ns.hasCopyright()) {
      addMarkdown(row(tbl, "Copyright"), ns.getCopyright());
    }
    boolean hasPreferred = false;
    boolean hasPeriod = false;
    boolean hasComment = false;
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      hasPreferred = hasPreferred || id.hasPreferred();
      hasPeriod = hasPeriod || id.hasPeriod();
      hasComment = hasComment || id.hasComment();
    }
    x.h3().tx("Identifiers");
    tbl = x.table("grid");
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx(translate("ns.summary", "Type"));
    tr.td().b().tx(translate("ns.summary", "Value"));
    if (hasPreferred) {
      tr.td().b().tx(translate("ns.summary", "Preferred"));
    }
    if (hasPeriod) {
      tr.td().b().tx(translate("ns.summary", "Period"));
    }
    if (hasComment) {
      tr.td().b().tx(translate("ns.summary", "Comment"));
    }
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      tr = tbl.tr();
      tr.td().tx(id.getType().getDisplay());
      tr.td().tx(id.getValue());
      if (hasPreferred) {
        tr.td().tx(id.getPreferredElement().primitiveValue());
      }
      if (hasPeriod) {
        tr.td().tx(display(id.getPeriod()));
      }
      if (hasComment) {
        tr.td().tx(id.getComment());
      }
    }    
    return false;
  }

  private XhtmlNode row(XhtmlNode tbl, String name) {
    XhtmlNode tr = tbl.tr();
    XhtmlNode td = tr.td();
    td.tx(translate("ns.summary", name));
    return tr.td();
  }
  private XhtmlNode row(XhtmlNode tbl, String name, String value) {
    XhtmlNode td = row(tbl, name);
    td.tx(value);
    return td;
  }

  public void describe(XhtmlNode x, NamingSystem ns) {
    x.tx(display(ns));
  }

  public String display(NamingSystem ns) {
    return ns.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((NamingSystem) r).present();
  }

  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    if (r.has("name")) {
      return r.children("name").get(0).getBase().primitiveValue();
    }
    return "??";
  }

}
