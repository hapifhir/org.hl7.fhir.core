# FHIR Convertors

While the first official FHIR release (R4) is out and the next version (R5) is one the way, there are still a lot of medical data saved in DSTU2. Moreover, most of the medical providers still provide their medical entries in DSTU2. Although they would have to move to R4 due to "cure acts", it would takes time. Yet, it is recommended to work with R4 and no DSTU2 because it is more stable and your code won't start with "legacy versions".

This project automatically converts forward and backward between FHIR versions.  
Please not that it is currently not complete. Feel free to open pull requests with additional conversions.

The conversion is documented under the official FHIR website using the [FHIR mapping language](https://www.hl7.org/fhir/mapping-language.html).  
Each resource has conversion mapping under it's official page. For example, medication request conversion from R3 to R4 can be found [here](https://www.hl7.org/fhir/medicationrequest-version-maps.html).


## Tutorial

We start with a simple example to convert resource from `dstu2` to `r4`:
```java
org.hl7.fhir.r4.model.Resource convert(org.hl7.fhir.dstu2.model.Resource dstu2) {
    VersionConvertorAdvisor40 advisor = new VersionConvertorAdvisor40();
    org.hl7.fhir.r4.model.Resource r4 = VersionConvertor_10_40.convertResource(dstu2, advisor);
    return r4;
}
```
As you can see, the convertor has 2 numeric values. In the project, the FHIR versions are specified by the following numeric values:
- `dstu2`: 10
- `dstu2016may`: 14
- `stu`: 30
- `r4`: 40
- `r5`: 50
Hence, `VersionConvertor_10_40` converts between `dstu2` and `r4` and `VersionConvertor_14_50` converts between `dstu2016may` and `r5`.

Most convertors can convert in both directions. For example, `VersionConvertor_10_40.convertResource` has 2 signature:
1. get `dstu2` resource and returns a `r4` one.
2. get `r4` resource and returns a `dstu2` one.

Look for example in the following file: [src/main/java/org/hl7/fhir/convertors/VersionConvertor_10_40.java](src/main/java/org/hl7/fhir/convertors/VersionConvertor_10_40.java). This file, as you now understand, has the full API to convert between `dstu2` and `r4`. Here, you can see all the available conversions. Beside converting full resources, you can convert individual elements such as converting references using `convertReference`. This method works in both directions as well.


## Project Hierarchy

The sources are located under `src/main/java/org/hl7/fhir/convertors/`.  
Each versions convertor has a single file containing the full API with the form `VersionConvertor_{old}_{new}.java` and a corresponding directory `conv{old}_{new}`. The directory contains helper classes to convert the different resources.  
The primitive types conversion is specified under the main API file.
