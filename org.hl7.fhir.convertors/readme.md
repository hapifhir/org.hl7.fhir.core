About the version conversion routines

The version conversion routines are maintained as part of 
the development of the standard, but always under considerable
time pressure. Implementers should regard these as 'scaffolds' for 
an actual reliable conversion routine. 

The FHIR project maintains and tests conversions on the following 
resources, from old versions to R5:
* CodeSystem
* ValueSet
* ConceptMap
* StructureDefinition
* StructureMap
* ImplementationGuide
* CapabilityStatement
* OperationDefinition
* NamingSystem

These can be relied on and are subject to extensive testing. 

In addition to this, some of the conversions have test cases 
for particular resources and particular version combinations. 
Where test cases exist, they will continue to pass and be 
maintained. 

So:
* test the conversion routines before using them in production
* contribute test cases to ensure that your use cases continue to be reliable

Test cases are welcome - make them as PRs to the core library, or even better,
to the FHIR test cases library