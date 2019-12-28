 
  public boolean hasCoding(String system, String code) {
    for (Coding c : getCoding()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode()))
        return true;
    }
    return false;
  } 

  public CodeableConcept(Coding code) {
    super();
    addCoding(code);
  }
  
  
