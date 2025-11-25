package org.hl7.fhir.validation.cli.param;

import org.hl7.fhir.validation.cli.param.parsers.ModularParameterParser;
import org.hl7.fhir.validation.cli.param.parsers.ValidationEngineParametersParser;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModularParameterParserTest {
  @Test
  void testModularParser(){
    ModularParameterParser parser = new ModularParameterParser(List.of(new ValidationEngineParametersParser()));
    String[] argArray = new String[]{"-native"};
    parser.parseArgs(Arg.of(argArray));
    ValidationEngineParametersParser validationEngineParametersParser = (ValidationEngineParametersParser) parser.getParser(ValidationEngineParametersParser.class);
    ValidationEngineParameters parameters = validationEngineParametersParser.getParameterObject();
    assertThat(parameters.isDoNative()).isTrue();
  }
}
