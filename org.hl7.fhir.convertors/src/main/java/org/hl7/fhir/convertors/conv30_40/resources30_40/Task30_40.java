package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException;

//Conversion based on mapping defined at https://hl7.org/fhir/R4/task-version-maps.html
//Note mapping says location should exist on dstu3, which is incorrect, so we are unable to map that field
public class Task30_40 {
  public static org.hl7.fhir.dstu3.model.Task convertTask(org.hl7.fhir.r4.model.Task src) throws FHIRException {
    if (src == null)
      return null;

    org.hl7.fhir.dstu3.model.Task tgt = new org.hl7.fhir.dstu3.model.Task();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);


    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    }
    if (src.hasInstantiatesUri()) {
      tgt.setDefinition(Uri30_40.convertUri(src.getInstantiatesUriElement()));
    } else if (src.hasInstantiatesCanonical()) {
      tgt.setDefinition(Reference30_40.convertCanonicalToReference(src.getInstantiatesCanonicalElement()));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_40.convertReference(t));
    }
    if (src.hasGroupIdentifier()) {
      tgt.setGroupIdentifier(Identifier30_40.convertIdentifier(src.getGroupIdentifier()));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) {
      tgt.addPartOf(Reference30_40.convertReference(t));
    }
    if (src.hasStatus()) {
      tgt.setStatus(org.hl7.fhir.dstu3.model.Task.TaskStatus.fromCode(src.getStatus().toCode()));
    }
    if (src.hasStatusReason()) {
      tgt.setStatusReason(CodeableConcept30_40.convertCodeableConcept(src.getStatusReason()));
    }
    if (src.hasBusinessStatus()) {
      tgt.setBusinessStatus(CodeableConcept30_40.convertCodeableConcept(src.getBusinessStatus()));
    }
    if (src.hasIntent()) {
      tgt.setIntent(org.hl7.fhir.dstu3.model.Task.TaskIntent.fromCode(src.getIntent().toCode()));
    }
    if (src.hasPriority()) {
      tgt.setPriority(org.hl7.fhir.dstu3.model.Task.TaskPriority.fromCode(src.getPriority().toCode()));
    }
    if (src.hasCode()) {
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    }
    if (src.hasDescription()) {
      tgt.setDescription(src.getDescription());
    }
    if (src.hasFocus()) {
      tgt.setFocus(Reference30_40.convertReference(src.getFocus()));
    }
    if (src.hasFor()) {
      tgt.setFor(Reference30_40.convertReference(src.getFor()));
    }
    if (src.hasEncounter()) {
      tgt.setContext(Reference30_40.convertReference(src.getEncounter()));
    }
    if (src.hasExecutionPeriod()) {
      tgt.setExecutionPeriod(Period30_40.convertPeriod(src.getExecutionPeriod()));
    }
    if (src.hasAuthoredOn()) {
      tgt.setAuthoredOnElement(DateTime30_40.convertDateTime(src.getAuthoredOnElement()));
    }
    if (src.hasLastModified()) {
      tgt.setLastModifiedElement(DateTime30_40.convertDateTime(src.getLastModifiedElement()));
    }
    if (src.hasRequester()) {
      tgt.setRequester(new org.hl7.fhir.dstu3.model.Task.TaskRequesterComponent(Reference30_40.convertReference(src.getRequester())));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPerformerType()) {
      tgt.addPerformerType(CodeableConcept30_40.convertCodeableConcept(t));
    }
    if (src.hasOwner()) {
      tgt.setOwner(Reference30_40.convertReference(src.getOwner()));
    }
    if (src.hasReasonCode()) {
      tgt.setReason(CodeableConcept30_40.convertCodeableConcept(src.getReasonCode()));
    }
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory()) {
      tgt.addRelevantHistory(Reference30_40.convertReference(t));
    }
    if (src.hasRestriction()) {
      tgt.setRestriction(convertTaskRestriction(src.getRestriction()));
    }
    for (org.hl7.fhir.r4.model.Task.ParameterComponent t : src.getInput()) {
      tgt.addInput(convertTaskParameter(t));
    }
    for (org.hl7.fhir.r4.model.Task.TaskOutputComponent t : src.getOutput()) {
      tgt.addOutput(convertTaskOutput(t));
    }

    return tgt;
  }


  public static org.hl7.fhir.r4.model.Task convertTask(org.hl7.fhir.dstu3.model.Task src) throws FHIRException {
    if (src == null)
      return null;

    org.hl7.fhir.r4.model.Task tgt = new org.hl7.fhir.r4.model.Task();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);


    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    }
    if (src.hasDefinition()) {
      if (src.getDefinition() instanceof org.hl7.fhir.dstu3.model.Reference) {
        tgt.setInstantiatesCanonicalElement(Reference30_40.convertReferenceToCanonical((org.hl7.fhir.dstu3.model.Reference) src.getDefinition()));
      } else if (src.getDefinition() instanceof org.hl7.fhir.dstu3.model.UriType) {
        tgt.setInstantiatesUriElement(Uri30_40.convertUri((org.hl7.fhir.dstu3.model.UriType) src.getDefinition()));
      }
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_40.convertReference(t));
    }
    if (src.hasGroupIdentifier()) {
      tgt.setGroupIdentifier(Identifier30_40.convertIdentifier(src.getGroupIdentifier()));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) {
      tgt.addPartOf(Reference30_40.convertReference(t));
    }
    if (src.hasStatus()) {
      tgt.setStatus(org.hl7.fhir.r4.model.Task.TaskStatus.fromCode(src.getStatus().toCode()));
    }
    if (src.hasStatusReason()) {
      tgt.setStatusReason(CodeableConcept30_40.convertCodeableConcept(src.getStatusReason()));
    }
    if (src.hasBusinessStatus()) {
      tgt.setBusinessStatus(CodeableConcept30_40.convertCodeableConcept(src.getBusinessStatus()));
    }
    if (src.hasIntent()) {
      tgt.setIntent(org.hl7.fhir.r4.model.Task.TaskIntent.fromCode(src.getIntent().toCode()));
    }
    if (src.hasPriority()) {
      tgt.setPriority(org.hl7.fhir.r4.model.Task.TaskPriority.fromCode(src.getPriority().toCode()));
    }
    if (src.hasCode()) {
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    }
    if (src.hasDescription()) {
      tgt.setDescription(src.getDescription());
    }
    if (src.hasFocus()) {
      tgt.setFocus(Reference30_40.convertReference(src.getFocus()));
    }
    if (src.hasFor()) {
      tgt.setFor(Reference30_40.convertReference(src.getFor()));
    }
    if (src.hasContext()) {
      tgt.setEncounter(Reference30_40.convertReference(src.getContext()));
    }
    if (src.hasExecutionPeriod()) {
      tgt.setExecutionPeriod(Period30_40.convertPeriod(src.getExecutionPeriod()));
    }
    if (src.hasAuthoredOn()) {
      tgt.setAuthoredOnElement(DateTime30_40.convertDateTime(src.getAuthoredOnElement()));
    }
    if (src.hasLastModified()) {
      tgt.setLastModifiedElement(DateTime30_40.convertDateTime(src.getLastModifiedElement()));
    }
    if (src.hasRequester() && src.getRequester().hasAgent()) {
      tgt.setRequester(Reference30_40.convertReference(src.getRequester().getAgent()));
    }
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPerformerType()) {
      tgt.addPerformerType(CodeableConcept30_40.convertCodeableConcept(t));
    }
    if (src.hasOwner()) {
      tgt.setOwner(Reference30_40.convertReference(src.getOwner()));
    }
    if (src.hasReason()) {
      tgt.setReasonCode(CodeableConcept30_40.convertCodeableConcept(src.getReason()));
    }
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRelevantHistory()) {
      tgt.addRelevantHistory(Reference30_40.convertReference(t));
    }
    if (src.hasRestriction()) {
      tgt.setRestriction(convertTaskRestriction(src.getRestriction()));
    }
    for (org.hl7.fhir.dstu3.model.Task.ParameterComponent t : src.getInput()) {
      tgt.addInput(convertTaskParameter(t));
    }
    for (org.hl7.fhir.dstu3.model.Task.TaskOutputComponent t : src.getOutput()) {
      tgt.addOutput(convertTaskOutput(t));
    }

    return tgt;
  }


  private static org.hl7.fhir.dstu3.model.Task.TaskRestrictionComponent convertTaskRestriction(org.hl7.fhir.r4.model.Task.TaskRestrictionComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.dstu3.model.Task.TaskRestrictionComponent tgt = new org.hl7.fhir.dstu3.model.Task.TaskRestrictionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasRepetitions()) {
      tgt.setRepetitions(src.getRepetitions());
    }
    if (src.hasPeriod()) {
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) {
      tgt.addRecipient(Reference30_40.convertReference(t));
    }

    return tgt;
  }

  private static org.hl7.fhir.r4.model.Task.TaskRestrictionComponent convertTaskRestriction(org.hl7.fhir.dstu3.model.Task.TaskRestrictionComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.r4.model.Task.TaskRestrictionComponent tgt = new org.hl7.fhir.r4.model.Task.TaskRestrictionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasRepetitions()) {
      tgt.setRepetitions(src.getRepetitions());
    }
    if (src.hasPeriod()) {
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) {
      tgt.addRecipient(Reference30_40.convertReference(t));
    }

    return tgt;
  }


  private static org.hl7.fhir.dstu3.model.Task.ParameterComponent convertTaskParameter(org.hl7.fhir.r4.model.Task.ParameterComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.dstu3.model.Task.ParameterComponent tgt = new org.hl7.fhir.dstu3.model.Task.ParameterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasType()) {
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    }
    if (src.hasValue()) {
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    }

    return tgt;
  }

  private static org.hl7.fhir.r4.model.Task.ParameterComponent convertTaskParameter(org.hl7.fhir.dstu3.model.Task.ParameterComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.r4.model.Task.ParameterComponent tgt = new org.hl7.fhir.r4.model.Task.ParameterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasType()) {
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    }
    if (src.hasValue()) {
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    }

    return tgt;
  }

  private static org.hl7.fhir.dstu3.model.Task.TaskOutputComponent convertTaskOutput(org.hl7.fhir.r4.model.Task.TaskOutputComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.dstu3.model.Task.TaskOutputComponent tgt = new org.hl7.fhir.dstu3.model.Task.TaskOutputComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasType()) {
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    }
    if (src.hasValue()) {
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    }

    return tgt;
  }

  private static org.hl7.fhir.r4.model.Task.TaskOutputComponent convertTaskOutput(org.hl7.fhir.dstu3.model.Task.TaskOutputComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.r4.model.Task.TaskOutputComponent tgt = new org.hl7.fhir.r4.model.Task.TaskOutputComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasType()) {
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    }
    if (src.hasValue()) {
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    }

    return tgt;
  }


}
