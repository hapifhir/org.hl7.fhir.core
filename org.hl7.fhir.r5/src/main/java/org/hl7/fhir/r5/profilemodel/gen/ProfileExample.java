package org.hl7.fhir.r5.profilemodel.gen;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.ObservationStatus;
import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.PEInstance;

/**
 * This class is a manually written example of the code that a POJO code
 * generator for Profiles would produce 
 * 
 * Should you generate code? If you can bind at compile time, then you should. 
 * If you can't - and most systems can't, given the nature of profiles, then 
 * you should use PEInstance directly
 * 
 * @author grahamegrieve
 *
 */
public class ProfileExample extends PEGeneratedBase {

  public enum LOINCCodesForCholesterolInSerumPlasma {
    L14647_2, L2093_3, L35200_5, L9342_7;
    
    public String getCode() {
      switch (this) {
      case L14647_2: return "14647-2";
      case L2093_3: return "2093-3";
      case L35200_5: return "35200-5";
      case L9342_7: return "9342-7";
      }
      return null;
    }
    
    public String getDisplay() {
      switch (this) {
      case L14647_2: return "Cholesterol [Moles/Volume]";
      case L2093_3: return "Cholesterol [Mass/Volume]";
      case L35200_5: return "Cholesterol [Mass Or Moles/Volume]";
      case L9342_7: return "Cholesterol [Percentile]";
      }
      return null;
    }
    
    public static LOINCCodesForCholesterolInSerumPlasma fromCode(String code) {
      if (code != null) {
        switch (code) {
        case "14647-2": return L14647_2;
        case "2093-3": return L2093_3;
        case "35200-5": return L35200_5;
        case "9342-7": return L9342_7;
        }
      }
      return null;
    }
  }

  
  public static class ProfileExampleComplexSlice3 extends PEGeneratedBase {
    private ProfileExampleComplexSlice3(PEInstance instance) {
      super();
      this.instance = instance;
    }

    public List<Coding> getSlice3a() {
      List<Coding> res = new ArrayList<>();
      for (PEInstance pe : instance.children("slice3a")) {
        res.add((Coding) pe.asDataType());
      }
      return res;
    }
    
    public boolean hasSlice3a() {
      return instance.children("slice3a").size() > 0;    
    }
    
    public ProfileExampleComplexSlice3 clearSlice3a() {
      removeChildren("slice3a");
      return this;
    }
    

    public List<StringType> getSlice3b() {
      List<StringType> res = new ArrayList<>();
      for (PEInstance pe : instance.children("slice3b")) {
        res.add((StringType) pe.asDataType());
      }
      return res;
    }
    
    public boolean hasSlice3b() {
      return instance.children("slice3b").size() > 0;    
    }
    
    public ProfileExampleComplexSlice3 clearSlice3b() {
      removeChildren("slice3b");
      return this;
    }
  }
  
  public static class ProfileExampleComplex extends PEGeneratedBase {
    private ProfileExampleComplex(PEInstance instance) {
      super();
      this.instance = instance;
    }
    
    public List<Coding> getSlice1() {
      List<Coding> res = new ArrayList<>();
      for (PEInstance pe : instance.children("slice1")) {
        res.add((Coding) pe.asDataType());
      }
      return res;
    }
    
    public boolean hasSlice1() {
      return instance.children("slice1").size() > 0;    
    }
    
    public ProfileExampleComplex clearSlice1() {
      removeChildren("slice1");
      return this;
    }
    
    public List<StringType> getSlice2() {
      List<StringType> res = new ArrayList<>();
      for (PEInstance pe : instance.children("slice2")) {
        res.add((StringType) pe.asDataType());
      }
      return res;
    }
    
    public boolean hasSlice2() {
      return instance.children("slice2").size() > 0;    
    }
    
    public ProfileExampleComplex clearSlice2() {
      removeChildren("slice1");
      return this;
    }
    
    public ProfileExampleComplexSlice3 getSlice3() {
      PEInstance pe = instance.forceChild("slice3");
      return new ProfileExampleComplexSlice3(pe);
    }
    
    public boolean hasComplex() {
      return instance.child("slice3") != null;
    }
    
    public ProfileExampleComplex clearComplex() {
      removeChild("slice3");
      return this;
    }
    
  }
  
  public ProfileExample(IWorkerContext context, Observation observation) {
    super();
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION_ID, true);
    instance = builder.buildPEInstance("http://hl7.org/fhir/test/StructureDefinition/pe-profile1", "0.1", observation);
  }
  
  /** 
   * this is public for testing purposes, but you generally shouldn't use it. If you do, make 
   * sure the parameters are (PEElementPropertiesPolicy.EXTENSION_ID, true) when building the PEBuilder
   * 
   * @param instance
   */
  public ProfileExample(PEInstance instance) {
    super();
    this.instance = instance;
  }
  
  /** 
   * @return fixed value "final"
   */
  public ObservationStatus getStatus() {
    return ObservationStatus.FINAL;
  }

  public CodeableConcept getCode() {
    return instance.forceChild("code").asCodeableConcept();
  }
  
  /**
   * Extension http://hl7.org/fhir/test/StructureDefinition/pe-extension-simple, type code
   * @return
   */
  public LOINCCodesForCholesterolInSerumPlasma getSimple() {
    return LOINCCodesForCholesterolInSerumPlasma.fromCode(((CodeType) instance.forceChild("simple").asDataType()).primitiveValue());
  }
  
  public boolean hasSimple() {
    return instance.child("simple") != null;    
  }
  
  public ProfileExample clearSimple() {
    removeChild("simple");
    return this;
  }

  public ProfileExampleComplex getComplex() {
    PEInstance pe = instance.child("complex");
    return new ProfileExampleComplex(pe);
  }
  
  public boolean hasComplex() {
    return instance.child("complex") != null;
  }
  
  public ProfileExample clearComplex() {
    removeChild("complex");
    return this;
  }
  
  /*
   * this doesn't exist, because of the way infrastructure works.
   * You get the value and set the properties
   */
//  public void setSimple() {
//    return (CodeType) instance.forceChild("simple").asDataType();
//  }
  
}
