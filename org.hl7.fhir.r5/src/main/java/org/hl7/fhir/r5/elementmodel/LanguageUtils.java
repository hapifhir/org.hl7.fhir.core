package org.hl7.fhir.r5.elementmodel;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TextUnit;

/**
 * in here:
 *   * generateTranslations
 *   * importFromTranslations
 *   * stripTranslations
 *   * switchLanguage
 *   
 *  in the validator
 *  
 * @author grahamegrieve
 *  generateTranslations = -langTransform export -src {src} -tgt {tgt} -dest {dest}
 *  importFromTranslations =  -langTransform import -src {src} -tgt {tgt} -dest {dest}
 */
public class LanguageUtils {

  IWorkerContext context;
  
  
  public LanguageUtils(IWorkerContext context) {
    super();
    this.context = context;
  }

  public void generateTranslations(Element resource, LanguageProducerLanguageSession session) {
    translate(resource, session);
  }
  
  private void translate(Element element, LanguageProducerLanguageSession langSession) {
    if (element.isPrimitive() && isTranslatable(element)) {
      String base = element.primitiveValue();
      if (base != null) {
        String translation = element.getTranslation(langSession.getTargetLang());
        langSession.entry(new TextUnit(element.getPath(), base, translation));
      }
    }
    for (Element c: element.getChildren()) {
      translate(c, langSession);
    }
  }
  
  private boolean isTranslatable(Element element) {
    return element.getProperty().isTranslatable();
  }

  public static boolean matches(String dstLang, String srcLang) {
    return dstLang == null ? false : dstLang.equals(srcLang);
  }
}
