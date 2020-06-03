package org.hl7.fhir.validation;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;

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
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.instance.utils.IndexedElement;

public class BaseValidator {

  protected final String META = "meta";
  protected final String ENTRY = "entry";
  protected final String DOCUMENT = "document";
  protected final String RESOURCE = "resource";
  protected final String MESSAGE = "message";
  protected final String ID = "id";
  protected final String FULL_URL = "fullUrl";
  protected final String PATH_ARG = ":0";
  protected final String TYPE = "type";
  protected final String BUNDLE = "Bundle";
  protected final String LAST_UPDATED = "lastUpdated";


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

  protected Base resolveInBundle(String url, Element bnd) {
    if (bnd == null)
      return null;
    if (bnd.fhirType().equals(BUNDLE)) {
      for (Element be : bnd.getChildrenByName(ENTRY)) {
        Element res = be.getNamedChild(RESOURCE);
        if (res != null) {
          String fullUrl = be.getChildValue(FULL_URL);
          String rt = res.fhirType();
          String id = res.getChildValue(ID);
          if (url.equals(fullUrl))
            return res;
          if (url.equals(rt + "/" + id))
            return res;
        }
      }
    }
    return null;
  }

  protected Element resolveInBundle(List<Element> entries, String ref, String fullUrl, String type, String id) {
    if (Utilities.isAbsoluteUrl(ref)) {
      // if the reference is absolute, then you resolve by fullUrl. No other thinking is required.
      for (Element entry : entries) {
        String fu = entry.getNamedChildValue(FULL_URL);
        if (ref.equals(fu))
          return entry;
      }
      return null;
    } else {
      // split into base, type, and id
      String u = null;
      if (fullUrl != null && fullUrl.endsWith(type + "/" + id))
        // fullUrl = complex
        u = fullUrl.substring(0, fullUrl.length() - (type + "/" + id).length()) + ref;
//        u = fullUrl.substring((type+"/"+id).length())+ref;
      String[] parts = ref.split("\\/");
      if (parts.length >= 2) {
        String t = parts[0];
        String i = parts[1];
        for (Element entry : entries) {
          String fu = entry.getNamedChildValue(FULL_URL);
          if (fu != null && fu.equals(u))
            return entry;
          if (u == null) {
            Element resource = entry.getNamedChild(RESOURCE);
            if (resource != null) {
              String et = resource.getType();
              String eid = resource.getNamedChildValue(ID);
              if (t.equals(et) && i.equals(eid))
                return entry;
            }
          }
        }
      }
      return null;
    }
  }


  protected IndexedElement getFromBundle(Element bundle, String ref, String fullUrl, List<ValidationMessage> errors, String path, String type, boolean isTransaction) {
    String targetUrl = null;
    String version = "";
    String resourceType = null;
    if (ref.startsWith("http") || ref.startsWith("urn")) {
      // We've got an absolute reference, no need to calculate
      if (ref.contains("/_history/")) {
        targetUrl = ref.substring(0, ref.indexOf("/_history/") - 1);
        version = ref.substring(ref.indexOf("/_history/") + 10);
      } else
        targetUrl = ref;

    } else if (fullUrl == null) {
      //This isn't a problem for signatures - if it's a signature, we won't have a resolution for a relative reference.  For anything else, this is an error
      // but this rule doesn't apply for batches or transactions
      rule(errors, IssueType.REQUIRED, -1, -1, path, Utilities.existsInList(type, "batch-response", "transaction-response") || path.startsWith("Bundle.signature"), I18nConstants.BUNDLE_BUNDLE_FULLURL_MISSING);
      return null;

    } else if (ref.split("/").length != 2 && ref.split("/").length != 4) {
      if (isTransaction) {
        rule(errors, IssueType.INVALID, -1, -1, path, isSearchUrl(ref), I18nConstants.REFERENCE_REF_FORMAT1, ref);
      } else {
        rule(errors, IssueType.INVALID, -1, -1, path, false, I18nConstants.REFERENCE_REF_FORMAT2, ref);
      }
      return null;

    } else {
      String base = "";
      if (fullUrl.startsWith("urn")) {
        String[] parts = fullUrl.split("\\:");
        for (int i = 0; i < parts.length - 1; i++) {
          base = base + parts[i] + ":";
        }
      } else {
        String[] parts;
        parts = fullUrl.split("/");
        for (int i = 0; i < parts.length - 2; i++) {
          base = base + parts[i] + "/";
        }
      }

      String id = null;
      if (ref.contains("/_history/")) {
        version = ref.substring(ref.indexOf("/_history/") + 10);
        String[] refBaseParts = ref.substring(0, ref.indexOf("/_history/")).split("/");
        resourceType = refBaseParts[0];
        id = refBaseParts[1];
      } else if (base.startsWith("urn")) {
        resourceType = ref.split("/")[0];
        id = ref.split("/")[1];
      } else
        id = ref;

      targetUrl = base + id;
    }

    List<Element> entries = new ArrayList<Element>();
    bundle.getNamedChildren(ENTRY, entries);
    Element match = null;
    int matchIndex = -1;
    for (int i = 0; i < entries.size(); i++) {
      Element we = entries.get(i);
      if (targetUrl.equals(we.getChildValue(FULL_URL))) {
        Element r = we.getNamedChild(RESOURCE);
        if (version.isEmpty()) {
          rule(errors, IssueType.FORBIDDEN, -1, -1, path, match == null, I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ref);
          match = r;
          matchIndex = i;
        } else {
          try {
            if (version.equals(r.getChildren(META).get(0).getChildValue("versionId"))) {
              rule(errors, IssueType.FORBIDDEN, -1, -1, path, match == null, I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ref);
              match = r;
              matchIndex = i;
            }
          } catch (Exception e) {
            warning(errors, IssueType.REQUIRED, -1, -1, path, r.getChildren(META).size() == 1 && r.getChildren(META).get(0).getChildValue("versionId") != null, I18nConstants.BUNDLE_BUNDLE_FULLURL_NEEDVERSION, targetUrl);
            // If one of these things is null
          }
        }
      }
    }

    if (match != null && resourceType != null)
      rule(errors, IssueType.REQUIRED, -1, -1, path, match.getType().equals(resourceType), I18nConstants.REFERENCE_REF_RESOURCETYPE, ref, match.getType());
    if (match == null)
      warning(errors, IssueType.REQUIRED, -1, -1, path, !ref.startsWith("urn"), I18nConstants.BUNDLE_BUNDLE_NOT_LOCAL, ref);
    return match == null ? null : new IndexedElement(matchIndex, match, entries.get(matchIndex));
  }

  private boolean isSearchUrl(String ref) {
    if (Utilities.noString(ref) || !ref.contains("?")) {
      return false;
    }
    String tn = ref.substring(0, ref.indexOf("?"));
    String q = ref.substring(ref.indexOf("?") + 1);
    if (!context.getResourceNames().contains(tn)) {
      return false;
    } else {
      return q.matches("([_a-zA-Z][_a-zA-Z0-9]*=[^=&]+)(&([_a-zA-Z][_a-zA-Z0-9]*=[^=&]+))*");
    }
  }


}