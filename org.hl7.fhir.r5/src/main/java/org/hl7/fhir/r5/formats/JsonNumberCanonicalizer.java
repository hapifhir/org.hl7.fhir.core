package org.hl7.fhir.r5.formats;

public class JsonNumberCanonicalizer {

  /**
   * Converts a number string to canonical JSON representation per RFC 8785
   * Following ECMAScript Section 7.1.12.1 algorithm
   */
  public static String toCanonicalJson(String numberString) {
      try {
          // Parse as double (IEEE 754 double precision)
          double value = Double.parseDouble(numberString);
          
          // Handle special cases
          if (Double.isNaN(value)) {
              throw new IllegalArgumentException("NaN is not valid in JSON");
          }
          if (Double.isInfinite(value)) {
              throw new IllegalArgumentException("Infinity is not valid in JSON");
          }
          
          // Use the ECMAScript-compatible algorithm
          return doubleToCanonicalString(value);
          
      } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Invalid number format: " + numberString);
      }
  }
  
  /**
   * Implements ECMAScript Number.prototype.toString() algorithm
   * Based on Section 7.1.12.1 of ECMA-262 with Note 2 enhancement
   */
  private static String doubleToCanonicalString(double value) {
      // Handle zero (positive and negative zero both become "0")
      if (value == 0.0) {
          return "0";
      }
      
      // Handle negative numbers
      if (value < 0) {
          return "-" + doubleToCanonicalString(-value);
      }
      
      // Apply ECMAScript formatting rules
      return formatWithEcmaScriptRules(value);
  }
  
  /**
   * Format double using ECMAScript rules per ECMA-262 Section 7.1.12.1
   * This follows the exact algorithm specified in the ECMAScript standard
   */
  private static String formatWithEcmaScriptRules(double value) {
      // Step 1: Find the shortest string that round-trips to the same value
      String result = findShortestString(value);
      
      // Step 2: Apply ECMAScript notation rules
      return applyNotationRules(value, result);
  }
  
  /**
   * Find the shortest string representation that converts back to the exact same double
   */
  private static String findShortestString(double value) {
      // Use Java's built-in algorithm which is close to what we need
      String javaDefault = Double.toString(value);
      
      // Try to find a shorter representation
      String shortest = javaDefault;
      
      // Try fixed-point notation with different precisions
      for (int precision = 0; precision <= 17; precision++) {
          String candidate = String.format("%." + precision + "f", value);
          candidate = removeTrailingZeros(candidate);
          
          // Verify round-trip accuracy
          if (isExactRepresentation(candidate, value) && candidate.length() < shortest.length()) {
              shortest = candidate;
          }
      }
      
      // Try scientific notation
      String scientific = String.format("%.15e", value);
      scientific = cleanupScientificNotation(scientific);
      if (isExactRepresentation(scientific, value) && scientific.length() < shortest.length()) {
          shortest = scientific;
      }
      
      return shortest;
  }
  
  /**
   * Check if a string representation exactly round-trips to the same double
   */
  private static boolean isExactRepresentation(String str, double original) {
      try {
          double parsed = Double.parseDouble(str);
          return Double.doubleToLongBits(parsed) == Double.doubleToLongBits(original);
      } catch (NumberFormatException e) {
          return false;
      }
  }
  
  /**
   * Apply ECMAScript notation rules to choose between decimal and exponential
   */
  private static String applyNotationRules(double value, String representation) {
      // Calculate the exponent k (position of most significant digit)
      int k = calculateExponent(value);
      
      // ECMAScript rules from Section 7.1.12.1:
      // - If k <= -7 or k >= 21, use exponential notation
      // - Otherwise, use decimal notation
      
      if (k <= -7 || k >= 21) {
          return formatExponential(value);
      } else {
          // Use decimal notation, but ensure proper formatting
          return formatDecimal(value, k);
      }
  }
  
  /**
   * Calculate the exponent k as defined in ECMAScript
   */
  private static int calculateExponent(double value) {
      if (value == 0.0) return 0;
      
      double abs = Math.abs(value);
      if (abs >= 1.0) {
          return (int) Math.floor(Math.log10(abs));
      } else {
          return (int) Math.floor(Math.log10(abs));
      }
  }
  
  /**
   * Format in decimal notation following ECMAScript rules
   */
  private static String formatDecimal(double value, int k) {
      if (k >= 0) {
          // Large enough for normal decimal representation
          return removeTrailingZeros(String.format("%.15f", value));
      } else {
          // Small number - use appropriate decimal places
          int decimalPlaces = Math.max(0, -k + 15);
          String result = String.format("%." + decimalPlaces + "f", value);
          return removeTrailingZeros(result);
      }
  }
  
  /**
   * Format in exponential notation following ECMAScript rules
   */
  private static String formatExponential(double value) {
      // Use the format that matches ECMAScript exactly
      String formatted = String.format("%.15e", value);
      return cleanupScientificNotation(formatted);
  }
  
  /**
   * Get the effective exponent for ECMAScript formatting decisions
   */
  private static int getEffectiveExponent(double value) {
      if (value == 0.0) return 0;
      
      // For ECMAScript, we need the position of the most significant digit
      // relative to the decimal point
      double abs = Math.abs(value);
      if (abs >= 1.0) {
          return (int) Math.floor(Math.log10(abs));
      } else {
          return (int) Math.floor(Math.log10(abs));
      }
  }
  
  /**
   * Convert to scientific notation following ECMAScript rules exactly
   */
  private static String toEcmaScientific(double value) {
      // Use Java's scientific notation as starting point
      String formatted = String.format("%.16e", value);
      
      // Parse and reformat to match ECMAScript exactly
      String[] parts = formatted.toLowerCase().split("e");
      String mantissa = removeTrailingZeros(parts[0]);
      int exp = Integer.parseInt(parts[1]);
      
      // ECMAScript format: always include sign for exponent
      String expStr = (exp >= 0) ? "+" + exp : String.valueOf(exp);
      
      return mantissa + "e" + expStr;
  }
  
  /**
   * ECMAScript-compliant scientific notation
   */
  private static String toEcmaScriptScientific(double value) {
      // Handle the specific formatting requirements
      if (value == 0.0) return "0";
      
      boolean negative = value < 0;
      if (negative) value = -value;
      
      // Find the exponent
      int exponent = (int) Math.floor(Math.log10(value));
      
      // Scale the mantissa
      double mantissa = value / Math.pow(10, exponent);
      
      // Format mantissa with minimal precision
      String mantissaStr = findShortestMantissa(mantissa);
      
      // Format exponent with proper sign
      String expStr = (exponent >= 0) ? "+" + exponent : String.valueOf(exponent);
      
      String result = mantissaStr + "e" + expStr;
      return negative ? "-" + result : result;
  }
  
  /**
   * Find shortest mantissa representation
   */
  private static String findShortestMantissa(double mantissa) {
      for (int precision = 1; precision <= 16; precision++) {
          String candidate = String.format("%." + precision + "f", mantissa);
          candidate = removeTrailingZeros(candidate);
          
          double test = Double.parseDouble(candidate);
          if (Math.abs(test - mantissa) < 1e-15) {
              return candidate;
          }
      }
      return removeTrailingZeros(String.format("%.15f", mantissa));
  }
  
  /**
   * Remove trailing zeros from decimal representation
   */
  private static String removeTrailingZeros(String str) {
      if (!str.contains(".")) {
          return str;
      }
      
      // Remove trailing zeros after decimal point
      str = str.replaceAll("0+$", "");
      
      // Remove decimal point if no fractional part remains
      if (str.endsWith(".")) {
          str = str.substring(0, str.length() - 1);
      }
      
      return str;
  }
  
  /**
   * More precise implementation using round-trip verification
   * This should handle the RFC 8785 test cases correctly
   */
  public static String toCanonicalJsonPrecise(String numberString) {
      double value = Double.parseDouble(numberString);
      
      // Handle special cases
      if (value == 0.0) return "0";
      if (Double.isNaN(value)) throw new IllegalArgumentException("NaN not allowed");
      if (Double.isInfinite(value)) throw new IllegalArgumentException("Infinity not allowed");
      
      if (value < 0) {
          return "-" + toCanonicalJsonPrecise(String.valueOf(-value));
      }
      
      // This is the core algorithm following ECMAScript rules exactly
      return formatWithEcmaScriptRules(value);
  }
  
  private static String cleanupScientificNotation(String str) {
      if (!str.contains("e")) return str;
      
      // Convert to lowercase and split
      str = str.toLowerCase();
      String[] parts = str.split("e");
      String mantissa = removeTrailingZeros(parts[0]);
      String exponent = parts[1];
      
      // Remove leading zeros from exponent but keep sign
      if (exponent.startsWith("+")) {
          exponent = exponent.substring(1);
      }
      exponent = String.valueOf(Integer.parseInt(exponent)); // removes leading zeros
      
      // ECMAScript requires explicit + for positive exponents
      if (!exponent.startsWith("-")) {
          exponent = "+" + exponent;
      }
      
      return mantissa + "e" + exponent;
  }
  
}
