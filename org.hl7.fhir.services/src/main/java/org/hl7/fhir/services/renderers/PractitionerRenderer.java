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
 * Practitioner, rendered along the same lines as Patient.
 *
 * Version differences handled here: communication is a CodeableConcept in R4 and a
 * backbone element (language + preferred) from R5; deceased[x] is R5+; qualification.status is R6+
 */
public class PractitionerRenderer extends ParticipantRendererBase {

  public PractitionerRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper prac) throws UnsupportedEncodingException, IOException {
    ResourceWrapper id = chooseId(prac);
    ResourceWrapper n = chooseName(prac);
    StringBuilder b = new StringBuilder();
    if (n != null) {
      b.append(displayHumanName(n).trim());
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.PRAC_NO_NAME));
    }
    if (id != null) {
      b.append(" (");
      b.append(displayIdentifier(id));
      b.append(")");
    }
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper prac) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(prac, x);
    makeBanner(x.para(), prac).tx(buildSummary(prac));
    x.hr();
    String photo = context.formatPhrase(RenderingI18nContext.IND_PHOTO);
    XhtmlNode tbl = startTable(x, prac, photo, photo);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT), prac.child("active"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_DECEASED), context.formatPhrase(RenderingI18nContext.PRAC_DECEASED_HINT), prac.child("deceased"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.IND_GENDER), context.formatPhrase(RenderingI18nContext.IND_GENDER_HINT), prac.child("gender"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.IND_DOB), context.formatPhrase(RenderingI18nContext.IND_DOB_HINT), prac.child("birthDate"));
    addPairedRows(status, tbl, values);
    addIdentifiers(status, tbl, prac);
    addNames(status, tbl, prac);
    addComms(status, tbl, prac, context.formatPhrase(RenderingI18nContext.PRAC_CONTACT_HINT));
    for (ResourceWrapper q : prac.children("qualification")) {
      addQualification(status, tbl, q);
    }
    addLangs(status, tbl, prac);
    addExtensions(status, tbl, prac);
    finishNarrative(status, x, tbl, prac);
  }

}
