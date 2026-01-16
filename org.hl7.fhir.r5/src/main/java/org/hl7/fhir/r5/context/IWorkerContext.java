package org.hl7.fhir.r5.context;

import lombok.Getter;
import org.fhir.ucum.UcumService;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.IPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import javax.annotation.Nonnull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


/**
 * This is the standard interface used for access to underlying FHIR
 * services through the tools and utilities provided by the reference
 * implementation. 
 *
 * You need to provide an implementation of IWorkerContext in order to use
 * the following features:
 *
 *  - FHIRPath Engine
 *  - Rendering
 *  - Terminology functions
 *  - Validation
 *  - Version Comparison
 *
 * The class SimpleWorkerContext provides a fully functional implementation
 * that is thread safe and tied to the use of a local filesystem based
 * package management context. The primary reason to not use the SimpleWorkerContext
 * class is to store resources and packages somewhere other than the local filesystem
 *
 * If you provide your own implementation, you need to handle packages properly in
 * order to get correct version resolution
 *  
 * @author Grahame
 */

@MarkedToMoveToAdjunctPackage
public interface IWorkerContext {

  //region General Properties

  /**
   * The version loaded *does not* have to be 5.0 (R5) - the context can load other versions, though the definitions
   * need to be converted to R5 first
   * 
   * Note that more than one version might be loaded at once, but one version is always the default / master
   * 
   * @return the version of the base definitions loaded in context
   */
  public String getVersion();

  /**
   * @return The URL that points to the specification for the version loaded
   */
  public String getSpecUrl();

  /**
   * @return the locale used when creating messages and invoking the terminology server
   */
  Locale getLocale();

  /**
   * @return the logging service configured for the context
   */
  public ILoggingService getLogger();

  /**
   * @return Get the UCUM service that provides access to units of measure reasoning services (if available)
   */
  public UcumService getUcumService();

  /**
   * @return a handle to provide information about OIDs known to the context (if available)
   */
  public IOIDServices oidServices();

  /**
   * if this returns null, the context is frozen (usually for threading concerns on the server)
   *
   * If you're considering not providing this service, the context can't load stuff on the fly
   * so you need to take care to load everything in advance. In particular, pay attention to
   * cross-version packages
   *
   * Also, beware of the impact of lazy-loading on thread safety
   *
   * @return the manager that can be used to load / unload content from the context
   */
  public IWorkerContextManager getManager();

  //endregion

  //region Binary and Messaging Support

  /**
   * Access to the contexts internationalised error messages
   *
   * For rendering internationalization, see RenderingContext
   *
   * Use String.format() functionality
   *
   * @param theMessage
   * @param theMessageArguments
   * @return the formatted message
   */
  String formatMessage(String theMessage, Object... theMessageArguments);

  /**
   * Access to the contexts internationalised error messages for messages
   * with a key plural property.
   *
   * There's no support for more than one plural property, so messages are designed accordingly
   *
   * For rendering internationalization, see RenderingContext
   *
   * Use String.format() functionality
   *
   * @param theMessage
   * @param theMessageArguments
   * @return the formatted message
   */
  String formatMessagePlural(Integer pluralNum, String theMessage, Object... theMessageArguments);


  /**
   * Returns a set of keys that can be used to get binaries from this context.
   * In general, the binaries come from the loaded packages (mostly the pubpack)
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

  //endregion

  //region Package Services

  /**
   * @return true if the nominated package has been loaded
   */
  public boolean hasPackage(String id, String ver);

  /**
   * @return true if the nominated package has been loaded (by id and version)
   */
  public boolean hasPackage(PackageInformation pack);

  /**
   * @return package information for nominated package
   */
  public PackageInformation getPackage(String id, String ver);

  /**
   * Note: take care with this method - there are multiple packages with the same
   * canonical (different sub-packages, different versions)
   *
   * @param url - canonical URL
   * @return - package information for the most recent package with the given canonical
   */
  public PackageInformation getPackageForUrl(String url);

//endregion

  //region Type Management Services

  /**
   * @return a list of the resource names defined for this version (sorted alphabetically)
   */
  public List<String> getResourceNames();

  /**
   * @return a set of the resource names defined for this version
   */
  public Set<String> getResourceNamesAsSet();

  /**
   * This is a short cut for fetchResource(StructureDefinition.class, ...)
   * but it accepts a typename - that is, it resolves based on StructureDefinition.type
   * or StructureDefinition.url. This only resolves to http://hl7.org/fhir/StructureDefinition/{typename}
   *
   * @param typeName
   * @return type (or exception if there is multiple candidates
   */
  public StructureDefinition fetchTypeDefinition(String typeName);

