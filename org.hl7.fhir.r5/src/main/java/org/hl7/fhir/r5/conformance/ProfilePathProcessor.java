package org.hl7.fhir.r5.conformance;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProfilePathProcessor {

  private final ProfileUtilities profileUtilities;

  public ProfilePathProcessor(ProfileUtilities profileUtilities) {
    this.profileUtilities = profileUtilities;
  }

  protected void processPaths(StructureDefinition base, StructureDefinition derived, String url, String webUrl, StructureDefinition.StructureDefinitionDifferentialComponent diff, StructureDefinition.StructureDefinitionSnapshotComponent baseSnapshot) {
    processPaths("", derived.getSnapshot(), baseSnapshot, diff, 0, 0, baseSnapshot.getElement().size()-1,
      derived.getDifferential().hasElement() ? derived.getDifferential().getElement().size()-1 : -1, url, webUrl, derived.present(), null, null, false, base.getUrl(), null, false, null, null, new ArrayList<ElementRedirection>(), base);
  }

  /**
   * @param trimDifferential
   * @param srcSD
   * @throws DefinitionException, FHIRException
   * @throws Exception
   */
  private ElementDefinition processPaths(final String indent,
                                         final StructureDefinition.StructureDefinitionSnapshotComponent result,
                                         StructureDefinition.StructureDefinitionSnapshotComponent base,
                                         final StructureDefinition.StructureDefinitionDifferentialComponent differential,
                                         int baseCursor, int diffCursor,
                                         final int baseLimit, final int diffLimit,
                                         final String url, final String webUrl,
                                         final String profileName, final String contextPathSrc,
                                         final String contextPathDst,
                                         final boolean trimDifferential,
                                         String contextName,
                                         String resultPathBase,
                                         final boolean slicingDone, final ElementDefinition slicer, final String typeSlicingPath, final List<ElementRedirection> redirector,
                                         final StructureDefinition srcSD) throws FHIRException {
    if (profileUtilities.isDebug()) {
      System.out.println(indent+"PP @ "+resultPathBase+" / "+contextPathSrc+" : base = "+baseCursor+" to "+baseLimit+", diff = "+diffCursor+" to "+diffLimit+" (slicing = "+slicingDone+", k "+(redirector == null ? "null" : redirector.toString())+")");
    }
    ElementDefinition res = null;
    List<TypeSlice> typeList = new ArrayList<>();
    // just repeat processing entries until we run out of our allowed scope (1st entry, the allowed scope is all the entries)
    while (baseCursor <= baseLimit) {
      // get the current focus of the base, and decide what to do
      ElementDefinition currentBase = base.getElement().get(baseCursor);
      String currentBasePath = profileUtilities.fixedPathSource(contextPathSrc, currentBase.getPath(), redirector);
      if (profileUtilities.isDebug()) {
        System.out.println(indent+" - "+currentBasePath+": base = "+baseCursor+" ("+profileUtilities.descED(base.getElement(),baseCursor)+") to "+baseLimit+" ("+profileUtilities.descED(base.getElement(),baseLimit)+"), diff = "+diffCursor+" ("+profileUtilities.descED(differential.getElement(),diffCursor)+") to "+diffLimit+" ("+profileUtilities.descED(differential.getElement(),diffLimit)+") "+
          "(slicingDone = "+slicingDone+") (diffpath= "+(differential.getElement().size() > diffCursor ? differential.getElement().get(diffCursor).getPath() : "n/a")+")");
      }
      List<ElementDefinition> diffMatches = profileUtilities.getDiffMatches(differential, currentBasePath, diffCursor, diffLimit, profileName); // get a list of matching elements in scope

      // in the simple case, source is not sliced.
      if (!currentBase.hasSlicing() || currentBasePath.equals(typeSlicingPath)) {
        // the differential doesn't say anything about this item
        // so we just copy it in
        if (diffMatches.isEmpty()) {
          ElementDefinition outcome = profileUtilities.updateURLs(url, webUrl, currentBase.copy());
          outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
          profileUtilities.updateFromBase(outcome, currentBase, srcSD.getUrl());
          profileUtilities.updateConstraintSources(outcome, srcSD.getUrl());
          profileUtilities.markDerived(outcome);
          if (resultPathBase == null)
            resultPathBase = outcome.getPath();
          else if (!outcome.getPath().startsWith(resultPathBase))
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH__OUTCOMEGETPATH___RESULTPATHBASE__, outcome.getPath(), resultPathBase));
          result.getElement().add(outcome);
          if (profileUtilities.hasInnerDiffMatches(differential, currentBasePath, diffCursor, diffLimit, base.getElement(), true)) {
            // well, the profile walks into this, so we need to as well
            // did we implicitly step into a new type?
            if (profileUtilities.baseHasChildren(base, currentBase)) { // not a new type here
              processPaths(indent+"  ", result, base, differential, baseCursor+1, diffCursor, baseLimit, diffLimit, url, webUrl, profileName, contextPathSrc, contextPathDst, trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);
              baseCursor = profileUtilities.indexOfFirstNonChild(base, currentBase, baseCursor+1, baseLimit);
            } else {
              if (outcome.getType().size() == 0 && !outcome.hasContentReference()) {
                throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_NO_CHILDREN__AND_NO_TYPES_IN_PROFILE_, currentBasePath, differential.getElement().get(diffCursor).getPath(), profileName));
              }
              boolean nonExtension = false;
              if (outcome.getType().size() > 1) {
                for (ElementDefinition.TypeRefComponent t : outcome.getType()) {
                  if (!t.getWorkingCode().equals("Reference")) {
                    for (ElementDefinition ed : diffMatches) {
                      if (ed != diffMatches.get(0) && !ed.getPath().endsWith(".extension")) {
                        nonExtension = true;
                      }
                    }
                  }
                }
              }
              int start = diffCursor;
              while (differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), currentBasePath+"."))
                diffCursor++;
              if (nonExtension) {
                throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__AND_MULTIPLE_TYPES__IN_PROFILE_, currentBasePath, differential.getElement().get(diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), profileName));
              }
              if (outcome.hasContentReference()) {
                ProfileUtilities.ElementDefinitionResolution tgt = profileUtilities.getElementById(srcSD, base.getElement(), outcome.getContentReference());
                if (tgt == null)
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNABLE_TO_RESOLVE_REFERENCE_TO_, outcome.getContentReference()));
                profileUtilities.replaceFromContentReference(outcome, tgt.getElement());
                if (tgt.getSource() != srcSD) {
                  base = tgt.getSource().getSnapshot();
                  int nbc = base.getElement().indexOf(tgt.getElement())+1;
                  int nbl = nbc;
                  while (nbl < base.getElement().size() && base.getElement().get(nbl).getPath().startsWith(tgt.getElement().getPath()+"."))
                    nbl++;
                  processPaths(indent+"  ", result, base, differential, nbc, start - 1, nbl-1, diffCursor - 1, url, webUrl, profileName, tgt.getElement().getPath(), diffMatches.get(0).getPath(), trimDifferential, contextName, resultPathBase, false, null, null, profileUtilities.redirectorStack(redirector, outcome, currentBasePath), tgt.getSource());
                } else {
                  int nbc = base.getElement().indexOf(tgt.getElement())+1;
                  int nbl = nbc;
                  while (nbl < base.getElement().size() && base.getElement().get(nbl).getPath().startsWith(tgt.getElement().getPath()+"."))
                    nbl++;
                  System.out.println("Test!");
                  processPaths(indent+"  ", result, base, differential, nbc, start, nbl-1, diffCursor-1, url, webUrl, profileName, tgt.getElement().getPath(), outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, profileUtilities.redirectorStack(redirector, outcome, currentBasePath), srcSD);
                }
              } else {
                StructureDefinition dt = outcome.getType().size() > 1 ? profileUtilities.getContext().fetchTypeDefinition("Element") : profileUtilities.getProfileForDataType(outcome.getType().get(0), webUrl);
                if (dt == null) {
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNKNOWN_TYPE__AT_, outcome.getType().get(0), currentBasePath));
                }
                contextName = dt.getUrl();
                if (redirector == null || redirector.isEmpty()) {
                  processPaths(indent+"  ", result, dt.getSnapshot(), differential, 1 /* starting again on the data type, but skip the root */, start, dt.getSnapshot().getElement().size()-1,
                    diffCursor-1, url, profileUtilities.getWebUrl(dt, webUrl, indent), profileName, currentBasePath, outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);
                } else {
                  processPaths(indent+"  ", result, dt.getSnapshot(), differential, 1 /* starting again on the data type, but skip the root */, start, dt.getSnapshot().getElement().size()-1,
                    diffCursor-1, url, profileUtilities.getWebUrl(dt, webUrl, indent), profileName, currentBasePath, outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, profileUtilities.redirectorStack(redirector, currentBase, currentBasePath), srcSD);
                }
              }
            }
          }
          baseCursor++;
        }
        // one matching element in the differential
        else if (oneMatchingElementInDifferential(slicingDone, currentBasePath, diffMatches)
        ) {
          ElementDefinition template = null;
          if (diffMatches.get(0).hasType() && "Reference".equals(diffMatches.get(0).getType().get(0).getWorkingCode()) && !profileUtilities.isValidType(diffMatches.get(0).getType().get(0), currentBase)) {
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.VALIDATION_VAL_ILLEGAL_TYPE_CONSTRAINT, url, diffMatches.get(0).getPath(), diffMatches.get(0).getType().get(0), currentBase.typeSummary()));
          }
          String id = diffMatches.get(0).getId();
          String lid = profileUtilities.tail(id);
          if (lid.contains("/")) {
            // the template comes from the snapshot of the base
            profileUtilities.generateIds(result.getElement(), url, srcSD.getType(), srcSD);
            String baseId = id.substring(0, id.length()-lid.length()) + lid.substring(0, lid.indexOf("/")); // this is wrong if there's more than one reslice (todo: one thing at a time)
            template = profileUtilities.getById(result.getElement(), baseId);

          } else if (diffMatches.get(0).hasType()
            && diffMatches.get(0).getType().size() == 1
            && diffMatches.get(0).getType().get(0).hasProfile()
            && !"Reference".equals(diffMatches.get(0).getType().get(0).getWorkingCode())) {
            CanonicalType firstTypeProfile = diffMatches.get(0).getType().get(0).getProfile().get(0);
            StructureDefinition firstTypeStructureDefinition = profileUtilities.getContext().fetchResource(StructureDefinition.class, firstTypeProfile.getValue());
            if (firstTypeStructureDefinition == null && profileUtilities.getXver() != null && profileUtilities.getXver().matchingUrl(firstTypeProfile.getValue())) {
              switch (profileUtilities.getXver().status(firstTypeProfile.getValue())) {
                case BadVersion: throw new FHIRException("Reference to invalid version in extension url "+firstTypeProfile.getValue());
                case Invalid: throw new FHIRException("Reference to invalid extension "+firstTypeProfile.getValue());
                case Unknown: throw new FHIRException("Reference to unknown extension "+firstTypeProfile.getValue());
                case Valid:
                  firstTypeStructureDefinition = profileUtilities.getXver().makeDefinition(firstTypeProfile.getValue());
                  profileUtilities.generateSnapshot(profileUtilities.getContext().fetchTypeDefinition("Extension"), firstTypeStructureDefinition, firstTypeStructureDefinition.getUrl(), webUrl, firstTypeStructureDefinition.getName());
              }
            }
            if (firstTypeStructureDefinition != null) {
              if (!profileUtilities.isMatchingType(firstTypeStructureDefinition, diffMatches.get(0).getType(), firstTypeProfile.getExtensionString(ToolingExtensions.EXT_PROFILE_ELEMENT))) {
                throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.VALIDATION_VAL_PROFILE_WRONGTYPE2, firstTypeStructureDefinition.getUrl(), diffMatches.get(0).getPath(), firstTypeStructureDefinition.getType(), firstTypeProfile.getValue(), diffMatches.get(0).getType().get(0).getWorkingCode()));
              }
              if (profileUtilities.isGenerating(firstTypeStructureDefinition)) {
                // this is a special case, because we're only going to access the first element, and we can rely on the fact that it's already populated.
                // but we check anyway
                if (firstTypeStructureDefinition.getSnapshot().getElementFirstRep().isEmpty()) {
                  throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ATTEMPT_TO_USE_A_SNAPSHOT_ON_PROFILE__AS__BEFORE_IT_IS_GENERATED, firstTypeStructureDefinition.getUrl(), "Source for first element"));
                }
              } else if (!firstTypeStructureDefinition.hasSnapshot()) {
                StructureDefinition sdb = profileUtilities.getContext().fetchResource(StructureDefinition.class, firstTypeStructureDefinition.getBaseDefinition());
                if (sdb == null)
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNABLE_TO_FIND_BASE__FOR_, firstTypeStructureDefinition.getBaseDefinition(), firstTypeStructureDefinition.getUrl()));
                profileUtilities.checkNotGenerating(sdb, "an extension base");
                profileUtilities.generateSnapshot(sdb, firstTypeStructureDefinition, firstTypeStructureDefinition.getUrl(), (sdb.hasUserData("path")) ? Utilities.extractBaseUrl(sdb.getUserString("path")) : webUrl, firstTypeStructureDefinition.getName());
              }
              ElementDefinition src;
              if (firstTypeProfile.hasExtension(ToolingExtensions.EXT_PROFILE_ELEMENT)) {
                src = null;
                String eid = firstTypeProfile.getExtensionString(ToolingExtensions.EXT_PROFILE_ELEMENT);
                for (ElementDefinition t : firstTypeStructureDefinition.getSnapshot().getElement()) {
                  if (eid.equals(t.getId()))
                    src = t;
                }
                if (src == null)
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNABLE_TO_FIND_ELEMENT__IN_, eid, firstTypeProfile.getValue()));
              } else
                src = firstTypeStructureDefinition.getSnapshot().getElement().get(0);
              template = src.copy().setPath(currentBase.getPath());
              template.setSliceName(null);
              // temporary work around
              if (!"Extension".equals(diffMatches.get(0).getType().get(0).getCode())) {
                template.setMin(currentBase.getMin());
                template.setMax(currentBase.getMax());
              }
            }
          }
          if (template == null)
            template = currentBase.copy();
          else
            // some of what's in currentBase overrides template
            template = profileUtilities.fillOutFromBase(template, currentBase);

          ElementDefinition outcome = profileUtilities.updateURLs(url, webUrl, template);
          outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
          if (res == null)
            res = outcome;
          profileUtilities.updateFromBase(outcome, currentBase, srcSD.getUrl());
          if (diffMatches.get(0).hasSliceName()) {
            outcome.setSliceName(diffMatches.get(0).getSliceName());
            if (!diffMatches.get(0).hasMin() && (diffMatches.size() > 1 || slicer == null || slicer.getSlicing().getRules() != ElementDefinition.SlicingRules.CLOSED)  && !currentBase.hasSliceName()) {
              if (!currentBasePath.endsWith("xtension.value[x]")) { // hack work around for problems with snapshots in official releases
                outcome.setMin(0);
              }
            }
          }
          profileUtilities.updateFromDefinition(outcome, diffMatches.get(0), profileName, trimDifferential, url, srcSD);
          profileUtilities.removeStatusExtensions(outcome);
