package org.hl7.fhir.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.model.ScanOutputItem;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ValidationScan {

  protected static final int BUFFER_SIZE = 4096;

  public static void validateScan(CliContext cliContext, ValidationEngine validator) throws Exception {
    if (Utilities.noString(cliContext.getOutput()))
      throw new Exception("Output parameter required when scanning");
    if (!(new File(cliContext.getOutput()).isDirectory()))
      throw new Exception("Output '" + cliContext.getOutput() + "' must be a directory when scanning");
    System.out.println("  .. scan " + cliContext.getSources() + " against loaded IGs");
    Set<String> urls = new HashSet<>();
    for (ImplementationGuide ig : validator.getContext().allImplementationGuides()) {
      if (ig.getUrl().contains("/ImplementationGuide") && !ig.getUrl().equals("http://hl7.org/fhir/ImplementationGuide/fhir"))
        urls.add(ig.getUrl());
    }
    List<ScanOutputItem> res = validator.validateScan(cliContext.getSources(), urls);
    genScanOutput(validator, cliContext.getOutput(), res);
    System.out.println("Done. output in " + Utilities.path(cliContext.getOutput(), "scan.html"));
  }

  public static void genScanOutput(ValidationEngine validationEngine, String folder, List<ScanOutputItem> items) throws IOException, FHIRException, EOperationOutcome {
    String f = Utilities.path(folder, "comparison.zip");
    download("http://fhir.org/archive/comparison.zip", f);
    unzip(f, folder);

    for (int i = 0; i < items.size(); i++) {
      items.get(i).setId("c" + i);
      genScanOutputItem(validationEngine.getContext(), items.get(i), Utilities.path(folder, items.get(i).getId() + ".html"));
    }

    StringBuilder b = new StringBuilder();
    b.append("<html>");
    b.append("<head>");
    b.append("<title>Implementation Guide Scan</title>");
    b.append("<link rel=\"stylesheet\" href=\"fhir.css\"/>\r\n");
    b.append("<style>\r\n");
    b.append("th \r\n");
    b.append("{\r\n");
    b.append("  vertical-align: bottom;\r\n");
    b.append("  text-align: center;\r\n");
    b.append("}\r\n");
    b.append("\r\n");
    b.append("th span\r\n");
    b.append("{\r\n");
    b.append("  -ms-writing-mode: tb-rl;\r\n");
    b.append("  -webkit-writing-mode: vertical-rl;\r\n");
    b.append("  writing-mode: vertical-rl;\r\n");
    b.append("  transform: rotate(180deg);\r\n");
    b.append("  white-space: nowrap;\r\n");
    b.append("}\r\n");
    b.append("</style>\r\n");
    b.append("</head>");
    b.append("<body>");
    b.append("<h2>Implementation Guide Scan</h2>");

    // organise
    Set<String> refs = new HashSet<>();
    Set<String> igs = new HashSet<>();
    Map<String, Set<String>> profiles = new HashMap<>();
    for (ScanOutputItem item : items) {
      refs.add(item.getRef());
      if (item.getIg() != null) {
        igs.add(item.getIg().getUrl());
        if (!profiles.containsKey(item.getIg().getUrl())) {
          profiles.put(item.getIg().getUrl(), new HashSet<>());
        }
        if (item.getProfile() != null)
          profiles.get(item.getIg().getUrl()).add(item.getProfile().getUrl());
      }
    }

    b.append("<h2>By reference</h2>\r\n");
    b.append("<table class=\"grid\">");
    b.append("<tr><th></th><th></th>");
    for (String s : sort(igs)) {
      ImplementationGuide ig = validationEngine.getContext().fetchResource(ImplementationGuide.class, s);
      b.append("<th colspan=\"" + Integer.toString(profiles.get(s).size() + 1) + "\"><b title=\"" + s + "\">" + ig.present() + "</b></th>");
    }
    b.append("</tr>\r\n");
    b.append("<tr><th><b>Source</b></th><th><span>Core Spec</span></th>");
    for (String s : sort(igs)) {
      ImplementationGuide ig = validationEngine.getContext().fetchResource(ImplementationGuide.class, s);
      b.append("<th><span>Global</span></th>");
      for (String sp : sort(profiles.get(s))) {
        StructureDefinition sd = validationEngine.getContext().fetchResource(StructureDefinition.class, sp);
        b.append("<th><b title=\"" + sp + "\"><span>" + sd.present() + "</span></b></th>");
      }
    }
    b.append("</tr>\r\n");

    for (String s : sort(refs)) {
      b.append("<tr>");
      b.append("<td>" + s + "</td>");
      b.append(genOutcome(items, s, null, null));
      for (String si : sort(igs)) {
        ImplementationGuide ig = validationEngine.getContext().fetchResource(ImplementationGuide.class, si);
        b.append(genOutcome(items, s, si, null));
        for (String sp : sort(profiles.get(ig.getUrl()))) {
          b.append(genOutcome(items, s, si, sp));
        }
      }
      b.append("</tr>\r\n");
    }
    b.append("</table>\r\n");

    b.append("<h2>By IG</h2>\r\n");
    b.append("<table class=\"grid\">");
    b.append("<tr><th></th><th></th>");
    for (String s : sort(refs)) {
      b.append("<th><span>" + s + "</span></th>");
    }
    b.append("</tr>\r\n");
    b.append("<tr><td></td><td>Core Spec</td>");
    for (String s : sort(refs)) {
      b.append(genOutcome(items, s, null, null));
    }
    b.append("</tr>\r\n");
    for (String si : sort(igs)) {
      b.append("<tr>");
      ImplementationGuide ig = validationEngine.getContext().fetchResource(ImplementationGuide.class, si);
      b.append("<td><b title=\"" + si + "\">" + ig.present() + "</b></td>");
      b.append("<td>Global</td>");
      for (String s : sort(refs)) {
        b.append(genOutcome(items, s, si, null));
      }
      b.append("</tr>\r\n");

      for (String sp : sort(profiles.get(ig.getUrl()))) {
        b.append("<tr>");
        StructureDefinition sd = validationEngine.getContext().fetchResource(StructureDefinition.class, sp);
        b.append("<td></td><td><b title=\"" + sp + "\">" + sd.present() + "</b></td>");
        for (String s : sort(refs)) {
          b.append(genOutcome(items, s, si, sp));
        }
        b.append("</tr>\r\n");
      }
    }
    b.append("</table>\r\n");

    b.append("</body>");
    b.append("</html>");
    TextFile.stringToFile(b.toString(), Utilities.path(folder, "scan.html"));
  }

  public static String genOutcome(List<ScanOutputItem> items, String src, String ig, String profile) {
    ScanOutputItem item = null;
    for (ScanOutputItem t : items) {
      boolean match = true;
      if (!t.getRef().equals(src))
        match = false;
      if (!((ig == null && t.getIg() == null) || (ig != null && t.getIg() != null && ig.equals(t.getIg().getUrl()))))
        match = false;
      if (!((profile == null && t.getProfile() == null) || (profile != null && t.getProfile() != null && profile.equals(t.getProfile().getUrl()))))
        match = false;
      if (match) {
        item = t;
        break;
      }
    }

    if (item == null)
      return "<td></td>";
    boolean ok = true;
    for (OperationOutcome.OperationOutcomeIssueComponent iss : item.getOutcome().getIssue()) {
      if (iss.getSeverity() == OperationOutcome.IssueSeverity.ERROR || iss.getSeverity() == OperationOutcome.IssueSeverity.FATAL) {
        ok = false;
      }
    }
    if (ok)
      return "<td style=\"background-color: #e6ffe6\"><a href=\"" + item.getId() + ".html\">\u2714</a></td>";
    else
      return "<td style=\"background-color: #ffe6e6\"><a href=\"" + item.getId() + ".html\">\u2716</a></td>";
  }

  public static void genScanOutputItem(SimpleWorkerContext context, ScanOutputItem item, String filename) throws IOException, FHIRException, EOperationOutcome {
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, RenderingContext.ResourceRendererMode.RESOURCE);
    rc.setNoSlowLookup(true);
    RendererFactory.factory(item.getOutcome(), rc).render(item.getOutcome());
    String s = new XhtmlComposer(XhtmlComposer.HTML).compose(item.getOutcome().getText().getDiv());

    String title = item.getTitle();

    StringBuilder b = new StringBuilder();
    b.append("<html>");
    b.append("<head>");
    b.append("<title>" + title + "</title>");
    b.append("<link rel=\"stylesheet\" href=\"fhir.css\"/>\r\n");
    b.append("</head>");
    b.append("<body>");
    b.append("<h2>" + title + "</h2>");
    b.append(s);
    b.append("</body>");
    b.append("</html>");
    TextFile.stringToFile(b.toString(), filename);
  }

  public static void download(String address, String filename) throws IOException {
    URL url = new URL(address);
    URLConnection c = url.openConnection();
    InputStream s = c.getInputStream();
    FileOutputStream f = new FileOutputStream(filename);
    transfer(s, f, 1024);
    f.close();
  }

  public static void transfer(InputStream in, OutputStream out, int buffer) throws IOException {
    byte[] read = new byte[buffer]; // Your buffer size.
    while (0 < (buffer = in.read(read)))
      out.write(read, 0, buffer);
  }

  public static List<String> sort(Set<String> keys) {
    return keys.stream().sorted().collect(Collectors.toList());
  }

  public static void unzip(String zipFilePath, String destDirectory) throws IOException {
    File destDir = new File(destDirectory);
    if (!destDir.exists()) {
      destDir.mkdir();
    }
    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
    ZipEntry entry = zipIn.getNextEntry();
    // iterates over entries in the zip file
    while (entry != null) {
      String filePath = destDirectory + File.separator + entry.getName();
      if (!entry.isDirectory()) {
        // if the entry is a file, extracts it
        extractFile(zipIn, filePath);
      } else {
        // if the entry is a directory, make the directory
        File dir = new File(filePath);
        dir.mkdir();
      }
      zipIn.closeEntry();
      entry = zipIn.getNextEntry();
    }
    zipIn.close();
  }

  protected static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] bytesIn = new byte[BUFFER_SIZE];
    int read = 0;
    while ((read = zipIn.read(bytesIn)) != -1) {
      bos.write(bytesIn, 0, read);
    }
    bos.close();
  }
}
