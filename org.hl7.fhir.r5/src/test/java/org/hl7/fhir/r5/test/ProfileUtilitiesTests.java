package org.hl7.fhir.r5.test;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileUtilitiesTests {

  //  /**
//   * This is simple: we just create an empty differential, generate the snapshot, and then insist it must match the base 
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
  @Test
  public void testSimple() throws FHIRException, FileNotFoundException, IOException, UcumException {

    StructureDefinition focus = new StructureDefinition();
    StructureDefinition base = TestingUtilities.context().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
    focus.setUrl(Utilities.makeUuidUrn());
    focus.setBaseDefinition(base.getUrl());
    focus.setType("Patient");
    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    new ProfileUtilities(TestingUtilities.context(), messages, null).generateSnapshot(base, focus, focus.getUrl(), "http://test.org/test", "Simple Test");

    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size();
    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
      ElementDefinition b = base.getSnapshot().getElement().get(i);
      ElementDefinition f = focus.getSnapshot().getElement().get(i);
      if (ok) {
        if (!f.hasBase())
          ok = false;
        else if (!b.getPath().equals(f.getPath()))
          ok = false;
        else {
          b.setBase(null);
          f.setBase(null);
          b.setRequirements(null);
          f.setRequirements(null);
          ok = Base.compareDeep(b, f, true);
        }
      }
    }

    if (!ok) {
      compareXml(base, focus);
      throw new FHIRException("Snap shot generation simple test failed");
    } else
      System.out.println("Snap shot generation simple test passed");
  }


  //
//  /**
//   * This is simple: we just create an empty differential, generate the snapshot, and then insist it must match the base. for a different resource with recursion 
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
  @Test
  public void testSimple2() throws EOperationOutcome, Exception {
    StructureDefinition base = TestingUtilities.context().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/ValueSet").copy();
    StructureDefinition focus = base.copy();
    focus.setUrl(Utilities.makeUuidUrn());
    focus.setSnapshot(null);
    focus.setDifferential(null);
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    new ProfileUtilities(TestingUtilities.context(), messages, null).generateSnapshot(base, focus, focus.getUrl(), "http://test.org", "Simple Test");

    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size();
    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
      if (ok) {
        ElementDefinition b = base.getSnapshot().getElement().get(i);
        ElementDefinition f = focus.getSnapshot().getElement().get(i);
        if (!f.hasBase() || !b.getPath().equals(f.getPath()))
          ok = false;
        else {
          f.setBase(null);
          b.setBase(null);
          b.setRequirements(null);
          f.setRequirements(null);
          b.setComment(null);
          f.setComment(null);
          b.setDefinition(null);
          f.setDefinition(null);
          ok = Base.compareDeep(b, f, true);
        }
      }
    }

    if (!ok) {
      compareXml(base, focus);
      System.out.println("Snap shot generation simple test failed");
      throw new FHIRException("Snap shot generation simple test failed");
    } else
      System.out.println("Snap shot generation simple test passed");
  }

