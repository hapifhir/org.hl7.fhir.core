package org.hl7.fhir.dstu3.context;

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



import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.hl7.fhir.dstu3.formats.IParser;
import org.hl7.fhir.dstu3.formats.ParserType;
import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;


/**
 * This is the standard interface used for access to underlying FHIR
 * services through the tools and utilities provided by the reference
 * implementation. 
 * 
 * The functionality it provides is 
 *  - get access to parsers, validators, narrative builders etc
 *    (you can't create these directly because they need access 
 *    to the right context for their information)
 *    
 *  - find resources that the tools need to carry out their tasks
 *  
 *  - provide access to terminology services they need. 
 *    (typically, these terminology service requests are just
 *    passed through to the local implementation's terminology
 *    service)    
 *  
 * @author Grahame
 */

public interface IWorkerContext {

  /**
   * Get the versions of the definitions loaded in context
   * @return
   */
  public String getVersion();
  
  // -- Parsers (read and write instances) ----------------------------------------


  /**
   * Get a parser to read/write instances. Use the defined type (will be extended 
   * as further types are added, though the only currently anticipate type is RDF)
   * 
   * XML/JSON - the standard renderers
   * XHTML - render the narrative only (generate it if necessary)
   * 
   * @param type
   * @return
   */
  public IParser getParser(ParserType type);

  /**
   * Get a parser to read/write instances. Determine the type 
   * from the stated type. Supported value for type:
   * - the recommended MIME types
   * - variants of application/xml and application/json
   * - _format values xml, json
   * 
   * @param type
   * @return
   */	
  public IParser getParser(String type);

  /**
   * Get a JSON parser
   * 
   * @return
   */
  public IParser newJsonParser();

  /**
   * Get an XML parser
   * 
   * @return
   */
  public IParser newXmlParser();

  // -- resource fetchers ---------------------------------------------------

