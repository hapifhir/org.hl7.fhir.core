package org.hl7.fhir.r5.terminologies.utilities;

import java.util.*;

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;

public class ValidationResult {
  private ConceptDefinitionComponent definition;
  private String preferredDisplay;
  private String system;
  private String version;
  private IssueSeverity severity;
  private Set<String> messages = new HashSet<>();
  private TerminologyServiceErrorClass errorClass;
  private String txLink;
  private String diagnostics;
  private List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
  private CodeableConcept codeableConcept;
  private Set<String> unknownSystems;
  private boolean inactive;
  private String status;
  private String server;
  private boolean errorIsDisplayIssue;
  private Parameters parameters;
  
  @Override
  public String toString() {
    return "ValidationResult [definition=" + definition + ", system=" + system + ", severity=" + severity + ", message=" + getMessage() + ", errorClass="
        + errorClass + ", txLink=" + txLink + "]";
  }

  public ValidationResult(ValidationResult validationResult) {
    this.definition = validationResult.definition == null ? null : validationResult.definition.copy();
    this.preferredDisplay = validationResult.preferredDisplay;
    this.system = validationResult.system;
    this.version = validationResult.version;
    this.severity = validationResult.severity;
    if (validationResult.messages != null) {
      this.messages.addAll(validationResult.messages);
    }
    this.errorClass = validationResult.errorClass;
    this.txLink = validationResult.txLink;
    this.diagnostics = validationResult.diagnostics;
    if (validationResult.issues != null) {
      for (OperationOutcomeIssueComponent issue : validationResult.issues) {
        this.issues.add(issue.copy());
      }
    }
    this.codeableConcept = validationResult.codeableConcept == null ? null : validationResult.codeableConcept.copy();
    this.unknownSystems = validationResult.unknownSystems == null ? null : new HashSet<>(validationResult.unknownSystems);
    this.inactive = validationResult.inactive;
    this.status = validationResult.status;
    this.server = validationResult.server;
  }

  public ValidationResult(IssueSeverity severity, String message, List<OperationOutcomeIssueComponent> issues) {
    this.severity = severity;
    if (message != null) {
      this.messages.add(message);
    }
    if (issues != null) {
      this.issues.addAll(issues);
      for (OperationOutcomeIssueComponent issue : issues) {
        if (issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR) {
          String msg = issue.getDetails().getText();
          if (!this.messages.contains(msg)) {
            this.messages.add(msg);
          }
        }
      }
      for (OperationOutcomeIssueComponent issue : issues) {
        if (issue.getSeverity() == OperationOutcome.IssueSeverity.WARNING && messages.isEmpty()) {
          String msg = issue.getDetails().getText();
          if (!this.messages.contains(msg)) {
            this.messages.add(msg);
          }
        }
      }
      for (OperationOutcomeIssueComponent issue : issues) {
        if (messages.isEmpty()) {
          String msg = issue.getDetails().getText();
          if (!this.messages.contains(msg)) {
            this.messages.add(msg);
          }
        }
      }
    }
  }

  public ValidationResult(IssueSeverity severity, String message1, String message2, List<OperationOutcomeIssueComponent> issues) {
    this.severity = severity;
    if (message1 != null) {
      this.messages.add(message1);
    }
    if (message2 != null) {
      this.messages.add(message2);
    }
    if (issues != null) {
      this.issues.addAll(issues);
      mineIssues(issues);
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
      mineIssues(issues);
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
      mineIssues(issues);
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
      mineIssues(issues);
    }
  }

  public void mineIssues(List<OperationOutcomeIssueComponent> issues) {
    for (OperationOutcomeIssueComponent iss : issues) {
      if (iss.getSeverity() == OperationOutcome.IssueSeverity.ERROR) {
        if (!messages.contains(iss.getDetails().getText())) {
          messages.add(iss.getDetails().getText());
        }
      }
    }
  }
  public boolean isOk() {
    return severity == null || severity == IssueSeverity.INFORMATION || severity == IssueSeverity.WARNING || errorIsDisplayIssue;
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
    return CommaSeparatedStringBuilder.join("; ", Utilities.sorted(messages));
  }

