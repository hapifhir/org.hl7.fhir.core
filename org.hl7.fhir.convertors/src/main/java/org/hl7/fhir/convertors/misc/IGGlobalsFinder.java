package org.hl7.fhir.convertors.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.IPackageVisitorProcessor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.PackageContext;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.xml.sax.SAXException;

/**
 * Scans all known packages looking for any package that contains an ImplementationGuide
 * that declares global resources (ImplementationGuide.global), and dumps a list at the
 * end of the packages found and the globals each one declares.
 */
@SuppressWarnings("checkstyle:systemout")
public class IGGlobalsFinder implements IPackageVisitorProcessor {

  public class Global {
    private String type;
    private String profile;
    public Global(String type, String profile) {
      super();
      this.type = type;
      this.profile = profile;
    }
    public String summary() {
      return type + " -> " + profile;
    }
  }

  public class PackageGlobals {
    private String pid;
    private String igUrl;
    private List<Global> globals = new ArrayList<>();
    public PackageGlobals(String pid, String igUrl) {
      super();
      this.pid = pid;
      this.igUrl = igUrl;
    }
  }

  public static void main(String[] args) throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    new IGGlobalsFinder().execute();
  }

  private List<PackageGlobals> found = new ArrayList<>();

  private void execute() throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    PackageVisitor pv = new PackageVisitor();
    pv.setCorePackages(false);
    pv.setClientPackageServer(PackageServer.primaryServer());
    pv.setResourceTypes("ImplementationGuide");
    pv.setProcessor(this);
    pv.visitPackages();

    System.out.println("");
    System.out.println("===============================================================");
    System.out.println("Packages that declare global resources in their ImplementationGuide:");
    System.out.println("===============================================================");
    int totalGlobals = 0;
    for (PackageGlobals pg : found) {
      System.out.println(pg.pid + (pg.igUrl == null ? "" : " (" + pg.igUrl + ")"));
      for (Global g : pg.globals) {
        System.out.println("  " + g.summary());
        totalGlobals++;
      }
    }
    System.out.println("===============================================================");
    System.out.println(found.size() + " package(s) declare globals, " + totalGlobals + " global declaration(s) in total");
  }

  @Override
  public Object startPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome {
    return this;
  }

  @Override
  public void processResource(PackageContext context, Object clientContext, String type, String id, byte[] content)
      throws FHIRException, IOException, EOperationOutcome {
    if (clientContext != null && "ImplementationGuide".equals(type)) {
      JsonObject ig = JsonParser.parseObject(content);
      if (ig.has("global")) {
        List<JsonObject> globals = ig.getJsonObjects("global");
        if (!globals.isEmpty()) {
          PackageGlobals pg = new PackageGlobals(context.getPid(), ig.asString("url"));
          for (JsonObject g : globals) {
            pg.globals.add(new Global(g.asString("type"), g.asString("profile")));
          }
          found.add(pg);
          System.out.println(context.getPid() + " declares " + pg.globals.size() + " global(s)");
        }
      }
    }
  }

  @Override
  public void finishPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome {
  }

  @Override
  public void alreadyVisited(String pid) throws FHIRException, IOException, EOperationOutcome {
  }

}
