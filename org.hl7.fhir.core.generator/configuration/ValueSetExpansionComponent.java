
      public boolean hasParameterValue(String name, String value) {
        for (ValueSetExpansionParameterComponent p : getParameterList()) {
          if (name.equals(p.getName()) && p.hasValue() && value.equals(p.getValue().primitiveValue())) {
            return true;
          }
        }
        return false;
      }


      public void addParameter(String name, DataType value) {
        getParameterList().add(new ValueSetExpansionParameterComponent(name).setValue(value));
      }