package org.hl7.fhir.convertors;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */

import org.hl7.fhir.convertors.loaders.loaderR3.R2ToR3Loader;
import org.hl7.fhir.dstu3.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.elementmodel.Manager;
import org.hl7.fhir.dstu3.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.dstu3.formats.FormatUtilities;
import org.hl7.fhir.dstu3.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.dstu3.utils.StructureMapUtilities;
import org.hl7.fhir.dstu3.utils.StructureMapUtilities.ITransformerServices;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.TextFile;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This class manages conversion from R2 to R3 and vice versa
 * <p>
 * To use this class, do the following:
 * <p>
 * - provide a stream or path (file or URL) that points to R2 definitions (from http://hl7.org/fhir/DSTU2/downloads.html)
 * - provide a stream or a path (file or URL) that points to the R3 definitions  (from http://hl7.org/fhir/STU3/downloads.html)
 * - provide a stream or a path (file or URL) that points to R2/R3 map files (from http://hl7.org/fhir/r2r3maps.zip)
 * <p>
 * - call convert() (can call this more than once, but not multithread safe)
 *
 * @author Grahame Grieve
 */
public class R2R3ConversionManager implements ITransformerServices {

  private final Map<String, StructureMap> library = new HashMap<String, StructureMap>();
  private final List<Resource> extras = new ArrayList<Resource>();
  private SimpleWorkerContext contextR2;
  private SimpleWorkerContext contextR3;
  private boolean needPrepare = false;
  private StructureMapUtilities smu3;
  private StructureMapUtilities smu2;
  private OutputStyle style = OutputStyle.PRETTY;

  public static void main(String[] args) throws IOException, FHIRException {
    if (args.length == 0 || !hasParam(args, "-d2") || !hasParam(args, "-d3") || !hasParam(args, "-maps") || !hasParam(args, "-src") || !hasParam(args, "-dest") || (!hasParam(args, "-r2") && !hasParam(args, "-r3"))) {
      System.out.println("R2 <--> R3 Convertor");
      System.out.println("====================");
      System.out.println();
      System.out.println("parameters: -d2 [r2 definitions] -d3 [r3 definitions] -maps [map source] -src [source] -dest [dest] -r2/3 - fmt [format]");
      System.out.println();
      System.out.println("d2: definitions from http://hl7.org/fhir/DSTU2/downloads.html");
      System.out.println("d3: definitions from http://hl7.org/fhir/STU3/downloads.html");
      System.out.println("maps: R2/R3 maps from http://hl7.org/fhir/r2r3maps.zip");
      System.out.println("src: filename for source to convert");
      System.out.println("dest: filename for destination of conversion");
      System.out.println("-r2: source is r2, convert to r3");
      System.out.println("-r3: source is r3, convert to r2");
      System.out.println("-fmt: xml | json (xml is default)");
    } else {
      R2R3ConversionManager self = new R2R3ConversionManager();
      self.setR2Definitions(getNamedParam(args, "-d2"));
      self.setR3Definitions(getNamedParam(args, "-d3"));
      self.setMappingLibrary(getNamedParam(args, "-maps"));
      FhirFormat fmt = hasParam(args, "-fmt") ? getNamedParam(args, "-fmt").equalsIgnoreCase("json") ? FhirFormat.JSON : FhirFormat.XML : FhirFormat.XML;
      InputStream src = new FileInputStream(getNamedParam(args, "-src"));
      OutputStream dst = new FileOutputStream(getNamedParam(args, "-dest"));
      self.convert(src, dst, hasParam(args, "-r2"), fmt);
    }
  }

  private static boolean hasParam(String[] args, String param) {
    for (String a : args)
      if (a.equals(param))
        return true;
    return false;
  }

  private static String getNamedParam(String[] args, String param) {
    boolean found = false;
    for (String a : args) {
      if (found)
        return a;
      if (a.equals(param)) {
        found = true;
      }
    }
    return null;
  }

  public OutputStyle getStyle() {
    return style;
  }

  public void setStyle(OutputStyle style) {
    this.style = style;
  }

  public List<Resource> getExtras() {
    return extras;
  }

  // set up ------------------------------------------------------------------
  public void setR2Definitions(InputStream stream) throws IOException, FHIRException {
    needPrepare = true;
    R2ToR3Loader ldr = new R2ToR3Loader();
    ldr.setPatchUrls(true).setKillPrimitives(true);
    Map<String, InputStream> files = readInputStream(stream);
    contextR2 = new SimpleWorkerContext();
    contextR2.setAllowLoadingDuplicates(true);
    contextR2.loadFromFile(files.get("profiles-types.xml"), "profiles-types.xml", ldr);
    contextR2.loadFromFile(files.get("profiles-resources.xml"), "profiles-resources.xml", ldr);
    contextR2.loadFromFile(files.get("valuesets.xml"), "valuesets.xml", ldr);
  }

  public void setR2Definitions(String source) throws IOException, FHIRException {
    File f = new File(source);
    if (f.exists())
      setR2Definitions(new FileInputStream(f));
    else
      setR2Definitions(fetch(source));
  }

  public void setR3Definitions(InputStream stream) throws IOException, FHIRException {
    needPrepare = true;
    Map<String, InputStream> files = readInputStream(stream);
    contextR3 = new SimpleWorkerContext();
    contextR2.setAllowLoadingDuplicates(true);
    contextR3.loadFromFile(files.get("profiles-types.xml"), "profiles-types.xml", null);
    contextR3.loadFromFile(files.get("profiles-resources.xml"), "profiles-resources.xml", null);
    contextR3.loadFromFile(files.get("extension-definitions.xml"), "extension-definitions.xml", null);
    contextR3.loadFromFile(files.get("valuesets.xml"), "valuesets.xml", null);
    contextR3.setCanRunWithoutTerminology(true);
  }

  public void setR3Definitions(String source) throws IOException, FHIRException {
    File f = new File(source);
    if (f.exists())
      setR3Definitions(new FileInputStream(f));
    else
      setR3Definitions(fetch(source));
  }

  public void setMappingLibrary(InputStream stream) throws IOException, FHIRException {
    needPrepare = true;
    Map<String, InputStream> files = readInputStream(stream);
    for (InputStream s : files.values()) {
      StructureMap sm = new StructureMapUtilities(contextR3).parse(TextFile.streamToString(s));
      library.put(sm.getUrl(), sm);
    }
  }

  public void setMappingLibrary(String source) throws IOException, FHIRException {
    File f = new File(source);
    if (f.exists())
      setMappingLibrary(new FileInputStream(f));
    else
      setMappingLibrary(fetch(source));
  }

  // support
  private InputStream fetch(String source) {
    throw new Error("not done yet");
  }

  private Map<String, InputStream> readInputStream(InputStream stream) throws IOException {
    Map<String, InputStream> res = new HashMap<String, InputStream>();
    ZipInputStream zip = new ZipInputStream(stream);
    ZipEntry ze = null;
    while ((ze = zip.getNextEntry()) != null) {
      String n = ze.getName();
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      for (int c = zip.read(); c != -1; c = zip.read()) {
        bs.write(c);
      }
      bs.close();
      res.put(n, new ByteArrayInputStream(bs.toByteArray()));
      zip.closeEntry();
    }
    zip.close();
    return res;
  }

  private void prepare() throws FHIRException {
    if (contextR2 == null)
      throw new FHIRException("No R2 definitions provided");
    if (contextR3 == null)
      throw new FHIRException("No R3 definitions provided");
    if (library == null)
      throw new FHIRException("No R2/R# conversion maps provided");

    if (needPrepare) {
      for (StructureDefinition sd : contextR2.allStructures()) {
        StructureDefinition sdn = sd.copy();
        sdn.getExtension().clear();
        contextR3.seeResource(sdn.getUrl(), sdn);
      }

      for (StructureDefinition sd : contextR3.allStructures()) {
        if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
          contextR2.seeResource(sd.getUrl(), sd);
          StructureDefinition sdn = sd.copy();
          sdn.setUrl(sdn.getUrl().replace("http://hl7.org/fhir/", "http://hl7.org/fhir/DSTU2/"));
          sdn.addExtension().setUrl("http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace").setValue(new UriType("http://hl7.org/fhir"));
          contextR2.seeResource(sdn.getUrl(), sdn);
          contextR3.seeResource(sdn.getUrl(), sdn);
        }
      }

      contextR2.setExpansionProfile(new ExpansionProfile().setUrl("urn:uuid:" + UUID.randomUUID().toString().toLowerCase()));
      contextR3.setExpansionProfile(new ExpansionProfile().setUrl("urn:uuid:" + UUID.randomUUID().toString().toLowerCase()));

      smu3 = new StructureMapUtilities(contextR3, library, this);
      smu2 = new StructureMapUtilities(contextR2, library, this);

      needPrepare = false;
    }
  }

  // execution
  public byte[] convert(byte[] source, boolean r2ToR3, FhirFormat format) throws FHIRException, IOException {
    prepare();
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    if (r2ToR3)
      convertToR3(new ByteArrayInputStream(source), bs, format);
    else
      convertToR2(new ByteArrayInputStream(source), bs, format);
    bs.close();
    return bs.toByteArray();
  }

  public void convert(InputStream source, OutputStream dest, boolean r2ToR3, FhirFormat format) throws FHIRException, IOException {
    prepare();
    if (r2ToR3)
      convertToR3(source, dest, format);
    else
      convertToR2(source, dest, format);
  }

  public org.hl7.fhir.dstu2.model.Resource convert(org.hl7.fhir.dstu3.model.Resource source) throws IOException, FHIRException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    new JsonParser().compose(bs, source);
    bs.close();
    return new org.hl7.fhir.dstu2.formats.JsonParser().parse(convert(bs.toByteArray(), false, FhirFormat.JSON));
  }

  public org.hl7.fhir.dstu3.model.Resource convert(org.hl7.fhir.dstu2.model.Resource source) throws IOException, FHIRException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    new org.hl7.fhir.dstu2.formats.JsonParser().compose(bs, source);
    bs.close();
    return new JsonParser().parse(convert(bs.toByteArray(), false, FhirFormat.JSON));
  }

  private void convertToR3(InputStream source, OutputStream dest, FhirFormat format) throws FHIRException, IOException {
    org.hl7.fhir.dstu3.elementmodel.Element r2 = new org.hl7.fhir.dstu3.elementmodel.XmlParser(contextR2).parse(source);
    StructureMap map = library.get("http://hl7.org/fhir/StructureMap/" + r2.fhirType() + "2to3");
    if (map == null)
      throw new FHIRException("No Map Found from R2 to R3 for " + r2.fhirType());
    String tn = smu3.getTargetType(map).getType();
    Resource r3 = ResourceFactory.createResource(tn);
    smu3.transform(new TransformContextR2R3(contextR3, r2.getChildValue("id")), r2, map, r3);
    FormatUtilities.makeParser(format).setOutputStyle(style).compose(dest, r3);
  }

  private void convertToR2(InputStream source, OutputStream dest, FhirFormat format) throws FHIRException, IOException {
    org.hl7.fhir.dstu3.elementmodel.Element r3 = new org.hl7.fhir.dstu3.elementmodel.XmlParser(contextR3).parse(source);
    StructureMap map = library.get("??");
    String tn = smu3.getTargetType(map).getType();
    StructureDefinition sd = smu2.getTargetType(map);
    org.hl7.fhir.dstu3.elementmodel.Element r2 = Manager.build(contextR2, sd);
    smu2.transform(contextR2, r3, map, r2);
    org.hl7.fhir.dstu3.elementmodel.Manager.compose(contextR2, r2, dest, format, style, null);
  }

  @Override
  public void log(String message) {
//    System.out.println(message);
  }

  @Override
  public Base createType(Object appInfo, String name) throws FHIRException {
    SimpleWorkerContext context = ((TransformContextR2R3) appInfo).getContext();
    if (context == contextR2) {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/DSTU2/StructureDefinition/" + name);
      if (sd == null)
        throw new FHIRException("Type not found: '" + name + "'");
      return Manager.build(context, sd);
    } else
      return ResourceFactory.createResourceOrType(name);
  }

  @Override
  public Base createResource(Object appInfo, Base res) {
    if (res instanceof Resource && (res.fhirType().equals("CodeSystem") || res.fhirType().equals("CareTeam")) || res.fhirType().equals("PractitionerRole")) {
      Resource r = (Resource) res;
      extras.add(r);
      r.setId(((TransformContextR2R3) appInfo).getId() + "-" + extras.size()); //todo: get this into appinfo
    }
    return res;
  }

  @Override
  public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
    throw new Error("translate not done yet");
  }

  @Override
  public Base resolveReference(Object appContext, String url) {
    for (Resource r : extras) {
      if (r instanceof MetadataResource) {
        MetadataResource mr = (MetadataResource) r;
        if (url.equals(mr.getUrl()))
          return mr;
      }
      if (url.equals(r.fhirType() + "/" + r.getId()))
        return r;
    }

    return null;
  }

  @Override
  public List<Base> performSearch(Object appContext, String url) {
    List<Base> results = new ArrayList<Base>();
    String[] parts = url.split("\\?");
    if (parts.length == 2 && parts[0].substring(1).equals("PractitionerRole")) {
      String[] vals = parts[1].split("\\=");
      if (vals.length == 2 && vals[0].equals("practitioner"))
        for (Resource r : extras) {
          if (r instanceof PractitionerRole && ((PractitionerRole) r).getPractitioner().getReference().equals("Practitioner/" + vals[1])) {
            results.add(r);
          }
        }
    }
    return results;
  }
}