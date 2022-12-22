package org.hl7.fhir.r5.conformance;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
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

  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  public class ProfilePathProcessorState {
    private StructureDefinition.StructureDefinitionSnapshotComponent base;

    private int baseCursor;
    private int diffCursor;

    private String contextName;
    private String resultPathBase;

  }

  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  public class PathSlicingParams {
    @Getter
    final boolean done;
    @Getter
    final ElementDefinition elementDefinition;
    @Getter
    final String path;

    public PathSlicingParams() {
      done = false;
      elementDefinition = null;
      path = null;
    }
  }

  public ProfilePathProcessor(ProfileUtilities profileUtilities) {
    this.profileUtilities = profileUtilities;
  }

  protected void processPaths(StructureDefinition base, StructureDefinition derived, String url, String webUrl, StructureDefinition.StructureDefinitionDifferentialComponent differential, StructureDefinition.StructureDefinitionSnapshotComponent baseSnapshot) {

    ProfilePathProcessorState cursors = new ProfilePathProcessorState(
      baseSnapshot,
      0,
      0,
      base.getUrl(),
      null);

    processPaths(
      new ProfilePathProcessorBase(this.profileUtilities,
        derived.getSnapshot(),
        differential,
        baseSnapshot.getElement().size() - 1,
        derived.getDifferential().hasElement() ? derived.getDifferential().getElement().size() - 1 : -1,
        url,
        webUrl,
        derived.present(),
        null,
      null,
      false, new ArrayList<ElementRedirection>(), base, derived, new PathSlicingParams()),
      cursors);
  }

  /**
   * @param cursors
   * @throws DefinitionException, FHIRException
   * @throws Exception
   */
  private ElementDefinition processPaths(final ProfilePathProcessorBase params,
                                         final ProfilePathProcessorState cursors) throws FHIRException {
    debugProcessPathsEntry(params, cursors);
    ElementDefinition res = null;
    List<TypeSlice> typeList = new ArrayList<>();
    // just repeat processing entries until we run out of our allowed scope (1st entry, the allowed scope is all the entries)
    while (cursors.baseCursor <= params.getBaseLimit()) {
      // get the current focus of the base, and decide what to do
      ElementDefinition currentBase = cursors.base.getElement().get(cursors.baseCursor);
      String currentBasePath = profileUtilities.fixedPathSource(params.getContextPathSource(), currentBase.getPath(), params.getRedirector());
      debugProcessPathsIteration(params, cursors, currentBasePath);
      List<ElementDefinition> diffMatches = profileUtilities.getDiffMatches(params.getDifferential(), currentBasePath, cursors.diffCursor, params.getDiffLimit(), params.getProfileName()); // get a list of matching elements in scope

      // in the simple case, source is not sliced.
      if (!currentBase.hasSlicing() || currentBasePath.equals(params.getSlicing().getPath()))
      {
        ElementDefinition currentRes = processSimplePath(currentBase, currentBasePath, diffMatches, typeList,
        params,
          cursors
        );
        if (res == null) {
          res = currentRes;
        }
      }
      else {
        processPathWithSlicedBase(currentBase, currentBasePath, diffMatches, typeList,
          params, cursors
          );
      }
    }

    int i = 0;
    for (ElementDefinition e : params.getResult().getElement()) {
      i++;
      if (e.hasMinElement() && e.getMinElement().getValue() == null)
        throw new Error(profileUtilities.getContext().formatMessage(I18nConstants.NULL_MIN));
    }
    return res;
  }

  private void debugProcessPathsIteration(ProfilePathProcessorBase params,  ProfilePathProcessorState cursors, String currentBasePath) {
    if (profileUtilities.isDebug()) {
      System.out.println(params.getDebugIndent() + " - " + currentBasePath + ": base = " + cursors.baseCursor + " (" + profileUtilities.descED(cursors.base.getElement(), cursors.baseCursor) + ") to " + params.getBaseLimit() + " (" + profileUtilities.descED(cursors.base.getElement(), params.getBaseLimit()) + "), diff = " + cursors.diffCursor + " (" + profileUtilities.descED(params.getDifferential().getElement(), cursors.diffCursor) + ") to " + params.getDiffLimit() + " (" + profileUtilities.descED(params.getDifferential().getElement(), params.getDiffLimit()) + ") " +
        "(slicingDone = " + params.getSlicing().isDone() + ") (diffpath= " + (params.getDifferential().getElement().size() > cursors.diffCursor ? params.getDifferential().getElement().get(cursors.diffCursor).getPath() : "n/a") + ")");
    }
  }

  private void debugProcessPathsEntry(ProfilePathProcessorBase params, ProfilePathProcessorState cursors) {
    if (profileUtilities.isDebug()) {
      System.out.println(params.getDebugIndent() + "PP @ " + cursors.resultPathBase + " / " + params.getContextPathSource() + " : base = " + cursors.baseCursor + " to " + params.getBaseLimit() + ", diff = " + cursors.diffCursor + " to " + params.getDiffLimit() + " (slicing = " + params.getSlicing().isDone() + ", k " + (params.getRedirector() == null ? "null" : params.getRedirector().toString()) + ")");
    }
  }


  public ElementDefinition processSimplePath(
    final ElementDefinition currentBase,
    final String currentBasePath,
    final List<ElementDefinition> diffMatches,
    final List<TypeSlice> typeList,
    final ProfilePathProcessorBase params,
    final ProfilePathProcessorState cursors) throws FHIRException {
    ElementDefinition res = null;

      // the differential doesn't say anything about this item
      // so we just copy it in
      if (diffMatches.isEmpty())
        processSimplePathWithEmptyDiffMatches(currentBase, currentBasePath, diffMatches, params, cursors);
        // one matching element in the differential
      else if (oneMatchingElementInDifferential(params.getSlicing().isDone(), currentBasePath, diffMatches))
        res = processSimplePathWithOneMatchingElementInDifferential(currentBase, currentBasePath, diffMatches, params, cursors);
      else if (profileUtilities.diffsConstrainTypes(diffMatches, currentBasePath, typeList))
        processSimplePathWhereDiffsConstrainTypes(currentBasePath, diffMatches, typeList, params, cursors);
      else
        processSimplePathDefault(currentBase, currentBasePath, diffMatches, params, cursors);


    return res;
  }

  private void processSimplePathDefault(ElementDefinition currentBase, String currentBasePath, List<ElementDefinition> diffMatches, ProfilePathProcessorBase params, ProfilePathProcessorState cursors) {
    // ok, the differential slices the item. Let's check our pre-conditions to ensure that this is correct
    if (!profileUtilities.unbounded(currentBase) && !profileUtilities.isSlicedToOneOnly(diffMatches.get(0)))
      // you can only slice an element that doesn't repeat if the sum total of your slices is limited to 1
      // (but you might do that in order to split up constraints by type)
      throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ATTEMPT_TO_A_SLICE_AN_ELEMENT_THAT_DOES_NOT_REPEAT__FROM__IN_, currentBase.getPath(), currentBase.getPath(), cursors.contextName, diffMatches.get(0).getId(), profileUtilities.sliceNames(diffMatches)));
    if (!diffMatches.get(0).hasSlicing() && !profileUtilities.isExtension(currentBase)) // well, the diff has set up a slice, but hasn't defined it. this is an error
      throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.DIFFERENTIAL_DOES_NOT_HAVE_A_SLICE__B_OF_____IN_PROFILE_, currentBase.getPath(), cursors.baseCursor, params.getBaseLimit(), cursors.diffCursor, params.getDiffLimit(), params.getUrl(), currentBasePath));

    // well, if it passed those preconditions then we slice the dest.
    int start = 0;
    int newBaseLimit = profileUtilities.findEndOfElement(cursors.base, cursors.baseCursor);
