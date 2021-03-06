/*
 * Copyright (C) 2016 Cognifide Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.knotx.knot.templating.handlebars;

import com.github.jknack.handlebars.ValueResolver;
import io.vertx.core.json.JsonObject;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * A {@link JsonObject} value resolver.
 */
public enum JsonObjectValueResolver implements ValueResolver {
  /**
   * A singleton instance.
   */
  INSTANCE;

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public Object resolve(Object context, String name) {
    Object value = null;
    if (context instanceof JsonObject) {
      value = ((JsonObject) context).getValue(name);
    }
    return value == null ? UNRESOLVED : value;
  }

  @Override
  public Object resolve(final Object context) {
    return context instanceof JsonObject ? context : UNRESOLVED;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Set<Map.Entry<String, Object>> propertySet(final Object context) {
    return context instanceof JsonObject ? ((JsonObject) context).getMap().entrySet() : Collections.emptySet();
  }
}
