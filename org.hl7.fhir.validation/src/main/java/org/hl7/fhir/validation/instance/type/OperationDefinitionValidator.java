package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.DefinitionNavigator;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class OperationDefinitionValidator extends BaseValidator {

  private FHIRPathEngine fpe;

  public OperationDefinitionValidator(BaseValidator parent, FHIRPathEngine fpe) {
    super (parent);
    this.fpe = fpe;
  }
  
  public boolean validateOperationDefinition(ValidationContext valContext, List<ValidationMessage> errors, Element od, NodeStack stack) {
    boolean ok = true;
    if (od.hasChild("inputProfile")) {
      ok = validateProfile(errors, stack.push(od.getNamedChild("inputProfile"), -1, null, null), od, od.getNamedChildValue("inputProfile"), "in") && ok;
    }
    if (od.hasChild("outputProfile")) {
      ok = validateProfile(errors, stack.push(od.getNamedChild("outputProfile"), -1, null, null), od, od.getNamedChildValue("outputProfile"), "out") && ok;      
    }

    return ok;
  }

  private boolean validateProfile(List<ValidationMessage> errors, NodeStack stack, Element od, String url, String use) {
    boolean  ok = true;
    StructureDefinition sdt = context.fetchResource(StructureDefinition.class, url);
    if (rule(errors, "2025-04-08", IssueType.UNKNOWN, stack, sdt != null, I18nConstants.OPDEF_PROFILE_NOT_FOUND, use, url) &&
        rule(errors, "2025-04-08", IssueType.INVALID, stack, "Parameters".equals(sdt.getType()), I18nConstants.OPDEF_PROFILE_NOT_PARAMETERS, use, url)) {
      DefinitionNavigator profile = new DefinitionNavigator(context, sdt, false, true);
      List<Element> params = od.getChildren("parameter");
      List<Element> matched = new ArrayList<Element>();
      if (profile.childByName("parameter") != null && profile.childByName("parameter").hasSlices()) {
        for (DefinitionNavigator slice : profile.childByName("parameter").slices()) {
          DefinitionNavigator nameSlice = slice.childByName("name");
          if (rule(errors, "2025-04-08", IssueType.UNKNOWN, stack, sdt != null, I18nConstants.OPDEF_PROFILE_NO_SLICE, use, slice.current().getSliceName())) {
            DataType name = nameSlice.current().hasFixed() ? nameSlice.current().getFixed() : nameSlice.current().getPattern();
            if (rule(errors, "2025-04-08", IssueType.UNKNOWN, stack, sdt != null, I18nConstants.OPDEF_PROFILE_NO_FIXED, use, slice.current().getSliceName())) {
              String paramName = name.primitiveValue();
              Element param = getParamByName(params, paramName, use);
              if (param == null) {
                warning(errors, "2025-04-08", IssueType.UNKNOWN, stack, false, I18nConstants.OPDEF_PROFILE_NOT_IN_PARAM, use, paramName);
              } else {
                matched.add(param);
                NodeStack nsp = stack.push(param, params.indexOf(param), null, null);
                ok = compareParameterDefinitions(errors, nsp, use, paramName, slice, param) && ok;
              }
            } else {
              ok = false;
            }
          } else {
            ok = false;
          }
        }
      }
      int i = 0;
      for (Element p : params) {
        if (!matched.contains(p) && use.equals(p.getNamedChildValue("use"))) {
          NodeStack nsp = stack.push(p, i, null, null);
          warning(errors, "2025-04-08", IssueType.UNKNOWN, nsp, false, I18nConstants.OPDEF_PROFILE_NOT_IN_PROFILE, use, p.getNamedChildValue("name"));
        }
        i++;
      }
    } else {
      ok = false;
    }
    return ok;
  }

  private boolean compareParameterDefinitions(List<ValidationMessage> errors, NodeStack nsp, String use, String paramName, DefinitionNavigator slice, Element param) {
    boolean ok = true;
    int minParam = Utilities.parseInt(param.getNamedChildValue("min"), -1);
    int minProfile = slice.current().getMin();
    if (minParam > -1) {
      ok = rule(errors, "2025-04-08", IssueType.UNKNOWN, nsp, minParam == minProfile, I18nConstants.OPDEF_PROFILE_NOT_VALUE_MISMATCH, use, paramName, "min", param.getNamedChildValue("min"), slice.current().getMin()) && ok;
    }
    int maxParam = parseMax(param.getNamedChildValue("max"));
    int maxProfile =  parseMax(slice.current().getMax());
    if (maxParam > -1 && maxProfile > -1) {
      ok = rule(errors, "2025-04-08", IssueType.UNKNOWN, nsp, maxParam == maxProfile, I18nConstants.OPDEF_PROFILE_NOT_VALUE_MISMATCH, use, paramName, "max", param.getNamedChildValue("max"), slice.current().getMax()) && ok;
    }
    
    List<String> allowedTypes = new ArrayList<>();
    if (param.hasExtension(ToolingExtensions.EXT_ALLOWED_TYPE)) {
      for (Element ex : param.getExtensions(ToolingExtensions.EXT_ALLOWED_TYPE)) {
        allowedTypes.add(ex.getNamedChildValue("value"));
      }
    } else if (param.hasChildren("allowedType")) {
      for (Element at : param.getChildren("allowedType")) {
        allowedTypes.add(at.primitiveValue());
      }      
    } else if (param.hasChild("type")) {
      allowedTypes.add(param.getNamedChildValue("type"));
    }
    
    List<String> allowedTargets = new ArrayList<>();
    for (Element at : param.getChildren("targetProfile")) {
      allowedTargets.add(at.primitiveValue());
    } 
    List<String> profileTypes = new ArrayList<>();
    List<String> profileTargets = new ArrayList<>();
    DefinitionNavigator valueDefn = slice.childByName("value");
    DefinitionNavigator resDefn = slice.childByName("resource");
    DefinitionNavigator partDefn = slice.childByName("part");
    if (valueDefn != null && isUsed(valueDefn, resDefn, partDefn)) {
      for (TypeRefComponent tr : valueDefn.current().getType()) {
        String t = tr.getWorkingCode();
        profileTypes.add(t);
        ok = rule(errors, "2025-04-08", IssueType.INVALID, nsp, allowedTypes.contains(t), I18nConstants.OPDEF_PROFILE_TYPE_NOT_IN_PARAMS, use, paramName, t, CommaSeparatedStringBuilder.join2(",", " and ", allowedTypes)) && ok;
        for (CanonicalType ct : tr.getTargetProfile()) {
          profileTargets.add(ct.asStringValue());
        }
      }
    }
    if (resDefn != null && isUsed(resDefn, valueDefn, partDefn)) {
      for (TypeRefComponent tr : resDefn.current().getType()) {
        String t = tr.getWorkingCode();
        profileTypes.add(t);
        for (CanonicalType ct : tr.getProfile()) {
          profileTargets.add(ct.asStringValue());
        }
        ok = rule(errors, "2025-04-08", IssueType.INVALID, nsp, allowedTypes.contains(t), I18nConstants.OPDEF_PROFILE_TYPE_NOT_IN_PARAMS, use, paramName, t, CommaSeparatedStringBuilder.join2(",", " and ", allowedTypes)) && ok;
      }
    }
    for (String t : allowedTypes) {
      ok = rule(errors, "2025-04-08", IssueType.INVALID, nsp, profileTypes.contains(t), I18nConstants.OPDEF_PROFILE_TYPE_NOT_IN_PROFILE, use, paramName, t, CommaSeparatedStringBuilder.join2(",", " and ", profileTypes)) && ok;        
    }

    for (String t : allowedTargets) {
      ok = rule(errors, "2025-04-08", IssueType.INVALID, nsp, profileTargets.contains(t), I18nConstants.OPDEF_PROFILE_PROFILE_NOT_IN_PARAMS, use, paramName, t, CommaSeparatedStringBuilder.join2(",", " and ", profileTargets)) && ok;        
    }
    
    for (String t : profileTargets) {
      ok = rule(errors, "2025-04-08", IssueType.INVALID, nsp, allowedTargets.contains(t), I18nConstants.OPDEF_PROFILE_PROFILE_NOT_IN_PROFILE, use, paramName, t, CommaSeparatedStringBuilder.join2(",", " and ", allowedTargets)) && ok;        
    }
    
//    type / allowedType / extension
//    targetProfile
//    binding
//    
    // toodo later - part
    return ok;
  }

  private boolean isUsed(DefinitionNavigator focus, DefinitionNavigator other1, DefinitionNavigator other2) {
    if ("0".equals(focus.current().getMax())) {
      return false;
    }
    if (other1.current().getMin() > 0) {
      return false;
    }
    if (other2.current().getMin() > 0) {
      return false;
    }
    return true;
  }

  private int parseMax(String max) {
    if ("*".equals(max)) {
      return Integer.MAX_VALUE;
    } else {
      return Utilities.parseInt(max, -1);
    }
  }

  private Element getParamByName(List<Element> params, String paramName, String use) {
    for (Element p : params) {
      if (paramName.equals(p.getNamedChildValue("name")) && use.equals(p.getNamedChildValue("use"))) {
        return p;
      }
    }
    return null;
  }


}