//          if (diffMatches.size() > 1 && diffMatches.get(0).hasSlicing() && differential.getElement().indexOf(diffMatches.get(1)) > differential.getElement().indexOf(diffMatches.get(0))+1) {
    ElementDefinition slicerElement;
    if (diffMatches.size() > 1 && diffMatches.get(0).hasSlicing() && (newBaseLimit > cursors.baseCursor || params.getDifferential().getElement().indexOf(diffMatches.get(1)) > params.getDifferential().getElement().indexOf(diffMatches.get(0)) + 1)) { // there's a default set before the slices
      int newDiffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(0));
      int newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), newDiffCursor);
      ElementDefinition e = processPaths(
        params
          .incrementDebugIndent()
          .withBaseLimit(newBaseLimit)
          .withDiffLimit(newDiffLimit)
          .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, 0)).withSlicing(new PathSlicingParams(true, null, null)),
        new ProfilePathProcessorState(cursors.base, cursors.baseCursor, newDiffCursor,
          cursors.contextName, cursors.resultPathBase));
      if (e == null)
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.DID_NOT_FIND_SINGLE_SLICE_, diffMatches.get(0).getPath()));
      e.setSlicing(diffMatches.get(0).getSlicing());
      slicerElement = e;
      start++;
    } else {
      // we're just going to accept the differential slicing at face value
      ElementDefinition outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), currentBase.copy());
      outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
      profileUtilities.updateFromBase(outcome, currentBase, params.getSourceStructureDefinition().getUrl());

      if (!diffMatches.get(0).hasSlicing())
        outcome.setSlicing(profileUtilities.makeExtensionSlicing());
      else
        outcome.setSlicing(diffMatches.get(0).getSlicing().copy());
      if (!outcome.getPath().startsWith(cursors.resultPathBase))
        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
      params.getResult().getElement().add(outcome);
      slicerElement = outcome;

      // differential - if the first one in the list has a name, we'll process it. Else we'll treat it as the base definition of the slice.
      if (!diffMatches.get(0).hasSliceName()) {
        profileUtilities.updateFromDefinition(outcome, diffMatches.get(0), params.getProfileName(), params.isTrimDifferential(), params.getUrl(), params.getSourceStructureDefinition(), params.getDerived());
        profileUtilities.removeStatusExtensions(outcome);
        if (!outcome.hasContentReference() && !outcome.hasType()) {
          throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.NOT_DONE_YET));
        }
        if (profileUtilities.hasInnerDiffMatches(params.getDifferential(), currentBasePath, cursors.diffCursor, params.getDiffLimit(), cursors.base.getElement(), false)) {
          if (profileUtilities.baseHasChildren(cursors.base, currentBase)) { // not a new type here
            throw new Error("This situation is not yet handled (constrain slicing to 1..1 and fix base slice for inline structure - please report issue to grahame@fhir.org along with a test case that reproduces this error (@ " + currentBasePath + " | " + currentBase.getPath() + ")");
          } else {
            StructureDefinition dt = profileUtilities.getTypeForElement(params.getDifferential(), cursors.diffCursor, params.getProfileName(), diffMatches, outcome, params.getWebUrl(), params.getDerived());
            cursors.contextName = dt.getUrl();
            cursors.diffCursor++;
            start = cursors.diffCursor;
            while (params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), currentBasePath + "."))
              cursors.diffCursor++;
            cursors.diffCursor--;
            processPaths(
              params.incrementDebugIndent()
                .withBaseLimit( dt.getSnapshot().getElement().size() - 1)
                .withDiffLimit(cursors.diffCursor)
                .withWebUrl(profileUtilities.getWebUrl(dt, params.getWebUrl()))
                .withContextPathSource(currentBasePath)
                .withContextPathTarget(outcome.getPath()).withSlicing(new PathSlicingParams()),     /* starting again on the data type, but skip the root */
              new ProfilePathProcessorState(dt.getSnapshot(), 1 /* starting again on the data type, but skip the root */, start,
                cursors.contextName, cursors.resultPathBase));
          }
        }
        start++;
        // result.getElement().remove(result.getElement().size()-1);
      } else
        profileUtilities.checkExtensionDoco(outcome);
    }
    // now, for each entry in the diff matches, we're going to process the base item
    // our processing scope for base is all the children of the current path
    int newDiffCursor = cursors.diffCursor;
    int newDiffLimit = cursors.diffCursor;
    for (int i = start; i < diffMatches.size(); i++) {
      // our processing scope for the differential is the item in the list, and all the items before the next one in the list
      newDiffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(i));
      newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), newDiffCursor);

      // now we process the base scope repeatedly for each instance of the item in the differential list
      processPaths(
        params
          .incrementDebugIndent()
          .withBaseLimit(newBaseLimit)
          .withDiffLimit(newDiffLimit)
          .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, i))
          .withSlicing(new PathSlicingParams(true, slicerElement, null)), new ProfilePathProcessorState(cursors.base, cursors.baseCursor, newDiffCursor, cursors.contextName, cursors.resultPathBase));
    }
    // ok, done with that - next in the base list
    cursors.baseCursor = newBaseLimit + 1;
    cursors.diffCursor = newDiffLimit + 1;
  }

  private void processSimplePathWhereDiffsConstrainTypes(String currentBasePath, List<ElementDefinition> diffMatches, List<TypeSlice> typeList, ProfilePathProcessorBase params, ProfilePathProcessorState cursors) {
    int start = 0;
    int newBaseLimit = profileUtilities.findEndOfElement(cursors.base, cursors.baseCursor);
    int newDiffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(0));
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
        params.getDifferential().getElement().add(newDiffCursor, ed);
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
        params.getDifferential().getElement().add(newDiffCursor, ed);
        elementToRemove = ed;
      }
    }
    int newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), newDiffCursor);
    // the first element is setting up the slicing

    if (diffMatches.get(0).getSlicing().hasOrdered()) {
      if (diffMatches.get(0).getSlicing().getOrdered()) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGORDERED__TRUE, currentBasePath, params.getUrl()));
      }
    }
    if (diffMatches.get(0).getSlicing().hasDiscriminator()) {
      if (diffMatches.get(0).getSlicing().getDiscriminator().size() != 1) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORCOUNT__1, currentBasePath, params.getUrl()));
      }
      if (diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getType() != ElementDefinition.DiscriminatorType.TYPE) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORTYPE__TYPE, currentBasePath, params.getUrl()));
      }
      if (!"$this".equals(diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getPath())) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORPATH__THIS, currentBasePath, params.getUrl()));
      }
    }
    // check the slice names too while we're at it...
    for (TypeSlice ts : typeList) {
      if (ts.getType() != null) {
        String tn = profileUtilities.rootName(currentBasePath) + Utilities.capitalize(ts.getType());
        if (!ts.defn.hasSliceName()) {
          ts.defn.setSliceName(tn);
        } else if (!ts.defn.getSliceName().equals(tn)) {
          if (profileUtilities.isAutoFixSliceNames()) {
            ts.defn.setSliceName(tn);
          } else {
            throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_NAME_MUST_BE__BUT_IS_, (!Utilities.noString(params.getContextPathSource()) ? params.getContextPathSource() : currentBasePath), tn, ts.defn.getSliceName()));
          }
        }
        if (!ts.defn.hasType()) {
          ts.defn.addType().setCode(ts.type);
        } else if (ts.defn.getType().size() > 1) {
          throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_MORE_THAN_ONE_TYPE_, (!Utilities.noString(params.getContextPathSource()) ? params.getContextPathSource() : currentBasePath), tn, ts.defn.typeSummary()));
        } else if (!ts.defn.getType().get(0).getCode().equals(ts.type)) {
          throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_WRONG_TYPE_, (!Utilities.noString(params.getContextPathSource()) ? params.getContextPathSource() : currentBasePath), tn, ts.defn.typeSummary()));
        }
      }
    }

    // ok passed the checks.
    // copy the root diff, and then process any children it has
    ElementDefinition elementDefinition = processPaths(
      params
        .incrementDebugIndent()
        .withBaseLimit(newBaseLimit)
        .withDiffLimit(newDiffLimit)
        .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, 0))
        .withSlicing(new PathSlicingParams(true, null, null)),
      new ProfilePathProcessorState(cursors.base, cursors.baseCursor, newDiffCursor,
        cursors.contextName, cursors.resultPathBase));
    if (elementDefinition == null)
      throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.DID_NOT_FIND_TYPE_ROOT_, diffMatches.get(0).getPath()));
    // now set up slicing on the e (cause it was wiped by what we called.
    elementDefinition.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
    elementDefinition.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
    elementDefinition.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED); // type slicing is always closed; the differential might call it open, but that just means it's not constraining the slices it doesn't mention
    elementDefinition.getSlicing().setOrdered(false);

    start++;

    String fixedType = null;
    // now process the siblings, which should each be type constrained - and may also have their own children
    // now we process the base scope repeatedly for each instance of the item in the differential list
    for (int i = start; i < diffMatches.size(); i++) {
      // our processing scope for the differential is the item in the list, and all the items before the next one in the list
      if (diffMatches.get(i).getMin() > 0) {
        if (diffMatches.size() > i + 1) {
          throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.INVALID_SLICING__THERE_IS_MORE_THAN_ONE_TYPE_SLICE_AT__BUT_ONE_OF_THEM__HAS_MIN__1_SO_THE_OTHER_SLICES_CANNOT_EXIST, diffMatches.get(i).getPath(), diffMatches.get(i).getSliceName()));
        } else {
          elementDefinition.setMin(1);
        }
        fixedType = profileUtilities.determineFixedType(diffMatches, fixedType, i);
      }
      newDiffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(i));
      newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), newDiffCursor);
      ElementDefinition typeSliceElement = processPaths(
        params
          .incrementDebugIndent()
          .withBaseLimit(newBaseLimit)
          .withDiffLimit(newDiffLimit)
          .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, i))
          .withSlicing(new PathSlicingParams(true, elementDefinition, null)),
        new ProfilePathProcessorState(cursors.base, cursors.baseCursor, newDiffCursor, cursors.contextName, cursors.resultPathBase));
      if (typeList.size() > start + 1) {
        typeSliceElement.setMin(0);
      }
    }
    if (elementToRemove != null) {
      params.getDifferential().getElement().remove(elementToRemove);
      newDiffLimit--;
    }
    if (fixedType != null) {
      for (Iterator<ElementDefinition.TypeRefComponent> iter = elementDefinition.getType().iterator(); iter.hasNext(); ) {
        ElementDefinition.TypeRefComponent tr = iter.next();
        if (!tr.getCode().equals(fixedType)) {
          iter.remove();
        }
      }
    }
    if (!"0".equals(elementDefinition.getMax())) {
      // check that there's a slice for each allowed types
      Set<String> allowedTypes = profileUtilities.getListOfTypes(elementDefinition);
      for (TypeSlice t : typeList) {
        if (t.type != null) {
          allowedTypes.remove(t.type);
        } else if (t.getDefn().hasSliceName() && t.getDefn().getType().size() == 1) {
          allowedTypes.remove(t.getDefn().getType().get(0).getCode());
        }
      }
      if (!allowedTypes.isEmpty()) {
        if (currentBasePath.contains("xtension.value")) {
          for (Iterator<ElementDefinition.TypeRefComponent> iter = elementDefinition.getType().iterator(); iter.hasNext(); ) {
            ElementDefinition.TypeRefComponent tr = iter.next();
            if (allowedTypes.contains(tr.getCode())) {
              iter.remove();
            }
          }
//                System.out.println("!!: Extension Error at "+cpath+": Allowed Types not sliced = "+allowedTypes+". !Extension!!");
//                throw new Error("Extension Error at "+cpath+": Allowed Types not sliced = "+allowedTypes+". !Extension!!");

        } else {
          elementDefinition.getSlicing().setRules(ElementDefinition.SlicingRules.OPEN);
        }
      }
    }
    // ok, done with that - next in the base list
    cursors.baseCursor = newBaseLimit + 1;
    cursors.diffCursor = newDiffLimit + 1;
  }

  private ElementDefinition processSimplePathWithOneMatchingElementInDifferential(ElementDefinition currentBase, String currentBasePath, List<ElementDefinition> diffMatches, ProfilePathProcessorBase params, ProfilePathProcessorState cursors) {
    ElementDefinition res;
    ElementDefinition template = null;
    if (diffMatches.get(0).hasType() && "Reference".equals(diffMatches.get(0).getType().get(0).getWorkingCode()) && !profileUtilities.isValidType(diffMatches.get(0).getType().get(0), currentBase)) {
      throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.VALIDATION_VAL_ILLEGAL_TYPE_CONSTRAINT, params.getUrl(), diffMatches.get(0).getPath(), diffMatches.get(0).getType().get(0), currentBase.typeSummary()));
    }
    String id = diffMatches.get(0).getId();
    String lid = profileUtilities.tail(id);
    if (lid.contains("/")) {
      // the template comes from the snapshot of the base
      profileUtilities.generateIds(params.getResult().getElement(), params.getUrl(), params.getSourceStructureDefinition().getType(), params.getSourceStructureDefinition());
      String baseId = id.substring(0, id.length() - lid.length()) + lid.substring(0, lid.indexOf("/")); // this is wrong if there's more than one reslice (todo: one thing at a time)
      template = profileUtilities.getById(params.getResult().getElement(), baseId);

    } else if (diffMatches.get(0).hasType()
      && diffMatches.get(0).getType().size() == 1
      && diffMatches.get(0).getType().get(0).hasProfile()
      && !"Reference".equals(diffMatches.get(0).getType().get(0).getWorkingCode())) {
      CanonicalType firstTypeProfile = diffMatches.get(0).getType().get(0).getProfile().get(0);
      StructureDefinition firstTypeStructureDefinition = profileUtilities.getContext().fetchResource(StructureDefinition.class, firstTypeProfile.getValue());
      if (firstTypeStructureDefinition == null && profileUtilities.getXver() != null && profileUtilities.getXver().matchingUrl(firstTypeProfile.getValue())) {
        switch (profileUtilities.getXver().status(firstTypeProfile.getValue())) {
          case BadVersion:
            throw new FHIRException("Reference to invalid version in extension url " + firstTypeProfile.getValue());
          case Invalid:
            throw new FHIRException("Reference to invalid extension " + firstTypeProfile.getValue());
          case Unknown:
            throw new FHIRException("Reference to unknown extension " + firstTypeProfile.getValue());
          case Valid:
            firstTypeStructureDefinition = profileUtilities.getXver().makeDefinition(firstTypeProfile.getValue());
            profileUtilities.generateSnapshot(profileUtilities.getContext().fetchTypeDefinition("Extension"), firstTypeStructureDefinition, firstTypeStructureDefinition.getUrl(), params.getWebUrl(), firstTypeStructureDefinition.getName());
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
          profileUtilities.generateSnapshot(sdb, firstTypeStructureDefinition, firstTypeStructureDefinition.getUrl(), (sdb.hasUserData("path")) ? Utilities.extractBaseUrl(sdb.getUserString("path")) : params.getWebUrl(), firstTypeStructureDefinition.getName());
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

    ElementDefinition outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), template);
    outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));

    res = outcome;
    profileUtilities.updateFromBase(outcome, currentBase, params.getSourceStructureDefinition().getUrl());
    if (diffMatches.get(0).hasSliceName()) {
      outcome.setSliceName(diffMatches.get(0).getSliceName());
      if (!diffMatches.get(0).hasMin() && (diffMatches.size() > 1 || params.getSlicing().getElementDefinition()== null || params.getSlicing().getElementDefinition().getSlicing().getRules() != ElementDefinition.SlicingRules.CLOSED) && !currentBase.hasSliceName()) {
        if (!currentBasePath.endsWith("xtension.value[x]")) { // hack work around for problems with snapshots in official releases
          outcome.setMin(0);
        }
      }
    }
    profileUtilities.updateFromDefinition(outcome, diffMatches.get(0), params.getProfileName(), params.isTrimDifferential(), params.getUrl(), params.getSourceStructureDefinition(), params.getDerived());
    profileUtilities.removeStatusExtensions(outcome);
