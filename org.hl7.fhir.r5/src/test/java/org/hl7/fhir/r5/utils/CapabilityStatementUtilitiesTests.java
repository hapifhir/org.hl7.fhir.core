package org.hl7.fhir.r5.utils;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.CapabilityStatementUtilities;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


class CapabilityStatementUtilitiesTests {

  private static final String SHALL = "SHALL";
  private static final String SHOULD = "SHOULD";
  private static final String MAY = "MAY";
  private static final Enumeration VP_NOVERSION = (new CapabilityStatement.ResourceVersionPolicyEnumFactory()).fromType(new CodeType("no-version"));
  private static final Enumeration VP_VERSIONED = (new CapabilityStatement.ResourceVersionPolicyEnumFactory()).fromType(new CodeType("versioned"));
  private static final Enumeration VP_VERSIONEDUPDATE = (new CapabilityStatement.ResourceVersionPolicyEnumFactory()).fromType(new CodeType("versioned-update"));
  private static final Enumeration CD_NOTSUPPORTED = (new CapabilityStatement.ConditionalDeleteStatusEnumFactory()).fromType(new CodeType("not-supported"));
  private static final Enumeration CD_SINGLE = (new CapabilityStatement.ConditionalDeleteStatusEnumFactory()).fromType(new CodeType("single"));
  private static final Enumeration CD_MULTIPLE = (new CapabilityStatement.ConditionalDeleteStatusEnumFactory()).fromType(new CodeType("multiple"));
  private static final Enumeration CR_NOTSUPPORTED = (new CapabilityStatement.ConditionalReadStatusEnumFactory()).fromType(new CodeType("not-supported"));
  private static final Enumeration CR_MODIFIEDSINCE = (new CapabilityStatement.ConditionalReadStatusEnumFactory()).fromType(new CodeType("modified-since"));
  private static final Enumeration CR_NOTMATCH = (new CapabilityStatement.ConditionalReadStatusEnumFactory()).fromType(new CodeType("not-match"));
  private static final Enumeration CR_FULLSUPPORT = (new CapabilityStatement.ConditionalReadStatusEnumFactory()).fromType(new CodeType("full-support"));

  private CapabilityStatementUtilities csu;
  private IWorkerContext ctxt;

  CapabilityStatementUtilitiesTests() {
    ctxt = TestingUtilities.getSharedWorkerContext();
    csu = new CapabilityStatementUtilities(ctxt);
  }

  @Test
  @Disabled
  void testOverall() {
    IParser p = new XmlParser(false);

    CapabilityStatement c1 = null;
    CapabilityStatement c2 = null;
    CapabilityStatement expected = null;
    try {
      InputStream strm1 = TestingUtilities.loadTestResourceStream("r5", "capabilitystatement-import", "CapabilityStatement-1.xml");
      InputStream strm2 = TestingUtilities.loadTestResourceStream("r5", "capabilitystatement-import", "CapabilityStatement-2.xml");
      InputStream strm3 = TestingUtilities.loadTestResourceStream("r5", "capabilitystatement-import", "CapabilityStatement-2merged.xml");
      c1 = (CapabilityStatement)p.parse(strm1);
      c2 = (CapabilityStatement)p.parse(strm2);
      expected = (CapabilityStatement)p.parse(strm3);
    } catch (IOException e) {
    }
    if (c1==null || c2==null)
      Assertions.fail("Unable to read source CapabilityStatements");

    ctxt.getManager().cacheResource(c1);
    CapabilityStatement out = csu.resolveImports(c2);
    try {
      String s1 = p.composeString(out);
      String s2 = p.composeString(expected);
      Assertions.assertEquals(s1, s2, "Merged capability statement must match expected value");
    } catch (IOException e) {
      Assertions.fail("Error serializing CapabilityStatements.");
    }
  }

