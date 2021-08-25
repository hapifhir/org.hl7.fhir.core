* Differential element fields minValue/maxValue are now correctly treated in the snapshot generation process
* Conversion context added to conversions process
* Users can now define custom behavior for CodeSystems, Extensions, BundleEntries, and Types by extending BaseAdvisor.
* Resource Conversions are now thread-safe, each using their own instance of the conversion context that is unique
* ConversionFactory classes are statically accessed, to minimize changes downstream
* I need to add more tests, there were very few to begin with, and it's my next task
* All conversion libraries and no play makes Mark a dull boy
* Exposed showMessagesFromReferences on the command line interface to support reporting validation errors on referenced types (particularly useful when validating messages & documents)
* https://github.com/hapifhir/org.hl7.fhir.core/issues/564
* 
