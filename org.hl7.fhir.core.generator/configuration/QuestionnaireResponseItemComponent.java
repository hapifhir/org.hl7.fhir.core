
    public UriType getDefinitionElement() {
      return definitionList != null && definitionList.size() > 0 ? definitionList.get(0) : null;
    }

    public String getDefinition() {
      return definitionList != null && definitionList.size() > 0 ? definitionList.get(0).getValue() : null;
    }