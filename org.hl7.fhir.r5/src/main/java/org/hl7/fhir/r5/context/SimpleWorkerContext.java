package org.hl7.fhir.r5.context;

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

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.context.ILoggingService.LogCategory;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode;
import org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager.ITerminologyClientFactory;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientR5;
import org.hl7.fhir.r5.utils.R5Hacker;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManagerFactory;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.MagicResources;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.CSFileInputStream;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.IPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

import ca.uhn.fhir.parser.DataFormatException;

/*
 * This is a stand alone implementation of worker context for use inside a tool.
 * It loads from the validation package (validation-min.xml.zip), and has a 
 * very light client to connect to an open unauthenticated terminology service
 */

@Slf4j
@MarkedToMoveToAdjunctPackage
public class SimpleWorkerContext extends BaseWorkerContext implements IWorkerContext {

  public interface ILoaderFactory {

    IContextResourceLoader makeLoader(String version);
  }

  public class InternalCanonicalResourceProxy extends CanonicalResourceProxy {

    public InternalCanonicalResourceProxy(String type, String id, String url, String version) {
      super(type, id, url, version, null, null, null);
    }

    @Override
    public CanonicalResource loadResource() throws FHIRException {
      throw new Error("not done yet");
    }

  }

  public static class PackageResourceLoader extends CanonicalResourceProxy {

    private final String filename;
    private final IContextResourceLoader loader;
    private final PackageInformation packageInformation;

    public PackageResourceLoader(PackageResourceInformation pri, IContextResourceLoader loader, PackageInformation pi) {
      super(pri.getResourceType(), pri.getId(), loader == null ? pri.getUrl() :loader.patchUrl(pri.getUrl(), pri.getResourceType()), pri.getVersion(), pri.getSupplements(), pri.getDerivation(), pri.getContent());
      this.filename = pri.getFilename();
      this.loader = loader;
      this.packageInformation = pi;
    }

    @Override
    public CanonicalResource loadResource() {
      try {
        FileInputStream f = ManagedFileAccess.inStream(filename);
        try  {
          if (loader != null) {
            return setPi(R5Hacker.fixR5BrokenResource((CanonicalResource) loader.loadResource(f, true)));
          } else {
            return setPi(R5Hacker.fixR5BrokenResource((CanonicalResource) new JsonParser().parse(f)));
          }
        } finally {
          f.close();
        }
      } catch (Exception e) {
        throw new FHIRException("Error loading "+filename+": "+e.getMessage(), e);
      }
    }

    private CanonicalResource setPi(CanonicalResource cr) {
      cr.setSourcePackage(packageInformation);
      return cr;
    }

    /**
     * This is not intended for use outside the package loaders
     * 
     * @return
     * @throws IOException 
     */
    public InputStream getStream() throws IOException {
      return ManagedFileAccess.inStream(filename);
    }
    
  }

  public interface ILoadFilter {
    boolean isOkToLoad(Resource resource);
    boolean isOkToLoad(String resourceType);
  }

  public interface IValidatorFactory {
    IResourceValidator makeValidator(IWorkerContext ctxt, ValidatorSession session) throws FHIRException;
    IResourceValidator makeValidator(IWorkerContext ctxts, XVerExtensionManager xverManager, ValidatorSession session) throws FHIRException;
  }

	private Questionnaire questionnaire;
  private String revision;
  private String date;
  private IValidatorFactory validatorFactory;
  private boolean progress;
  private final List<String> loadedPackages = new ArrayList<>();
  private boolean canNoTS;
  private XVerExtensionManager xverManager;
  private boolean allowLazyLoading = true;
  private IPackageCacheManager packageCacheManager;
  @Getter @Setter private ILoaderFactory loaderFactory;

  private SimpleWorkerContext() throws IOException, FHIRException {
    super();
  }

  private SimpleWorkerContext(Locale locale) throws IOException, FHIRException {
    super(locale);
  }

  public SimpleWorkerContext(SimpleWorkerContext other) throws IOException, FHIRException {
    super();
    copy(other);
  }

