package org.hl7.fhir.validation;

/*-
 * #%L
 * org.hl7.fhir.validation
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
/*
Copyright (c) 2011+, HL7, Inc
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

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.hl7.fhir.r5.conformance.CapabilityStatementUtilities;
import org.hl7.fhir.r5.conformance.CapabilityStatementUtilities.CapabilityStatementComparisonOutput;
import org.hl7.fhir.r5.conformance.ProfileComparer;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.KeyGenerator;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.validation.ValidationEngine.ScanOutputItem;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.cliutils.*;

/**
 * A executable class that will validate one or more FHIR resources against
 * the specification
 * <p>
 * todo: schema validation (w3c xml, json schema, shex?)
 * <p>
 * if you want to host validation inside a process, skip this class, and look at
 * ValidationEngine
 * <p>
 * todo: find a gome for this:
 *
 * @author Grahame
 */
public class Validator {

  public enum EngineMode {
    VALIDATION, TRANSFORM, NARRATIVE, SNAPSHOT, SCAN, CONVERT, FHIRPATH, VERSION
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

  private static String toMB(long maxMemory) {
    return Long.toString(maxMemory / (1024 * 1024));
  }

  public static void main(String[] args) throws Exception {
    System.out.println("FHIR Validation tool " + VersionUtil.getVersionString());
    System.out.println("Detected Java version: " + System.getProperty("java.version") + " from " + System.getProperty("java.home") + " on " + System.getProperty("os.arch") + " (" + System.getProperty("sun.arch.data.model") + "bit). " + toMB(Runtime.getRuntime().maxMemory()) + "MB available");
    String proxy = getNamedParam(args, "-proxy");
    if (!Utilities.noString(proxy)) {
      String[] p = proxy.split("\\:");
      System.setProperty("http.proxyHost", p[0]);
      System.setProperty("http.proxyPort", p[1]);
    }

    if (ParamUtils.hasParam(args, "-tests")) {
      Utils.runValidationEngineTests();
    } else if (args.length == 0 || ParamUtils.hasParam(args, "help") || ParamUtils.hasParam(args, "?") || ParamUtils.hasParam(args, "-?") || ParamUtils.hasParam(args, "/?")) {
      DisplayUtils.displayHelpDetails();
    } else if (ParamUtils.hasParam(args, "-compare")) {
      DisplayUtils.printCliArgumentsAndInfo(args);
      String dest = ParamUtils.getParam(args, "-dest");
      if (dest == null)
        System.out.println("no -dest parameter provided");
      else if (!new File(dest).isDirectory())
        System.out.println("Specified destination (-dest parameter) is not valid: \"" + dest + "\")");
      else {
        // first, prepare the context
        String txLog = Utils.getTerminologyServerLog(args);
        ValidationEngine validator = Utils.getValidationEngine(args, txLog);
        Utils.checkIGFileReferences(args);
        ComparisonUtils.doLeftRightComparison(args, dest, validator);
      }
    } else {
      DisplayUtils.printCliArgumentsAndInfo(args);

      String map = null;
      List<String> igs = new ArrayList<String>();
      List<String> questionnaires = new ArrayList<String>();
      String txServer = "http://tx.fhir.org";
      boolean doNative = false;
      boolean anyExtensionsAllowed = true;
      boolean hintAboutNonMustSupport = false;
      boolean recursive = false;
      Locale locale = null;
      List<String> profiles = new ArrayList<String>();
      EngineMode mode = EngineMode.VALIDATION;
      String output = null;
      Boolean canDoNative = null;
      List<String> sources = new ArrayList<String>();
      Map<String, String> locations = new HashMap<String, String>();
      String sv = "current";
      String txLog = null;
      String mapLog = null;
      String lang = null;
      String fhirpath = null;
      String snomedCT = "900000000000207008";
      String targetVer = null;
      boolean doDebug = false;
      boolean assumeValidRestReferences = false;

      // load the parameters - so order doesn't matter
      for (int i = 0; i < args.length; i++) {
        if (args[i].equals("-version")) {
          sv = args[++i];
          sv = VersionUtilities.getCurrentPackageVersion(sv);
        } else if (args[i].equals("-output")) {
          if (i + 1 == args.length)
            throw new Error("Specified -output without indicating output file");
          else
            output = args[++i];
        } else if (args[i].equals("-proxy")) {
          i++; // ignore next parameter
        } else if (args[i].equals("-profile")) {
          String p = null;
          if (i + 1 == args.length)
            throw new Error("Specified -profile without indicating profile source");
          else {
            p = args[++i];
            profiles.add(p);
          }
          if (p != null && i + 1 < args.length && args[i + 1].equals("@")) {
            i++;
            if (i + 1 == args.length)
              throw new Error("Specified -profile with @ without indicating profile location");
            else
              locations.put(p, args[++i]);
          }
        } else if (args[i].equals("-questionnaire")) {
          if (i + 1 == args.length)
            throw new Error("Specified -questionnaire without indicating questionnaire file");
          else
            questionnaires.add(args[++i]);
        } else if (args[i].equals("-native")) {
          doNative = true;
        } else if (args[i].equals("-assumeValidRestReferences")) {
          assumeValidRestReferences = true;
        } else if (args[i].equals("-debug")) {
          doDebug = true;
        } else if (args[i].equals("-sct")) {
          String s = args[++i];
          snomedCT = SnomedVersion.resolveSnomedCTCode(s);
        } else if (args[i].equals("-recurse")) {
          recursive = true;
        } else if (args[i].equals("-locale")) {
          if (i + 1 == args.length) {
            throw new Error("Specified -locale without indicating locale");
          } else {
            locale = new Locale(args[++i]);
          }
        } else if (args[i].equals("-strictExtensions")) {
          anyExtensionsAllowed = false;
        } else if (args[i].equals("-hintAboutNonMustSupport")) {
          hintAboutNonMustSupport = true;
        } else if (args[i].equals("-to-version")) {
          targetVer = args[++i];
          mode = EngineMode.VERSION;
        } else if (args[i].equals("-do-native")) {
          canDoNative = true;
        } else if (args[i].equals("-no-native")) {
          canDoNative = false;
        } else if (args[i].equals("-transform")) {
          map = args[++i];
          mode = EngineMode.TRANSFORM;
        } else if (args[i].equals("-narrative")) {
          mode = EngineMode.NARRATIVE;
        } else if (args[i].equals("-snapshot")) {
          mode = EngineMode.SNAPSHOT;
        } else if (args[i].equals("-scan")) {
          mode = EngineMode.SCAN;
        } else if (args[i].equals("-tx")) {
          if (i + 1 == args.length)
            throw new Error("Specified -tx without indicating terminology server");
          else
            txServer = "n/a".equals(args[++i]) ? null : args[i];
        } else if (args[i].equals("-txLog")) {
          if (i + 1 == args.length)
            throw new Error("Specified -txLog without indicating file");
          else
            txLog = args[++i];
        } else if (args[i].equals("-log")) {
          if (i + 1 == args.length)
            throw new Error("Specified -log without indicating file");
          else
            mapLog = args[++i];
        } else if (args[i].equals("-language")) {
          if (i + 1 == args.length)
            throw new Error("Specified -language without indicating language");
          else
            lang = args[++i];
        } else if (args[i].equals("-ig") || args[i].equals("-defn")) {
          if (i + 1 == args.length)
            throw new Error("Specified " + args[i] + " without indicating ig file");
          else {
            String s = args[++i];
            sv = Utils.getVersionFromIGName(null, s);
            if (sv == null) {
              igs.add(s);
            }
          }
        } else if (args[i].equals("-map")) {
          if (map == null) {
            if (i + 1 == args.length)
              throw new Error("Specified -map without indicating map file");
            else
              map = args[++i];
          } else {
            throw new Exception("Can only nominate a single -map parameter");
          }
        } else if (args[i].startsWith("-x")) {
          i++;
        } else if (args[i].equals("-convert")) {
          mode = EngineMode.CONVERT;
        } else if (args[i].equals("-fhirpath")) {
          mode = EngineMode.FHIRPATH;
          if (fhirpath == null)
            if (i + 1 == args.length)
              throw new Error("Specified -fhirpath without indicating a FHIRPath expression");
            else
              fhirpath = args[++i];
          else
            throw new Exception("Can only nominate a single -fhirpath parameter");
        } else {
          sources.add(args[i]);
        }
      }
      if (sources.isEmpty())
        throw new Exception("Must provide at least one source file");

      // Comment this out because definitions filename doesn't necessarily contain version (and many not even be 14 characters long).  Version gets spit out a couple of lines later after we've loaded the context
      String definitions = VersionUtilities.packageForVersion(sv) + "#" + VersionUtilities.getCurrentVersion(sv);
      System.out.println("  .. FHIR Version " + sv + ", definitions from " + definitions);
      System.out.println("  .. connect to tx server @ " + txServer);
      ValidationEngine validator = new ValidationEngine(definitions, txServer, txLog, FhirPublication.fromCode(sv), sv);
      validator.setDebug(doDebug);
      System.out.println("    (v" + validator.getContext().getVersion() + ")");
      for (String src : igs) {
        System.out.println("+  .. load IG from " + src);
        validator.loadIg(src, recursive);
      }
      validator.setQuestionnaires(questionnaires);
      validator.setNative(doNative);
      validator.setHintAboutNonMustSupport(hintAboutNonMustSupport);
      validator.setAnyExtensionsAllowed(anyExtensionsAllowed);
      validator.setLanguage(lang);
      validator.setLocale(locale);
      validator.setSnomedExtension(snomedCT);
      validator.setAssumeValidRestReferences(assumeValidRestReferences);

      IParser x;
      if (output != null && output.endsWith(".json"))
        x = new JsonParser();
      else
        x = new XmlParser();
      x.setOutputStyle(OutputStyle.PRETTY);

      if (mode == EngineMode.VERSION) {
        if (sources.size() > 1) {
          throw new Exception("Can only have one source when converting versions (found " + sources + ")");
        }
        if (targetVer == null) {
          throw new Exception("Must provide a map when converting versions");
        }
        if (output == null) {
          throw new Exception("Must nominate an output when converting versions");
        }
        try {
          if (mapLog != null) {
            validator.setMapLog(mapLog);
          }
          byte[] r = validator.transformVersion(sources.get(0), targetVer, output.endsWith(".json") ? FhirFormat.JSON : FhirFormat.XML, canDoNative);
          System.out.println(" ...success");
          TextFile.bytesToFile(r, output);
        } catch (Exception e) {
          System.out.println(" ...Failure: " + e.getMessage());
          e.printStackTrace();
        }
      } else if (mode == EngineMode.TRANSFORM) {
        if (sources.size() > 1)
          throw new Exception("Can only have one source when doing a transform (found " + sources + ")");
        if (txServer == null)
          throw new Exception("Must provide a terminology server when doing a transform");
        if (map == null)
          throw new Exception("Must provide a map when doing a transform");
        try {
          validator.setMapLog(mapLog);
          org.hl7.fhir.r5.elementmodel.Element r = validator.transform(sources.get(0), map);
          System.out.println(" ...success");
          if (output != null) {
            FileOutputStream s = new FileOutputStream(output);
            if (output != null && output.endsWith(".json"))
              new org.hl7.fhir.r5.elementmodel.JsonParser(validator.getContext()).compose(r, s, OutputStyle.PRETTY, null);
            else
              new org.hl7.fhir.r5.elementmodel.XmlParser(validator.getContext()).compose(r, s, OutputStyle.PRETTY, null);
            s.close();
          }
        } catch (Exception e) {
          System.out.println(" ...Failure: " + e.getMessage());
          e.printStackTrace();
        }
      } else if (mode == EngineMode.NARRATIVE) {
        DomainResource r = validator.generate(sources.get(0), sv);
        System.out.println(" ...generated narrative successfully");
        if (output != null) {
          validator.handleOutput(r, output, sv);
        }
      } else if (mode == EngineMode.SNAPSHOT) {
        StructureDefinition r = validator.snapshot(sources.get(0), sv);
        System.out.println(" ...generated snapshot successfully");
        if (output != null) {
          validator.handleOutput(r, output, sv);
        }
      } else if (mode == EngineMode.CONVERT) {
        validator.convert(sources.get(0), output);
        System.out.println(" ...convert");
      } else if (mode == EngineMode.FHIRPATH) {
        System.out.println(" ...evaluating " + fhirpath);
        System.out.println(validator.evaluateFhirPath(sources.get(0), fhirpath));
      } else {
        if (definitions == null)
          throw new Exception("Must provide a defn when doing validation");
        for (String s : profiles) {
          if (!validator.getContext().hasResource(StructureDefinition.class, s) && !validator.getContext().hasResource(ImplementationGuide.class, s)) {
            System.out.println("Fetch Profile from " + s);
            validator.loadProfile(locations.getOrDefault(s, s));
          }
        }
        if (mode == EngineMode.SCAN) {
          if (Utilities.noString(output))
            throw new Exception("Output parameter required when scanning");
          if (!(new File(output).isDirectory()))
            throw new Exception("Output '" + output + "' must be a directory when scanning");
          System.out.println("  .. scan " + sources + " against loaded IGs");
          Set<String> urls = new HashSet<>();
          for (ImplementationGuide ig : validator.getContext().allImplementationGuides()) {
            if (ig.getUrl().contains("/ImplementationGuide") && !ig.getUrl().equals("http://hl7.org/fhir/ImplementationGuide/fhir"))
              urls.add(ig.getUrl());
          }
          List<ScanOutputItem> res = validator.validateScan(sources, urls);
          validator.genScanOutput(output, res);
          System.out.println("Done. output in " + Utilities.path(output, "scan.html"));
        } else {
          if (profiles.size() > 0)
            System.out.println("  .. validate " + sources + " against " + profiles.toString());
          else
            System.out.println("  .. validate " + sources);
          validator.prepare(); // generate any missing snapshots
          Resource r = validator.validate(sources, profiles);
          int ec = 0;
          if (output == null) {
            if (r instanceof Bundle)
              for (BundleEntryComponent e : ((Bundle) r).getEntry())
                ec = displayOO((OperationOutcome) e.getResource()) + ec;
            else
              ec = displayOO((OperationOutcome) r);
          } else {
            FileOutputStream s = new FileOutputStream(output);
            x.compose(s, r);
            s.close();
          }
          System.exit(ec > 0 ? 1 : 0);
        }
      }
    }
  }

