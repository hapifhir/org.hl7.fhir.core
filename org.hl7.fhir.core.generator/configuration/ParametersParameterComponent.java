public String toString() {
    String s = getName() + " = ";
    if (hasValue()) {
      if (getValue().isPrimitive()) {
        s = s + getValue().primitiveValue();
      } else {
        s = s + "["+getValue().fhirType()+"]";
      }
    } else if (hasResource()) {
      s = s + "["+getResource().fhirType()+"]";
    } else {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (ParametersParameterComponent p : getPart()) {
        b.append(p.getName());
      }
      s = s + "{"+b.toString()+"}";
    }
    return s;
  }