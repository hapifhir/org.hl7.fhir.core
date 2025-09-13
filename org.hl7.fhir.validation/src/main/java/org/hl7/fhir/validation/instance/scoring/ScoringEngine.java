package org.hl7.fhir.validation.instance.scoring;

import org.apache.commons.lang3.StringUtils;
import org.fhir.ucum.UcumException;
import org.fhir.ucum.UcumService;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import java.util.ArrayList;
import java.util.List;

public class ScoringEngine {

  private IWorkerContext context;
  private FHIRPathEngine fpe;
  private UcumService ucumService;

  public ScoringEngine(IWorkerContext context, FHIRPathEngine fpe) {
    super();
    this.context = context;
    this.fpe = fpe;
    this.ucumService = context.getUcumService();
  }

  /**
   * call this at the root of the element tree
   *
   * @param element - post validation (needs validation Info populated)
   * @return a Scored element - with a score
   */
  public ScoreOutcome generateScores(StructureDefinition structure, Element element) {
    ScoreOutcome outcome = new ScoreOutcome();
    outcome.setElement(new ScoredElement(element.fhirType(), -1, element.fhirType(), 0, 0, new ArrayList<>(), new ArrayList<>()));
    for (Element child : element.getChildren()) {
      scoreElement(structure, element.fhirType(), outcome.getRules(), outcome.getElement(), element, element, child);
    }
    return outcome;
  }

  private List<Extension> makeScoreRulesList(List<Base.ValidationInfo> list) {
    List<Extension> rules = new ArrayList<>();
    for (Base.ValidationInfo info : list) {
      for (Extension ext : info.getDefinition().getExtension()) {
        if (Utilities.existsInList(ext.getUrl(), ExtensionDefinitions.EXT_SCORE)) {
          rules.add(ext);
        }
      }
    }
    return rules;
  }

  private void scoreElement(StructureDefinition structure, String path, List<RuleScore> ruleList, ScoredElement res, Element root, Element focus, Element element) {
    List<Base.ValidationInfo> vi = element.getValidationInfoForProfile(structure);
    List<Extension> scoreRules = makeScoreRulesList(vi);
    String n = element.getName();
    if (!vi.isEmpty()) {
      // there's only supposed to be one; we're just going to assume that there's just one and it matters
      ElementDefinition ed = vi.get(0).getDefinition();
      if (ed.hasSliceName()) {
        n = n + ":"+ed.getSliceName();
      }
    }
    String npath = element.getIndex() == -1 ? path + "." + n : path + "." + n + "[" + element.getIndex() + "]";

    double score = 0;
    double total = 0;
    List<String> reasons = new ArrayList<>();
    for (Extension ext : scoreRules) {
      double value = getScoreValue(ext);
      total += value;
      boolean passes = passesCondition(npath, ext, root, focus, element, reasons);
      List<String> rules = getScoreRuleCodes(ext);
      for (String rule : rules) {
        if (passes) {
          try {
            passes = checkRule(npath, element, rule, reasons);
          } catch (Exception e) {
            reasons.add("Exception: " + e.getMessage());
          }
        }
      }
      if (passes) {
        score += value;
      }
      RuleScore rule = getRule(ruleList, ext, value);
      if (rule != null) {
        rule.count(passes);
      }
    }
    ScoredElement e = new ScoredElement(n, element.getIndex(), element.fhirType(), score, total, reasons, scoreRules);
    res.addChild(e);
    for (Element child : element.getChildren()) {
      scoreElement(structure, npath, ruleList, e, root, child.isResource() ? child : focus, child);
    }
  }

  private RuleScore getRule(List<RuleScore> rules, Extension ext, double value) {
    String key = ext.getExtensionString("key");
    if (key == null) {
      return null;
    }
    for (RuleScore r : rules) {
      if (r.getKey().equals(key)) {
        return r;
      }
    }
    RuleScore r = new RuleScore(key, value);
    rules.add(r);
    return r;
  }

  private boolean checkRule(String path, Element element, String rule, List<String> reasons) throws UcumException {
    if ("valid".equals(rule)) {
      return element.isValid();
    } else {
      if (element.isPrimitive()) {
        if (element.fhirType().equals("canonical")) {
          return checkCanonicalRule(path, element, rule, reasons);
        } else {
          return checkPrimitiveRule(path, element, rule, reasons);
        }
      } else if ("Coding".equals(element.fhirType())) {
        return checkCodingRule(path, element, rule, reasons);
      } else if ("CodeableConcept".equals(element.fhirType())) {
        return checkCodeableConceptRule(path, element, rule, reasons);
      } else if ("Identifier".equals(element.fhirType())) {
        return checkIdentifierRule(path, element, rule, reasons);
      } else if ("Quantity".equals(element.fhirType())) {
        return checkQuantityRule(path, element, rule, reasons);
      } else if ("HumanName".equals(element.fhirType())) {
        return checkHumanNameRule(path, element, rule, reasons);
      } else if ("Address".equals(element.fhirType())) {
        return checkAddressRule(path, element, rule, reasons);
      } else if ("Attachment".equals(element.fhirType())) {
        return checkAttachmentRule(path, element, rule, reasons);
      } else if ("ContactPoint".equals(element.fhirType())) {
        return checkContactPointRule(path, element, rule, reasons);
      } else if ("Period".equals(element.fhirType())) {
        return checkPeriodRule(path, element, rule, reasons);
      } else if ("Range".equals(element.fhirType())) {
        return checkRangeRule(path, element, rule, reasons);
      } else if ("Reference".equals(element.fhirType())) {
        return checkReferenceRule(path, element, rule, reasons);
      } else {
        return checkGeneralRule(path, element, rule, reasons);
      }
    }
  }

