public boolean hasCoding(String system, String code) {
    for (Coding c : getCodingList()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode()))
        return true;
    }
    return false;
  }

  public CodeableConcept(IModelContext modelContext, Coding code) {
    super();
    this.modelContext = modelContext;
    addCoding(code);
  }

  public CodeableConcept(Coding code) {
    super();
    addCoding(code);
  }


  public boolean matches(CodeableConcept other) {
    for (Coding c : other.getCodingList()) {
      if (hasCoding(c.getSystem(), c.getCode())) {
        return true;
      }
    }
    return false;
  }

  public boolean hasCoding(Coding coding) {
    return hasCoding(coding.getSystem(), coding.getCode());
  }
  
 public boolean hasCoding(String system) {
    for (Coding c : getCodingList()) {
      if (system.equals(c.getSystem())) {
        return true;
      }
    }
    return false;
  }

  public String getCode(String system) {
    for (Coding c : getCodingList()) {
      if (system.equals(c.getSystem())) {
        return c.getCode();
      }
    }
    return null;
  }

  public static CodeableConcept merge(CodeableConcept l, CodeableConcept r) {
    CodeableConcept res = new CodeableConcept();
    List<Coding> handled = new ArrayList<>();
    for (Coding c : l.getCodingList()) {
      boolean done = false;
      for (Coding t : r.getCodingList()) {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //False positive: not using String.matches
        boolean codesMatch = t.matches(c);
        if (codesMatch) {
          handled.add(t);
          res.getCodingList().add(Coding.merge(c, t));
          done = true;
          break;
        }
      }
      if (!done) {
       res.getCodingList().add(c.copy(Base.COPY_DATA));
      }
    }
    for (Coding c : r.getCodingList()) {
      if (!handled.contains(c)) {
        res.getCodingList().add(c);
      }
    }
    if (l.hasText()) {
      res.setText(l.getText());
    } else {
      res.setText(r.getText());
    }
    return res;
  }

  public static CodeableConcept intersect(CodeableConcept l, CodeableConcept r) {
    CodeableConcept res = new CodeableConcept();
    for (Coding c : l.getCodingList()) {
      for (Coding t : r.getCodingList()) {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //False positive: not using String.matches
        boolean codesMatch = t.matches(c);
        if (codesMatch) {
          res.getCodingList().add(Coding.intersect(c, t));
          break;
        }
      }
    }
    if (l.hasText() && r.hasText() && l.getText().equals(r.getText())) {
      res.setText(l.getText());
    }
    return res;
  }
    
  public void addCoding(String system, String code, String display) {
    getCodingList().add(new Coding(system, code, display));
  }
  
  @Override 
  public String toString() { 
    return hasCoding() ? getCodingList().toString() : "["+getText()+"]";
  }


  public void removeCoding(String system, String version, String code) {
    getCodingList().removeIf(c ->
      (system == null || system.equals(c.getSystem())) &&
        (version == null || version.equals(c.getVersion())) &&
        (code == null || code.equals(c.getCode())));
  }
