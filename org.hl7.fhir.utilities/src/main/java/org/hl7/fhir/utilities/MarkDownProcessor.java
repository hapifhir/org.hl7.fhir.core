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
    switch (dialect) {
    case DARING_FIREBALL : return Processor.process(source); 
    case COMMON_MARK : return processCommonMark(source); 
    default: throw new Error("Unknown Markdown Dialect: "+dialect.toString()+" at "+context); 
    }
  }

  private String processCommonMark(String source) {
    Set<Extension> extensions = Collections.singleton(TablesExtension.create());
    Parser parser = Parser.builder().extensions(extensions).build();
    Node document = parser.parse(source);
    HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
    String html = renderer.render(document);
    html = html.replace("<table>", "<table class=\"grid\">");
    return html;  
  }
  
}