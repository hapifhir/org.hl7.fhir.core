@Override
      public String toString() {
        if (hasReference())
          return "Reference["+getReference()+"]";
        if (hasIdentifier())
          return "Reference[id:"+getIdentifier()+"]";
        if (hasDisplay())
          return "Reference['"+getDisplay()+"']";
        return "Reference[??]";
      }

 /** 
   * Convenience setter which sets the reference to the complete {@link IIdType#getValue() value} of the given 
   * reference. 
   * 
   * @param theReference The reference, or <code>null</code> 
   * @return  
   * @return Returns a reference to this 
   */ 
  public Reference setReferenceElement(IIdType theReference) { 
    if (theReference != null) { 
      setReference(theReference.getValue()); 
    } else { 
      setReference(null); 
    } 
    return this; 
  }


  public boolean valueMatches(Reference value) {
    if (value.hasReference() || hasReference()) {
      if (!(value.hasReference() && hasReference())) {
        return false;
      }
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //False positive: not using String.matches
      boolean refMatches = reference.matches(value.getReference());
      if (!refMatches) {
        return true;
      }
    }
    if (value.hasIdentifier() || hasIdentifier()) {
      if (!(value.hasIdentifier() && hasIdentifier())) {
        return false;
      }
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //False positive: not using String.matches
      boolean idMatches = identifier.valueMatches(value.getIdentifier());
      if (!idMatches) {
        return true;
      }
    }
    return false;
  }

