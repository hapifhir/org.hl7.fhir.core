package org.hl7.fhir.validation.instance.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.utilities.UserDataNames;

/**
 * An index of the entries in a bundle, so that references between entries can be
 * resolved without walking the entry list.
 *
 * The index is built once per bundle, as soon as the validator sees the bundle, and
 * stored in the bundle's user data. Everything that navigates the bundle should get
 * it from {@link #forBundle(Element)}.
 *
 * Note that this is built off the bundle as it is when the index is built - the
 * validator doesn't change the bundle, so the index doesn't get out of date.
 *
 * Threading: the index is built by {@link #startBuilding(Element)} - currently on the
 * calling thread, but it's set up so that the build can move to another thread. What's
 * stored in the bundle's user data is a future; startBuilding puts it there before the
 * build starts, and {@link #forBundle(Element)} waits for it. The build only reads the
 * bundle, and a finished index is never changed (the lists it returns are unmodifiable),
 * so once built, it's safe to use from any thread. (Reading an Element from more than one
 * thread relies on NamedItemList and Property building their caches safely)
 */
public class BundleIndex {

  private final Map<String, List<Element>> byFullUrl = new HashMap<>();
  private final Map<String, List<Element>> byTypeAndId = new HashMap<>();
  private final Map<Element, Integer> entryIndex = new IdentityHashMap<>();
  private final List<Element> entries = new ArrayList<>();

  private BundleIndex() {
  }

  /**
   * Start building the index for the bundle, if that hasn't already been started. Call this
   * as soon as the bundle is seen
   */
  public static void startBuilding(Element bundle) {
    getOrStart(bundle);
  }

  /**
   * Get the index for the bundle: waits for it if it's being built, or builds it now if
   * no one has started building it
   */
  public static BundleIndex forBundle(Element bundle) {
    try {
      return getOrStart(bundle).join();
    } catch (CompletionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      }
      if (e.getCause() instanceof Error) {
        throw (Error) e.getCause();
      }
      throw e;
    }
  }

  @SuppressWarnings("unchecked")
  private static CompletableFuture<BundleIndex> getOrStart(Element bundle) {
    CompletableFuture<BundleIndex> future = (CompletableFuture<BundleIndex>) bundle.getUserData(UserDataNames.validator_bundle_index);
    if (future != null) {
      return future;
    }
    boolean mine = false;
    synchronized (bundle) {
      future = (CompletableFuture<BundleIndex>) bundle.getUserData(UserDataNames.validator_bundle_index);
      if (future == null) {
        future = new CompletableFuture<>();
        bundle.setUserData(UserDataNames.validator_bundle_index, future);
        mine = true;
      }
    }
    if (mine) {
      // for now, the index is built here, on the calling thread. To build it on another thread, hand this to an executor
      // (and then, the wait in forBundle needs a timeout, and the build should respect the validation timeout)
      runBuild(bundle, future);
    }
    return future;
  }

  private static void runBuild(Element bundle, CompletableFuture<BundleIndex> future) {
    try {
      future.complete(build(bundle));
    } catch (Throwable e) {
      future.completeExceptionally(e);
    }
  }

  private static BundleIndex build(Element bundle) {
    BundleIndex index = new BundleIndex();
    int i = 0;
    for (Element entry : bundle.getChildrenByName("entry")) {
      index.entryIndex.put(entry, i++);
      index.entries.add(entry);
      // entries with no fullUrl can never be the target of a reference (all the resolution rules match on fullUrl), so they aren't indexed by fullUrl
      String fu = entry.getNamedChildValue("fullUrl", false);
      if (fu != null) {
        add(index.byFullUrl, fu, entry);
      }

      Element resource = entry.getNamedChild("resource", false);
      if (resource != null) {
        String eid = resource.getNamedChildValue("id", false);
        String rl = eid == null ? null : resource.getType() + "/" + eid;
        if (rl != null) {
          add(index.byTypeAndId, rl, entry);
        }
        Element meta = resource.getNamedChild("meta", false);
        Element versionId = meta == null ? null : meta.getNamedChild("versionId", false);
        if (versionId != null && versionId.hasValue()) {
          if (fu != null) {
            add(index.byFullUrl, fu + "/_history/" + versionId.getValue(), entry);
          }
          if (rl != null) {
            add(index.byTypeAndId, rl + "/_history/" + versionId.getValue(), entry);
          }
        }
      }
    }
    // a built index is never changed, so callers can't change the lists either
    index.byFullUrl.replaceAll((k, v) -> Collections.unmodifiableList(v));
    index.byTypeAndId.replaceAll((k, v) -> Collections.unmodifiableList(v));
    return index;
  }

  private static void add(Map<String, List<Element>> map, String key, Element entry) {
    map.computeIfAbsent(key, k -> new ArrayList<>()).add(entry);
  }

  /**
   * @return the entries with the given fullUrl (which may include /_history/[versionId]), or null if there are none.
   */
  public List<Element> getByFullUrl(String url) {
    return byFullUrl.get(url);
  }

  /**
   * @return the entries whose resource has the given Type/id (which may include /_history/[versionId]), or null if there are none.
   */
  public List<Element> getByTypeAndId(String typeAndId) {
    return byTypeAndId.get(typeAndId);
  }

  /**
   * @return the position of the entry in Bundle.entry, or -1 if it's not an entry in this bundle
   */
  public int getEntryIndex(Element entry) {
    Integer i = entryIndex.get(entry);
    return i == null ? -1 : i;
  }

  /**
   * @return the entry in this bundle that contains the element, or null if it's not in this bundle.
   *
   * Walks up the validator parent chain (see InstanceValidator.setParents), so it costs the depth of the element,
   * not the size of the bundle. If the parent chain isn't available, falls back to searching the entries
   */
  public Element getEntryForElement(Element element) {
    Element focus = element;
    while (focus != null && focus.hasParentForValidator()) {
      if (entryIndex.containsKey(focus)) {
        return focus;
      }
      focus = focus.getParentForValidator();
    }
    if (focus == null) {
      return null; // walked all the way to the root: it's not in this bundle
    }
    if (entryIndex.containsKey(focus)) {
      return focus;
    }
    // no parent chain - search the hard way
    for (Element entry : entries) {
      if (entry.hasDescendant(element)) {
        return entry;
      }
    }
    return null;
  }
}
