package org.hl7.fhir.convertors.txClient;

import java.net.URISyntaxException;

import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager.ITerminologyClientFactory;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientR5;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class TerminologyClientFactory implements ITerminologyClientFactory {

  private String v;  

  public TerminologyClientFactory(FhirPublication v) {
    super();
    this.v = v == null ? null : v.toCode();
  }
  
  public TerminologyClientFactory(String version) {
    super();
    this.v = version;
  }

  @Override
  public ITerminologyClient makeClient(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
    if (v == null)
      return new TerminologyClientR5(id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    v = VersionUtilities.getMajMin(v);
    if (VersionUtilities.isR2Ver(v)) {
      return new TerminologyClientR2(id, checkEndsWith("/r2", url), userAgent).setLogger(logger);      
    }
    if (VersionUtilities.isR2BVer(v)) {
      return new TerminologyClientR3(id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match      
    }
    if (VersionUtilities.isR3Ver(v)) {
      return new TerminologyClientR3(id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match      
    }
    if (VersionUtilities.isR4Ver(v)) {
      return new TerminologyClientR4(id, checkEndsWith("/r4", url), userAgent).setLogger(logger);      
    }
    if (VersionUtilities.isR4BVer(v)) {
      return new TerminologyClientR4(id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    }
    if (VersionUtilities.isR5Plus(v)) {
      return new TerminologyClientR5(id, checkEndsWith("/r4", url), userAgent).setLogger(logger); // r4 for now, since the terminology is currently the same      
    }
    throw new Error("The version " + v + " is not currently supported");
  }

  private String checkEndsWith(String term, String url) {
    if (url.endsWith(term))
      return url;
    if (Utilities.isTxFhirOrgServer(url)) {
      return Utilities.pathURL(url, term);
    }
    return url;
  }

  @Override
  public String getVersion() {
    return v;
  }

}