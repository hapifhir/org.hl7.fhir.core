package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.CapabilityStatement;
import org.hl7.fhir.r4b.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r4b.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r4b.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r4b.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r4b.model.CapabilityStatement.SystemRestfulInteraction;
import org.hl7.fhir.r4b.model.CapabilityStatement.TypeRestfulInteraction;
import org.hl7.fhir.r4b.model.CanonicalType;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class CapabilityStatementRenderer extends ResourceRenderer {

  public CapabilityStatementRenderer(RenderingContext context) {
    super(context);
  }

  public CapabilityStatementRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (CapabilityStatement) dr);
  }

  public boolean render(XhtmlNode x, CapabilityStatement conf)
      throws FHIRFormatError, DefinitionException, IOException {
    x.h2().addText(conf.getName());
    addMarkdown(x, conf.getDescription());
    if (conf.getRest().size() > 0) {
      CapabilityStatementRestComponent rest = conf.getRest().get(0);
      XhtmlNode t = x.table(null);
      addTableRow(t, "Mode", rest.getMode().toString());
      addMarkdown(addTableRow(t, "Description"), rest.getDocumentation());

      addTableRow(t, "Transaction", showOp(rest, SystemRestfulInteraction.TRANSACTION));
      addTableRow(t, "System History", showOp(rest, SystemRestfulInteraction.HISTORYSYSTEM));
      addTableRow(t, "System Search", showOp(rest, SystemRestfulInteraction.SEARCHSYSTEM));

      boolean hasVRead = false;
      boolean hasPatch = false;
      boolean hasDelete = false;
      boolean hasHistory = false;
      boolean hasUpdates = false;
      for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
        hasVRead = hasVRead || hasOp(r, TypeRestfulInteraction.VREAD);
        hasPatch = hasPatch || hasOp(r, TypeRestfulInteraction.PATCH);
        hasDelete = hasDelete || hasOp(r, TypeRestfulInteraction.DELETE);
        hasHistory = hasHistory || hasOp(r, TypeRestfulInteraction.HISTORYTYPE);
        hasUpdates = hasUpdates || hasOp(r, TypeRestfulInteraction.HISTORYINSTANCE);
      }

      t = x.table(null);
      XhtmlNode tr = t.tr();
      tr.th().b().tx("Resource Type");
      tr.th().b().tx("Profile");
      tr.th().b().attribute("title", "GET a resource (read interaction)").tx("Read");
      if (hasVRead)
        tr.th().b().attribute("title", "GET past versions of resources (vread interaction)").tx("V-Read");
      tr.th().b().attribute("title", "GET all set of resources of the type (search interaction)").tx("Search");
      tr.th().b().attribute("title", "PUT a new resource version (update interaction)").tx("Update");
      if (hasPatch)
        tr.th().b().attribute("title", "PATCH a new resource version (patch interaction)").tx("Patch");
      tr.th().b().attribute("title", "POST a new resource (create interaction)").tx("Create");
      if (hasDelete)
        tr.th().b().attribute("title", "DELETE a resource (delete interaction)").tx("Delete");
      if (hasUpdates)
        tr.th().b().attribute("title", "GET changes to a resource (history interaction on instance)").tx("Updates");
      if (hasHistory)
        tr.th().b().attribute("title", "GET changes for all resources of the type (history interaction on type)")
            .tx("History");

      XhtmlNode profCell = null;
      boolean hasProf = false;
      boolean hasSupProf = false;
      for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
        tr = t.tr();
        tr.td().addText(r.getType());

        // Show profiles
        profCell = tr.td();
        hasProf = r.hasProfile();
        hasSupProf = r.hasSupportedProfile();
        if ((!hasProf) && (!hasSupProf)) {
          profCell.nbsp();
        } else if (hasProf) {
          profCell.ah(r.getProfile()).addText(r.getProfile());
          if (hasSupProf) {
            profCell.br();
            profCell.addText("Additional supported profiles:");
            for (CanonicalType sp : r.getSupportedProfile()) {
              profCell.br();
              profCell.nbsp().nbsp();
              profCell.ah(sp.getValue()).addText(sp.getValue());
            }
          }
        } else { // Case of only supported profiles
          profCell.addText("Supported profiles:");
          for (CanonicalType sp : r.getSupportedProfile()) {
            profCell.br();
            profCell.nbsp().nbsp();
            profCell.ah(sp.getValue()).addText(sp.getValue());
          }
        }
        // Show capabilities
        tr.td().addText(showOp(r, TypeRestfulInteraction.READ));
        if (hasVRead)
          tr.td().addText(showOp(r, TypeRestfulInteraction.VREAD));
        tr.td().addText(showOp(r, TypeRestfulInteraction.SEARCHTYPE));
        tr.td().addText(showOp(r, TypeRestfulInteraction.UPDATE));
        if (hasPatch)
          tr.td().addText(showOp(r, TypeRestfulInteraction.PATCH));
        tr.td().addText(showOp(r, TypeRestfulInteraction.CREATE));
        if (hasDelete)
          tr.td().addText(showOp(r, TypeRestfulInteraction.DELETE));
        if (hasUpdates)
          tr.td().addText(showOp(r, TypeRestfulInteraction.HISTORYINSTANCE));
        if (hasHistory)
          tr.td().addText(showOp(r, TypeRestfulInteraction.HISTORYTYPE));
      }
    }

    return true;
  }

  public void describe(XhtmlNode x, CapabilityStatement cs) {
    x.tx(display(cs));
  }

  public String display(CapabilityStatement cs) {
    return cs.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((CapabilityStatement) r).present();
  }

  private boolean hasOp(CapabilityStatementRestResourceComponent r, TypeRestfulInteraction on) {
    for (ResourceInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return true;
    }
    return false;
  }

  private String showOp(CapabilityStatementRestResourceComponent r, TypeRestfulInteraction on) {
    for (ResourceInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return "y";
    }
    return "";
  }

  private String showOp(CapabilityStatementRestComponent r, SystemRestfulInteraction on) {
    for (SystemInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return "y";
    }
    return "";
  }

  private XhtmlNode addTableRow(XhtmlNode t, String name) {
    XhtmlNode tr = t.tr();
    tr.td().addText(name);
    return tr.td();
  }

  private void addTableRow(XhtmlNode t, String name, String value) {
    XhtmlNode tr = t.tr();
    tr.td().addText(name);
    tr.td().addText(value);
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
