package org.hl7.fhir.convertors.baseAdaptors;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.services.utilities.TestingUtilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests the metadata based (property) access part of the Base API on the R5 adaptor - both what is
 * read through the adaptor, and that what is written through it lands on the underlying R5 object.
 *
 * observation-example.xml is used for choice types: value[x] (valueQuantity), effective[x]
 * (effectiveDateTime), and an extension with a valueAge
 *
 * Also tests user data, which the adaptor keeps on the wrapped R5 objects
 */
class BaseNAdaptorR5Tests {

  private static Patient loadPatient() throws IOException {
    return (Patient) new XmlParser().parse(TestingUtilities.loadTestResourceBytes("r5", "patient-example.xml"));
  }

  private static Observation loadObservation() throws IOException {
    return (Observation) new XmlParser().parse(TestingUtilities.loadTestResourceBytes("r5", "observation-example.xml"));
  }

  private static Base wrap(org.hl7.fhir.r5.model.Base r5) {
    return new BaseNAdaptorR5(ModelContext.fullCoreContext(), r5);
  }

  private static List<String> names(List<Property> properties) {
    List<String> result = new ArrayList<>();
    for (Property p : properties) {
      result.add(p.getName());
    }
    return result;
  }

  private static List<String> r5Names(List<org.hl7.fhir.r5.model.Property> properties) {
    List<String> result = new ArrayList<>();
    for (org.hl7.fhir.r5.model.Property p : properties) {
      result.add(p.getName());
    }
    return result;
  }

  @Test
  void testPatient() throws IOException {
    Patient pat = loadPatient();
    Base base = wrap(pat);
    Assertions.assertNotNull(base);
    Assertions.assertTrue(VersionUtilities.isR5Ver(base.getFHIRVersion()));
    Assertions.assertEquals("Patient", base.fhirType());
    Assertions.assertFalse(base.getChildren().isEmpty());
    Assertions.assertNotNull(base.getChildByName("id"));
    Assertions.assertTrue(base.getChildByName("id").hasValues());
    Assertions.assertEquals(1, base.getChildByName("id").getValues().size());
    Assertions.assertTrue(base.getChildByName("id").getValues().get(0).isPrimitive());
    Assertions.assertEquals("example", base.getChildByName("id").getValues().get(0).primitiveValue());
    base.setProperty("id", new IdType("test"));
    Assertions.assertEquals("test", base.getChildByName("id").getValues().get(0).primitiveValue());
    Assertions.assertEquals("test", base.getChildValues("id", true).get(0).primitiveValue());
    Assertions.assertEquals("test", pat.getIdElement().getIdPart());
    base.removeChild("id", null);

    Assertions.assertNotNull(base.getChildByName("id"));
    Assertions.assertFalse(base.getChildByName("id").hasValues());
    Assertions.assertFalse(pat.hasId());

    Base address = base.getChildByName("address").getValues().get(0);
    Assertions.assertNotNull(address);
    Assertions.assertTrue(VersionUtilities.isR5Ver(address.getFHIRVersion()));
    Assertions.assertEquals("Address", address.fhirType());
    Assertions.assertFalse(address.getChildren().isEmpty());
    Assertions.assertEquals("PleasantVille", address.getSingleChildValue("city", true).primitiveValue());

    // a backbone element
    Base contact = base.getChildValues("contact", true).get(0);
    Assertions.assertEquals("Patient.contact", contact.fhirType());
    Assertions.assertFalse(contact.isResource());
    Assertions.assertFalse(contact.isPrimitive());
    Assertions.assertEquals("female", contact.getSingleChildValue("gender", true).primitiveValue());
    Assertions.assertEquals("Address", contact.getSingleChildValue("address", true).fhirType());

    // a choice type with a primitive value
    Assertions.assertEquals("deceased[x]", base.getChildByName("deceased").getName());
    Base deceased = base.getSingleChildValue("deceased", true);
    Assertions.assertEquals("boolean", deceased.fhirType());
    Assertions.assertTrue(deceased.isBooleanPrimitive());
    Assertions.assertEquals("false", deceased.primitiveValue());
  }

