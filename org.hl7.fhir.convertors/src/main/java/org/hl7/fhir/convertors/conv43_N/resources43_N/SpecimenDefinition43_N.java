package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Duration43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Range43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.SpecimenDefinition;

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

public class SpecimenDefinition43_N {

  public static org.hl7.fhir.model.core.SpecimenDefinition convertSpecimenDefinition(org.hl7.fhir.r4b.model.SpecimenDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SpecimenDefinition tgt = new org.hl7.fhir.model.core.SpecimenDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasTypeCollected())
      tgt.setTypeCollected(CodeableConcept43_N.convertCodeableConcept(src.getTypeCollected()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPatientPreparation())
      tgt.addPatientPreparation(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasTimeAspect())
      tgt.setTimeAspectElement(String43_N.convertString(src.getTimeAspectElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCollection())
      tgt.addCollection(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent t : src.getTypeTested())
      tgt.addTypeTested(convertSpecimenDefinitionTypeTestedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition convertSpecimenDefinition(org.hl7.fhir.model.core.SpecimenDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasTypeCollected())
      tgt.setTypeCollected(CodeableConcept43_N.convertCodeableConcept(src.getTypeCollected()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getPatientPreparationList())
      tgt.addPatientPreparation(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasTimeAspect())
      tgt.setTimeAspectElement(String43_N.convertString(src.getTimeAspectElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCollectionList())
      tgt.addCollection(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent t : src.getTypeTestedList())
      tgt.addTypeTested(convertSpecimenDefinitionTypeTestedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent convertSpecimenDefinitionTypeTestedComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent tgt = new org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasIsDerived())
      tgt.setIsDerivedElement(Boolean43_N.convertBoolean(src.getIsDerivedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPreference())
      tgt.setPreferenceElement(convertSpecimenContainedPreference(src.getPreferenceElement()));
    if (src.hasContainer())
      tgt.setContainer(convertSpecimenDefinitionTypeTestedContainerComponent(src.getContainer()));
    if (src.hasRequirement())
      tgt.setRequirementElement(String43_N.convertStringToMarkdown(src.getRequirementElement()));
    if (src.hasRetentionTime())
      tgt.setRetentionTime(Duration43_N.convertDuration(src.getRetentionTime()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRejectionCriterion())
      tgt.addRejectionCriterion(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent t : src.getHandling())
      tgt.addHandling(convertSpecimenDefinitionTypeTestedHandlingComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent convertSpecimenDefinitionTypeTestedComponent(org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasIsDerived())
      tgt.setIsDerivedElement(Boolean43_N.convertBoolean(src.getIsDerivedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPreference())
      tgt.setPreferenceElement(convertSpecimenContainedPreference(src.getPreferenceElement()));
    if (src.hasContainer())
      tgt.setContainer(convertSpecimenDefinitionTypeTestedContainerComponent(src.getContainer()));
    if (src.hasRequirement())
      tgt.setRequirementElement(String43_N.convertString(src.getRequirementElement()));
    if (src.hasRetentionTime())
      tgt.setRetentionTime(Duration43_N.convertDuration(src.getRetentionTime()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRejectionCriterionList())
      tgt.addRejectionCriterion(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent t : src.getHandlingList())
      tgt.addHandling(convertSpecimenDefinitionTypeTestedHandlingComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SpecimenDefinition.SpecimenContainedPreference> convertSpecimenContainedPreference(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<SpecimenDefinition.SpecimenContainedPreference> tgt = new Enumeration<>(new SpecimenDefinition.SpecimenContainedPreferenceEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PREFERRED:
                  tgt.setValue(SpecimenDefinition.SpecimenContainedPreference.PREFERRED);
                  break;
              case ALTERNATE:
                  tgt.setValue(SpecimenDefinition.SpecimenContainedPreference.ALTERNATE);
                  break;
              default:
                  tgt.setValue(SpecimenDefinition.SpecimenContainedPreference.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference> convertSpecimenContainedPreference(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SpecimenDefinition.SpecimenContainedPreference> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreference> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenContainedPreferenceEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent convertSpecimenDefinitionTypeTestedContainerComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent tgt = new org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMinimumVolume())
      tgt.setMinimumVolume(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMinimumVolume()));
    for (org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent t : src.getAdditive())
      tgt.addAdditive(convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(t));
    if (src.hasPreparation())
      tgt.setPreparationElement(String43_N.convertStringToMarkdown(src.getPreparationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent convertSpecimenDefinitionTypeTestedContainerComponent(org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMinimumVolume())
      tgt.setMinimumVolume(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMinimumVolume()));
    for (org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent t : src.getAdditiveList())
      tgt.addAdditive(convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(t));
    if (src.hasPreparation())
      tgt.setPreparationElement(String43_N.convertString(src.getPreparationElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent tgt = new org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent convertSpecimenDefinitionTypeTestedContainerAdditiveComponent(org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedContainerAdditiveComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent convertSpecimenDefinitionTypeTestedHandlingComponent(org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent tgt = new org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTemperatureQualifier())
      tgt.setTemperatureQualifier(CodeableConcept43_N.convertCodeableConcept(src.getTemperatureQualifier()));
    if (src.hasTemperatureRange())
      tgt.setTemperatureRange(Range43_N.convertRange(src.getTemperatureRange()));
    if (src.hasMaxDuration())
      tgt.setMaxDuration(Duration43_N.convertDuration(src.getMaxDuration()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_N.convertStringToMarkdown(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent convertSpecimenDefinitionTypeTestedHandlingComponent(org.hl7.fhir.model.core.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent tgt = new org.hl7.fhir.r4b.model.SpecimenDefinition.SpecimenDefinitionTypeTestedHandlingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTemperatureQualifier())
      tgt.setTemperatureQualifier(CodeableConcept43_N.convertCodeableConcept(src.getTemperatureQualifier()));
    if (src.hasTemperatureRange())
      tgt.setTemperatureRange(Range43_N.convertRange(src.getTemperatureRange()));
    if (src.hasMaxDuration())
      tgt.setMaxDuration(Duration43_N.convertDuration(src.getMaxDuration()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_N.convertString(src.getInstructionElement()));
    return tgt;
  }
}