package org.hl7.fhir.dstu3.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBase;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

import ca.uhn.fhir.model.api.IElement;

public abstract class Base implements Serializable, IBase, IElement {

  /**
   * User appended data items - allow users to add extra information to the class
   */
private Map<String, Object> userData; 

  /**
   * Round tracking xml comments for testing convenience
   */
  private List<String> formatCommentsPre; 
   
  /**
   * Round tracking xml comments for testing convenience
   */
  private List<String> formatCommentsPost; 
   
  
  public Object getUserData(String name) {
    if (userData == null)
      return null;
    return userData.get(name);
  }
  
  public void setUserData(String name, Object value) {
    if (userData == null)
      userData = new HashMap<String, Object>();
    userData.put(name, value);
  }

  public void clearUserData(String name) {
    if (userData != null)
      userData.remove(name);
  }
  
  public void setUserDataINN(String name, Object value) {
    if (value == null)
      return;
    
    if (userData == null)
      userData = new HashMap<String, Object>();
    userData.put(name, value);
  }

  public boolean hasUserData(String name) {
    if (userData == null)
      return false;
    else
      return userData.containsKey(name);
  }

	public String getUserString(String name) {
    Object ud = getUserData(name);
    if (ud == null)
      return null;
    if (ud instanceof String)
      return (String) ud;
    return ud.toString();
  }

  public int getUserInt(String name) {
    if (!hasUserData(name))
      return 0;
    return (Integer) getUserData(name);
  }

  public boolean hasFormatComment() {
  	return (formatCommentsPre != null && !formatCommentsPre.isEmpty()) || (formatCommentsPost != null && !formatCommentsPost.isEmpty());
  }
  
  public List<String> getFormatCommentsPre() {
    if (formatCommentsPre == null)
      formatCommentsPre = new ArrayList<String>();
    return formatCommentsPre;
  }
  
  public List<String> getFormatCommentsPost() {
    if (formatCommentsPost == null)
      formatCommentsPost = new ArrayList<String>();
    return formatCommentsPost;
  }  
  
	// these 3 allow evaluation engines to get access to primitive values
	public boolean isPrimitive() {
		return false;
	}
	
  public boolean isBooleanPrimitive() {
    return false;
  }

	public boolean hasPrimitiveValue() {
		return isPrimitive();
	}
	
	public String primitiveValue() {
		return null;
	}
	
	public abstract String fhirType() ;
	
	public boolean hasType(String... name) {
		String t = fhirType();
		for (String n : name)
		  if (n.equalsIgnoreCase(t))
		  	return true;
		return false;
	}
	
	protected abstract void listChildren(List<Property> result) ;
	
	public Base setProperty(String name, Base value) throws FHIRException {
	  throw new FHIRException("Attempt to set unknown property "+name);
	}
	
	public Base addChild(String name) throws FHIRException {
    throw new FHIRException("Attempt to add child with unknown name "+name);
  }

  /**
   * Supports iterating the children elements in some generic processor or browser
   * All defined children will be listed, even if they have no value on this instance
   * 
   * Note that the actual content of primitive or xhtml elements is not iterated explicitly.
   * To find these, the processing code must recognise the element as a primitive, typecast
   * the value to a {@link Type}, and examine the value
   *  
   * @return a list of all the children defined for this element
   */
  public List<Property> children() {
  	List<Property> result = new ArrayList<Property>();
  	listChildren(result);
  	return result;
  }

  public Property getChildByName(String name) {
    List<Property> children = new ArrayList<Property>();
    listChildren(children);
    for (Property c : children)
      if (c.getName().equals(name))
        return c;
    return null;
  }  
  
  public List<Base> listChildrenByName(String name) throws FHIRException {
    List<Base> result = new ArrayList<Base>();
  	for (Base b : listChildrenByName(name, true))
  		if (b != null)
  		  result.add(b);
    return result;
  }

  public Base[] listChildrenByName(String name, boolean checkValid) throws FHIRException {
  	if (name.equals("*")) {
  		List<Property> children = new ArrayList<Property>();
  		listChildren(children);
  		List<Base> result = new ArrayList<Base>();
  		for (Property c : children)
				result.addAll(c.getValues());
  		return result.toArray(new Base[result.size()]);
  	}
  	else
    	return getProperty(name.hashCode(), name, checkValid);
  }

