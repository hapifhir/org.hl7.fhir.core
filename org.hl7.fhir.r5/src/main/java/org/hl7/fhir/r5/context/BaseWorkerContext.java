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


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.fhir.ucum.UcumService;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext.PackageVersion;
import org.hl7.fhir.r5.context.IWorkerContext.ILoggingService.LogCategory;
import org.hl7.fhir.r5.context.TerminologyCache.CacheToken;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Measure;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PlanDefinition;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.terminologies.ValueSetCheckerSimple;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.ValueSetExpanderSimple;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.client.ToolingClientLogger;
import org.hl7.fhir.utilities.i18n.I18nBase;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.OIDUtils;
import org.hl7.fhir.utilities.TranslationServices;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.validation.ValidationOptions.ValueSetMode;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;

import com.google.gson.JsonObject;

public abstract class BaseWorkerContext extends I18nBase implements IWorkerContext{

  public class MetadataResourceVersionComparator<T extends CanonicalResource> implements Comparator<T> {

    private List<T> list;

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
  protected String version;
  
  private Map<String, Map<String, Resource>> allResourcesById = new HashMap<String, Map<String, Resource>>();
  // all maps are to the full URI
  private CanonicalResourceManager<CodeSystem> codeSystems = new CanonicalResourceManager<CodeSystem>(false);
  private Set<String> supportedCodeSystems = new HashSet<String>();
  private Set<String> unsupportedCodeSystems = new HashSet<String>(); // know that the terminology server doesn't support them
  private CanonicalResourceManager<ValueSet> valueSets = new CanonicalResourceManager<ValueSet>(false);
  private CanonicalResourceManager<ConceptMap> maps = new CanonicalResourceManager<ConceptMap>(false);
  protected CanonicalResourceManager<StructureMap> transforms = new CanonicalResourceManager<StructureMap>(false);
  private CanonicalResourceManager<StructureDefinition> structures = new CanonicalResourceManager<StructureDefinition>(false);
  private CanonicalResourceManager<Measure> measures = new CanonicalResourceManager<Measure>(false);
  private CanonicalResourceManager<Library> libraries = new CanonicalResourceManager<Library>(false);
  private CanonicalResourceManager<ImplementationGuide> guides = new CanonicalResourceManager<ImplementationGuide>(false);
  private CanonicalResourceManager<CapabilityStatement> capstmts = new CanonicalResourceManager<CapabilityStatement>(false);
  private CanonicalResourceManager<SearchParameter> searchParameters = new CanonicalResourceManager<SearchParameter>(false);
  private CanonicalResourceManager<Questionnaire> questionnaires = new CanonicalResourceManager<Questionnaire>(false);
  private CanonicalResourceManager<OperationDefinition> operations = new CanonicalResourceManager<OperationDefinition>(false);
  private CanonicalResourceManager<PlanDefinition> plans = new CanonicalResourceManager<PlanDefinition>(false);
  private List<NamingSystem> systems = new ArrayList<NamingSystem>();
  private UcumService ucumService;
  protected Map<String, byte[]> binaries = new HashMap<String, byte[]>();

  protected Map<String, Map<String, ValidationResult>> validationCache = new HashMap<String, Map<String,ValidationResult>>();
  protected String tsServer;
  protected String name;
  private boolean allowLoadingDuplicates;

  protected TerminologyClient txClient;
  protected ToolingClientLogger txLog;
  private TerminologyCapabilities txcaps;
  private boolean canRunWithoutTerminology;
  protected boolean noTerminologyServer;
  private int expandCodesLimit = 1000;
  protected ILoggingService logger;
  protected Parameters expParameters;
  private TranslationServices translator = new NullTranslator();
  protected TerminologyCache txCache;

  private boolean tlogging = true;
  
  public BaseWorkerContext() throws FileNotFoundException, IOException, FHIRException {
    txCache = new TerminologyCache(lock, null);
    setValidationMessageLanguage(getLocale());
  }

  public BaseWorkerContext(Locale locale) throws FileNotFoundException, IOException, FHIRException {
    txCache = new TerminologyCache(lock, null);
    setValidationMessageLanguage(locale);
  }

  public BaseWorkerContext(CanonicalResourceManager<CodeSystem> codeSystems, CanonicalResourceManager<ValueSet> valueSets, CanonicalResourceManager<ConceptMap> maps, CanonicalResourceManager<StructureDefinition> profiles,
      CanonicalResourceManager<ImplementationGuide> guides) throws FileNotFoundException, IOException, FHIRException {
    this();
    this.codeSystems = codeSystems;
    this.valueSets = valueSets;
    this.maps = maps;
    this.structures = profiles;
    this.guides = guides;
  }

