/** 
  /** 
   * Returns all repetitions of {@link #getGiven() given name} as a space separated string 
   *  
   * @see DatatypeUtil#joinStringsSpaceSeparated(List) 
   */ 
  public String getGivenAsSingleString() { 
    return joinStringsSpaceSeparated(getGiven()); 
  } 

  /** 
   * Returns all repetitions of {@link #getPrefix() prefix name} as a space separated string 
   *  
   * @see DatatypeUtil#joinStringsSpaceSeparated(List) 
   */ 
  public String getPrefixAsSingleString() { 
    return joinStringsSpaceSeparated(getPrefix()); 
  } 

  /** 
   * Returns all repetitions of {@link #getSuffix() suffix} as a space separated string 
   *  
   * @see DatatypeUtil#joinStringsSpaceSeparated(List) 
   */ 
  public String getSuffixAsSingleString() { 
    return joinStringsSpaceSeparated(getSuffix()); 
  } 

  /** 
   * Returns all of the components of the name (prefix, given, family, suffix) as a single string with a single spaced 
   * string separating each part. 
   * <p> 
   * If none of the parts are populated, returns the {@link #getTextElement() text} element value instead. 
   * </p> 
   */ 
  public String getNameAsSingleString() { 
    List<StringType> nameParts = new ArrayList<StringType>(); 
    nameParts.addAll(getPrefix()); 
    nameParts.addAll(getGiven()); 
    nameParts.add(getFamilyElement()); 
    nameParts.addAll(getSuffix()); 
    if (nameParts.size() > 0) { 
      return joinStringsSpaceSeparated(nameParts); 
    } else { 
      return getTextElement().getValue(); 
    } 
  } 

  /** 
   * Joins a list of strings with a single space (' ') between each string 
   *  
   * TODO: replace with call to ca.uhn.fhir.util.DatatypeUtil.joinStringsSpaceSeparated when HAPI upgrades to 1.4 
   */ 
  private static String joinStringsSpaceSeparated(List<? extends IPrimitiveType<String>> theStrings) { 
    StringBuilder b = new StringBuilder(); 
    for (IPrimitiveType<String> next : theStrings) { 
      if (next.isEmpty()) { 
        continue; 
      } 
      if (b.length() > 0) { 
        b.append(' '); 
      } 
      b.append(next.getValue()); 
    } 
    return b.toString(); 
  }