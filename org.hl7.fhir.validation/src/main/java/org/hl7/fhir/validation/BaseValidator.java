package org.hl7.fhir.validation;


import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.XVerExtensionManager.XVerExtensionStatus;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier.IValidationContextResourceLoader;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.validation.cli.utils.ValidationLevel;
import org.hl7.fhir.validation.instance.utils.IndexedElement;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class BaseValidator implements IValidationContextResourceLoader {

  public class BooleanHolder {
    private boolean value = true;

    public BooleanHolder() {
      super();
      this.value = true;
    }
    public BooleanHolder(boolean value) {
      super();
      this.value = value;
    }
    public void fail() {
      value = false;
    }
    public boolean ok() {
      return value;
    }
    public void see(boolean ok) {
      value = value && ok;
    }
  }
  

  public class TrackedLocationRelatedMessage {
    private Object location;
    private ValidationMessage vmsg;
    public TrackedLocationRelatedMessage(Object location, ValidationMessage vmsg) {
      super();
      this.location = location;
      this.vmsg = vmsg;
    }
    public Object getLocation() {
      return location;
    }
    public ValidationMessage getVmsg() {
      return vmsg;
    }
      }

  public class ValidationControl {
    private boolean allowed;
    private IssueSeverity level;
    
    public ValidationControl(boolean allowed, IssueSeverity level) {
      super();
      this.allowed = allowed;
      this.level = level;
    }
    public boolean isAllowed() {
      return allowed;
    }
    public IssueSeverity getLevel() {
      return level;
    }
  }

  public static final String NO_RULE_DATE = ValidationMessage.NO_RULE_DATE;

  protected final String META = "meta";
  protected final String ENTRY = "entry";
  protected final String LINK = "link";
  protected final String DOCUMENT = "document";
  protected final String RESOURCE = "resource";
  protected final String MESSAGE = "message";
  protected final String SEARCHSET = "searchset";
  protected final String ID = "id";
  protected final String FULL_URL = "fullUrl";
  protected final String PATH_ARG = ":0";
  protected final String TYPE = "type";
  protected final String BUNDLE = "Bundle";
  protected final String LAST_UPDATED = "lastUpdated";

  protected BaseValidator parent;
  protected Source source;
  protected IWorkerContext context;
  protected ValidationTimeTracker timeTracker = new ValidationTimeTracker();
  protected XVerExtensionManager xverManager;
  protected List<TrackedLocationRelatedMessage> trackedMessages = new ArrayList<>();
  protected List<ValidationMessage> messagesToRemove = new ArrayList<>();
  protected ValidationLevel level = ValidationLevel.HINTS;
  protected Coding jurisdiction;
  protected boolean allowExamples;
  protected boolean forPublication;
  protected boolean debug;
  protected boolean warnOnDraftOrExperimental; 
  protected Set<String> statusWarnings = new HashSet<>();  
  protected BestPracticeWarningLevel bpWarnings = BestPracticeWarningLevel.Warning;
  protected String sessionId = Utilities.makeUuidLC();


  public BaseValidator(IWorkerContext context, XVerExtensionManager xverManager, boolean debug) {
    super();
    this.context = context;
    this.xverManager = xverManager;
    if (this.xverManager == null) {
      this.xverManager = new XVerExtensionManager(context);
    }
    this.debug = debug;
    urlRegex = Constants.URI_REGEX_XVER.replace("$$", CommaSeparatedStringBuilder.join("|", context.getResourceNames()));
  }
  
  public BaseValidator(BaseValidator parent) {
    super();
    this.parent = parent;
    this.context = parent.context;
    this.xverManager = parent.xverManager;
    this.debug = parent.debug;
    this.source = parent.source;
    this.timeTracker = parent.timeTracker;
    this.trackedMessages = parent.trackedMessages;
    this.messagesToRemove = parent.messagesToRemove;
    this.level = parent.level;
    this.allowExamples = parent.allowExamples;
    this.forPublication = parent.forPublication;
    this.debug = parent.debug;
    this.warnOnDraftOrExperimental = parent.warnOnDraftOrExperimental;
    this.statusWarnings = parent.statusWarnings;
    this.bpWarnings = parent.bpWarnings;
    this.urlRegex = parent.urlRegex;
  }
  
  private boolean doingLevel(IssueSeverity error) {
    switch (error) {
    case ERROR:
      return level == null || level == ValidationLevel.ERRORS || level == ValidationLevel.WARNINGS || level == ValidationLevel.HINTS;
    case FATAL:
      return level == null || level == ValidationLevel.ERRORS || level == ValidationLevel.WARNINGS || level == ValidationLevel.HINTS;
    case WARNING:
      return level == null || level == ValidationLevel.WARNINGS || level == ValidationLevel.HINTS;
    case INFORMATION:
      return level == null || level == ValidationLevel.HINTS;
    case NULL:
      return true;
    default:
      return true;    
    }
  }

  private boolean doingErrors() {
    return doingLevel(IssueSeverity.ERROR);
  }
  
  private boolean doingWarnings() {
    return doingLevel(IssueSeverity.WARNING);
  }
  
  private boolean doingHints() {
    return doingLevel(IssueSeverity.INFORMATION);
  }
  

  /**
   * Use to control what validation the validator performs. 
   * Using this, you can turn particular kinds of validation on and off 
   * In addition, you can override the error | warning | hint level and make it a different level
   * 
   * There is no way to do this using the command line validator; it's a service that is only 
   * offered when the validator is hosted in some other process
   */
  private Map<String, ValidationControl> validationControl = new HashMap<>();

  protected String urlRegex;

    /**
   * Test a rule and add a {@link IssueSeverity#FATAL} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  @Deprecated
  protected boolean fail(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg) {
    if (!thePass && doingErrors()) {
      addValidationMessage(errors, ruleDate, type, line, col, path, msg, IssueSeverity.FATAL, null);
    }
    return thePass;
  }

  protected boolean fail(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String msg = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, msg, IssueSeverity.FATAL, theMessage);
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
  protected boolean fail(List<ValidationMessage> errors, String ruleDate, IssueType type, List<String> pathParts, boolean thePass, String msg) {
    if (!thePass && doingErrors()) {
      String path = toPath(pathParts);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, msg, IssueSeverity.FATAL, null);
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
  protected boolean fail(List<ValidationMessage> errors, String ruleDate, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String path = toPath(pathParts);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, context.formatMessage(theMessage, theMessageArguments), IssueSeverity.FATAL, theMessage);
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
  protected boolean fail(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass && doingErrors()) {
      addValidationMessage(errors, ruleDate, type, -1, -1, path, msg, IssueSeverity.FATAL, null);
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
  protected boolean hint(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg) {
    if (!thePass && doingHints()) {
      String message = context.formatMessage(msg);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.INFORMATION, msg);
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
  protected boolean hintInv(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg, String invId) {
    if (!thePass && doingHints()) {
      String message = context.formatMessage(msg);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.INFORMATION, msg).setInvId(invId);
    }
    return thePass;
  }

  protected boolean hint(List<ValidationMessage> errors, String ruleDate, IssueType type, NodeStack stack, boolean thePass, String msg, Object... theMessageArguments) {
    return hint(errors, ruleDate, type, stack.line(), stack.col(), stack.getLiteralPath(),  thePass, msg, theMessageArguments);
  }

  protected boolean slicingHint(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, boolean isCritical, String msg, String html, String[] text) {
    if (!thePass && doingHints()) {
      addValidationMessage(errors, ruleDate, type, line, col, path, msg, IssueSeverity.INFORMATION, null).setSlicingHint(true).setSliceHtml(html, text).setCriticalSignpost(isCritical);
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
  protected boolean slicingHint(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, boolean isCritical, String msg, String html, String[] text, List<ValidationMessage> sliceInfo) {
    if (!thePass && doingHints()) {
      addValidationMessage(errors, ruleDate, type, line, col, path, msg, IssueSeverity.INFORMATION, null).setSlicingHint(true).setSliceHtml(html, text).setCriticalSignpost(isCritical).setSliceInfo(sliceInfo);
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
  protected boolean hint(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingHints()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.INFORMATION, theMessage);
    }
    return thePass;
  }

  protected boolean hintPlural(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, int num, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingHints()) {
      String message = context.formatMessagePlural(num, theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.INFORMATION, theMessage);
    }
    return thePass;
  }

  protected ValidationMessage signpost(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, String theMessage, Object... theMessageArguments) {
    String message = context.formatMessage(theMessage, theMessageArguments);
    return addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.INFORMATION, theMessage).setSignpost(true);
  }

  protected boolean txHint(List<ValidationMessage> errors, String ruleDate, String txLink, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingHints()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.INFORMATION, Source.TerminologyEngine, theMessage).setTxLink(txLink);
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
  protected boolean hint(List<ValidationMessage> errors, String ruleDate, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingHints()) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.INFORMATION, theMessage);
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
  protected boolean hint(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingHints()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.INFORMATION, null);
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
  protected boolean rule(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  protected boolean ruleInv(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String theMessage, String invId, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.ERROR, invId).setInvId(invId);
    }
    return thePass;
  }

  protected boolean rule(List<ValidationMessage> errors, String ruleDate, IssueType type, NodeStack stack, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, stack.line(), stack.col(), stack.getLiteralPath(), message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  protected boolean rulePlural(List<ValidationMessage> errors, String ruleDate, IssueType type, NodeStack node, boolean thePass, int num, String theMessage, Object... theMessageArguments) {
    return rulePlural(errors, ruleDate, type, node.line(), node.col(), node.getLiteralPath(), thePass, num, theMessage, theMessageArguments);
  }
  
  protected boolean rulePlural(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, int num, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String message = context.formatMessagePlural(num, theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  protected boolean txRule(List<ValidationMessage> errors, String ruleDate, String txLink, IssueType type, int line, int col, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      ValidationMessage vm = new ValidationMessage(Source.TerminologyEngine, type, line, col, path, message, IssueSeverity.ERROR).setMessageId(idForMessage(theMessage, message));
      vm.setRuleDate(ruleDate);
      if (checkMsgId(theMessage, vm)) {
        errors.add(vm.setTxLink(txLink));
      }
    }
    return thePass;
  }

  private String idForMessage(String theMessage, String message) {
    return theMessage.equals(message) ? null : theMessage;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#ERROR} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean rule(List<ValidationMessage> errors, String ruleDate, IssueType type, List<String> pathParts, boolean thePass, String msg) {
    if (!thePass && doingErrors()) {
      String path = toPath(pathParts);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, msg, IssueSeverity.ERROR, null);
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
  protected boolean rule(List<ValidationMessage> errors, String ruleDate, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.ERROR, theMessage);
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


  protected boolean rule(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  protected boolean rulePlural(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, int num, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingErrors()) {
      String message = context.formatMessagePlural(num, theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.ERROR, theMessage);
    }
    return thePass;
  }

  public boolean rule(List<ValidationMessage> errors, String ruleDate, Source source, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass && doingErrors()) {
      addValidationMessage(errors, ruleDate, type, -1, -1, path, msg, IssueSeverity.ERROR, source, null);
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
  protected boolean ruleHtml(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg, String html) {
    if (!thePass && doingErrors()) {
      msg = context.formatMessage(msg, null);
      html = context.formatMessage(html, null);
      addValidationMessage(errors, ruleDate, type, path, msg, html, IssueSeverity.ERROR, null);
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
  protected boolean warning(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      IssueSeverity severity = IssueSeverity.WARNING;
      addValidationMessage(errors, ruleDate, type, line, col, path, nmsg, severity, msg);
    }
    return thePass;

  }
  
  protected boolean warning(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, String id, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      IssueSeverity severity = IssueSeverity.WARNING;
      addValidationMessage(errors, ruleDate, type, line, col, path, nmsg, severity, id);
    }
    return thePass;

  }
  
  protected boolean warningInv(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg, String invId, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      IssueSeverity severity = IssueSeverity.WARNING;
      String id = idForMessage(msg, nmsg);
      addValidationMessage(errors, ruleDate, type, line, col, path, nmsg, severity, id).setMessageId(id).setInvId(invId);
    }
    return thePass;

  }

  protected boolean warning(List<ValidationMessage> errors, String ruleDate, IssueType type, NodeStack stack, boolean thePass, String msg, Object... theMessageArguments) {
    return warning(errors, ruleDate, type, stack, null, thePass, msg, theMessageArguments);
  }
  
  protected boolean warning(List<ValidationMessage> errors, String ruleDate, IssueType type, NodeStack stack, String id, boolean thePass, String msg, Object... theMessageArguments) {
    return warning(errors, ruleDate, type, stack.line(), stack.col(), stack.getLiteralPath(), id, thePass, msg, theMessageArguments);
  }

  protected boolean warningPlural(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, int num, String msg, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessagePlural(num, msg, theMessageArguments);
      IssueSeverity severity = IssueSeverity.WARNING;
      addValidationMessage(errors, ruleDate, type, line, col, path, nmsg, severity, msg);
    }
    return thePass;

  }

  protected ValidationMessage addValidationMessage(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, String msg, IssueSeverity theSeverity, String id) {
    Source source = this.source;
    return addValidationMessage(errors, ruleDate, type, line, col, path, msg, theSeverity, source, id);
  }

  protected ValidationMessage addValidationMessage(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, String msg, IssueSeverity theSeverity, Source theSource, String id) {
    ValidationMessage validationMessage = new ValidationMessage(theSource, type, line, col, path, msg, theSeverity).setMessageId(id);
    validationMessage.setRuleDate(ruleDate);
    if (doingLevel(theSeverity) && checkMsgId(id, validationMessage)) {
      errors.add(validationMessage);
    }
    return validationMessage;
  }

  public boolean checkMsgId(String id, ValidationMessage vm) { 
    if (id != null && validationControl.containsKey(id)) {
      ValidationControl control = validationControl.get(id);
      if (control.level != null) {
        vm.setLevel(control.level);
      }
      return control.isAllowed();
    }
    return true;
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean txWarning(List<ValidationMessage> errors, String ruleDate, String txLink, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      ValidationMessage vmsg = new ValidationMessage(Source.TerminologyEngine, type, line, col, path, nmsg, IssueSeverity.WARNING).setTxLink(txLink).setMessageId(idForMessage(msg, nmsg));
      vmsg.setRuleDate(ruleDate);
      if (checkMsgId(msg, vmsg)) {
        errors.add(vmsg);
      }
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
  protected ValidationMessage txIssue(List<ValidationMessage> errors, String ruleDate, String txLink, int line, int col, String path, OperationOutcomeIssueComponent issue) {
    if (issue.hasLocation() && issue.getExpressionOrLocation().get(0).getValue().contains(".")) {
      path = path + dropHead(issue.getExpressionOrLocation().get(0).getValue());
    }
    IssueType code = IssueType.fromCode(issue.getCode().toCode());
    IssueSeverity severity = IssueSeverity.fromCode(issue.getSeverity().toCode());
    ValidationMessage vmsg = new ValidationMessage(Source.TerminologyEngine, code, line, col, path, issue.getDetails().getText(), severity).setTxLink(txLink);
    vmsg.setServer(issue.getExtensionString(ToolingExtensions.EXT_ISSUE_SERVER));
    errors.add(vmsg);
    return vmsg;
  }
  
  private String dropHead(String value) {
    return value.contains(".") ? value.substring(value.indexOf(".")) : "";
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails. Also, keep track of it later in case we want to remove it if we find a required binding for this element later
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean txWarningForLaterRemoval(Object location, List<ValidationMessage> errors, String ruleDate, String txLink, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      ValidationMessage vmsg = new ValidationMessage(Source.TerminologyEngine, type, line, col, path, nmsg, IssueSeverity.WARNING).setTxLink(txLink).setMessageId(msg);
      vmsg.setRuleDate(ruleDate);
      if (checkMsgId(msg, vmsg)) {
        errors.add(vmsg);
      }
      trackedMessages.add(new TrackedLocationRelatedMessage(location, vmsg));
    }
    return thePass;

  }

  protected void removeTrackedMessagesForLocation(List<ValidationMessage> errors, Object location, String path) {
    List<TrackedLocationRelatedMessage> messages = new ArrayList<>();
    for (TrackedLocationRelatedMessage m : trackedMessages) {
      if (m.getLocation() == location) {
        messages.add(m);
        messagesToRemove.add(m.getVmsg());
      }
    }
    trackedMessages.removeAll(messages);    
  }
  
  protected boolean warningOrError(boolean isError, List<ValidationMessage> errors, String ruleDate, IssueType type, NodeStack stack, boolean thePass, String msg, Object... theMessageArguments) {
    return warningOrError(isError, errors, ruleDate, type, stack.line(), stack.col(), stack.getLiteralPath(), thePass, msg, theMessageArguments);
  }
  
  protected boolean warningOrError(boolean isError, List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      IssueSeverity lvl = isError ? IssueSeverity.ERROR : IssueSeverity.WARNING;
      if (doingLevel(lvl)) {
        addValidationMessage(errors, ruleDate, type, line, col, path, nmsg, lvl, msg);
      }
    }
    return thePass;

  }

  protected boolean hintOrError(boolean isError, List<ValidationMessage> errors, String ruleDate, IssueType type, NodeStack stack, boolean thePass, String msg, Object... theMessageArguments) {
    return hintOrError(isError, errors, ruleDate, type, stack.line(), stack.col(), stack.getLiteralPath(), thePass, msg, theMessageArguments);
  }
  
  protected boolean hintOrError(boolean isError, List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      IssueSeverity lvl = isError ? IssueSeverity.ERROR : IssueSeverity.INFORMATION;
      if (doingLevel(lvl)) {
        addValidationMessage(errors, ruleDate, type, line, col, path, nmsg, lvl, msg);
      }
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
  protected boolean warning(List<ValidationMessage> errors, String ruleDate, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.WARNING, theMessage);
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
  protected boolean warning(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String message = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.WARNING, null);
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
  protected boolean warningOrHint(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, boolean warning, String msg, Object... theMessageArguments) {
    if (!thePass) {
      String message = context.formatMessage(msg, theMessageArguments);
      IssueSeverity lvl = warning ? IssueSeverity.WARNING : IssueSeverity.INFORMATION;
      if  (doingLevel(lvl)) {
        addValidationMessage(errors, ruleDate, type, -1, -1, path, message, lvl, null);
      }
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
  protected boolean warningHtml(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg, String html) {
    if (!thePass && doingWarnings()) {
      addValidationMessage(errors, ruleDate, type, path, msg, html, IssueSeverity.WARNING, null);
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
  protected boolean warningHtml(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg, String html, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, path, nmsg, html, IssueSeverity.WARNING, msg);
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
  protected boolean suppressedwarning(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, boolean thePass, String msg, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) { 
      String nmsg = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, line, col, path, nmsg, IssueSeverity.INFORMATION, msg);
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
  protected boolean suppressedwarning(List<ValidationMessage> errors, String ruleDate, IssueType type, List<String> pathParts, boolean thePass, String theMessage, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String path = toPath(pathParts);
      String message = context.formatMessage(theMessage, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, -1, -1, path, message, IssueSeverity.INFORMATION, theMessage);
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
  protected boolean suppressedwarning(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg) {
    if (!thePass && doingWarnings()) {
      addValidationMessage(errors, ruleDate, type, -1, -1, path, msg, IssueSeverity.INFORMATION, null);
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
  protected boolean suppressedwarning(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg, String html) {
    if (!thePass && doingWarnings()) {
      IssueSeverity severity = IssueSeverity.INFORMATION;
      addValidationMessage(errors, ruleDate, type, path, msg, html, severity, null);
    }
    return thePass;
  }

  protected void addValidationMessage(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, String msg, String html, IssueSeverity theSeverity, String id) {
    ValidationMessage vm = new ValidationMessage(source, type, -1, -1, path, msg, html, theSeverity);
    vm.setRuleDate(ruleDate);
    if (checkMsgId(id, vm)) {
      if (doingLevel(theSeverity)) {
        errors.add(vm.setMessageId(id));
      }
    }
  }

  /**
   * Test a rule and add a {@link IssueSeverity#WARNING} validation message if the validation fails
   * 
   * @param thePass
   *          Set this parameter to <code>false</code> if the validation does not pass
   * @return Returns <code>thePass</code> (in other words, returns <code>true</code> if the rule did not fail validation)
   */
  protected boolean suppressedwarning(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass, String msg, String html, Object... theMessageArguments) {
    if (!thePass && doingWarnings()) {
      String nmsg = context.formatMessage(msg, theMessageArguments);
      addValidationMessage(errors, ruleDate, type, path, nmsg, html, IssueSeverity.INFORMATION, msg);
    }
    return thePass;
  }


  protected ValueSet resolveBindingReference(DomainResource ctxt, String reference, String uri, Resource src) {
    if (reference != null) {
      if (reference.equals("http://www.rfc-editor.org/bcp/bcp13.txt")) {
        reference = "http://hl7.org/fhir/ValueSet/mimetypes";
      }
      if (reference.startsWith("#")) {
        for (Resource c : ctxt.getContained()) {
          if (c.getId().equals(reference.substring(1)) && (c instanceof ValueSet))
            return (ValueSet) c;
        }
        return null;
      } else {
        long t = System.nanoTime();
        ValueSet fr = context.fetchResource(ValueSet.class, reference, src);
        if (fr == null) {
          if (!Utilities.isAbsoluteUrl(reference)) {
            reference = resolve(uri, reference);
            fr = context.fetchResource(ValueSet.class, reference, src);
          }
        }
        if (fr == null) {
          fr = ValueSetUtilities.generateImplicitValueSet(reference);
        } 
       
        timeTracker.tx(t, "vs "+uri);
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
        Element res = be.getNamedChild(RESOURCE, false);
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

  protected Element resolveInBundle(Element bundle, List<Element> entries, String ref, String fullUrl, String type, String id, NodeStack stack, List<ValidationMessage> errors, String name, Element source, boolean isWarning, boolean isNLLink) {
    @SuppressWarnings("unchecked")
    Map<String, List<Element>> map = (Map<String, List<Element>>) bundle.getUserData("validator.entrymap");
    @SuppressWarnings("unchecked")
    Map<String, List<Element>> relMap = (Map<String, List<Element>>) bundle.getUserData("validator.entrymapR");
    List<Element> list = null;

    if (map == null) {
      map = new HashMap<>();
      bundle.setUserData("validator.entrymap", map);
      relMap = new HashMap<>();
      bundle.setUserData("validator.entrymapR", relMap);
      for (Element entry : entries) {
        String fu = entry.getNamedChildValue(FULL_URL, false);
        list = map.get(fu);
        if (list == null) {
          list = new ArrayList<Element>();
          map.put(fu, list);
        }
        list.add(entry);
        
        Element resource = entry.getNamedChild(RESOURCE, false);
        if (resource != null) {
          String et = resource.getType();
          String eid = resource.getNamedChildValue(ID, false);
          if (eid != null) {
            String rl = et+"/"+eid;
            list = relMap.get(rl);
            if (list == null) {
              list = new ArrayList<Element>();
              relMap.put(rl, list);
            }
            list.add(entry);
          }
        }
      }      
    }
    
    String fragment = null;
    if (ref != null && ref.contains("#")) {
      fragment = ref.substring(ref.indexOf("#")+1);
      ref = ref.substring(0, ref.indexOf("#"));
    }
    
    if (Utilities.isAbsoluteUrl(ref)) {
      // if the reference is absolute, then you resolve by fullUrl. No other thinking is required.
      List<Element> el = map.get(ref);
      if (el == null) {
        // if this something we complain about? 
        // not if it's in a package, or it looks like a restful URL and it's one of the canonical resource types
        boolean ok = context.hasResource(Resource.class, ref);
        if (!ok && ref.matches(urlRegex)) {
          String tt = extractResourceType(ref);
          ok = VersionUtilities.getCanonicalResourceNames(context.getVersion()).contains(tt);
        }
        if (!ok && stack != null && !sessionId.equals(source.getUserString("bundle.error.noted"))) {
          source.setUserData("bundle.error.noted", sessionId);          
          hintOrError(!isWarning, errors, NO_RULE_DATE, IssueType.NOTFOUND, stack, false, I18nConstants.BUNDLE_BUNDLE_ENTRY_NOTFOUND, ref, name);
        }
        return null;
      } else if (el.size() == 1) {
        if (fragment != null) {
          int i = countFragmentMatches(el.get(0), fragment);
          if (i == 0) {
            source.setUserData("bundle.error.noted", sessionId);
            hintOrError(isNLLink, errors, NO_RULE_DATE, IssueType.NOTFOUND, stack, false, I18nConstants.BUNDLE_BUNDLE_ENTRY_NOTFOUND_FRAGMENT, ref, fragment, name);            
          } else if (i > 1) {
            source.setUserData("bundle.error.noted", sessionId);
            rule(errors, "2023-11-15", IssueType.INVALID, stack, false, I18nConstants.BUNDLE_BUNDLE_ENTRY_FOUND_MULTIPLE_FRAGMENT, i, ref, fragment, name);            
          }
        }
        return el.get(0);
      } else {
        if (stack != null && !sessionId.equals(source.getUserString("bundle.error.noted"))) {
          source.setUserData("bundle.error.noted", sessionId);
          rule(errors, "2023-11-15", IssueType.INVALID, stack, false, I18nConstants.BUNDLE_BUNDLE_ENTRY_FOUND_MULTIPLE, el.size(), ref, name);
        }
        return null;
      }
    } else {
      // split into base, type, and id
      String u = null;
      if (fullUrl != null && fullUrl.matches(urlRegex) && fullUrl.endsWith(type + "/" + id)) {
        u = fullUrl.substring(0, fullUrl.length() - (type + "/" + id).length()) + ref;
      }
      List<Element> el = map.get(u);
      if (el != null && el.size() > 0) {
        if (el.size() == 1) {
          return el.get(0);
        } else {
          if (stack != null && !sessionId.equals(source.getUserString("bundle.error.noted"))) {
            source.setUserData("bundle.error.noted", sessionId);
            rule(errors, "2023-11-15", IssueType.INVALID, stack, false, I18nConstants.BUNDLE_BUNDLE_ENTRY_FOUND_MULTIPLE, el.size(), ref, name);
          }
          return null;
        }
      } else {
        String[] parts = ref.split("\\/");
        if (parts.length >= 2) {
          String t = parts[0];
          if (context.getResourceNamesAsSet().contains(t)) {
            String i = parts[1];
            el = relMap.get(t+"/"+i);
            if (el != null) {
              Set<String> tl = new HashSet<>();
              for (Element e : el) {
                String fu = e.getNamedChildValue(FULL_URL, false);
                tl.add(fu == null ? "<missing>" : fu);
              }
              if (!VersionUtilities.isR4Plus(context.getVersion())) {
                if (el.size() == 1) {
                  return el.get(0);
                } else if (stack != null && !sessionId.equals(source.getUserString("bundle.error.noted"))) {
                  source.setUserData("bundle.error.noted", sessionId);
                  rulePlural(errors, "2023-11-15", IssueType.INVALID, stack, false, el.size(), I18nConstants.BUNDLE_BUNDLE_ENTRY_NOTFOUND_APPARENT, ref, name, CommaSeparatedStringBuilder.join(",", Utilities.sorted(tl)));
                }
              } else if (stack != null && !sessionId.equals(source.getUserString("bundle.error.noted"))) {
                source.setUserData("bundle.error.noted", sessionId);
                rulePlural(errors, "2023-11-15", IssueType.INVALID, stack, false, el.size(), I18nConstants.BUNDLE_BUNDLE_ENTRY_NOTFOUND_APPARENT, ref, name, CommaSeparatedStringBuilder.join(",", Utilities.sorted(tl)));
              }
            } else {
              if (stack != null && !sessionId.equals(source.getUserString("bundle.error.noted"))) {
                source.setUserData("bundle.error.noted", sessionId);
                hintOrError(!isWarning, errors, NO_RULE_DATE, IssueType.NOTFOUND, stack, false, I18nConstants.BUNDLE_BUNDLE_ENTRY_NOTFOUND, ref, name);
              }            
            }
          }
        }
        return null;    
      }
    }
  }


  protected int countFragmentMatches(Element element, String fragment) {
    int count = 0;
    if (fragment.equals(element.getIdBase())) {
      count++;
    }
    if (element.getXhtml() != null) {
      count = count + countFragmentMatches(element.getXhtml(), fragment);
    }
    if (element.hasChildren()) {
      for (Element child : element.getChildren()) {
        count = count + countFragmentMatches(child, fragment);
      }
    }
    return count;
  }

  private int countFragmentMatches(XhtmlNode node, String fragment) {
    int count = 0;
    if (fragment.equals(node.getAttribute("id"))) {
      count++;
    }
    if (node.hasChildren()) {
      for (XhtmlNode child : node.getChildNodes()) {
        count = count + countFragmentMatches(child, fragment);
      }
    }
    return count;
  }

  private String extractResourceType(String ref) {
    String[] p = ref.split("\\/");
    return p[p.length -2];
  }

  protected IndexedElement getFromBundle(Element bundle, String ref, String fullUrl, List<ValidationMessage> errors, String path, String type, boolean isTransaction, BooleanHolder bh) {
    String targetUrl = null;
    String version = "";
    String resourceType = null;
    if (ref.startsWith("http:") || ref.startsWith("urn:") || Utilities.isAbsoluteUrl(ref)) {
      // We've got an absolute reference, no need to calculate
      if (ref.contains("/_history/")) {
        targetUrl = ref.substring(0, ref.indexOf("/_history/") - 1);
        version = ref.substring(ref.indexOf("/_history/") + 10);
      } else
        targetUrl = ref;

    } else if (fullUrl == null) {
      //This isn't a problem for signatures - if it's a signature, we won't have a resolution for a relative reference.  For anything else, this is an error
      // but this rule doesn't apply for batches or transactions
      rule(errors, NO_RULE_DATE, IssueType.REQUIRED, -1, -1, path, Utilities.existsInList(type, "batch-response", "transaction-response") || path.startsWith("Bundle.signature"), I18nConstants.BUNDLE_BUNDLE_FULLURL_MISSING);
      return null;

    } else if (ref.split("/").length != 2 && ref.split("/").length != 4) {
      if (isTransaction) {
        rule(errors, NO_RULE_DATE, IssueType.INVALID, -1, -1, path, isSearchUrl(ref), I18nConstants.REFERENCE_REF_FORMAT1, ref);
      } else {
        rule(errors, NO_RULE_DATE, IssueType.INVALID, -1, -1, path, false, I18nConstants.REFERENCE_REF_FORMAT2, ref);
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
        Element r = we.getNamedChild(RESOURCE, false);
        if (version.isEmpty()) {
          rule(errors, NO_RULE_DATE, IssueType.FORBIDDEN, -1, -1, path, match == null, I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ref);
          match = r;
          matchIndex = i;
        } else {
          try {
            if (version.equals(r.getChildren(META).get(0).getChildValue("versionId"))) {
              rule(errors, NO_RULE_DATE, IssueType.FORBIDDEN, -1, -1, path, match == null, I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ref);
              match = r;
              matchIndex = i;
            }
          } catch (Exception e) {
            warning(errors, NO_RULE_DATE, IssueType.REQUIRED, -1, -1, path, r.getChildren(META).size() == 1 && r.getChildren(META).get(0).getChildValue("versionId") != null, I18nConstants.BUNDLE_BUNDLE_FULLURL_NEEDVERSION, targetUrl);
            // If one of these things is null
          }
        }
      }
    }

    if (match != null && resourceType != null)
      bh.see(rule(errors, NO_RULE_DATE, IssueType.REQUIRED, -1, -1, path, match.getType().equals(resourceType), I18nConstants.REFERENCE_REF_RESOURCETYPE, ref, match.getType()));
    if (match == null) {
      warning(errors, NO_RULE_DATE, IssueType.REQUIRED, -1, -1, path, !ref.startsWith("urn"), I18nConstants.BUNDLE_BUNDLE_NOT_LOCAL, ref);
      if (!Utilities.isAbsoluteUrl(ref)) {
        String[] p = ref.split("\\/");
        List<Element> ml = new ArrayList<>();
        if (p.length >= 2 && context.getResourceNamesAsSet().contains(p[0]) && Utilities.isValidId(p[1])) {
          for (int i = 0; i < entries.size(); i++) {
            Element we = entries.get(i);
            Element r = we.getNamedChild(RESOURCE, false);
            if (r != null && p[0].equals(r.fhirType()) && p[1].equals(r.getNamedChildValue("id", false)) ) {
              ml.add(we);
            }
          }          
        }
        if (ml.size() > 1) {
          warning(errors, NO_RULE_DATE, IssueType.REQUIRED, -1, -1, path, false, I18nConstants.BUNDLE_POSSSIBLE_MATCHES, ref, targetUrl);          
        }
        for (Element e : ml) {
          String fu = e.getChildValue(FULL_URL);
          int i = entries.indexOf(e);
          if (fu == null) {
            warning(errors, NO_RULE_DATE, IssueType.REQUIRED, -1, -1, path, false, I18nConstants.BUNDLE_BUNDLE_POSSIBLE_MATCH_NO_FU, i, ref, targetUrl);
          } else {
            warning(errors, NO_RULE_DATE, IssueType.REQUIRED, -1, -1, path, false, I18nConstants.BUNDLE_BUNDLE_POSSIBLE_MATCH_WRONG_FU, i, ref, fu, targetUrl);            
          }
        }
      }
    }
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
      return q.matches("([_a-zA-Z][_a-zA-Z0-9]*=[^=&]*)(&([_a-zA-Z][_a-zA-Z0-9]*=[^=&]*))*");
    }
  }

  public Map<String, ValidationControl> getValidationControl() {
    return validationControl;
  }

  public XVerExtensionStatus xverStatus(String url) {
    return xverManager.status(url);
  }

  public boolean isXverUrl(String url) {
    return xverManager.matchingUrl(url);    
  }
  
  public StructureDefinition xverDefn(String url) {
    return xverManager.makeDefinition(url);
  }
  
  public String xverVersion(String url) {
    return xverManager.getVersion(url);
  }

  public String xverElementId(String url) {
    return xverManager.getElementId(url);
  }

  public StructureDefinition getXverExt(StructureDefinition profile, List<ValidationMessage> errors, String url) {
    if (isXverUrl(url)) {
      switch (xverStatus(url)) {
        case BadVersion:
          rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, profile.getId(), false, I18nConstants.EXTENSION_EXT_VERSION_INVALID, url, xverVersion(url));
          return null;
        case Unknown:
          rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, profile.getId(), false, I18nConstants.EXTENSION_EXT_VERSION_INVALIDID, url, xverElementId(url));
          return null;
        case Invalid:
          rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, profile.getId(), false, I18nConstants.EXTENSION_EXT_VERSION_NOCHANGE, url, xverElementId(url));
          return null;
        case Valid:
          StructureDefinition defn = xverDefn(url);
          new ContextUtilities(context).generateSnapshot(defn);
          context.cacheResource(defn);
          return defn;
        default:
          rule(errors, NO_RULE_DATE, IssueType.INVALID, profile.getId(), false, I18nConstants.EXTENSION_EXT_VERSION_INTERNAL, url);
          return null;
      }
    } else {
      return null;      
    }
  }
  
  public StructureDefinition getXverExt(List<ValidationMessage> errors, String path, Element element, String url) {
    if (isXverUrl(url)) {
      switch (xverStatus(url)) {
      case BadVersion:
        rule(errors, NO_RULE_DATE, IssueType.INVALID, element.line(), element.col(), path + "[url='" + url + "']", false, I18nConstants.EXTENSION_EXT_VERSION_INVALID, url, xverVersion(url));
        break;
      case Unknown:
        rule(errors, NO_RULE_DATE, IssueType.INVALID, element.line(), element.col(), path + "[url='" + url + "']", false, I18nConstants.EXTENSION_EXT_VERSION_INVALIDID, url, xverElementId(url));
        break;
      case Invalid:
        rule(errors, NO_RULE_DATE, IssueType.INVALID, element.line(), element.col(), path + "[url='" + url + "']", false, I18nConstants.EXTENSION_EXT_VERSION_NOCHANGE, url, xverElementId(url));
        break;
      case Valid:
        StructureDefinition ex = xverDefn(url);
        new ContextUtilities(context).generateSnapshot(ex);
        context.cacheResource(ex);
        return ex;
      default:
        rule(errors, NO_RULE_DATE, IssueType.INVALID, element.line(), element.col(), path + "[url='" + url + "']", false, I18nConstants.EXTENSION_EXT_VERSION_INTERNAL, url);
        break;
      }
    }
    return null;
  }
  
  protected String versionFromCanonical(String system) {
    if (system == null) {
      return null;
    } else if (system.contains("|")) {
      return system.substring(0, system.indexOf("|"));
    } else {
      return system;
    }
  }

  protected String systemFromCanonical(String system) {
    if (system == null) {
      return null;
    } else if (system.contains("|")) {
      return system.substring(system.indexOf("|")+1);
    } else {
      return system;
    }
  }
  
  @Override
  public Resource loadContainedResource(List<ValidationMessage> errors, String path, Element resource, String id, Class<? extends Resource> class1) throws FHIRException {
    for (Element contained : resource.getChildren("contained")) {
      if (contained.getIdBase().equals(id)) {
        return loadFoundResource(errors, path, contained, class1);
      }
    }
    return null;
  }
  
  protected Resource loadFoundResource(List<ValidationMessage> errors, String path, Element resource, Class<? extends Resource> class1) throws FHIRException {
    try {
      FhirPublication v = FhirPublication.fromCode(context.getVersion());
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      new JsonParser(context).compose(resource, bs, OutputStyle.NORMAL, resource.getIdBase());
      byte[] json = bs.toByteArray();
      Resource r5 = null;
      switch (v) {
      case DSTU1:
        rule(errors, NO_RULE_DATE, IssueType.INVALID, resource.line(), resource.col(), path, false, I18nConstants.UNSUPPORTED_VERSION_R1, resource.getIdBase());
        return null; // this can't happen
      case DSTU2:
        org.hl7.fhir.dstu2.model.Resource r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(json);
        r5 = VersionConvertorFactory_10_50.convertResource(r2);
        break;
      case DSTU2016May:
        org.hl7.fhir.dstu2016may.model.Resource r2a = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(json);
        r5 = VersionConvertorFactory_14_50.convertResource(r2a);
        break;
      case STU3:
        org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(json);
        r5 = VersionConvertorFactory_30_50.convertResource(r3);
        break;
      case R4:
        org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(json);
        r5 = VersionConvertorFactory_40_50.convertResource(r4);
        break;
      case R5:
        r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(json);
        break;
      default:
        return null; // this can't happen
      }
      if (class1.isInstance(r5))
        return (Resource) r5;
      else {
        rule(errors, NO_RULE_DATE, IssueType.INVALID, resource.line(), resource.col(), path, false, I18nConstants.REFERENCE_REF_WRONGTARGET_LOAD, resource.getIdBase(), class1.toString(), r5.fhirType());
        return null;
      }

    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  public void setLevel(ValidationLevel level) {
    this.level = level;
  }

  public ValidationLevel getLevel() {
    return level;
  }

  protected boolean isHL7(Element cr) {
    String url = cr.getChildValue("url");
    return url != null && url.contains("hl7");
  }

  protected boolean isHL7Core(Element cr) {
    String url = cr.getChildValue("url");
    return url != null && url.startsWith("http://hl7.org/fhir/") && !url.startsWith("http://hl7.org/fhir/test");
  }

  public boolean isAllowExamples() {
    return this.allowExamples;
  }

  public void setAllowExamples(boolean value) {
    this.allowExamples = value;
  }

  protected boolean isExampleUrl(String url) {
    return Utilities.containsInList(url, "example.org", "acme.com", "acme.org");    
  }
  
  public boolean isForPublication() {
    return forPublication;
  }
  
  public BaseValidator setForPublication(boolean forPublication) {
    this.forPublication = forPublication;
    return this;
  }

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    this.debug = debug;
  }
 

  protected boolean checkDefinitionStatus(List<ValidationMessage> errors, Element element, String path, StructureDefinition ex, CanonicalResource source, String type) {
    boolean ok = true;
    String vurl = ex.getVersionedUrl();

    StandardsStatus standardsStatus = ToolingExtensions.getStandardsStatus(ex);
    if (standardsStatus == StandardsStatus.DEPRECATED) {
      if (!statusWarnings.contains(vurl+":DEPRECATED")) {  
        statusWarnings.add(vurl+":DEPRECATED");
        hint(errors, "2023-08-10", IssueType.BUSINESSRULE, element.line(), element.col(), path, false, I18nConstants.MSG_DEPENDS_ON_DEPRECATED, type, vurl);
      }
    } else if (standardsStatus == StandardsStatus.WITHDRAWN) {
      if (!statusWarnings.contains(vurl+":WITHDRAWN")) {  
        statusWarnings.add(vurl+":WITHDRAWN");
        hint(errors, "2023-08-10", IssueType.BUSINESSRULE, element.line(), element.col(), path, false, I18nConstants.MSG_DEPENDS_ON_WITHDRAWN, type, vurl);
      }
    } else if (ex.getStatus() == PublicationStatus.RETIRED) {
      if (!statusWarnings.contains(vurl+":RETIRED")) {  
        statusWarnings.add(vurl+":RETIRED");
        hint(errors, "2023-08-10", IssueType.BUSINESSRULE, element.line(), element.col(), path, false, I18nConstants.MSG_DEPENDS_ON_RETIRED, type, vurl);
      }
    } else if (false && warnOnDraftOrExperimental && source != null) {
      // for now, this is disabled; these warnings are just everywhere, and it's an intractible problem. 
      // working this through QA in IG publisher
      if (ex.getExperimental() && !source.getExperimental()) {
        if (!statusWarnings.contains(vurl+":Experimental")) {  
          statusWarnings.add(vurl+":Experimental");
          hint(errors, "2023-08-10", IssueType.BUSINESSRULE, element.line(), element.col(), path, false, I18nConstants.MSG_DEPENDS_ON_EXPERIMENTAL, type, vurl);
        }
      } else if (ex.getStatus() == PublicationStatus.DRAFT && source.getStatus() != PublicationStatus.DRAFT) {
        if (!statusWarnings.contains(vurl+":Draft")) {  
          statusWarnings.add(vurl+":Draft");
          hint(errors, "2023-08-10", IssueType.BUSINESSRULE, element.line(), element.col(), path, false, I18nConstants.MSG_DEPENDS_ON_DRAFT, type, vurl);
        }
      }
    }
    return ok;
  }


  public BestPracticeWarningLevel getBestPracticeWarningLevel() {
    return bpWarnings;
  }

  
  protected boolean bpCheck(List<ValidationMessage> errors, IssueType invalid, int line, int col, String literalPath, boolean test, String message, Object... theMessageArguments) {
    if (bpWarnings != null) {
      switch (bpWarnings) {
        case Error:
          rule(errors, NO_RULE_DATE, invalid, line, col, literalPath, test, message, theMessageArguments);
          return test;
        case Warning:
          warning(errors, NO_RULE_DATE, invalid, line, col, literalPath, test, message, theMessageArguments);
          return true;
        case Hint:
          hint(errors, NO_RULE_DATE, invalid, line, col, literalPath, test, message, theMessageArguments);
          return true;
        default: // do nothing
          break;
      }
    }
    return true;
  }

}