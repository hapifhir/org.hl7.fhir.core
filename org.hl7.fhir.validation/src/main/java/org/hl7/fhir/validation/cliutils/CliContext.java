package org.hl7.fhir.validation.cliutils;

import org.hl7.fhir.validation.Validator;

import java.util.*;

public class CliContext {

  private String map = null;
  private List<String> igs = new ArrayList<String>();
  private List<String> questionnaires = new ArrayList<String>();
  private String txServer = "http://tx.fhir.org";
  private boolean doNative = false;
  private boolean anyExtensionsAllowed = true;
  private boolean hintAboutNonMustSupport = false;
  private boolean recursive = false;
  private Locale locale = null;
  private List<String> profiles = new ArrayList<String>();
  private Validator.EngineMode mode = Validator.EngineMode.VALIDATION;
  private String output = null;
  private Boolean canDoNative = null;
  private List<String> sources = new ArrayList<String>();
  private Map<String, String> locations = new HashMap<String, String>();
  private String sv = "current";
  private String txLog = null;
  private String mapLog = null;
  private String lang = null;
  private String fhirpath = null;
  private String snomedCT = "900000000000207008";
  private String targetVer = null;
  private boolean doDebug = false;
  private boolean assumeValidRestReferences = false;
}
