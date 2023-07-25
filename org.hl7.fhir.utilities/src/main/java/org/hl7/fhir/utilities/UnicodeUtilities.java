package org.hl7.fhir.utilities;

import java.util.ArrayList;
import java.util.List;

public class UnicodeUtilities {

  public static class StateStackEntry {

    private char c;
    private int i;

    public StateStackEntry(char c, int i) {
      this.c = c;
      this.i = i;
    }
  }

  public static class StateStack {

    private List<StateStackEntry> list = new ArrayList<>();

    public void clear() {
      list.clear();      
    }

    public void push(char c, int i) {
      list.add(new StateStackEntry(c, i));      
    }

    public void popJustOne(CharSet oneSet) {
      if (!list.isEmpty() && oneSet.contains(list.get(list.size()-1).c)) {
        list.remove(list.size()-1);
      }
    }

    public void popOneAndOthers(CharSet oneSet, CharSet otherSet) {
      boolean found = false;
      for (StateStackEntry t : list) {
        if (oneSet.contains(t.c)) {
          found = true;
          break;
        }
      }
      if (found) {
        while (!list.isEmpty() && (oneSet.contains(list.get(list.size()-1).c) || otherSet.contains(list.get(list.size()-1).c))) {
          boolean done = oneSet.contains(list.get(list.size()-1).c);
          list.remove(list.size()-1);
          if (done) {
            break;
          }
        }
      }
    }

    public boolean empty() {
      return list.isEmpty();
    }

    public String summary(String src) {
      char ch = list.get(list.size()-1).c;
      int i = list.get(list.size()-1).i;
      String pt;
      if (i == 0) {
        pt = "";
      } else if (i < 5) {
        pt = " (preceding text = '"+src.substring(0, i)+"')";
      } else {
        pt = " (preceding text = '"+src.substring(i-5, i)+"')";
      }
      return "Unicode Character "+describe(ch)+" at index "+i+" has no terminating match"+pt;
    }

  
  }

  public static class CharSet {

    private char[] chars;

    public CharSet(char... chars) {
      this.chars = chars;
    }

    public boolean contains(char c) {
      for (char t : chars) {
        if (c == t) {
          return true;
        }
      }
      return false;
    }

  }

  public static final char LRE = '\u202a';
  public static final char RLE = '\u202b';
  public static final char PDF = '\u202c';
  public static final char LRO = '\u202d';
  public static final char RLO = '\u202e';
  public static final char LRI = '\u2066';
  public static final char RLI = '\u2067';
  public static final char FSI = '\u2068';
  public static final char PDI = '\u2069';
  public static final char LRM = '\u200E';
  public static final char RLM = '\u200F';
  public static final char ALM = '\u061C';
  public static final char PARA = '\n';

  private static CharSet allBiDiChars = new CharSet(LRE, RLE, PDF, LRO, RLO, LRI, RLI, FSI, PDI, LRM, RLM, ALM, PARA);

  public static boolean hasBiDiChars(String src) {
    for (char c : src.toCharArray()) {
      if (allBiDiChars.contains(c)) {
        return true;
      }
    }
    return false;
  }

  /**
   * returns null if src is well formed, or a description of a structure problem with bi-directional characters
   * @param src
   * @return
   */
  public static String checkUnicodeWellFormed(String src) {
    StateStack ss = new StateStack();
    for (int i = 0; i < src.length(); i++) {
      char c = src.charAt(i);
      if (allBiDiChars.contains(c)) {
        switch (c) {
        case PARA: 
          ss.clear();
          break;
        case LRO:
        case RLO:
          ss.push(c, i);
          break;
        case PDF:
          ss.popJustOne(new CharSet(LRE, RLE, LRO, RLO, LRM, RLM, ALM));
          break;
        case LRI:
        case RLI:
        case FSI:
          ss.push(c, i);
          break;
        case PDI:
          ss.popOneAndOthers(new CharSet(LRI, RLI, FSI), new CharSet(LRE, RLE, LRO, RLO, LRM, RLM, ALM));
          break;
        case LRM:
        case RLM:
        case ALM:
          ss.push(c, i);
          break;
        }
      }      
    }
    if (ss.empty()) {
      return null;      
    } else {
      return ss.summary(src);
    }
  }

  public static String describe(char c) {
    switch (c) {
    case LRE: return "LRE";
    case RLE: return "RLE";
    case PDF: return "PDF";
    case LRO: return "LRO";
    case RLO: return "RLO";
    case LRI: return "LRI";
    case RLI: return "RLI";
    case FSI: return "FSI";
    case PDI: return "PDI";
    case LRM: return "LRM";
    case RLM: return "RLM";
    case ALM: return "ALM";
    case PARA: return "PARA";
    }
    return String.valueOf(c);
  }

  public static Object replaceBiDiChars(String s) {
    if (s == null) {
      return null;
    }
    StringBuilder b = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (allBiDiChars.contains(c)) {
        b.append("|"+describe(c)+"|");
        
      } else {
        b.append(c);
      }
    }
    return b.toString();
  }
}
