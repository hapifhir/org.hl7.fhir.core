package org.hl7.fhir.validation.codesystem;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.CodeValidationRule;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyFilterType;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyOperation;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyValidationRules;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class SnomedCTChecker extends CodeSystemChecker {
  private boolean noTag = false;
  private List<String> noTags = new ArrayList<>();
  private boolean hasTag = false;
  private List<String> tags = new ArrayList<>();
  
  public SnomedCTChecker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, settings, xverManager, errors, session);
  }
  
  public void checkConcept(String code, String display) {
    super.checkConcept(code, display);
    if (!Utilities.noString(display)) {
      int s = display.lastIndexOf("(");
      int e = display.lastIndexOf(")");
      boolean tagged = e == display.length() - 1 && s > -1 && s > display.length() - 20;
      if (tagged) {
        hasTag = true;
        if (tags.size() < 5) {
          tags.add(display);
        }
      } else {
        noTag = true;
        if (noTags.size() < 5) {
          noTags.add(display);
        }
      }      
    }
  }
  public void finish(Element inc, NodeStack stack) {
    super.finish(inc, stack);
    hint(errors, "2023-07-21", IssueType.BUSINESSRULE, inc.line(), inc.col(), stack.getLiteralPath(), !(noTag && hasTag), I18nConstants.VALUESET_CONCEPT_DISPLAY_SCT_TAG_MIXED, tags.toString(), noTags.toString());           
  }

  @Override
  public void listPropertyNames(List<String> knownNames) { 
    // list from http://tx.fhir.org/r4/ValueSet/$expand?url=http://snomed.info/sct?fhir_vs=isa/410662002
    addName(knownNames, "concept");
    addName(knownNames, "constraint");
    addName(knownNames, "expressions");
    addName(knownNames, "inactive");
    addName(knownNames, "410662002");
    addName(knownNames, "42752001");
    addName(knownNames, "47429007");
    addName(knownNames, "116676008");
    addName(knownNames, "116686009");
    addName(knownNames, "118168003");
    addName(knownNames, "118169006");
    addName(knownNames, "118170007");
    addName(knownNames, "118171006");
    addName(knownNames, "127489000");
    addName(knownNames, "131195008");
    addName(knownNames, "246075003");
    addName(knownNames, "246090004");
    addName(knownNames, "246093002");
    addName(knownNames, "246112005");
    addName(knownNames, "246454002");
    addName(knownNames, "246456000");
    addName(knownNames, "246501002");
    addName(knownNames, "246513007");
    addName(knownNames, "246514001");
    addName(knownNames, "255234002");
    addName(knownNames, "260507000");
    addName(knownNames, "260686004");
    addName(knownNames, "260870009");
    addName(knownNames, "263502005");
    addName(knownNames, "272741003");
    addName(knownNames, "288556008");
    addName(knownNames, "363589002");
    addName(knownNames, "363698007");
    addName(knownNames, "363699004");
    addName(knownNames, "363700003");
    addName(knownNames, "363701004");
    addName(knownNames, "363702006");
    addName(knownNames, "363703001");
    addName(knownNames, "363704007");
    addName(knownNames, "363705008");
    addName(knownNames, "363709002");
    addName(knownNames, "363710007");
    addName(knownNames, "363713009");
    addName(knownNames, "363714003");
    addName(knownNames, "370129005");
    addName(knownNames, "370130000");
    addName(knownNames, "370131001");
    addName(knownNames, "370132008");
    addName(knownNames, "370133003");
    addName(knownNames, "370134009");
    addName(knownNames, "370135005");
    addName(knownNames, "371881003");
    addName(knownNames, "405813007");
    addName(knownNames, "405814001");
    addName(knownNames, "405815000");
    addName(knownNames, "405816004");
    addName(knownNames, "408729009");
    addName(knownNames, "408730004");
    addName(knownNames, "408731000");
    addName(knownNames, "408732007");
    addName(knownNames, "410675002");
    addName(knownNames, "411116001");
    addName(knownNames, "418775008");
    addName(knownNames, "419066007");
    addName(knownNames, "424226004");
    addName(knownNames, "424244007");
    addName(knownNames, "424361007");
    addName(knownNames, "424876005");
    addName(knownNames, "425391005");
    addName(knownNames, "609096000");
    addName(knownNames, "704319004");
    addName(knownNames, "704320005");
    addName(knownNames, "704321009");
    addName(knownNames, "704322002");
    addName(knownNames, "704323007");
    addName(knownNames, "704324001");
    addName(knownNames, "704325000");
    addName(knownNames, "704326004");
    addName(knownNames, "704327008");
    addName(knownNames, "704346009");
    addName(knownNames, "704347000");
    addName(knownNames, "704647008");
    addName(knownNames, "718497002");
    addName(knownNames, "719715003");
    addName(knownNames, "719722006");
    addName(knownNames, "726542003");
    addName(knownNames, "726633004");
    addName(knownNames, "732943007");
    addName(knownNames, "732945000");
    addName(knownNames, "732947008");
    addName(knownNames, "733722007");
    addName(knownNames, "733725009");
    addName(knownNames, "733928003");
    addName(knownNames, "733930001");
    addName(knownNames, "733931002");
    addName(knownNames, "733932009");
    addName(knownNames, "733933004");
    addName(knownNames, "734136001");
    addName(knownNames, "734137005");
    addName(knownNames, "736472000");
    addName(knownNames, "736473005");
    addName(knownNames, "736474004");
    addName(knownNames, "736475003");
    addName(knownNames, "736476002");
    addName(knownNames, "736518005");
    addName(knownNames, "738774007");
    addName(knownNames, "762705008");
    addName(knownNames, "762706009");
    addName(knownNames, "762949000");
    addName(knownNames, "762951001");
    addName(knownNames, "763032000");
    addName(knownNames, "766939001");
    addName(knownNames, "774081006");
    addName(knownNames, "774158006");
    addName(knownNames, "774159003");
    addName(knownNames, "774160008");
    addName(knownNames, "774163005");
    addName(knownNames, "827081001");
    addName(knownNames, "836358009");
    addName(knownNames, "840560000");
    addName(knownNames, "860779006");
    addName(knownNames, "860781008");
    addName(knownNames, "1003703000");
    addName(knownNames, "1003735000");
    addName(knownNames, "1142135004");
    addName(knownNames, "1142136003");
    addName(knownNames, "1142137007");
    addName(knownNames, "1142138002");
    addName(knownNames, "1142139005");
    addName(knownNames, "1142140007");
    addName(knownNames, "1142141006");
    addName(knownNames, "1142142004");
    addName(knownNames, "1142143009");
    addName(knownNames, "1148793005");
    addName(knownNames, "1148965004");
    addName(knownNames, "1148967007");
    addName(knownNames, "1148968002");
    addName(knownNames, "1148969005");
    addName(knownNames, "1149366004");
    addName(knownNames, "1149367008");
    addName(knownNames, "1230370004");
    addName(knownNames, "320091000221107");
  }

  @Override
  public PropertyValidationRules rulesForFilter(String property, EnumSet<PropertyOperation> ops) {
    switch (property) {
    case "constraint": return new PropertyValidationRules(PropertyFilterType.String, null, addToOps(ops, PropertyOperation.Equals)).setActive(true);
    case "expressions": return new PropertyValidationRules(PropertyFilterType.Boolean, null, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In));
    case "inactive": return new PropertyValidationRules(PropertyFilterType.Boolean, null, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In));
    case "concept": return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, addToOps(ops, PropertyOperation.IsA, PropertyOperation.IsNotA, PropertyOperation.In, PropertyOperation.DescendentOf, PropertyOperation.DescendentLeaf));
    default:
      return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In));
    }
  }
  
  @Override
  public StringWithFlag checkFilterValue(String system, String version, String property, String op, String value, PropertyValidationRules rules, ValidationOptions options) {
    ValueSet vs = new ValueSet();
    vs.setStatus(PublicationStatus.DRAFT);
    vs.getCompose().addInclude().setSystem(system).setVersion(version).addFilter().setProperty("constraint").setOp(FilterOperator.EQUAL).setValue(value);
    
    try {
      return process(context.validateTxResource(options, vs));
    } catch (EFhirClientException e) {
      return process(e.getServerError());
    } catch (Exception e) {
      return new StringWithFlag(e.getMessage(), false);
    }
  }

  private StringWithFlag process(OperationOutcome oo) {
    for (OperationOutcomeIssueComponent iss : oo.getIssue()) {
      if (hasLocation(iss, "ValueSet.include.filter.value[0]", "ValueSet.compose.include[0].filter[0].value")) {
        return new StringWithFlag(iss.getText(), false);
      }
    }
    if (oo.getIssue().size() == 1 && oo.getIssueFirstRep().getLocation().size() == 0) {
      return new StringWithFlag(oo.getIssueFirstRep().getText(), true);
    }
    return null;
  }

  private boolean hasLocation(OperationOutcomeIssueComponent iss, String... paths) {
    for (StringType loc : iss.getLocation()) {
      for (String path : paths) {
        if (path.equals(loc.getValue())) {
          return true;
        }
      }
    }
    return false;
  }
  
}