  protected void copy(BaseWorkerContext other) {
    synchronized (other.lock) { // tricky, because you need to lock this as well, but it's really not in use yet 
      allResourcesById.putAll(other.allResourcesById);
      translator = other.translator;
      codeSystems.copy(other.codeSystems);
      txcaps = other.txcaps;
      valueSets.copy(other.valueSets);
      maps.copy(other.maps);
      transforms.copy(other.transforms);
      structures.copy(other.structures);
      searchParameters.copy(other.searchParameters);
      plans.copy(other.plans);
      questionnaires.copy(other.questionnaires);
      operations.copy(other.operations);
      systems.addAll(other.systems);
      guides.copy(other.guides);
      capstmts.copy(other.capstmts);
      measures.copy(other.measures);
      libraries.copy(libraries);

      allowLoadingDuplicates = other.allowLoadingDuplicates;
      tsServer = other.tsServer;
      name = other.name;
      txClient = other.txClient;
      txLog = other.txLog;
      txcaps = other.txcaps;
      canRunWithoutTerminology = other.canRunWithoutTerminology;
      noTerminologyServer = other.noTerminologyServer;
      if (other.txCache != null)
        txCache = other.txCache.copy();
      expandCodesLimit = other.expandCodesLimit;
      logger = other.logger;
      expParameters = other.expParameters;
    }
  }
  
  public void cachePackage(PackageVersion packageDetails, List<PackageVersion> dependencies) {
    // nothing yet
  }

  public void cacheResource(Resource r) throws FHIRException {
    cacheResourceFromPackage(r, null);  
  }
  
  public void cacheResourceFromPackage(Resource r, PackageVersion packageInfo) throws FHIRException {
    synchronized (lock) {
      Map<String, Resource> map = allResourcesById.get(r.fhirType());
      if (map == null) {
        map = new HashMap<String, Resource>();
        allResourcesById.put(r.fhirType(), map);
      }
      map.put(r.getId(), r);

      if (r instanceof CanonicalResource) {
        CanonicalResource m = (CanonicalResource) r;
        String url = m.getUrl();
        if (!allowLoadingDuplicates && hasResource(r.getClass(), url)) {
          // spcial workaround for known problems with existing packages
          if (Utilities.existsInList(url, "http://hl7.org/fhir/SearchParameter/example")) {
            return;
          }
          throw new DefinitionException(formatMessage(I18nConstants.DUPLICATE_RESOURCE_, url));
        }
        if (r instanceof StructureDefinition) {
          StructureDefinition sd = (StructureDefinition) m;
          if ("1.4.0".equals(version)) {
            fixOldSD(sd);
          }
          structures.see(sd, packageInfo);
        } else if (r instanceof ValueSet)
          valueSets.see((ValueSet) m, packageInfo);
        else if (r instanceof CodeSystem) {
          CodeSystemUtilities.crossLinkCodeSystem((CodeSystem) r);
          codeSystems.see((CodeSystem) m, packageInfo);
        } else if (r instanceof ImplementationGuide)
          guides.see((ImplementationGuide) m, packageInfo);
        else if (r instanceof CapabilityStatement)
          capstmts.see((CapabilityStatement) m, packageInfo);
        else if (r instanceof Measure)
          measures.see((Measure) m, packageInfo);
        else if (r instanceof Library)
          libraries.see((Library) m, packageInfo);        
        else if (r instanceof SearchParameter)
          searchParameters.see((SearchParameter) m, packageInfo);
        else if (r instanceof PlanDefinition)
          plans.see((PlanDefinition) m, packageInfo);
        else if (r instanceof OperationDefinition)
          operations.see((OperationDefinition) m, packageInfo);
        else if (r instanceof Questionnaire)
          questionnaires.see((Questionnaire) m, packageInfo);
        else if (r instanceof ConceptMap)
          maps.see((ConceptMap) m, packageInfo);
        else if (r instanceof StructureMap)
          transforms.see((StructureMap) m, packageInfo);
        else if (r instanceof NamingSystem)
          systems.add((NamingSystem) r);
      }
    }
  }

