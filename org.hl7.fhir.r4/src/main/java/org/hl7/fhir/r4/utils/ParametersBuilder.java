package org.hl7.fhir.r4.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.MetadataResource;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.utilities.TextFile;

/**
 * Used to take an overload dump from tx.fhir.org and turn it into a parameters resource
 * 
 * @author grahamegrieve
 *
 */
public class ParametersBuilder {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    new ParametersBuilder(args[0], args[1]).process(args[2]);
  }



  private String folder;
  private String baseId;

  protected ParametersBuilder(String folder, String baseId) {
    super();
    this.folder = folder;
    this.baseId = baseId;
  }

  private void process(String output) throws FileNotFoundException, IOException {
    Parameters p = new Parameters();
    Set<String> ids = new HashSet<>();
    for (File f : new File(folder).listFiles()) {
      if (f.getName().startsWith(baseId)) {
        if (f.getName().startsWith(baseId)) {
          byte[] cnt = TextFile.fileToBytes(f);
          cnt = shaveZeros(cnt); // bug in tx.fhir.org
          MetadataResource r = (MetadataResource) new JsonParser().parse(cnt);
          if (!ids.contains(r.getUrl()+"|"+r.getVersion())) {
            ids.add(r.getUrl()+"|"+r.getVersion());
            p.addParameter().setName("tx-resource").setResource(r);
          }
        }
      }
    }
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(output), p);
  }

  private byte[] shaveZeros(byte[] cnt) {
    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] == 0) {
        return Arrays.copyOf(cnt, i-1);
      }
    }
    return cnt;
  }
}
