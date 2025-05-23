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
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.xml.sax.SAXException;

@SuppressWarnings("checkstyle:systemout")
public class MustSupportSlicingFinder implements IPackageVisitorProcessor {


  public class Issue {
    private String pvid;
    private String url;
    private String path;
    private String ref;
    private boolean ms;
    private boolean smsOne;
    private boolean smsAll;
    private int sliceCount;
    public Issue(String pvid, String url, String path, String ref, boolean ms, int sliceCount, boolean smsOne, boolean smsAll) {
      super();
      this.pvid = pvid;
      this.url = url;
      this.path = path;
      this.ref = ref;
      this.ms = ms;
      this.sliceCount = sliceCount;
      this.smsOne = smsOne;
      this.smsAll = smsAll;
    }
    public String summary() {
      return url+"#"+path+": "+meaning()+" from "+pvid+" @ "+ref;
    }

    public String meaning() {
      if (!ms) {
        if (sliceCount == 1) {
          count1++;
          return "slicer MustSupport = false, but the only slice is must-support";          
        } else if (sliceCount > 1) {
          if (smsAll) {
            count2++;
            return "slicer MustSupport = false, but all "+sliceCount+" slices are must-support";
          } else {
            count3++;
            return "slicer MustSupport = false, but some of "+sliceCount+" slices are must-support";            
          }
        } else {
          count4++;
          return "slicer MustSupport = false, and there are no slices"; 
        }
      } else if (!smsOne) {
        if (sliceCount == 0) {
          count5++;
          return "slicer MustSupport = true, no slices";
        } else if (sliceCount == 1) {
          count6++;
          return "slicer MustSupport = true, but the slice is not must-support";
        } else {
          count7++;
          return "slicer MustSupport = true, but all "+sliceCount+" slices are not must-support";
        }
      } else {
        if (sliceCount == 1) {
          count8++;
          return "slicer MustSupport = true, and the slice is must-support";
        } else {
          count9++;
          return "slicer MustSupport = true, and some of  "+sliceCount+" slices are must-support";
        }        
      }
    }
  }

  public static void main(String[] args) throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    new MustSupportSlicingFinder().execute();
  }

  List<Issue> issues = new ArrayList<>();
  public int count1 = 0;
  public int count2 = 0;
  public int count3 = 0;
  public int count4 = 0;
  public int count5 = 0;
  public int count6 = 0;
  public int count7 = 0;
  public int count8 = 0;
  public int count9 = 0;
  

  private void execute() throws FHIRException, IOException, ParserConfigurationException, SAXException, EOperationOutcome {
    PackageVisitor pv = new PackageVisitor();
    pv.setCorePackages(false);
    pv.setClientPackageServer(PackageServer.primaryServer());
    pv.setResourceTypes("StructureDefinition", "Patient", "RelatedPerson", "Practitioner", "Person");
    pv.setProcessor(this);
    pv.visitPackages();
    for (Issue s : issues) {
      System.out.println(s.summary());
    }

    System.out.println("slicer MustSupport = false, but the only slice is must-support: "+count1);          
    System.out.println("slicer MustSupport = false, but all N slices are must-support: "+count2);  
    System.out.println("slicer MustSupport = false, but some of N slices are must-support: "+count3);           
    System.out.println("slicer MustSupport = false, and there are no slices: "+count4);  
    System.out.println("slicer MustSupport = true, no slices: "+count5);  
    System.out.println("slicer MustSupport = true, but the slice is not must-support: "+count6);  
    System.out.println("slicer MustSupport = true, but all N slices are not must-support: "+count7);  
    System.out.println("slicer MustSupport = true, and the slice is must-support: "+count8);  
    System.out.println("slicer MustSupport = true, and some of  N slices are must-support: "+count9);  
  }

  @Override
  public Object startPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome {
    if (isUS(context.getNpm())) {
      System.out.println(context.getPid()+" is a US Realm package");
      return this;
    } else {
      return null;
    }
  }

  private boolean isUS(NpmPackage npm) {
    if (npm != null) {
      return npm.name().contains("hl7.fhir.us");
    }
    return false;
  }

  @Override
  public void processResource(PackageContext context, Object clientContext, String type, String id, byte[] content)
      throws FHIRException, IOException, EOperationOutcome {
    if (clientContext != null && "StructureDefinition".equals(type)) {
      JsonObject r = JsonParser.parseObject(content);
      for (JsonObject ed : r.forceObject("snapshot").forceArray("element").asJsonObjects()) {
        if (ed.has("slicing")) {
          boolean smsOne = false;
          boolean smsAll = true;
          int count = 0;
          String eid = ed.asString("id");
          for (JsonObject slice : r.forceObject("snapshot").forceArray("element").asJsonObjects()) {
            if (slice.has("sliceName") && slice.has("id") && slice.asString("id").equals(eid+":"+slice.asString("sliceName"))) {
              count++;
              smsOne = smsOne || slice.asBoolean("mustSupport");
              smsAll = smsAll && slice.asBoolean("mustSupport");
            }
          }
          
          if (count > 0 && (ed.asBoolean("mustSupport") || smsOne)) {
            issues.add(new Issue(context.getPid()+"#"+context.getPid(), r.asString("url")+"|"+r.asString("version"), ed.asString("path"), context.getNpm().getWebLocation(),
                ed.asBoolean("mustSupport"), count, smsOne, smsAll));
          }
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
