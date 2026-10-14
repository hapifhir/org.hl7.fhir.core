
  public String toString() {
    return (type == null ? "??" : type.getCode()) + "="+(path == null ? "??" : path.asStringValue());
  }
