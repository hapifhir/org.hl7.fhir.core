package org.hl7.fhir.utilities;

import java.util.ArrayList;
import java.util.List;

public class SemverParser {
  private final String input;
  private int pos;
  private final List<String> parts;
  private final boolean allowWildcards;
  private final boolean requirePatch;

  public SemverParser(String input) {
    this(input, false, true);
  }

  public SemverParser(String input, boolean allowWildcards) {
    this(input, allowWildcards, true);
  }

  public SemverParser(String input, boolean allowWildcards, boolean requirePatch) {
    this.input = input;
    this.pos = 0;
    this.parts = new ArrayList<>();
    this.allowWildcards = allowWildcards;
    this.requirePatch = requirePatch;
  }

  public static class ParseResult {
    private final List<String> parts;
    private final String error;

    private ParseResult(List<String> parts, String error) {
      this.parts = parts;
      this.error = error;
    }

    public static ParseResult success(List<String> parts) {
      return new ParseResult(new ArrayList<>(parts), null);
    }

    public static ParseResult error(String error) {
      return new ParseResult(null, error);
    }

    public boolean isSuccess() {
      return error == null;
    }

    public List<String> getParts() {
      return parts;
    }

    public String getError() {
      return error;
    }

    // Semantic accessor methods
    public String getMajor() {
      if (!isSuccess() || parts.isEmpty()) {
        return null;
      }
      return parts.get(0);
    }

    public String getMinor() {
      if (!isSuccess() || parts.size() < 3) {
        return null;
      }
      // parts[0]=major, parts[1]=".", parts[2]=minor
      return parts.get(2);
    }

    public String getPatch() {
      if (!isSuccess() || parts.size() < 5) {
        return null;
      }
      // Check if we actually have a patch: parts[0]=major, parts[1]=".", parts[2]=minor, parts[3]=".", parts[4]=patch
      // If parts[3] is not ".", then there's no patch (e.g., "1.2-alpha" has "-" at parts[3])
      if (!".".equals(parts.get(3))) {
        return null;
      }
      return parts.get(4);
    }

    public String getReleaseLabel() {
      if (!isSuccess()) {
        return null;
      }

      // Find the "-" separator
      int dashIndex = -1;
      for (int i = 0; i < parts.size(); i++) {
        if ("-".equals(parts.get(i))) {
          dashIndex = i;
          break;
        }
      }

      if (dashIndex == -1) {
        return null; // No pre-release
      }

      // Find the "+" separator (if any)
      int plusIndex = parts.size(); // Default to end of parts
      for (int i = dashIndex + 1; i < parts.size(); i++) {
        if ("+".equals(parts.get(i))) {
          plusIndex = i;
          break;
        }
      }

      // Reconstruct the release label from parts between "-" and "+"
      StringBuilder sb = new StringBuilder();
      for (int i = dashIndex + 1; i < plusIndex; i++) {
        sb.append(parts.get(i));
      }

      return sb.length() > 0 ? sb.toString() : null;
    }

    public String getBuild() {
      if (!isSuccess()) {
        return null;
      }

      // Find the "+" separator
      int plusIndex = -1;
      for (int i = 0; i < parts.size(); i++) {
        if ("+".equals(parts.get(i))) {
          plusIndex = i;
          break;
        }
      }

      if (plusIndex == -1) {
        return null; // No build metadata
      }

      // Reconstruct the build metadata from parts after "+"
      StringBuilder sb = new StringBuilder();
      for (int i = plusIndex + 1; i < parts.size(); i++) {
        sb.append(parts.get(i));
      }

      return sb.length() > 0 ? sb.toString() : null;
    }
  }

  public ParseResult parse() {
    try {
      parseValidSemver();
      if (pos != input.length()) {
        throw new IllegalArgumentException(
          String.format("Unexpected characters at position %d: \"%s\"", pos, input.substring(pos))
        );
      }
      return ParseResult.success(parts);
    } catch (Exception e) {
      return ParseResult.error(e.getMessage());
    }
  }

