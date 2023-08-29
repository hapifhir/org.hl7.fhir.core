package org.hl7.fhir.convertors.misc.xver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_30;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_30;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.NpmPackageFolder;


public class CorePackageVersionConvertor {

  public interface IContentConvertor {
    byte[] convert(byte[] cnt) throws IOException;
  }

  public class BaseConvertor {
    protected String version;

    public BaseConvertor(String version) {
      super();
      this.version = version;
    }
  }

  public class ContentConverter3to4 extends BaseConvertor implements IContentConvertor {

    public ContentConverter3to4(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt);
      if (r3 instanceof org.hl7.fhir.dstu3.model.MetadataResource) {
        org.hl7.fhir.dstu3.model.MetadataResource cr = (org.hl7.fhir.dstu3.model.MetadataResource) r3;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_30_40.convertResource(r3);
      return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(r4);
    }
  }
  public class ContentConverter2to4 extends BaseConvertor implements IContentConvertor {

    public ContentConverter2to4(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu2.model.Resource r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt);      
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_10_40.convertResource(r2);
      if (r4 instanceof org.hl7.fhir.r4.model.MetadataResource) {
        org.hl7.fhir.r4.model.MetadataResource cr = (org.hl7.fhir.r4.model.MetadataResource) r4;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(r4);
    }
  }
  public class ContentConverter2Bto4 extends BaseConvertor implements IContentConvertor {

    public ContentConverter2Bto4(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu2016may.model.Resource r2 = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt);      
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_14_40.convertResource(r2);
      if (r4 instanceof org.hl7.fhir.r4.model.MetadataResource) {
        org.hl7.fhir.r4.model.MetadataResource cr = (org.hl7.fhir.r4.model.MetadataResource) r4;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(r4);
    }
  }
  public class ContentConverter5to4 extends BaseConvertor implements IContentConvertor {
    public ContentConverter5to4(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r5.model.Resource r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(cnt);
      if (r5 instanceof org.hl7.fhir.r5.model.MetadataResource) {
        org.hl7.fhir.r5.model.MetadataResource cr = (org.hl7.fhir.r5.model.MetadataResource) r5;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(r5);
      return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(r4);
    }
  }
 
  public class ContentConverter4to3 extends BaseConvertor implements IContentConvertor {

    public ContentConverter4to3(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt);
      if (r4 instanceof org.hl7.fhir.r4.model.MessageDefinition) {
        return null;
      }
      if (r4 instanceof org.hl7.fhir.r4.model.GraphDefinition) {
        return null;
      }
      if (r4 instanceof org.hl7.fhir.r4.model.TerminologyCapabilities) {
        return null;
      }
      
      if (r4 instanceof org.hl7.fhir.r4.model.MetadataResource) {
        org.hl7.fhir.r4.model.MetadataResource cr = (org.hl7.fhir.r4.model.MetadataResource) r4;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertorFactory_30_40.convertResource(r4);
      return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(r3);
    }
  }
  public class ContentConverter2to3 extends BaseConvertor implements IContentConvertor {

    public ContentConverter2to3(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu2.model.Resource r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt);      
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertorFactory_10_30.convertResource(r2);
      if (r3 instanceof org.hl7.fhir.dstu3.model.MetadataResource) {
        org.hl7.fhir.dstu3.model.MetadataResource cr = (org.hl7.fhir.dstu3.model.MetadataResource) r3;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(r3);
    }
  }
  public class ContentConverter2Bto3 extends BaseConvertor implements IContentConvertor {

    public ContentConverter2Bto3(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu2016may.model.Resource r2 = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt);  
      if (r2 instanceof org.hl7.fhir.dstu2016may.model.StructureMap) {
        return null;
      }
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertorFactory_14_30.convertResource(r2);
      if (r3 instanceof org.hl7.fhir.dstu3.model.MetadataResource) {
        org.hl7.fhir.dstu3.model.MetadataResource cr = (org.hl7.fhir.dstu3.model.MetadataResource) r3;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(r3);
    }
  }
  public class ContentConverter5to3 extends BaseConvertor implements IContentConvertor {
    public ContentConverter5to3(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r5.model.Resource r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(cnt);
      if (r5 instanceof org.hl7.fhir.r5.model.TerminologyCapabilities) {
        return null;
      }
      
      if (r5 instanceof org.hl7.fhir.r5.model.MetadataResource) {
        org.hl7.fhir.r5.model.MetadataResource cr = (org.hl7.fhir.r5.model.MetadataResource) r5;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertorFactory_30_50.convertResource(r5);
      return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(r3);
    }
  }
 
