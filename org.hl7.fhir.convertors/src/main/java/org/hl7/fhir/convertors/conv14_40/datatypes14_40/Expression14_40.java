package org.hl7.fhir.convertors.conv14_40.datatypes14_40;

public class Expression14_40 {
  public static String convertToR4Expression(String oldExpression) {
    String pass1 = oldExpression.replaceAll("\\$context", "%context").replaceAll("\\$resource", "%resource").replaceAll("code\\+profile", "code&profile").replaceAll("path\\+'\\.'", "path&'.'").replaceAll("fullUrl\\+resource", "fullUrl&resource");
    String pass2 = pass1;
    if (pass1.endsWith(".distinct()")) pass2 = pass1.substring(0, pass2.length() - 11) + ".isDistinct()";
    String pass3 = pass2;
    if (pass2.endsWith(".empty() or (type.count() = 1)"))
      pass3 = pass2.substring(0, pass2.length() - 30) + ".empty() or (type.count() <= 1)";
    String pass4 = pass3;
    if (pass3.equals("duration >= 0")) pass4 = "duration.exists() implies duration >= 0";
    else if (pass3.equals("period >= 0")) pass4 = "period.exists() implies period >= 0";
    else if (pass3.equals("fullUrl.empty() xor resource")) pass4 = "fullUrl.empty() xor resource.exists()";
    return pass4;
  }

  public static String convertTo2016MayExpression(String newExpression) {
    String pass1 = newExpression.replaceAll("%context", "\\$context").replaceAll("%resource", "\\$resource").replaceAll("code&profile", "code+profile").replaceAll("path&'\\.'", "path+'.'").replaceAll("fullUrl%resource", "fullUrl+resource");
    String pass2 = pass1;
    if (pass1.endsWith(".isDistinct()")) pass2 = pass1.substring(0, pass1.length() - 13) + ".distinct()";
    String pass3 = pass2;
    if (pass2.endsWith(".empty() or (type.count() <= 1)"))
      pass3 = pass2.substring(0, pass2.length() - 31) + ".empty() or (type.count() = 1)";
    String pass4 = pass3;
    if (pass3.equals("duration.exists() implies duration >= 0")) pass4 = "duration >= 0";
    else if (pass3.equals("period.exists() implies period >= 0")) pass4 = "period >= 0";
    else if (pass3.equals("fullUrl.empty() xor resource.exists()")) pass4 = "fullUrl.empty() xor resource";
    return pass4;
  }
}
