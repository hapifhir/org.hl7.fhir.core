package org.hl7.fhir.validation;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.validation.ValidatorUtils.SourceFile;
import org.hl7.fhir.validation.cli.model.ScanOutputItem;
import org.hl7.fhir.validation.instance.InstanceValidator;

import lombok.Getter;

public class Scanner {

  private static final int BUFFER_SIZE = 4096;

  @Getter private final SimpleWorkerContext context;
  @Getter private final InstanceValidator validator;
  @Getter private final IgLoader igLoader;
  @Getter private final FHIRPathEngine fhirPathEngine;

  public Scanner(SimpleWorkerContext context, InstanceValidator validator, IgLoader igLoader, FHIRPathEngine fhirPathEngine) {
    this.context = context;
    this.validator = validator;
    this.igLoader = igLoader;
    this.fhirPathEngine = fhirPathEngine;
  }

  public void validateScan(String output, List<String> sources) throws Exception {
    if (Utilities.noString(output))
      throw new Exception("Output parameter required when scanning");
    if (!(new File(output).isDirectory()))
      throw new Exception("Output '" + output + "' must be a directory when scanning");
    System.out.println("  .. scan " + sources + " against loaded IGs");
    Set<String> urls = new HashSet<>();
    for (ImplementationGuide ig : getContext().allImplementationGuides()) {
      if (ig.getUrl().contains("/ImplementationGuide") && !ig.getUrl().equals("http://hl7.org/fhir/ImplementationGuide/fhir"))
        urls.add(ig.getUrl());
    }
    List<ScanOutputItem> res = validateScan(sources, urls);
    genScanOutput(output, res);
    System.out.println("Done. output in " + Utilities.path(output, "scan.html"));
  }

  protected List<ScanOutputItem> validateScan(List<String> sources, Set<String> guides) throws FHIRException, IOException, EOperationOutcome {
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(sources, refs, getContext());

    List<ScanOutputItem> res = new ArrayList<>();

    for (SourceFile ref : refs) {
      Content cnt = getIgLoader().loadContent(ref.getRef(), "validate", false, true);
      List<ValidationMessage> messages = new ArrayList<>();
      Element e = null;
      try {
        System.out.println("Validate " + ref);
        messages.clear();
        e = getValidator().validate(null, messages, new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType());
        res.add(new ScanOutputItem(ref.getRef(), null, null, ValidatorUtils.messagesToOutcome(messages, getContext(), getFhirPathEngine())));
      } catch (Exception ex) {
        res.add(new ScanOutputItem(ref.getRef(), null, null, exceptionToOutcome(ex)));
      }
      if (e != null) {
        String rt = e.fhirType();
        for (String u : guides) {
          ImplementationGuide ig = getContext().fetchResource(ImplementationGuide.class, u);
          System.out.println("Check Guide " + ig.getUrl());
          String canonical = ig.getUrl().contains("/Impl") ? ig.getUrl().substring(0, ig.getUrl().indexOf("/Impl")) : ig.getUrl();
          String url = getGlobal(ig, rt);
          if (url != null) {
            try {
              System.out.println("Validate " + ref + " against " + ig.getUrl());
              messages.clear();
              getValidator().validate(null, messages, new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType(), url);
              res.add(new ScanOutputItem(ref.getRef(), ig, null, ValidatorUtils.messagesToOutcome(messages, getContext(), getFhirPathEngine())));
            } catch (Exception ex) {
              res.add(new ScanOutputItem(ref.getRef(), ig, null, exceptionToOutcome(ex)));
            }
          }
          Set<String> done = new HashSet<>();
          for (StructureDefinition sd : new ContextUtilities(getContext()).allStructures()) {
            if (!done.contains(sd.getUrl())) {
              done.add(sd.getUrl());
              if (sd.getUrl().startsWith(canonical) && rt.equals(sd.getType())) {
                try {
                  System.out.println("Validate " + ref + " against " + sd.getUrl());
                  messages.clear();
                  validator.validate(null, messages, new ByteArrayInputStream(cnt.getFocus()), cnt.getCntType(), Collections.singletonList(sd));
                  res.add(new ScanOutputItem(ref.getRef(), ig, sd, ValidatorUtils.messagesToOutcome(messages, getContext(), getFhirPathEngine())));
                } catch (Exception ex) {
                  res.add(new ScanOutputItem(ref.getRef(), ig, sd, exceptionToOutcome(ex)));
                }
              }
            }
          }
        }
      }
    }
    return res;
  }

