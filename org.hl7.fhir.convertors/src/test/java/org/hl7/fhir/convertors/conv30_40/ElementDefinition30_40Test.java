package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.StringType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ElementDefinition30_40Test {

  @Test
  public void convertR4toDstu3Empty() {
    org.hl7.fhir.r4.model.ElementDefinition input = new org.hl7.fhir.r4.model.ElementDefinition();
    org.hl7.fhir.dstu3.model.ElementDefinition result = (org.hl7.fhir.dstu3.model.ElementDefinition) VersionConvertorFactory_30_40.convertType(input);

    assertNull(result);
  }

  @Test
  public void convertR4toDstu3ModifierReason() {
    org.hl7.fhir.r4.model.ElementDefinition input = new org.hl7.fhir.r4.model.ElementDefinition();
    input.setIsModifierReason("My Modifier");
    org.hl7.fhir.dstu3.model.ElementDefinition result = (org.hl7.fhir.dstu3.model.ElementDefinition) VersionConvertorFactory_30_40.convertType(input);

    assertNotNull(result);
    assertTrue(result.hasExtension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION));
    assertThat(result.getExtensionString(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION)).isEqualTo("My Modifier");
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  @ValueSource(strings = VersionConvertorConstants.EXT_MODIFIER_REASON_LEGACY)
  public void convertR4toDstu3InvalidModifierReason(String modifierReason) {
    org.hl7.fhir.r4.model.ElementDefinition input = new org.hl7.fhir.r4.model.ElementDefinition();
    input.setId("id");//set id to prevent complete null result
    input.setIsModifierReason(modifierReason);
    org.hl7.fhir.dstu3.model.ElementDefinition result = (org.hl7.fhir.dstu3.model.ElementDefinition) VersionConvertorFactory_30_40.convertType(input);

    assertNotNull(result);
    assertThat(result.getId()).isEqualTo("id");
    assertFalse(result.hasExtension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION));
  }

  @Test
  public void convertDstu3oR4Empty() {
    org.hl7.fhir.dstu3.model.ElementDefinition input = new org.hl7.fhir.dstu3.model.ElementDefinition();
    org.hl7.fhir.r4.model.ElementDefinition result = (org.hl7.fhir.r4.model.ElementDefinition) VersionConvertorFactory_30_40.convertType(input);

    assertNull(result);
  }


  @Test
  public void convertDstu3oR4ModifierReason() {
    org.hl7.fhir.dstu3.model.ElementDefinition input = new org.hl7.fhir.dstu3.model.ElementDefinition();
    input.setIsModifier(true);
    input.addExtension(new Extension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION, new StringType("my Modifier")));
    org.hl7.fhir.r4.model.ElementDefinition result = (org.hl7.fhir.r4.model.ElementDefinition) VersionConvertorFactory_30_40.convertType(input);

    assertNotNull(result);
    assertTrue(result.getIsModifier());
    assertThat(result.getIsModifierReason()).isEqualTo("my Modifier");
    assertFalse(result.hasExtension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION));
  }

  @Test
  public void convertDstu3oR4ModifierReasonModifierFalse() {
    org.hl7.fhir.dstu3.model.ElementDefinition input = new org.hl7.fhir.dstu3.model.ElementDefinition();
    input.setIsModifier(false);
    input.addExtension(new Extension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION, new StringType("my Modifier")));
    org.hl7.fhir.r4.model.ElementDefinition result = (org.hl7.fhir.r4.model.ElementDefinition) VersionConvertorFactory_30_40.convertType(input);

    assertNotNull(result);
    assertFalse(result.getIsModifier());
    assertThat(result.getIsModifierReason()).isNull();
    assertFalse(result.hasExtension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION));
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  public void convertDstu3oR4ModifierReasonEmpty(String modifierValue) {
    org.hl7.fhir.dstu3.model.ElementDefinition input = new org.hl7.fhir.dstu3.model.ElementDefinition();
    input.setIsModifier(true);
    input.addExtension(new Extension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION, new StringType(modifierValue)));
    org.hl7.fhir.r4.model.ElementDefinition result = (org.hl7.fhir.r4.model.ElementDefinition) VersionConvertorFactory_30_40.convertType(input);

    assertNotNull(result);
    assertTrue(result.getIsModifier());
    assertThat(result.getIsModifierReason()).isEqualTo(VersionConvertorConstants.EXT_MODIFIER_REASON_LEGACY);
    assertFalse(result.hasExtension(VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION));
  }

}
