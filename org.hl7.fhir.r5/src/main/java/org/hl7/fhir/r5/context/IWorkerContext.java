package org.hl7.fhir.r5.context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
import java.util.Map;
import java.util.Set;

import org.fhir.ucum.UcumService;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.TerminologyCache.CacheToken;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.ParserType;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.profilemodel.PEDefinition;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.TranslationServices;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.gson.JsonSyntaxException;

import javax.annotation.Nonnull;


/**
 * This is the standard interface used for access to underlying FHIR
 * services through the tools and utilities provided by the reference
 * implementation. 
 * 
 * The functionality it provides is 
 *  - get access to canonical resources,terminology services, and validator
 *    (you can't create a validator directly because it needs access 
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

  class ValidationResult {
    private ConceptDefinitionComponent definition;
    private String preferredDisplay;
    private String system;
    private String version;
    private IssueSeverity severity;
    private String message;
    private TerminologyServiceErrorClass errorClass;
    private String txLink;
    private String diagnostics;
    private List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    private CodeableConcept codeableConcept;
    private Set<String> unknownSystems;
    private boolean inactive;
    private String status;
    
    @Override
    public String toString() {
      return "ValidationResult [definition=" + definition + ", system=" + system + ", severity=" + severity + ", message=" + message + ", errorClass="
          + errorClass + ", txLink=" + txLink + "]";
    }

    public ValidationResult(IssueSeverity severity, String message, List<OperationOutcomeIssueComponent> issues) {
      this.severity = severity;
      this.message = message;
      if (issues != null) {
        this.issues.addAll(issues);
      }
    }

    public ValidationResult(String system, String version, ConceptDefinitionComponent definition, String preferredDisplay) {
      this.system = system;
      this.version = version;
      this.definition = definition;
      this.preferredDisplay = preferredDisplay;
    }

    public ValidationResult(IssueSeverity severity, String message, String system, String version, ConceptDefinitionComponent definition, String preferredDisplay, List<OperationOutcomeIssueComponent>  issues) {
      this.severity = severity;
      this.message = message;
      this.system = system;
      this.version = version;
      this.definition = definition;
      this.preferredDisplay = preferredDisplay;
      if (issues != null) {
        this.issues.addAll(issues);
      }
    }

    public ValidationResult(IssueSeverity severity, String message, TerminologyServiceErrorClass errorClass, List<OperationOutcomeIssueComponent>  issues) {
      this.severity = severity;
      this.message = message;
      this.errorClass = errorClass;
      if (issues != null) {
        this.issues.addAll(issues);
      }
    }

    public boolean isOk() {
      return severity == null || severity == IssueSeverity.INFORMATION || severity == IssueSeverity.WARNING;
    }

    public String getSystem() {
      return system;
    }

    public String getVersion() {
      return version;
    }

    public String getDisplay() {
      if (preferredDisplay != null) {
        return preferredDisplay; 
      } else {
        return definition == null ? null : definition.getDisplay();
      }
    }

    public void setDisplay(String display) {
      this.preferredDisplay = display;
    }

    public void setSystem(String system) {
      this.system = system;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    public String getCode() {
      return definition == null ? null : definition.getCode();
    }

    public String getDefinition() {
      return definition == null ? null : definition.getDefinition();
    }

    public void setDefinition(ConceptDefinitionComponent definition) {
      this.definition = definition;
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

    public ValidationResult setSeverity(IssueSeverity severity) {
      this.severity = severity;
      return this;
    }

    public ValidationResult setMessage(String message) {
      this.message = message;
      return this;
    }
    
    public ValidationResult addToMessage(String message) {
      this.message = this.message == null ? message : this.message +"; "+ message; 
      return this;
    }
    
    public ValidationResult setErrorClass(TerminologyServiceErrorClass errorClass) {
      this.errorClass = errorClass;
      return this;
    }

    public String getTxLink() {
      return txLink;
    }

    public ValidationResult setTxLink(String txLink) {
      this.txLink = txLink;
      return this;
    }

    public boolean hasMessage() {
      return message != null;
    }

    public String getDiagnostics() {
      return diagnostics;
    }

    public void setDiagnostics(String diagnostics) {
      this.diagnostics = diagnostics;
    }

    public Coding asCoding() {
      if (isOk() && definition != null && definition.getCode() != null) {
        return new Coding(system, definition.getCode(), definition.getDisplay());
      } else {
        return null;
      }
    }

    public List<OperationOutcomeIssueComponent> getIssues() {
      return issues;
    }

    public ValidationResult addCodeableConcept(CodeableConcept vcc) {
      if (!vcc.isEmpty()) {
        codeableConcept = vcc;
      }
      return this;
    }

    public CodeableConcept getCodeableConcept() {
      return codeableConcept;
    }

    public Set<String> getUnknownSystems() {
      return unknownSystems;
    }

    public ValidationResult setUnknownSystems(Set<String> unknownSystems) {
      this.unknownSystems = unknownSystems;
      return this;
    }

    public String unknownSystems() {
      if (unknownSystems == null) {
        return null;
      }
      if (unknownSystems.size() == 1) {
        return unknownSystems.iterator().next();        
      } else {
        return String.join(",", unknownSystems);
      }
    }

    public void setIssues(List<OperationOutcomeIssueComponent> issues) {
      if (this.issues != null) {
        issues.addAll(this.issues);
      }
      this.issues = issues;
      
    }

    public void trimPath(String prefix) {
      if (issues != null) {
        for (OperationOutcomeIssueComponent iss : issues) {
          for (int i = iss.getLocation().size() -1; i >= 0; i--) {
            var s = iss.getLocation().get(i).primitiveValue();
            if (prefix.equals(s)) {
              iss.getLocation().remove(i);
            } else if (s.startsWith(prefix+".")) {
              iss.getLocation().get(i).setValueAsString(s.substring(prefix.length()+1));                
            }            
          }
        }
      }      
      
    }

    public boolean isInactive() {
      return inactive;
    }

    public String getStatus() {
      return status;
    }

    public ValidationResult setStatus(boolean inactive, String status) {
      this.inactive = inactive;
      if (!"inactive".equals(status)) {
        this.status = status;
      }
      return this;
    }

  }

  public class CodingValidationRequest {
    private Coding coding;
    private ValidationResult result;
    private CacheToken cacheToken;
    private String vs;
    private ValueSet vsObj;

    public CodingValidationRequest(Coding coding) {
      super();
      this.coding = coding;
    }

    public CodingValidationRequest(Coding coding, String vs) {
      super();
      this.coding = coding;
      this.vs = vs;
    }

    public CodingValidationRequest(Coding coding, ValueSet vsObj) {
      super();
      this.coding = coding;
      this.vsObj = vsObj;
    }

    public String getVs() {
      return vs;
    }

    public ValueSet getVsObj() {
      return vsObj;
    }

    public ValidationResult getResult() {
      return result;
    }

    public void setResult(ValidationResult result) {
      this.result = result;
    }

    public Coding getCoding() {
      return coding;
    }

    public boolean hasResult() {
      return result != null;
    }

    /**
     * internal logic; external users of batch validation should ignore this property
     * 
     * @return
     */
    public CacheToken getCacheToken() {
      return cacheToken;
    }

    /**
     * internal logic; external users of batch validation should ignore this property
     * 
     * @param cacheToken
     */
    public void setCacheToken(CacheToken cacheToken) {
      this.cacheToken = cacheToken;
    }


  }


  public interface IContextResourceLoader {
    /** 
     * @return List of the resource types that should be loaded
     */
    List<String> getTypes();

    /**
     * Request to actually load the resources and do whatever is required
     *  
     * @param stream
     * @param isJson
     * @return A bundle because some single resources become multiple resources after loading
     * @throws FHIRException
     * @throws IOException
     */
    Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException;

    /**
     * Load a single resources (lazy load)
     * 
     * @param stream
     * @param isJson
     * @return
     * @throws FHIRException - throw this if you a single resource can't be returned - can't lazy load in this circumstance   
     * @throws IOException
     */
    Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException;

    /** 
     * get the path for references to this resource.
     * @param resource
     * @return null if not tracking paths
     */
    String getResourcePath(Resource resource);

    /**
     * called when a new package is being loaded
     * 
     * this is called by loadPackageAndDependencies when a new package is loaded
     * @param npm
     * @return
     * @throws IOException 
     * @throws JsonSyntaxException 
     */
    IContextResourceLoader getNewLoader(NpmPackage npm) throws JsonSyntaxException, IOException;

    /**
     * called when processing R2 for implicit code systems in ValueSets 
     * 
     * @return
     */
    List<CodeSystem> getCodeSystems();  
    
    /**
     * if this is true, then the loader will patch canonical URLs and cross-links 
     * to add /X.X/ into the URL so that different versions can be loaded safely 
     * 
     * default is false
     */
    void setPatchUrls(boolean value);

    /**
     * patch the URL if necessary
     * 
     * @param url
     * @return
     */
    String patchUrl(String url, String resourceType);
    
    /** 
     * set this to false (default is true) if you don't want profiles loaded
     * @param value
     * @return
     */
    IContextResourceLoader setLoadProfiles(boolean value);
    
    /**
     * Called during the loading process - the loader can decide which resources to load. 
     * At this point, only the .index.json is being read 
     *  
     * @param pi
     * @param pri
     * @return
     */
    boolean wantLoad(NpmPackage pi, PackageResourceInformation pri);
  }

  /**
   * Get the version of the definitions loaded in context
   * This *does not* have to be 5.0 (R5) - the context can load other versions
   * 
   * @return
   */
  public String getVersion();

  /**
   * Get the UCUM service that provides access to units of measure reasoning services 
   * 
   * This service might not be available 
   * 
   * @return
   */
  public UcumService getUcumService();
  public void setUcumService(UcumService ucumService);

  /**
   * Get a validator that can check whether a resource is valid 
   * 
   * @return a prepared generator
   * @throws FHIRException 
   * @
   */
  public IResourceValidator newValidator() throws FHIRException;

  // -- resource fetchers ---------------------------------------------------

  /**
   * Find an identified resource. The most common use of this is to access the the 
   * standard conformance resources that are part of the standard - structure 
   * definitions, value sets, concept maps, etc.
   * 
   * Also, the narrative generator uses this, and may access any kind of resource
   * 
   * The URI is called speculatively for things that might exist, so not finding 
   * a matching resource, return null, not an error
   * 
   * The URI can have one of 3 formats:
   *  - a full URL e.g. http://acme.org/fhir/ValueSet/[id]
   *  - a relative URL e.g. ValueSet/[id]
   *  - a logical id e.g. [id]
   *  
   * It's an error if the second form doesn't agree with class_. It's an 
   * error if class_ is null for the last form
   * 
   * class can be Resource, DomainResource or CanonicalResource, which means resource of all kinds
   * 
   * @param resource
   * @param Reference
   * @return
   * @throws FHIRException 
   * @throws Exception
   */
  public <T extends Resource> T fetchResource(Class<T> class_, String uri);
  public <T extends Resource> T fetchResourceRaw(Class<T> class_, String uri);
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri) throws FHIRException;
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri, Resource sourceOfReference) throws FHIRException;
  public <T extends Resource> T fetchResource(Class<T> class_, String uri, String version);

  /** has the same functionality as fetchResource, but passes in information about the source of the 
   * reference (this may affect resolution of version)
   *  
   * @param <T>
   * @param class_
   * @param uri
   * @param canonicalForSource
   * @return
   */
  public <T extends Resource> T fetchResource(Class<T> class_, String uri, Resource sourceOfReference);

  /** 
   * Fetch all the resources of a particular type. if class == (null | Resource | DomainResource | CanonicalResource) return everything
   *  
   * @param <T>
   * @param class_
   * @param uri
   * @param canonicalForSource
   * @return
   */
  public <T extends Resource> List<T> fetchResourcesByType(Class<T> class_);

  /**
   * Variation of fetchResource when you have a string type, and don't need the right class
   * 
   * The URI can have one of 3 formats:
   *  - a full URL e.g. http://acme.org/fhir/ValueSet/[id]
   *  - a relative URL e.g. ValueSet/[id]
   *  - a logical id e.g. [id]
   *  
   * if type == null, the URI can't be a simple logical id
   * 
   * @param type
   * @param uri
   * @return
   */
  public Resource fetchResourceById(String type, String uri);

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

  /**
   * cache a resource for later retrieval using fetchResource.
   * 
   * Note that various context implementations will have their own ways of loading
   * rseources, and not all need implement cacheResource.
   * 
   * If the resource is loaded out of a package, call cacheResourceFromPackage instead
   * @param res
   * @throws FHIRException 
   */
  public void cacheResource(Resource res) throws FHIRException;

  /**
   * cache a resource for later retrieval using fetchResource.
   * 
   * The package information is used to help manage the cache internally, and to 
   * help with reference resolution. Packages should be define using cachePackage (but don't have to be)
   *    
   * Note that various context implementations will have their own ways of loading
   * rseources, and not all need implement cacheResource
   * 
   * @param res
   * @throws FHIRException 
   */
  public void cacheResourceFromPackage(Resource res, PackageInformation packageInfo) throws FHIRException;

  /**
   * Inform the cache about package dependencies. This can be used to help resolve references
   * 
   * Note that the cache doesn't load dependencies
   *  
   * @param packageInfo
   */
  public void cachePackage(PackageInformation packageInfo);

  // -- profile services ---------------------------------------------------------

  /**
   * @return a list of the resource names defined for this version
   */
  public List<String> getResourceNames();
  /**
   * @return a set of the resource names defined for this version
   */
  public Set<String> getResourceNamesAsSet();

  // -- Terminology services ------------------------------------------------------

  /**
   * Set the expansion parameters passed through the terminology server when txServer calls are made
   * 
   * Note that the Validation Options override these when they are specified on validateCode
   */
  public Parameters getExpansionParameters();

  /**
   * Get the expansion parameters passed through the terminology server when txServer calls are made
   * 
   * Note that the Validation Options override these when they are specified on validateCode
   */
  public void setExpansionProfile(Parameters expParameters);

  // these are the terminology services used internally by the tools
  /**
   * Find the code system definition for the nominated system uri. 
   * return null if there isn't one (then the tool might try 
   * supportsSystem)
   * 
   * This is a short cut for fetchResource(CodeSystem.class...)
   * 
   * @param system
   * @return
   */
  public CodeSystem fetchCodeSystem(String system);
  public CodeSystem fetchCodeSystem(String system, String version);

  /**
   * Like fetchCodeSystem, except that the context will find any CodeSysetm supplements and merge them into the
   * @param system
   * @return
   */
  public CodeSystem fetchSupplementedCodeSystem(String system);
  public CodeSystem fetchSupplementedCodeSystem(String system, String version);

  /**
   * True if the underlying terminology service provider will do 
   * expansion and code validation for the terminology. Corresponds
   * to the extension 
   * 
   * http://hl7.org/fhir/StructureDefinition/capabilitystatement-supported-system
   * 
   * in the Conformance resource
   * 
   * Not that not all supported code systems have an available CodeSystem resource
   * 
   * @param system
   * @return
   * @throws Exception 
   */
  public boolean supportsSystem(String system) throws TerminologyServiceException;

  /**
   * ValueSet Expansion - see $expand
   *  
   * @param source
   * @return
   */
  public ValueSetExpansionOutcome expandVS(ValueSet source, boolean cacheOk, boolean heiarchical);

  /**
   * ValueSet Expansion - see $expand
   *  
   * @param source
   * @return
   */
  public ValueSetExpansionOutcome expandVS(ValueSet source, boolean cacheOk, boolean heiarchical, boolean incompleteOk);

  /**
   * ValueSet Expansion - see $expand, but resolves the binding first
   *  
   * @param source
   * @return
   * @throws FHIRException 
   */
  public ValueSetExpansionOutcome expandVS(Resource src, ElementDefinitionBindingComponent binding, boolean cacheOk, boolean heiarchical) throws FHIRException;

  /**
   * Value set expanion inside the internal expansion engine - used 
   * for references to supported system (see "supportsSystem") for
   * which there is no value set. 
   * 
   * @param inc
   * @return
   * @throws FHIRException 
   */
  ValueSetExpansionOutcome expandVS(ConceptSetComponent inc, boolean hierarchical, boolean noInactive) throws TerminologyServiceException;

  /**
   * get/set the locale used when creating messages
   * 
   * todo: what's the difference?
   * 
   * @return
   */
  Locale getLocale();
  void setLocale(Locale locale);
  void setValidationMessageLanguage(Locale locale);

  /**
   * Access to the contexts internationalised error messages
   *  
   * @param theMessage
   * @param theMessageArguments
   * @return
   */
  String formatMessage(String theMessage, Object... theMessageArguments);
  String formatMessagePlural(Integer pluralNum, String theMessage, Object... theMessageArguments);

  /**
   * Validation of a code - consult the terminology infrstructure and/or service 
   * to see whether it is known. If known, return a description of it
   * 
   * note: always return a result, with either an error or a code description
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * in this case, the system will be inferred from the value set. It's an error to call this one without the value set
   * 
   * @param options - validation options (required)
   * @param code he code to validate (required)
   * @param vs the applicable valueset (required)
   * @return
   */
  public ValidationResult validateCode(ValidationOptions options, String code, ValueSet vs);

  /**
   * Validation of a code - consult the terminology infrstructure and/or service 
   * to see whether it is known. If known, return a description of it
   * 
   * note: always return a result, with either an error or a code description
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * @param options - validation options (required)
   * @param system - equals Coding.system (required)
   * @param code - equals Coding.code (required)
   * @param display - equals Coding.display (optional)
   * @return
   */
  public ValidationResult validateCode(ValidationOptions options, String system, String version, String code, String display);

  /**
   * Validation of a code - consult the terminology infrstructure and/or service 
   * to see whether it is known. If known, return a description of it
   * 
   * note: always return a result, with either an error or a code description
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * @param options - validation options (required)
   * @param system - equals Coding.system (required)
   * @param code - equals Coding.code (required)
   * @param display - equals Coding.display (optional)
   * @param vs the applicable valueset (optional)
   * @return
   */
  public ValidationResult validateCode(ValidationOptions options, String system, String version, String code, String display, ValueSet vs);

  /**
   * Validation of a code - consult the terminology infrstructure and/or service 
   * to see whether it is known. If known, return a description of it
   * 
   * note: always return a result, with either an error or a code description
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * Note that this doesn't validate binding strength (e.g. is just text allowed?)
   * 
   * @param options - validation options (required)
   * @param code - CodeableConcept to validate
   * @param vs the applicable valueset (optional)
   * @return
   */
  public ValidationResult validateCode(ValidationOptions options, CodeableConcept code, ValueSet vs);

  /**
   * Validation of a code - consult the terminology infrstructure and/or service 
   * to see whether it is known. If known, return a description of it
   * 
   * note: always return a result, with either an error or a code description
   *  
   * corresponds to 2 terminology service calls: $validate-code and $lookup
   * 
   * in this case, the system will be inferred from the value set. It's an error to call this one without the value set
   * 
   * @param options - validation options (required)
   * @param code - Coding to validate
   * @param vs the applicable valueset (optional)
   * @return
   */
  public ValidationResult validateCode(ValidationOptions options, Coding code, ValueSet vs);

  /** 
   * See comments in ValidationContextCarrier. This is called when there might be additional value sets etc 
   * available in the context, but we don't want to pre-process them. 
   * 
   * @param options
   * @param code
   * @param vs
   * @param ctxt
   * @return
   */
  public ValidationResult validateCode(ValidationOptions options, Coding code, ValueSet vs, ValidationContextCarrier ctxt);

  /**
   * Batch validate code - reduce latency and do a bunch of codes in a single server call. 
   * Each is the same as a validateCode
   * 
   * @param options
   * @param codes
   * @param vs
   */
  public void validateCodeBatch(ValidationOptions options, List<? extends CodingValidationRequest> codes, ValueSet vs);
  public void validateCodeBatchByRef(ValidationOptions options, List<? extends CodingValidationRequest> codes, String vsUrl);


  // todo: figure these out
  public Map<String, NamingSystem> getNSUrlMap();
  public TranslationServices translator();

  public interface ILoggingService {
    public enum LogCategory {
      INIT, 
      PROGRESS,
      TX, 
      CONTEXT, 
      GENERATE,
      HTML 
    }
    public void logMessage(String message); // status messages, always display
    public void logDebugMessage(LogCategory category, String message); // verbose; only when debugging 
    public boolean isDebugLogging(); // whether to log debug information
  }
  public void setLogger(@Nonnull ILoggingService logger);
  public ILoggingService getLogger();

  public boolean isNoTerminologyServer();
  public Set<String> getCodeSystemsUsed();
  public int getClientRetryCount();
  public IWorkerContext setClientRetryCount(int value);

  public TimeTracker clock();

  /**
   * This is a short cut for fetchResource(StructureDefinition.class, ...)
   * but it accepts a typename - that is, it resolves based on StructureDefinition.type 
   * or StructureDefinition.url. This only resolves to http://hl7.org/fhir/StructureDefinition/{typename}
   * 
   * @param typeName
   * @return
   */
  public StructureDefinition fetchTypeDefinition(String typeName);

  /**
   * This finds all the structure definitions that have the given typeName
   * 
   * @param typeName
   * @return
   */
  public List<StructureDefinition> fetchTypeDefinitions(String n);

  /**
   * return whether type is primitive type. This is called a lot, and needs a high performance implementation 
   * @param type
   * @return
   */
  public boolean isPrimitiveType(String type);

  /**
   * return whether type is data type. This is called a lot, and needs a high performance implementation 
   * @param type
   * @return
   */
  public boolean isDataType(String type);
  
  /**
   * Returns a set of keys that can be used to get binaries from this context.
   * The binaries come from the loaded packages (mostly the pubpack)
   *
   * @return a set of binaries or null
   */
  public Set<String> getBinaryKeysAsSet();

  /**
   * Returns true if this worker context contains a binary for this key.
   *
   * @param binaryKey
   * @return true if binary is available for this key
   */
  public boolean hasBinaryKey(String binaryKey);

  /**
   * Returns the binary for the key
   * @param binaryKey
   * @return
   */
  public byte[] getBinaryForKey(String binaryKey);

  /*
   * Todo: move these loaders out to IWorkerContextManager
   * 
   */
  /**
   * Load relevant resources of the appropriate types (as specified by the loader) from the nominated package
   * 
   * note that the package system uses lazy loading; the loader will be called later when the classes that use the context need the relevant resource
   * 
   * @param pi - the package to load
   * @param loader - an implemenation of IContextResourceLoader that knows how to read the resources in the package (e.g. for the appropriate version).
   * @return the number of resources loaded
   */
  int loadFromPackage(NpmPackage pi, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException;

  /**
   * Load relevant resources of the appropriate types (as specified by the loader) from the nominated package
   * 
   * note that the package system uses lazy loading; the loader will be called later when the classes that use the context need the relevant resource
   *
   * Deprecated - use the simpler method where the types come from the loader.
   * 
   * @param pi - the package to load
   * @param loader - an implemenation of IContextResourceLoader that knows how to read the resources in the package (e.g. for the appropriate version).
   * @param types - which types of resources to load
   * @return the number of resources loaded
   */
  @Deprecated
  int loadFromPackage(NpmPackage pi, IContextResourceLoader loader, List<String> types) throws FileNotFoundException, IOException, FHIRException;

  /**
   * Load relevant resources of the appropriate types (as specified by the loader) from the nominated package
   * 
   * note that the package system uses lazy loading; the loader will be called later when the classes that use the context need the relevant resource
   *
   * This method also loads all the packages that the package depends on (recursively)
   * 
   * @param pi - the package to load
   * @param loader - an implemenation of IContextResourceLoader that knows how to read the resources in the package (e.g. for the appropriate version).
   * @param pcm - used to find and load additional dependencies
   * @return the number of resources loaded
   */
  int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoader loader, BasePackageCacheManager pcm) throws FileNotFoundException, IOException, FHIRException;

  public boolean hasPackage(String id, String ver);
  public boolean hasPackage(PackageInformation pack);
  public PackageInformation getPackage(String id, String ver);
  public PackageInformation getPackageForUrl(String url);

  public IWorkerContextManager.IPackageLoadingTracker getPackageTracker();
  public IWorkerContext setPackageTracker(IWorkerContextManager.IPackageLoadingTracker packageTracker);

  public String getSpecUrl();

  public PEBuilder getProfiledElementBuilder(PEElementPropertiesPolicy elementProps, boolean fixedProps);
  
  public boolean isForPublication();
  public void setForPublication(boolean value);


}