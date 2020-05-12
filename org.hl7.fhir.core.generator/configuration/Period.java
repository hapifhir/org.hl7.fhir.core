/**
   * Sets the value for <b>start</b> () 
   *
     * <p>
     * <b>Definition:</b>
     * The start of the period. The boundary is inclusive. 
     * </p>  
   */
  public Period setStart( Date theDate,  TemporalPrecisionEnum thePrecision) { 
    start = new DateTimeType(theDate, thePrecision);  
    return this;  
  } 

   /**
   * Sets the value for <b>end</b> () 
   *
     * <p>
     * <b>Definition:</b>
     * The end of the period. The boundary is inclusive. 
     * </p>  
   */
  public Period setEnd( Date theDate,  TemporalPrecisionEnum thePrecision) { 
    end = new DateTimeType(theDate, thePrecision);  
    return this;  
  }