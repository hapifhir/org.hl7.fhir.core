@Override
      public String toString() {
        return fhirType()+"["+getUrl()+"]";
      }
      
      public String present() {
        if (hasTitle())
          return getTitle();
        if (hasName())
          return getName();
        return toString();
      }