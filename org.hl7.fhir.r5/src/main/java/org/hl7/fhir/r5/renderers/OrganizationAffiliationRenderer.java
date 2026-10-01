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
 * OrganizationAffiliation, rendered along the same lines as Patient.
 *
 * Version differences handled here:
 *  - R4: telecom
 *  - R5+: contact (ExtendedContactDetail)
 *  - network is R4 and R5 only
 */
public class OrganizationAffiliationRenderer extends ParticipantRendererBase {

  public OrganizationAffiliationRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper oa) throws UnsupportedEncodingException, IOException {
    StringBuilder b = new StringBuilder();
    if (oa.has("participatingOrganization")) {
      b.append(referenceText(oa.child("participatingOrganization")));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.OA_NO_ORG));
    }
    List<ResourceWrapper> codes = oa.children("code");
    if (!codes.isEmpty()) {
      b.append(": ");
      boolean first = true;
      for (ResourceWrapper code : codes) {
        if (first) first = false; else b.append(", ");
        b.append(conceptText(code));
      }
    }
    if (oa.has("organization")) {
      b.append(" ");
      b.append(context.formatPhrase(RenderingI18nContext.OA_FOR, referenceText(oa.child("organization"))));
    }
    appendId(b, oa);
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper oa) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(oa, x);
    makeBanner(x.para(), oa).tx(buildSummary(oa));
    x.hr();
    XhtmlNode tbl = startTable(x, oa, null, null);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT), oa.child("active"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_PERIOD), context.formatPhrase(RenderingI18nContext.IND_PERIOD_HINT), oa.child("period"));
    addPairedRows(status, tbl, values);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.OA_ORG), context.formatPhrase(RenderingI18nContext.OA_ORG_HINT), oa.children("organization"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.OA_PARTICIPANT), context.formatPhrase(RenderingI18nContext.OA_PARTICIPANT_HINT), oa.children("participatingOrganization"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.OA_NETWORK), context.formatPhrase(RenderingI18nContext.OA_NETWORK_HINT), oa.children("network"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.OA_CODE), context.formatPhrase(RenderingI18nContext.OA_CODE_HINT), oa.children("code"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_SPECIALTY), context.formatPhrase(RenderingI18nContext.ADM_SPECIALTY_HINT), oa.children("specialty"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_LOCATION), context.formatPhrase(RenderingI18nContext.ADM_LOCATION_HINT), oa.children("location"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_SERVICE), context.formatPhrase(RenderingI18nContext.ADM_SERVICE_HINT), oa.children("healthcareService"));
    addIdentifiers(status, tbl, oa);
    addComms(status, tbl, oa, context.formatPhrase(RenderingI18nContext.ADM_CONTACT_HINT)); // R4
    for (ResourceWrapper c : oa.children("contact")) {
      addContactDetail(status, tbl, c, context.formatPhrase(RenderingI18nContext.ADM_CONTACT_HINT));
    }
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT), context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT_HINT), oa.children("endpoint"));
    addExtensions(status, tbl, oa);
    finishNarrative(status, x, tbl, oa);
  }

}