  @Test
  void testTypeInformation() throws IOException {
    Patient pat = loadPatient();
    Base base = wrap(pat);

    // resource
    Assertions.assertTrue(base.isResource());
    Assertions.assertFalse(base.isPrimitive());
    Assertions.assertFalse(base.canHavePrimitiveValue());
    Assertions.assertFalse(base.hasPrimitiveValue());
    Assertions.assertNull(base.primitiveValue());
    Assertions.assertFalse(base.isBooleanPrimitive());
    Assertions.assertFalse(base.isDateTime());
    Assertions.assertNull(base.dateTimeValue());
    Assertions.assertFalse(base.isMetadataBased());
    Assertions.assertNull(base.asType());
    Assertions.assertNull(base.getAsICoding());
    Assertions.assertFalse(base.isEmpty());
    Assertions.assertTrue(base.hasType("Patient"));
    Assertions.assertTrue(base.hasType("patient"));
    Assertions.assertTrue(base.hasType("Observation", "Patient"));
    Assertions.assertTrue(base.hasType("FHIR.Patient"));
    Assertions.assertFalse(base.hasType("Observation"));
    Assertions.assertEquals("example", base.getIdBase());
    base.setIdBase("other");
    Assertions.assertEquals("other", base.getIdBase());
    Assertions.assertEquals("other", pat.getIdElement().getIdPart());

    // boolean primitive
    Base active = base.getSingleChildValue("active", true);
    Assertions.assertEquals("boolean", active.fhirType());
    Assertions.assertTrue(active.isPrimitive());
    Assertions.assertTrue(active.canHavePrimitiveValue());
    Assertions.assertTrue(active.hasPrimitiveValue());
    Assertions.assertTrue(active.isBooleanPrimitive());
    Assertions.assertFalse(active.isDateTime());
    Assertions.assertFalse(active.isResource());
    Assertions.assertEquals("true", active.primitiveValue());
    Assertions.assertNull(active.dateTimeValue());

    // date primitive, which also has an extension
    Base birthDate = base.getSingleChildValue("birthDate", true);
    Assertions.assertEquals("date", birthDate.fhirType());
    Assertions.assertTrue(birthDate.isPrimitive());
    Assertions.assertFalse(birthDate.isBooleanPrimitive());
    Assertions.assertTrue(birthDate.isDateTime());
    Assertions.assertEquals("1974-12-25", birthDate.primitiveValue());
    Assertions.assertNotNull(birthDate.dateTimeValue());
    Assertions.assertEquals("1974-12-25", birthDate.dateTimeValue().primitiveValue());
    Assertions.assertEquals(1, birthDate.getChildValues("extension", true).size());
    Assertions.assertEquals("Extension", birthDate.getChildValues("extension", true).get(0).fhirType());

    // data type
    Base name = base.getChildValues("name", true).get(0);
    Assertions.assertEquals("HumanName", name.fhirType());
    Assertions.assertTrue(name.hasType("HumanName"));
    Assertions.assertFalse(name.isResource());
    Assertions.assertFalse(name.isPrimitive());
    Assertions.assertFalse(name.canHavePrimitiveValue());
    Assertions.assertNull(name.primitiveValue());
    Assertions.assertFalse(name.isEmpty());
    Assertions.assertEquals(2, name.getChildValues("given", true).size());
    Assertions.assertEquals("James", name.getChildValues("given", true).get(1).primitiveValue());

    // coding
    Observation obs = loadObservation();
    Base code = wrap(obs).getSingleChildValue("code", true);
    Assertions.assertNull(code.getAsICoding(), "a CodeableConcept is not a Coding");
    Base coding = code.getChildValues("coding", true).get(0);
    Assertions.assertNotNull(coding.getAsICoding());
    Assertions.assertEquals("http://loinc.org", coding.getAsICoding().getSystem());
    Assertions.assertEquals("29463-7", coding.getAsICoding().getCode());
  }

