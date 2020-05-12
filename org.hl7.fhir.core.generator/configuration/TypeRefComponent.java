public boolean hasTarget() {
    return Utilities.existsInList(getCode(), "Reference", "canonical", "CodeableReference");
  }
  
    /**
   * This code checks for the system prefix and returns the FHIR type
   * 
   * @return
   */
  public String getWorkingCode() {
    if (hasExtension(ToolingExtensions.EXT_FHIR_TYPE))
      return getExtensionString(ToolingExtensions.EXT_FHIR_TYPE);
    if (!hasCodeElement()) 
      return null;
    if (getCodeElement().hasExtension(ToolingExtensions.EXT_XML_TYPE)) {
      String s = getCodeElement().getExtensionString(ToolingExtensions.EXT_XML_TYPE);
      if ("xsd:gYear OR xsd:gYearMonth OR xsd:date OR xsd:dateTime".equalsIgnoreCase(s))
        return "dateTime";
      if ("xsd:gYear OR xsd:gYearMonth OR xsd:date".equalsIgnoreCase(s))
        return "date";
      if ("xsd:dateTime".equalsIgnoreCase(s))
        return "instant";
      if ("xsd:token".equals(s))
        return "code";
      if ("xsd:boolean".equals(s))
        return "boolean";
      if ("xsd:string".equals(s))
        return "string";
      if ("xsd:time".equals(s))
        return "time";
      if ("xsd:int".equals(s))
        return "integer";
      if ("xsd:decimal OR xsd:double".equals(s))
        return "decimal";
      if ("xsd:decimal".equalsIgnoreCase(s))
        return "decimal";
      if ("xsd:base64Binary".equalsIgnoreCase(s))
        return "base64Binary";
      if ("xsd:positiveInteger".equalsIgnoreCase(s))
        return "positiveInt";
      if ("xsd:nonNegativeInteger".equalsIgnoreCase(s))
        return "unsignedInt";
      if ("xsd:anyURI".equalsIgnoreCase(s))
        return "uri";
      
      throw new Error("Unknown xml type '"+s+"'");
    }
    return getCode();
  }

  @Override
  public String toString() {
    String res = getCode();
    if (hasProfile()) {
      res = res + "{";
      boolean first = true;
      for (CanonicalType s : getProfile()) {
        if (first) first = false; else res = res + "|";
        res = res + s.getValue();
      }
      res = res + "}";
    }
    if (hasTargetProfile()) {
      res = res + "->(";
      boolean first = true;
      for (CanonicalType s : getTargetProfile()) {
        if (first) first = false; else res = res + "|";
        res = res + s.getValue();
      }
      res = res + ")";
    }    
    return res;
  }

  public String getName() {
    return getWorkingCode();
  }

  public boolean isResourceReference() {
    return "Reference".equals(getCode()) && hasTargetProfile();
  }