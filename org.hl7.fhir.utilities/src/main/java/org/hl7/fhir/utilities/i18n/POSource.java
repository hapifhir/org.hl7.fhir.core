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

@Slf4j
public class POSource {

  private String lang;
  private List<POObject> entries = new ArrayList<>();
  private List<String> prefixes = new ArrayList<>();
  
  
  public String getLang() {
    return lang;
  }

  public List<POObject> getEntries() {
    return entries;
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
    POSource res = new POSource();
    POObject obj = null;
    int i = 0;
    while (i < lines.length) {
      String line = lines[i];
      if (Utilities.noString(line)) {
        // else 
      } else if (line.startsWith("#:")) {
        if (obj == null || obj.getId() != null) {
          obj = new POObject();
          res.entries.add(obj);
        }
        obj.setId(line.substring(2).trim());  
      } else if (line.startsWith("# ") && line.contains(" -> ")) {
        res.lang = line.substring(line.indexOf("->")+2).trim();
      } else if (line.startsWith("# ")) {
        if (obj == null || obj.getComment() != null) {
          obj = new POObject();
          res.entries.add(obj);
        }
        obj.setComment(line.substring(1).trim());
        if (obj.getComment().contains("!!when")) {
          obj.setOldMsgId(obj.getComment().substring(obj.getComment().indexOf("!!when")));
          obj.setComment(obj.getComment().substring(0, obj.getComment().indexOf("!!when")-1));
          obj.setOldMsgId(obj.getOldMsgId().substring(obj.getOldMsgId().indexOf(": ")+2).trim());
          obj.setOldMsgId(obj.getOldMsgId().substring(0, obj.getOldMsgId().length()-1));
        }
      } else if (obj == null) {
        res.prefixes.add(line);  
      } else if (line.startsWith("#,")) {
        // retired use of #| because it caused problems with the tools
        String s = line.substring(2).trim();
        for (String f : s.split("\\,")) {
          obj.getFlags().add(f.trim());
        }
      } else if (line.startsWith("#|")) {
        // retired use of #| because it caused problems with the tools
        String s = line.substring(2).trim();
        if (s.startsWith("msgid ")) {
          s = trimQuotes(s.substring(6));
        }
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += trimQuotes(lines[i]);
        }
        obj.setOldMsgId(s);
      } else if (line.startsWith("msgid ")) {
        String s = trimQuotes(line.substring(5).trim());
        if (s.endsWith("("+obj.getId()+")")) {
          s = s.substring(0, s.length() - (obj.getId().length()+3));
        }
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += trimQuotes(lines[i]);
        }
        obj.setMsgid(s);
      } else if (line.startsWith("msgid_plural ")) {
        String s = trimQuotes(line.substring(12).trim());
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += trimQuotes(lines[i]);
        }
        obj.setMsgidPlural(s);
      } else if (line.startsWith("msgstr ")) {
        String s = trimQuotes(line.substring(6).trim());
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += trimQuotes(lines[i]);
        }
        obj.getMsgstr().add(s);
      } else if (line.startsWith("msgctxt ")) {
        // ignore this
      } else if (line.startsWith("msgstr[")) {
        String s = line.substring(7);
        int ii = s.indexOf("]");
        int c = Integer.valueOf(s.substring(0, ii));
        s = trimQuotes(s.substring(ii+1).trim());
        while (i < lines.length-1 && lines[i+1].startsWith("\"")) {
          i++;
          s += trimQuotes(lines[i]);
        }
        while (s.startsWith("!!")) {
          s = s.substring(2);
        }
        if (c != obj.getMsgstr().size()) {
          log.warn("index issue");
        } else { // if (!Utilities.noString(s)) {
          obj.getMsgstr().add(s);          
        }
      } else {
        log.warn("unknown line: "+line);
      }
      i++;
    }
    return res;
  }


  private static String trimQuotes(String s) {
    s = s.trim();
    if (s.startsWith("\"")) {
      s = s.substring(1);
    }
    if (s.endsWith("\"")) {
      s = s.substring(0, s.length()-1);
    }
    return s.trim().replace("\\\"", "\"");
  }


  public int savePOFile(String dest, int count, int noTrans) throws IOException {
    // source.prefixes.clear();
    
    StringBuilder b = new StringBuilder();
    for (String p : prefixes) {
      b.append(p);
      b.append("\r\n");
    }
    b.append("\r\n");
    for (POObject o : entries) {
      // for POEdit
      if (o.getOldMsgId() != null) {
        b.append("# "+o.getComment()+" (!!when last translated was: "+o.getOldMsgId()+")\r\n");        
      } else {
        b.append("# "+o.getComment()+"\r\n");
      }
      b.append("#: "+o.getId()+"\r\n");
      if (!o.getFlags().isEmpty()) {
        b.append("#, "+ CommaSeparatedStringBuilder.join(",", o.getFlags()));
      }
      if (o.isDuplicate()) {
        b.append("msgctxt \""+o.getId()+"\"\r\n");        
      } 
      String m = Utilities.noString(o.getMsgid()) ? "-- no content: do not translate #"+(++noTrans )+" --" : o.getMsgid(); 
      b.append("msgid \""+wrapQuotes(m)+"\"\r\n");
      if (o.getMsgidPlural() != null) {
        b.append("msgid_plural \""+wrapQuotes(o.getMsgidPlural())+"\"\r\n"); 
        while (o.getMsgstr().size() < count) {
          o.getMsgstr().add("");
        }
        for (int i = 0; i < o.getMsgstr().size(); i++) {
          String s = o.getMsgstr().get(i);
//          if (tfxMode && Utilities.noString(s)) {
//            s = Utilities.noString(i == 0 ? o.msgid : o.msgidPlural) ? "-- no content: do not translate --" : "";
//          }
          b.append("msgstr["+i+"] \""+wrapQuotes(s)+"\"\r\n");
        }
      } else {
        if (o.getMsgstr().size() == 0) {
          b.append("msgstr \"\"\r\n");                  
        } else {
          b.append("msgstr \""+wrapQuotes(o.getMsgstr().get(0))+"\"\r\n");                            
        }
      } 
      b.append("\r\n");
    }
    FileUtilities.stringToFile(b.toString(), dest);
    return noTrans;
  }


  private static String wrapQuotes(String s) {
    return s.replace("\"", "\\\"");
  }

}
