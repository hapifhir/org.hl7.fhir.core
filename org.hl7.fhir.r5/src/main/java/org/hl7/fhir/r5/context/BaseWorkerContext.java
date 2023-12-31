package org.hl7.fhir.r5.context;

import java.io.File;

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


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.fhir.ucum.UcumService;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.NoTerminologyServiceException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.context.ILoggingService.LogCategory;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Measure;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemType;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PlanDefinition;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Requirements;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.Bundle.HTTPVerb;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.profilemodel.PEDefinition;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.renderers.OperationOutcomeRenderer;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpander;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache.CacheToken;
import org.hl7.fhir.r5.terminologies.validation.VSCheckerException;
import org.hl7.fhir.r5.terminologies.validation.ValueSetValidator;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.utils.PackageHackerR5;
import org.hl7.fhir.r5.utils.ResourceUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.TranslationServices;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nBase;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.annotation.Nonnull;

public abstract class BaseWorkerContext extends I18nBase implements IWorkerContext {

  class OIDSource {
    private String folder;
    private Connection db;
    protected OIDSource(String folder) {
      super();
      this.folder = folder;
    }
    
  }

  private static final boolean QA_CHECK_REFERENCE_SOURCE = false; // see comments below

  public static class ResourceProxy {
    private Resource resource;
    private CanonicalResourceProxy proxy;

    public ResourceProxy(Resource resource) {
      super();
      this.resource = resource;
    }
    public ResourceProxy(CanonicalResourceProxy proxy) {
      super();
      this.proxy = proxy;
    }
    
    public Resource getResource() {
      return resource != null ? resource : proxy.getResource();
    }
      
    public CanonicalResourceProxy getProxy() {
      return proxy;
    }
    
    public String getUrl() {
      if (resource == null) {
        return proxy.getUrl();
      } else if (resource instanceof CanonicalResource) {
        return ((CanonicalResource) resource).getUrl(); 
      } else {
        return null;
      }
    }
    
  }

  public class MetadataResourceVersionComparator<T extends CanonicalResource> implements Comparator<T> {

    final private List<T> list;

    public MetadataResourceVersionComparator(List<T> list) {
      this.list = list;
    }

    @Override
    public int compare(T arg1, T arg2) {
      String v1 = arg1.getVersion();
      String v2 = arg2.getVersion();
      if (v1 == null && v2 == null) {
        return Integer.compare(list.indexOf(arg1), list.indexOf(arg2)); // retain original order
      } else if (v1 == null) {
        return -1;
      } else if (v2 == null) {
        return 1;
      } else {
        String mm1 = VersionUtilities.getMajMin(v1);
        String mm2 = VersionUtilities.getMajMin(v2);
        if (mm1 == null || mm2 == null) {
          return v1.compareTo(v2);
        } else {
          return mm1.compareTo(mm2);
        }
      }
    }
  }

  private Object lock = new Object(); // used as a lock for the data that follows
  protected String version; // although the internal resources are all R5, the version of FHIR they describe may not be 

  protected TerminologyClientContext tcc = new TerminologyClientContext();
  private boolean minimalMemory = false;

  private Map<String, Map<String, ResourceProxy>> allResourcesById = new HashMap<String, Map<String, ResourceProxy>>();
  // all maps are to the full URI
  private CanonicalResourceManager<CodeSystem> codeSystems = new CanonicalResourceManager<CodeSystem>(false, minimalMemory);
  private final Set<String> supportedCodeSystems = new HashSet<String>();
  private final Set<String> unsupportedCodeSystems = new HashSet<String>(); // know that the terminology server doesn't support them
  private CanonicalResourceManager<ValueSet> valueSets = new CanonicalResourceManager<ValueSet>(false, minimalMemory);
  private CanonicalResourceManager<ConceptMap> maps = new CanonicalResourceManager<ConceptMap>(false, minimalMemory);
  protected CanonicalResourceManager<StructureMap> transforms = new CanonicalResourceManager<StructureMap>(false, minimalMemory);
  private CanonicalResourceManager<StructureDefinition> structures = new CanonicalResourceManager<StructureDefinition>(false, minimalMemory);
  private TypeManager typeManager = new TypeManager(structures);
  private final CanonicalResourceManager<Measure> measures = new CanonicalResourceManager<Measure>(false, minimalMemory);
  private final CanonicalResourceManager<Library> libraries = new CanonicalResourceManager<Library>(false, minimalMemory);
  private CanonicalResourceManager<ImplementationGuide> guides = new CanonicalResourceManager<ImplementationGuide>(false, minimalMemory);
  private final CanonicalResourceManager<CapabilityStatement> capstmts = new CanonicalResourceManager<CapabilityStatement>(false, minimalMemory);
  private final CanonicalResourceManager<SearchParameter> searchParameters = new CanonicalResourceManager<SearchParameter>(false, minimalMemory);
  private final CanonicalResourceManager<Questionnaire> questionnaires = new CanonicalResourceManager<Questionnaire>(false, minimalMemory);
  private final CanonicalResourceManager<OperationDefinition> operations = new CanonicalResourceManager<OperationDefinition>(false, minimalMemory);
  private final CanonicalResourceManager<PlanDefinition> plans = new CanonicalResourceManager<PlanDefinition>(false, minimalMemory);
  private final CanonicalResourceManager<ActorDefinition> actors = new CanonicalResourceManager<ActorDefinition>(false, minimalMemory);
  private final CanonicalResourceManager<Requirements> requirements = new CanonicalResourceManager<Requirements>(false, minimalMemory);
  private final CanonicalResourceManager<NamingSystem> systems = new CanonicalResourceManager<NamingSystem>(false, minimalMemory);
  private Map<String, NamingSystem> systemUrlMap;

  
  private UcumService ucumService;
  protected Map<String, byte[]> binaries = new HashMap<String, byte[]>();
  protected Map<String, Set<String>> oidCacheManual = new HashMap<>();
  protected List<OIDSource> oidSources = new ArrayList<>();

  protected Map<String, Map<String, ValidationResult>> validationCache = new HashMap<String, Map<String,ValidationResult>>();
  protected String name;
  private boolean allowLoadingDuplicates;

  private final Set<String> codeSystemsUsed = new HashSet<>();
  protected ToolingClientLogger txLog;
  private boolean canRunWithoutTerminology;
  protected boolean noTerminologyServer;
  private int expandCodesLimit = 1000;
  protected ILoggingService logger = new SystemOutLoggingService();
  protected Parameters expParameters;
  private TranslationServices translator = new NullTranslator();
  private Map<String, PackageInformation> packages = new HashMap<>();

  @Getter
  protected TerminologyCache txCache;
  protected TimeTracker clock;
  private boolean tlogging = true;
  private IWorkerContextManager.ICanonicalResourceLocator locator;
  protected String userAgent;

  protected BaseWorkerContext() throws FileNotFoundException, IOException, FHIRException {
    setValidationMessageLanguage(getLocale());
    clock = new TimeTracker();
  }

  protected BaseWorkerContext(Locale locale) throws FileNotFoundException, IOException, FHIRException {
    setValidationMessageLanguage(locale);
    clock = new TimeTracker();
  }

  protected BaseWorkerContext(CanonicalResourceManager<CodeSystem> codeSystems, CanonicalResourceManager<ValueSet> valueSets, CanonicalResourceManager<ConceptMap> maps, CanonicalResourceManager<StructureDefinition> profiles,
      CanonicalResourceManager<ImplementationGuide> guides) throws FileNotFoundException, IOException, FHIRException {
    this();
    this.codeSystems = codeSystems;
    this.valueSets = valueSets;
    this.maps = maps;
    this.structures = profiles;
    this.typeManager = new TypeManager(structures);
    this.guides = guides;
    clock = new TimeTracker();
  }

  protected void copy(BaseWorkerContext other) {
    synchronized (other.lock) { // tricky, because you need to lock this as well, but it's really not in use yet 
      allResourcesById.putAll(other.allResourcesById);
      translator = other.translator;
      codeSystems.copy(other.codeSystems);
      valueSets.copy(other.valueSets);
      maps.copy(other.maps);
      transforms.copy(other.transforms);
      structures.copy(other.structures);
      typeManager = new TypeManager(structures);
      searchParameters.copy(other.searchParameters);
      plans.copy(other.plans);
      questionnaires.copy(other.questionnaires);
      operations.copy(other.operations);
      systems.copy(other.systems);
      systemUrlMap = null;
      guides.copy(other.guides);
      capstmts.copy(other.capstmts);
      measures.copy(other.measures);
      libraries.copy(libraries);

      allowLoadingDuplicates = other.allowLoadingDuplicates;
      name = other.name;
      txLog = other.txLog;
      canRunWithoutTerminology = other.canRunWithoutTerminology;
      noTerminologyServer = other.noTerminologyServer;
      if (other.txCache != null)
        txCache = other.txCache; // no copy. for now?
      expandCodesLimit = other.expandCodesLimit;
      logger = other.logger;
      expParameters = other.expParameters;
      version = other.version;
      supportedCodeSystems.addAll(other.supportedCodeSystems);
      unsupportedCodeSystems.addAll(other.unsupportedCodeSystems);
      codeSystemsUsed.addAll(other.codeSystemsUsed);
      ucumService = other.ucumService;
      binaries.putAll(other.binaries);
      oidSources.addAll(other.oidSources);
      oidCacheManual.putAll(other.oidCacheManual);
      validationCache.putAll(other.validationCache);
      tlogging = other.tlogging;
      locator = other.locator;
      userAgent = other.userAgent;
      tcc.copy(other.tcc);
      cachingAllowed = other.cachingAllowed;
    }
  }
  
  
  public void cacheResource(Resource r) throws FHIRException {
    cacheResourceFromPackage(r, null);  
  }
  

  public void registerResourceFromPackage(CanonicalResourceProxy r, PackageInformation packageInfo) throws FHIRException {    
    PackageHackerR5.fixLoadedResource(r, packageInfo);

    synchronized (lock) {
      if (packageInfo != null) {
        packages.put(packageInfo.getVID(), packageInfo);
      }
      if (r.getId() != null) {
        Map<String, ResourceProxy> map = allResourcesById.get(r.getType());
        if (map == null) {
          map = new HashMap<String, ResourceProxy>();
          allResourcesById.put(r.getType(), map);
        }
        if ((packageInfo == null || !packageInfo.isExamplesPackage()) || !map.containsKey(r.getId())) {
          map.put(r.getId(), new ResourceProxy(r));
        }
      }

      String url = r.getUrl();
      if (!allowLoadingDuplicates && hasResourceVersion(r.getType(), url, r.getVersion()) && !packageInfo.isHTO()) {
        // spcial workaround for known problems with existing packages
        if (Utilities.existsInList(url, "http://hl7.org/fhir/SearchParameter/example")) {
          return;
        }
        CanonicalResource ex = fetchResourceWithException(r.getType(), url);
        throw new DefinitionException(formatMessage(I18nConstants.DUPLICATE_RESOURCE_, url, r.getVersion(), ex.getVersion(),
            ex.fhirType()));
      }
      switch(r.getType()) {
      case "StructureDefinition":
        if ("1.4.0".equals(version)) {
          StructureDefinition sd = (StructureDefinition) r.getResource();
          fixOldSD(sd);
        }
        structures.register(r, packageInfo);
        typeManager.see(r);
        break;
      case "ValueSet":
        valueSets.register(r, packageInfo);
        break;
      case "CodeSystem":
        codeSystems.register(r, packageInfo);
        break;
      case "ImplementationGuide":
        guides.register(r, packageInfo);
        break;
      case "CapabilityStatement":
        capstmts.register(r, packageInfo);
        break;
      case "Measure":
        measures.register(r, packageInfo);
        break;
      case "Library":
        libraries.register(r, packageInfo);
        break;
      case "SearchParameter":
        searchParameters.register(r, packageInfo);
        break;
      case "PlanDefinition":
        plans.register(r, packageInfo);
        break;
      case "OperationDefinition":
        operations.register(r, packageInfo);
        break;
      case "Questionnaire":
        questionnaires.register(r, packageInfo);
        break;
      case "ConceptMap":
        maps.register(r, packageInfo);
        break;
      case "StructureMap":
        transforms.register(r, packageInfo);
        break;
      case "NamingSystem":
        systems.register(r, packageInfo);
        break;
      case "Requirements":
        requirements.register(r, packageInfo);
        break;
      case "ActorDefinition":
        actors.register(r, packageInfo);
        break;
      }
    }
  }

