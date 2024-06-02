package org.hl7.fhir.utilities;

import org.apache.commons.lang3.StringUtils;

/**
 * Abstraction that splits a canonical in form of {@code <url>|<version>} into a URL and a version part.
 */
public class CanonicalPair {

  private final String url;
  private final String version;
  
  /**
   * Static factory method, that invokes the {@link CanonicalPair#CanonicalPair(String) CanonicalPair constructor}
   * with the given argument.
   * @param target the canonical to be split. May be {@code null}.
   * @return new instance of CanonicalPair
   */
  public static CanonicalPair of(String target) {
    return new CanonicalPair(target);
  }

  /**
   * Wraps the given canonical and if needed splits off the version part.<p>
   * The given parameter {@code target} is expected to be a canonical.
   * @param target canonical to create a url, version pair from. May be {@code null}.
   */
  public CanonicalPair(String target) {
    int pipeIndex = target != null ? target.indexOf('|') : -1;
    if (pipeIndex >= 0) {
      this.url = target.substring(0, pipeIndex);
      this.version = target.substring(pipeIndex+1);
    } else {
      this.url = target;
      this.version = null;
    }
  }

  /**
   * Returns the URL part  of the canonical (everything before the {@code "|"} character, or the complete
   * canonical if the character is not present). If the source 
   * @return URL part of the source canonical. May be {@code null}, if source canonical was {@code null}
   */
  public String getUrl() {
    return url;
  }

  /**
   * Returns the version part of the source canonical (everything after the {@code "|"} character.
   * @return version part of the canonical, may be {@code null}, if canonical was {@code null}, or canonical contains no 
   *   {@code "|"} character.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Determines if the version part of the canonical is not {@code null}
   * @return {@code true} if version is not {@code null}, otherwise {@code false}
   */
  public boolean hasVersion() {
    return version != null;
  }

  /**
   * Returns the version of this pair, or the parameter {@code alternative},
   * if the version of this pair is {@code null}.
   * @param alternative to be returned from this method if the encapsulated version is {@code null}.
   * @return either the held version, or {@code alternative}, if version is {@code null}
   */
  public String getVersionOr(String alternative) {
    return hasVersion() ? version : alternative;
  }

  /**
   * Determines if the encapsulated version of this pair is not {@code null} and not an empty string.
   * @return {@code true} if the version of this pair is not {@code null} and not an empty string, {@code false} otherwise
   */
  public boolean hasNonEmptyVersion() {
    return StringUtils.isNotEmpty(version);
  }
}
