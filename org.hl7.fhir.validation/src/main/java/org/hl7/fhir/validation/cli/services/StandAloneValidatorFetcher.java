package org.hl7.fhir.validation.cli.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContextManager;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.AdditionalBindingPurpose;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.CodedContentValidationAction;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ElementValidationAction;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ResourceValidationAction;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.CodedContentValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.VersionUtilities.VersionURLInfo;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.validation.cli.utils.Common;

import javax.annotation.Nonnull;


public class StandAloneValidatorFetcher implements IValidatorResourceFetcher, IValidationPolicyAdvisor, IWorkerContextManager.ICanonicalResourceLocator {

  List<String> mappingsUris = new ArrayList<>();
  private FilesystemPackageCacheManager pcm;
  private IWorkerContext context;
  private IPackageInstaller installer;
  private Map<String, Boolean> urlList = new HashMap<>();
  private Map<String, String> pidList = new HashMap<>();
  private Map<String, NpmPackage> pidMap = new HashMap<>();

  public StandAloneValidatorFetcher(FilesystemPackageCacheManager pcm, IWorkerContext context, IPackageInstaller installer) {
    super();
    this.pcm = pcm;
    this.context = context;
    this.installer = installer;
  }

  @Override
  public Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRException {
    throw new FHIRException("The URL '" + url + "' is not known to the FHIR validator, and has not been provided as part of the setup / parameters");
  }

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator,
                                                      Object appContext,
                                                      String path,
                                                      String url) {
    return ReferenceValidationPolicy.CHECK_TYPE_IF_EXISTS;
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator,
      Object appContext,
      StructureDefinition structure,
      ElementDefinition element,
      String containerType,
      String containerId,
      Element.SpecialElement containingResourceType,
      String path,
      String url) {
    return ContainedReferenceValidationPolicy.CHECK_VALID;
  }

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext,
      StructureDefinition type, String path) {
    return EnumSet.allOf(ResourceValidationAction.class);
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String path) {
    return EnumSet.allOf(ElementValidationAction.class);
  }
  
  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type, boolean canonical) throws IOException, FHIRException {
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
        context.loadFromPackage(pi, null);
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
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, String url) throws URISyntaxException {
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
    return new TerminologyClientFactory(context.getVersion()).makeClient("source", root, Common.getValidatorUserAgent());
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
      resolveURL((IResourceValidator) validator, null, null, url, null, false);
    } catch (Exception e) {
    }
  }

  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator,
      Object appContext,
      String stackPath,
      ElementDefinition definition,
      StructureDefinition structure,
      BindingKind kind,
      AdditionalBindingPurpose purpose,
      ValueSet valueSet,
      List<String> systems) {
    return EnumSet.allOf(CodedContentValidationAction.class);
  }

}