//  /**
//   * Change one cardinality.
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
//  private void testCardinalityChange() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier");
//    id.setMin(1);
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size();
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.identifier")) {
//            ok = f.getMin() == 1;
//            if (ok)
//              f.setMin(0);
//          }
//          ok = ok && Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation chenge cardinality test failed");
//    } else 
//      System.out.println("Snap shot generation chenge cardinality test passed");
//  }
//
//  /**
//   * check that documentation appending is working
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
//  private void testDocumentationAppend() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier");
//    id.setDefinition("... some more doco");
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size();
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.identifier")) {
//            ok = f.getDefinition().length() > b.getDefinition().length();
//            if (ok) {
//              f.setDefinition(null);
//              b.setDefinition(null);
//            }
//          }
//          ok = ok && Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation documentation append failed");
//    } else 
//      System.out.println("Snap shot generation documentation append test passed");
//  }
//
//  
//  /**
//   * check that narrowing types is working
//   * this one doesn't rename the path
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
//  private void textTypeNarrowing1() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.deceased[x]");
//    id.addType().setCode("dateTime");
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size();
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.deceasedDateTime")) {
//            ok = f.getType().size() == 1 && f.getType().get(0).getCode().equals("dateTime");
//            if (ok) {
//              f.getType().clear();
//              b.getType().clear();
//              f.setPath(b.getPath());
//            }
//          }
//          ok = ok && Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation narrow type 1 failed");
//    } else 
//      System.out.println("Snap shot generation narrow type 1 test passed");
//  }
//  
//  /**
//   * check that narrowing types is working
//   * this one renames the path
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
//  private void textTypeNarrowing2() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.deceasedDateTime");
//    id.addType().setCode("dateTime");
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size();
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.deceasedDateTime")) {
//            ok = f.getType().size() == 1 && f.getType().get(0).getCode().equals("dateTime");
//            if (ok) {
//              f.getType().clear();
//              b.getType().clear();
//              f.setPath(b.getPath());
//            }
//          }
//          ok = ok && Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation narrow type 2 failed");
//    } else 
//      System.out.println("Snap shot generation narrow type 2 test passed");
//  }
//
//  /**
//   * check that mapping resolution is working
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
//  private void testMapping() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier");
//    id.addMapping().setIdentity("rim").setMap("test");
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size();
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.identifier")) {
//            ok = f.getMapping().size() > b.getMapping().size();
//            if (ok) {
//              f.getMapping().clear();
//              b.getMapping().clear();
//            }
//          }
//          ok = ok && Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation mapping changes failed");
//    } else 
//      System.out.println("Snap shot generation mapping changes test passed");
//  }
//
//  /**
//   * Walking into a type 
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
//  private void testTypeWalk() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier");
//    id.setMustSupport(true);
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier.system");
//    id.setMustSupport(true);
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    // the derived should be 8 longer
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size() - 8;
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i <= 9 ? i : i + 8);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.identifier")) {
//            ok = f.getMustSupport() && !b.getMustSupport();
//            if (ok) {
//              f.setMustSupportElement(null);
//            }
//          }
//          ok = Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation simple test failed");
//    } else 
//      System.out.println("Snap shot generation simple test passed");
//  }
//
//  /**
//   * Walking into a type, without explicitly doing so 
//   * 
//   * note: this currently fails.
//   * 
//   * @param context2
//   * @
//   * @throws EOperationOutcome 
//   */
//  private void testTypeWalk2() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier.system");
//    id.setMustSupport(true);
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    // the derived should be 8 longer
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size() - 8;
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i <= 9 ? i : i + 8);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.identifier")) {
//            ok = f.getMustSupport() && !b.getMustSupport();
//            if (ok) {
//              f.setMustSupportElement(null);
//            }
//          }
//          ok = Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation simple test failed");
//    } else 
//      System.out.println("Snap shot generation simple test passed");
//  }
//
//  
//  /**
//   * we're going to slice Patient.identifier
//   */
//  private void testSlicingSimple() throws EOperationOutcome, Exception {
//    
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    
//    // set the slice up
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier");
//    id.getSlicing().setOrdered(false).setRules(SlicingRules.OPEN).addDiscriminator().setPath("use").setType(DiscriminatorType.VALUE);
//    
//    // first slice: 
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier");
//    id.setSliceName("name1");
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier.use");
//    id.setFixed(new CodeType("usual"));
//    
//    // second slice:
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier");
//    id.setSliceName("name2");
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.identifier.use");
//    id.setFixed(new CodeType("official"));
//    
//    
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    // 18 different: identifier + 8 inner children * 2 
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size() - 18;
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i <= 9 ? i : i + 18);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.identifier")) {
//            ok = f.hasSlicing();
//            if (ok)
//              f.setSlicing(null);
//          }            
//          ok = Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    // now, check that the slices we skipped are correct:
//    for (int i = 10; i <= 18; i++) {
//      if (ok) {
//        ElementDefinition d1 = focus.getSnapshot().getElement().get(i);
//        ElementDefinition d2 = focus.getSnapshot().getElement().get(i+9);
//        if (d1.getPath().equals("Patient.identifier.use")) {
//          ok = d1.hasFixed() && d2.hasFixed() && !Base.compareDeep(d1.getFixed(), d2.getFixed(), true);
//          if (ok) {
//            d1.setFixed(null);
//            d2.setFixed(null);
//          }
//        }
//        if (d1.getPath().equals("Patient.identifier")) {
//          ok = d1.hasSliceName() && d2.hasSliceName() && !Base.compareDeep(d1.getSliceNameElement(), d2.getSliceNameElement(), true);
//          if (ok) {
//            d1.setSliceName(null);
//            d2.setSliceName(null);
//          }
//        }
//        ok = Base.compareDeep(d1, d2, true);
//      }
//    }
//    // for throughness, we could check against identifier too, but this is not done now.
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation slicing failed");
//    } else 
//      System.out.println("Snap shot generation slicing passed");
//    
//  }
//
//  /**
//   * we're going to slice Patient.extension and refer to extension by profile
//   * 
//   * implicit: whether to rely on implicit extension slicing
//   */
//  private void testSlicingExtension(boolean implicit) throws EOperationOutcome, Exception {
//    
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    
//    // set the slice up
//    ElementDefinition id;
//    if (!implicit) {
//      id = focus.getDifferential().addElement();
//      id.setPath("Patient.extension");
//      id.getSlicing().setOrdered(false).setRules(SlicingRules.OPEN).addDiscriminator().setPath("url").setType(DiscriminatorType.VALUE);
//      id.setMax("3");
//    }
//    // first slice: 
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.extension");
//    id.setSliceName("name1");
//    id.addType().setCode("Extension").setProfile("http://hl7.org/fhir/StructureDefinition/patient-birthTime");
//    id.setMin(1);
//    
//    // second slice:
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.extension");
//    id.setSliceName("name2");
//    id.addType().setCode("Extension").setProfile("http://hl7.org/fhir/StructureDefinition/patient-mothersMaidenName");    
//    
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    ProfileUtilities pu = new ProfileUtilities(context, messages, null);
//    pu.generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    // 2 different: extension slices 
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size() - 2;
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i <= 7 ? i : i + 2);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.extension")) {
//            ok = f.hasSlicing() && (implicit || f.getMax().equals("3"));
//            if (ok) {
//              f.setSlicing(null);
//              f.setMaxElement(b.getMaxElement());
//            }
//          }            
//          if (!f.getPath().equals("Patient.extension")) // no compare that because the definitions get overwritten 
//            ok = Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    // now, check that the slices we skipped are correct:
//    if (ok) {
//      ElementDefinition d1 = focus.getSnapshot().getElement().get(8);
//      ElementDefinition d2 = focus.getSnapshot().getElement().get(9);
//      ok = d1.hasType() && d1.getType().get(0).hasProfile() && d2.hasType() && d2.getType().get(0).hasProfile() && !Base.compareDeep(d1.getType(), d2.getType(), true) &&
//            d1.getMin() == 1 && d2.getMin() == 0 && d1.getMax().equals("1") && d2.getMax().equals("1");
//      if (ok) {
//        d1.getType().clear();
//        d2.getType().clear();
//        d1.setSliceName("x");
//        d2.setSliceName("x");
//        d1.setMin(0);
//      }
//      ok = Base.compareDeep(d1, d2, true);
//      // for throughness, we could check against extension too, but this is not done now.
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation slicing extensions simple ("+(implicit ? "implicit" : "not implicit")+") failed");
//    } else 
//      System.out.println("Snap shot generation slicing extensions simple ("+(implicit ? "implicit" : "not implicit")+") passed");
//  }
//
//  /**
//   * we're going to slice Patient.extension and refer to extension by profile. one of the extensions is complex, and we're going to walk into 
//   * it and make it must support
//   * 
//   * implicit: whether to rely on implicit extension slicing
//   */
//  private void testSlicingExtensionComplex(boolean implicit) throws EOperationOutcome, Exception {
//    
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Patient").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    
//    // set the slice up
//    ElementDefinition id;
//    if (!implicit) {
//      id = focus.getDifferential().addElement();
//      id.setPath("Patient.extension");
//      id.getSlicing().setOrdered(false).setRules(SlicingRules.OPEN).addDiscriminator().setPath("url").setType(DiscriminatorType.VALUE);
//    }
//    // first slice  - a simple one to get us going: 
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.extension");
//    id.setSliceName("simple");
//    id.addType().setCode("Extension").setProfile("http://hl7.org/fhir/StructureDefinition/patient-birthTime");
//    
//    // second slice - the complex one
//    // we walk into this and fix properties on the inner extensions
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.extension");
//    id.setSliceName("complex");
//    id.addType().setCode("Extension").setProfile("http://hl7.org/fhir/StructureDefinition/patient-nationality");
//    if (!implicit) {
//      id = focus.getDifferential().addElement();
//      id.setPath("Patient.extension.extension");
//      id.getSlicing().setOrdered(false).setRules(SlicingRules.OPEN).addDiscriminator().setPath("url").setType(DiscriminatorType.VALUE);
//    }
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.extension.extension");
//    id.setSliceName("code");
//    id.setMustSupport(true);
//    id.addType().setCode("Extension").setProfile("http://hl7.org/fhir/StructureDefinition/patient-nationality#code");
//    
//    id = focus.getDifferential().addElement();
//    id.setPath("Patient.extension.extension");
//    id.setSliceName("period");
//    id.addType().setCode("Extension").setProfile("http://hl7.org/fhir/StructureDefinition/patient-nationality#period");
//    id.setMax("0"); // prohibit this one....
//        
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    // ok, there's going to 1 (simple) + complex: 1 + id + extnesion.slice + extension.code + (4 inside from that) + extension.period + (4 inside from that) + value + url = 16
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size() - 16;
//    
//    // custom checks
//    ok = ok && rule(focus.getSnapshot().getElement().get(7).getPath().equals("Patient.extension"), "element 7 (base) path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(7).hasSlicing(), "element 7 slicing");
//    ok = ok && rule(focus.getSnapshot().getElement().get(8).getPath().equals("Patient.extension"), "element 8 (1st slice) path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(8).getSliceName().equals("simple"), "element 8 (1st slice) name");
//    ok = ok && rule(focus.getSnapshot().getElement().get(8).getType().get(0).getProfile().equals("http://hl7.org/fhir/StructureDefinition/patient-birthTime"), "element 9 (2nd slice) profile name");
//    ok = ok && rule(focus.getSnapshot().getElement().get(9).getPath().equals("Patient.extension"), "element 9 (2nd slice) path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(9).getSliceName().equals("complex"), "element 8 (1st slice) name");
//    ok = ok && rule(focus.getSnapshot().getElement().get(9).getType().get(0).getProfile().equals("http://hl7.org/fhir/StructureDefinition/patient-nationality"), "element 9 (2nd slice) profile name");
//    ok = ok && rule(focus.getSnapshot().getElement().get(10).getPath().equals("Patient.extension.id"), "element 10 (2nd slice).id path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(11).getPath().equals("Patient.extension.extension"), "element 11 (2nd slice).extension path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(12).getPath().equals("Patient.extension.extension"), "element 12 (2nd slice).extension path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(12).getMustSupport(), "element 12 (2nd slice).extension must support");
//    ok = ok && rule(focus.getSnapshot().getElement().get(13).getPath().equals("Patient.extension.extension.id"), "element 13 (2nd slice).extension.id path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(14).getPath().equals("Patient.extension.extension.extension"), "element 14 (2nd slice).extension.extension path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(15).getPath().equals("Patient.extension.extension.url"), "element 15 (2nd slice).extension.url path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(16).getPath().equals("Patient.extension.extension.valueCodeableConcept"), "element 16 (2nd slice).extension.valueCodeableConcept path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(17).getPath().equals("Patient.extension.extension"), "element 17 (2nd slice).extension path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(17).getMax().equals("0"), "element 17 (2nd slice).extension cardinality");
//    ok = ok && rule(focus.getSnapshot().getElement().get(18).getPath().equals("Patient.extension.extension.id"), "element 18 (2nd slice).extension.id path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(19).getPath().equals("Patient.extension.extension.extension"), "element 19 (2nd slice).extension.extension path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(20).getPath().equals("Patient.extension.extension.url"), "element 20 (2nd slice).extension.url path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(21).getPath().equals("Patient.extension.extension.valuePeriod"), "element 21 (2nd slice).extension.valuePeriod path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(22).getPath().equals("Patient.extension.url"), "element 22 (2nd slice).url path");
//    ok = ok && rule(focus.getSnapshot().getElement().get(23).getPath().equals("Patient.extension.value[x]"), "element 23 (2nd slice).url path");
//
//    for (int i = 0; i < base.getSnapshot().getElement().size(); i++) {
//      if (ok) {
//        ElementDefinition b = base.getSnapshot().getElement().get(i);
//        ElementDefinition f = focus.getSnapshot().getElement().get(i <= 7 ? i : i + 16);
//        if (!f.hasBase() || !b.getPath().equals(f.getBase().getPath())) 
//          ok = false;
//        else {
//          f.setBase(null);
//          if (f.getPath().equals("Patient.extension")) {
//            ok = f.hasSlicing();
//            if (ok)
//              f.setSlicing(null);
//          }            
//          if (!f.getPath().equals("Patient.extension")) // no compare that because the definitions get overwritten 
//            ok = Base.compareDeep(b, f, true);
//        }
//      }
//    }
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation slicing extensions complex ("+(implicit ? "implicit" : "not implicit")+") failed");
//    } else 
//      System.out.println("Snap shot generation slicing extensions complex ("+(implicit ? "implicit" : "not implicit")+") passed");
//  }
//
//  private void testSlicingTask8742() throws EOperationOutcome, Exception {
//    StructureDefinition focus = new StructureDefinition();
//    StructureDefinition base = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Organization").copy();
//    focus.setUrl(Utilities.makeUuidUrn());
//    focus.setBaseDefinition(base.getUrl());
//    focus.setType(base.getType());
//    focus.setDerivation(TypeDerivationRule.CONSTRAINT);
//    
//    ElementDefinition id = focus.getDifferential().addElement();
//    id.setPath("Organization.address");
//    id.setMin(1);
//    id.setMax("1");
//    id.setMustSupport(true);
//        
//    id = focus.getDifferential().addElement();
//    id.setPath("Organization.address.extension");
//    id.setSliceName("USLabCountycodes");
//    id.getSlicing().setOrdered(false).setRules(SlicingRules.OPEN).addDiscriminator().setPath("url").setType(DiscriminatorType.VALUE);
//    id.setShort("County/Parish FIPS codes");
//    id.setDefinition("County/Parish FIPS codes.");
//    id.setRequirements("County/Parish Code SHALL use FIPS 6-4  ( INCITS 31:2009).");
//    id.setMin(0);
//    id.setMax("1");
//    id.addType().setCode("Extension").setProfile("http://hl7.org/fhir/StructureDefinition/us-core-county");
//    id.setMustSupport(true);
//    id.getBinding().setStrength(BindingStrength.REQUIRED).setDescription("FIPS codes for US counties and county equivalent entities.").setValueSet(new Reference().setReference("http://hl7.org/fhir/ValueSet/fips-county"));
//    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
//    
//    new ProfileUtilities(context, messages, null).generateSnapshot(base, focus, focus.getUrl(), "Simple Test" );
//
//    // 14 for address with one sliced extension
//    boolean ok = base.getSnapshot().getElement().size() == focus.getSnapshot().getElement().size() - 13;
//    
//    if (!ok) {
//      compareXml(base, focus);
//      throw new FHIRException("Snap shot generation test 8742 failed");
//    } else 
//      System.out.println("Snap shot generation test 8742 passed");
//  }
//
//
//  private boolean rule(boolean ok, String message) {
//    if (!ok)
//      System.out.println("Test failed: " + message);
//    return ok;
//  }
//

  private void compareXml(StructureDefinition base, StructureDefinition focus) throws FileNotFoundException, IOException {
    base.setText(null);
    focus.setText(null);
    base.setDifferential(null);
//    focus.setDifferential(null);
    String f1 = Utilities.path("c:", "temp", "base.xml");
    String f2 = Utilities.path("c:", "temp", "derived.xml");
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f1), base);
    ;
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f2), focus);
    ;
    String diff = Utilities.path(System.getenv("ProgramFiles(X86)"), "WinMerge", "WinMergeU.exe");
    List<String> command = new ArrayList<String>();
    command.add("\"" + diff + "\" \"" + f1 + "\" \"" + f2 + "\"");

    ProcessBuilder builder = new ProcessBuilder(command);
    builder.directory(new CSFile("c:\\temp"));
    builder.start();
  }
}
