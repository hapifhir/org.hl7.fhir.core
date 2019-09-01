package org.hl7.fhir.utilities.liquid;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.narrative2.BaseNarrativeGenerator;
import ca.uhn.fhir.narrative2.INarrativeTemplate;
import ca.uhn.fhir.narrative2.TemplateTypeEnum;
import org.hl7.fhir.instance.model.api.IBase;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class DefaultLiquidNarrativeGenerator extends BaseNarrativeGenerator {
	private static final Logger ourLog = LoggerFactory.getLogger(DefaultLiquidNarrativeGenerator.class);


	public static final String NARRATIVES_PROPERTIES = "classpath:ca/uhn/fhir/narrative/liquid/narratives.properties";
	static final String HAPISERVER_NARRATIVES_PROPERTIES = "classpath:ca/uhn/fhir/narrative/liquid/narratives-hapiserver.properties";

	private boolean myUseHapiServerConformanceNarrative;

	private LiquidEngine myLiquidEngine;

	private void initializeNarrativeEngine(FhirContext theFhirContext) {
		myLiquidEngine = new LiquidEngine(theFhirContext);
	}

	@Override
	protected List<String> getPropertyFile() {
		List<String> retVal = new ArrayList<String>();
		retVal.add(NARRATIVES_PROPERTIES);
		if (myUseHapiServerConformanceNarrative) {
			retVal.add(HAPISERVER_NARRATIVES_PROPERTIES);
		}
		return retVal;
	}

	/**
	 * If set to <code>true</code> (default is <code>false</code>) a special custom narrative for the Conformance resource will be provided, which is designed to be used with HAPI {@link RestfulServer}
	 * instances. This narrative provides a friendly search page which can assist users of the service.
	 */
	public void setUseHapiServerConformanceNarrative(boolean theValue) {
		myUseHapiServerConformanceNarrative = theValue;
	}

	/**
	 * If set to <code>true</code> (default is <code>false</code>) a special custom narrative for the Conformance resource will be provided, which is designed to be used with HAPI {@link RestfulServer}
	 * instances. This narrative provides a friendly search page which can assist users of the service.
	 */
	public boolean isUseHapiServerConformanceNarrative() {
		return myUseHapiServerConformanceNarrative;
	}

	public LiquidEngine getLiquidEngine() {
		return myLiquidEngine;
	}

  @Override
  protected String applyTemplate(FhirContext theFhirContext, INarrativeTemplate theTemplate, IBase theTargetContext) {
    if (!(theTargetContext instanceof IBaseResource)) {
      return "";
    }
    IBaseResource resource = (IBaseResource)theTargetContext;
    if (myLiquidEngine == null) {
      initializeNarrativeEngine(theFhirContext);
    }
    LiquidEngine.LiquidDocument doc = null;
    try {
      doc = myLiquidEngine.parse(theTemplate.getTemplateText(), theTemplate.getTemplateName());
    } catch (Exception e) {
      ourLog.error(e.getMessage(), e);
    }
    return myLiquidEngine.evaluate(doc, resource, null);
  }

  @Override
  protected EnumSet<TemplateTypeEnum> getStyle() {
    return EnumSet.of(TemplateTypeEnum.LIQUID);
  }

}