  public class ContentConverter3to5 extends BaseConvertor implements IContentConvertor {

    public ContentConverter3to5(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt);
      if (r3 instanceof org.hl7.fhir.dstu3.model.MetadataResource) {
        org.hl7.fhir.dstu3.model.MetadataResource cr = (org.hl7.fhir.dstu3.model.MetadataResource) r3;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_30_50.convertResource(r3);
      return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(r5);
    }
  }
  public class ContentConverter2to5 extends BaseConvertor implements IContentConvertor {

    public ContentConverter2to5(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu2.model.Resource r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt);      
      org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_10_50.convertResource(r2);
      if (r5 instanceof org.hl7.fhir.r5.model.MetadataResource) {
        org.hl7.fhir.r5.model.MetadataResource cr = (org.hl7.fhir.r5.model.MetadataResource) r5;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(r5);
    }
  }
  public class ContentConverter2Bto5 extends BaseConvertor implements IContentConvertor {

    public ContentConverter2Bto5(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu2016may.model.Resource r2 = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt);      
      org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_14_50.convertResource(r2);
      if (r5 instanceof org.hl7.fhir.r5.model.MetadataResource) {
        org.hl7.fhir.r5.model.MetadataResource cr = (org.hl7.fhir.r5.model.MetadataResource) r5;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(r5);
    }
  }
  public class ContentConverter4to5 extends BaseConvertor implements IContentConvertor {
    public ContentConverter4to5(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt);
      if (r4 instanceof org.hl7.fhir.r4.model.MetadataResource) {
        org.hl7.fhir.r4.model.MetadataResource cr = (org.hl7.fhir.r4.model.MetadataResource) r4;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_40_50.convertResource(r4);
      return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(r5);
    }
  }

  public class ContentConverter5to2 extends BaseConvertor implements IContentConvertor {

    public ContentConverter5to2(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r5.model.Resource r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(cnt);      
      if (r5 instanceof org.hl7.fhir.r5.model.MetadataResource) {
        org.hl7.fhir.r5.model.MetadataResource cr = (org.hl7.fhir.r5.model.MetadataResource) r5;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertorFactory_10_50.convertResource(r5);
      return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(r2);
    }
  }

  public class ContentConverter5to2B extends BaseConvertor implements IContentConvertor {

    public ContentConverter5to2B(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r5.model.Resource r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(cnt);      
      if (r5 instanceof org.hl7.fhir.r5.model.MessageDefinition) {
        return null;
      }
      if (r5 instanceof org.hl7.fhir.r5.model.GraphDefinition) {
        return null;
      }
      if (r5 instanceof org.hl7.fhir.r5.model.TerminologyCapabilities) {
        return null;
      }
      
      if (r5 instanceof org.hl7.fhir.r5.model.MetadataResource) {
        org.hl7.fhir.r5.model.MetadataResource cr = (org.hl7.fhir.r5.model.MetadataResource) r5;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu2016may.model.Resource r2 = VersionConvertorFactory_14_50.convertResource(r5);
      return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(r2);
    }
  }

  public class ContentConverter4to2 extends BaseConvertor implements IContentConvertor {

    public ContentConverter4to2(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt);      
      if (r4 instanceof org.hl7.fhir.r4.model.MetadataResource) {
        org.hl7.fhir.r4.model.MetadataResource cr = (org.hl7.fhir.r4.model.MetadataResource) r4;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertorFactory_10_40.convertResource(r4);
      return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(r2);
    }
  }

  public class ContentConverter4to2B extends BaseConvertor implements IContentConvertor {

    public ContentConverter4to2B(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt);  
      if (r4 instanceof org.hl7.fhir.r4.model.MessageDefinition) {
        return null;
      }
      if (r4 instanceof org.hl7.fhir.r4.model.GraphDefinition) {
        return null;
      }
      if (r4 instanceof org.hl7.fhir.r4.model.TerminologyCapabilities) {
        return null;
      }
      if (r4 instanceof org.hl7.fhir.r4.model.MetadataResource) {
        org.hl7.fhir.r4.model.MetadataResource cr = (org.hl7.fhir.r4.model.MetadataResource) r4;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu2016may.model.Resource r2 = VersionConvertorFactory_14_40.convertResource(r4);
      return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(r2);
    }
  }

