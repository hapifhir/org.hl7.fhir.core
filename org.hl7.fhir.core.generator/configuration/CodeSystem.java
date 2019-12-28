  public PropertyComponent getProperty(String code) {
    for (PropertyComponent pd : getProperty()) {
      if (pd.getCode().equalsIgnoreCase(code))
        return pd;
    }
    return null;
  }
