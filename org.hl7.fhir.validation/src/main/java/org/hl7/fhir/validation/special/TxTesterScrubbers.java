package org.hl7.fhir.validation.special;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.ElementVisitor;
import org.hl7.fhir.r5.utils.ElementVisitor.ElementVisitorInstruction;
import org.hl7.fhir.r5.utils.ElementVisitor.IElementVisitor;
import org.hl7.fhir.utilities.Utilities;

public class TxTesterScrubbers {


  public static class TxTesterScrubberVisitor implements IElementVisitor {

    private boolean tight;
    
    protected TxTesterScrubberVisitor(boolean tight) {
      super();
      this.tight = tight;
    }

    private boolean isManagedExtension(Extension extension) {
      return tight || !Utilities.isAbsoluteUrl(extension.getUrl()) || Utilities.existsInList(extension.getUrl(), 
          "http://hl7.org/fhir/StructureDefinition/codesystem-alternate", 
          "http://hl7.org/fhir/StructureDefinition/codesystem-conceptOrder",
          "http://hl7.org/fhir/StructureDefinition/codesystem-label", 
          "http://hl7.org/fhir/StructureDefinition/coding-sctdescid",
          "http://hl7.org/fhir/StructureDefinition/itemWeight", 
          "http://hl7.org/fhir/StructureDefinition/rendering-style", 
          "http://hl7.org/fhir/StructureDefinition/rendering-xhtml", 
          "http://hl7.org/fhir/StructureDefinition/translation",
          "http://hl7.org/fhir/StructureDefinition/valueset-concept-definition", 
          "http://hl7.org/fhir/StructureDefinition/valueset-conceptOrder", 
          "http://hl7.org/fhir/StructureDefinition/valueset-deprecated", 
          "http://hl7.org/fhir/StructureDefinition/valueset-label", 
          "http://hl7.org/fhir/StructureDefinition/valueset-supplement", 
          "http://hl7.org/fhir/test/CodeSystem/de-multi", 
          "http://hl7.org/fhir/test/CodeSystem/en-multi", 
          "http://hl7.org/fhir/test/StructureDefinition/unknown-extension-1", 
          "http://hl7.org/fhir/test/StructureDefinition/unknown-extension-3", 
          "http://hl7.org/fhir/test/StructureDefinition/unknown-extension-4", 
          "http://hl7.org/fhir/test/StructureDefinition/unknown-extension-5", 
          "http://hl7.org/fhir/test/ValueSet/extensions-bad-supplement", 
          "http://hl7.org/fhir/test/ValueSet/simple-all", 
          "http://hl7.org/fhir/test/ValueSet/simple-enumerated", 
          "http://hl7.org/fhir/StructureDefinition/alternate-code-use",
          "http://hl7.org/fhir/StructureDefinition/alternate-code-status",
          "http://hl7.org/fhir/test/ValueSet/simple-filter-isa");
    }
    
    @Override
    public ElementVisitorInstruction visit(Object context, Resource resource) {
      if (resource instanceof DomainResource) {
        DomainResource dr = (DomainResource) resource;
        dr.getExtension().removeIf(ext -> !isManagedExtension(ext));
      } 
      return ElementVisitorInstruction.VISIT_CHILDREN;
    }

    @Override
    public ElementVisitorInstruction visit(Object context, Element element) {
      element.getExtension().removeIf(ext -> !isManagedExtension(ext));
      if (element.fhirType().equals("ValueSet.compose")) {
        return ElementVisitorInstruction.NO_VISIT_CHILDREN;
      } else {
        return ElementVisitorInstruction.VISIT_CHILDREN;
      }
    }
  }
  
  public static void scrubDR(DomainResource dr, boolean tight) {
    dr.setText(null);
    dr.setMeta(null);  
    new ElementVisitor(new TxTesterScrubberVisitor(tight)).visit(null, dr);
  }

  public static void scrubVS(ValueSet vs, boolean tight) {
    scrubDR(vs, tight);    
  }

  public static void scrubParams(Parameters po) {
    po.setMeta(null);
  }

  public static void scrubOO(OperationOutcome po, boolean tight) {
    scrubDR(po, tight);
  }

}
