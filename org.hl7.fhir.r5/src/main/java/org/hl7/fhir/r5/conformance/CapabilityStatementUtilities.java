package org.hl7.fhir.r5.conformance;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Enumeration;

import org.hl7.fhir.utilities.Utilities;

import java.util.*;

public class CapabilityStatementUtilities {
  private IWorkerContext context;

  public CapabilityStatementUtilities(IWorkerContext context) {
    this.context = context;
  }

  /*
   * Resolves any imported CapabilityStatements and returns a revised CapabilityStatement that merges all functionality from
   * the imported CapabilityStatements
   * @param targetCS - The CapabilityStatement (potentially) containing imports to be resolved
   * @throws FHIRException - If there's an issue resolving any of the imports
   */
  public CapabilityStatement resolveImports(CapabilityStatement targetCS) throws FHIRException {
    CapabilityStatement resolvedCS = targetCS.copy();
    return resolveImports(resolvedCS, new HashMap<>(), "SHALL");
  }

  /*
   * Resolves any imported CapabilityStatements and returns a revised CapabilityStatement that merges all functionality from
   * the imported CapabilityStatements
   * @param targetCS - The CapabilityStatement (potentially) containing imports to be resolved
   * @param importedUrls - Keeps track of what CapabilityStatements have already been merged so that if the same CS appears more
   *    than once in the hierarchy, we only process it once.  Also keeps track of what 'strength' the import is.
   * @throws FHIRException - If there's an issue resolving any of the imports
   *
   * When processing imports, an imported CapabilityStatement can itself declare a conformance expectation.  If an import is a SHOULD or a MAY,
   * then even if the imported CS asserts something as a SHALL, the highest effective level of conformance for the imported statements is the
   * conformance level for the import itself.  And that cascades.  So if a MAY import points to a SHOULD import, the max conformance is 'MAY'.
   *
   * The merge process also tackles most of the semantically-significant extensions on CababilityStatement.
   *
   * Metadata is not merged - so things like description, publisher, etc. are taken only from the root importing CS.
   */
  public CapabilityStatement resolveImports(CapabilityStatement targetCS, Map<String, String> importedUrls, String conformance) throws FHIRException {
    if (!targetCS.hasImports())
      return targetCS;

    CapabilityStatement resolvedCS = targetCS.copy();
    for (CanonicalType canonical: resolvedCS.getImports()) {
      CapabilityStatement importedCS = context.fetchResource(CapabilityStatement.class, canonical.getValue());
      if (importedCS == null)
        throw new FHIRException("Unable to resolve CapabilityStatement " + canonical.getValue() + " imported by " + targetCS.getUrl());
      String importConformance = effectiveConformance(canonical.getExtensionString(ExtensionDefinitions.EXT_CAP_STMT_EXPECT), conformance);
      if (importedUrls.containsKey(canonical.getValue()) && !importedUrls.get(canonical.getValue()).equals(importConformance)) {
        throw new FHIRException("The CapabilityStatement " + canonical.getValue() + " is imported with different strengths - " + importedUrls.get(canonical.getValue()).equals(importConformance) + ", " + importConformance +
          (importConformance.equals(canonical.getExtensionString(ExtensionDefinitions.EXT_CAP_STMT_EXPECT)) ? "" : "(effective from " + canonical.getExtensionString(ExtensionDefinitions.EXT_CAP_STMT_EXPECT) + ")"));
      }
      importedUrls.put(targetCS.getUrl(), importConformance);

      CapabilityStatement mergedImportedCS = resolveImports(importedCS, importedUrls, importConformance);
      mergeCS(resolvedCS, mergedImportedCS, importConformance);
    }

    return resolvedCS;
  }

