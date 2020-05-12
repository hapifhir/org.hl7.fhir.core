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
    for (QuestionnaireItemComponent i : getItem()) {
      QuestionnaireItemComponent t = i.getCommonGroup(q1, q2);
      if (t != null)
        return t;
    }
    return null;
  }