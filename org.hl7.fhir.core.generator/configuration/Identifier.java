
  public boolean valueMatches(Identifier other) {
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //system and value are identifiers/URLs; safe
    boolean result = hasSystem() && hasValue() && getSystem().matches(other.getSystem()) && getValue().matches(other.getValue());
    return result;
  }