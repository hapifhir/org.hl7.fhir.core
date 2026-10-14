package org.hl7.fhir.services.renderers;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.core.NamingSystem;
import org.hl7.fhir.model.core.NamingSystem.NamingSystemUniqueIdComponent;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.utilities.CodeSystemUtilities;
import org.hl7.fhir.model.utilities.EOperationOutcome;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class NamingSystemRenderer extends ResourceRenderer {


  public NamingSystemRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) { 
      renderResourceTechDetails(r, x);
      genSummaryTable(status, x, (NamingSystem) r.getBase());
      render(status, x, (NamingSystem) r.getBase());      
    } else {
      // the intention is to change this in the future
      x.para().tx("NamingSystemRenderer only renders native resources directly");
    }
  }

  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  

  public void render(RenderingStatus status, XhtmlNode x, NamingSystem ns) throws FHIRFormatError, DefinitionException, IOException {
    x.h3().tx(context.formatPhrase(RenderingI18nContext.GENERAL_SUMM));
    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    row(tbl, (context.formatPhrase(RenderingI18nContext.GENERAL_DEFINING_URL)), ns.getUrl());
    if (ns.hasVersion()) {
      row(tbl, (context.formatPhrase(RenderingI18nContext.GENERAL_VER)), ns.getVersion());
    }
    if (ns.hasName()) {
      row(tbl, (context.formatPhrase(RenderingI18nContext.GENERAL_NAME)), gt(ns.getNameElement()));
    }
    if (ns.hasTitle()) {
      row(tbl, (context.formatPhrase(RenderingI18nContext.GENERAL_TITLE)), gt(ns.getTitleElement()));
    }
    row(tbl, (context.formatPhrase(RenderingI18nContext.GENERAL_STATUS)), ns.getStatus().toCode());
    if (ns.hasDescription()) {
      addMarkdown(row(tbl, (context.formatPhrase(RenderingI18nContext.GENERAL_DEFINITION))), ns.getDescription());
    }
    if (ns.hasPublisher()) {
      row(tbl, (context.formatPhrase(RenderingI18nContext.CANON_REND_PUBLISHER)), gt(ns.getPublisherElement()));
    }
    if (ns.hasExtension(ExtensionDefinitions.EXT_WORKGROUP)) {
      renderCommitteeLink(row(tbl, "Committee"), ns);
    }
    if (CodeSystemUtilities.hasOID(ns)) {
      row(tbl, context.formatPhrase(RenderingI18nContext.GENERAL_OID)).tx(context.formatPhrase(RenderingI18nContext.CODE_SYS_FOR_OID, CodeSystemUtilities.getOID(ns)));
    }
    if (ns.hasCopyright()) {
      addMarkdown(row(tbl, (context.formatPhrase(RenderingI18nContext.GENERAL_COPYRIGHT))), ns.getCopyright());
    }
    List<NamingSystem> nsl = new ArrayList<>();
    nsl.add(ns);
    renderList(x, nsl);
  }
  
  public void renderList(XhtmlNode x, List<NamingSystem> nsl) {

    boolean hasPreferred = false;
    boolean hasPeriod = false;
    boolean hasComment = false;
    for (NamingSystem ns : nsl) {
      for (NamingSystemUniqueIdComponent id : ns.getUniqueIdList()) {
        hasPreferred = hasPreferred || id.hasPreferred();
        hasPeriod = hasPeriod || id.hasPeriod();
        hasComment = hasComment || id.hasComment();
      }
    }
    x.h3().tx(context.formatPhrase(RenderingI18nContext.NAME_SYS_IDEN));
    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx((context.formatPhrase(RenderingI18nContext.GENERAL_TYPE)));
    tr.td().b().tx((context.formatPhrase(RenderingI18nContext.GENERAL_VALUE)));
    if (hasPreferred) {
      tr.td().b().tx((context.formatPhrase(RenderingI18nContext.GENERAL_PREFERRED)));
    }
    if (hasPeriod) {
      tr.td().b().tx((context.formatPhrase(RenderingI18nContext.NAME_SYS_PER)));
    }
    if (hasComment) {
      tr.td().b().tx((context.formatPhrase(RenderingI18nContext.GENERAL_COMMENT)));
    }
    for (NamingSystem ns : nsl) {
      for (NamingSystemUniqueIdComponent id : ns.getUniqueIdList()) {
        tr = tbl.tr();
        tr.td().tx(id.getType().getDisplay());
        tr.td().tx(id.getValue());
        if (hasPreferred) {
          tr.td().tx(id.getPreferredElement().primitiveValue());
        }
        if (hasPeriod) {
          tr.td().tx(displayDataType(id.getPeriod()));
        }
        if (hasComment) {
          tr.td().tx(id.getComment());
        }
      } 
    }
  }
  

  private XhtmlNode row(XhtmlNode tbl, String name) {
    XhtmlNode tr = tbl.tr();
    XhtmlNode td = tr.td();
    td.tx((name));
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

}
