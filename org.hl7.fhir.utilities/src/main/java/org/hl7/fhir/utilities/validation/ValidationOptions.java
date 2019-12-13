package org.hl7.fhir.utilities.validation;

public class ValidationOptions {
  private String language;
  private boolean useServer = true;
  private boolean useClient = true;
  private boolean guessSystem = false;

  public ValidationOptions() {
    super();
  }

  public ValidationOptions(String language) {
    super();
    this.language = language;
  }

  public String getLanguage() {
    return language;
  }

  
  public boolean isUseServer() {
    return useServer;
  }

  public boolean isUseClient() {
    return useClient;
  }

  public boolean isGuessSystem() {
    return guessSystem;
  }
  
  private ValidationOptions copy() {
    ValidationOptions n = new ValidationOptions(language);
    n.useServer = useServer;
    n.useClient = useClient;
    n.guessSystem = guessSystem;    
    return n;
  }
  
  public ValidationOptions setLanguage(String language) {
    ValidationOptions n = this.copy();
    n.language = language;
    return n;
  }


  public ValidationOptions noServer() {
    ValidationOptions n = this.copy();
    n.useServer = false;
    return n;
  }
  
  public ValidationOptions noClient() {
    ValidationOptions n = this.copy();
    n.useClient = false;
    return n;
  }

  public ValidationOptions guessSystem() {
    ValidationOptions n = this.copy();
    n.guessSystem = false;
    return n;
  }
  

  public String toJson() {
    return "\"lang\":\""+language+"\", \"useServer\":\""+Boolean.toString(useServer)+"\", \"useClient\":\""+Boolean.toString(useClient)+"\", \"guessSystem\":\""+Boolean.toString(guessSystem)+"\"";
  }

  public static ValidationOptions defaults() {
    return new ValidationOptions("en-US");
  }
}