  public class ContentConverter3to2 extends BaseConvertor implements IContentConvertor {

    public ContentConverter3to2(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt);      
      if (r3 instanceof org.hl7.fhir.dstu3.model.MetadataResource) {
        org.hl7.fhir.dstu3.model.MetadataResource cr = (org.hl7.fhir.dstu3.model.MetadataResource) r3;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertorFactory_10_30.convertResource(r3);
      return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(r2);
    }
  }

  public class ContentConverter3to2B extends BaseConvertor implements IContentConvertor {

    public ContentConverter3to2B(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt);      
      if (r3 instanceof org.hl7.fhir.dstu3.model.StructureMap) {
        return null;
      }

      if (r3 instanceof org.hl7.fhir.dstu3.model.MetadataResource) {
        org.hl7.fhir.dstu3.model.MetadataResource cr = (org.hl7.fhir.dstu3.model.MetadataResource) r3;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      org.hl7.fhir.dstu2016may.model.Resource r2 = VersionConvertorFactory_14_30.convertResource(r3);
      return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(r2);
    }
  }

  public class ContentConverter4to4 extends BaseConvertor implements IContentConvertor {

    public ContentConverter4to4(String version) {
      super(version);
    }

    @Override
    public byte[] convert(byte[] cnt) throws IOException {
      org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt);      
      if (r4 instanceof org.hl7.fhir.r4.model.MetadataResource) {
        org.hl7.fhir.r4.model.MetadataResource cr = (org.hl7.fhir.r4.model.MetadataResource) r4;
        if (!cr.hasVersion()) {
          cr.setVersion(version);          
        }
      }
      return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(r4);
    }
  }


