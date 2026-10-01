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
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * Group, rendered along the same lines as Patient: a banner, a table of the group's properties,
 * then a table of characteristics and a table of members (the first MAX_MEMBERS of them).
 *
 * Version differences handled here:
 *  - R4: actual (boolean) instead of membership; characteristic.value[x] is CodeableConcept|boolean|Quantity|Range|Reference
 *  - R5+: membership, description
 *  - R6+: Group is a canonical resource (url, version, title, status, publisher etc. - shown in the
 *    usual summary table when that's turned on), purpose, combinationMethod/Threshold,
 *    characteristic.description/method/formula/determiner/offset/instances/duration/relativeTime, value[x] adds uri|Expression,
 *    member.involvement. There's no active in R6
 */
public class GroupRenderer extends ParticipantRendererBase {

  private static final int MAX_MEMBERS = 50;

  public GroupRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper grp) throws UnsupportedEncodingException, IOException {
    StringBuilder b = new StringBuilder();
    if (grp.has("title")) {
      b.append(context.getTranslated(grp.child("title")));
    } else if (grp.has("name")) {
      b.append(context.getTranslated(grp.child("name")));
    } else {
      b.append(context.formatPhrase(RenderingI18nContext.GROUP_NO_NAME));
    }
    List<String> details = new ArrayList<>();
    if (grp.has("type")) {
      details.add(context.getTranslatedCode(grp.primitiveValue("type"), "http://hl7.org/fhir/group-type"));
    }
    String membership = membership(grp);
    if (membership != null) {
      details.add(membership);
    }
    if (grp.has("quantity")) {
      String q = grp.primitiveValue("quantity");
      details.add(context.formatPhrasePlural(Utilities.parseInt(q, 0), RenderingI18nContext.GROUP_MEMBER_COUNT, q));
    } else if (grp.has("member")) {
      int q = grp.children("member").size();
      details.add(context.formatPhrasePlural(q, RenderingI18nContext.GROUP_MEMBER_COUNT, q));
    }
    if (!details.isEmpty()) {
      b.append(" (");
      b.append(String.join(", ", details));
      b.append(")");
    }
    ResourceWrapper id = chooseId(grp);
    if (id != null) {
      b.append(" (");
      b.append(displayIdentifier(id));
      b.append(")");
    }
    return b.toString();
  }

  /**
   * membership is a code from R5; R4 has actual (boolean) instead
   */
  private String membership(ResourceWrapper grp) {
    if (grp.has("membership")) {
      return context.getTranslatedCode(grp.primitiveValue("membership"), "http://hl7.org/fhir/group-membership-basis");
    } else if (grp.has("actual")) {
      return "true".equals(grp.primitiveValue("actual")) ? context.formatPhrase(RenderingI18nContext.GROUP_ENUMERATED) : context.formatPhrase(RenderingI18nContext.GROUP_DEFINITIONAL);
    } else {
      return null;
    }
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper grp) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(grp, x);
    makeBanner(x.para(), grp).tx(buildSummary(grp));
    x.hr();
    // from R6, Group is a canonical resource
    boolean canonical = grp.has("url") || grp.has("version") || grp.has("title") || grp.has("status");
    boolean summary = canonical && genSummaryTable(status, x, grp);

    XhtmlNode tbl = startTable(x, grp, null, null);
    // the table has 4 columns
    List<LabelledValue> values = new ArrayList<>();
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.PAT_ACTIVE), context.formatPhrase(RenderingI18nContext.PAT_ACTIVE_HINT), grp.child("active"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.GROUP_TYPE), context.formatPhrase(RenderingI18nContext.GROUP_TYPE_HINT), grp.child("type"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.GROUP_MEMBERSHIP), context.formatPhrase(RenderingI18nContext.GROUP_MEMBERSHIP_HINT), grp.child("membership"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.GROUP_QUANTITY), context.formatPhrase(RenderingI18nContext.GROUP_QUANTITY_HINT), grp.child("quantity"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.GROUP_COMB_METHOD), context.formatPhrase(RenderingI18nContext.GROUP_COMB_METHOD_HINT), grp.child("combinationMethod"));
    addLabelledValue(values, context.formatPhrase(RenderingI18nContext.GROUP_COMB_THRESHOLD), context.formatPhrase(RenderingI18nContext.GROUP_COMB_THRESHOLD_HINT), grp.child("combinationThreshold"));
    addPairedRows(status, tbl, values);
    if (grp.has("actual")) { // R4
      XhtmlNode tr = tbl.tr();
      nameCell(tr, context.formatPhrase(RenderingI18nContext.GROUP_MEMBERSHIP), context.formatPhrase(RenderingI18nContext.GROUP_MEMBERSHIP_HINT));
      XhtmlNode td = tr.td();
      td.colspan("3");
      spanIfTracking(td, grp.child("actual")).tx(membership(grp));
    }
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.GROUP_CODE), context.formatPhrase(RenderingI18nContext.GROUP_CODE_HINT), grp.children("code"));
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.GROUP_MANAGER), context.formatPhrase(RenderingI18nContext.GROUP_MANAGER_HINT), grp.children("managingEntity"));
    if (!summary) {
      // these are in the summary table if it was rendered
      addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.GROUP_DESC), context.formatPhrase(RenderingI18nContext.GROUP_DESC_HINT), grp.children("description"));
      addIdentifiers(status, tbl, grp);
    }
    addValuesRow(status, tbl, context.formatPhrase(RenderingI18nContext.GROUP_PURPOSE), context.formatPhrase(RenderingI18nContext.GROUP_PURPOSE_HINT), grp.children("purpose"));
    addExtensions(status, tbl, grp);
    if (tbl.isEmpty()) {
      x.remove(tbl);
    }
    addCharacteristics(status, x, grp.children("characteristic"));
    addMembers(status, x, grp.children("member"));
    addContainedResources(status, x, grp);
  }

  private void addCharacteristics(RenderingStatus status, XhtmlNode x, List<ResourceWrapper> list) throws FHIRFormatError, DefinitionException, IOException {
    if (list.isEmpty()) {
      return;
    }
    boolean hasExclude = false;
    boolean hasPeriod = false;
    boolean hasDetails = false;
    for (ResourceWrapper c : list) {
      hasExclude = hasExclude || "true".equals(c.primitiveValue("exclude"));
      hasPeriod = hasPeriod || c.has("period");
      hasDetails = hasDetails || c.hasMN("method", "formula", "determiner", "offset", "instances", "duration", "relativeTime");
    }
    x.para().b().tx(context.formatPhrase(RenderingI18nContext.GROUP_CHARS));
    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = tbl.tr();
    tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_CHAR));
    tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_VALUE));
    if (hasExclude) {
      tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_EXCLUDE));
    }
    if (hasPeriod) {
      tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_PERIOD));
    }
    if (hasDetails) {
      tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_DETAILS));
    }
    for (ResourceWrapper c : list) {
      tr = tbl.tr();
      XhtmlNode td = tr.td();
      if (c.has("code")) {
        renderValue(status, td, c.child("code"));
      }
      if (c.has("description")) { // R6
        if (c.has("code")) {
          td.tx(" - ");
        }
        renderDataType(status, td, c.child("description"));
      }
      td = tr.td();
      if (c.has("value")) {
        renderValue(status, td, c.child("value"));
      }
      if (hasExclude) {
        td = tr.td();
        if ("true".equals(c.primitiveValue("exclude"))) {
          spanIfTracking(td, c.child("exclude")).tx(context.formatPhrase(RenderingI18nContext.GROUP_EXCLUDED));
        }
      }
      if (hasPeriod) {
        td = tr.td();
        if (c.has("period")) {
          renderValue(status, td, c.child("period"));
        }
      }
      if (hasDetails) {
        td = tr.td();
        if (c.hasMN("method", "formula", "determiner", "offset", "instances", "duration", "relativeTime")) {
          XhtmlNode ul = td.ul();
          for (ResourceWrapper m : c.children("method")) {
            addDetail(status, ul, RenderingI18nContext.GROUP_METHOD, m);
          }
          addDetail(status, ul, RenderingI18nContext.GROUP_FORMULA, c.child("formula"));
          addDetail(status, ul, RenderingI18nContext.GROUP_DETERMINER, c.child("determiner"));
          addDetail(status, ul, RenderingI18nContext.GROUP_OFFSET, c.child("offset"));
          addDetail(status, ul, RenderingI18nContext.GROUP_INSTANCES, c.child("instances"));
          addDetail(status, ul, RenderingI18nContext.GROUP_DURATION, c.child("duration"));
          for (ResourceWrapper rt : c.children("relativeTime")) {
            addDetail(status, ul, RenderingI18nContext.GROUP_TIMING, rt);
          }
        }
      }
    }
  }

  private void addDetail(RenderingStatus status, XhtmlNode ul, String label, ResourceWrapper value) throws FHIRFormatError, DefinitionException, IOException {
    if (value != null) {
      XhtmlNode li = ul.li();
      li.tx(context.formatPhrase(label)+" ");
      renderValue(status, li, value);
    }
  }

  private void addMembers(RenderingStatus status, XhtmlNode x, List<ResourceWrapper> list) throws FHIRFormatError, DefinitionException, IOException {
    if (list.isEmpty()) {
      return;
    }
    boolean hasInvolvement = false;
    boolean hasPeriod = false;
    boolean hasInactive = false;
    for (ResourceWrapper m : list) {
      hasInvolvement = hasInvolvement || m.has("involvement");
      hasPeriod = hasPeriod || m.has("period");
      hasInactive = hasInactive || "true".equals(m.primitiveValue("inactive"));
    }
    x.para().b().tx(context.formatPhrase(RenderingI18nContext.GROUP_MEMBERS));
    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = tbl.tr();
    tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_MEMBER));
    if (hasInvolvement) {
      tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_INVOLVEMENT));
    }
    if (hasPeriod) {
      tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_PERIOD));
    }
    if (hasInactive) {
      tr.th().tx(context.formatPhrase(RenderingI18nContext.GROUP_INACTIVE));
    }
    int limit = Math.min(list.size(), MAX_MEMBERS);
    for (int i = 0; i < limit; i++) {
      ResourceWrapper m = list.get(i);
      tr = tbl.tr();
      XhtmlNode td = tr.td();
      if (m.has("entity")) {
        renderValue(status, td, m.child("entity"));
      }
      if (hasInvolvement) {
        td = tr.td();
        boolean first = true;
        for (ResourceWrapper inv : m.children("involvement")) {
          if (first) first = false; else td.tx(", ");
          renderValue(status, td, inv);
        }
      }
      if (hasPeriod) {
        td = tr.td();
        if (m.has("period")) {
          renderValue(status, td, m.child("period"));
        }
      }
      if (hasInactive) {
        td = tr.td();
        if ("true".equals(m.primitiveValue("inactive"))) {
          spanIfTracking(td, m.child("inactive")).tx(context.formatPhrase(RenderingI18nContext.GROUP_INACTIVE));
        }
      }
    }
    if (list.size() > MAX_MEMBERS) {
      x.para().i().tx(context.formatPhrase(RenderingI18nContext.GROUP_MEMBERS_MORE, MAX_MEMBERS, list.size()));
    }
  }

}
