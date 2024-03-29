public Parameters addParameter(String name, boolean b) {
  addParameter().setName(name).setValue(new BooleanType(b));
  return this;
}

public Parameters addParameter(String name, String s) {
  if (s != null)
    addParameter().setName(name).setValue(new StringType(s));
  return this;
}

public Parameters addParameter(String name, DataType v) {
  if (v != null)
    addParameter().setName(name).setValue(v);
  return this;
}

public Parameters setParameter(String name, boolean b) {
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name)) {
      p.setValue(new BooleanType(b));
      return this;
    }
  }
  addParameter().setName(name).setValue(new BooleanType(b));
  return this;
}

public Parameters setParameter(String name, String s) {
  if (s != null) {
    for (ParametersParameterComponent p : getParameter()) {
      if (p.getName().equals(name)) {
        p.setValue(new StringType(s));
        return this;
      }
    }
    addParameter().setName(name).setValue(new StringType(s));
  }
  return this;
}

public Parameters setParameter(String name, DataType v) {
  if (v != null) {
    for (ParametersParameterComponent p : getParameter()                                                                                     ) {
      if (p.getName().equals(name)) {
        p.setValue(v);
        return this;
      }
    }
    addParameter().setName(name).setValue(v);
  }
  return this;
}

public boolean hasParameterValue(String name) {
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name) && p.hasValue())
      return true;
  }
  return false;
}

public boolean hasParameter(String name) {
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name))
      return true;
  }
  return false;
}

public DataType getParameterValue(String name) {
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name))
      return p.getValue();
  }
  return null;
}

public ParametersParameterComponent getParameter(String name) {
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name))
      return p;
  }
  return null;
}

public List<DataType> getParameterValues(String name) {
  List<DataType> res = new ArrayList<>();
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name))
      res.add(p.getValue());
  }
  return res;
}

public List<ParametersParameterComponent> getParameters(String name) {
  List<ParametersParameterComponent> res = new ArrayList<ParametersParameterComponent>();
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name))
      res.add(p);
  }
  return res;
}

public boolean getParameterBool(String name) {
  for (ParametersParameterComponent p : getParameter()) {
    if (p.getName().equals(name)) {
      if (p.getValue() instanceof BooleanType)
        return ((BooleanType) p.getValue()).booleanValue();
      boolean ok = Boolean.getBoolean(p.getValue().primitiveValue());
      return ok;
    }
  }
  return false;
}