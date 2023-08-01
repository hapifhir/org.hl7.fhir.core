package org.hl7.fhir.r4b.utils;

import java.util.Comparator;

import org.hl7.fhir.r4b.model.CanonicalResource;

public class ResourceSorters {

  public static class CanonicalResourceSortByUrl implements Comparator<CanonicalResource> {

    @Override
    public int compare(CanonicalResource arg0, CanonicalResource arg1) {
      return arg0.getUrl().compareTo(arg1.getUrl());
    }

  }

  public static class CanonicalResourceSortByTypeId implements Comparator<CanonicalResource> {

    @Override
    public int compare(CanonicalResource arg0, CanonicalResource arg1) {
      int ret = arg0.fhirType().compareTo(arg1.fhirType());
      if (ret == 0) {
        ret = arg0.getId().compareTo(arg1.getId());
      }
      return ret;
    }

  }

}
