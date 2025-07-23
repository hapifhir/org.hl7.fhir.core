package org.hl7.fhir.convertors.conv30_40;


import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
  public void testTakenConversionWithoutStatusExtensions40To30() {
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
    assertThat(dstu3Converted.getReasonNotTaken(), is(empty()));
    assertThat(dstu3Converted.getReasonCode(), hasSize(1));
  }

  @Test
  public void testReasonCodeNotTaken40To30() {
    org.hl7.fhir.r4.model.MedicationStatement r4Actual = new org.hl7.fhir.r4.model.MedicationStatement();
    r4Actual.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN);
    r4Actual.addReasonCode(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "display")));

    org.hl7.fhir.dstu3.model.MedicationStatement dstu3Converted = (org.hl7.fhir.dstu3.model.MedicationStatement) VersionConvertorFactory_30_40.convertResource(r4Actual);
    Assertions.assertEquals(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.N, dstu3Converted.getTaken());
    assertThat(dstu3Converted.getReasonNotTaken(), hasSize(1));
    assertThat(dstu3Converted.getReasonCode(), is(empty()));
  }


}
