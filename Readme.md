What is it ?
============

This project allows to create an annotation instance in a fluent way.

Building this project
---------------------

Run the following command at the project root: `mvn clean install` (the resulting jar will be generated in the *target* folder of the project and installed in your local maven repository).

Example of use
--------------

The annotation:

    public @interface MyAnnotation {
		String value();
		String defaultValue() default "default value";
	}

Creation of an instance:

	MyAnnotation annotation = builder.setAttribute( "value" )
									 .value( "at" )
									 .setAttribute( "defaultValue" )
									 .value( "builder" )
									 .create();
									