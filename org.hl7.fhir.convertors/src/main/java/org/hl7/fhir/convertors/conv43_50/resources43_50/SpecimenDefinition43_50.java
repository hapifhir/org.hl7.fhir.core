package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Duration43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Range43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class SpecimenDefinition43_50 {

  public static org.hl7.fhir.r5.model.SpecimenDefinition convertSpecimenDefinition(org.hl7.fhir.r4b.model.SpecimenDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SpecimenDefinition tgt = new org.hl7.fhir.r5.model.SpecimenDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasTypeCollected())
      tgt.setTypeCollected(CodeableConcept43_50.convertCodeableConcept(src.getTypeCollected()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPatientPreparation())
      tgt.addPatientPreparation(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasTimeAspect())
      tgt.setTimeAspectElement(String43_50.convertString(src.getTimeAspectElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCollection())
      tgt.addCollection(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent t : src.getTypeTested())
      tgt.addTypeTested(convertSpecimenDefinitionTypeTestedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition convertSpecimenDefinition(org.hl7.fhir.r5.model.SpecimenDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasTypeCollected())
      tgt.setTypeCollected(CodeableConcept43_50.convertCodeableConcept(src.getTypeCollected()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPatientPreparation())
      tgt.addPatientPreparation(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasTimeAspect())
      tgt.setTimeAspectElement(String43_50.convertString(src.getTimeAspectElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCollection())
      tgt.addCollection(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent t : src.getTypeTested())
      tgt.addTypeTested(convertSpecimenDefinitionTypeTestedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent convertSpecimenDefinitionTypeTestedComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent tgt = new org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasIsDerived())
      tgt.setIsDerivedElement(Boolean43_50.convertBoolean(src.getIsDerivedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasPreference())
      tgt.setPreferenceElement(convertSpecimenContainedPreference(src.getPreferenceElement()));
    if (src.hasContainer())
      tgt.setContainer(convertSpecimenDefinitionTypeTestedContainerComponent(src.getContainer()));
    if (src.hasRequirement())
      tgt.setRequirementElement(String43_50.convertStringToMarkdown(src.getRequirementElement()));
    if (src.hasRetentionTime())
      tgt.setRetentionTime(Duration43_50.convertDuration(src.getRetentionTime()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRejectionCriterion())
      tgt.addRejectionCriterion(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent t : src.getHandling())
      tgt.addHandling(convertSpecimenDefinitionTypeTestedHandlingComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent convertSpecimenDefinitionTypeTestedComponent(org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasIsDerived())
      tgt.setIsDerivedElement(Boolean43_50.convertBoolean(src.getIsDerivedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasPreference())
      tgt.setPreferenceElement(convertSpecimenContainedPreference(src.getPreferenceElement()));
    if (src.hasContainer())
      tgt.setContainer(convertSpecimenDefinitionTypeTestedContainerComponent(src.getContainer()));
    if (src.hasRequirement())
      tgt.setRequirementElement(String43_50.convertString(src.getRequirementElement()));
    if (src.hasRetentionTime())
      tgt.setRetentionTime(Duration43_50.convertDuration(src.getRetentionTime()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRejectionCriterion())
      tgt.addRejectionCriterion(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent t : src.getHandling())
      tgt.addHandling(convertSpecimenDefinitionTypeTestedHandlingComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenContainedPreference> convertSpecimenContainedPreference(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenContainedPreference> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenContainedPreferenceEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREFERRED:
        tgt.setValue(org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenContainedPreference.PREFERRED);
        break;
      case ALTERNATE:
        tgt.setValue(org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenContainedPreference.ALTERNATE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenContainedPreference.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference> convertSpecimenContainedPreference(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenContainedPreference> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreferenceEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREFERRED:
        tgt.setValue(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference.PREFERRED);
        break;
      case ALTERNATE:
        tgt.setValue(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference.ALTERNATE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent convertSpecimenDefinitionTypeTestedContainerComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent tgt = new org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMaterial())
      tgt.setMaterial(CodeableConcept43_50.convertCodeableConcept(src.getMaterial()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasCap())
      tgt.setCap(CodeableConcept43_50.convertCodeableConcept(src.getCap()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCapacity())
      tgt.setCapacity(SimpleQuantity43_50.convertSimpleQuantity(src.getCapacity()));
    if (src.hasMinimumVolume())
      tgt.setMinimumVolume(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getMinimumVolume()));
    for (org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent t : src.getAdditive())
      tgt.addAdditive(convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(t));
    if (src.hasPreparation())
      tgt.setPreparationElement(String43_50.convertStringToMarkdown(src.getPreparationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent convertSpecimenDefinitionTypeTestedContainerComponent(org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMaterial())
      tgt.setMaterial(CodeableConcept43_50.convertCodeableConcept(src.getMaterial()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasCap())
      tgt.setCap(CodeableConcept43_50.convertCodeableConcept(src.getCap()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasCapacity())
      tgt.setCapacity(SimpleQuantity43_50.convertSimpleQuantity(src.getCapacity()));
    if (src.hasMinimumVolume())
      tgt.setMinimumVolume(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getMinimumVolume()));
    for (org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent t : src.getAdditive())
      tgt.addAdditive(convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(t));
    if (src.hasPreparation())
      tgt.setPreparationElement(String43_50.convertString(src.getPreparationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent tgt = new org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasAdditive())
      tgt.setAdditive(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAdditive()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasAdditive())
      tgt.setAdditive(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAdditive()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent convertSpecimenDefinitionTypeTestedHandlingComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent tgt = new org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTemperatureQualifier())
      tgt.setTemperatureQualifier(CodeableConcept43_50.convertCodeableConcept(src.getTemperatureQualifier()));
    if (src.hasTemperatureRange())
      tgt.setTemperatureRange(Range43_50.convertRange(src.getTemperatureRange()));
    if (src.hasMaxDuration())
      tgt.setMaxDuration(Duration43_50.convertDuration(src.getMaxDuration()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_50.convertStringToMarkdown(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent convertSpecimenDefinitionTypeTestedHandlingComponent(org.hl7.fhir.r5.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTemperatureQualifier())
      tgt.setTemperatureQualifier(CodeableConcept43_50.convertCodeableConcept(src.getTemperatureQualifier()));
    if (src.hasTemperatureRange())
      tgt.setTemperatureRange(Range43_50.convertRange(src.getTemperatureRange()));
    if (src.hasMaxDuration())
      tgt.setMaxDuration(Duration43_50.convertDuration(src.getMaxDuration()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_50.convertString(src.getInstructionElement()));
    return tgt;
  }
}