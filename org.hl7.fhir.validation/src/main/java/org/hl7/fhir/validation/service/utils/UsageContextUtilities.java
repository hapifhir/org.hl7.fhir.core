package org.hl7.fhir.validation.service.utils;

import java.math.BigDecimal;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.utilities.Utilities;

/**
 * Parses the use contexts named on the command line into the UsageContext values the validator
 * matches additional bindings against.
 *
 * <p>The syntax is {@code code=value}. The code is always {@code system#code}. The value is
 * {@code type:...}, where the type says what is being given:
 * <pre>
 *   Coding:system#code               e.g. Coding:http://hl7.org/fhir/administrative-gender#female
 *   Quantity:decimal:system#code     e.g. Quantity:65:http://unitsofmeasure.org#kg
 *   Reference:url                    e.g. Reference:http://example.org/fhir/Patient/1
 * </pre>
 * A value with no recognised type prefix is read as a Coding, so the shorter
 * {@code code=system#code} form works too.
 *
 * <p>'Coding' names what you type, not where it lands: UsageContext.value[x] is
 * CodeableConcept | Quantity | Range | Reference, so a coding becomes a CodeableConcept carrying
 * that one coding. Range has no form here - there is no succinct way to write one, and nothing
 * matches against one.
 *
 * <p>Note that {@code BaseValidator.usagesMatch} only compares CodeableConcept values today;
 * Quantity and Reference parse and are carried into the settings, but will not match anything until
 * that is extended.
 */
public class UsageContextUtilities {

  private static final String TYPE_CODING = "Coding";
  private static final String TYPE_QUANTITY = "Quantity";
  private static final String TYPE_REFERENCE = "Reference";

  /**
   * @param src a {@code code=value} pair, as given to -usage
   * @return the use context it describes
   * @throws FHIRException if it isn't one
   */
  public static UsageContext parseUsageContext(String src) {
    if (src == null) {
      throw new FHIRException("Unable to understand the use context 'null'");
    }
    int i = src.indexOf("=");
    if (i < 1 || i == src.length() - 1) {
      throw new FHIRException("Unable to understand the use context '" + src + "': it must have the form code=value, e.g. "
          + "http://terminology.hl7.org/CodeSystem/usage-context-type#gender=Coding:http://hl7.org/fhir/administrative-gender#female");
    }
    UsageContext usage = new UsageContext();
    usage.setCode(parseCoding(src.substring(0, i), "code", src));
    usage.setValue(parseValue(src.substring(i + 1), src));
    return usage;
  }

  private static DataType parseValue(String value, String whole) {
    String type = typeOf(value);
    String rest = type == null ? value : value.substring(type.length() + 1);
    if (type == null || TYPE_CODING.equals(type)) {
      // UsageContext.value[x] has no Coding choice - a coding is carried as a CodeableConcept
      return new CodeableConcept().addCoding(parseCoding(rest, "value", whole));
    } else if (TYPE_QUANTITY.equals(type)) {
      int i = rest.indexOf(":");
      if (i < 1 || i == rest.length() - 1) {
        throw new FHIRException("Unable to understand the Quantity value '" + rest + "' in the use context '" + whole
            + "': it must have the form Quantity:decimal:system#code, e.g. Quantity:65:http://unitsofmeasure.org#kg");
      }
      String num = rest.substring(0, i);
      if (!Utilities.isDecimal(num, true)) {
        throw new FHIRException("Unable to understand the Quantity value in the use context '" + whole
            + "': '" + num + "' is not a decimal");
      }
      Coding units = parseCoding(rest.substring(i + 1), "value", whole);
      return new Quantity().setValue(new BigDecimal(num)).setSystem(units.getSystem()).setCode(units.getCode());
    } else {
      if (!Utilities.isAbsoluteUrl(rest)) {
        throw new FHIRException("Unable to understand the Reference value in the use context '" + whole
            + "': '" + rest + "' is not an absolute URL");
      }
      return new Reference().setReference(rest);
    }
  }

  /**
   * The type prefix, if there is one. A value can start with 'http:', which looks like a prefix, so
   * only the type names count - anything else is read as a bare coding.
   */
  private static String typeOf(String value) {
    for (String t : new String[] { TYPE_CODING, TYPE_QUANTITY, TYPE_REFERENCE }) {
      if (value.length() > t.length() + 1 && value.charAt(t.length()) == ':'
          && value.substring(0, t.length()).equalsIgnoreCase(t)) {
        return t;
      }
    }
    return null;
  }

  private static Coding parseCoding(String src, String part, String whole) {
    int i = src.indexOf("#");
    if (i < 1 || i == src.length() - 1) {
      throw new FHIRException("Unable to understand the " + part + " '" + src + "' in the use context '" + whole
          + "': it must have the form system#code, e.g. http://terminology.hl7.org/CodeSystem/usage-context-type#gender");
    }
    return new Coding().setSystem(src.substring(0, i)).setCode(src.substring(i + 1));
  }
}
