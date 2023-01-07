package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;

public interface CodeResolver {

  public class CodeResolution {
    private String systenName;
    private String systemLink;
    private String link;
    private String display;
    private String hint;
    
    
    protected CodeResolution(String systenName, String systemLink, String link, String display, String hint) {
      super();
      this.systenName = systenName;
      this.systemLink = systemLink;
      this.link = link;
      this.display = display;
      this.hint = hint;
    }
    
    public String getSystenName() {
      return systenName;
    }
    public String getSystemLink() {
      return systemLink;
    }
    public String getLink() {
      return link;
    }
    public String getDisplay() {
      return display;
    }
    public String getHint() {
      return hint;
    }

    
  }
  
  public CodeResolution resolveCode(String system, String code);
  public CodeResolution resolveCode(Coding code);
  public CodeResolution resolveCode(CodeableConcept code);
}
