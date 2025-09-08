package org.hl7.fhir.r5.utils.xver;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;

public class XVerExtensionManagerFactory {

  private static XVerExtensionManagerNew.IXverManagerPackageLoader loader;

  public static XVerExtensionManagerNew.IXverManagerPackageLoader getLoader() {
    return loader;
  }

  public static void setLoader(XVerExtensionManagerNew.IXverManagerPackageLoader loader) {
    XVerExtensionManagerFactory.loader = loader;
  }

  public static XVerExtensionManager createExtensionManager(IWorkerContext context) throws FHIRException {
    if (loader != null) {
      return new XVerExtensionManagerNew(context, loader);
    } else {
      return new XVerExtensionManagerOld(context);
    }
  }
}
