package org.hl7.fhir.services.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.utilities.EOperationOutcome;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * PractitionerRole, rendered along the same lines as Patient.
 *
 * Version differences handled here:
 *  - R4: telecom, availableTime, notAvailable, availabilityExceptions
 *  - R5+: contact (ExtendedContactDetail), availability (Availability), characteristic, communication
 *  - R6+: display
 */
public class PractitionerRoleRenderer extends ParticipantRendererBase {

  public PractitionerRoleRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper pr) throws UnsupportedEncodingException, IOException {
    return buildSummary(pr, 0);
  }

  @Override
  public String buildSummary(ResourceWrapper pr, int recursionCount) throws UnsupportedEncodingException, IOException {
    if (pr.has("display")) {
      return context.getTranslated(pr.child("display"));
    }
    StringBuilder b = new StringBuilder();
    if (pr.has("practitioner")) {
      b.append(referenceText(pr.child("practitioner"), recursionCount));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.PRR_NO_PRACT));
    }
    List<ResourceWrapper> codes = pr.children("code");
    if (!codes.isEmpty()) {
      b.append(": ");
      boolean first = true;
      for (ResourceWrapper code : codes) {
        if (first) first = false; else b.append(", ");
        b.append(conceptText(code));
      }
    }
    if (pr.has("organization")) {
      b.append(" ");
      b.append(context.formatPhrase(RenderingI18nContext.PRR_AT, referenceText(pr.child("organization"), recursionCount)));
    }
    ResourceWrapper id = chooseId(pr);
    if (id != null) {
      b.append(" (");
      b.append(displayIdentifier(id));
      b.append(")");
    }
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper pr) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(pr, x);
    makeBanner(x.para(), pr).tx(buildSummary(pr));
    x.hr();
    XhtmlNode tbl = startTable(x, pr, null, null);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT), pr.child("active"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_PERIOD), context.formatPhrase(RenderingI18nContext.IND_PERIOD_HINT), pr.child("period"));
    addPairedRows(status, tbl, values);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_PRACT), context.formatPhrase(RenderingI18nContext.PRR_PRACT_HINT), pr.children("practitioner"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_ORG), context.formatPhrase(RenderingI18nContext.PRR_ORG_HINT), pr.children("organization"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_CODE), context.formatPhrase(RenderingI18nContext.PRR_CODE_HINT), pr.children("code"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_SPECIALTY), context.formatPhrase(RenderingI18nContext.PRR_SPECIALTY_HINT), pr.children("specialty"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_LOCATION), context.formatPhrase(RenderingI18nContext.PRR_LOCATION_HINT), pr.children("location"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_SERVICE), context.formatPhrase(RenderingI18nContext.PRR_SERVICE_HINT), pr.children("healthcareService"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_CHAR), context.formatPhrase(RenderingI18nContext.PRR_CHAR_HINT), pr.children("characteristic"));
    addIdentifiers(status, tbl, pr);
    addComms(status, tbl, pr, context.formatPhrase(RenderingI18nContext.PRR_CONTACT_HINT)); // R4
    for (ResourceWrapper c : pr.children("contact")) { // R5+
      addContactDetail(status, tbl, c, context.formatPhrase(RenderingI18nContext.PRR_CONTACT_HINT));
    }
    addLangs(status, tbl, pr);
    addAvailability(status, tbl, pr, "availability", context.formatPhrase(RenderingI18nContext.PRR_AVAIL), context.formatPhrase(RenderingI18nContext.PRR_AVAIL_HINT));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PRR_ENDPOINT), context.formatPhrase(RenderingI18nContext.PRR_ENDPOINT_HINT), pr.children("endpoint"));
    addExtensions(status, tbl, pr);
    finishNarrative(status, x, tbl, pr);
  }

}
