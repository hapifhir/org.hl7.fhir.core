The Java Core Code Generator

Note: This code only generates the R6 java code. Older generated models are now maintained by hand.

To run this code, run the class JavaCoreGenerator with 3-4 parameters:      
* 1: fhir version to generate from (e.g. 4.1.0 or 'current'
* 2: project directory to read configuration and templates from - e.g. C:\work\org.hl7.fhir\org.hl7.fhir.core\org.hl7.fhir.core.generator\configuration
* 3: project directory to generate code into - e.g. C:\\work\\org.hl7.fhir\\org.hl7.fhir.core\\org.hl7.fhir.r5.new
* 4: a directory to generate the converters in (note: will need days of work to make them compile)

The generation process depends on the code it generates - do not regenerate the master R6 code until you have tested that it generates correctly.

To test the generation:
* create a new project, copy the existing R6 code into it, and get it compiling
* make sure that project is not in the build path for the generator itself, which depends on the production R6 code 
* run the generation
* refresh etc and make sure that the compiler is happy
* copy the JUnit tests RoundTripTests into the copy project, update the constants, and execute it
* check all the tests pass, and inspect a sampling of the results for consistency 

Configuring the Generation Output

The most common reason to alter the generation is to add additional utility routines/enhanceements to the generated classes. 
To do this, edit on the one of the templates in the configuration directory - xx.java, where xx is the class name (may include
containing class). You may also need to add to the imports in the configuration.ini file. 

