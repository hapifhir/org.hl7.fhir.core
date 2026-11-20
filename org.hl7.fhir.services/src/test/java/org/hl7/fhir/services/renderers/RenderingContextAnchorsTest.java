package org.hl7.fhir.services.renderers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ResourceRendererMode;
import org.junit.jupiter.api.Test;

public class RenderingContextAnchorsTest {

  private RenderingContext context() {
    return new RenderingContext(null, null, null, null, "http://hl7.org/fhir", "", Locale.ENGLISH, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
  }

  @Test
  public void testSetAnchorsIsUsedAndSharedByCopies() {
    RenderingContext rc = context();
    rc.addAnchor("old");
    Set<String> anchors = new HashSet<>();
    assertSame(rc, rc.setAnchors(anchors));
    assertSame(anchors, rc.getAnchors());
    assertFalse(rc.hasAnchor("old"));

    rc.addAnchor("a");
    assertTrue(anchors.contains("a"));

    RenderingContext shared = rc.copy(true);
    assertSame(anchors, shared.getAnchors());
    shared.addAnchor("b");
    assertTrue(rc.hasAnchor("b"));

    RenderingContext separate = rc.copy(false);
    assertNotSame(anchors, separate.getAnchors());
    assertFalse(separate.hasAnchor("a"));
    separate.addAnchor("c");
    assertFalse(rc.hasAnchor("c"));
  }

  @Test
  public void testCopiesMadeBeforeKeepTheOldSet() {
    RenderingContext rc = context();
    RenderingContext before = rc.copy(true);
    Set<String> old = rc.getAnchors();
    rc.setAnchors(new HashSet<>());
    rc.addAnchor("a");
    assertSame(old, before.getAnchors());
    assertFalse(before.hasAnchor("a"));
  }
}
