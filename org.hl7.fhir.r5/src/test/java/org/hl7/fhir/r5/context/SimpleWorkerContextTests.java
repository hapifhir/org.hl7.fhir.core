package org.hl7.fhir.r5.context;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.ParserType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;

public class SimpleWorkerContextTests {
  @Test
  public void testValidateCodingOnServer() throws IOException {
    SimpleWorkerContext context = Mockito.spy(new SimpleWorkerContext());
    IWorkerContext.ValidationResult result = mock(IWorkerContext.ValidationResult.class);

    Mockito.doReturn(result).when(context).validateOnServer(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any());
    ValidationOptions validationOptions = new ValidationOptions().guessSystem().setVersionFlexible(false);
    ValueSet valueSet = new ValueSet();
    ValidationContextCarrier ctxt = null;
    context.validateCode(validationOptions, new Coding(), valueSet, ctxt);
  }

  @Test
  public void testValidateCodableConceptOnServer() throws IOException {
    SimpleWorkerContext context = Mockito.spy(new SimpleWorkerContext());
    IWorkerContext.ValidationResult result = mock(IWorkerContext.ValidationResult.class);

    Mockito.doReturn(result).when(context).validateOnServer(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any());
    ValidationOptions validationOptions = new ValidationOptions().guessSystem().setVersionFlexible(false);
    ValueSet valueSet = new ValueSet();

    CodeableConcept codeableConcept = new CodeableConcept();

    context.validateCode(validationOptions, codeableConcept, valueSet);
  }
}