  @Test
  void testMergeList() {
    List<CanonicalType> l1 = new ArrayList<>();
    List<CanonicalType> l2 = new ArrayList<>();
    l1.add(makeCanonical("http://foo.bar/1", null));
    l1.add(makeCanonical("http://foo.bar/2", SHALL));
    l1.add(makeCanonical("http://foo.bar/3", SHOULD));
    l1.add(makeCanonical("http://foo.bar/4", MAY));
    l1.add(makeCanonical("http://foo.bar/5", MAY));
    l1.add(makeCanonical("http://foo.bar/6", MAY));

    l2.add(makeCanonical("http://foo.bar/1", SHOULD));
    l2.add(makeCanonical("http://foo.bar/2", SHALL));
    l2.add(makeCanonical("http://foo.bar/3", MAY));
    l2.add(makeCanonical("http://foo.bar/4", SHOULD));
    l2.add(makeCanonical("http://foo.bar/5", null));
    l2.add(makeCanonical("http://foo.bar/7", null));

    List<CanonicalType> l = l1.subList(0, l1.size());
    mergeIntrospect(l1, l2, "test");
    Assertions.assertTrue(l1.size() == 7);
    Assertions.assertTrue(hasConformanceElement(l1, new CanonicalType("http://foo.bar/1"), SHOULD));
    Assertions.assertTrue(hasConformanceElement(l1, new CanonicalType("http://foo.bar/2"), SHALL));
    Assertions.assertTrue(hasConformanceElement(l1, new CanonicalType("http://foo.bar/3"), SHOULD));
    Assertions.assertTrue(hasConformanceElement(l1, new CanonicalType("http://foo.bar/4"), SHOULD));
    Assertions.assertTrue(hasConformanceElement(l1, new CanonicalType("http://foo.bar/5"), MAY));
    Assertions.assertTrue(hasConformanceElement(l1, new CanonicalType("http://foo.bar/6"), MAY));
    Assertions.assertTrue(hasConformanceElement(l1, new CanonicalType("http://foo.bar/7"), null));
  }

  @Test
  void testMergeBoolean() {
    Assertions.assertThrows(FHIRException.class,
      () ->  mergeIntrospect(makeBool(true, null), makeBool(false, null), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeBool(false, null), makeBool(true, null), "test"));

    Assertions.assertThrows(FHIRException.class,
      () ->  mergeIntrospect(makeBool(true, null), makeBool(false, SHALL), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeBool(false, MAY), makeBool(true, null), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeBool(false, SHALL), makeBool(true, SHALL), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () -> mergeIntrospect(makeBool(false, SHOULD), makeBool(true, SHOULD), "test"));

    BooleanType b1 =  mergeIntrospect(makeBool(false, SHALL), makeBool(true, SHOULD), "test");
    Assertions.assertEquals(b1.getValue(), false);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    b1 =  mergeIntrospect(makeBool(false, SHOULD), makeBool(true, SHALL), "test");
    Assertions.assertEquals(b1.getValue(), true);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    b1 =  mergeIntrospect(makeBool(false, SHALL), makeBool(true, MAY), "test");
    Assertions.assertEquals(b1.getValue(), false);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    b1 =  mergeIntrospect(makeBool(false, MAY), makeBool(true, SHALL), "test");
    Assertions.assertEquals(b1.getValue(), true);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    b1 =  mergeIntrospect(makeBool(true, MAY), makeBool(true, SHALL), "test");
    Assertions.assertEquals(b1.getValue(), true);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    b1 =  mergeIntrospect(makeBool(false, SHOULD), makeBool(true, MAY), "test");
    Assertions.assertEquals(b1.getValue(), false);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    b1 =  mergeIntrospect(makeBool(false, MAY), makeBool(true, SHOULD), "test");
    Assertions.assertEquals(b1.getValue(), true);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    b1 =  mergeIntrospect(makeBool(true, MAY), makeBool(true, SHOULD), "test");
    Assertions.assertEquals(b1.getValue(), true);
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);
  }

