package org.hl7.fhir.validation.cli.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.utils.IResourceValidator.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.IResourceValidator.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.VersionUtilities.VersionURLInfo;
import org.hl7.fhir.utilities.json.JSONUtil;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

import com.google.gson.JsonObject;

import ca.uhn.fhir.util.JsonUtil;

public class StandAloneValidatorFetcher implements IValidatorResourceFetcher {

  public interface IPackageInstaller {
    boolean packageExists(String id, String ver) throws IOException, FHIRException;
    void loadPackage(String id, String ver) throws IOException, FHIRException;
  }

  List<String> mappingsUris = new ArrayList<>();
  private FilesystemPackageCacheManager pcm;
  private IWorkerContext context;
  private IPackageInstaller installer;
  
  public StandAloneValidatorFetcher(FilesystemPackageCacheManager pcm, IWorkerContext context, IPackageInstaller installer) {
    super();
    this.pcm = pcm;
    this.context = context;
    this.installer = installer;
  }

  @Override
  public Element fetch(Object appContext, String url) throws FHIRFormatError, DefinitionException, FHIRException, IOException {
    throw new FHIRException("The URL '"+url+"' is not known to the FHIR validator, and has not been provided as part of the setup / parameters");
  }

  @Override
  public ReferenceValidationPolicy validationPolicy(Object appContext, String path, String url) {
    return ReferenceValidationPolicy.CHECK_TYPE_IF_EXISTS;
  }

  @Override
  public boolean resolveURL(Object appContext, String path, String url, String type) throws IOException, FHIRException {
    if (!Utilities.isAbsoluteUrl(url)) {
      return false;
    }
    
    if (url.contains("|")) {
      url = url.substring(0, url.lastIndexOf("|"));
    }
    
    if (type.equals("uri") && isMappingUri(url)) {
      return true;
    }
    
    // if we've got to here, it's a reference to a FHIR URL. We're going to try to resolve it on the fly
    String pid = null;
    String ver = null;
    String base = findBaseUrl(url);
    if (base == null) {
      return !url.startsWith("http://hl7.org/fhir") && !type.equals("canonical");
    }
    
    if (base.equals("http://terminology.hl7.org")) {
      pid = "hl7.terminology"; 
    } else if (url.startsWith("http://hl7.org/fhir")) {
      pid = pcm.getPackageId(base);
    } else { 
      pid = pcm.findCanonicalInLocalCache(base);
    }
    ver = url.contains("|") ? url.substring(url.indexOf("|")+1) : null;
    if (pid == null && Utilities.startsWithInList(url, "http://hl7.org/fhir", "http://terminology.hl7.org")) {
      return false;
    }
    
    if (url.startsWith("http://hl7.org/fhir")) {
      // first possibility: it's a reference to a version specific URL http://hl7.org/fhir/X.X/...
      VersionURLInfo vu = VersionUtilities.parseVersionUrl(url);
      if (vu != null) {
        NpmPackage pi = pcm.loadPackage(VersionUtilities.packageForVersion(vu.getVersion()), VersionUtilities.getCurrentVersion(vu.getVersion()));
        return pi.hasCanonical(vu.getUrl());
      }
    }

    // ok maybe it's a reference to a package we know
    if (pid != null) {
      if (installer.packageExists(pid, ver)) {
        installer.loadPackage(pid, ver);
        NpmPackage pi = pcm.loadPackage(pid);
        return pi.hasCanonical(url);
      }
    }
    

 // we don't bother with urls outside fhir space in the standalone validator - we assume they are valid
    return !url.startsWith("http://hl7.org/fhir") && !type.equals("canonical");
  }

  private boolean isMappingUri(String url) {
    if (mappingsUris.isEmpty()) {
      JsonObject json;
      try {
        json = JsonTrackingParser.fetchJson("http://hl7.org/fhir/mappingspaces.json");
        for (JsonObject ms : JSONUtil.objects(json, "spaces")) {
          mappingsUris.add(JSONUtil.str(ms, "url"));       
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
    for (int i = 1; i< p.length; i++) {
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
  public byte[] fetchRaw(String url) throws MalformedURLException, IOException {
    throw new FHIRException("The URL '"+url+"' is not known to the FHIR validator, and has not been provided as part of the setup / parameters");
  }

  @Override
  public void setLocale(Locale locale) {
    // nothing
  }

  @Override
  public CanonicalResource fetchCanonicalResource(String url) throws URISyntaxException {
    String[] p = url.split("\\/");
    String root = getRoot(p, url);
    if (root != null) {
      TerminologyClient c;
      c = TerminologyClientFactory.makeClient(root, context.getVersion());
      return c.read(p[p.length-2], p[p.length-1]);
    } else {
      throw new FHIRException("The URL '"+url+"' is not known to the FHIR validator, and has not been provided as part of the setup / parameters");
    }
  }

  private String getRoot(String[] p, String url) {
    if (p.length > 3 && Utilities.isValidId(p[p.length-1]) && context.getResourceNames().contains(p[p.length-2])) {
      url = url.substring(0, url.lastIndexOf("/"));
      return url.substring(0, url.lastIndexOf("/"));
    } else {
      return null;
    }
    
  }

  @Override
  public boolean fetchesCanonicalResource(String url) {
    return true;
  }

}
