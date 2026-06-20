package org.hl7.fhir.convertors.conv30_40;


import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class MedicationStatement30_40Test {

  @Test
  public void convertMedicationStatement30to40() throws IOException {

    InputStream dstu3InputJson = this.getClass().getResourceAsStream("/medication_statement_30.json");
    InputStream r4ExpectedOutputJson = this.getClass().getResourceAsStream("/medication_statement_30_converted_to_40.json");

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3Actual = (org.hl7.fhir.dstu3.model.MedicationStatement) new org.hl7.fhir.dstu3.formats.JsonParser().parse(dstu3InputJson);
    org.hl7.fhir.r4.model.Resource r4Converted = VersionConvertorFactory_30_40.convertResource(dstu3Actual);

    org.hl7.fhir.r4.formats.JsonParser r4Parser = new org.hl7.fhir.r4.formats.JsonParser();
    org.hl7.fhir.r4.model.Resource r4Expected = r4Parser.parse(r4ExpectedOutputJson);

    Assertions.assertTrue(r4Expected.equalsDeep(r4Converted),
      "Failed comparing\n" + r4Parser.composeString(r4Expected) + "\nand\n" + r4Parser.composeString(r4Converted));
  }


  //    src.status where (src.taken in ('n' | 'unk')).not() -> tgt.status;
  //    src.taken where value = 'n' -> tgt.status = 'not-taken';
  //    src.taken where value = 'unk' -> tgt.status = 'unknown';
  private static Stream<Arguments> statusTakenConversionInput30To40() {
    return Stream.of(
      Arguments.of(
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ACTIVE,
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.Y,
        org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE),
      Arguments.of(
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ONHOLD,
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.NA,
        org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ONHOLD),
      Arguments.of(
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ACTIVE,
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.N,
        org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN),
      Arguments.of(
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ACTIVE,
        org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.UNK,
        org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.UNKNOWN)
    );
  }

  @ParameterizedTest
  @MethodSource("statusTakenConversionInput30To40")
  public void testStatusConversion30To40(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus statusInput,
                                         org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken takenInput,
                                         org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus expectedOutput) {

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3 = new org.hl7.fhir.dstu3.model.MedicationStatement();
    dstu3.setStatus(statusInput);
    dstu3.setTaken(takenInput);

    org.hl7.fhir.r4.model.MedicationStatement r4result = (org.hl7.fhir.r4.model.MedicationStatement) VersionConvertorFactory_30_40.convertResource(dstu3);
    Assertions.assertEquals(expectedOutput, r4result.getStatus());

    Assertions.assertTrue(r4result.hasExtension(VersionConvertorConstants.EXT_MED_STAT_STATUS));
    org.hl7.fhir.r4.model.Extension statusExtension = r4result.getExtensionByUrl(VersionConvertorConstants.EXT_MED_STAT_STATUS);
    org.hl7.fhir.r4.model.StringType statusExtensionValue = Assertions.assertInstanceOf(org.hl7.fhir.r4.model.StringType.class, statusExtension.getValue());
    Assertions.assertEquals(statusInput.toCode(), statusExtensionValue.getValue());


    Assertions.assertTrue(r4result.hasExtension(VersionConvertorConstants.EXT_MED_STAT_TAKEN));
    org.hl7.fhir.r4.model.Extension takenExtension = r4result.getExtensionByUrl(VersionConvertorConstants.EXT_MED_STAT_TAKEN);
    org.hl7.fhir.r4.model.StringType takenExtensionValue = Assertions.assertInstanceOf(org.hl7.fhir.r4.model.StringType.class, takenExtension.getValue());
    Assertions.assertEquals(takenInput.toCode(), takenExtensionValue.getValue());
  }


  @Test
  public void convertMedicationStatement40to30() throws IOException {
    InputStream r4InputJson = this.getClass().getResourceAsStream("/medication_statement_40.json");
    InputStream dstu3ExpectedOutputJson = this.getClass().getResourceAsStream("/medication_statement_40_converted_to_30.json");

    org.hl7.fhir.r4.model.MedicationStatement r4Actual = (org.hl7.fhir.r4.model.MedicationStatement) new org.hl7.fhir.r4.formats.JsonParser().parse(r4InputJson);
    org.hl7.fhir.dstu3.model.Resource dstu3Converted = VersionConvertorFactory_30_40.convertResource(r4Actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3Parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3Expected = dstu3Parser.parse(dstu3ExpectedOutputJson);

    Assertions.assertTrue(dstu3Expected.equalsDeep(dstu3Converted),
      "Failed comparing\n" + dstu3Parser.composeString(dstu3Expected) + "\nand\n" + dstu3Parser.composeString(dstu3Converted));
  }


  @Test
  public void testStatusConversion40To30() {
    org.hl7.fhir.r4.model.MedicationStatement r4Actual = new org.hl7.fhir.r4.model.MedicationStatement();
    r4Actual.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE);

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3Converted = (org.hl7.fhir.dstu3.model.MedicationStatement) VersionConvertorFactory_30_40.convertResource(r4Actual);
    Assertions.assertEquals(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ACTIVE, dstu3Converted.getStatus());
    Assertions.assertNull(dstu3Converted.getTaken());
  }

  @Test
  public void testStatusConversionWithExtensions40To30() {
    org.hl7.fhir.r4.model.MedicationStatement r4Actual = new org.hl7.fhir.r4.model.MedicationStatement();
    r4Actual.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_STAT_STATUS,
      new org.hl7.fhir.r4.model.StringType(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.INTENDED.toCode())));
    r4Actual.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_STAT_TAKEN,
      new org.hl7.fhir.r4.model.StringType(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.UNK.toCode())));
    //Also set status to a different value, to test the extension gets priority in conversion
    r4Actual.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE);

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3Converted = (org.hl7.fhir.dstu3.model.MedicationStatement) VersionConvertorFactory_30_40.convertResource(r4Actual);
    Assertions.assertEquals(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.INTENDED, dstu3Converted.getStatus());
    Assertions.assertEquals(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.UNK, dstu3Converted.getTaken());
    Assertions.assertFalse(dstu3Converted.hasExtension(VersionConvertorConstants.EXT_MED_STAT_STATUS));
    Assertions.assertFalse(dstu3Converted.hasExtension(VersionConvertorConstants.EXT_MED_STAT_TAKEN));
  }

  @Test
  void testTakenConversionWithoutStatusExtensions40To30() {
    org.hl7.fhir.r4.model.MedicationStatement r4Actual = new org.hl7.fhir.r4.model.MedicationStatement();
    r4Actual.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_STAT_TAKEN,
      new org.hl7.fhir.r4.model.StringType(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.UNK.toCode())));

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3Converted = (org.hl7.fhir.dstu3.model.MedicationStatement) VersionConvertorFactory_30_40.convertResource(r4Actual);
    Assertions.assertNull(dstu3Converted.getStatus());
    Assertions.assertNull(dstu3Converted.getTaken());
    Assertions.assertFalse(dstu3Converted.hasExtension(VersionConvertorConstants.EXT_MED_STAT_STATUS));
    Assertions.assertFalse(dstu3Converted.hasExtension(VersionConvertorConstants.EXT_MED_STAT_TAKEN));
  }

  @Test
  public void testReasonCode40To30() {
    org.hl7.fhir.r4.model.MedicationStatement r4Actual = new org.hl7.fhir.r4.model.MedicationStatement();
    r4Actual.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
    r4Actual.addReasonCode(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "display")));

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3Converted = (org.hl7.fhir.dstu3.model.MedicationStatement) VersionConvertorFactory_30_40.convertResource(r4Actual);
    Assertions.assertNull(dstu3Converted.getTaken());
    assertThat(dstu3Converted.getReasonNotTaken()).isEmpty();
    assertThat(dstu3Converted.getReasonCode()).hasSize(1);
  }

  @Test
  public void testReasonCodeNotTaken40To30() {
    org.hl7.fhir.r4.model.MedicationStatement r4Actual = new org.hl7.fhir.r4.model.MedicationStatement();
    r4Actual.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN);
    r4Actual.addReasonCode(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "display")));

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3Converted = (org.hl7.fhir.dstu3.model.MedicationStatement) VersionConvertorFactory_30_40.convertResource(r4Actual);
    Assertions.assertEquals(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.N, dstu3Converted.getTaken());
    assertThat(dstu3Converted.getReasonNotTaken()).hasSize(1);
    assertThat(dstu3Converted.getReasonCode()).isEmpty();
  }


}
