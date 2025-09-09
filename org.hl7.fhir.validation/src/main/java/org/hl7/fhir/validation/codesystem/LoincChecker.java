package org.hl7.fhir.validation.codesystem;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.CodeValidationRule;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyFilterType;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyOperation;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyValidationRules;

public class LoincChecker extends CodeSystemChecker {

  public LoincChecker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, settings, xverManager, errors, session);
  }
  

  @Override
  public void listPropertyNames(List<String> knownNames) {
    super.listPropertyNames(knownNames);
    addName(knownNames, "concept");
    addName(knownNames, "ancestor");
    addName(knownNames, "descendent");
    addName(knownNames, "parent");
    addName(knownNames, "child");
    addName(knownNames, "COMPONENT");
    addName(knownNames, "PROPERTY");
    addName(knownNames, "TIME_ASPCT");
    addName(knownNames, "SYSTEM");
    addName(knownNames, "SCALE_TYP");
    addName(knownNames, "METHOD_TYP");
    addName(knownNames, "CLASS");
    addName(knownNames, "VersionLastChanged");
    addName(knownNames, "CHNG_TYPE");
    addName(knownNames, "DefinitionDescription");
    addName(knownNames, "STATUS");
    addName(knownNames, "CLASSTYPE");
    addName(knownNames, "FORMULA");
    addName(knownNames, "EXMPL_ANSWERS");
    addName(knownNames, "SURVEY_QUEST_TEXT");
    addName(knownNames, "SURVEY_QUEST_SRC");
    addName(knownNames, "UNITSREQUIRED");
    addName(knownNames, "ORDER_OBS");
    addName(knownNames, "HL7_FIELD_SUBFIELD_ID");
    addName(knownNames, "EXTERNAL_COPYRIGHT_NOTICE");
    addName(knownNames, "EXAMPLE_UNITS");
    addName(knownNames, "EXAMPLE_UCUM_UNITS");
    addName(knownNames, "STATUS_REASON");
    addName(knownNames, "STATUS_TEXT");
    addName(knownNames, "CHANGE_REASON_PUBLIC");
    addName(knownNames, "COMMON_TEST_RANK");
    addName(knownNames, "COMMON_ORDER_RANK");
    addName(knownNames, "HL7_ATTACHMENT_STRUCTURE");
    addName(knownNames, "EXTERNAL_COPYRIGHT_LINK");
    addName(knownNames, "PanelType");
    addName(knownNames, "AskAtOrderEntry");
    addName(knownNames, "AssociatedObservations");
    addName(knownNames, "VersionFirstReleased");
    addName(knownNames, "ValidHL7AttachmentRequest");
    addName(knownNames, "answer-list");
    addName(knownNames, "MAP_TO");
    addName(knownNames, "analyte");
    addName(knownNames, "analyte-core");
    addName(knownNames, "analyte-suffix");
    addName(knownNames, "analyte-numerator");
    addName(knownNames, "analyte-divisor");
    addName(knownNames, "analyte-divisor-suffix");
    addName(knownNames, "challenge");
    addName(knownNames, "adjustment");
    addName(knownNames, "count");
    addName(knownNames, "time-core");
    addName(knownNames, "time-modifier");
    addName(knownNames, "system-core");
    addName(knownNames, "super-system");
    addName(knownNames, "analyte-gene");
    addName(knownNames, "category");
    addName(knownNames, "search");
    addName(knownNames, "rad-modality-modality-type");
    addName(knownNames, "rad-modality-modality-subtype");
    addName(knownNames, "rad-anatomic-location-region-imaged");
    addName(knownNames, "rad-anatomic-location-imaging-focus");
    addName(knownNames, "rad-anatomic-location-laterality-presence");
    addName(knownNames, "rad-anatomic-location-laterality");
    addName(knownNames, "rad-view-aggregation");
    addName(knownNames, "rad-view-view-type");
    addName(knownNames, "rad-maneuver-maneuver-type");
    addName(knownNames, "rad-timing");
    addName(knownNames, "rad-pharmaceutical-substance-given");
    addName(knownNames, "rad-pharmaceutical-route");
    addName(knownNames, "rad-reason-for-exam");
    addName(knownNames, "rad-guidance-for-presence");
    addName(knownNames, "rad-guidance-for-approach");
    addName(knownNames, "rad-guidance-for-action");
    addName(knownNames, "rad-guidance-for-object");
    addName(knownNames, "rad-subject");
    addName(knownNames, "document-kind");
    addName(knownNames, "document-role");
    addName(knownNames, "document-setting");
    addName(knownNames, "document-subject-matter-domain");
    addName(knownNames, "document-type-of-service");
    addName(knownNames, "answers-for");
    addName(knownNames, "answer");
    addName(knownNames, "answer-list");

  }

  @Override
  public PropertyValidationRules rulesForFilter(String property, EnumSet<PropertyOperation> ops) {
    if (Utilities.existsInList(property, 
        "ancestor",
        "descendent",
        "parent",
        "child",
        "COMPONENT",
        "PROPERTY",
        "TIME_ASPCT",
        "SYSTEM",
        "SCALE_TYP",
        "METHOD_TYP",
        "CLASS",
        "answer-list",
        "MAP_TO",
        "analyte",
        "analyte-core",
        "analyte-suffix",
        "analyte-numerator",
        "analyte-divisor",
        "analyte-divisor-suffix",
        "challenge",
        "adjustment",
        "count",
        "time-core",
        "time-modifier",
        "system-core",
        "super-system",
        "analyte-gene",
        "category",
        "search",
        "rad-modality-modality-type",
        "rad-modality-modality-subtype",
        "rad-anatomic-location-region-imaged",
        "rad-anatomic-location-imaging-focus",
        "rad-anatomic-location-laterality-presence",
        "rad-anatomic-location-laterality",
        "rad-view-aggregation",
        "rad-view-view-type",
        "rad-maneuver-maneuver-type",
        "rad-timing",
        "rad-pharmaceutical-substance-given",
        "rad-pharmaceutical-route",
        "rad-reason-for-exam",
        "rad-guidance-for-presence",
        "rad-guidance-for-approach",
        "rad-guidance-for-action",
        "rad-guidance-for-object",
        "rad-subject",
        "document-kind",
        "document-role",
        "document-setting",
        "document-subject-matter-domain",
        "document-type-of-service",
        "answers-for",
        "answer",
        "answer-list")) {
        return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, addToOps(ops, PropertyOperation.Equals, PropertyOperation.Exists, PropertyOperation.RegEx, PropertyOperation.In, PropertyOperation.NotIn)).setChange(true);      
      }
      
      if (Utilities.existsInList(property,
          "VersionLastChanged",
          "CHNG_TYPE",
          "DefinitionDescription",
          "STATUS",
          "CLASSTYPE",
          "FORMULA",
          "EXMPL_ANSWERS",
          "SURVEY_QUEST_TEXT",
          "SURVEY_QUEST_SRC",
          "UNITSREQUIRED",
          "ORDER_OBS",
          "HL7_FIELD_SUBFIELD_ID",
          "EXTERNAL_COPYRIGHT_NOTICE",
          "EXAMPLE_UNITS",
          "EXAMPLE_UCUM_UNITS",
          "STATUS_REASON",
          "STATUS_TEXT",
          "CHANGE_REASON_PUBLIC",
          "COMMON_TEST_RANK",
          "COMMON_ORDER_RANK",
          "HL7_ATTACHMENT_STRUCTURE",
          "EXTERNAL_COPYRIGHT_LINK",
          "PanelType",
          "AskAtOrderEntry",
          "AssociatedObservations",
          "VersionFirstReleased",
          "ValidHL7AttachmentRequest")) { 
        return new PropertyValidationRules(PropertyFilterType.String, CodeValidationRule.None, addToOps(ops, PropertyOperation.Equals, PropertyOperation.Exists, PropertyOperation.RegEx, PropertyOperation.In, PropertyOperation.NotIn));
      }

      if (Utilities.existsInList(property, 
        "STATUS")) { 
        return new PropertyValidationRules(PropertyFilterType.CodeList, CodeValidationRule.None, addToOps(ops, PropertyOperation.Equals, PropertyOperation.RegEx, PropertyOperation.In, PropertyOperation.NotIn))
            .setCodes("ACTIVE", "TRIAL", "DISCOURAGED", "DEPRECATED");
      }

      if (Utilities.existsInList(property, 
        "copyright")) {
        return new PropertyValidationRules(PropertyFilterType.CodeList, CodeValidationRule.None, addToOps(ops, PropertyOperation.Equals, PropertyOperation.RegEx, PropertyOperation.In, PropertyOperation.NotIn)).setCodes("LOINC", "3rdParty");      
      }

      if (Utilities.existsInList(property, 
        "concept")) {
        return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, addToOps(ops, PropertyOperation.Equals, PropertyOperation.IsA, PropertyOperation.IsNotA));      
      }
      if (Utilities.existsInList(property, 
          "code")) {
          return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, addToOps(ops, PropertyOperation.Equals, PropertyOperation.IsA, PropertyOperation.IsNotA));      
        }
      return null;
  }
}
