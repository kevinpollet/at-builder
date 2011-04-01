/*
 * Copyright 2011 Kevin Pollet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kevinpollet.atbuilder.test;

import com.github.kevinpollet.atbuilder.api.AnnotationBuilder;
import com.github.kevinpollet.atbuilder.api.Builder;
import com.github.kevinpollet.atbuilder.test.annotation.MyAnnotation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Kevin Pollet
 */
public class AnnotationBuilderTest {

	private AnnotationBuilder<MyAnnotation> builder;

	@BeforeMethod
	private void init() {
		builder = Builder.createFor( MyAnnotation.class );
	}

	@Test
	public void buildAnnotationWithoutDefaultValueRedefinition() {
		MyAnnotation annotation = builder.setAttribute( "value" ).value( "Hi !" ).create();

		assertEquals( annotation.value(), "Hi !" );
		assertEquals( annotation.defaultValue(), "default value" );
	}

	@Test
	public void buildAnnotationWithRedefinedDefaultValue() {
		MyAnnotation annotation = builder.setAttribute( "value" )
				.value( "Hi !" )
				.setAttribute( "defaultValue" )
				.value( "Hello !" )
				.create();

		assertEquals( annotation.value(), "Hi !" );
		assertEquals( annotation.defaultValue(), "Hello !" );
	}

	@Test(expectedExceptions = IllegalStateException.class,
			expectedExceptionsMessageRegExp = "Attribute value is not defined")
	public void buildAnnotationWithoutDefinitionOfRequiredValues() {
		builder.create();
	}
}