  /*
   * Merges the details of an imported capability statement into the 'target' capability statement (which is a copy of the importing CS)
   * The general import rules are as follows:
   * - If the importing CS has something and the imported doesn't, grab what the importing does.
   * - If the imported CS has something and the importing doesn't, grab what the imported does.
   * - If both do something, combine the functionality and set the conformance expectation to the highest of the two
   *
   * Additional rules:
   *  - CS allows you to specify separate messaging repetitions with different combinations of recipients.  That gets miserable to try to merge
   *    because the potential recipients can be overlapping.  It's also super-rare to do that.  So this algorithm only handles merging if there's
   *    a maximum of one messaging element (though that one element can list lots of supported messages)
   *  - If there's non-repeating elements with different values, grab the one with the highest conformance expectation.  If the conformance levels
   *    are the same, then fail due to the conflict.  For example, if one says SHOULD security.cors = true and the other says SHALL security.cors = false,
   *    then the SHALL takes precedence.  On the other hand, if both say SHOULD with different values, that's conflict and will trigger an exception.
   *  - For certain 'coded' elements there's a hierarchy.  versioned-update implies versioned.  So if you have SHOULD:versioned and SHOULD:versioned-update,
   *    that's *not* a conflict and you'll end up with SHOULD:versioned-update.  (Hierarchies are handled by the weightForEnum function.)
   *  - For numeric values, will take the strictest.  So for timeout values, if there is a SHOULD:5seconds and SHOULD:10 seconds, you'll get SHOULD:5 seconds
   *  - For coded values, a match means all codings match (code, system, and version if present) and text matches.  Display names are ignored
   *  - It's also a conflict if:
   *    - the same operation 'code' is associated with different operation definitions
   *    - the same search parameter 'code' is associated with different search parameter definitions
   *    - the same rest.resource is tied to different profiles.  (We could try to be smart and figure out if the imported profile is a proper subset of the
   *      importing profile, but that was too hard to take on at this point)
   *    - An imported search combination has more 'optional' elements than the importing search combination
   *  - The following are additional limitations
   *    - Can't handle endpoints on an imported CS.  (That's a super-weird situation and couldn't decide what to do about it.)  Same is true for importing
   *      a CS with messages that declare endpoints
   *
   *
   */
  protected void mergeCS(CapabilityStatement targetCS, CapabilityStatement importedCS, String maxConformance) {
    merge(targetCS.getFormat(), importedCS.getFormat(), maxConformance, "format");
    merge(targetCS.getPatchFormat(), importedCS.getPatchFormat(), maxConformance, "patchFormat");
    merge(targetCS.getAcceptLanguage(), importedCS.getAcceptLanguage(), maxConformance, "acceptLanguage");
    merge(targetCS.getImplementationGuide(), importedCS.getImplementationGuide(), maxConformance, "implementationGuide");
    merge(targetCS.getRest(), importedCS.getRest(), maxConformance, "rest");
    if (targetCS.getMessaging().size()>1)
      throw new FHIRException("Unable to handle messaging repetitions greater than one for importing Capability Statement - use one repetition with multiple messaging.supportedMessage elements.");
    else if (importedCS.getMessaging().size()>1)
      throw new FHIRException("Unable to handle messaging repetitions greater than one for imported Capability Statement - use one repetition with multiple messaging.supportedMessage elements.");
    else if (!importedCS.hasMessaging()) {
      // Do nothing
    } else if (!targetCS.hasMessaging())
      targetCS.setMessaging(importedCS.getMessaging());
    else {
      CapabilityStatement.CapabilityStatementMessagingComponent targetMessaging = targetCS.getMessaging().get(0);
      CapabilityStatement.CapabilityStatementMessagingComponent importedMessaging = importedCS.getMessaging().get(0);
      merge(targetMessaging.getReliableCacheElement(), importedMessaging.getReliableCacheElement(), maxConformance, "messaging.reliableCache");
      if (importedMessaging.hasEndpoint())
        throw new FHIRException("Importing capability statements that assert endpoints is not supported");
      merge(targetMessaging.getSupportedMessage(), importedMessaging.getSupportedMessage(), maxConformance, "messaging.supportedMessage");
    }
    merge(targetCS.getMessaging(), importedCS.getMessaging(), maxConformance, "messaging");
    merge(targetCS.getDocument(), importedCS.getDocument(), maxConformance, "messaging");
  }

