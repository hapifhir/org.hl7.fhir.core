
public ElementDefinition getElementByPath(String path) {
  for (ElementDefinition ed : getElement()) {
    if (path.equals(ed.getPath())) {
      return ed;
    }
  }
  return null;
}
