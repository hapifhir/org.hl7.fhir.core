package org.hl7.fhir.r5.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;

public abstract class CanonicalResourceProxy {
  private String type;
  private String id;
  private String url;
  private String version;
  private String supplements;
  private String derivation;
  private CanonicalResource resource;
  private boolean hacked;
  private String content;

  public CanonicalResourceProxy(String type, String id, String url, String version, String supplements, String derivation, String content) {
    super();
    this.type = type;
    this.id = id;
    this.url = url;
    this.version = version;
    this.supplements = supplements;
    this.content = content;
    this.derivation = derivation;
  }

  public String getType() {
    return type;
  }

  public String getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public String getVersion() {
    return version;
  }

  public boolean hasId() {
    return id != null;
  }

  public boolean hasUrl() {
    return url != null;
  }

  public boolean hasVersion() {
    return version != null;
  }

  public String getSupplements() {
    return supplements;
  }


  public String getContent() {
    return content;
  }

  public String getDerivation() {
    return derivation;
  }

  public void setDerivation(String derivation) {
    this.derivation = derivation;
  }

  public CanonicalResource getResource() throws FHIRException {
    if (resource == null) {
      resource = loadResource();
      if (hacked) {
        resource.setUrl(url).setVersion(version);
      }
      if (resource instanceof CodeSystem) {
        CodeSystemUtilities.crossLinkCodeSystem((CodeSystem) resource);
      }
      // if a resource is loaded by this path, we'll never need it's narrative.
      // and there's no reason to keep it in memory. at some stage, it is worth
      // investing in not loading it in the frst place, but it's quite a bit of
      // routing and piping. this saves a lot of memory
      if (resource instanceof DomainResource) {
        (resource).setText(null);
      }
    }
    return resource;
  }

  public void setResource(CanonicalResource resource) {
    this.resource = resource;
  }

  public abstract CanonicalResource loadResource() throws FHIRException;

  @Override
  public String toString() {
    return type + "/" + id + ": " + url + "|" + version;
  }

  public void hack(String url, String version) {
    this.url = url;
    this.version = version;
    this.hacked = true;

  }

  /**
   * used in cross version settings by the package loaders.
   */
  public void updateInfo() {
    type = resource.fhirType();
    id = resource.getId();
    url = resource.getUrl();
    version = resource.getVersion();
    if (resource instanceof CodeSystem) {
      supplements = ((CodeSystem) resource).getSupplements();
      content = ((CodeSystem) resource).getContentElement().asStringValue();
    }
    if (resource instanceof StructureDefinition) {
      derivation = ((StructureDefinition) resource).getDerivationElement().asStringValue();
    }
  }
}
