package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction;
import org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.ToolingExtensions;
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

  public boolean render(XhtmlNode x, CapabilityStatement conf) throws FHIRFormatError, DefinitionException, IOException {
    x.h2().addText(conf.getName());
    addMarkdown(x, conf.getDescription());
    if (conf.getRest().size() > 0) {
      CapabilityStatementRestComponent rest = conf.getRest().get(0);
      XhtmlNode t = x.table(null);
      if (rest.hasMode()) {
        addTableRow(t, "Mode", rest.getMode().toString());
      }
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
        tr.th().b().attribute("title", "GET changes for all resources of the type (history interaction on type)").tx("History");

      XhtmlNode profCell = null;
      boolean hasProf = false;
      boolean hasSupProf = false;
      for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
        tr = t.tr();
        tr.td().addText(r.getType());

        //Show profiles
        profCell = tr.td();
        hasProf = r.hasProfile();
        hasSupProf = r.hasSupportedProfile();
        if ((!hasProf) && (!hasSupProf)) {
          profCell.nbsp();
        }
        else if (hasProf) {
          profCell.ah(r.getProfile()).addText(r.getProfile());
          if (hasSupProf) {
            profCell.br();
            profCell.addText("Additional supported profiles:");
            renderSupportedProfiles(profCell, r);
          }
        }
        else {    //Case of only supported profiles
          profCell.addText("Supported profiles:");
          renderSupportedProfiles(profCell, r);
        }
        //Show capabilities
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

  private void renderSupportedProfiles(XhtmlNode profCell, CapabilityStatementRestResourceComponent r) throws IOException {
    for (CanonicalType sp: r.getSupportedProfile()) { 
      profCell.br();
      profCell.nbsp().nbsp();
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, sp.getValue());
      if (sd != null) {
        profCell.ah(sd.getWebPath()).addText(sd.present());
      } else {
        profCell.ah(sp.getValue()).addText(sp.getValue());        
      }
    }
    if (r.hasExtension(ToolingExtensions.EXT_PROFILE_MAPPING)) {
      profCell.br();
      profCell.b().tx("Profile Mapping");
      XhtmlNode tbl = profCell.table("grid");
      boolean doco = false;
      for (Extension ext : r.getExtensionsByUrl(ToolingExtensions.EXT_PROFILE_MAPPING)) {
        doco = doco || ext.hasExtension("documentation");
      }
      XhtmlNode tr = tbl.tr();
      tr.th().tx("Criteria");
      tr.th().tx("Profile");
      if (doco) {
        tr.th().tx("Criteria");
      }
      for (Extension ext : r.getExtensionsByUrl(ToolingExtensions.EXT_PROFILE_MAPPING)) {
        tr = tbl.tr();
        tr.td().code().tx(ToolingExtensions.readStringExtension(ext, "search"));
        String url = ToolingExtensions.readStringExtension(ext, "profile");
        StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, url);
        if (sd != null) {
          tr.td().code().ah(sd.getWebPath()).tx(sd.present());
        } else {
          tr.td().code().tx(url);
        }
        if (doco) {
          tr.td().code().markdown(ToolingExtensions.readStringExtension(ext, "documentation"), "documentation"); 
        }
      }      
    }
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
