  
  public String toString() {
    if (hasId())
      return getId();
    if (hasSliceName())
      return getPath()+":"+getSliceName();
    else
      return getPath();
  }
    
  public void makeBase(String path, int min, String max) {
    ElementDefinitionBaseComponent self = getBase();
    self.setPath(path);
    self.setMin(min);
    self.setMax(max);
  }
  
  public void makeBase() {
    ElementDefinitionBaseComponent self = getBase();
    self.setPath(getPath());
    self.setMin(getMin());
    self.setMax(getMax());
  }
  
  
  
  public String typeSummary() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (TypeRefComponent tr : type) {
      if (tr.hasCode())
        b.append(tr.getCode());
    }
    return b.toString();
   }
  
  public TypeRefComponent getType(String code) {
    for (TypeRefComponent tr : getType()) 
      if (tr.getCode().equals(code))
        return tr;
    TypeRefComponent tr = new TypeRefComponent();
    tr.setCode(code);
    type.add(tr);
    return tr;
  }

  public static final boolean NOT_MODIFIER = false;
  public static final boolean NOT_IN_SUMMARY = false;
  public static final boolean IS_MODIFIER = true;
  public static final boolean IS_IN_SUMMARY = true;
  public ElementDefinition(boolean defaults, boolean modifier, boolean inSummary) {
    super();
    if (defaults) {
      setIsModifier(modifier);
      setIsSummary(inSummary);
    }
  }  

 public String present() {
    return hasId() ? getId() : getPath();
  }

  public boolean hasCondition(IdType id) {
    for (IdType c : getCondition()) {
      if (c.primitiveValue().equals(id.primitiveValue()))
        return true;
    }
    return false;
  }

  public boolean hasConstraint(String key) {
    for (ElementDefinitionConstraintComponent c : getConstraint()) {
      if (c.getKey().equals(key))
        return true;
    }
    return false;
  }

  public boolean hasCode(Coding c) {
    for (Coding t : getCode()) {
      if (t.getSystem().equals(c.getSystem()) && t.getCode().equals(c.getCode()))
        return true;
    }
    return false;
  }  

  public boolean isChoice() {
    return getPath().endsWith("[x]");
  }  