//          if (outcome.getPath().endsWith("[x]") && outcome.getType().size() == 1 && !outcome.getType().get(0).getCode().equals("*") && !diffMatches.get(0).hasSlicing()) // if the base profile allows multiple types, but the profile only allows one, rename it
//            outcome.setPath(outcome.getPath().substring(0, outcome.getPath().length()-3)+Utilities.capitalize(outcome.getType().get(0).getCode()));
    outcome.setSlicing(null);
    if (cursors.resultPathBase == null)
      cursors.resultPathBase = outcome.getPath();
    else if (!outcome.getPath().startsWith(cursors.resultPathBase))
      throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
    params.getResult().getElement().add(outcome);
    cursors.baseCursor++;
    cursors.diffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(0)) + 1;
    if (params.getDiffLimit() >= cursors.diffCursor && outcome.getPath().contains(".") && (profileUtilities.isDataType(outcome.getType()) || profileUtilities.isBaseResource(outcome.getType()) || outcome.hasContentReference())) {  // don't want to do this for the root, since that's base, and we're already processing it
      if (profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), diffMatches.get(0).getPath() + ".") && !profileUtilities.baseWalksInto(cursors.base.getElement(), cursors.baseCursor)) {
        if (outcome.getType().size() > 1) {
          if (outcome.getPath().endsWith("[x]") && !diffMatches.get(0).getPath().endsWith("[x]")) {
            String en = profileUtilities.tail(outcome.getPath());
            String tn = profileUtilities.tail(diffMatches.get(0).getPath());
            String t = tn.substring(en.length() - 3);
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
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__AND_MULTIPLE_TYPES__IN_PROFILE_, diffMatches.get(0).getPath(), params.getDifferential().getElement().get(cursors.diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), params.getProfileName()));
              }
            }
        }
        int start = cursors.diffCursor;
        while (cursors.diffCursor <= params.getDiffLimit() && params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), diffMatches.get(0).getPath() + "."))
          cursors.diffCursor++;
        if (outcome.hasContentReference()) {
          ProfileUtilities.ElementDefinitionResolution target = profileUtilities.getElementById(params.getSourceStructureDefinition(), cursors.base.getElement(), outcome.getContentReference());
          if (target == null)
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNABLE_TO_RESOLVE_REFERENCE_TO_, outcome.getContentReference()));
          profileUtilities.replaceFromContentReference(outcome, target.getElement());
          if (target.getSource() != params.getSourceStructureDefinition()) {
            cursors.base = target.getSource().getSnapshot();
            int newBaseCursor = cursors.base.getElement().indexOf(target.getElement()) + 1;
            int newBaseLimit = newBaseCursor;
            while (newBaseLimit < cursors.base.getElement().size() && cursors.base.getElement().get(newBaseLimit).getPath().startsWith(target.getElement().getPath() + "."))
              newBaseLimit++;
            processPaths(
              params
                .incrementDebugIndent()
                .withBaseLimit(newBaseLimit - 1)
                .withDiffLimit(cursors.diffCursor - 1)
                .withContextPathSource(target.getElement().getPath())
                .withContextPathTarget(diffMatches.get(0).getPath()).withRedirector(profileUtilities.redirectorStack(params.getRedirector(), outcome, currentBasePath))
                .withSourceStructureDefinition(target.getSource())
                .withSlicing(new PathSlicingParams()), new ProfilePathProcessorState(cursors.base, newBaseCursor, start - 1, cursors.contextName, cursors.resultPathBase));
          } else {
            final int newBaseCursor = cursors.base.getElement().indexOf(target.getElement()) + 1;
            int newBaseLimit = newBaseCursor;
            while (newBaseLimit < cursors.base.getElement().size() && cursors.base.getElement().get(newBaseLimit).getPath().startsWith(target.getElement().getPath() + "."))
              newBaseLimit++;
            processPaths(
              params
                .incrementDebugIndent()
                .withBaseLimit(newBaseLimit - 1)
                .withDiffLimit(cursors.diffCursor - 1)
                .withContextPathSource(target.getElement().getPath())
                .withContextPathTarget(diffMatches.get(0).getPath())
                .withRedirector(profileUtilities.redirectorStack(params.getRedirector(), outcome, currentBasePath))
                .withSlicing(new PathSlicingParams()),
              new ProfilePathProcessorState(cursors.base, newBaseCursor, start - 1, cursors.contextName, cursors.resultPathBase));
          }
        } else {
          StructureDefinition dt = outcome.getType().size() == 1 ? profileUtilities.getProfileForDataType(outcome.getType().get(0), params.getWebUrl(), params.getDerived()) : profileUtilities.getProfileForDataType("Element");
          if (dt == null)
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__FOR_TYPE__IN_PROFILE__BUT_CANT_FIND_TYPE, diffMatches.isEmpty() ? "??" : diffMatches.get(0).getPath(), params.getDifferential().getElement().get(cursors.diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), params.getProfileName()));
          cursors.contextName = dt.getUrl();
          processPaths(
            params
              .incrementDebugIndent()
              .withBaseLimit(dt.getSnapshot().getElement().size() - 1)
              .withDiffLimit(cursors.diffCursor - 1)
              .withWebUrl( profileUtilities.getWebUrl(dt, params.getWebUrl()))
              .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, 0))
              .withContextPathSource(diffMatches.get(0).getPath()).withContextPathTarget(outcome.getPath()).withRedirector(new ArrayList<ElementRedirection>())
              .withSlicing(new PathSlicingParams()),     /* starting again on the data type, but skip the root */
            new ProfilePathProcessorState(dt.getSnapshot(), 1 /* starting again on the data type, but skip the root */, start,
              cursors.contextName, cursors.resultPathBase));
        }
      }
    }
    return res;
  }

  private void processSimplePathWithEmptyDiffMatches(ElementDefinition currentBase, String currentBasePath, List<ElementDefinition> diffMatches, ProfilePathProcessorBase params, ProfilePathProcessorState cursors) {
    ElementDefinition outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), currentBase.copy());
    outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
    profileUtilities.updateFromBase(outcome, currentBase, params.getSourceStructureDefinition().getUrl());
    profileUtilities.updateConstraintSources(outcome, params.getSourceStructureDefinition().getUrl());
    profileUtilities.markDerived(outcome);
    if (cursors.resultPathBase == null)
      cursors.resultPathBase = outcome.getPath();
    else if (!outcome.getPath().startsWith(cursors.resultPathBase))
      throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH__OUTCOMEGETPATH___RESULTPATHBASE__, outcome.getPath(), cursors.resultPathBase));
    params.getResult().getElement().add(outcome);
    if (profileUtilities.hasInnerDiffMatches(params.getDifferential(), currentBasePath, cursors.diffCursor, params.getDiffLimit(), cursors.base.getElement(), true)) {
      // well, the profile walks into this, so we need to as well
      // did we implicitly step into a new type?
      if (profileUtilities.baseHasChildren(cursors.base, currentBase)) { // not a new type here
        processPaths(
          params.incrementDebugIndent().withSlicing(new PathSlicingParams()), new ProfilePathProcessorState(cursors.base, cursors.baseCursor + 1, cursors.diffCursor, cursors.contextName, cursors.resultPathBase));
        cursors.baseCursor = profileUtilities.indexOfFirstNonChild(cursors.base, currentBase, cursors.baseCursor + 1, params.getBaseLimit());
      }
      else {
        if (outcome.getType().size() == 0 && !outcome.hasContentReference()) {
          throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_NO_CHILDREN__AND_NO_TYPES_IN_PROFILE_, currentBasePath, params.getDifferential().getElement().get(cursors.diffCursor).getPath(), params.getProfileName()));
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
        int start = cursors.diffCursor;
        while (params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), currentBasePath + "."))
          cursors.diffCursor++;
        if (nonExtension) {
          throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__AND_MULTIPLE_TYPES__IN_PROFILE_, currentBasePath, params.getDifferential().getElement().get(cursors.diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), params.getProfileName()));
        }
        if (outcome.hasContentReference()) {
          ProfileUtilities.ElementDefinitionResolution tgt = profileUtilities.getElementById(params.getSourceStructureDefinition(), cursors.base.getElement(), outcome.getContentReference());
          if (tgt == null)
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNABLE_TO_RESOLVE_REFERENCE_TO_, outcome.getContentReference()));
          profileUtilities.replaceFromContentReference(outcome, tgt.getElement());
          if (tgt.getSource() != params.getSourceStructureDefinition()) {
            cursors.base = tgt.getSource().getSnapshot();
            int newBaseCursor = cursors.base.getElement().indexOf(tgt.getElement()) + 1;
            int newBaseLimit = newBaseCursor;
            while (newBaseLimit < cursors.base.getElement().size() && cursors.base.getElement().get(newBaseLimit).getPath().startsWith(tgt.getElement().getPath() + "."))
              newBaseLimit++;
            processPaths(
              params
                .incrementDebugIndent()
                .withBaseLimit(newBaseLimit - 1)
                .withDiffLimit(cursors.diffCursor - 1)
                .withContextPathSource(tgt.getElement().getPath())
                .withContextPathTarget(diffMatches.get(0).getPath())
                .withRedirector(profileUtilities.redirectorStack(params.getRedirector(), outcome, currentBasePath))
                .withSourceStructureDefinition(tgt.getSource())
                .withSlicing(new PathSlicingParams()),
              new ProfilePathProcessorState(cursors.base, newBaseCursor, start - 1, cursors.contextName, cursors.resultPathBase));
          } else {
            int newBaseCursor = cursors.base.getElement().indexOf(tgt.getElement()) + 1;
            int newBaseLimit = newBaseCursor;
            while (newBaseLimit < cursors.base.getElement().size() && cursors.base.getElement().get(newBaseLimit).getPath().startsWith(tgt.getElement().getPath() + "."))
              newBaseLimit++;
            System.out.println("Test!");
            processPaths(
              params
                .incrementDebugIndent()
                .withBaseLimit(newBaseLimit - 1)
                .withDiffLimit(cursors.diffCursor - 1)
                .withContextPathSource(tgt.getElement().getPath())
                .withContextPathTarget(outcome.getPath())
                .withRedirector(profileUtilities.redirectorStack(params.getRedirector(), outcome, currentBasePath)).withSlicing(new PathSlicingParams()),
              new ProfilePathProcessorState(cursors.base, newBaseCursor, start, cursors.contextName, cursors.resultPathBase));
          }
        } else {
          StructureDefinition dt = outcome.getType().size() > 1 ? profileUtilities.getContext().fetchTypeDefinition("Element") : profileUtilities.getProfileForDataType(outcome.getType().get(0), params.getWebUrl(), params.getDerived());
          if (dt == null) {
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNKNOWN_TYPE__AT_, outcome.getType().get(0), currentBasePath));
          }
          cursors.contextName = dt.getUrl();
          if (params.getRedirector() == null || params.getRedirector().isEmpty()) {
            processPaths(
              params
                .incrementDebugIndent()
                .withBaseLimit(dt.getSnapshot().getElement().size() - 1)
                .withDiffLimit(cursors.diffCursor - 1)
                .withWebUrl(profileUtilities.getWebUrl(dt, params.getWebUrl()))
                .withContextPathSource(currentBasePath)
                .withContextPathTarget(outcome.getPath())
                .withSlicing(new PathSlicingParams()),     /* starting again on the data type, but skip the root */
              new ProfilePathProcessorState(dt.getSnapshot(), 1 /* starting again on the data type, but skip the root */, start,
                cursors.contextName, cursors.resultPathBase));
          } else {
            processPaths(
              params
                .incrementDebugIndent()
                .withBaseLimit(dt.getSnapshot().getElement().size() - 1)
                .withDiffLimit(cursors.diffCursor - 1)
                .withWebUrl(profileUtilities.getWebUrl(dt, params.getWebUrl()))
                .withContextPathSource(currentBasePath)
                .withContextPathTarget( outcome.getPath())
                .withRedirector(profileUtilities.redirectorStack(params.getRedirector(), currentBase, currentBasePath)).withSlicing(new PathSlicingParams()),     /* starting again on the data type, but skip the root */
              new ProfilePathProcessorState(dt.getSnapshot(), 1 /* starting again on the data type, but skip the root */, start,
                cursors.contextName, cursors.resultPathBase));
          }
        }
      }
    }
    cursors.baseCursor++;
  }

  private void processPathWithSlicedBase(
    ElementDefinition currentBase,
    String currentBasePath,
    List<ElementDefinition> diffMatches, List<TypeSlice> typeList,
    final ProfilePathProcessorBase params,
    final ProfilePathProcessorState cursors
  ) {
    // the item is already sliced in the base profile.
    // here's the rules
    //  1. irrespective of whether the slicing is ordered or not, the definition order must be maintained
    //  2. slice element names have to match.
    //  3. new slices must be introduced at the end
    // corallory: you can't re-slice existing slices. is that ok?

    // we're going to need this:
    String path = currentBase.getPath();

    if (diffMatches.isEmpty()) {
      processPathWithSlicedBaseAndEmptyDiffMatches(currentBase, currentBasePath, diffMatches, params, cursors, path);
    }
    else if (profileUtilities.diffsConstrainTypes(diffMatches, currentBasePath, typeList))
    {
      processPathWithSlicedBaseWhereDiffsConstrainTypes(currentBasePath, diffMatches, typeList, params, cursors);
    }
    else
    {
      processPathWithSlicedBaseDefault(currentBase, currentBasePath, diffMatches, params, cursors, path);
    }
  }

  private void processPathWithSlicedBaseDefault(ElementDefinition currentBase, String currentBasePath, List<ElementDefinition> diffMatches, ProfilePathProcessorBase params, ProfilePathProcessorState cursors, String path) {
    // first - check that the slicing is ok
    boolean closed = currentBase.getSlicing().getRules() == ElementDefinition.SlicingRules.CLOSED;
    int diffpos = 0;
    if (diffMatches.get(0).hasSlicing()) { // it might be null if the differential doesn't want to say anything about slicing
//            if (!isExtension)
//              diffpos++; // if there's a slice on the first, we'll ignore any content it has
      ElementDefinition.ElementDefinitionSlicingComponent dSlice = diffMatches.get(0).getSlicing();
      ElementDefinition.ElementDefinitionSlicingComponent bSlice = currentBase.getSlicing();
      if (dSlice.hasOrderedElement() && bSlice.hasOrderedElement() && !profileUtilities.orderMatches(dSlice.getOrderedElement(), bSlice.getOrderedElement()))
        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.SLICING_RULES_ON_DIFFERENTIAL__DO_NOT_MATCH_THOSE_ON_BASE___ORDER___, profileUtilities.summarizeSlicing(dSlice), profileUtilities.summarizeSlicing(bSlice), path, cursors.contextName));
      if (!profileUtilities.discriminatorMatches(dSlice.getDiscriminator(), bSlice.getDiscriminator()))
        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.SLICING_RULES_ON_DIFFERENTIAL__DO_NOT_MATCH_THOSE_ON_BASE___DISCIMINATOR___, profileUtilities.summarizeSlicing(dSlice), profileUtilities.summarizeSlicing(bSlice), path, cursors.contextName));
      if (!currentBase.isChoice() && !profileUtilities.ruleMatches(dSlice.getRules(), bSlice.getRules()))
        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.SLICING_RULES_ON_DIFFERENTIAL__DO_NOT_MATCH_THOSE_ON_BASE___RULE___, profileUtilities.summarizeSlicing(dSlice), profileUtilities.summarizeSlicing(bSlice), path, cursors.contextName));
    }
    ElementDefinition outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), currentBase.copy());
    outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
    profileUtilities.updateFromBase(outcome, currentBase, params.getSourceStructureDefinition().getUrl());
    if (diffMatches.get(0).hasSlicing() || !diffMatches.get(0).hasSliceName()) {
      profileUtilities.updateFromSlicing(outcome.getSlicing(), diffMatches.get(0).getSlicing());
      profileUtilities.updateFromDefinition(outcome, diffMatches.get(0), params.getProfileName(), closed, params.getUrl(), params.getSourceStructureDefinition(), params.getDerived()); // if there's no slice, we don't want to update the unsliced description
      profileUtilities.removeStatusExtensions(outcome);
    } else if (!diffMatches.get(0).hasSliceName()) {
      diffMatches.get(0).setUserData(profileUtilities.GENERATED_IN_SNAPSHOT, outcome); // because of updateFromDefinition isn't called
    }

    params.getResult().getElement().add(outcome);

    if (!diffMatches.get(0).hasSliceName()) { // it's not real content, just the slice
      diffpos++;
    }
    if (profileUtilities.hasInnerDiffMatches(params.getDifferential(), currentBasePath, cursors.diffCursor, params.getDiffLimit(), cursors.base.getElement(), false)) {
      int newBaseLimit = profileUtilities.findEndOfElement(cursors.base, cursors.baseCursor);
      int ndx = params.getDifferential().getElement().indexOf(diffMatches.get(0));
      int newDiffCursor = ndx + (diffMatches.get(0).hasSlicing() ? 1 : 0);
      int newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), ndx);
      if (newBaseLimit == cursors.baseCursor) {
        if (cursors.base.getElement().get(cursors.baseCursor).getType().size() != 1) {
          throw new Error(profileUtilities.getContext().formatMessage(I18nConstants.DIFFERENTIAL_WALKS_INTO____BUT_THE_BASE_DOES_NOT_AND_THERE_IS_NOT_A_SINGLE_FIXED_TYPE_THE_TYPE_IS__THIS_IS_NOT_HANDLED_YET, currentBasePath, diffMatches.get(0).toString(), cursors.base.getElement().get(cursors.baseCursor).typeSummary()));
        }
        StructureDefinition dt = profileUtilities.getProfileForDataType(cursors.base.getElement().get(cursors.baseCursor).getType().get(0), params.getWebUrl(), params.getDerived());
        if (dt == null) {
          throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.UNKNOWN_TYPE__AT_, outcome.getType().get(0), diffMatches.get(0).getPath()));
        }
        cursors.contextName = dt.getUrl();
        while (params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), currentBasePath + "."))
          cursors.diffCursor++;
        processPaths(
          params
            .incrementDebugIndent()
            .withBaseLimit(dt.getSnapshot().getElement().size() - 1)
            .withDiffLimit(newDiffLimit)
            .withWebUrl(profileUtilities.getWebUrl(dt, params.getWebUrl()))
            .withContextPathSource(currentBasePath).withContextPathTarget(outcome.getPath())
            .withSlicing(new PathSlicingParams()),
          new ProfilePathProcessorState(dt.getSnapshot(), 1, newDiffCursor,
            cursors.contextName, cursors.resultPathBase));
      } else {
        processPaths(
          params
            .incrementDebugIndent()
            .withBaseLimit(newBaseLimit)
            .withDiffLimit(newDiffLimit)
            .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, 0))
            .withRedirector(null).withSlicing(new PathSlicingParams()),
          new ProfilePathProcessorState(cursors.base, cursors.baseCursor + 1, newDiffCursor,
            cursors.contextName, cursors.resultPathBase));
      }
