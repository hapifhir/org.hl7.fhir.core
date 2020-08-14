@Override
      public String getVersion() {
        return null;
      }

      @Override
      public boolean hasVersion() {
        return false;
      }

      @Override
      public boolean supportsVersion() {
        return false;
      }

      @Override
      public String getDisplay() {
        return null;
      }

      @Override
      public boolean hasDisplay() {
        return false;
      }

      @Override
      public boolean supportsDisplay() {
        return false;
      }

   public static Quantity fromUcum(String v, String code) {
      Quantity res = new Quantity();
      res.setValue(new BigDecimal(v));
      res.setSystem("http://unitsofmeasure.org");
      res.setCode(code);
      return res;
    }