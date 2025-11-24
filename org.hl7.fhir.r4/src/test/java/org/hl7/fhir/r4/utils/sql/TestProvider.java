package org.hl7.fhir.r4.utils.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;

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

    // Handle different reference formats.
    String resourceId = ref;

    // Strip URL prefix if present.
    if (ref.contains("/")) {
      String[] parts = ref.split("/");
      if (parts.length >= 2) {
        resourceId = parts[parts.length - 1];
      }
    }

    // Try direct lookup.
    Resource resource = resourcesById.get(ref);
    if (resource != null) {
      return resource;
    }

    // Try with just the ID part.
    resource = resourcesById.get(resourceId);
    if (resource != null) {
      // Check if resource type matches if specified.
      if (specifiedResourceType != null && !specifiedResourceType.isEmpty()) {
        String actualType = resource.getResourceType().toString();
        if (specifiedResourceType.startsWith("FHIR.")) {
          specifiedResourceType = specifiedResourceType.substring(5);
        }
        if (actualType.equals(specifiedResourceType)) {
          return resource;
        }
      } else {
        return resource;
      }
    }

    // Try with resource type prefix.
    if (specifiedResourceType != null && !specifiedResourceType.isEmpty()) {
      String typedRef = specifiedResourceType + "/" + resourceId;
      resource = resourcesById.get(typedRef);
      if (resource != null) {
        return resource;
      }
    }

    return null;
  }

  /**
   * Clear all resources.
   */
  public void clear() {
    resourcesByType.clear();
    resourcesById.clear();
  }
}