package org.hl7.fhir.r5.terminologies.expansion;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.regex.RegexTimeout;

@MarkedToMoveToAdjunctPackage
public class RegexFilter extends ConceptFilter {

  private String regex;
  
  protected RegexFilter(List<String> allErrors, String regex) {
    super(allErrors);
    this.regex = regex;
  }

  @Override
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    // the regex comes from the ValueSet filter value - user-supplied at runtime - so it is
    // evaluated through RegexTimeout, which bounds evaluation of pathological patterns
    try {
      return RegexTimeout.matches(def.getCode(), regex);
    } catch (TimeoutException e) {
      throw fail("The regex filter '"+regex+"' took too long to evaluate against code '"+def.getCode()+"'");
    } catch (RuntimeException e) {
      // RegexTimeout wraps evaluation failures (e.g. an invalid pattern) in a RuntimeException
      throw fail("Error evaluating the regex filter '"+regex+"' against code '"+def.getCode()+"': "+e.getMessage());
    }
  }
}
