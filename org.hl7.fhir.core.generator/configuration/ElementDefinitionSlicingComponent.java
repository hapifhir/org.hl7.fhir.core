
  public String summary() {
    StringBuilder b = new StringBuilder();
    if (!hasRulesElement() && !hasOrdered() && !hasDiscriminator()) {
      return "(no slicing)";
    }
    if (hasRulesElement() || hasOrdered()) {
      if (hasRulesElement() && hasOrdered()) {
        b.append((getOrdered() ? "ordererd : "unordered")+" and " +getRules().toCode()+", by");
      } else if (hasRules()) {
        b.append(getRules().toCode()+", by");
      } else if (getOrdered()) {
        b.append("ordered, by");
      } else {
        b.append("unordered, by");            
      }
    } 
    boolean first = true;
    for (ElementDefinitionSlicingDiscriminatorComponent d : getDiscriminatorList()) {
      if (first) {
        first = false;
      } else {
        b.append(",");
      }
      b.append(" ");
      b.append(d.getType().toCode());
      b.append("=");
      b.append(d.getPath());
    }
    return b.toString();
  }
