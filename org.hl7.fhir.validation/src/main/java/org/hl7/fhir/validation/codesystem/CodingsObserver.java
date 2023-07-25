package org.hl7.fhir.validation.codesystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.CodingValidationRequest;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class CodingsObserver extends BaseValidator {

  private class CodingUsage {

    private NodeStack stack;
    private Coding c;

    public CodingUsage(NodeStack stack, Coding c) {
      this.stack = stack;
      this.c = c;
    }
  }

  public CodingsObserver(IWorkerContext context, XVerExtensionManager xverManager, boolean debug) {
    super(context, xverManager, debug);
    this.context = context;
  }

  private IWorkerContext context;
  private List<CodingUsage> list = new ArrayList<>();
  private boolean checkIPSCodes;

  public void seeCode(NodeStack stack, String system, String version, String code, String display) {
    seeCode(stack, new Coding().setSystem(system).setCode(code).setVersion(version).setDisplay(display));    
  }

  public boolean isCheckIPSCodes() {
    return checkIPSCodes;
  }

  public void setCheckIPSCodes(boolean checkIPSCodes) {
    this.checkIPSCodes = checkIPSCodes;
  }


  public void seeCode(NodeStack stack, CodeableConcept cc) {
    for (Coding c : cc.getCoding()) {
      seeCode(stack, c);
    }
  }

  public void seeCode(NodeStack stack, Coding c) {
    list.add(new CodingUsage(stack, c));
    
  }

  public void finish(List<ValidationMessage> errors, NodeStack rootStack) {
    if (checkIPSCodes) {
      System.out.println("");
      System.out.println("Checking SCT codes for IPS");

      Set<String> snomedCTCodes = new HashSet<>();
      for (CodingUsage c : list) {
        if ("http://snomed.info/sct".equals(c.c.getSystem()) && c.c.getCode() != null) {
          snomedCTCodes.add(c.c.getCode());
        }
      }
      if (!snomedCTCodes.isEmpty()) {
        Map<String, String> nonIPSCodes = checkSCTCodes(snomedCTCodes);
        if (!nonIPSCodes.isEmpty()) {
          for (String s : nonIPSCodes.keySet()) {
            hint(errors, "2023-07-25", IssueType.BUSINESSRULE, rootStack, false, I18nConstants.CS_SCT_IPS_NOT_IPS, s, nonIPSCodes.get(s));
          }
        }
      }
      System.out.println("Done Checking SCT codes for IPS");
    }

  }

  private Map<String, String> checkSCTCodes(Set<String> codes) {
    List<CodingValidationRequest> serverList = new ArrayList<>();
    for (String s : codes) {      
      serverList.add(new CodingValidationRequest(new Coding("http://snomed.info/sct", s, null)));
    }
    
    context.validateCodeBatchByRef(null, serverList, "http://terminology.hl7.org/ValueSet/snomed-intl-ips");
    
    Map<String, String> results = new HashMap<>();
    
    for (CodingValidationRequest vr : serverList) {
      if (!vr.getResult().isOk()) {
        results.put(vr.getCoding().getCode(), vr.getResult().getDisplay() != null ? vr.getResult().getDisplay() : vr.getCoding().getDisplay());
      }
    }
    return results;
  }
   
}