  @Test
  void testChildrenMetadata() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);

    List<Property> children = base.getChildren();
    // all the defined children, whether they have values or not, in the R5 order
    Assertions.assertEquals(r5Names(obs.children()), names(children));
    Assertions.assertThrows(UnsupportedOperationException.class, () -> children.add(null));

    for (Property p : children) {
      org.hl7.fhir.r5.model.Property r5p = obs.getChildByName(p.getName());
      Assertions.assertNotNull(r5p, p.getName());
      Assertions.assertEquals(r5p.getTypeCode(), p.getTypeCode(), p.getName());
      Assertions.assertEquals(r5p.getDefinition(), p.getDefinition(), p.getName());
      Assertions.assertEquals(r5p.getMinCardinality(), p.getMinCardinality(), p.getName());
      Assertions.assertEquals(r5p.getMaxCardinality(), p.getMaxCardinality(), p.getName());
      Assertions.assertEquals(r5p.hasValues(), p.hasValues(), p.getName());
      Assertions.assertEquals(r5p.getValues().size(), p.getValues().size(), p.getName());
      for (int i = 0; i < p.getValues().size(); i++) {
        Base v = p.getValues().get(i);
        Assertions.assertTrue(VersionUtilities.isR5Ver(v.getFHIRVersion()), p.getName());
        Assertions.assertEquals(r5p.getValues().get(i).fhirType(), v.fhirType(), p.getName());
      }
    }

    Property identifier = base.getChildByName("identifier");
    Assertions.assertEquals("identifier", identifier.getName());
    Assertions.assertEquals("Identifier", identifier.getTypeCode());
    Assertions.assertEquals(0, identifier.getMinCardinality());
    Assertions.assertEquals(Integer.MAX_VALUE, identifier.getMaxCardinality());
    Assertions.assertTrue(identifier.isList());
    Assertions.assertFalse(identifier.hasValues());
    Assertions.assertTrue(identifier.getValues().isEmpty());

    Property status = base.getChildByName("status");
    Assertions.assertEquals("code", status.getTypeCode());
    Assertions.assertEquals(0, status.getMinCardinality());
    Assertions.assertEquals(1, status.getMaxCardinality());
    Assertions.assertFalse(status.isList());
    Assertions.assertTrue(status.hasValues());
    Assertions.assertFalse(status.getDefinition().isEmpty());

    Property category = base.getChildByName("category");
    Assertions.assertTrue(category.isList());
    Assertions.assertEquals(1, category.getValues().size());
    Assertions.assertEquals("CodeableConcept", category.getValues().get(0).fhirType());

    // a defined child with no value is still listed
    Property dar = base.getChildByName("dataAbsentReason");
    Assertions.assertNotNull(dar);
    Assertions.assertFalse(dar.hasValues());

    // choice types are found by the stem and the [x] name, but not the type specific name
    Property value = base.getChildByName("value");
    Assertions.assertNotNull(value);
    Assertions.assertEquals("value[x]", value.getName());
    Assertions.assertTrue(value.getTypeCode().contains("Quantity"));
    Assertions.assertTrue(value.getTypeCode().contains("CodeableConcept"));
    Assertions.assertEquals(0, value.getMinCardinality());
    Assertions.assertEquals(1, value.getMaxCardinality());
    Assertions.assertFalse(value.isList());
    Assertions.assertEquals("value[x]", base.getChildByName("value[x]").getName());
    Assertions.assertNull(base.getChildByName("valueQuantity"));

    Assertions.assertNull(base.getChildByName("nonsense"));

    // children of a data type
    Base quantity = value.getValues().get(0);
    Assertions.assertEquals(r5Names(obs.getValueQuantity().children()), names(quantity.getChildren()));
  }

  @Test
  void testChildValues() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);

    List<Base> category = base.getChildValues("category", true);
    Assertions.assertEquals(1, category.size());
    Assertions.assertEquals("CodeableConcept", category.get(0).fhirType());
    Assertions.assertThrows(UnsupportedOperationException.class, () -> category.add(null));
    Assertions.assertTrue(base.getChildValues("identifier", true).isEmpty());
    Assertions.assertTrue(base.getChildValues("nonsense", false).isEmpty());
    Assertions.assertThrows(FHIRException.class, () -> base.getChildValues("nonsense", true));

    // "*" - all the values of all the children
    List<Base> all = base.getChildValues("*", true);
    List<String> expected = new ArrayList<>();
    for (Property p : base.getChildren()) {
      for (Base v : p.getValues()) {
        expected.add(v.fhirType());
      }
    }
    List<String> actual = new ArrayList<>();
    for (Base v : all) {
      actual.add(v.fhirType());
    }
    Assertions.assertEquals(expected, actual);
    // id, text, extension, status, category, code, subject, encounter, effective, value
    Assertions.assertEquals(10, all.size());

    // single values
    Base code = base.getSingleChildValue("code", true);
    Assertions.assertEquals("CodeableConcept", code.fhirType());
    Assertions.assertNotNull(base.getSingleChildValue("category", true));
    Assertions.assertNull(base.getSingleChildValue("dataAbsentReason", true));
    Assertions.assertNull(base.getSingleChildValue("nonsense", false));
    Assertions.assertThrows(FHIRException.class, () -> base.getSingleChildValue("nonsense", true));
    Assertions.assertEquals(4, code.getChildValues("coding", true).size());
    Assertions.assertThrows(FHIRException.class, () -> code.getSingleChildValue("coding", true));
    Assertions.assertEquals("http://snomed.info/sct", code.getChildValues("coding", true).get(2).getSingleChildValue("system", true).primitiveValue());

    // raw values
    Base[] status = base.getNamedValue("status", true);
    Assertions.assertEquals(1, status.length);
    Assertions.assertEquals("final", status[0].primitiveValue());
    Assertions.assertEquals(0, base.getNamedValue("identifier", true).length);
    Assertions.assertEquals(0, base.getNamedValue("dataAbsentReason", true).length);
    Assertions.assertNull(base.getNamedValue("nonsense", false));
    Assertions.assertThrows(FHIRException.class, () -> base.getNamedValue("nonsense", true));

    // named properties
    Property p = base.getNamedProperty("status", true);
    Assertions.assertEquals("status", p.getName());
    Assertions.assertEquals("code", p.getTypeCode());
    Assertions.assertEquals(1, p.getMaxCardinality());
    Assertions.assertEquals(1, p.getValues().size());
    Assertions.assertEquals("final", p.getValues().get(0).primitiveValue());
    p = base.getNamedProperty("performer", true);
    Assertions.assertEquals("performer", p.getName());
    Assertions.assertTrue(p.isList());
    Assertions.assertFalse(p.hasValues());
    Assertions.assertNull(base.getNamedProperty("nonsense", false));
    Assertions.assertThrows(FHIRException.class, () -> base.getNamedProperty("nonsense", true));
  }

  @Test
  void testChoiceTypeRead() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);

    // getNamedProperty answers to the stem, the [x] name, and the type specific names
    for (String n : new String[] {"value", "value[x]", "valueQuantity"}) {
      Property p = base.getNamedProperty(n, true);
      Assertions.assertNotNull(p, n);
      Assertions.assertEquals("value[x]", p.getName(), n);
      Assertions.assertEquals(1, p.getValues().size(), n);
      Assertions.assertEquals("Quantity", p.getValues().get(0).fhirType(), n);
    }
    Assertions.assertEquals("value[x]", base.getNamedProperty("valueString", true).getName());
    Assertions.assertEquals("effective[x]", base.getNamedProperty("effectiveDateTime", true).getName());
    Assertions.assertEquals("dateTime", base.getNamedProperty("effectiveDateTime", true).getValues().get(0).fhirType());

    // getNamedValue / getChildValues answer to the stem only
    Base[] values = base.getNamedValue("value", true);
    Assertions.assertEquals(1, values.length);
    Assertions.assertEquals("Quantity", values[0].fhirType());
    Assertions.assertNull(base.getNamedValue("valueQuantity", false));
    Assertions.assertNull(base.getNamedValue("value[x]", false));
    Assertions.assertTrue(base.getChildValues("valueQuantity", false).isEmpty());
    Assertions.assertThrows(FHIRException.class, () -> base.getChildValues("valueQuantity", true));
    Assertions.assertThrows(FHIRException.class, () -> base.getChildValues("value[x]", true));

    // a primitive choice
    Base effective = base.getSingleChildValue("effective", true);
    Assertions.assertEquals("dateTime", effective.fhirType());
    Assertions.assertTrue(effective.isPrimitive());
    Assertions.assertTrue(effective.isDateTime());
    Assertions.assertEquals("2016-03-28", effective.primitiveValue());
    Assertions.assertNotNull(effective.dateTimeValue());
    Assertions.assertEquals("2016-03-28", effective.dateTimeValue().primitiveValue());

    // a complex choice - and navigating into it (Quantity.value is not a choice)
    Base quantity = base.getSingleChildValue("value", true);
    Assertions.assertFalse(quantity.isPrimitive());
    Assertions.assertEquals("value", quantity.getChildByName("value").getName());
    Base qv = quantity.getSingleChildValue("value", true);
    Assertions.assertEquals("decimal", qv.fhirType());
    Assertions.assertTrue(qv.isPrimitive());
    Assertions.assertEquals("185", qv.primitiveValue());
    Assertions.assertEquals("lbs", quantity.getSingleChildValue("unit", true).primitiveValue());
    Assertions.assertEquals("http://unitsofmeasure.org", quantity.getSingleChildValue("system", true).primitiveValue());
    Assertions.assertEquals("[lb_av]", quantity.getSingleChildValue("code", true).primitiveValue());

    // a choice on an extension, where the type is a profile on Quantity
    Base ext = base.getSingleChildValue("extension", true);
    Assertions.assertEquals("Extension", ext.fhirType());
    Assertions.assertEquals("http://example.com/fhir/StructureDefinition/patient-age", ext.getSingleChildValue("url", true).primitiveValue());
    Property extValue = ext.getChildByName("value");
    Assertions.assertEquals("value[x]", extValue.getName());
    Base age = extValue.getValues().get(0);
    Assertions.assertEquals("Age", age.fhirType());
    // (not "valueAge": R5's Extension.getNamedProperty only knows the type specific names for primitive types)
    Assertions.assertEquals("Age", ext.getNamedProperty("value[x]", true).getValues().get(0).fhirType());
    Assertions.assertEquals("41", age.getSingleChildValue("value", true).primitiveValue());
    Assertions.assertEquals("a", age.getSingleChildValue("code", true).primitiveValue());
  }

  @Test
  void testChoiceTypeWrite() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);

    // setProperty uses the [x] name, and the value's type picks the choice
    base.setProperty("value[x]", new StringType("heavy"));
    Assertions.assertTrue(obs.getValue() instanceof org.hl7.fhir.r5.model.StringType);
    Assertions.assertEquals("heavy", obs.getValueStringType().getValue());
    Assertions.assertEquals("string", base.getSingleChildValue("value", true).fhirType());
    Assertions.assertEquals("heavy", base.getSingleChildValue("value", true).primitiveValue());
    Assertions.assertThrows(FHIRException.class, () -> base.setProperty("value", new StringType("x")));
    Assertions.assertThrows(FHIRException.class, () -> base.setProperty("valueString", new StringType("x")));
    Assertions.assertEquals("heavy", obs.getValueStringType().getValue());

    // removeChild with no value clears the choice
    base.removeChild("value[x]", null);
    Assertions.assertFalse(obs.hasValue());
    Assertions.assertFalse(base.getChildByName("value").hasValues());
    Assertions.assertNull(base.getSingleChildValue("value", true));

    // addChild uses the type specific name
    Base quantity = base.addChild("valueQuantity");
    Assertions.assertNotNull(quantity);
    Assertions.assertEquals("Quantity", quantity.fhirType());
    Assertions.assertTrue(quantity.isEmpty());
    Assertions.assertTrue(obs.getValue() instanceof org.hl7.fhir.r5.model.Quantity);
    Assertions.assertTrue(obs.getValueQuantity().isEmpty());
    Assertions.assertThrows(FHIRException.class, () -> base.addChild("value[x]"));
    Assertions.assertThrows(FHIRException.class, () -> base.addChild("value"));

    // writes to the child land on the R5 object
    quantity.setProperty("value", new DecimalType("72.5"));
    quantity.setProperty("unit", new StringType("kg"));
    Assertions.assertEquals(0, new BigDecimal("72.5").compareTo(obs.getValueQuantity().getValue()));
    Assertions.assertEquals("kg", obs.getValueQuantity().getUnit());
    Assertions.assertFalse(quantity.isEmpty());

    // makeProperty returns the existing value, not a new one (stem or [x] name, but not type specific)
    Base existing = base.makeProperty("value");
    Assertions.assertEquals("Quantity", existing.fhirType());
    existing.setProperty("code", new CodeType("kg"));
    Assertions.assertEquals("kg", obs.getValueQuantity().getCode());
    Assertions.assertEquals("72.5", obs.getValueQuantity().getValueElement().asStringValue());
    Assertions.assertEquals("kg", base.makeProperty("value[x]").getSingleChildValue("code", true).primitiveValue());
    Assertions.assertThrows(FHIRException.class, () -> base.makeProperty("valueQuantity"));

    // removeChild with the current value clears it
    base.removeChild("value[x]", base.getSingleChildValue("value", true));
    Assertions.assertFalse(obs.hasValue());

    // switching type with addChild
    Base cc = base.addChild("valueCodeableConcept");
    Assertions.assertEquals("CodeableConcept", cc.fhirType());
    cc.setProperty("text", new StringType("overweight"));
    Assertions.assertEquals("overweight", obs.getValueCodeableConcept().getText());
    Base quantity2 = base.addChild("valueQuantity");
    Assertions.assertTrue(quantity2.isEmpty());
    Assertions.assertTrue(obs.getValue() instanceof org.hl7.fhir.r5.model.Quantity);

    // effective[x]: dateTime -> Period
    base.setProperty("effective[x]", new DateTimeType("2020-01-02"));
    Assertions.assertEquals("2020-01-02", obs.getEffectiveDateTimeType().asStringValue());
    Assertions.assertEquals("2020-01-02", base.getSingleChildValue("effective", true).primitiveValue());
    org.hl7.fhir.model.core.Period period = new org.hl7.fhir.model.core.Period();
    period.setStartElement(new DateTimeType("2020-01-01"));
    period.setEndElement(new DateTimeType("2020-01-03"));
    base.setProperty("effective[x]", period);
    Assertions.assertTrue(obs.getEffective() instanceof org.hl7.fhir.r5.model.Period);
    Assertions.assertEquals("2020-01-03", obs.getEffectivePeriod().getEndElement().asStringValue());
    Base effective = base.getSingleChildValue("effective", true);
    Assertions.assertEquals("Period", effective.fhirType());
    Assertions.assertFalse(effective.isDateTime());
    Assertions.assertEquals("2020-01-01", effective.getSingleChildValue("start", true).primitiveValue());
  }

  @Test
  void testPropertyWrite() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);

    // setProperty - singleton primitive
    Base result = base.setProperty("status", new CodeType("amended"));
    Assertions.assertNotNull(result);
    Assertions.assertEquals(Enumerations.ObservationStatus.AMENDED, obs.getStatus());
    Assertions.assertEquals("amended", base.getSingleChildValue("status", true).primitiveValue());

    // setProperty - list: appends
    base.setProperty("category", new org.hl7.fhir.model.core.CodeableConcept().setText("second"));
    Assertions.assertEquals(2, obs.getCategory().size());
    Assertions.assertEquals("second", obs.getCategory().get(1).getText());
    Assertions.assertEquals(2, base.getChildValues("category", true).size());

    // setProperty - an adaptor value from another tree is unwrapped, not converted
    Observation other = loadObservation();
    Base otherCode = wrap(other).getSingleChildValue("code", true);
    base.setProperty("code", otherCode);
    Assertions.assertSame(other.getCode(), obs.getCode());

    // setProperty - errors
    Assertions.assertThrows(FHIRException.class, () -> base.setProperty("nonsense", new StringType("x")));
    Assertions.assertThrows(FHIRException.class, () -> base.setProperty("subject", new org.hl7.fhir.model.core.Patient()));

    // addChild - list: appends a new instance
    Base cat = base.addChild("category");
    Assertions.assertEquals("CodeableConcept", cat.fhirType());
    Assertions.assertEquals(3, obs.getCategory().size());
    cat.setProperty("text", new StringType("third"));
    Assertions.assertEquals("third", obs.getCategory().get(2).getText());

    // addChild - singleton: replaces
    org.hl7.fhir.r5.model.Reference oldSubject = obs.getSubject();
    Base subject = base.addChild("subject");
    Assertions.assertEquals("Reference", subject.fhirType());
    Assertions.assertNotSame(oldSubject, obs.getSubject());
    Assertions.assertFalse(obs.getSubject().hasReference());
    subject.setProperty("reference", new StringType("Patient/other"));
    Assertions.assertEquals("Patient/other", obs.getSubject().getReference());

    // addChild - errors
    Assertions.assertThrows(FHIRException.class, () -> base.addChild("status"));
    Assertions.assertThrows(FHIRException.class, () -> base.addChild("nonsense"));

    // makeProperty - singleton: the existing value
    Base code = base.makeProperty("code");
    Assertions.assertEquals("CodeableConcept", code.fhirType());
    code.setProperty("text", new StringType("Weight"));
    Assertions.assertEquals("Weight", obs.getCode().getText());
    Assertions.assertEquals(4, code.getChildValues("coding", true).size());

    // makeProperty - list: appends
    Base cat4 = base.makeProperty("category");
    Assertions.assertEquals(4, obs.getCategory().size());
    Assertions.assertTrue(cat4.isEmpty());

    // makeProperty - primitive: the element
    Base status = base.makeProperty("status");
    Assertions.assertTrue(status.isPrimitive());
    Assertions.assertEquals("amended", status.primitiveValue());

    // makeProperty - singleton with no value: created
    Assertions.assertFalse(obs.hasMethod());
    Base method = base.makeProperty("method");
    Assertions.assertEquals("CodeableConcept", method.fhirType());
    method.setProperty("text", new StringType("scales"));
    Assertions.assertEquals("scales", obs.getMethod().getText());

    Assertions.assertThrows(FHIRException.class, () -> base.makeProperty("nonsense"));

    // removeChild - list: removes the matching value only
    org.hl7.fhir.r5.model.CodeableConcept first = obs.getCategory().get(0);
    base.removeChild("category", base.getChildValues("category", true).get(1));
    Assertions.assertEquals(3, obs.getCategory().size());
    Assertions.assertSame(first, obs.getCategory().get(0));
    Assertions.assertEquals("third", obs.getCategory().get(1).getText());
    Assertions.assertEquals(3, base.getChildValues("category", true).size());

    // removeChild - singleton
    base.removeChild("status", null);
    Assertions.assertFalse(obs.hasStatus());
    Assertions.assertFalse(base.getChildByName("status").hasValues());
    base.removeChild("method", null);
    Assertions.assertFalse(obs.hasMethod());

    Assertions.assertThrows(FHIRException.class, () -> base.removeChild("nonsense", null));
  }

  @Test
  void testNewInstance() {
    Base base = new BaseNAdaptorR5(ModelContext.fullCoreContext(), "Observation");
    Assertions.assertEquals("Observation", base.fhirType());
    Assertions.assertTrue(VersionUtilities.isR5Ver(base.getFHIRVersion()));
    Assertions.assertTrue(base.isResource());
    Assertions.assertTrue(base.isEmpty());
    Assertions.assertEquals(r5Names(new Observation().children()), names(base.getChildren()));
    for (Property p : base.getChildren()) {
      Assertions.assertFalse(p.hasValues(), p.getName());
    }
    Assertions.assertTrue(base.getChildValues("*", true).isEmpty());

    base.setProperty("status", new CodeType("final"));
    Assertions.assertFalse(base.isEmpty());
    Base coding = base.addChild("code").addChild("coding");
    coding.setProperty("system", new UriType("http://loinc.org"));
    coding.setProperty("code", new CodeType("29463-7"));
    base.setProperty("value[x]", new StringType("heavy"));

    Assertions.assertEquals("final", base.getSingleChildValue("status", true).primitiveValue());
    Base readCoding = base.getSingleChildValue("code", true).getSingleChildValue("coding", true);
    Assertions.assertEquals("http://loinc.org", readCoding.getSingleChildValue("system", true).primitiveValue());
    Assertions.assertEquals("29463-7", readCoding.getAsICoding().getCode());
    Assertions.assertEquals("heavy", base.getSingleChildValue("value", true).primitiveValue());
    Assertions.assertEquals(3, base.getChildValues("*", true).size());

    Base type = new BaseNAdaptorR5(ModelContext.fullCoreContext(), "Quantity");
    Assertions.assertEquals("Quantity", type.fhirType());
    Assertions.assertFalse(type.isResource());
    Assertions.assertTrue(type.isEmpty());
    type.setProperty("value", new DecimalType("1.50"));
    Assertions.assertEquals("1.50", type.getSingleChildValue("value", true).primitiveValue());
  }

  // --- user data ------------------------------------------------------------------------------

  @Test
  void testUserData() throws IOException {
    Patient pat = loadPatient();
    Base base = wrap(pat);

    // nothing there to start with
    Assertions.assertNull(base.getUserData("s"));
    Assertions.assertFalse(base.hasUserData("s"));
    Assertions.assertNull(base.getUserString("s"));
    Assertions.assertEquals(0, base.getUserInt("s"));
    Assertions.assertTrue(base.getUserDataNames().isEmpty());

    // set: stored on the R5 object
    base.setUserData("s", "text");
    Assertions.assertEquals("text", base.getUserData("s"));
    Assertions.assertTrue(base.hasUserData("s"));
    Assertions.assertEquals("text", base.getUserString("s"));
    Assertions.assertEquals("text", pat.getUserData("s"));

    // replace
    base.setUserData("s", "other");
    Assertions.assertEquals("other", base.getUserString("s"));
    Assertions.assertEquals("other", pat.getUserData("s"));

    // ints, and getUserString on non-strings
    base.setUserData("i", 5);
    Assertions.assertEquals(5, base.getUserInt("i"));
    Assertions.assertEquals("5", base.getUserString("i"));
    Assertions.assertThrows(ClassCastException.class, () -> base.getUserInt("s"));

    // any object
    Object o = new Object();
    base.setUserData("o", o);
    Assertions.assertSame(o, base.getUserData("o"));
    Assertions.assertSame(o, pat.getUserData("o"));

    // set on the R5 object: visible through the adaptor
    pat.setUserData("r5", "from-r5");
    Assertions.assertTrue(base.hasUserData("r5"));
    Assertions.assertEquals("from-r5", base.getUserString("r5"));

    Assertions.assertEquals(java.util.Set.of("s", "i", "o", "r5"), base.getUserDataNames());

    // an entry with a null value doesn't count
    base.setUserData("null", null);
    Assertions.assertFalse(base.hasUserData("null"));
    Assertions.assertNull(base.getUserData("null"));
    Assertions.assertNull(base.getUserString("null"));
    Assertions.assertEquals(0, base.getUserInt("null"));
    base.clearUserData("null");

    // setUserDataINN: a null value leaves things alone
    base.setUserDataINN("s", null);
    Assertions.assertEquals("other", base.getUserString("s"));
    base.setUserDataINN("inn", null);
    Assertions.assertFalse(base.hasUserData("inn"));
    Assertions.assertFalse(base.getUserDataNames().contains("inn"));
    Assertions.assertFalse(pat.getUserDataNames().contains("inn"));
    base.setUserDataINN("inn", "value");
    Assertions.assertEquals("value", base.getUserString("inn"));
    Assertions.assertEquals("value", pat.getUserData("inn"));
    base.setUserDataINN("inn", "value2");
    Assertions.assertEquals("value2", base.getUserString("inn"));

    // clear one
    base.clearUserData("s");
    Assertions.assertFalse(base.hasUserData("s"));
    Assertions.assertNull(base.getUserData("s"));
    Assertions.assertNull(pat.getUserData("s"));
    Assertions.assertFalse(base.getUserDataNames().contains("s"));
    Assertions.assertTrue(base.hasUserData("i"));
    base.clearUserData("absent");

    // clear all
    base.clearUserData();
    Assertions.assertTrue(base.getUserDataNames().isEmpty());
    Assertions.assertTrue(pat.getUserDataNames().isEmpty());
    Assertions.assertFalse(base.hasUserData("i"));
    Assertions.assertNull(pat.getUserData("r5"));
    base.clearUserData();
    base.clearUserData("i");

    // and usable again after that
    base.setUserData("again", "yes");
    Assertions.assertEquals("yes", pat.getUserData("again"));
  }

  @Test
  void testUserDataOnChildren() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);

    // the adaptor doesn't cache wrappers, but user data lives on the R5 object, so it survives re-wrapping
    Base code = base.getSingleChildValue("code", true);
    code.setUserData("mark", "code");
    Base again = base.getSingleChildValue("code", true);
    Assertions.assertNotSame(code, again);
    Assertions.assertEquals("code", again.getUserString("mark"));
    Assertions.assertEquals("code", base.getChildByName("code").getValues().get(0).getUserString("mark"));
    Assertions.assertEquals("code", base.getNamedValue("code", true)[0].getUserString("mark"));
    Assertions.assertEquals("code", obs.getCode().getUserData("mark"));

    // ... and doesn't leak to other objects
    Assertions.assertFalse(base.hasUserData("mark"));
    Assertions.assertFalse(base.getSingleChildValue("category", true).hasUserData("mark"));

    // on choice values and primitives
    base.getSingleChildValue("value", true).setUserData("mark", "value");
    Assertions.assertEquals("value", obs.getValueQuantity().getUserData("mark"));
    Assertions.assertEquals("value", base.getNamedProperty("valueQuantity", true).getValues().get(0).getUserString("mark"));
    Base status = base.getSingleChildValue("status", true);
    status.setUserData("mark", "status");
    Assertions.assertEquals("status", obs.getStatusElement().getUserData("mark"));
    Assertions.assertEquals("status", base.makeProperty("status").getUserString("mark"));

    // clearing through one wrapper clears it for all of them
    again.clearUserData("mark");
    Assertions.assertFalse(code.hasUserData("mark"));
    Assertions.assertFalse(obs.getCode().hasUserData("mark"));

    // on children that the adaptor created
    Base cat = base.addChild("category");
    cat.setUserData("mark", "new");
    Assertions.assertEquals("new", obs.getCategory().get(1).getUserData("mark"));
    Assertions.assertEquals("new", base.getChildValues("category", true).get(1).getUserString("mark"));

    // on an instance the adaptor created
    Base created = new BaseNAdaptorR5(ModelContext.fullCoreContext(), "Observation");
    created.setUserData("mark", "created");
    Assertions.assertEquals("created", created.getUserString("mark"));
    Assertions.assertEquals(java.util.Set.of("mark"), created.getUserDataNames());
  }

  private enum Colour { RED }

  private static class Holder {
    private final String value;

    Holder(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Holder(" + value + ")";
    }
  }

  @Test
  void testUserDataValueTypes() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);

    // user data values are opaque: what goes in comes out - the same instance, nothing converted or wrapped
    List<String> list = new ArrayList<>(List.of("a"));
    Map<String, Integer> map = new HashMap<>();
    map.put("k", 1);
    Holder holder = new Holder("h");
    int[] array = new int[] {1, 2};
    Map<String, Object> values = new HashMap<>();
    values.put("list", list);
    values.put("map", map);
    values.put("holder", holder);
    values.put("enum", Colour.RED);
    values.put("bool", Boolean.TRUE);
    values.put("long", 7L);
    values.put("array", array);
    for (Map.Entry<String, Object> e : values.entrySet()) {
      base.setUserData(e.getKey(), e.getValue());
    }
    for (Map.Entry<String, Object> e : values.entrySet()) {
      Assertions.assertSame(e.getValue(), base.getUserData(e.getKey()), e.getKey());
      Assertions.assertSame(e.getValue(), obs.getUserData(e.getKey()), e.getKey());
      Assertions.assertSame(e.getValue(), wrap(obs).getUserData(e.getKey()), e.getKey());
      Assertions.assertTrue(base.hasUserData(e.getKey()), e.getKey());
    }
    Assertions.assertEquals(values.keySet(), base.getUserDataNames());

    // mutable values are held by reference: later changes are visible
    list.add("b");
    map.put("k", 2);
    Assertions.assertEquals(List.of("a", "b"), wrap(obs).getUserData("list"));
    Assertions.assertEquals(2, ((Map<?, ?>) wrap(obs).getUserData("map")).get("k"));

    // getUserString is toString() for anything that isn't a String
    Assertions.assertEquals("Holder(h)", base.getUserString("holder"));
    Assertions.assertEquals("RED", base.getUserString("enum"));
    Assertions.assertEquals("true", base.getUserString("bool"));
    Assertions.assertEquals("7", base.getUserString("long"));
    Assertions.assertEquals("[a, b]", base.getUserString("list"));

    // getUserInt is only for Integers - not even other numbers
    Assertions.assertThrows(ClassCastException.class, () -> base.getUserInt("long"));
    Assertions.assertThrows(ClassCastException.class, () -> base.getUserInt("bool"));
    Assertions.assertThrows(ClassCastException.class, () -> base.getUserInt("holder"));

    // FHIR objects as values aren't converted in either direction
    StringType r6 = new StringType("r6");
    base.setUserData("r6", r6);
    Assertions.assertSame(r6, obs.getUserData("r6"), "R5 code sees the R6 object");
    org.hl7.fhir.r5.model.StringType r5 = new org.hl7.fhir.r5.model.StringType("r5");
    obs.setUserData("r5", r5);
    Assertions.assertSame(r5, base.getUserData("r5"), "R6 code sees the R5 object, not an adaptor");
    Assertions.assertFalse(base.getUserData("r5") instanceof Base);
    Base code = base.getSingleChildValue("code", true);
    base.setUserData("wrapper", code);
    Assertions.assertSame(code, obs.getUserData("wrapper"), "an adaptor stays an adaptor");
    values.put("r6", r6);
    values.put("r5", r5);
    values.put("wrapper", code);

    // copies share the values rather than copying them - the same as a native R6 copy
    Base copy = base.copy(Base.COPY_DATA);
    for (Map.Entry<String, Object> e : values.entrySet()) {
      Assertions.assertSame(e.getValue(), copy.getUserData(e.getKey()), e.getKey());
    }
    list.add("c");
    Assertions.assertEquals(3, ((List<?>) copy.getUserData("list")).size());
    StringType nativeR6 = new StringType("native");
    nativeR6.setUserData("list", list);
    Assertions.assertSame(list, nativeR6.copy(Base.COPY_DATA).getUserData("list"));

    // and so does copyUserData, into an adaptor or a native R6 object
    Base other = wrap(loadObservation());
    other.copyUserData(base);
    StringType target = new StringType("target");
    target.copyUserData(base);
    for (Map.Entry<String, Object> e : values.entrySet()) {
      Assertions.assertSame(e.getValue(), other.getUserData(e.getKey()), e.getKey());
      Assertions.assertSame(e.getValue(), target.getUserData(e.getKey()), e.getKey());
    }
  }

  @Test
  void testCopyUserData() throws IOException {
    Base a = wrap(loadPatient());
    Base b = wrap(loadPatient());
    a.setUserData("x", 1);
    a.setUserData("y", 2);
    b.setUserData("y", 3);
    b.setUserData("z", 4);

    // merges: shared names are overwritten, others are kept
    a.copyUserData(b);
    Assertions.assertEquals(java.util.Set.of("x", "y", "z"), a.getUserDataNames());
    Assertions.assertEquals(1, a.getUserInt("x"));
    Assertions.assertEquals(3, a.getUserInt("y"));
    Assertions.assertEquals(4, a.getUserInt("z"));
    // the source is unchanged
    Assertions.assertEquals(java.util.Set.of("y", "z"), b.getUserDataNames());
    Assertions.assertEquals(3, b.getUserInt("y"));

    // nothing to copy
    a.copyUserData(wrap(loadPatient()));
    Assertions.assertEquals(java.util.Set.of("x", "y", "z"), a.getUserDataNames());

    // from itself, or another wrapper of the same object
    a.copyUserData(a);
    Assertions.assertEquals(java.util.Set.of("x", "y", "z"), a.getUserDataNames());
    Assertions.assertEquals(3, a.getUserInt("y"));

    // from a native R6 object
    StringType r6 = new StringType("native");
    r6.setUserData("z", 5);
    r6.setUserData("n", "native");
    a.copyUserData(r6);
    Assertions.assertEquals(5, a.getUserInt("z"));
    Assertions.assertEquals("native", a.getUserString("n"));
    Assertions.assertEquals(java.util.Set.of("x", "y", "z", "n"), a.getUserDataNames());

    // to a native R6 object
    StringType target = new StringType("target");
    target.setUserData("t", "kept");
    target.copyUserData(b);
    Assertions.assertEquals(java.util.Set.of("t", "y", "z"), target.getUserDataNames());
    Assertions.assertEquals(3, target.getUserInt("y"));
    Assertions.assertEquals("kept", target.getUserString("t"));
  }

  @Test
  void testCopyAndUserData() throws IOException {
    Observation obs = loadObservation();
    Base base = wrap(obs);
    Object shared = new Object();
    base.setUserData("top", "observation");
    base.setUserData("shared", shared);
    base.getSingleChildValue("code", true).getChildValues("coding", true).get(1).setUserData("deep", "coding");
    base.getSingleChildValue("value", true).getSingleChildValue("value", true).setUserData("deep", "decimal");

    // COPY_NOTHING: the content, but no user data
    Base copy = base.copy(Base.COPY_NOTHING);
    Assertions.assertEquals("Observation", copy.fhirType());
    Assertions.assertTrue(VersionUtilities.isR5Ver(copy.getFHIRVersion()));
    Assertions.assertEquals("185", copy.getSingleChildValue("value", true).getSingleChildValue("value", true).primitiveValue());
    Assertions.assertTrue(copy.getUserDataNames().isEmpty());
    Assertions.assertFalse(copy.getSingleChildValue("code", true).getChildValues("coding", true).get(1).hasUserData("deep"));
    Assertions.assertFalse(copy.getSingleChildValue("value", true).getSingleChildValue("value", true).hasUserData("deep"));

    // the copy is independent of the original
    copy.setProperty("status", new CodeType("cancelled"));
    Assertions.assertEquals(Enumerations.ObservationStatus.FINAL, obs.getStatus());
    Assertions.assertEquals("cancelled", copy.getSingleChildValue("status", true).primitiveValue());

    // COPY_DATA: user data at every level
    for (java.util.EnumSet<Base.CopyObjectOptions> options : List.of(Base.COPY_DATA, Base.COPY_ALL)) {
      copy = base.copy(options);
      Assertions.assertEquals(java.util.Set.of("top", "shared"), copy.getUserDataNames(), options.toString());
      Assertions.assertEquals("observation", copy.getUserString("top"), options.toString());
      Assertions.assertSame(shared, copy.getUserData("shared"), options.toString());
      Base coding = copy.getSingleChildValue("code", true).getChildValues("coding", true).get(1);
      Assertions.assertEquals("coding", coding.getUserString("deep"), options.toString());
      Assertions.assertFalse(copy.getSingleChildValue("code", true).getChildValues("coding", true).get(0).hasUserData("deep"), options.toString());
      Assertions.assertEquals("decimal", copy.getSingleChildValue("value", true).getSingleChildValue("value", true).getUserString("deep"), options.toString());

      // the copy's user data is its own
      copy.setUserData("top", "copy");
      copy.clearUserData("shared");
      coding.clearUserData();
      Assertions.assertEquals("observation", base.getUserString("top"), options.toString());
      Assertions.assertSame(shared, base.getUserData("shared"), options.toString());
      Assertions.assertEquals("coding", base.getSingleChildValue("code", true).getChildValues("coding", true).get(1).getUserString("deep"), options.toString());
    }
  }
}