//            throw new Error("Not done yet");
//          } else if (currentBase.getType().get(0).getCode().equals("BackboneElement") && diffMatches.size() > 0 && diffMatches.get(0).hasSliceName()) {
    } else if (currentBase.getType().get(0).getCode().equals("BackboneElement")) {
      // We need to copy children of the backbone element before we start messing around with slices
      int newBaseLimit = profileUtilities.findEndOfElement(cursors.base, cursors.baseCursor);
      for (int i = cursors.baseCursor + 1; i <= newBaseLimit; i++) {
        outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), cursors.base.getElement().get(i).copy());
        params.getResult().getElement().add(outcome);
      }
    }

    // now, we have two lists, base and diff. we're going to work through base, looking for matches in diff.
    List<ElementDefinition> baseMatches = profileUtilities.getSiblings(cursors.base.getElement(), currentBase);
    for (ElementDefinition baseItem : baseMatches) {
      cursors.baseCursor = cursors.base.getElement().indexOf(baseItem);
      outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), baseItem.copy());
      profileUtilities.updateFromBase(outcome, currentBase, params.getSourceStructureDefinition().getUrl());
      outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
      outcome.setSlicing(null);
      if (!outcome.getPath().startsWith(cursors.resultPathBase))
        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
      if (diffpos < diffMatches.size() && diffMatches.get(diffpos).hasSliceName() && diffMatches.get(diffpos).getSliceName().equals(outcome.getSliceName())) {
        // if there's a diff, we update the outcome with diff
        // no? updateFromDefinition(outcome, diffMatches.get(diffpos), profileName, closed, url);
        //then process any children
        int newBaseLimit = profileUtilities.findEndOfElement(cursors.base, cursors.baseCursor);
        int newDiffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(diffpos));
        int newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), newDiffCursor);
        // now we process the base scope repeatedly for each instance of the item in the differential list
        processPaths(
          params
            .incrementDebugIndent()
            .withBaseLimit(newBaseLimit)
            .withDiffLimit(newDiffLimit)
            .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, diffpos))
            .withTrimDifferential(closed)
            .withSlicing(new PathSlicingParams(true, null, null)),
          new ProfilePathProcessorState(cursors.base, cursors.baseCursor, newDiffCursor, cursors.contextName, cursors.resultPathBase));
        // ok, done with that - now set the cursors for if this is the end
        cursors.baseCursor = newBaseLimit;
        cursors.diffCursor = newDiffLimit + 1;
        diffpos++;
      } else {
        params.getResult().getElement().add(outcome);
        cursors.baseCursor++;
        // just copy any children on the base
        while (cursors.baseCursor < cursors.base.getElement().size() && cursors.base.getElement().get(cursors.baseCursor).getPath().startsWith(path) && !cursors.base.getElement().get(cursors.baseCursor).getPath().equals(path)) {
          outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), cursors.base.getElement().get(cursors.baseCursor).copy());
          outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
          if (!outcome.getPath().startsWith(cursors.resultPathBase))
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
          outcome.setUserData(profileUtilities.BASE_PATH, outcome.getPath());
          outcome.setUserData(profileUtilities.BASE_MODEL, params.getSourceStructureDefinition().getUrl());
          params.getResult().getElement().add(outcome);
          cursors.baseCursor++;
        }
        //Lloyd - add this for test T15
        cursors.baseCursor--;
      }
    }
    // finally, we process any remaining entries in diff, which are new (and which are only allowed if the base wasn't closed
    if (closed && diffpos < diffMatches.size()) {
      // this is a problem, unless we're on a polymorhpic type and we're going to constrain a slice that actually implicitly exists
      if (!currentBase.getPath().endsWith("[x]")) {
        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.THE_BASE_SNAPSHOT_MARKS_A_SLICING_AS_CLOSED_BUT_THE_DIFFERENTIAL_TRIES_TO_EXTEND_IT_IN__AT__, params.getProfileName(), path, currentBasePath));
      }
    }
    if (diffpos != diffMatches.size()) {
      while (diffpos < diffMatches.size()) {
        ElementDefinition diffItem = diffMatches.get(diffpos);
        for (ElementDefinition baseItem : baseMatches)
          if (baseItem.getSliceName().equals(diffItem.getSliceName()))
            throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.NAMED_ITEMS_ARE_OUT_OF_ORDER_IN_THE_SLICE));
        outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), currentBase.copy());
        //            outcome = updateURLs(url, diffItem.copy());
        outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
        profileUtilities.updateFromBase(outcome, currentBase, params.getSourceStructureDefinition().getUrl());
        outcome.setSlicing(null);
        outcome.setMin(0); // we're in a slice, so it's only a mandatory if it's explicitly marked so
        if (!outcome.getPath().startsWith(cursors.resultPathBase))
          throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
        params.getResult().getElement().add(outcome);
        profileUtilities.updateFromDefinition(outcome, diffItem, params.getProfileName(), params.isTrimDifferential(), params.getUrl(), params.getSourceStructureDefinition(), params.getDerived());
        profileUtilities.removeStatusExtensions(outcome);
        // --- LM Added this
        cursors.diffCursor = params.getDifferential().getElement().indexOf(diffItem) + 1;
        if (!outcome.getType().isEmpty() && (/*outcome.getType().get(0).getCode().equals("Extension") || */params.getDifferential().getElement().size() > cursors.diffCursor) && outcome.getPath().contains(".")/* && isDataType(outcome.getType())*/) {  // don't want to do this for the root, since that's base, and we're already processing it
          if (!profileUtilities.baseWalksInto(cursors.base.getElement(), cursors.baseCursor)) {
            if (params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), diffMatches.get(0).getPath() + ".")) {
              if (outcome.getType().size() > 1)
                for (ElementDefinition.TypeRefComponent t : outcome.getType()) {
                  if (!t.getCode().equals("Reference"))
                    throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__AND_MULTIPLE_TYPES__IN_PROFILE_, diffMatches.get(0).getPath(), params.getDifferential().getElement().get(cursors.diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), params.getProfileName()));
                }
              ElementDefinition.TypeRefComponent t = outcome.getType().get(0);
              if (t.getCode().equals("BackboneElement")) {
                int baseStart = cursors.base.getElement().indexOf(currentBase) + 1;
                int baseMax = baseStart + 1;
                while (baseMax < cursors.base.getElement().size() && cursors.base.getElement().get(baseMax).getPath().startsWith(currentBase.getPath() + "."))
                  baseMax++;
                int start = cursors.diffCursor;
                while (params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), diffMatches.get(0).getPath() + "."))
                  cursors.diffCursor++;
                processPaths(
                  params.incrementDebugIndent().withBaseLimit(baseMax - 1)
                    .withDiffLimit(cursors.diffCursor - 1)
                    .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, 0))
                    .withContextPathSource(cursors.base.getElement().get(0).getPath())
                    .withContextPathTarget(cursors.base.getElement().get(0).getPath())
                    .withSlicing(new PathSlicingParams()),
                  new ProfilePathProcessorState(cursors.base, baseStart, start - 1,
                    cursors.contextName, cursors.resultPathBase));
              } else {
                StructureDefinition dt = profileUtilities.getProfileForDataType(outcome.getType().get(0), params.getWebUrl(), params.getDerived());
                //                if (t.getCode().equals("Extension") && t.hasProfile() && !t.getProfile().contains(":")) {
                // lloydfix                  dt =
                //                }
                if (dt == null)
                  throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants._HAS_CHILDREN__FOR_TYPE__IN_PROFILE__BUT_CANT_FIND_TYPE, diffMatches.get(0).getPath(), params.getDifferential().getElement().get(cursors.diffCursor).getPath(), profileUtilities.typeCode(outcome.getType()), params.getProfileName()));
                cursors.contextName = dt.getUrl();
                int start = cursors.diffCursor;
                while (params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), diffMatches.get(0).getPath() + "."))
                  cursors.diffCursor++;
                processPaths(
                  params
                    .incrementDebugIndent()
                    .withBaseLimit(dt.getSnapshot().getElement().size() - 1)
                    .withDiffLimit(cursors.diffCursor - 1)
                    .withWebUrl(profileUtilities.getWebUrl(dt, params.getWebUrl()))
                    .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, 0))
                    .withContextPathSource(diffMatches.get(0).getPath()).withContextPathTarget(outcome.getPath()).withSlicing(new PathSlicingParams()),     /* starting again on the data type, but skip the root */
                  new ProfilePathProcessorState(dt.getSnapshot(), 1 /* starting again on the data type, but skip the root */, start - 1,
                    cursors.contextName, cursors.resultPathBase));
              }
            }
          }
        }
        // ---
        diffpos++;
      }
    }
    cursors.baseCursor++;
  }

  private void processPathWithSlicedBaseWhereDiffsConstrainTypes(String currentBasePath, List<ElementDefinition> diffMatches, List<TypeSlice> typeList, ProfilePathProcessorBase params, ProfilePathProcessorState cursors) {
    int start = 0;
    int newBaseLimit = profileUtilities.findEndOfElement(cursors.base, cursors.baseCursor);
    int newDiffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(0));
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
        params.getDifferential().getElement().add(newDiffCursor, ed);
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
        params.getDifferential().getElement().add(newDiffCursor, ed);
        elementToRemove = ed;
      }
    }
    int newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), newDiffCursor);
    // the first element is setting up the slicing

    if (diffMatches.get(0).getSlicing().hasOrdered()) {
      if (diffMatches.get(0).getSlicing().getOrdered()) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGORDERED__TRUE, currentBasePath, params.getUrl()));
      }
    }
    if (diffMatches.get(0).getSlicing().hasDiscriminator()) {
      if (diffMatches.get(0).getSlicing().getDiscriminator().size() != 1) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORCOUNT__1, currentBasePath, params.getUrl()));
      }
      if (diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getType() != ElementDefinition.DiscriminatorType.TYPE) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORTYPE__TYPE, currentBasePath, params.getUrl()));
      }
      if (!"$this".equals(diffMatches.get(0).getSlicing().getDiscriminatorFirstRep().getPath())) {
        throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__IN__TYPE_SLICING_WITH_SLICINGDISCRIMINATORPATH__THIS, currentBasePath, params.getUrl()));
      }
    }
    // check the slice names too while we're at it...
    for (TypeSlice ts : typeList) {
      if (ts.type != null) {
        String tn = profileUtilities.rootName(currentBasePath) + Utilities.capitalize(ts.type);
        if (!ts.defn.hasSliceName()) {
          ts.defn.setSliceName(tn);
        } else if (!ts.defn.getSliceName().equals(tn)) {
          throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_NAME_MUST_BE__BUT_IS_, (!Utilities.noString(params.getContextPathSource()) ? params.getContextPathSource() : currentBasePath), tn, ts.defn.getSliceName()));
        }
        if (!ts.defn.hasType()) {
          ts.defn.addType().setCode(ts.type);
        } else if (ts.defn.getType().size() > 1) {
          throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_MORE_THAN_ONE_TYPE_, (!Utilities.noString(params.getContextPathSource()) ? params.getContextPathSource() : currentBasePath), tn, ts.defn.typeSummary()));
        } else if (!ts.defn.getType().get(0).getCode().equals(ts.type)) {
          throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.ERROR_AT_PATH__SLICE_FOR_TYPE__HAS_WRONG_TYPE_, (!Utilities.noString(params.getContextPathSource()) ? params.getContextPathSource() : currentBasePath), tn, ts.defn.typeSummary()));
        }
      }
    }

    // ok passed the checks.
    // copy the root diff, and then process any children it has
    ElementDefinition e = processPaths(
      params
        .incrementDebugIndent()
        .withBaseLimit(newBaseLimit)
        .withDiffLimit(newDiffLimit)
        .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches,0))
        .withSlicing(new PathSlicingParams(true, null, currentBasePath)),
      new ProfilePathProcessorState(cursors.base, cursors.baseCursor, newDiffCursor,
        cursors.contextName, cursors.resultPathBase));
    if (e == null)
      throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.DID_NOT_FIND_TYPE_ROOT_, diffMatches.get(0).getPath()));
    // now set up slicing on the e (cause it was wiped by what we called.
    e.setSlicing(new ElementDefinition.ElementDefinitionSlicingComponent());
    e.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.TYPE).setPath("$this");
    e.getSlicing().setRules(ElementDefinition.SlicingRules.CLOSED); // type slicing is always closed; the differential might call it open, but that just means it's not constraining the slices it doesn't mention
    e.getSlicing().setOrdered(false);
    start++;

    String fixedType = null;
    List<BaseTypeSlice> baseSlices = profileUtilities.findBaseSlices(cursors.base, newBaseLimit);
    // now process the siblings, which should each be type constrained - and may also have their own children. they may match existing slices
    // now we process the base scope repeatedly for each instance of the item in the differential list
    for (int i = start; i < diffMatches.size(); i++) {
      String type = profileUtilities.determineFixedType(diffMatches, fixedType, i);
      // our processing scope for the differential is the item in the list, and all the items before the next one in the list
      if (diffMatches.get(i).getMin() > 0) {
        if (diffMatches.size() > i + 1) {
          throw new FHIRException(profileUtilities.getContext().formatMessage(I18nConstants.INVALID_SLICING__THERE_IS_MORE_THAN_ONE_TYPE_SLICE_AT__BUT_ONE_OF_THEM__HAS_MIN__1_SO_THE_OTHER_SLICES_CANNOT_EXIST, diffMatches.get(i).getPath(), diffMatches.get(i).getSliceName()));
        }
        fixedType = type;
      }
      newDiffCursor = params.getDifferential().getElement().indexOf(diffMatches.get(i));
      newDiffLimit = profileUtilities.findEndOfElement(params.getDifferential(), newDiffCursor);
      int sStart = cursors.baseCursor;
      int sEnd = newBaseLimit;
      BaseTypeSlice bs = profileUtilities.chooseMatchingBaseSlice(baseSlices, type);
      if (bs != null) {
        sStart = bs.getStart();
        sEnd = bs.getEnd();
        bs.setHandled(true);
      }
      processPaths(
        params
          .incrementDebugIndent()
          .withBaseLimit(sEnd)
          .withDiffLimit(newDiffLimit)
          .withProfileName(params.getProfileName() + profileUtilities.pathTail(diffMatches, i))
          .withSlicing(new PathSlicingParams(true, e, currentBasePath)),
        new ProfilePathProcessorState(cursors.base, sStart, newDiffCursor, cursors.contextName, cursors.resultPathBase));
    }
    if (elementToRemove != null) {
      params.getDifferential().getElement().remove(elementToRemove);
      newDiffLimit--;
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
        processPaths(
          params
            .incrementDebugIndent()
            .withDifferential(fakeDiff)
            .withBaseLimit(bs.getEnd())
            .withDiffLimit(0)
            .withProfileName(params.getProfileName() + profileUtilities.tail(bs.getDefn().getPath())).withSlicing(new PathSlicingParams(true, e, currentBasePath)),
          new ProfilePathProcessorState(cursors.base, bs.getStart(), 0, cursors.contextName, cursors.resultPathBase));

      }
    }
    // ok, done with that - next in the base list
    cursors.baseCursor = baseSlices.get(baseSlices.size() - 1).getEnd() + 1;
    cursors.diffCursor = newDiffLimit + 1;
    //throw new Error("not done yet - slicing / types @ "+cpath);
  }

  private void processPathWithSlicedBaseAndEmptyDiffMatches(ElementDefinition currentBase, String currentBasePath, List<ElementDefinition> diffMatches, ProfilePathProcessorBase params, ProfilePathProcessorState cursors, String path) {
    if (profileUtilities.hasInnerDiffMatches(params.getDifferential(), path, cursors.diffCursor, params.getDiffLimit(), cursors.base.getElement(), true)) {
      // so we just copy it in
      ElementDefinition outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), currentBase.copy());
      outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
      profileUtilities.updateFromBase(outcome, currentBase, params.getSourceStructureDefinition().getUrl());
      profileUtilities.markDerived(outcome);
      if (cursors.resultPathBase == null)
        cursors.resultPathBase = outcome.getPath();
      else if (!outcome.getPath().startsWith(cursors.resultPathBase))
        throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH));
      params.getResult().getElement().add(outcome);
      // the profile walks into this, so we need to as well
      // did we implicitly step into a new type?
      if (profileUtilities.baseHasChildren(cursors.base, currentBase)) { // not a new type here
        processPaths(
          params
            .incrementDebugIndent()
            .withSlicing(new PathSlicingParams()),
          new ProfilePathProcessorState(cursors.base, cursors.baseCursor + 1, cursors.diffCursor, cursors.contextName, cursors.resultPathBase));
        cursors.baseCursor = profileUtilities.indexOfFirstNonChild(cursors.base, currentBase, cursors.baseCursor, params.getBaseLimit());
      } else {
        StructureDefinition dt = profileUtilities.getTypeForElement(params.getDifferential(), cursors.diffCursor, params.getProfileName(), diffMatches, outcome, params.getWebUrl(), params.getDerived());
        cursors.contextName = dt.getUrl();
        int start = cursors.diffCursor;
        if (params.getDifferential().getElement().get(cursors.diffCursor).getPath().equals(currentBasePath)) {
          cursors.diffCursor++;
        }
        while (params.getDifferential().getElement().size() > cursors.diffCursor && profileUtilities.pathStartsWith(params.getDifferential().getElement().get(cursors.diffCursor).getPath(), currentBasePath + ".")) {
          cursors.diffCursor++;
        }
        if (cursors.diffCursor > start) {
          processPaths(
            params
              .incrementDebugIndent()
              .withBaseLimit(dt.getSnapshot().getElement().size() - 1)
              .withDiffLimit(cursors.diffCursor - 1)
              .withWebUrl( profileUtilities.getWebUrl(dt, params.getWebUrl()))
              .withContextPathSource(currentBasePath)
              .withContextPathTarget(outcome.getPath()).withSlicing(new PathSlicingParams()),     /* starting again on the data type, but skip the root */
            new ProfilePathProcessorState(dt.getSnapshot(), 1 /* starting again on the data type, but skip the root */, start,
              cursors.contextName, cursors.resultPathBase));
        }
      }
      cursors.baseCursor++;
    }
    else {
      // the differential doesn't say anything about this item
      // copy across the currentbase, and all of its children and siblings
      while (cursors.baseCursor < cursors.base.getElement().size() && cursors.base.getElement().get(cursors.baseCursor).getPath().startsWith(path)) {
        ElementDefinition outcome = profileUtilities.updateURLs(params.getUrl(), params.getWebUrl(), cursors.base.getElement().get(cursors.baseCursor).copy());
        outcome.setPath(profileUtilities.fixedPathDest(params.getContextPathTarget(), outcome.getPath(), params.getRedirector(), params.getContextPathSource()));
        if (!outcome.getPath().startsWith(cursors.resultPathBase))
          throw new DefinitionException(profileUtilities.getContext().formatMessage(I18nConstants.ADDING_WRONG_PATH_IN_PROFILE___VS_, params.getProfileName(), outcome.getPath(), cursors.resultPathBase));
        params.getResult().getElement().add(outcome); // so we just copy it in
        outcome.setUserData(profileUtilities.BASE_MODEL, params.getSourceStructureDefinition().getUrl());
        outcome.setUserData(profileUtilities.BASE_PATH, cursors.resultPathBase);
        cursors.baseCursor++;
      }
    }
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
    return !(diffMatches.get(0).hasSlicing()
      || (profileUtilities.isExtension(diffMatches.get(0))
      && diffMatches.get(0).hasSliceName()));
  }


}
