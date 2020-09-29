package org.hl7.fhir.validation.cli.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.utils.IResourceValidator.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.IResourceValidator.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.VersionUtilities.VersionURLInfo;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.validation.cli.services.StandAloneValidatorFetcher.IPackageInstaller;

public class StandAloneValidatorFetcher implements IValidatorResourceFetcher {

  public interface IPackageInstaller {
    public boolean packageExists(String id, String ver) throws IOException, FHIRException;
    public void loadPackage(String id, String ver) throws IOException, FHIRException;
  }

  private BasePackageCacheManager pcm;
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
    throw new Error("Not done yet");
  }

  @Override
  public ReferenceValidationPolicy validationPolicy(Object appContext, String path, String url) {
    throw new Error("Not done yet");
  }

  @Override
  public boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException {
    if (!Utilities.isAbsoluteUrl(url)) {
      return false;
    }
    // if we've got to here, it's a reference to a FHIR URL. We're going to try to resolve it on the fly 
    
    // first possibility: it's a reference to a version specific URL http://hl7.org/fhir/X.X/...
    VersionURLInfo vu = VersionUtilities.parseVersionUrl(url);
    if (vu != null) {
      NpmPackage pi = pcm.loadPackage(VersionUtilities.packageForVersion(vu.getVersion()), VersionUtilities.getCurrentVersion(vu.getVersion()));
      return pi.hasCanonical(vu.getUrl());
    }

    // ok maybe it's a reference to a package we know
    String base = findBaseUrl(url);
    String pid = pcm.getPackageId(base);
    String ver = url.contains("|") ? url.substring(url.indexOf("|")+1) : null;
    if (pid != null) {
      if (installer.packageExists(pid, ver)) {
        installer.loadPackage(pid, ver);
        NpmPackage pi = pcm.loadPackage(pid);
        return pi.hasCanonical(url);
      }
    }
    
    if (!url.startsWith("http://hl7.org/fhir")) {
      return true; // we don't bother with those in the standalone validator - we assume they are valid 
    }
    
    // we assume it's invalid at this point 
    return false;

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
    throw new Error("Not done yet");
  }

  @Override
  public void setLocale(Locale locale) {
    throw new Error("Not done yet");
  }

}
