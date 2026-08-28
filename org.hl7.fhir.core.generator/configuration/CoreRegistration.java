{{startMark}}
package org.hl7.fhir.model.core;

import org.hl7.fhir.model.ModelContextInformation;

{{license}}

{{generated}}
public class CoreRegistration {

  public static String register(ModelContextInformation modelContextInformation) {
    String packageName = Constants.PACKAGE_NAME+"#"+ Constants.VERSION;

{{coreregistration}}

    return packageName;
  }
}
