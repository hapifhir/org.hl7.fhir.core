package org.hl7.fhir.validation.codesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.terminology.CodingValidationRequest;
import org.hl7.fhir.services.validation.ValidatorSession;
import org.hl7.fhir.services.xver.XVerExtensionManager;
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

  public void seeCode(NodeStack stack, String system, String version, String code, String display) {
    seeCode(stack, new Coding().setSystem(system).setCode(code).setVersion(version).setDisplay(display));    
  }

  public void seeCode(NodeStack stack, CodeableConcept cc) {
    for (Coding c : cc.getCodingList()) {
      seeCode(stack, c);
    }
  }

  public void seeCode(NodeStack stack, Coding c) {
    list.add(new CodingUsage(stack, c));
    
  }

  public void finish(List<ValidationMessage> errors, NodeStack rootStack) {
    // nothing
  }

   
}
