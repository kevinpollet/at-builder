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
public interface AnnotationBuilder<T extends Annotation> {
	/**
	 * Sets an attribute of the annotation being
	 * built.
	 *
	 * @param name The attribute name.
	 *
	 * @return An instance of {@code AttributeBuilder}
	 *
	 * @see AttributeBuilder
	 */
	AttributeBuilder<T> setAttribute(String name);

	/**
	 * Build the annotation.
	 *
	 * @return The built annotation.
	 */
	T create();
}
