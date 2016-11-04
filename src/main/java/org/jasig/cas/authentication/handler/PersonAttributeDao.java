/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.authentication.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AttributeNamedPersonImpl;
import org.jasig.services.persondir.support.StubPersonAttributeDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonAttributeDao  extends StubPersonAttributeDao{
	
	@NotNull
	private JdbcTemplate jdbcTemplate;
	@NotNull
    private DataSource dataSource;
	@NotNull
	private String sql;
	@Override
	public IPersonAttributes getPerson(String uid) {
		System.out.println(uid);
		Map<String, Object> queryForMap = jdbcTemplate.queryForMap(sql,uid);
		Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();
        attributes.put("userid", Collections.singletonList(queryForMap.get("id")));
        attributes.put("username", Collections.singletonList(queryForMap.get("username")));
        attributes.put("systemcode", Collections.singletonList(queryForMap.get("systemcode")));
        attributes.put("salt", Collections.singletonList(queryForMap.get("salt")));
        attributes.put("postid", Collections.singletonList(queryForMap.get("postid")));
        return new AttributeNamedPersonImpl(attributes);
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	protected final JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	protected final DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	    this.dataSource = dataSource;
	}
	
	
	
}
