package org.hl7.fhir.convertors.loaders;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseLoader {

  protected final String URL_BASE = "http://hl7.org/fhir/";
  protected final String URL_DSTU2 = "http://hl7.org/fhir/1.0/";
  protected final String URL_DSTU2016MAY = "http://hl7.org/fhir/1.4/";
  protected final String URL_DSTU3 = "http://hl7.org/fhir/3.0/";
  protected final String URL_R4 = "http://hl7.org/fhir/4.0/";

  protected final String URL_ELEMENT_DEF_NAMESPACE = "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace";

  protected boolean patchUrls;
  protected boolean killPrimitives;;

  private String[] types;

  public BaseLoader(String[] types) {
    super();
    this.types = types;
  }
  
  public String[] getTypes() {
    return types;
  }

  public boolean isPatchUrls() {
    return patchUrls;
  }

  public BaseLoader setPatchUrls(boolean patchUrls) {
    this.patchUrls = patchUrls;
    return this;
  }

  public boolean isKillPrimitives() {
    return killPrimitives;
  }

  public BaseLoader setKillPrimitives(boolean killPrimitives) {
    this.killPrimitives = killPrimitives;
    return this;
  }


}