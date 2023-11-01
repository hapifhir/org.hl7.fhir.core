package org.hl7.fhir.convertors.conv14_50.resources14_50;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.SourceElementComponentWrapper;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Reference14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.ContactPoint14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Identifier14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Boolean14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.DateTime14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.utils.ToolingExtensions;

public class ConceptMap14_50 {

  public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2016may.model.ConceptMap src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier14_50.convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent t : src.getContact())
      tgt.addContact(convertConceptMapContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (CodeableConcept14_50.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_50.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_50.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    org.hl7.fhir.r5.model.DataType tt = ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getSource());
    tgt.setSourceScope(tt instanceof org.hl7.fhir.r5.model.Reference ? new CanonicalType(((org.hl7.fhir.r5.model.Reference) tt).getReference()) : tt);
    tt = ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getTarget());
    tgt.setTargetScope(tt instanceof org.hl7.fhir.r5.model.Reference ? new CanonicalType(((org.hl7.fhir.r5.model.Reference) tt).getReference()) : tt);
    for (org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent t : src.getElement()) {
      List<SourceElementComponentWrapper<ConceptMap.SourceElementComponent>> ws = convertSourceElementComponent(t, tgt);
      for (SourceElementComponentWrapper<ConceptMap.SourceElementComponent> w : ws)
        getGroup(tgt, w.getSource(), w.getTarget()).addElement(w.getComp());
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ConceptMap tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier()) {
      if (src.hasIdentifier())
        tgt.setIdentifier(Identifier14_50.convertIdentifier(src.getIdentifierFirstRep()));
    }
    if (src.hasVersion())
      tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.getSourceScope() instanceof CanonicalType)
      tgt.setSource(Reference14_50.convertCanonicalToReference((CanonicalType) src.getSourceScope()));
    else if (src.hasSourceScope())
      tgt.setSource(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getSourceScope()));
    if (src.getTargetScope() instanceof CanonicalType)
      tgt.setTarget(Reference14_50.convertCanonicalToReference((CanonicalType) src.getTargetScope()));
    else if (src.hasTargetScope())
      tgt.setTarget(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getTargetScope()));
    if (src.hasSourceScope())
      tgt.setSource(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getSourceScope()));
    if (src.hasTargetScope())
      tgt.setTarget(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getTargetScope()));
    for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup())
      for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : g.getElement())
        tgt.addElement(convertSourceElementComponent(t, g, src));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence> convertConceptMapEquivalence(Enumeration<ConceptMapRelationship> src, org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent ccm) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence>(new org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalenceEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (ccm.hasExtension(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
      tgt.setValueAsString(ccm.getExtensionString(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE));
    } else {
      switch (src.getValue()) {
        case EQUIVALENT:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
          break;
        case SOURCEISNARROWERTHANTARGET:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.WIDER);
          break;
        case SOURCEISBROADERTHANTARGET:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NARROWER);
          break;
        case NOTRELATEDTO:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.DISJOINT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NULL);
          break;
      }
    }
    return tgt;
  }

  public static Enumeration<ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence> src, org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgtCtxt) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<ConceptMapRelationship> tgt = new Enumeration<ConceptMapRelationship>(new Enumerations.ConceptMapRelationshipEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    ToolingExtensions.setCodeExtensionMod(tgtCtxt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE, src.getValueAsString());
    switch (src.getValue()) {
      case EQUIVALENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT);
        break;
      case EQUAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT);
        break;
      case WIDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
        break;
      case SUBSUMES:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
        break;
      case NARROWER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
        break;
      case SPECIALIZES:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
        break;
      case INEXACT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO);
        break;
      case UNMATCHED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL);
        break;
      case DISJOINT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NOTRELATEDTO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src, org.hl7.fhir.r5.model.ConceptMap srcMap) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasAttribute())
      tgt.setElement(srcMap.getAttributeUri(src.getAttribute()));
    if (src.hasValueCoding()) {
      tgt.setSystem(src.getValueCoding().getSystem());
      tgt.setCode(src.getValueCoding().getCode());
    } else if (src.hasValue()) {
        tgt.setCode(src.getValue().primitiveValue());
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent src, org.hl7.fhir.r5.model.ConceptMap tgtMap) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasElementElement())
      tgt.setAttribute(tgtMap.registerAttribute(src.getElement()));
    if (src.hasSystem()) {
      tgt.setValue(new Coding().setSystem(src.getSystem()).setCode(src.getCode()));
    } else if (src.hasCodeElement()) {
      tgt.setValue(String14_50.convertString(src.getCodeElement()));
    }
    return tgt;
  }

  public static List<SourceElementComponentWrapper<ConceptMap.SourceElementComponent>> convertSourceElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r5.model.ConceptMap tgtMap) throws FHIRException {
    List<SourceElementComponentWrapper<ConceptMap.SourceElementComponent>> res = new ArrayList<>();
    if (src == null || src.isEmpty())
      return res;
    for (org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
      org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
      if (src.hasCode())
        tgt.setCode(src.getCode());
      if (t.getEquivalence() == org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
        tgt.setNoMap(true);
      } else {
        tgt.addTarget(convertTargetElementComponent(t, tgtMap));
      }
      res.add(new SourceElementComponentWrapper<>(tgt, src.getSystem(), t.getSystem()));
    }
    return res;
  }

  public static org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g, org.hl7.fhir.r5.model.ConceptMap srcMap) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (g.hasSource())
      tgt.setSystem(g.getSource());
    if (src.hasCode())
      tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    if (src.hasNoMap() && src.getNoMap() == true) {
      tgt.addTarget(new org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
    } else {
      for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget())
        tgt.addTarget(convertTargetElementComponent(t, g, srcMap));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g, org.hl7.fhir.r5.model.ConceptMap srcMap) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
    if (g.hasTarget())
      tgt.setSystem(g.getTarget());
    if (src.hasCode())
      tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    if (src.hasRelationship())
      tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getRelationshipElement(), src));
    if (src.hasComment())
      tgt.setCommentsElement(String14_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t, srcMap));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t, srcMap));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r5.model.ConceptMap tgtMap) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    if (src.hasEquivalence())
      tgt.setRelationshipElement(convertConceptMapRelationship(src.getEquivalenceElement(), tgt));
    if (src.hasComments())
      tgt.setCommentElement(String14_50.convertString(src.getCommentsElement()));
    for (org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t, tgtMap));
    for (org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t, tgtMap));
    return tgt;
  }

  static public ConceptMapGroupComponent getGroup(ConceptMap map, String srcs, String tgts) {
    for (ConceptMapGroupComponent grp : map.getGroup()) {
      if (grp.hasSource() && grp.getSource().equals(srcs) && grp.getTarget().equals(tgts))
        return grp;
    }
    ConceptMapGroupComponent grp = map.addGroup();
    grp.setSource(srcs);
    grp.setTarget(tgts);
    return grp;
  }
}