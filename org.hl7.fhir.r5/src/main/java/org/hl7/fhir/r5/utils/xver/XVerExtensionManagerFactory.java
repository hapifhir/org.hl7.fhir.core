package org.hl7.fhir.r5.utils.xver;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class XVerExtensionManagerFactory {

  // this arrangement is temporary while working up the new cross-version package
  // system. We need to figure out a better way to inject the loader logic.
  //
  // On the context?
  @Getter @Setter
  private static boolean newLoader = false;


  public static XVerExtensionManager createExtensionManager(IWorkerContext context) throws FHIRException {
    if (newLoader) {
      return new XVerExtensionManagerNew(context);
    } else {
      return new XVerExtensionManagerOld(context);
    }
  }
}