  private SimpleWorkerContext(SimpleWorkerContext other, Locale locale) throws IOException, FHIRException {
    super(locale);
    copy(other);
  }
  
  protected void copy(SimpleWorkerContext other) {
    super.copy(other);
    binaries.putAll(other.binaries);
    version = other.version;
    revision = other.revision;
    date = other.date;
    validatorFactory = other.validatorFactory;
    progress = other.progress;
    loadedPackages.addAll(other.loadedPackages);
    canNoTS = other.canNoTS;
    xverManager = other.xverManager;
    allowLazyLoading = other.allowLazyLoading;
    questionnaire = other.questionnaire;
    packageCacheManager = other.packageCacheManager;
    loaderFactory = other.loaderFactory;
  }


  public List<String> getLoadedPackages() {
    return loadedPackages;
  }

  // -- Initializations
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class SimpleWorkerContextBuilder {


    @With
    private final String terminologyCachePath;
    @With
    private final boolean cacheTerminologyClientErrors;
    @With
    private final boolean alwaysUseTerminologyServer;
    @With
    private final boolean readOnlyCache;

    @With
    private final Locale locale;

    @With
    private final String userAgent;

    @With
    private final boolean allowLoadingDuplicates;

    @With
    private final org.hl7.fhir.r5.context.ILoggingService loggingService;
    private boolean defaultExpParams;

    public SimpleWorkerContextBuilder() {
      cacheTerminologyClientErrors = false;
      alwaysUseTerminologyServer = false;
      readOnlyCache = false;
      terminologyCachePath = null;
      locale = null;
      userAgent = null;
      allowLoadingDuplicates = false;
      loggingService = new Slf4JLoggingService(log);
    }

    private SimpleWorkerContext getSimpleWorkerContextInstance() throws IOException {
      if (locale != null) {
        return new SimpleWorkerContext(locale);
      } else {
        return new SimpleWorkerContext();
      }
    }

    public SimpleWorkerContext build() throws IOException {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      return build(context);
    }

    private SimpleWorkerContext build(SimpleWorkerContext context) throws IOException {
      if (VersionUtilities.isR2Ver(context.getVersion()) || VersionUtilities.isR2Ver(context.getVersion())) {
        log.warn("As of end 2024, FHIR R2 (version "+context.getVersion()+") is no longer officially supported.");
      }
      context.initTxCache(terminologyCachePath);
      context.setUserAgent(userAgent);
      context.setLogger(loggingService);
      context.cacheResource(new org.hl7.fhir.r5.formats.JsonParser().parse(MagicResources.spdxCodesAsData()));
      if (defaultExpParams) {
        context.setExpansionParameters(makeExpProfile());
      }
      return context;
    }

    public SimpleWorkerContext fromPackage(NpmPackage pi) throws IOException, FHIRException {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      context.setAllowLoadingDuplicates(allowLoadingDuplicates);
      context.terminologyClientManager.setFactory(TerminologyClientR5.factory());
      context.loadFromPackage(pi, null);
      return build(context);
    }
    
    private Parameters makeExpProfile() {
      Parameters ep = new Parameters();
      ep.addParameter("cache-id", UUID.randomUUID().toString().toLowerCase());
      return ep;
    }

    public SimpleWorkerContext fromPackage(NpmPackage pi, IContextResourceLoader loader, boolean genSnapshots) throws IOException, FHIRException {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      context.setAllowLoadingDuplicates(allowLoadingDuplicates);      
      context.version = pi.fhirVersion();
      if (loader != null) {
        context.terminologyClientManager.setFactory(loader.txFactory());
      }
      context.loadFromPackage(pi, loader);
      context.finishLoading(genSnapshots);
      if (defaultExpParams) {
        context.setExpansionParameters(makeExpProfile());
      }
      return build(context);
    }

    /**
     * Load the working context from the validation pack
     *
     * @param path
     *           filename of the validation pack
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws FHIRException
     * @throws Exception
     */
    public  SimpleWorkerContext fromPack(String path) throws IOException, FHIRException {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      context.setAllowLoadingDuplicates(allowLoadingDuplicates);
      context.loadFromPack(path, null);
      return build(context);
    }

    public SimpleWorkerContext fromPack(String path, IContextResourceLoader loader) throws IOException, FHIRException {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      context.loadFromPack(path, loader);
      return build(context);
    }

    public SimpleWorkerContext fromClassPath() throws IOException, FHIRException {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      context.loadFromStream(SimpleWorkerContext.class.getResourceAsStream("validation.json.zip"), null);
      return build(context);
    }

    public SimpleWorkerContext fromClassPath(String name) throws IOException, FHIRException {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      InputStream s = SimpleWorkerContext.class.getResourceAsStream("/" + name);
      context.setAllowLoadingDuplicates(allowLoadingDuplicates);
      context.loadFromStream(s, null);
      return build(context);
    }

    public SimpleWorkerContext fromDefinitions(Map<String, ByteProvider> source, IContextResourceLoader loader, PackageInformation pi) throws IOException, FHIRException  {
      SimpleWorkerContext context = getSimpleWorkerContextInstance();
      for (String name : source.keySet()) {
        try {
          context.loadDefinitionItem(name, new ByteArrayInputStream(source.get(name).getBytes()), loader, null, pi);
        } catch (Exception e) {
          log.error("Error loading "+name+": "+e.getMessage());
          throw new FHIRException("Error loading "+name+": "+e.getMessage(), e);
        }
      }
      return build(context);
    }
    public SimpleWorkerContext fromNothing() throws FHIRException, IOException  {
      return build();
    }

    public SimpleWorkerContextBuilder withDefaultParams() {
      defaultExpParams = true;
      return this;
    }
  }

