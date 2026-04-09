package org.hl7.fhir.utilities;

public class HTMLUtilities {

  private HTMLUtilities() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  public static boolean containsHtmlTags(String input) {
    int tagStart = input.indexOf("<");
    while (tagStart > -1) {
      input = input.substring(tagStart+1);
      tagStart = input.indexOf("<");
      int tagEnd = input.indexOf(">");
      if (tagEnd > -1 && tagEnd < tagStart) {
        String tagContent = input.substring(0, tagEnd);
        if (looksLikeHtmlTag(tagContent)) {
          return true;
        }
      }
    }
    return false;
  }

  // Returns true if tagContent is a tag name with optional attributes
  private static boolean looksLikeHtmlTag(String tagContent) {
    if (tagContent.isEmpty() || !Character.isLetter(tagContent.charAt(0))) {
      return false;
    }
    int pos = 1;
    while (pos < tagContent.length() && (Character.isLetterOrDigit(tagContent.charAt(pos)) || tagContent.charAt(pos) == '_')) {
      pos++;
    }
    return pos == tagContent.length() || Character.isWhitespace(tagContent.charAt(pos));
  }
}
