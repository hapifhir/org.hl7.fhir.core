package org.hl7.fhir.r5.model;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class TypeConvertor {

  // -- converters for property setters
  
  public static DataType castToType(Base b) throws FHIRException {
    if (b instanceof DataType)
      return (DataType) b;
    else if (b.isMetadataBased())
      return ((org.hl7.fhir.r5.elementmodel.Element) b).asType();
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Reference");
  }
  

  public static BooleanType castToBoolean(Base b) throws FHIRException {
    if (b instanceof BooleanType)
      return (BooleanType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Boolean");
  }
  
  public static IntegerType castToInteger(Base b) throws FHIRException {
    if (b instanceof IntegerType)
      return (IntegerType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Integer");
  }
  
  public static Integer64Type castToInteger64(Base b) throws FHIRException {
    if (b instanceof Integer64Type)
      return (Integer64Type) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Integer");
  }
  
  public static DecimalType castToDecimal(Base b) throws FHIRException {
    if (b instanceof DecimalType)
      return (DecimalType) b;
    else if (b.hasPrimitiveValue())
      return new DecimalType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Decimal");
  }
  
  public static Base64BinaryType castToBase64Binary(Base b) throws FHIRException {
    if (b instanceof Base64BinaryType)
      return (Base64BinaryType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Base64Binary");
  }
  
  public static InstantType castToInstant(Base b) throws FHIRException {
    if (b instanceof InstantType)
      return (InstantType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Instant");
  }
  
  public static StringType castToString(Base b) throws FHIRException {
    if (b instanceof StringType)
      return (StringType) b;
    else if (b.hasPrimitiveValue())
      return new StringType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a String");
  }
  
  public static UriType castToUri(Base b) throws FHIRException {
    if (b instanceof UriType)
      return (UriType) b;
    else if (b.hasPrimitiveValue())
      return new UriType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Uri");
  }
  
  public static UrlType castToUrl(Base b) throws FHIRException {
    if (b instanceof UrlType)
      return (UrlType) b;
    else if (b.hasPrimitiveValue())
      return new UrlType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Uri");
  }
  
  public static CanonicalType castToCanonical(Base b) throws FHIRException {
    if (b instanceof CanonicalType)
      return (CanonicalType) b;
    else if (b.hasPrimitiveValue())
      return new CanonicalType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Uri");
  }
  
  public static DateType castToDate(Base b) throws FHIRException {
    if (b instanceof DateType)
      return (DateType) b;
    else if (b.hasPrimitiveValue())
      return new DateType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Date");
  }
  
  public static DateTimeType castToDateTime(Base b) throws FHIRException {
    if (b instanceof DateTimeType)
      return (DateTimeType) b;
    else if (b.fhirType().equals("dateTime"))
      return new DateTimeType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a DateTime");
  }
  
  public static TimeType castToTime(Base b) throws FHIRException {
    if (b instanceof TimeType)
      return (TimeType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Time");
  }
  
  public static CodeType castToCode(Base b) throws FHIRException {
    if (b instanceof CodeType)
      return (CodeType) b;
    else if (b.isPrimitive())
      return new CodeType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Code");
  }
  
  public static OidType castToOid(Base b) throws FHIRException {
    if (b instanceof OidType)
      return (OidType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Oid");
  }
  
  public static IdType castToId(Base b) throws FHIRException {
    if (b instanceof IdType)
      return (IdType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Id");
  }
  
  public static UnsignedIntType castToUnsignedInt(Base b) throws FHIRException {
    if (b instanceof UnsignedIntType)
      return (UnsignedIntType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a UnsignedInt");
  }
  
  public static PositiveIntType castToPositiveInt(Base b) throws FHIRException {
    if (b instanceof PositiveIntType)
      return (PositiveIntType) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a PositiveInt");
  }
  
  public static MarkdownType castToMarkdown(Base b) throws FHIRException {
    if (b instanceof MarkdownType)
      return (MarkdownType) b;
    else if (b.hasPrimitiveValue())
      return new MarkdownType(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Markdown");
  }
    
  public static Annotation castToAnnotation(Base b) throws FHIRException {
    if (b instanceof Annotation)
      return (Annotation) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Annotation");
  }
  
  public static Dosage castToDosage(Base b) throws FHIRException {
    if (b instanceof Dosage)
      return (Dosage) b;
    else      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an DosageInstruction");
  }
  
  
  public static Attachment castToAttachment(Base b) throws FHIRException {
    if (b instanceof Attachment)
      return (Attachment) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Attachment");
  }
  
  public static Identifier castToIdentifier(Base b) throws FHIRException {
    if (b instanceof Identifier)
      return (Identifier) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Identifier");
  }
  
  public static CodeableConcept castToCodeableConcept(Base b) throws FHIRException {
    if (b instanceof CodeableConcept)
      return (CodeableConcept) b;
    else if (b instanceof Element) {
      return ObjectConverter.readAsCodeableConcept((Element) b);
    } else if (b instanceof CodeType) {
      CodeableConcept cc = new CodeableConcept();
      cc.addCoding().setCode(((CodeType) b).asStringValue());
      return cc;
    } else if(b instanceof StringType) {
      CodeableConcept cc = new CodeableConcept();
      cc.addCoding().setCode(((StringType) b).asStringValue());
      return cc;
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a CodeableConcept");
  }
  
  public static CodeableReference castToCodeableReference(Base b) throws FHIRException {
    if (b instanceof CodeableReference) {
      return (CodeableReference) b;
    } else if (b instanceof CodeType) {
      CodeableReference cc = new CodeableReference();
      cc.getConcept().addCoding().setCode(((CodeType) b).asStringValue());
      return cc;
    } else if (b instanceof Reference) {
      CodeableReference cc = new CodeableReference();
      cc.setReference((Reference) b);
      return cc;
    } else if(b instanceof StringType) {
      CodeableReference cc = new CodeableReference();
      cc.getConcept().addCoding().setCode(((StringType) b).asStringValue());
      return cc;
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a CodeableConcept");
  }
  
  public static Population castToPopulation(Base b) throws FHIRException {
    if (b instanceof Population)
      return (Population) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Population");
  }
  
  
  public static Coding castToCoding(Base b) throws FHIRException {
    if (b instanceof Coding)
      return (Coding) b;
    else if (b instanceof Element) {
      ICoding c = ((Element) b).getAsICoding();
      if (c != null) {
        return new Coding().setCode(c.getCode()).setSystem(c.getSystem()).setVersion(c.getVersion()).setDisplay(c.getDisplay());
      } else if (b.isPrimitive()) {  
        return new Coding().setCode(b.primitiveValue());
      } else {
        throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Coding");
      }
    } else if (b instanceof ICoding) {
      ICoding c = (ICoding) b;
      return new Coding().setCode(c.getCode()).setSystem(c.getSystem()).setVersion(c.getVersion()).setDisplay(c.getDisplay());
    } else if (b.isPrimitive()) {  
      return new Coding().setCode(b.primitiveValue());
    } else {
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Coding");
    }
  }
  
  public static Quantity castToQuantity(Base b) throws FHIRException {
    if (b instanceof Quantity)
      return (Quantity) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Quantity");
  }
  
  public static Money castToMoney(Base b) throws FHIRException {
    if (b instanceof Money)
      return (Money) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Money");
  }
  
  public static Duration castToDuration(Base b) throws FHIRException {
    if (b instanceof Duration)
      return (Duration) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Duration");
  }
  
  public static SimpleQuantity castToSimpleQuantity(Base b) throws FHIRException {
    if (b instanceof SimpleQuantity)
      return (SimpleQuantity) b;
    else if (b instanceof Quantity) {
      Quantity q = (Quantity) b;
      SimpleQuantity sq = new SimpleQuantity();
      sq.setValueElement(q.getValueElement());
      sq.setComparatorElement(q.getComparatorElement());
      sq.setUnitElement(q.getUnitElement());
      sq.setSystemElement(q.getSystemElement());
      sq.setCodeElement(q.getCodeElement());
      return sq;
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an SimpleQuantity");
  }
  
  public static Range castToRange(Base b) throws FHIRException {
    if (b instanceof Range)
      return (Range) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Range");
  }
  
  public static Period castToPeriod(Base b) throws FHIRException {
    if (b instanceof Period)
      return (Period) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Period");
  }
  
  public static Ratio castToRatio(Base b) throws FHIRException {
    if (b instanceof Ratio)
      return (Ratio) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Ratio");
  }
  
  public static SampledData castToSampledData(Base b) throws FHIRException {
    if (b instanceof SampledData)
      return (SampledData) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a SampledData");
  }
  
  public static Signature castToSignature(Base b) throws FHIRException {
    if (b instanceof Signature)
      return (Signature) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Signature");
  }
  
  public static HumanName castToHumanName(Base b) throws FHIRException {
    if (b instanceof HumanName)
      return (HumanName) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a HumanName");
  }
  
  public static Address castToAddress(Base b) throws FHIRException {
    if (b instanceof Address)
      return (Address) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Address");
  }
  
  public static ContactDetail castToContactDetail(Base b) throws FHIRException {
    if (b instanceof ContactDetail)
      return (ContactDetail) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ContactDetail");
  }

  public static Contributor castToContributor(Base b) throws FHIRException {
    if (b instanceof Contributor)
      return (Contributor) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Contributor");
  }

  public static UsageContext castToUsageContext(Base b) throws FHIRException {
    if (b instanceof UsageContext)
      return (UsageContext) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a UsageContext");
  }

  public static RelatedArtifact castToRelatedArtifact(Base b) throws FHIRException {
    if (b instanceof RelatedArtifact)
      return (RelatedArtifact) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a RelatedArtifact");
  }

  public static ContactPoint castToContactPoint(Base b) throws FHIRException {
    if (b instanceof ContactPoint)
      return (ContactPoint) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ContactPoint");
  }
  
  public static Timing castToTiming(Base b) throws FHIRException {
    if (b instanceof Timing)
      return (Timing) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Timing");
  }
  
  public static Reference castToReference(Base b) throws FHIRException {
    if (b instanceof Reference)
      return (Reference) b;
    else if (b.isPrimitive() && Utilities.isURL(b.primitiveValue()))
      return new Reference().setReference(b.primitiveValue());
    else if (b instanceof org.hl7.fhir.r5.elementmodel.Element && b.fhirType().equals("Reference")) {
      org.hl7.fhir.r5.elementmodel.Element e = (org.hl7.fhir.r5.elementmodel.Element) b;
      return new Reference().setReference(e.getChildValue("reference")).setDisplay(e.getChildValue("display"));
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Reference");
  }
  
  public static Meta castToMeta(Base b) throws FHIRException {
    if (b instanceof Meta)
      return (Meta) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Meta");
  }
    
  
  public static MarketingStatus castToMarketingStatus(Base b) throws FHIRException {
    if (b instanceof MarketingStatus)
      return (MarketingStatus) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a MarketingStatus");
  }
    
  public static Statistic castToStatistic(Base b) throws FHIRException {
    if (b instanceof Statistic)
      return (Statistic) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Statistic");
  }
   
  
  public static OrderedDistribution castToOrderedDistribution(Base b) throws FHIRException {
    if (b instanceof OrderedDistribution)
      return (OrderedDistribution) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a OrderedDistribution");
  }
  
  public static ProductShelfLife castToProductShelfLife(Base b) throws FHIRException {
    if (b instanceof ProductShelfLife)
      return (ProductShelfLife) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ProductShelfLife");
  }
    
  public static ProdCharacteristic castToProdCharacteristic(Base b) throws FHIRException {
    if (b instanceof ProdCharacteristic)
      return (ProdCharacteristic) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ProdCharacteristic");
  }
    
  
  public static SubstanceAmount castToSubstanceAmount(Base b) throws FHIRException {
    if (b instanceof SubstanceAmount)
      return (SubstanceAmount) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a SubstanceAmount");
  }
    
  public static Extension castToExtension(Base b) throws FHIRException {
    if (b instanceof Extension)
      return (Extension) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Extension");
  }
  
  public static Resource castToResource(Base b) throws FHIRException {
    if (b instanceof Resource)
      return (Resource) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Resource");
  }
  
  public static Narrative castToNarrative(Base b) throws FHIRException {
    if (b instanceof Narrative)
      return (Narrative) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Narrative");
  }
  
  
  public static ElementDefinition castToElementDefinition(Base b) throws FHIRException {
    if (b instanceof ElementDefinition)
      return (ElementDefinition) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ElementDefinition");
  }

  public static DataRequirement castToDataRequirement(Base b) throws FHIRException {
    if (b instanceof DataRequirement)
      return (DataRequirement) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a DataRequirement");
  }

  public static Expression castToExpression(Base b) throws FHIRException {
    if (b instanceof Expression)
      return (Expression) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Expression");
  }

  
  public static ParameterDefinition castToParameterDefinition(Base b) throws FHIRException {
    if (b instanceof ParameterDefinition)
      return (ParameterDefinition) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ParameterDefinition");
  }

  public static TriggerDefinition castToTriggerDefinition(Base b) throws FHIRException {
    if (b instanceof TriggerDefinition)
      return (TriggerDefinition) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a TriggerDefinition");
  }

  public static XhtmlNode castToXhtml(Base b) throws FHIRException {
    if (b instanceof Element) {
      return ((Element) b).getXhtml();
    } else if (b instanceof XhtmlType) {
      return ((XhtmlType) b).getValue();
    } else if (b instanceof StringType) {
      try {
        return new XhtmlParser().parseFragment(((StringType) b).asStringValue());
      } catch (IOException e) {
        throw new FHIRException(e);
      }
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to XHtml");
  }
  
  public static String castToXhtmlString(Base b) throws FHIRException {
    if (b instanceof Element) {
      return ((Element) b).getValue();
    } else if (b instanceof XhtmlType) {
      try {
        return new XhtmlComposer(true).compose(((XhtmlType) b).getValue());
      } catch (IOException e) {
        return null;
      }
    } else if (b instanceof StringType) {
      return ((StringType) b).asStringValue();
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to XHtml string");
  }
  

}