  private Resource loadDefinitionItem(String name, InputStream stream, IContextResourceLoader loader, ILoadFilter filter, PackageInformation pi) throws IOException, FHIRException {
    if (name.endsWith(".xml"))
      return loadFromFile(stream, name, loader, filter);
    else if (name.endsWith(".json"))
      return loadFromFileJson(stream, name, loader, filter, pi);
    else if (name.equals("version.info"))
      readVersionInfo(stream);
    else
      binaries.put(name, new BytesProvider(FileUtilities.streamToBytesNoClose(stream)));
    return null;
  }

  public void connectToTSServer(ITerminologyClientFactory factory, ITerminologyClient client, boolean useEcosystem) {
    terminologyClientManager.setFactory(factory);
    if (txLog == null) {
      txLog = client.getLogger();
    }
    try {
      terminologyClientManager.setMasterClient(client, useEcosystem);
      txLog("Connect to "+client.getAddress());
    } catch (Exception e) {
      if (canRunWithoutTerminology) {
        noTerminologyServer = true;
        logger.logMessage("==============!! Running without terminology server !! ==============");
        if (terminologyClientManager.getMasterClient() != null) {
          logger.logMessage("txServer = "+ terminologyClientManager.getMasterClient().getId());
          logger.logMessage("Error = "+e.getMessage()+"");
        }
        logger.logMessage("=====================================================================");
      } else {
        e.printStackTrace();
        throw new TerminologyServiceException(e);
      }
    }      
  }
  
  public void connectToTSServer(ITerminologyClientFactory factory, String address, String software, String log, boolean useEcosystem) {
    try {
      terminologyClientManager.setFactory(factory);
      if (log != null) {
        if (log.endsWith(".htm") || log.endsWith(".html")) {
          txLog = new HTMLClientLogger(log);
        } else if (log.endsWith(".txt") || log.endsWith(".log")) {
          txLog = new TextClientLogger(log);
        } else {
          throw new IllegalArgumentException("Unknown extension for text file logging: \"" + log + "\" expected: .html, .htm, .txt or .log");
        }
      }
      ITerminologyClient client = factory.makeClient("tx-server", ManagedWebAccess.makeSecureRef(address), software, txLog);
      // txFactory.makeClient("Tx-Server", txServer, "fhir/publisher", null)
//      terminologyClientManager.setLogger(txLog);
//      terminologyClientManager.setUserAgent(userAgent);
      connectToTSServer(factory, client, useEcosystem);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new FHIRException(formatMessage(canNoTS ? I18nConstants.UNABLE_TO_CONNECT_TO_TERMINOLOGY_SERVER_USE_PARAMETER_TX_NA_TUN_RUN_WITHOUT_USING_TERMINOLOGY_SERVICES_TO_VALIDATE_LOINC_SNOMED_ICDX_ETC_ERROR__ : I18nConstants.UNABLE_TO_CONNECT_TO_TERMINOLOGY_SERVER, e.getMessage(), address), e);
    }
  }

