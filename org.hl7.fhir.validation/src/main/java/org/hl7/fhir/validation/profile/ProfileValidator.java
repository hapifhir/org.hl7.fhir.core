package org.hl7.fhir.validation.profile;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;

public class ProfileValidator extends BaseValidator {

  private boolean checkAggregation = false;
  private boolean checkMustSupport = false;
  private boolean allowDoubleQuotesInFHIRPath = false;
  private FHIRPathEngine fpe;

  public ProfileValidator(IWorkerContext context, XVerExtensionManager xverManager) {
    super(context, xverManager, false);
    fpe = new FHIRPathEngine(context);
    fpe.setAllowDoubleQuotes(allowDoubleQuotesInFHIRPath);
  }

  public boolean isCheckAggregation() {
    return checkAggregation;
  }

  public boolean isCheckMustSupport() {
    return checkMustSupport;
  }

  public void setCheckAggregation(boolean checkAggregation) {
    this.checkAggregation = checkAggregation;
  }

  public void setCheckMustSupport(boolean checkMustSupport) {
    this.checkMustSupport = checkMustSupport;
  }

  public boolean isAllowDoubleQuotesInFHIRPath() {
    return allowDoubleQuotesInFHIRPath;
  }

  public void setAllowDoubleQuotesInFHIRPath(boolean allowDoubleQuotesInFHIRPath) {
    this.allowDoubleQuotesInFHIRPath = allowDoubleQuotesInFHIRPath;
  }

  protected boolean rule(List<ValidationMessage> errors, IssueType type, String path, boolean b, String msg) {
    String rn = path.contains(".") ? path.substring(0, path.indexOf(".")) : path;
    return super.ruleHtml(errors, NO_RULE_DATE, type, path, b, msg, "<a href=\""+(rn.toLowerCase())+".html\">"+rn+"</a>: "+Utilities.escapeXml(msg));
  }

  public List<ValidationMessage> validate(StructureDefinition profile, boolean forBuild) {
    List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
    
    // must have a FHIR version- GF#3160
    String s = (profile.getKind() == StructureDefinitionKind.LOGICAL) ? "Logical Models" : "Profiles";
    warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, profile.getUrl(), profile.hasFhirVersion(), s+" SHOULD state the FHIR Version on which they are based");
    warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, profile.getUrl(), profile.hasVersion(), s+" SHOULD state their own version");
    
    // extensions must be defined
    for (ElementDefinition ec : profile.getDifferential().getElement())
      checkExtensions(profile, errors, "differential", ec);
    rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, profile.getId(), profile.hasSnapshot(), "missing Snapshot at "+profile.getName()+"."+profile.getName());
    for (ElementDefinition ec : profile.getSnapshot().getElement()) 
      checkExtensions(profile, errors, "snapshot", ec);

    if (rule(errors, NO_RULE_DATE, IssueType.STRUCTURE, profile.getId(), profile.hasSnapshot(), "A snapshot is required")) {
      Hashtable<String, ElementDefinition> snapshotElements = new Hashtable<String, ElementDefinition>();
      for (ElementDefinition ed : profile.getSnapshot().getElement()) {
        snapshotElements.put(ed.getId(), ed);
        for (ElementDefinitionConstraintComponent inv : ed.getConstraint()) {
          if (forBuild) {
            if (!inExemptList(inv.getKey())) {
//              if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, profile.getId()+"::"+ed.getPath()+"::"+inv.getKey(), inv.hasExpression(), "The invariant has no FHIR Path expression ("+inv.getXpath()+")")) {
//                try {
//                  fpe.check(null, profile.getType(), ed.getPath(), inv.getExpression()); // , inv.hasXpath() && inv.getXpath().startsWith("@value")
//                } catch (Exception e) {
//                  // rule(errors, UNKNOWN_DATE_TIME, IssueType.STRUCTURE, profile.getId()+"::"+ed.getPath()+"::"+inv.getId(), false, e.getMessage());
//                }
//              } 
            }
          }
        }
      }
      if (snapshotElements != null) {
        for (ElementDefinition diffElement : profile.getDifferential().getElement()) {
          if (diffElement == null)
            throw new Error("Diff Element is null - this is not an expected thing");
          ElementDefinition snapElement = snapshotElements.get(diffElement.getId());
          if (snapElement!=null) { // Happens with profiles in the main build - should be able to fix once snapshot generation is fixed - Lloyd
            warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, diffElement.getId(), !checkMustSupport || snapElement.hasMustSupport(), "Elements included in the differential should declare mustSupport");
            if (checkAggregation) {
              for (TypeRefComponent type : snapElement.getType()) {
                if ("http://hl7.org/fhir/Reference".equals(type.getWorkingCode()) || "http://hl7.org/fhir/canonical".equals(type.getWorkingCode())) {
                  warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, diffElement.getId(), type.hasAggregation(), "Elements with type Reference or canonical should declare aggregation");
                }
              }
            }
          }
        }
      }
    }
    return errors;
  }

  // these are special cases
  private boolean inExemptList(String key) {
    return key.startsWith("txt-");
  }

  private boolean checkExtensions(StructureDefinition profile, List<ValidationMessage> errors, String kind, ElementDefinition ec) {
    if (!ec.getType().isEmpty() && "Extension".equals(ec.getType().get(0).getWorkingCode()) && ec.getType().get(0).hasProfile()) {
      String url = ec.getType().get(0).getProfile().get(0).getValue();
      StructureDefinition defn = context.fetchResource(StructureDefinition.class, url);
      if (defn == null) {
        defn = getXverExt(profile, errors, url);
      }
      return rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, profile.getId(), defn != null, "Unable to find Extension '"+url+"' referenced at "+profile.getUrl()+" "+kind+" "+ec.getPath()+" ("+ec.getSliceName()+")");
    } else {
      return true;
    }
  }

 
}