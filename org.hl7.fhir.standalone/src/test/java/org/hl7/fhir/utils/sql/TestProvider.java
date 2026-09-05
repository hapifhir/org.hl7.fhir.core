package org.hl7.fhir.utils.sql;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.ResourceFactory;
import org.hl7.fhir.services.sql.Provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test implementation of Provider interface for SQL on FHIR tests.
 * Stores resources in memory and provides access by resource type.
 *
 * @author John Grimes
 */
public class TestProvider implements Provider {

  private Map<String, List<Resource>> resourcesByType = new HashMap<>();
  private Map<String, Resource> resourcesById = new HashMap<>();

  /**
   * Add a resource to the provider.
   */
  public void addResource(Resource resource) {
    String resourceType = resource.getResourceType().toString();
    resourcesByType.computeIfAbsent(resourceType, k -> new ArrayList<>()).add(resource);

    // Store by ID for reference resolution.
    if (resource.hasId()) {
      String fullId = resourceType + "/" + resource.getIdElement().getIdPart();
      resourcesById.put(fullId, resource);
      // Also store without resource type prefix for relative references.
      resourcesById.put(resource.getIdElement().getIdPart(), resource);
    }
  }

  @Override
  public List<Base> fetch(String resourceType) {
    List<Base> result = new ArrayList<>();
    List<Resource> resources = resourcesByType.get(resourceType);
    if (resources != null) {
      result.addAll(resources);
    }
    return result;
  }

  @Override
  public Base resolveReference(Base rootResource, String ref, String specifiedResourceType) {
    if (ref == null || ref.isEmpty()) {
      return null;
    }

    // getReferenceKey() derives a key from the reference itself, so the target does not have to be
    // one of the resources loaded for the test: fn_reference_keys deliberately points p2 at
    // Patient/p3, which is not loaded, and expects that row to compare false rather than to be
    // empty. Resolving only against the loaded resources returned null there and the whole
    // expression collapsed to empty
    String work = ref;
    int h = work.indexOf("/_history/");
    if (h > -1) {
      work = work.substring(0, h);
    }
    String[] parts = work.split("/");
    if (parts.length < 2) {
      return null;
    }
    String resourceId = parts[parts.length - 1];
    String resourceType = parts[parts.length - 2];

    // A type specifier constrains the reference: getReferenceKey(Observation) on Patient/p1 has no
    // value at all. The previous code looked the full reference up first and returned it without
    // ever consulting the specifier, so the wrong type still produced a key
    if (specifiedResourceType != null && !specifiedResourceType.isEmpty()) {
      String wanted = specifiedResourceType.startsWith("FHIR.") ? specifiedResourceType.substring(5) : specifiedResourceType;
      if (!wanted.equals(resourceType)) {
        return null;
      }
    }

    Resource resource = resourcesById.get(resourceType + "/" + resourceId);
    if (resource != null) {
      return resource;
    }

    // Not loaded - synthesise the target, which is all the key is derived from
    try {
      return ResourceFactory.createResource(resourceType).setId(resourceId);
    } catch (Exception e) {
      return null; // not a resource type, so there is no key
    }
  }

  /**
   * Clear all resources.
   */
  public void clear() {
    resourcesByType.clear();
    resourcesById.clear();
  }
}