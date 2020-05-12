package org.hl7.fhir.validation;

import static org.apache.commons.lang3.StringUtils.isBlank;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



/*
Copyright (c) 2011+, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

 */
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

public class BaseValidator {

  protected Source source;
  protected IWorkerContext context;
  protected TimeTracker timeTracker = new TimeTracker();


  public BaseValidator(IWorkerContext context){
    this.context = context;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#FATAL} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  @Deprecated
  protected boolean fail(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String msg) {
    if (!thePass) {
      addValidationMessage(errors, type, line, col, path, msg, IssueSeverity.FATAL, null);
    }
    return thePass;
  }

  protected boolean fail(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String msg = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, line, col, path, msg, IssueSeverity.FATAL, theMessage);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#FATAL} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  @Deprecated
  protected boolean fail(List<ValidationMessage> errors, IssueType type, List<String> pathParts, boolean thePass, String msg) {
    if (!thePass) {
      String path = toPath(pathParts);
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.FATAL, null);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#FATAL} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  @Deprecated
  protected boolean fail(List<ValidationMessage> errors, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String path = toPath(pathParts);
      addValidationMessage(errors, type, -1, -1, path, context.formatMessage(theMessage, theMessageArguments), IssueSeverity.FATAL, theMessage);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#FATAL} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  @Deprecated
  protected boolean fail(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass) {
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.FATAL, null);
    }
    return thePass;
  }
  //TODO: i18n
  protected boolean grammarWord(String w) {
    return w.equals("and") || w.equals("or") || w.equals("a") || w.equals("the") || w.equals("for") || w.equals("this") || w.equals("that") || w.equals("of");
  }

  /**
   * Test a rule and add a {@link IssueSeverity#INFORMATION} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean hint(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String msg) {
    if (!thePass) {
      String message = context.formatMessage(msg);
      addValidationMessage(errors, type, line, col, path, message, IssueSeverity.INFORMATION, msg);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#INFORMATION} validation message if the validation fails. And mark it as a slicing hint for later recovery if appropriate
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  //FIXME: formatMessage should be done here
  protected boolean slicingHint(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String msg, String html) {
    if (!thePass) {
      addValidationMessage(errors, type, line, col, path, msg, IssueSeverity.INFORMATION, null).setSlicingHint(true).setSliceHtml(html);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#INFORMATION} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean hint(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, line, col, path, message, IssueSeverity.INFORMATION, theMessage);
    }
    return thePass;
  }

  protected boolean txHint(List<ValidationMessage> errors, String txLink, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, line, col, path, message, IssueSeverity.INFORMATION, Source.TerminologyEngine, theMessage).setTxLink(txLink);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#INFORMATION} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean hint(List<ValidationMessage> errors, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, -1, -1, path, message, IssueSeverity.INFORMATION, theMessage);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#INFORMATION} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean hint(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass) {
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.INFORMATION, null);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#ERROR} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean rule(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, line, col, path, message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  protected boolean txRule(List<ValidationMessage> errors, String txLink, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      errors.add(new ValidationMessage(Source.TerminologyEngine, type, line, col, path, message, IssueSeverity.ERROR).setTxLink(txLink));
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#ERROR} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean rule(List<ValidationMessage> errors, IssueType type, List<String> pathParts, boolean thePass, String msg) {
    if (!thePass) {
      String path = toPath(pathParts);
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.ERROR, null);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#ERROR} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean rule(List<ValidationMessage> errors, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, -1, -1, path, message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#ERROR} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */

  //todo: delete this when finished i18n
  protected boolean rule(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass) {
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.ERROR, null);
    }
    return thePass;
  }

  protected boolean rule(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, -1, -1, path, message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  public boolean rule(List<ValidationMessage> errors, Source source, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass) {
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.ERROR, source, null);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#ERROR} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean rule(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg, String html) {
    if (!thePass) {
      msg = context.formatMessage(msg, null);
      html = context.formatMessage(html, null);
      addValidationMessage(errors, type, path, msg, html, IssueSeverity.ERROR, null);
    }
    return thePass;
  }

  protected String splitByCamelCase(String s) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isUpperCase(c) && !(i == 0 || Character.isUpperCase(s.charAt(i-1))))
        b.append(' ');
      b.append(c);
    }
    return b.toString();
  }

  protected String stripPunctuation(String s, boolean numbers) {
    StringBuilder b = new StringBuilder();
    for (char c : s.toCharArray()) {
      int t = Character.getType(c);
      if (t == Character.UPPERCASE_LETTER || t == Character.LOWERCASE_LETTER || t == Character.TITLECASE_LETTER || t == Character.MODIFIER_LETTER || t == Character.OTHER_LETTER || (t == Character.DECIMAL_DIGIT_NUMBER && numbers) || (t == Character.LETTER_NUMBER && numbers) || c == ' ')
        b.append(c);
    }
    return b.toString();
  }

  private String toPath(List<String> pathParts) {
    if (pathParts == null || pathParts.isEmpty()) {
      return "";
    }
    return "//" + StringUtils.join(pathParts, '/');
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean warning(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      IssueSeverity severity = IssueSeverity.WARNING;
      addValidationMessage(errors, type, line, col, path, nmsg, severity, msg);
    }
    return thePass;

  }

  protected ValidationMessage addValidationMessage(List<ValidationMessage> errors, IssueType type, int line, int col, String path, String msg, IssueSeverity theSeverity, String id) {
    Source source = this.source;
    return addValidationMessage(errors, type, line, col, path, msg, theSeverity, source, id);
  }

  protected ValidationMessage addValidationMessage(List<ValidationMessage> errors, IssueType type, int line, int col, String path, String msg, IssueSeverity theSeverity, Source theSource, String id) {
    ValidationMessage validationMessage = new ValidationMessage(theSource, type, line, col, path, msg, theSeverity).setMessageId(id);
    errors.add(validationMessage);
    return validationMessage;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean txWarning(List<ValidationMessage> errors, String txLink, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      errors.add(new ValidationMessage(Source.TerminologyEngine, type, line, col, path, nmsg, IssueSeverity.WARNING).setTxLink(txLink).setMessageId(msg));
    }
    return thePass;

  }

  protected boolean warningOrError(boolean isError, List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, type, line, col, path, nmsg, isError ? IssueSeverity.ERROR : IssueSeverity.WARNING, msg);
    }
    return thePass;

  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean warning(List<ValidationMessage> errors, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, -1, -1, path, message, IssueSeverity.WARNING, theMessage);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean warning(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass) {
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.WARNING, null);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean warning(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg, String html) {
    if (!thePass) {
      addValidationMessage(errors, type, path, msg, html, IssueSeverity.WARNING, null);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean warning(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg, String html, Object... theMessageArguments) {
    if (!thePass) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, type, path, nmsg, html, IssueSeverity.WARNING, msg);
    }
    return thePass;
  }

  //---------
  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean suppressedwarning(List<ValidationMessage> errors, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass) { 
      String nmsg = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, type, line, col, path, nmsg, IssueSeverity.INFORMATION, msg);
    }
    return thePass;

  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean suppressedwarning(List<ValidationMessage> errors, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, type, -1, -1, path, message, IssueSeverity.INFORMATION, theMessage);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean suppressedwarning(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass) {
      addValidationMessage(errors, type, -1, -1, path, msg, IssueSeverity.INFORMATION, null);
    }
    return thePass;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean suppressedwarning(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg, String html) {
    if (!thePass) {
      IssueSeverity severity = IssueSeverity.INFORMATION;
      addValidationMessage(errors, type, path, msg, html, severity, null);
    }
    return thePass;
  }

  protected void addValidationMessage(List<ValidationMessage> errors, IssueType type, String path, String msg, String html, IssueSeverity theSeverity, String id) {
    errors.add(new ValidationMessage(source, type, -1, -1, path, msg, html, theSeverity).setMessageId(id));
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean suppressedwarning(List<ValidationMessage> errors, IssueType type, String path, boolean thePass, String msg, String html, Object... theMessageArguments) {
    if (!thePass) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, type, path, nmsg, html, IssueSeverity.INFORMATION, msg);
    }
    return thePass;
  }


  protected ValueSet resolveBindingReference(DomainResource ctxt, String reference, String uri) {
    if (reference != null) {
      if (reference.startsWith("#")) {
        for (Resource c : ctxt.getContained()) {
          if (c.getId().equals(reference.substring(1)) && (c instanceof ValueSet))
            return (ValueSet) c;
        }
        return null;
      } else {
        long t = System.nanoTime();
        ValueSet fr = context.fetchResource(ValueSet.class, reference);
        if (fr == null) {
          if (!Utilities.isAbsoluteUrl(reference)) {
            reference = resolve(uri, reference);
            fr = context.fetchResource(ValueSet.class, reference);
          }
        }
        if (fr == null)
          fr = ValueSetUtilities.generateImplicitValueSet(reference);
        timeTracker.tx(t, System.nanoTime());
        return fr;
      }
    } else
      return null;
  }


  private String resolve(String uri, String ref) {
    if (isBlank(uri)) {
      return ref;
    }
    String[] up = uri.split("\\/");
    String[] rp = ref.split("\\/");
    if (context.getResourceNames().contains(up[up.length - 2]) && context.getResourceNames().contains(rp[0])) {
      StringBuilder b = new StringBuilder();
      for (int i = 0; i < up.length - 2; i++) {
        b.append(up[i]);
        b.append("/");
      }
      b.append(ref);
      return b.toString();
    } else
      return ref;
  }

  protected String describeReference(String reference) {
    if (reference == null)
      return "null";
    return reference;
  }


}