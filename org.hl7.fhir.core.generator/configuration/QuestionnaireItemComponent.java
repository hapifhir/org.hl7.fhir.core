public QuestionnaireItemComponent getQuestion(String linkId) {
        if (linkId == null)
          return null;
        for (QuestionnaireItemComponent i : getItem()) {
          if (i.getLinkId().equals(linkId))
            return i;
          QuestionnaireItemComponent t = i.getQuestion(linkId);
          if (t != null)
            return t;
        }
        return null;
      }

      public QuestionnaireItemComponent getCommonGroup(QuestionnaireItemComponent q1, QuestionnaireItemComponent q2) {
        if (q1 == null || q2 == null)
          return null;
        for (QuestionnaireItemComponent i : getItem()) {
          QuestionnaireItemComponent t = i.getCommonGroup(q1, q2);
          if (t != null)
            return t;
        }
        if (containsQuestion(q1) && containsQuestion(q2))
          return this;
        return null;
      }

      public boolean containsQuestion(QuestionnaireItemComponent q) {
        if (q == this)
          return true;
        for (QuestionnaireItemComponent i : getItem()) {
          if (i.containsQuestion(q))
            return true;
        }
        return false;
      }