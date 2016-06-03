/*
 *  Copyright 2004 Clinton Begin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.ibatis.sqlmap.engine.mapping.sql.dynamic.elements;

import com.ibatis.common.beans.Probe;
import com.ibatis.common.beans.ProbeFactory;

import java.util.Map;

public class IsPropertyAvailableTagHandler extends ConditionalTagHandler {

  private static final Probe PROBE = ProbeFactory.getProbe();

  public boolean isCondition(SqlTagContext ctx, SqlTag tag, Object parameterObject) {
    if (parameterObject == null) {
      return false;
    } else if (parameterObject instanceof Map) {
      return ((Map)parameterObject).containsKey(tag.getPropertyAttr());      
    } else {
      return PROBE.hasReadableProperty(parameterObject, tag.getPropertyAttr());
    }
  }

}