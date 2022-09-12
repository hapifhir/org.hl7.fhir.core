package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.context.IWorkerContext.PackageVersion;

public class PackageHackerR5 {

  public static void fixLoadedResource(CanonicalResourceProxy r, PackageVersion packageInfo) {
   if ("http://terminology.hl7.org/CodeSystem/v2-0391|2.6".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0391-2.6", "2.6");
   }
   if ("http://terminology.hl7.org/CodeSystem/v2-0391|2.4".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0391-2.4", "2.4");
   }
   if ("http://terminology.hl7.org/CodeSystem/v2-0360|2.7".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0360-2.7", "2.7");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0006|2.1".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0006-2.1", "2.1");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0360|2.7".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0360-2.7", "2.7");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0006|2.4".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0006-2.4", "2.4");
   }

   if ("http://terminology.hl7.org/CodeSystem/v2-0360|2.3.1".equals(r.getUrl())) {
     r.hack("http://terminology.hl7.org/CodeSystem/v2-0360-2.3.1", "2.3.1");
   }

   if (r.hasUrl() && r.getUrl().contains("|")) {
     assert false;
   }
  }

}
