@Override
      public boolean supportsVersion() {
        return true;
      }

      @Override
      public boolean supportsDisplay() {
        return true;
      }


      public boolean is(String system, String code) {
        return hasSystem() && hasCode() &&  this.getSystem().equals(system) && this.getCode().equals(code);
      }
      
      public String toString() {
        String base = hasSystem() ? getSystem() : "";
        if (hasVersion())
          base = base+"|"+getVersion();
        base = base + "#"+getCode();
        if (hasDisplay())
          base = base+": '"+getDisplay()+"'";
        return base;
        
      } 
      

      public boolean matches(Coding other) {
        return other.hasCode() && this.hasCode() && other.hasSystem() && this.hasSystem() && this.getCode().equals(other.getCode()) && this.getSystem().equals(other.getSystem()) ;
      }
      

      public static Coding merge(Coding l, Coding r) {
        Coding res = new Coding();
        if (l.hasSystem()) {
          res.setSystem(l.getSystem());
        } else {
          res.setSystem(r.getSystem());
        }
        if (l.hasVersion()) {
          res.setVersion(l.getVersion());
        } else {
          res.setVersion(r.getVersion());
        }
        if (l.hasCode()) {
          res.setCode(l.getCode());
        } else {
          res.setCode(r.getCode());
        }
        if (l.hasDisplay()) {
          res.setDisplay(l.getDisplay());
        } else {
          res.setDisplay(r.getDisplay());
        }
        if (l.hasUserSelected()) {
          res.setUserSelected(l.getUserSelected());
        } else {
          res.setUserSelected(r.getUserSelected());
        }
        return res;
      }

      public static Coding intersect(Coding l, Coding r) {
        Coding res = new Coding();
        if (l.hasSystem() && l.getSystem().equals(r.getSystem())) {
          res.setSystem(l.getSystem());
        }
        if (l.hasVersion() && l.getVersion().equals(r.getVersion())) {
          res.setVersion(l.getVersion());
        }
        if (l.hasCode() && l.getCode().equals(r.getCode())) {
          res.setCode(l.getCode());
        }
        if (l.hasDisplay() && l.getDisplay().equals(r.getDisplay())) {
          res.setDisplay(l.getDisplay());
        }
        if (l.hasUserSelected() && l.getUserSelected() == r.getUserSelected()) {
          res.setUserSelected(l.getUserSelected());
        }
        return res;
      } 
            
      public Coding(IModelContext modelContext, String theSystem, String theVersion, String theCode, String theDisplay) {
        this.modelContext = modelContext;
        setSystem(theSystem);
        setVersion(theVersion);
        setCode(theCode);
        setDisplay(theDisplay);
      }
    public Coding(String theSystem, String theVersion, String theCode, String theDisplay) {
      setSystem(theSystem);
      setVersion(theVersion);
      setCode(theCode);
      setDisplay(theDisplay);
    }
    public Coding(String theSystem, String theCode, String theDisplay) {
      setSystem(theSystem);
      setCode(theCode);
      setDisplay(theDisplay);
    }


  public static Coding fromLiteral(String value) {
    String sv = value.contains("#") ? value.substring(0, value.indexOf("#")) : value;
    String cp = value.contains("#") ? value.substring(value.indexOf("#")+1) : null;

    String system = sv.contains("|") ? sv.substring(0, sv.indexOf("|")) : sv;
    String version = sv.contains("|") ? sv.substring(sv.indexOf("|")+1) : null;

    String code = cp != null && cp.contains("'") ? cp.substring(0, cp.indexOf("'")) : cp;
    String display = cp != null && cp.contains("'") ? cp.substring(cp.indexOf("'")+1) : null;
    if (display != null) {
      display = display.trim();
      display = display.substring(0, display.length() -1);
    }
    if ((system == null || !Utilities.isAbsoluteUrl(system)) && code == null) {
      return null;
    } else {
      return new Coding(system, version, code, display);
    }
  }