  protected void genScanOutput(String folder, List<ScanOutputItem> items) throws IOException, FHIRException, EOperationOutcome {
    String f = Utilities.path(folder, "comparison.zip");
    download("https://fhir.org/archive/comparison.zip", f);
    unzip(f, folder);

    for (int i = 0; i < items.size(); i++) {
      items.get(i).setId("c" + i);
      genScanOutputItem(items.get(i), Utilities.path(folder, items.get(i).getId() + ".html"));
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
      ImplementationGuide ig = getContext().fetchResource(ImplementationGuide.class, s);
      b.append("<th colspan=\"" + Integer.toString(profiles.get(s).size() + 1) + "\"><b title=\"" + s + "\">" + ig.present() + "</b></th>");
    }
    b.append("</tr>\r\n");
    b.append("<tr><th><b>Source</b></th><th><span>Core Spec</span></th>");
    for (String s : sort(igs)) {
      ImplementationGuide ig = getContext().fetchResource(ImplementationGuide.class, s);
      b.append("<th><span>Global</span></th>");
      for (String sp : sort(profiles.get(s))) {
        StructureDefinition sd = getContext().fetchResource(StructureDefinition.class, sp);
        b.append("<th><b title=\"" + sp + "\"><span>" + sd.present() + "</span></b></th>");
      }
    }
    b.append("</tr>\r\n");

    for (String s : sort(refs)) {
      b.append("<tr>");
      b.append("<td>" + s + "</td>");
      b.append(genOutcome(items, s, null, null));
      for (String si : sort(igs)) {
        ImplementationGuide ig = getContext().fetchResource(ImplementationGuide.class, si);
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
      ImplementationGuide ig = getContext().fetchResource(ImplementationGuide.class, si);
      b.append("<td><b title=\"" + si + "\">" + ig.present() + "</b></td>");
      b.append("<td>Global</td>");
      for (String s : sort(refs)) {
        b.append(genOutcome(items, s, si, null));
      }
      b.append("</tr>\r\n");

      for (String sp : sort(profiles.get(ig.getUrl()))) {
        b.append("<tr>");
        StructureDefinition sd = getContext().fetchResource(StructureDefinition.class, sp);
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

  protected void genScanOutputItem(ScanOutputItem item, String filename) throws IOException, FHIRException, EOperationOutcome {
    RenderingContext rc = new RenderingContext(getContext(), null, null, "http://hl7.org/fhir", "", null, RenderingContext.ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
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

  protected String genOutcome(List<ScanOutputItem> items, String src, String ig, String profile) {
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

  protected OperationOutcome exceptionToOutcome(Exception ex) throws IOException, FHIRException, EOperationOutcome {
    OperationOutcome op = new OperationOutcome();
    op.addIssue().setCode(OperationOutcome.IssueType.EXCEPTION).setSeverity(OperationOutcome.IssueSeverity.FATAL).getDetails().setText(ex.getMessage());
    RenderingContext rc = new RenderingContext(getContext(), null, null, "http://hl7.org/fhir", "", null, RenderingContext.ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    RendererFactory.factory(op, rc).render(op);
    return op;
  }

  protected void download(String address, String filename) throws IOException {
    SimpleHTTPClient http = new SimpleHTTPClient();
    HTTPResult res = http.get(address);
    res.checkThrowException();
    TextFile.bytesToFile(res.getContent(), filename);
  }

  protected void transfer(InputStream in, OutputStream out, int buffer) throws IOException {
    byte[] read = new byte[buffer]; // Your buffer size.
    while (0 < (buffer = in.read(read)))
      out.write(read, 0, buffer);
  }

  protected List<String> sort(Set<String> keys) {
    return keys.stream().sorted().collect(Collectors.toList());
  }

  protected void unzip(String zipFilePath, String destDirectory) throws IOException {
    File destDir = new File(destDirectory);
    if (!destDir.exists()) {
      destDir.mkdir();
    }
    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
    ZipEntry entry = zipIn.getNextEntry();
    // iterates over entries in the zip file
    while (entry != null) {
      String filePath = destDirectory + File.separator + entry.getName();

      final File zipEntryFile = new File(destDirectory, entry.getName());
      if (!zipEntryFile.toPath().normalize().startsWith(destDirectory)) {
        throw new RuntimeException("Entry with an illegal path: " + entry.getName());
      }

      if (!entry.isDirectory()) {
        // if the entry is a file, extract it
        extractFile(zipIn, filePath);
      } else {
        // if the entry is a directory, make the directory
        zipEntryFile.mkdir();
      }
      zipIn.closeEntry();
      entry = zipIn.getNextEntry();
    }
    zipIn.close();
  }

  protected void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] bytesIn = new byte[BUFFER_SIZE];
    int read;
    while ((read = zipIn.read(bytesIn)) != -1) {
      bos.write(bytesIn, 0, read);
    }
    bos.close();
  }

  protected String getGlobal(ImplementationGuide ig, String rt) {
    for (ImplementationGuide.ImplementationGuideGlobalComponent igg : ig.getGlobal()) {
      if (rt.equals(igg.getType()))
        return igg.getProfile();
    }
    return null;
  }
}
