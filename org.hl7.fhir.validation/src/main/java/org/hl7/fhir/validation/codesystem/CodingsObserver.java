package org.hl7.fhir.validation.codesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.utils.NodeStack;

@Slf4j
public class CodingsObserver extends BaseValidator {

  private class CodingUsage {

    private NodeStack stack;
    private Coding c;

    public CodingUsage(NodeStack stack, Coding c) {
      this.stack = stack;
      this.c = c;
    }
  }

  public CodingsObserver(@Nonnull IWorkerContext context, @Nonnull ValidatorSettings settings, @Nonnull XVerExtensionManager xverManager, ValidatorSession session) {
    super(context, settings, xverManager, session);
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
      log.info("");
      log.info("Checking SCT codes for IPS");

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
      log.info("Done Checking SCT codes for IPS");
    }
  }

  private Map<String, String> checkSCTCodes(Set<String> codes) {
    List<CodingValidationRequest> serverList = new ArrayList<>();
    for (String s : codes) {      
      serverList.add(new CodingValidationRequest(new Coding("http://snomed.info/sct", s, null)));
    }

    ValueSet vsTemp = new ValueSet();
    vsTemp.setUrl("http://terminology.hl7.org/ValueSet/snomed-intl-ips");
    context.validateCodeBatch(null, serverList, vsTemp, false);
    // #FIXME
    Map<String, String> results = new HashMap<>();
    
    for (CodingValidationRequest vr : serverList) {
      if (!vr.getResult().isOk()) {
        results.put(vr.getCoding().getCode(), vr.getResult().getDisplay() != null ? vr.getResult().getDisplay() : vr.getCoding().getDisplay());
      }
    }
    return results;
  }
   
}
