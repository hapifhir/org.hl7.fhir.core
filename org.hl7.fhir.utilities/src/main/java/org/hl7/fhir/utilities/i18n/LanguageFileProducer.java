package org.hl7.fhir.utilities.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.utilities.Utilities;
import org.xml.sax.SAXException;


public abstract class LanguageFileProducer {

  public static class TextUnit {
    protected String id;
    protected String context;
    protected String srcText;
    protected String tgtText;
    public TextUnit(String id, String context, String srcText, String tgtText) {
      super();
      this.id = id;
      this.context = context;
      this.srcText = srcText;
      this.tgtText = tgtText;
    }

    /**
     * The identity of the item being translated
     * 
     * @return
     */
    public String getId() {
      return id;
    }
    
    /**
     * Additional language that helps establish the context
     * @return
     */
    public String getContext() {
      return context;
    }

    /**
     * The language that's being translated from
     * 
     * @return
     */
    public String getSrcText() {
      return srcText;
    }
    
    /** 
     * The language that's being translated to
     * 
     * @return
     */
    public String getTgtText() {
      return tgtText;
    }
  }
  
  public static class TranslationUnit extends TextUnit {
    private String language;
    private String original; // for when the source text has been modified since being translated

    public TranslationUnit(String language, String id, String context, String srcText, String tgtText) {
      super(id, context, srcText, tgtText);
      this.language = language;
    }

    public String getLanguage() {
      return language;
    }

    public void setContext(String context) {
      this.context = context;
    }

    public void setSrcText(String srcText) {
      this.srcText = srcText;
    }

    public void setTgtText(String tgtText) {
      this.tgtText = tgtText;
    }

    public String getOriginal() {
      return original;
    }

    public TranslationUnit setOriginal(String original) {
      this.original = original;
      return this;
    }

    @Override
    public String toString() {
      return "["+language+":"+id+"]"+" '"+srcText+"' -> '"+ tgtText+"' ("+context+")";
    }
    
  }

  public class Translations {
    private String id;
    private Map<String, String> translations = new HashMap<>();
    protected Translations(String id) {
      super();
      this.id = id;
    }
    public String getId() {
      return id;
    }
    public Map<String, String> getTranslations() {
      return translations;
    }
    
  }

  public abstract class LanguageProducerLanguageSession {

    protected String id;
    protected String baseLang;
    protected String targetLang;
    
    protected LanguageProducerLanguageSession(String id, String baseLang, String targetLang) {
      super();
      this.id = id;
      this.baseLang = baseLang;
      this.targetLang = targetLang;
    }

    public String getTargetLang() {
      return targetLang;
    }

    public String getBaseLang() {
      return baseLang;
    }

    public abstract void finish() throws IOException;

    public abstract void entry(TextUnit unit);
  }

  public abstract class LanguageProducerSession {

    protected String id;
    protected String baseLang;
    
    protected LanguageProducerSession(String id, String baseLang) {
      super();
      this.id = id;
      this.baseLang = baseLang;
    }
    public abstract LanguageProducerLanguageSession forLang(String lang);
    public abstract void finish() throws IOException;
  }
  
  private String rootFolder;
  private String folderName;
  private boolean useLangFolder;
  
  public LanguageFileProducer(String rootFolder, String folderName, boolean useLangFolder) {
    super();
    this.rootFolder = rootFolder;
    this.folderName = folderName;
    this.useLangFolder = useLangFolder;
  }
  
  public LanguageFileProducer() {
    super();
  }
  

  public String getRootFolder() {
    return rootFolder;
  }

  public String getFolderName() {
    return folderName;
  }

  public boolean isUseLangFolder() {
    return useLangFolder;
  }
  

  protected String getTargetFileName(String targetLang, String filename) throws IOException {
    return Utilities.path(getRootFolder(), isUseLangFolder() ? targetLang : ".", getFolderName(), filename);
  }

  

  public abstract LanguageProducerSession startSession(String id, String baseLang) throws IOException;
  public abstract void finish();

  public abstract List<TranslationUnit> loadSource(InputStream source) throws IOException, ParserConfigurationException, SAXException;

  public abstract int fileCount();

  public abstract void produce(String id, String baseLang, String targetLang, List<TranslationUnit> translations, String filename) throws IOException;
}
