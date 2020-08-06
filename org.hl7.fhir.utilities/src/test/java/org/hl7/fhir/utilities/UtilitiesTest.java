package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

  public static final int BOUND = 500;
  public static final Random RAND = new Random();

  public static final int GB_MEASURE_JUST_OVER = (int) Math.pow(Utilities.ONE_MB, 3) + RAND.nextInt(BOUND);
  public static final int GB_MEASURE_EXACT = (int) Math.pow(Utilities.ONE_MB, 3);
  public static final int GB_MEASURE_JUST_UNDER = (int) Math.pow(Utilities.ONE_MB, 3) - RAND.nextInt(BOUND);

  public static final int MB_MEASURE_JUST_OVER = (int) Math.pow(Utilities.ONE_MB, 2) + RAND.nextInt(BOUND);
  public static final int MB_MEASURE_EXACT = (int) Math.pow(Utilities.ONE_MB, 2);
  public static final int MB_MEASURE_JUST_UNDER = (int) Math.pow(Utilities.ONE_MB, 2) - RAND.nextInt(BOUND);

  public static final int KB_MEASURE_JUST_OVER = Utilities.ONE_MB + RAND.nextInt(BOUND);
  public static final int KB_MEASURE_EXACT = Utilities.ONE_MB;
  public static final int KB_MEASURE_JUST_UNDER = Utilities.ONE_MB - RAND.nextInt(BOUND);

  public static final int BT_MEASURE = Utilities.ONE_MB + RAND.nextInt(BOUND);
  public static final int EMPTY = 0;

  public static final int BIG_NEG = Utilities.ONE_MB * -1;

  @Test
  @DisplayName("Test size bounds on file size utility.")
  void describeSizeTest() {
    Assertions.assertAll("GB Measure Limits",
      () -> assertTrue(Utilities.describeSize(GB_MEASURE_JUST_OVER).contains(Utilities.GB)),
      () -> assertTrue(Utilities.describeSize(GB_MEASURE_EXACT).contains(Utilities.MB)),
      () -> assertTrue(Utilities.describeSize(GB_MEASURE_JUST_UNDER).contains(Utilities.MB))
    );
    Assertions.assertAll("MB Measure Limits",
      () -> assertTrue(Utilities.describeSize(MB_MEASURE_JUST_OVER).contains(Utilities.MB)),
      () -> assertTrue(Utilities.describeSize(MB_MEASURE_EXACT).contains(Utilities.KB)),
      () -> assertTrue(Utilities.describeSize(MB_MEASURE_JUST_UNDER).contains(Utilities.KB))
    );
    Assertions.assertAll("KB Measure Limits",
      () -> assertTrue(Utilities.describeSize(KB_MEASURE_JUST_OVER).contains(Utilities.KB)),
      () -> assertTrue(Utilities.describeSize(KB_MEASURE_EXACT).contains(Utilities.BT)),
      () -> assertTrue(Utilities.describeSize(KB_MEASURE_JUST_UNDER).contains(Utilities.BT))
    );
    Assertions.assertAll("BT Measure Limits",
      () -> assertTrue(Utilities.describeSize(BT_MEASURE).contains(Utilities.BT)),
      () -> assertTrue(Utilities.describeSize(EMPTY).contains(Utilities.BT))
    );
    Assertions.assertThrows(IllegalArgumentException.class, () -> Utilities.describeSize(BIG_NEG));
  }
}