//          if (outcome.getPath().endsWith("[x]") && outcome.getType().size() == 1 && !outcome.getType().get(0).getCode().equals("*") && !diffMatches.get(0).hasSlicing()) // if the base profile allows multiple types, but the profile only allows one, rename it
//            outcome.setPath(outcome.getPath().substring(0, outcome.getPath().length()-3)+Utilities.capitalize(outcome.getType().get(0).getCode()));
          outcome.setSlicing(null);
          if (resultPathBase == null)
            resultPathBase = outcome.getPath();
          else if (!outcome.getPath().startsWith(resultPathBase))
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
          result.getElement().add(outcome);
          baseCursor++;
          diffCursor = differential.getElement().indexOf(diffMatches.get(0))+1;
          if (diffLimit >= diffCursor && outcome.getPath().contains(".") && (profileUtilities.isDataType(outcome.getType()) || profileUtilities.isBaseResource(outcome.getType()) || outcome.hasContentReference())) {  // don't want to do this for the root, since that's base, and we're already processing it
            if (profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), diffMatches.get(0).getPath()+".") && !profileUtilities.baseWalksInto(base.getElement(), baseCursor)) {
              if (outcome.getType().size() > 1) {
                if (outcome.getPath().endsWith("[x]") && !diffMatches.get(0).getPath().endsWith("[x]")) {
                  String en = profileUtilities.tail(outcome.getPath());
                  String tn = profileUtilities.tail(diffMatches.get(0).getPath());
                  String t = tn.substring(en.length()-3);
                  if (profileUtilities.isPrimitive(Utilities.uncapitalize(t)))
                    t = Utilities.uncapitalize(t);
                  List<ElementDefinition.TypeRefComponent> ntr = profileUtilities.getByTypeName(outcome.getType(), t); // keep any additional information
                  if (ntr.isEmpty())
                    ntr.add(new ElementDefinition.TypeRefComponent().setCode(t));
                  outcome.getType().clear();
                  outcome.getType().addAll(ntr);
                }
                if (outcome.getType().size() > 1)
                  for (ElementDefinition.TypeRefComponent t : outcome.getType()) {
                    if (!t.getCode().equals("Reference")) {
                      boolean nonExtension = false;
                      for (ElementDefinition ed : diffMatches)
                        if (ed != diffMatches.get(0) && !ed.getPath().endsWith(".extension"))
                          nonExtension = true;
                      if (nonExtension)
                        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__AND_MULTIPLE_TYPES__IN_PROFILE_, diffMatches.get(0).getPath(), differential.getElement().get(diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), profileName));
                    }
                  }
              }
              int start = diffCursor;
              while (diffCursor <= diffLimit && differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), diffMatches.get(0).getPath()+"."))
                diffCursor++;
              if (outcome.hasContentReference()) {
                ProfileUtilities.ElementDefinitionResolution tgt = profileUtilities.getElementById(srcSD, base.getElement(), outcome.getContentReference());
                if (tgt == null)
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNABLE_TO_RESOLVE_REFERENCE_TO_, outcome.getContentReference()));
                profileUtilities.replaceFromContentReference(outcome, tgt.getElement());
                if (tgt.getSource() != srcSD) {
                  base = tgt.getSource().getSnapshot();
                  int nbc = base.getElement().indexOf(tgt.getElement())+1;
                  int nbl = nbc;
                  while (nbl < base.getElement().size() && base.getElement().get(nbl).getPath().startsWith(tgt.getElement().getPath()+"."))
                    nbl++;
                  processPaths(indent+"  ", result, base, differential, nbc, start - 1, nbl-1, diffCursor - 1, url, webUrl, profileName, tgt.getElement().getPath(), diffMatches.get(0).getPath(), trimDifferential, contextName, resultPathBase, false, null, null, profileUtilities.redirectorStack(redirector, outcome, currentBasePath), tgt.getSource());
                } else {
                  int nbc = base.getElement().indexOf(tgt.getElement())+1;
                  int nbl = nbc;
                  while (nbl < base.getElement().size() && base.getElement().get(nbl).getPath().startsWith(tgt.getElement().getPath()+"."))
                    nbl++;
                  processPaths(indent+"  ", result, base, differential, nbc, start - 1, nbl-1, diffCursor - 1, url, webUrl, profileName, tgt.getElement().getPath(), diffMatches.get(0).getPath(), trimDifferential, contextName, resultPathBase, false, null, null, profileUtilities.redirectorStack(redirector, outcome, currentBasePath), srcSD);
                }
              } else {
                StructureDefinition dt = outcome.getType().size() == 1 ? profileUtilities.getProfileForDataType(outcome.getType().get(0), webUrl) : profileUtilities.getProfileForDataType("Element");
                if (dt == null)
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__FOR_TYPE__IN_PROFILE__BUT_CANT_FIND_TYPE, diffMatches.isEmpty() ?  "??" : diffMatches.get(0).getPath(), differential.getElement().get(diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), profileName));
                contextName = dt.getUrl();
                processPaths(indent+"  ", result, dt.getSnapshot(), differential, 1 /* starting again on the data type, but skip the root */, start, dt.getSnapshot().getElement().size()-1,
                  diffCursor - 1, url, profileUtilities.getWebUrl(dt, webUrl, indent), profileName+profileUtilities.pathTail(diffMatches, 0), diffMatches.get(0).getPath(), outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, new ArrayList<ElementRedirection>(), srcSD);
              }
            }
          }
        }
        else if (profileUtilities.diffsConstrainTypes(diffMatches, currentBasePath, typeList)) {
          int start = 0;
          int nbl = profileUtilities.findEndOfElement(base, baseCursor);
          int ndc = differential.getElement().indexOf(diffMatches.get(0));
          ElementDefinition elementToRemove = null;
          boolean shortCut = !typeList.isEmpty() && typeList.get(0).getType() != null;
          // we come here whether they are sliced in the diff, or whether the short cut is used.
          if (shortCut) {
            // this is the short cut method, we've just dived in and specified a type slice.
            // in R3 (and unpatched R4, as a workaround right now...
            if (!VersionUtilities.isR4Plus(profileUtilities.getContext().getVersion()) || !profileUtilities.isNewSlicingProcessing()) { // newSlicingProcessing is a work around for editorial loop dependency
              // we insert a cloned element with the right types at the start of the diffMatches
              ElementDefinition ed = new ElementDefinition();
              ed.setPath(profileUtilities.determineTypeSlicePath(diffMatches.get(0).getPath(), currentBasePath));
              for (TypeSlice ts : typeList)
                ed.addType().setCode(ts.getType());
              ed.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
              ed.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
              ed.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED);
              ed.getSlicing().setOrdered(false);
              diffMatches.add(0, ed);
              differential.getElement().add(ndc, ed);
              elementToRemove = ed;
            } else {
              // as of R4, this changed; if there's no slice, there's no constraint on the slice types, only one the type.
              // so the element we insert specifies no types (= all types) allowed in the base, not just the listed type.
              // see also discussion here: https://chat.fhir.org/#narrow/stream/179177-conformance/topic/Slicing.20a.20non-repeating.20element
              ElementDefinition ed = new ElementDefinition();
              ed.setPath(profileUtilities.determineTypeSlicePath(diffMatches.get(0).getPath(), currentBasePath));
              ed.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
              ed.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
              ed.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED);
              ed.getSlicing().setOrdered(false);
              diffMatches.add(0, ed);
              differential.getElement().add(ndc, ed);
              elementToRemove = ed;
            }
          }
          int ndl = profileUtilities.findEndOfElement(differential, ndc);
          // the first element is setting up the slicing

          if (diffMatches.get(0).getSlicing().hasOrdered()) {
            if (diffMatches.get(0).getSlicing().getOrdered()) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGORDERED__TRUE, currentBasePath, url));
            }
          }
          if (diffMatches.get(0).getSlicing().hasDiscriminator()) {
            if (diffMatches.get(0).getSlicing().getDiscriminator().size() != 1) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORCOUNT__1, currentBasePath, url));
            }
            if (diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getType() != ElementDefinition.DiscriminatorType.TYPE) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORTYPE__TYPE, currentBasePath, url));
            }
            if (!"$this".equals(diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getPath())) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORPATH__THIS, currentBasePath, url));
            }
          }
          // check the slice names too while we're at it...
          for (TypeSlice ts : typeList) {
            if (ts.getType() != null) {
              String tn = profileUtilities.rootName(currentBasePath)+Utilities.capitalize(ts.getType());
              if (!ts.defn.hasSliceName()) {
                ts.defn.setSliceName(tn);
              } else if (!ts.defn.getSliceName().equals(tn)) {
                if (profileUtilities.isAutoFixSliceNames()) {
                  ts.defn.setSliceName(tn);
                } else {
                  throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_NAME_MUST_BE__BUT_IS_, (!Utilities.noString(contextPathSrc) ? contextPathSrc : currentBasePath), tn, ts.defn.getSliceName()));
                }
              } if (!ts.defn.hasType()) {
                ts.defn.addType().setCode(ts.type);
              } else if (ts.defn.getType().size() > 1) {
                throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_MORE_THAN_ONE_TYPE_, (!Utilities.noString(contextPathSrc) ? contextPathSrc : currentBasePath), tn, ts.defn.typeSummary()));
              } else if (!ts.defn.getType().get(0).getCode().equals(ts.type)) {
                throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_WRONG_TYPE_, (!Utilities.noString(contextPathSrc) ? contextPathSrc : currentBasePath), tn, ts.defn.typeSummary()));
              }
            }
          }

          // ok passed the checks.
          // copy the root diff, and then process any children it has
          ElementDefinition e = processPaths(indent+"  ", result, base, differential, baseCursor, ndc, nbl, ndl, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, 0), contextPathSrc, contextPathDst,
            trimDifferential, contextName, resultPathBase, true, null, null, redirector, srcSD);
          if (e==null)
            throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.DID_NOT_FIND_TYPE_ROOT_, diffMatches.get(0).getPath()));
          // now set up slicing on the e (cause it was wiped by what we called.
          e.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
          e.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
          e.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED); // type slicing is always closed; the differential might call it open, but that just means it's not constraining the slices it doesn't mention
          e.getSlicing().setOrdered(false);

          start++;

          String fixedType = null;
          // now process the siblings, which should each be type constrained - and may also have their own children
          // now we process the base scope repeatedly for each instance of the item in the differential list
          for (int i = start; i < diffMatches.size(); i++) {
            // our processing scope for the differential is the item in the list, and all the items before the next one in the list
            if (diffMatches.get(i).getMin() > 0) {
              if (diffMatches.size() > i+1) {
                throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.INVALID_SLICING__THERE_IS_MORE_THAN_ONE_TYPE_SLICE_AT__BUT_ONE_OF_THEM__HAS_MIN__1_SO_THE_OTHER_SLICES_CANNOT_EXIST, diffMatches.get(i).getPath(), diffMatches.get(i).getSliceName()));
              } else {
                e.setMin(1);
              }
              fixedType = profileUtilities.determineFixedType(diffMatches, fixedType, i);
            }
            ndc = differential.getElement().indexOf(diffMatches.get(i));
            ndl = profileUtilities.findEndOfElement(differential, ndc);
            ElementDefinition typeSliceElement = processPaths(indent+"  ", result, base, differential, baseCursor, ndc, nbl, ndl, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, i), contextPathSrc, contextPathDst, trimDifferential, contextName, resultPathBase, true, e, null, redirector, srcSD);
            if (typeList.size() > start+1) {
              typeSliceElement.setMin(0);
            }
          }
          if (elementToRemove != null) {
            differential.getElement().remove(elementToRemove);
            ndl--;
          }
          if (fixedType != null) {
            for (Iterator<ElementDefinition.TypeRefComponent> iter = e.getType().iterator(); iter.hasNext(); ) {
              ElementDefinition.TypeRefComponent tr = iter.next();
              if (!tr.getCode().equals(fixedType)) {
                iter.remove();
              }
            }
          }
          if (!"0".equals(e.getMax())) {
            // check that there's a slice for each allowed types
            Set<String> allowedTypes = profileUtilities.getListOfTypes(e);
            for (TypeSlice t : typeList) {
              if (t.type != null) {
                allowedTypes.remove(t.type);
              } else if (t.getDefn().hasSliceName() && t.getDefn().getType().size() == 1) {
                allowedTypes.remove(t.getDefn().getType().get(0).getCode());
              }
            }
            if (!allowedTypes.isEmpty()) {
              if (currentBasePath.contains("xtension.value")) {
                for (Iterator<ElementDefinition.TypeRefComponent> iter = e.getType().iterator(); iter.hasNext(); ) {
                  ElementDefinition.TypeRefComponent tr = iter.next();
                  if (allowedTypes.contains(tr.getCode())) {
                    iter.remove();
                  }
                }
//                System.out.println("!!: Extension Error at "+cpath+": Allowed Types not sliced = "+allowedTypes+". !Extension!!");
//                throw new Error("Extension Error at "+cpath+": Allowed Types not sliced = "+allowedTypes+". !Extension!!");

              } else {
                e.getSlicing().setRules(ElementDefinition.SlicingRules.OPEN);
              }
            }
          }
          // ok, done with that - next in the base list
          baseCursor = nbl+1;
          diffCursor = ndl+1;

        }
        else {
          // ok, the differential slices the item. Let's check our pre-conditions to ensure that this is correct
          if (!profileUtilities.unbounded(currentBase) && !profileUtilities.isSlicedToOneOnly(diffMatches.get(0)))
            // you can only slice an element that doesn't repeat if the sum total of your slices is limited to 1
            // (but you might do that in order to split up constraints by type)
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ATTEMPT_TO_A_SLICE_AN_ELEMENT_THAT_DOES_NOT_REPEAT__FROM__IN_, currentBase.getPath(), currentBase.getPath(), contextName, url, diffMatches.get(0).getId(), profileUtilities.sliceNames(diffMatches)));
          if (!diffMatches.get(0).hasSlicing() && !profileUtilities.isExtension(currentBase)) // well, the diff has set up a slice, but hasn't defined it. this is an error
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.DIFFERENTIAL_DOES_NOT_HAVE_A_SLICE__B_OF_____IN_PROFILE_, currentBase.getPath(), baseCursor, baseLimit, diffCursor, diffLimit, url, currentBasePath));

          // well, if it passed those preconditions then we slice the dest.
          int start = 0;
          int nbl = profileUtilities.findEndOfElement(base, baseCursor);
