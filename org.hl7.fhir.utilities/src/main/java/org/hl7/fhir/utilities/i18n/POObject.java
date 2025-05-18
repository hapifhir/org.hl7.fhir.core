package org.hl7.fhir.utilities.i18n;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;

public class POObject {
  private boolean orphan = true;
  private boolean duplicate;
  private String id;
  private String msgid;
  private String oldMsgId;
  private String msgidPlural;
  private String comment;
  private List<String> msgstr  = new ArrayList<String>();

  public POObject() {
    super();
  }
  
  public POObject(String id, String src, String tgt) {
    super();
    this.id = id;
    this.comment = id;
    this.msgid = src;
    if (tgt != null) {
      this.msgstr.add(tgt);
    }
  }
  public boolean isOrphan() {
    return orphan;
  }
  public void setOrphan(boolean orphan) {
    this.orphan = orphan;
  }
  public boolean isDuplicate() {
    return duplicate;
  }
  public void setDuplicate(boolean duplicate) {
    this.duplicate = duplicate;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getMsgid() {
    return msgid;
  }
  public void setMsgid(String msgid) {
    this.msgid = msgid;
  }
  public String getOldMsgId() {
    return oldMsgId;
  }
  public void setOldMsgId(String oldMsgId) {
    this.oldMsgId = oldMsgId;
  }
  public String getMsgidPlural() {
    return msgidPlural;
  }
  public void setMsgidPlural(String msgidPlural) {
    this.msgidPlural = msgidPlural;
  }
  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }
  public List<String> getMsgstr() {
    return msgstr;
  }
  
  public static List<POObject> loadPOFile(List<String> prefixes, InputStream source) throws FileNotFoundException, IOException {
    return loadPOFile(prefixes, FileUtilities.streamToLines(source));
  }
  
  public static List<POObject> loadPOFile(List<String> prefixes, String dest) throws FileNotFoundException, IOException {
    return loadPOFile(prefixes, FileUtilities.fileToLines(new File(dest)));
  }
  
  private static List<POObject> loadPOFile(List<String> prefixes, String[] lines) throws FileNotFoundException, IOException {
    List<POObject> list = new ArrayList<POObject>();
    POObject obj = null;
    for (String line : lines) {
      if (Utilities.noString(line)) {
        // else 
      } else if (line.startsWith("#:")) {
        if (obj == null || obj.getId() != null) {
          obj = new POObject();
          list.add(obj);
        }
        obj.setId(line.substring(2).trim());  
      } else if (line.startsWith("# ")) {
        if (obj == null || obj.getComment() != null) {
          obj = new POObject();
          list.add(obj);
        }
        obj.setComment(line.substring(1).trim());
        if (obj.getComment().contains("!!when")) {
          obj.setOldMsgId(obj.getComment().substring(obj.getComment().indexOf("!!when")));
          obj.setComment(obj.getComment().substring(0, obj.getComment().indexOf("!!when")-1));
          obj.setOldMsgId(obj.getOldMsgId().substring(obj.getOldMsgId().indexOf(": ")+2).trim());
          obj.setOldMsgId(obj.getOldMsgId().substring(0, obj.getOldMsgId().length()-1));
        }
      } else if (obj == null) {
        prefixes.add(line);  
      } else if (line.startsWith("#|")) {
        // retired use of #| because it caused problems with the tools
        obj.setOldMsgId(line.substring(2).trim());
        if (obj.getOldMsgId().startsWith("msgid ")) {
          obj.setOldMsgId(trimQuotes(obj.getOldMsgId().substring(6)));
        }
      } else if (line.startsWith("msgid ")) {
        obj.setMsgid(trimQuotes(line.substring(5).trim()));
        if (obj.getMsgid().endsWith("("+obj.getId()+")")) {
          obj.setMsgid(obj.getMsgid().substring(0, obj.getMsgid().length() - (obj.getId().length()+3)));
        }
      } else if (line.startsWith("msgid_plural ")) {
        obj.setMsgidPlural(trimQuotes(line.substring(12).trim()));
      } else if (line.startsWith("msgstr ")) {
        obj.getMsgstr().add(trimQuotes(line.substring(6).trim()));
      } else if (line.startsWith("msgctxt ")) {
        // ignore this
      } else if (line.startsWith("msgstr[")) {
        String s = line.substring(7);
        int i = s.indexOf("]");
        int c = Integer.valueOf(s.substring(0, i));
        s = trimQuotes(s.substring(i+1).trim());
        while (s.startsWith("!!")) {
          s = s.substring(2);
        }
        if (c != obj.getMsgstr().size()) {
          System.out.println("index issue");   
        } else { // if (!Utilities.noString(s)) {
          obj.getMsgstr().add(s);          
        }
      } else {
        System.out.println("unknown line: "+line);          
      }
    }
    return list;
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


  public static int savePOFile(List<String> prefixes, String dest, List<POObject> objects, int count, int noTrans) throws IOException {
    prefixes.clear();
    
    StringBuilder b = new StringBuilder();
    for (String p : prefixes) {
      b.append(p);
      b.append("\r\n");
    }
    b.append("\r\n");
    for (POObject o : objects) {
      // for POEdit
      if (o.getOldMsgId() != null) {
        b.append("# "+o.getComment()+" (!!when last translated was: "+o.getOldMsgId()+")\r\n");        
      } else {
        b.append("# "+o.getComment()+"\r\n");
      }
      b.append("#: "+o.getId()+"\r\n");
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