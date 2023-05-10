package org.hl7.fhir.utilities;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import com.github.rjeschke.txtmark.Processor;

public class MarkDownProcessor {

  public enum Dialect {DARING_FIREBALL, COMMON_MARK};
  
  private Dialect dialect;
  
  
  public MarkDownProcessor(Dialect dialect) {
    super();
    this.dialect = dialect;
  }


  public String process(String source, String context) {
    if (source == null) {
      return null;
    }
    if ("".equals(source)) {
      return "";
    }
    switch (dialect) {
    case DARING_FIREBALL : return Processor.process(source); 
    case COMMON_MARK : return processCommonMark(preProcess(source)); 
    default: throw new Error("Unknown Markdown Dialect: "+dialect.toString()+" at "+context); 
    }
  }

  /**
   * Returns true if this is intended to be processed as markdown
   * 
   * this is guess, based on textual analysis of the content. 
   * 
   * Uses of this routine:
   *   In general, the main use of this is to decide to escape the string so erroneous markdown processing doesn't munge characters
   *   If it's a plain string, and it's being put into something that's markdown, then you should escape the content
   *   If it's markdown, but you're not sure whether to process it as markdown
   *   
   * The underlying problem is that markdown processing plain strings is problematic because some technical characters might 
   * get lost. So it's good to escape them... but if it's meant to be markdown, then it'll get trashed. 
   * 
   * This method works by looking for character patterns that are unlikely to occur outside markdown - but it's still only unlikely
   *  
   * @param content
   * @return
   */
  // todo: dialect dependency?
  public boolean isProbablyMarkdown(String content, boolean mdIfParagrapghs) {
    if (mdIfParagrapghs && content.contains("\n")) {
      return true;
    }
    String[] lines = content.split("\\r?\\n");
    for (String s : lines) {
      if (s.startsWith("* ") || isHeading(s) || s.startsWith("1. ") || s.startsWith("    ")) {
        return true;
      }
      if (s.contains("```") || s.contains("~~~") || s.contains("[[[")) {
        return true;
      }
      if (hasLink(s)) {
        return true;
      }
      if (hasTextSpecial(s, '*') || hasTextSpecial(s, '_') ) {
        return true;
      }
    }
      
    return false;
  }
  
  private boolean isHeading(String s) {
    if (s.length() > 7 && s.startsWith("###### ") && !Character.isWhitespace(s.charAt(7))) {
      return true;
    }
    if (s.length() > 6 && s.startsWith("##### ") && !Character.isWhitespace(s.charAt(6))) {
      return true;
    }
    if (s.length() > 5 && s.startsWith("#### ") && !Character.isWhitespace(s.charAt(5))) {
      return true;
    }
    if (s.length() > 4 && s.startsWith("### ") && !Character.isWhitespace(s.charAt(4))) {
      return true;
    }
    if (s.length() > 3 && s.startsWith("## ") && !Character.isWhitespace(s.charAt(3))) {
      return true;
    }
    //
    // not sure about this one. # [string] is something that could easily arise in non-markdown, 
    // so this appearing isn't enough to call it markdown
    //
//    if (s.length() > 2 && s.startsWith("# ") && !Character.isWhitespace(s.charAt(2))) {
//      return true;
//    }
    return false;
  }


  private boolean hasLink(String s) {
    int left = -1;
    int mid = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '[') {
        mid = -1;
        left = i;
      } else if (left > -1 && i < s.length()-1 && c == ']' && s.charAt(i+1) == '(') {
        mid = i;
      } else if (left > -1 && c == ']') {
        left = -1;
      } else if (left > -1 && mid > -1 && c == ')') {
        return true;
      } else if (mid > -1 && c == '[' || c == ']' || (c == '(' && i > mid+1)) {
        left = -1;
        mid = -1;
      }
    }

    // Detect autolinks, which should start with a scheme, followed by a colon, followed by some content. Whitespace
    // is not allowed and for practical purposes, the scheme is considered to consist of lowercase ASCII characters
    // only.
    Pattern autolinkPattern = Pattern.compile("<[a-z]+:[^\\s]+>");
    Matcher autolinkMatcher = autolinkPattern.matcher(s);
    return autolinkMatcher.find();
  }


  private boolean hasTextSpecial(String s, char c) {
    boolean second = false;
    for (int i = 0; i < s.length(); i++) {
      char prev = i == 0 ? ' ' : s.charAt(i-1);
      char next = i < s.length() - 1 ? s.charAt(i+1) : ' ';
      if (s.charAt(i) != c) {
        // nothing
      } else if (second) {
        if (Character.isWhitespace(next) && (isPunctation(prev) || Character.isLetterOrDigit(prev))) {
          return true;
        }
        second = false;        
      } else {
        if (Character.isWhitespace(prev) && (isPunctation(next) || Character.isLetterOrDigit(next))) {
          second = true;
        }            
      }
    }
    return false;
  }


  private boolean isPunctation(char ch) {
    return Utilities.existsInList(ch, '.', ',', '!', '?');
  }


  /**
   * This deals with a painful problem created by the intersection of previous publishing processes 
   * and the way commonmark specifies that < is handled in content. For control reasons, the FHIR specification does 
   * not allow raw html tags in the markdown 
   * 
   * This check finds any raw html tag and prepends \ to it so that it renders as a < (e.g. gets escaped in the output
   * HTML)
   * 
   * This is public to enable testing (not for direct use otherwise)
   * 
   * @param source
   * @return
   */
  public static String preProcess(String source) {
    // Escape all unescaped open and closing tags ('<' or '</', followed by an ASCII letter, followed by ASCII 
    // letters, digits and/or hyphens).
    String processed = source.replaceAll("(?<!\\\\)<(\\/)?([A-Za-z][A-Za-z0-9-]*[\\s>])", "\\\\<$1$2");

    // Escape all other HTML tags: HTML comments, processing instructions, declarations and CDATA sections -- 
    // everything starting with '<?' or '<!'.
    processed = processed.replaceAll("<(!|\\?)", "\\\\<$1");

    return processed;
  }

  private String processCommonMark(String source) {
    Set<Extension> extensions = Collections.singleton(TablesExtension.create());
    Parser parser = Parser.builder().extensions(extensions).build();
    Node document = parser.parse(source);
    HtmlRenderer renderer = HtmlRenderer.builder().escapeHtml(true).extensions(extensions).build();
    String html = renderer.render(document);
    html = html.replace("<table>", "<table class=\"grid\">");
    return html;  
  }


  public static boolean isSimpleMarkdown(String description) {
    return !description.contains("\n");
  }
  
  public static String makeStringSafeAsMarkdown(String content) {
    StringBuilder b = new StringBuilder();
    for (char c : content.toCharArray()) {
      if (isEscableMarkdownChar(c)) {
        b.append('\\');
      }
      b.append(c);
    }
    return b.toString();
  }
  
  private static boolean isEscableMarkdownChar(char c) {
    switch (c) {
    case '*':
    case '&':
    case '#':
    case '[':
    case '>':
    case '<':
    case '`':
      return true;  
    default: 
      return false;
    }
  }


  public static String makeMarkdownForString(String content) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < content.length(); i++) {
      char c = content.charAt(i);
      if (c != '\\' || i == content.length() - 1 || !isEscableMarkdownChar(content.charAt(i+1))) {
        b.append(c);
      }
    }
    return b.toString();
  }

}