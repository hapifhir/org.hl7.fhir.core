public String describeType() {
    if ("Extension".equals(getType()))
      return "Extension" ;
    switch (getKind()) {
    case COMPLEXTYPE: return getDerivation() == TypeDerivationRule.CONSTRAINT ? "DataType Constraint" : "DataType" ;
    case LOGICAL: return getDerivation() == TypeDerivationRule.CONSTRAINT ? "Logical Model" : "Logical Model Profile";
    case PRIMITIVETYPE: return getDerivation() == TypeDerivationRule.CONSTRAINT ? "PrimitiveType Constraint" : "PrimitiveType";
    case RESOURCE: return getDerivation() == TypeDerivationRule.CONSTRAINT ? "Resource Profile" : "Resource";
    default:
      return "Definition";
    }
  }


  public String getTypeName() { 
    String t = getType(); 
    return StructureDefinitionKind.LOGICAL.equals(getKind()) && t.contains("/") ? t.substring(t.lastIndexOf("/")+1) : t; 
  } 

  public String getTypeTail() { 
    if (getType().contains("/")) { 
      return getType().substring(getType().lastIndexOf("/")+1); 
    } else { 
      return getType(); 
    } 
  }

  private boolean generatedSnapshot;
  private boolean generatingSnapshot;

  public boolean isGeneratedSnapshot() {
    return generatedSnapshot;
  }

  public void setGeneratedSnapshot(boolean generatedSnapshot) {
    this.generatedSnapshot = generatedSnapshot;
  }

  public boolean isGeneratingSnapshot() {
    return generatingSnapshot;
  }

  public void setGeneratingSnapshot(boolean generatingSnapshot) {
    this.generatingSnapshot = generatingSnapshot;
  }
