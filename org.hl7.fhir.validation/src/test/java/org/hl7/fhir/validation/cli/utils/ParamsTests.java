package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.validation.cli.model.CliContext;
import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ParamsTests {
  @Test
  void testLocale() throws Exception {
    CliContext cliContext = Params.loadCliContext(new String[]{"-locale", "de"});
    assertEquals(Locale.GERMAN, cliContext.getLocale());
  }
}