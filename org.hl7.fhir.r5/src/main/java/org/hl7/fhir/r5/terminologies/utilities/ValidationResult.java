package org.hl7.fhir.r5.terminologies.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;

public class ValidationResult {
  private ConceptDefinitionComponent definition;
  private String preferredDisplay;
  private String system;
  private String version;
  private IssueSeverity severity;
  private List<String> messages = new ArrayList<>();
  private TerminologyServiceErrorClass errorClass;
  private String txLink;
  private String diagnostics;
  private List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
  private CodeableConcept codeableConcept;
  private Set<String> unknownSystems;
  private boolean inactive;
  private String status;
  
  @Override
  public String toString() {
    return "ValidationResult [definition=" + definition + ", system=" + system + ", severity=" + severity + ", message=" + getMessage() + ", errorClass="
        + errorClass + ", txLink=" + txLink + "]";
  }

  public ValidationResult(IssueSeverity severity, String message, List<OperationOutcomeIssueComponent> issues) {
    this.severity = severity;
    if (message != null) {
      this.messages.add(message);
    }
    if (issues != null) {
      this.issues.addAll(issues);
    }
  }

  public ValidationResult(String system, String version, ConceptDefinitionComponent definition, String preferredDisplay) {
    this.system = system;
    this.version = version;
    this.definition = definition;
    this.preferredDisplay = preferredDisplay;
  }

  public ValidationResult(IssueSeverity severity, String message, String system, String version, ConceptDefinitionComponent definition, String preferredDisplay, List<OperationOutcomeIssueComponent>  issues) {
    this.severity = severity;
    if (message != null) {
      this.messages.add(message);
    }
    this.system = system;
    this.version = version;
    this.definition = definition;
    this.preferredDisplay = preferredDisplay;
    if (issues != null) {
      this.issues.addAll(issues);
    }
  }
  public ValidationResult(IssueSeverity severity, List<String> messages, String system, String version, ConceptDefinitionComponent definition, String preferredDisplay, List<OperationOutcomeIssueComponent>  issues) {
    this.severity = severity;
    this.messages.addAll(messages);
    this.system = system;
    this.version = version;
    this.definition = definition;
    this.preferredDisplay = preferredDisplay;
    if (issues != null) {
      this.issues.addAll(issues);
    }
  }

  public ValidationResult(IssueSeverity severity, String message, TerminologyServiceErrorClass errorClass, List<OperationOutcomeIssueComponent>  issues) {
    this.severity = severity;
    if (message != null) {
      this.messages.add(message);
    }
    this.errorClass = errorClass;
    if (issues != null) {
      this.issues.addAll(issues);
    }
  }

  public boolean isOk() {
    return severity == null || severity == IssueSeverity.INFORMATION || severity == IssueSeverity.WARNING;
  }

  public String getSystem() {
    return system;
  }

  public String getVersion() {
    return version;
  }

  public String getDisplay() {
    if (preferredDisplay != null) {
      return preferredDisplay; 
    } else {
      return definition == null ? null : definition.getDisplay();
    }
  }

  public void setDisplay(String display) {
    this.preferredDisplay = display;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getCode() {
    return definition == null ? null : definition.getCode();
  }

  public String getDefinition() {
    return definition == null ? null : definition.getDefinition();
  }

  public void setDefinition(ConceptDefinitionComponent definition) {
    this.definition = definition;
  }

  public ConceptDefinitionComponent asConceptDefinition() {
    return definition;
  }

  public IssueSeverity getSeverity() {
    return severity;
  }

  public String getMessage() {
    if (messages.size() == 0) {
      return null;
    }
    Collections.sort(messages);
    return CommaSeparatedStringBuilder.join("; ", messages);
  }

  public boolean IsNoService() {
    return errorClass == TerminologyServiceErrorClass.NOSERVICE;
  }

  public TerminologyServiceErrorClass getErrorClass() {
    return errorClass;
  }

  public ValidationResult setSeverity(IssueSeverity severity) {
    this.severity = severity;
    return this;
  }

  public ValidationResult setMessage(String message) {
    this.messages.clear();
    if (message != null) {
      this.messages.add(message);
    }
    return this;
  }
  
  public ValidationResult addMessage(String message) {
    if (message != null) {
      this.messages.add(message);
    }
    return this;
  }
  
  public ValidationResult setErrorClass(TerminologyServiceErrorClass errorClass) {
    this.errorClass = errorClass;
    return this;
  }

  public String getTxLink() {
    return txLink;
  }

  public ValidationResult setTxLink(String txLink) {
    this.txLink = txLink;
    return this;
  }

  public boolean hasMessage() {
    return !messages.isEmpty();
  }

  public String getDiagnostics() {
    return diagnostics;
  }

  public void setDiagnostics(String diagnostics) {
    this.diagnostics = diagnostics;
  }

  public Coding asCoding() {
    if (isOk() && definition != null && definition.getCode() != null) {
      return new Coding(system, definition.getCode(), definition.getDisplay());
    } else {
      return null;
    }
  }

  public List<OperationOutcomeIssueComponent> getIssues() {
    return issues;
  }

  public ValidationResult addCodeableConcept(CodeableConcept vcc) {
    if (!vcc.isEmpty()) {
      codeableConcept = vcc;
    }
    return this;
  }

  public CodeableConcept getCodeableConcept() {
    return codeableConcept;
  }

  public Set<String> getUnknownSystems() {
    return unknownSystems;
  }

  public ValidationResult setUnknownSystems(Set<String> unknownSystems) {
    this.unknownSystems = unknownSystems;
    return this;
  }

  public String unknownSystems() {
    if (unknownSystems == null) {
      return null;
    }
    if (unknownSystems.size() == 1) {
      return unknownSystems.iterator().next();        
    } else {
      return String.join(",", unknownSystems);
    }
  }

  public void setIssues(List<OperationOutcomeIssueComponent> issues) {
    if (this.issues != null) {
      issues.addAll(this.issues);
    }
    this.issues = issues;
    
  }

  public void trimPath(String prefix) {
    if (issues != null) {
      for (OperationOutcomeIssueComponent iss : issues) {
        for (int i = iss.getLocation().size() -1; i >= 0; i--) {
          var s = iss.getLocation().get(i).primitiveValue();
          if (prefix.equals(s)) {
            iss.getLocation().remove(i);
          } else if (s.startsWith(prefix+".")) {
            iss.getLocation().get(i).setValueAsString(s.substring(prefix.length()+1));                
          }            
        }
      }
    }      
    
  }

  public boolean isInactive() {
    return inactive;
  }

  public String getStatus() {
    return status;
  }

  public ValidationResult setStatus(boolean inactive, String status) {
    this.inactive = inactive;
    if (!"inactive".equals(status)) {
      this.status = status;
    }
    return this;
  }

  public boolean messageIsInIssues() {
    // the message is sometimes a summary of the issues that are already tracked. 
    // this returns true in that case, so that duplication of messages is suppressed
    
    for (String s : messages) {
      boolean found = false;
      for (OperationOutcomeIssueComponent iss : issues) {
        if (iss.getSeverity().ordinal() <= getSeverity().ordinal() && s.equals(iss.getDetails().getText())) {
          found = true;
        }
      }
      if (!found) {
        return false;
      }
    }
    return true;
  }

}