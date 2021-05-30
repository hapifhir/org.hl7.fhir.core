package org.hl7.fhir.utilities;

public class CanonicalPair {

  private String url;
  private String version;
  
  public CanonicalPair(String target) {
    if (target != null && target.contains("|")) {
      this.url = target.substring(0, target.indexOf("|"));
      this.version = target.substring(target.indexOf("|")+1);     
    } else {
      this.url = target;
      this.version = null;
    }
  }

  public String getUrl() {
    return url;
  }

  public String getVersion() {
    return version;
  }

}