  /**
   * This finds all the structure definitions that have the given typeName
   *
   * @param typeName
   * @return
   */
  public List<StructureDefinition> fetchTypeDefinitions(String typeName);

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

  //endregion

  //region Canonical Resource Fetchers

  /**
   * This region provides access to CanonicalResources loaded into the context.
   * For non-canonical resources, see the next region.
   *
   * In general, fetch a resource takes 4 properties:
   *   - the class of resource wanted (a generics thing - Resource.class, or a particular class)
   *   - the URL of the canonical resource
   *   - the version of the resource
   *   - the source of the reference
   *
   *  The URL may contain the version using the |version suffix. It's an error to provide both the suffix and a version.
   *  version can be in either place for ease of use acros different scenarios; in practice, it's generally best to not
   *  worry about it being in both places - it should not be and if it is, it's an error in the resource content, and
   *  just let this routine return an error if it is
   *
   *  If no version is provided in either parameter, then the latest known resource will be returned using a general
   *  heuristic based on the provided version algorithm etc.
   *
   *  The source of the reference gives a package context for the resolution, since the
   *  package context drives the version determination. It should always be provided if the
   *  reference being fetched come from another resource.
   */

  /**
   * find whether a resource is available. the principal use of this method is to find whether
   * a resource is known without actually loading it.
   *
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @return if the resource is known
   */
  public <T extends Resource> boolean hasResource(Class<T> class_, String uri);

  /**
   * find whether a resource is available. the principal use of this method is to find whether
   * a resource is known without actually loading it.
   *
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @param version the version. Don't provide both a version and a |version suffix
   * @param sourceOfReference where the reference was found (if the reference is in a resource)
   * @return if the resource is known
   */
  public <T extends Resource> boolean hasResource(Class<T> class_, String uri, String version, Resource sourceOfReference);

  /**
   * Fetch (load if necessary) an identified resource. The most common use of this is to access the
   * standard conformance resources that are part of the standard - structure 
   * definitions, value sets, concept maps, etc.
   **
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
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @return the resource if known (or null)
   */
  public <T extends Resource> T fetchResource(Class<T> class_, String uri);

  /**
   * Fetch (load if necessary) an identified resource. The most common use of this is to access the
   * standard conformance resources that are part of the standard - structure
   * definitions, value sets, concept maps, etc.
   **
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
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @param version the version. Don't provide both a version and a |version suffix
   * @return if the resource is known
   */
 // public <T extends Resource> T fetchResource(Class<T> class_, String uri, String version);

  /**
   * Fetch (load if necessary) an identified resource. The most common use of this is to access the
   * standard conformance resources that are part of the standard - structure
   * definitions, value sets, concept maps, etc.
   **
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
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @param version the version. Don't provide both a version and a |version suffix
   * @param sourceOfReference where the reference was found (if the reference is in a resource)
   * @return if the resource is known
   */
  public <T extends Resource> T fetchResource(Class<T> class_, String uri, String version, Resource sourceOfReference);

