      public String getSymbol() {
        switch (this) {
          case RELATEDTO:
            return "-";
          case EQUIVALENT:
            return "=";
          case SOURCEISNARROWERTHANTARGET:
            return "<";
          case SOURCEISBROADERTHANTARGET:
            return ">";
          case NOTRELATEDTO:
            return "!=";
          case NULL:
            return null;
          default:
            return "?";
        }
      }
