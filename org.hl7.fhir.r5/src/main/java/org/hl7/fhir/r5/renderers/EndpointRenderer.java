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
 * Endpoint, rendered along the same lines as Patient.
 *
 * Version differences handled here:
 *  - R4: connectionType is a single Coding; payloadType and payloadMimeType are on the resource
 *  - R5+: connectionType is CodeableConcept (1..*); payload (type, mimeType); description, environmentType
 *  - R6+: payload.profileCanonical/profileUri, availability
 */
public class EndpointRenderer extends ParticipantRendererBase {

  public EndpointRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper ep) throws UnsupportedEncodingException, IOException {
    StringBuilder b = new StringBuilder();
    if (ep.has("name")) {
      b.append(context.getTranslated(ep.child("name")));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.EP_NO_NAME));
    }
    List<String> types = new ArrayList<>();
    for (ResourceWrapper ct : ep.children("connectionType")) {
      types.add("Coding".equals(ct.fhirType()) ? displayCoding(ct) : conceptText(ct));
    }
    if (!types.isEmpty()) {
      b.append(" (");
      b.append(String.join(", ", types));
      b.append(")");
    }
    if (ep.has("address")) {
      b.append(": ");
      b.append(ep.primitiveValue("address"));
    }
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper ep) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(ep, x);
    makeBanner(x.para(), ep).tx(buildSummary(ep));
    x.hr();
    XhtmlNode tbl = startTable(x, ep, null, null);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.EP_STATUS), context.formatPhrase(RenderingI18nContext.EP_STATUS_HINT), ep.child("status"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_PERIOD), context.formatPhrase(RenderingI18nContext.EP_PERIOD_HINT), ep.child("period"));
    addPairedRows(status, tbl, values);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.EP_ADDRESS), context.formatPhrase(RenderingI18nContext.EP_ADDRESS_HINT), ep.children("address"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.EP_CONN_TYPE), context.formatPhrase(RenderingI18nContext.EP_CONN_TYPE_HINT), ep.children("connectionType"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_DESC), context.formatPhrase(RenderingI18nContext.EP_DESC_HINT), ep.children("description"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.EP_ENV), context.formatPhrase(RenderingI18nContext.EP_ENV_HINT), ep.children("environmentType"));
    // R4
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.EP_PAYLOAD_TYPE), context.formatPhrase(RenderingI18nContext.EP_PAYLOAD_TYPE_HINT), ep.children("payloadType"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.EP_MIME_TYPE), context.formatPhrase(RenderingI18nContext.EP_MIME_TYPE_HINT), ep.children("payloadMimeType"));
    // R5+
    for (ResourceWrapper p : ep.children("payload")) {
      addPayload(status, tbl, p);
    }
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.EP_MANAGER), context.formatPhrase(RenderingI18nContext.EP_MANAGER_HINT), ep.children("managingOrganization"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PAT_CONTACT), context.formatPhrase(RenderingI18nContext.EP_CONTACT_HINT), ep.children("contact"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.EP_HEADER), context.formatPhrase(RenderingI18nContext.EP_HEADER_HINT), ep.children("header"));
    addAvailability(status, tbl, ep, "availability", context.formatPhrase(RenderingI18nContext.ADM_AVAIL), context.formatPhrase(RenderingI18nContext.EP_AVAIL_HINT));
    addIdentifiers(status, tbl, ep);
    addExtensions(status, tbl, ep);
    finishNarrative(status, x, tbl, ep);
  }

  private void addPayload(RenderingStatus status, XhtmlNode tbl, ResourceWrapper p) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tr = tbl.tr();
    nameCell(tr, context.formatPhrase(RenderingI18nContext.EP_PAYLOAD), context.formatPhrase(RenderingI18nContext.EP_PAYLOAD_HINT));
    XhtmlNode td = tr.td();
    td.colspan("3");
    XhtmlNode ul = td.ul();
    addPayloadItems(status, ul, RenderingI18nContext.EP_PAYLOAD_TYPE, p.children("type"));
    addPayloadItems(status, ul, RenderingI18nContext.EP_MIME_TYPE, p.children("mimeType"));
    addPayloadItems(status, ul, RenderingI18nContext.EP_PROFILE, p.childrenMN("profileCanonical", "profileUri"));
  }

  private void addPayloadItems(RenderingStatus status, XhtmlNode ul, String label, List<ResourceWrapper> items) throws FHIRFormatError, DefinitionException, IOException {
    if (!items.isEmpty()) {
      XhtmlNode li = ul.li();
      li.tx(context.formatPhrase(label)+" ");
      boolean first = true;
      for (ResourceWrapper item : items) {
        if (first) first = false; else li.tx(", ");
        if ("canonical".equals(item.fhirType())) {
          renderCanonical(status, li, item);
        } else {
          renderValue(status, li, item);
        }
      }
    }
  }

}
