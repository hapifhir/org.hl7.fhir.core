package org.hl7.fhir.convertors.advisors;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.advisors.support.ExpressionAdvisor40;
import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Expression40Test {

  @Test
  @DisplayName("Test ValueExpression conversion R4 -> DSTU3, without advisor. Lossy conversion.")
  public void testValueExpressionConversion40_10() throws IOException {
    InputStream r4_stream = this.getClass().getResourceAsStream("/questionnaire_with_expression_40.json");
    org.hl7.fhir.r4.model.Questionnaire r4_input = (org.hl7.fhir.r4.model.Questionnaire) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_stream);

    InputStream r2_stream = this.getClass().getResourceAsStream("/questionnaire_with_omitted_expression_40_10.json");
    org.hl7.fhir.dstu2.model.Questionnaire r2_expected_output = (org.hl7.fhir.dstu2.model.Questionnaire) new org.hl7.fhir.dstu2.formats.JsonParser().parse(r2_stream);

    org.hl7.fhir.dstu2.model.Questionnaire convertedDstu2Questionnaire = (org.hl7.fhir.dstu2.model.Questionnaire) VersionConvertor_10_40.convertResource(r4_input);

    org.hl7.fhir.dstu2.formats.JsonParser dstu2_parser = new org.hl7.fhir.dstu2.formats.JsonParser();
    String composeString1 = dstu2_parser.composeString(convertedDstu2Questionnaire);
    String composeString2 = dstu2_parser.composeString(r2_expected_output);
    System.out.println("Expected out ->\n"+ composeString2 + "\n\nActual out ->\n" + composeString1);

    Assertions.assertTrue(r2_expected_output.equalsDeep(convertedDstu2Questionnaire));
  }

  @Test
  @DisplayName("Ensure base advisor ignores Expression types and doesn't explode.")
  public void testBaseAdvisorExpressionIgore() throws IOException {
    Expression exp = new Expression();
    exp.setExpression("x + y = z");
    Extension ext = new Extension();
    ext.setValue(exp);
    BaseAdvisor_10_40 baseAdvisor1040 = new BaseAdvisor_10_40();
    Assertions.assertTrue(baseAdvisor1040.ignoreExtension("", ext));
  }

  @Test
  @DisplayName("Test Advisor is used in Expression R4 -> DSTU3 conversion.")
  public void testAdvisorExpressionConversion40_10() throws IOException {
    InputStream r4_stream = this.getClass().getResourceAsStream("/questionnaire_with_expression_40.json");
    org.hl7.fhir.r4.model.Questionnaire r4_input = (org.hl7.fhir.r4.model.Questionnaire) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_stream);

    InputStream r2_stream = this.getClass().getResourceAsStream("/questionnaire_with_converted_expression_40_10.json");
    org.hl7.fhir.dstu2.model.Questionnaire r2_expected_output = (org.hl7.fhir.dstu2.model.Questionnaire) new org.hl7.fhir.dstu2.formats.JsonParser().parse(r2_stream);

    org.hl7.fhir.dstu2.model.Questionnaire convertedDstu2Questionnaire = (org.hl7.fhir.dstu2.model.Questionnaire) VersionConvertor_10_40.convertResource(r4_input, new ExpressionAdvisor40());

    org.hl7.fhir.dstu2.formats.JsonParser dstu2_parser = new org.hl7.fhir.dstu2.formats.JsonParser();
    String composeString1 = dstu2_parser.composeString(convertedDstu2Questionnaire);
    String composeString2 = dstu2_parser.composeString(r2_expected_output);
    System.out.println("Expected out ->\n"+ composeString2 + "\n\nActual out ->\n" + composeString1);

    Assertions.assertTrue(r2_expected_output.equalsDeep(convertedDstu2Questionnaire));
  }
}