  void mergeProperties(CapabilityStatement.CapabilityStatementRestComponent targetType, CapabilityStatement.CapabilityStatementRestComponent importedType, String maxConformance, String context) {
    String localContext = context + "." + targetType.getMode();

    merge(targetType.getExtensionsByUrl(ExtensionDefinitions.EXT_CSDECLARED_PROFILE), importedType.getExtensionsByUrl(ExtensionDefinitions.EXT_CSDECLARED_PROFILE), maxConformance, ".extension(DeclaredProfile)");
    merge(targetType.getExtensionsByUrl(ExtensionDefinitions.EXT_CSSEARCH_PARAMETER_COMBINATION), importedType.getExtensionsByUrl(ExtensionDefinitions.EXT_CSSEARCH_PARAMETER_COMBINATION), maxConformance, ".extension(SearchMode)");
    if (!targetType.hasSecurity())
      targetType.setSecurity(importedType.getSecurity());
    else if (!importedType.hasSecurity())
      return;
    else {
      mergeProperties(targetType.getSecurity(), importedType.getSecurity(), maxConformance, localContext);
      mergeExpectations(targetType.getSecurity(), importedType.getSecurity(), maxConformance);
    }
    merge(targetType.getResource(), importedType.getResource(), maxConformance, localContext + ".resource");
    merge(targetType.getInteraction(), importedType.getInteraction(), maxConformance, localContext + ".interaction");
    merge(targetType.getOperation(), importedType.getOperation(), maxConformance, localContext + ".operation");
    merge(targetType.getSearchParam(), importedType.getSearchParam(), maxConformance, localContext + ".searchParam");
  }

  /*
   * Merges the properties of two RestSecurity components together
   * NOTE: Doesn't merge documentation or extensions
   */
  // TODO: Handle known security extensions
  void mergeProperties(CapabilityStatement.CapabilityStatementRestSecurityComponent targetType, CapabilityStatement.CapabilityStatementRestSecurityComponent importedType, String maxConformance, String context) {
    merge(targetType.getCorsElement(), importedType.getCorsElement(), maxConformance, context + ".cors");
    merge(targetType.getService(), importedType.getService(), maxConformance, context + ".service");
  }

  void mergeProperties(CapabilityStatement.CapabilityStatementRestResourceComponent targetType, CapabilityStatement.CapabilityStatementRestResourceComponent importedType, String maxConformance, String context) throws FHIRException {
    String localContext = context + "." + targetType.getType();
    if (targetType.hasProfile() && importedType.hasProfile() && !targetType.getProfile().equals(importedType.getProfile()))
      throw new FHIRException("Conflicting resource profiles for " + localContext + ".  If both the importing and imported CapabilityStatement declare profiles for the same resource, those profiles must be the same." +
        "Importing: " + targetType.getProfile() + "; Imported: " + importedType.getProfile());
    merge(targetType.getSupportedProfile(), importedType.getSupportedProfile(), maxConformance, localContext + ".supportedProfile");
    targetType.setVersioningElement(merge(targetType.getVersioningElement(), importedType.getVersioningElement(), maxConformance, localContext + ".versioning"));
    merge(targetType.getInteraction(), importedType.getInteraction(), maxConformance, localContext + ".interaction");
    targetType.setReadHistoryElement(merge(targetType.getReadHistoryElement(), importedType.getReadHistoryElement(), maxConformance, localContext + ".readHistory"));
    targetType.setUpdateCreateElement(merge(targetType.getUpdateCreateElement(), importedType.getUpdateCreateElement(), maxConformance, localContext + ".updateCreate"));
    targetType.setConditionalCreateElement(merge(targetType.getConditionalCreateElement(), importedType.getConditionalCreateElement(), maxConformance, localContext + ".conditionalCreate"));
    targetType.setConditionalReadElement(merge(targetType.getConditionalReadElement(), importedType.getConditionalReadElement(), maxConformance, localContext + ".conditionalRead"));
    targetType.setConditionalPatchElement(merge(targetType.getConditionalPatchElement(), importedType.getConditionalPatchElement(), maxConformance, localContext + ".conditionalPatch"));
    targetType.setConditionalDeleteElement(merge(targetType.getConditionalDeleteElement(), importedType.getConditionalDeleteElement(), maxConformance, localContext + ".conditionalDelete"));
    merge(targetType.getReferencePolicy(), importedType.getReferencePolicy(), maxConformance, localContext + ".referencePolicy");
    merge(targetType.getSearchInclude(), importedType.getSearchInclude(), maxConformance, localContext + ".searchInclude");
    merge(targetType.getSearchRevInclude(), importedType.getSearchRevInclude(), maxConformance, localContext + ".searchRevInclude");
    merge(targetType.getSearchParam(), importedType.getSearchParam(), maxConformance, localContext + ".searchParam");
    merge(targetType.getOperation(), importedType.getOperation(), maxConformance, localContext + ".operation");
  }

