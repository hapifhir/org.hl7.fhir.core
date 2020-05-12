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