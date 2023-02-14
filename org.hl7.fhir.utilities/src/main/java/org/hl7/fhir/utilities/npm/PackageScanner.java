package org.hl7.fhir.utilities.npm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;


public class PackageScanner {

  
  public static void main(String[] args) throws IOException {
    List<String> output = new ArrayList<>();
    Set<String> packages = new HashSet<>();

    processServer(PackageServer.primaryServer(), output, packages);
    processServer(PackageServer.secondaryServer(), output, packages);
    
    StringBuilder b = new StringBuilder();
    for (String s : output) {
      b.append(s);
      b.append("\r\n");
      System.out.println(s);
    }
    TextFile.stringToFile(b.toString(), Utilities.path("[tmp]", "packages.csv"));
  }

  public static void processServer(PackageServer server, List<String> output, Set<String> packages) throws IOException {
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
            output.add(pck.name()+"\t"+pck.version()+"\t"+pck.canonical()+"\t"+fv+'\t'+pck.fhirVersionList()+'\t'+json.asString("kind")+'\t'+json.asString("type")+'\t'+JsonParser.compose(json));          } catch (Exception e) {
            System.out.println("Error acessing "+pi.getId()+"#"+piv.getVersion()+": "+e.getMessage());
            e.printStackTrace();
          }
        }
      }
      System.out.println("!");
    }
  }

}