//          if (diffMatches.size() > 1 && diffMatches.get(0).hasSlicing() && differential.getElement().indexOf(diffMatches.get(1)) > differential.getElement().indexOf(diffMatches.get(0))+1) {
          ElementDefinition slicerElement;
          if (diffMatches.size() > 1 && diffMatches.get(0).hasSlicing() && (nbl > baseCursor || differential.getElement().indexOf(diffMatches.get(1)) > differential.getElement().indexOf(diffMatches.get(0))+1)) { // there's a default set before the slices
            int ndc = differential.getElement().indexOf(diffMatches.get(0));
            int ndl = profileUtilities.findEndOfElement(differential, ndc);
            ElementDefinition e = processPaths(indent+"  ", result, base, differential, baseCursor, ndc, nbl, ndl, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, 0), contextPathSrc, contextPathDst,
              trimDifferential, contextName, resultPathBase, true, null, null, redirector, srcSD);
            if (e==null)
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.DID_NOT_FIND_SINGLE_SLICE_, diffMatches.get(0).getPath()));
            e.setSlicing(diffMatches.get(0).getSlicing());
            slicerElement = e;
            start++;
          } else {
            // we're just going to accept the differential slicing at face value
            ElementDefinition outcome = profileUtilities.updateURLs(url, webUrl, currentBase.copy());
            outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
            profileUtilities.updateFromBase(outcome, currentBase, srcSD.getUrl());

            if (!diffMatches.get(0).hasSlicing())
              outcome.setSlicing(profileUtilities.makeExtensionSlicing());
            else
              outcome.setSlicing(diffMatches.get(0).getSlicing().copy());
            if (!outcome.getPath().startsWith(resultPathBase))
              throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
            result.getElement().add(outcome);
            slicerElement = outcome;

            // differential - if the first one in the list has a name, we'll process it. Else we'll treat it as the base definition of the slice.
            if (!diffMatches.get(0).hasSliceName()) {
              profileUtilities.updateFromDefinition(outcome, diffMatches.get(0), profileName, trimDifferential, url, srcSD);
              profileUtilities.removeStatusExtensions(outcome);
              if (!outcome.hasContentReference() && !outcome.hasType()) {
                throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.NOT_DONE_YET));
              }
              if (profileUtilities.hasInnerDiffMatches(differential, currentBasePath, diffCursor, diffLimit, base.getElement(), false)) {
                if (profileUtilities.baseHasChildren(base, currentBase)) { // not a new type here
                  throw new Error("This situation is not yet handled (constrain slicing to 1..1 and fix base slice for inline structure - please report issue to grahame@fhir.org along with a test case that reproduces this error (@ "+currentBasePath+" | "+currentBase.getPath()+")");
                } else {
                  StructureDefinition dt = profileUtilities.getTypeForElement(differential, diffCursor, profileName, diffMatches, outcome, webUrl);
                  contextName = dt.getUrl();
                  diffCursor++;
                  start = diffCursor;
                  while (differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), currentBasePath+"."))
                    diffCursor++;
                  diffCursor--;
                  processPaths(indent+"  ", result, dt.getSnapshot(), differential, 1 /* starting again on the data type, but skip the root */, start, dt.getSnapshot().getElement().size()-1,
                    diffCursor, url, profileUtilities.getWebUrl(dt, webUrl, indent), profileName, currentBasePath, outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);
                }
              }
              start++;
              // result.getElement().remove(result.getElement().size()-1);
            } else
              profileUtilities.checkExtensionDoco(outcome);
          }
          // now, for each entry in the diff matches, we're going to process the base item
          // our processing scope for base is all the children of the current path
          int ndc = diffCursor;
          int ndl = diffCursor;
          for (int i = start; i < diffMatches.size(); i++) {
            // our processing scope for the differential is the item in the list, and all the items before the next one in the list
            ndc = differential.getElement().indexOf(diffMatches.get(i));
            ndl = profileUtilities.findEndOfElement(differential, ndc);
/*            if (skipSlicingElement && i == 0) {
              ndc = ndc + 1;
              if (ndc > ndl)
                continue;
            }*/
            // now we process the base scope repeatedly for each instance of the item in the differential list
            processPaths(indent+"  ", result, base, differential, baseCursor, ndc, nbl, ndl, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, i), contextPathSrc, contextPathDst, trimDifferential, contextName, resultPathBase, true, slicerElement, null, redirector, srcSD);
          }
          // ok, done with that - next in the base list
          baseCursor = nbl+1;
          diffCursor = ndl+1;
        }
      } else {
        // the item is already sliced in the base profile.
        // here's the rules
        //  1. irrespective of whether the slicing is ordered or not, the definition order must be maintained
        //  2. slice element names have to match.
        //  3. new slices must be introduced at the end
        // corallory: you can't re-slice existing slices. is that ok?

        // we're going to need this:
        String path = currentBase.getPath();
        ElementDefinition original = currentBase;

        if (diffMatches.isEmpty()) {
          if (profileUtilities.hasInnerDiffMatches(differential, path, diffCursor, diffLimit, base.getElement(), true)) {
            // so we just copy it in
            ElementDefinition outcome = profileUtilities.updateURLs(url, webUrl, currentBase.copy());
            outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
            profileUtilities.updateFromBase(outcome, currentBase, srcSD.getUrl());
            profileUtilities.markDerived(outcome);
            if (resultPathBase == null)
              resultPathBase = outcome.getPath();
            else if (!outcome.getPath().startsWith(resultPathBase))
              throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
            result.getElement().add(outcome);
            // the profile walks into this, so we need to as well
            // did we implicitly step into a new type?
            if (profileUtilities.baseHasChildren(base, currentBase)) { // not a new type here
              processPaths(indent+"  ", result, base, differential, baseCursor+1, diffCursor, baseLimit, diffLimit, url, webUrl, profileName, contextPathSrc, contextPathDst, trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);
              baseCursor = profileUtilities.indexOfFirstNonChild(base, currentBase, baseCursor, baseLimit);
            } else {
              StructureDefinition dt = profileUtilities.getTypeForElement(differential, diffCursor, profileName, diffMatches, outcome, webUrl);
              contextName = dt.getUrl();
              int start = diffCursor;
              if (differential.getElement().get(diffCursor).getPath().equals(currentBasePath)) {
                diffCursor++;
              }
              while (differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), currentBasePath+".")) {
                diffCursor++;
              }
              if (diffCursor > start) {
                processPaths(indent+"  ", result, dt.getSnapshot(), differential, 1 /* starting again on the data type, but skip the root */, start, dt.getSnapshot().getElement().size()-1,
                  diffCursor-1, url, profileUtilities.getWebUrl(dt, webUrl, indent), profileName, currentBasePath, outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);
              }
            }
            baseCursor++;
          } else {
            // the differential doesn't say anything about this item
            // copy across the currentbase, and all of its children and siblings
            while (baseCursor < base.getElement().size() && base.getElement().get(baseCursor).getPath().startsWith(path)) {
              ElementDefinition outcome = profileUtilities.updateURLs(url, webUrl, base.getElement().get(baseCursor).copy());
              outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
              if (!outcome.getPath().startsWith(resultPathBase))
                throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH_IN_PROFILE___VS_, profileName, outcome.getPath(), resultPathBase));
              result.getElement().add(outcome); // so we just copy it in
              outcome.setUserData(profileUtilities.BASE_MODEL, srcSD.getUrl());
              outcome.setUserData(profileUtilities.BASE_PATH, resultPathBase);
              baseCursor++;
            }
          }
        } else if (profileUtilities.diffsConstrainTypes(diffMatches, currentBasePath, typeList)) {
          int start = 0;
          int nbl = profileUtilities.findEndOfElement(base, baseCursor);
          int ndc = differential.getElement().indexOf(diffMatches.get(0));
          ElementDefinition elementToRemove = null;
          boolean shortCut = (!typeList.isEmpty() && typeList.get(0).type != null) || (diffMatches.get(0).hasSliceName() && !diffMatches.get(0).hasSlicing());
          // we come here whether they are sliced in the diff, or whether the short cut is used.
          if (shortCut) {
            // this is the short cut method, we've just dived in and specified a type slice.
            // in R3 (and unpatched R4, as a workaround right now...
            if (!VersionUtilities.isR4Plus(profileUtilities.getContext().getVersion()) || !profileUtilities.isNewSlicingProcessing()) { // newSlicingProcessing is a work around for editorial loop dependency
              // we insert a cloned element with the right types at the start of the diffMatches
              ElementDefinition ed = new ElementDefinition();
              ed.setPath(profileUtilities.determineTypeSlicePath(diffMatches.get(0).getPath(), currentBasePath));
              for (TypeSlice ts : typeList)
                ed.addType().setCode(ts.type);
              ed.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
              ed.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
              ed.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED);
              ed.getSlicing().setOrdered(false);
              diffMatches.add(0, ed);
              differential.getElement().add(ndc, ed);
              elementToRemove = ed;
            } else {
              // as of R4, this changed; if there's no slice, there's no constraint on the slice types, only one the type.
              // so the element we insert specifies no types (= all types) allowed in the base, not just the listed type.
              // see also discussion here: https://chat.fhir.org/#narrow/stream/179177-conformance/topic/Slicing.20a.20non-repeating.20element
              ElementDefinition ed = new ElementDefinition();
              ed.setPath(profileUtilities.determineTypeSlicePath(diffMatches.get(0).getPath(), currentBasePath));
              ed.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
              ed.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
              ed.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED);
              ed.getSlicing().setOrdered(false);
              diffMatches.add(0, ed);
              differential.getElement().add(ndc, ed);
              elementToRemove = ed;
            }
          }
          int ndl = profileUtilities.findEndOfElement(differential, ndc);
          // the first element is setting up the slicing

          if (diffMatches.get(0).getSlicing().hasOrdered()) {
            if (diffMatches.get(0).getSlicing().getOrdered()) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGORDERED__TRUE, currentBasePath, url));
            }
          }
          if (diffMatches.get(0).getSlicing().hasDiscriminator()) {
            if (diffMatches.get(0).getSlicing().getDiscriminator().size() != 1) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORCOUNT__1, currentBasePath, url));
            }
            if (diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getType() != ElementDefinition.DiscriminatorType.TYPE) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORTYPE__TYPE, currentBasePath, url));
            }
            if (!"$this".equals(diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getPath())) {
              throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORPATH__THIS, currentBasePath, url));
            }
          }
          // check the slice names too while we're at it...
          for (TypeSlice ts : typeList) {
            if (ts.type != null) {
              String tn = profileUtilities.rootName(currentBasePath)+Utilities.capitalize(ts.type);
              if (!ts.defn.hasSliceName()) {
                ts.defn.setSliceName(tn);
              } else if (!ts.defn.getSliceName().equals(tn)) {
                throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_NAME_MUST_BE__BUT_IS_, (!Utilities.noString(contextPathSrc) ? contextPathSrc : currentBasePath), tn, ts.defn.getSliceName()));
              } if (!ts.defn.hasType()) {
                ts.defn.addType().setCode(ts.type);
              } else if (ts.defn.getType().size() > 1) {
                throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_MORE_THAN_ONE_TYPE_, (!Utilities.noString(contextPathSrc) ? contextPathSrc : currentBasePath), tn, ts.defn.typeSummary()));
              } else if (!ts.defn.getType().get(0).getCode().equals(ts.type)) {
                throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_WRONG_TYPE_, (!Utilities.noString(contextPathSrc) ? contextPathSrc : currentBasePath), tn, ts.defn.typeSummary()));
              }
            }
          }

          // ok passed the checks.
          // copy the root diff, and then process any children it has
          ElementDefinition e = processPaths(indent+"  ", result, base, differential, baseCursor, ndc, nbl, ndl, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, 0), contextPathSrc, contextPathDst,
            trimDifferential, contextName, resultPathBase, true, null, currentBasePath, redirector, srcSD);
          if (e==null)
            throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.DID_NOT_FIND_TYPE_ROOT_, diffMatches.get(0).getPath()));
          // now set up slicing on the e (cause it was wiped by what we called.
          e.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
          e.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
          e.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED); // type slicing is always closed; the differential might call it open, but that just means it's not constraining the slices it doesn't mention
          e.getSlicing().setOrdered(false);
          start++;

          String fixedType = null;
          List<BaseTypeSlice> baseSlices = profileUtilities.findBaseSlices(base, nbl);
          // now process the siblings, which should each be type constrained - and may also have their own children. they may match existing slices
          // now we process the base scope repeatedly for each instance of the item in the differential list
          for (int i = start; i < diffMatches.size(); i++) {
            String type = profileUtilities.determineFixedType(diffMatches, fixedType, i);
            // our processing scope for the differential is the item in the list, and all the items before the next one in the list
            if (diffMatches.get(i).getMin() > 0) {
              if (diffMatches.size() > i+1) {
                throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.INVALID_SLICING__THERE_IS_MORE_THAN_ONE_TYPE_SLICE_AT__BUT_ONE_OF_THEM__HAS_MIN__1_SO_THE_OTHER_SLICES_CANNOT_EXIST, diffMatches.get(i).getPath(), diffMatches.get(i).getSliceName()));
              }
              fixedType = type;
            }
            ndc = differential.getElement().indexOf(diffMatches.get(i));
            ndl = profileUtilities.findEndOfElement(differential, ndc);
            int sStart = baseCursor;
            int sEnd = nbl;
            BaseTypeSlice bs = profileUtilities.chooseMatchingBaseSlice(baseSlices, type);
            if (bs != null) {
              sStart = bs.getStart();
              sEnd = bs.getEnd();
              bs.setHandled(true);
            }
            processPaths(indent+"  ", result, base, differential, sStart, ndc, sEnd, ndl, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, i), contextPathSrc, contextPathDst, trimDifferential, contextName, resultPathBase, true, e, currentBasePath, redirector, srcSD);
          }
          if (elementToRemove != null) {
            differential.getElement().remove(elementToRemove);
            ndl--;
          }
          if (fixedType != null) {
            for (Iterator<ElementDefinition.TypeRefComponent> iter = e.getType().iterator(); iter.hasNext(); ) {
              ElementDefinition.TypeRefComponent tr = iter.next();
              if (!tr.getCode().equals(fixedType)) {
                iter.remove();
              }
            }
          }
          for (BaseTypeSlice bs : baseSlices) {
            if (!bs.isHandled()) {
              // ok we gimme up a fake differential that says nothing, and run that against the slice.
              StructureDefinition.StructureDefinitionDifferentialComponent fakeDiff = new StructureDefinition.StructureDefinitionDifferentialComponent();
              fakeDiff.getElementFirstRep().setPath(bs.getDefn().getPath());
              processPaths(indent+"  ", result, base, fakeDiff, bs.getStart(), 0, bs.getEnd(), 0, url, webUrl, profileName+profileUtilities.tail(bs.getDefn().getPath()), contextPathSrc, contextPathDst, trimDifferential, contextName, resultPathBase, true, e, currentBasePath, redirector, srcSD);

            }
          }
          // ok, done with that - next in the base list
          baseCursor = baseSlices.get(baseSlices.size() - 1).getEnd() +1;
          diffCursor = ndl+1;
          //throw new Error("not done yet - slicing / types @ "+cpath);
        } else {
          // first - check that the slicing is ok
          boolean closed = currentBase.getSlicing().getRules() == ElementDefinition.SlicingRules.CLOSED;
          int diffpos = 0;
          boolean isExtension = currentBasePath.endsWith(".extension") || currentBasePath.endsWith(".modifierExtension");
          if (diffMatches.get(0).hasSlicing()) { // it might be null if the differential doesn't want to say anything about slicing
//            if (!isExtension)
//              diffpos++; // if there's a slice on the first, we'll ignore any content it has
            ElementDefinition.ElementDefinitionSlicingComponent dSlice = diffMatches.get(0).getSlicing();
            ElementDefinition.ElementDefinitionSlicingComponent bSlice = currentBase.getSlicing();
            if (dSlice.hasOrderedElement() && bSlice.hasOrderedElement() && !profileUtilities.orderMatches(dSlice.getOrderedElement(), bSlice.getOrderedElement()))
              throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.SLICING_RULES_ON_DIFFERENTIAL__DO_NOT_MATCH_THOSE_ON_BASE___ORDER___, profileUtilities.summarizeSlicing(dSlice), profileUtilities.summarizeSlicing(bSlice), path, contextName));
            if (!profileUtilities.discriminatorMatches(dSlice.getDiscriminator(), bSlice.getDiscriminator()))
              throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.SLICING_RULES_ON_DIFFERENTIAL__DO_NOT_MATCH_THOSE_ON_BASE___DISCIMINATOR___, profileUtilities.summarizeSlicing(dSlice), profileUtilities.summarizeSlicing(bSlice), path, contextName));
            if (!currentBase.isChoice() && !profileUtilities.ruleMatches(dSlice.getRules(), bSlice.getRules()))
              throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.SLICING_RULES_ON_DIFFERENTIAL__DO_NOT_MATCH_THOSE_ON_BASE___RULE___, profileUtilities.summarizeSlicing(dSlice), profileUtilities.summarizeSlicing(bSlice), path, contextName));
          }
          ElementDefinition outcome = profileUtilities.updateURLs(url, webUrl, currentBase.copy());
          outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
          profileUtilities.updateFromBase(outcome, currentBase, srcSD.getUrl());
          if (diffMatches.get(0).hasSlicing() || !diffMatches.get(0).hasSliceName()) {
            profileUtilities.updateFromSlicing(outcome.getSlicing(), diffMatches.get(0).getSlicing());
            profileUtilities.updateFromDefinition(outcome, diffMatches.get(0), profileName, closed, url, srcSD); // if there's no slice, we don't want to update the unsliced description
            profileUtilities.removeStatusExtensions(outcome);
          } else if (!diffMatches.get(0).hasSliceName()) {
            diffMatches.get(0).setUserData(profileUtilities.GENERATED_IN_SNAPSHOT, outcome); // because of updateFromDefinition isn't called
          }

          result.getElement().add(outcome);

          if (!diffMatches.get(0).hasSliceName()) { // it's not real content, just the slice
            diffpos++;
          }
          if (profileUtilities.hasInnerDiffMatches(differential, currentBasePath, diffCursor, diffLimit, base.getElement(), false)) {
            int nbl = profileUtilities.findEndOfElement(base, baseCursor);
            int ndx = differential.getElement().indexOf(diffMatches.get(0));
            int ndc = ndx+(diffMatches.get(0).hasSlicing() ? 1 : 0);
            int ndl = profileUtilities.findEndOfElement(differential, ndx);
            if (nbl == baseCursor) {
              if (base.getElement().get(baseCursor).getType().size() != 1) {
                throw new Error(profileUtilities.getContext().formatMessage(I18nConstants.DIFFERENTIAL_WALKS_INTO____BUT_THE_BASE_DOES_NOT_AND_THERE_IS_NOT_A_SINGLE_FIXED_TYPE_THE_TYPE_IS__THIS_IS_NOT_HANDLED_YET, currentBasePath, diffMatches.get(0).toString(), base.getElement().get(baseCursor).typeSummary()));
              }
              StructureDefinition dt = profileUtilities.getProfileForDataType(base.getElement().get(baseCursor).getType().get(0), webUrl);
              if (dt == null) {
                throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNKNOWN_TYPE__AT_, outcome.getType().get(0), diffMatches.get(0).getPath()));
              }
              contextName = dt.getUrl();
              while (differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), currentBasePath+"."))
                diffCursor++;
              processPaths(indent+"  ", result, dt.getSnapshot(), differential, 1, ndc, dt.getSnapshot().getElement().size()-1, ndl,
                url, profileUtilities.getWebUrl(dt, webUrl, indent), profileName, currentBasePath, outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);
            } else {
              processPaths(indent+"  ", result, base, differential, baseCursor+1, ndc, nbl, ndl,
                url, webUrl, profileName+profileUtilities.pathTail(diffMatches, 0), contextPathSrc, contextPathDst, trimDifferential, contextName, resultPathBase, false, null, null, null, srcSD);
            }