  void mergeProperties(CapabilityStatement.CapabilityStatementRestResourceOperationComponent targetType, CapabilityStatement.CapabilityStatementRestResourceOperationComponent importedType, String context) throws FHIRException {
    String localContext = context + "(name=" + targetType.getName() + ")";
    if (!importedType.hasDefinition()) {
      // do nothing
    } else if (!targetType.hasDefinition())
      targetType.setDefinitionElement(importedType.getDefinitionElement());
    else if (!targetType.getDefinition().equals(importedType.getDefinition()))
      throw new FHIRException("Differing definitions for same operation " + localContext + " in imported IG.  Importing:" + targetType.getDefinition() + "; imported:" + importedType.getDefinition());
  }

  void mergeProperties(CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent targetType, CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent importedType, String maxConformance, String context) throws FHIRException {
    String localContext = context + "(name=" + targetType.getName() + ")";
    if (!importedType.hasDefinition()) {
      // do nothing
    } else if (!targetType.hasDefinition()) {
      targetType.setDefinitionElement((CanonicalType)fixMax(importedType.getDefinitionElement(), maxConformance));
    } else if (!targetType.getDefinition().equals(importedType.getDefinition()))
      throw new FHIRException("Differing definitions for same Search parameter " + localContext + " in imported IG.  Importing:" + targetType.getDefinition() + "; imported:" + importedType.getDefinition());
    if (!importedType.hasType()) {
      // do nothing
    } else if (!targetType.hasType()) {
      targetType.setTypeElement((Enumeration<Enumerations.SearchParamType>)fixMax(importedType.getTypeElement(), maxConformance));
    } else if (!targetType.getType().equals(importedType.getType()))
      throw new FHIRException("Differing search types for same Search parameter " + localContext + " in imported IG.  Importing:" + targetType.getType() + "; imported:" + importedType.getType());
  }

  void mergeProperties(CapabilityStatement.CapabilityStatementMessagingComponent targetType, CapabilityStatement.CapabilityStatementMessagingComponent importedType, String maxConformance, String context) throws FHIRException {
    if (importedType.hasEndpoint()) {
      throw new FHIRException("Cannot handle importing messaging with declared endpoints");
    }
    targetType.setReliableCacheElement(merge(targetType.getReliableCacheElement(), importedType.getReliableCacheElement(), maxConformance, context + ".reliableCache"));
    merge(targetType.getSupportedMessage(), importedType.getSupportedMessage(), maxConformance, context + ".reliableCache");
  }

  void merge(List targetList, List importedList, String context) throws FHIRException {
    merge(targetList, importedList, "SHALL", context);
  }