  public void loadFromFile(InputStream stream, String name, IContextResourceLoader loader) throws FHIRException {
    loadFromFile(stream, name, loader, null);
  }
  
	public Resource loadFromFile(InputStream stream, String name, IContextResourceLoader loader, ILoadFilter filter) throws FHIRException {
		Resource f;
		try {
		  if (loader != null)
		    f = loader.loadBundle(stream, false);
		  else {
		    XmlParser xml = new XmlParser();
		    f = xml.parse(stream);
		  }
    } catch (DataFormatException e1) {
      throw new org.hl7.fhir.exceptions.FHIRFormatError(formatMessage(I18nConstants.ERROR_PARSING_, name, e1.getMessage()), e1);
    } catch (Exception e1) {
			throw new org.hl7.fhir.exceptions.FHIRFormatError(formatMessage(I18nConstants.ERROR_PARSING_, name, e1.getMessage()), e1);
		}
		if (f instanceof Bundle) {
		  Bundle bnd = (Bundle) f;
		  for (BundleEntryComponent e : bnd.getEntry()) {
		    if (e.getFullUrl() == null) {
		      logger.logDebugMessage(LogCategory.CONTEXT, "unidentified resource in " + name+" (no fullUrl)");
		    }
	      if (filter == null || filter.isOkToLoad(e.getResource())) {
	        String path = loader != null ? loader.getResourcePath(e.getResource()) : null;
	        if (path != null) {
	          e.getResource().setWebPath(path);
	        }
		      cacheResource(e.getResource());
	      }
		  }
		} else if (f instanceof CanonicalResource) {
		  if (filter == null || filter.isOkToLoad(f)) {
        String path = loader != null ? loader.getResourcePath(f) : null;
        if (path != null) {
          f.setWebPath(path);
        }
		    cacheResource(f);
		  }
		}
		return f;
	}

  private Resource loadFromFileJson(InputStream stream, String name, IContextResourceLoader loader, ILoadFilter filter, PackageInformation pi) throws IOException, FHIRException {
    Bundle f = null;
    try {
      if (loader != null)
        f = loader.loadBundle(stream, true);
      else {
        JsonParser json = new JsonParser();
        Resource r = json.parse(stream);
        if (r instanceof Bundle)
          f = (Bundle) r;
        else if (filter == null || filter.isOkToLoad(f)) {
          cacheResourceFromPackage(r, pi);
        }
      }
    } catch (FHIRFormatError e1) {
      throw new org.hl7.fhir.exceptions.FHIRFormatError(e1.getMessage(), e1);
    }
    if (f != null)
      for (BundleEntryComponent e : f.getEntry()) {
        if (filter == null || filter.isOkToLoad(e.getResource())) {
          String path = loader != null ? loader.getResourcePath(e.getResource()) : null;
          if (path != null) {
            e.getResource().setWebPath(path);
          }
          cacheResourceFromPackage(e.getResource(), pi);
        }
    }
    return f;
  }

	private void loadFromPack(String path, IContextResourceLoader loader) throws IOException, FHIRException {
		loadFromStream(new CSFileInputStream(path), loader);
	}
  

  @Override
  public int loadFromPackage(NpmPackage npm, IContextResourceLoader loader) throws IOException, FHIRException {
    return loadFromPackageInt(npm, loader, loader == null ? defaultTypesToLoad() : loader.getTypes());
  }