  public void fixOldSD(StructureDefinition sd) {
    if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT && sd.getType().equals("Extension") && sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/")) {
      sd.setSnapshot(null);
    }
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      if (ed.getPath().equals("Extension.url") || ed.getPath().endsWith(".extension.url") ) {
        ed.setMin(1);
        ed.getBase().setMin(1);
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
    if (StringUtils.isNumeric(newVersion) && StringUtils.isNumeric(oldVersion))
      return Double.parseDouble(newVersion) > Double.parseDouble(oldVersion);
    else if (hasDelimiter(newVersion, oldVersion, "."))
      return laterDelimitedVersion(newVersion, oldVersion, "\\.");
    else if (hasDelimiter(newVersion, oldVersion, "-"))
      return laterDelimitedVersion(newVersion, oldVersion, "\\-");
    else if (hasDelimiter(newVersion, oldVersion, "_"))
      return laterDelimitedVersion(newVersion, oldVersion, "\\_");
    else if (hasDelimiter(newVersion, oldVersion, ":"))
      return laterDelimitedVersion(newVersion, oldVersion, "\\:");
    else if (hasDelimiter(newVersion, oldVersion, " "))
      return laterDelimitedVersion(newVersion, oldVersion, "\\ ");
    else {
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
      if (!newParts[i].equals(oldParts[i]))
        return laterVersion(newParts[i], oldParts[i]);
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
      if (!map.containsKey(r.getUrl()))
        map.put(r.getUrl(), r);
      else {
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
  public CodeSystem fetchCodeSystem(String system) {
    synchronized (lock) {
      return codeSystems.get(system);
    }
  } 

  @Override
  public boolean supportsSystem(String system) throws TerminologyServiceException {
    synchronized (lock) {
      if (codeSystems.has(system) && codeSystems.get(system).getContent() != CodeSystemContentMode.NOTPRESENT)
        return true;
      else if (supportedCodeSystems.contains(system))
        return true;
      else if (system.startsWith("http://example.org") || system.startsWith("http://acme.com") || system.startsWith("http://hl7.org/fhir/valueset-") || system.startsWith("urn:oid:"))
        return false;
      else {
        if (noTerminologyServer)
          return false;
        if (txcaps == null) {
          try {
            log("Terminology server: Check for supported code systems for "+system);
            txcaps = txClient.getTerminologyCapabilities();
          } catch (Exception e) {
            if (canRunWithoutTerminology) {
              noTerminologyServer = true;
              log("==============!! Running without terminology server !! ==============");
              if (txClient!=null) {
                log("txServer = "+txClient.getAddress());
                log("Error = "+e.getMessage()+"");
              }
              log("=====================================================================");
              return false;
            } else {
              e.printStackTrace();
              throw new TerminologyServiceException(e);
            }
          }
          if (txcaps != null) {
            for (TerminologyCapabilitiesCodeSystemComponent tccs : txcaps.getCodeSystem()) {
              supportedCodeSystems.add(tccs.getUri());
            }
          }
          if (supportedCodeSystems.contains(system))
            return true;
        }
      }
      return false;
    }
  }

  private void log(String message) {
    if (logger != null)
      logger.logMessage(message);
    else
      System.out.println(message);
  }


  protected void tlog(String msg) {
    if (tlogging )
      if (logger != null)
        logger.logDebugMessage(LogCategory.TX, msg);
      else 
        System.out.println("-tx: "+msg);
  }

  // --- expansion support ------------------------------------------------------------------------------------------------------------

  public int getExpandCodesLimit() {
    return expandCodesLimit;
  }

  public void setExpandCodesLimit(int expandCodesLimit) {
    this.expandCodesLimit = expandCodesLimit;
  }

  @Override
  public ValueSetExpansionOutcome expandVS(ElementDefinitionBindingComponent binding, boolean cacheOk, boolean heirarchical) throws FHIRException {
    ValueSet vs = null;
    vs = fetchResource(ValueSet.class, binding.getValueSet());
    if (vs == null)
      throw new FHIRException(formatMessage(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_, binding.getValueSet()));
    return expandVS(vs, cacheOk, heirarchical);
  }
  
  @Override
  public ValueSetExpansionOutcome expandVS(ConceptSetComponent inc, boolean hierarchical) throws TerminologyServiceException {
    ValueSet vs = new ValueSet();
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSetComposeComponent());
    vs.getCompose().getInclude().add(inc);
    CacheToken cacheToken = txCache.generateExpandToken(vs, hierarchical);
    ValueSetExpansionOutcome res;
    res = txCache.getExpansion(cacheToken);
    if (res != null)
      return res;
    Parameters p = expParameters.copy(); 
    p.setParameter("includeDefinition", false);
    p.setParameter("excludeNested", !hierarchical);
    
    if (noTerminologyServer)
      return new ValueSetExpansionOutcome(formatMessage(I18nConstants.ERROR_EXPANDING_VALUESET_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE);
    Map<String, String> params = new HashMap<String, String>();
    params.put("_limit", Integer.toString(expandCodesLimit ));
    params.put("_incomplete", "true");
    tlog("$expand on "+txCache.summary(vs));
    try {
      ValueSet result = txClient.expandValueset(vs, p, params);
      res = new ValueSetExpansionOutcome(result).setTxLink(txLog.getLastId());  
    } catch (Exception e) {
      res = new ValueSetExpansionOutcome(e.getMessage() == null ? e.getClass().getName() : e.getMessage(), TerminologyServiceErrorClass.UNKNOWN);
      if (txLog != null)
        res.setTxLink(txLog.getLastId());
    }
    txCache.cacheExpansion(cacheToken, res, TerminologyCache.PERMANENT);
    return res;
  }

  @Override
  public ValueSetExpansionOutcome expandVS(ValueSet vs, boolean cacheOk, boolean heirarchical) {
    if (expParameters == null)
      throw new Error(formatMessage(I18nConstants.NO_EXPANSION_PARAMETERS_PROVIDED));
    Parameters p = expParameters.copy(); 
    return expandVS(vs, cacheOk, heirarchical, p);
  }
  
  public ValueSetExpansionOutcome expandVS(ValueSet vs, boolean cacheOk, boolean heirarchical, Parameters p)  {
    if (p == null)
      throw new Error(formatMessage(I18nConstants.NO_PARAMETERS_PROVIDED_TO_EXPANDVS));
    if (vs.hasExpansion()) {
      return new ValueSetExpansionOutcome(vs.copy());
    }
    if (!vs.hasUrl())
      throw new Error(formatMessage(I18nConstants.NO_VALUE_SET));
    
      CacheToken cacheToken = txCache.generateExpandToken(vs, heirarchical);
      ValueSetExpansionOutcome res;
      if (cacheOk) {
        res = txCache.getExpansion(cacheToken);
        if (res != null)
          return res;
      }
      p.setParameter("includeDefinition", false);
      p.setParameter("excludeNested", !heirarchical);
      
      // ok, first we try to expand locally
      try {
        ValueSetExpanderSimple vse = new ValueSetExpanderSimple(this);
        res = vse.doExpand(vs, p);
        if (!res.getValueset().hasUrl())
          throw new Error(formatMessage(I18nConstants.NO_URL_IN_EXPAND_VALUE_SET));
        txCache.cacheExpansion(cacheToken, res, TerminologyCache.TRANSIENT);
        return res;
      } catch (Exception e) {
      }
      
      // if that failed, we try to expand on the server
      if (noTerminologyServer)
      return new ValueSetExpansionOutcome(formatMessage(I18nConstants.ERROR_EXPANDING_VALUESET_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE);
      Map<String, String> params = new HashMap<String, String>();
      params.put("_limit", Integer.toString(expandCodesLimit ));
      params.put("_incomplete", "true");
      tlog("$expand on "+txCache.summary(vs));
      try {
        ValueSet result = txClient.expandValueset(vs, p, params);
        if (!result.hasUrl())
          result.setUrl(vs.getUrl());
        if (!result.hasUrl())
          throw new Error(formatMessage(I18nConstants.NO_URL_IN_EXPAND_VALUE_SET_2));
        res = new ValueSetExpansionOutcome(result).setTxLink(txLog.getLastId());  
      } catch (Exception e) {
        res = new ValueSetExpansionOutcome(e.getMessage() == null ? e.getClass().getName() : e.getMessage(), TerminologyServiceErrorClass.UNKNOWN).setTxLink(txLog == null ? null : txLog.getLastId());
      }
      txCache.cacheExpansion(cacheToken, res, TerminologyCache.PERMANENT);
      return res;
  }


  private boolean hasTooCostlyExpansion(ValueSet valueset) {
    return valueset != null && valueset.hasExpansion() && ToolingExtensions.hasExtension(valueset.getExpansion(), ToolingExtensions.EXT_EXP_TOOCOSTLY);
  }
  // --- validate code -------------------------------------------------------------------------------
  
  @Override
  public ValidationResult validateCode(ValidationOptions options, String system, String code, String display) {
    assert options != null;
    Coding c = new Coding(system, code, display);
    return validateCode(options, c, null);
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, String system, String code, String display, ValueSet vs) {
    assert options != null;
    Coding c = new Coding(system, code, display);
    return validateCode(options, c, vs);
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, String code, ValueSet vs) {
    assert options != null;
    Coding c = new Coding(null, code, null);
    return validateCode(options.guessSystem(), c, vs);
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, Coding code, ValueSet vs) {
    assert options != null;
    
    CacheToken cacheToken = txCache != null ? txCache.generateValidationToken(options, code, vs) : null;
    ValidationResult res = null;
    if (txCache != null) 
      res = txCache.getValidation(cacheToken);
    if (res != null)
      return res;

    if (options.isUseClient()) {
      // ok, first we try to validate locally
      try {
        ValueSetCheckerSimple vsc = new ValueSetCheckerSimple(options, vs, this); 
        res = vsc.validateCode(code);
        if (txCache != null)
          txCache.cacheValidation(cacheToken, res, TerminologyCache.TRANSIENT);
        return res;
      } catch (Exception e) {
      }
    }
    
    if (!options.isUseServer()) {
      return new ValidationResult(IssueSeverity.WARNING,formatMessage(I18nConstants.UNABLE_TO_VALIDATE_CODE_WITHOUT_USING_SERVER), TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS);
    }
    if (unsupportedCodeSystems.contains(code.getSystem())) {
      return new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_NOTKNOWN, code.getSystem()), TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);      
    }
    
    // if that failed, we try to validate on the server
    if (noTerminologyServer) {
      return new ValidationResult(IssueSeverity.ERROR,formatMessage(I18nConstants.ERROR_VALIDATING_CODE_RUNNING_WITHOUT_TERMINOLOGY_SERVICES), TerminologyServiceErrorClass.NOSERVICE);
    }
    String csumm =  txCache != null ? txCache.summary(code) : null;
    if (txCache != null) {
      tlog("$validate "+csumm+" for "+ txCache.summary(vs));
    } else {
      tlog("$validate "+csumm+" before cache exists");
    }
    try {
      Parameters pIn = new Parameters();
      pIn.addParameter().setName("coding").setValue(code);
      if (options.isGuessSystem())
        pIn.addParameter().setName("implySystem").setValue(new BooleanType(true));
      setTerminologyOptions(options, pIn);
      res = validateOnServer(vs, pIn);
    } catch (Exception e) {
      res = new ValidationResult(IssueSeverity.ERROR, e.getMessage() == null ? e.getClass().getName() : e.getMessage()).setTxLink(txLog == null ? null : txLog.getLastId());
    }
    if (res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
      unsupportedCodeSystems.add(code.getSystem());
    } else if (txCache != null) // we never cache unsuppoted code systems - we always keep trying (but only once per run)
      txCache.cacheValidation(cacheToken, res, TerminologyCache.PERMANENT);
    return res;
  }

  private void setTerminologyOptions(ValidationOptions options, Parameters pIn) {
    if (!Utilities.noString(options.getLanguage())) {
      pIn.addParameter("displayLanguage", options.getLanguage());
    }
    if (options.getValueSetMode() != ValueSetMode.ALL_CHECKS) {
      pIn.addParameter("valueSetMode", options.getValueSetMode().toString());
    }
  }

  @Override
  public ValidationResult validateCode(ValidationOptions options, CodeableConcept code, ValueSet vs) {
    CacheToken cacheToken = txCache.generateValidationToken(options, code, vs);
    ValidationResult res = txCache.getValidation(cacheToken);
    if (res != null)
      return res;

    if (options.isUseClient()) {
      // ok, first we try to validate locally
      try {
        ValueSetCheckerSimple vsc = new ValueSetCheckerSimple(options, vs, this); 
        res = vsc.validateCode(code);
        txCache.cacheValidation(cacheToken, res, TerminologyCache.TRANSIENT);
        return res;
      } catch (Exception e) {
      }
    }

    if (!options.isUseServer()) {
      return new ValidationResult(IssueSeverity.WARNING, "Unable to validate code without using server", TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS);      
    }
    
    // if that failed, we try to validate on the server
    if (noTerminologyServer)
      return new ValidationResult(IssueSeverity.ERROR, "Error validating code: running without terminology services", TerminologyServiceErrorClass.NOSERVICE);
    tlog("$validate "+txCache.summary(code)+" for "+ txCache.summary(vs));
    try {
      Parameters pIn = new Parameters();
      pIn.addParameter().setName("codeableConcept").setValue(code);
      setTerminologyOptions(options, pIn);
      res = validateOnServer(vs, pIn);
    } catch (Exception e) {
      res = new ValidationResult(IssueSeverity.ERROR, e.getMessage() == null ? e.getClass().getName() : e.getMessage()).setTxLink(txLog.getLastId());
    }
    txCache.cacheValidation(cacheToken, res, TerminologyCache.PERMANENT);
    return res;
  }

  private ValidationResult validateOnServer(ValueSet vs, Parameters pin) throws FHIRException {
    if (vs != null)
      pin.addParameter().setName("valueSet").setResource(vs);
    for (ParametersParameterComponent pp : pin.getParameter())
      if (pp.getName().equals("profile"))
        throw new Error(formatMessage(I18nConstants.CAN_ONLY_SPECIFY_PROFILE_IN_THE_CONTEXT));
    if (expParameters == null)
      throw new Error(formatMessage(I18nConstants.NO_EXPANSIONPROFILE_PROVIDED));
    pin.addParameter().setName("profile").setResource(expParameters);
    if (txLog != null) {
      txLog.clearLastId();
    }
    if (txClient == null) {
      throw new FHIRException(formatMessage(I18nConstants.ATTEMPT_TO_USE_TERMINOLOGY_SERVER_WHEN_NO_TERMINOLOGY_SERVER_IS_AVAILABLE));
    }
    Parameters pOut;
    if (vs == null)
      pOut = txClient.validateCS(pin);
    else
      pOut = txClient.validateVS(pin);
    boolean ok = false;
    String message = "No Message returned";
    String display = null;
    TerminologyServiceErrorClass err = TerminologyServiceErrorClass.UNKNOWN;
    for (ParametersParameterComponent p : pOut.getParameter()) {
      if (p.getName().equals("result"))
        ok = ((BooleanType) p.getValue()).getValue().booleanValue();
      else if (p.getName().equals("message"))
        message = ((StringType) p.getValue()).getValue();
      else if (p.getName().equals("display"))
        display = ((StringType) p.getValue()).getValue();
      else if (p.getName().equals("cause")) {
        try {
          IssueType it = IssueType.fromCode(((StringType) p.getValue()).getValue());
          if (it == IssueType.UNKNOWN)
            err = TerminologyServiceErrorClass.UNKNOWN;
          else if (it == IssueType.NOTFOUND)
            err = TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED;
          else if (it == IssueType.NOTSUPPORTED)
            err = TerminologyServiceErrorClass.VALUESET_UNSUPPORTED;
        } catch (FHIRException e) {
        }
      }
    }
    if (!ok)
      return new ValidationResult(IssueSeverity.ERROR, message, err).setTxLink(txLog.getLastId()).setTxLink(txLog.getLastId());
    else if (message != null && !message.equals("No Message returned")) 
      return new ValidationResult(IssueSeverity.WARNING, message, new ConceptDefinitionComponent().setDisplay(display)).setTxLink(txLog.getLastId()).setTxLink(txLog.getLastId());
    else if (display != null)
      return new ValidationResult(new ConceptDefinitionComponent().setDisplay(display)).setTxLink(txLog.getLastId()).setTxLink(txLog.getLastId());
    else
      return new ValidationResult(new ConceptDefinitionComponent()).setTxLink(txLog.getLastId()).setTxLink(txLog.getLastId());
  }

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  
  public void initTS(String cachePath) throws Exception {
    txCache = new TerminologyCache(lock, cachePath);
  }

  @Override
  public List<ConceptMap> findMapsForSource(String url) throws FHIRException {
    synchronized (lock) {
      List<ConceptMap> res = new ArrayList<ConceptMap>();
      for (ConceptMap map : maps.getList())
        if (((Reference) map.getSource()).getReference().equals(url)) 
          res.add(map);
      return res;
    }
  }

  public boolean isCanRunWithoutTerminology() {
    return canRunWithoutTerminology;
  }

  public void setCanRunWithoutTerminology(boolean canRunWithoutTerminology) {
    this.canRunWithoutTerminology = canRunWithoutTerminology;
  }

  public void setLogger(ILoggingService logger) {
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
    return noTerminologyServer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
  
  @SuppressWarnings("unchecked")
  public <T extends Resource> T fetchResourceWithException(Class<T> class_, String uri, CanonicalResource source) throws FHIRException {
    if (uri == null) {
      return null;
    }
   
    if (class_ == StructureDefinition.class)
      uri = ProfileUtilities.sdNs(uri, getOverrideVersionNs());
    synchronized (lock) {

      String version = null;
      if (uri.contains("|")) {
        version = uri.substring(uri.lastIndexOf("|")+1);
        uri = uri.substring(0, uri.lastIndexOf("|"));
      }
      if (uri.contains("#"))
        uri = uri.substring(0, uri.indexOf("#"));
      if (class_ == Resource.class || class_ == null) {
        if (structures.has(uri))
          return (T) structures.get(uri, version);
        if (guides.has(uri))
          return (T) guides.get(uri, version);
        if (capstmts.has(uri))
          return (T) capstmts.get(uri, version);
        if (measures.has(uri))
          return (T) measures.get(uri, version);
        if (libraries.has(uri))
          return (T) libraries.get(uri, version);        
        if (valueSets.has(uri))
          return (T) valueSets.get(uri, version);
        if (codeSystems.has(uri))
          return (T) codeSystems.get(uri, version);
        if (operations.has(uri))
          return (T) operations.get(uri, version);
        if (searchParameters.has(uri))
          return (T) searchParameters.get(uri, version);
        if (plans.has(uri))
          return (T) plans.get(uri, version);
        if (maps.has(uri))
          return (T) maps.get(uri, version);
        if (transforms.has(uri))
          return (T) transforms.get(uri, version);
        if (questionnaires.has(uri))
          return (T) questionnaires.get(uri, version);
        for (Map<String, Resource> rt : allResourcesById.values()) {
          for (Resource r : rt.values()) {
            if (r instanceof CanonicalResource) {
              CanonicalResource mr = (CanonicalResource) r;
              if (uri.equals(mr.getUrl()))
                return (T) mr;
            }
          }            
        }
        return null;      
      } else if (class_ == ImplementationGuide.class) {
        return (T) guides.get(uri, version);
      } else if (class_ == CapabilityStatement.class) {
        return (T) capstmts.get(uri, version);
      } else if (class_ == Measure.class) {
        return (T) measures.get(uri, version);
      } else if (class_ == Library.class) {
        return (T) libraries.get(uri, version);
      } else if (class_ == StructureDefinition.class) {
        return (T) structures.get(uri, version);
      } else if (class_ == StructureMap.class) {
        return (T) transforms.get(uri, version);
      } else if (class_ == ValueSet.class) {
        return (T) valueSets.get(uri, version);
      } else if (class_ == CodeSystem.class) {
          return (T) codeSystems.get(uri, version);
      } else if (class_ == ConceptMap.class) {
        return (T) maps.get(uri, version);
      } else if (class_ == PlanDefinition.class) {
        return (T) plans.get(uri, version);
      } else if (class_ == OperationDefinition.class) {
        OperationDefinition od = operations.get(uri, version);
        return (T) od;
      } else if (class_ == Questionnaire.class) {
        return (T) questionnaires.get(uri, version);
      } else if (class_ == SearchParameter.class) {
        SearchParameter res = searchParameters.get(uri, version);
        return (T) res;
      }
      if (class_ == CodeSystem.class && codeSystems.has(uri))
        return (T) codeSystems.get(uri, version);
      if (class_ == ValueSet.class && valueSets.has(uri))
        return (T) valueSets.get(uri, version);
      
      if (class_ == Questionnaire.class)
        return (T) questionnaires.get(uri, version);
      if (class_ == null) {
        if (uri.matches(Constants.URI_REGEX) && !uri.contains("ValueSet"))
          return null;

        // it might be a special URL.
        if (Utilities.isAbsoluteUrl(uri) || uri.startsWith("ValueSet/")) {
          Resource res = null; // findTxValueSet(uri);
          if (res != null)
            return (T) res;
        }
        return null;      
      }    
      if (supportedCodeSystems.contains(uri))
        return null;
      throw new FHIRException(formatMessage(I18nConstants.NOT_DONE_YET_CANT_FETCH_, uri));
    }
  }

  private Set<String> notCanonical = new HashSet<String>();

  private String overrideVersionNs;
  
//  private MetadataResource findTxValueSet(String uri) {
//    MetadataResource res = expansionCache.getStoredResource(uri);
//    if (res != null)
//      return res;
//    synchronized (lock) {
//      if (notCanonical.contains(uri))
//        return null;
//    }
//    try {
//      tlog("get canonical "+uri);
//      res = txServer.getCanonical(ValueSet.class, uri);
//    } catch (Exception e) {
//      synchronized (lock) {
//        notCanonical.add(uri);
//      }
//      return null;
//    }
//    if (res != null)
//      try {
//        expansionCache.storeResource(res);
//      } catch (IOException e) {
//      }
//    return res;
//  }

  @Override
  public Resource fetchResourceById(String type, String uri) {
    synchronized (lock) {
      String[] parts = uri.split("\\/");
      if (!Utilities.noString(type) && parts.length == 1) {
        if (allResourcesById.containsKey(type))
          return allResourcesById.get(type).get(parts[0]);
        else
          return null;
      }
      if (parts.length >= 2) {
        if (!Utilities.noString(type))
          if (!type.equals(parts[parts.length-2])) 
            throw new Error(formatMessage(I18nConstants.RESOURCE_TYPE_MISMATCH_FOR___, type, uri));
        return allResourcesById.get(parts[parts.length-2]).get(parts[parts.length-1]);
      } else
        throw new Error(formatMessage(I18nConstants.UNABLE_TO_PROCESS_REQUEST_FOR_RESOURCE_FOR___, type, uri));
    }
  }

  public <T extends Resource> T fetchResource(Class<T> class_, String uri, CanonicalResource source) {
    try {
      return fetchResourceWithException(class_, uri, source);
    } catch (FHIRException e) {
      throw new Error(e);
    }    
  }
  
  public <T extends Resource> T fetchResource(Class<T> class_, String uri) {
    try {
      return fetchResourceWithException(class_, uri, null);
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

      Map<String, Resource> map = allResourcesById.get(fhirType);
      if (map == null) {
        map = new HashMap<String, Resource>();
        allResourcesById.put(fhirType, map);
      }
      if (map.containsKey(id))
        map.remove(id);

      if (fhirType.equals("StructureDefinition"))
        structures.drop(id);
      else if (fhirType.equals("ImplementationGuide"))
        guides.drop(id);
      else if (fhirType.equals("CapabilityStatement"))
        capstmts.drop(id);
      else if (fhirType.equals("Measure"))
        measures.drop(id);
      else if (fhirType.equals("Library"))
        libraries.drop(id);
      else if (fhirType.equals("ValueSet"))
        valueSets.drop(id);
      else if (fhirType.equals("CodeSystem"))
        codeSystems.drop(id);
      else if (fhirType.equals("OperationDefinition"))
        operations.drop(id);
      else if (fhirType.equals("Questionnaire"))
        questionnaires.drop(id);
      else if (fhirType.equals("ConceptMap"))
        maps.drop(id);
      else if (fhirType.equals("StructureMap"))
        transforms.drop(id);
      else if (fhirType.equals("NamingSystem"))
        for (int i = systems.size()-1; i >= 0; i--) {
          if (systems.get(i).getId().equals(id))
            systems.remove(i);
        }
    }
  }

  private <T extends CanonicalResource> void dropMetadataResource(Map<String, T> map, String id) {
    T res = map.get(id);
    if (res != null) {
      map.remove(id);
      if (map.containsKey(res.getUrl()))
        map.remove(res.getUrl());
      if (res.getVersion() != null)
        if (map.containsKey(res.getUrl()+"|"+res.getVersion()))
          map.remove(res.getUrl()+"|"+res.getVersion());
    }
  }

  @Override
  public List<CanonicalResource> allConformanceResources() {
    synchronized (lock) {
      List<CanonicalResource> result = new ArrayList<CanonicalResource>();
      structures.listAllM(result);
      guides.listAllM(result);
      capstmts.listAllM(result);
      measures.listAllM(result);
      libraries.listAllM(result);
      codeSystems.listAllM(result);
      valueSets.listAllM(result);
      maps.listAllM(result);
      transforms.listAllM(result);
      plans.listAllM(result);
      questionnaires.listAllM(result);
      return result;
    }
  }
  
  public String listSupportedSystems() {
    synchronized (lock) {
      String sl = null;
      for (String s : supportedCodeSystems)
        sl = sl == null ? s : sl + "\r\n" + s;
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
  
  public List<StructureMap> listTransforms() {
    List<StructureMap> m = new ArrayList<StructureMap>();
    synchronized (lock) {
      transforms.listAll(m);    
    }
    return m;
  }
  
  public StructureMap getTransform(String code) {
    synchronized (lock) {
      return transforms.get(code);
    }
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

  @Override
  public String oid2Uri(String oid) {
    synchronized (lock) {
      if (oid != null && oid.startsWith("urn:oid:")) {
        oid = oid.substring(8);
      }

      String uri = OIDUtils.getUriForOid(oid);
      if (uri != null)
        return uri;
      for (NamingSystem ns : systems) {
        if (hasOid(ns, oid)) {
          uri = getUri(ns);
          if (uri != null)
            return null;
        }
      }
    }
    return null;
  }
  

  private String getUri(NamingSystem ns) {
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      if (id.getType() == NamingSystemIdentifierType.URI)
        return id.getValue();
    }
    return null;
  }

  private boolean hasOid(NamingSystem ns, String oid) {
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      if (id.getType() == NamingSystemIdentifierType.OID && id.getValue().equals(oid))
        return true;
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
  public String getOverrideVersionNs() {
    return overrideVersionNs;
  }

  @Override
  public void setOverrideVersionNs(String value) {
    overrideVersionNs = value;
  }

  @Override
  public ILoggingService getLogger() {
    return logger;
  }

  @Override
  public StructureDefinition fetchTypeDefinition(String typeName) {
    if (Utilities.isAbsoluteUrl(typeName))
      return fetchResource(StructureDefinition.class, typeName);
    else
      return fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/"+typeName);
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

  @Override
  public List<StructureDefinition> getStructures() {
    List<StructureDefinition> res = new ArrayList<>();
    synchronized (lock) { // tricky, because you need to lock this as well, but it's really not in use yet
      structures.listAll(res);
    }
    return res;
  }
  
  public String getLinkForUrl(String corePath, String url) {
    if (codeSystems.has(url))
      return codeSystems.get(url).getUserString("path");

    if (valueSets.has(url))
      return valueSets.get(url).getUserString("path");

    if (maps.has(url))
      return maps.get(url).getUserString("path");
    
    if (transforms.has(url))
      return transforms.get(url).getUserString("path");
    
    if (structures.has(url))
      return structures.get(url).getUserString("path");
    
    if (guides.has(url))
      return guides.get(url).getUserString("path");
    
    if (capstmts.has(url))
      return capstmts.get(url).getUserString("path");
    
    if (measures.has(url))
      return measures.get(url).getUserString("path");

    if (libraries.has(url))
      return libraries.get(url).getUserString("path");

    if (searchParameters.has(url))
      return searchParameters.get(url).getUserString("path");
        
    if (questionnaires.has(url))
      return questionnaires.get(url).getUserString("path");

    if (operations.has(url))
      return operations.get(url).getUserString("path");
    
    if (plans.has(url))
      return plans.get(url).getUserString("path");

    if (url.equals("http://loinc.org"))
      return corePath+"loinc.html";
    if (url.equals("http://unitsofmeasure.org"))
      return corePath+"ucum.html";
    if (url.equals("http://snomed.info/sct"))
      return corePath+"snomed.html";
    return null;
  }

  

  public List<ImplementationGuide> allImplementationGuides() {
    List<ImplementationGuide> res = new ArrayList<>();
    guides.listAll(res);
    return res;
  }

  @Override
  public Map<String, byte[]> getBinaries() {
    return binaries;
  }
  
  public void finishLoading() {
    for (StructureDefinition sd : listStructures()) {
      try {
        if (sd.getSnapshot().isEmpty()) { 
          generateSnapshot(sd);
//          new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "snapshot", tail(sd.getUrl())+".xml")), sd);
        }
      } catch (Exception e) {
//        System.out.println("Unable to generate snapshot for "+tail(sd.getUrl()) +" from "+tail(sd.getBaseDefinition())+" because "+e.getMessage());
      }

    }  
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
}