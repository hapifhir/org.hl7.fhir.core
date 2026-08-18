
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
    for (TypeRefComponent tr : getTypeList()) {
      if (tr.hasCode())
        b.append(tr.getWorkingCode());
    }
    return b.toString();
  }
  
  public String typeSummaryVB() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|");
    for (TypeRefComponent tr : getTypeList()) {
      if (tr.hasCode())
        b.append(tr.getWorkingCode());
    }
    return b.toString().replace(" ", "");
  }
  
  public TypeRefComponent getType(String code) {
    for (TypeRefComponent tr : getTypeList()) 
      if (tr.getCode().equals(code))
        return tr;
    TypeRefComponent tr = new TypeRefComponent();
    tr.setCode(code);
    getTypeList().add(tr);
    return tr;
  }

  public static final boolean NOT_MODIFIER = false;
  public static final boolean NOT_IN_SUMMARY = false;
  public static final boolean IS_MODIFIER = true;
  public static final boolean IS_IN_SUMMARY = true;
  public ElementDefinition(IModelContext modelContext, boolean defaults, boolean modifier, boolean inSummary) {
    super();
    this.modelContext = modelContext;
    if (defaults) {
      setIsModifier(modifier);
      setIsSummary(inSummary);
    }
  }  

 public String present() {
    return hasId() ? getId() : getPath();
  }

  public boolean hasCondition(IdType id) {
    for (IdType c : getConditionList()) {
      if (c.primitiveValue().equals(id.primitiveValue()))
        return true;
    }
    return false;
  }

  public boolean hasConstraint(String key) {
    for (ElementDefinitionConstraintComponent c : getConstraintList()) {
      if (c.getKey().equals(key))
        return true;
    }
    return false;
  }

  public boolean hasCode(Coding c) {
    for (Coding t : getCodeList()) {
      if (t.getSystem().equals(c.getSystem()) && t.getCode().equals(c.getCode()))
        return true;
    }
    return false;
  }  

  public boolean isChoice() {
    return getPath().endsWith("[x]");
  }  

  public String getName() {
    return hasPath() ? getPath().contains(".") ? getPath().substring(getPath().lastIndexOf(".")+1) : getPath() : null;
  }
  
  public String getNameBase() {
    return getName().replace("[x]", "");
  }

  public boolean unbounded() {
    return getMax().equals("*") || Integer.parseInt(getMax()) > 1;
  }

  public boolean repeats() {
    return !Utilities.existsInList(getMax(), "0", "1");
  }

  public int getMaxAsInt() {
    return "*".equals(getMax()) ? Integer.MAX_VALUE : Integer.parseInt(getMax());
  }

  public boolean isMandatory() {
    return getMin() > 0;
  }

  public boolean isInlineType() {
    return getTypeList().size() == 1 && Utilities.existsInList(getTypeList().get(0).getCode(), "Element", "BackboneElement");
  }  


  public boolean prohibited() { 
    return "0".equals(getMax()); 
  } 

  public boolean hasFixedOrPattern() { 
    return hasFixed() || hasPattern(); 
  } 

  public DataType getFixedOrPattern() { 
    return hasFixed() ? getFixed() : getPattern(); 
  } 

  public boolean isProhibited() { 
    return "0".equals(getMax()); 
  }   

  public boolean isRequired() { 
    return getMin() == 1; 
  }

  public String getIdOrPath() {
    return hasId() ? getId() : getPath();
  }

  public boolean hasObligations() {
    boolean res = hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE);
    for (TypeRefComponent tr : getTypeList()) {
      res = res || tr.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE);
    }
    return res;
  }

  public boolean isProfiledExtension() {
    return getTypeList().size() == 1 && "Extension".equals(getTypeFirstRep().getCode()) &&
      getTypeFirstRep().getProfileList().size() == 1;
  }