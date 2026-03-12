package org.hl7.fhir.convertors.misc.npm;

import net.sourceforge.plantuml.abel.LinkStrategy;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class TemplatePackageWrangler {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    FileUtilities.clearDirectory(args[1]);
    Set<String> packages = new HashSet<>();
    packages.addAll(JsonParser.parseObject(new File("/Users/grahamegrieve/temp/npm-packages.json")).getStrings("packages"));
    try {
      StringBuilder sh = new StringBuilder();
      sh.append("set -e\n");
      new TemplatePackageWrangler().execute(ManagedFileAccess.file(args[0]), args[1], sh, packages);
      FileUtilities.stringToFile(sh.toString(), Utilities.path(args[1], "publish.sh"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    JsonObject json = new JsonObject();
    for (String p : Utilities.sorted(packages)) {
      json.forceArray("packages").add(p);
    }
    JsonParser.compose(json, new File("/Users/grahamegrieve/temp/npm-packages.json"), true);
  }

  private void execute(File file, String dest, StringBuilder sh, Set<String> packageList) throws IOException {
    Map<String, String> packages = new HashMap<>();
    try (Stream<String> lines = Files.lines(Path.of("/Users/grahamegrieve/temp/package-list.txt"))) {
      lines.forEach(name -> {
        try {
          int splitAt = -1;
          for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == '-' && Character.isDigit(name.charAt(i + 1))) {
              splitAt = i;
              break;
            }
          }
          if (splitAt > -1) {
            String id = name.substring(0, splitAt);
            String version = name.substring(splitAt + 1);
            if (!packages.containsKey(id)) {
              packages.put(id, version);
            } else {
              String v = packages.get(id);
              if (VersionUtilities.isThisOrLater(v, version, VersionUtilities.VersionPrecision.FULL)) {
                packages.put(id, version);
              }
            }
          }
        } catch (Exception e) {
          // nothing
        }
      });
    }

    for (String id : Utilities.sorted(packages.keySet())) {
      if (packages.containsKey(id)) {
        continue;
      }
      packageList.add(id);
      String fn = id + "-" + packages.get(id) + ".tgz";
      File f = new File(Utilities.path(file.getAbsolutePath(), fn));
      NpmPackage npm = NpmPackage.fromPackage(new FileInputStream(f));
      String v = npm.version();
      File tgt = new File(Utilities.path(dest, id + "#" + v));
      if (!tgt.exists()) {
        FileUtilities.createDirectory(tgt);
        npm.unPack(tgt.getAbsolutePath());
        File p = new File(Utilities.path(tgt, "package"));
        JsonParser.compose(npm.getNpm(), new File(Utilities.path(tgt, "package.json")), true);
        FileUtilities.copyFiles(p.getAbsolutePath(), tgt.getAbsolutePath());
        FileUtilities.deleteAllFiles(p.getAbsolutePath());
        p.delete();
        sh.append("echo " + id + "#" + v + "\n");
        sh.append("cd " + id + "#" + v + "\n");
        sh.append("npm publish"+(v.contains("-") ? " --tag beta" : "")+"\n");
        sh.append("cd ..\n");
      }
    }
  }

}
