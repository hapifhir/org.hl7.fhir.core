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
  
  
  public boolean matches(CodeableConcept other) {
    for (Coding c : other.getCoding()) {
      if (hasCoding(c.getSystem(), c.getCode())) {
        return true;
      }
    }
    return false;
  }

  public boolean hasCoding(Coding coding) {
    return hasCoding(coding.getSystem(), coding.getCode());
  }