  /*
   * Combines any 'simple' types found in the 'imported' list into the target list, merging conformance expectations found on matching codes
   */
  void merge(List targetList, List importedList, String maxConformance, String context) throws FHIRException {
    for (Object importedType : importedList) {
      Object foundType = null;
      for (Object targetType : targetList) {
        boolean match;
        if (targetType instanceof PrimitiveType)
          match = importedType.toString().equals(targetType.toString());
        else if (importedType instanceof CodeableConcept)
          match = match((CodeableConcept)targetType,(CodeableConcept)importedType);
        else if (importedType instanceof CapabilityStatement.CapabilityStatementRestComponent)
          match = ((CapabilityStatement.CapabilityStatementRestComponent)targetType).getMode().equals(((CapabilityStatement.CapabilityStatementRestComponent)importedType).getMode());
        else if (importedType instanceof CapabilityStatement.CapabilityStatementRestResourceComponent)
          match = ((CapabilityStatement.CapabilityStatementRestResourceComponent)targetType).getType().equals(((CapabilityStatement.CapabilityStatementRestResourceComponent)importedType).getType());
        else if (importedType instanceof CapabilityStatement.CapabilityStatementRestResourceOperationComponent)
          match = ((CapabilityStatement.CapabilityStatementRestResourceOperationComponent)targetType).getName().equals(((CapabilityStatement.CapabilityStatementRestResourceOperationComponent)importedType).getName());
        else if (importedType instanceof CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent)
          match = ((CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent)targetType).getName().equals(((CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent)importedType).getName());
        else if (importedType instanceof CapabilityStatement.CapabilityStatementMessagingComponent)
          match = true; // We only work if there's only one messaging component in each
        else if (importedType instanceof CapabilityStatement.ResourceInteractionComponent)
          match = ((CapabilityStatement.ResourceInteractionComponent)targetType).getCode().equals(((CapabilityStatement.ResourceInteractionComponent)importedType).getCode());
        else if (importedType instanceof CapabilityStatement.SystemInteractionComponent)
          match = ((CapabilityStatement.SystemInteractionComponent)targetType).getCode().equals(((CapabilityStatement.SystemInteractionComponent)importedType).getCode());
        else if (importedType instanceof CapabilityStatement.CapabilityStatementDocumentComponent)
          match = ((CapabilityStatement.CapabilityStatementDocumentComponent)targetType).getMode().equals(((CapabilityStatement.CapabilityStatementDocumentComponent)importedType).getMode()) &&
            ((CapabilityStatement.CapabilityStatementDocumentComponent)targetType).getProfile().equals(((CapabilityStatement.CapabilityStatementDocumentComponent)importedType).getProfile());
        else if (importedType instanceof CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent)
          match = ((CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent)targetType).getMode().equals(((CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent)importedType).getMode())
            && ((CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent)targetType).getDefinition().equals(((CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent)importedType).getDefinition());
        else if (importedType instanceof Extension) {
          if (((Extension)importedType).getUrl().equals(ExtensionDefinitions.EXT_CSDECLARED_PROFILE))
            match = ((Extension)targetType).getValueCanonicalType().getValue().equals(((Extension)importedType).getValueCanonicalType().getValue());
          else if (((Extension)importedType).getUrl().equals(ExtensionDefinitions.EXT_CSSEARCH_PARAMETER_COMBINATION)) {
            match = requiredSort(targetType).equals(requiredSort(importedType));
          } else
            throw new Error("Unexpected extension " + ((Extension)importedType).getUrl());
        } else
          throw new Error("Unhandled complex type in List match");
        if (match){
          foundType = targetType;
          break;
        }
      }
      if (foundType == null)
        targetList.add(importedType);
      else {
        if (importedType instanceof PrimitiveType) {
          // No properties to merge
        } else if (importedType instanceof CapabilityStatement.CapabilityStatementRestComponent)
          mergeProperties((CapabilityStatement.CapabilityStatementRestComponent)foundType, (CapabilityStatement.CapabilityStatementRestComponent)importedType, maxConformance, context);
        else if (importedType instanceof CapabilityStatement.CapabilityStatementRestResourceComponent)
          mergeProperties((CapabilityStatement.CapabilityStatementRestResourceComponent)foundType, (CapabilityStatement.CapabilityStatementRestResourceComponent)importedType, maxConformance, context);
        else if (importedType instanceof CapabilityStatement.CapabilityStatementRestResourceOperationComponent)
          mergeProperties((CapabilityStatement.CapabilityStatementRestResourceOperationComponent)foundType, (CapabilityStatement.CapabilityStatementRestResourceOperationComponent)importedType, context);
        else if (importedType instanceof CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent)
          mergeProperties((CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent)foundType, (CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent)importedType, maxConformance, context);
        else if (importedType instanceof CapabilityStatement.ResourceInteractionComponent || importedType instanceof CapabilityStatement.SystemInteractionComponent) {
          // No properties to merge
        } else if (importedType instanceof CapabilityStatement.CapabilityStatementDocumentComponent) {
          // No properties to merge
        } else if (importedType instanceof CapabilityStatement.CapabilityStatementMessagingComponent)
          mergeProperties((CapabilityStatement.CapabilityStatementMessagingComponent)foundType, (CapabilityStatement.CapabilityStatementMessagingComponent)importedType, maxConformance, context);
        else if (importedType instanceof CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent) {
          // No properties to merge
        } else if (importedType instanceof Extension) {
          if (((Extension) importedType).getUrl().equals(ExtensionDefinitions.EXT_CSDECLARED_PROFILE)) {
            // No action needed
          } else if (((Extension) importedType).getUrl().equals(ExtensionDefinitions.EXT_CSSEARCH_PARAMETER_COMBINATION))
            mergeSearchComboExt(((Extension) foundType), ((Extension) importedType), context + ".extension(SearchCombo - " + requiredSort(importedType) + ")");
        }
        mergeExpectations((Element) foundType, (Element) importedType, maxConformance);
      }
    }
  }