  public void cacheResourceFromPackage(Resource r, PackageInformation packageInfo) throws FHIRException {
 
    synchronized (lock) {   
      if (packageInfo != null) {
        packages.put(packageInfo.getVID(), packageInfo);
      }

      if (r.getId() != null) {
        Map<String, ResourceProxy> map = allResourcesById.get(r.fhirType());
        if (map == null) {
          map = new HashMap<String, ResourceProxy>();
          allResourcesById.put(r.fhirType(), map);
        }
        if ((packageInfo == null || !packageInfo.isExamplesPackage()) || !map.containsKey(r.getId())) {
          map.put(r.getId(), new ResourceProxy(r));
        } else {
          logger.logDebugMessage(LogCategory.PROGRESS,"Ignore "+r.fhirType()+"/"+r.getId()+" from package "+packageInfo.toString());
        }
      }

      if (r instanceof CodeSystem || r instanceof NamingSystem) {
        String url = null;
        Set<String> oids = new HashSet<String>();
        if (r instanceof CodeSystem) {
          CodeSystem cs = (CodeSystem) r;
          url = cs.getUrl();
          for (Identifier id : cs.getIdentifier()) {
            if (id.hasValue() && id.getValue().startsWith("urn:oid:")) {
              oids.add(id.getValue().substring(8));           
            }
          }
        }
        if (r instanceof NamingSystem) {
          NamingSystem ns = ((NamingSystem) r);
          if (ns.getKind() == NamingSystemType.CODESYSTEM) {
            for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
              if (id.getType() == NamingSystemIdentifierType.URI) {
                url = id.getValue();
              }
              if (id.getType() == NamingSystemIdentifierType.OID) {
                oids.add(id.getValue());
              }
            }
          }
        }
        if (url != null) {
          for (String s : oids) {
            if (!oidCacheManual.containsKey(s)) {
              oidCacheManual.put(s, new HashSet<>());
            }
            oidCacheManual.get(s).add(url);
          }
        }
      }

      if (r instanceof CanonicalResource) {
        CanonicalResource m = (CanonicalResource) r;
        String url = m.getUrl();
        if (!allowLoadingDuplicates && hasResource(r.getClass(), url)) {
          // special workaround for known problems with existing packages
          if (Utilities.existsInList(url, "http://hl7.org/fhir/SearchParameter/example")) {
            return;
          }
          CanonicalResource ex = (CanonicalResource) fetchResourceWithException(r.getClass(), url);
          throw new DefinitionException(formatMessage(I18nConstants.DUPLICATE_RESOURCE_, url, ((CanonicalResource) r).getVersion(), ex.getVersion(),
              ex.fhirType()));
        }
        if (r instanceof StructureDefinition) {
          StructureDefinition sd = (StructureDefinition) m;
          if ("1.4.0".equals(version)) {
            fixOldSD(sd);
          }
          structures.see(sd, packageInfo);
          typeManager.see(sd);
        } else if (r instanceof ValueSet) {
          valueSets.see((ValueSet) m, packageInfo);
        } else if (r instanceof CodeSystem) {
          CodeSystemUtilities.crossLinkCodeSystem((CodeSystem) r);
          codeSystems.see((CodeSystem) m, packageInfo);
        } else if (r instanceof ImplementationGuide) {
          guides.see((ImplementationGuide) m, packageInfo);
        } else if (r instanceof CapabilityStatement) {
          capstmts.see((CapabilityStatement) m, packageInfo);
        } else if (r instanceof Measure) {
          measures.see((Measure) m, packageInfo);
        } else if (r instanceof Library) {
          libraries.see((Library) m, packageInfo);        
        } else if (r instanceof SearchParameter) {
          searchParameters.see((SearchParameter) m, packageInfo);
        } else if (r instanceof PlanDefinition) {
          plans.see((PlanDefinition) m, packageInfo);
        } else if (r instanceof OperationDefinition) {
          operations.see((OperationDefinition) m, packageInfo);
        } else if (r instanceof Questionnaire) {
          questionnaires.see((Questionnaire) m, packageInfo);
        } else if (r instanceof ConceptMap) {
          maps.see((ConceptMap) m, packageInfo);
        } else if (r instanceof StructureMap) {
          transforms.see((StructureMap) m, packageInfo);
        } else if (r instanceof NamingSystem) {
          systems.see((NamingSystem) m, packageInfo);
          systemUrlMap = null;
        } else if (r instanceof Requirements) {
          requirements.see((Requirements) m, packageInfo);
        } else if (r instanceof ActorDefinition) {
          actors.see((ActorDefinition) m, packageInfo);
          systemUrlMap = null;
        }
      }
    }
  }

  public Map<String, NamingSystem> getNSUrlMap() {
    if (systemUrlMap == null) {
      systemUrlMap = new HashMap<>();
      List<NamingSystem> nsl = systems.getList();
      for (NamingSystem ns : nsl) {
        for (NamingSystemUniqueIdComponent uid : ns.getUniqueId()) {
          if (uid.getType() == NamingSystemIdentifierType.URI && uid.hasValue()) {
            systemUrlMap.put(uid.getValue(), ns) ;
          }
        }        
      }
    }
    return systemUrlMap;
  }

  
  public void fixOldSD(StructureDefinition sd) {
    if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT && sd.getType().equals("Extension") && sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/")) {
      sd.setSnapshot(null);
    }
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      if (ed.getPath().equals("Extension.url") || ed.getPath().endsWith(".extension.url") ) {
        ed.setMin(1);
        if (ed.hasBase()) {
          ed.getBase().setMin(1);
        }
      }
      if ("extension".equals(ed.getSliceName())) {
        ed.setSliceName(null);
      }
    }
  }

  /*
   *  Compare business versions, returning "true" if the candidate newer version is in fact newer than the oldVersion
   *  Comparison will work for strictly numeric versions as well as multi-level versions separated by ., -, _, : or space
   *  Failing that, it will do unicode-based character ordering.
   *  E.g. 1.5.3 < 1.14.3
   *       2017-3-10 < 2017-12-7
   *       A3 < T2
   */
  private boolean laterVersion(String newVersion, String oldVersion) {
    // Compare business versions, retur
    newVersion = newVersion.trim();
    oldVersion = oldVersion.trim();
    if (StringUtils.isNumeric(newVersion) && StringUtils.isNumeric(oldVersion)) {
      return Double.parseDouble(newVersion) > Double.parseDouble(oldVersion);
    } else if (hasDelimiter(newVersion, oldVersion, ".")) {
      return laterDelimitedVersion(newVersion, oldVersion, "\\.");
    } else if (hasDelimiter(newVersion, oldVersion, "-")) {
      return laterDelimitedVersion(newVersion, oldVersion, "\\-");
    } else if (hasDelimiter(newVersion, oldVersion, "_")) {
      return laterDelimitedVersion(newVersion, oldVersion, "\\_");
    } else if (hasDelimiter(newVersion, oldVersion, ":")) {
      return laterDelimitedVersion(newVersion, oldVersion, "\\:");
    } else if (hasDelimiter(newVersion, oldVersion, " ")) {
      return laterDelimitedVersion(newVersion, oldVersion, "\\ ");
    } else {
      return newVersion.compareTo(oldVersion) > 0;
    }
  }
  
  /*
   * Returns true if both strings include the delimiter and have the same number of occurrences of it
   */
  private boolean hasDelimiter(String s1, String s2, String delimiter) {
    return s1.contains(delimiter) && s2.contains(delimiter) && s1.split(delimiter).length == s2.split(delimiter).length;
  }

  private boolean laterDelimitedVersion(String newVersion, String oldVersion, String delimiter) {
    String[] newParts = newVersion.split(delimiter);
    String[] oldParts = oldVersion.split(delimiter);
    for (int i = 0; i < newParts.length; i++) {
      if (!newParts[i].equals(oldParts[i])) {
        return laterVersion(newParts[i], oldParts[i]);
      }
    }
    // This should never happen
    throw new Error(formatMessage(I18nConstants.DELIMITED_VERSIONS_HAVE_EXACT_MATCH_FOR_DELIMITER____VS_, delimiter, newParts, oldParts));
  }
  
  protected <T extends CanonicalResource> void seeMetadataResource(T r, Map<String, T> map, List<T> list, boolean addId) throws FHIRException {
//    if (addId)
    //      map.put(r.getId(), r); // todo: why?
    list.add(r);
    if (r.hasUrl()) {
      // first, this is the correct reosurce for this version (if it has a version)
      if (r.hasVersion()) {
        map.put(r.getUrl()+"|"+r.getVersion(), r);
      }
      // if we haven't get anything for this url, it's the correct version
      if (!map.containsKey(r.getUrl())) {
        map.put(r.getUrl(), r);
      } else {
        List<T> rl = new ArrayList<T>();
        for (T t : list) {
          if (t.getUrl().equals(r.getUrl()) && !rl.contains(t)) {
            rl.add(t);
          }
        }
        Collections.sort(rl, new MetadataResourceVersionComparator<T>(list));
        map.put(r.getUrl(), rl.get(rl.size()-1));
        T latest = null;
        for (T t : rl) {
          if (VersionUtilities.versionsCompatible(t.getVersion(), r.getVersion())) {
            latest = t;
          }
        }
        if (latest != null) { // might be null if it's not using semver
          map.put(r.getUrl()+"|"+VersionUtilities.getMajMin(latest.getVersion()), rl.get(rl.size()-1));
        }
      }
    }
  }  

  @Override
  public CodeSystem fetchCodeSystem(String system, FhirPublication fhirVersion) {
    return fetchCodeSystem(system);
  }
  
  @Override
  public CodeSystem fetchCodeSystem(String system) {
    if (system == null) {
      return null;
    }
    if (system.contains("|")) {
      String s = system.substring(0, system.indexOf("|"));
      String v = system.substring(system.indexOf("|")+1);
      return fetchCodeSystem(s, v);
    }
    CodeSystem cs;
    synchronized (lock) {
      cs = codeSystems.get(system);
    }
    if (cs == null && locator != null) {
      locator.findResource(this, system);
      synchronized (lock) {
        cs = codeSystems.get(system);
      }
    }
    return cs;
  } 


  public CodeSystem fetchCodeSystem(String system, String version, FhirPublication fhirVersion) {
    return fetchCodeSystem(system, version);
  }
  
  public CodeSystem fetchCodeSystem(String system, String version) {
    if (version == null) {
      return fetchCodeSystem(system);
    }
    CodeSystem cs;
    synchronized (lock) {
      cs = codeSystems.get(system, version);
    }
    if (cs == null && locator != null) {
      locator.findResource(this, system);
      synchronized (lock) {
        cs = codeSystems.get(system);
      }
    }
    return cs;
  } 
  

  public CodeSystem fetchSupplementedCodeSystem(String system, FhirPublication fhirVersion) {
    return fetchSupplementedCodeSystem(system);  
  }
  
  public CodeSystem fetchSupplementedCodeSystem(String system, String version, FhirPublication fhirVersion) {
    return fetchSupplementedCodeSystem(system, version);
  }
  
  @Override
  public CodeSystem fetchSupplementedCodeSystem(String system) {
    CodeSystem cs = fetchCodeSystem(system);
    if (cs != null) {
      List<CodeSystem> supplements = codeSystems.getSupplements(cs);
      if (supplements.size() > 0) {
        cs = CodeSystemUtilities.mergeSupplements(cs, supplements);
      }
    }
    return cs;
  }

  @Override
  public CodeSystem fetchSupplementedCodeSystem(String system, String version) {
    CodeSystem cs = fetchCodeSystem(system, version);
    if (cs != null) {
      List<CodeSystem> supplements = codeSystems.getSupplements(cs);
      if (supplements.size() > 0) {
        cs = CodeSystemUtilities.mergeSupplements(cs, supplements);
      }
    }
    return cs;
  }


  public boolean supportsSystem(String system, FhirPublication fhirVersion) throws TerminologyServiceException {
    return supportsSystem(system);
  }
  
  @Override
  public boolean supportsSystem(String system) throws TerminologyServiceException {
    synchronized (lock) {
      if (codeSystems.has(system) && codeSystems.get(system).getContent() != CodeSystemContentMode.NOTPRESENT) {
        return true;
      } else if (supportedCodeSystems.contains(system)) {
        return true;
      } else if (system.startsWith("http://example.org") || system.startsWith("http://acme.com") || system.startsWith("http://hl7.org/fhir/valueset-") || system.startsWith("urn:oid:")) {
        return false;
      } else {
        if (noTerminologyServer) {
          return false;
        }
        if (tcc.getTxcaps() == null) {
          try {
            logger.logMessage("Terminology server: Check for supported code systems for "+system);
            final TerminologyCapabilities capabilityStatement = txCache.hasTerminologyCapabilities() ? txCache.getTerminologyCapabilities() : tcc.getClient().getTerminologyCapabilities();
            txCache.cacheTerminologyCapabilities(capabilityStatement);
            setTxCaps(capabilityStatement);
          } catch (Exception e) {
            if (canRunWithoutTerminology) {
              noTerminologyServer = true;
              logger.logMessage("==============!! Running without terminology server !! ==============");
              if (tcc.getClient() != null) {
                logger.logMessage("txServer = "+tcc.getClient().getId());
                logger.logMessage("Error = "+e.getMessage()+"");
              }
              logger.logMessage("=====================================================================");
              return false;
            } else {
              e.printStackTrace();
              throw new TerminologyServiceException(e);
            }
          }
          if (supportedCodeSystems.contains(system)) {
            return true;
          }
        }
      }
      return false;
    }
  }





  protected void txLog(String msg) {
    if (tlogging ) {
        logger.logDebugMessage(LogCategory.TX, msg);
    }
  }

  // --- expansion support ------------------------------------------------------------------------------------------------------------

  public int getExpandCodesLimit() {
    return expandCodesLimit;
  }

  public void setExpandCodesLimit(int expandCodesLimit) {
    this.expandCodesLimit = expandCodesLimit;
  }

  @Override
  public ValueSetExpansionOutcome expandVS(Resource src, ElementDefinitionBindingComponent binding, boolean cacheOk, boolean heirarchical) throws FHIRException {
    ValueSet vs = null;
    vs = fetchResource(ValueSet.class, binding.getValueSet(), src);
    if (vs == null) {
      throw new FHIRException(formatMessage(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_, binding.getValueSet()));
    }
    return expandVS(vs, cacheOk, heirarchical);
  }


  @Override
  public ValueSetExpansionOutcome expandVS(ConceptSetComponent inc, boolean hierarchical, boolean noInactive) throws TerminologyServiceException {
    ValueSet vs = new ValueSet();
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSetComposeComponent());
    vs.getCompose().setInactive(!noInactive);
    vs.getCompose().getInclude().add(inc);
    CacheToken cacheToken = txCache.generateExpandToken(vs, hierarchical);
    ValueSetExpansionOutcome res;
    res = txCache.getExpansion(cacheToken);
    if (res != null) {
      return res;
    }
    Parameters p = constructParameters(vs, hierarchical);
    for (ConceptSetComponent incl : vs.getCompose().getInclude()) {
      codeSystemsUsed.add(incl.getSystem());
    }
    for (ConceptSetComponent incl : vs.getCompose().getExclude()) {
      codeSystemsUsed.add(incl.getSystem());
    }
    
    if (noTerminologyServer) {
      return new ValueSetExpansionOutcome(formatMessage(I18nConstants.ERROR_EXPANDING_VALUESET_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE, false);
    }
    Map<String, String> params = new HashMap<String, String>();
    params.put("_limit", Integer.toString(expandCodesLimit ));
    params.put("_incomplete", "true");
    txLog("$expand on "+txCache.summary(vs));
    if (addDependentResources(p, vs)) {
      p.addParameter().setName("cache-id").setValue(new IdType(tcc.getCacheId()));              
    }
    
    try {
      ValueSet result = tcc.getClient().expandValueset(vs, p, params);
      res = new ValueSetExpansionOutcome(result).setTxLink(txLog.getLastId());  
    } catch (Exception e) {
      res = new ValueSetExpansionOutcome(e.getMessage() == null ? e.getClass().getName() : e.getMessage(), TerminologyServiceErrorClass.UNKNOWN, true);
      if (txLog != null) {
        res.setTxLink(txLog.getLastId());
      }
    }
    txCache.cacheExpansion(cacheToken, res, TerminologyCache.PERMANENT);
    return res;
  }

  @Override
  public ValueSetExpansionOutcome expandVS(ValueSet vs, boolean cacheOk, boolean heirarchical) {
    if (expParameters == null)
      throw new Error(formatMessage(I18nConstants.NO_EXPANSION_PARAMETERS_PROVIDED));
    Parameters p = expParameters.copy(); 
    return expandVS(vs, cacheOk, heirarchical, false, p);
  }

  @Override
  public ValueSetExpansionOutcome expandVS(ValueSet vs, boolean cacheOk, boolean heirarchical, boolean incompleteOk) {
    if (expParameters == null)
      throw new Error(formatMessage(I18nConstants.NO_EXPANSION_PARAMETERS_PROVIDED));
    Parameters p = expParameters.copy(); 
    return expandVS(vs, cacheOk, heirarchical, incompleteOk, p);
  }

  public ValueSetExpansionOutcome expandVS(ValueSet vs, boolean cacheOk, boolean hierarchical, boolean incompleteOk, Parameters pIn)  {
    if (pIn == null) {
      throw new Error(formatMessage(I18nConstants.NO_PARAMETERS_PROVIDED_TO_EXPANDVS));
    }
    if (vs.hasUrl() && (vs.getUrl().equals("http://hl7.org/fhir/ValueSet/all-time-units") || vs.getUrl().equals("http://hl7.org/fhir/ValueSet/all-distance-units"))) {
      return new ValueSetExpansionOutcome("This value set is not expanded correctly at this time (will be fixed in a future version)", TerminologyServiceErrorClass.VALUESET_UNSUPPORTED, false);
    }
    
    Parameters p = pIn.copy();

    if (vs.hasExpansion()) {
      return new ValueSetExpansionOutcome(vs.copy());
    }
    if (!vs.hasUrl()) {
      throw new Error(formatMessage(I18nConstants.NO_VALUE_SET_IN_URL));
    }
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      codeSystemsUsed.add(inc.getSystem());
    }
    for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
      codeSystemsUsed.add(inc.getSystem());
    }

    CacheToken cacheToken = txCache.generateExpandToken(vs, hierarchical);
    ValueSetExpansionOutcome res;
    if (cacheOk) {
      res = txCache.getExpansion(cacheToken);
      if (res != null) {
        return res;
      }
    }
    
    p.setParameter("excludeNested", !hierarchical);
    if (incompleteOk) {
      p.setParameter("incomplete-ok", true);      
    }

    List<String> allErrors = new ArrayList<>();
    
    // ok, first we try to expand locally
    ValueSetExpander vse = constructValueSetExpanderSimple(new ValidationOptions(vs.getFHIRPublicationVersion()));
    res = null;
    try {
      res = vse.expand(vs, p);
    } catch (Exception e) {
      allErrors.addAll(vse.getAllErrors());
      e.printStackTrace();
      res = new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.UNKNOWN, e instanceof EFhirClientException);
    }
    allErrors.addAll(vse.getAllErrors());
    if (res.getValueset() != null) {
      if (!res.getValueset().hasUrl()) {
        throw new Error(formatMessage(I18nConstants.NO_URL_IN_EXPAND_VALUE_SET));
      }
      txCache.cacheExpansion(cacheToken, res, TerminologyCache.TRANSIENT);
      return res;
    }
    if (res.getErrorClass() == TerminologyServiceErrorClass.INTERNAL_ERROR || isNoTerminologyServer()) { // this class is created specifically to say: don't consult the server
      return new ValueSetExpansionOutcome(res.getError(), res.getErrorClass(), false);
    }

    // if that failed, we try to expand on the server
    if (noTerminologyServer) {
      return new ValueSetExpansionOutcome(formatMessage(I18nConstants.ERROR_EXPANDING_VALUESET_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE, allErrors, false);
    }

    p.addParameter().setName("cache-id").setValue(new IdType(tcc.getCacheId()));              
    addDependentResources(p, vs);
    
    Map<String, String> params = new HashMap<String, String>();
    params.put("_limit", Integer.toString(expandCodesLimit ));
    params.put("_incomplete", "true");
    txLog("$expand on "+txCache.summary(vs));
    try {
      ValueSet result = tcc.getClient().expandValueset(vs, p, params);
      if (result != null) {
        if (!result.hasUrl()) {
          result.setUrl(vs.getUrl());
        }
        if (!result.hasUrl()) {
          throw new Error(formatMessage(I18nConstants.NO_URL_IN_EXPAND_VALUE_SET_2));
        }
      }
      res = new ValueSetExpansionOutcome(result).setTxLink(txLog.getLastId());  
    } catch (Exception e) {
      if (res != null && !res.isFromServer()) {
        res = new ValueSetExpansionOutcome(res.getError()+" (and "+e.getMessage()+")", res.getErrorClass(), false);
      } else {
        res = new ValueSetExpansionOutcome((e.getMessage() == null ? e.getClass().getName() : e.getMessage()), TerminologyServiceErrorClass.UNKNOWN, allErrors, true).setTxLink(txLog == null ? null : txLog.getLastId());
      }
    }
    txCache.cacheExpansion(cacheToken, res, TerminologyCache.PERMANENT);
    return res;
  }