	public boolean isEmpty() {
	  return true; // userData does not count
  }

	public boolean equalsDeep(Base other) {
	  return other != null;
  }  
  
	public boolean equalsShallow(Base other) {
	  return other != null;
  }  
  
	public static boolean compareDeep(List<? extends Base> e1, List<? extends Base> e2, boolean allowNull) {
		if (noList(e1) && noList(e2) && allowNull)
			return true;
		if (noList(e1) || noList(e2))
			return false;
		if (e1.size() != e2.size())
			return false;
		for (int i = 0; i < e1.size(); i++) {
			if (!compareDeep(e1.get(i), e2.get(i), allowNull))
				return false;
		}
		return true;
	}
	
	private static boolean noList(List<? extends Base> list) {
    return list == null || list.isEmpty();
  }

	public static boolean compareDeep(Base e1, Base e2, boolean allowNull) {
		if (allowNull) {
			boolean noLeft = e1 == null || e1.isEmpty();
			boolean noRight = e2 == null || e2.isEmpty();
			if (noLeft && noRight) {
			return true;
			}
		}
		if (e1 == null || e2 == null)
			return false;
		else
  		return e1.equalsDeep(e2);
	}
	
	public static boolean compareDeep(XhtmlNode div1, XhtmlNode div2, boolean allowNull) {
		if (div1 == null && div2 == null && allowNull)
			return true;
		if (div1 == null || div2 == null)
			return false;
		return div1.equalsDeep(div2);
  }


	public static boolean compareValues(List<? extends PrimitiveType> e1, List<? extends PrimitiveType> e2, boolean allowNull) {
		if (e1 == null && e2 == null && allowNull)
			return true;
		if (e1 == null || e2 == null)
			return false;
		if (e1.size() != e2.size())
			return false;
		for (int i = 0; i < e1.size(); i++) {
			if (!compareValues(e1.get(i), e2.get(i), allowNull))
				return false;
		}
		return true;
	}

	public static boolean compareValues(PrimitiveType e1, PrimitiveType e2, boolean allowNull) {
		boolean noLeft = e1 == null || e1.isEmpty();
		boolean noRight = e2 == null || e2.isEmpty();
      if (noLeft && noRight && allowNull) {
			return true;
      }
		if (noLeft != noRight)
			return false;
		return e1.equalsShallow(e2);
  }
	
	// -- converters for property setters
	
  public Type castToType(Base b) throws FHIRException {
    if (b instanceof Type)
      return (Type) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Reference");
  }
  

