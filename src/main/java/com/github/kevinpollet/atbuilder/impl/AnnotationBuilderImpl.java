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
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.kevinpollet.atbuilder.api.AnnotationBuilder;

/**
 * @author Kevin Pollet
 */
public class AnnotationBuilderImpl<T extends Annotation> implements AnnotationBuilder<T> {
	private final Class<T> annotationClass;
	private final Map<String, Object> attributes;

	public AnnotationBuilderImpl(Class<T> annotationClass) {
		this.annotationClass = annotationClass;
		this.attributes = new ConcurrentHashMap<String, Object>();
	}

	public AttributeBuilder<T> setAttribute(String name) {
		return new AttributeBuilderImpl<T>( name );
	}

	public T create() {
		//verify the annotation definition
		for ( Method method : annotationClass.getDeclaredMethods() ) {
			if ( method.getDefaultValue() == null && !attributes.containsKey( method.getName() ) ) {
				throw new IllegalStateException( String.format( "Attribute %s is not defined", method.getName() ) );
			}
		}

		//construct the annotation
		return annotationClass.cast(
				Proxy.newProxyInstance(
						annotationClass.getClassLoader(),
						new Class<?>[] { annotationClass },
						new AnnotationHandler( attributes )
				)
		);
	}

	private class AttributeBuilderImpl<T extends Annotation> implements AttributeBuilder<T> {
		private final String name;

		public AttributeBuilderImpl(String attribute) {
			this.name = attribute;
		}

		public AnnotationBuilder<T> value(Object value) {
			attributes.put( name, value );
			return (AnnotationBuilder<T>) AnnotationBuilderImpl.this;
		}
	}
}
