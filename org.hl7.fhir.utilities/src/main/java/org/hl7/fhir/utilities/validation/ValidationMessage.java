package org.hl7.fhir.utilities.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

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

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class ValidationMessage implements Comparator<ValidationMessage>, Comparable<ValidationMessage>
{
  public enum Source {
    ExampleValidator, 
    ProfileValidator, 
    ResourceValidator, 
    InstanceValidator,
    MatchetypeValidator,
    Template,
    Schema, 
    Schematron, 
    Publisher, 
    LinkChecker,
    Ontology, 
    ProfileComparer, 
    TerminologyEngine,
    QuestionnaireResponseValidator, 
    IPAValidator
  }

  public enum IssueSeverity {
    /**
     * The issue caused the action to fail, and no further checking could be performed.
     */
    FATAL, 
    /**
     * The issue is sufficiently important to cause the action to fail.
     */
    ERROR, 
    /**
     * The issue is not important enough to cause the action to fail, but may cause it to be performed suboptimally or in a way that is not as desired.
     */
    WARNING, 
    /**
     * The issue has no relation to the degree of success of the action.
     */
    INFORMATION, 
    /**
     * added to help the parsers with the generic types
     */
    NULL;
    public static IssueSeverity fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("fatal".equals(codeString))
        return FATAL;
      if ("error".equals(codeString))
        return ERROR;
      if ("warning".equals(codeString))
        return WARNING;
      if ("information".equals(codeString))
        return INFORMATION;
      else
        throw new FHIRException("Unknown IssueSeverity code '"+codeString+"'");
    }
    public String toCode() {
      switch (this) {
      case FATAL: return "fatal";
      case ERROR: return "error";
      case WARNING: return "warning";
      case INFORMATION: return "information";
      case NULL: return null;
      default: return "?";
      }
    }
    public String getSystem() {
      switch (this) {
      case FATAL: return "http://hl7.org/fhir/issue-severity";
      case ERROR: return "http://hl7.org/fhir/issue-severity";
      case WARNING: return "http://hl7.org/fhir/issue-severity";
      case INFORMATION: return "http://hl7.org/fhir/issue-severity";
      case NULL: return null;
      default: return "?";
      }
    }
    public String getDefinition() {
      switch (this) {
      case FATAL: return "The issue caused the action to fail, and no further checking could be performed.";
      case ERROR: return "The issue is sufficiently important to cause the action to fail.";
      case WARNING: return "The issue is not important enough to cause the action to fail, but may cause it to be performed suboptimally or in a way that is not as desired.";
      case INFORMATION: return "The issue has no relation to the degree of success of the action.";
      case NULL: return null;
      default: return "?";
      }
    }
    public String getDisplay() {
      switch (this) {
      case FATAL: return "Fatal";
      case ERROR: return "Error";
      case WARNING: return "Warning";
      case INFORMATION: return "Information";
      case NULL: return null;
      default: return "?";
      }
    }
    public boolean isError() {
      return this == FATAL || this == ERROR;
    }
    public boolean isHint() {
      return this == INFORMATION;
    }
    
    public static IssueSeverity max(IssueSeverity l1, IssueSeverity l2) {
      switch (l1) {
      case ERROR:
        return l1 == FATAL ? FATAL : ERROR;
      case FATAL:
        return FATAL;
      case INFORMATION:
        return l2;
      case NULL:
        return l2;
      case WARNING:
        return l2 == INFORMATION ? WARNING : l2;
      }
      return null;
    }
    public String toShortCode() {
      switch (this) {
      case FATAL: return "fatal";
      case ERROR: return "error";
      case WARNING: return "warn";
      case INFORMATION: return "info";
      case NULL: return null;
      default: return "?";
      }
    }
  }

  public enum IssueType {
    /**
     * Content invalid against the specification or a profile.
     */
    INVALID, 
    DELETED,
    /**
     * A structural issue in the content such as wrong namespace, or unable to parse the content completely, or invalid json syntax.
     */
    STRUCTURE, 
    /**
     * A required element is missing.
     */
    REQUIRED, 
    /**
     * An element value is invalid.
     */
    VALUE, 
    /**
     * A content validation rule failed - e.g. a schematron rule.
     */
    INVARIANT, 
    /**
     * An authentication/authorization/permissions issue of some kind.
     */
    SECURITY, 
    /**
     * The client needs to initiate an authentication process.
     */
    LOGIN, 
    /**
     * The user or system was not able to be authenticated (either there is no process, or the proferred token is unacceptable).
     */
    MULTIPLEMATCHES,
    UNKNOWN, 
    /**
     * User session expired; a login may be required.
     */
    EXPIRED, 
    /**
     * The user does not have the rights to perform this action.
     */
    FORBIDDEN, 
    /**
     * Some information was not or may not have been returned due to business rules, consent or privacy rules, or access permission constraints.  This information may be accessible through alternate processes.
     */
    SUPPRESSED, 
    /**
     * Processing issues. These are expected to be final e.g. there is no point resubmitting the same content unchanged.
     */
    PROCESSING, 
    /**
     * The resource or profile is not supported.
     */
    NOTSUPPORTED, 
    /**
     * An attempt was made to create a duplicate record.
     */
    DUPLICATE, 
    /**
     * The reference provided was not found. In a pure RESTful environment, this would be an HTTP 404 error, but this code may be used where the content is not found further into the application architecture.
     */
    NOTFOUND, 
    /**
     * Provided content is too long (typically, this is a denial of service protection type of error).
     */
    TOOLONG, 
    /**
     * The code or system could not be understood, or it was not valid in the context of a particular ValueSet.code.
     */
    CODEINVALID, 
    /**
     * An extension was found that was not acceptable, could not be resolved, or a modifierExtension was not recognized.
     */
    EXTENSION, 
    /**
     * The operation was stopped to protect server resources; e.g. a request for a value set expansion on all of SNOMED CT.
     */
    TOOCOSTLY, 
    /**
     * The content/operation failed to pass some business rule, and so could not proceed.
     */
    BUSINESSRULE, 
    /**
     * Content could not be accepted because of an edit conflict (i.e. version aware updates) (In a pure RESTful environment, this would be an HTTP 404 error, but this code may be used where the conflict is discovered further into the application architecture.)
     */
    CONFLICT, 
    /**
     * Not all data sources typically accessed could be reached, or responded in time, so the returned information may not be complete.
     */
    INCOMPLETE, 
    /**
     * Transient processing issues. The system receiving the error may be able to resubmit the same content once an underlying issue is resolved.
     */
    TRANSIENT, 
    /**
     * A resource/record locking failure (usually in an underlying database).
     */
    LOCKERROR, 
    /**
     * The persistent store is unavailable; e.g. the database is down for maintenance or similar action.
     */
    NOSTORE, 
    /**
     * An unexpected internal error has occurred.
     */
    EXCEPTION, 
    /**
     * An internal timeout has occurred.
     */
    TIMEOUT, 
    /**
     * The system is not prepared to handle this request due to load management.
     */
    THROTTLED, 
    /**
     * A message unrelated to the processing success of the completed operation (examples of the latter include things like reminders of password expiry, system maintenance times, etc.).
     */
    INFORMATIONAL, 
    /**
     * added to help the parsers with the generic types
     */
    NULL;
    public static IssueType fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("invalid".equals(codeString))
        return INVALID;
      if ("structure".equals(codeString))
        return STRUCTURE;
      if ("required".equals(codeString))
        return REQUIRED;
      if ("value".equals(codeString))
        return VALUE;
      if ("invariant".equals(codeString))
        return INVARIANT;
      if ("security".equals(codeString))
        return SECURITY;
      if ("login".equals(codeString))
        return LOGIN;
      if ("unknown".equals(codeString))
        return UNKNOWN;
      if ("expired".equals(codeString))
        return EXPIRED;
      if ("forbidden".equals(codeString))
        return FORBIDDEN;
      if ("suppressed".equals(codeString))
        return SUPPRESSED;
      if ("processing".equals(codeString))
        return PROCESSING;
      if ("not-supported".equals(codeString))
        return NOTSUPPORTED;
      if ("duplicate".equals(codeString))
        return DUPLICATE;
      if ("not-found".equals(codeString))
        return NOTFOUND;
      if ("too-long".equals(codeString))
        return TOOLONG;
      if ("code-invalid".equals(codeString))
        return CODEINVALID;
      if ("extension".equals(codeString))
        return EXTENSION;
      if ("too-costly".equals(codeString))
        return TOOCOSTLY;
      if ("business-rule".equals(codeString))
        return BUSINESSRULE;
      if ("conflict".equals(codeString))
        return CONFLICT;
      if ("incomplete".equals(codeString))
        return INCOMPLETE;
      if ("transient".equals(codeString))
        return TRANSIENT;
      if ("lock-error".equals(codeString))
        return LOCKERROR;
      if ("no-store".equals(codeString))
        return NOSTORE;
      if ("exception".equals(codeString))
        return EXCEPTION;
      if ("timeout".equals(codeString))
        return TIMEOUT;
      if ("throttled".equals(codeString))
        return THROTTLED;
      if ("informational".equals(codeString))
        return INFORMATIONAL;
      else
        throw new FHIRException("Unknown IssueType code '"+codeString+"'");
    }
    public String toCode() {
      switch (this) {
      case INVALID: return "invalid";
      case STRUCTURE: return "structure";
      case REQUIRED: return "required";
      case VALUE: return "value";
      case INVARIANT: return "invariant";
      case SECURITY: return "security";
      case LOGIN: return "login";
      case UNKNOWN: return "unknown";
      case EXPIRED: return "expired";
      case FORBIDDEN: return "forbidden";
      case SUPPRESSED: return "suppressed";
      case PROCESSING: return "processing";
      case NOTSUPPORTED: return "not-supported";
      case DUPLICATE: return "duplicate";
      case NOTFOUND: return "not-found";
      case TOOLONG: return "too-long";
      case CODEINVALID: return "code-invalid";
      case EXTENSION: return "extension";
      case TOOCOSTLY: return "too-costly";
      case BUSINESSRULE: return "business-rule";
      case CONFLICT: return "conflict";
      case INCOMPLETE: return "incomplete";
      case TRANSIENT: return "transient";
      case LOCKERROR: return "lock-error";
      case NOSTORE: return "no-store";
      case EXCEPTION: return "exception";
      case TIMEOUT: return "timeout";
      case THROTTLED: return "throttled";
      case INFORMATIONAL: return "informational";
      case NULL: return null;
      default: return "?";
      }
    }
    public String getSystem() {
      switch (this) {
      case INVALID: return "http://hl7.org/fhir/issue-type";
      case STRUCTURE: return "http://hl7.org/fhir/issue-type";
      case REQUIRED: return "http://hl7.org/fhir/issue-type";
      case VALUE: return "http://hl7.org/fhir/issue-type";
      case INVARIANT: return "http://hl7.org/fhir/issue-type";
      case SECURITY: return "http://hl7.org/fhir/issue-type";
      case LOGIN: return "http://hl7.org/fhir/issue-type";
      case UNKNOWN: return "http://hl7.org/fhir/issue-type";
      case EXPIRED: return "http://hl7.org/fhir/issue-type";
      case FORBIDDEN: return "http://hl7.org/fhir/issue-type";
      case SUPPRESSED: return "http://hl7.org/fhir/issue-type";
      case PROCESSING: return "http://hl7.org/fhir/issue-type";
      case NOTSUPPORTED: return "http://hl7.org/fhir/issue-type";
      case DUPLICATE: return "http://hl7.org/fhir/issue-type";
      case NOTFOUND: return "http://hl7.org/fhir/issue-type";
      case TOOLONG: return "http://hl7.org/fhir/issue-type";
      case CODEINVALID: return "http://hl7.org/fhir/issue-type";
      case EXTENSION: return "http://hl7.org/fhir/issue-type";
      case TOOCOSTLY: return "http://hl7.org/fhir/issue-type";
      case BUSINESSRULE: return "http://hl7.org/fhir/issue-type";
      case CONFLICT: return "http://hl7.org/fhir/issue-type";
      case INCOMPLETE: return "http://hl7.org/fhir/issue-type";
      case TRANSIENT: return "http://hl7.org/fhir/issue-type";
      case LOCKERROR: return "http://hl7.org/fhir/issue-type";
      case NOSTORE: return "http://hl7.org/fhir/issue-type";
      case EXCEPTION: return "http://hl7.org/fhir/issue-type";
      case TIMEOUT: return "http://hl7.org/fhir/issue-type";
      case THROTTLED: return "http://hl7.org/fhir/issue-type";
      case INFORMATIONAL: return "http://hl7.org/fhir/issue-type";
      case NULL: return null;
      default: return "?";
      }
    }
    public String getDefinition() {
      switch (this) {
      case INVALID: return "Content invalid against the specification or a profile.";
      case STRUCTURE: return "A structural issue in the content such as wrong namespace, or unable to parse the content completely, or invalid json syntax.";
      case REQUIRED: return "A required element is missing.";
      case VALUE: return "An element value is invalid.";
      case INVARIANT: return "A content validation rule failed - e.g. a schematron rule.";
      case SECURITY: return "An authentication/authorization/permissions issue of some kind.";
      case LOGIN: return "The client needs to initiate an authentication process.";
      case UNKNOWN: return "The user or system was not able to be authenticated (either there is no process, or the proferred token is unacceptable).";
      case EXPIRED: return "User session expired; a login may be required.";
      case FORBIDDEN: return "The user does not have the rights to perform this action.";
      case SUPPRESSED: return "Some information was not or may not have been returned due to business rules, consent or privacy rules, or access permission constraints.  This information may be accessible through alternate processes.";
      case PROCESSING: return "Processing issues. These are expected to be final e.g. there is no point resubmitting the same content unchanged.";
      case NOTSUPPORTED: return "The resource or profile is not supported.";
      case DUPLICATE: return "An attempt was made to create a duplicate record.";
      case NOTFOUND: return "The reference provided was not found. In a pure RESTful environment, this would be an HTTP 404 error, but this code may be used where the content is not found further into the application architecture.";
      case TOOLONG: return "Provided content is too long (typically, this is a denial of service protection type of error).";
      case CODEINVALID: return "The code or system could not be understood, or it was not valid in the context of a particular ValueSet.code.";
      case EXTENSION: return "An extension was found that was not acceptable, could not be resolved, or a modifierExtension was not recognized.";
      case TOOCOSTLY: return "The operation was stopped to protect server resources; e.g. a request for a value set expansion on all of SNOMED CT.";
      case BUSINESSRULE: return "The content/operation failed to pass some business rule, and so could not proceed.";
      case CONFLICT: return "Content could not be accepted because of an edit conflict (i.e. version aware updates) (In a pure RESTful environment, this would be an HTTP 404 error, but this code may be used where the conflict is discovered further into the application architecture.)";
      case INCOMPLETE: return "Not all data sources typically accessed could be reached, or responded in time, so the returned information may not be complete.";
      case TRANSIENT: return "Transient processing issues. The system receiving the error may be able to resubmit the same content once an underlying issue is resolved.";
      case LOCKERROR: return "A resource/record locking failure (usually in an underlying database).";
      case NOSTORE: return "The persistent store is unavailable; e.g. the database is down for maintenance or similar action.";
      case EXCEPTION: return "An unexpected internal error has occurred.";
      case TIMEOUT: return "An internal timeout has occurred.";
      case THROTTLED: return "The system is not prepared to handle this request due to load management.";
      case INFORMATIONAL: return "A message unrelated to the processing success of the completed operation (examples of the latter include things like reminders of password expiry, system maintenance times, etc.).";
      case NULL: return null;
      default: return "?";
      }
    }
    public String getDisplay() {
      switch (this) {
      case INVALID: return "Invalid Content";
      case STRUCTURE: return "Structural Issue";
      case REQUIRED: return "Required element missing";
      case VALUE: return "Element value invalid";
      case INVARIANT: return "Validation rule failed";
      case SECURITY: return "Security Problem";
      case LOGIN: return "Login Required";
      case UNKNOWN: return "Unknown User";
      case EXPIRED: return "Session Expired";
      case FORBIDDEN: return "Forbidden";
      case SUPPRESSED: return "Information  Suppressed";
      case PROCESSING: return "Processing Failure";
      case NOTSUPPORTED: return "Content not supported";
      case DUPLICATE: return "Duplicate";
      case NOTFOUND: return "Not Found";
      case TOOLONG: return "Content Too Long";
      case CODEINVALID: return "Invalid Code";
      case EXTENSION: return "Unacceptable Extension";
      case TOOCOSTLY: return "Operation Too Costly";
      case BUSINESSRULE: return "Business Rule Violation";
      case CONFLICT: return "Edit Version Conflict";
      case INCOMPLETE: return "Incomplete Results";
      case TRANSIENT: return "Transient Issue";
      case LOCKERROR: return "Lock Error";
      case NOSTORE: return "No Store Available";
      case EXCEPTION: return "Exception";
      case TIMEOUT: return "Timeout";
      case THROTTLED: return "Throttled";
      case INFORMATIONAL: return "Informational Note";
      case NULL: return null;
      default: return "?";
      }
    }
  }


  private Source source;
  private String server;
  private int line;
  private int col;
  private String location; // fhirPath
  private String message;
  private String messageId; // source, for grouping
  private IssueType type;
  private IssueSeverity level;
  private String html;
  private String locationLink;
  private String txLink;
  public String sliceHtml;
  private boolean slicingHint;
  private boolean signpost;
  private boolean criticalSignpost;
  private Date ruleDate;
  public static final String NO_RULE_DATE = null;
  private boolean matched; // internal use counting matching filters
  private boolean ignorableError;
  private String invId;
  private String comment;
  private List<ValidationMessage> sliceInfo;
  private int count;

  /**
   * Constructor
   */
  public ValidationMessage() {
    // nothing
  }

  public ValidationMessage(Source source, IssueType type, String path, String message, IssueSeverity level) {
    this();
    this.line = -1;
    this.col = -1;
    this.location = path;
    if (message == null)
      throw new Error("message is null");
    this.message = message;
    this.html = Utilities.escapeXml(message);
    this.level = level;
    this.source = source;
    this.type = type;
    if (level == IssueSeverity.NULL)
      determineLevel(path);
    if (type == null)
      throw new Error("A type must be provided");
  }

  public ValidationMessage(Source source, IssueType type, int line, int col, String path, String message, IssueSeverity level) {
    this();
    this.line = line;
    this.col = col;
    this.location = path;
    this.message = message;
    this.html = Utilities.escapeXml(message);
    this.level = level;
    this.source = source;
    this.type = type;
    if (level == IssueSeverity.NULL)
      determineLevel(path);
    if (type == null)
      throw new Error("A type must be provided");
  }

  public ValidationMessage(Source source, IssueType type, String path, String message, String html, IssueSeverity level) {
    this();
    this.line = -1;
    this.col = -1;
    this.location = path;
    if (message == null)
      throw new Error("message is null");
    this.message = message;
    this.html = html;
    this.level = level;
    this.source = source;
    this.type = type;
    if (level == IssueSeverity.NULL)
      determineLevel(path);
    if (type == null)
      throw new Error("A type must be provided");
  }

  public ValidationMessage(Source source, IssueType type, int line, int col, String path, String message, String html, IssueSeverity level) {
    this();
    this.line = line;
    this.col = col;
    this.location = path;
    if (message == null)
      throw new Error("message is null");
    this.message = message;
    this.html = html;
    this.level = level;
    this.source = source;
    this.type = type;
    if (level == IssueSeverity.NULL)
      determineLevel(path);
    if (type == null)
      throw new Error("A type must be provided");
  }

  private IssueSeverity determineLevel(String path) {
    if (isGrandfathered(path))
      return IssueSeverity.WARNING;
    else
      return IssueSeverity.ERROR;
  }

  private boolean isGrandfathered(String path) {
    if (path.startsWith("xds-documentmanifest."))
      return true;
    if (path.startsWith("observation-device-metric-devicemetricobservation."))
      return true;
    if (path.startsWith("medicationadministration-immunization-vaccine."))
      return true;
    if (path.startsWith("elementdefinition-de-dataelement."))
      return true;
    if (path.startsWith("dataelement-sdc-sdcelement."))
      return true;
    if (path.startsWith("questionnaireresponse-sdc-structureddatacaptureanswers."))
      return true;
    if (path.startsWith("valueset-sdc-structureddatacapturevalueset."))
      return true;
    if (path.startsWith("dataelement-sdc-de-sdcelement."))
      return true;
    if (path.startsWith("do-uslab-uslabdo."))
      return true;
    if (path.startsWith("."))
      return true;
    if (path.startsWith("."))
      return true;
    if (path.startsWith("."))
      return true;
    if (path.startsWith("."))
      return true;

    return false;
  }

  public String getMessage() {
    return message+showCount();
  }
  
  private String showCount() {
    return count == 0 ? "" : " (also in "+count+" other files)";
  }

  public ValidationMessage setMessage(String message) {
    this.message = message;
    return this;
  }

  public IssueSeverity getLevel() {
    return level;
  }
  public ValidationMessage setLevel(IssueSeverity level) {
    this.level = level;
    return this;
  }

  public Source getSource() {
    return source;
  }
  public ValidationMessage setSource(Source source) {
    this.source = source;
    return this;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int theLine) {
    line = theLine;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int theCol) {
    col = theCol;
  }

  public String getLocation() {
    return location;
  }
  public ValidationMessage setLocation(String location) {
    this.location = location;
    return this;
  }

  public IssueType getType() {
    return type;
  }

  public ValidationMessage setType(IssueType type) {
    this.type = type;
    return this;
  }

  public String summary() {
    return level.toString()+" @ "+location+(line>= 0 && col >= 0 ? " (line "+Integer.toString(line)+", col"+Integer.toString(col)+"): " : ": ") +message+showCount() +(server != null ? " (src = "+server+")" : "");
  }

  public String summaryNoLevel() {
    return location+(line>= 0 && col >= 0 ? " (line "+Integer.toString(line)+", col"+Integer.toString(col)+"): " : ": ") +message+showCount() +(server != null ? " (src = "+server+")" : "");
  }


  public String toXML() {
    return "<message source=\"" + source + "\" line=\"" + line + "\" col=\"" + col + "\" location=\"" + Utilities.escapeXml(location) + "\" type=\"" + type + "\" level=\"" + level + "\" display=\"" + Utilities.escapeXml(getDisplay()) + "\" ><plain>" + Utilities.escapeXml(message)+showCount() + "</plain><html>" + html + "</html></message>";
  }

  public String getHtml() {
    return (html == null ? Utilities.escapeXml(message) : html)+showCount();
  }

  public String getDisplay() {
    return level + ": " + (location==null || location.isEmpty() ? "" : (location + ": ")) + message+showCount();
  }

  /**
   * Returns a representation of this ValidationMessage suitable for logging. The values of
   * most of the internal fields are included, so this may not be suitable for display to 
   * an end user.
   */
  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
    b.append("level", level);
    b.append("type", type);
    b.append("location", location);
    b.append("message", message+showCount());
    return b.build();
  }

  @Override
  public boolean equals(Object o) {
    return (
      this.getMessage() != null && this.getMessage().equals(((ValidationMessage)o).getMessage()))
      && (this.getLocation() != null && this.getLocation().equals(((ValidationMessage)o).getLocation()));
  }

  @Override
  public int compare(ValidationMessage x, ValidationMessage y) {
    String sx = x.getLevel().getDisplay() + x.getType().getDisplay() + String.format("%06d", x.getLine()) + x.getMessage();
    String sy = y.getLevel().getDisplay() + y.getType().getDisplay() + String.format("%06d", y.getLine()) + y.getMessage();
    return sx.compareTo(sy);
  }  

  @Override
  public int compareTo(ValidationMessage y) {
    return compare(this, y);
  }

  public String getLocationLink() {
    return locationLink;
  }

  public ValidationMessage setLocationLink(String locationLink) {
    this.locationLink = locationLink;
    return this;
  }

  public String getTxLink() {
    return txLink;
  }

  public ValidationMessage setTxLink(String txLink) {
    this.txLink = txLink;
    return this;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public boolean isSlicingHint() {
    return slicingHint;
  }

  public ValidationMessage setSlicingHint(boolean slicingHint) {
    this.slicingHint = slicingHint;
    return this;
  }

  public String getSliceHtml() {
    return sliceHtml;
  }

  public ValidationMessage setSliceHtml(String sliceHtml, List<ValidationMessage> info) {
    this.sliceHtml = sliceHtml;
    if (info != null) {
      if (this.sliceInfo == null) {
        this.sliceInfo = new ArrayList<ValidationMessage>();
      }
      this.sliceInfo.addAll(info);
    }
    return this;
  }

  public String getMessageId() {
    return messageId;
  }

  public ValidationMessage setMessageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  public boolean isSignpost() {
    return signpost;
  }

  public ValidationMessage setSignpost(boolean signpost) {
    this.signpost = signpost;
    return this;
  }

  public boolean isCriticalSignpost() {
    return criticalSignpost;
  }

  public ValidationMessage setCriticalSignpost(boolean criticalSignpost) {
    this.criticalSignpost = criticalSignpost;
    return this;
  }

  public Date getRuleDate() {
    return ruleDate;
  }

  public ValidationMessage setRuleDate(Date ruleDate) {
    this.ruleDate = ruleDate;
    return this;
  }


  public ValidationMessage setRuleDate(String value) {
    if (value == null) {
      ruleDate = null;
    } else {
      Date d = null;
      try {
        d = new SimpleDateFormat("yyyy-MM-dd").parse(value);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      ruleDate = d;
    }
    return this;
  }

  public boolean isError() {
    return level == IssueSeverity.ERROR || level == IssueSeverity.FATAL;
  }

  public boolean isMatched() {
    return matched;
  }

  public void setMatched(boolean matched) {
    this.matched = matched;
  }

  public boolean isIgnorableError() {
    return ignorableError;
  }

  public ValidationMessage setIgnorableError(boolean ignorableError) {
    this.ignorableError = ignorableError;
    return this;
  }

  public boolean matches(ValidationMessage other) {
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else {
      String l1 = preprocessLocation(location);
      String l2 = preprocessLocation(other.location);
      if (!l1.equals(l2)) {
        return false;
      }
    }
    if (message == null) {
      if (other.message != null) {
        return false;
      }
    } else if (!message.equals(other.message)) {
      return false;
    }
    if (messageId == null) {
      if (other.messageId != null) {
        return false;
      }
    } else if (!messageId.equals(other.messageId)) {
      return false;
    }
    if (type != other.type) {
      return false;
    }
    if (level != other.level) {
      return false;
    }
    return true;
  }

  private String preprocessLocation(String loc) {
    // some locations are prefixes with a location but they're not different since the location is fixed where .match is called from 
    if (loc.contains(": ")) {
      return loc.substring(loc.indexOf(": ")+2);
    }
    return loc;
  }

  public String getInvId() {
    return invId;
  }

  public ValidationMessage setInvId(String invId) {
    this.invId = invId;
    return this;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public List<ValidationMessage> getSliceInfo() {
    return sliceInfo;
  }

  public void setSliceInfo(List<ValidationMessage> sliceInfo) {
    this.sliceInfo = sliceInfo;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public void incCount() {
    count++;
  }

  public boolean containsText(List<String> fragements) {
    for (String s : fragements) {
      if ((getMessage() != null && getMessage().contains(s)) || (getMessageId() != null && getMessageId().contains(s))) {
        return true;
      }
    }
    return false;
  }

  public boolean hasSliceInfo() {
    return sliceInfo != null && !sliceInfo.isEmpty();
  }

  public boolean preciseMatch(ValidationMessage other) {
    if (other == null) {
      return false;
    }

    // Compare source
    if (this.source != other.source) {
      return false;
    }

    // Compare server
    if (!Objects.equals(this.server, other.server)) {
      return false;
    }

    // Compare line
    if (this.line != other.line) {
      return false;
    }

    // Compare col
    if (this.col != other.col) {
      return false;
    }

    // Compare location
    if (!Objects.equals(this.location, other.location)) {
      return false;
    }

    // Compare message
    if (!Objects.equals(this.message, other.message)) {
      return false;
    }

    // Compare messageId
    if (!Objects.equals(this.messageId, other.messageId)) {
      return false;
    }

    // Compare type
    if (this.type != other.type) {
      return false;
    }

    // Compare level
    if (this.level != other.level) {
      return false;
    }

    // Compare html
    if (!Objects.equals(this.html, other.html)) {
      return false;
    }

    // Compare locationLink
    if (!Objects.equals(this.locationLink, other.locationLink)) {
      return false;
    }

    // Compare txLink
    if (!Objects.equals(this.txLink, other.txLink)) {
      return false;
    }

    // Compare sliceHtml
    if (!Objects.equals(this.sliceHtml, other.sliceHtml)) {
      return false;
    }

    // Compare slicingHint
    if (this.slicingHint != other.slicingHint) {
      return false;
    }

    // Compare signpost
    if (this.signpost != other.signpost) {
      return false;
    }

    // Compare criticalSignpost
    if (this.criticalSignpost != other.criticalSignpost) {
      return false;
    }

    // Compare ruleDate
    if (!Objects.equals(this.ruleDate, other.ruleDate)) {
      return false;
    }

    // Compare matched
    if (this.matched != other.matched) {
      return false;
    }

    // Compare ignorableError
    if (this.ignorableError != other.ignorableError) {
      return false;
    }

    // Compare invId
    if (!Objects.equals(this.invId, other.invId)) {
      return false;
    }

    // Compare comment
    if (!Objects.equals(this.comment, other.comment)) {
      return false;
    }

    // Compare sliceInfo
    if (!Objects.equals(this.sliceInfo, other.sliceInfo)) {
      return false;
    }


    return true;
  }
}