//  private boolean hasTooCostlyExpansion(ValueSet valueset) {
//    return valueset != null && valueset.hasExpansion() && ToolingExtensions.hasExtension(valueset.getExpansion(), ToolingExtensions.EXT_EXP_TOOCOSTLY);
//  }
  
  // --- validate code -------------------------------------------------------------------------------
  
  @Override
  public ValidationResult validateCode(ValidationOptions options, String system, String version, String code, String display) {
    assert options != null;
    Coding c = new Coding(system, version, code, display);
    return validateCode(options, c, null);
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, String system, String version, String code, String display, ValueSet vs) {
    assert options != null;
    Coding c = new Coding(system, version, code, display);
    ValidationResult ret = validateCode(options, "$", c, vs);
    ret.trimPath("$");
    return ret;
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, String code, ValueSet vs) {
    assert options != null;
    Coding c = new Coding(null, code, null);
    return validateCode(options.withGuessSystem(), c, vs);
  }


  @Override
  public void validateCodeBatch(ValidationOptions options, List<? extends CodingValidationRequest> codes, ValueSet vs) {
    if (options == null) {
      options = ValidationOptions.defaults();
    }
    // 1st pass: what is in the cache? 
    // 2nd pass: What can we do internally 
    // 3rd pass: hit the server
    for (CodingValidationRequest t : codes) {
      t.setCacheToken(txCache != null ? txCache.generateValidationToken(options, t.getCoding(), vs == null ? t.getVsObj() : vs, expParameters) : null);
      if (t.getCoding().hasSystem()) {
        codeSystemsUsed.add(t.getCoding().getSystem());
      }
      if (txCache != null) { 
        t.setResult(txCache.getValidation(t.getCacheToken()));
      }
    }
    if (options.isUseClient()) {
      for (CodingValidationRequest t : codes) {
        if (!t.hasResult()) {
          try {
            ValueSetValidator vsc = constructValueSetCheckerSimple(options, vs == null ? t.getVsObj() : vs);
            vsc.setThrowToServer(options.isUseServer() && tcc.getClient() != null);
            ValidationResult res = vsc.validateCode("Coding", t.getCoding());
            if (txCache != null) {
              txCache.cacheValidation(t.getCacheToken(), res, TerminologyCache.TRANSIENT);
            }
            t.setResult(res);
          } catch (Exception e) {
          }
        }
      }      
    }  

    for (CodingValidationRequest t : codes) {
      if (!t.hasResult()) {
        String codeKey = t.getCoding().hasVersion() ? t.getCoding().getSystem()+"|"+t.getCoding().getVersion() : t.getCoding().getSystem();
        if (!options.isUseServer()) {
         t.setResult(new ValidationResult(IssueSeverity.WARNING,formatMessage(I18nConstants.UNABLE_TO_VALIDATE_CODE_WITHOUT_USING_SERVER), TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS, null));
        } else if (unsupportedCodeSystems.contains(codeKey)) {
          t.setResult(new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_NOTKNOWN, t.getCoding().getSystem()), TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, null));      
        } else if (noTerminologyServer) {
          t.setResult(new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.ERROR_VALIDATING_CODE_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE, null));
        }
      }
    }
    
    if (expParameters == null)
      throw new Error(formatMessage(I18nConstants.NO_EXPANSIONPROFILE_PROVIDED));
    // for those that that failed, we try to validate on the server
    Bundle batch = new Bundle();
    batch.setType(BundleType.BATCH);
    Set<String> systems = new HashSet<>();
    for (CodingValidationRequest codingValidationRequest : codes) {
      if (!codingValidationRequest.hasResult()) {
        Parameters pIn = constructParameters(options, codingValidationRequest, vs == null ? codingValidationRequest.getVsObj() : vs);
        setTerminologyOptions(options, pIn);
        BundleEntryComponent be = batch.addEntry();
        be.setResource(pIn);
        be.getRequest().setMethod(HTTPVerb.POST);
        if (vs != null || codingValidationRequest.getVsObj() != null) {
          be.getRequest().setUrl("ValueSet/$validate-code");          
        } else {
          be.getRequest().setUrl("CodeSystem/$validate-code");
        }
        be.setUserData("source", codingValidationRequest);
        systems.add(codingValidationRequest.getCoding().getSystem());
      }
    }
    if (batch.getEntry().size() > 0) {
      Bundle resp = processBatch(batch, systems);      
      for (int i = 0; i < batch.getEntry().size(); i++) {
        CodingValidationRequest t = (CodingValidationRequest) batch.getEntry().get(i).getUserData("source");
        BundleEntryComponent r = resp.getEntry().get(i);

        if (r.getResource() instanceof Parameters) {
          t.setResult(processValidationResult((Parameters) r.getResource(), vs != null ? vs.getUrl() : t.getVsObj() != null ? t.getVsObj().getUrl() : null, tcc.getClient().getAddress()));
          if (txCache != null) {
            txCache.cacheValidation(t.getCacheToken(), t.getResult(), TerminologyCache.PERMANENT);
          }
        } else {
          t.setResult(new ValidationResult(IssueSeverity.ERROR, getResponseText(r.getResource()), null).setTxLink(txLog == null ? null : txLog.getLastId()));          
        }
      }
    }    
  }

  private Bundle processBatch(Bundle batch, Set<String> systems) {
    txLog("$batch validate for "+batch.getEntry().size()+" codes on systems "+systems.toString());
    if (tcc.getClient() == null) {
      throw new FHIRException(formatMessage(I18nConstants.ATTEMPT_TO_USE_TERMINOLOGY_SERVER_WHEN_NO_TERMINOLOGY_SERVER_IS_AVAILABLE));
    }
    if (txLog != null) {
      txLog.clearLastId();
    }
    Bundle resp = tcc.getClient().validateBatch(batch);
    if (resp == null) {
      throw new FHIRException(formatMessage(I18nConstants.TX_SERVER_NO_BATCH_RESPONSE));          
    }
    return resp;
  }
  
  @Override
  public void validateCodeBatchByRef(ValidationOptions options, List<? extends CodingValidationRequest> codes, String vsUrl) {
    if (options == null) {
      options = ValidationOptions.defaults();
    }
    // 1st pass: what is in the cache? 
    // 2nd pass: What can we do internally 
    // 3rd pass: hit the server
    for (CodingValidationRequest t : codes) {
      t.setCacheToken(txCache != null ? txCache.generateValidationToken(options, t.getCoding(), vsUrl, expParameters) : null);
      if (t.getCoding().hasSystem()) {
        codeSystemsUsed.add(t.getCoding().getSystem());
      }
      if (txCache != null) { 
        t.setResult(txCache.getValidation(t.getCacheToken()));
      }
    }
    if (options.isUseClient()) {
      ValueSet vs = fetchResource(ValueSet.class, vsUrl);
      if (vs != null) {
        for (CodingValidationRequest t : codes) {
          if (!t.hasResult()) {
            try {
              ValueSetValidator vsc = constructValueSetCheckerSimple(options, vs);
              vsc.setThrowToServer(options.isUseServer() && tcc.getClient() != null);
              ValidationResult res = vsc.validateCode("Coding", t.getCoding());
              if (txCache != null) {
                txCache.cacheValidation(t.getCacheToken(), res, TerminologyCache.TRANSIENT);
              }
              t.setResult(res);
            } catch (Exception e) {
            }
          }
        }      
      }  
    }

    for (CodingValidationRequest t : codes) {
      if (!t.hasResult()) {
        String codeKey = t.getCoding().hasVersion() ? t.getCoding().getSystem()+"|"+t.getCoding().getVersion() : t.getCoding().getSystem();
        if (!options.isUseServer()) {
         t.setResult(new ValidationResult(IssueSeverity.WARNING,formatMessage(I18nConstants.UNABLE_TO_VALIDATE_CODE_WITHOUT_USING_SERVER), TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS, null));
        } else if (unsupportedCodeSystems.contains(codeKey)) {
          t.setResult(new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_NOTKNOWN, t.getCoding().getSystem()), TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, null));      
        } else if (noTerminologyServer) {
          t.setResult(new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.ERROR_VALIDATING_CODE_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE, null));
        }
      }
    }
    
    if (expParameters == null)
      throw new Error(formatMessage(I18nConstants.NO_EXPANSIONPROFILE_PROVIDED));
    // for those that that failed, we try to validate on the server
    Bundle batch = new Bundle();
    batch.setType(BundleType.BATCH);
    Set<String> systems = new HashSet<>();
    for (CodingValidationRequest codingValidationRequest : codes) {
      if (!codingValidationRequest.hasResult()) {
        Parameters pIn = constructParameters(options, codingValidationRequest, vsUrl);
        setTerminologyOptions(options, pIn);
        BundleEntryComponent be = batch.addEntry();
        be.setResource(pIn);
        be.getRequest().setMethod(HTTPVerb.POST);
        if (vsUrl != null) {
          be.getRequest().setUrl("ValueSet/$validate-code");
        } else {
          be.getRequest().setUrl("CodeSystem/$validate-code");
        }
        be.setUserData("source", codingValidationRequest);
        systems.add(codingValidationRequest.getCoding().getSystem());
      }
    }
    if (batch.getEntry().size() > 0) {
      Bundle resp = processBatch(batch, systems);      
      for (int i = 0; i < batch.getEntry().size(); i++) {
        CodingValidationRequest t = (CodingValidationRequest) batch.getEntry().get(i).getUserData("source");
        BundleEntryComponent r = resp.getEntry().get(i);

        if (r.getResource() instanceof Parameters) {
          t.setResult(processValidationResult((Parameters) r.getResource(), vsUrl, tcc.getClient().getAddress()));
          if (txCache != null) {
            txCache.cacheValidation(t.getCacheToken(), t.getResult(), TerminologyCache.PERMANENT);
          }
        } else {
          t.setResult(new ValidationResult(IssueSeverity.ERROR, getResponseText(r.getResource()), null).setTxLink(txLog == null ? null : txLog.getLastId()));          
        }
      }
    }    
  }
  
  private String getResponseText(Resource resource) {
    if (resource instanceof OperationOutcome) {
      return OperationOutcomeRenderer.toString((OperationOutcome) resource);
    }
    return "Todo";
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, Coding code, ValueSet vs) {
    ValidationContextCarrier ctxt = new ValidationContextCarrier();
    return validateCode(options, "Coding", code, vs, ctxt);
  }
  
  public ValidationResult validateCode(ValidationOptions options, String path, Coding code, ValueSet vs) {
    ValidationContextCarrier ctxt = new ValidationContextCarrier();
    return validateCode(options, path, code, vs, ctxt);
  }

  private final String getCodeKey(Coding code) {
    return code.hasVersion() ? code.getSystem()+"|"+code.getVersion() : code.getSystem();
  }

  @Override
  public ValidationResult validateCode(final ValidationOptions optionsArg, final Coding code, final ValueSet vs, final ValidationContextCarrier ctxt) {
    return validateCode(optionsArg, "Coding", code, vs, ctxt); 
  }
  
  public ValidationResult validateCode(final ValidationOptions optionsArg, String path, final Coding code, final ValueSet vs, final ValidationContextCarrier ctxt) {

    ValidationOptions options = optionsArg != null ? optionsArg : ValidationOptions.defaults();

    if (code.hasSystem()) {
      codeSystemsUsed.add(code.getSystem());
    }

    final CacheToken cacheToken = cachingAllowed && txCache != null ? txCache.generateValidationToken(options, code, vs, expParameters) : null;
    ValidationResult res = null;
    if (cachingAllowed && txCache != null) {
      res = txCache.getValidation(cacheToken);
    }
    if (res != null) {
      updateUnsupportedCodeSystems(res, code, getCodeKey(code));
      return res;
    }

    List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    Set<String> unknownSystems = new HashSet<>();
    
    String localError = null;
    String localWarning = null;
    TerminologyServiceErrorClass type = TerminologyServiceErrorClass.UNKNOWN;
    if (options.isUseClient()) {
      // ok, first we try to validate locally
      try {
        ValueSetValidator vsc = constructValueSetCheckerSimple(options, vs, ctxt);
        vsc.setUnknownSystems(unknownSystems);
        vsc.setThrowToServer(options.isUseServer() && tcc.getClient() != null);
        if (!ValueSetUtilities.isServerSide(code.getSystem())) {
          res = vsc.validateCode(path, code);
          if (txCache != null && cachingAllowed) {
            txCache.cacheValidation(cacheToken, res, TerminologyCache.TRANSIENT);
          }
          return res;
        }
      } catch (VSCheckerException e) {
        if (e.isWarning()) {
          localWarning = e.getMessage();
        } else {  
          localError = e.getMessage();
        }
        if (e.getIssues() != null) {
          issues.addAll(e.getIssues());
        }
        type = e.getType();
      } catch (TerminologyServiceProtectionException e) {
        OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR, e.getType());
        iss.getDetails().setText(e.getMessage());
        issues.add(iss);
        return new ValidationResult(IssueSeverity.FATAL, e.getMessage(), e.getError(), issues);
      } catch (Exception e) {
//        e.printStackTrace();
        localError = e.getMessage();
      }
    }
    
    if (localError != null && tcc.getClient() == null) {
      if (unknownSystems.size() > 0) {
        return new ValidationResult(IssueSeverity.ERROR, localError, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, issues).setUnknownSystems(unknownSystems);
      } else {
        return new ValidationResult(IssueSeverity.ERROR, localError, TerminologyServiceErrorClass.UNKNOWN, issues);
      }
    }
    if (localWarning != null && tcc.getClient() == null) {
      return new ValidationResult(IssueSeverity.WARNING,formatMessage(I18nConstants.UNABLE_TO_VALIDATE_CODE_WITHOUT_USING_SERVER, localWarning), TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS, issues);       
    }
    if (!options.isUseServer()) {
      if (localWarning != null) {
        return new ValidationResult(IssueSeverity.WARNING,formatMessage(I18nConstants.UNABLE_TO_VALIDATE_CODE_WITHOUT_USING_SERVER, localWarning), TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS, issues);       
      } else {
        return new ValidationResult(IssueSeverity.WARNING,formatMessage(I18nConstants.UNABLE_TO_VALIDATE_CODE_WITHOUT_USING_SERVER, localError), TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS, issues);
      }
    }
    String codeKey = getCodeKey(code);
    if (unsupportedCodeSystems.contains(codeKey)) {
      return new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_NOTKNOWN, code.getSystem()), TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, issues);      
    }
    
    // if that failed, we try to validate on the server
    if (noTerminologyServer) {
      return new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.ERROR_VALIDATING_CODE_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE, issues);
    }
    String csumm =cachingAllowed && txCache != null ? txCache.summary(code) : null;
    if (cachingAllowed && txCache != null) {
      txLog("$validate "+csumm+(vs == null ? "" : " for "+ txCache.summary(vs)));
    } else {
      txLog("$validate "+csumm+" before cache exists");
    }
    try {
      Parameters pIn = constructParameters(options, code);
      res = validateOnServer(vs, pIn, options);
    } catch (Exception e) {
      res = new ValidationResult(IssueSeverity.ERROR, e.getMessage() == null ? e.getClass().getName() : e.getMessage(), null).setTxLink(txLog == null ? null : txLog.getLastId()).setErrorClass(TerminologyServiceErrorClass.SERVER_ERROR);
    }
    if (!res.isOk() && res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED && (localError != null && !localError.equals(ValueSetValidator.NO_TRY_THE_SERVER))) {
      res = new ValidationResult(IssueSeverity.ERROR, localError, null).setTxLink(txLog == null ? null : txLog.getLastId()).setErrorClass(type);
    } 
    if (!res.isOk() && localError != null) {
      res.setDiagnostics("Local Error: "+localError.trim()+". Server Error: "+res.getMessage());
    } else if (!res.isOk() && res.getUnknownSystems() != null && res.getUnknownSystems().contains(codeKey) && localWarning != null) {
      // we had some problem evaluating locally, but the server doesn't know the code system, so we'll just go with the local error
      res.setMessage(localWarning);
      res.setSeverity(IssueSeverity.WARNING);
      res.setDiagnostics("Local Warning: "+localWarning.trim()+". Server Error: "+res.getMessage());
    }
    updateUnsupportedCodeSystems(res, code, codeKey);
    if (cachingAllowed && txCache != null) { // we never cache unsupported code systems - we always keep trying (but only once per run)
      txCache.cacheValidation(cacheToken, res, TerminologyCache.PERMANENT);
    }
    return res;
  }

  protected ValueSetExpander constructValueSetExpanderSimple(ValidationOptions options) {
    return new ValueSetExpander(this, new TerminologyOperationContext(this, options));
  }

  protected ValueSetValidator constructValueSetCheckerSimple(ValidationOptions options,  ValueSet vs,  ValidationContextCarrier ctxt) {
    return new ValueSetValidator(this, new TerminologyOperationContext(this, options), options, vs, ctxt, expParameters, tcc.getTxcaps());
  }

  protected ValueSetValidator constructValueSetCheckerSimple( ValidationOptions options,  ValueSet vs) {
    return new ValueSetValidator(this, new TerminologyOperationContext(this, options), options, vs, expParameters, tcc.getTxcaps());
  }

  protected Parameters constructParameters(ValueSet vs, boolean hierarchical) {
    Parameters p = expParameters.copy();
    p.setParameter("includeDefinition", false);
    p.setParameter("excludeNested", !hierarchical);

    addDependentResources(p, vs);
    p.addParameter().setName("cache-id").setValue(new IdType(tcc.getCacheId()));
    return p;
  }

  protected Parameters constructParameters(ValidationOptions options, Coding coding) {
    Parameters pIn = new Parameters();
    pIn.addParameter().setName("coding").setValue(coding);
    if (options.isGuessSystem()) {
      pIn.addParameter().setName("inferSystem").setValue(new BooleanType(true));
    }
    setTerminologyOptions(options, pIn);
    return pIn;
  }

  protected Parameters constructParameters(ValidationOptions options, CodeableConcept codeableConcept) {
    Parameters pIn = new Parameters();
    pIn.addParameter().setName("codeableConcept").setValue(codeableConcept);
    setTerminologyOptions(options, pIn);
    return pIn;
  }

  protected Parameters constructParameters(ValidationOptions options, CodingValidationRequest codingValidationRequest, ValueSet valueSet) {
    Parameters pIn = new Parameters();
    pIn.addParameter().setName("coding").setValue(codingValidationRequest.getCoding());
    if (options.isGuessSystem()) {
      pIn.addParameter().setName("inferSystem").setValue(new BooleanType(true));
    }
    if (valueSet != null) {
      pIn.addParameter().setName("valueSet").setResource(valueSet);
    }
    
    pIn.addParameters(expParameters);
    return pIn;
  }

  protected Parameters constructParameters(ValidationOptions options, CodingValidationRequest codingValidationRequest, String vsUrl) {
    Parameters pIn = new Parameters();
    pIn.addParameter().setName("coding").setValue(codingValidationRequest.getCoding());
    if (options.isGuessSystem()) {
      pIn.addParameter().setName("inferSystem").setValue(new BooleanType(true));
    }
    if (vsUrl != null) {
      pIn.addParameter().setName("url").setValue(new CanonicalType(vsUrl));
    }
    pIn.addParameters(expParameters);
    return pIn;
  }

  private void updateUnsupportedCodeSystems(ValidationResult res, Coding code, String codeKey) {
    if (res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED && !code.hasVersion() && fetchCodeSystem(codeKey) == null) {
      unsupportedCodeSystems.add(codeKey);
    }
  }

  private void setTerminologyOptions(ValidationOptions options, Parameters pIn) {
    if (options.hasLanguages()) {
      pIn.addParameter("displayLanguage", options.getLanguages().toString());
    }
    if (options.isMembershipOnly()) {
      pIn.addParameter("valueset-membership-only", true);
    }
    if (options.isDisplayWarningMode()) {
      pIn.addParameter("lenient-display-validation", true);
    }
    if (options.isVersionFlexible()) {
      pIn.addParameter("default-to-latest-version", true);     
    }
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, CodeableConcept code, ValueSet vs) {
    CacheToken cacheToken = txCache.generateValidationToken(options, code, vs, expParameters);
    ValidationResult res = null;
    if (cachingAllowed) {
      res = txCache.getValidation(cacheToken);
      if (res != null) {
        return res;
      }
    }
    for (Coding c : code.getCoding()) {
      if (c.hasSystem()) {
        codeSystemsUsed.add(c.getSystem());
      }
    }
    Set<String> unknownSystems = new HashSet<>();

    List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    
    String localError = null;
    String localWarning = null;
    
    if (options.isUseClient()) {
      // ok, first we try to validate locally
      try {
        ValueSetValidator vsc = constructValueSetCheckerSimple(options, vs);
        vsc.setUnknownSystems(unknownSystems);
        vsc.setThrowToServer(options.isUseServer() && tcc.getClient() != null);
        res = vsc.validateCode("CodeableConcept", code);
        if (cachingAllowed) {
          txCache.cacheValidation(cacheToken, res, TerminologyCache.TRANSIENT);
        }
        return res;
      } catch (VSCheckerException e) {
        if (e.isWarning()) {
          localWarning = e.getMessage();
        } else {  
          localError = e.getMessage();
        }
        if (e.getIssues() != null) {
          issues.addAll(e.getIssues());
        }
      } catch (TerminologyServiceProtectionException e) {
        OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR, e.getType());
        iss.getDetails().setText(e.getMessage());
        issues.add(iss);
        return new ValidationResult(IssueSeverity.FATAL, e.getMessage(), e.getError(), issues);
      } catch (Exception e) {
//        e.printStackTrace();
        localError = e.getMessage();
      }
    }

    if (localError != null && tcc.getClient() == null) {
      if (unknownSystems.size() > 0) {
        return new ValidationResult(IssueSeverity.ERROR, localError, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED, issues).setUnknownSystems(unknownSystems);
      } else {
        return new ValidationResult(IssueSeverity.ERROR, localError, TerminologyServiceErrorClass.UNKNOWN, issues);
      }
    }
    if (localWarning != null && tcc.getClient() == null) {
      return new ValidationResult(IssueSeverity.WARNING,formatMessage(I18nConstants.UNABLE_TO_VALIDATE_CODE_WITHOUT_USING_SERVER, localWarning), TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS, issues);       
    }
    
    if (!options.isUseServer()) {
      return new ValidationResult(IssueSeverity.WARNING, "Unable to validate code without using server", TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS, null);      
    }
    
    // if that failed, we try to validate on the server
    if (noTerminologyServer) {
      return new ValidationResult(IssueSeverity.ERROR, "Error validating code: running without terminology services", TerminologyServiceErrorClass.NOSERVICE, null);
    }
    txLog("$validate "+txCache.summary(code)+" for "+ txCache.summary(vs));
    try {
      Parameters pIn = constructParameters(options, code);
      res = validateOnServer(vs, pIn, options);
    } catch (Exception e) {
      res = new ValidationResult(IssueSeverity.ERROR, e.getMessage() == null ? e.getClass().getName() : e.getMessage(), null).setTxLink(txLog == null ? null : txLog.getLastId());
    }
    if (cachingAllowed) {
      txCache.cacheValidation(cacheToken, res, TerminologyCache.PERMANENT);
    }
    return res;
  }

  protected ValidationResult validateOnServer(ValueSet vs, Parameters pin, ValidationOptions options) throws FHIRException {

    if (vs != null) {
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        codeSystemsUsed.add(inc.getSystem());
      }
      for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
        codeSystemsUsed.add(inc.getSystem());
      }
    }

    addServerValidationParameters(vs, pin, options);

    if (txLog != null) {
      txLog.clearLastId();
    }
    if (tcc.getClient() == null) {
      throw new FHIRException(formatMessage(I18nConstants.ATTEMPT_TO_USE_TERMINOLOGY_SERVER_WHEN_NO_TERMINOLOGY_SERVER_IS_AVAILABLE));
    }
    Parameters pOut;
    if (vs == null) {
      pOut = tcc.getClient().validateCS(pin);
    } else {
      pOut = tcc.getClient().validateVS(pin);
    }
    return processValidationResult(pOut, vs == null ? null : vs.getUrl(), tcc.getClient().getAddress());
  }

  protected void addServerValidationParameters(ValueSet vs, Parameters pin, ValidationOptions options) {
    boolean cache = false;
    if (vs != null) {
      if (tcc.isTxCaching() && tcc.getCacheId() != null && vs.getUrl() != null && tcc.getCached().contains(vs.getUrl()+"|"+ vs.getVersion())) {
        pin.addParameter().setName("url").setValue(new UriType(vs.getUrl()+(vs.hasVersion() ? "|"+ vs.getVersion() : "")));
      } else if (options.getVsAsUrl()){
        pin.addParameter().setName("url").setValue(new UriType(vs.getUrl()));
      } else {
        pin.addParameter().setName("valueSet").setResource(vs);
        if (vs.getUrl() != null) {
          tcc.getCached().add(vs.getUrl()+"|"+ vs.getVersion());
        }
      }
      cache = true;
      addDependentResources(pin, vs);
    }
    pin.addParameter().setName("cache-id").setValue(new IdType(tcc.getCacheId()));
    for (ParametersParameterComponent pp : pin.getParameter()) {
      if (pp.getName().equals("profile")) {
        throw new Error(formatMessage(I18nConstants.CAN_ONLY_SPECIFY_PROFILE_IN_THE_CONTEXT));
      }
    }
    if (expParameters == null) {
      throw new Error(formatMessage(I18nConstants.NO_EXPANSIONPROFILE_PROVIDED));
    }
    pin.addParameters(expParameters);

    if (options.isDisplayWarningMode()) {
      pin.addParameter("mode","lenient-display-validation");
    }
  }

  private boolean addDependentResources(Parameters pin, ValueSet vs) {
    boolean cache = false;
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      cache = addDependentResources(pin, inc, vs) || cache;
    }
    for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
      cache = addDependentResources(pin, inc, vs) || cache;
    }
    return cache;
  }

  private boolean addDependentResources(Parameters pin, ConceptSetComponent inc, Resource src) {
    boolean cache = false;
    for (CanonicalType c : inc.getValueSet()) {
      ValueSet vs = fetchResource(ValueSet.class, c.getValue(), src);
      if (vs != null && !hasCanonicalResource(pin, "tx-resource", vs.getVUrl())) {
        cache = checkAddToParams(pin, vs) || cache;
        addDependentResources(pin, vs);
      }
    }
    CodeSystem cs = fetchResource(CodeSystem.class, inc.getSystem(), src);
    if (cs != null && !hasCanonicalResource(pin, "tx-resource", cs.getVUrl()) && (cs.getContent() == CodeSystemContentMode.COMPLETE || cs.getContent() == CodeSystemContentMode.FRAGMENT)) {
      cache = checkAddToParams(pin, cs) || cache;
      // todo: supplements
    }
    return cache;
  }

  private boolean checkAddToParams(Parameters pin, CanonicalResource cr) {
    boolean cache = false;
    boolean addToParams = false;
    if (tcc.usingCache()) {
      if (!tcc.alreadyCached(cr)) {
        tcc.addToCache(cr);
        if (logger.isDebugLogging()) {
          logger.logMessage("add to cache: "+cr.getVUrl());
        }
        addToParams = true;
        cache = true;
      } else {
        if (logger.isDebugLogging()) {
          logger.logMessage("already cached: "+cr.getVUrl());
        }
      }
    } else {
      addToParams = true;
    }
    if (addToParams) {
      pin.addParameter().setName("tx-resource").setResource(cr);
    }
    return cache;
  }

  private boolean hasCanonicalResource(Parameters pin, String name, String vUrl) {
    for (ParametersParameterComponent p : pin.getParameter()) {
      if (name.equals(p.getName()) && p.hasResource() &&
          p.getResource() instanceof CanonicalResource && vUrl.equals(((CanonicalResource) p.getResource()).getVUrl())) {
        return true;
      }
    }
    return false;
  }

  public ValidationResult processValidationResult(Parameters pOut, String vs, String server) {
    boolean ok = false;
    String message = "No Message returned";
    String display = null;
    String system = null;
    String code = null;
    String version = null;
    boolean inactive = false;
    String status = null;
    List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    Set<String> unknownSystems = new HashSet<>();

    TerminologyServiceErrorClass err = TerminologyServiceErrorClass.UNKNOWN;
    for (ParametersParameterComponent p : pOut.getParameter()) {
      if (p.hasValue()) {
        if (p.getName().equals("result")) {
          ok = ((BooleanType) p.getValue()).getValue().booleanValue();
        } else if (p.getName().equals("message")) {
          message = p.getValue().primitiveValue();
        } else if (p.getName().equals("display")) {
          display = p.getValue().primitiveValue();
        } else if (p.getName().equals("system")) {
          system = ((PrimitiveType<?>) p.getValue()).asStringValue();
        } else if (p.getName().equals("version")) {
          version = ((PrimitiveType<?>) p.getValue()).asStringValue();
        } else if (p.getName().equals("code")) {
          code = ((PrimitiveType<?>) p.getValue()).asStringValue();
        } else if (p.getName().equals("inactive")) {
          inactive = "true".equals(((PrimitiveType<?>) p.getValue()).asStringValue());
        } else if (p.getName().equals("status")) {
          status = ((PrimitiveType<?>) p.getValue()).asStringValue();
        } else if (p.getName().equals("x-caused-by-unknown-system")) {
          err = TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED;
          unknownSystems.add(((PrimitiveType<?>) p.getValue()).asStringValue());      
        } else if (p.getName().equals("warning-withdrawn")) {
          String msg = ((PrimitiveType<?>) p.getValue()).asStringValue();
          OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION, org.hl7.fhir.r5.model.OperationOutcome.IssueType.BUSINESSRULE);
          iss.getDetails().setText(formatMessage(vs == null ? I18nConstants.MSG_WITHDRAWN : I18nConstants.MSG_WITHDRAWN_SRC, msg, vs, impliedType(msg)));              
          issues.add(iss);
        } else if (p.getName().equals("warning-deprecated")) {
          String msg = ((PrimitiveType<?>) p.getValue()).asStringValue();
          OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION, org.hl7.fhir.r5.model.OperationOutcome.IssueType.BUSINESSRULE);
          iss.getDetails().setText(formatMessage(vs == null ? I18nConstants.MSG_DEPRECATED : I18nConstants.MSG_DEPRECATED_SRC, msg, vs, impliedType(msg)));              
          issues.add(iss);
        } else if (p.getName().equals("warning-retired")) {
          String msg = ((PrimitiveType<?>) p.getValue()).asStringValue();
          OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION, org.hl7.fhir.r5.model.OperationOutcome.IssueType.BUSINESSRULE);
          iss.getDetails().setText(formatMessage(vs == null ? I18nConstants.MSG_RETIRED : I18nConstants.MSG_RETIRED_SRC, msg, vs, impliedType(msg)));              
          issues.add(iss);
        } else if (p.getName().equals("warning-experimental")) {
          String msg = ((PrimitiveType<?>) p.getValue()).asStringValue();
          OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION, org.hl7.fhir.r5.model.OperationOutcome.IssueType.BUSINESSRULE);
          iss.getDetails().setText(formatMessage(vs == null ? I18nConstants.MSG_EXPERIMENTAL : I18nConstants.MSG_EXPERIMENTAL_SRC, msg, vs, impliedType(msg)));              
          issues.add(iss);
        } else if (p.getName().equals("warning-draft")) {
          String msg = ((PrimitiveType<?>) p.getValue()).asStringValue();
          OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION, org.hl7.fhir.r5.model.OperationOutcome.IssueType.BUSINESSRULE);
          iss.getDetails().setText(formatMessage(vs == null ? I18nConstants.MSG_DRAFT : I18nConstants.MSG_DRAFT_SRC, msg, vs, impliedType(msg)));              
          issues.add(iss);
        } else if (p.getName().equals("cause")) {
          try {
            IssueType it = IssueType.fromCode(((StringType) p.getValue()).getValue());
            if (it == IssueType.UNKNOWN) {
              err = TerminologyServiceErrorClass.UNKNOWN;
            } else if (it == IssueType.NOTFOUND) {
              err = TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED;
            } else if (it == IssueType.NOTSUPPORTED) {
              err = TerminologyServiceErrorClass.VALUESET_UNSUPPORTED;
            } else {
              err = null;
            }
          } catch (FHIRException e) {
          }
        }
      } else if (p.hasResource()) {
        if (p.getName().equals("issues")) {
          OperationOutcome oo = (OperationOutcome) p.getResource();
          for (OperationOutcomeIssueComponent iss : oo.getIssue()) {
            iss.addExtension(ToolingExtensions.EXT_ISSUE_SERVER, new UrlType(server));
            issues.add(iss);
          }
        } else {
          // nothing?
        }
      }
    }
    ValidationResult res = null;
    if (!ok) {
      res = new ValidationResult(IssueSeverity.ERROR, message, err, null).setTxLink(txLog.getLastId());
      if (code != null) {
        res.setDefinition(new ConceptDefinitionComponent().setDisplay(display).setCode(code));
        res.setDisplay(display);
      }
    } else if (message != null && !message.equals("No Message returned")) { 
      res = new ValidationResult(IssueSeverity.WARNING, message, system, version, new ConceptDefinitionComponent().setDisplay(display).setCode(code), display, null).setTxLink(txLog.getLastId());
    } else if (display != null) {
      res = new ValidationResult(system, version, new ConceptDefinitionComponent().setDisplay(display).setCode(code), display).setTxLink(txLog.getLastId());
    } else {
      res = new ValidationResult(system, version, new ConceptDefinitionComponent().setCode(code), null).setTxLink(txLog.getLastId());
    }
    res.setIssues(issues);
    res.setStatus(inactive, status);
    res.setUnknownSystems(unknownSystems);
    return res;
  }

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  
  private Object impliedType(String msg) {
    if (msg.contains("/CodeSystem")) {
      return "CodeSystem";
    }
    if (msg.contains("/ValueSet")) {
      return "ValueSet";
    }
    return "item";
  }

  protected void initTS(String cachePath) throws IOException {
    if (cachePath != null && !new File(cachePath).exists()) {
      Utilities.createDirectory(cachePath);
    }
    txCache = new TerminologyCache(lock, cachePath);
  }

  public void clearTSCache(String url) throws Exception {
    txCache.removeCS(url);
  }

  public void clearTS() {
    txCache.clear();
  }

  public boolean isCanRunWithoutTerminology() {
    return canRunWithoutTerminology;
  }

  public void setCanRunWithoutTerminology(boolean canRunWithoutTerminology) {
    this.canRunWithoutTerminology = canRunWithoutTerminology;
  }

  public void setLogger(@Nonnull ILoggingService logger) {
    this.logger = logger;
  }

  public Parameters getExpansionParameters() {
    return expParameters;
  }

  public void setExpansionProfile(Parameters expParameters) {
    this.expParameters = expParameters;
  }

  @Override
  public boolean isNoTerminologyServer() {
    return noTerminologyServer || tcc.getClient() == null;
  }

  public void setNoTerminologyServer(boolean noTerminologyServer) {
    this.noTerminologyServer = noTerminologyServer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public List<String> getResourceNames(FhirPublication fhirVersion) {
    return getResourceNames();    
  }
  
  public Set<String> getResourceNamesAsSet(FhirPublication fhirVersion) {
    return getResourceNamesAsSet();
  }
  
  @Override
  public Set<String> getResourceNamesAsSet() {
    Set<String> res = new HashSet<String>();
    res.addAll(getResourceNames());
    return res;
  }

  public boolean isAllowLoadingDuplicates() {
    return allowLoadingDuplicates;
  }

  public void setAllowLoadingDuplicates(boolean allowLoadingDuplicates) {
    this.allowLoadingDuplicates = allowLoadingDuplicates;
  }

  @Override
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri) throws FHIRException {
    return fetchResourceWithException(class_, uri, null);
  }
  
  public <T extends Resource> T fetchResourceWithException(String cls, String uri) throws FHIRException {
    return fetchResourceWithExceptionByVersion(cls, uri, null, null);
  }
  
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri, Resource sourceForReference) throws FHIRException {
    return fetchResourceWithExceptionByVersion(class_, uri, null, sourceForReference);
  }
  
  @SuppressWarnings("unchecked")
  public <T extends Resource> T fetchResourceWithExceptionByVersion(Class<T> class_, String uri, String version, Resource sourceForReference) throws FHIRException {
    if (uri == null) {
      return null;
    }
    if (uri.startsWith("#")) {
      if (sourceForReference != null && sourceForReference instanceof DomainResource) {
        for (Resource r : ((DomainResource) sourceForReference).getContained()) {
          if (r.getClass() == class_ &&( "#"+r.getIdBase()).equals(uri)) {
            if (r instanceof CanonicalResource) {
              CanonicalResource cr = (CanonicalResource) r;
              if (!cr.hasUrl()) {
                cr.setUrl(Utilities.makeUuidUrn());
              }              
            }
            return (T) r;
          }
        }
      }
      return null;
    }
    
    if (QA_CHECK_REFERENCE_SOURCE) {
      // it can be tricky to trace the source of a reference correctly. The code isn't water tight,
      // particularly around snapshot generation. Enable this code to check that the references are 
      // correct (but it's slow)
      if (sourceForReference != null && uri.contains("ValueSet")) {
        if (!ResourceUtilities.hasURL(uri, sourceForReference)) {
          System.out.print("Claimed source doesn't have url in it: "+sourceForReference.fhirType()+"/"+sourceForReference.getIdPart()+" -> "+uri);
          System.out.println();
        }
      }
    }
   
    List<String> pvlist = new ArrayList<>();
    if (sourceForReference != null && sourceForReference.getSourcePackage() != null) {
      populatePVList(pvlist, sourceForReference.getSourcePackage());
    }
    
    if (class_ == StructureDefinition.class) {
      uri = ProfileUtilities.sdNs(uri, null);
    }
    synchronized (lock) {

      if (version == null) {
        if (uri.contains("|")) {
          version = uri.substring(uri.lastIndexOf("|")+1);
          uri = uri.substring(0, uri.lastIndexOf("|"));
        }
      } else {
        assert !uri.contains("|");
      }
      if (uri.contains("#")) {
        uri = uri.substring(0, uri.indexOf("#"));
      } 
      if (class_ == Resource.class || class_ == null) {
        if (structures.has(uri)) {
          return (T) structures.get(uri, version, pvlist);
        }        
        if (guides.has(uri)) {
          return (T) guides.get(uri, version, pvlist);
        } 
        if (capstmts.has(uri)) {
          return (T) capstmts.get(uri, version, pvlist);
        } 
        if (measures.has(uri)) {
          return (T) measures.get(uri, version, pvlist);
        } 
        if (libraries.has(uri)) {
          return (T) libraries.get(uri, version, pvlist);
        } 
        if (valueSets.has(uri)) {
          return (T) valueSets.get(uri, version, pvlist);
        } 
        if (codeSystems.has(uri)) {
          return (T) codeSystems.get(uri, version, pvlist);
        } 
        if (operations.has(uri)) {
          return (T) operations.get(uri, version, pvlist);
        } 
        if (searchParameters.has(uri)) {
          return (T) searchParameters.get(uri, version, pvlist);
        } 
        if (plans.has(uri)) {
          return (T) plans.get(uri, version, pvlist);
        } 
        if (maps.has(uri)) {
          return (T) maps.get(uri, version, pvlist);
        } 
        if (transforms.has(uri)) {
          return (T) transforms.get(uri, version, pvlist);
        } 
        if (actors.has(uri)) {
          return (T) transforms.get(uri, version, pvlist);
        } 
        if (requirements.has(uri)) {
          return (T) transforms.get(uri, version, pvlist);
        } 
        if (questionnaires.has(uri)) {
          return (T) questionnaires.get(uri, version, pvlist);
        } 

        for (Map<String, ResourceProxy> rt : allResourcesById.values()) {
          for (ResourceProxy r : rt.values()) {
            if (uri.equals(r.getUrl())) {
              if (version == null || version == r.getResource().getMeta().getVersionId()) {
                return (T) r.getResource();
              }
            }
          }            
        }
        if (uri.matches(Constants.URI_REGEX) && !uri.contains("ValueSet")) {
          return null;
        }

        // it might be a special URL.
//        if (Utilities.isAbsoluteUrl(uri) || uri.startsWith("ValueSet/")) {
//          Resource res = null; // findTxValueSet(uri);
//          if (res != null) {
//            return (T) res;
//          }
//        }
        return null;      
      } else if (class_ == ImplementationGuide.class) {
        return (T) guides.get(uri, version, pvlist);
      } else if (class_ == CapabilityStatement.class) {
        return (T) capstmts.get(uri, version, pvlist);
      } else if (class_ == Measure.class) {
        return (T) measures.get(uri, version, pvlist);
      } else if (class_ == Library.class) {
        return (T) libraries.get(uri, version, pvlist);
      } else if (class_ == StructureDefinition.class) {
        return (T) structures.get(uri, version, pvlist);
      } else if (class_ == StructureMap.class) {
        return (T) transforms.get(uri, version, pvlist);
      } else if (class_ == ValueSet.class) {
        return (T) valueSets.get(uri, version, pvlist);
      } else if (class_ == CodeSystem.class) {
        return (T) codeSystems.get(uri, version, pvlist);
      } else if (class_ == ConceptMap.class) {
        return (T) maps.get(uri, version, pvlist);
      } else if (class_ == ActorDefinition.class) {
        return (T) actors.get(uri, version, pvlist);
      } else if (class_ == Requirements.class) {
        return (T) requirements.get(uri, version, pvlist);
      } else if (class_ == PlanDefinition.class) {
        return (T) plans.get(uri, version, pvlist);
      } else if (class_ == OperationDefinition.class) {
        OperationDefinition od = operations.get(uri, version);
        return (T) od;
      } else if (class_ == Questionnaire.class) {
        return (T) questionnaires.get(uri, version, pvlist);
      } else if (class_ == SearchParameter.class) {
        SearchParameter res = searchParameters.get(uri, version, pvlist);
        return (T) res;
      }
      if (class_ == CodeSystem.class && codeSystems.has(uri)) { 
        return (T) codeSystems.get(uri, version, pvlist);
      }
      if (class_ == ValueSet.class && valueSets.has(uri)) {
        return (T) valueSets.get(uri, version, pvlist);
      } 
      
      if (class_ == Questionnaire.class) {
        return (T) questionnaires.get(uri, version, pvlist);
      } 
      if (supportedCodeSystems.contains(uri)) {
        return null;
      } 
      throw new FHIRException(formatMessage(I18nConstants.NOT_DONE_YET_CANT_FETCH_, uri));
    }
  }

  private void populatePVList(List<String> pvlist, PackageInformation sourcePackage) {
    pvlist.add(sourcePackage.getVID());
    List<String> toadd = new ArrayList<>();
    do {
      toadd.clear();
      for (String s : pvlist) {
        PackageInformation pi = packages.get(s);
        if (pi != null) {
          for (String v : pi.getDependencies()) {
            if (!pvlist.contains(v) && !toadd.contains(v)) {
              toadd.add(v);
            }
          }
        }        
      }
      pvlist.addAll(toadd);
    } while (toadd.size() > 0);
  }

  public PackageInformation getPackageForUrl(String uri) {
    if (uri == null) {
      return null;
    }
    uri = ProfileUtilities.sdNs(uri, null);

    synchronized (lock) {

      String version = null;
      if (uri.contains("|")) {
        version = uri.substring(uri.lastIndexOf("|")+1);
        uri = uri.substring(0, uri.lastIndexOf("|"));
      }
      if (uri.contains("#")) {
        uri = uri.substring(0, uri.indexOf("#"));
      } 
      if (structures.has(uri)) {
        return structures.getPackageInfo(uri, version);
      }        
      if (guides.has(uri)) {
        return guides.getPackageInfo(uri, version);
      } 
      if (capstmts.has(uri)) {
        return capstmts.getPackageInfo(uri, version);
      } 
      if (measures.has(uri)) {
        return measures.getPackageInfo(uri, version);
      } 
      if (libraries.has(uri)) {
        return libraries.getPackageInfo(uri, version);
      } 
      if (valueSets.has(uri)) {
        return valueSets.getPackageInfo(uri, version);
      } 
      if (codeSystems.has(uri)) {
        return codeSystems.getPackageInfo(uri, version);
      } 
      if (operations.has(uri)) {
        return operations.getPackageInfo(uri, version);
      } 
      if (searchParameters.has(uri)) {
        return searchParameters.getPackageInfo(uri, version);
      } 
      if (plans.has(uri)) {
        return plans.getPackageInfo(uri, version);
      } 
      if (maps.has(uri)) {
        return maps.getPackageInfo(uri, version);
      } 
      if (transforms.has(uri)) {
        return transforms.getPackageInfo(uri, version);
      } 
      if (actors.has(uri)) {
        return actors.getPackageInfo(uri, version);
      } 
      if (requirements.has(uri)) {
        return requirements.getPackageInfo(uri, version);
      } 
      if (questionnaires.has(uri)) {
        return questionnaires.getPackageInfo(uri, version);
      }         
      return null;
    }
  }
  
  @SuppressWarnings("unchecked")
  public <T extends Resource> T fetchResourceWithExceptionByVersion(String cls, String uri, String version, CanonicalResource source) throws FHIRException {
    if (uri == null) {
      return null;
    }
   
    if ("StructureDefinition".equals(cls)) {
      uri = ProfileUtilities.sdNs(uri, null);
    }
    synchronized (lock) {

      if (version == null) {
        if (uri.contains("|")) {
          version = uri.substring(uri.lastIndexOf("|")+1);
          uri = uri.substring(0, uri.lastIndexOf("|"));
        }
      } else {
        boolean b = !uri.contains("|");
        assert b;
      }
      if (uri.contains("#")) {
        uri = uri.substring(0, uri.indexOf("#"));
      } 
      if (cls == null || "Resource".equals(cls)) {
        if (structures.has(uri)) {
          return (T) structures.get(uri, version);
        } 
        if (guides.has(uri)) {
          return (T) guides.get(uri, version);
        } 
        if (capstmts.has(uri)) {
          return (T) capstmts.get(uri, version);
        } 
        if (measures.has(uri)) {
          return (T) measures.get(uri, version);
        } 
        if (libraries.has(uri)) {
          return (T) libraries.get(uri, version);
        } 
        if (valueSets.has(uri)) {
          return (T) valueSets.get(uri, version);
        } 
        if (codeSystems.has(uri)) {
          return (T) codeSystems.get(uri, version);
        } 
        if (operations.has(uri)) {
          return (T) operations.get(uri, version);
        } 
        if (searchParameters.has(uri)) {
          return (T) searchParameters.get(uri, version);
        } 
        if (plans.has(uri)) {
          return (T) plans.get(uri, version);
        } 
        if (maps.has(uri)) {
          return (T) maps.get(uri, version);
        } 
        if (transforms.has(uri)) {
          return (T) transforms.get(uri, version);
        } 
        if (actors.has(uri)) {
          return (T) actors.get(uri, version);
        } 
        if (requirements.has(uri)) {
          return (T) requirements.get(uri, version);
        } 
        if (questionnaires.has(uri)) {
          return (T) questionnaires.get(uri, version);
        } 
        for (Map<String, ResourceProxy> rt : allResourcesById.values()) {
          for (ResourceProxy r : rt.values()) {
            if (uri.equals(r.getUrl())) {
              return (T) r.getResource();
            }
          }            
        }
      } else if ("ImplementationGuide".equals(cls)) {
        return (T) guides.get(uri, version);
      } else if ("CapabilityStatement".equals(cls)) {
        return (T) capstmts.get(uri, version);
      } else if ("Measure".equals(cls)) {
        return (T) measures.get(uri, version);
      } else if ("Library".equals(cls)) {
        return (T) libraries.get(uri, version);
      } else if ("StructureDefinition".equals(cls)) {
        return (T) structures.get(uri, version);
      } else if ("StructureMap".equals(cls)) {
        return (T) transforms.get(uri, version);
      } else if ("Requirements".equals(cls)) {
        return (T) requirements.get(uri, version);
      } else if ("ActorDefinition".equals(cls)) {
        return (T) actors.get(uri, version);
      } else if ("ValueSet".equals(cls)) {
        return (T) valueSets.get(uri, version);
      } else if ("CodeSystem".equals(cls)) {
        return (T) codeSystems.get(uri, version);
      } else if ("ConceptMap".equals(cls)) {
        return (T) maps.get(uri, version);
      } else if ("PlanDefinition".equals(cls)) {
        return (T) plans.get(uri, version);
      } else if ("OperationDefinition".equals(cls)) {
        OperationDefinition od = operations.get(uri, version);
        return (T) od;
      } else if ("Questionnaire.class".equals(cls)) {
        return (T) questionnaires.get(uri, version);
      } else if ("SearchParameter.class".equals(cls)) {
        SearchParameter res = searchParameters.get(uri, version);
        return (T) res;
      }
      if ("CodeSystem".equals(cls) && codeSystems.has(uri)) {
        return (T) codeSystems.get(uri, version);
      } 
      if ("ValueSet".equals(cls) && valueSets.has(uri)) {
        return (T) valueSets.get(uri, version);
      } 
      
      if ("Questionnaire".equals(cls)) {
        return (T) questionnaires.get(uri, version);
      } 
      if (cls == null) {
        if (uri.matches(Constants.URI_REGEX) && !uri.contains("ValueSet")) {
          return null;
        } 

        // it might be a special URL.
        if (Utilities.isAbsoluteUrl(uri) || uri.startsWith("ValueSet/")) {
          Resource res = null; // findTxValueSet(uri);
          if (res != null) {
            return (T) res;
          } 
        }
        return null;      
      }    
      if (supportedCodeSystems.contains(uri)) {
        return null;
      } 
      throw new FHIRException(formatMessage(I18nConstants.NOT_DONE_YET_CANT_FETCH_, uri));
    }
  }
  
  public <T extends Resource> List<T> fetchResourcesByType(Class<T> class_, FhirPublication fhirVersion) {
    return fetchResourcesByType(class_);
  }
  
  @SuppressWarnings("unchecked")
  public <T extends Resource> List<T> fetchResourcesByType(Class<T> class_) {

    List<T> res = new ArrayList<>();

    synchronized (lock) {

      if (class_ == Resource.class || class_ == DomainResource.class || class_ == CanonicalResource.class || class_ == null) {
        res.addAll((List<T>) structures.getList());
        res.addAll((List<T>) guides.getList());
        res.addAll((List<T>) capstmts.getList());
        res.addAll((List<T>) measures.getList());
        res.addAll((List<T>) libraries.getList());
        res.addAll((List<T>) valueSets.getList());
        res.addAll((List<T>) codeSystems.getList());
        res.addAll((List<T>) operations.getList());
        res.addAll((List<T>) searchParameters.getList());
        res.addAll((List<T>) plans.getList());
        res.addAll((List<T>) maps.getList());
        res.addAll((List<T>) transforms.getList());
        res.addAll((List<T>) questionnaires.getList());
        res.addAll((List<T>) systems.getList());
        res.addAll((List<T>) actors.getList());
        res.addAll((List<T>) requirements.getList());
      } else if (class_ == ImplementationGuide.class) {
        res.addAll((List<T>) guides.getList());
      } else if (class_ == CapabilityStatement.class) {
        res.addAll((List<T>) capstmts.getList());
      } else if (class_ == Measure.class) {
        res.addAll((List<T>) measures.getList());
      } else if (class_ == Library.class) {
        res.addAll((List<T>) libraries.getList());
      } else if (class_ == StructureDefinition.class) {
        res.addAll((List<T>) structures.getList());
      } else if (class_ == StructureMap.class) {
        res.addAll((List<T>) transforms.getList());
      } else if (class_ == ValueSet.class) {
        res.addAll((List<T>) valueSets.getList());
      } else if (class_ == CodeSystem.class) {
        res.addAll((List<T>) codeSystems.getList());
      } else if (class_ == NamingSystem.class) {
        res.addAll((List<T>) systems.getList());
      } else if (class_ == ActorDefinition.class) {
        res.addAll((List<T>) actors.getList());
      } else if (class_ == Requirements.class) {
        res.addAll((List<T>) requirements.getList());
      } else if (class_ == ConceptMap.class) {
        res.addAll((List<T>) maps.getList());
      } else if (class_ == PlanDefinition.class) {
        res.addAll((List<T>) plans.getList());
      } else if (class_ == OperationDefinition.class) {
        res.addAll((List<T>) operations.getList());
      } else if (class_ == Questionnaire.class) {
        res.addAll((List<T>) questionnaires.getList());
      } else if (class_ == SearchParameter.class) {
        res.addAll((List<T>) searchParameters.getList());
      }
    }
    return res;
  }

  private Set<String> notCanonical = new HashSet<String>();

  protected IWorkerContextManager.IPackageLoadingTracker packageTracker;
  private boolean forPublication;
  private boolean cachingAllowed = true;

  public Resource fetchResourceById(String type, String uri, FhirPublication fhirVersion) {
    return fetchResourceById(type, uri);
  }
  
  @Override
  public Resource fetchResourceById(String type, String uri) {
    synchronized (lock) {
      String[] parts = uri.split("\\/");
      if (!Utilities.noString(type) && parts.length == 1) {
        if (allResourcesById.containsKey(type)) {
          return allResourcesById.get(type).get(parts[0]).getResource();
        } else {
          return null;
        }
      }
      if (parts.length >= 2) {
        if (!Utilities.noString(type)) {
          if (!type.equals(parts[parts.length-2])) { 
            throw new Error(formatMessage(I18nConstants.RESOURCE_TYPE_MISMATCH_FOR___, type, uri));
          }
        }
        return allResourcesById.get(parts[parts.length-2]).get(parts[parts.length-1]).getResource();
      } else {
        throw new Error(formatMessage(I18nConstants.UNABLE_TO_PROCESS_REQUEST_FOR_RESOURCE_FOR___, type, uri));
      }
    }
  }

  public <T extends Resource> T fetchResource(Class<T> class_, String uri, Resource sourceForReference) {
    try {
      return fetchResourceWithException(class_, uri, sourceForReference);
    } catch (FHIRException e) {
      throw new Error(e);
    }    
  }
  
  public <T extends Resource> T fetchResource(Class<T> class_, String uri, FhirPublication fhirVersion) {
    return fetchResource(class_, uri);
  }
  
  public <T extends Resource> T fetchResource(Class<T> class_, String uri) {
    try {
      return fetchResourceWithException(class_, uri, null);
    } catch (FHIRException e) {
      throw new Error(e);
    }
  }

  public <T extends Resource> T fetchResource(Class<T> class_, String uri, String version, FhirPublication fhirVersion) {
    return fetchResource(class_, uri, version);
  }
  public <T extends Resource> T fetchResource(Class<T> class_, String uri, String version) {
    try {
      return fetchResourceWithExceptionByVersion(class_, uri, version, null);
    } catch (FHIRException e) {
      throw new Error(e);
    }
  }
  
  @Override
  public <T extends Resource> boolean hasResource(Class<T> class_, String uri) {
    try {
      return fetchResourceWithException(class_, uri) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public <T extends Resource> boolean hasResource(String cls, String uri) {
    try {
      return fetchResourceWithException(cls, uri) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public <T extends Resource> boolean hasResourceVersion(Class<T> class_, String uri, String version) {
    try {
      return fetchResourceWithExceptionByVersion(class_, uri, version, null) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public <T extends Resource> boolean hasResourceVersion(String cls, String uri, String version) {
    try {
      return fetchResourceWithExceptionByVersion(cls, uri, version, null) != null;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public <T extends Resource> boolean hasResource(Class<T> class_, String uri, FhirPublication fhirVersion) {
    try {
      return fetchResourceWithException(class_, uri) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public <T extends Resource> boolean hasResource(String cls, String uri, FhirPublication fhirVersion) {
    try {
      return fetchResourceWithException(cls, uri) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public <T extends Resource> boolean hasResourceVersion(Class<T> class_, String uri, String version, FhirPublication fhirVersion) {
    try {
      return fetchResourceWithExceptionByVersion(class_, uri, version, null) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public <T extends Resource> boolean hasResourceVersion(String cls, String uri, String version, FhirPublication fhirVersion) {
    try {
      return fetchResourceWithExceptionByVersion(cls, uri, version, null) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public <T extends Resource> boolean hasResource(Class<T> class_, String uri, Resource sourceOfReference) {
    try {
      return fetchResourceWithExceptionByVersion(class_, uri, version, null) != null;
    } catch (Exception e) {
      return false;
    }
  }

  public TranslationServices translator() {
    return translator;
  }

  public void setTranslator(TranslationServices translator) {
    this.translator = translator;
  }
  
  public class NullTranslator implements TranslationServices {

    @Override
    public String translate(String context, String value, String targetLang) {
      return value;
    }

    @Override
    public String translate(String context, String value) {
      return value;
    }

    @Override
    public String toStr(float value) {
      return null;
    }

    @Override
    public String toStr(Date value) {
      return null;
    }

    @Override
    public String translateAndFormat(String contest, String lang, String value, Object... args) {
      return String.format(value, args);
    }

    @Override
    public Map<String, String> translations(String value) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Set<String> listTranslations(String category) {
      // TODO Auto-generated method stub
      return null;
    }

  }
  
  public void reportStatus(JsonObject json) {
    synchronized (lock) {
      json.addProperty("codeystem-count", codeSystems.size());
      json.addProperty("valueset-count", valueSets.size());
      json.addProperty("conceptmap-count", maps.size());
      json.addProperty("transforms-count", transforms.size());
      json.addProperty("structures-count", structures.size());
      json.addProperty("guides-count", guides.size());
      json.addProperty("statements-count", capstmts.size());
      json.addProperty("measures-count", measures.size());
      json.addProperty("libraries-count", libraries.size());
    }
  }


  public void dropResource(Resource r) throws FHIRException {
    dropResource(r.fhirType(), r.getId());   
  }

  public void dropResource(String fhirType, String id) {
    synchronized (lock) {

      Map<String, ResourceProxy> map = allResourcesById.get(fhirType);
      if (map == null) {
        map = new HashMap<String, ResourceProxy>();
        allResourcesById.put(fhirType, map);
      }
      if (map.containsKey(id)) {
        map.remove(id); // this is a challenge because we might have more than one resource with this id (different versions)
      }

      if (fhirType.equals("StructureDefinition")) {
        structures.drop(id);
        typeManager.reload();
      } else if (fhirType.equals("ImplementationGuide")) {
        guides.drop(id);
      } else if (fhirType.equals("CapabilityStatement")) {
        capstmts.drop(id);
      } else if (fhirType.equals("Measure")) {
        measures.drop(id);
      } else if (fhirType.equals("Library")) {
        libraries.drop(id);
      } else if (fhirType.equals("ValueSet")) {
        valueSets.drop(id);
      } else if (fhirType.equals("CodeSystem")) {
        codeSystems.drop(id);
      } else if (fhirType.equals("OperationDefinition")) {
        operations.drop(id);
      } else if (fhirType.equals("Questionnaire")) {
        questionnaires.drop(id);
      } else if (fhirType.equals("ConceptMap")) {
        maps.drop(id);
      } else if (fhirType.equals("StructureMap")) {
        transforms.drop(id);
      } else if (fhirType.equals("NamingSystem")) {
        systems.drop(id);
        systemUrlMap = null;
      } else if (fhirType.equals("ActorDefinition")) {
        actors.drop(id);
      } else if (fhirType.equals("Requirements")) {
        requirements.drop(id);
      }
    }
  }

  private <T extends CanonicalResource> void dropMetadataResource(Map<String, T> map, String id) {
    T res = map.get(id);
    if (res != null) {
      map.remove(id);
      if (map.containsKey(res.getUrl())) {
        map.remove(res.getUrl());
      }
      if (res.getVersion() != null) {
        if (map.containsKey(res.getUrl()+"|"+res.getVersion())) {
          map.remove(res.getUrl()+"|"+res.getVersion());
        }
      }
    }
  }

  
  public String listSupportedSystems() {
    synchronized (lock) {
      String sl = null;
      for (String s : supportedCodeSystems) {
        sl = sl == null ? s : sl + "\r\n" + s;
      }
      return sl;
    }
  }


  public int totalCount() {
    synchronized (lock) {
      return valueSets.size() +  maps.size() + structures.size() + transforms.size();
    }
  }
  
  public List<ConceptMap> listMaps() {
    List<ConceptMap> m = new ArrayList<ConceptMap>();
    synchronized (lock) {
      maps.listAll(m);
    }
    return m;
  }
  
  public List<StructureDefinition> listStructures() {
    List<StructureDefinition> m = new ArrayList<StructureDefinition>();
    synchronized (lock) {
      structures.listAll(m);    
    }
    return m;
  }

  public StructureDefinition getStructure(String code) {
    synchronized (lock) {
      return structures.get(code);
    }
  }

  private String getUri(NamingSystem ns) {
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      if (id.getType() == NamingSystemIdentifierType.URI) {
        return id.getValue();
      }
    }
    return null;
  }

  private boolean hasOid(NamingSystem ns, String oid) {
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      if (id.getType() == NamingSystemIdentifierType.OID && id.getValue().equals(oid)) {
        return true;
      }
    }
    return false;
  }

  public void cacheVS(JsonObject json, Map<String, ValidationResult> t) {
    synchronized (lock) {
      validationCache.put(json.get("url").getAsString(), t);
    }
  }

  public SearchParameter getSearchParameter(String code) {
    synchronized (lock) {
      return searchParameters.get(code);
    }
  }

  @Override
  public ILoggingService getLogger() {
    return logger;
  }


  public StructureDefinition fetchTypeDefinition(String typeName, FhirPublication fhirVersion) {
    return fetchTypeDefinition(typeName);
  }

  @Override
  public StructureDefinition fetchTypeDefinition(String typeName) {
    if (Utilities.isAbsoluteUrl(typeName)) {
      StructureDefinition res = fetchResource(StructureDefinition.class, typeName);
      if (res != null) {
        return res;
      }
    } 
    StructureDefinition p = typeManager.fetchTypeDefinition(typeName);
    if (p != null && !p.isGeneratedSnapshot()) {
      if (p.isGeneratingSnapshot()) {
        throw new FHIRException("Attempt to fetch the profile "+p.getVersionedUrl()+" while generating the snapshot for it");
      }
      try {
        if (logger.isDebugLogging()) {
          System.out.println("Generating snapshot for "+p.getVersionedUrl());
        }
        p.setGeneratingSnapshot(true);
        try {
          new ContextUtilities(this).generateSnapshot(p);
        } finally {
          p.setGeneratingSnapshot(false);      
        }
      } catch (Exception e) {
        // not sure what to do in this case?
        System.out.println("Unable to generate snapshot @5 for "+p.getVersionedUrl()+": "+e.getMessage());
        if (logger.isDebugLogging()) {
          e.printStackTrace();
        }
      }
    }
    return p;
  }
  
  @Override
  public List<StructureDefinition> fetchTypeDefinitions(String typeName) {
    return typeManager.getDefinitions(typeName);
  }

  @Override
  public List<StructureDefinition> fetchTypeDefinitions(String typeName, FhirPublication fhirVersion) {
    return typeManager.getDefinitions(typeName);
  }


  public boolean isPrimitiveType(String type) {
    return typeManager.isPrimitive(type);
  }

  public boolean isDataType(String type) {
    return typeManager.isDataType(type);
  }
  
  public boolean isTlogging() {
    return tlogging;
  }

  public void setTlogging(boolean tlogging) {
    this.tlogging = tlogging;
  }

  public UcumService getUcumService() {
    return ucumService;
  }

  public void setUcumService(UcumService ucumService) {
    this.ucumService = ucumService;
  }

  public String getLinkForUrl(String corePath, String url) {
    if (url == null) {
      return null;
    }
    
    if (codeSystems.has(url)) {
      return codeSystems.get(url).getWebPath();
    }

    if (valueSets.has(url)) {
      return valueSets.get(url).getWebPath();
    }

    if (maps.has(url)) {
      return maps.get(url).getWebPath();
    }
    
    if (transforms.has(url)) {
      return transforms.get(url).getWebPath();
    }
    
    if (actors.has(url)) {
      return actors.get(url).getWebPath();
    }
    
    if (requirements.has(url)) {
      return requirements.get(url).getWebPath();
    }
    
    if (structures.has(url)) {
      return structures.get(url).getWebPath();
    }
    
    if (guides.has(url)) {
      return guides.get(url).getWebPath();
    }
    
    if (capstmts.has(url)) {
      return capstmts.get(url).getWebPath();
    }
    
    if (measures.has(url)) {
      return measures.get(url).getWebPath();
    }

    if (libraries.has(url)) {
      return libraries.get(url).getWebPath();
    }

    if (searchParameters.has(url)) {
      return searchParameters.get(url).getWebPath();
    }
        
    if (questionnaires.has(url)) {
      return questionnaires.get(url).getWebPath();
    }

    if (operations.has(url)) {
      return operations.get(url).getWebPath();
    }
    
    if (plans.has(url)) {
      return plans.get(url).getWebPath();
    }

    if (url.equals("http://loinc.org")) {
      return corePath+"loinc.html";
    }
    if (url.equals("http://unitsofmeasure.org")) {
      return corePath+"ucum.html";
    } 
    if (url.equals("http://snomed.info/sct")) {
      return corePath+"snomed.html";
    } 
    return null;
  }

  public List<ImplementationGuide> allImplementationGuides() {
    List<ImplementationGuide> res = new ArrayList<>();
    guides.listAll(res);
    return res;
  }

  @Override
  public Set<String> getBinaryKeysAsSet() { return binaries.keySet(); }

  @Override
  public boolean hasBinaryKey(String binaryKey) {
    return binaries.containsKey(binaryKey);
  }

  @Override
  public byte[] getBinaryForKey(String binaryKey) {
    return binaries.get(binaryKey);
  }

  public void finishLoading(boolean genSnapshots) {
    if (!hasResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Base")) {
      cacheResource(ProfileUtilities.makeBaseDefinition(version));
    }
    if(genSnapshots) {
      for (StructureDefinition sd : listStructures()) {
        try {
          if (sd.getSnapshot().isEmpty()) { 
            new ContextUtilities(this).generateSnapshot(sd);
            //          new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "snapshot", tail(sd.getUrl())+".xml")), sd);
          }
        } catch (Exception e) {
          System.out.println("Unable to generate snapshot @1 for "+tail(sd.getUrl()) +" from "+tail(sd.getBaseDefinition())+" because "+e.getMessage());
          if (logger.isDebugLogging()) {
            e.printStackTrace();          
          }
        }
      }  
    }
    codeSystems.setVersion(version);
    valueSets.setVersion(version);
    maps.setVersion(version);
    transforms.setVersion(version);
    structures.setVersion(version);
    typeManager.reload();
    measures.setVersion(version);
    libraries.setVersion(version);
    guides.setVersion(version);
    capstmts.setVersion(version);
    searchParameters.setVersion(version);
    questionnaires.setVersion(version);
    operations.setVersion(version);
    plans.setVersion(version);
    systems.setVersion(version);
    actors.setVersion(version);
    requirements.setVersion(version);
  }

  protected String tail(String url) {
    if (Utilities.noString(url)) {
      return "noname";
    }
    if (url.contains("/")) {
      return url.substring(url.lastIndexOf("/")+1);
    }
    return url;
  }
  
  public int getClientRetryCount() {
    return tcc.getClient() == null ? 0 : tcc.getClient().getRetryCount();
  }
  
  public IWorkerContext setClientRetryCount(int value) {
    if (tcc.getClient() != null) {
      tcc.getClient().setRetryCount(value);
    }
    return this;
  }

  public ITerminologyClient getTxClient() {
    return tcc.getClient();
  }

  public String getCacheId() {
    return tcc.getCacheId();
  }

  public void setCacheId(String cacheId) {
    tcc.setCacheId(cacheId);
  }

  public TerminologyCapabilities getTxCaps() {
    return tcc.getTxcaps();
  }

  public void setTxCaps(TerminologyCapabilities txCaps) {
    this.tcc.setTxcaps(txCaps);
    if (txCaps != null) {
      for (TerminologyCapabilitiesExpansionParameterComponent t : tcc.getTxcaps().getExpansion().getParameter()) {
        if ("cache-id".equals(t.getName())) {
          tcc.setTxCaching(true);
        }
      }
      for (TerminologyCapabilitiesCodeSystemComponent tccs : tcc.getTxcaps().getCodeSystem()) {
        supportedCodeSystems.add(tccs.getUri());
      }
    }
  }

  public TimeTracker clock() {
    return clock;
  }
 

  public int countAllCaches() {
    return codeSystems.size() + valueSets.size() + maps.size() + transforms.size() + structures.size() + measures.size() + libraries.size() + 
        guides.size() + capstmts.size() + searchParameters.size() + questionnaires.size() + operations.size() + plans.size() + 
        systems.size()+ actors.size()+ requirements.size();
  }

  public Set<String> getCodeSystemsUsed() {
    return codeSystemsUsed ;
  }
 
  public IWorkerContextManager.ICanonicalResourceLocator getLocator() {
    return locator;
  }

  public void setLocator(IWorkerContextManager.ICanonicalResourceLocator locator) {
    this.locator = locator;
  }

  public String getUserAgent() {
    return userAgent;
  }

  protected void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
    if (tcc.getClient() != null)
      tcc.getClient().setUserAgent(userAgent);
  }


  public IWorkerContextManager.IPackageLoadingTracker getPackageTracker() {
    return packageTracker;
  }
  
  public IWorkerContext setPackageTracker(IWorkerContextManager.IPackageLoadingTracker packageTracker) {
    this.packageTracker = packageTracker;
    return this;
  }
  

  @Override
  public PEBuilder getProfiledElementBuilder(PEElementPropertiesPolicy elementProps, boolean fixedProps) {
    // TODO Auto-generated method stub
    return new PEBuilder(this, elementProps, fixedProps);
  }
  
  public boolean isForPublication() {
    return forPublication;
  }
  
  public void setForPublication(boolean value) {
    forPublication = value;
  }

  public boolean isCachingAllowed() {
    return cachingAllowed;
  }

  public void setCachingAllowed(boolean cachingAllowed) {
    this.cachingAllowed = cachingAllowed;
  }

  @Override
  public Set<String> urlsForOid(boolean codeSystem, String oid) {
    Set<String> set = urlsForOid(codeSystem, oid, true);
    if (set.size() > 1) {
      set =  urlsForOid(codeSystem, oid, false);
    }
    return set;
  }
  
  public Set<String> urlsForOid(boolean codeSystem, String oid, boolean retired) {
    if (oid == null) {
      return null;
    }
    Set<String> urls = new HashSet<>();
    if (oidCacheManual.containsKey(oid)) {
      urls.addAll(oidCacheManual.get(oid));
    }
    for (OIDSource os : oidSources) {
      if (os.db == null) {
        os.db = connectToOidSource(os.folder);
      }
      if (os.db != null) {
        try {
          PreparedStatement psql = os.db.prepareStatement("Select URL, Status from OIDMap where OID = ?");
          psql.setString(1, oid);
          ResultSet rs = psql.executeQuery();
          while (rs.next()) {
            if (retired || !"retired".equals(rs.getString(2))) {
              urls.add(rs.getString(1));
            }
          }
        } catch (Exception e) {
          // nothing, there would alreagy have been an error
//          e.printStackTrace();
        }
      }
    }      

    switch (oid) {
    case "2.16.840.1.113883.6.1" :
      urls.add("http://loinc.org");
      break;
    case "2.16.840.1.113883.6.8" :
      urls.add("http://unitsofmeasure.org");
      break;
    case "2.16.840.1.113883.6.96" :
      urls.add("http://snomed.info/sct");
      break;
    default:
    }
    return urls;
  }

  private Connection connectToOidSource(String folder) {
    try {
      File ff = new File(folder);
      File of = new File(Utilities.path(ff.getAbsolutePath(), ".oid-map.db"));
      if (!of.exists()) {
        OidIndexBuilder oidBuilder = new OidIndexBuilder(ff, of);
        oidBuilder.build();
      }
      return DriverManager.getConnection("jdbc:sqlite:"+of.getAbsolutePath());
    } catch (Exception e) {
      return null;
    }
  }


  public void unload() {

    codeSystems.unload();
    valueSets.unload();
    maps.unload();
    transforms.unload();
    structures.unload();
    typeManager.unload();
    measures.unload();
    libraries.unload();
    guides.unload();
    capstmts.unload();
    searchParameters.unload();
    questionnaires.unload();
    operations.unload();
    plans.unload();
    actors.unload();
    requirements.unload();
    systems.unload();

    binaries.clear();
    validationCache.clear();
    txCache.clear();
}
  
}
