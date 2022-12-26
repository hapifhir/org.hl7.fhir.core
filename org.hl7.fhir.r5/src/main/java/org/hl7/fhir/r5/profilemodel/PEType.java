package org.hl7.fhir.r5.profilemodel;

public class PEType {
  private String name;
  private String type;
  private String url;
  public PEType(String name, String type, String url) {
    super();
    this.name = name;
    this.url = url;
    this.type = type;
  }
  
  /**
   * Human presentable name 
   * 
   * @return
   */
  public String getName() {
    return name;
  }
  
  /**
   * The concrete FHIR type name for the type
   * 
   * @return
   */
  public String getType() {
    return type;
  }

  /**
   * URL that identifies the type
   * @return
   */
  public String getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return (name.equals(type) ? name : name+"->"+type)+"["+url+"]"; 
  } 
  
}