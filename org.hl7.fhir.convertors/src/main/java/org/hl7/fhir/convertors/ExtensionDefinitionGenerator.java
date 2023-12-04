package org.hl7.fhir.convertors;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.loaders.loaderR4.R2016MayToR4Loader;
import org.hl7.fhir.convertors.loaders.loaderR4.R2ToR4Loader;
import org.hl7.fhir.convertors.loaders.loaderR4.R3ToR4Loader;
import org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.context.BaseWorkerContext;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r4.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.r4.utils.NPMPackageGenerator;
import org.hl7.fhir.r4.utils.NPMPackageGenerator.Category;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.hl7.fhir.utilities.npm.ToolsVersion;

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


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ExtensionDefinitionGenerator {

  private FHIRVersion sourceVersion;
  private FHIRVersion targetVersion;
  private String filename;
  private StructureDefinition extbase;
  private ElementDefinition extv;
  private ProfileUtilities pu;
  private BaseWorkerContext context;

  public static void main(String[] args) throws IOException, FHIRException {
    if (args.length == 0) {
      System.out.println("Extension Generator");
      System.out.println("===================");
      System.out.println();
      System.out.println("See http://hl7.org/fhir/versions.html#extensions. This generates the packages");
      System.out.println();
      System.out.println("parameters: -srcver [version] -tgtver [version] -package [filename]");
      System.out.println();
      System.out.println("srcver: the source version to load");
      System.out.println("tgtver: the version to generate extension definitions for");
      System.out.println("package: the package to produce");
    } else {
      ExtensionDefinitionGenerator self = new ExtensionDefinitionGenerator();
      self.setSourceVersion(FHIRVersion.fromCode(getNamedParam(args, "-srcver")));
      self.setTargetVersion(FHIRVersion.fromCode(getNamedParam(args, "-tgtver")));
      self.setFilename(getNamedParam(args, "-package"));
      self.generate();
    }
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
    throw new Error("Unable to find parameter " + param);
  }

  public FHIRVersion getSourceVersion() {
    return sourceVersion;
  }

  public void setSourceVersion(FHIRVersion sourceVersion) {
    this.sourceVersion = sourceVersion;
  }

  public FHIRVersion getTargetVersion() {
    return targetVersion;
  }

  public void setTargetVersion(FHIRVersion targetVersion) {
    this.targetVersion = targetVersion;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }


  private void generate() throws IOException, FHIRException {
    List<StructureDefinition> definitions = loadSource();
    List<StructureDefinition> extensions = buildExtensions(definitions);
    for (StructureDefinition ext : extensions)
      pu.generateSnapshot(extbase, ext, ext.getUrl(), "http://hl7.org/fhir/R4", ext.getName());
    savePackage(extensions);

  }

  private List<StructureDefinition> buildExtensions(List<StructureDefinition> definitions) throws FHIRException {
    Set<String> types = new HashSet<>();
    List<StructureDefinition> list = new ArrayList<>();
    for (StructureDefinition type : definitions)
      if (type.getDerivation() == TypeDerivationRule.SPECIALIZATION && !type.getName().contains(".") && !types.contains(type.getName()) && type.getKind() != StructureDefinitionKind.PRIMITIVETYPE && !Utilities.existsInList(type.getName(), "Extension", "Narrative")) {
        types.add(type.getName());
        buildExtensions(type, list);
      }
    return list;
  }


  private void buildExtensions(StructureDefinition type, List<StructureDefinition> list) throws FHIRException {
    for (ElementDefinition ed : type.getDifferential().getElement()) {
      if (ed.getPath().contains(".")) {
        if (!ed.getPath().endsWith(".extension") && !ed.getPath().endsWith(".modifierExtension")) {
          StructureDefinition ext = generateExtension(type, ed);
          if (ext != null) {
            list.add(ext);
            context.cacheResource(ext);
          }
        }
      }
    }
  }

  private StructureDefinition generateExtension(StructureDefinition type, ElementDefinition ed) throws FHIRException {
    StructureDefinition ext = new StructureDefinition();
    ext.setId("extension-" + ed.getPath().replace("[x]", ""));
    ext.setUrl("http://hl7.org/fhir/" + sourceVersion.toCode().substring(0, 3) + "/StructureDefinition/" + ext.getId());
    if (ext.getId().length() > 64)
      ext.setId(contract(ext.getId()));
    ext.setVersion(sourceVersion.toCode());
    ext.setName("ExtensionR" + sourceVersion.toCode().substring(0, 1) + ed.getPath().replace(".", ""));
    ext.setTitle("Extension definition for R" + sourceVersion.toCode().substring(0, 1) + " element " + ed.getPath());
    ext.setStatus(PublicationStatus.ACTIVE);
    ext.setDate(type.getDate());
    ext.setFhirVersion(type.getFhirVersion());
    ext.setDescription(ed.getDefinition());
    ext.setKind(StructureDefinitionKind.COMPLEXTYPE);
    ext.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Extension");
    ext.setDerivation(TypeDerivationRule.CONSTRAINT);
    if (ed.hasType() && ("Element".equals(ed.getType().get(0).getCode()) || "BackboneElement".equals(ed.getType().get(0).getCode()))) {
      ElementDefinition v = ed.copy();
      v.setPath("Extension");
      v.getType().clear();
      v.setIsSummaryElement(null);
      ext.getDifferential().addElement(v);
      List<ElementDefinition> children = ProfileUtilities.getChildList(type, ed);
      for (ElementDefinition child : children) {
        String n = tail(child.getPath());
        if (!Utilities.existsInList(n, "id", "extension", "modifierExtension") && !hasNonValidType(child)) {
          v = child.copy();
          v.setId("Extension.extension:" + n);
          v.setPath("Extension.extension");
          v.setSliceName(n);
          v.getType().clear();
          v.setIsSummaryElement(null);
          v.addType().setCode("Extension").addProfile("http://hl7.org/fhir/" + sourceVersion.toCode().substring(0, 3) + "/StructureDefinition/extension-" + child.getPath().replace("[x]", ""));
          ext.getDifferential().addElement(v);
        }
      }
      ext.getDifferential().addElement(genElement("Extension.url").setFixed(new UriType(ext.getUrl())));
      ext.getDifferential().addElement(genElement("Extension.value[x]").setMax("0"));

    } else if (ed.hasType() && Utilities.existsInList(ed.getType().get(0).getCode(), "Resource", "Narrative")) {
      return null;
    } else if (ed.hasType() && !goesInExtension(ed.getType().get(0).getCode())) {
      ElementDefinition v = ed.copy();
      v.setPath("Extension");
      v.getType().clear();
      v.setIsSummaryElement(null);
      ext.getDifferential().addElement(v);
      List<ElementDefinition> children = ProfileUtilities.getChildList(type, ed);
      for (ElementDefinition child : children) {
        String n = tail(child.getPath());
        if (!Utilities.existsInList(n, "id", "extension", "modifierExtension") && !hasNonValidType(child)) {
          v = child.copy();
          v.setId("Extension.extension:" + n);
          v.setPath("Extension.extension");
          v.setSliceName(n);
          v.getType().clear();
          v.setIsSummaryElement(null);
          v.addType().setCode("Extension").addProfile("http://hl7.org/fhir/" + sourceVersion.toCode().substring(0, 3) + "/StructureDefinition/extension-" + child.getPath().replace("[x]", ""));
          ext.getDifferential().addElement(v);
        }
      }
      ext.getDifferential().addElement(genElement("Extension.url").setFixed(new UriType(ext.getUrl())));
      ext.getDifferential().addElement(genElement("Extension.value[x]").setMax("0"));
    } else {
      // simple type...
      ElementDefinition v = ed.copy();
      v.setPath("Extension");
      v.getType().clear();
      v.setIsSummaryElement(null);
      ext.getDifferential().addElement(v);
      ext.getDifferential().addElement(genElement("Extension.extension").setMax("0"));
      ext.getDifferential().addElement(genElement("Extension.url").setFixed(new UriType(ext.getUrl())));
      v = ed.copy();
      v.setPath("Extension.value[x]");
      v.setId("Extension.value");
      v.setMax("1");
      v.setIsSummaryElement(null);
      ext.getDifferential().addElement(v);
    }
    return ext;
  }

  private boolean hasNonValidType(ElementDefinition ed) {
    return ed.hasType() && Utilities.existsInList(ed.getType().get(0).getCode(), "Resource", "Narrative");
  }


  private boolean goesInExtension(String code) {
    if (code == null)
      return true;
    for (TypeRefComponent tr : extv.getType()) {
      if (code.equals(tr.getCode()))
        return true;
    }
    return false;
  }


  private String tail(String path) {
    return path.substring(path.lastIndexOf(".") + 1);
  }


  private ElementDefinition genElement(String path) {
    return new ElementDefinition().setPath(path);
  }


  private String contract(String id) {
    List<StringReplacement> abbrevs = new ArrayList<>();
    abbrevs.add(new StringReplacement("AdverseEvent", "AE"));
    abbrevs.add(new StringReplacement("CoverageEligibilityResponse", "CERsp"));
    abbrevs.add(new StringReplacement("CoverageEligibilityRequest", "CEReq"));
    abbrevs.add(new StringReplacement("EffectEvidenceSynthesis", "EES"));
    abbrevs.add(new StringReplacement("ExplanationOfBenefit", "EoB"));
    abbrevs.add(new StringReplacement("ImmunizationRecommendation", "IR"));
    abbrevs.add(new StringReplacement("MeasureReport", "MR"));
    abbrevs.add(new StringReplacement("MedicationKnowledge", "MK"));
    abbrevs.add(new StringReplacement("CapabilityStatement", "CS"));
    abbrevs.add(new StringReplacement("ChargeItemDefinition", "CID"));
    abbrevs.add(new StringReplacement("ClaimResponse", "CR"));
    abbrevs.add(new StringReplacement("InsurancePlan", "IP"));
    abbrevs.add(new StringReplacement("MedicationRequest", "MR"));
    abbrevs.add(new StringReplacement("MedicationOrder", "MO"));
    abbrevs.add(new StringReplacement("MedicationDispense", "MD"));
    abbrevs.add(new StringReplacement("NutritionOrder", "NO"));
    abbrevs.add(new StringReplacement("MedicinalProductAuthorization", "MPA"));
    abbrevs.add(new StringReplacement("MedicinalProductContraindication", "MPC"));
    abbrevs.add(new StringReplacement("MedicinalProductIngredient", "MPI"));
    abbrevs.add(new StringReplacement("MedicinalProductPharmaceutical", "MPP"));
    abbrevs.add(new StringReplacement("MedicinalProduct", "MP"));
    abbrevs.add(new StringReplacement("ResearchElementDefinition", "RED"));
    abbrevs.add(new StringReplacement("RiskEvidenceSynthesis", "RES"));
    abbrevs.add(new StringReplacement("ObservationDefinition", "OD"));
    abbrevs.add(new StringReplacement("SubstanceReferenceInformation", "SRI"));
    abbrevs.add(new StringReplacement("SubstanceSourceMaterial", "SSM"));
    abbrevs.add(new StringReplacement("SpecimenDefinition", "SD"));
    abbrevs.add(new StringReplacement("SubstanceSpecification", "SS"));
    abbrevs.add(new StringReplacement("SubstancePolymer", "SP"));
    abbrevs.add(new StringReplacement("TerminologyCapabilities", "TC"));
    abbrevs.add(new StringReplacement("VerificationResult", "VR"));
    abbrevs.add(new StringReplacement("EligibilityResponse", "ERsp"));
    abbrevs.add(new StringReplacement("ExpansionProfile", "EP"));
    abbrevs.add(new StringReplacement("ImagingObjectSelection", "IOS"));


    abbrevs.add(new StringReplacement("administrationGuidelines.patientCharacteristics", "ag.pc"));
    abbrevs.add(new StringReplacement("manufacturingBusinessOperation", "mbo"));
    abbrevs.add(new StringReplacement("strength.referenceStrength", "strength.rs"));
    abbrevs.add(new StringReplacement("MPP.routeOfAdministration", "MPP.roa"));
    abbrevs.add(new StringReplacement("supportingInformation", "si"));
    abbrevs.add(new StringReplacement("structuralRepresentation", "sr"));
    abbrevs.add(new StringReplacement("compareToSourceExpression", "ctse"));
    abbrevs.add(new StringReplacement("TestScript.setup.action.assert", "TestScript.s.a.a"));

    for (StringReplacement s : abbrevs)
      if (id.contains(s.getSource()))
        id = id.replace(s.getSource(), s.getReplacement());
    if (id.length() > 64)
      throw new Error("Still too long: " + id);
    return id;
  }


  private String timezone() {
    TimeZone tz = TimeZone.getDefault();
    Calendar cal = GregorianCalendar.getInstance(tz);
    int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
    offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

    return offset;
  }

  private void savePackage(List<StructureDefinition> extensions) throws FHIRException, IOException {
    JsonObject npm = new JsonObject();
    npm.addProperty("name", "hl7.fhir.extensions.r" + sourceVersion.toCode().substring(0, 1));
    npm.addProperty("version", targetVersion.toCode().substring(0, 3));
    npm.addProperty("tools-version", ToolsVersion.TOOLS_VERSION);
    npm.addProperty("type", PackageType.IG.getCode());
    npm.addProperty("license", SPDXLicense.CC0_1_0.toCode());
    npm.addProperty("canonical", "http://hl7.org/fhir/" + sourceVersion.toCode().substring(0, 3) + "/extensions/" + targetVersion.toCode().substring(0, 3));
    npm.addProperty("url", "http://hl7.org/fhir/" + sourceVersion.toCode().substring(0, 3) + "/extensions/" + targetVersion.toCode().substring(0, 3));
    npm.addProperty("title", "Extension Definitions for representing elements from " + sourceVersion.toCode() + " in " + targetVersion.toCode());
    npm.addProperty("description", "Extension Definitions for representing elements from " + sourceVersion.toCode() + " in " + targetVersion.toCode() + " built " + new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(Calendar.getInstance().getTime()) + timezone() + ")");
    JsonObject dep = new JsonObject();
    npm.add("dependencies", dep);
    dep.addProperty("hl7.fhir.core", targetVersion.toCode());
    npm.addProperty("author", "FHIR Project");
    JsonArray m = new JsonArray();
    JsonObject md = new JsonObject();
    m.add(md);
    md.addProperty("name", "FHIR Project");
    md.addProperty("url", "http://hl7.org/fhir");
    NPMPackageGenerator pi = new NPMPackageGenerator(filename, npm);
    for (StructureDefinition sd : extensions) {
      byte[] cnt = saveResource(sd, targetVersion);
      pi.addFile(Category.RESOURCE, "StructureDefinition-" + sd.getId() + ".json", cnt);
    }
    pi.finish();

  }


  private List<StructureDefinition> loadSource() throws IOException, FHIRException {
    List<StructureDefinition> list = new ArrayList<>();
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    NpmPackage npm = pcm.loadPackage("hl7.fhir.core", sourceVersion.toCode());
    if (sourceVersion == FHIRVersion._4_0_0)
      context = SimpleWorkerContext.fromPackage(npm);
    else if (sourceVersion == FHIRVersion._3_0_1)
      context = SimpleWorkerContext.fromPackage(npm, new R3ToR4Loader());
    else if (sourceVersion == FHIRVersion._1_4_0)
      context = SimpleWorkerContext.fromPackage(npm, new R2016MayToR4Loader());
    else if (sourceVersion == FHIRVersion._1_0_2)
      context = SimpleWorkerContext.fromPackage(npm, new R2ToR4Loader());
    pu = new ProfileUtilities(context, null, null);
    for (String fn : npm.listResources("StructureDefinition")) {
      list.add((StructureDefinition) loadResource(npm.load("package", fn), sourceVersion));
    }
    for (StructureDefinition sd : list)
      if (sd.getName().equals("Extension")) {
        extbase = sd;
        extv = extbase.getSnapshot().getElement().get(extbase.getSnapshot().getElement().size() - 1);
      }
    return list;
  }

  private byte[] saveResource(Resource resource, FHIRVersion v) throws IOException, FHIRException {
    if (v == FHIRVersion._3_0_1) {
      org.hl7.fhir.dstu3.model.Resource res = VersionConvertorFactory_30_40.convertResource(resource, new BaseAdvisor_30_40(false));
      return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(res);
    } else if (v == FHIRVersion._1_4_0) {
      org.hl7.fhir.dstu2016may.model.Resource res = VersionConvertorFactory_14_40.convertResource(resource);
      return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(res);
    } else if (v == FHIRVersion._1_0_2) {
      BaseAdvisor_10_40 advisor = new IGR2ConvertorAdvisor();
      org.hl7.fhir.dstu2.model.Resource res = VersionConvertorFactory_10_40.convertResource(resource, advisor);
      return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(res);
    } else if (v == FHIRVersion._4_0_0) {
      return new JsonParser().composeBytes(resource);
    } else
      throw new Error("Unsupported version " + v);
  }

  private Resource loadResource(InputStream inputStream, FHIRVersion v) throws IOException, FHIRException {
    if (v == FHIRVersion._3_0_1) {
      org.hl7.fhir.dstu3.model.Resource res = new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream);
      return VersionConvertorFactory_30_40.convertResource(res, new BaseAdvisor_30_40(false));
    } else if (v == FHIRVersion._1_4_0) {
      org.hl7.fhir.dstu2016may.model.Resource res = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream);
      return VersionConvertorFactory_14_40.convertResource(res);
    } else if (v == FHIRVersion._1_0_2) {
      org.hl7.fhir.dstu2.model.Resource res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream);
      BaseAdvisor_10_40 advisor = new IGR2ConvertorAdvisor();
      return VersionConvertorFactory_10_40.convertResource(res, advisor);
    } else if (v == FHIRVersion._4_0_0) {
      return new JsonParser().parse(inputStream);
    } else
      throw new Error("Unsupported version " + v);
  }
}