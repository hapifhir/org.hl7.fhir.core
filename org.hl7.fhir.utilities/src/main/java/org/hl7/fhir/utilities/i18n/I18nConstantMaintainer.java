package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class I18nConstantMaintainer {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    rename("/Users/grahamegrieve/work/core", "SD_GRID_HEAD_CARD", "GENERAL_CARD");
    replace("/Users/grahamegrieve/work/core", "SD_HEAD_CARD", "GENERAL_CARD");      
    replace("/Users/grahamegrieve/work/core", "STRUC_DEF_CARD", "GENERAL_CARD");      

    rename("/Users/grahamegrieve/work/core", "OP_DEF_CARD", "GENERAL_CARDINALITY");
    replace("/Users/grahamegrieve/work/core", "QUEST_CARD", "GENERAL_CARDINALITY");  
    
//    rename("/Users/grahamegrieve/work/core", "CODEPROP_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "CODE_SYS_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "CONC_MAP_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "DATA_REND_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "DIAG_REP_REND_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "OP_OUT_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "QUEST_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "TX_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "VALUE_SET_CODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "DATA_REND_GETCODE", "GENERAL_CODE");
    replace("/Users/grahamegrieve/work/core", "LIST_REND_CODE", "GENERAL_CODE");
  }

  private static void replace(String dir, String src, String tgt) throws FileNotFoundException, IOException {
    System.out.println("Replace "+src+" with "+tgt+" in "+dir);
    int count = replace(new File(dir), src, tgt);
    System.out.println("Done. "+count+" files changed");    
  }

  private static int replace(File file, String src, String tgt) throws FileNotFoundException, IOException {
    int count = 0;
    if (file.isDirectory()) {
      for (File f : file.listFiles()) {
        count = count + replace(f, src, tgt);
      }
    } else {
      String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
      if ("java".equals(ext)) {
        String source = TextFile.fileToString(file);
        boolean mod = false;
        if (source.contains("I18nConstants."+src)) {
          source = source.replace("I18nConstants."+src, "I18nConstants."+tgt);
          mod = true;
        } 
        if (source.contains("RenderingI18nContext."+src)) {
          source = source.replace("RenderingI18nContext."+src, "RenderingI18nContext."+tgt);
          mod = true;
        } 
        if (source.contains("RenderingContext."+src)) {
          source = source.replace("RenderingContext."+src, "RenderingContext."+tgt);
          mod = true;
        } 
        if (file.getName().equals("I18nConstants.java") && source.contains(src)) {
          source = removeLines(source, src);
          mod = true;
        } 
        if (file.getName().equals("RenderingI18nContext.java") && source.contains(src)) {
          source = removeLines(source, src);
          mod = true;
        } 
        if (mod) {
          TextFile.stringToFile(source, file);
          count++;
        }
      
      } else if (Utilities.existsInList(ext, "properties")) {
        String source = TextFile.fileToString(file);
        if (source.contains(src)) {
          source = removeLines(source, src);
          TextFile.stringToFile(source, file);
          count++;
        }
      }
    }
    return count;
  }
  
  private static String removeLines(String source, String src) {
    String[] lines = Utilities.splitLines(source);
    StringBuilder b = new StringBuilder();
    for (String s : lines) {
      if (!s.contains(src)) {
        b.append(s);
        b.append("\r\n");
      }
    }
    return b.toString();
  }

  private static void rename(String dir, String src, String tgt) throws FileNotFoundException, IOException {
    System.out.println("Rename "+src+" to "+tgt+" in "+dir);
    int count = rename(new File(dir), src, tgt);
    System.out.println("Done. "+count+" files changed");    
  }

  private static int rename(File file, String src, String tgt) throws FileNotFoundException, IOException {
    int count = 0;
    if (file.isDirectory()) {
      for (File f : file.listFiles()) {
        count = count + rename(f, src, tgt);
      }
    } else {
      String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
      if ("java".equals(ext)) {
        String source = TextFile.fileToString(file);
        boolean mod = false;
        if (source.contains("I18nConstants."+src)) {
          source = source.replace("I18nConstants."+src, "I18nConstants."+tgt);
          mod = true;
        } 
        if (source.contains("RenderingI18nContext."+src)) {
          source = source.replace("RenderingI18nContext."+src, "RenderingI18nContext."+tgt);
          mod = true;
        } 
        if (source.contains("RenderingContext."+src)) {
          source = source.replace("RenderingContext."+src, "RenderingContext."+tgt);
          mod = true;
        } 
        if (file.getName().equals("I18nConstants.java") && source.contains(src)) {
          source = source.replace(src, tgt);
          mod = true;
        } 
        if (file.getName().equals("RenderingI18nContext.java") && source.contains(src)) {
          source = source.replace(src, tgt);
          mod = true;
        } 
        if (mod) {
          TextFile.stringToFile(source, file);
          count++;
        }
      
      } else if (Utilities.existsInList(ext, "po", "properties")) {
        String source = TextFile.fileToString(file);
        if (source.contains(src)) {
          source = source.replace(src, tgt);
          TextFile.stringToFile(source, file);
          count++;
        }
      }
    }
    return count;
  }
}