  /**
   * Fetch (load if necessary) an identified resource. The most common use of this is to access the
   * standard conformance resources that are part of the standard - structure
   * definitions, value sets, concept maps, etc.
   **
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
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @return the resource if known (or an exception will be thrown)
   */
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri) throws FHIRException;

  /**
   * Fetch (load if necessary) an identified resource. The most common use of this is to access the
   * standard conformance resources that are part of the standard - structure
   * definitions, value sets, concept maps, etc.
   **
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
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @param version the version. Don't provide both a version and a |version suffix
   * @param sourceOfReference where the reference was found (if the reference is in a resource)
   * @return if the resource is known. Will throw an exception if the resource is not known
   */
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri, String version, Resource sourceOfReference) throws FHIRException;

  /**
   * Find an identified resource, but do not do any processing on it.
   * The usual processing that happens is ensuring that the snapshot is
   * generated before returning it; This routine is used in the snapshot
   * generation routines to avoid circular dependency challenges generating
   * snapshots.

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
   * @param class_ the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @return the resource if known (or an exception will be thrown)
   */
  public <T extends Resource> T fetchResourceRaw(Class<T> class_, String uri);

  /**
   * Fetch (load if necessary) an identified resource. The most common use of this is to access the
   * standard conformance resources that are part of the standard - structure
   * definitions, value sets, concept maps, etc.
   *
   * This is the non-generic version, but the functionality is otherwise the same
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
   * @param type the type of resource
   * @param uri the URL of the resource, optionally with a |version suffix
   * @return the resource if known (or null)
   */
  public Resource fetchResourceById(String type, String uri);

  /**
   * Fetch all the resources of a particular type. if class == (null | Resource | DomainResource | CanonicalResource) return everything
   *
   * Note: this forces every resource to be loaded; this might take a very long time. Some implementations
   * require some flag to be set elsewhere to allow this method to be called for some types to prevent the
   * method from accidentally being called (ValueSets can take minutes to load, since there are so many in scope)
   *
   * @param class_ the type of resource to load
   * @return all the resources
   */
  public <T extends Resource> List<T> fetchResourcesByType(Class<T> class_);

  /**
   * Fetch all the versions of a resource.
   *
   * @param class_ the type of resource to load
   * @return all the resources
   */
  public <T extends Resource> List<T> fetchResourceVersions(Class<T> class_, String url);

  //endregion

  //region Terminology services

  /**
   * this first does a fetch resource, and if nothing is found, looks in the
   * terminology eco-system for a matching definition for the resource
   */
  public <T extends Resource> T findTxResource(Class<T> class_, String canonical);
  /**
   * this first does a fetch resource, and if nothing is found, looks in the
   * terminology eco-system for a matching definition for the resource
   */
  public <T extends Resource> T findTxResource(Class<T> class_, String canonical, String version, Resource sourceOfReference);

  /**
   * Get a copy of the expansion parameters to be passed through the terminology server when txServer calls are made
   *
   * You can change these - it's not setting the underlying expansion parameters (see IWorkerContextManager)
   *
   * Note that the Validation Options override these when they are specified on validateCode
   */
  public Parameters getExpansionParameters();

  /**
   * Find the code system definition for the nominated system uri. 
   * return null if there isn't one (then the tool might try 
   * supportsSystem)
   * 
   * This is a short cut for fetchResource(CodeSystem.class, system)
   * 
   * @param system
   * @return
   */
  public CodeSystem fetchCodeSystem(String system);

  /**
   * Find the code system definition for the nominated system uri.
   * return null if there isn't one (then the tool might try
   * supportsSystem)
   *
   * This is a short cut for fetchResource(CodeSystem.class, system, version, sourceOfReference)
   */
  public CodeSystem fetchCodeSystem(String system, String version, Resource sourceOfReference);

  /**
   * Like fetchCodeSystem, except that the context will find any CodeSysetm supplements and merge them into the
   * definition that's returned
   */
  public CodeSystem fetchSupplementedCodeSystem(String system);

  /**
   * Like fetchCodeSystem, except that the context will find any CodeSysetm supplements and merge them into the
   * definition that's returned
   */
  public CodeSystem fetchSupplementedCodeSystem(String system, String version, Resource sourceOfReference);

  /**
   * ValueSet Expansion - see $expand
   *
   * Note that caching makes a real performance difference, so turn it off with care.
   *
   * @param source - the valueset to expand
   * @param cacheOk - whether to look in the cache for an expansion
   * @param heiarchical - whether to accept a heirarchical expansion
   * @return the expansion, or information about how the expansion failed
   */
  @Deprecated
  public ValueSetExpansionOutcome expandVS(ValueSet source, boolean cacheOk, boolean heiarchical);


  /**
   * ValueSet Expansion - see $expand
   *
   * Note that caching makes a real performance difference, so turn it off with care.
   *
   * @param options - controls the expansion process (overrides expansion parameters)
   * @param source - the valueset to expand
   * @return the expansion, or information about how the expansion failed
   */
  public ValueSetExpansionOutcome expandVS(ExpansionOptions options, ValueSet source);

  /**
   * ValueSet Expansion - see $expand
   *
   * Note that caching makes a real performance difference, so turn it off with care.
   *
   * @param source - the valueset to expand
   * @param cacheOk - whether to look in the cache for an expansion
   * @param heiarchical - whether to accept a heirarchical expansion
   * @param count - maximum concepts to return
   * @return the expansion, or information about how the expansion failed
   */
  @Deprecated
  public ValueSetExpansionOutcome expandVS(ValueSet source, boolean cacheOk, boolean heiarchical, int count);

  /**
   * ValueSet Expansion - see $expand
   *
   * Note that caching makes a real performance difference, so turn it off with care.
   *
   * This isn't quite the same as findTxResource+expand because if the uri can't be
   * resolved, it'll be passed to the terminology service directly, and some terminology
   * servers will expand value sets that they won't return.
   *
   * @param options - controls the expansion process (overrides expansion parameters)
   * @param uri - valueset uri.
   * @return the expansion, or information about how the expansion failed
   */
  public ValueSetExpansionOutcome expandVS(ExpansionOptions options, String uri); // set to 0 to just check existence

  /**
   * ValueSet Expansion - see $expand, but resolves the binding first
   *  
   * @param src
   * @return
   * @throws FHIRException 
   */
  @Deprecated
  public ValueSetExpansionOutcome expandVS(Resource src, ElementDefinitionBindingComponent binding, boolean cacheOk, boolean heiarchical) throws FHIRException;

  /**
   * Validation of a code - consult the terminology infrstructure and/or service
   * to see whether it is known. If known, return a description of it
   *
   * note: always return a result, with either an error or a code description
   *
   * in this case, the system will be inferred from the value set. It's an error to call this one without the value set
   *
   * @param options - validation options (required)
   * @param code The code to validate (required)
   * @param vs the applicable valueset (required)
   * @return
   */
  public ValidationResult validateCode(ValidationOptions options, String code, ValueSet vs);

  /**
   * Validation of a code - consult the terminology infrstructure and/or service
   * to see whether it is known. If known, return a description of it
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
  public void validateCodeBatch(ValidationOptions options, List<? extends CodingValidationRequest> codes, ValueSet vs, boolean passVS);

  /**
   * Validate the actual terminology resource itself on the appropriate terminology server
   *
   * (used for ECL validation)
   *
   * @param options
   * @param resource
   * @return
   */
  public OperationOutcome validateTxResource(ValidationOptions options, Resource resource);

  /**
   * ask the terminology system whether parent subsumes child.
   *
   * @return true if it does, false if it doesn't, and null if it's not know whether it does
   */
  public Boolean subsumes(ValidationOptions options, Coding parent, Coding child);

  class SystemSupportInformation {
    // whether the system(/version) is supported
    @Getter
    private boolean supported;

    // the reason it's not supported (if known)
    private String reason;

    // the server that supports the system(/version)
    // may be null for some systems where we never consult any server
    @Getter
    private String server;

    // if the server supports it, the set of test cases the server claims to pass (or null)
    @Getter
    private String testVersion;

    public boolean isServerSide() { return server != null; }
    public SystemSupportInformation(boolean supported, String server, String testVersion, String reason) {
      this.supported = supported;
      this.server = server;
      this.testVersion = testVersion;
      this.reason = reason;
    }

    public SystemSupportInformation(boolean supported) {
      this.supported = supported;
    }

    public String reason() {
      return reason;
    }
  }
  /**
   * return the System Support Information for the server that serves the specified code system
   * @param system
   * @param version
   * @return
   */
  public SystemSupportInformation getTxSupportInfo(String system, String version);

  /**
   * @return true if there is a terminology server supporting the context
   */
  public boolean isNoTerminologyServer();

  /**
   * @return a list of all the code systems used by the functions above
   */
  public Set<String> getCodeSystemsUsed();
  //endregion


  //region Deprecated

  /**
   * Get a validator that can check whether a resource is valid
   *
   * this is deprecated because there's lots of properties to set on the validator;
   * the functions using this need to be changed to use the validator directly
   *
   * @return a prepared generator
   * @throws FHIRException
   * @
   */
  @Deprecated
  public IResourceValidator newValidator() throws FHIRException;
  @Deprecated
  public PEBuilder getProfiledElementBuilder(PEElementPropertiesPolicy elementProps, boolean fixedProps);

  /**
   * @return time tracker for when the context is being loaded (0 = start of loading)
   */
  @Deprecated
  public TimeTracker clock();

  //endregion


  // todo: figure these out
  @Deprecated
  public Map<String, NamingSystem> getNSUrlMap();

  @Deprecated
  public IWorkerContextManager.IPackageLoadingTracker getPackageTracker();
  @Deprecated
  public IWorkerContext setPackageTracker(IWorkerContextManager.IPackageLoadingTracker packageTracker);

  @Deprecated
  public int getClientRetryCount();
  @Deprecated
  public IWorkerContext setClientRetryCount(int value);


  @Deprecated
  public boolean isForPublication();
  @Deprecated
  public void setForPublication(boolean value);

}