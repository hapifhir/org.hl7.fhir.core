package org.hl7.fhir.validation.instance.type;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Measure;
import org.hl7.fhir.r5.model.Measure.MeasureGroupComponent;
import org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent;
import org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.DataRenderer;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidatorHostContext;
import org.w3c.dom.Document;

public class MeasureValidator extends BaseValidator {

  private InstanceValidator parent;
  public MeasureValidator(IWorkerContext context, boolean debug, TimeTracker timeTracker, XVerExtensionManager xverManager, Coding jurisdiction, InstanceValidator parent) {
    super(context, xverManager, debug);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
    this.jurisdiction = jurisdiction;
    this.parent = parent;

  }

  public boolean validateMeasure(ValidatorHostContext hostContext, List<ValidationMessage> errors, Element element, NodeStack stack) throws FHIRException {
    boolean ok = true;
    MeasureContext mctxt = new MeasureContext();
    List<Element> libs = element.getChildrenByName("library");
    for (Element lib : libs) {
      String ref = lib.isPrimitive() ? lib.primitiveValue() : lib.getChildValue("reference");
      if (!Utilities.noString(ref)) {
        Library l = context.fetchResource(Library.class, ref);
        if (hint(errors, NO_RULE_DATE, IssueType.NOTFOUND, lib.line(), lib.col(), stack.getLiteralPath(), l != null, I18nConstants.MEASURE_M_LIB_UNKNOWN, ref)) {
          mctxt.seeLibrary(l);
        }
      }
    }

    List<Element> groups = element.getChildrenByName("group");
    if (warning(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), groups.size() > 0, I18nConstants.MEASURE_M_NO_GROUPS)) {      
      int c = 0;
      for (Element group : groups) {
        NodeStack ns = stack.push(group, c, null, null);
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, group.line(), group.col(), ns.getLiteralPath(), groups.size() ==1 || group.hasChild("code"), I18nConstants.MEASURE_M_GROUP_CODE);
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, group.line(), group.col(), ns.getLiteralPath(), group.hasChildren("population"), I18nConstants.MEASURE_M_GROUP_POP);
        int c1 = 0;
        List<Element> pl = group.getChildrenByName("population");
        for (Element p : pl) {
          NodeStack ns2 = ns.push(p, c1, null, null);
          warning(errors, NO_RULE_DATE, IssueType.REQUIRED, p.line(), p.col(), ns2.getLiteralPath(), pl.size() == 1 || p.hasChild("code"), I18nConstants.MEASURE_M_GROUP_POP_NO_CODE);
          c1++;
        }
        c1 = 0;
        List<Element> stl = group.getChildrenByName("stratifier");
        for (Element st : stl) {
          NodeStack ns2 = ns.push(st, c1, null, null);
          warning(errors, NO_RULE_DATE, IssueType.REQUIRED, st.line(), st.col(), ns2.getLiteralPath(), stl.size() == 1 || st.hasChild("code"), I18nConstants.MEASURE_M_GROUP_STRATA_NO_CODE);
          if (st.hasChild("criteria")) {
            Element crit = st.getNamedChild("criteria");
            NodeStack nsc = ns2.push(crit, -1, null, null);
            ok = validateMeasureCriteria(hostContext, errors, mctxt, crit, nsc) && ok;
          }
          int c2 = 0;
          List<Element> cpl = group.getChildrenByName("component");
          for (Element cp : cpl) {
            NodeStack ns3 = ns2.push(cp, c2, null, null);
            warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cp.line(), cp.col(), ns3.getLiteralPath(), cpl.size() == 1 || cp.hasChild("code"), I18nConstants.MEASURE_M_GROUP_STRATA_COMP_NO_CODE);
            if (cp.hasChild("criteria")) {
              Element crit = cp.getNamedChild("criteria");
              NodeStack nsc = ns3.push(crit, -1, null, null);
              ok= validateMeasureCriteria(hostContext, errors, mctxt, crit, nsc) && ok;
            }
            c2++;
          }
          c1++;
        }
        c++;
      }            
    }
    if (!stack.isContained()) {
      ok = checkShareableMeasure(errors, element, stack) && ok;
    }
    return ok;
  }
  

  private boolean checkShareableMeasure(List<ValidationMessage> errors, Element cs, NodeStack stack) {
    boolean ok = true;
    if (parent.isForPublication()) { 
      if (isHL7(cs)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url"), I18nConstants.MEASURE_SHAREABLE_MISSING_HL7, "url") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version"), I18nConstants.MEASURE_SHAREABLE_MISSING_HL7, "version") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name"), I18nConstants.MEASURE_SHAREABLE_EXTRA_MISSING_HL7, "name") && ok;                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title"), I18nConstants.MEASURE_SHAREABLE_MISSING_HL7, "title");                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status"), I18nConstants.MEASURE_SHAREABLE_MISSING_HL7, "status") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental"), I18nConstants.MEASURE_SHAREABLE_MISSING_HL7, "experimental") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("publisher"), I18nConstants.MEASURE_SHAREABLE_MISSING_HL7, "publisher") && ok; 
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description"), I18nConstants.MEASURE_SHAREABLE_MISSING_HL7, "description") && ok; 
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url"), I18nConstants.MEASURE_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version"), I18nConstants.MEASURE_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name"), I18nConstants.MEASURE_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title"), I18nConstants.MEASURE_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status"), I18nConstants.MEASURE_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental"), I18nConstants.MEASURE_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description"), I18nConstants.MEASURE_SHAREABLE_MISSING, "description"); 
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("publisher"), I18nConstants.MEASURE_SHAREABLE_MISSING, "publisher"); 
      }
    }
    return ok;
  }
  
  private boolean validateMeasureCriteria(ValidatorHostContext hostContext, List<ValidationMessage> errors, MeasureContext mctxt, Element crit, NodeStack nsc) {
    boolean ok = true;
    String mimeType = crit.getChildValue("language");
    if (!Utilities.noString(mimeType)) { // that would be an error elsewhere 
      if ("text/cql".equals(mimeType) || "text/cql.identifier".equals(mimeType)) {
        String cqlRef = crit.getChildValue("expression");
        Library lib = null;
        if (rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), mctxt.libraries().size()> 0, I18nConstants.MEASURE_M_CRITERIA_CQL_NO_LIB)) {
          if (cqlRef.contains(".")) {
            String name = cqlRef.substring(0, cqlRef.indexOf(".")); 
            cqlRef = cqlRef.substring(cqlRef.indexOf(".")+1); 
            for (Library l : mctxt.libraries()) {
              if (name.equals(l.getName())) {
                if (rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), lib == null, I18nConstants.MEASURE_M_CRITERIA_CQL_LIB_DUPL)) {
                  lib = l;
                } else {
                  ok = false;
                }
              }
            }
            ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), lib != null, I18nConstants.MEASURE_M_CRITERIA_CQL_LIB_NOT_FOUND, name) && ok;
          } else {
            if (rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), mctxt.libraries().size() == 1, I18nConstants.MEASURE_M_CRITERIA_CQL_ONLY_ONE_LIB)) {
              lib = mctxt.libraries().get(0);
            } else {
              ok = false;
            }
          }
        } else {
          ok = false;
        }
        if (lib != null) {
          if (rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), lib.hasUserData(MeasureContext.USER_DATA_ELM), I18nConstants.MEASURE_M_CRITERIA_CQL_NO_ELM, lib.getUrl())) {
            if (lib.getUserData(MeasureContext.USER_DATA_ELM) instanceof String) {
              ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), false, I18nConstants.MEASURE_M_CRITERIA_CQL_ERROR, lib.getUrl(), lib.getUserString(MeasureContext.USER_DATA_ELM)) && ok;            
            } else if (lib.getUserData(MeasureContext.USER_DATA_ELM) instanceof Document) {
              org.w3c.dom.Element elm = ((Document)lib.getUserData(MeasureContext.USER_DATA_ELM)).getDocumentElement();
              if (rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), isValidElm(elm), I18nConstants.MEASURE_M_CRITERIA_CQL_ELM_NOT_VALID, lib.getUrl(), cqlRef)) {
                ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, crit.line(), crit.col(), nsc.getLiteralPath(), hasCqlTarget(elm, cqlRef), I18nConstants.MEASURE_M_CRITERIA_CQL_NOT_FOUND, lib.getUrl(), cqlRef) && ok;
              }
            }
          } else {
            ok = false;
          }
        }
      } else if ("text/fhirpath".equals(mimeType)) {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, crit.line(), crit.col(), nsc.getLiteralPath(), false, I18nConstants.MEASURE_M_CRITERIA_UNKNOWN, mimeType);
      } else if ("application/x-fhir-query".equals(mimeType)) {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, crit.line(), crit.col(), nsc.getLiteralPath(), false, I18nConstants.MEASURE_M_CRITERIA_UNKNOWN, mimeType);
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, crit.line(), crit.col(), nsc.getLiteralPath(), false, I18nConstants.MEASURE_M_CRITERIA_UNKNOWN, mimeType);
      }  
    }
    return ok;
  }
    
  private boolean isValidElm(org.w3c.dom.Element elm) {
    return elm != null && "library".equals(elm.getNodeName()) && "urn:hl7-org:elm:r1".equals(elm.getNamespaceURI());
  }

  private boolean hasCqlTarget(org.w3c.dom.Element element, String cqlRef) {
    org.w3c.dom.Element stmts = XMLUtil.getNamedChild(element, "statements");
    if (stmts != null) {
      for (org.w3c.dom.Element def : XMLUtil.getNamedChildren(stmts, "def")) {
        if (cqlRef.equals(def.getAttribute("name"))) {
          return true;
        }
      }
    }
    return false;
  }


  // ---------------------------------------------------------------------------------------------------------------------------------------------------------

  public boolean validateMeasureReport(ValidatorHostContext hostContext, List<ValidationMessage> errors, Element element, NodeStack stack) throws FHIRException {
    boolean ok = true;
    Element m = element.getNamedChild("measure");
    String measure = null;
    if (m != null) {
      /*
       * q.getValue() is correct for R4 content, but we'll also accept the second
       * option just in case we're validating raw STU3 content. Being lenient here
       * isn't the end of the world since if someone is actually doing the reference
       * wrong in R4 content it'll get flagged elsewhere by the validator too
       */
      if (isNotBlank(m.getValue())) {
        measure = m.getValue();
      } else if (isNotBlank(m.getChildValue("reference"))) {
        measure = m.getChildValue("reference");
      }
    }
    if (hint(errors, NO_RULE_DATE, IssueType.REQUIRED, element.line(), element.col(), stack.getLiteralPath(), measure != null, I18nConstants.MEASURE_MR_M_NONE)) {
      long t = System.nanoTime();
      Measure msrc = measure.startsWith("#") ? loadMeasure(element, measure.substring(1)) : context.fetchResource(Measure.class, measure);
      timeTracker.sd(t);
      if (warning(errors, NO_RULE_DATE, IssueType.REQUIRED, m.line(), m.col(), stack.getLiteralPath(), msrc != null, I18nConstants.MEASURE_MR_M_NOTFOUND, measure)) {
        boolean inComplete = !"complete".equals(element.getNamedChildValue("status"));
        MeasureContext mc = new MeasureContext(msrc, element);
        NodeStack ns = stack.push(m, -1, m.getProperty().getDefinition(), m.getProperty().getDefinition());
        hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, m.line(), m.col(), ns.getLiteralPath(), Utilities.existsInList(mc.scoring(), "proportion", "ratio", "continuous-variable", "cohort"), I18nConstants.MEASURE_MR_M_SCORING_UNK); 
        ok = validateMeasureReportGroups(hostContext, mc, errors, element, stack, inComplete) && ok;
      }
    }
    return ok;
  }

  private Measure loadMeasure(Element resource, String id) throws FHIRException {
    try {
      for (Element contained : resource.getChildren("contained")) {
        if (contained.getIdBase().equals(id)) {
          FhirPublication v = FhirPublication.fromCode(context.getVersion());
          ByteArrayOutputStream bs = new ByteArrayOutputStream();
          new JsonParser(context).compose(contained, bs, OutputStyle.NORMAL, id);
          byte[] json = bs.toByteArray();
          switch (v) {
            case DSTU1:
              throw new FHIRException(context.formatMessage(I18nConstants.UNSUPPORTED_VERSION_R1));
            case DSTU2:
              throw new FHIRException(context.formatMessage(I18nConstants.UNSUPPORTED_VERSION_R2));
            case DSTU2016May:
              throw new FHIRException(context.formatMessage(I18nConstants.UNSUPPORTED_VERSION_R2B));
            case STU3:
              org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(json);
              Resource r5 = VersionConvertorFactory_30_50.convertResource(r3);
              if (r5 instanceof Measure)
                return (Measure) r5;
              else
                return null;
            case R4:
              org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(json);
              r5 = VersionConvertorFactory_40_50.convertResource(r4);
              if (r5 instanceof Measure)
                return (Measure) r5;
              else
                return null;
            case R5:
              r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(json);
              if (r5 instanceof Measure)
                return (Measure) r5;
              else
                return null;
          }
        }
      }
      return null;
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  private boolean validateMeasureReportGroups(ValidatorHostContext hostContext, MeasureContext m, List<ValidationMessage> errors, Element mr, NodeStack stack, boolean inProgress) {
    boolean ok = true;
    
    if (m.groups().size() == 0) {
      // only validate the report groups if the measure has groups.
      return ok;
    }

    List<MeasureGroupComponent> groups = new ArrayList<MeasureGroupComponent>();

    List<Element> glist = mr.getChildrenByName("group");
    
    if (glist.size() == 1 && m.groups().size() == 1) {
      // if there's only one group, it can be ((and usually is) anonymous)
      // but we still check that the code, if both have one, is consistent.
      Element mrg = glist.get(0);
      NodeStack ns = stack.push(mrg, 0, mrg.getProperty().getDefinition(), mrg.getProperty().getDefinition());
      if (m.groups().get(0).hasCode() && mrg.hasChild("code")) {
        CodeableConcept cc = ObjectConverter.readAsCodeableConcept(mrg.getNamedChild("code"));
        if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), hasUseableCode(cc), I18nConstants.MEASURE_MR_GRP_NO_USABLE_CODE)) {
          ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), cc.matches(m.groups().get(0).getCode()), I18nConstants.MEASURE_MR_GRP_NO_WRONG_CODE, DataRenderer.display(context, cc), DataRenderer.display(context, m.groups().get(0).getCode())) && ok;
        } else {
          ok = false;
        }
      }
      ok = validateMeasureReportGroup(hostContext, m, m.groups().get(0), errors, mrg, ns, inProgress) && ok;
    } else {
      int i = 0;
      for (Element mrg : glist) {
        NodeStack ns = stack.push(mrg, i, mrg.getProperty().getDefinition(), mrg.getProperty().getDefinition());
        CodeableConcept cc = ObjectConverter.readAsCodeableConcept(mrg.getNamedChild("code"));
        if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), cc != null, I18nConstants.MEASURE_MR_GRP_NO_CODE)) {
          MeasureGroupComponent mg = getGroupForCode(cc, m.measure());
          if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), mg != null, I18nConstants.MEASURE_MR_GRP_UNK_CODE)) {
            if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), !groups.contains(mg), I18nConstants.MEASURE_MR_GRP_DUPL_CODE)) {
              groups.add(mg);
              ok = validateMeasureReportGroup(hostContext, m, mg, errors, mrg, ns, inProgress) && ok;
            } else {
              ok = false;
            }
          } else {
            ok = false;
          }
        } else {
          ok = false;
        }
        i++;
      }
      boolean dataCollection = isDataCollection(mr);
      for (MeasureGroupComponent mg : m.groups()) {
        if (!groups.contains(mg)) {
          ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mr.line(), mr.col(), stack.getLiteralPath(), groups.contains(mg) || dataCollection, I18nConstants.MEASURE_MR_GRP_MISSING_BY_CODE, DataRenderer.display(context, mg.getCode())) && ok;
        }
      }
    }
    return ok;
  }

  private boolean isDataCollection(Element mr) {
    return "data-collection".equals(mr.getChildValue("type"));
  }

  private boolean validateMeasureReportGroup(ValidatorHostContext hostContext, MeasureContext m, MeasureGroupComponent mg, List<ValidationMessage> errors, Element mrg, NodeStack ns, boolean inProgress) {
    boolean ok = true;
    ok = validateMeasureReportGroupPopulations(hostContext, m, mg, errors, mrg, ns, inProgress) && ok;
    ok = validateScore(hostContext, m, errors, mrg, ns, inProgress) && ok;
    ok = validateMeasureReportGroupStratifiers(hostContext, m, mg, errors, mrg, ns, inProgress) && ok;
    return ok;
  }

  private boolean validateScore(ValidatorHostContext hostContext, MeasureContext m, List<ValidationMessage> errors, Element mrg, NodeStack stack, boolean inProgress) {
    boolean ok = true;
    
    Element ms = mrg.getNamedChild("measureScore");
    // first, we check MeasureReport.type
    if ("data-collection".equals(m.reportType())) {
      ok = banned(errors, stack, ms, I18nConstants.MEASURE_MR_SCORE_PROHIBITED_RT) && ok;
    } else if ("cohort".equals(m.scoring())) {
      //  cohort - there is no measure score
      ok = banned(errors, stack, ms, I18nConstants.MEASURE_MR_SCORE_PROHIBITED_MS) && ok;
    } else if (Utilities.existsInList(m.scoring(), "proportion", "ratio", "continuous-variable")) {
      if (rule(errors, NO_RULE_DATE, IssueType.REQUIRED, mrg.line(), mrg.col(), stack.getLiteralPath(), ms != null, I18nConstants.MEASURE_MR_SCORE_REQUIRED, m.scoring())) {
        NodeStack ns = stack.push(ms, -1, ms.getProperty().getDefinition(), ms.getProperty().getDefinition());
        Element v = ms.getNamedChild("value");
        // TODO: this is a DEQM special and should be handled differently
        if (v == null) {
          if (ms.hasExtension("http://hl7.org/fhir/us/davinci-deqm/StructureDefinition/extension-alternateScoreType")) {
            v = ms.getExtension("http://hl7.org/fhir/us/davinci-deqm/StructureDefinition/extension-alternateScoreType").getNamedChild("value");
          }
        }
        if ("proportion".equals(m.scoring())) {
          //  proportion - score is a unitless number from 0 ... 1
          ok = banned(errors, ns, ms, "unit", I18nConstants.MEASURE_MR_SCORE_UNIT_PROHIBITED, "proportion");
          ok = banned(errors, ns, ms, "system", I18nConstants.MEASURE_MR_SCORE_UNIT_PROHIBITED, "proportion");
          ok = banned(errors, ns, ms, "code", I18nConstants.MEASURE_MR_SCORE_UNIT_PROHIBITED, "proportion");
          if (rule(errors, NO_RULE_DATE, IssueType.REQUIRED, ms.line(), ms.col(), ns.getLiteralPath(), v != null, I18nConstants.MEASURE_MR_SCORE_VALUE_REQUIRED, "proportion")) {
            try {
              BigDecimal dec = new BigDecimal(v.primitiveValue());
              NodeStack nsv = ns.push(v, -1, v.getProperty().getDefinition(), v.getProperty().getDefinition());
              ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, v.line(), v.col(), nsv.getLiteralPath(), dec.compareTo(new BigDecimal(0)) >= 0 && dec.compareTo(new BigDecimal(1)) <= 0, I18nConstants.MEASURE_MR_SCORE_VALUE_INVALID_01) && ok;
            } catch (Exception e) {
              // nothing - will have caused an error elsewhere
            }            
          } else {
            ok = false;
          }
        } else if ("ratio".equals(m.scoring())) {
          //  ratio -  score is a number with no value constraints, and maybe with a unit (perhaps constrained by extension)
          if (rule(errors, NO_RULE_DATE, IssueType.REQUIRED, ms.line(), ms.col(), ns.getLiteralPath(), v != null, I18nConstants.MEASURE_MR_SCORE_VALUE_REQUIRED, "ratio")) {
            Element unit = ms.getNamedChild("code");
            Coding c = m.measure().hasExtension(ToolingExtensions.EXT_Q_UNIT) ? (Coding) m.measure().getExtensionByUrl(ToolingExtensions.EXT_Q_UNIT).getValue() : null;
            if (unit != null) {
              if (c != null) {
                NodeStack nsc = ns.push(unit, -1, unit.getProperty().getDefinition(), unit.getProperty().getDefinition());
                ok = rule(errors, NO_RULE_DATE, IssueType.CODEINVALID, unit.line(), unit.col(), nsc.getLiteralPath(), c.getCode().equals(unit.primitiveValue()), I18nConstants.MEASURE_MR_SCORE_FIXED, c.getCode()) && ok;
                Element system = ms.getNamedChild("system");
                if (system == null) {
                  NodeStack nss = system == null ? ns : ns.push(system, -1, system.getProperty().getDefinition(), system.getProperty().getDefinition());
                  ok = rule(errors, NO_RULE_DATE, IssueType.CODEINVALID, system.line(), system.col(), nss.getLiteralPath(), c.getSystem().equals(system.primitiveValue()), I18nConstants.MEASURE_MR_SCORE_FIXED, c.getSystem()) && ok;
                } else {
                  ok = rule(errors, NO_RULE_DATE, IssueType.CODEINVALID, ms.line(), ms.col(), ns.getLiteralPath(), c.getSystem().equals(system.primitiveValue()), I18nConstants.MEASURE_MR_SCORE_FIXED, c.getSystem()) && ok;
                }
              }
            } else if (c != null) {
              ok = rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, ms.line(), ms.col(), ns.getLiteralPath(), false, I18nConstants.MEASURE_MR_SCORE_FIXED, DataRenderer.display(context, c)) && ok;            
            } else {
              warning(errors, NO_RULE_DATE, IssueType.NOTFOUND, ms.line(), ms.col(), ns.getLiteralPath(), false, I18nConstants.MEASURE_MR_SCORE_UNIT_REQUIRED, "ratio");            
            }
          } else {
            ok = true;
          }
        } else if ("continuous-variable".equals(m.scoring())) {
          // continuous-variable - score is a quantity with a unit per the extension
          if (rule(errors, NO_RULE_DATE, IssueType.REQUIRED, ms.line(), ms.col(), ns.getLiteralPath(), v != null, I18nConstants.MEASURE_MR_SCORE_VALUE_REQUIRED, "continuous-variable")) {
            Element unit = ms.getNamedChild("code");
            Coding c = m.measure().hasExtension(ToolingExtensions.EXT_Q_UNIT) ? (Coding) m.measure().getExtensionByUrl(ToolingExtensions.EXT_Q_UNIT).getValue() : null;
            if (unit != null) {
              if (c != null) {
                NodeStack nsc = ns.push(unit, -1, unit.getProperty().getDefinition(), unit.getProperty().getDefinition());
                rule(errors, NO_RULE_DATE, IssueType.CODEINVALID, unit.line(), unit.col(), nsc.getLiteralPath(), c.getCode().equals(unit.primitiveValue()), I18nConstants.MEASURE_MR_SCORE_FIXED, c.getCode());
                Element system = ms.getNamedChild("system");
                if (system == null) {
                  NodeStack nss = system == null ? ns : ns.push(system, -1, system.getProperty().getDefinition(), system.getProperty().getDefinition());
                  ok = rule(errors, NO_RULE_DATE, IssueType.CODEINVALID, system.line(), system.col(), nss.getLiteralPath(), c.getSystem().equals(system.primitiveValue()), I18nConstants.MEASURE_MR_SCORE_FIXED, c.getSystem()) && ok;
                } else {
                  ok = rule(errors, NO_RULE_DATE, IssueType.CODEINVALID, ms.line(), ms.col(), ns.getLiteralPath(), c.getSystem().equals(system.primitiveValue()), I18nConstants.MEASURE_MR_SCORE_FIXED, c.getSystem()) && ok;
                }
              }
            } else if (c != null) {
              ok = rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, ms.line(), ms.col(), ns.getLiteralPath(), false, I18nConstants.MEASURE_MR_SCORE_FIXED, DataRenderer.display(context, c)) && ok;            
            } 
          }
        }
      } else { // else do nothing - there's a hint elsewhere
        ok = false;
      }
    } 
    return ok;
  }

  private boolean banned(List<ValidationMessage> errors, NodeStack stack, Element parent, String childName, String msgId, Object... params) {
    Element child = parent.getNamedChild(childName);
    return banned(errors, stack, child, msgId, params);
  }
  
  private boolean banned(List<ValidationMessage> errors, NodeStack stack, Element e, String msgId, Object... params) {
    if (e != null) {
      NodeStack ns = stack.push(e, -1, e.getProperty().getDefinition(), e.getProperty().getDefinition());
      rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, e.line(), e.col(), ns.getLiteralPath(), false, msgId, params);
      return false;
    } else {
      return true;
    }
  }
  private boolean validateMeasureReportGroupPopulations(ValidatorHostContext hostContext, MeasureContext m, MeasureGroupComponent mg, List<ValidationMessage> errors, Element mrg, NodeStack stack, boolean inProgress) {
    boolean ok = true;
    // there must be a population for each population defined in the measure, and no 4others. 
    List<MeasureGroupPopulationComponent> pops = new ArrayList<MeasureGroupPopulationComponent>();
    List<Element> plist = mrg.getChildrenByName("population");
    
    int i = 0;
    for (Element mrgp : plist) {
      NodeStack ns = stack.push(mrgp, i, mrgp.getProperty().getDefinition(), mrgp.getProperty().getDefinition());
      CodeableConcept cc = ObjectConverter.readAsCodeableConcept(mrgp.getNamedChild("code"));
      if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrgp.line(), mrgp.col(), ns.getLiteralPath(), cc != null, I18nConstants.MEASURE_MR_GRP_POP_NO_CODE)) {
        MeasureGroupPopulationComponent mgp = getGroupPopForCode(cc, mg);
        if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), mgp != null, I18nConstants.MEASURE_MR_GRP_POP_UNK_CODE)) {
          if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), !pops.contains(mgp), I18nConstants.MEASURE_MR_GRP_POP_DUPL_CODE)) {
            pops.add(mgp);
            ok = validateMeasureReportGroupPopulation(hostContext, m, mgp, errors, mrgp, ns, inProgress) && ok;
          } else {
            ok = false;
          }
        } else {
          ok = false;
        }
      } else {
        ok = false;
      }
      i++;
    }
    for (MeasureGroupPopulationComponent mgp : mg.getPopulation()) {
      if (!pops.contains(mgp) && !mgp.getCode().hasCoding("http://terminology.hl7.org/CodeSystem/measure-population", "measure-observation")) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), stack.getLiteralPath(), pops.contains(mg), I18nConstants.MEASURE_MR_GRP_MISSING_BY_CODE, DataRenderer.display(context, mgp.getCode())) && ok;
      }
    }
    return ok;
  }
  
  private boolean validateMeasureReportGroupPopulation(ValidatorHostContext hostContext, MeasureContext m, MeasureGroupPopulationComponent mgp, List<ValidationMessage> errors, Element mrgp, NodeStack ns, boolean inProgress) {
    boolean ok = true;
    List<Element> sr = mrgp.getChildrenByName("subjectResults");
    if ("subject-list".equals(m.reportType())) {
      try {
        int c = Integer.parseInt(mrgp.getChildValue("count"));
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrgp.line(), mrgp.col(), ns.getLiteralPath(), c == sr.size(), I18nConstants.MEASURE_MR_GRP_POP_COUNT_MISMATCH, c, sr.size()) && ok;
      } catch (Exception e) {
        // nothing; that'll be because count is not valid, and that's a different error or its missing and we don't care
      }
    } else {
      ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrgp.line(), mrgp.col(), ns.getLiteralPath(), sr.size() == 0, I18nConstants.MEASURE_MR_GRP_POP_NO_SUBJECTS) && ok;
      warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrgp.line(), mrgp.col(), ns.getLiteralPath(), mrgp.hasChild("count"), I18nConstants.MEASURE_MR_GRP_POP_NO_COUNT);      
    }
    return ok;
  }

  private boolean validateMeasureReportGroupStratifiers(ValidatorHostContext hostContext, MeasureContext m, MeasureGroupComponent mg, List<ValidationMessage> errors, Element mrg, NodeStack stack, boolean inProgress) {
    boolean ok = true;
    
    // there must be a population for each population defined in the measure, and no 4others. 
    List<MeasureGroupStratifierComponent> strats = new ArrayList<>();
    List<Element> slist = mrg.getChildrenByName("stratifier");
    
    int i = 0;
    for (Element mrgs : slist) {
      NodeStack ns = stack.push(mrgs, i, mrgs.getProperty().getDefinition(), mrgs.getProperty().getDefinition());
      CodeableConcept cc = ObjectConverter.readAsCodeableConcept(mrgs.getNamedChild("code"));
      if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrgs.line(), mrgs.col(), ns.getLiteralPath(), cc != null, I18nConstants.MEASURE_MR_GRP_POP_NO_CODE)) {
        MeasureGroupStratifierComponent mgs = getGroupStratifierForCode(cc, mg);
        if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), mgs != null, I18nConstants.MEASURE_MR_GRP_POP_UNK_CODE)) {
          if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), ns.getLiteralPath(), !strats.contains(mgs), I18nConstants.MEASURE_MR_GRP_POP_DUPL_CODE)) {
            strats.add(mgs);
            ok = validateMeasureReportGroupStratifier(hostContext, m, mgs, errors, mrgs, ns, inProgress) && ok;
          } else {
            ok = false;
          }
        } else {
          ok = false;
        }
      } else {
        ok = false;
      }
      i++;
    }
    for (MeasureGroupStratifierComponent mgs : mg.getStratifier()) {
      if (!strats.contains(mgs)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, mrg.line(), mrg.col(), stack.getLiteralPath(), strats.contains(mg), I18nConstants.MEASURE_MR_GRP_MISSING_BY_CODE, DataRenderer.display(context, mgs.getCode())) && ok;
      }
    }
    return true;
  }
  
  private boolean validateMeasureReportGroupStratifier(ValidatorHostContext hostContext, MeasureContext m, MeasureGroupStratifierComponent mgs, List<ValidationMessage> errors, Element mrgs, NodeStack ns, boolean inProgress) {
    // still to be done
    return true;
  }

  private MeasureGroupStratifierComponent getGroupStratifierForCode(CodeableConcept cc, MeasureGroupComponent mg) {
    for (MeasureGroupStratifierComponent t : mg.getStratifier()) {
      if (t.hasCode()) {
        for (Coding c : t.getCode().getCoding()) {
          if (cc.hasCoding(c.getSystem(), c.getCode())) {
            return t;
          }
        }
        if (!cc.hasCoding() && !t.getCode().hasCoding()) {
          if (cc.hasText() && t.getCode().hasText()) {
            if (cc.getText().equals(t.getCode().getText())) {
              return t;
            }
          }
        }
      }
    }
    return null;
  }

  private boolean hasUseableCode(CodeableConcept cc) {
    for (Coding c : cc.getCoding()) {
      if (c.hasSystem() && c.hasCode()) {
        return true;
      }
    }
    return false;
  }

  private MeasureGroupPopulationComponent getGroupPopForCode(CodeableConcept cc, MeasureGroupComponent mg) {
    for (MeasureGroupPopulationComponent t : mg.getPopulation()) {
      if (t.hasCode()) {
        for (Coding c : t.getCode().getCoding()) {
          if (cc.hasCoding(c.getSystem(), c.getCode())) {
            return t;
          }
        }
      }
    }
    return null;
  }
  private MeasureGroupComponent getGroupForCode(CodeableConcept cc, Measure m) {
    for (MeasureGroupComponent t : m.getGroup()) {
      if (t.hasCode()) {
        for (Coding c : t.getCode().getCoding()) {
          if (cc.hasCoding(c.getSystem(), c.getCode())) {
            return t;
          }
        }
      }
    }
    return null;
  }


}