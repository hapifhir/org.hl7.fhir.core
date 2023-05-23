package org.hl7.fhir.r5.model;

import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BundleTypeTest {

  @Test
  @DisplayName("Test getLink by string when present")
  public void getLinkShouldFindWhenPresent() {
    Bundle bundle = new Bundle();
    Bundle.BundleLinkComponent link = new Bundle.BundleLinkComponent();
    link.setRelation(Bundle.LinkRelationTypes.NEXT);
    bundle.getLink().add(link);
    Bundle.BundleLinkComponent returnedLink = bundle.getLink(IBaseBundle.LINK_NEXT);
    Assertions.assertNotNull(returnedLink);
  }

  @Test
  @DisplayName("Test getLink by string when not present")
  public void getLinkStringShouldReturnNullWhenNoLinksMatch() {
    Bundle bundle = new Bundle();
    Bundle.BundleLinkComponent previousLink = new Bundle.BundleLinkComponent();
    previousLink.setRelation(Bundle.LinkRelationTypes.PREV);
    bundle.getLink().add(previousLink);
    Bundle.BundleLinkComponent returnedLink = bundle.getLink(IBaseBundle.LINK_NEXT);
    Assertions.assertNull(returnedLink);
  }
}
