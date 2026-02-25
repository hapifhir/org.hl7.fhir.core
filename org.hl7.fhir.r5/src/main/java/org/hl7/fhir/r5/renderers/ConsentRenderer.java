package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@MarkedToMoveToAdjunctPackage
public class ConsentRenderer extends ResourceRenderer {


  public ConsentRenderer(RenderingContext context) {
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(r, x);
    boolean summ = genSummaryTable(status, x, r);
    render(status, x, r, summ);      
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }


  protected void genSummaryTableContent(RenderingStatus status, XhtmlNode tbl, ResourceWrapper cr) throws IOException {
    super.genSummaryTableContent(status, tbl, cr);
    XhtmlNode tr;
    if (cr.has("status")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_STATUS)+":");
      xlinkNarrative(tr.td(), cr.child("status")).tx(context.getTranslated(cr.child("status")));
    }

    if (cr.has("date")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.CONSENT_DATE)+":");
      renderDataType(status, xlinkNarrative(tr.td(), cr.child("date")), cr.child("date"));
    }
    if (cr.has("period")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.CONSENT_PERIOD)+":");
      renderDataType(status, xlinkNarrative(tr.td(), cr.child("period")), cr.child("period"));
    }
    if (cr.has("category")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrasePlural(cr.children("category").size(), RenderingContext.CONSENT_CATEGORY)+":");
      XhtmlNode td = xlinkNarrative(tr.td(), cr.child("category"));
      for (ResourceWrapper r : cr.children("category")) {
        td.sep(", ");
        renderDataType(status, td, r);
      }
    }
    if (cr.has("scope")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrasePlural(cr.children("scope").size(), RenderingContext.CONSENT_SCOPE)+":");
      XhtmlNode td = xlinkNarrative(tr.td(), cr.child("scope"));
      for (ResourceWrapper r : cr.children("scope")) {
        td.sep(", ");
        renderDataType(status, td, r);
      }
    }
  }

  public void renderParticipants(RenderingStatus status, XhtmlNode tbl, ResourceWrapper consent, String role, String desc, String... names) throws FHIRFormatError, DefinitionException, IOException {
    for (String name : names) {
      for (ResourceWrapper r : consent.children(name)) {
        XhtmlNode tr = tbl.tr();
        XhtmlNode td = tr.td();
        td.attributeNN("title", context.formatPhrase(desc));
        td.tx(context.formatPhrase(role));
        renderReference(status, tr.td(), r);
      }
    }
  }

  public void render(RenderingStatus status, XhtmlNode x, ResourceWrapper consent, boolean summ) throws FHIRFormatError, DefinitionException, IOException {
    x.h2().tx("Participants");
    XhtmlNode tbl = x.table("grid", false);
    XhtmlNode trHeader = tbl.tr();
    trHeader.td().b().tx(context.formatPhrase(RenderingContext.CONSENT_PART_TBL_ROLE));
    trHeader.td().b().tx(context.formatPhrase(RenderingContext.CONSENT_PART_TBL_DETAILS));
    renderParticipants(status, tbl, consent, RenderingContext.CONSENT_PART_TBL_PATIENT, RenderingContext.CONSENT_PART_TBL_PATIENT_DESC, "patient", "subject");
    renderParticipants(status, tbl, consent, RenderingContext.CONSENT_PART_TBL_PARTY, RenderingContext.CONSENT_PART_TBL_PARTY_DESC, "performer", "consentingParty");
    renderParticipants(status, tbl, consent, RenderingContext.CONSENT_PART_TBL_GRANTOR, RenderingContext.CONSENT_PART_TBL_GRANTOR_DESC, "grantor");
    renderParticipants(status, tbl, consent, RenderingContext.CONSENT_PART_TBL_GRANTEE, RenderingContext.CONSENT_PART_TBL_GRANTEE_DESC, "grantee");
    renderParticipants(status, tbl, consent, RenderingContext.CONSENT_PART_TBL_MANAGER, RenderingContext.CONSENT_PART_TBL_MANAGER_DESC, "manager", "organization");
    renderParticipants(status, tbl, consent, RenderingContext.CONSENT_PART_TBL_CONTROLLER, RenderingContext.CONSENT_PART_TBL_CONTROLLER_DESC, "controller");

//    if (consent.has("verification")) {
//      tbl = x.table("grid", false);
//      trHeader = tbl.tr();
//      trHeader.td().b().tx(context.formatPhrase(RenderingContext.CONSENT_VERF_TBL_STATUS));
//      trHeader.td().b().tx(context.formatPhrase(RenderingContext.CONSENT_VERF_TBL_DETAILS));
//      renderParticipants(status, x, consent, RenderingContext.CONSENT_PART_TBL_PATIENT, "patient", "subject");
//      renderParticipants(status, x, consent, RenderingContext.CONSENT_PART_TBL_PARTY, "performer", "consentingParty");
//      renderParticipants(status, x, consent, RenderingContext.CONSENT_PART_TBL_GRANTOR, "grantor");
//      renderParticipants(status, x, consent, RenderingContext.CONSENT_PART_TBL_GRANTEE, "grantee");
//      renderParticipants(status, x, consent, RenderingContext.CONSENT_PART_TBL_MANAGER, "manager", "organization");
//      renderParticipants(status, x, consent, RenderingContext.CONSENT_PART_TBL_CONTROLLER, "controller");
//    }

    if (consent.hasMN("regulatoryBasis", "policyRule", "policy", "authority", "uri")) {
      XhtmlNode p = x.para();
      if (consent.hasMN("regulatoryBasis", "policyRule")) {
        p.tx(context.formatPhrasePlural(consent.childrenMN("regulatoryBasis", "policyRule").size(), RenderingContext.CONSENT_BASIS_REGULATION_PREFIX));
        boolean first = true;
        for (ResourceWrapper r : consent.childrenMN("regulatoryBasis", "policyRule")) {
          first = p.sepFirst(first, ",");
          p.tx(" ");
          if (VersionUtilities.isR4Plus(context.getContext().getVersion())) {
            renderCodeableConcept(status, p, r);
          } else {
            p.ah(r.primitiveValue()).tx(r.primitiveValue());
          }
        }
        if (consent.hasMN("policy", "policyBasis")) {
          p.txWithWhitespace(context.formatPhrase(RenderingContext.CONSENT_BASIS_REGULATION_SUFFIX_MORE));
        } else {
          p.txWithWhitespace(context.formatPhrase(RenderingContext.CONSENT_BASIS_REGULATION_SUFFIX));
        }
      } else {
        p.tx(context.formatPhrase(RenderingContext.CONSENT_BASIS_REGULATION_NONE));
      }
      if (consent.hasMN("policy", "policyBasis")) {
        p.txWithWhitespace(context.formatPhrasePlural(consent.childrenMN("policy", "policyBasis").size(), RenderingContext.CONSENT_BASIS_POLICY_PREFIX));
        boolean first = true;
        for (ResourceWrapper r : consent.childrenMN("policy", "policyBasis")) {
          if (r.hasMN("url", "uri")) {
            first = p.sepFirst(first, ",");
            p.tx(" ");
            String url = r.primitiveValueMN("uri", "url");
            p.ah(url).tx(url);
          }
        }
        p.txWithWhitespace(context.formatPhrase(RenderingContext.CONSENT_BASIS_POLICY_SUFFIX));
      }
    }

    boolean permit = determineBasePermit(consent);
    if (consent.hasMN("provision", "except")) {
      boolean hasWhen = checkTreeForWhen(consent);
      boolean hasWho = scanForWho(consent);
      boolean hasWhat = scanForWhat(consent);
      boolean hasRules = scanForRules(consent);
      HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, context.getDestDir(), context.isInlineGraphics(), true, "");
      HierarchicalTableGenerator.TableModel model = gen.new TableModel("consenttree=" + consent.getId(), context.getRules() == RenderingContext.GenerationRules.IG_PUBLISHER);
      model.setAlternating(true);
      if (context.getRules() == RenderingContext.GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) {
        model.setDocoImg(HierarchicalTableGenerator.help16AsData());
      } else {
        model.setDocoImg(Utilities.pathURL(context.getLink(RenderingContext.KnownLinkType.SPEC, true), "help16.png"));
      }
      model.setDocoRef(context.getLink(RenderingContext.KnownLinkType.SPEC, true) + "formats.html#table");
      model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_RULE)), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_RULE_DESC)), null, 0));
      if (hasWhen) {
        model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_WHEN)), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_WHEN_DESC)), null, 0));
      }
      if (hasWho) {
        model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_WHO)), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_WHO_DESC)), null, 0));
      }
      if (hasWhat) {
        model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_WHAT)), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_WHAT_DESC)), null, 0));
      }
      if (hasRules) {
        model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_RULES)), (context.formatPhrase(RenderingContext.CONSENT_HTABLE_RULES_DESC)), null, 0));
      }

      // first we add a root for the consent itself
      HierarchicalTableGenerator.Row row = addConsentRoot(gen, model.getRows(), consent, permit, hasWhen, hasWho, hasWhat, hasRules);
      for (ResourceWrapper i : consent.childrenMN("provision", "except")) {
        renderConsentProvision(status, gen, row.getSubRows(), consent, i, permit, hasWhen, hasWho, hasWhat, hasRules);
      }
      XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null);
      x.addChildNode(xn);
    } else {
      x.para().tx(context.formatPhrase(permit ? RenderingContext.CONSENT_PERMIT_DESC :  RenderingContext.CONSENT_DENY_DESC));
    }
  }

  private boolean determineBasePermit(ResourceWrapper consent) {
    if (VersionUtilities.isR5Plus(context.getContext().getVersion())) {
      return "permit".equals(consent.primitiveValue("decision"));
    } else if (VersionUtilities.isR4Plus(context.getContext().getVersion())) {
      return true;
    } else {
      return true;
    }
  }

  private boolean determineItemPermit(ResourceWrapper consent, ResourceWrapper item, boolean parentPermit) {
    if (VersionUtilities.isR5Plus(context.getContext().getVersion())) {
      return !parentPermit;
    } else {
      return "permit".equals(item.primitiveValue("type"));
    }
  }

  private HierarchicalTableGenerator.Row addConsentRoot(HierarchicalTableGenerator gen, List<HierarchicalTableGenerator.Row> rows, ResourceWrapper consent, boolean permit, boolean hasWhen, boolean hasWho, boolean hasWhat, boolean hasRules) throws IOException {
    HierarchicalTableGenerator.Row r = gen.new Row();
    rows.add(r);
    r.setIcon(permit ? "icon_extension.png" : "icon-qi-hidden.png", context.formatPhrase(RenderingContext.CONSENT_PROVISION));
    r.getCells().add(gen.new Cell(null, null, context.formatPhrase(permit ? RenderingContext.CONSENT_PERMIT :  RenderingContext.CONSENT_DENY), null, null));
    if (hasWhen) {
      r.getCells().add(gen.new Cell(null, null, "", null, null));
    }
    if (hasWho) {
      r.getCells().add(gen.new Cell(null, null, "", null, null));
    }
    if (hasWhat) {
      r.getCells().add(gen.new Cell(null, null, "", null, null));
    }
    if (hasRules) {
      r.getCells().add(gen.new Cell(null, null, "", null, null));
    }
    return r;
  }

  private void renderConsentProvision(RenderingStatus status, HierarchicalTableGenerator gen, List<HierarchicalTableGenerator.Row> subRows, ResourceWrapper consent, ResourceWrapper i, boolean permit, boolean hasWhen, boolean hasWho, boolean hasWhat, boolean hasRules) throws IOException {
    HierarchicalTableGenerator.Row r = gen.new Row();
    subRows.add(r);
    boolean itemPermit = determineItemPermit(consent, i , permit);
    r.setIcon(itemPermit ? "icon_extension.png" : "icon-qi-hidden.png", context.formatPhrase(RenderingContext.CONSENT_PROVISION));
    r.getCells().add(gen.new Cell(null, null, context.formatPhrase(itemPermit ? RenderingContext.CONSENT_PERMIT :  RenderingContext.CONSENT_DENY), null, null));
    if (hasWhen) {
      HierarchicalTableGenerator.Cell c = gen.new Cell(null, null,  "", null, null);
      r.getCells().add(c);
      if (checkNodeForWhen(i)) {
        XhtmlNode ul = c.xhtmlRoot().ul();
        if (i.has("period")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_PERIOD, i.child("period"));
        }
        if (i.has("dataPeriod")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_DATA_PERIOD, i.child("dataPeriod"));
        }
      }
    }
    if (hasWho) {
      HierarchicalTableGenerator.Cell c = gen.new Cell(null, null, "", null, null);
      r.getCells().add(c);
      if (checkForWho(i)) {
        XhtmlNode ul = c.xhtmlRoot().ul();
        for (ResourceWrapper actor : i.children("actor")) {
          renderActor(status, ul.li(), actor.child("role"), actor.child("reference"));
        }
      }
    }
    if (hasWhat) {
      HierarchicalTableGenerator.Cell c = gen.new Cell(null, null, "", null, null);
      r.getCells().add(c);
      if (checkForWhat(i)) {
        XhtmlNode ul = c.xhtmlRoot().ul();
        for (ResourceWrapper v : i.children("action")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_ACTION, v);
        }
        for (ResourceWrapper v : i.children("securityLabel")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_SEC_LABEL, v);
        }
        for (ResourceWrapper v : i.children("purpose")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_PURPOSE, v);
        }
        for (ResourceWrapper v : i.children("class")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_CLASS, v);
        }
        for (ResourceWrapper v : i.children("resourceType")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_RESOURCE_TYPE, v);
        }
        for (ResourceWrapper v : i.children("documentType")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_DOC_TYPE, v);
        }
        for (ResourceWrapper v : i.children("code")) {
          renderDataItem(status, ul.li(), RenderingContext.CONSENT_HT_CODE, v);
        }

      }
    }
    if (hasRules) {
      HierarchicalTableGenerator.Cell c = gen.new Cell(null, null, "", null, null);
      r.getCells().add(c);
      if (checkForRules(i)) {
        XhtmlNode ul = c.xhtmlRoot().ul();
        for (ResourceWrapper ext : i.children("extension")) {
          renderDataItem(status, ul.li(), chooseNameForExtension(ext.primitiveValue("url")), ext.child("value"));
        }
      }
    }
    for (ResourceWrapper item : i.childrenMN("provision", "except")) {
      renderConsentProvision(status, gen, r.getSubRows(), consent, item, itemPermit, hasWhen, hasWho, hasWhat, hasRules);
    }
  }

  private String chooseNameForExtension(String url) {
    StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, url);
    if (sd == null) {
      return Utilities.urlTail(url);
    } else {
      return sd.present();
    }
  }

  private void renderActor(RenderingStatus status, XhtmlNode x, ResourceWrapper role, ResourceWrapper reference) throws IOException {
    if (role != null) {
      renderDataType(status, x, role);
    } else {
      x.tx(context.formatPhrase(RenderingContext.CSTABLE_HEAD_ACTOR));
    }
    x.tx(": ");
    if (reference != null) {
      renderDataType(status, x, reference);
    } else {
      x.tx(context.formatPhrase(RenderingContext._NA));
    }
  }

  private void renderDataItem(RenderingStatus status, XhtmlNode x, String name, ResourceWrapper data) throws IOException {
    x.tx(context.formatPhrase(name));
    x.tx(": ");
    renderDataType(status, x, data);
  };

  private boolean checkTreeForWhen(ResourceWrapper node) {
    if (checkNodeForWhen(node)) {
      return true;
    }
    for (ResourceWrapper item : node.childrenMN("provision", "except")) {
      if (checkTreeForWhen(item)) {
        return true;
      }
    }
    return false;
  }

  private static boolean checkNodeForWhen(ResourceWrapper node) {
    return node.hasMN("period", "dataPeriod");
  }

  private boolean scanForWho(ResourceWrapper node) {
    if (checkForWho(node)) {
      return true;
    }
    for (ResourceWrapper item : node.childrenMN("provision", "except")) {
      if (scanForWho(item)) {
        return true;
      }
    }
    return false;
  }

  private static boolean checkForWho(ResourceWrapper node) {
    return node.hasMN("actor");
  }

  private boolean scanForWhat(ResourceWrapper node) {
    if (checkForWhat(node)) {
      return true;
    }
    for (ResourceWrapper item : node.childrenMN("provision", "except")) {
      if (scanForWhat(item)) {
        return true;
      }
    }
    return false;
  }

  private static boolean checkForWhat(ResourceWrapper node) {
    return node.hasMN("action", "securityLabel", "purpose", "documentType", "resourceType", "class", "code", "data");
  }


  private boolean scanForRules(ResourceWrapper node) {
    if (checkForRules(node)) {
      return true;
    }
    for (ResourceWrapper item : node.childrenMN("provision", "except")) {
      if (scanForRules(item)) {
        return true;
      }
    }
    return false;
  }

  private static boolean checkForRules(ResourceWrapper node) {
    return node.hasMN("extension", "expression");
  }

  public void describe(XhtmlNode x, Library lib) {
    x.tx(display(lib));
  }

  public String display(Library lib) {
    return lib.present();
  }
  
}
