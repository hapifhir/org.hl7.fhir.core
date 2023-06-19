package org.hl7.fhir.validation;

import java.util.List;

import org.hl7.fhir.utilities.validation.ValidationMessage;

public class ValidationRecord {

  private String location;
  private List<ValidationMessage> messages;
  int err = 0;
  int warn = 0;
  int info = 0;

  public ValidationRecord(String location, List<ValidationMessage> messages) {
    this.location = location;
    this.messages = messages;
    for (ValidationMessage vm : messages) {
      if (vm.getLevel().equals(ValidationMessage.IssueSeverity.FATAL) || vm.getLevel().equals(ValidationMessage.IssueSeverity.ERROR))
        err++;
      else if (vm.getLevel().equals(ValidationMessage.IssueSeverity.WARNING))
        warn++;
      else if (!vm.isSignpost()) {
        info++;
      }
    }
  }

  public String getLocation() {
    return location;
  }

  public List<ValidationMessage> getMessages() {
    return messages;
  }

  public int getErr() {
    return err;
  }

  public int getWarn() {
    return warn;
  }

  public int getInfo() {
    return info;
  }

  public void setMessages(List<ValidationMessage> messages) {
    this.messages = messages;
    
  }

}