	public BooleanType castToBoolean(Base b) throws FHIRException {
		if (b instanceof BooleanType)
			return (BooleanType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Boolean");
	}
	
	public IntegerType castToInteger(Base b) throws FHIRException {
		if (b instanceof IntegerType)
			return (IntegerType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Integer");
	}
	
	public DecimalType castToDecimal(Base b) throws FHIRException {
		if (b instanceof DecimalType)
			return (DecimalType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Decimal");
	}
	
	public Base64BinaryType castToBase64Binary(Base b) throws FHIRException {
		if (b instanceof Base64BinaryType)
			return (Base64BinaryType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Base64Binary");
	}
	
	public InstantType castToInstant(Base b) throws FHIRException {
		if (b instanceof InstantType)
			return (InstantType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Instant");
	}
	
	public StringType castToString(Base b) throws FHIRException {
		if (b instanceof StringType)
			return (StringType) b;
		else if (b.hasPrimitiveValue())
			return new StringType(b.primitiveValue());
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a String");
	}
	
	public UriType castToUri(Base b) throws FHIRException {
		if (b instanceof UriType)
			return (UriType) b;
		else if (b.hasPrimitiveValue())
			return new UriType(b.primitiveValue());
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Uri");
	}
	
	public DateType castToDate(Base b) throws FHIRException {
		if (b instanceof DateType)
			return (DateType) b;
		else if (b.hasPrimitiveValue())
			return new DateType(b.primitiveValue());
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Date");
	}
	
	public DateTimeType castToDateTime(Base b) throws FHIRException {
		if (b instanceof DateTimeType)
			return (DateTimeType) b;
		else if (b.fhirType().equals("dateTime"))
			return new DateTimeType(b.primitiveValue());
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a DateTime");
	}
	
	public TimeType castToTime(Base b) throws FHIRException {
		if (b instanceof TimeType)
			return (TimeType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Time");
	}
	
	public CodeType castToCode(Base b) throws FHIRException {
		if (b instanceof CodeType)
			return (CodeType) b;
		else if (b.isPrimitive())
			return new CodeType(b.primitiveValue());
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Code");
	}
	
	public OidType castToOid(Base b) throws FHIRException {
		if (b instanceof OidType)
			return (OidType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Oid");
	}
	
	public IdType castToId(Base b) throws FHIRException {
		if (b instanceof IdType)
			return (IdType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Id");
	}
	
	public UnsignedIntType castToUnsignedInt(Base b) throws FHIRException {
		if (b instanceof UnsignedIntType)
			return (UnsignedIntType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a UnsignedInt");
	}
	
	public PositiveIntType castToPositiveInt(Base b) throws FHIRException {
		if (b instanceof PositiveIntType)
			return (PositiveIntType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a PositiveInt");
	}
	
  public MarkdownType castToMarkdown(Base b) throws FHIRException {
		if (b instanceof MarkdownType)
			return (MarkdownType) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Markdown");
	}
		
  public Annotation castToAnnotation(Base b) throws FHIRException {
    if (b instanceof Annotation)
      return (Annotation) b;
    else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Annotation");
  }
  
  public Dosage castToDosage(Base b) throws FHIRException {
    if (b instanceof Dosage)
      return (Dosage) b;
    else      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an DosageInstruction");
  }
  
	
	public Attachment castToAttachment(Base b) throws FHIRException {
		if (b instanceof Attachment)
			return (Attachment) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Attachment");
	}
	
	public Identifier castToIdentifier(Base b) throws FHIRException {
		if (b instanceof Identifier)
			return (Identifier) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Identifier");
	}
	
	public CodeableConcept castToCodeableConcept(Base b) throws FHIRException {
		if (b instanceof CodeableConcept)
			return (CodeableConcept) b;
    else if (b instanceof CodeType) {
		  CodeableConcept cc = new CodeableConcept();
		  cc.addCoding().setCode(((CodeType) b).asStringValue());
		  return cc;
		} else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a CodeableConcept");
	}
	
	public Coding castToCoding(Base b) throws FHIRException {
		if (b instanceof Coding)
			return (Coding) b;
    else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Coding");
	}
	
	public Quantity castToQuantity(Base b) throws FHIRException {
		if (b instanceof Quantity)
			return (Quantity) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Quantity");
	}
	
	public Money castToMoney(Base b) throws FHIRException {
		if (b instanceof Money)
			return (Money) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Money");
	}
	
	public Duration castToDuration(Base b) throws FHIRException {
		if (b instanceof Duration)
			return (Duration) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to an Duration");
	}
	
	public SimpleQuantity castToSimpleQuantity(Base b) throws FHIRException {
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
	
	public Range castToRange(Base b) throws FHIRException {
		if (b instanceof Range)
			return (Range) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Range");
	}
	
	public Period castToPeriod(Base b) throws FHIRException {
		if (b instanceof Period)
			return (Period) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Period");
	}
	
	public Ratio castToRatio(Base b) throws FHIRException {
		if (b instanceof Ratio)
			return (Ratio) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Ratio");
	}
	
	public SampledData castToSampledData(Base b) throws FHIRException {
		if (b instanceof SampledData)
			return (SampledData) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a SampledData");
	}
	
	public Signature castToSignature(Base b) throws FHIRException {
		if (b instanceof Signature)
			return (Signature) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Signature");
	}
	
	public HumanName castToHumanName(Base b) throws FHIRException {
		if (b instanceof HumanName)
			return (HumanName) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a HumanName");
	}
	
	public Address castToAddress(Base b) throws FHIRException {
		if (b instanceof Address)
			return (Address) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Address");
	}
	
	public ContactDetail castToContactDetail(Base b) throws FHIRException {
		if (b instanceof ContactDetail)
			return (ContactDetail) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ContactDetail");
	}

	public Contributor castToContributor(Base b) throws FHIRException {
		if (b instanceof Contributor)
			return (Contributor) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Contributor");
	}

	public UsageContext castToUsageContext(Base b) throws FHIRException {
		if (b instanceof UsageContext)
			return (UsageContext) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a UsageContext");
	}

	public RelatedArtifact castToRelatedArtifact(Base b) throws FHIRException {
		if (b instanceof RelatedArtifact)
			return (RelatedArtifact) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a RelatedArtifact");
	}

	public ContactPoint castToContactPoint(Base b) throws FHIRException {
		if (b instanceof ContactPoint)
			return (ContactPoint) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ContactPoint");
	}
	
	public Timing castToTiming(Base b) throws FHIRException {
		if (b instanceof Timing)
			return (Timing) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Timing");
	}
	
	public Reference castToReference(Base b) throws FHIRException {
		if (b instanceof Reference)
			return (Reference) b;
		else if (b.isPrimitive() && Utilities.isURL(b.primitiveValue()))
      return new Reference().setReference(b.primitiveValue());
    else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Reference");
	}
	
	public Meta castToMeta(Base b) throws FHIRException {
		if (b instanceof Meta)
			return (Meta) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Meta");
	}
		
	public Extension castToExtension(Base b) throws FHIRException {
		if (b instanceof Extension)
			return (Extension) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Extension");
	}
	
	public Resource castToResource(Base b) throws FHIRException {
		if (b instanceof Resource)
			return (Resource) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Resource");
	}
	
	public Narrative castToNarrative(Base b) throws FHIRException {
		if (b instanceof Narrative)
			return (Narrative) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a Narrative");
	}
	
	
	public ElementDefinition castToElementDefinition(Base b) throws FHIRException {
		if (b instanceof ElementDefinition)
			return (ElementDefinition) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ElementDefinition");
	}

	public DataRequirement castToDataRequirement(Base b) throws FHIRException {
		if (b instanceof DataRequirement)
			return (DataRequirement) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a DataRequirement");
	}

	public ParameterDefinition castToParameterDefinition(Base b) throws FHIRException {
		if (b instanceof ParameterDefinition)
			return (ParameterDefinition) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a ParameterDefinition");
	}

	public TriggerDefinition castToTriggerDefinition(Base b) throws FHIRException {
		if (b instanceof TriggerDefinition)
			return (TriggerDefinition) b;
		else
			throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to a TriggerDefinition");
	}

  public XhtmlNode castToXhtml(Base b) throws FHIRException {
    if (b instanceof StringType) {
      try {
        return new XhtmlParser().parseFragment(((StringType) b).asStringValue());
      } catch (IOException e) {
        throw new FHIRException(e);
      }
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to XHtml");
  }
  
  public String castToXhtmlString(Base b) throws FHIRException {
    if (b instanceof StringType) {
      return ((StringType) b).asStringValue();
    } else
      throw new FHIRException("Unable to convert a "+b.getClass().getName()+" to XHtml string");
  }

	public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
		if (checkValid)
			throw new FHIRException("Attempt to read invalid property '"+name+"' on type "+fhirType());
  	return null; 
	}

	public Base setProperty(int hash, String name, Base value) throws FHIRException {
		throw new FHIRException("Attempt to write to invalid property '"+name+"' on type "+fhirType());
	}

	public Base makeProperty(int hash, String name) throws FHIRException {
		throw new FHIRException("Attempt to make an invalid property '"+name+"' on type "+fhirType());
	}

	public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    throw new FHIRException("Attempt to get types for an invalid property '"+name+"' on type "+fhirType());
	}
	
	public static boolean equals(String v1, String v2) {
  	if (v1 == null && v2 == null)
  		return true;
  	else if (v1 == null || v2 == null)
    	return false;
  	else
  		return v1.equals(v2);
	}

  public boolean isResource() {
    return false;
  }
	

  public abstract String getIdBase();
  public abstract void setIdBase(String value);

  public Property getNamedProperty(String _name) throws FHIRException {
    return getNamedProperty(_name.hashCode(), _name, false);
  }
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    if (_checkValid)
      throw new FHIRException("Attempt to read invalid property '"+_name+"' on type "+fhirType());
    return null; 
  }

}