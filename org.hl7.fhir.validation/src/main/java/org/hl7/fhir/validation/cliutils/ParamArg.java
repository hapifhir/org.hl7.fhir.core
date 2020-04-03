package org.hl7.fhir.validation.cliutils;

public enum ParamArg {
  VERSION("-version"),
  OUTPUT("-output"),
  PROXY("-proxy"),
  PROFILE("-profile"),
  QUESTIONNAIRE("-questionnaire"),
  NATIVE("-native"),
  ASSUME_VALID_REST_REF("-assumeValidRestReferences"),
  DEBUG("-debug"),
  SCT("-sct"),
  RECURSE("-recurse"),
  LOCALE("-locale"),
  STRICT_EXTENSIONS("-strictExtensions"),
  HINT_ABOUT_NON_MUST_SUPPORT("-hintAboutNonMustSupport"),
  TO_VERSION("-to-version"),
  DO_NATIVE("-do-native"),
  NO_NATIVE("-no-native"),
  TRANSFORM("-transform"),
  NARRATIVE("-narrative"),
  SNAPSHOT("-snapshot"),
  SCAN("-scan"),
  TERMINOLOGY("-tx"),
  TERMINOLOGY_LOG("-txLog");

  private final String code;

  ParamArg(String code) {
    this.code = code;
  }

}


//  } else if (args[i].equals("-log")) {
//  if (i + 1 == args.length)
//  throw new Error("Specified -log without indicating file");
//  else
//  mapLog = args[++i];
//  } else if (args[i].equals("-language")) {
//  if (i + 1 == args.length)
//  throw new Error("Specified -language without indicating language");
//  else
//  lang = args[++i];
//  } else if (args[i].equals("-ig") || args[i].equals("-defn")) {
//  if (i + 1 == args.length)
//  throw new Error("Specified " + args[i] + " without indicating ig file");
//  else {
//  String s = args[++i];
//  sv = Utils.getVersionFromIGName(null, s);
//  if (sv == null) {
//  igs.add(s);
//  }
//  }
//  } else if (args[i].equals("-map")) {
//  if (map == null) {
//  if (i + 1 == args.length)
//  throw new Error("Specified -map without indicating map file");
//  else
//  map = args[++i];
//  } else {
//  throw new Exception("Can only nominate a single -map parameter");
//  }
//  } else if (args[i].startsWith("-x")) {
//  i++;
//  } else if (args[i].equals("-convert")) {
//  mode = EngineMode.CONVERT;
//  } else if (args[i].equals("-fhirpath")) {
//  mode = EngineMode.FHIRPATH;
//  if (fhirpath == null)
//  if (i + 1 == args.length)
//  throw new Error("Specified -fhirpath without indicating a FHIRPath expression");
//  else
//  fhirpath = args[++i];
//  else
//  throw new Exception("Can only nominate a single -fhirpath parameter");
//  } else {
//  sources.add(args[i]);
//  }
//  }