  private static String getGitBuild() {
    return "??";
  }

  private static int displayOO(OperationOutcome oo) {
    int error = 0;
    int warn = 0;
    int info = 0;
    String file = ToolingExtensions.readStringExtension(oo, ToolingExtensions.EXT_OO_FILE);

    for (OperationOutcomeIssueComponent issue : oo.getIssue()) {
      if (issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL || issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
        error++;
      else if (issue.getSeverity() == OperationOutcome.IssueSeverity.WARNING)
        warn++;
      else
        info++;
    }

    System.out.println((error == 0 ? "Success..." : "*FAILURE* ") + "validating " + file + ": " + " error:" + Integer.toString(error) + " warn:" + Integer.toString(warn) + " info:" + Integer.toString(info));
    for (OperationOutcomeIssueComponent issue : oo.getIssue()) {
      System.out.println(getIssueSummary(issue));
    }
    System.out.println();
    return error;
  }

  private static String getIssueSummary(OperationOutcomeIssueComponent issue) {
    String loc = null;
    if (issue.hasExpression()) {
      int line = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_LINE, -1);
      int col = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_COL, -1);
      loc = issue.getExpression().get(0).asStringValue() + (line >= 0 && col >= 0 ? " (line " + Integer.toString(line) + ", col" + Integer.toString(col) + ")" : "");
    } else if (issue.hasLocation()) {
      loc = issue.getLocation().get(0).asStringValue();
    } else {
      int line = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_LINE, -1);
      int col = ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_COL, -1);
      loc = (line >= 0 && col >= 0 ? "line " + Integer.toString(line) + ", col" + Integer.toString(col) : "??");
    }
    return "  " + issue.getSeverity().getDisplay() + " @ " + loc + " : " + issue.getDetails().getText();
  }

}