  // <valid semver> ::= <version core> | <version core> "-" <pre-release> | <version core> "+" <build> | <version core> "-" <pre-release> "+" <build>
  private void parseValidSemver() {
    parseVersionCore();

    if (peek() != null && peek() == '-') {
      consume('-');
      parts.add("-");
      parsePreRelease();

      if (peek() != null && peek() == '+') {
        consume('+');
        parts.add("+");
        parseBuild();
      }
    } else if (peek() != null && peek() == '+') {
      consume('+');
      parts.add("+");
      parseBuild();
    }
  }

  // <version core> ::= <major> "." <minor> "." <patch>
  // With wildcards: <major> | <major> "." <wildcard> | <major> "." <minor> "." <wildcard>
  // With optional patch: <major> "." <minor> | <major> "." <minor> "." <patch>
  private void parseVersionCore() {
    String major = parseNumericIdentifier();
    parts.add(major);

    // Must have at least a dot after major
    if (peek() == null || peek() != '.') {
      throw new IllegalArgumentException(String.format("Expected '.' after major version at position %d", pos));
    }

    consume('.');
    parts.add(".");

    boolean hasWildcardInMinor = false;

    // Parse minor version (either numeric or wildcard)
    if (allowWildcards && isWildcard(peek())) {
      String wildcard = parseWildcard();
      parts.add(wildcard);
      hasWildcardInMinor = true;
    } else {
      String minor = parseNumericIdentifier();
      parts.add(minor);
    }

    // If we have a wildcard in minor, we can stop here or continue with wildcards only
    if (hasWildcardInMinor) {
      // Check if we have a dot for patch
      if (peek() != null && peek() == '.') {
        consume('.');
        parts.add(".");

        // After wildcard, only wildcards are allowed in version positions
        if (allowWildcards && isWildcard(peek())) {
          String patchWildcard = parseWildcard();
          parts.add(patchWildcard);
        } else {
          throw new IllegalArgumentException(String.format("After wildcard in version, only wildcards are allowed at position %d", pos));
        }
      }
      // Otherwise, we're done with version core - this handles "1.*" case
      return;
    }

    // Check if patch is optional and we're at end or at a separator
    if (!requirePatch && (peek() == null || peek() == '-' || peek() == '+')) {
      return; // Valid to stop here when patch is optional
    }

    // Must have a dot after minor (either for patch or error)
    if (peek() == null || peek() != '.') {
      if (requirePatch) {
        throw new IllegalArgumentException(String.format("Expected '.' after minor version at position %d", pos));
      } else {
        return; // Optional patch not provided
      }
    }

    consume('.');
    parts.add(".");

    // Parse patch version (either numeric or wildcard)
    if (allowWildcards && isWildcard(peek())) {
      String wildcard = parseWildcard();
      parts.add(wildcard);
    } else {
      String patch = parseNumericIdentifier();
      parts.add(patch);
    }
  }

  // <pre-release> ::= <dot-separated pre-release identifiers>
  private void parsePreRelease() {
    parseDotSeparatedPreReleaseIdentifiers();
  }

  // <dot-separated pre-release identifiers> ::= <pre-release identifier> | <pre-release identifier> "." <dot-separated pre-release identifiers>
  private void parseDotSeparatedPreReleaseIdentifiers() {
    String identifier = parsePreReleaseIdentifier();
    parts.add(identifier);

    while (peek() != null && peek() == '.' && pos + 1 < input.length() && input.charAt(pos + 1) != '+') {
      consume('.');
      parts.add(".");
      String nextIdentifier = parsePreReleaseIdentifier();
      parts.add(nextIdentifier);
    }
  }

  // <build> ::= <dot-separated build identifiers>
  private void parseBuild() {
    parseDotSeparatedBuildIdentifiers();
  }

  // <dot-separated build identifiers> ::= <build identifier> | <build identifier> "." <dot-separated build identifiers>
  private void parseDotSeparatedBuildIdentifiers() {
    String identifier = parseBuildIdentifier();
    parts.add(identifier);

    while (peek() != null && peek() == '.') {
      consume('.');
      parts.add(".");
      String nextIdentifier = parseBuildIdentifier();
      parts.add(nextIdentifier);
    }
  }