  /*
   * Two CodeableConcepts match if they have the same text and their codings match by code + system (and version if present)
   */
  private boolean match(CodeableConcept a, CodeableConcept b) {
    if (a.hasText() || b.hasText())
      if (a.hasText()!= b.hasText() || !a.getText().equals(b.getText()))
        return false;
    if (a.getCoding().size()!= b.getCoding().size())
      return false;
    for (Coding codeA: a.getCoding()) {
      boolean codingMatch = false;
      for (Coding codeB: b.getCoding()) {
        if (codeA.hasSystem() != codeB.hasSystem())
          continue;
        if (codeA.hasSystem() && !codeA.getSystem().equals(codeB.getSystem()))
          continue;
        if (codeA.hasCode() != codeB.hasCode())
          continue;
        if (codeA.hasCode() && !codeA.getCode().equals(codeB.getCode()))
          continue;
        if (codeA.hasVersion() != codeB.hasVersion())
          continue;
        if (codeA.hasVersion() && !codeA.getVersion().equals(codeB.getVersion()))
          continue;
        codingMatch = true;
        break;
      }
      if (!codingMatch)
        return false;
    }
    return true;
  }

  private List<String> extensionValueList(Extension sortExtension, String url) {
    List<String> aList = new ArrayList<>();
    for (Extension e: sortExtension.getExtensionsByUrl(url)) {
      aList.add(e.getValueStringType().toString());
    }
    aList.sort(new Utilities.CaseInsensitiveSorter());
    return aList;
  }

  private String requiredSort(Object sortExtension) {
    return String.join(";", extensionValueList((Extension)sortExtension, "required"));
  }

  private void mergeSearchComboExt(Extension targetExt, Extension importedExt, String context) {
    List<String> targetList = extensionValueList(targetExt, "otional");
    List<String> importedList = extensionValueList(importedExt, "otional");
    if (!targetList.containsAll(importedList))
      throw new FHIRException("Search Options extension for " + context + " does not contain all of the optional search names from the imported CapabilityStatement, which is not supported.");
  }

  private UnsignedIntType merge(UnsignedIntType targetInt, UnsignedIntType importedInt, String context) throws FHIRException {
    return merge(targetInt, importedInt, "SHALL", context);
  }

