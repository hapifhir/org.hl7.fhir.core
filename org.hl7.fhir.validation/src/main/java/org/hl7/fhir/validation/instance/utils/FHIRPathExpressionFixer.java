package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.utilities.Utilities;

public class FHIRPathExpressionFixer {


  public static String fixExpr(String expr, String key) {
    // this is a hack work around for past publication of wrong FHIRPath expressions
    // R4
    // waiting for 4.0.2
    //TODO is this expression below correct? @grahamegrieve
    if ("probability is decimal implies (probability as decimal) <= 100".equals(expr)) {
      return "probability.empty() or ((probability is decimal) implies ((probability as decimal) <= 100))";
    }
    if ("enableWhen.count() > 2 implies enableBehavior.exists()".equals(expr)) {
      return "enableWhen.count() >= 2 implies enableBehavior.exists()";
    }
    if ("txt-2".equals(key)) {
      return "htmlChecks2()";
    }
    if ("generated='generated' implies source.empty()".equals(expr)) {
      return "generation='generated' implies source.empty()";
    }
    // fixes to string functions in FHIRPath
    // ref-1
    if (expr.equals("reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids')) or (reference='#' and %rootResource!=%resource)")) { // R5
      return "reference.exists() implies ("+expr+")";
    }
    if (expr.equals("reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))")) { // R4/R4B
      return "reference.exists() implies (reference = '#' or ("+expr+"))";
    }
    if (expr.equals("reference.startsWith('#').not() or (reference.substring(1).trace('url') in %resource.contained.id.trace('ids'))")) { // STU3
      return "reference.exists() implies (reference = '#' or (reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))))";
    }
    // bld-8
    if (expr.equals("fullUrl.contains('/_history/').not()")) { // R4
      return "fullUrl.exists() implies fullUrl.contains('/_history/').not()";      
    }
    if (expr.equals("name.matches('[A-Z]([A-Za-z0-9_]){0,254}')")) {
      return "name.exists() implies name.matches('^[A-Z]([A-Za-z0-9_]){0,254}$')";
    }
    // canonical
    if (expr.equals("name.matches('[A-Z]([A-Za-z0-9_]){0,254}')")) {
      return ("name.exists() implies name.matches('[A-Z]([A-Za-z0-9_]){0,254}')");
    }
    
    // R5 ballot
    if (expr.equals("url.matches('([^|#])*')")) {
      return ("$this.matches('([^|#])*')");
    }
    
    
    
    
    // clarification in FHIRPath spec
    if ("eld-19".equals(key)) {
      return "path.matches('^[^\\\\s\\\\.,:;\\\\\\'\"\\\\/|?!@#$%&*()\\\\[\\\\]{}]{1,64}(\\\\.[^\\\\s\\\\.,:;\\\\\\'\"\\\\/|?!@#$%&*()\\\\[\\\\]{}]{1,64}(\\\\[x\\\\])?(\\\\:[^\\\\s\\\\.]+)?)*$')";
    }
    if ("eld-20".equals(key)) {
      return "path.matches('^[A-Za-z][A-Za-z0-9]*(\\\\.[a-z][A-Za-z0-9]*(\\\\[x])?)*$')";
    }
  
    // handled in 4.0.1
    if ("(component.empty() and hasMember.empty()) implies (dataAbsentReason or value)".equals(expr)) {
      return "(component.empty() and hasMember.empty()) implies (dataAbsentReason.exists() or value.exists())";
    }
    if ("isModifier implies isModifierReason.exists()".equals(expr)) {
      return "(isModifier.exists() and isModifier) implies isModifierReason.exists()";
    }
    if ("(%resource.kind = 'logical' or element.first().path.startsWith(%resource.type)) and (element.tail().not() or  element.tail().all(path.startsWith(%resource.differential.element.first().path.replaceMatches('\\\\..*','')&'.')))".equals(expr)) {
      return "(%resource.kind = 'logical' or element.first().path.startsWith(%resource.type)) and (element.tail().empty() or  element.tail().all(path.startsWith(%resource.differential.element.first().path.replaceMatches('\\\\..*','')&'.')))";
    }
    if ("differential.element.all(id) and differential.element.id.trace('ids').isDistinct()".equals(expr)) {
      return "differential.element.all(id.exists()) and differential.element.id.trace('ids').isDistinct()";
    }
    if ("snapshot.element.all(id) and snapshot.element.id.trace('ids').isDistinct()".equals(expr)) {
      return "snapshot.element.all(id.exists()) and snapshot.element.id.trace('ids').isDistinct()";
    }

    // R3
    if ("(code or value.empty()) and (system.empty() or system = 'urn:iso:std:iso:4217')".equals(expr)) {
      return "(code.exists() or value.empty()) and (system.empty() or system = 'urn:iso:std:iso:4217')";
    }
    if ("value.empty() or code!=component.code".equals(expr)) {
      return "value.empty() or (code in component.code).not()";
    }
    if ("(code or value.empty()) and (system.empty() or system = %ucum) and (value.empty() or value > 0)".equals(expr)) {
      return "(code.exists() or value.empty()) and (system.empty() or system = %ucum) and (value.empty() or value > 0)";
    }
    if ("element.all(definition and min and max)".equals(expr)) {
      return "element.all(definition.exists() and min.exists() and max.exists())";
    }
    if ("telecom or endpoint".equals(expr)) {
      return "telecom.exists() or endpoint.exists()";
    }
    if ("(code or value.empty()) and (system.empty() or system = %ucum) and (value.empty() or value > 0)".equals(expr)) {
      return "(code.exists() or value.empty()) and (system.empty() or system = %ucum) and (value.empty() or value > 0)";
    }
    if ("searchType implies type = 'string'".equals(expr)) {
      return "searchType.exists() implies type = 'string'";
    }
    if ("abatement.empty() or (abatement as boolean).not()  or clinicalStatus='resolved' or clinicalStatus='remission' or clinicalStatus='inactive'".equals(expr)) {
      return "abatement.empty() or (abatement is boolean).not() or (abatement as boolean).not() or (clinicalStatus = 'resolved') or (clinicalStatus = 'remission') or (clinicalStatus = 'inactive')";
    }
    if ("(component.empty() and related.empty()) implies (dataAbsentReason or value)".equals(expr)) {
      return "(component.empty() and related.empty()) implies (dataAbsentReason.exists() or value.exists())";
    }
    if ("reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))".equals(expr)) {
      return "(reference = '#') or reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))";
    }
    if ("reference.startsWith('#').not() or (reference.substring(1).trace('url') in %resource.contained.id.trace('ids'))".equals(expr)) {
      return "(reference = '#') or reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))";
    }
    if ("probability is decimal implies probability.as(decimal) <= 100".equals(expr)) {
      if (key.equals("ras-2")) {
        return "probability.empty() or (probability is decimal implies probability.as(decimal) <= 100)";
      }
    }
    if ("".equals(expr)) {
      return "";
    }
    return expr;
  }
  
}