  public String getTrimmedMessage() {
    List<String> toTrim = new ArrayList<>();
    for (OperationOutcomeIssueComponent iss : getIssues()) {
      toTrim.add(iss.getDetails().getText());
    }
    List<String> trimmed = new ArrayList<>();
    trimmed.addAll(messages);
    trimmed.removeAll(toTrim);
    if (trimmed.size() == 0) {
      return null;
    }       
    Collections.sort(trimmed);
    return CommaSeparatedStringBuilder.join("; ", trimmed);
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
    if (message != null && !this.messages.contains(message)) {
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
        for (int i = iss.getExpression().size() -1; i >= 0; i--) {
          var s = iss.getExpression().get(i).primitiveValue();
          if (prefix.equals(s)) {
            iss.getExpression().remove(i);
          } else if (s.startsWith(prefix+".")) {
            iss.getExpression().get(i).setValueAsString(s.substring(prefix.length()+1));                
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

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public boolean equals(Object otherObject) {
    if (!(otherObject instanceof ValidationResult)) {
      return false;
    }

    ValidationResult other = (ValidationResult) otherObject;
    if (!Objects.equals(this.system, other.system)) {
      return false;
    }
    if (!Objects.equals(this.version, other.version)) {
      return false;
    }
    if (!Objects.equals(this.preferredDisplay, other.preferredDisplay)) {
      return false;
    }
    if (!Objects.equals(this.severity, other.severity)) {
      return false;
    }
    if (!Objects.equals(this.definition, other.definition)) {
      return false;
    }
    if (!Objects.equals(this.messages, other.messages)) {
      return false;
    }
    if (!Objects.equals(this.errorClass, other.errorClass)) {
      return false;
    }
    if (!Objects.equals(this.txLink, other.txLink)) {
      return false;
    }
    if (!Objects.equals(this.diagnostics, other.diagnostics)) {
      return false;
    }
    if (!Objects.equals(this.issues, other.issues)) {
      return false;
    }
    if (!Objects.equals(this.codeableConcept, other.codeableConcept)) {
      return false;
    }
    if (!Objects.equals(this.unknownSystems, other.unknownSystems)) {
      return false;
    }
    if (this.inactive != other.inactive) {
      return false;
    }
    if (!Objects.equals(this.status, other.status)) {
      return false;
    }
    if (!Objects.equals(this.server, other.server)) {
      return false;
    }
    return true;
  }

  public boolean isErrorIsDisplayIssue() {
    return errorIsDisplayIssue;
  }

  public ValidationResult setErrorIsDisplayIssue(boolean errorIsDisplayIssue) {
    this.errorIsDisplayIssue = errorIsDisplayIssue;
    return this;
  }

  public Parameters getParameters() {
    return parameters;
  }

  public void setParameters(Parameters parameters) {
    this.parameters = parameters;
    
  }


  public Parameters getOrMakeParameters() {
    if (parameters == null) {
      Parameters p = new Parameters();
      p.addParameter("result", isOk());
      if (getMessage() != null) {
        p.addParameter("message", getMessage());
      }
      if (getDisplay() != null) {
        p.addParameter("display", getDisplay());
      }
      if (getSystem() != null) {
        p.addParameter("system", new UriType(getSystem()));
      }
      if (getVersion() != null) {
        p.addParameter("version", getVersion());
      }
      if (getCode() != null) {
        p.addParameter("code", new CodeType(getCode()));
      }
      if (getCodeableConcept() != null) {
        p.addParameter("codeableConcept", getCodeableConcept());
      }
      if (issues != null && !issues.isEmpty()) {
        OperationOutcome oo = new OperationOutcome();
        oo.getIssue().addAll(issues);
        p.addParameter().setName("issues").setResource(oo);
      }
      return p;
    } else {
      return parameters;
    }
  }

  public boolean hasIssues() {
    return issues != null && !issues.isEmpty();
  }
}