  private UnsignedIntType merge(UnsignedIntType targetInt, UnsignedIntType importedInt, String maxConformance, String context) throws FHIRException {
    if (targetInt == null)
      return importedInt;
    else if (importedInt == null)
      return (UnsignedIntType)fixMax(targetInt, context);
    else if (targetInt.getValue().equals(importedInt.getValue())) {
      mergeExpectations(targetInt, importedInt, maxConformance);
      return targetInt;
    } else if (targetInt.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT) && importedInt.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT)) {
      String targetExpectation = targetInt.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode();
      String importedExpectation = importedInt.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode();
      if (targetExpectation.equals(importedExpectation)) {
        if (targetExpectation.equals("SHALL"))
          throw new FHIRException("Non matching enumeration values with SHALL conformance expectations for " + context + " - base CapabilityStatement:" + targetInt.getValue() + "; imported CapabilityStatement:" + importedInt.getValue());
        else if (targetInt.getValue() > importedInt.getValue())
          return targetInt;
        else
          return (UnsignedIntType)fixMax(importedInt, maxConformance);
      } else {
        if (targetExpectation.equals("SHALL"))
          return targetInt;
        else if (importedExpectation.equals("SHALL"))
          return (UnsignedIntType)fixMax(importedInt, maxConformance);
        else if (targetInt.getValue() > importedInt.getValue())
          return targetInt;
        else
          return importedInt;
      }
    }
    throw new FHIRException("Non matching integer values for " + context + " - base CapabilityStatement:" + targetInt.getValue() + "; imported CapabilityStatement:" + importedInt.getValue());
  }


  private Enumeration merge(Enumeration targetCode, Enumeration importedCode, String context) throws FHIRException {
    return merge(targetCode, importedCode, "SHALL", context);
  }

  /*
   * Selects whichever code exists if only one exists, otherwise checks that the two codes match and merges conformance expectations
   */
  private Enumeration merge(Enumeration targetCode, Enumeration importedCode, String maxConformance, String context) throws FHIRException {
    if (targetCode == null || targetCode.getCode() == null)
      return (Enumeration)fixMax(importedCode, maxConformance);
    else if (importedCode == null || importedCode.getCode() == null)
      return targetCode;
    else if (targetCode.getValue().equals(importedCode.getValue())) {
      mergeExpectations(targetCode, importedCode, maxConformance);
      return targetCode;
    } else if (targetCode.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT) && importedCode.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT)) {
      String targetExpectation = targetCode.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode();
      String importedExpectation = importedCode.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode();
      int targetWeight = weightForEnum(targetCode, context);
      int importedWeight = weightForEnum(importedCode, context);
      if (targetExpectation.equals(importedExpectation)) {
        if (targetExpectation.equals("SHALL"))
          throw new FHIRException("Non matching enumeration values with SHALL conformance expectations for " + context + " - base CapabilityStatement:" + targetCode.getValue() + "; imported CapabilityStatement:" + importedCode.getValue());
        else if (targetWeight == importedWeight)
          throw new FHIRException("Non matching enumeration values with equivalent weight and identical conformance expectations for " + context + " - base CapabilityStatement:" + targetCode.getValue() + "; imported CapabilityStatement:" + importedCode.getValue());
        else if (targetWeight > importedWeight)
          return targetCode;
        else
          return (Enumeration)fixMax(importedCode, maxConformance);
      } else {
        if (targetExpectation.equals("SHALL"))
          return targetCode;
        else if (importedExpectation.equals("SHALL"))
          return (Enumeration)fixMax(importedCode, maxConformance);
        else if (targetWeight == importedWeight)
          throw new FHIRException("Non matching enumeration values with equivalent weight and optional conformance expectations for " + context + " - base CapabilityStatement:" + targetCode.getValue() + "; imported CapabilityStatement:" + importedCode.getValue());
        else if (targetWeight > importedWeight)
          return targetCode;
        else
          return (Enumeration)fixMax(importedCode, maxConformance);
      }
    }
    throw new FHIRException("Non matching code values for " + context + " - base CapabilityStatement:" + targetCode.getCode() + "; imported CapabilityStatement:" + importedCode.getCode());
  }

  /*
   * Returns a numeric weight for enumeration codes that represent differing levels of sophistication.
   * Lower numbers imply lesser functionality that is implicitly included in higher numbers.  I.e. If you have a higher number it means you support the functionality of the lower numbers
   */
  private int weightForEnum(Enumeration code, String context) {
    switch (code.getSystem()) {
      case "http://hl7.org/fhir/conditional-delete-status":
        CapabilityStatement.ConditionalDeleteStatus deleteStatus = CapabilityStatement.ConditionalDeleteStatus.fromCode(code.getCode());
        switch (deleteStatus) {
          case NOTSUPPORTED:
            return 0;
          case SINGLE:
            return 1;
          case MULTIPLE:
            return 2;
          default:
            throw new FHIRException("Unrecognized Delete Status in " + context + ": " + code.getCode());
        }
      case "http://hl7.org/fhir/conditional-read-status":
        CapabilityStatement.ConditionalReadStatus readStatus = CapabilityStatement.ConditionalReadStatus.fromCode(code.getCode());
        switch (readStatus) {
          case NOTSUPPORTED:
            return 0;
          case MODIFIEDSINCE:
            return 1;
          case NOTMATCH:
            return 1; // Same weight as MODIFIEDSINCE
          case FULLSUPPORT:
            return 2;
          default:
            throw new FHIRException("Unrecognized Read Status in " + context + ": " + code.getCode());
        }
      case "http://hl7.org/fhir/versioning-policy":
        CapabilityStatement.ResourceVersionPolicy versionPolicy = CapabilityStatement.ResourceVersionPolicy.fromCode(code.getCode());
        switch (versionPolicy) {
          case NOVERSION:
            return 0;
          case VERSIONED:
            return 1;
          case VERSIONEDUPDATE:
            return 2;
          default:
            throw new FHIRException("Unrecognized Versioning Policy in " + context + ": " + code.getCode());
        }
    }
    throw new Error("Unsupported code system in " + context + ": " + code.getSystem());
  }

  protected BooleanType merge(BooleanType targetBool, BooleanType importedBool, String context) throws FHIRException {
    return merge(targetBool, importedBool, "SHALL", context);
  }

  /*
   * Selects whichever code exists if only one exists, otherwise checks that the two codes match and merges conformance expectations
   */
  protected BooleanType merge(BooleanType targetBool, BooleanType importedBool, String maxConformance, String context) throws FHIRException {
    if (targetBool == null || targetBool.getValue() == null)
      return (BooleanType)fixMax(importedBool,maxConformance);
    else if (importedBool == null || importedBool.getValue() == null)
      return targetBool;
    else if (targetBool.getValue().equals(importedBool.getValue())) {
      mergeExpectations(targetBool, importedBool, maxConformance);
      return targetBool;
    } else if (targetBool.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT) && importedBool.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT)) {
      String targetExpectation = targetBool.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode();
      String importedExpectation = importedBool.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT).getValueCodeType().getCode();
      if (targetExpectation.equals(importedExpectation))
        throw new FHIRException("Non matching boolean values with equivalent conformance expectations for " + context + " - base CapabilityStatement:" + targetBool.getValue() + "; imported CapabilityStatement:" + importedBool.getValue());
      else if (targetExpectation.equals("SHALL"))
        return targetBool;
      else if (importedExpectation.equals("SHALL"))
        return (BooleanType)fixMax(importedBool, maxConformance);
      else if (targetExpectation.equals("SHOULD"))
        return targetBool;
      else if (importedExpectation.equals("SHOULD"))
        return (BooleanType)fixMax(importedBool, maxConformance);
    }
    throw new FHIRException("Non matching boolean values with no conformance expectations for " + context + " - base CapabilityStatement:" + targetBool.getValue() + "; imported CapabilityStatement:" + importedBool.getValue());
  }


  public void mergeExpectations(Element target, Element source, String maxConformance) {
    if (target.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT)) {
      Extension targetExpectation = target.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT);
      if (!targetExpectation.getValueCodeType().getCode().equals("SHALL") && source.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT)) {
        String sourceExpectation = effectiveConformance(source.getExtensionString(ExtensionDefinitions.EXT_CAP_STMT_EXPECT), maxConformance);
        if (sourceExpectation.equals("SHALL") || targetExpectation.getValueCodeType().getCode().equals("MAY"))
          targetExpectation.setValue(new CodeType(sourceExpectation));
      }
    } else if (source.hasExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT)) {
      target.addExtension(source.getExtensionByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT));
    }
  }

  private String effectiveConformance(String conf, String maxConf) {
    conf = conf==null ? "SHALL" : conf;
    maxConf = maxConf==null ? "SHALL" : maxConf;
    if (conf.equals(maxConf))
      return conf;
    else if (conf.equals("SHALL"))
      return maxConf;
    else if (maxConf.equals("SHALL") || maxConf.equals("SHOULD"))
      return conf;
    else
      return maxConf;
  }

  public DataType fixMax(DataType d, String maxConformance) {
    String conformance = d.getExtensionString(ExtensionDefinitions.EXT_CAP_STMT_EXPECT);
    d.removeExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT);
    d.addExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT, new CodeType(effectiveConformance(conformance, maxConformance)));
    return d;
  }
}