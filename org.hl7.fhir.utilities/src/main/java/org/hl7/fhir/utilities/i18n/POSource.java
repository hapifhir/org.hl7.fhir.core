package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;

import static org.hl7.fhir.utilities.i18n.POUtilities.isOutdated;

@Slf4j
public class POSource {

  private String lang;
  private List<POObject> poObjects = new ArrayList<>();
  private List<String> prefixes = new ArrayList<>();

  public String getLang() {
    return lang;
  }

  public List<POObject> getPOObjects() {
    return poObjects;
  }

  public List<String> getPrefixes() {
    return prefixes;
  }

  public static POSource loadPOFile(InputStream source) throws FileNotFoundException, IOException {
    return loadPOFile(FileUtilities.streamToLines(source));
  }
  
  public static POSource loadPOFile(String dest) throws FileNotFoundException, IOException {
    return loadPOFile(FileUtilities.fileToLines(new File(dest)));
  }
  
  private static POSource loadPOFile(String[] lines) throws FileNotFoundException, IOException {
    POSource poSource = new POSource();
    POObject poObject = null;
    int i = 0;
    while (i < lines.length) {
      String line = lines[i];
      if (Utilities.noString(line)) {
        // else 
      } else if (line.startsWith("#:")) {
        if (poObject == null || poObject.getId() != null) {
          poObject = new POObject();
          poSource.poObjects.add(poObject);
        }
        poObject.setId(line.substring(2).trim());
      } else if (line.startsWith("# ") && line.contains(" -> ")) {
        poSource.lang = line.substring(line.indexOf("->")+2).trim();
      } else if (line.startsWith("# ")) {
        if (poObject == null || poObject.getComment() != null) {
          poObject = new POObject();
          poSource.poObjects.add(poObject);
        }
        poObject.setComment(line.substring(1).trim());
        if (poObject.getComment().contains("!!when")) {
          poObject.setOldMsgId(poObject.getComment().substring(poObject.getComment().indexOf("!!when")));
          poObject.setComment(poObject.getComment().substring(0, poObject.getComment().indexOf("!!when")-1));
          poObject.setOldMsgId(poObject.getOldMsgId().substring(poObject.getOldMsgId().indexOf(": ")+2).trim());
          poObject.setOldMsgId(poObject.getOldMsgId().substring(0, poObject.getOldMsgId().length()-1));
        }
      } else if (poObject == null) {
        poSource.prefixes.add(line);
      } else if (line.startsWith("#,")) {
        // retired use of #| because it caused problems with the tools
        String flags = line.substring(2).trim();
        for (String flag : flags.split(",")) {
          poObject.getFlags().add(flag.trim());
        }
      } else if (line.startsWith("#|")) {
        // retired use of #| because it caused problems with the tools
        String s = line.substring(2).trim();
        if (s.startsWith("msgid ")) {
          s = POUtilities.trimQuotes(s.substring(6));
        }
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += POUtilities.trimQuotes(lines[i]);
        }
        poObject.setOldMsgId(s);
      } else if (line.startsWith("msgid ")) {
        String s = POUtilities.trimQuotes(line.substring(5).trim());
        if (s.endsWith("("+poObject.getId()+")")) {
          s = s.substring(0, s.length() - (poObject.getId().length()+3));
        }
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += POUtilities.trimQuotes(lines[i]);
        }
        poObject.setMsgid(s);
      } else if (line.startsWith("msgid_plural ")) {
        String s = POUtilities.trimQuotes(line.substring(12).trim());
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += POUtilities.trimQuotes(lines[i]);
        }
        poObject.setMsgidPlural(s);
      } else if (line.startsWith("msgstr ")) {
        String s = POUtilities.trimQuotes(line.substring(6).trim());
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += POUtilities.trimQuotes(lines[i]);
        }
        poObject.getMsgstr().add(s);
      } else if (line.startsWith("msgctxt ")) {
        // ignore this
      } else if (line.startsWith("msgstr[")) {
        String s = line.substring(7);
        int ii = s.indexOf("]");
        int c = Integer.valueOf(s.substring(0, ii));
        s = POUtilities.trimQuotes(s.substring(ii+1).trim());
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += POUtilities.trimQuotes(lines[i]);
        }
        while (isOutdated(s)) {
          s = s.substring(2);
        }
        if (c != poObject.getMsgstr().size()) {
          log.warn("index issue");
        } else { // if (!Utilities.noString(s)) {
          poObject.getMsgstr().add(s);
        }
      } else {
        log.warn("unknown line: "+line);
      }
      i++;
    }
    return poSource;
  }


  public int savePOFile(String poFilePath, int numberOfPlurals, int noTrans) throws IOException {
    // source.prefixes.clear();
    
    StringBuilder sb = new StringBuilder();
    for (String prefix : prefixes) {
      sb.append(prefix);
      sb.append("\r\n");
    }
    sb.append("\r\n");
    for (POObject poObject : poObjects) {
      // for POEdit
      if (poObject.getOldMsgId() != null) {
        sb.append("# "+poObject.getComment()+" (!!when last translated was: "+poObject.getOldMsgId()+")\r\n");
      } else {
        sb.append("# "+poObject.getComment()+"\r\n");
      }
      sb.append("#: "+poObject.getId()+"\r\n");
      if (!poObject.getFlags().isEmpty()) {
        sb.append("#, "+ CommaSeparatedStringBuilder.join(",", poObject.getFlags()) + "\r\n");
      }
      if (poObject.isDuplicate()) {
        sb.append("msgctxt \""+poObject.getId()+"\"\r\n");
      } 
      String m = Utilities.noString(poObject.getMsgid()) ? "-- no content: do not translate #"+(++noTrans )+" --" : poObject.getMsgid();
      sb.append("msgid \""+ POUtilities.escapeNonEscapedQuotes(m)+"\"\r\n");
      if (poObject.getMsgidPlural() != null) {
        sb.append("msgid_plural \""+ POUtilities.escapeNonEscapedQuotes(poObject.getMsgidPlural())+"\"\r\n");
        while (poObject.getMsgstr().size() < numberOfPlurals) {
          poObject.getMsgstr().add("");
        }
        for (int i = 0; i < poObject.getMsgstr().size(); i++) {
          String s = poObject.getMsgstr().get(i);
//          if (tfxMode && Utilities.noString(s)) {
//            s = Utilities.noString(i == 0 ? o.msgid : o.msgidPlural) ? "-- no content: do not translate --" : "";
//          }
          sb.append("msgstr["+i+"] \""+ POUtilities.escapeNonEscapedQuotes(s)+"\"\r\n");
        }
      } else {
        if (poObject.getMsgstr().size() == 0) {
          sb.append("msgstr \"\"\r\n");
        } else {
          sb.append("msgstr \""+ POUtilities.escapeNonEscapedQuotes(poObject.getMsgstr().get(0))+"\"\r\n");
        }
      } 
      sb.append("\r\n");
    }
    FileUtilities.stringToFile(sb.toString(), poFilePath);
    return noTrans;
  }

}
