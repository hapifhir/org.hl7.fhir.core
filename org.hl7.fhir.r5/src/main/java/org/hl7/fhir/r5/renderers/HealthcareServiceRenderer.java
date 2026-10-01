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
 * HealthcareService, rendered along the same lines as Patient.
 *
 * Version differences handled here:
 *  - R4: telecom, availableTime, notAvailable, availabilityExceptions; comment is a string
 *  - R5+: offeredIn, contact (ExtendedContactDetail), availability (Availability); comment is markdown
 *  - R6+: referralRequired, eligibility.value[x] and eligibility.period
 */
public class HealthcareServiceRenderer extends ParticipantRendererBase {

  public HealthcareServiceRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper hs) throws UnsupportedEncodingException, IOException {
    return buildSummary(hs, 0);
  }

  @Override
  public String buildSummary(ResourceWrapper hs, int recursionCount) throws UnsupportedEncodingException, IOException {
    StringBuilder b = new StringBuilder();
    if (hs.has("name")) {
      b.append(context.getTranslated(hs.child("name")));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.HS_NO_NAME));
    }
    appendConcepts(b, hs.children("type"));
    if (hs.has("providedBy")) {
      b.append(" ");
      b.append(context.formatPhrase(RenderingI18nContext.HS_BY, referenceText(hs.child("providedBy"), recursionCount)));
    }
    appendId(b, hs);
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper hs) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(hs, x);
    makeBanner(x.para(), hs).tx(buildSummary(hs));
    x.hr();
    String photo = context.formatPhrase(RenderingI18nContext.IND_PHOTO);
    XhtmlNode tbl = startTable(x, hs, photo, photo);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT), hs.child("active"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.HS_APPT), context.formatPhrase(RenderingI18nContext.HS_APPT_HINT), hs.child("appointmentRequired"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.HS_REFERRAL), context.formatPhrase(RenderingI18nContext.HS_REFERRAL_HINT), hs.child("referralRequired"));
    addPairedRows(status, tbl, values);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_PROVIDED_BY), context.formatPhrase(RenderingI18nContext.HS_PROVIDED_BY_HINT), hs.children("providedBy"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_OFFERED_IN), context.formatPhrase(RenderingI18nContext.HS_OFFERED_IN_HINT), hs.children("offeredIn"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_CATEGORY), context.formatPhrase(RenderingI18nContext.HS_CATEGORY_HINT), hs.children("category"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_TYPE), context.formatPhrase(RenderingI18nContext.HS_TYPE_HINT), hs.children("type"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_SPECIALTY), context.formatPhrase(RenderingI18nContext.ADM_SPECIALTY_HINT), hs.children("specialty"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_LOCATION), context.formatPhrase(RenderingI18nContext.ADM_LOCATION_HINT), hs.children("location"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_COVERAGE), context.formatPhrase(RenderingI18nContext.HS_COVERAGE_HINT), hs.children("coverageArea"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_COMMENT), context.formatPhrase(RenderingI18nContext.HS_COMMENT_HINT), hs.children("comment"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_EXTRA), context.formatPhrase(RenderingI18nContext.HS_EXTRA_HINT), hs.children("extraDetails"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_PROVISION), context.formatPhrase(RenderingI18nContext.HS_PROVISION_HINT), hs.children("serviceProvisionCode"));
    for (ResourceWrapper e : hs.children("eligibility")) {
      addEligibility(status, tbl, e);
    }
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_PROGRAM), context.formatPhrase(RenderingI18nContext.HS_PROGRAM_HINT), hs.children("program"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_CHAR), context.formatPhrase(RenderingI18nContext.HS_CHAR_HINT), hs.children("characteristic"));
    addLangs(status, tbl, hs);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.HS_REFERRAL_METHOD), context.formatPhrase(RenderingI18nContext.HS_REFERRAL_METHOD_HINT), hs.children("referralMethod"));
    addIdentifiers(status, tbl, hs);
    addComms(status, tbl, hs, context.formatPhrase(RenderingI18nContext.ADM_CONTACT_HINT)); // R4
    for (ResourceWrapper c : hs.children("contact")) {
      addContactDetail(status, tbl, c, context.formatPhrase(RenderingI18nContext.ADM_CONTACT_HINT));
    }
    addAvailability(status, tbl, hs, "availability", context.formatPhrase(RenderingI18nContext.ADM_AVAIL), context.formatPhrase(RenderingI18nContext.HS_AVAIL_HINT));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT), context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT_HINT), hs.children("endpoint"));
    addExtensions(status, tbl, hs);
    finishNarrative(status, x, tbl, hs);
  }

  private void addEligibility(RenderingStatus status, XhtmlNode tbl, ResourceWrapper e) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tr = tbl.tr();
    nameCell(tr, context.formatPhrase(RenderingI18nContext.HS_ELIGIBILITY), context.formatPhrase(RenderingI18nContext.HS_ELIGIBILITY_HINT));
    XhtmlNode td = tr.td();
    td.colspan("3");
    if (e.has("code")) {
      renderValue(status, td, e.child("code"));
      if (e.has("value")) { // R6
        td.tx(": ");
        renderValue(status, td, e.child("value"));
      }
    }
    if (e.has("period")) { // R6
      td.tx(" (");
      renderValue(status, td, e.child("period"));
      td.tx(")");
    }
    if (e.has("comment")) {
      renderDataType(status, td, e.child("comment"));
    }
  }

}
