package org.hl7.fhir.convertors.txClient;

import java.net.URISyntaxException;

import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.services.client.ITerminologyClientFactoryN;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.services.client.TerminologyClientR6;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient5;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClientFactory5;
import org.hl7.fhir.r5.terminologies.client.TerminologyClient5R5;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class TerminologyClientFactory implements ITerminologyClientFactory5, ITerminologyClientFactoryN {

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
  public ITerminologyClient5 makeClientR5(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
    if (v == null)
      return new TerminologyClient5R5(id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    v = VersionUtilities.getMajMin(v);
    if (VersionUtilities.isR2Ver(v)) {
      return new TerminologyClient5R3(id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match
    }
    if (VersionUtilities.isR2BVer(v)) {
      return new TerminologyClient5R3(id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match
    }
    if (VersionUtilities.isR3Ver(v)) {
      return new TerminologyClient5R3(id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match
    }
    if (VersionUtilities.isR4Ver(v)) {
      return new TerminologyClient5R4(id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    }
    if (VersionUtilities.isR4BVer(v)) {
      return new TerminologyClient5R4(id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    }
    if (VersionUtilities.isR5Plus(v)) {
      return new TerminologyClient5R5(id, checkEndsWith("/r5", url), userAgent).setLogger(logger); // r4 for now, since the terminology is currently the same
    }
    throw new Error("The version " + v + " is not currently supported");
  }

  public ITerminologyClientN makeClientN(IModelContext context, String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException {
    if (v == null)
      return new TerminologyClientR6(context, id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    v = VersionUtilities.getMajMin(v);
    if (VersionUtilities.isR2Ver(v)) {
      return new TerminologyClientNR3(context, id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match
    }
    if (VersionUtilities.isR2BVer(v)) {
      return new TerminologyClientNR3(context, id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match
    }
    if (VersionUtilities.isR3Ver(v)) {
      return new TerminologyClientNR3(context, id, checkEndsWith("/r3", url), userAgent).setLogger(logger); // r3 is the least worst match
    }
    if (VersionUtilities.isR4Ver(v)) {
      return new TerminologyClientNR4(context, id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    }
    if (VersionUtilities.isR4BVer(v)) {
      return new TerminologyClientNR4(context, id, checkEndsWith("/r4", url), userAgent).setLogger(logger);
    }
    if (VersionUtilities.isR5Ver(v)) {
      return new TerminologyClientNR5(id, checkEndsWith("/r5", url), userAgent, context).setLogger(logger); // r4 for now, since the terminology is currently the same
    }
    if (VersionUtilities.isR6Plus(v)) {
      // note that this is still R5 for now, until we get an R6 terminology endpoint
      return new TerminologyClientNR5(id, checkEndsWith("/r5", url), userAgent, context).setLogger(logger); // r4 for now, since the terminology is currently the same
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