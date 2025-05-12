package org.hl7.fhir.r5.utils;

import java.util.Comparator;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class ResourceSorters {

  public static class CanonicalResourceSortByUrl implements Comparator<CanonicalResource> {

    @Override
    public int compare(CanonicalResource arg0, CanonicalResource arg1) {
      if (arg0.getUrl() != null && arg1.getUrl() != null) {
        return arg0.getUrl().compareTo(arg1.getUrl());        
      } else if (arg1.getUrl() != null) {
        return -1;        
      } else if (arg0.getUrl() != null) {
        return 1;        
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
