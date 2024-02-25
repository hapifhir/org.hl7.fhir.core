package org.hl7.fhir.r5.elementmodel;

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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.IDigitalSignatureServices;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

public abstract class ParserBase {

  public enum IdRenderingPolicy {
    All, None, RootOnly, NotRoot;

    boolean forRoot() {
      return this == All || this == RootOnly;
    }

    boolean forInner() {
      return this == All || this == NotRoot;
    }
  }

  public interface ILinkResolver {
    String resolveType(String type);
    String resolveProperty(Property property);
    String resolvePage(String string);
    String resolveReference(String referenceForElement);
  }
  
  public enum ValidationPolicy { NONE, QUICK, EVERYTHING }

  public boolean isPrimitive(String code) {
    return context.isPrimitiveType(code);    
	}

	protected IWorkerContext context;
	protected ValidationPolicy policy;
  protected ILinkResolver linkResolver;
  protected boolean showDecorations;
  protected IdRenderingPolicy idPolicy = IdRenderingPolicy.All;
  protected StructureDefinition logical;
  protected IDigitalSignatureServices signatureServices;
  private ProfileUtilities profileUtilities;
  private ContextUtilities contextUtilities;

	public ParserBase(IWorkerContext context, ProfileUtilities utilities) {
		super();
		this.context = context;
    this.profileUtilities = utilities;
    contextUtilities = new ContextUtilities(context);
		policy = ValidationPolicy.NONE;
	}

	public ParserBase(IWorkerContext context) {
	  super();
    this.context = context;
    this.profileUtilities = new ProfileUtilities(context, null, null, new FHIRPathEngine(context));
    contextUtilities = new ContextUtilities(context);
    policy = ValidationPolicy.NONE;
  }

  public void setupValidation(ValidationPolicy policy) {
	  this.policy = policy;
	}

  public abstract List<ValidatedFragment> parse(InputStream stream) throws IOException, FHIRFormatError, DefinitionException, FHIRException;
  
  public Element parseSingle(InputStream stream, List<ValidationMessage> errors) throws IOException, FHIRFormatError, DefinitionException, FHIRException {
    
    List<ValidatedFragment> res = parse(stream);
   
    if (res.size() != 1) {
      throw new FHIRException("Parsing FHIR content returned multiple elements in a context where only one element is allowed");
    }
    var resE = res.get(0);
    if (resE.getElement() == null) {
      throw new FHIRException("Parsing FHIR content failed: "+errorSummary(resE.getErrors()));      
    } else if (res.size() == 0) {
      throw new FHIRException("Parsing FHIR content returned no elements in a context where one element is required because: "+errorSummary(resE.getErrors()));
    }
    if (errors != null) {
      errors.addAll(resE.getErrors());
    }
    return resE.getElement();
  }

	private String errorSummary(List<ValidationMessage> errors) {
	  if (errors == null || errors.size() == 0) {
	    return "(no error description)";
	  } else {
	    return errors.get(0).summary();
	  }
  }

  public abstract void compose(Element e, OutputStream destination, OutputStyle style, String base)  throws FHIRException, IOException;

