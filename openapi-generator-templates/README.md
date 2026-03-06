# OpenAPI Generator Templates

This directory contains 2 custom generator templates for the OpenAPI tool to work-around 2 bugs in the generator.

### oneof_interface.mustache
This is a work-around for bug https://github.com/OpenAPITools/openapi-generator/issues/19194.

The original JavaSpring version of this file ([source](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator/src/main/resources/JavaSpring/oneof_interface.mustache))
contains a getter for the discriminator property method but this is not correctly overridden by implementing classes. 

Therefor we use a custom version _without_ the getter for the discriminator, since it's not really needed anyway.

### typeInfoAnnotation.mustache
This is a work-around for bug https://github.com/OpenAPITools/openapi-generator/issues/18929.

The original JavaSpring version of this file ([source](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator/src/main/resources/JavaSpring/typeInfoAnnotation.mustache))
contains an `@JsonIgnoreProperties` annotation but in certain edge-cases the actual import statement for
the `@JsonIgnoreProperties` annotation is not generated in the code, which then results in a compilation
error. 

Therefor we use a custom version with a fully qualified name for the annotation to avoid the need to import it.