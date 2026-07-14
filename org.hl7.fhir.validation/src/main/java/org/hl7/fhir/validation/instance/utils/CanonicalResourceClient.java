package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.service.utils.Common;

import javax.annotation.Nonnull;
import java.net.URISyntaxException;

public class CanonicalResourceClient {
  private final IWorkerContext context;

  public CanonicalResourceClient(IWorkerContext context) {
    this.context = context;
  }

  public CanonicalResource fetch(String url) throws URISyntaxException {
    if (url.contains("|")) {
      url = url.substring(0, url.indexOf("|"));
    }
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //single literal character split
    String[] p = url.split("\\/");

    String root = getRoot(p, url);
    if (root != null) {
      ITerminologyClient terminologyClient = getTerminologyClient(root);
      return terminologyClient.read(p[p.length - 2], p[p.length - 1]);
    } else {
      throw new FHIRException("The URL '" + url + "' is not known to the FHIR validator, and has not been provided as part of the setup / parameters");
    }
  }

  private String getRoot(String[] p, String url) {
    if (p.length > 3 && Utilities.isValidId(p[p.length - 1]) && context.getResourceNames().contains(p[p.length - 2])) {
      url = url.substring(0, url.lastIndexOf("/"));
      return url.substring(0, url.lastIndexOf("/"));
    } else {
      return null;
    }
  }

  @Nonnull
  public ITerminologyClient getTerminologyClient(String root) throws URISyntaxException {
    return new TerminologyClientFactory(context.getVersion()).makeClient("source", root, Common.getValidatorUserAgent(), null);
  }


}
