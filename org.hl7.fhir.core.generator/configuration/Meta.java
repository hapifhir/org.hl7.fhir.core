/** 
     * Convenience method which adds a tag 
     *  
     * @param theSystem The code system 
     * @param theCode The code 
     * @param theDisplay The display name 
     * @return Returns a reference to <code>this</code> for easy chaining 
     */ 
    public Meta addTag(String theSystem, String theCode, String theDisplay) { 
     addTag().setSystem(theSystem).setCode(theCode).setDisplay(theDisplay); 
     return this; 
    } 

   /**
   * Returns the first tag (if any) that has the given system and code, or returns 
   * <code>null</code> if none 
   */
  public Coding getTag(String theSystem, String theCode) { 
    for (Coding next : getTag()) {
      if (ca.uhn.fhir.util.ObjectUtil.equals(next.getSystem(), theSystem) && ca.uhn.fhir.util.ObjectUtil.equals(next.getCode(), theCode)) { 
        return next; 
      } 
    }
    return null; 
  } 

  /**
   * Returns the first security label (if any) that has the given system and code, or returns 
   * <code>null</code> if none 
   */
  public Coding getSecurity(String theSystem, String theCode) { 
    for (Coding next : getSecurity()) {
      if (ca.uhn.fhir.util.ObjectUtil.equals(next.getSystem(), theSystem) && ca.uhn.fhir.util.ObjectUtil.equals(next.getCode(), theCode)) { 
        return next; 
      } 
    }
    return null; 
  }