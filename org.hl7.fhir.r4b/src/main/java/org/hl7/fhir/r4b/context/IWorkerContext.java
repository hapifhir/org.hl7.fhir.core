package org.hl7.fhir.r4b.context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
import org.hl7.fhir.r4b.context.TerminologyCache.CacheToken;
import org.hl7.fhir.r4b.formats.IParser;
import org.hl7.fhir.r4b.formats.ParserType;
import org.hl7.fhir.r4b.model.Bundle;
import org.hl7.fhir.r4b.model.CanonicalResource;
import org.hl7.fhir.r4b.model.CodeSystem;
import org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4b.model.CodeableConcept;
import org.hl7.fhir.r4b.model.Coding;
import org.hl7.fhir.r4b.model.ConceptMap;
import org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r4b.model.Parameters;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.model.StructureMap;
import org.hl7.fhir.r4b.model.ValueSet;
import org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r4b.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r4b.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r4b.utils.validation.IResourceValidator;
import org.hl7.fhir.r4b.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.TranslationServices;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.gson.JsonSyntaxException;


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

  public class CodingValidationRequest {
    private Coding coding;
    private ValidationResult result;
    private CacheToken cacheToken;
    
    public CodingValidationRequest(Coding coding) {
      super();
      this.coding = coding;
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

  public class PackageVersion {
    private String id;
    private String version;
    
    public PackageVersion(String source) {
      if (source == null) {
        throw new Error("Source cannot be null");
      }
      if (!source.contains("#")) {
        throw new FHIRException("Source ");        
      }
      id = source.substring(0, source.indexOf("#"));
      version = source.substring(source.indexOf("#")+1);
    }
    public PackageVersion(String id, String version) {
      super();
      this.id = id;
      this.version = version;
    }
    public String getId() {
      return id;
    }
    public String getVersion() {
      return version;
    }
    public boolean isExamplesPackage() {
      boolean b = id.startsWith("hl7.fhir.") && id.endsWith(".examples");
      return b;
    }
    @Override
    public String toString() {
      return id+"#"+version;
    }
    
  }

  public class PackageDetails extends PackageVersion {
    private String name;
    private String canonical;
    private String web;
    public PackageDetails(String id, String version, String name, String canonical, String web) {
      super(id, version);
      this.name = name;
      this.canonical = canonical;
      this.web = web;
    }
    public String getName() {
      return name;
    }
    public String getCanonical() {
      return canonical;
    }
    public String getWeb() {
      return web;
    }
    
  }

  public interface ICanonicalResourceLocator {
    void findResource(Object caller, String url); // if it can be found, put it in the context
  }
  
  public interface IContextResourceLoader {
    /** 
     * @return List of the resource types that should be loaded
     */
    String[] getTypes();
    
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
     * called when a mew package is being loaded
     * 
     * this is called by loadPacakgeAndDependencies when a new package is loaded
     * @param npm
     * @return
     * @throws IOException 
     * @throws JsonSyntaxException 
     */
    IContextResourceLoader getNewLoader(NpmPackage npm) throws JsonSyntaxException, IOException;   
  }

  /**
   * Get the versions of the definitions loaded in context
   * @return
   */
  public String getVersion();
  
  /**
   * return the link to the base of the specification for the loaded version e.g. http://hl7.org/fhir/R4
   */
  public String getSpecUrl();
  
  // get the UCUM service (might not be available)
  public UcumService getUcumService();
  
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
  public <T extends Resource> T fetchResource(Class<T> class_, String uri, CanonicalResource canonicalForSource);

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
  public void cacheResourceFromPackage(Resource res, PackageVersion packageDetails) throws FHIRException;
  
  /**
   * Inform the cache about package dependencies. This can be used to help resolve references
   * 
   * Note that the cache doesn't load dependencies
   *  
   * @param packageInfo
   */
  public void cachePackage(PackageDetails packageDetails, List<PackageVersion> dependencies);
  
  // -- profile services ---------------------------------------------------------
  
  /**
   * @return a list of the resource names defined for this version
   */
  public List<String> getResourceNames();
  /**
   * @return a set of the resource names defined for this version
   */
  public Set<String> getResourceNamesAsSet();

  /**
   * @return a list of the resource and type names defined for this version
   */
  public List<String> getTypeNames();
  
  /**
   * @return a list of all structure definitions, with snapshots generated (if possible)
   */
  public List<StructureDefinition> allStructures();
  
  /**
   * @return a list of all structure definitions, without trying to generate snapshots
   */
  public List<StructureDefinition> getStructures();
  
  /**
   * @return a list of all conformance resources
   */
  public List<CanonicalResource> allConformanceResources();
  
  /**
   * Given a structure definition, generate a snapshot (or regenerate it)
   * @param p
   * @throws DefinitionException
   * @throws FHIRException
   */
  public void generateSnapshot(StructureDefinition p) throws DefinitionException, FHIRException;
  public void generateSnapshot(StructureDefinition mr, boolean ifLogical);
  
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
   * @param system
   * @return
   */
  public CodeSystem fetchCodeSystem(String system);
  public CodeSystem fetchCodeSystem(String system, String version);

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
   * @throws FHIRException 
   */
  public List<ConceptMap> findMapsForSource(String url) throws FHIRException;  

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
  public ValueSetExpansionOutcome expandVS(ElementDefinitionBindingComponent binding, boolean cacheOk, boolean heiarchical) throws FHIRException;
  
  /**
   * Value set expanion inside the internal expansion engine - used 
   * for references to supported system (see "supportsSystem") for
   * which there is no value set. 
   * 
   * @param inc
   * @return
   * @throws FHIRException 
   */
  ValueSetExpansionOutcome expandVS(ConceptSetComponent inc, boolean hierarchical) throws TerminologyServiceException;

  Locale getLocale();

  void setLocale(Locale locale);

  String formatMessage(String theMessage, Object... theMessageArguments);
  String formatMessagePlural(Integer pl, String theMessage, Object... theMessageArguments);

  void setValidationMessageLanguage(Locale locale);

  class ValidationResult {
    private ConceptDefinitionComponent definition;
    private String system;
    private IssueSeverity severity;
    private String message;
    private TerminologyServiceErrorClass errorClass;
    private String txLink;
    
    @Override
    public String toString() {
      return "ValidationResult [definition=" + definition + ", system=" + system + ", severity=" + severity + ", message=" + message + ", errorClass="
          + errorClass + ", txLink=" + txLink + "]";
    }

    public ValidationResult(IssueSeverity severity, String message) {
      this.severity = severity;
      this.message = message;
    }
    
    public ValidationResult(String system, ConceptDefinitionComponent definition) {
      this.system = system;
      this.definition = definition;
    }

    public ValidationResult(IssueSeverity severity, String message, String system, ConceptDefinitionComponent definition) {
      this.severity = severity;
      this.message = message;
      this.system = system;
      this.definition = definition;
    }
    
    public ValidationResult(IssueSeverity severity, String message, TerminologyServiceErrorClass errorClass) {
      this.severity = severity;
      this.message = message;
      this.errorClass = errorClass;
    }

    public boolean isOk() {
      return severity == null || severity == IssueSeverity.INFORMATION || severity == IssueSeverity.WARNING;
    }

    public String getSystem() {
      return system;
    }

    public String getDisplay() {
      return definition == null ? null : definition.getDisplay();
    }

    public String getCode() {
      return definition == null ? null : definition.getCode();
    }

    public String getDefinition() {
      return definition == null ? null : definition.getDefinition();
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
    
    public Coding asCoding() {
      if (isOk() && definition != null && definition.getCode() != null) {
        return new Coding(system, definition.getCode(), definition.getDisplay());
      } else {
        return null;
      }
    }
  }

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
  
  public ValidationResult validateCode(ValidationOptions options, Coding code, ValueSet vs, ValidationContextCarrier ctxt);

  public void validateCodeBatch(ValidationOptions options, List<? extends CodingValidationRequest> codes, ValueSet vs);
  
  /**
   * returns the recommended tla for the type  (from the structure definitions)
   * 
   * @param name
   * @return
   */
  public String getAbbreviation(String name);


  /**
   * translate an OID to a URI (look through known NamingSystems)
   * @param code
   * @return
   */
	public String oid2Uri(String code);

	/** 
	 * @return true if the contxt has a terminology caching service internally
	 */
  public boolean hasCache();

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
  }

  public void setLogger(ILoggingService logger);
  public ILoggingService getLogger();

  public boolean isNoTerminologyServer();
  public Set<String> getCodeSystemsUsed();
  public TranslationServices translator();
  public List<StructureMap> listTransforms();
  public StructureMap getTransform(String url);

  public String getOverrideVersionNs();
  public void setOverrideVersionNs(String value);

  public StructureDefinition fetchTypeDefinition(String typeName);
  public StructureDefinition fetchRawProfile(String url);
  
  public void setUcumService(UcumService ucumService);

  public String getLinkForUrl(String corePath, String s);
  public Map<String, byte[]> getBinaries();

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
  int loadFromPackage(NpmPackage pi, IContextResourceLoader loader, String[] types) throws FileNotFoundException, IOException, FHIRException;

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
   public boolean hasPackage(PackageVersion pack);
   public PackageDetails getPackage(PackageVersion pack);

  public int getClientRetryCount();
  public IWorkerContext setClientRetryCount(int value);
  
  public TimeTracker clock();

  public PackageVersion getPackageForUrl(String url);
}