  // <pre-release identifier> ::= <alphanumeric identifier> | <numeric identifier>
  private String parsePreReleaseIdentifier() {
    // Check if this is a wildcard first
    if (allowWildcards && isWildcard(peek())) {
      return parseWildcard();
    }

    // Check if this is a valid numeric identifier by looking ahead
    if (isValidNumericIdentifier()) {
      return parseNumericIdentifier();
    }

    // Must be alphanumeric identifier
    return parseAlphanumericIdentifier();
  }

  // <build identifier> ::= <alphanumeric identifier> | <digits>
  private String parseBuildIdentifier() {
    // Check if this is a wildcard first
    if (allowWildcards && isWildcard(peek())) {
      return parseWildcard();
    }

    // Check if this is pure digits by looking ahead
    if (isValidDigitsOnly()) {
      return parseDigits();
    }

    // Must be alphanumeric identifier
    return parseAlphanumericIdentifier();
  }

  // <numeric identifier> ::= "0" | <positive digit> | <positive digit> <digits>
  private String parseNumericIdentifier() {
    int start = pos;

    if (peek() != null && peek() == '0') {
      consume('0');
      return "0";
    }

    if (isPositiveDigit(peek())) {
      consumePositiveDigit();
      parseOptionalDigits();
      return input.substring(start, pos);
    }

    throw new IllegalArgumentException(String.format("Expected numeric identifier at position %d", pos));
  }

  // <alphanumeric identifier> ::= <non-digit> | <non-digit> <identifier characters> | <identifier characters> <non-digit> | <identifier characters> <non-digit> <identifier characters>
  private String parseAlphanumericIdentifier() {
    int start = pos;
    boolean hasNonDigit = false;

    if (pos >= input.length()) {
      throw new IllegalArgumentException(String.format("Expected alphanumeric identifier at position %d", pos));
    }

    // Must have at least one character
    if (isNonDigit(peek())) {
      hasNonDigit = true;
      consumeNonDigit();
    } else if (isDigit(peek())) {
      consumeDigit();
    } else {
      throw new IllegalArgumentException(String.format("Expected alphanumeric identifier at position %d", pos));
    }

    // Continue with identifier characters
    while (isIdentifierCharacter(peek())) {
      if (isNonDigit(peek())) {
        hasNonDigit = true;
        consumeNonDigit();
      } else {
        consumeDigit();
      }
    }

    if (!hasNonDigit) {
      throw new IllegalArgumentException(String.format("Alphanumeric identifier must contain at least one non-digit at position %d", start));
    }

    return input.substring(start, pos);
  }

  // <digits> ::= <digit> | <digit> <digits>
  private String parseDigits() {
    int start = pos;

    if (!isDigit(peek())) {
      throw new IllegalArgumentException(String.format("Expected digit at position %d", pos));
    }

    consumeDigit();
    parseOptionalDigits();

    return input.substring(start, pos);
  }

  private void parseOptionalDigits() {
    while (isDigit(peek())) {
      consumeDigit();
    }
  }

  // Helper methods
  private Character peek() {
    return pos < input.length() ? input.charAt(pos) : null;
  }

  private void consume(char expected) {
    Character actual = peek();
    if (actual == null || actual != expected) {
      throw new IllegalArgumentException(String.format("Expected '%c' at position %d, got '%s'", expected, pos, actual == null ? "end of input" : actual));
    }
    pos++;
  }

  private boolean isPositiveDigit(Character ch) {
    return ch != null && ch >= '1' && ch <= '9';
  }

  private boolean isDigit(Character ch) {
    return ch != null && ch >= '0' && ch <= '9';
  }

  private boolean isLetter(Character ch) {
    return ch != null && ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
  }

  private boolean isNonDigit(Character ch) {
    return isLetter(ch) || (ch != null && ch == '-');
  }

  private boolean isIdentifierCharacter(Character ch) {
    return isDigit(ch) || isNonDigit(ch);
  }

