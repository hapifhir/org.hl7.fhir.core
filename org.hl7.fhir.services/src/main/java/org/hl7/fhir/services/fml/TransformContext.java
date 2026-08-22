package org.hl7.fhir.services.fml;




public class TransformContext {
  private Object appInfo;

  public TransformContext(Object appInfo) {
    super();
    this.appInfo = appInfo;
  }

  public Object getAppInfo() {
    return appInfo;
  }

}
