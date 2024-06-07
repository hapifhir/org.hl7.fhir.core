package org.hl7.fhir.validation.instance;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.*;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.ResourceUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidatorUtils;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R5EvaluationContext implements FHIRPathEngine.IEvaluationContext {
  private final Map<String,Element> validatedContentMap = new HashMap<>();

  public R5EvaluationContext(SimpleWorkerContext context, List<ValidatorUtils.SourceFile> refs) {
    for (ValidatorUtils.SourceFile ref : refs) {
      List<ValidatedFragment> validatedContent = getValidatedFragmentList(context, ref);
      if (validatedContent.size() == 1 && validatedContent.get(0).getElement() != null && ref.getResourceType()!=null ) {
        this.validatedContentMap.put(ref.getResourceType().name() + "/" + ref.getId(), validatedContent.get(0).getElement());
      }
    }
  }

  private static List<ValidatedFragment> getValidatedFragmentList(SimpleWorkerContext context, ValidatorUtils.SourceFile ref) {
    ParserBase parser = Manager.makeParser(context, ref.getCnt().getCntType());
    List<StructureDefinition> logicals = new ArrayList<>();
//      for (StructureDefinition sd : profiles) {
//        if (sd.getKind() == StructureDefinition.StructureDefinitionKind.LOGICAL) {
//          logicals.add(sd);
//        }
//      }
//      if (logicals.size() > 0) {
//        if (rulePlural(errors, NO_RULE_DATE, ValidationMessage.IssueType.BUSINESSRULE, "Configuration", logicals.size() == 1, logicals.size(), I18nConstants.MULTIPLE_LOGICAL_MODELS, ResourceUtilities.listUrls(logicals))) {
//          parser.setLogical(logicals.get(0));
//        }
//      }
    if (parser instanceof XmlParser) {
      ((XmlParser) parser).setAllowXsiLocation(true);
    }
    parser.setupValidation(ParserBase.ValidationPolicy.EVERYTHING);
    if (parser instanceof XmlParser) {
      ((XmlParser) parser).setAllowXsiLocation(true);
    }
    if (parser instanceof JsonParser) {
      ((JsonParser) parser).setAllowComments(true);
    }
    // TODO: check if this is allowed.
//      parser.setSignatureServices(signatureServices);

    List<ValidatedFragment> validatedContent = null;
    try {
      validatedContent = parser.parse(new ByteArrayInputStream(ref.getCnt().getFocus().getBytes()));
    } catch (IOException e) {
      throw new FHIRException(e);
    }
    return validatedContent;
  }

  public R5EvaluationContext() {
  }


  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, boolean beforeContext, boolean explicitConstant) throws PathEngineException {
    return List.of();
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, boolean explicitConstant) throws PathEngineException {
    return null;
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    return false;
  }

  @Override
  public FHIRPathUtilityClasses.FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    return null;
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    return null;
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    return List.of();
  }

  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) throws FHIRException {
    if ( url.contains("/") ){
      return this.validatedContentMap.get( url );
    }
    return null;
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
    return false;
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
    return null;
  }

  @Override
  public boolean paramIsType(String name, int index) {
    return false;
  }
}
