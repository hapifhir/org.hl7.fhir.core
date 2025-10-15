package org.hl7.fhir.r5.context;

import lombok.Getter;
import lombok.Setter;
import lombok.With;

public class ExpansionOptions {
  @Getter @Setter @With
  private boolean cacheOk;

  @Getter @Setter @With
  private boolean hierarchical;

  /**
   * the number of concepts to return.
   *
   * -1 means no limit
   *
   * (0 means, check that the value set expands(/exists) but don't return any concepts)
   *
   */
  @Getter @Setter @With
  private int maxCount;

  @Getter @Setter @With
  private boolean incompleteOk;

  @Getter @Setter @With
  private String language;

  public boolean hasLanguage() {
    return language != null;
  }

  public ExpansionOptions() {
  }

  public ExpansionOptions(boolean cacheOk, boolean heiarchical, int maxCount, boolean incompleteOk, String language) {
    this.cacheOk = cacheOk;
    this.hierarchical = heiarchical;
    this.maxCount = maxCount;
    this.incompleteOk = incompleteOk;
    this.language = language;
  }

  public static ExpansionOptions cacheNoHeirarchy() {
    return new ExpansionOptions().withCacheOk(true).withHierarchical(true);
  }
}