  private boolean checkCanonicalRule(String path, Element element, String rule, List<String> reasons) {
    // for now
    return checkPrimitiveRule(path, element, rule, reasons);
  }

  private boolean checkPrimitiveRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "value":
        return element.hasPrimitiveValue();
      default:
        if (rule.startsWith("system:")) {
          return rule.substring(7).equals(element.getNamedChildValue("system"));
        } else if (rule.startsWith("binding:")) {
          Coding c = ObjectConverter.readAsCoding(element);
          ValueSet vs = context.fetchResource(ValueSet.class, rule.substring(8));
          if (vs == null) {
            reasons.add("Unable to find ValueSet: " + rule.substring(8));
            return false;
          } else {
            ValidationResult vr = context.validateCode(ValidationOptions.defaults(), c, vs);
            return vr.isOk();
          }
        } else if (rule.startsWith("regex:")) {
          return element.primitiveValue().matches(rule.substring(6));
        } else {
          reasons.add("Unknown rule '" + rule + "' on an Identifier at " + path);
          return false;
        }
    }
  }

  private boolean checkCodingRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "system":
        return element.hasChildren("system");
      case "version":
        return element.hasChildren("version");
      case "code":
        return element.hasChildren("code");
      case "display":
        return element.hasChildren("display");
      default:
        if (rule.startsWith("system:")) {
          return rule.substring(7).equals(element.getNamedChildValue("system"));
        } else if (rule.startsWith("binding:")) {
          Coding c = ObjectConverter.readAsCoding(element);
          ValueSet vs = context.fetchResource(ValueSet.class, rule.substring(8));
          if (vs == null) {
            reasons.add("Unable to find ValueSet: " + rule.substring(8));
            return false;
          } else {
            ValidationResult vr = context.validateCode(ValidationOptions.defaults(), c, vs);
            return vr.isOk();
          }
        } else {
          reasons.add("Unknown rule '" + rule + "' on an Identifier at " + path);
          return false;
        }
    }
  }

  private boolean checkCodeableConceptRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "coding":
        return element.hasChildren("coding");
      case "text":
        return element.hasChildren("text");
      default:
        if (rule.startsWith("system:")) {
          return rule.substring(7).equals(element.getNamedChildValue("system"));
        } else if (rule.startsWith("binding:")) {
          CodeableConcept cc = ObjectConverter.readAsCodeableConcept(element);
          ValueSet vs = context.fetchResource(ValueSet.class, rule.substring(8));
          if (vs == null) {
            reasons.add("Unable to find ValueSet: " + rule.substring(8));
            return false;
          } else {
            ValidationResult vr = context.validateCode(ValidationOptions.defaults(), cc, vs);
            return vr.isOk();
          }
        } else {
          reasons.add("Unknown rule '" + rule + "' on an Identifier at " + path);
          return false;
        }
    }
  }

  private boolean checkIdentifierRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "use":
        return element.hasChildren("use");
      case "type":
        return element.hasChildren("type");
      case "complete":
        return element.hasChildren("system") && element.hasChildren("value");
      default:
        if (rule.startsWith("system:")) {
          return rule.substring(7).equals(element.getNamedChildValue("system"));
        } else {
          reasons.add("Unknown rule '" + rule + "' on an Identifier at " + path);
          return false;
        }
    }
  }

  private boolean checkQuantityRule(String path, Element element, String rule, List<String> reasons) throws UcumException {
    switch (rule) {
      case "code":
        return element.hasChildren("code") && element.hasChildren("system");
      case "ucum":
        return "http://unitsofmeasure.org".equals(element.getNamedChildValue("system"));
      default:
        if (rule.startsWith("compares:")) {
          return ucumService.isComparable(rule.substring(9), element.getNamedChildValue("code"));
        } else {
          reasons.add("Unknown rule '" + rule + "' on a Quantity at " + path);
          return false;
        }
    }
  }

  private boolean checkHumanNameRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "text":
        return element.hasChildren("text");
      case "family":
        return element.hasChildren("family");
      case "given":
        return element.hasChild("given");
      case "content":
        return element.hasChildren("text") || element.hasChildren("given");
      case "use":
        return element.hasChild("use");
      default:
        reasons.add("Unknown rule '" + rule + "' on a HumanName at " + path);
        return false;
    }
  }

  private boolean checkAddressRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "type":
        return element.hasChild("type");
      case "text":
        return element.hasChildren("text");
      case "line":
        return element.hasChildren("line");
      case "postalCode":
        return element.hasChild("postalCode");
      case "content":
        return element.hasChildren("text") || element.hasChildren("line");
      case "use":
        return element.hasChild("use");
      default:
        reasons.add("Unknown rule '" + rule + "' on an Address at " + path);
        return false;

    }
  }

  private boolean checkAttachmentRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "url":
        return element.hasChild("url");
      case "data":
        return element.hasChild("data");
      case "content":
        return element.hasChild("url") || element.hasChild("data");
      case "contentType":
        return element.hasChild("contentType");
      case "triple":
        return (element.hasChild("url") || element.hasChild("data")) && element.hasChild("contentType");
      case "hash":
        return element.hasChild("hash");
      default:
        reasons.add("Unknown rule '" + rule + "' on an Attachment at " + path);
        return false;
    }
  }

  private boolean checkContactPointRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      case "value":
        return element.hasChild("value");
      case "system":
        return element.hasChild("system");
      case "use":
        return element.hasChild("value");
      case "resolves":
        return element.hasChild("value") && element.hasChild("system");
      case "triple":
        return element.hasChild("value") && element.hasChild("system") && element.hasChild("use");
      case "auto":
        return element.hasChild("value") && element.hasChild("system") && Utilities.existsInList(element.getNamedChildValue("system"), "email", "url", "sms");
      default:
        reasons.add("Unknown rule '" + rule + "' on a ContactPoint at " + path);
        return false;
    }
  }

  private boolean checkPeriodRule(String path, Element element, String rule, List<String> reasons) {

    Element start = element.getNamedChild("start", false);
    Element end = element.getNamedChild("end", false);
    switch (rule) {
      case "both":
        return start != null && end != null;
      case "end":
        return end != null;
      case "start":
        return start != null;
      case "precision":
        return start.primitiveValue().length() == end.primitiveValue().length();
      case "timeOfDay":
        return start.primitiveValue().length() > 10 && end.primitiveValue().length() > 10;
      default:
        reasons.add("Unknown rule '" + rule + "' on a Period at " + path);
        return false;
    }
  }

  private boolean checkRangeRule(String path, Element element, String rule, List<String> reasons) throws UcumException {
    Element low = element.getNamedChild("low", false);
    Element high = element.getNamedChild("high", false);
    switch (rule) {
      case "both":
        return low != null && high != null;
      case "high":
        return high != null;
      case "low":
        return low != null;
      case "units":
        return low.hasChild("units") && high.hasChild("units") && low.hasChild("code") && high.hasChild("code");
      case "units-match":
        return low.hasChild("code") && high.hasChild("code") && ucumService.isComparable(low.getNamedChildValue("units"), high.getNamedChildValue("units"));
      case "units-same":
        return low.hasChild("code") && high.hasChild("code") && StringUtils.compare(low.getNamedChildValue("units"), high.getNamedChildValue("units")) == 0;
      default:
        if (rule.startsWith("compares:")) {
          return ucumService.isComparable(rule.substring(9), low.getNamedChildValue("code")) &&
            ucumService.isComparable(rule.substring(9), high.getNamedChildValue("code"));
        } else {
          reasons.add("Unknown rule '" + rule + "' on a Range at " + path);
          return false;
        }

    }
  }

  private boolean checkReferenceRule(String path, Element element, String rule, List<String> reasons) {
    String ref = element.getNamedChildValue("reference");
    switch (rule) {
      case "reference":
        return ref != null;
      case "rest":
        return ref != null && ref.matches(Constants.URI_REGEX);
      case "local-rest":
        return ref != null && ref.matches(Constants.LOCAL_REF_REGEX);
      case "absolute":
        return ref != null && ref.matches(Constants.URI_REGEX) && Utilities.isAbsoluteUrl(ref);
      case "identifier":
        return element.hasChild("identifier");
      case "display":
        return element.hasChild("display");
      default:
        reasons.add("Unknown rule '" + rule + "' on a Reference at " + path);
        return false;
    }
  }

  private boolean checkGeneralRule(String path, Element element, String rule, List<String> reasons) {
    switch (rule) {
      default:
        reasons.add("Unknown rule '" + rule + "' on a " + element.fhirType() + " at " + path);
        return false;
    }
  }

  private boolean passesCondition(String path, Extension ext, Element root, Element focus, Element element, List<String> reasons) {
    if (ext.hasExtension("condition")) {
      String v = ext.getExtensionString("condition");
      try {
        ExpressionNode node = fpe.parse(v);
        return fpe.evaluateToBoolean(null, root, focus, element, node);
      } catch (Exception e) {
        reasons.add("Error evaluating FHIRPath '" + v + "' at '" + path + "': " + e.getMessage());
        return false;
      }
    } else {
      return true;
    }
  }

  private List<String> getScoreRuleCodes(Extension ext) {
    List<String> rules = new ArrayList<>();
    for (Extension e : ext.getExtensionsByUrl("rule")) {
      rules.add(e.getValue().primitiveValue());
    }
    return rules;
  }

  private double getScoreValue(Extension ext) {
    double value = 1;
    if (ext.hasExtension("value")) {
      String v = ext.getExtensionString("value");
      value = Double.parseDouble(v);
    }
    return value;
  }

}
