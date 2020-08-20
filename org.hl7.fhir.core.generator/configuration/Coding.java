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
        String base = getSystem();
        if (hasVersion())
          base = base+"|"+getVersion();
        base = base + "#"+getCode();
        if (hasDisplay())
          base = base+": "+getDisplay();
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
            