  @Test
  void testMergeInt() {
    Assertions.assertThrows(FHIRException.class,
      () ->  mergeIntrospect(makeInt(1, null), makeInt(2, null), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeInt(2, null), makeInt(1, null), "test"));

    Assertions.assertThrows(FHIRException.class,
      () ->  mergeIntrospect(makeInt(1, null), makeInt(2, SHALL), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeInt(1, MAY), makeInt(2, null), "test"));

    IntegerType i1 =  mergeIntrospect(makeInt(1, SHALL), makeInt(2, SHOULD), "test");
    Assertions.assertEquals(i1.getValue(), 1);
    Assertions.assertEquals(i1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    i1 =  mergeIntrospect(makeInt(1, SHOULD), makeInt(2, SHALL), "test");
    Assertions.assertEquals(i1.getValue(), 2);
    Assertions.assertEquals(i1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    i1 =  mergeIntrospect(makeInt(2, SHOULD), makeInt(1, MAY), "test");
    Assertions.assertEquals(i1.getValue(), 2);
    Assertions.assertEquals(i1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    i1 =  mergeIntrospect(makeInt(2, MAY), makeInt(1, SHOULD), "test");
    Assertions.assertEquals(i1.getValue(), 2);
    Assertions.assertEquals(i1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), MAY);

    i1 =  mergeIntrospect(makeInt(2, MAY), makeInt(1, SHALL), "test");
    Assertions.assertEquals(i1.getValue(), 1);
    Assertions.assertEquals(i1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);
  }

  @Test
  void testMergeCode() {
    Assertions.assertThrows(FHIRException.class,
      () ->  mergeIntrospect(makeCode(CR_FULLSUPPORT, null), makeCode(CR_NOTSUPPORTED, null), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeCode(CD_MULTIPLE, null), makeCode(CD_SINGLE, null), "test"));

    Assertions.assertThrows(FHIRException.class,
      () ->  mergeIntrospect(makeCode(VP_NOVERSION, null), makeCode(VP_VERSIONED, SHALL), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeCode(VP_VERSIONED, MAY), makeCode(VP_VERSIONEDUPDATE, null), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeCode(CR_NOTSUPPORTED, SHALL), makeCode(CR_MODIFIEDSINCE, SHALL), "test"));

    Assertions.assertThrowsExactly(FHIRException.class,
      () ->  mergeIntrospect(makeCode(CR_NOTMATCH, SHOULD), makeCode(CR_MODIFIEDSINCE, SHOULD), "test"));

    Enumeration c1 =  mergeIntrospect(makeCode(VP_VERSIONED, SHALL), makeCode(VP_VERSIONEDUPDATE, SHOULD), "test");
    Assertions.assertEquals(c1.getValueAsString(), VP_VERSIONED.getCode());
    Assertions.assertEquals(c1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    c1 =  mergeIntrospect(makeCode(VP_VERSIONED, SHOULD), makeCode(VP_VERSIONEDUPDATE, SHALL), "test");
    Assertions.assertEquals(c1.getValueAsString(), VP_VERSIONEDUPDATE.getCode());
    Assertions.assertEquals(c1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    c1 =  mergeIntrospect(makeCode(VP_VERSIONED, SHOULD), makeCode(VP_NOVERSION, MAY), "test");
    Assertions.assertEquals(c1.getValueAsString(), VP_VERSIONED.getCode());
    Assertions.assertEquals(c1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    c1 =  mergeIntrospect(makeCode(VP_VERSIONED, MAY), makeCode(VP_NOVERSION, SHOULD), "test");
    Assertions.assertEquals(c1.getValueAsString(), VP_VERSIONED.getCode());
    Assertions.assertEquals(c1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), MAY);

    c1 =  mergeIntrospect(makeCode(CD_SINGLE, MAY), makeCode(CD_NOTSUPPORTED, SHALL), "test");
    Assertions.assertEquals(c1.getValueAsString(), CD_NOTSUPPORTED.getCode());
    Assertions.assertEquals(c1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);
  }

  @Test
  void testMergeExpectations() {
    // null, null -> null
    BooleanType b1 = makeBool(true, null);
    csu.mergeExpectations(b1, makeBool(true, null), "SHALL");
    Assertions.assertEquals(b1.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT), false);

    // SHALL, null -> SHALL
    b1 = makeBool(true, SHALL);
    csu.mergeExpectations(b1, makeBool(true, null), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    // SHOULD, null -> SHOULD
    b1 = makeBool(true, SHOULD);
    csu.mergeExpectations(b1, makeBool(true, null), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    // MAY, null -> MAY
    b1 = makeBool(true, MAY);
    csu.mergeExpectations(b1, makeBool(true, null), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), MAY);

    // null, SHALL -> SHALL
    b1 = makeBool(true, null);
    csu.mergeExpectations(b1, makeBool(true, SHALL), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    // null, SHOULD -> SHOULD
    b1 = makeBool(true, null);
    csu.mergeExpectations(b1, makeBool(true, SHOULD), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    // null, MAY -> MAY
    b1 = makeBool(true, null);
    csu.mergeExpectations(b1, makeBool(true, MAY), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), MAY);

    // SHALL, SHALL -> SHALL
    b1 = makeBool(true, SHALL);
    csu.mergeExpectations(b1, makeBool(true, SHALL), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    // SHALL, SHOULD -> SHALL
    b1 = makeBool(true, SHALL);
    csu.mergeExpectations(b1, makeBool(true, SHOULD), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    // SHALL, MAY -> SHALL
    b1 = makeBool(true, SHALL);
    csu.mergeExpectations(b1, makeBool(true, MAY), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    // SHOULD, SHALL -> SHALL
    b1 = makeBool(true, SHOULD);
    csu.mergeExpectations(b1, makeBool(true, SHALL), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    // SHOULD, SHOULD -> SHOULD
    b1 = makeBool(true, SHOULD);
    csu.mergeExpectations(b1, makeBool(true, SHOULD), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    // SHOULD, MAY -> SHOULD
    b1 = makeBool(true, SHOULD);
    csu.mergeExpectations(b1, makeBool(true, MAY), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    // MAY, SHALL -> SHALL
    b1 = makeBool(true, MAY);
    csu.mergeExpectations(b1, makeBool(true, SHALL), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHALL);

    // MAY, SHOULD -> SHOULD
    b1 = makeBool(true, MAY);
    csu.mergeExpectations(b1, makeBool(true, SHOULD), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), SHOULD);

    // MAY, MAY -> MAY
    b1 = makeBool(true, MAY);
    csu.mergeExpectations(b1, makeBool(true, MAY), "SHALL");
    Assertions.assertEquals(b1.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode(), MAY);
  }

  private CanonicalType makeCanonical(String url, String conformance) {
    CanonicalType c = new CanonicalType(url);
    if (conformance != null)
      c.addExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT, new CodeType(conformance));
    return c;
  }

  private BooleanType makeBool(boolean aBool, String conformance) {
    BooleanType b = new BooleanType(aBool);
    if (conformance != null)
      b.addExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT, new CodeType(conformance));
    return b;
  }

  private UnsignedIntType makeInt(int anInt, String conformance) {
    UnsignedIntType i = new UnsignedIntType(anInt);
    if (conformance != null)
      i.addExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT, new CodeType(conformance));
    return i;
  }

  private Enumeration makeCode(Enumeration aCode, String conformance) {
    Enumeration c = aCode.copy();
    if (conformance != null)
      c.addExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT, new CodeType(conformance));
    return c;
  }

  private boolean hasConformanceElement(List l, DataType d, String conformance) {
    for (Object o: l) {
      if (((DataType)o).toString().equals(d.toString())) {
        Extension e = ((DataType) o).getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT);
        if (e == null)
          return conformance==null;
        else if (e.getValueCodeType().getCode().equals(conformance))
          return true;
        else
          return false;
      }
    }
    return false;
  }

  private void mergeIntrospect(List target, List imported, String context) throws FHIRException {
    try {
      Method method = CapabilityStatementUtilities.class.getDeclaredMethod("merge", List.class, List.class, String.class);
      method.setAccessible(true);
      method.invoke(csu, target, imported, context);
    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new Error("Bad introspection");
    } catch (InvocationTargetException e) {
      throw (FHIRException) e.getTargetException();
    }
  }

  private UnsignedIntType mergeIntrospect(UnsignedIntType targetInt, UnsignedIntType importedInt, String context) throws FHIRException {
    try {
      Method method = CapabilityStatementUtilities.class.getDeclaredMethod("merge", UnsignedIntType.class, UnsignedIntType.class, String.class);
      method.setAccessible(true);
      return (UnsignedIntType)method.invoke(csu, targetInt, importedInt, context);
    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new Error("Bad introspection");
    } catch (InvocationTargetException e) {
      throw (FHIRException) e.getTargetException();
    }
  }

  private BooleanType mergeIntrospect(BooleanType targetBool, BooleanType importedBool, String context) throws FHIRException {
    try {
      Method method = CapabilityStatementUtilities.class.getDeclaredMethod("merge", BooleanType.class, BooleanType.class, String.class);
      method.setAccessible(true);
      return (BooleanType)method.invoke(csu, targetBool, importedBool, context);
    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new Error("Bad introspection");
    } catch (InvocationTargetException e) {
      throw (FHIRException) e.getTargetException();
    }
  }

  private Enumeration mergeIntrospect(Enumeration targetCode, Enumeration importedCode, String context) throws FHIRException {
    try {
      Method method = CapabilityStatementUtilities.class.getDeclaredMethod("merge", Enumeration.class, Enumeration.class, String.class);
      method.setAccessible(true);
      return (Enumeration)method.invoke(csu, targetCode, importedCode, context);
    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new Error("Bad introspection");
    } catch (InvocationTargetException e) {
      throw (FHIRException) e.getTargetException();
    }
  }
}