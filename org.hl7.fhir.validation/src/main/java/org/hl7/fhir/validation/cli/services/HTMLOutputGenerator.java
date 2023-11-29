package org.hl7.fhir.validation.cli.services;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.ValidationRecord;

public class HTMLOutputGenerator {

  private List<ValidationRecord> records;

  public HTMLOutputGenerator(List<ValidationRecord> records) {
    super();
    this.records = records;
  }
  
  public String generate(long time) {
    
    StringBuilder b = new StringBuilder();
    b.append(genHeader(time));
    int i = 0;
    for (ValidationRecord f : records) {
      i++;
      b.append(genSummaryRow(i, f));
    }
    b.append("</table>\r\n");

    i = 0;
    int id = 0;
    for (ValidationRecord f : records) {
      i++;
      b.append(genStart(i, f));
      if (f.getMessages().size() > 0) {
        b.append(
            " <table class=\"grid\">\r\n"+
                "   <tr>\r\n"+
                "     <td><b>Path</b></td><td><b>Severity</b></td><td><b>Message</b></td>\r\n"+
            "   </tr>\r\n");
        for (ValidationMessage vm : f.getMessages()) {
          id++;
          b.append(genDetails(vm, "m"+id));
        }
        b.append("</table>\r\n");
      } else {
        b.append("<p>No Issues detected</p>\r\n");
      }
    }
    return b.toString();
  }    
   
  private String genHeader(long time) {
    int err = 0;
    int warn = 0;
    int info = 0;
    for (ValidationRecord f : records) {
      err = err + f.getErr();
      warn = warn + f.getWarn();
      info = info + f.getInfo();
    }

    return 
        "<!DOCTYPE HTML>\r\n"+
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n"+
        "<head>\r\n"+
        "  <title>Validation Results</title>\r\n"+
        "  <link href=\"http://hl7.org/fhir/fhir.css\" rel=\"stylesheet\"/>\r\n"+
        "  <style>\r\n"+
        "    span.flip  { background-color: #4CAF50; color: white; border: solid 1px #a6d8a8; padding: 2px }\r\n"+
        "  </style>\r\n"+
        "  <script>\r\n"+
        "    function flip(id) {\r\n"+
        "      var span = document.getElementById('s'+id);\r\n"+
        "      var div = document.getElementById(id);\r\n"+
        "      if (document.getElementById('s'+id).innerHTML == 'Show Reasoning') {\r\n"+
        "        div.style.display = 'block';\r\n"+
        "        span.innerHTML = 'Hide Reasoning';\r\n"+
        "      } else {\r\n"+
        "        div.style.display = 'none';\r\n"+
        "        span.innerHTML = 'Show Reasoning';\r\n"+
        "      }\r\n"+
        "    }\r\n"+
        "  </script>\r\n"+
        "</head>\r\n"+
        "<body style=\"margin: 20px; background-color: #ffffff\">\r\n"+
        " <h1>Validation Results</h1>\r\n"+
        " <p>"+err+" "+Utilities.pluralize("error", err)+", "+warn+" "+Utilities.pluralize("warning", warn)+", "+info+" "+Utilities.pluralize("hint", info)+". Generated "+now()+" by Validator "+VersionUtil.getVersionString()+" ("+time+"ms)</p>\r\n"+
        " <table class=\"grid\">\r\n"+
        "   <tr>\r\n"+
        "     <td><b>Filename</b></td><td><b>Errors</b></td><td><b>Warnings</b></td><td><b>Hints</b></td>\r\n"+
        "   </tr>\r\n";
  }

  private String now() {
    return DateFormat.getDateTimeInstance().format(new Date());
  }

  private String genSummaryRow(int i, ValidationRecord rec) {
    String color = colorForLevel(IssueSeverity.ERROR, false);
    if (rec.getErr() == 0) {
      color = "#EFFFEF";
    }       
    return       
        "   <tr style=\"background-color: "+color+"\">\r\n"+
        "     <td><a href=\"#;"+i+"\"><b>"+Utilities.escapeXml(rec.getLocation())+"</b></a></td><td><b>"+rec.getErr()+"</b></td><td><b>"+rec.getWarn()+"</b></td><td><b>"+rec.getInfo()+"</b></td>\r\n"+
        "   </tr>\r\n";
  }

  private String genStart(int i, ValidationRecord f) {
    String xlink = Utilities.isAbsoluteUrl(f.getLocation()) ? f.getLocation() : "file:"+f.getLocation();
    return 
        "<hr/>\r\n"+
        "<a name=\"l"+i+"\"> </a>\r\n"+
        "<h2><a href=\""+xlink+"\">"+Utilities.escapeXml(f.getLocation())+"</a></h2>\r\n";
  }
  
  
  private String genDetails(ValidationMessage vm, String id) {
    String path = vm.getLocation() == null ? "" : vm.getLocation()+ lineCol(vm); 
    String level = vm.isSlicingHint() ? "Slicing Information" : vm.isSignpost() ? "Process Info" : vm.getLevel().toCode();
    String color = colorForLevel(vm.getLevel(), vm.isSignpost());
    String mid = vm.getMessageId();
    String msg = vm.getHtml();
    String msgdetails = vm.isSlicingHint() ? vm.getSliceHtml() : vm.getHtml();
    if (vm.isSlicingHint()) {
      return 
          "   <tr style=\"background-color: "+color+"\">\r\n"+
          "     <td><b>"+path+"</b></td><td><b>"+level+"</b></td><td><b>"+msg+"</b> <span id=\"s"+id+"\" class=\"flip\" onclick=\"flip('"+id+"')\">Show Reasoning</span><div id=\""+id+"\" style=\"display: none\"><p>&nbsp;</p>"+msgdetails+"</div></td>\r\n"+
          "   </tr>\r\n";
          
    } else {
      return 
          "   <tr style=\"background-color: "+color+"\">\r\n"+
          "     <td><b>"+path+"</b></td><td><b>"+level+"</b></td><td title=\""+mid+"\"><b>"+msg+"</b></td>\r\n"+
          "   </tr>\r\n";
    }
  }
  
  private String lineCol(ValidationMessage vm) {
    return vm.getLine() > 0 ? " (l"+vm.getLine()+"/c"+vm.getCol()+")" : "";
  }
  

  private String colorForLevel(IssueSeverity level, boolean signpost) {
    if (signpost) {
      return "#d6feff";
    }
    switch (level) {
    case ERROR:
      return "#ffcccc";
    case FATAL:
      return "#ff9999";
    case WARNING:
      return "#ffebcc";
    default: // INFORMATION:
      return "#ffffe6";
    }
  }

  private String halfColorForLevel(IssueSeverity level, boolean signpost) {
    if (signpost) {
      return "#e3feff";
    }
    switch (level) {
    case ERROR:
      return "#ffeeee";
    case FATAL:
      return "#ffcccc";
    case WARNING:
      return "#fff4ee";
    default: // INFORMATION:
      return "#fffff2";
    }
  }


}
