package org.hl7.fhir.r5.utils.validation;

import lombok.Getter;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@MarkedToMoveToAdjunctPackage
public interface IValidatorResourceFetcher {

  Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRException, IOException;

  boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type, boolean canonical, List<CanonicalType> targets) throws IOException, FHIRException;

  byte[] fetchRaw(IResourceValidator validator, String url) throws IOException; // for attachment checking

  IValidatorResourceFetcher setLocale(Locale locale);

  /**
   * this is used when the validator encounters a reference to a structure definition, value set or code system at some random URL reference
   * while validating.
   * <p>
   * Added in v5.2.2. return null to leave functionality as it was before then.
   *
   * @return an R5 version of the resource
   * @throws URISyntaxException
   */
  CanonicalResource fetchCanonicalResource(IResourceValidator validator, Object appContext, String url) throws URISyntaxException;

  /**
   * Whether to try calling fetchCanonicalResource for this reference (not whether it will succeed - just throw an exception from fetchCanonicalResource if it doesn't resolve. This is a policy thing.
   * <p>
   * Added in v5.2.2. return false to leave functionality as it was before then.
   *
   * @param url
   * @return
   */
  boolean fetchesCanonicalResource(IResourceValidator validator, String url);

  Set<ResourceVersionInformation> fetchCanonicalResourceVersions(IResourceValidator validator, Object appContext, String url);

  public static class ResourceVersionInformation {
    @Getter private String version;
    @Getter private String sourcePackage;

    public ResourceVersionInformation(String version, PackageInformation sourcePackage) {
      this.version = version;
      this.sourcePackage = sourcePackage == null ? null : sourcePackage.getVID();
    }

    public static Set<String> toStrings(Set<IValidatorResourceFetcher.ResourceVersionInformation> possibleVersions) {
      Set<String> result = new HashSet<>();
      for (IValidatorResourceFetcher.ResourceVersionInformation v : possibleVersions) {
        if (v.getSourcePackage() == null) {
          result.add(v.getVersion());
        } else {
          result.add(v.getVersion()+" (from "+v.getSourcePackage()+")");
        }
      }
      return result;
    }
  }
}
