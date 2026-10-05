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
 * Location, rendered along the same lines as Patient.
 *
 * Version differences handled here:
 *  - R4: telecom; physicalType; hoursOfOperation is a list of times (openingTime/closingTime); availabilityExceptions; description is a string
 *  - R5+: contact (ExtendedContactDetail); form; hoursOfOperation is Availability; characteristic, virtualService; description is markdown
 *  - R6+: code
 */
public class LocationRenderer extends ParticipantRendererBase {

  public LocationRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper loc) throws UnsupportedEncodingException, IOException {
    StringBuilder b = new StringBuilder();
    if (loc.has("name")) {
      b.append(context.getTranslated(loc.child("name")));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.LOC_NO_NAME));
    }
    appendConcepts(b, loc.children("type"));
    appendId(b, loc);
    return b.toString();
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper loc) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(loc, x);
    makeBanner(x.para(), loc).tx(buildSummary(loc));
    x.hr();
    XhtmlNode tbl = startTable(x, loc, null, null);

    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.LOC_STATUS), context.formatPhrase(RenderingI18nContext.LOC_STATUS_HINT), loc.child("status"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.LOC_OP_STATUS), context.formatPhrase(RenderingI18nContext.LOC_OP_STATUS_HINT), loc.child("operationalStatus"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.LOC_MODE), context.formatPhrase(RenderingI18nContext.LOC_MODE_HINT), loc.child("mode"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.LOC_FORM), context.formatPhrase(RenderingI18nContext.LOC_FORM_HINT), loc.childMN("form", "physicalType"));
    addPairedRows(status, tbl, values);
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_ALIAS), context.formatPhrase(RenderingI18nContext.ADM_ALIAS_HINT), loc.children("alias"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_DESC), context.formatPhrase(RenderingI18nContext.LOC_DESC_HINT), loc.children("description"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.LOC_CODE), context.formatPhrase(RenderingI18nContext.LOC_CODE_HINT), loc.children("code"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_TYPE), context.formatPhrase(RenderingI18nContext.LOC_TYPE_HINT), loc.children("type"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.LOC_ADDRESS), context.formatPhrase(RenderingI18nContext.LOC_ADDRESS_HINT), loc.children("address"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.PAT_CONTACT), context.formatPhrase(RenderingI18nContext.LOC_CONTACT_HINT), loc.children("telecom")); // R4
    addPosition(tbl, loc.child("position"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.LOC_MANAGER), context.formatPhrase(RenderingI18nContext.LOC_MANAGER_HINT), loc.children("managingOrganization"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.LOC_PART_OF), context.formatPhrase(RenderingI18nContext.LOC_PART_OF_HINT), loc.children("partOf"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.LOC_CHAR), context.formatPhrase(RenderingI18nContext.LOC_CHAR_HINT), loc.children("characteristic"));
    addIdentifiers(status, tbl, loc);
    for (ResourceWrapper c : loc.children("contact")) {
      addContactDetail(status, tbl, c, context.formatPhrase(RenderingI18nContext.LOC_CONTACT_HINT));
    }
    addAvailability(status, tbl, loc, "hoursOfOperation", context.formatPhrase(RenderingI18nContext.LOC_HOURS), context.formatPhrase(RenderingI18nContext.LOC_HOURS_HINT));
    for (ResourceWrapper vs : loc.children("virtualService")) {
      addVirtualService(status, tbl, vs);
    }
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT), context.formatPhrase(RenderingI18nContext.ADM_ENDPOINT_HINT), loc.children("endpoint"));
    addExtensions(status, tbl, loc);
    finishNarrative(status, x, tbl, loc);
  }

  private void addPosition(XhtmlNode tbl, ResourceWrapper pos) {
    if (pos == null || !pos.has("latitude") || !pos.has("longitude")) {
      return;
    }
    XhtmlNode tr = tbl.tr();
    nameCell(tr, context.formatPhrase(RenderingI18nContext.LOC_POSITION), context.formatPhrase(RenderingI18nContext.LOC_POSITION_HINT));
    XhtmlNode td = tr.td();
    td.colspan("3");
    spanIfTracking(td, pos).tx(context.formatPhrase(RenderingI18nContext.LOC_LAT_LONG, pos.primitiveValue("latitude"), pos.primitiveValue("longitude")));
    if (pos.has("altitude")) {
      td.tx(" "+context.formatPhrase(RenderingI18nContext.LOC_ALTITUDE, pos.primitiveValue("altitude")));
    }
  }

  private void addVirtualService(RenderingStatus status, XhtmlNode tbl, ResourceWrapper vs) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tr = tbl.tr();
    nameCell(tr, context.formatPhrase(RenderingI18nContext.LOC_VIRTUAL), context.formatPhrase(RenderingI18nContext.LOC_VIRTUAL_HINT));
    XhtmlNode td = tr.td();
    td.colspan("3");
    if (vs.has("channelType")) {
      renderValue(status, td, vs.child("channelType"));
    }
    if (vs.hasMN("address", "additionalInfo", "maxParticipants", "sessionKey")) {
      XhtmlNode ul = td.ul();
      ResourceWrapper address = vs.child("address");
      if (address != null) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.LOC_VS_ADDRESS)+" ");
        if ("ExtendedContactDetail".equals(address.fhirType())) {
          boolean first = true;
          for (ResourceWrapper item : address.childrenMN("name", "telecom", "address", "organization")) {
            if (first) first = false; else li.tx(", ");
            renderValue(status, li, item);
          }
        } else {
          renderValue(status, li, address);
        }
      }
      for (ResourceWrapper ai : vs.children("additionalInfo")) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.LOC_VS_INFO)+" ");
        renderValue(status, li, ai);
      }
      if (vs.has("maxParticipants")) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.LOC_VS_MAX)+" ");
        renderValue(status, li, vs.child("maxParticipants"));
      }
      if (vs.has("sessionKey")) {
        XhtmlNode li = ul.li();
        li.tx(context.formatPhrase(RenderingI18nContext.LOC_VS_KEY)+" ");
        renderValue(status, li, vs.child("sessionKey"));
      }
    }
  }

}
