package org.hl7.fhir.services.fhirpath;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class FHIRPathUtilityClasses {

  public static class FHIRConstant extends Base {

    private static final long serialVersionUID = -8933773658248269439L;
    private String value;

    public FHIRConstant(String value) {
      this.value = value;
    }

    @Override    
    public String fhirType() {
      return "%constant";
    }

    @Override
    protected void listChildren(List<Property> result) {
    }

    @Override
    public String getIdBase() {
      return null;
    }

    @Override
    public void setIdBase(String value) {
    }

    public String getValue() {
      return value;
    }

    @Override
    public String primitiveValue() {
      return value;
    }

    @Override
    public Base copy(EnumSet<CopyObjectOptions> options) {
      throw new Error("Not Implemented");
    }
    
    public FhirPublication getFHIRPublicationVersion() {
      return FhirPublication.R5; 
    }
  }

  public static class ClassTypeInfo extends Base {
    private static final long serialVersionUID = 4909223114071029317L;
    private Base instance;

    public ClassTypeInfo(Base instance) {
      super();
      this.instance = instance;
    }

    @Override
    public String fhirType() {
      return "ClassInfo";
    }

    @Override
    protected void listChildren(List<Property> result) {
    }

    @Override
    public String getIdBase() {
      return null;
    }

    @Override
    public void setIdBase(String value) {
    }

    @Override
    public Base[] getNamedValue(String name, boolean checkValid) throws FHIRException {
      if (name.equals("name")) {
        return new Base[]{new StringType(getName())};
      } else if (name.equals("namespace")) { 
        return new Base[]{new StringType(getNamespace())};
      } else {
        return super.getNamedValue(name, checkValid);
      }
    }

    private String getNamespace() {
      if ((instance instanceof Resource)) {
        return "FHIR";
      } else if (!(instance instanceof Element) || ((Element)instance).isDisallowExtensions()) {
        return "System";
      } else {
        return "FHIR";
      }
    }

    private String getName() {
      if ((instance instanceof Resource)) {
        return instance.fhirType();
      } else if (!(instance instanceof Element) || ((Element)instance).isDisallowExtensions()) {
        return Utilities.capitalize(instance.fhirType());
      } else {
        return instance.fhirType();
      }
    }

    @Override
    public Base copy(EnumSet<CopyObjectOptions> options) {
      throw new Error("Not Implemented");
    }

    public FhirPublication getFHIRPublicationVersion() {
      return FhirPublication.R5; 
    }
  }

  public static class TypedElementDefinition {
    private ElementDefinition element;
    private String type;
    private StructureDefinition src;
    public TypedElementDefinition(StructureDefinition src, ElementDefinition element, String type) {
      super();
      this.element = element;
      this.type = type;
      this.src = src;
    }
    public TypedElementDefinition(ElementDefinition element) {
      super();
      this.element = element;
    }
    public ElementDefinition getElement() {
      return element;
    }
    public String getType() {
      return type;
    }
    public List<TypeRefComponent> getTypes() {
      List<TypeRefComponent> res = new ArrayList<ElementDefinition.TypeRefComponent>();
      for (TypeRefComponent tr : element.getTypeList()) {
        if (type == null || type.equals(tr.getCode())) {
          res.add(tr);
        }
      }
      return res;
    }
    public boolean hasType(String tn) {
      if (type != null) {
        return tn.equals(type);
      } else {
        for (TypeRefComponent t : element.getTypeList()) {
          if (tn.equals(t.getCode())) {
            return true;
          }
        }
        return false;
      }
    }
    public StructureDefinition getSrc() {
      return src;
    }
  }
  

  public static class FunctionDetails {
    private String description;
    private int minParameters;
    private int maxParameters;
    public FunctionDetails(String description, int minParameters, int maxParameters) {
      super();
      this.description = description;
      this.minParameters = minParameters;
      this.maxParameters = maxParameters;
    }
    public String getDescription() {
      return description;
    }
    public int getMinParameters() {
      return minParameters;
    }
    public int getMaxParameters() {
      return maxParameters;
    }

  }
}
