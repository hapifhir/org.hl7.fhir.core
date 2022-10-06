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
  
 public boolean hasCoding(String system) {
    for (Coding c : getCoding()) {
      if (system.equals(c.getSystem())) {
        return true;
      }
    }
    return false;
  }

  public String getCode(String system) {
    for (Coding c : getCoding()) {
      if (system.equals(c.getSystem())) {
        return c.getCode();
      }
    }
    return null;
  }

  public static CodeableConcept merge(CodeableConcept l, CodeableConcept r) {
    CodeableConcept res = new CodeableConcept();
    List<Coding> handled = new ArrayList<>();
    for (Coding c : l.getCoding()) {
      boolean done = false;
      for (Coding t : r.getCoding()) {
        if (t.matches(c)) {
          handled.add(t);
          res.getCoding().add(Coding.merge(c, t));
          done = true;
          break;
        }
      }
      if (!done) {
       res.getCoding().add(c.copy());
      }
    }
    for (Coding c : r.getCoding()) {
      if (!handled.contains(c)) {
        res.getCoding().add(c);
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
    for (Coding c : l.getCoding()) {
      for (Coding t : r.getCoding()) {
        if (t.matches(c)) {
          res.getCoding().add(Coding.intersect(c, t));
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
    getCoding().add(new Coding(system, code, display));
  }
  
  @Override 
  public String toString() { 
    return hasCoding() ? getCoding().toString() : "["+getText()+"]"; 
  } 
   