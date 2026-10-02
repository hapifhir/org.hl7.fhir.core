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
 * RelatedPerson, rendered along the same lines as Patient.
 *
 * Version differences handled here: role is R6+
 */
public class RelatedPersonRenderer extends ParticipantRendererBase {

  public RelatedPersonRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper rp) throws UnsupportedEncodingException, IOException {
    ResourceWrapper id = chooseId(rp);
    ResourceWrapper n = chooseName(rp);
    StringBuilder b = new StringBuilder();
    if (n != null) {
      b.append(displayHumanName(n).trim());
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.RP_NO_NAME));
    }
    List<ResourceWrapper> rels = rp.children("relationship");
    if (!rels.isEmpty()) {
      b.append(" - ");
      boolean first = true;
      for (ResourceWrapper rel : rels) {
        if (first) first = false; else b.append(", ");
        b.append(conceptText(rel));
      }
    }
    if (id != null) {
      b.append(" (");
      b.append(displayIdentifier(id));
      b.append(")");
    }
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper rp) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(rp, x);
    makeBanner(x.para(), rp).tx(buildSummary(rp));
    x.hr();
    String photo = context.formatPhrase(RenderingI18nContext.IND_PHOTO);
    XhtmlNode tbl = startTable(x, rp, photo, photo);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT), rp.child("active"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_PERIOD), context.formatPhrase(RenderingI18nContext.IND_PERIOD_HINT), rp.child("period"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.IND_GENDER), context.formatPhrase(RenderingI18nContext.IND_GENDER_HINT), rp.child("gender"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.IND_DOB), context.formatPhrase(RenderingI18nContext.IND_DOB_HINT), rp.child("birthDate"));
    addPairedRows(status, tbl, values);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.RP_PATIENT), context.formatPhrase(RenderingI18nContext.RP_PATIENT_HINT), rp.children("patient"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.RP_RELN), context.formatPhrase(RenderingI18nContext.RP_RELN_HINT), rp.children("relationship"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.RP_ROLE), context.formatPhrase(RenderingI18nContext.RP_ROLE_HINT), rp.children("role"));
    addIdentifiers(status, tbl, rp);
    addNames(status, tbl, rp);
    addComms(status, tbl, rp, context.formatPhrase(RenderingI18nContext.RP_CONTACT_HINT));
    addLangs(status, tbl, rp);
    addExtensions(status, tbl, rp);
    finishNarrative(status, x, tbl, rp);
  }

}
