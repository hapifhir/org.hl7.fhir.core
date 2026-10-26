package org.hl7.fhir.convertors.context;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;

class VersionConvertorContextTest {

  @Test
  void outermostConvertorIsKeptUntilItCloses() {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    Object convertor = new Object();
    assertNull(context.getVersionConvertor());

    context.init(convertor);
    context.init(new Object());
    context.init(convertor);
    assertSame(convertor, context.getVersionConvertor());

    context.close();
    context.close();
    assertSame(convertor, context.getVersionConvertor());
    context.close();
    assertNull(context.getVersionConvertor());
  }

  @Test
  void closingWithNothingOpen() {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    assertThrows(FHIRException.class, context::close);
    context.init(new Object());
    context.close();
    assertThrows(FHIRException.class, context::close);
  }

  @Test
  void nullConvertorIsRejected() {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    assertThrows(FHIRException.class, () -> context.init(null));
    assertNull(context.getVersionConvertor());
  }

  @Test
  void eachThreadHasItsOwnConvertor() throws InterruptedException {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    Object convertor = new Object();
    Object otherConvertor = new Object();
    context.init(convertor);
    Object[] seen = new Object[2];
    Thread t = new Thread(() -> {
      seen[0] = context.getVersionConvertor();
      context.init(otherConvertor);
      seen[1] = context.getVersionConvertor();
      context.close();
    });
    t.start();
    t.join();
    assertNull(seen[0]);
    assertSame(otherConvertor, seen[1]);
    assertSame(convertor, context.getVersionConvertor());
    context.close();
  }
}
