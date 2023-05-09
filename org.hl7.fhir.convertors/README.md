# Resource Conversion

## IMPORTANT
-----

_The conversion code in this module is maintained as part of the development of the standard, but always under 
considerable time pressure. Only part of the code is rigorously tested [as detailed here](#reliable-conversion-code). 
Implementers should regard this code as a 'scaffold' for actual reliable conversions._

**ALWAYS TEST ANY CONVERSION ROUTINES BEFORE USING THEM IN PRODUCTION!**

_Ideally, this should be via unit tests in your code, or better yet [unit tests contributed to FHIR](#test-cases)._

## Using the Conversion package

### Basic Usage

The majority of conversion tasks should be performed by the Version Convertor factories:

* VersionConvertorFactory_10_30
* VersionConvertorFactory_10_40
* VersionConvertorFactory_10_50
* VersionConvertorFactory_14_30
* VersionConvertorFactory_14_40
* VersionConvertorFactory_14_50
* VersionConvertorFactory_30_40
* VersionConvertorFactory_30_50
* VersionConvertorFactory_40_50
* VersionConvertorFactory_43_50

These factories all use the following convention:

`VersionConvertorFactory_` + `(VERSION A)` + `_` + `(VERSION B)`

Each factory allows conversion between two versions of FHIR, specified by `VERSION A` and `VERSION B`. The syntax of each version is described briefly in the following section.

### Conversion Version Syntax
-----

Within the code, we use a set naming convention to organize the classes used for conversion between the various versions of FHIR.

| Version       | Code      | 
| :---          | :---:     |
| dstu2         | 10        |
| dstu2016may   | 14        |
| dstu3         | 30        |
| r4            | 40        |
| r5            | 50        |

So, for example, VersionConvertorFactory_10_40 allows the conversion of resources and types to and from dtu2 (10) and r4 (50).

### Conversion Factory Usage

-----
Each VersionConvertorFactory provides two statically accessed base methods for converting resources:

`public static (V1 Resource) convertResource((V2 Resource) src)`

`public static (V2 Resource) convertResource((V1 Resource) src)`

as well as two statically accessed base methods for converting types:

`public static (V1 Type) convertType((V2 Type) src)`

`public static (V2 Type) convertType((V1 Type) src)`

It's important to note that these methods convert from the base `Resource` of one version to the base `Resource` of 
another version, or from the base `Type` of one version to the base `Type` of another version (or `DataType` in the 
case of r5), so the result will need to be cast to the correct class.

Example:

```java
  // Converting a r4 AllergyIntolerance to r5.
  org.hl7.fhir.r5.model.Resource r5Resource = VersionConvertorFactory_40_50.convertResource(r4AllergyIntolerance);
  org.hl7.fhir.r5.model.AllergyIntolerance r5AllergyIntolerance = (org.hl7.fhir.r5.model.AllergyIntolerance) r5Resource;
```

## Developers Notes

If you are developing or debugging conversion routines, you will likely need to access the individual Resource, DataType, and Primitive conversion classes.

These are located in the following packages:

* org.hl7.fhir.convertors.conv10_30
* org.hl7.fhir.convertors.conv10_40
* org.hl7.fhir.convertors.conv10_50
* org.hl7.fhir.convertors.conv14_30
* org.hl7.fhir.convertors.conv14_40
* org.hl7.fhir.convertors.conv14_50
* org.hl7.fhir.convertors.conv30_40
* org.hl7.fhir.convertors.conv30_50
* org.hl7.fhir.convertors.conv40_50
* org.hl7.fhir.convertors.conv43_50

These classes follow the convention:

`(NAME)` + `(VERSION A)` + `_` + `(VERSION B)`

Where `NAME` is the proper name of the resource or datatype being converted, and `VERSION A` and `VERSION B` indicate the two versions of FHIR that the code will convert the given resource or datatype between (See [Conversion Version Syntax](#-conversion-version-syntax) for version details).

So, in the repository, you may come across a file name `AllergyIntolerance40_50`. This would indicate that the code in this file is related to the conversion of the AllergyIntolerance resource between versions [r4](http://hl7.org/fhir/r4/allergyintolerance.html) and [r5](https://hl7.org/fhir/r5/allergyintolerance.html)

Note that these classes are not intended to be used directly. When actually converting resources, the provided conversion factory classes are intended to be used as the entry point. For example, to convert a dstu3 AllergyIntolerance resource, the above conversion would not use `AllergyIntolerance40_50` directly, but would instead call: `VersionConvertorFactory_40_50.convertResource(dstu3AllergyIntolerance)`. `VersionConvertorFactory_40_50` would call `AllergyIntolerance40_50` internally to convert `r4AllergyIntolerance`.

### Common Conversion Scenarios

Conversion classes are implemented using some simple, repeatable patterns. `AllegeryIntolerance40_50` will be used as an example of this. Each conversion class for a resource will have two entry points, allowing for conversions to be done to and from the two versions in the convertor. 

```java
public static org.hl7.fhir.r5.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r4.model.AllergyIntolerance src);
public static org.hl7.fhir.r4.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r5.model.AllergyIntolerance src)
```

Initially, a target resource is created in the appropriate method. Upon the completion of the conversion, this target resource is returned. In our case, the target resource is
version 50, or r5. 

```java
public static org.hl7.fhir.r5.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r4.model.AllergyIntolerance src){
    
  //...
  
  org.hl7.fhir.r5.model.AllergyIntolerance tgt = new org.hl7.fhir.r5.model.AllergyIntolerance();
	
  //...
}
```

After the target resource is created, the elements of the source resource need to be converted to the target version, and added to the target resource. Many elements can be copied automatically using the static methods provided in the `ConversionContext` and  `VersionConvertor` classes. These classes follow the convention:

`ConversionContext` + `(VERSION A)` + `_` + `(VERSION B)`

and

`VersionConvertor` + `(VERSION A)` + `_` + `(VERSION B)`

An example usage is in the copying of [DomainResource](https://build.fhir.org/domainresource.html) elements (`text`, `contained`, `extension`, and `modifierExtension`). In FHIR, all listed Resources except Bundle, Parameters and Binary extend DomainResource. Copying DomainResource elements is done using the following code:

```java
ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
```

For elements more specific to the resource being converted, we find the appropriate type convertor class, and set the target element directly:

```java
if (src.hasClinicalStatus())
    tgt.setClinicalStatus(CodeableConcept40_50.convertCodeableConcept(src.getClinicalStatus()));
```

### Converting Extensions

A special case exists for the conversion of extensions. As mentioned above, the `copyDomainResource(src, tgt)` method is used to copy the extensions from one resource to another. This applies a default conversion process to all extensions (see [Using conversion advisors](#using-conversion-advisors) for details).

However, in some conversion cases, an extension may exist that can be converted into a resource element. An example of this is the `acceptUnknown` element in the dstu3 [CapabilityStatement](http://hl7.org/fhir/STU3/capabilitystatement-definitions.html#CapabilityStatement.acceptUnknown) resource. This element does not exist in versions r4 and up, so is converted into an extension with the url `http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown`. Should this extension exist in a resource being converted to a CapabilityStatement in dstu3, the convertor needs to convert this extension to an element, and to indicate to the copyDomainResource method that the extension should not be copied.

First, since the copyDomainResource occurs early in the conversion process, we need to indicate all the ignored URLs using the vararg parameter `extensionUrlsToIgnore`:

```java
// Call copyDomainResource(DomainResource src, DomainResource tgt, String... extensionUrlsToIgnore)
ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt, ACCEPT_UNKNOWN_EXTENSION_URL);
```

Then, we need to handle any instances matching that extension URL. In this case, the `acceptUnknown` element can be set.

```java
  if (src.hasExtension(ACCEPT_UNKNOWN_EXTENSION_URL))
		tgt.setAcceptUnknown(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.fromCode(src.getExtensionByUrl(ACCEPT_UNKNOWN_EXTENSION_URL).getValue().primitiveValue()));

```

A similar pattern is used to manage extensions in resource elements:

```
copyElement(DomainResource src, DomainResource tgt,, String... extensionUrlsToIgnore)
```

After all necessary elements are converted, the conversion is complete, and the target resource is returned.

## Extending Conversion Functionality 

As the FHIR specification has evolved over time, the versions of FHIR have built on top of one another, adding new fields within existing resources, changing the name of existing resources, or adding entirely new resources altogether. As a result of this conversions are inherently lossy operations. 

A quick example of this would be [ValueSet Expression](https://www.hl7.org/fhir/extension-valueset-expression.html) extension type. This exists in the r4 version of the specification, but no such type exists in dstu2.

If we were to convert a R4 resource, such as a questionnaire, that contained an extension of this type from r4 -> dstu2, without any special intervention, the extension would be ignored, and the data would be lost in the conversion process.

This is where advisors come in.

### Using conversion advisors

-----
When you call the base conversion factory methods `convertType(...)` or `convertResource(...)`, the library does a predefined conversion, using the standard conversion (which could be a lossy one, or one that makes assumptions). 

These defaults/assumptions are defined in the convertor advisor classes. Each pair of versions has a BaseAdvisor, which is used by default when you call the factory methods. For example, here is the advisor class which handles conversions between dstu2 and r5:

```java
public class BaseAdvisor_10_50 extends BaseAdvisor50<org.hl7.fhir.dstu2.model.Extension> {
 
  private final List<Class<?>> ignoredExtensionTypes = new ArrayList<>(Collections.singletonList(Expression.class));

  public BaseAdvisor_10_50() {
  }

  public BaseAdvisor_10_50(Boolean failFast) {
    this.failFast = failFast;
  }

  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) {
	  // no globally ignored extensions here.
	  return false;
  }

  public boolean ignoreType(@Nonnull String path,
                            @Nonnull DataType type) {
    return ignoredExtensionTypes.contains(type.getClass());
  }
}
```

You can see in the `ignoreType` implementation above that we check if we are converting a  DataType of the `Expression` class. The `Expression` DataType did not exist in dstu2, and is ignored when doing this particular conversion.

As mentioned above, we provide a stock set of implied conversion rules that are used by default. However, there may be cases where you need to add specific behavior to your conversion. Within the `BaseAdvisor` class, there exist a number of overrideable methods that can be used to modify the outcome of any given conversion:

```java
  public void handleCodeSystem(@Nonnull CodeSystem tgtcs, @Nonnull ValueSet source)

  public boolean ignoreEntry(@Nonnull Bundle.BundleEntryComponent src, @Nonnull FhirPublication targetVersion)

  public CodeSystem getCodeSystem(@Nonnull ValueSet src) throws FHIRException

  public boolean ignoreExtension(@Nonnull String path, @Nonnull Extension ext) throws FHIRException

  public boolean ignoreExtension(@Nonnull String path, @Nonnull T ext) throws FHIRException

  public boolean ignoreExtension(@Nonnull String path, @Nonnull String url) throws FHIRException

  public boolean ignoreType(@Nonnull String path, @Nonnull DataType type) throws FHIRException

  public boolean ignoreType(@Nonnull String path, @Nonnull Object type) throws FHIRException

  public boolean useAdvisorForExtension(@Nonnull String path, @Nonnull Extension ext) throws FHIRException

  public boolean useAdvisorForExtension(@Nonnull String path, @Nonnull T ext) throws FHIRException

  public void handleExtension(@Nonnull String path, @Nonnull Extension src, @Nonnull T tgt) throws FHIRException

  public void handleExtension(@Nonnull String path, @Nonnull T src, @Nonnull Extension tgt) throws FHIRException
```

Through overriding these methods and implementing your own custom advisor, you can customize the output of any given conversion operation to suit your specific use-case. 

For example, the [Expression](https://www.hl7.org/fhir/extension-valueset-expression.html)
extension type exists in the r5 version of the specification, but no such type exists in dstu2.

Our stock advisor just ignores this extension when converting from r5 to dstu2. However, if we wanted, we could create our own conversion advisor, as follows:

```java
public class ExpressionAdvisor50 extends BaseAdvisor_10_50 {

	public boolean useAdvisorForExtension(@Nonnull String path, @Nonnull org.hl7.fhir.r5.model.Extension ext) {
		return ext.hasValue() && ext.getValue() instanceof org.hl7.fhir.r5.model.Expression;
	}

	public void handleExtension(@Nonnull String path,
								@Nonnull org.hl7.fhir.r5.model.Extension src,
								@Nonnull org.hl7.fhir.dstu2.model.Extension tgt) {
		if (src.getValue() instanceof org.hl7.fhir.r5.model.Expression) {
			StringType type = new StringType();
			if (src.getValue() == null) {
				throw new NullPointerException("null cannot be cast to non-null type org.hl7.fhir.r5.model.Expression");
			} else {
				type.setValueAsString(((Expression) src.getValue()).getExpression());
				tgt.setValue(type);
				if (src.hasUrlElement()) {
					tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
				}
			}
		} else {
			throw new FHIRException("Unknown extension type passed in to custom convertor method.");
		}
	}
}
```

Here, we first check to see if the extension is of type `org.hl7.fhir.r5.model.Expression` and has a value set in the `useAdvisorForExtension` method, then in the `handleExtension` method, we manually create a `StringType` extension, and copy the value from the r5 `Expression` into it. This results in no data being lost, and a the new custom conversion  behavior for our particular use-case.

Once you've created your new advisor, they can be provided as an argument when calling the conversion factory classes.

`public static (V1 Resource) convertResource((V2 Resource) src, <T extends BaseAdvisor> advisor)`

`public static (V2 Resource) convertResource((V1 Resource) src, <T extends BaseAdvisor> advisor)`

For example, the example `ExpressionAdvisor50` class can be used in converting a Questionnaire resource like so:

```java
VersionConvertorFactory_10_50.convertResource(r5_input, new ExpressionAdvisor50());
```


## Development notes
-----

### Reliable conversion code

The FHIR project maintains and tests conversions on the following resources, from old versions to R5:

- CodeSystem
- ValueSet
- ConceptMap
- StructureDefinition
- StructureMap
- ImplementationGuide
- CapabilityStatement
- OperationDefinition
- NamingSystem

These can be relied on and are subject to extensive testing.

### Test cases

Some conversions have test cases for particular resources and particular version combinations. Where test cases exist, 
they will continue to be maintained and expected to pass.

Contributing test cases is highly encouraged! To contribute, create a PRs to the 
[core library](https://github.com/hapifhir/org.hl7.fhir.core), or even better, to the 
[FHIR test cases library](https://github.com/FHIR/fhir-test-cases).