	public void logError(List<ValidationMessage> errors, String ruleDate, int line, int col, String path, IssueType type, String message, IssueSeverity level) throws FHIRFormatError {
	  if (errors != null) {
	    if (policy == ValidationPolicy.EVERYTHING) {
	      ValidationMessage msg = new ValidationMessage(Source.InstanceValidator, type, line, col, path, message, level);
	      msg.setRuleDate(ruleDate);
	      errors.add(msg);
	    } else if (level == IssueSeverity.FATAL || (level == IssueSeverity.ERROR && policy == ValidationPolicy.QUICK))
	      throw new FHIRFormatError(message+String.format(" at line %d col %d", line, col));
	  }
	}
	
	
	protected StructureDefinition getDefinition(List<ValidationMessage> errors, int line, int col, String ns, String name) throws FHIRFormatError {
	  if (logical != null) {
	    String expectedName = ToolingExtensions.readStringExtension(logical, ToolingExtensions.EXT_XML_NAME);
	    if (expectedName == null) {
	      expectedName = logical.getType();
	      if (Utilities.isAbsoluteUrl(expectedName)) {
	        expectedName = expectedName.substring(expectedName.lastIndexOf("/")+1);
	      }
	    }
	    String expectedNamespace = ToolingExtensions.readStringExtension(logical, ToolingExtensions.EXT_XML_NAMESPACE, ToolingExtensions.EXT_XML_NAMESPACE_DEPRECATED);
	    if (matchesNamespace(expectedNamespace, ns) && matchesName(expectedName, name)) {
	      return logical;
	    } else {
	      if (expectedNamespace == null && ns == null) {
          logError(errors, ValidationMessage.NO_RULE_DATE, line, col, name, IssueType.STRUCTURE, context.formatMessage(I18nConstants.LOGICAL_MODEL_NAME_MISMATCH, name, expectedName), IssueSeverity.FATAL);
	      } else {
	        logError(errors, ValidationMessage.NO_RULE_DATE, line, col, name, IssueType.STRUCTURE, context.formatMessage(I18nConstants.LOGICAL_MODEL_QNAME_MISMATCH, qn(ns, name), qn(expectedNamespace, expectedName)), IssueSeverity.FATAL);	        
	      }
        return null;	      
	    }
	  } else {
      if (ns == null) {
        logError(errors, ValidationMessage.NO_RULE_DATE, line, col, name, IssueType.STRUCTURE, context.formatMessage(I18nConstants.THIS__CANNOT_BE_PARSED_AS_A_FHIR_OBJECT_NO_NAMESPACE, name), IssueSeverity.FATAL);
        return null;
      }
      if (name == null) {
        logError(errors, ValidationMessage.NO_RULE_DATE, line, col, name, IssueType.STRUCTURE, context.formatMessage(I18nConstants.THIS_CANNOT_BE_PARSED_AS_A_FHIR_OBJECT_NO_NAME), IssueSeverity.FATAL);
        return null;
    	}
  	  for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
  	    if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/de-")) {
  	      String type = urlTail(sd.getType());
          if(name.equals(type) && (ns == null || ns.equals(FormatUtilities.FHIR_NS)) && !ToolingExtensions.hasAnyOfExtensions(sd, ToolingExtensions.EXT_XML_NAMESPACE, ToolingExtensions.EXT_XML_NAMESPACE_DEPRECATED))
  	        return sd;
  	      String sns = ToolingExtensions.readStringExtension(sd, ToolingExtensions.EXT_XML_NAMESPACE, ToolingExtensions.EXT_XML_NAMESPACE_DEPRECATED);
  	      if ((name.equals(type) || name.equals(sd.getName())) && ns != null && ns.equals(sns))
  	        return sd;
  	    }
  	  }
  	  logError(errors, ValidationMessage.NO_RULE_DATE, line, col, name, IssueType.STRUCTURE, context.formatMessage(I18nConstants.THIS_DOES_NOT_APPEAR_TO_BE_A_FHIR_RESOURCE_UNKNOWN_NAMESPACENAME_, (ns == null ? "(none)" : ns), name), IssueSeverity.FATAL);
  	  return null;
	  }
  }

  private Object qn(String ns, String name) {
    return ns == null ? name : ns+"::"+name;
  }

  private boolean matchesNamespace(String expectedNamespace, String ns) {
    if (expectedNamespace == null) {
      return ns == null || "noNamespace".equals(ns);
    } else {
      return expectedNamespace.equals(ns);
    }
  }

  private boolean matchesName(String expectedName, String name) {
    return expectedName != null && expectedName.equals(name);
  }

  private String urlTail(String type) {
    return type == null || !type.contains("/") ? type : type.substring(type.lastIndexOf("/")+1);
  }

  protected StructureDefinition getDefinition(List<ValidationMessage> errors, int line, int col, String name) throws FHIRFormatError {
    if (name == null) {
      logError(errors, ValidationMessage.NO_RULE_DATE, line, col, name, IssueType.STRUCTURE, context.formatMessage(I18nConstants.THIS_CANNOT_BE_PARSED_AS_A_FHIR_OBJECT_NO_NAME), IssueSeverity.FATAL);
      return null;
  	}
    // first pass: only look at base definitions
	  for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
	    if (sd.getUrl().equals("http://hl7.org/fhir/StructureDefinition/"+name)) {
	      contextUtilities.generateSnapshot(sd); 
	      return sd;
	    }
	  }
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (name.equals(sd.getTypeName()) && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        contextUtilities.generateSnapshot(sd); 
        return sd;
      }
    }
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (name.equals(sd.getUrl()) && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        contextUtilities.generateSnapshot(sd); 
        return sd;
      }
    }
	  logError(errors, ValidationMessage.NO_RULE_DATE, line, col, name, IssueType.STRUCTURE, context.formatMessage(I18nConstants.THIS_DOES_NOT_APPEAR_TO_BE_A_FHIR_RESOURCE_UNKNOWN_NAME_, name), IssueSeverity.FATAL);
	  return null;
  }

  public ILinkResolver getLinkResolver() {
    return linkResolver;
  }

  public ParserBase setLinkResolver(ILinkResolver linkResolver) {
    this.linkResolver = linkResolver;
    return this;
  }

  public boolean isShowDecorations() {
    return showDecorations;
  }

  public void setShowDecorations(boolean showDecorations) {
    this.showDecorations = showDecorations;
  }

  public String getImpliedProfile() {
    return null;
  }


  public IdRenderingPolicy getIdPolicy() {
    return idPolicy;
  }

  public void setIdPolicy(IdRenderingPolicy idPolicy) {
    this.idPolicy = idPolicy;
  }

  protected boolean wantCompose(String path, Element e) {
    if (!"id".equals(e.getName())) {
      return true;
    }
    if (path!=null && path.contains(".")) {
      return idPolicy.forInner();
    } else {
      return idPolicy.forRoot();
    }
  }

  public boolean hasLogical() {
    return logical != null;
  }

  public StructureDefinition getLogical() {
    return logical;
  }

  public ParserBase setLogical(StructureDefinition logical) {
    this.logical = logical;
    return this;
  }

  public IDigitalSignatureServices getSignatureServices() {
    return signatureServices;
  }

  public void setSignatureServices(IDigitalSignatureServices signatureServices) {
    this.signatureServices = signatureServices;
  }

  protected String getReferenceForElement(Element element) {
    if (element.isPrimitive()) {
      return element.primitiveValue();
    } else {
      return element.getNamedChildValue("reference");
    }
  }

  public IWorkerContext getContext() {
    return context;
  }

  public ValidationPolicy getPolicy() {
    return policy;
  }

  public ProfileUtilities getProfileUtilities() {
    return profileUtilities;
  }

  public ContextUtilities getContextUtilities() {
    return contextUtilities;
  }
  
  
}