  private void consumePositiveDigit() {
    if (!isPositiveDigit(peek())) {
      throw new IllegalArgumentException(String.format("Expected positive digit at position %d", pos));
    }
    pos++;
  }

  private void consumeDigit() {
    if (!isDigit(peek())) {
      throw new IllegalArgumentException(String.format("Expected digit at position %d", pos));
    }
    pos++;
  }

  private void consumeNonDigit() {
    if (!isNonDigit(peek())) {
      throw new IllegalArgumentException(String.format("Expected non-digit at position %d", pos));
    }
    pos++;
  }

  private boolean isValidDigitsOnly() {
    if (pos >= input.length() || !isDigit(input.charAt(pos))) {
      return false;
    }

    int tempPos = pos;
    // Advance through all digits
    while (tempPos < input.length() && isDigit(input.charAt(tempPos))) {
      tempPos++;
    }

    // Check if this sequence contains ONLY digits (no non-digits)
    // and is followed by a separator or end
    return (tempPos >= input.length()) ||
      input.charAt(tempPos) == '.' ||
      input.charAt(tempPos) == '+' ||
      !isIdentifierCharacter(input.charAt(tempPos));
  }

  private boolean isValidNumericIdentifier() {
    if (pos >= input.length()) {
      return false;
    }

    // Case 1: exactly "0"
    if (input.charAt(pos) == '0') {
      // Check if it's followed by a non-identifier character or end of string
      return (pos + 1 >= input.length()) ||
        !isIdentifierCharacter(input.charAt(pos + 1)) ||
        input.charAt(pos + 1) == '.' ||
        input.charAt(pos + 1) == '+';
    }

    // Case 2: positive digit followed by only digits
    if (isPositiveDigit(input.charAt(pos))) {
      int tempPos = pos + 1;
      while (tempPos < input.length() && isDigit(input.charAt(tempPos))) {
        tempPos++;
      }
      // Must be followed by non-identifier character, dot, plus, or end
      return (tempPos >= input.length()) ||
        !isIdentifierCharacter(input.charAt(tempPos)) ||
        input.charAt(tempPos) == '.' ||
        input.charAt(tempPos) == '+';
    }

    return false;
  }

  private boolean isNumericIdentifierStart() {
    Character ch = peek();
    return ch != null && (ch == '0' || isPositiveDigit(ch));
  }

  private boolean isAlphanumericIdentifierStart() {
    // An alphanumeric identifier can start with any identifier character,
    // but we need to look ahead to see if it will contain a non-digit
    boolean hasNonDigit = false;
    int tempPos = pos;

    // Look ahead to see if this could be an alphanumeric identifier
    while (tempPos < input.length() && isIdentifierCharacter(input.charAt(tempPos))) {
      if (isNonDigit(input.charAt(tempPos))) {
        hasNonDigit = true;
      }
      tempPos++;
      // Stop at separators
      if (tempPos < input.length() && (input.charAt(tempPos) == '.' || input.charAt(tempPos) == '+')) {
        break;
      }
    }

    return hasNonDigit && isIdentifierCharacter(peek());
  }

  // Wildcard support methods
  private boolean isWildcard(Character ch) {
    return ch != null && (ch == 'x' || ch == 'X' || ch == '*');
  }

  private String parseWildcard() {
    int start = pos;

    // Parse one or more wildcard characters
    while (isWildcard(peek())) {
      pos++;
    }

    if (start == pos) {
      throw new IllegalArgumentException(String.format("Expected wildcard at position %d", pos));
    }

    return input.substring(start, pos);
  }

  // Static convenience method
  public static ParseResult parseSemver(String input) {
    SemverParser parser = new SemverParser(input);
    return parser.parse();
  }

  public static ParseResult parseSemver(String input, boolean allowWildcards) {
    SemverParser parser = new SemverParser(input, allowWildcards);
    return parser.parse();
  }

  public static ParseResult parseSemver(String input, boolean allowWildcards, boolean requirePatch) {
    SemverParser parser = new SemverParser(input, allowWildcards, requirePatch);
    return parser.parse();
  }
}
