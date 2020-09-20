      public ContactPoint getEmail() {
        for (ContactPoint cp : getTelecom()) {
          if (cp.getSystem() == ContactPointSystem.EMAIL) {
            return cp;
          }
        }
        return null;
      }

      public ContactPoint getPhone() {
        for (ContactPoint cp : getTelecom()) {
          if (cp.getSystem() == ContactPointSystem.PHONE) {
            return cp;
          }
        }
        return null;
      }

      public ContactPoint getUrl() {
        for (ContactPoint cp : getTelecom()) {
          if (cp.getSystem() == ContactPointSystem.URL) {
            return cp;
          }
        }
        return null;
      }
