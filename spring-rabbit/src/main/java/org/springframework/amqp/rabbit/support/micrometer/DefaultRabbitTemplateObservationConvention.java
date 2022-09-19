/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.amqp.rabbit.support.micrometer;

import io.micrometer.common.KeyValues;

/**
 * Default {@link RabbitTemplateObservationConvention} for Rabbit template key values.
 *
 * @author Gary Russell
 * @since 3.0
 *
 */
public class DefaultRabbitTemplateObservationConvention implements RabbitTemplateObservationConvention {

	/**
	 * A singleton instance of the convention.
	 */
	public static final DefaultRabbitTemplateObservationConvention INSTANCE =
			new DefaultRabbitTemplateObservationConvention();

	@Override
	public KeyValues getLowCardinalityKeyValues(RabbitMessageSenderContext context) {
		return KeyValues.of(RabbitTemplateObservation.TemplateLowCardinalityTags.BEAN_NAME.asString(),
						context.getBeanName());
	}

	@Override
	public String getContextualName(RabbitMessageSenderContext context) {
		return context.getDestination() + " send";
	}

}
