/** 
  /** 
   * Returns all repetitions of {@link #getGivenList() given name} as a space separated string 
   *  
   * @see DatatypeUtil#joinStringsSpaceSeparated(List) 
   */ 
  public String getGivenAsSingleString() { 
    return joinStringsSpaceSeparated(getGivenList()); 
  } 

  /** 
   * Returns all repetitions of {@link #getPrefixList() prefix name} as a space separated string 
   *  
   * @see DatatypeUtil#joinStringsSpaceSeparated(List) 
   */ 
  public String getPrefixAsSingleString() { 
    return joinStringsSpaceSeparated(getPrefixList()); 
  } 

  /** 
   * Returns all repetitions of {@link #getSuffixList() suffix} as a space separated string 
   *  
   * @see DatatypeUtil#joinStringsSpaceSeparated(List) 
   */ 
  public String getSuffixAsSingleString() { 
    return joinStringsSpaceSeparated(getSuffixList()); 
  } 

  /** 
   * Returns the name as a single string. 
   * <p> 
   * If {@link #getTextElement() text} is populated it is returned as-is - text is the name as it should be 
   * presented, and takes precedence over the parts. Otherwise the components that are present (prefix, given, 
   * family, suffix) are joined with a single space between each part. 
   * </p> 
   */ 
  public String getNameAsSingleString() { 
    if (hasText()) { 
      return getText(); 
    } 

    List<StringType> nameParts = new ArrayList<StringType>(); 
    nameParts.addAll(getPrefixList()); 
    nameParts.addAll(getGivenList()); 
    if (hasFamilyElement()) { 
      nameParts.add(getFamilyElement()); 
    } 
    nameParts.addAll(getSuffixList()); 
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