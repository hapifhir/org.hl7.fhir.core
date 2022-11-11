package org.hl7.fhir.r5.context;

public interface IWorkerContextManager {

  interface IPackageLoadingTracker {
    public void packageLoaded(String pid, String version);
  }

  interface ICanonicalResourceLocator {
    void findResource(Object caller, String url); // if it can be found, put it in the context
  }

}
