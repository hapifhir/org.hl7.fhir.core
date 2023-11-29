package org.hl7.fhir.r5.utils;

import java.util.Comparator;

import org.hl7.fhir.r5.model.CanonicalResource;

public class ResourceSorters {

  public static class CanonicalResourceSortByUrl implements Comparator<CanonicalResource> {

    @Override
    public int compare(CanonicalResource arg0, CanonicalResource arg1) {
      if (arg0.getUrl() != null) {
        return arg0.getUrl().compareTo(arg1.getUrl());        
      } else if (arg1.getUrl() != null) {
        return -arg1.getUrl().compareTo(arg0.getUrl());        
      } else {
        return 0;
      }
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
