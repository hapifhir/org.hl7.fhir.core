import org.junit.jupiter.api.Test;

import org.hl7.fhir.utilities.Base64;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Base64Tests {
  @Test
  public void testIsArrayByteBase64() {
    assertFalse(Base64.isBase64(new byte[] { Byte.MIN_VALUE }));
    assertFalse(Base64.isBase64(new byte[] { -125 }));
    assertFalse(Base64.isBase64(new byte[] { -10 }));
    assertFalse(Base64.isBase64(new byte[] { 0 }));
    assertFalse(Base64.isBase64(new byte[] { 64, Byte.MAX_VALUE }));
    assertFalse(Base64.isBase64(new byte[] { Byte.MAX_VALUE }));

    assertTrue(Base64.isBase64(new byte[] { 'A' }));

    assertFalse(Base64.isBase64(new byte[] { 'A', Byte.MIN_VALUE }));

    assertTrue(Base64.isBase64(new byte[] { 'A', 'Z', 'a' }));
    assertTrue(Base64.isBase64(new byte[] { '/', '=', '+' }));

    assertFalse(Base64.isBase64(new byte[] { '$' }));
  }
}