  /**
   * Find an identified resource. The most common use of this is to access the the 
   * standard conformance resources that are part of the standard - structure 
   * definitions, value sets, concept maps, etc.
   * 
   * Also, the narrative generator uses this, and may access any kind of resource
   * 
   * The URI is called speculatively for things that might exist, so not finding 
   * a matching resouce, return null, not an error
   * 
   * The URI can have one of 3 formats:
   *  - a full URL e.g. http://acme.org/fhir/ValueSet/[id]
   *  - a relative URL e.g. ValueSet/[id]
   *  - a logical id e.g. [id]
   *  
   * It's an error if the second form doesn't agree with class_. It's an 
   * error if class_ is null for the last form
   * 
   * @param resource
   * @param Reference
   * @return
   * @throws FHIRException 
   * @throws Exception
   */
  public <T extends Resource> T fetchResource(Class<T> class_, String uri);
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri) throws FHIRException;

  /**
   * find whether a resource is available. 
   * 
   * Implementations of the interface can assume that if hasResource ruturns 
   * true, the resource will usually be fetched subsequently
   * 
   * @param class_
   * @param uri
   * @return
   */
  public <T extends Resource> boolean hasResource(Class<T> class_, String uri);

  // -- profile services ---------------------------------------------------------
  
  public List<String> getResourceNames();
  public Set<String> getResourceNamesAsSet();
  public List<String> getTypeNames();
  public List<StructureDefinition> allStructures();
  public List<MetadataResource> allConformanceResources();
  
  // -- Terminology services ------------------------------------------------------

  public ExpansionProfile getExpansionProfile();
  public void setExpansionProfile(ExpansionProfile expProfile);

  // these are the terminology services used internally by the tools
  /**
   * Find the code system definition for the nominated system uri. 
   * return null if there isn't one (then the tool might try 
   * supportsSystem)
   * 
   * @param system
   * @return
   */
  public CodeSystem fetchCodeSystem(String system);

  /**
   * True if the underlying terminology service provider will do 
   * expansion and code validation for the terminology. Corresponds
   * to the extension 
   * 
   * http://hl7.org/fhir/StructureDefinition/capabilitystatement-supported-system
   * 
   * in the Conformance resource
   * 
   * @param system
   * @return
   * @throws Exception 
   */
  public boolean supportsSystem(String system) throws TerminologyServiceException;

  /**
   * find concept maps for a source
   * @param url
   * @return
   */
  public List<ConceptMap> findMapsForSource(String url);  

  /**
   * ValueSet Expansion - see $expand
   *  
   * @param source
   * @return
   */
  public ValueSetExpansionOutcome expandVS(ValueSet source, boolean cacheOk, boolean heiarchical);
  
  /**
   * Value set expanion inside the internal expansion engine - used 
   * for references to supported system (see "supportsSystem") for
   * which there is no value set. 
   * 
   * @param inc
   * @return
   * @throws FHIRException 
   */
  public ValueSetExpansionComponent expandVS(ConceptSetComponent inc, boolean heiarchical) throws TerminologyServiceException;

  Locale getLocale();

  void setLocale(Locale locale);

  String formatMessage(String theMessage, Object... theMessageArguments);

  void setValidationMessageLanguage(Locale locale);

  public class ValidationResult {
    private ConceptDefinitionComponent definition;
    private IssueSeverity severity;
    private String message;
    private TerminologyServiceErrorClass errorClass;
    
    public ValidationResult(IssueSeverity severity, String message) {
      this.severity = severity;
      this.message = message;
    }
    
    public ValidationResult(ConceptDefinitionComponent definition) {
      this.definition = definition;
    }

    public ValidationResult(IssueSeverity severity, String message, ConceptDefinitionComponent definition) {
      this.severity = severity;
      this.message = message;
      this.definition = definition;
    }
    
    public ValidationResult(IssueSeverity severity, String message, TerminologyServiceErrorClass errorClass) {
      this.severity = severity;
      this.message = message;
      this.errorClass = errorClass;
    }

    public boolean isOk() {
      return definition != null;
    }

    public String getDisplay() {
// We don't want to return question-marks because that prevents something more useful from being displayed (e.g. the code) if there's no display value
//      return definition == null ? "??" : definition.getDisplay();
      return definition == null ? null : definition.getDisplay();
    }

    public ConceptDefinitionComponent asConceptDefinition() {
      return definition;
    }

    public IssueSeverity getSeverity() {
      return severity;
    }

    public String getMessage() {
      return message;
    }

    public boolean IsNoService() {
      return errorClass == TerminologyServiceErrorClass.NOSERVICE;
    }

    public TerminologyServiceErrorClass getErrorClass() {
      return errorClass;
    }



    public Parameters getOrMakeParameters() {
      Parameters p = new Parameters();
      p.addParameter().setName("result").setValue(new BooleanType(isOk()));
      if (getMessage() != null) {
        p.addParameter().setName("message").setValue(new StringType(getMessage()));
      }
      if (getDisplay() != null) {
        p.addParameter().setName("display").setValue(new StringType(getDisplay()));
      }
      return p;
    }
  }

  /**
   * Validation of a code - consult the terminology service 
   * to see whether it is known. If known, return a description of it
   * 
   *  note: always return a result, with either an error or a code description
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * @param system
   * @param code
   * @param display
   * @return
   */
  public ValidationResult validateCode(String system, String code, String display);

  /**
   * Validation of a code - consult the terminology service 
   * to see whether it is known. If known, return a description of it
   * Also, check whether it's in the provided value set
   * 
   * note: always return a result, with either an error or a code description, or both (e.g. known code, but not in the value set)
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * @param system
   * @param code
   * @param display
   * @return
   */
  public ValidationResult validateCode(String system, String code, String display, ValueSet vs);
  public ValidationResult validateCode(Coding code, ValueSet vs);
  public ValidationResult validateCode(CodeableConcept code, ValueSet vs);
  
  /**
   * Validation of a code - consult the terminology service 
   * to see whether it is known. If known, return a description of it
   * Also, check whether it's in the provided value set fragment (for supported systems with no value set definition)
   * 
   * note: always return a result, with either an error or a code description, or both (e.g. known code, but not in the value set)
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * @param system
   * @param code
   * @param display
   * @return
   */
  public ValidationResult validateCode(String system, String code, String display, ConceptSetComponent vsi);

  /**
   * returns the recommended tla for the type 
   * 
   * @param name
   * @return
   */
  public String getAbbreviation(String name);

  // return a set of types that have tails
  public Set<String> typeTails();

	public String oid2Uri(String code);

  public boolean hasCache();

  public interface ILoggingService {
    public enum LogCategory {
      PROGRESS, TX, INIT, CONTEXT, HTML 
    }
    public void logMessage(String message); // status messages, always display
    public void logDebugMessage(LogCategory category, String message); // verbose; only when debugging 
  }

  public void setLogger(ILoggingService logger);

  public boolean isNoTerminologyServer();
  public StructureDefinition fetchTypeDefinition(String typeName);


  /**
   * Some value sets are just too big to expand. Instead of an expanded value set,
   * you get back an interface that can test membership - usually on a server somewhere
   *
   * @author Grahame
   */
  public class ValueSetExpansionOutcome {
    private ValueSet valueset;
    private Object service; // actually a ValueSetChecker, but we shouldn't need this?
    private String error;
    private TerminologyServiceErrorClass errorClass;

    public ValueSetExpansionOutcome(ValueSet valueset) {
      super();
      this.valueset = valueset;
      this.service = null;
      this.error = null;
    }
    public ValueSetExpansionOutcome(ValueSet valueset, String error, TerminologyServiceErrorClass errorClass) {
      super();
      this.valueset = valueset;
      this.service = null;
      this.error = error;
      this.errorClass = errorClass;
    }
    public ValueSetExpansionOutcome(Object service, String error, TerminologyServiceErrorClass errorClass) {
      super();
      this.valueset = null;
      this.service = service;
      this.error = error;
      this.errorClass = errorClass;
    }
    public ValueSetExpansionOutcome(String error, TerminologyServiceErrorClass errorClass) {
      this.valueset = null;
      this.service = null;
      this.error = error;
      this.errorClass = errorClass;
    }
    public ValueSet getValueset() {
      return valueset;
    }
    public Object getService() {
      return service;
    }
    public String getError() {
      return error;
    }
    public TerminologyServiceErrorClass getErrorClass() {
      return errorClass;
    }

    public boolean isOk() {
      return error == null;
    }
  }

  public enum TerminologyServiceErrorClass {
    UNKNOWN, NOSERVICE, SERVER_ERROR, VALUESET_UNSUPPORTED;

    public boolean isInfrastructure() {
      return this == NOSERVICE || this == SERVER_ERROR || this == VALUESET_UNSUPPORTED;
    }
  }
}