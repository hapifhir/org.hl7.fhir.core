package org.hl7.fhir.convertors.txClient;

import java.net.URISyntaxException;

import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.utilities.FhirPublication;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class TerminologyClientFactory {

  public static ITerminologyClient makeClient(String id, String url, String userAgent, FhirPublication v) throws URISyntaxException {
    if (v == null)
      return new TerminologyClientR5(id, checkEndsWith("/r4", url), userAgent);
    switch (v) {
      case DSTU2016May:
        return new TerminologyClientR3(id, checkEndsWith("/r3", url), userAgent); // r3 is the least worst match
      case DSTU1:
        throw new Error("The version " + v + " is not currently supported");
      case DSTU2:
        return new TerminologyClientR2(id, checkEndsWith("/r2", url), userAgent);
      case R4:
        return new TerminologyClientR4(id, checkEndsWith("/r4", url), userAgent);
      case R4B:
        return new TerminologyClientR4(id, checkEndsWith("/r4", url), userAgent);
      case R5:
        return new TerminologyClientR5(id, checkEndsWith("/r4", url), userAgent); // r4 for now, since the terminology is currently the same
      case STU3:
        return new TerminologyClientR3(id, checkEndsWith("/r3", url), userAgent);
      default:
        throw new Error("The version " + v + " is not currently supported");
    }
  }

  public static ITerminologyClient makeClient(String id, String url, String userAgent, String v) throws URISyntaxException {
    if (v == null)
      return new TerminologyClientR5(id, checkEndsWith("/r4", url), userAgent);
    v = VersionUtilities.getMajMin(v);
    if (VersionUtilities.isR2Ver(v)) {
      return new TerminologyClientR2(id, checkEndsWith("/r2", url), userAgent);      
    }
    if (VersionUtilities.isR2BVer(v)) {
      return new TerminologyClientR3(id, checkEndsWith("/r3", url), userAgent); // r3 is the least worst match      
    }
    if (VersionUtilities.isR3Ver(v)) {
      return new TerminologyClientR3(id, checkEndsWith("/r3", url), userAgent); // r3 is the least worst match      
    }
    if (VersionUtilities.isR4Ver(v)) {
      return new TerminologyClientR4(id, checkEndsWith("/r4", url), userAgent);      
    }
    if (VersionUtilities.isR4BVer(v)) {
      return new TerminologyClientR4(id, checkEndsWith("/r4", url), userAgent);
    }
    if (VersionUtilities.isR5Plus(v)) {
      return new TerminologyClientR5(id, checkEndsWith("/r4", url), userAgent); // r4 for now, since the terminology is currently the same      
    }
    throw new Error("The version " + v + " is not currently supported");
  }

  private static String checkEndsWith(String term, String url) {
    if (url.endsWith(term))
      return url;
    if (Utilities.isTxFhirOrgServer(url)) {
      return Utilities.pathURL(url, term);
    }
    return url;
  }

}