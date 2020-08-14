public String toCode(int len) {
          return toCode().substring(0, len);
        }

        public static boolean isR4Plus(String version) {
           return version != null && (version.startsWith("4.") || version.startsWith("5.") || "current".equals(version));
        }
        
       public static boolean isValidCode(String codeString) {
          if (codeString == null || "".equals(codeString))
              return false;
      if ("0.01".equals(codeString))
        return true;
      if ("0.05".equals(codeString))
        return true;
      if ("0.06".equals(codeString))
        return true;
      if ("0.11".equals(codeString))
        return true;
      if ("0.0.80".equals(codeString))
        return true;
      if ("0.0.81".equals(codeString))
        return true;
      if ("0.0.82".equals(codeString))
        return true;
      if ("0.4.0".equals(codeString))
        return true;
      if ("0.5.0".equals(codeString))
        return true;
      if ("1.0.0".equals(codeString))
        return true;
      if ("1.0.1".equals(codeString))
        return true;
      if ("1.0.2".equals(codeString))
        return true;
      if ("1.1.0".equals(codeString))
        return true;
      if ("1.4.0".equals(codeString))
        return true;
      if ("1.6.0".equals(codeString))
        return true;
      if ("1.8.0".equals(codeString))
        return true;
      if ("3.0.0".equals(codeString))
        return true;
      if ("3.0.1".equals(codeString))
        return true;
      if ("3.3.0".equals(codeString))
        return true;
      if ("3.5.0".equals(codeString))
        return true;
      if ("4.0.0".equals(codeString))
        return true;
      if ("4.2.0".equals(codeString))
        return true;
      return false;
      }

        @Override
        public String toString() {
          return toCode();
        }