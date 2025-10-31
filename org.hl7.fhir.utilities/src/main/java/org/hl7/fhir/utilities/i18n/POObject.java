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
  private List<String> flags = new ArrayList<>();

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

  public String getMsgstrFirst() {
    if (msgstr == null) {
      return null;
    }
    for (String s : msgstr) {
      if (!Utilities.noString(s)) {
        return s;
      }
    }
    return msgstr.get(0);
  }

  public List<String> getFlags() {
    return flags;
  }

}