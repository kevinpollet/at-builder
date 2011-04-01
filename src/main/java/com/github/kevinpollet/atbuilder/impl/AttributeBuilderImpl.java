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
package com.github.kevinpollet.atbuilder.impl;

import java.lang.annotation.Annotation;

import com.github.kevinpollet.atbuilder.api.AnnotationBuilder;
import com.github.kevinpollet.atbuilder.api.AttributeBuilder;

/**
 * @author Kevin Pollet
 */
public class AttributeBuilderImpl<T extends Annotation> implements AttributeBuilder<T> {

	private final String name;
	private final AnnotationBuilder<T> annotationBuilder;

	public AttributeBuilderImpl(String attribute, AnnotationBuilder<T> annotationBuilder) {
		this.name = attribute;
		this.annotationBuilder = annotationBuilder;
	}

	public AnnotationBuilder<T> value(Object value) {
		( (AnnotationBuilderImpl) annotationBuilder ).addAttribute( name, value );
		return annotationBuilder;
	}
}
