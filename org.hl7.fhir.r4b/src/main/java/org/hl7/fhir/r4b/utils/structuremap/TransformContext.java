package org.hl7.fhir.r4b.utils.structuremap;

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
