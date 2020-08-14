/** 
   * Returns the {@link #getLink() link} which matches a given {@link BundleLinkComponent#getRelation() relation}.  
   * If no link is found which matches the given relation, returns <code>null</code>. If more than one 
   * link is found which matches the given relation, returns the first matching BundleLinkComponent. 
   *  
   * @param theRelation 
   *            The relation, such as \"next\", or \"self. See the constants such as {@link IBaseBundle#LINK_SELF} and {@link IBaseBundle#LINK_NEXT}. 
   * @return Returns a matching BundleLinkComponent, or <code>null</code> 
   * @see IBaseBundle#LINK_NEXT 
   * @see IBaseBundle#LINK_PREV 
   * @see IBaseBundle#LINK_SELF 
   */ 
  public BundleLinkComponent getLink(String theRelation) { 
    org.apache.commons.lang3.Validate.notBlank(theRelation, "theRelation may not be null or empty"); 
    for (BundleLinkComponent next : getLink()) { 
      if (theRelation.equals(next.getRelation())) { 
        return next; 
      } 
    } 
    return null; 
  } 

  /** 
   * Returns the {@link #getLink() link} which matches a given {@link BundleLinkComponent#getRelation() relation}.  
   * If no link is found which matches the given relation, creates a new BundleLinkComponent with the 
   * given relation and adds it to this Bundle. If more than one 
   * link is found which matches the given relation, returns the first matching BundleLinkComponent. 
   *  
   * @param theRelation 
   *            The relation, such as \"next\", or \"self. See the constants such as {@link IBaseBundle#LINK_SELF} and {@link IBaseBundle#LINK_NEXT}. 
   * @return Returns a matching BundleLinkComponent, or <code>null</code> 
   * @see IBaseBundle#LINK_NEXT 
   * @see IBaseBundle#LINK_PREV 
   * @see IBaseBundle#LINK_SELF 
   */ 
  public BundleLinkComponent getLinkOrCreate(String theRelation) { 
    org.apache.commons.lang3.Validate.notBlank(theRelation, "theRelation may not be null or empty"); 
    for (BundleLinkComponent next : getLink()) { 
      if (theRelation.equals(next.getRelation())) { 
        return next; 
      } 
    } 
    BundleLinkComponent retVal = new BundleLinkComponent(); 
    retVal.setRelation(theRelation); 
    getLink().add(retVal); 
    return retVal; 
  }