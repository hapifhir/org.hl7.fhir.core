package org.hl7.fhir.convertors.advisors;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.advisors.support.ExpressionAdvisor50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Expression50Test {

  @Test
  @DisplayName("Test ValueExpression conversion R5 -> DSTU2, without advisor. Lossy conversion.")
  public void testValueExpressionConversion50_10() throws IOException {
    InputStream r5_stream = this.getClass().getResourceAsStream("/questionnaire_with_expression_50.json");
    org.hl7.fhir.r5.model.Questionnaire r5_input = (org.hl7.fhir.r5.model.Questionnaire) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_stream);

    InputStream r2_stream = this.getClass().getResourceAsStream("/questionnaire_with_omitted_expression_40_10.json");
    org.hl7.fhir.dstu2.model.Questionnaire r2_expected_output = (org.hl7.fhir.dstu2.model.Questionnaire) new org.hl7.fhir.dstu2.formats.JsonParser().parse(r2_stream);

    org.hl7.fhir.dstu2.model.Questionnaire convertedDstu2Questionnaire = (org.hl7.fhir.dstu2.model.Questionnaire) VersionConvertorFactory_10_50.convertResource(r5_input);

    org.hl7.fhir.dstu2.formats.JsonParser dstu2_parser = new org.hl7.fhir.dstu2.formats.JsonParser();
    String composeString1 = dstu2_parser.composeString(convertedDstu2Questionnaire);
    String composeString2 = dstu2_parser.composeString(r2_expected_output);
    System.out.println("Expected out ->\n"+ composeString2 + "\n\nActual out ->\n" + composeString1);

    Assertions.assertTrue(r2_expected_output.equalsDeep(convertedDstu2Questionnaire));
  }

  @Test
  @DisplayName("Ensure base advisor ignores Expression types and doesn't explode.")
  public void testBaseAdvisorExpressionIgnore() throws IOException {
    Expression exp = new Expression();
    exp.setExpression("x + y = z");
    Extension ext = new Extension();
    ext.setValue(exp);
    BaseAdvisor_10_50 baseAdvisor50 = new BaseAdvisor_10_50();
    Assertions.assertTrue(baseAdvisor50.ignoreExtension("", ext));
  }

  @Test
  @DisplayName("Test Advisor is used in Expression R5 -> DSTU3 conversion.")
  public void testAdvisorExpressionConversion50_10() throws IOException {
    InputStream r5_stream = this.getClass().getResourceAsStream("/questionnaire_with_expression_50.json");
    org.hl7.fhir.r5.model.Questionnaire r5_input = (org.hl7.fhir.r5.model.Questionnaire) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_stream);

    InputStream r2_stream = this.getClass().getResourceAsStream("/questionnaire_with_converted_expression_40_10.json");
    org.hl7.fhir.dstu2.model.Questionnaire r2_expected_output = (org.hl7.fhir.dstu2.model.Questionnaire) new org.hl7.fhir.dstu2.formats.JsonParser().parse(r2_stream);

    org.hl7.fhir.dstu2.model.Questionnaire convertedDstu2Questionnaire = (org.hl7.fhir.dstu2.model.Questionnaire) VersionConvertorFactory_10_50.convertResource(r5_input, new ExpressionAdvisor50());

    org.hl7.fhir.dstu2.formats.JsonParser dstu2_parser = new org.hl7.fhir.dstu2.formats.JsonParser();
    String composeString1 = dstu2_parser.composeString(convertedDstu2Questionnaire);
    String composeString2 = dstu2_parser.composeString(r2_expected_output);
    System.out.println("Expected out ->\n"+ composeString2 + "\n\nActual out ->\n" + composeString1);

    Assertions.assertTrue(r2_expected_output.equalsDeep(convertedDstu2Questionnaire));
  }
}
