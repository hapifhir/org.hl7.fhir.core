package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public interface CodeResolver {

  public class CodeResolution {
    private String systemName;
    private String systemLink;
    private String link;
    private String display;
    private String hint;
    
    
    protected CodeResolution(String systemName, String systemLink, String link, String display, String hint) {
      super();
      this.systemName = systemName;
      this.systemLink = systemLink;
      this.link = link;
      this.display = display;
      this.hint = hint;
    }
    
    public String getSystemName() {
      return systemName;
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
  
  public CodeResolution resolveCode(String system, String code, Resource source);
  public CodeResolution resolveCode(Coding code, Resource source);
  public CodeResolution resolveCode(CodeableConcept code, Resource source);
}
