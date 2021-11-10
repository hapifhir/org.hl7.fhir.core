package org.hl7.fhir.utilities.npm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.json.JSONUtil;
import org.hl7.fhir.utilities.json.JsonTrackingParser;

import com.google.gson.JsonObject;

public class PackageScanner {

  
  public static void main(String[] args) throws IOException {
    List<String> output = new ArrayList<>();
    Set<String> packages = new HashSet<>();

    processServer("http://packages.fhir.org", output, packages);
    processServer("http://packages2.fhir.org/packages", output, packages);
    
    StringBuilder b = new StringBuilder();
    for (String s : output) {
      b.append(s);
      b.append("\r\n");
      System.out.println(s);
    }
    TextFile.stringToFile(b.toString(), "c:\\temp\\packages.csv");
  }

  public static void processServer(String server, List<String> output, Set<String> packages) throws IOException {
    System.out.println("Server: "+server);
    PackageClient client = new PackageClient(server);
    List<PackageInfo> list = client.search(null, null, null, false);
    output.add("id\tversion\tcanonica\tfhir version\tfhir-versions\tkind\ttype\tsource");
    for (PackageInfo pi : list) {
      System.out.print("  fetch: "+pi.getId());
      List<PackageInfo> versions = null;
      while (versions == null) {
        System.out.print("-");
        try {
          versions = client.getVersions(pi.getId());
        } catch (Exception e) {
          // nothing
        }
      }
      for (PackageInfo piv : versions) {
        if (!packages.contains(pi.getId()+"#"+piv.getVersion())) {
          packages.add(pi.getId()+"#"+piv.getVersion());
          try {
            System.out.print(".");
            InputStream cnt = client.fetch(pi.getId(), piv.getVersion());
            NpmPackage pck = NpmPackage.fromPackage(cnt);
            JsonObject json = pck.getNpm();
            String fv;
            try {
              fv = pck.fhirVersion();
            } catch (Exception e) {
              fv = "--";
            }
            output.add(pck.name()+"\t"+pck.version()+"\t"+pck.canonical()+"\t"+fv+'\t'+pck.fhirVersionList()+'\t'+JSONUtil.str(json, "kind")+'\t'+JSONUtil.str(json, "type")+'\t'+JsonTrackingParser.writeDense(json));          } catch (Exception e) {
            System.out.println("Error acessing "+pi.getId()+"#"+piv.getVersion()+": "+e.getMessage());
            e.printStackTrace();
          }
        }
      }
      System.out.println("!");
    }
  }

}