  public static void main(String[] args) throws Exception {
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r2b.core.tgz"),  "3.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r2b.core.tgz"),  "4.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r2b.core.tgz"),  "4.3.0");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r2b.core.tgz"),  "5.0.0");

    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r3.core.tgz"),  "1.4.0");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r3.core.tgz"),  "4.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r3.core.tgz"),  "4.3.0");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r3.core.tgz"),  "5.0.0");

    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4.core.tgz"),  "1.4.0");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4.core.tgz"),  "3.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4.core.tgz"),  "4.3.0");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4.core.tgz"),  "5.0.0");

    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4b.core.tgz"),  "1.4.0");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4b.core.tgz"),  "3.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4b.core.tgz"),  "4.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r4b.core.tgz"),  "5.0.0");

    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r5.core.tgz"),  "1.4.0");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r5.core.tgz"),  "3.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r5.core.tgz"),  "4.0.1");
    new CorePackageVersionConvertor().execute(Utilities.path(args[0], "hl7.fhir.r5.core.tgz"),  "4.3.0");

  }

  public void execute(String packageSource, String versionTarget) throws Exception {
    // open the existing package 
    // chose the version converter 
    // build a new package
    System.out.println("Convert "+packageSource+" to "+versionTarget);
    
    NpmPackage src = NpmPackage.fromPackage(new FileInputStream(packageSource));
    IContentConvertor conv = contentConvertorFactory(src.fhirVersion(), versionTarget);
    
    NpmPackage dst = NpmPackage.empty();
    
    for (NpmPackageFolder folder : src.getFolders().values()) {
      for (String s : folder.getContent().keySet()) {
        byte[] cnt = folder.getContent().get(s);
        if (s.endsWith(".json")) {
          if (s.equals("package.json")) {
           cnt = convertPackage(cnt, versionTarget); 
          } else {
            String sJ = new String(cnt);
            if (sJ.contains("\"resourceType\"") && !s.equals(".index.json") && !s.endsWith(".schema.json")) {
              try {
                cnt = conv.convert(cnt);
              } catch (Exception e) {
                throw new Exception("Error processing "+folder.getFolderName()+"/"+s+": "+e.getMessage(), e);
              }
            } else {
              // nothing
            }
          }        
          if (cnt != null) {
            dst.addFile(folder.getFolderName(), s, cnt, null);
          }
        } else {
          dst.addFile(folder.getFolderName(), s, cnt, null);
        }
      }
    }
    dst.save(new FileOutputStream(Utilities.changeFileExt(packageSource, ".as."+VersionUtilities.getNameForVersion(versionTarget).toLowerCase()+".tgz")));
  }

  private IContentConvertor contentConvertorFactory(String fhirVersion, String versionTarget) throws Exception {
    if (VersionUtilities.isR3Ver(fhirVersion)) {
      if (VersionUtilities.isR4Ver(versionTarget) || VersionUtilities.isR4BVer(versionTarget)) {
        return new ContentConverter3to4(fhirVersion);
      } else if (VersionUtilities.isR5Plus(versionTarget)) {
        return new ContentConverter3to5(fhirVersion);
      } else if (VersionUtilities.isR2Ver(versionTarget)) {
        return new ContentConverter3to2(fhirVersion);
      } else if (VersionUtilities.isR2BVer(versionTarget)) {
        return new ContentConverter3to2B(fhirVersion);
      }
    } else if (VersionUtilities.isR2Ver(fhirVersion)) {
      if (VersionUtilities.isR4Ver(versionTarget) || VersionUtilities.isR4BVer(versionTarget)) {
        return new ContentConverter2to4(fhirVersion);
      } else if (VersionUtilities.isR5Plus(versionTarget)) {
        return new ContentConverter2to5(fhirVersion);
      } else if (VersionUtilities.isR3Ver(versionTarget)) {
        return new ContentConverter2to3(fhirVersion);
      }
    } else if (VersionUtilities.isR2BVer(fhirVersion)) {
      if (VersionUtilities.isR4Ver(versionTarget) || VersionUtilities.isR4BVer(versionTarget)) {
        return new ContentConverter2Bto4(fhirVersion);
      } else if (VersionUtilities.isR5Plus(versionTarget)) {
        return new ContentConverter2Bto5(fhirVersion);
      } else if (VersionUtilities.isR3Ver(versionTarget)) {
        return new ContentConverter2Bto3(fhirVersion);
      }
    } else if (VersionUtilities.isR4Ver(fhirVersion)) {
      if (VersionUtilities.isR3Ver(versionTarget)) {
        return new ContentConverter4to3(fhirVersion);
      } else if (VersionUtilities.isR5Plus(versionTarget)) {
        return new ContentConverter4to5(fhirVersion);
      } else if (VersionUtilities.isR2Ver(versionTarget)) {
        return new ContentConverter4to2(fhirVersion);
      } else if (VersionUtilities.isR4BVer(versionTarget)) {
        return new ContentConverter4to4(fhirVersion);
      } else if (VersionUtilities.isR2BVer(versionTarget)) {
        return new ContentConverter4to2B(fhirVersion);
      }
    } else if (VersionUtilities.isR4BVer(fhirVersion)) {
      if (VersionUtilities.isR3Ver(versionTarget)) {
        return new ContentConverter4to3(fhirVersion);
      } else if (VersionUtilities.isR5Plus(versionTarget)) {
        return new ContentConverter4to5(fhirVersion);
      } else if (VersionUtilities.isR4Ver(versionTarget)) {
        return new ContentConverter4to4(fhirVersion);
      } else if (VersionUtilities.isR2Ver(versionTarget)) {
        return new ContentConverter4to2(fhirVersion);
      } else if (VersionUtilities.isR2BVer(versionTarget)) {
        return new ContentConverter4to2B(fhirVersion);
      }
    } else     if (VersionUtilities.isR5Plus(fhirVersion)) {
      if (VersionUtilities.isR4Ver(versionTarget) || VersionUtilities.isR4BVer(versionTarget)) {
        return new ContentConverter5to4(fhirVersion);
      } else if (VersionUtilities.isR3Ver(versionTarget)) {
        return new ContentConverter5to3(fhirVersion);
      } else if (VersionUtilities.isR2Ver(versionTarget)) {
        return new ContentConverter5to2(fhirVersion);
      } else if (VersionUtilities.isR2BVer(versionTarget)) {
        return new ContentConverter5to2B(fhirVersion);
      }
    }
    throw new Exception("Unable to convert from "+fhirVersion+" to "+versionTarget);
  }

  private byte[] convertPackage(byte[] cnt, String version) throws IOException {
    JsonObject json = JsonParser.parseObject(cnt);
    json.remove("fhir-version-list");
    JsonArray vl = new JsonArray();
    json.add("fhirVersions", vl);
    vl.add(version);
    json.add("name", json.asString("name")+".as."+VersionUtilities.getNameForVersion(version).toLowerCase());
    json.add("title", json.asString("title")+" (as Version "+VersionUtilities.getNameForVersion(version).toLowerCase()+")");
    return JsonParser.composeBytes(json);
  }
}
