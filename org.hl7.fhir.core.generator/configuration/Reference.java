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