@Override
      public String getVersion() {
        return null;
      }

      @Override
      public boolean hasVersion() {
        return false;
      }

      @Override
      public boolean supportsVersion() {
        return false;
      }

      @Override
      public String getDisplay() {
        return null;
      }

      @Override
      public boolean hasDisplay() {
        return false;
      }

      @Override
      public boolean supportsDisplay() {
        return false;
      }

   public static Quantity fromUcum(String v, String code) {
      Quantity res = new Quantity();
      res.setValue(new BigDecimal(v));
      res.setSystem("http://unitsofmeasure.org");
      res.setCode(code);
      return res;
    }


/**
 * Returns {@code true} if this Quantity represents a time duration that can be
 * used for exact date/time arithmetic (i.e. with
 * {@link BaseDateTimeType#add(Quantity)} / {@link BaseDateTimeType#subtract(Quantity)}).
 *
 * <p>The rules are:</p>
 * <ul>
 *   <li>The value and code must be present.</li>
 *   <li>The code must be a recognised UCUM time unit:
 *       {@code a}, {@code mo}, {@code wk}, {@code d}, {@code h},
 *       {@code min}, {@code s}, or {@code ms}.</li>
 *   <li>For calendar-relative units ({@code a}, {@code mo}) and for
 *       {@code ms}, the value must be a whole number (no fractional part),
 *       because these map directly to a {@link java.util.Calendar} field
 *       and fractional amounts are not meaningful.</li>
 *   <li>For fixed-duration units ({@code wk}, {@code d}, {@code h},
 *       {@code min}, {@code s}) any value — including decimals — is
 *       accepted, because the decimal can be converted down to whole
 *       milliseconds.</li>
 * </ul>
 *
 * @return {@code true} if this Quantity can be used for date/time arithmetic
 */
public boolean isExactTime() {
  if (!hasValue() || !hasCode()) {
    return false;
  }
  if (!"http://unitsofmeasure.org".equals(getSystem())) {
    return false;
  }
  BigDecimal val = getValue();
  String unit = getCode();
  switch (unit) {
    case "a":
    case "mo":
    case "ms":
      // These units require a whole number
      return val.stripTrailingZeros().scale() <= 0;
    case "wk":
    case "d":
    case "h":
    case "min":
    case "s":
      return true;
    default:
      return false;
  }
}