//            throw new Error("Not done yet");
//          } else if (currentBase.getType().get(0).getCode().equals("BackboneElement") && diffMatches.size() > 0 && diffMatches.get(0).hasSliceName()) {
          } else if (currentBase.getType().get(0).getCode().equals("BackboneElement")) {
            // We need to copy children of the backbone element before we start messing around with slices
            int nbl = profileUtilities.findEndOfElement(base, baseCursor);
            for (int i = baseCursor+1; i<=nbl; i++) {
              outcome = profileUtilities.updateURLs(url, webUrl, base.getElement().get(i).copy());
              result.getElement().add(outcome);
            }
          }

          // now, we have two lists, base and diff. we're going to work through base, looking for matches in diff.
          List<ElementDefinition> baseMatches = profileUtilities.getSiblings(base.getElement(), currentBase);
          for (ElementDefinition baseItem : baseMatches) {
            baseCursor = base.getElement().indexOf(baseItem);
            outcome = profileUtilities.updateURLs(url, webUrl, baseItem.copy());
            profileUtilities.updateFromBase(outcome, currentBase, srcSD.getUrl());
            outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
            outcome.setSlicing(null);
            if (!outcome.getPath().startsWith(resultPathBase))
              throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
            if (diffpos < diffMatches.size() && diffMatches.get(diffpos).hasSliceName() && diffMatches.get(diffpos).getSliceName().equals(outcome.getSliceName())) {
              // if there's a diff, we update the outcome with diff
              // no? updateFromDefinition(outcome, diffMatches.get(diffpos), profileName, closed, url);
              //then process any children
              int nbl = profileUtilities.findEndOfElement(base, baseCursor);
              int ndc = differential.getElement().indexOf(diffMatches.get(diffpos));
              int ndl = profileUtilities.findEndOfElement(differential, ndc);
              // now we process the base scope repeatedly for each instance of the item in the differential list
              processPaths(indent+"  ", result, base, differential, baseCursor, ndc, nbl, ndl, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, diffpos), contextPathSrc, contextPathDst, closed, contextName, resultPathBase, true, null, null, redirector, srcSD);
              // ok, done with that - now set the cursors for if this is the end
              baseCursor = nbl;
              diffCursor = ndl+1;
              diffpos++;
            } else {
              result.getElement().add(outcome);
              baseCursor++;
              // just copy any children on the base
              while (baseCursor < base.getElement().size() && base.getElement().get(baseCursor).getPath().startsWith(path) && !base.getElement().get(baseCursor).getPath().equals(path)) {
                outcome = profileUtilities.updateURLs(url, webUrl, base.getElement().get(baseCursor).copy());
                outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
                if (!outcome.getPath().startsWith(resultPathBase))
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
                outcome.setUserData(profileUtilities.BASE_PATH, outcome.getPath());
                outcome.setUserData(profileUtilities.BASE_MODEL, srcSD.getUrl());
                result.getElement().add(outcome);
                baseCursor++;
              }
              //Lloyd - add this for test T15
              baseCursor--;
            }
          }
          // finally, we process any remaining entries in diff, which are new (and which are only allowed if the base wasn't closed
          boolean checkImplicitTypes = false;
          if (closed && diffpos < diffMatches.size()) {
            // this is a problem, unless we're on a polymorhpic type and we're going to constrain a slice that actually implicitly exists
            if (currentBase.getPath().endsWith("[x]")) {
              checkImplicitTypes = true;
            } else {
              throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.THE_BASE_SNAPSHOT_MARKS_A_SLICING_AS_CLOSED_BUT_THE_DIFFERENTIAL_TRIES_TO_EXTEND_IT_IN__AT__, profileName, path, currentBasePath));
            }
          }
          if (diffpos == diffMatches.size()) {
//Lloyd This was causing problems w/ Telus
//            diffCursor++;
          } else {
            while (diffpos < diffMatches.size()) {
              ElementDefinition diffItem = diffMatches.get(diffpos);
              for (ElementDefinition baseItem : baseMatches)
                if (baseItem.getSliceName().equals(diffItem.getSliceName()))
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.NAMED_ITEMS_ARE_OUT_OF_ORDER_IN_THE_SLICE));
              outcome = profileUtilities.updateURLs(url, webUrl, currentBase.copy());
              //            outcome = updateURLs(url, diffItem.copy());
              outcome.setPath(profileUtilities.fixedPathDest(contextPathDst, outcome.getPath(), redirector, contextPathSrc));
              profileUtilities.updateFromBase(outcome, currentBase, srcSD.getUrl());
              outcome.setSlicing(null);
              outcome.setMin(0); // we're in a slice, so it's only a mandatory if it's explicitly marked so
              if (!outcome.getPath().startsWith(resultPathBase))
                throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
              result.getElement().add(outcome);
              profileUtilities.updateFromDefinition(outcome, diffItem, profileName, trimDifferential, url, srcSD);
              profileUtilities.removeStatusExtensions(outcome);
              // --- LM Added this
              diffCursor = differential.getElement().indexOf(diffItem)+1;
              if (!outcome.getType().isEmpty() && (/*outcome.getType().get(0).getCode().equals("Extension") || */differential.getElement().size() > diffCursor) && outcome.getPath().contains(".")/* && isDataType(outcome.getType())*/) {  // don't want to do this for the root, since that's base, and we're already processing it
                if (!profileUtilities.baseWalksInto(base.getElement(), baseCursor)) {
                  if (differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), diffMatches.get(0).getPath()+".")) {
                    if (outcome.getType().size() > 1)
                      for (ElementDefinition.TypeRefComponent t : outcome.getType()) {
                        if (!t.getCode().equals("Reference"))
                          throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__AND_MULTIPLE_TYPES__IN_PROFILE_, diffMatches.get(0).getPath(), differential.getElement().get(diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), profileName));
                      }
                    ElementDefinition.TypeRefComponent t = outcome.getType().get(0);
                    if (t.getCode().equals("BackboneElement")) {
                      int baseStart = base.getElement().indexOf(currentBase)+1;
                      int baseMax = baseStart + 1;
                      while (baseMax < base.getElement().size() && base.getElement().get(baseMax).getPath().startsWith(currentBase.getPath()+"."))
                        baseMax++;
                      int start = diffCursor;
                      while (differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), diffMatches.get(0).getPath()+"."))
                        diffCursor++;
                      processPaths(indent+"  ", result, base, differential, baseStart, start-1, baseMax-1,
                        diffCursor - 1, url, webUrl, profileName+profileUtilities.pathTail(diffMatches, 0), base.getElement().get(0).getPath(), base.getElement().get(0).getPath(), trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);

                    } else {
                      StructureDefinition dt = profileUtilities.getProfileForDataType(outcome.getType().get(0), webUrl);
                      //                if (t.getCode().equals("Extension") && t.hasProfile() && !t.getProfile().contains(":")) {
                      // lloydfix                  dt =
                      //                }
                      if (dt == null)
                        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__FOR_TYPE__IN_PROFILE__BUT_CANT_FIND_TYPE, diffMatches.get(0).getPath(), differential.getElement().get(diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), profileName));
                      contextName = dt.getUrl();
                      int start = diffCursor;
                      while (differential.getElement().size() > diffCursor && profileUtilities.pathStartsWith(differential.getElement().get(diffCursor).getPath(), diffMatches.get(0).getPath()+"."))
                        diffCursor++;
                      processPaths(indent+"  ", result, dt.getSnapshot(), differential, 1 /* starting again on the data type, but skip the root */, start-1, dt.getSnapshot().getElement().size()-1,
                        diffCursor - 1, url, profileUtilities.getWebUrl(dt, webUrl, indent), profileName+profileUtilities.pathTail(diffMatches, 0), diffMatches.get(0).getPath(), outcome.getPath(), trimDifferential, contextName, resultPathBase, false, null, null, redirector, srcSD);
                    }
                  }
                }
              }
              // ---
              diffpos++;
            }
          }
          baseCursor++;
        }
      }
    }

    int i = 0;
    for (ElementDefinition e : result.getElement()) {
      i++;
      if (e.hasMinElement() && e.getMinElement().getValue()==null)
        throw new Error(profileUtilities.getContext().formatMessage(I18nConstants.NULL_MIN));
    }
    return res;
  }


  private boolean oneMatchingElementInDifferential(boolean slicingDone, String path, List<ElementDefinition> diffMatches) {
    if (diffMatches.size() != 1) {
      return false;
    }
    if (slicingDone) {
      return true;
    }
    if (profileUtilities.isImplicitSlicing(diffMatches.get(0), path)) {
      return false;
    }
    return   !(diffMatches.get(0).hasSlicing()
      || (profileUtilities.isExtension(diffMatches.get(0))
      && diffMatches.get(0).hasSliceName()));
  }


}
