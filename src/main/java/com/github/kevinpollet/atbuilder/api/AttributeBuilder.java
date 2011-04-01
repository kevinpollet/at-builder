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
package com.github.kevinpollet.atbuilder.api;

import java.lang.annotation.Annotation;

/**
 * @author Kevin Pollet
 */
public interface AttributeBuilder<T extends Annotation> {
	/**
	 * Defines the value for the current configured attribute.
	 *
	 * @param value The current configured attribute value.
	 *
	 * @return The instance of {@code AnnotationBuilder}.
	 */
	AnnotationBuilder<T> value(Object value);
}
