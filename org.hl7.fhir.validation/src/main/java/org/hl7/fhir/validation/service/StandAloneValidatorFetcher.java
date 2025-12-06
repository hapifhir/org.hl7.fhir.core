package org.hl7.fhir.validation.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import lombok.Getter;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContextManager;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.utils.validation.IMessagingServices;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.VersionUtilities.VersionURLInfo;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.service.utils.Common;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;


public class StandAloneValidatorFetcher implements IValidatorResourceFetcher, IValidationPolicyAdvisor, IWorkerContextManager.ICanonicalResourceLocator {

  List<String> mappingsUris = new ArrayList<>();
  private FilesystemPackageCacheManager pcm;
  private IWorkerContext context;
  private IPackageInstaller installer;
  private Map<String, Boolean> urlList = new HashMap<>();
  private Map<String, String> pidList = new HashMap<>();
  private Map<String, NpmPackage> pidMap = new HashMap<>();
  private IValidationPolicyAdvisor policyAdvisor;
  private String resolutionContext;
  private Map<String, String> knownFiles = new HashMap<>();

  public StandAloneValidatorFetcher(FilesystemPackageCacheManager pcm, IWorkerContext context, IPackageInstaller installer) {
    this.pcm = pcm;
    this.context = context;
    this.installer = installer;
    this.policyAdvisor = new BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy.IGNORE, null);
  }

  @Override
  public Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRException, IOException {
    if (!Utilities.isAbsoluteUrl(url) && Utilities.startsWithInList(resolutionContext, "http:", "https:")) {
      url = Utilities.pathURL(resolutionContext, url);
    }
    
    if (Utilities.isAbsoluteUrl(url)) {
      HTTPResult cnt = null; 
      try {
        cnt = ManagedWebAccess.get(Arrays.asList("web"), url, "application/json");
        cnt.checkThrowException();
        
      } catch (Exception e) {
        cnt = ManagedWebAccess.get(Arrays.asList("web"), url, "application/fhir+xml");
        cnt.checkThrowException();        
      }
      if (cnt.getContentType() != null && cnt.getContentType().contains("xml")) {
        return Manager.parse(context, new ByteArrayInputStream(cnt.getContent()), FhirFormat.XML).get(0).getElement();
      } else {
        return Manager.parse(context, new ByteArrayInputStream(cnt.getContent()), FhirFormat.JSON).get(0).getElement();
      }
    } else if (resolutionContext == null) {
      throw new FHIRException("The URL '" + url + "' is not known to the FHIR validator, and a resolution context has not been provided as part of the setup / parameters");
    } else if (resolutionContext.startsWith("file:")) {
      File rc = ManagedFileAccess.file(resolutionContext.substring(5));
      if (!rc.exists()) {
        throw new FHIRException("The URL '" + url + "' is not known to the FHIR validator, and a resolution context has not been provided as part of the setup / parameters");        
      }
      // first we look for the file by several different patterns
      File tgt = ManagedFileAccess.file(rc, url);
      if (tgt.exists()) {
        return see(tgt, loadFile(tgt));
      }
      tgt = ManagedFileAccess.file(rc, url+".json");
      if (tgt.exists()) {
        return see(tgt, loadFile(tgt));
      }
      tgt = ManagedFileAccess.file(rc, url+".xml");
      if (tgt.exists()) {
        return see(tgt, loadFile(tgt));
      }
      String[] p = url.split("\\/");
      if (p.length != 2) {
        throw new FHIRException("The URL '" + url + "' was not understood - expecting type/id");                
      }
      if (knownFiles.containsKey(p[0]+"/"+p[1])) {
        tgt = ManagedFileAccess.file(knownFiles.get(p[0]+"/"+p[1]));
        return loadFile(tgt);
      }
      tgt = ManagedFileAccess.file(rc, p[0]+"-"+p[1]+".json");
      if (tgt.exists()) {
        return see(tgt, loadFile(tgt));
      }
      tgt = ManagedFileAccess.file(rc, p[0]+"-"+p[1]+".xml");
      if (tgt.exists()) {
        return see(tgt, loadFile(tgt));
      }
      // didn't find it? now scan...
      for (File f : ManagedFileAccess.listFiles(rc)) {
        if (isPossibleMatch(f, p[0], p[1])) {
          Element e = see(f, loadFile(f));
          if (p[0].equals(e.fhirType()) && p[1].equals(e.getIdBase())) {
            return e;
          }
        }
      }
      return null;
    } else {
      throw new FHIRException("The resolution context '"+resolutionContext+"' was not understood");

    }
  }

  private Element see(File f, Element e) {
    knownFiles.put(e.fhirType()+"/"+e.getIdBase(), f.getAbsolutePath());
    return e;
  }

  private boolean isPossibleMatch(File f, String rt, String id) throws FileNotFoundException, IOException {
    String src = FileUtilities.fileToString(f);
    if (f.getName().endsWith(".xml")) {
      return src.contains("<"+rt) && src.contains("\""+id+"\"");
    } else {
      return src.contains("\""+rt+"\"") && src.contains("\""+id+"\"");      
    }
  }

  private Element loadFile(File tgt) throws FHIRFormatError, DefinitionException, FHIRException, FileNotFoundException, IOException {
    if (tgt.getName().endsWith(".xml")) {
      return Manager.parse(context, new FileInputStream(tgt), FhirFormat.XML).get(0).getElement();
    } else {
      return Manager.parse(context, new FileInputStream(tgt), FhirFormat.JSON).get(0).getElement();
    }
  }

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator,
                                                      Object appContext,
                                                      String path,
                                                      String url,
                                                      ReferenceDestinationType destinationType) {
    return policyAdvisor.policyForReference(validator, appContext, path, url, destinationType);
  }
  
  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type, boolean canonical, List<CanonicalType> targets) throws IOException, FHIRException {
    if (!Utilities.isAbsoluteUrl(url)) {
      return false;
    }

    if (url.contains("|")) {
      url = url.substring(0, url.lastIndexOf("|"));
    }

    if (type != null && type.equals("uri") && isMappingUri(url)) {
      return true;
    }

    // if we've got to here, it's a reference to a FHIR URL. We're going to try to resolve it on the fly
    String pid = null;
    String ver = null;
    String base = findBaseUrl(url);
    if (base == null) {
      return !url.startsWith("http://hl7.org/fhir") && !type.equals("canonical");
    }

    // the next operations are expensive. we're going to cache them 
    if (urlList.containsKey(url)) {
      return urlList.get(url);
    }
    if (base.equals("http://terminology.hl7.org")) {
      pid = "hl7.terminology";
    } else if (base.equals("http://hl7.org/fhir")) {
      return false;
    } else if (url.startsWith("http://hl7.org/fhir")) {
      pid = pcm.getPackageId(base);
    } else {
      if (pidList.containsKey(base)) {
        pid = pidList.get(base);
      } else {
        pid = pcm.findCanonicalInLocalCache(base);
        pidList.put(base, pid);
      }
    }
    ver = url.contains("|") ? url.substring(url.indexOf("|") + 1) : null;
    if (pid == null && Utilities.startsWithInList(url, "http://hl7.org/fhir", "http://terminology.hl7.org")) {
      urlList.put(url, false);
      return false;
    }

    if (url.startsWith("http://hl7.org/fhir")) {
      // first possibility: it's a reference to a version specific URL http://hl7.org/fhir/X.X/...
      VersionURLInfo vu = VersionUtilities.parseVersionUrl(url);
      if (vu != null) {
        NpmPackage pi = pcm.loadPackage(VersionUtilities.packageForVersion(vu.getVersion()), VersionUtilities.getCurrentVersion(vu.getVersion()));
        boolean res = pi.hasCanonical(vu.getUrl());
        urlList.put(url, res);
        return res;
      }
    }

    // ok maybe it's a reference to a package we know
    if (pid != null) {
      if ("sharedhealth.fhir.ca.common".equals(pid)) { // special case - optimise this
        return false;
      }
      NpmPackage pi = null;
      if (pidMap.containsKey(pid+"|"+ver)) {
        pi = pidMap.get(pid+"|"+ver);
      } else  if (installer.packageExists(pid, ver)) {
        try {
          installer.loadPackage(pid, ver);
          pi = pcm.loadPackage(pid);
          pidMap.put(pid+"|"+ver, pi);
        } catch (Exception e) {
          pidMap.put(pid+"|"+ver, null);          
        }
      } else {
        pidMap.put(pid+"|"+ver, null);
      }
      if (pi != null) {
        context.getManager().loadFromPackage(pi, null);
        return pi.hasCanonical(url) ||  context.fetchResource(Resource.class, url) != null;
      }
    }

    // we don't bother with urls outside fhir space in the standalone validator - we assume they are valid
    return !url.startsWith("http://hl7.org/fhir") && !type.equals("canonical");
  }

  private boolean isMappingUri(String url) {
    if (mappingsUris.isEmpty()) {
      JsonObject json;
      try {
        json = JsonParser.parseObjectFromUrl("http://hl7.org/fhir/mappingspaces.json");
        for (JsonObject ms : json.getJsonObjects("spaces")) {
          mappingsUris.add(ms.asString("url"));
        }
      } catch (IOException e) {
        // frozen R4 list
        mappingsUris.add("http://hl7.org/fhir/fivews");
        mappingsUris.add("http://hl7.org/fhir/workflow");
        mappingsUris.add("http://hl7.org/fhir/interface");
        mappingsUris.add("http://hl7.org/v2");
        mappingsUris.add("http://loinc.org");
        mappingsUris.add("http://snomed.org/attributebinding");
        mappingsUris.add("http://snomed.info/conceptdomain");
        mappingsUris.add("http://hl7.org/v3/cda");
        mappingsUris.add("http://hl7.org/v3");
        mappingsUris.add("http://nema.org/dicom");
        mappingsUris.add("http://w3.org/vcard");
        mappingsUris.add("http://ihe.net/xds");
        mappingsUris.add("http://www.w3.org/ns/prov");
        mappingsUris.add("http://ietf.org/rfc/2445");
        mappingsUris.add("http://www.omg.org/spec/ServD/1.0/");
        mappingsUris.add("http://metadata-standards.org/11179/");
        mappingsUris.add("http://ihe.net/data-element-exchange");
        mappingsUris.add("http://openehr.org");
        mappingsUris.add("http://siframework.org/ihe-sdc-profile");
        mappingsUris.add("http://siframework.org/cqf");
        mappingsUris.add("http://www.cdisc.org/define-xml");
        mappingsUris.add("http://www.cda-adc.ca/en/services/cdanet/");
        mappingsUris.add("http://www.pharmacists.ca/");
        mappingsUris.add("http://www.healthit.gov/quality-data-model");
        mappingsUris.add("http://hl7.org/orim");
        mappingsUris.add("http://hl7.org/fhir/w5");
        mappingsUris.add("http://hl7.org/fhir/logical");
        mappingsUris.add("http://hl7.org/fhir/auditevent");
        mappingsUris.add("http://hl7.org/fhir/provenance");
        mappingsUris.add("http://hl7.org/qidam");
        mappingsUris.add("http://cap.org/ecc");
        mappingsUris.add("http://fda.gov/UDI");
        mappingsUris.add("http://hl7.org/fhir/object-implementation");
        mappingsUris.add("http://github.com/MDMI/ReferentIndexContent");
        mappingsUris.add("http://ncpdp.org/SCRIPT10_6");
        mappingsUris.add("http://clinicaltrials.gov");
        mappingsUris.add("http://hl7.org/fhir/rr");
        mappingsUris.add("http://www.hl7.org/v3/PORX_RM020070UV");
        mappingsUris.add("https://bridgmodel.nci.nih.gov");
        mappingsUris.add("http://hl7.org/fhir/composition");
        mappingsUris.add("http://hl7.org/fhir/documentreference");
        mappingsUris.add("https://en.wikipedia.org/wiki/Identification_of_medicinal_products");
        mappingsUris.add("urn:iso:std:iso:11073:10201");
        mappingsUris.add("urn:iso:std:iso:11073:10207");
      }
    }
    return mappingsUris.contains(url);
  }

  private String findBaseUrl(String url) {
    String[] p = url.split("\\/");
    for (int i = 1; i < p.length; i++) {
      if (Utilities.existsInList(p[i], context.getResourceNames())) {
        StringBuilder b = new StringBuilder(p[0]);
        for (int j = 1; j < i; j++) {
          b.append("/");
          b.append(p[j]);
        }
        return b.toString();
      }
    }
    return null;
  }

  @Override
  public byte[] fetchRaw(IResourceValidator validator, String url) throws MalformedURLException, IOException {
    throw new FHIRException("The URL '" + url + "' is not known to the FHIR validator, and has not been provided as part of the setup / parameters");
  }

  @Override
  public IValidatorResourceFetcher setLocale(Locale locale) {
    // nothing

    return null;
  }

  @Override
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, Object appContext, String url) throws URISyntaxException {
    if (url.contains("|")) {
      url = url.substring(0, url.indexOf("|"));
    }
    String[] p = url.split("\\/");
  
    String root = getRoot(p, url);
    if (root != null) {
      ITerminologyClient terminologyClient = getTerminologyClient(root);
      return terminologyClient.read(p[p.length - 2], p[p.length - 1]);
    } else {
      throw new FHIRException("The URL '" + url + "' is not known to the FHIR validator, and has not been provided as part of the setup / parameters");
    }
  }

  @Nonnull
  protected ITerminologyClient getTerminologyClient(String root) throws URISyntaxException {
    return new TerminologyClientFactory(context.getVersion()).makeClient("source", root, Common.getValidatorUserAgent(), null);
  }

  private String getRoot(String[] p, String url) {
    if (p.length > 3 && Utilities.isValidId(p[p.length - 1]) && context.getResourceNames().contains(p[p.length - 2])) {
      url = url.substring(0, url.lastIndexOf("/"));
      return url.substring(0, url.lastIndexOf("/"));
    } else {
      return null;
    }
  }

  @Override
  public boolean fetchesCanonicalResource(IResourceValidator validator, String url) {
    return true;
  }

  @Override
  public void findResource(Object validator, String url) {
    try {
      resolveURL((IResourceValidator) validator, null, null, url, null, false, null);
    } catch (Exception e) {
    }
  }

  @Override
  public Set<ResourceVersionInformation> fetchCanonicalResourceVersions(IResourceValidator validator, Object appContext, String url) {
    return new HashSet<>();
  }

  @Override
  public boolean isSuppressMessageId(String path, String messageId) {
    return policyAdvisor.isSuppressMessageId(path, messageId);
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String containerType, String containerId,
      SpecialElement containingResourceType, String path, String url) {
    return policyAdvisor.policyForContained(validator, appContext, structure, element, containerType, containerId, containingResourceType, path, url);
  }

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext,
      StructureDefinition type, String path) {
    return policyAdvisor.policyForResource(validator, appContext, type, path);
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String path) {
    return policyAdvisor.policyForElement(validator, appContext, structure, element, path);
  }

  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, BindingKind kind,
      AdditionalBindingPurpose purpose, ValueSet valueSet, List<String> systems) {
    return policyAdvisor.policyForCodedContent(validator, appContext, stackPath, definition, structure, kind, purpose, valueSet, systems);
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, Element resource, boolean valid,
      IMessagingServices msgServices, List<ValidationMessage> messages) {
    return policyAdvisor.getImpliedProfilesForResource(validator, appContext, stackPath, definition, structure, resource, valid, msgServices, messages);
  }


  public Set<String> getCheckReferencesTo() {
    return policyAdvisor.getCheckReferencesTo();
  }


  @Override
  public ReferenceValidationPolicy getReferencePolicy() {
    return policyAdvisor.getReferencePolicy();
  }

  public void setReferencePolicy(ReferenceValidationPolicy policy) {
    if (policyAdvisor instanceof BasePolicyAdvisorForFullValidation) {
      ((BasePolicyAdvisorForFullValidation) policyAdvisor).setRefpol(policy);
    } else {
      throw new Error("Cannot set reference policy on a "+policy.getClass().getName());      
    }
  }

  public IValidationPolicyAdvisor getPolicyAdvisor() {
    return policyAdvisor;
  }

  public IValidationPolicyAdvisor setPolicyAdvisor(IValidationPolicyAdvisor policyAdvisor) {
    this.policyAdvisor = policyAdvisor;
    return this;
  }

  public String getResolutionContext() {
    return resolutionContext;
  }

  public void setResolutionContext(String resolutionContext) {
    this.resolutionContext = resolutionContext;
  }

  @Override
  public SpecialValidationAction policyForSpecialValidation(IResourceValidator validator, Object appContext, SpecialValidationRule rule, String stackPath, Element resource, Element element) {
    return policyAdvisor.policyForSpecialValidation(validator, appContext, rule, stackPath, resource, element);
  }

}
