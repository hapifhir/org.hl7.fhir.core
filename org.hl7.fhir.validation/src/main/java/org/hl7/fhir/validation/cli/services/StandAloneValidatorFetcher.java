package org.hl7.fhir.validation.cli.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class StandAloneValidatorFetcher implements IValidatorResourceFetcher {

  public interface IPackageInstaller {
    boolean packageExists(String id, String ver) throws IOException, FHIRException;
    void loadPackage(String id, String ver) throws IOException, FHIRException;
  }

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
  public boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException {
    if (!Utilities.isAbsoluteUrl(url)) {
      return false;
    }
    
    // if we've got to here, it's a reference to a FHIR URL. We're going to try to resolve it on the fly
    String pid = null;
    String ver = null;
    String base = findBaseUrl(url);
    if (base == null) {
      return false;
    }
    
    if (base.equals("http://terminology.hl7.org")) {
      pid = "hl7.terminology"; 
    } else if (url.startsWith("http://hl7.org/fhir")) {
      pid = pcm.getPackageId(base);
    } else { 
      pid = pcm.findCanonicalInLocalCache(base);
    }
    ver = url.contains("|") ? url.substring(url.indexOf("|")+1) : null;
    if (pid == null) {
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
    return !url.startsWith("http://hl7.org/fhir");
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
