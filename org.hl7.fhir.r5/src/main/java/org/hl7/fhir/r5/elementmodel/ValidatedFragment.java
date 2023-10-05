package org.hl7.fhir.r5.elementmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class ValidatedFragment {

  @Getter
  private String name;

  @Getter @Setter
  private String elementPath;

  @Getter
  private String extension;

  @Getter @Setter
  private Element element;

  @Getter @Setter
  private byte[] content;

  @Getter
  private final boolean isDerivedContent;
  public final static String FOCUS_NAME = "focus";

  @Getter
  private List<ValidationMessage> errors = new ArrayList<>();


  public ValidatedFragment(String name, String extension, Element element, byte[] content, boolean isDerivedContent) {
    super();
    this.name = name;
    this.element = element; 
    this.content = content;
    this.extension = extension;
    this.isDerivedContent = isDerivedContent;
  }

  public ValidatedFragment(String name, String extension, byte[] content, boolean isDerivedContent) {
    super();
    this.name = name;
    this.content = content;
    this.extension = extension;
    this.isDerivedContent = isDerivedContent;
  }
  public String getFilename() {
    return name+"."+extension;
  }

  public String path() {
    return elementPath == null ? name : elementPath;
  }
}