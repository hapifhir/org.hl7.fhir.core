package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * Organization, rendered along the same lines as Patient.
 *
 * Version differences handled here:
 *  - R4: telecom and address on the organization; contact has purpose, name, telecom, address
 *  - R5+: description, contact is ExtendedContactDetail, qualification
 *  - R6+: qualification.status
 */
public class OrganizationRenderer extends ParticipantRendererBase {

  public OrganizationRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper org) throws UnsupportedEncodingException, IOException {
    StringBuilder b = new StringBuilder();
    if (org.has("name")) {
      b.append(context.getTranslated(org.child("name")));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.ORG_NO_NAME));
    }
    appendConcepts(b, org.children("type"));
    appendId(b, org);
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper org) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(org, x);
    makeBanner(x.para(), org).tx(buildSummary(org));
    x.hr();
    XhtmlNode tbl = startTable(x, org, null, null);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT), org.child("active"));
    addPairedRows(status, tbl, values);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_TYPE), context.formatPhrase(RenderingI18nContext.ORG_TYPE_HINT), org.children("type"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_ALIAS), context.formatPhrase(RenderingI18nContext.ADM_ALIAS_HINT), org.children("alias"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_DESC), context.formatPhrase(RenderingI18nContext.ORG_DESC_HINT), org.children("description"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ORG_PART_OF), context.formatPhrase(RenderingI18nContext.ORG_PART_OF_HINT), org.children("partOf"));
    addIdentifiers(status, tbl, org);
    addComms(status, tbl, org, context.formatPhrase(RenderingI18nContext.ORG_CONTACT_HINT)); // R4
    for (ResourceWrapper c : org.children("contact")) {
      addContactDetail(status, tbl, c, context.formatPhrase(RenderingI18nContext.ORG_CONTACT_HINT));
    }
    for (ResourceWrapper q : org.children("qualification")) {
      addQualification(status, tbl, q);
    }
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT), context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT_HINT), org.children("endpoint"));
    addExtensions(status, tbl, org);
    finishNarrative(status, x, tbl, org);
  }

}
