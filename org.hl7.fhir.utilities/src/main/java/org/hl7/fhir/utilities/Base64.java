package org.hl7.fhir.utilities;

/**
 * This is a partial duplication of org.apache.commons.codec.binary.Base64
 *
 * It exists because Android compatibility only supports version 1.2 of that
 * library, which only has the deprecated isArrayByteBase64. The use of
 * isBase64 from this class will allow us to avoid using a deprecated method
 * or hacking a solution that involves catching exceptions on decoding.
 */
public class Base64 {

  private static final byte[] DECODE_TABLE = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

  public static boolean isBase64(byte octet) {
    return octet == 61 || octet >= 0 && octet < DECODE_TABLE.length && DECODE_TABLE[octet] != -1;
  }

  public static boolean isBase64(byte[] arrayOctet) {
    for(int i = 0; i < arrayOctet.length; ++i) {
      if (!isBase64(arrayOctet[i]) && !isWhiteSpace(arrayOctet[i])) {
        return false;
      }
    }

    return true;
  }

  protected static boolean isWhiteSpace(byte byteToCheck) {
    switch (byteToCheck) {
      case 9:
      case 10:
      case 13:
      case 32:
        return true;
      default:
        return false;
    }
  }
}