  public int loadPackage(NpmPackage npm) throws IOException, FHIRException {
    IContextResourceLoader loader =  loaderFactory.makeLoader(npm.fhirVersion());
    return loadFromPackageInt(npm, loader, loader == null ? defaultTypesToLoad() : loader.getTypes());
  }

  public int loadPackage(String idAndVer) throws IOException, FHIRException {
    NpmPackage npm = packageCacheManager.loadPackage(idAndVer);
    IContextResourceLoader loader =  loaderFactory.makeLoader(npm.fhirVersion());
    return loadFromPackageInt(npm, loader, loader == null ? defaultTypesToLoad() : loader.getTypes());
  }

  public static Set<String> defaultTypesToLoad() {
    // there's no penalty for listing resources that don't exist, so we just all the relevant possibilities for all versions 
    return Utilities.stringSet("CodeSystem", "ValueSet", "ConceptMap", "NamingSystem", 
                         "StructureDefinition", "StructureMap", 
                         "SearchParameter", "OperationDefinition", "CapabilityStatement", "Conformance",
                         "Questionnaire", "ImplementationGuide", "Measure" );
  }
 
  @Override
  public int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoader loader, BasePackageCacheManager pcm) throws IOException, FHIRException {
    return loadFromPackageAndDependenciesInt(pi, loader, pcm, pi.name()+"#"+pi.version());
  }

  public int loadFromPackageAndDependenciesInt(NpmPackage pi, IContextResourceLoader loader, BasePackageCacheManager pcm, String path) throws IOException, FHIRException {
    int t = 0;

    for (String e : pi.dependencies()) {
      if (!loadedPackages.contains(e) && !VersionUtilities.isCorePackage(e)) {
        NpmPackage npm = pcm.loadPackage(e);
        if (!VersionUtilities.versionMatches(version, npm.fhirVersion())) {
          log.info(formatMessage(I18nConstants.PACKAGE_VERSION_MISMATCH, e, version, npm.fhirVersion(), path));
        }
        t = t + loadFromPackageAndDependenciesInt(npm, loader.getNewLoader(npm), pcm, path+" -> "+npm.name()+"#"+npm.version());
      }
    }
    t = t + loadFromPackageInt(pi, loader, loader.getTypes());
    return t;
  }


  public int loadFromPackageInt(NpmPackage pi, IContextResourceLoader loader, Set<String> types) throws IOException, FHIRException {
    int t = 0;
    if (progress) {
      log.info("Load Package "+pi.name()+"#"+pi.version());
    }
    if (loadedPackages.contains(pi.id()+"#"+pi.version())) {
      return 0;
    }
    
    loadedPackages.add(pi.id()+"#"+pi.version());
    if (packageTracker != null) {
      packageTracker.packageLoaded(pi.id(), pi.version());
    }
    
    String of = pi.getFolders().get("package").getFolderPath();
    if (of != null) {
      oidSources.add(new OIDSource(of, pi.vid()));
    }
    
    if ((types == null || types.size() == 0) &&  loader != null) {
      types = loader.getTypes();
    }
    boolean hasIG = false;
    PackageInformation pii = new PackageInformation(pi);
    if (VersionUtilities.isR2Ver(pi.fhirVersion()) || !pi.canLazyLoad() || !allowLazyLoading) {
      // can't lazy load R2 because of valueset/codesystem implementation
      if (types == null || types.size() == 0) {
        types = Utilities.stringSet("ImplementationGuide", "StructureDefinition", "ValueSet", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem" );
      }
      for (String s : pi.listResources(types)) {
        try {
          Resource r = loadDefinitionItem(s, pi.load("package", s), loader, null, pii);
          if (r != null) {
            hasIG = "ImplementationGuide".equals(r.fhirType()) || hasIG;
          }
          t++;
        } catch (Exception e) {
          throw new FHIRException(formatMessage(I18nConstants.ERROR_READING__FROM_PACKAGE__, s, pi.name(), pi.version(), e.getMessage()), e);
        }      
      }
    } else {
      if (types == null || types.size() == 0) {
        types = Utilities.stringSet("ImplementationGuide", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem", "Measure" );
      }
      types.add("ImplementationGuide");
      if (loader != null) {
        types = loader.reviewActualTypes(types);
      }
      for (PackageResourceInformation pri : pi.listIndexedResources(types)) {
        if (!pri.getFilename().contains("ig-r4") && (loader == null || loader.wantLoad(pi, pri))) {
          try {

            hasIG = "ImplementationGuide".equals(pri.getResourceType()) || hasIG;
            if (!pri.hasId()) {
              loadDefinitionItem(pri.getFilename(), ManagedFileAccess.inStream(pri.getFilename()), loader, null, pii);
            } else {
              PackageResourceLoader pl = new PackageResourceLoader(pri, loader, pii);
              if  (loader != null) {
                pl = loader.editInfo(pl);
              }
              if (pl != null) {
                registerResourceFromPackage(pl, pii);
              }
            }
            t++;
          } catch (FHIRException e) {
            throw new FHIRException(formatMessage(I18nConstants.ERROR_READING__FROM_PACKAGE__, pri.getFilename(), pi.name(), pi.version(), e.getMessage()), e);
          }
        }
      }
    }
    if (!hasIG && !pi.isCore()) {
      try {
        registerResourceFromPackage(makeIgResource(pi), pii);
      } catch (Exception e) {
        log.error("Problem constructing IG for "+pi.vid()+": "+e.getMessage());
      }
    }
	  for (String s : pi.list("other")) {
	    binaries.put(s, new BytesFromPackageProvider(pi, s));
	  }
	  if (version == null) {
	    version = pi.version();
	    if (version.equals("current")) {
	      version = "5.0.0";
	    }
	  }
	  if (loader != null && terminologyClientManager.getFactory() == null) {
	    terminologyClientManager.setFactory(loader.txFactory());
	  }
	  return t;
	}

  private CanonicalResourceProxy makeIgResource(NpmPackage pi) {
    ImplementationGuide ig = new ImplementationGuide();
    ig.setId(pi.name());
    ig.setVersion(pi.version());
    ig.setUrl(makeIgUrl(pi));
    ig.setUserData(UserDataNames.IG_FAKE, true);
    
    var res = new InternalCanonicalResourceProxy(ig.fhirType(), ig.getId(), ig.getUrl(), ig.getVersion());
    res.setResource(ig);
    return res;
  }

  private String makeIgUrl(NpmPackage pi) {
    switch (pi.name()) {
    case "hl7.fhir.pubpack": return "http://hl7.org/fhir/pubpack/ImplementationGuide/hl7.fhir.pubpack"; 
    case "hl7.fhir.xver-extensions": return "http://hl7.org/fhir/xver-extensions/ImplementationGuide/hl7.fhir.xver-extensions";
    case "us.nlm.vsac": return "http://fhir.org/packages/us.nlm.vsac/ImplementationGuide/us.nlm.vsac"; 
    case "us.cdc.phinvads": return "https://phinvads.cdc.gov/vads/fhir/ImplementationGuide/us.cdc.phinvads";
    case "hl7.fhir.us.core.v610": return "http://hl7.org/fhir/us/core/v610/ImplementationGuide/hl7.fhir.us.core.v610";
    case "hl7.fhir.us.core.v311": return "http://hl7.org/fhir/us/core/v311/ImplementationGuide/hl7.fhir.us.core.v311";
    case "fhir.dicom": return "http://fhir.org/packages/fhir.dicom/ImplementationGuide/fhir.dicom";
    default:
      if (pi.name() != null && pi.canonical() != null) {
        return Utilities.pathURL(pi.canonical(), "ImplementationGuide", pi.name());
      } else {
        throw new FHIRException("No IG canonical can be determined for package: "+pi.name()+"#"+pi.version());
      }
    }
  }

  public void loadFromFile(String file, IContextResourceLoader loader) throws IOException, FHIRException {
    loadDefinitionItem(file, new CSFileInputStream(file), loader, null, null);
  }
  
	private void loadFromStream(InputStream stream, IContextResourceLoader loader) throws IOException, FHIRException {
		ZipInputStream zip = new ZipInputStream(stream);
    ZipEntry zipEntry;
    while ((zipEntry = zip.getNextEntry()) != null) {
      String entryName = zipEntry.getName();
      if (entryName.contains("..")) {
        throw new RuntimeException("Entry with an illegal path: " + entryName);
      }
      loadDefinitionItem(entryName, zip, loader, null, null);
			zip.closeEntry();
		}
		zip.close();
	}

  private void readVersionInfo(InputStream stream) throws IOException, DefinitionException {
    byte[] bytes = IOUtils.toByteArray(stream);
    binaries.put("version.info", new BytesProvider(bytes));

    String[] vi = new String(bytes).split("\\r?\\n");
    for (String s : vi) {
      if (s.startsWith("version=")) {
        if (version == null)
        version = s.substring(8);
        else if (!version.equals(s.substring(8))) {
          throw new DefinitionException(formatMessage(I18nConstants.VERSION_MISMATCH_THE_CONTEXT_HAS_VERSION__LOADED_AND_THE_NEW_CONTENT_BEING_LOADED_IS_VERSION_, version, s.substring(8)));
        }
      }
      if (s.startsWith("revision="))
        revision = s.substring(9);
      if (s.startsWith("date="))
        date = s.substring(5);
    }
  }

	@Override
	public IResourceValidator newValidator() throws FHIRException {
	  if (validatorFactory == null)
	    throw new Error(formatMessage(I18nConstants.NO_VALIDATOR_CONFIGURED));
	  return validatorFactory.makeValidator(this, xverManager, null).setJurisdiction(JurisdictionUtilities.getJurisdictionCodingFromLocale(Locale.getDefault().getCountry()));
	}

  @Override
  public List<String> getResourceNames() {
    Set<String> result = new HashSet<String>();
    for (StructureDefinition sd : listStructures()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.hasUserData(UserDataNames.loader_urls_patched))
        result.add(sd.getName());
    }
    return Utilities.sorted(result);
  }

 
  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

 

  public void loadBinariesFromFolder(String folder) throws IOException {
    for (String n : ManagedFileAccess.file(folder).list()) {
      binaries.put(n, new BytesFromFileProvider(Utilities.path(folder, n)));
    }
  }
  
  public void loadBinariesFromFolder(NpmPackage pi) throws IOException {
    for (String n : pi.list("other")) {
      binaries.put(n, new BytesFromPackageProvider(pi, n));
    }
  }
  
  public void loadFromFolder(String folder) throws IOException {
    for (String n : ManagedFileAccess.file(folder).list()) {
      if (n.endsWith(".json")) 
        loadFromFile(Utilities.path(folder, n), new JsonParser());
      else if (n.endsWith(".xml")) 
        loadFromFile(Utilities.path(folder, n), new XmlParser());
    }
  }
  
  private void loadFromFile(String filename, IParser p) {
  	Resource r; 
  	try {
  		r = p.parse(ManagedFileAccess.inStream(filename));
      if (r.getResourceType() == ResourceType.Bundle) {
        for (BundleEntryComponent e : ((Bundle) r).getEntry()) {
          cacheResource(e.getResource());
        }
     } else {
       cacheResource(r);
     }
  	} catch (Exception e) {
    	return;
    }
  }

 

  @Override
  public String getVersion() {
    return version;
  }

  
  public List<StructureMap> findTransformsforSource(String url) {
    List<StructureMap> res = new ArrayList<StructureMap>();
    for (StructureMap map : fetchResourcesByType(StructureMap.class)) {
      boolean match = false;
      boolean ok = true;
      for (StructureMapStructureComponent t : map.getStructure()) {
        if (t.getMode() == StructureMapModelMode.SOURCE) {
          match = match || t.getUrl().equals(url);
          ok = ok && t.getUrl().equals(url);
        }
      }
      if (match && ok)
        res.add(map);
    }
    return res;
  }

  public IValidatorFactory getValidatorFactory() {
    return validatorFactory;
  }

  public void setValidatorFactory(IValidatorFactory validatorFactory) {
    this.validatorFactory = validatorFactory;
  }

  @Override
  public <T extends Resource> T fetchResource(Class<T> class_, String uri) {
    T r = super.fetchResource(class_, uri);
    if (r instanceof StructureDefinition) {
      StructureDefinition p = (StructureDefinition)r;
      try {
        cutils.generateSnapshot(p);
      } catch (Exception e) {
        // not sure what to do in this case?
        log.error("Unable to generate snapshot @3 for "+uri+": "+e.getMessage());
        logger.logDebugMessage(org.hl7.fhir.r5.context.ILoggingService.LogCategory.GENERATE, ExceptionUtils.getStackTrace(e));
      }
    }
    return r;
  }

  @Override
  public <T extends Resource> T fetchResourceRaw(Class<T> class_, String uri) {
    T r = super.fetchResource(class_, uri);
    return r;
  }

  @Override
  public <T extends Resource> T fetchResource(Class<T> class_, String uri, String version, Resource source) {
    T resource = super.fetchResource(class_, uri, version, source);
    if (resource instanceof StructureDefinition) {
      StructureDefinition structureDefinition = (StructureDefinition)resource;
      generateSnapshot(structureDefinition, "4");
    }
    return resource;
  }




  public String listMapUrls() {
    return Utilities.listCanonicalUrls(transforms.keys());
  }

  public boolean isProgress() {
    return progress;
  }

  public void setProgress(boolean progress) {
    this.progress = progress;
  }

  public void setClock(TimeTracker tt) {
    clock = tt;
  }

  public boolean isCanNoTS() {
    return canNoTS;
  }

  public void setCanNoTS(boolean canNoTS) {
    this.canNoTS = canNoTS;
  }

  public XVerExtensionManager getXVer() {
    if (xverManager == null) {
      xverManager = XVerExtensionManagerFactory.createExtensionManager(this);
    }
   return xverManager;
  }

  @Override
  public IPackageCacheManager packageManager() {
    return packageCacheManager;
  }

  @Override
  public void setPackageManager(IPackageCacheManager packageCacheManager) {
    this.packageCacheManager = packageCacheManager;
  }

  public void cachePackage(PackageInformation packageInfo) {
    // nothing yet
  }

  @Override
  public boolean hasPackage(String id, String ver) {
    if (ver == null) {
      for (String p : loadedPackages) {
        if (p.startsWith(id+"#")) {
          return true;
        }
      }
      return false;
    } else {    
      return loadedPackages.contains(id+"#"+ver);
    }
  }

  public boolean hasPackage(String idAndver) {
    if (loadedPackages.contains(idAndver)) {
      return true;
    }
    // not clear whether the same logic should apply to other cross-version packages?
    if (idAndver.startsWith("hl7.fhir.uv.extensions")) {
      String v = idAndver.substring(idAndver.lastIndexOf("#")+1);
      for (String s : loadedPackages) {
        String v2 = s.substring(s.lastIndexOf("#")+1);
        if (s.startsWith("hl7.fhir.uv.extensions.") && VersionUtilities.versionMatches(v, v2)) {
          return true;
        }
      }
    }
    return false;
    
  }

  @Override
  public boolean hasPackage(PackageInformation pack) {
    return false;
  }

  @Override
  public PackageInformation getPackage(String id, String ver) {
    return null;
  }

  public boolean isAllowLazyLoading() {
    return allowLazyLoading;
  }

  public void setAllowLazyLoading(boolean allowLazyLoading) {
    this.allowLazyLoading = allowLazyLoading;
  }

  public String loadedPackageSummary() {
     return loadedPackages.toString();
  }

  @Override
  public String getSpecUrl() {
    return VersionUtilities.getSpecUrl(getVersion())+"/";
  }


  // only for testing (and transient)
  public void setXVerManager(XVerExtensionManager value) {
    xverManager = value;
  }

}

